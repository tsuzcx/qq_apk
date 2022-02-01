package com.tencent.mm.plugin.o;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.a.m;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class a
  extends i
{
  private AudioTrack bfq;
  private int channels;
  private boolean fOX = false;
  private int sampleRate;
  
  public a(h paramh, aq paramaq)
  {
    super(paramh, paramaq);
  }
  
  private int getChannels()
  {
    AppMethodBeat.i(133900);
    if (this.channels == 0) {
      this.channels = this.vXF.getInteger("channel-count");
    }
    int i = this.channels;
    AppMethodBeat.o(133900);
    return i;
  }
  
  private int getSampleRate()
  {
    AppMethodBeat.i(133901);
    if (this.sampleRate == 0) {
      this.sampleRate = this.vXF.getInteger("sample-rate");
    }
    int i = this.sampleRate;
    AppMethodBeat.o(133901);
    return i;
  }
  
  @TargetApi(21)
  private void ou(boolean paramBoolean)
  {
    AppMethodBeat.i(133898);
    if (paramBoolean)
    {
      this.bfq.setVolume(0.0F);
      AppMethodBeat.o(133898);
      return;
    }
    this.bfq.setVolume(1.0F);
    AppMethodBeat.o(133898);
  }
  
  protected final void a(z paramz, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(133902);
    super.a(paramz, paramMediaFormat);
    ae.i("MicroMsg.AudioTrackDataSource", "%s on output format changed: %s", new Object[] { info(), paramMediaFormat });
    if (paramMediaFormat.containsKey("sample-rate")) {
      this.sampleRate = paramMediaFormat.getInteger("sample-rate");
    }
    AppMethodBeat.o(133902);
  }
  
  final boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(133893);
    ae.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!e.Kz(this.state))
    {
      ae.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133893);
      return false;
    }
    if (this.bfq == null)
    {
      ae.i("MicroMsg.AudioTrackDataSource", "%s init audio track, sampleRate:%s, channels:%s", new Object[] { info(), Integer.valueOf(getSampleRate()), Integer.valueOf(getChannels()) });
      if (getChannels() == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.bfq = new com.tencent.mm.compatible.b.e(3, getSampleRate(), i, j);
        if ((this.bfq == null) || (this.bfq.getState() == 1)) {
          break label271;
        }
        ae.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { info(), Integer.valueOf(this.bfq.getState()) });
        this.bfq.release();
        this.bfq = null;
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
        setMute(this.fOX);
      }
    }
    label285:
    if ((e.Kt(this.state)) && ((this.bfq.getPlayState() == 2) || (this.bfq.getPlayState() == 1))) {
      onStart();
    }
    if ((e.Ku(this.state)) && (this.bfq.getPlayState() == 3)) {
      onPause();
    }
    try
    {
      this.vXA.vXs = paramBufferInfo.presentationTimeUs;
      byte[] arrayOfByte = new byte[paramBufferInfo.size];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer.clear();
      paramLong1 = bu.HQ();
      if (arrayOfByte.length > 0) {
        this.bfq.write(arrayOfByte, 0, arrayOfByte.length);
      }
      ae.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track, size:%s, cost:%s", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.vXA.vXs), Integer.valueOf(paramBufferInfo.size), Long.valueOf(bu.aO(paramLong1)) });
      paramz.releaseOutputBuffer(paramInt, false);
    }
    catch (Exception paramz)
    {
      for (;;)
      {
        ae.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { info(), paramz.toString() });
      }
    }
    AppMethodBeat.o(133893);
    return true;
  }
  
  final boolean a(z paramz)
  {
    AppMethodBeat.i(133899);
    ae.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { info() });
    MediaFormat localMediaFormat = dpw();
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFs, false) | bv.fpT();
    if (com.tencent.mm.compatible.util.d.lB(28)) {
      i = 0;
    }
    Object localObject1;
    if (i != 0)
    {
      localMediaFormat.setInteger("encoder-delay", 0);
      localMediaFormat.setInteger("encoder-padding", 0);
      localObject1 = new com.tencent.mm.plugin.a.h();
      long l1 = System.currentTimeMillis();
      boolean bool = ((com.tencent.mm.plugin.a.h)localObject1).JA(this.path);
      long l2 = System.currentTimeMillis();
      if (bool)
      {
        Object localObject2 = ((com.tencent.mm.plugin.a.h)localObject1).iTF;
        Iterator localIterator = ((com.tencent.mm.plugin.a.h)localObject1).iTG.iterator();
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
            localObject1 = (p)localIterator.next();
            if (((p)localObject1).iUw != null) {
              if (((p)localObject1).iUw.iTz == com.tencent.mm.plugin.a.g.iTw)
              {
                i = 1;
                if (i == 0) {
                  break label600;
                }
                l7 = ((m)localObject2).iTy;
                if ((((p)localObject1).iUx != null) && (((p)localObject1).iUx.iTh.size() == 1))
                {
                  localObject2 = ((p)localObject1).iUx;
                  localObject1 = ((p)localObject1).iUw;
                  l3 = ((com.tencent.mm.plugin.a.g)localObject1).duration;
                  l6 = ((com.tencent.mm.plugin.a.g)localObject1).iTy;
                  l4 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).iTh.get(0)).longValue();
                  l5 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).iTg.get(0)).longValue();
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
          ae.i("MicroMsg.AudioTrackDataSource", "mediaDuration:%s, editStartTime:%s, editDuration:%s, editEndTime:%s, paddingTimeUnits:%s, encoderDelay:%s, encoderPadding:%s, sampleRate:%s, oriEncoderDelay:%s, trackFormat:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l6), Integer.valueOf(m), Integer.valueOf(i), localMediaFormat });
          if ((l9 > 2147483647L) || (l6 > 2147483647L)) {
            break label608;
          }
          localMediaFormat.setInteger("encoder-delay", (int)l9);
          localMediaFormat.setInteger("encoder-padding", (int)l6);
          ae.i("MicroMsg.AudioTrackDataSource", "set encoder-delay:%s, encoder-padding:%s", new Object[] { Long.valueOf(l9), Long.valueOf(l6) });
          com.tencent.mm.plugin.report.service.g.yxI.dD(1117, 0);
          com.tencent.mm.plugin.report.service.g.yxI.n(1117L, 1L, l2 - l1);
          com.tencent.mm.plugin.report.service.g.yxI.n(1117L, 3L, i);
          com.tencent.mm.plugin.report.service.g.yxI.n(1117L, 4L, (int)l9);
          com.tencent.mm.plugin.report.service.g.yxI.n(1117L, 5L, (int)l9 - i);
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
      ae.i("MicroMsg.AudioTrackDataSource", "ignore set encoder-delay and encoder-padding and reset to 0");
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(133895);
    ae.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { info() });
    if ((this.bfq != null) && (this.bfq.getState() == 1)) {
      this.bfq.pause();
    }
    AppMethodBeat.o(133895);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(133894);
    ae.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { info() });
    if ((this.bfq != null) && (this.bfq.getState() == 1)) {
      this.bfq.play();
    }
    AppMethodBeat.o(133894);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133896);
    try
    {
      this.bfq.flush();
      this.bfq.release();
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
    if (this.bfq == null)
    {
      ae.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      this.fOX = paramBoolean;
      AppMethodBeat.o(133897);
      return;
    }
    if (com.tencent.mm.compatible.util.d.lB(21))
    {
      ae.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.bfq.setStereoVolume(0.0F, 0.0F);
        AppMethodBeat.o(133897);
        return;
      }
      this.bfq.setStereoVolume(1.0F, 1.0F);
      AppMethodBeat.o(133897);
      return;
    }
    ae.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
    ou(paramBoolean);
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