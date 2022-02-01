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
  private c ddy;
  private long hiy;
  MediaFormat hjk;
  VideoTransPara ivO;
  MediaFormat ivg;
  String mime;
  private long startTimeMs;
  z vRC;
  z vRD;
  boolean vRE;
  List<byte[]> vRF;
  private boolean vRG;
  private boolean vRH;
  private byte[] vRI;
  private HandlerThread vRJ;
  private ap vRK;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.mime = null;
    this.vRE = true;
    this.vRF = null;
    this.vRG = false;
    this.vRH = false;
    this.vRJ = null;
    this.vRK = null;
    this.ddy = paramc;
    this.ivg = paramMediaFormat;
    this.startTimeMs = paramLong1;
    this.hiy = paramLong2;
    this.ivO = paramVideoTransPara;
    this.mime = paramMediaFormat.getString("mime");
    this.vRF = new ArrayList();
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
    ad.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vRH) });
    if (this.vRE)
    {
      if (!this.vRG)
      {
        dnG();
        this.vRG = true;
      }
      if (this.vRI == null)
      {
        this.vRI = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.vRI, 0, paramByteBuffer.remaining());
      }
      c(this.vRI, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.vRF.add(arrayOfByte);
    if ((this.vRH) || (paramBoolean)) {
      try
      {
        this.vRC.stop();
        this.vRC.release();
        dnG();
        this.vRG = true;
        paramByteBuffer = this.vRF.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.vRF.size() - 1) {
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
  
  private void ato()
  {
    AppMethodBeat.i(107647);
    if (this.vRC == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.vRC.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.vRC.dequeueOutputBuffer(localBufferInfo, 20000L);
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
        arrayOfByteBuffer2 = this.vRC.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.ivg = this.vRC.getOutputFormat();
        ad.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.ivg });
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
        break label359;
      }
    }
    label359:
    for (boolean bool = true;; bool = false)
    {
      a(localByteBuffer, localBufferInfo, bool);
      this.vRC.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      ad.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.vRC == null) {
        break label364;
      }
      this.vRC.stop();
      this.vRC.release();
      this.vRC = null;
      AppMethodBeat.o(107647);
      return;
    }
    label364:
    AppMethodBeat.o(107647);
  }
  
  private void atx()
  {
    AppMethodBeat.i(107651);
    if (this.vRD == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.vRD.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.vRD.dequeueOutputBuffer(localBufferInfo, 20000L);
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
          arrayOfByteBuffer2 = this.vRD.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.hjk = this.vRD.getOutputFormat();
          ad.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.hjk });
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
        l(localByteBuffer, localBufferInfo);
      }
      this.vRD.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    ad.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.vRD != null)
    {
      this.vRD.stop();
      this.vRD.release();
      this.vRD = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.vRD == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.vRD.getInputBuffers();
    int j = this.vRD.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      ad.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      atx();
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
      dnH();
    }
    for (;;)
    {
      if (this.vRD == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        ad.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.vRD.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        atx();
        AppMethodBeat.o(107650);
        return;
        this.vRD.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void dnG()
  {
    AppMethodBeat.i(107649);
    if ((this.vRD != null) && (this.vRE) && (!this.vRG))
    {
      this.vRC.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.hjk = new MediaFormat();
      this.hjk.setString("mime", "audio/mp4a-latm");
      this.hjk.setInteger("aac-profile", 2);
      this.hjk.setInteger("sample-rate", this.ivO.audioSampleRate);
      this.hjk.setInteger("channel-count", 1);
      this.hjk.setInteger("bitrate", this.ivO.audioBitrate);
      this.hjk.setInteger("max-input-size", 16384);
      this.vRD = z.q(this.mime, false);
      this.vRD.a(this.hjk, null, 1);
      this.vRD.start();
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
  
  private void dnH()
  {
    AppMethodBeat.i(107653);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.vRD != null)
          {
            ad.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.vRD.stop();
            g.this.vRD.release();
            g.this.vRD = null;
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
  
  private static void l(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(107652);
    if (paramByteBuffer != null) {
      MP4MuxerJNI.writeAACData(0, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(107652);
  }
  
  public final void dnF()
  {
    AppMethodBeat.i(107646);
    this.vRG = false;
    this.vRH = false;
    for (;;)
    {
      try
      {
        if ((this.vRC == null) || (this.ddy == null))
        {
          ad.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.vRC.getInputBuffers();
        int j = this.vRC.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          ad.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          ato();
        }
        int k;
        long l;
        if (j >= 0)
        {
          ad.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.ddy.readSampleData((ByteBuffer)localObject, 0);
          l = this.ddy.gdS.getSampleTime();
          this.ddy.gdS.advance();
          ad.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.hiy * 1000L) && (l > 0L) && (k > 0)) {
            break label351;
          }
          ad.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.vRH = true;
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.vRC != null)
                {
                  ad.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.vRC.stop();
                  g.this.vRC.release();
                  g.this.vRC = null;
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
          if (this.vRC == null) {
            break label344;
          }
          if (i != 0)
          {
            ad.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.vRC.a(j, k, l, 4);
          }
        }
        else
        {
          ato();
          if (!this.vRH) {
            continue;
          }
          localObject = this.vRD;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.vRC.a(j, k, l, 0);
        continue;
        AppMethodBeat.o(107646);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107646);
        return;
      }
      label344:
      return;
      label351:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */