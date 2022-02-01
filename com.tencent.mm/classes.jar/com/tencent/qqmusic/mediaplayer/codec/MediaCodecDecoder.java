package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(23)
public class MediaCodecDecoder
  extends BaseDecoder
{
  private static final int CONTINUOUS_TIMEOUT_COUNT = 500;
  private static final String KEY_BIT_RATE = "bit-rate";
  private static final String KEY_PCM_ENCODING = "pcm-encoding";
  private static final String TAG = "MediaCodecDecoder";
  private static final long TIMEOUT_AUTO_SEEK_INTERVAL_MS = 5000L;
  private static final int TIMEOUT_US = 1000;
  private WeakReference<AudioTrack> mAudioTrackRef;
  private long mCurrentDecodeTime;
  private boolean mDecoderFinished;
  private long mFileSize;
  private AudioInformation mInfo;
  private MediaCodec mMediaCodec;
  private final MediaExtractor mMediaExtractor;
  private volatile byte[] mRemainBuffer;
  private SeekTable mSeekTable;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
  }
  
  public MediaCodecDecoder()
  {
    AppMethodBeat.i(114358);
    this.mMediaExtractor = new MediaExtractor();
    this.mMediaCodec = null;
    this.mInfo = null;
    this.mDecoderFinished = false;
    this.mCurrentDecodeTime = 0L;
    this.mRemainBuffer = null;
    this.mSeekTable = null;
    this.mFileSize = 0L;
    this.mAudioTrackRef = new WeakReference(null);
    AppMethodBeat.o(114358);
  }
  
  private int decodeDataInternal(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114364);
    Object localObject1 = this.mRemainBuffer;
    int k;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      if (paramInt >= localObject1.length)
      {
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
        k = localObject1.length;
        this.mRemainBuffer = null;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114364);
      return k;
      System.arraycopy(localObject1, 0, paramArrayOfByte, 0, paramInt);
      int i = localObject1.length - paramInt;
      paramArrayOfByte = new byte[i];
      System.arraycopy(localObject1, paramInt, paramArrayOfByte, 0, i);
      this.mRemainBuffer = paramArrayOfByte;
      k = paramInt;
      continue;
      if (this.mMediaCodec != null)
      {
        localObject1 = new MediaCodec.BufferInfo();
        i = 0;
        int j = 0;
        k = i;
        if (!this.mDecoderFinished)
        {
          k = i;
          if (i <= 0) {
            label494:
            for (;;)
            {
              try
              {
                k = processInputOutputBuffer((MediaCodec.BufferInfo)localObject1);
                Object localObject2;
                switch (k)
                {
                default: 
                  localObject2 = this.mMediaCodec.getOutputBuffer(k);
                  if (localObject2 == null) {
                    break;
                  }
                  i = Math.min(Math.min(paramInt, ((ByteBuffer)localObject2).remaining()), paramArrayOfByte.length);
                  ((ByteBuffer)localObject2).get(paramArrayOfByte, 0, i);
                  if (((MediaCodec.BufferInfo)localObject1).size > paramInt)
                  {
                    int m = ((MediaCodec.BufferInfo)localObject1).size - paramInt;
                    this.mRemainBuffer = new byte[m];
                    ((ByteBuffer)localObject2).get(this.mRemainBuffer, 0, m);
                  }
                  ((ByteBuffer)localObject2).clear();
                  this.mMediaCodec.releaseOutputBuffer(k, false);
                  long l1 = this.mCurrentDecodeTime;
                  this.mCurrentDecodeTime = (((MediaCodec.BufferInfo)localObject1).presentationTimeUs / 1000L);
                  if ((this.mInfo != null) && (this.mInfo.getBitDepth() == 0))
                  {
                    long l2 = this.mCurrentDecodeTime;
                    k = AudioRecognition.calcBitDept(((MediaCodec.BufferInfo)localObject1).size, l2 - l1, this.mInfo.getChannels(), this.mInfo.getSampleRate());
                    this.mInfo.setBitDept(k);
                  }
                  if ((((MediaCodec.BufferInfo)localObject1).flags & 0x4) != 0)
                  {
                    this.mDecoderFinished = true;
                    this.mCurrentDecodeTime = getDuration();
                    Logger.i("MediaCodecDecoder", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                  }
                  break;
                case -3: 
                  Logger.i("MediaCodecDecoder", "INFO_OUTPUT_BUFFERS_CHANGED");
                  break;
                case -2: 
                  localObject2 = this.mMediaCodec.getOutputFormat();
                  AudioTrack localAudioTrack = (AudioTrack)this.mAudioTrackRef.get();
                  if ((localAudioTrack != null) && (localObject2 != null)) {
                    localAudioTrack.setPlaybackRate(((MediaFormat)localObject2).getInteger("sample-rate"));
                  }
                  Logger.i("MediaCodecDecoder", "New format ".concat(String.valueOf(localObject2)));
                  break;
                case -1: 
                  j += 1;
                  Logger.i("MediaCodecDecoder", "dequeueOutputBuffer timed out!");
                  if (j != 500) {
                    break label494;
                  }
                  paramArrayOfByte = new BufferTimeoutException();
                  AppMethodBeat.o(114364);
                  throw paramArrayOfByte;
                }
              }
              catch (NullInputBufferException localNullInputBufferException) {}
              break;
            }
          }
        }
      }
      else
      {
        k = 0;
      }
    }
  }
  
  @TargetApi(16)
  private static AudioFormat.AudioType getAudioType(MediaExtractor paramMediaExtractor, IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114372);
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    Object localObject = getMediaFormatByExtractor(paramMediaExtractor);
    paramMediaExtractor = localAudioType;
    int i;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      paramMediaExtractor = localAudioType;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMediaExtractor = localAudioType;
        if (((String)localObject).startsWith("audio"))
        {
          i = -1;
          switch (((String)localObject).hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              paramMediaExtractor = localAudioType;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114372);
      return paramMediaExtractor;
      if (!((String)localObject).equals("audio/vorbis")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("audio/flac")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("audio/raw")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("audio/mp4a-latm")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("audio/mpeg")) {
        break;
      }
      i = 4;
      break;
      paramMediaExtractor = AudioFormat.AudioType.OGG;
      continue;
      paramMediaExtractor = AudioFormat.AudioType.FLAC;
      continue;
      if (FLACRecognition.isFlac(paramIDataSource))
      {
        paramMediaExtractor = AudioFormat.AudioType.FLAC;
      }
      else
      {
        paramMediaExtractor = localAudioType;
        if (WavRecognition.isWav(paramIDataSource))
        {
          paramMediaExtractor = AudioFormat.AudioType.WAV;
          continue;
          paramMediaExtractor = localAudioType;
          if (FfmpegRecognition.isM4a(paramIDataSource))
          {
            paramMediaExtractor = AudioFormat.AudioType.M4A;
            continue;
            paramMediaExtractor = AudioFormat.AudioType.MP3;
          }
        }
      }
    }
  }
  
  public static AudioFormat.AudioType getAudioType(String paramString)
  {
    AppMethodBeat.i(114371);
    AudioFormat.AudioType localAudioType2 = AudioFormat.AudioType.UNSUPPORT;
    AudioFormat.AudioType localAudioType1 = localAudioType2;
    MediaExtractor localMediaExtractor;
    if (Build.VERSION.SDK_INT >= 16) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("MediaCodecDecoder", "getAudioType", localThrowable);
        int i = 0;
      }
    }
    localAudioType1 = localAudioType2;
    if (i != 0)
    {
      paramString = new FileDataSource(paramString);
      paramString.open();
      localAudioType1 = getAudioType(localMediaExtractor, paramString);
      paramString.close();
    }
    AppMethodBeat.o(114371);
    return localAudioType1;
  }
  
  private static MediaFormat getMediaFormatByExtractor(MediaExtractor paramMediaExtractor)
  {
    AppMethodBeat.i(114370);
    int i = 0;
    MediaFormat localMediaFormat;
    if (i < paramMediaExtractor.getTrackCount())
    {
      localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("audio"))) {}
    }
    for (paramMediaExtractor = localMediaFormat;; paramMediaExtractor = null)
    {
      AppMethodBeat.o(114370);
      return paramMediaExtractor;
      i += 1;
      break;
    }
  }
  
  /* Error */
  private boolean initAudioInformation(String paramString, int paramInt, MediaFormat paramMediaFormat, IDataSource paramIDataSource, AudioFormat.AudioType paramAudioType)
  {
    // Byte code:
    //   0: ldc_w 344
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 76	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaExtractor	Landroid/media/MediaExtractor;
    //   10: iload_2
    //   11: invokevirtual 347	android/media/MediaExtractor:selectTrack	(I)V
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic 351	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   19: putfield 78	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   22: aload_0
    //   23: getfield 78	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   26: aload_3
    //   27: aconst_null
    //   28: aconst_null
    //   29: iconst_0
    //   30: invokevirtual 355	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   33: aload_0
    //   34: getfield 78	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   37: invokevirtual 358	android/media/MediaCodec:start	()V
    //   40: iconst_m1
    //   41: istore 6
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: sipush 500
    //   49: if_icmpge +339 -> 388
    //   52: iload 6
    //   54: iconst_m1
    //   55: if_icmpeq +10 -> 65
    //   58: iload 6
    //   60: bipush 253
    //   62: if_icmpne +326 -> 388
    //   65: aload_0
    //   66: new 111	android/media/MediaCodec$BufferInfo
    //   69: dup
    //   70: invokespecial 112	android/media/MediaCodec$BufferInfo:<init>	()V
    //   73: invokespecial 116	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:processInputOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;)I
    //   76: istore 7
    //   78: iload 7
    //   80: istore 6
    //   82: iload 7
    //   84: bipush 254
    //   86: if_icmpne +212 -> 298
    //   89: aload_0
    //   90: getfield 78	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   93: invokevirtual 194	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +277 -> 375
    //   101: ldc 26
    //   103: new 360	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 362
    //   110: invokespecial 363	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_3
    //   114: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc_w 369
    //   120: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 188	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_1
    //   134: getstatic 60	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:KEY_PCM_ENCODING	Ljava/lang/String;
    //   137: invokevirtual 379	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   140: ifeq +17 -> 157
    //   143: aload_3
    //   144: getstatic 60	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:KEY_PCM_ENCODING	Ljava/lang/String;
    //   147: aload_1
    //   148: getstatic 60	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:KEY_PCM_ENCODING	Ljava/lang/String;
    //   151: invokevirtual 207	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   154: invokevirtual 383	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   157: aload_1
    //   158: ldc 201
    //   160: invokevirtual 379	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   163: ifeq +15 -> 178
    //   166: aload_3
    //   167: ldc 201
    //   169: aload_1
    //   170: ldc 201
    //   172: invokevirtual 207	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   175: invokevirtual 383	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   178: aload_1
    //   179: ldc_w 385
    //   182: invokevirtual 379	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   185: ifeq +17 -> 202
    //   188: aload_3
    //   189: ldc_w 385
    //   192: aload_1
    //   193: ldc_w 385
    //   196: invokevirtual 207	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   199: invokevirtual 383	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   202: aload_0
    //   203: getfield 80	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mInfo	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   206: aload_3
    //   207: aload 4
    //   209: invokeinterface 390 1 0
    //   214: invokestatic 394	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:setAudioInformationByMediaFormat	(Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Landroid/media/MediaFormat;J)V
    //   217: aload 5
    //   219: getstatic 280	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   222: if_acmpne +83 -> 305
    //   225: aload_0
    //   226: new 396	com/tencent/qqmusic/mediaplayer/seektable/flac/FlacSeekTable
    //   229: dup
    //   230: aload_0
    //   231: getfield 80	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mInfo	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   234: invokevirtual 166	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   237: l2i
    //   238: invokespecial 398	com/tencent/qqmusic/mediaplayer/seektable/flac/FlacSeekTable:<init>	(I)V
    //   241: putfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   244: aload_0
    //   245: getfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   248: ifnull +14 -> 262
    //   251: aload_0
    //   252: getfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   255: aload 4
    //   257: invokeinterface 404 2 0
    //   262: aload_0
    //   263: getfield 80	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mInfo	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   266: invokevirtual 405	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   269: lconst_0
    //   270: lcmp
    //   271: ifle +111 -> 382
    //   274: aload_0
    //   275: getfield 80	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mInfo	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   278: invokevirtual 162	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   281: iconst_2
    //   282: if_icmplt +100 -> 382
    //   285: iconst_1
    //   286: istore 8
    //   288: ldc_w 344
    //   291: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: iload 8
    //   296: ireturn
    //   297: astore_1
    //   298: iload_2
    //   299: iconst_1
    //   300: iadd
    //   301: istore_2
    //   302: goto -257 -> 45
    //   305: aload 5
    //   307: getstatic 302	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   310: if_acmpeq +11 -> 321
    //   313: aload 5
    //   315: getstatic 408	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP4	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   318: if_acmpne +17 -> 335
    //   321: aload_0
    //   322: new 410	com/tencent/qqmusic/mediaplayer/seektable/mpeg4/Mp4SeekTable
    //   325: dup
    //   326: invokespecial 411	com/tencent/qqmusic/mediaplayer/seektable/mpeg4/Mp4SeekTable:<init>	()V
    //   329: putfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   332: goto -88 -> 244
    //   335: aload 5
    //   337: getstatic 305	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP3	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   340: if_acmpne -96 -> 244
    //   343: aload_0
    //   344: new 413	com/tencent/qqmusic/mediaplayer/seektable/mp3/Mp3SeekTable
    //   347: dup
    //   348: invokespecial 414	com/tencent/qqmusic/mediaplayer/seektable/mp3/Mp3SeekTable:<init>	()V
    //   351: putfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   354: goto -110 -> 244
    //   357: astore_1
    //   358: aload_0
    //   359: aconst_null
    //   360: putfield 88	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mSeekTable	Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   363: ldc 26
    //   365: ldc_w 416
    //   368: aload_1
    //   369: invokestatic 331	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto -110 -> 262
    //   375: aload_0
    //   376: getfield 78	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   379: invokevirtual 419	android/media/MediaCodec:release	()V
    //   382: iconst_0
    //   383: istore 8
    //   385: goto -97 -> 288
    //   388: aconst_null
    //   389: astore_1
    //   390: goto -293 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	MediaCodecDecoder
    //   0	393	1	paramString	String
    //   0	393	2	paramInt	int
    //   0	393	3	paramMediaFormat	MediaFormat
    //   0	393	4	paramIDataSource	IDataSource
    //   0	393	5	paramAudioType	AudioFormat.AudioType
    //   41	40	6	i	int
    //   76	11	7	j	int
    //   286	98	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	78	297	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder$NullInputBufferException
    //   251	262	357	com/tencent/qqmusic/mediaplayer/seektable/InvalidBoxException
  }
  
  private boolean initMediaCodecAndFormat(IDataSource paramIDataSource)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114369);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mMediaExtractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.mMediaExtractor.getTrackFormat(i);
        String str = localMediaFormat.getString("mime");
        if ((!TextUtils.isEmpty(str)) && (str.startsWith("audio")))
        {
          this.mInfo = new AudioInformation();
          AudioFormat.AudioType localAudioType = paramIDataSource.getAudioType();
          this.mInfo.setAudioType(localAudioType);
          setAudioType(localAudioType);
          bool1 = initAudioInformation(str, i, localMediaFormat, paramIDataSource, localAudioType);
        }
      }
      else
      {
        AppMethodBeat.o(114369);
        return bool1;
      }
      i += 1;
    }
  }
  
  private int processInputOutputBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(114363);
    int i = this.mMediaCodec.dequeueInputBuffer(1000L);
    int j;
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.mMediaCodec.getInputBuffer(i);
      if (localByteBuffer == null)
      {
        paramBufferInfo = new NullInputBufferException();
        AppMethodBeat.o(114363);
        throw paramBufferInfo;
      }
      j = this.mMediaExtractor.readSampleData(localByteBuffer, 0);
      if (j >= 0) {
        break label107;
      }
      Logger.i("MediaCodecDecoder", "InputBuffer BUFFER_FLAG_END_OF_STREAM");
      this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
    }
    for (;;)
    {
      i = this.mMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(114363);
      return i;
      label107:
      this.mMediaCodec.queueInputBuffer(i, 0, j, this.mMediaExtractor.getSampleTime(), 0);
      this.mMediaExtractor.advance();
    }
  }
  
  private static void setAudioInformationByMediaFormat(AudioInformation paramAudioInformation, MediaFormat paramMediaFormat, long paramLong)
  {
    AppMethodBeat.i(114373);
    int n = paramMediaFormat.getInteger("sample-rate");
    int i1 = paramMediaFormat.getInteger("channel-count");
    long l = 0L;
    int i = 0;
    int j;
    label84:
    label127:
    int k;
    if (paramMediaFormat.containsKey("bitrate"))
    {
      i = paramMediaFormat.getInteger("bitrate") / 1000;
      if (i <= 0) {
        break label258;
      }
      if (!paramMediaFormat.containsKey("durationUs")) {
        break label238;
      }
      l = paramMediaFormat.getLong("durationUs") / 1000L;
      j = i;
      if (!paramMediaFormat.containsKey(KEY_PCM_ENCODING)) {
        break label324;
      }
      switch (paramMediaFormat.getInteger(KEY_PCM_ENCODING))
      {
      default: 
        i = 2;
        if (Build.VERSION.SDK_INT >= 21) {
          k = 0;
        }
        break;
      }
    }
    label151:
    label324:
    try
    {
      int m = paramMediaFormat.getInteger("bitrate-mode");
      k = m;
    }
    catch (Exception paramMediaFormat)
    {
      label238:
      break label151;
    }
    switch (k)
    {
    }
    for (;;)
    {
      paramAudioInformation.setSampleRate(n);
      paramAudioInformation.setChannels(i1);
      paramAudioInformation.setDuration(l);
      paramAudioInformation.setBitrate(j);
      paramAudioInformation.setBitDept(i);
      AppMethodBeat.o(114373);
      return;
      if (!paramMediaFormat.containsKey("bit-rate")) {
        break;
      }
      i = paramMediaFormat.getInteger("bit-rate") / 1000;
      break;
      l = (int)(paramLong / i * 8L);
      j = i;
      break label84;
      label258:
      j = i;
      if (!paramMediaFormat.containsKey("durationUs")) {
        break label84;
      }
      l = paramMediaFormat.getLong("durationUs") / 1000L;
      if (l > 0L)
      {
        j = (int)(paramLong / l * 8L);
        break label84;
      }
      j = 0;
      break label84;
      i = 1;
      break label127;
      i = 4;
      break label127;
      i = 2;
      break label127;
      paramAudioInformation.setCbr(1);
      continue;
      paramAudioInformation.setCbr(3);
    }
  }
  
  public int decodeData(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114362);
    try
    {
      i = decodeDataInternal(paramInt, paramArrayOfByte);
      AppMethodBeat.o(114362);
      return i;
    }
    catch (BufferTimeoutException localBufferTimeoutException1)
    {
      long l;
      do
      {
        int i;
        l = getCurrentTime() + 5000L;
        Logger.i("MediaCodecDecoder", "decodeData buffer timeout, seekTime:".concat(String.valueOf(l)));
        seekTo((int)Math.min(getDuration(), l));
        try
        {
          i = decodeDataInternal(paramInt, paramArrayOfByte);
          AppMethodBeat.o(114362);
          return i;
        }
        catch (BufferTimeoutException localBufferTimeoutException2) {}
      } while (l < getDuration());
      AppMethodBeat.o(114362);
    }
    return -1;
  }
  
  public AudioInformation getAudioInformation()
  {
    return this.mInfo;
  }
  
  public long getBytePositionOfTime(long paramLong)
  {
    AppMethodBeat.i(114375);
    int i = this.mInfo.getBitrate();
    if (this.mSeekTable != null)
    {
      paramLong = this.mSeekTable.seek(paramLong);
      AppMethodBeat.o(114375);
      return paramLong;
    }
    if (i > 0)
    {
      long l = i;
      AppMethodBeat.o(114375);
      return l * paramLong;
    }
    if (getDuration() > 0L)
    {
      paramLong = this.mFileSize * paramLong / getDuration();
      AppMethodBeat.o(114375);
      return paramLong;
    }
    AppMethodBeat.o(114375);
    return 0L;
  }
  
  public long getCurrentTime()
  {
    return this.mCurrentDecodeTime;
  }
  
  public long getDuration()
  {
    AppMethodBeat.i(114367);
    long l = 0L;
    if (this.mInfo != null) {
      l = this.mInfo.getDuration();
    }
    AppMethodBeat.o(114367);
    return l;
  }
  
  public int getErrorCodeMask()
  {
    return -1;
  }
  
  public long getMinBufferSize()
  {
    int i = 4;
    AppMethodBeat.i(114368);
    int j;
    if (this.mInfo != null)
    {
      j = this.mInfo.getBitDepth();
      if (j == 1) {
        i = 3;
      }
    }
    for (long l = AudioTrack.getMinBufferSize((int)this.mInfo.getSampleRate(), 12, i);; l = 0L)
    {
      AppMethodBeat.o(114368);
      return l;
      if ((j == 4) && (Build.VERSION.SDK_INT >= 21)) {
        break;
      }
      i = 2;
      break;
    }
  }
  
  protected List<NativeLibs> getNativeLibs()
  {
    AppMethodBeat.i(114359);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(114359);
    return localArrayList;
  }
  
  @TargetApi(23)
  public int init(final IDataSource paramIDataSource)
  {
    j = -1;
    AppMethodBeat.i(114361);
    i = j;
    if (paramIDataSource != null) {}
    try
    {
      paramIDataSource.open();
      this.mMediaExtractor.setDataSource(new MediaDataSource()
      {
        public void close() {}
        
        public long getSize()
        {
          AppMethodBeat.i(114335);
          long l = paramIDataSource.getSize();
          AppMethodBeat.o(114335);
          return l;
        }
        
        public int readAt(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(114334);
          paramAnonymousInt1 = paramIDataSource.readAt(paramAnonymousLong, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(114334);
          return paramAnonymousInt1;
        }
      });
      this.mFileSize = paramIDataSource.getSize();
      boolean bool = initMediaCodecAndFormat(paramIDataSource);
      i = j;
      if (bool) {
        i = 0;
      }
    }
    catch (Throwable paramIDataSource)
    {
      for (;;)
      {
        Logger.e("MediaCodecDecoder", "init", paramIDataSource);
        i = j;
      }
    }
    AppMethodBeat.o(114361);
    return i;
  }
  
  public int init(INativeDataSource paramINativeDataSource)
  {
    return -1;
  }
  
  public int init(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(114360);
    int i = init(new FileDataSource(paramString));
    AppMethodBeat.o(114360);
    return i;
  }
  
  public int release()
  {
    AppMethodBeat.i(114366);
    this.mMediaExtractor.release();
    if (this.mMediaCodec != null) {
      this.mMediaCodec.release();
    }
    AppMethodBeat.o(114366);
    return 0;
  }
  
  public int seekTo(int paramInt)
  {
    AppMethodBeat.i(114365);
    this.mMediaCodec.flush();
    this.mRemainBuffer = null;
    this.mMediaExtractor.seekTo(paramInt * 1000, 2);
    this.mCurrentDecodeTime = paramInt;
    AppMethodBeat.o(114365);
    return paramInt;
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(114376);
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(114376);
  }
  
  static class BufferTimeoutException
    extends Exception
  {
    BufferTimeoutException()
    {
      super();
    }
  }
  
  static class NullInputBufferException
    extends Exception
  {
    NullInputBufferException()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */