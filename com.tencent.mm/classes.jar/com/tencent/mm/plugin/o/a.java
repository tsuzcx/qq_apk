package com.tencent.mm.plugin.o;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.a.l;
import com.tencent.mm.plugin.a.o;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class a
  extends i
{
  private AudioTrack aUg;
  private int channels;
  private boolean fqj = false;
  private int sampleRate;
  
  public a(h paramh, ap paramap)
  {
    super(paramh, paramap);
  }
  
  private int getChannels()
  {
    AppMethodBeat.i(133900);
    if (this.channels == 0) {
      this.channels = this.tzY.getInteger("channel-count");
    }
    int i = this.channels;
    AppMethodBeat.o(133900);
    return i;
  }
  
  private int getSampleRate()
  {
    AppMethodBeat.i(133901);
    if (this.sampleRate == 0) {
      this.sampleRate = this.tzY.getInteger("sample-rate");
    }
    int i = this.sampleRate;
    AppMethodBeat.o(133901);
    return i;
  }
  
  @TargetApi(21)
  private void nc(boolean paramBoolean)
  {
    AppMethodBeat.i(133898);
    if (paramBoolean)
    {
      this.aUg.setVolume(0.0F);
      AppMethodBeat.o(133898);
      return;
    }
    this.aUg.setVolume(1.0F);
    AppMethodBeat.o(133898);
  }
  
  protected final void a(z paramz, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(133902);
    super.a(paramz, paramMediaFormat);
    ad.i("MicroMsg.AudioTrackDataSource", "%s on output format changed: %s", new Object[] { info(), paramMediaFormat });
    if (paramMediaFormat.containsKey("sample-rate")) {
      this.sampleRate = paramMediaFormat.getInteger("sample-rate");
    }
    AppMethodBeat.o(133902);
  }
  
  final boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(133893);
    ad.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!e.GG(this.state))
    {
      ad.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133893);
      return false;
    }
    if (this.aUg == null)
    {
      ad.i("MicroMsg.AudioTrackDataSource", "%s init audio track, sampleRate:%s, channels:%s", new Object[] { info(), Integer.valueOf(getSampleRate()), Integer.valueOf(getChannels()) });
      if (getChannels() == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.aUg = new com.tencent.mm.compatible.b.e(3, getSampleRate(), i, j);
        if ((this.aUg == null) || (this.aUg.getState() == 1)) {
          break label271;
        }
        ad.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { info(), Integer.valueOf(this.aUg.getState()) });
        this.aUg.release();
        this.aUg = null;
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          break label285;
        }
        AppMethodBeat.o(133893);
        return false;
        i = 12;
        break;
        label271:
        setMute(this.fqj);
      }
    }
    label285:
    if ((e.GA(this.state)) && ((this.aUg.getPlayState() == 2) || (this.aUg.getPlayState() == 1))) {
      onStart();
    }
    if ((e.GB(this.state)) && (this.aUg.getPlayState() == 3)) {
      onPause();
    }
    try
    {
      this.tzT.tzM = paramBufferInfo.presentationTimeUs;
      byte[] arrayOfByte = new byte[paramBufferInfo.size];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer.clear();
      paramLong1 = bt.GC();
      if (arrayOfByte.length > 0) {
        this.aUg.write(arrayOfByte, 0, arrayOfByte.length);
      }
      ad.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track, size:%s, cost:%s", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.tzT.tzM), Integer.valueOf(paramBufferInfo.size), Long.valueOf(bt.aS(paramLong1)) });
      paramz.releaseOutputBuffer(paramInt, false);
    }
    catch (Exception paramz)
    {
      for (;;)
      {
        ad.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { info(), paramz.toString() });
      }
    }
    AppMethodBeat.o(133893);
    return true;
  }
  
  final boolean a(z paramz)
  {
    AppMethodBeat.i(133899);
    ad.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { info() });
    MediaFormat localMediaFormat = cPt();
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppV, false) | bu.eGT();
    if (com.tencent.mm.compatible.util.d.lg(28)) {
      i = 0;
    }
    Object localObject1;
    if (i != 0)
    {
      localMediaFormat.setInteger("encoder-delay", 0);
      localMediaFormat.setInteger("encoder-padding", 0);
      localObject1 = new com.tencent.mm.plugin.a.g();
      long l1 = System.currentTimeMillis();
      boolean bool = ((com.tencent.mm.plugin.a.g)localObject1).BI(this.path);
      long l2 = System.currentTimeMillis();
      if (bool)
      {
        Object localObject2 = ((com.tencent.mm.plugin.a.g)localObject1).hXz;
        Iterator localIterator = ((com.tencent.mm.plugin.a.g)localObject1).hXA.iterator();
        for (;;)
        {
          label185:
          label189:
          long l7;
          long l3;
          long l6;
          long l4;
          long l5;
          int m;
          long l8;
          long l9;
          if (localIterator.hasNext())
          {
            localObject1 = (o)localIterator.next();
            if (((o)localObject1).hYq != null) {
              if (((o)localObject1).hYq.hXt == f.hXq)
              {
                i = 1;
                if (i == 0) {
                  break label600;
                }
                l7 = ((l)localObject2).hXs;
                if ((((o)localObject1).hYr != null) && (((o)localObject1).hYr.hXb.size() == 1))
                {
                  localObject2 = ((o)localObject1).hYr;
                  localObject1 = ((o)localObject1).hYq;
                  l3 = ((f)localObject1).duration;
                  l6 = ((f)localObject1).hXs;
                  l4 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).hXb.get(0)).longValue();
                  l5 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).hXa.get(0)).longValue();
                  l7 = l4 + l5 * l6 / l7;
                  m = getSampleRate();
                  l8 = l3 - l7;
                  l9 = m * l4 / l6;
                  l6 = m * l8 / l6;
                  i = 0;
                }
              }
            }
          }
          try
          {
            int k = localMediaFormat.getInteger("encoder-delay");
            i = k;
          }
          catch (Exception localException)
          {
            label348:
            break label348;
          }
          ad.i("MicroMsg.AudioTrackDataSource", "mediaDuration:%s, editStartTime:%s, editDuration:%s, editEndTime:%s, paddingTimeUnits:%s, encoderDelay:%s, encoderPadding:%s, sampleRate:%s, oriEncoderDelay:%s, trackFormat:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l6), Integer.valueOf(m), Integer.valueOf(i), localMediaFormat });
          if ((l9 > 2147483647L) || (l6 > 2147483647L)) {
            break label608;
          }
          localMediaFormat.setInteger("encoder-delay", (int)l9);
          localMediaFormat.setInteger("encoder-padding", (int)l6);
          ad.i("MicroMsg.AudioTrackDataSource", "set encoder-delay:%s, encoder-padding:%s", new Object[] { Long.valueOf(l9), Long.valueOf(l6) });
          com.tencent.mm.plugin.report.service.h.vKh.dB(1117, 0);
          com.tencent.mm.plugin.report.service.h.vKh.m(1117L, 1L, l2 - l1);
          com.tencent.mm.plugin.report.service.h.vKh.m(1117L, 3L, i);
          com.tencent.mm.plugin.report.service.h.vKh.m(1117L, 4L, (int)l9);
          com.tencent.mm.plugin.report.service.h.vKh.m(1117L, 5L, (int)l9 - i);
        }
      }
    }
    for (;;)
    {
      paramz.a(localMediaFormat, null, 0);
      AppMethodBeat.o(133899);
      return false;
      int j = 0;
      break label185;
      label600:
      break;
      localObject1 = null;
      break label189;
      label608:
      ad.i("MicroMsg.AudioTrackDataSource", "ignore set encoder-delay and encoder-padding and reset to 0");
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(133895);
    ad.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { info() });
    if ((this.aUg != null) && (this.aUg.getState() == 1)) {
      this.aUg.pause();
    }
    AppMethodBeat.o(133895);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(133894);
    ad.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { info() });
    if ((this.aUg != null) && (this.aUg.getState() == 1)) {
      this.aUg.play();
    }
    AppMethodBeat.o(133894);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133896);
    try
    {
      this.aUg.flush();
      this.aUg.release();
      label20:
      super.release();
      AppMethodBeat.o(133896);
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133897);
    if (this.aUg == null)
    {
      ad.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      this.fqj = paramBoolean;
      AppMethodBeat.o(133897);
      return;
    }
    if (com.tencent.mm.compatible.util.d.lg(21))
    {
      ad.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.aUg.setStereoVolume(0.0F, 0.0F);
        AppMethodBeat.o(133897);
        return;
      }
      this.aUg.setStereoVolume(1.0F, 1.0F);
      AppMethodBeat.o(133897);
      return;
    }
    ad.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
    nc(paramBoolean);
    AppMethodBeat.o(133897);
  }
  
  final String type()
  {
    return "audio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a
 * JD-Core Version:    0.7.0.1
 */