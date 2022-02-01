package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private c deA;
  MediaFormat hlY;
  private long hlm;
  VideoTransPara iyH;
  MediaFormat iya;
  String mime;
  private long startTimeMs;
  z wdG;
  z wdH;
  boolean wdI;
  List<byte[]> wdJ;
  private boolean wdK;
  private boolean wdL;
  private byte[] wdM;
  private HandlerThread wdN;
  private aq wdO;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.mime = null;
    this.wdI = true;
    this.wdJ = null;
    this.wdK = false;
    this.wdL = false;
    this.wdN = null;
    this.wdO = null;
    this.deA = paramc;
    this.iya = paramMediaFormat;
    this.startTimeMs = paramLong1;
    this.hlm = paramLong2;
    this.iyH = paramVideoTransPara;
    this.mime = paramMediaFormat.getString("mime");
    this.wdJ = new ArrayList();
    ae.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.mime, paramMediaFormat, paramVideoTransPara });
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
    ae.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.wdL) });
    if (this.wdI)
    {
      if (!this.wdK)
      {
        dqE();
        this.wdK = true;
      }
      if (this.wdM == null)
      {
        this.wdM = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.wdM, 0, paramByteBuffer.remaining());
      }
      c(this.wdM, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.wdJ.add(arrayOfByte);
    if ((this.wdL) || (paramBoolean)) {
      try
      {
        this.wdG.stop();
        this.wdG.release();
        dqE();
        this.wdK = true;
        paramByteBuffer = this.wdJ.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.wdJ.size() - 1) {
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
          ae.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    label278:
    AppMethodBeat.o(107648);
  }
  
  private void atD()
  {
    AppMethodBeat.i(107647);
    if (this.wdG == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.wdG.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.wdG.dequeueOutputBuffer(localBufferInfo, 20000L);
        ae.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          ae.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          AppMethodBeat.o(107647);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107647);
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.wdG.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.iya = this.wdG.getOutputFormat();
        ae.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.iya });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        ae.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    ae.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      ae.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      AppMethodBeat.o(107647);
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      ae.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
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
      this.wdG.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      ae.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.wdG == null) {
        break label364;
      }
      this.wdG.stop();
      this.wdG.release();
      this.wdG = null;
      AppMethodBeat.o(107647);
      return;
    }
    label364:
    AppMethodBeat.o(107647);
  }
  
  private void atM()
  {
    AppMethodBeat.i(107651);
    if (this.wdH == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.wdH.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.wdH.dequeueOutputBuffer(localBufferInfo, 20000L);
          ae.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            ae.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
            AppMethodBeat.o(107651);
            return;
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107651);
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer2 = this.wdH.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.hlY = this.wdH.getOutputFormat();
          ae.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.hlY });
        }
        else
        {
          if (i >= 0) {
            break;
          }
          ae.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      ae.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
      ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
      if (localByteBuffer == null)
      {
        ae.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        AppMethodBeat.o(107651);
        return;
      }
      if (localBufferInfo.size > 0)
      {
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        l(localByteBuffer, localBufferInfo);
      }
      this.wdH.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    ae.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.wdH != null)
    {
      this.wdH.stop();
      this.wdH.release();
      this.wdH = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.wdH == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.wdH.getInputBuffers();
    int j = this.wdH.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      ae.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      atM();
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
      ae.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
      i = 1;
      dqF();
    }
    for (;;)
    {
      if (this.wdH == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        ae.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.wdH.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        atM();
        AppMethodBeat.o(107650);
        return;
        this.wdH.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void dqE()
  {
    AppMethodBeat.i(107649);
    if ((this.wdH != null) && (this.wdI) && (!this.wdK))
    {
      this.wdG.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.hlY = new MediaFormat();
      this.hlY.setString("mime", "audio/mp4a-latm");
      this.hlY.setInteger("aac-profile", 2);
      this.hlY.setInteger("sample-rate", this.iyH.audioSampleRate);
      this.hlY.setInteger("channel-count", 1);
      this.hlY.setInteger("bitrate", this.iyH.audioBitrate);
      this.hlY.setInteger("max-input-size", 16384);
      this.wdH = z.q(this.mime, false);
      this.wdH.a(this.hlY, null, 1);
      this.wdH.start();
      ae.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      AppMethodBeat.o(107649);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107649);
    }
  }
  
  private void dqF()
  {
    AppMethodBeat.i(107653);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.wdH != null)
          {
            ae.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.wdH.stop();
            g.this.wdH.release();
            g.this.wdH = null;
          }
          AppMethodBeat.o(107644);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
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
  
  public final void dqD()
  {
    AppMethodBeat.i(107646);
    this.wdK = false;
    this.wdL = false;
    for (;;)
    {
      try
      {
        if ((this.wdG == null) || (this.deA == null))
        {
          ae.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.wdG.getInputBuffers();
        int j = this.wdG.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          ae.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          atD();
        }
        int k;
        long l;
        if (j >= 0)
        {
          ae.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.deA.readSampleData((ByteBuffer)localObject, 0);
          l = this.deA.gga.getSampleTime();
          this.deA.gga.advance();
          ae.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.hlm * 1000L) && (l > 0L) && (k > 0)) {
            break label351;
          }
          ae.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.wdL = true;
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.wdG != null)
                {
                  ae.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.wdG.stop();
                  g.this.wdG.release();
                  g.this.wdG = null;
                }
                AppMethodBeat.o(107643);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(107643);
              }
            }
          }, 500L);
          i = 1;
          if (this.wdG == null) {
            break label344;
          }
          if (i != 0)
          {
            ae.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.wdG.a(j, k, l, 4);
          }
        }
        else
        {
          atD();
          if (!this.wdL) {
            continue;
          }
          localObject = this.wdH;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.wdG.a(j, k, l, 0);
        continue;
        AppMethodBeat.o(107646);
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
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