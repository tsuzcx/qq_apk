package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder
{
  private static final String TAG = "MediaCodecEncoder";
  private static boolean mDumpEnable = false;
  private MediaCodec.BufferInfo mAACEncBufferInfo;
  private MediaCodec mAudioAACEncoder;
  private MediaFormat mAudioFormat;
  private int mBitrate;
  private int mChannels;
  private Context mContext;
  private ByteBuffer mEncInBuffer;
  private ByteBuffer mEncOutBuffer;
  private boolean mFormatChangeFlag;
  private ByteBuffer mInputBuffer;
  private ByteBuffer[] mMediaInputBuffers;
  private ByteBuffer[] mMediaOutputBuffers;
  private ByteBuffer mOutputBuffer;
  private File mRecFileDump;
  private FileOutputStream mRecFileOut;
  private int mSampleRate;
  private byte[] mTempBufEncIn;
  private byte[] mTempBufEncOut;
  private int nMaxBitRate;
  
  public MediaCodecEncoder()
  {
    AppMethodBeat.i(13694);
    this.mAudioAACEncoder = null;
    this.mAudioFormat = null;
    this.mAACEncBufferInfo = null;
    this.mInputBuffer = null;
    this.mOutputBuffer = null;
    this.mSampleRate = 48000;
    this.mChannels = 1;
    this.mBitrate = 32000;
    this.nMaxBitRate = 256000;
    this.mFormatChangeFlag = false;
    this.mRecFileDump = null;
    this.mRecFileOut = null;
    this.mContext = TXCCommonUtil.getAppContext();
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
    AppMethodBeat.o(13694);
  }
  
  public MediaCodecEncoder(Context paramContext)
  {
    AppMethodBeat.i(182239);
    this.mAudioAACEncoder = null;
    this.mAudioFormat = null;
    this.mAACEncBufferInfo = null;
    this.mInputBuffer = null;
    this.mOutputBuffer = null;
    this.mSampleRate = 48000;
    this.mChannels = 1;
    this.mBitrate = 32000;
    this.nMaxBitRate = 256000;
    this.mFormatChangeFlag = false;
    this.mRecFileDump = null;
    this.mRecFileOut = null;
    this.mContext = paramContext;
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
    AppMethodBeat.o(182239);
  }
  
  private void addADTStoPacket(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    if (this.mSampleRate == 48000) {
      i = 3;
    }
    for (;;)
    {
      int j = this.mChannels;
      paramArrayOfByte[0] = -1;
      paramArrayOfByte[1] = -7;
      paramArrayOfByte[2] = ((byte)((i << 2) + 64 + (j >> 2)));
      paramArrayOfByte[3] = ((byte)(((j & 0x3) << 6) + (paramInt >> 11)));
      paramArrayOfByte[4] = ((byte)((paramInt & 0x7FF) >> 3));
      paramArrayOfByte[5] = ((byte)(((paramInt & 0x7) << 5) + 31));
      paramArrayOfByte[6] = -4;
      return;
      if (this.mSampleRate == 44100) {
        i = 4;
      } else if (this.mSampleRate == 32000) {
        i = 5;
      } else if (this.mSampleRate == 24000) {
        i = 6;
      } else if (this.mSampleRate == 16000) {
        i = 8;
      } else {
        i = 3;
      }
    }
  }
  
  private String getDumpFilePath(String paramString)
  {
    AppMethodBeat.i(13695);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13695);
      return null;
    }
    File localFile = this.mContext.getExternalFilesDir(null);
    if (localFile == null)
    {
      AppMethodBeat.o(13695);
      return null;
    }
    paramString = localFile.getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-" + paramString;
    localFile = new File(paramString);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:".concat(String.valueOf(paramString)));
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    paramString = paramString.replace(" ", "_");
    AppMethodBeat.o(13695);
    return paramString;
  }
  
  @SuppressLint({"NewApi"})
  public int createAACEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(13696);
    try
    {
      this.mAudioAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      this.mAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
      this.mAudioFormat.setInteger("aac-profile", 2);
      this.mAudioFormat.setInteger("sample-rate", paramInt1);
      this.mAudioFormat.setInteger("channel-count", paramInt2);
      this.mAudioFormat.setInteger("bitrate", paramInt3);
      this.mAudioAACEncoder.configure(this.mAudioFormat, null, null, 1);
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.start();
        this.mAACEncBufferInfo = new MediaCodec.BufferInfo();
        this.mSampleRate = paramInt1;
        this.mChannels = paramInt2;
        this.mBitrate = paramInt3;
      }
      if (mDumpEnable) {
        this.mRecFileDump = new File(getDumpFilePath("jnirecord.aac"));
      }
      try
      {
        this.mRecFileOut = new FileOutputStream(this.mRecFileDump);
        if (QLog.isColorLevel()) {
          QLog.w("MediaCodecEncoder", 2, "createAACEncoder succeed!!! : (" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ")");
        }
        AppMethodBeat.o(13696);
        return 0;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MediaCodecEncoder", 2, "open jnirecord.aac file failed.");
          }
        }
      }
      return -1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "create AAC Encoder failed.");
      }
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] creating aac encode stream failed!!! : (" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ")");
      }
      AppMethodBeat.o(13696);
    }
  }
  
  @SuppressLint({"NewApi"})
  public int encodeAACFrame(int paramInt)
  {
    AppMethodBeat.i(13697);
    if (this.mFormatChangeFlag)
    {
      this.mFormatChangeFlag = false;
      this.mAudioAACEncoder.stop();
      this.mAudioFormat.setInteger("bitrate", this.mBitrate);
      this.mAudioAACEncoder.configure(this.mAudioFormat, null, null, 1);
      this.mAudioAACEncoder.start();
    }
    this.mEncInBuffer.get(this.mTempBufEncIn, 0, paramInt);
    int i = encodeInternalAACFrame(paramInt);
    this.mEncOutBuffer.rewind();
    if (i > 0)
    {
      this.mEncOutBuffer.put(this.mTempBufEncOut, 0, i);
      paramInt = i;
      if (mDumpEnable)
      {
        paramInt = i;
        if (this.mRecFileOut == null) {}
      }
    }
    for (paramInt = i + 7;; paramInt = 0)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInt];
        addADTStoPacket(arrayOfByte, paramInt);
        System.arraycopy(this.mTempBufEncOut, 0, arrayOfByte, 7, i);
        this.mRecFileOut.write(arrayOfByte, 0, paramInt);
        paramInt = i;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramInt = i;
          if (QLog.isColorLevel())
          {
            QLog.e("MediaCodecEncoder", 2, "write file failed.");
            paramInt = i;
          }
        }
      }
      AppMethodBeat.o(13697);
      return paramInt;
    }
  }
  
  @SuppressLint({"NewApi"})
  public int encodeInternalAACFrame(int paramInt)
  {
    AppMethodBeat.i(13698);
    int i;
    try
    {
      i = this.mAudioAACEncoder.dequeueInputBuffer(2000L);
      if (i != -1) {
        if (Build.VERSION.SDK_INT < 21) {
          break label109;
        }
      }
      for (this.mInputBuffer = this.mAudioAACEncoder.getInputBuffer(i);; this.mInputBuffer = this.mMediaInputBuffers[i])
      {
        this.mInputBuffer.clear();
        this.mInputBuffer.put(this.mTempBufEncIn, 0, paramInt);
        this.mAudioAACEncoder.queueInputBuffer(i, 0, paramInt, 0L, 0);
        this.mEncInBuffer.rewind();
        i = this.mAudioAACEncoder.dequeueOutputBuffer(this.mAACEncBufferInfo, 0L);
        if (i >= 0) {
          break;
        }
        AppMethodBeat.o(13698);
        return 0;
        label109:
        this.mMediaInputBuffers = this.mAudioAACEncoder.getInputBuffers();
      }
      AppMethodBeat.o(13698);
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "encode failed." + localException1.getMessage());
      }
      i = 0;
    }
    for (;;)
    {
      return i;
      int j = this.mAACEncBufferInfo.size;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mOutputBuffer = this.mAudioAACEncoder.getOutputBuffer(i);
        paramInt = this.mAACEncBufferInfo.flags;
        if ((paramInt & 0x2) != 2) {
          break label319;
        }
      }
      for (paramInt = 0;; paramInt = this.mAACEncBufferInfo.size)
      {
        try
        {
          this.mOutputBuffer.position(this.mAACEncBufferInfo.offset);
          this.mOutputBuffer.limit(j + this.mAACEncBufferInfo.offset);
          this.mOutputBuffer.get(this.mTempBufEncOut, 0, paramInt);
          this.mOutputBuffer.position(0);
          this.mAudioAACEncoder.releaseOutputBuffer(i, false);
          AppMethodBeat.o(13698);
          return paramInt;
        }
        catch (Exception localException2)
        {
          label319:
          i = paramInt;
        }
        this.mMediaOutputBuffers = this.mAudioAACEncoder.getOutputBuffers();
        this.mOutputBuffer = this.mMediaOutputBuffers[i];
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] encoding aac stream failed!!!");
        i = paramInt;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACEncoder()
  {
    AppMethodBeat.i(13699);
    try
    {
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.stop();
        this.mAudioAACEncoder.release();
        this.mAudioAACEncoder = null;
        if (QLog.isColorLevel()) {
          QLog.w("MediaCodecEncoder", 2, "releaseAACEncoder, release aac encode stream succeed!!");
        }
        AppMethodBeat.o(13699);
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "release aac encoder failed." + localException.getMessage());
      }
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
      }
      AppMethodBeat.o(13699);
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public int setAACEncodeBitrate(int paramInt)
  {
    AppMethodBeat.i(13700);
    if ((this.mAudioAACEncoder != null) && (this.mBitrate != paramInt))
    {
      this.mFormatChangeFlag = true;
      this.mBitrate = paramInt;
      if (QLog.isColorLevel()) {
        QLog.w("MediaCodecEncoder", 2, "Set AAC bitrate = ".concat(String.valueOf(paramInt)));
      }
    }
    AppMethodBeat.o(13700);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecEncoder
 * JD-Core Version:    0.7.0.1
 */