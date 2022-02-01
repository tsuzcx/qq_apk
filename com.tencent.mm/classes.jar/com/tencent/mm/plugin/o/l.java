package com.tencent.mm.plugin.o;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.nio.ByteBuffer;

public final class l
  extends i
{
  private long cVi = 0L;
  float kOZ = 1.0F;
  Surface surface;
  boolean uJa = false;
  private boolean uJb = false;
  boolean uJc = false;
  long uJd = -1L;
  private int videoHeight;
  private int videoWidth;
  
  public l(h paramh, ao paramao)
  {
    super(paramh, paramao);
  }
  
  final boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(133954);
    paramByteBuffer = info();
    int i = this.state;
    long l1 = paramBufferInfo.presentationTimeUs;
    if ((paramBufferInfo.flags & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d, pts:%s, keyframe:%s, flags:%s", new Object[] { paramByteBuffer, Integer.valueOf(i), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(paramBufferInfo.flags) });
      if (!e.IB(this.state)) {
        break;
      }
      ac.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { info() });
      paramz.releaseOutputBuffer(paramInt, true);
      setState(4);
      AppMethodBeat.o(133954);
      return true;
    }
    if (e.IA(this.state))
    {
      paramLong2 = paramBufferInfo.presentationTimeUs / 1000L;
      l1 = paramLong1 - paramLong2;
      ac.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[] { info(), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
      if (l1 <= 30L)
      {
        i = 1;
        if (i == 0) {
          break label311;
        }
        ac.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[] { info() });
        paramz.releaseOutputBuffer(paramInt, true);
        if (this.uJb)
        {
          setState(7);
          this.uJb = false;
        }
        this.uJb = true;
      }
      for (;;)
      {
        AppMethodBeat.o(133954);
        return true;
        i = 0;
        break;
        label311:
        paramz.releaseOutputBuffer(paramInt, false);
      }
    }
    if (!e.IC(this.state))
    {
      ac.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133954);
      return false;
    }
    l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = ((float)l1 / this.kOZ - (float)paramLong1 - (float)l3);
    ac.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { info(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      ac.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { info() });
      paramz.releaseOutputBuffer(paramInt, false);
      this.uIq.uIl = 0L;
      AppMethodBeat.o(133954);
      return true;
    }
    if (l4 < 30L)
    {
      this.uIq.uIi = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      label562:
      if (!e.IC(this.state))
      {
        ac.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
        AppMethodBeat.o(133954);
        return false;
      }
      if ((Math.abs(l1 - this.cVi) > 1000L) || (this.cVi <= 0L))
      {
        ac.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(l1) });
        this.cVi = l1;
      }
      paramz.releaseOutputBuffer(paramInt, true);
      AppMethodBeat.o(133954);
      return true;
      ac.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[] { info() });
      AppMethodBeat.o(133954);
      return false;
    }
    catch (Exception paramByteBuffer)
    {
      break label562;
    }
  }
  
  final boolean a(z paramz)
  {
    AppMethodBeat.i(133955);
    if (paramz == null)
    {
      AppMethodBeat.o(133955);
      return false;
    }
    if (this.surface == null) {
      ac.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[] { info() });
    }
    for (this.uJa = false;; this.uJa = true)
    {
      ac.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { info() });
      ac.i("MicroMsg.VideoTrackDataSource", "%s before prepare init decoder, surface valid: %s", new Object[] { info(), Boolean.valueOf(this.surface.isValid()) });
      paramz.a(ddc(), this.surface, 0);
      this.cVi = 0L;
      AppMethodBeat.o(133955);
      return false;
    }
  }
  
  protected final boolean ai(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133959);
    ac.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.uIq.prj) });
    if ((this.uIq.prj) && (paramInt == 1) && (this.uJd != paramLong))
    {
      boolean bool = W(paramLong, -1L);
      this.uJd = paramLong;
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
      this.uIr.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(paramInt)).sendToTarget();
      ac.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { info(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133958);
      return;
      paramInt = SightVideoJNI.getMp4RotateVFS(this.path);
      ac.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { info(), Integer.valueOf(paramInt) });
    }
  }
  
  @TargetApi(23)
  final void ddg()
  {
    AppMethodBeat.i(133956);
    try
    {
      if (this.gOr != null)
      {
        z localz = this.gOr;
        Surface localSurface = this.surface;
        try
        {
          MediaCodecProxyUtils.b.kW(81);
          localz.fIx.setOutputSurface(localSurface);
          MediaCodecProxyUtils.b.kW(82);
          AppMethodBeat.o(133956);
          return;
        }
        catch (Exception localException2)
        {
          ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy setOutputSurface", new Object[0]);
          z.a(34, localException2, localz.fIy);
          AppMethodBeat.o(133956);
          throw localException2;
        }
      }
      AppMethodBeat.o(133956);
    }
    catch (Exception localException1)
    {
      ac.printErrStackTrace("MicroMsg.VideoTrackDataSource", localException1, "%s change surface23 error [%s]", new Object[] { info(), localException1.toString() });
      ddh();
      AppMethodBeat.o(133956);
      return;
    }
  }
  
  final void ddh()
  {
    AppMethodBeat.i(133957);
    ac.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { info() });
    if (this.gOr != null)
    {
      releaseDecoder();
      W(this.uIq.uIi, -1L);
      ddb();
    }
    AppMethodBeat.o(133957);
  }
  
  final String type()
  {
    return "video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.l
 * JD-Core Version:    0.7.0.1
 */