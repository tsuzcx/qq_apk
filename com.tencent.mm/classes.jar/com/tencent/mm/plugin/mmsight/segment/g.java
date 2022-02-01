package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private long bvf;
  private c cSi;
  private long gOz;
  MediaFormat gQS;
  MediaFormat ibK;
  VideoTransPara ics;
  String mime;
  private HandlerThread uOA;
  private ao uOB;
  z uOt;
  z uOu;
  boolean uOv;
  List<byte[]> uOw;
  private boolean uOx;
  private boolean uOy;
  private byte[] uOz;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.mime = null;
    this.uOv = true;
    this.uOw = null;
    this.uOx = false;
    this.uOy = false;
    this.uOA = null;
    this.uOB = null;
    this.cSi = paramc;
    this.ibK = paramMediaFormat;
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    this.ics = paramVideoTransPara;
    this.mime = paramMediaFormat.getString("mime");
    this.uOw = new ArrayList();
    ac.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.mime, paramMediaFormat, paramVideoTransPara });
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
    ac.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uOy) });
    if (this.uOv)
    {
      if (!this.uOx)
      {
        dei();
        this.uOx = true;
      }
      if (this.uOz == null)
      {
        this.uOz = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.uOz, 0, paramByteBuffer.remaining());
      }
      c(this.uOz, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.uOw.add(arrayOfByte);
    if ((this.uOy) || (paramBoolean)) {
      try
      {
        this.uOt.stop();
        this.uOt.release();
        dei();
        this.uOx = true;
        paramByteBuffer = this.uOw.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.uOw.size() - 1) {
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
          ac.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    label278:
    AppMethodBeat.o(107648);
  }
  
  private void aqJ()
  {
    AppMethodBeat.i(107651);
    if (this.uOu == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.uOu.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.uOu.dequeueOutputBuffer(localBufferInfo, 20000L);
          ac.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ac.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
            AppMethodBeat.o(107651);
            return;
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107651);
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer2 = this.uOu.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.gQS = this.uOu.getOutputFormat();
          ac.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.gQS });
        }
        else
        {
          if (i >= 0) {
            break;
          }
          ac.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      ac.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
      ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
      if (localByteBuffer == null)
      {
        ac.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        AppMethodBeat.o(107651);
        return;
      }
      if (localBufferInfo.size > 0)
      {
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        k(localByteBuffer, localBufferInfo);
      }
      this.uOu.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    ac.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.uOu != null)
    {
      this.uOu.stop();
      this.uOu.release();
      this.uOu = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void aqt()
  {
    AppMethodBeat.i(107647);
    if (this.uOt == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.uOt.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.uOt.dequeueOutputBuffer(localBufferInfo, 20000L);
        ac.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          ac.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          AppMethodBeat.o(107647);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107647);
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.uOt.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.ibK = this.uOt.getOutputFormat();
        ac.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.ibK });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        ac.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    ac.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      ac.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      AppMethodBeat.o(107647);
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      ac.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
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
      this.uOt.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      ac.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.uOt == null) {
        break label377;
      }
      this.uOt.stop();
      this.uOt.release();
      this.uOt = null;
      AppMethodBeat.o(107647);
      return;
    }
    label377:
    AppMethodBeat.o(107647);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.uOu == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.uOu.getInputBuffers();
    int j = this.uOu.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      ac.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      aqJ();
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
      ac.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
      i = 1;
      dej();
    }
    for (;;)
    {
      if (this.uOu == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        ac.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.uOu.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        aqJ();
        AppMethodBeat.o(107650);
        return;
        this.uOu.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void dei()
  {
    AppMethodBeat.i(107649);
    if ((this.uOu != null) && (this.uOv) && (!this.uOx))
    {
      this.uOt.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.gQS = new MediaFormat();
      this.gQS.setString("mime", "audio/mp4a-latm");
      this.gQS.setInteger("aac-profile", 2);
      this.gQS.setInteger("sample-rate", this.ics.audioSampleRate);
      this.gQS.setInteger("channel-count", 1);
      this.gQS.setInteger("bitrate", this.ics.audioBitrate);
      this.gQS.setInteger("max-input-size", 16384);
      this.uOu = z.q(this.mime, false);
      this.uOu.a(this.gQS, null, 1);
      this.uOu.start();
      ac.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      AppMethodBeat.o(107649);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107649);
    }
  }
  
  private void dej()
  {
    AppMethodBeat.i(107653);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.uOu != null)
          {
            ac.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.uOu.stop();
            g.this.uOu.release();
            g.this.uOu = null;
          }
          AppMethodBeat.o(107644);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
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
  
  public final void deh()
  {
    AppMethodBeat.i(107646);
    this.uOx = false;
    this.uOy = false;
    for (;;)
    {
      try
      {
        if ((this.uOt == null) || (this.cSi == null))
        {
          ac.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.uOt.getInputBuffers();
        int j = this.uOt.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          ac.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          aqt();
        }
        int k;
        long l;
        if (j >= 0)
        {
          ac.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.cSi.j((ByteBuffer)localObject);
          l = this.cSi.fKr.getSampleTime();
          this.cSi.fKr.advance();
          ac.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.gOz * 1000L) && (l > 0L) && (k > 0)) {
            break label350;
          }
          ac.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.uOy = true;
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.uOt != null)
                {
                  ac.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.uOt.stop();
                  g.this.uOt.release();
                  g.this.uOt = null;
                }
                AppMethodBeat.o(107643);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(107643);
              }
            }
          }, 500L);
          i = 1;
          if (this.uOt == null) {
            break label343;
          }
          if (i != 0)
          {
            ac.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.uOt.a(j, k, l, 4);
          }
        }
        else
        {
          aqt();
          if (!this.uOy) {
            continue;
          }
          localObject = this.uOu;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.uOt.a(j, k, l, 0);
        continue;
        AppMethodBeat.o(107646);
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
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