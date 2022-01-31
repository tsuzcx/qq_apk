package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private long aZw;
  private MediaExtractor cfO;
  String cfP;
  private long eRN;
  MediaFormat eUh;
  MediaFormat fYw;
  VideoTransPara fZe;
  MediaCodec oKN;
  MediaCodec oKO;
  boolean oKP;
  List<byte[]> oKQ;
  private boolean oKR;
  private boolean oKS;
  private byte[] oKT;
  private HandlerThread oKU;
  private ak oKV;
  
  public g(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(3644);
    this.cfP = null;
    this.oKP = true;
    this.oKQ = null;
    this.oKR = false;
    this.oKS = false;
    this.oKU = null;
    this.oKV = null;
    this.cfO = paramMediaExtractor;
    this.fYw = paramMediaFormat;
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    this.fZe = paramVideoTransPara;
    this.cfP = paramMediaFormat.getString("mime");
    this.oKQ = new ArrayList();
    ab.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.cfP, paramMediaFormat, paramVideoTransPara });
    AppMethodBeat.o(3644);
  }
  
  private void UC()
  {
    AppMethodBeat.i(3646);
    if (this.oKN == null)
    {
      AppMethodBeat.o(3646);
      return;
    }
    MediaCodec.BufferInfo localBufferInfo;
    int i;
    ByteBuffer[] arrayOfByteBuffer2;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer1 = this.oKN.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.oKN.dequeueOutputBuffer(localBufferInfo, 20000L);
        ab.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          ab.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          AppMethodBeat.o(3646);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(3646);
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.oKN.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.fYw = this.oKN.getOutputFormat();
        ab.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.fYw });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        ab.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    ab.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      ab.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      AppMethodBeat.o(3646);
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      ab.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
      localBufferInfo.size = 0;
    }
    if (localBufferInfo.size > 0)
    {
      localByteBuffer.position(localBufferInfo.offset);
      localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label364;
      }
    }
    label364:
    for (boolean bool = true;; bool = false)
    {
      a(localByteBuffer, localBufferInfo, bool);
      this.oKN.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      ab.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.oKN == null) {
        break label369;
      }
      this.oKN.stop();
      this.oKN.release();
      this.oKN = null;
      AppMethodBeat.o(3646);
      return;
    }
    label369:
    AppMethodBeat.o(3646);
  }
  
  private void UR()
  {
    AppMethodBeat.i(3650);
    if (this.oKO == null)
    {
      AppMethodBeat.o(3650);
      return;
    }
    MediaCodec.BufferInfo localBufferInfo;
    do
    {
      int i;
      ByteBuffer[] arrayOfByteBuffer2;
      for (;;)
      {
        try
        {
          ByteBuffer[] arrayOfByteBuffer1 = this.oKO.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.oKO.dequeueOutputBuffer(localBufferInfo, 20000L);
          ab.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ab.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
            AppMethodBeat.o(3650);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(3650);
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer2 = this.oKO.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.eUh = this.oKO.getOutputFormat();
          ab.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.eUh });
        }
        else
        {
          if (i >= 0) {
            break;
          }
          ab.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      ab.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
      ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
      if (localByteBuffer == null)
      {
        ab.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        AppMethodBeat.o(3650);
        return;
      }
      if (localBufferInfo.size > 0)
      {
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        h(localByteBuffer, localBufferInfo);
      }
      this.oKO.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    ab.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.oKO != null)
    {
      this.oKO.stop();
      this.oKO.release();
      this.oKO = null;
      AppMethodBeat.o(3650);
      return;
    }
    AppMethodBeat.o(3650);
  }
  
  private void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(3647);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(3647);
      return;
    }
    ab.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.oKS) });
    if (this.oKP)
    {
      if (!this.oKR)
      {
        bRF();
        this.oKR = true;
      }
      if (this.oKT == null)
      {
        this.oKT = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.oKT, 0, paramByteBuffer.remaining());
      }
      c(this.oKT, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(3647);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.oKQ.add(arrayOfByte);
    if ((this.oKS) || (paramBoolean)) {
      try
      {
        this.oKN.stop();
        this.oKN.release();
        bRF();
        this.oKR = true;
        paramByteBuffer = this.oKQ.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label282;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.oKQ.size() - 1) {
            break;
          }
          paramBoolean = true;
          c(arrayOfByte, l, paramBoolean);
          i += 1;
        }
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    label282:
    AppMethodBeat.o(3647);
  }
  
  private void bRF()
  {
    AppMethodBeat.i(3648);
    if ((this.oKO != null) && (this.oKP) && (!this.oKR))
    {
      this.oKN.start();
      AppMethodBeat.o(3648);
      return;
    }
    try
    {
      this.eUh = new MediaFormat();
      this.eUh.setString("mime", "audio/mp4a-latm");
      this.eUh.setInteger("aac-profile", 2);
      this.eUh.setInteger("sample-rate", this.fZe.audioSampleRate);
      this.eUh.setInteger("channel-count", 1);
      this.eUh.setInteger("bitrate", this.fZe.fzT);
      this.eUh.setInteger("max-input-size", 16384);
      this.oKO = MediaCodec.createEncoderByType(this.cfP);
      this.oKO.configure(this.eUh, null, null, 1);
      this.oKO.start();
      ab.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      AppMethodBeat.o(3648);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(3648);
    }
  }
  
  private void bRG()
  {
    AppMethodBeat.i(3652);
    al.p(new g.2(this), 500L);
    AppMethodBeat.o(3652);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(3649);
    if ((this.oKO == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(3649);
      return;
    }
    Object localObject = this.oKO.getInputBuffers();
    int j = this.oKO.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      ab.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      UR();
    }
    int i;
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      if (!paramBoolean) {
        break label183;
      }
      ab.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
      i = 1;
      bRG();
    }
    for (;;)
    {
      if (this.oKO == null)
      {
        AppMethodBeat.o(3649);
        return;
      }
      if (i != 0)
      {
        ab.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.oKO.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        UR();
        AppMethodBeat.o(3649);
        return;
        this.oKO.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 0);
      }
      label183:
      i = 0;
    }
  }
  
  private static void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(3651);
    if (paramByteBuffer != null) {
      MP4MuxerJNI.writeAACData(0, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(3651);
  }
  
  public final void bRE()
  {
    AppMethodBeat.i(3645);
    this.oKR = false;
    this.oKS = false;
    for (;;)
    {
      try
      {
        if ((this.oKN == null) || (this.cfO == null))
        {
          ab.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(3645);
          return;
        }
        Object localObject = this.oKN.getInputBuffers();
        int j = this.oKN.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          ab.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          UC();
        }
        int k;
        long l;
        if (j >= 0)
        {
          ab.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.cfO.readSampleData((ByteBuffer)localObject, 0);
          l = this.cfO.getSampleTime();
          this.cfO.advance();
          ab.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.eRN * 1000L) && (l > 0L) && (k > 0)) {
            break label347;
          }
          ab.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.oKS = true;
          al.p(new g.1(this), 500L);
          i = 1;
          if (this.oKN == null) {
            break label340;
          }
          if (i != 0)
          {
            ab.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.oKN.queueInputBuffer(j, 0, k, l, 4);
          }
        }
        else
        {
          UC();
          if (!this.oKS) {
            continue;
          }
          localObject = this.oKO;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(3645);
          return;
        }
        this.oKN.queueInputBuffer(j, 0, k, l, 0);
        continue;
        AppMethodBeat.o(3645);
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(3645);
        return;
      }
      label340:
      return;
      label347:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */