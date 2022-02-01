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
  aa FdJ;
  aa FdK;
  boolean FdL;
  List<byte[]> FdM;
  private boolean FdN;
  private boolean FdO;
  private byte[] FdP;
  private HandlerThread FdQ;
  private MMHandler FdR;
  String aFM;
  private long endTimeMs;
  MediaFormat kTI;
  private c miS;
  MediaFormat miU;
  VideoTransPara mjz;
  private long startTimeMs;
  
  public g(c paramc, MediaFormat paramMediaFormat, long paramLong1, long paramLong2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107645);
    this.aFM = null;
    this.FdL = true;
    this.FdM = null;
    this.FdN = false;
    this.FdO = false;
    this.FdQ = null;
    this.FdR = null;
    this.miS = paramc;
    this.miU = paramMediaFormat;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.mjz = paramVideoTransPara;
    this.aFM = paramMediaFormat.getString("mime");
    this.FdM = new ArrayList();
    Log.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.aFM, paramMediaFormat, paramVideoTransPara });
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
    Log.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FdO) });
    if (this.FdL)
    {
      if (!this.FdN)
      {
        eUd();
        this.FdN = true;
      }
      if (this.FdP == null)
      {
        this.FdP = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.FdP, 0, paramByteBuffer.remaining());
      }
      c(this.FdP, paramBufferInfo.presentationTimeUs, paramBoolean);
      AppMethodBeat.o(107648);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, paramByteBuffer.remaining());
    this.FdM.add(arrayOfByte);
    if ((this.FdO) || (paramBoolean)) {
      try
      {
        this.FdJ.stop();
        this.FdJ.release();
        eUd();
        this.FdN = true;
        paramByteBuffer = this.FdM.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramByteBuffer.hasNext()) {
            break label278;
          }
          arrayOfByte = (byte[])paramByteBuffer.next();
          long l = paramBufferInfo.presentationTimeUs;
          if (i < this.FdM.size() - 1) {
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
  
  private void aUD()
  {
    AppMethodBeat.i(107651);
    if (this.FdK == null)
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
          ByteBuffer[] arrayOfByteBuffer1 = this.FdK.avk();
          localBufferInfo = new MediaCodec.BufferInfo();
          i = this.FdK.a(localBufferInfo, 20000L);
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
          arrayOfByteBuffer2 = this.FdK.avk();
        }
        else if (i == -2)
        {
          this.kTI = this.FdK.avi();
          Log.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[] { this.kTI });
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
      this.FdK.releaseOutputBuffer(i, false);
    } while ((localBufferInfo.flags & 0x4) == 0);
    Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
    if (this.FdK != null)
    {
      this.FdK.stop();
      this.FdK.release();
      this.FdK = null;
      AppMethodBeat.o(107651);
      return;
    }
    AppMethodBeat.o(107651);
  }
  
  private void aUt()
  {
    AppMethodBeat.i(107647);
    if (this.FdJ == null)
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
        ByteBuffer[] arrayOfByteBuffer1 = this.FdJ.avk();
        localBufferInfo = new MediaCodec.BufferInfo();
        i = this.FdJ.a(localBufferInfo, 20000L);
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
        arrayOfByteBuffer2 = this.FdJ.avk();
      }
      else if (i == -2)
      {
        this.miU = this.FdJ.avi();
        Log.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[] { this.miU });
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
        break label372;
      }
    }
    label372:
    for (boolean bool = true;; bool = false)
    {
      a(localByteBuffer, localBufferInfo, bool);
      this.FdJ.releaseOutputBuffer(i, false);
      if ((localBufferInfo.flags & 0x4) == 0) {
        break;
      }
      Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
      if (this.FdJ == null) {
        break label377;
      }
      this.FdJ.stop();
      this.FdJ.release();
      this.FdJ = null;
      AppMethodBeat.o(107647);
      return;
    }
    label377:
    AppMethodBeat.o(107647);
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107650);
    if ((this.FdK == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(107650);
      return;
    }
    Object localObject = this.FdK.avj();
    int j = this.FdK.EX(20000L);
    if (j < 0)
    {
      Log.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
      aUD();
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
      eUe();
    }
    for (;;)
    {
      if (this.FdK == null)
      {
        AppMethodBeat.o(107650);
        return;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
        this.FdK.a(j, paramArrayOfByte.length, paramLong, 4);
      }
      for (;;)
      {
        aUD();
        AppMethodBeat.o(107650);
        return;
        this.FdK.a(j, paramArrayOfByte.length, paramLong, 0);
      }
      label181:
      i = 0;
    }
  }
  
  private void eUd()
  {
    AppMethodBeat.i(107649);
    if ((this.FdK != null) && (this.FdL) && (!this.FdN))
    {
      this.FdJ.start();
      AppMethodBeat.o(107649);
      return;
    }
    try
    {
      this.kTI = new MediaFormat();
      this.kTI.setString("mime", "audio/mp4a-latm");
      this.kTI.setInteger("aac-profile", 2);
      this.kTI.setInteger("sample-rate", this.mjz.audioSampleRate);
      this.kTI.setInteger("channel-count", 1);
      this.kTI.setInteger("bitrate", this.mjz.audioBitrate);
      this.kTI.setInteger("max-input-size", 16384);
      this.FdK = aa.t(this.aFM, false);
      this.FdK.a(this.kTI, null, 1);
      this.FdK.start();
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
  
  private void eUe()
  {
    AppMethodBeat.i(107653);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107644);
        try
        {
          if (g.this.FdK != null)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
            g.this.FdK.stop();
            g.this.FdK.release();
            g.this.FdK = null;
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
  
  public final void eUc()
  {
    AppMethodBeat.i(107646);
    this.FdN = false;
    this.FdO = false;
    for (;;)
    {
      try
      {
        if ((this.FdJ == null) || (this.miS == null))
        {
          Log.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
          AppMethodBeat.o(107646);
          return;
        }
        Object localObject = this.FdJ.avj();
        int j = this.FdJ.EX(20000L);
        if (j < 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
          aUt();
        }
        int k;
        long l;
        if (j >= 0)
        {
          Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[] { Integer.valueOf(j) });
          localObject = localObject[j];
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).position(0);
          k = this.miS.readSampleData((ByteBuffer)localObject, 0);
          l = this.miS.jvU.getSampleTime();
          this.miS.jvU.advance();
          Log.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          if ((l < this.endTimeMs * 1000L) && (l > 0L) && (k > 0)) {
            break label351;
          }
          Log.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
          this.FdO = true;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107643);
              try
              {
                if (g.this.FdJ != null)
                {
                  Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                  g.this.FdJ.stop();
                  g.this.FdJ.release();
                  g.this.FdJ = null;
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
          if (this.FdJ == null) {
            break label344;
          }
          if (i != 0)
          {
            Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
            this.FdJ.a(j, k, l, 4);
          }
        }
        else
        {
          aUt();
          if (!this.FdO) {
            continue;
          }
          localObject = this.FdK;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(107646);
          return;
        }
        this.FdJ.a(j, k, l, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g
 * JD-Core Version:    0.7.0.1
 */