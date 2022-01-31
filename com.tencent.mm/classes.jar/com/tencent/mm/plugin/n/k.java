package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

public final class k
  extends h
{
  Surface axw;
  float idC = 1.0F;
  boolean oFt = false;
  private boolean oFu = false;
  boolean oFv = false;
  private long oFw = 0L;
  long oFx = -1L;
  private int videoHeight;
  private int videoWidth;
  
  public k(g paramg, ak paramak)
  {
    super(paramg, paramak);
  }
  
  protected final boolean V(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117914);
    ab.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { bau(), Integer.valueOf(paramInt), Boolean.valueOf(this.oEN.lxE) });
    if ((this.oEN.lxE) && (paramInt == 1) && (this.oFx != paramLong))
    {
      boolean bool = P(paramLong, -1L);
      this.oFx = paramLong;
      AppMethodBeat.o(117914);
      return bool;
    }
    AppMethodBeat.o(117914);
    return false;
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(117908);
    ab.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { bau(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (d.zf(this.state))
    {
      ab.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { bau() });
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      setState(4);
      AppMethodBeat.o(117908);
      return true;
    }
    if (d.ze(this.state))
    {
      paramLong2 = paramBufferInfo.presentationTimeUs / 1000L;
      l1 = paramLong1 - paramLong2;
      ab.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[] { bau(), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
      int i;
      if (l1 <= 30L)
      {
        i = 1;
        if (i == 0) {
          break label247;
        }
        ab.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[] { bau() });
        paramMediaCodec.releaseOutputBuffer(paramInt, true);
        if (this.oFu)
        {
          setState(7);
          this.oFu = false;
        }
        this.oFu = true;
      }
      for (;;)
      {
        AppMethodBeat.o(117908);
        return true;
        i = 0;
        break;
        label247:
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
      }
    }
    if (!d.zg(this.state))
    {
      ab.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { bau(), Integer.valueOf(this.state) });
      AppMethodBeat.o(117908);
      return false;
    }
    long l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = ((float)l1 / this.idC - (float)paramLong1 - (float)l3);
    ab.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { bau(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      ab.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { bau() });
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      this.oEN.oEI = 0L;
      AppMethodBeat.o(117908);
      return true;
    }
    if (l4 < 30L)
    {
      this.oEN.oEF = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      label498:
      if (!d.zg(this.state))
      {
        ab.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { bau(), Integer.valueOf(this.state) });
        AppMethodBeat.o(117908);
        return false;
      }
      if (Math.abs(l1 - this.oFw) > 1000L)
      {
        ab.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { bau(), Integer.valueOf(paramInt), Long.valueOf(l1) });
        this.oFw = l1;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      AppMethodBeat.o(117908);
      return true;
      ab.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[] { bau() });
      AppMethodBeat.o(117908);
      return false;
    }
    catch (Exception paramByteBuffer)
    {
      break label498;
    }
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(117909);
    if (paramMediaCodec == null)
    {
      AppMethodBeat.o(117909);
      return false;
    }
    if (this.axw == null)
    {
      ab.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[] { bau() });
      this.oFt = false;
      ab.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { bau() });
      if (this.cfO != null) {
        break label102;
      }
    }
    label102:
    for (MediaFormat localMediaFormat = this.oES;; localMediaFormat = this.cfO.getTrackFormat(this.oET))
    {
      paramMediaCodec.configure(localMediaFormat, this.axw, null, 0);
      AppMethodBeat.o(117909);
      return false;
      this.oFt = true;
      break;
    }
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(117910);
    ab.i("MicroMsg.VideoTrackDataSource", "%s output format changed", new Object[] { bau() });
    paramMediaCodec.setVideoScalingMode(1);
    AppMethodBeat.o(117910);
  }
  
  protected final void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(117913);
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
      this.oEO.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(paramInt)).sendToTarget();
      ab.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { bau(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(paramInt) });
      AppMethodBeat.o(117913);
      return;
      paramInt = SightVideoJNI.getMp4Rotate(this.path);
      ab.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { bau(), Integer.valueOf(paramInt) });
    }
  }
  
  @TargetApi(23)
  final void bQC()
  {
    AppMethodBeat.i(117911);
    try
    {
      if (this.eRD != null) {
        this.eRD.setOutputSurface(this.axw);
      }
      AppMethodBeat.o(117911);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VideoTrackDataSource", localException, "%s change surface23 error [%s]", new Object[] { bau(), localException.toString() });
      bQD();
      AppMethodBeat.o(117911);
    }
  }
  
  final void bQD()
  {
    AppMethodBeat.i(117912);
    ab.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { bau() });
    if (this.eRD != null)
    {
      pJ();
      P(this.oEN.oEF, -1L);
      bQx();
    }
    AppMethodBeat.o(117912);
  }
  
  final String type()
  {
    return "video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.n.k
 * JD-Core Version:    0.7.0.1
 */