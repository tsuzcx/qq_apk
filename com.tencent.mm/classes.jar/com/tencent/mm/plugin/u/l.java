package com.tencent.mm.plugin.u;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;

public final class l
  extends i
{
  private boolean KTA = false;
  boolean KTB = false;
  long KTC = -1L;
  boolean KTz = false;
  private long hvL = 0L;
  public float sAn = 1.0F;
  Surface surface;
  private int videoHeight;
  private int videoWidth;
  
  public l(h paramh, MMHandler paramMMHandler)
  {
    super(paramh, paramMMHandler);
  }
  
  private void gbP()
  {
    AppMethodBeat.i(133956);
    try
    {
      if (this.nyz != null) {
        this.nyz.setOutputSurface(this.surface);
      }
      AppMethodBeat.o(133956);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoTrackDataSource", localException, "%s change surface23 error [%s]", new Object[] { info(), localException.toString() });
      gbQ();
      AppMethodBeat.o(133956);
    }
  }
  
  private void gbQ()
  {
    AppMethodBeat.i(133957);
    Log.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { info() });
    if (this.nyz != null)
    {
      releaseDecoder();
      aR(this.KSM.KSD, -1L);
      gbJ();
    }
    AppMethodBeat.o(133957);
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
      if (!e.aaP(this.state)) {
        break;
      }
      Log.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { info() });
      paramaa.releaseOutputBuffer(paramInt, true);
      setState(4);
      AppMethodBeat.o(133954);
      return true;
    }
    if (e.aaO(this.state))
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
        if (this.KTA)
        {
          setState(7);
          this.KTA = false;
        }
        this.KTA = true;
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
    if (!e.aaQ(this.state))
    {
      Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133954);
      return false;
    }
    l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = ((float)l1 / this.sAn - (float)paramLong1 - (float)l3);
    Log.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { info(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      Log.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { info() });
      paramaa.releaseOutputBuffer(paramInt, false);
      this.KSM.KSG = 0L;
      AppMethodBeat.o(133954);
      return true;
    }
    if (l4 < 30L)
    {
      this.KSM.KSD = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      label562:
      if (!e.aaQ(this.state))
      {
        Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
        AppMethodBeat.o(133954);
        return false;
      }
      if ((Math.abs(l1 - this.hvL) > 1000L) || (this.hvL <= 0L))
      {
        Log.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(l1) });
        this.hvL = l1;
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
    for (this.KTz = false;; this.KTz = true)
    {
      Log.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { info() });
      Log.i("MicroMsg.VideoTrackDataSource", "%s before prepare init decoder, surface valid: %s", new Object[] { info(), Boolean.valueOf(this.surface.isValid()) });
      paramaa.a(gbK(), this.surface, 0);
      this.hvL = 0L;
      AppMethodBeat.o(133955);
      return false;
    }
  }
  
  protected final boolean aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133959);
    Log.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.KSM.ykl) });
    if ((this.KSM.ykl) && (paramInt == 1) && (this.KTC != paramLong))
    {
      boolean bool = aR(paramLong, -1L);
      this.KTC = paramLong;
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
      this.KSN.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(paramInt)).sendToTarget();
      Log.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { info(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133958);
      return;
      paramInt = SightVideoJNI.getMp4RotateVFS(this.path);
      Log.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { info(), Integer.valueOf(paramInt) });
    }
  }
  
  protected final g gbL()
  {
    return null;
  }
  
  public final void r(Surface paramSurface)
  {
    AppMethodBeat.i(260385);
    Log.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { info() });
    this.surface = paramSurface;
    if (d.rb(23))
    {
      gbP();
      AppMethodBeat.o(260385);
      return;
    }
    gbQ();
    AppMethodBeat.o(260385);
  }
  
  final String type()
  {
    return "video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.u.l
 * JD-Core Version:    0.7.0.1
 */