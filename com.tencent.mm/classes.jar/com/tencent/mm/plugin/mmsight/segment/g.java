package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private long bxw;
  private c cUM;
  private long gnO;
  MediaFormat gqk;
  VideoTransPara hBR;
  MediaFormat hBj;
  String mime;
  z tFY;
  z tFZ;
  boolean tGa;
  List<byte[]> tGb;
  private boolean tGc;
  private boolean tGd;
  private byte[] tGe;
  private HandlerThread tGf;
  private ap tGg;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.mime = null;
    this.tGa = true;
    this.tGb = null;
    this.tGc = false;
    this.tGd = false;
    this.tGf = null;
    this.tGg = null;
    this.cUM = paramc;
    this.hBj = paramMediaFormat;
    this.bxw = paramLong1;
    this.gnO = paramLong2;
    this.hBR = paramVideoTransPara;
    this.mime = paramMediaFormat.getString("mime");
    this.tGb = new ArrayList();
    ad.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.mime, paramMediaFormat, paramVideoTransPara });
    AppMethodBeat.o(107645);
  }
  
  private void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(107648);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(107648);
      return;
    }
    ad.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.tGd) });
    if (this.tGa)
    {
      if (!this.tGc)
      {
        cQA();
        this.tGc = true;
      }
      if (this.tGe == null)
      {
        this.tGe = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.tGe, 0, paramByteBuffer.remaining());
      }
      c(this.tGe, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.tGb.add(arrayOfByte);
    if ((this.tGd) || (paramBoolean)) {
      try
      {
        this.tFY.stop();
        this.tFY.release();
        cQA();
        this.tGc = true;
        paramByteBuffer = this.tGb.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.tGb.size() - 1) {
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
          ad.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    label278:
    AppMethodBeat.o(107648);
  }
  
  private void ajK()
  {
    AppMethodBeat.i(107651);
    if (this.tFZ == null)
    {
      AppMethodBeat.o(107651);
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
          ByteBuffer[] arrayOfByteBuffer1 = this.tFZ.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.tFZ.dequeueOutputBuffer(localBufferInfo, 20000L);
          ad.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ad.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
            AppMethodBeat.o(107651);
            return;
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107651);
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer2 = this.tFZ.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.gqk = this.tFZ.getOutputFormat();
          ad.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.gqk });
        }
        else
        {
          if (i >= 0) {
            break;
          }
          ad.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      ad.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
      ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
      if (localByteBuffer == null)
      {
        ad.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        AppMethodBeat.o(107651);
        return;
      }
      if (localBufferInfo.size > 0)
      {
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        k(localByteBuffer, localBufferInfo);
      }
      this.tFZ.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    ad.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.tFZ != null)
    {
      this.tFZ.stop();
      this.tFZ.release();
      this.tFZ = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void aju()
  {
    AppMethodBeat.i(107647);
    if (this.tFY == null)
    {
      AppMethodBeat.o(107647);
      return;
    }
    MediaCodec.BufferInfo localBufferInfo;
    int i;
    ByteBuffer[] arrayOfByteBuffer2;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer1 = this.tFY.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.tFY.dequeueOutputBuffer(localBufferInfo, 20000L);
        ad.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          ad.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          AppMethodBeat.o(107647);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107647);
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.tFY.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.hBj = this.tFY.getOutputFormat();
        ad.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.hBj });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        ad.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    ad.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      ad.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      AppMethodBeat.o(107647);
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      ad.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
      localBufferInfo.size = 0;
    }
    if (localBufferInfo.size > 0)
    {
      localByteBuffer.position(localBufferInfo.offset);
      localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label372;
      }
    }
    label372:
    for (boolean bool = true;; bool = false)
    {
      a(localByteBuffer, localBufferInfo, bool);
      this.tFY.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      ad.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.tFY == null) {
        break label377;
      }
      this.tFY.stop();
      this.tFY.release();
      this.tFY = null;
      AppMethodBeat.o(107647);
      return;
    }
    label377:
    AppMethodBeat.o(107647);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.tFZ == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.tFZ.getInputBuffers();
    int j = this.tFZ.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      ad.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      ajK();
    }
    int i;
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      if (!paramBoolean) {
        break label181;
      }
      ad.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
      i = 1;
      cQB();
    }
    for (;;)
    {
      if (this.tFZ == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        ad.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.tFZ.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        ajK();
        AppMethodBeat.o(107650);
        return;
        this.tFZ.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void cQA()
  {
    AppMethodBeat.i(107649);
    if ((this.tFZ != null) && (this.tGa) && (!this.tGc))
    {
      this.tFY.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.gqk = new MediaFormat();
      this.gqk.setString("mime", "audio/mp4a-latm");
      this.gqk.setInteger("aac-profile", 2);
      this.gqk.setInteger("sample-rate", this.hBR.audioSampleRate);
      this.gqk.setInteger("channel-count", 1);
      this.gqk.setInteger("bitrate", this.hBR.audioBitrate);
      this.gqk.setInteger("max-input-size", 16384);
      this.tFZ = z.q(this.mime, false);
      this.tFZ.a(this.gqk, null, 1);
      this.tFZ.start();
      ad.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      AppMethodBeat.o(107649);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107649);
    }
  }
  
  private void cQB()
  {
    AppMethodBeat.i(107653);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.tFZ != null)
          {
            ad.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.tFZ.stop();
            g.this.tFZ.release();
            g.this.tFZ = null;
          }
          AppMethodBeat.o(107644);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107644);
        }
      }
    }, 500L);
    AppMethodBeat.o(107653);
  }
  
  private static void k(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(107652);
    if (paramByteBuffer != null) {
      MP4MuxerJNI.writeAACData(0, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(107652);
  }
  
  public final void cQz()
  {
    AppMethodBeat.i(107646);
    this.tGc = false;
    this.tGd = false;
    for (;;)
    {
      try
      {
        if ((this.tFY == null) || (this.cUM == null))
        {
          ad.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.tFY.getInputBuffers();
        int j = this.tFY.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          ad.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          aju();
        }
        int k;
        long l;
        if (j >= 0)
        {
          ad.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.cUM.j((ByteBuffer)localObject);
          l = this.cUM.fGK.getSampleTime();
          this.cUM.fGK.advance();
          ad.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.gnO * 1000L) && (l > 0L) && (k > 0)) {
            break label350;
          }
          ad.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.tGd = true;
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.tFY != null)
                {
                  ad.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.tFY.stop();
                  g.this.tFY.release();
                  g.this.tFY = null;
                }
                AppMethodBeat.o(107643);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(107643);
              }
            }
          }, 500L);
          i = 1;
          if (this.tFY == null) {
            break label343;
          }
          if (i != 0)
          {
            ad.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.tFY.a(j, k, l, 4);
          }
        }
        else
        {
          aju();
          if (!this.tGd) {
            continue;
          }
          localObject = this.tFZ;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.tFY.a(j, k, l, 0);
        continue;
        AppMethodBeat.o(107646);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107646);
        return;
      }
      label343:
      return;
      label350:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */