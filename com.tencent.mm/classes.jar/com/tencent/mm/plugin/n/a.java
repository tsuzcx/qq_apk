package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

public final class a
  extends h
{
  private AudioTrack ayN;
  private int channels;
  private boolean efg = false;
  private int sampleRate;
  
  public a(g paramg, ak paramak)
  {
    super(paramg, paramak);
  }
  
  private int getSampleRate()
  {
    AppMethodBeat.i(117863);
    if (this.sampleRate == 0) {
      this.sampleRate = this.oES.getInteger("sample-rate");
    }
    int i = this.sampleRate;
    AppMethodBeat.o(117863);
    return i;
  }
  
  @TargetApi(21)
  private void jk(boolean paramBoolean)
  {
    AppMethodBeat.i(117861);
    if (paramBoolean)
    {
      this.ayN.setVolume(0.0F);
      AppMethodBeat.o(117861);
      return;
    }
    this.ayN.setVolume(1.0F);
    AppMethodBeat.o(117861);
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(117856);
    ab.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { bau(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!d.zg(this.state))
    {
      ab.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { bau(), Integer.valueOf(this.state) });
      AppMethodBeat.o(117856);
      return false;
    }
    if (this.ayN == null)
    {
      ab.i("MicroMsg.AudioTrackDataSource", "%s init audio track", new Object[] { bau() });
      if (this.channels == 0) {
        this.channels = this.oES.getInteger("channel-count");
      }
      if (this.channels == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.ayN = new e(3, getSampleRate(), i, j);
        if ((this.ayN == null) || (this.ayN.getState() == 1)) {
          break label271;
        }
        ab.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { bau(), Integer.valueOf(this.ayN.getState()) });
        this.ayN.release();
        this.ayN = null;
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          break label285;
        }
        AppMethodBeat.o(117856);
        return false;
        i = 12;
        break;
        label271:
        setMute(this.efg);
      }
    }
    label285:
    if ((d.za(this.state)) && ((this.ayN.getPlayState() == 2) || (this.ayN.getPlayState() == 1))) {
      onStart();
    }
    if ((d.zb(this.state)) && (this.ayN.getPlayState() == 3)) {
      onPause();
    }
    try
    {
      this.oEN.oEG = paramBufferInfo.presentationTimeUs;
      paramBufferInfo = new byte[paramBufferInfo.size];
      paramByteBuffer.get(paramBufferInfo);
      paramByteBuffer.clear();
      if (paramBufferInfo.length > 0) {
        this.ayN.write(paramBufferInfo, 0, paramBufferInfo.length);
      }
      ab.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", new Object[] { bau(), Integer.valueOf(paramInt), Long.valueOf(this.oEN.oEG) });
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
    }
    catch (Exception paramMediaCodec)
    {
      for (;;)
      {
        ab.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { bau(), paramMediaCodec.toString() });
      }
    }
    AppMethodBeat.o(117856);
    return true;
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(117862);
    ab.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { bau() });
    paramMediaCodec.configure(this.oES, null, null, 0);
    AppMethodBeat.o(117862);
    return false;
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(117864);
    ab.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", new Object[] { bau() });
    this.sampleRate = 0;
    this.channels = 0;
    if (this.ayN != null) {}
    try
    {
      this.ayN.flush();
      this.ayN.release();
      label54:
      this.ayN = null;
      AppMethodBeat.o(117864);
      return;
    }
    catch (Exception paramMediaCodec)
    {
      break label54;
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(117858);
    ab.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { bau() });
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.pause();
    }
    AppMethodBeat.o(117858);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(117857);
    ab.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { bau() });
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.play();
    }
    AppMethodBeat.o(117857);
  }
  
  public final void release()
  {
    AppMethodBeat.i(117859);
    try
    {
      this.ayN.flush();
      this.ayN.release();
      label19:
      super.release();
      AppMethodBeat.o(117859);
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(117860);
    if (this.ayN == null)
    {
      ab.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { bau(), Boolean.valueOf(paramBoolean) });
      this.efg = paramBoolean;
      AppMethodBeat.o(117860);
      return;
    }
    if (com.tencent.mm.compatible.util.d.fw(21))
    {
      ab.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { bau(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.ayN.setStereoVolume(0.0F, 0.0F);
        AppMethodBeat.o(117860);
        return;
      }
      this.ayN.setStereoVolume(1.0F, 1.0F);
      AppMethodBeat.o(117860);
      return;
    }
    ab.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { bau(), Boolean.valueOf(paramBoolean) });
    jk(paramBoolean);
    AppMethodBeat.o(117860);
  }
  
  final String type()
  {
    return "audio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.n.a
 * JD-Core Version:    0.7.0.1
 */