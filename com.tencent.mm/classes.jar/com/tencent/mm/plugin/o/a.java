package com.tencent.mm.plugin.o;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.a.m;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class a
  extends i
{
  private AudioTrack aUW;
  private int channels;
  private boolean ftN = false;
  private int sampleRate;
  
  public a(h paramh, ao paramao)
  {
    super(paramh, paramao);
  }
  
  private int getChannels()
  {
    AppMethodBeat.i(133900);
    if (this.channels == 0) {
      this.channels = this.uIv.getInteger("channel-count");
    }
    int i = this.channels;
    AppMethodBeat.o(133900);
    return i;
  }
  
  private int getSampleRate()
  {
    AppMethodBeat.i(133901);
    if (this.sampleRate == 0) {
      this.sampleRate = this.uIv.getInteger("sample-rate");
    }
    int i = this.sampleRate;
    AppMethodBeat.o(133901);
    return i;
  }
  
  @TargetApi(21)
  private void nV(boolean paramBoolean)
  {
    AppMethodBeat.i(133898);
    if (paramBoolean)
    {
      this.aUW.setVolume(0.0F);
      AppMethodBeat.o(133898);
      return;
    }
    this.aUW.setVolume(1.0F);
    AppMethodBeat.o(133898);
  }
  
  protected final void a(z paramz, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(133902);
    super.a(paramz, paramMediaFormat);
    ac.i("MicroMsg.AudioTrackDataSource", "%s on output format changed: %s", new Object[] { info(), paramMediaFormat });
    if (paramMediaFormat.containsKey("sample-rate")) {
      this.sampleRate = paramMediaFormat.getInteger("sample-rate");
    }
    AppMethodBeat.o(133902);
  }
  
  final boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(133893);
    ac.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!e.IC(this.state))
    {
      ac.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { info(), Integer.valueOf(this.state) });
      AppMethodBeat.o(133893);
      return false;
    }
    if (this.aUW == null)
    {
      ac.i("MicroMsg.AudioTrackDataSource", "%s init audio track, sampleRate:%s, channels:%s", new Object[] { info(), Integer.valueOf(getSampleRate()), Integer.valueOf(getChannels()) });
      if (getChannels() == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.aUW = new com.tencent.mm.compatible.b.e(3, getSampleRate(), i, j);
        if ((this.aUW == null) || (this.aUW.getState() == 1)) {
          break label271;
        }
        ac.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { info(), Integer.valueOf(this.aUW.getState()) });
        this.aUW.release();
        this.aUW = null;
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
        setMute(this.ftN);
      }
    }
    label285:
    if ((e.Iw(this.state)) && ((this.aUW.getPlayState() == 2) || (this.aUW.getPlayState() == 1))) {
      onStart();
    }
    if ((e.Ix(this.state)) && (this.aUW.getPlayState() == 3)) {
      onPause();
    }
    try
    {
      this.uIq.uIj = paramBufferInfo.presentationTimeUs;
      byte[] arrayOfByte = new byte[paramBufferInfo.size];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer.clear();
      paramLong1 = bs.Gn();
      if (arrayOfByte.length > 0) {
        this.aUW.write(arrayOfByte, 0, arrayOfByte.length);
      }
      ac.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track, size:%s, cost:%s", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.uIq.uIj), Integer.valueOf(paramBufferInfo.size), Long.valueOf(bs.aO(paramLong1)) });
      paramz.releaseOutputBuffer(paramInt, false);
    }
    catch (Exception paramz)
    {
      for (;;)
      {
        ac.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { info(), paramz.toString() });
      }
    }
    AppMethodBeat.o(133893);
    return true;
  }
  
  final boolean a(z paramz)
  {
    AppMethodBeat.i(133899);
    ac.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { info() });
    MediaFormat localMediaFormat = ddc();
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTG, false) | bt.eWo();
    if (com.tencent.mm.compatible.util.d.la(28)) {
      i = 0;
    }
    Object localObject1;
    if (i != 0)
    {
      localMediaFormat.setInteger("encoder-delay", 0);
      localMediaFormat.setInteger("encoder-padding", 0);
      localObject1 = new com.tencent.mm.plugin.a.h();
      long l1 = System.currentTimeMillis();
      boolean bool = ((com.tencent.mm.plugin.a.h)localObject1).FM(this.path);
      long l2 = System.currentTimeMillis();
      if (bool)
      {
        Object localObject2 = ((com.tencent.mm.plugin.a.h)localObject1).ixD;
        Iterator localIterator = ((com.tencent.mm.plugin.a.h)localObject1).ixE.iterator();
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
            if (((p)localObject1).iyu != null) {
              if (((p)localObject1).iyu.ixx == com.tencent.mm.plugin.a.g.ixu)
              {
                i = 1;
                if (i == 0) {
                  break label600;
                }
                l7 = ((m)localObject2).ixw;
                if ((((p)localObject1).iyv != null) && (((p)localObject1).iyv.ixf.size() == 1))
                {
                  localObject2 = ((p)localObject1).iyv;
                  localObject1 = ((p)localObject1).iyu;
                  l3 = ((com.tencent.mm.plugin.a.g)localObject1).duration;
                  l6 = ((com.tencent.mm.plugin.a.g)localObject1).ixw;
                  l4 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).ixf.get(0)).longValue();
                  l5 = ((Long)((com.tencent.mm.plugin.a.d)localObject2).ixe.get(0)).longValue();
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
          ac.i("MicroMsg.AudioTrackDataSource", "mediaDuration:%s, editStartTime:%s, editDuration:%s, editEndTime:%s, paddingTimeUnits:%s, encoderDelay:%s, encoderPadding:%s, sampleRate:%s, oriEncoderDelay:%s, trackFormat:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l6), Integer.valueOf(m), Integer.valueOf(i), localMediaFormat });
          if ((l9 > 2147483647L) || (l6 > 2147483647L)) {
            break label608;
          }
          localMediaFormat.setInteger("encoder-delay", (int)l9);
          localMediaFormat.setInteger("encoder-padding", (int)l6);
          ac.i("MicroMsg.AudioTrackDataSource", "set encoder-delay:%s, encoder-padding:%s", new Object[] { Long.valueOf(l9), Long.valueOf(l6) });
          com.tencent.mm.plugin.report.service.h.wUl.dB(1117, 0);
          com.tencent.mm.plugin.report.service.h.wUl.n(1117L, 1L, l2 - l1);
          com.tencent.mm.plugin.report.service.h.wUl.n(1117L, 3L, i);
          com.tencent.mm.plugin.report.service.h.wUl.n(1117L, 4L, (int)l9);
          com.tencent.mm.plugin.report.service.h.wUl.n(1117L, 5L, (int)l9 - i);
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
      ac.i("MicroMsg.AudioTrackDataSource", "ignore set encoder-delay and encoder-padding and reset to 0");
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(133895);
    ac.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { info() });
    if ((this.aUW != null) && (this.aUW.getState() == 1)) {
      this.aUW.pause();
    }
    AppMethodBeat.o(133895);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(133894);
    ac.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { info() });
    if ((this.aUW != null) && (this.aUW.getState() == 1)) {
      this.aUW.play();
    }
    AppMethodBeat.o(133894);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133896);
    try
    {
      this.aUW.flush();
      this.aUW.release();
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
    if (this.aUW == null)
    {
      ac.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      this.ftN = paramBoolean;
      AppMethodBeat.o(133897);
      return;
    }
    if (com.tencent.mm.compatible.util.d.la(21))
    {
      ac.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.aUW.setStereoVolume(0.0F, 0.0F);
        AppMethodBeat.o(133897);
        return;
      }
      this.aUW.setStereoVolume(1.0F, 1.0F);
      AppMethodBeat.o(133897);
      return;
    }
    ac.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
    nV(paramBoolean);
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