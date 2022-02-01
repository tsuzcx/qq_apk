package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
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
  private long endTimeMs;
  MediaFormat ieU;
  VideoTransPara jtV;
  private c jto;
  MediaFormat jtq;
  String mime;
  private long startTimeMs;
  z zyo;
  z zyp;
  boolean zyq;
  List<byte[]> zyr;
  private boolean zys;
  private boolean zyt;
  private byte[] zyu;
  private HandlerThread zyv;
  private MMHandler zyw;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.mime = null;
    this.zyq = true;
    this.zyr = null;
    this.zys = false;
    this.zyt = false;
    this.zyv = null;
    this.zyw = null;
    this.jto = paramc;
    this.jtq = paramMediaFormat;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.jtV = paramVideoTransPara;
    this.mime = paramMediaFormat.getString("mime");
    this.zyr = new ArrayList();
    Log.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.mime, paramMediaFormat, paramVideoTransPara });
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
    Log.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zyt) });
    if (this.zyq)
    {
      if (!this.zys)
      {
        ekv();
        this.zys = true;
      }
      if (this.zyu == null)
      {
        this.zyu = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.zyu, 0, paramByteBuffer.remaining());
      }
      c(this.zyu, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.zyr.add(arrayOfByte);
    if ((this.zyt) || (paramBoolean)) {
      try
      {
        this.zyo.stop();
        this.zyo.release();
        ekv();
        this.zys = true;
        paramByteBuffer = this.zyr.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.zyr.size() - 1) {
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
  
  private void aMe()
  {
    AppMethodBeat.i(107647);
    if (this.zyo == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.zyo.getOutputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.zyo.dequeueOutputBuffer(localBufferInfo, 20000L);
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
        arrayOfByteBuffer2 = this.zyo.getOutputBuffers();
      }
      else if (i == -2)
      {
        this.jtq = this.zyo.getOutputFormat();
        Log.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.jtq });
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
      this.zyo.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.zyo == null) {
        break label364;
      }
      this.zyo.stop();
      this.zyo.release();
      this.zyo = null;
      AppMethodBeat.o(107647);
      return;
    }
    label364:
    AppMethodBeat.o(107647);
  }
  
  private void aMn()
  {
    AppMethodBeat.i(107651);
    if (this.zyp == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.zyp.getOutputBuffers();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.zyp.dequeueOutputBuffer(localBufferInfo, 20000L);
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
          arrayOfByteBuffer2 = this.zyp.getOutputBuffers();
        }
        else if (i == -2)
        {
          this.ieU = this.zyp.getOutputFormat();
          Log.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.ieU });
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
        l(localByteBuffer, localBufferInfo);
      }
      this.zyp.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.zyp != null)
    {
      this.zyp.stop();
      this.zyp.release();
      this.zyp = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.zyp == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.zyp.getInputBuffers();
    int j = this.zyp.dequeueInputBuffer(20000L);
    if (j < 0)
    {
      Log.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      aMn();
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
      ekw();
    }
    for (;;)
    {
      if (this.zyp == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.zyp.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        aMn();
        AppMethodBeat.o(107650);
        return;
        this.zyp.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void ekv()
  {
    AppMethodBeat.i(107649);
    if ((this.zyp != null) && (this.zyq) && (!this.zys))
    {
      this.zyo.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.ieU = new MediaFormat();
      this.ieU.setString("mime", "audio/mp4a-latm");
      this.ieU.setInteger("aac-profile", 2);
      this.ieU.setInteger("sample-rate", this.jtV.audioSampleRate);
      this.ieU.setInteger("channel-count", 1);
      this.ieU.setInteger("bitrate", this.jtV.audioBitrate);
      this.ieU.setInteger("max-input-size", 16384);
      this.zyp = z.q(this.mime, false);
      this.zyp.a(this.ieU, null, 1);
      this.zyp.start();
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
  
  private void ekw()
  {
    AppMethodBeat.i(107653);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.zyp != null)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.zyp.stop();
            g.this.zyp.release();
            g.this.zyp = null;
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
  
  private static void l(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(107652);
    if (paramByteBuffer != null) {
      MP4MuxerJNI.writeAACData(0, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(107652);
  }
  
  public final void eku()
  {
    AppMethodBeat.i(107646);
    this.zys = false;
    this.zyt = false;
    for (;;)
    {
      try
      {
        if ((this.zyo == null) || (this.jto == null))
        {
          Log.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.zyo.getInputBuffers();
        int j = this.zyo.dequeueInputBuffer(20000L);
        if (j < 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          aMe();
        }
        int k;
        long l;
        if (j >= 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.jto.readSampleData((ByteBuffer)localObject, 0);
          l = this.jto.gLF.getSampleTime();
          this.jto.gLF.advance();
          Log.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.endTimeMs * 1000L) && (l > 0L) && (k > 0)) {
            break label351;
          }
          Log.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.zyt = true;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.zyo != null)
                {
                  Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.zyo.stop();
                  g.this.zyo.release();
                  g.this.zyo = null;
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
          if (this.zyo == null) {
            break label344;
          }
          if (i != 0)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.zyo.a(j, k, l, 4);
          }
        }
        else
        {
          aMe();
          if (!this.zyt) {
            continue;
          }
          localObject = this.zyp;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.zyo.a(j, k, l, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */