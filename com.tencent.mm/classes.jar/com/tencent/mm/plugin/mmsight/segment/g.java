package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private long aRW;
  private MediaExtractor eIP;
  private long eIR;
  MediaFormat eIS;
  VideoTransPara eJA;
  String jkV = null;
  MediaCodec mlF;
  MediaCodec mlG;
  MediaFormat mlH;
  boolean mlI = true;
  List<byte[]> mlJ = null;
  private boolean mlK = false;
  private boolean mlL = false;
  private byte[] mlM;
  private HandlerThread mlN = null;
  private ah mlO = null;
  
  public g(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    this.eIP = paramMediaExtractor;
    this.eIS = paramMediaFormat;
    this.aRW = paramLong1;
    this.eIR = paramLong2;
    this.eJA = paramVideoTransPara;
    this.jkV = paramMediaFormat.getString("mime");
    this.mlJ = new ArrayList();
    y.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.jkV, paramMediaFormat, paramVideoTransPara });
  }
  
  private void SS()
  {
    if (this.mlG == null) {}
    do
    {
      return;
      MediaCodec.BufferInfo localBufferInfo;
      do
      {
        int i;
        ByteBuffer[] arrayOfByteBuffer2;
        for (;;)
        {
          try
          {
            ByteBuffer[] arrayOfByteBuffer1 = this.mlG.getOutputBuffers();
            localBufferInfo = new MediaCodec.BufferInfo();
            i = this.mlG.dequeueOutputBuffer(localBufferInfo, 20000L);
            y.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
            if (i == -1)
            {
              y.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
              return;
            }
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
            return;
          }
          if (i == -3)
          {
            arrayOfByteBuffer2 = this.mlG.getOutputBuffers();
          }
          else if (i == -2)
          {
            this.mlH = this.mlG.getOutputFormat();
            y.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.mlH });
          }
          else
          {
            if (i >= 0) {
              break;
            }
            y.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          }
        }
        y.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
        ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
        if (localByteBuffer == null)
        {
          y.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
          return;
        }
        if (localBufferInfo.size > 0)
        {
          localByteBuffer.position(localBufferInfo.offset);
          localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
          if (localByteBuffer != null) {
            MP4MuxerJNI.writeAACData(0, localByteBuffer, localBufferInfo.size);
          }
        }
        this.mlG.releaseOutputBuffer(i, false);
      } while ((localBufferInfo.flags & 0x4) == 0);
      y.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    } while (this.mlG == null);
    this.mlG.stop();
    this.mlG.release();
    this.mlG = null;
  }
  
  private void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, boolean paramBoolean)
  {
    if (paramByteBuffer == null) {}
    for (;;)
    {
      return;
      y.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mlL) });
      if (this.mlI)
      {
        if (!this.mlK)
        {
          bjT();
          this.mlK = true;
        }
        if (this.mlM == null)
        {
          this.mlM = new byte[paramByteBuffer.remaining()];
          paramByteBuffer.get(this.mlM, 0, paramByteBuffer.remaining());
        }
        a(this.mlM, paramBufferInfo.presentationTimeUs, paramBoolean);
        return;
      }
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
      this.mlJ.add(arrayOfByte);
      if ((!this.mlL) && (!paramBoolean)) {
        continue;
      }
      try
      {
        this.mlF.stop();
        this.mlF.release();
        bjT();
        this.mlK = true;
        paramByteBuffer = this.mlJ.iterator();
        int i = 0;
        while (paramByteBuffer.hasNext())
        {
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.mlJ.size() - 1) {
            break label258;
          }
          paramBoolean = true;
          a(arrayOfByte, l, paramBoolean);
          i += 1;
        }
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          label258:
          paramBoolean = false;
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    if ((this.mlG == null) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.mlG.getInputBuffers();
      int j = this.mlG.dequeueInputBuffer(20000L);
      if (j < 0)
      {
        y.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
        SS();
      }
      int i;
      if (j >= 0)
      {
        localObject = localObject[j];
        ((ByteBuffer)localObject).clear();
        ((ByteBuffer)localObject).position(0);
        ((ByteBuffer)localObject).put(paramArrayOfByte);
        if (!paramBoolean) {
          break label168;
        }
        y.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
        i = 1;
        ai.l(new g.2(this), 500L);
      }
      while (this.mlG != null)
      {
        if (i != 0)
        {
          y.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
          this.mlG.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 4);
        }
        for (;;)
        {
          SS();
          return;
          this.mlG.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 0);
        }
        label168:
        i = 0;
      }
    }
  }
  
  private void bjS()
  {
    if (this.mlF == null) {
      return;
    }
    MediaCodec.BufferInfo localBufferInfo;
    label25:
    int i;
    ByteBuffer[] arrayOfByteBuffer2;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer1 = this.mlF.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.mlF.dequeueOutputBuffer(localBufferInfo, 20000L);
        y.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          y.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          return;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.mlF.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.eIS = this.mlF.getOutputFormat();
        y.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.eIS });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        y.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    y.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      y.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      y.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
      localBufferInfo.size = 0;
    }
    if (localBufferInfo.size > 0)
    {
      localByteBuffer.position(localBufferInfo.offset);
      localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label335;
      }
    }
    label335:
    for (boolean bool = true;; bool = false)
    {
      a(localByteBuffer, localBufferInfo, bool);
      this.mlF.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label25;
      }
      y.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.mlF == null) {
        break;
      }
      this.mlF.stop();
      this.mlF.release();
      this.mlF = null;
      return;
    }
  }
  
  private void bjT()
  {
    if ((this.mlG != null) && (this.mlI) && (!this.mlK))
    {
      this.mlF.start();
      return;
    }
    try
    {
      this.mlH = new MediaFormat();
      this.mlH.setString("mime", "audio/mp4a-latm");
      this.mlH.setInteger("aac-profile", 2);
      this.mlH.setInteger("sample-rate", this.eJA.audioSampleRate);
      this.mlH.setInteger("channel-count", 1);
      this.mlH.setInteger("bitrate", this.eJA.ejM);
      this.mlH.setInteger("max-input-size", 16384);
      this.mlG = MediaCodec.createEncoderByType(this.jkV);
      this.mlG.configure(this.mlH, null, null, 1);
      this.mlG.start();
      y.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void bjR()
  {
    this.mlK = false;
    this.mlL = false;
    label312:
    for (;;)
    {
      try
      {
        if ((this.mlF == null) || (this.eIP == null))
        {
          y.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          return;
        }
        Object localObject = this.mlF.getInputBuffers();
        int j = this.mlF.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          y.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          bjS();
        }
        int k;
        long l;
        if (j >= 0)
        {
          y.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.eIP.readSampleData((ByteBuffer)localObject, 0);
          l = this.eIP.getSampleTime();
          this.eIP.advance();
          y.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.eIR * 1000L) && (l > 0L) && (k > 0)) {
            break label312;
          }
          y.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.mlL = true;
          ai.l(new g.1(this), 500L);
          i = 1;
          if (this.mlF == null) {
            break;
          }
          if (i != 0)
          {
            y.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.mlF.queueInputBuffer(j, 0, k, l, 4);
          }
        }
        else
        {
          bjS();
          if ((!this.mlL) || (this.mlG != null)) {
            continue;
          }
          return;
        }
        this.mlF.queueInputBuffer(j, 0, k, l, 0);
        continue;
        int i = 0;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */