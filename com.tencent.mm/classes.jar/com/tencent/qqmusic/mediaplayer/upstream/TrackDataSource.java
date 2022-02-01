package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import java.io.File;

public class TrackDataSource
  implements PlayerListenerCallback, IDataSource
{
  private static final String TAG = "TrackDataSource";
  private IDataSource mDataSource;
  private long mEndBytePosition;
  private long mStartBytePosition;
  private long mStartTimePosition;
  private TrackInfo mTrackInfo;
  private TrackStateCallback mTrackStateCallback;
  
  public TrackDataSource(TrackInfo paramTrackInfo)
  {
    AppMethodBeat.i(76505);
    String str = paramTrackInfo.getUri();
    if (TextUtils.isEmpty(paramTrackInfo.getUri()))
    {
      paramTrackInfo = new DataSourceException(-1, "track info has no media file path!", null);
      AppMethodBeat.o(76505);
      throw paramTrackInfo;
    }
    if (!new File(str).exists())
    {
      paramTrackInfo = new DataSourceException(-1, "track info's media file not exists!", null);
      AppMethodBeat.o(76505);
      throw paramTrackInfo;
    }
    this.mDataSource = new FileDataSource(paramTrackInfo.getUri());
    this.mTrackInfo = paramTrackInfo;
    AppMethodBeat.o(76505);
  }
  
  public void close()
  {
    AppMethodBeat.i(76509);
    this.mDataSource.close();
    AppMethodBeat.o(76509);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(76510);
    AudioFormat.AudioType localAudioType = this.mDataSource.getAudioType();
    AppMethodBeat.o(76510);
    return localAudioType;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(76508);
    long l = this.mDataSource.getSize();
    AppMethodBeat.o(76508);
    return l;
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer) {}
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3) {}
  
  /* Error */
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 75	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   9: invokeinterface 107 1 0
    //   14: aload_0
    //   15: getfield 75	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   18: invokeinterface 92 1 0
    //   23: lstore 4
    //   25: aload_1
    //   26: invokevirtual 113	com/tencent/qqmusic/mediaplayer/BaseMediaPlayer:createSeekTable	()Lcom/tencent/qqmusic/mediaplayer/seektable/SeekTable;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull +45 -> 76
    //   34: ldc 15
    //   36: ldc 115
    //   38: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 104
    //   43: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: return
    //   47: astore_1
    //   48: ldc 15
    //   50: ldc 123
    //   52: aload_1
    //   53: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: ldc 104
    //   58: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: astore_1
    //   63: ldc 15
    //   65: ldc 128
    //   67: aload_1
    //   68: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aconst_null
    //   72: astore_1
    //   73: goto -43 -> 30
    //   76: aload_0
    //   77: getfield 77	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mTrackInfo	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo;
    //   80: invokevirtual 132	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   83: astore 10
    //   85: ldc 15
    //   87: new 134	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 136
    //   93: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 10
    //   98: getfield 143	android/util/Pair:first	Ljava/lang/Object;
    //   101: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: ldc 149
    //   106: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 10
    //   111: getfield 155	android/util/Pair:second	Ljava/lang/Object;
    //   114: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 10
    //   125: getfield 143	android/util/Pair:first	Ljava/lang/Object;
    //   128: checkcast 162	java/lang/Long
    //   131: invokevirtual 165	java/lang/Long:longValue	()J
    //   134: aload 10
    //   136: getfield 155	android/util/Pair:second	Ljava/lang/Object;
    //   139: checkcast 162	java/lang/Long
    //   142: invokevirtual 165	java/lang/Long:longValue	()J
    //   145: lcmp
    //   146: ifle +16 -> 162
    //   149: ldc 15
    //   151: ldc 167
    //   153: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 104
    //   158: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: aload_0
    //   163: aload 10
    //   165: getfield 143	android/util/Pair:first	Ljava/lang/Object;
    //   168: checkcast 162	java/lang/Long
    //   171: invokevirtual 165	java/lang/Long:longValue	()J
    //   174: putfield 169	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mStartTimePosition	J
    //   177: aload_1
    //   178: aload 10
    //   180: getfield 143	android/util/Pair:first	Ljava/lang/Object;
    //   183: checkcast 162	java/lang/Long
    //   186: invokevirtual 165	java/lang/Long:longValue	()J
    //   189: invokeinterface 175 3 0
    //   194: lstore 8
    //   196: aload_1
    //   197: aload 10
    //   199: getfield 155	android/util/Pair:second	Ljava/lang/Object;
    //   202: checkcast 162	java/lang/Long
    //   205: invokevirtual 165	java/lang/Long:longValue	()J
    //   208: invokeinterface 175 3 0
    //   213: lstore 6
    //   215: lload 4
    //   217: lconst_0
    //   218: lcmp
    //   219: ifle +24 -> 243
    //   222: lload 8
    //   224: lload 4
    //   226: lcmp
    //   227: ifle +16 -> 243
    //   230: ldc 15
    //   232: ldc 177
    //   234: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: ldc 104
    //   239: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: return
    //   243: lload 6
    //   245: lstore_2
    //   246: lload 4
    //   248: lconst_0
    //   249: lcmp
    //   250: ifle +17 -> 267
    //   253: lload 6
    //   255: lstore_2
    //   256: lload 6
    //   258: lload 4
    //   260: lcmp
    //   261: ifle +6 -> 267
    //   264: lload 4
    //   266: lstore_2
    //   267: aload_0
    //   268: lload 8
    //   270: putfield 179	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mStartBytePosition	J
    //   273: aload_0
    //   274: lload_2
    //   275: putfield 181	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mEndBytePosition	J
    //   278: ldc 15
    //   280: new 134	java/lang/StringBuilder
    //   283: dup
    //   284: ldc 183
    //   286: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 179	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mStartBytePosition	J
    //   293: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc 188
    //   298: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 181	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mEndBytePosition	J
    //   305: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 160	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_0
    //   315: getfield 190	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mTrackStateCallback	Lcom/tencent/qqmusic/mediaplayer/upstream/TrackDataSource$TrackStateCallback;
    //   318: ifnull +16 -> 334
    //   321: aload_0
    //   322: getfield 190	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mTrackStateCallback	Lcom/tencent/qqmusic/mediaplayer/upstream/TrackDataSource$TrackStateCallback;
    //   325: aload_0
    //   326: getfield 77	com/tencent/qqmusic/mediaplayer/upstream/TrackDataSource:mTrackInfo	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo;
    //   329: invokeinterface 193 2 0
    //   334: ldc 104
    //   336: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	TrackDataSource
    //   0	340	1	paramBaseMediaPlayer	BaseMediaPlayer
    //   245	30	2	l1	long
    //   23	242	4	l2	long
    //   213	44	6	l3	long
    //   194	75	8	l4	long
    //   83	115	10	localPair	android.util.Pair
    // Exception table:
    //   from	to	target	type
    //   5	25	47	java/io/IOException
    //   25	30	62	java/lang/IllegalStateException
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(76512);
    paramBaseMediaPlayer.seekTo(0);
    AppMethodBeat.o(76512);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void open()
  {
    AppMethodBeat.i(76506);
    this.mDataSource.open();
    AppMethodBeat.o(76506);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76507);
    if ((this.mEndBytePosition > 0L) && (paramLong > this.mEndBytePosition))
    {
      AppMethodBeat.o(76507);
      return -1;
    }
    paramInt1 = this.mDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(76507);
    return paramInt1;
  }
  
  public void setEndBytePosition(long paramLong)
  {
    this.mEndBytePosition = paramLong;
  }
  
  public void setTrackStateCallback(TrackStateCallback paramTrackStateCallback)
  {
    this.mTrackStateCallback = paramTrackStateCallback;
  }
  
  public static abstract interface TrackStateCallback
  {
    public abstract void onTrackPrepared(TrackInfo paramTrackInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource
 * JD-Core Version:    0.7.0.1
 */