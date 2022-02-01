package com.tencent.mm.plugin.u;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;

public final class l
  extends i
{
  boolean EXN = false;
  private boolean EXO = false;
  boolean EXP = false;
  long EXQ = -1L;
  private long frB = 0L;
  float pvh = 1.0F;
  Surface surface;
  private int videoHeight;
  private int videoWidth;
  
  public l(h paramh, MMHandler paramMMHandler)
  {
    super(paramh, paramMMHandler);
  }
  
  final boolean a(long paramLong1, long paramLong2, aa paramaa, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(133954);
    paramByteBuffer = info();
    int i = this.state;
    long l1 = paramBufferInfo.presentationTimeUs;
    if ((paramBufferInfo.flags & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d, pts:%s, keyframe:%s, flags:%s", new Object[] { paramByteBuffer, Integer.valueOf(i), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(paramBufferInfo.flags) });
      if (!e.WN(this.state)) {
        break;
      }
      Log.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { info() });
      paramaa.releaseOutputBuffer(paramInt, true);
      setState(4);
      AppMethodBeat.o(133954);
      return true;
    }
    if (e.WM(this.state))
    {
      paramLong2 = paramBufferInfo.presentationTimeUs / 1000L;
      l1 = paramLong1 - paramLong2;
      Log.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[] { info(), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
      if (l1 <= 30L)
      {
        i = 1;
        if (i == 0) {
          break label311;
        }
        Log.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[] { info() });
        paramaa.releaseOutputBuffer(paramInt, true);
        if (this.EXO)
        {
          setState(7);
          this.EXO = false;
        }
        this.EXO = true;
      }
      for (;;)
      {
        AppMethodBeat.o(133954);
        return true;
        i = 0;
        break;
        label311:
        paramaa.releaseOutputBuffer(paramInt, false);
      }
    }
    if (!e.WO(this.state))
    {
      Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133954);
      return false;
    }
    l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = ((float)l1 / this.pvh - (float)paramLong1 - (float)l3);
    Log.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { info(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      Log.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { info() });
      paramaa.releaseOutputBuffer(paramInt, false);
      this.EXa.EWU = 0L;
      AppMethodBeat.o(133954);
      return true;
    }
    if (l4 < 30L)
    {
      this.EXa.EWR = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      label562:
      if (!e.WO(this.state))
      {
        Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
        AppMethodBeat.o(133954);
        return false;
      }
      if ((Math.abs(l1 - this.frB) > 1000L) || (this.frB <= 0L))
      {
        Log.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(l1) });
        this.frB = l1;
      }
      paramaa.releaseOutputBuffer(paramInt, true);
      AppMethodBeat.o(133954);
      return true;
      Log.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[] { info() });
      AppMethodBeat.o(133954);
      return false;
    }
    catch (Exception paramByteBuffer)
    {
      break label562;
    }
  }
  
  final boolean a(aa paramaa)
  {
    AppMethodBeat.i(133955);
    if (paramaa == null)
    {
      AppMethodBeat.o(133955);
      return false;
    }
    if (this.surface == null) {
      Log.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[] { info() });
    }
    for (this.EXN = false;; this.EXN = true)
    {
      Log.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { info() });
      Log.i("MicroMsg.VideoTrackDataSource", "%s before prepare init decoder, surface valid: %s", new Object[] { info(), Boolean.valueOf(this.surface.isValid()) });
      paramaa.a(eSS(), this.surface, 0);
      this.frB = 0L;
      AppMethodBeat.o(133955);
      return false;
    }
  }
  
  protected final boolean aA(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133959);
    Log.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.EXa.uXX) });
    if ((this.EXa.uXX) && (paramInt == 1) && (this.EXQ != paramLong))
    {
      boolean bool = ai(paramLong, -1L);
      this.EXQ = paramLong;
      AppMethodBeat.o(133959);
      return bool;
    }
    AppMethodBeat.o(133959);
    return false;
  }
  
  protected final void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(133958);
    super.b(paramMediaFormat, paramString, paramInt);
    this.videoHeight = paramMediaFormat.getInteger("height");
    this.videoWidth = paramMediaFormat.getInteger("width");
    if (paramMediaFormat.containsKey("rotation-degrees")) {
      paramInt = paramMediaFormat.getInteger("rotation-degrees");
    }
    for (int i = 1;; i = 0)
    {
      if ((Math.abs(paramInt) == 90) || (Math.abs(paramInt) == 270))
      {
        int j = this.videoWidth;
        this.videoWidth = this.videoHeight;
        this.videoHeight = j;
      }
      if (i != 0) {
        paramInt = 0;
      }
      this.EXb.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(paramInt)).sendToTarget();
      Log.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { info(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133958);
      return;
      paramInt = SightVideoJNI.getMp4RotateVFS(this.path);
      Log.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { info(), Integer.valueOf(paramInt) });
    }
  }
  
  @TargetApi(23)
  final void eSW()
  {
    AppMethodBeat.i(133956);
    try
    {
      if (this.kSN != null)
      {
        aa localaa = this.kSN;
        Surface localSurface = this.surface;
        try
        {
          MediaCodecProxyUtils.b.qS(81);
          localaa.jtS.setOutputSurface(localSurface);
          MediaCodecProxyUtils.b.qS(82);
          AppMethodBeat.o(133956);
          return;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy setOutputSurface", new Object[0]);
          aa.a(34, localException2, localaa.jtT);
          AppMethodBeat.o(133956);
          throw localException2;
        }
      }
      AppMethodBeat.o(133956);
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.VideoTrackDataSource", localException1, "%s change surface23 error [%s]", new Object[] { info(), localException1.toString() });
      eSX();
      AppMethodBeat.o(133956);
      return;
    }
  }
  
  final void eSX()
  {
    AppMethodBeat.i(133957);
    Log.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { info() });
    if (this.kSN != null)
    {
      releaseDecoder();
      ai(this.EXa.EWR, -1L);
      eSQ();
    }
    AppMethodBeat.o(133957);
  }
  
  final String type()
  {
    return "video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.l
 * JD-Core Version:    0.7.0.1
 */