package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class k
  extends h
{
  Surface avf;
  float gEy = 1.0F;
  boolean meU = false;
  private boolean meV = false;
  boolean meW = false;
  private long meX = 0L;
  long meY = -1L;
  private int videoHeight;
  private int videoWidth;
  
  public k(g paramg, ah paramah)
  {
    super(paramg, paramah);
  }
  
  protected final boolean F(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    y.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { ayN(), Integer.valueOf(paramInt), Boolean.valueOf(this.mep.joQ) });
    boolean bool1 = bool2;
    if (this.mep.joQ)
    {
      bool1 = bool2;
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (this.meY != paramLong)
        {
          bool1 = D(paramLong, -1L);
          this.meY = paramLong;
        }
      }
    }
    return bool1;
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    y.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { ayN(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (d.tM(this.state))
    {
      y.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { ayN() });
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      setState(4);
      return true;
    }
    if (d.tL(this.state))
    {
      paramLong2 = paramBufferInfo.presentationTimeUs / 1000L;
      l1 = paramLong1 - paramLong2;
      y.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[] { ayN(), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
      int i;
      if (l1 <= 30L)
      {
        i = 1;
        if (i == 0) {
          break label232;
        }
        y.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[] { ayN() });
        paramMediaCodec.releaseOutputBuffer(paramInt, true);
        if (this.meV)
        {
          setState(7);
          this.meV = false;
        }
        this.meV = true;
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label232:
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
      }
    }
    if (!d.tN(this.state))
    {
      y.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { ayN(), Integer.valueOf(this.state) });
      return false;
    }
    long l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = ((float)l1 / this.gEy - (float)paramLong1 - (float)l3);
    y.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { ayN(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      y.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { ayN() });
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      this.mep.mek = 0L;
      return true;
    }
    if (l4 < 30L)
    {
      this.mep.meh = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      label473:
      if (!d.tN(this.state))
      {
        y.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { ayN(), Integer.valueOf(this.state) });
        return false;
      }
      if (Math.abs(l1 - this.meX) > 1000L)
      {
        y.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { ayN(), Integer.valueOf(paramInt), Long.valueOf(l1) });
        this.meX = l1;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      return true;
      y.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[] { ayN() });
      return false;
    }
    catch (Exception paramByteBuffer)
    {
      break label473;
    }
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    if (paramMediaCodec == null) {
      return false;
    }
    if (this.avf == null)
    {
      y.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[] { ayN() });
      this.meU = false;
      y.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { ayN() });
      if (this.eIP != null) {
        break label87;
      }
    }
    label87:
    for (MediaFormat localMediaFormat = this.meu;; localMediaFormat = this.eIP.getTrackFormat(this.mev))
    {
      paramMediaCodec.configure(localMediaFormat, this.avf, null, 0);
      return false;
      this.meU = true;
      break;
    }
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    y.i("MicroMsg.VideoTrackDataSource", "%s output format changed", new Object[] { ayN() });
    paramMediaCodec.setVideoScalingMode(1);
  }
  
  protected final void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
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
      this.meq.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(paramInt)).sendToTarget();
      y.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { ayN(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(paramInt) });
      return;
      paramInt = SightVideoJNI.getMp4Rotate(this.path);
      y.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { ayN(), Integer.valueOf(paramInt) });
    }
  }
  
  @TargetApi(23)
  final void biA()
  {
    try
    {
      if (this.eIT != null) {
        this.eIT.setOutputSurface(this.avf);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.VideoTrackDataSource", localException, "%s change surface23 error [%s]", new Object[] { ayN(), localException.toString() });
      biB();
    }
  }
  
  final void biB()
  {
    y.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { ayN() });
    if (this.eIT != null)
    {
      nm();
      D(this.mep.meh, -1L);
      biv();
    }
  }
  
  final String type()
  {
    return "video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.s.k
 * JD-Core Version:    0.7.0.1
 */