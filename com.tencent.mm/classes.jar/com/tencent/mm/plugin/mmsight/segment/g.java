package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private MMHandler KZA;
  aa KZs;
  aa KZt;
  boolean KZu;
  List<byte[]> KZv;
  private boolean KZw;
  private boolean KZx;
  private byte[] KZy;
  private HandlerThread KZz;
  String cBw;
  private long endTimeMs;
  MediaFormat nzt;
  VideoTransPara pcW;
  private c pcp;
  MediaFormat pcr;
  private long startTimeMs;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.cBw = null;
    this.KZu = true;
    this.KZv = null;
    this.KZw = false;
    this.KZx = false;
    this.KZz = null;
    this.KZA = null;
    this.pcp = paramc;
    this.pcr = paramMediaFormat;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.pcW = paramVideoTransPara;
    this.cBw = paramMediaFormat.getString("mime");
    this.KZv = new ArrayList();
    Log.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.cBw, paramMediaFormat, paramVideoTransPara });
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
    Log.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.KZx) });
    if (this.KZu)
    {
      if (!this.KZw)
      {
        gcV();
        this.KZw = true;
      }
      if (this.KZy == null)
      {
        this.KZy = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.KZy, 0, paramByteBuffer.remaining());
      }
      c(this.KZy, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.KZv.add(arrayOfByte);
    if ((this.KZx) || (paramBoolean)) {
      try
      {
        this.KZs.stop();
        this.KZs.release();
        gcV();
        this.KZw = true;
        paramByteBuffer = this.KZv.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.KZv.size() - 1) {
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
          Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", paramByteBuffer, "", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    label278:
    AppMethodBeat.o(107648);
  }
  
  private void boU()
  {
    AppMethodBeat.i(107647);
    if (this.KZs == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.KZs.aPE();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.KZs.dequeueOutputBuffer(localBufferInfo, 20000L);
        Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        if (i == -1)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
          AppMethodBeat.o(107647);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainDecoder error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107647);
        return;
      }
      if (i == -3)
      {
        arrayOfByteBuffer2 = this.KZs.aPE();
      }
      else if (i == -2)
      {
        this.pcr = this.KZs.getOutputFormat();
        Log.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.pcr });
      }
      else
      {
        if (i >= 0) {
          break;
        }
        Log.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    Log.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
    ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
    if (localByteBuffer == null)
    {
      Log.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
      AppMethodBeat.o(107647);
      return;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      Log.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
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
      this.KZs.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.KZs == null) {
        break label364;
      }
      this.KZs.stop();
      this.KZs.release();
      this.KZs = null;
      AppMethodBeat.o(107647);
      return;
    }
    label364:
    AppMethodBeat.o(107647);
  }
  
  private void bpk()
  {
    AppMethodBeat.i(107651);
    if (this.KZt == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.KZt.aPE();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.KZt.dequeueOutputBuffer(localBufferInfo, 20000L);
          Log.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            Log.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
            AppMethodBeat.o(107651);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107651);
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer2 = this.KZt.aPE();
        }
        else if (i == -2)
        {
          this.nzt = this.KZt.getOutputFormat();
          Log.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.nzt });
        }
        else
        {
          if (i >= 0) {
            break;
          }
          Log.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      Log.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
      ByteBuffer localByteBuffer = arrayOfByteBuffer2[i];
      if (localByteBuffer == null)
      {
        Log.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        AppMethodBeat.o(107651);
        return;
      }
      if (localBufferInfo.size > 0)
      {
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        j(localByteBuffer, localBufferInfo);
      }
      this.KZt.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.KZt != null)
    {
      this.KZt.stop();
      this.KZt.release();
      this.KZt = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.KZt == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.KZt.aPD();
    int j = this.KZt.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      Log.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      bpk();
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
      Log.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
      i = 1;
      gcW();
    }
    for (;;)
    {
      if (this.KZt == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.KZt.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        bpk();
        AppMethodBeat.o(107650);
        return;
        this.KZt.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void gcV()
  {
    AppMethodBeat.i(107649);
    if ((this.KZt != null) && (this.KZu) && (!this.KZw))
    {
      this.KZs.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.nzt = new MediaFormat();
      this.nzt.setString("mime", "audio/mp4a-latm");
      this.nzt.setInteger("aac-profile", 2);
      this.nzt.setInteger("sample-rate", this.pcW.audioSampleRate);
      this.nzt.setInteger("channel-count", 1);
      this.nzt.setInteger("bitrate", this.pcW.audioBitrate);
      this.nzt.setInteger("max-input-size", 16384);
      this.KZt = aa.u(this.cBw, false);
      this.KZt.a(this.nzt, null, 1);
      this.KZt.start();
      Log.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
      AppMethodBeat.o(107649);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107649);
    }
  }
  
  private void gcW()
  {
    AppMethodBeat.i(107653);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.KZt != null)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.KZt.stop();
            g.this.KZt.release();
            g.this.KZt = null;
          }
          AppMethodBeat.o(107644);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(107644);
        }
      }
    }, 500L);
    AppMethodBeat.o(107653);
  }
  
  private static void j(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(107652);
    if (paramByteBuffer != null) {
      MP4MuxerJNI.writeAACData(0, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(107652);
  }
  
  public final void gcU()
  {
    AppMethodBeat.i(107646);
    this.KZw = false;
    this.KZx = false;
    for (;;)
    {
      try
      {
        if ((this.KZs == null) || (this.pcp == null))
        {
          Log.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.KZs.aPD();
        int j = this.KZs.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          boU();
        }
        int k;
        long l;
        if (j >= 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.pcp.readSampleData((ByteBuffer)localObject, 0);
          l = this.pcp.lZm.getSampleTime();
          this.pcp.lZm.advance();
          Log.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.endTimeMs * 1000L) && (l > 0L) && (k > 0)) {
            break label351;
          }
          Log.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.KZx = true;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.KZs != null)
                {
                  Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.KZs.stop();
                  g.this.KZs.release();
                  g.this.KZs = null;
                }
                AppMethodBeat.o(107643);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(107643);
              }
            }
          }, 500L);
          i = 1;
          if (this.KZs == null) {
            break label344;
          }
          if (i != 0)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.KZs.a(j, k, l, 4);
          }
        }
        else
        {
          boU();
          if (!this.KZx) {
            continue;
          }
          localObject = this.KZt;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.KZs.a(j, k, l, 0);
        continue;
        AppMethodBeat.o(107646);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException, "startTranscodeBlockLoop error: %s", new Object[] { localException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */