package com.tencent.mm.plugin.s;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class a
  extends h
{
  private AudioTrack awx;
  private int channels;
  private boolean dnJ = false;
  private int sampleRate;
  
  public a(g paramg, ah paramah)
  {
    super(paramg, paramah);
  }
  
  private int getSampleRate()
  {
    if (this.sampleRate == 0) {
      this.sampleRate = this.meu.getInteger("sample-rate");
    }
    return this.sampleRate;
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    y.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { ayN(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!d.tN(this.state))
    {
      y.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { ayN(), Integer.valueOf(this.state) });
      return false;
    }
    if (this.awx == null)
    {
      y.i("MicroMsg.AudioTrackDataSource", "%s init audio track", new Object[] { ayN() });
      if (this.channels == 0) {
        this.channels = this.meu.getInteger("channel-count");
      }
      if (this.channels == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.awx = new com.tencent.mm.compatible.b.d(3, getSampleRate(), i, j);
        if ((this.awx == null) || (this.awx.getState() == 1)) {
          break label256;
        }
        y.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { ayN(), Integer.valueOf(this.awx.getState()) });
        this.awx.release();
        this.awx = null;
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label270;
        }
        return false;
        i = 12;
        break;
        label256:
        setMute(this.dnJ);
      }
    }
    label270:
    if ((d.tI(this.state)) && ((this.awx.getPlayState() == 2) || (this.awx.getPlayState() == 1))) {
      onStart();
    }
    if (this.state == 4) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.awx.getPlayState() == 3)) {
        onPause();
      }
      try
      {
        this.mep.mei = paramBufferInfo.presentationTimeUs;
        paramBufferInfo = new byte[paramBufferInfo.size];
        paramByteBuffer.get(paramBufferInfo);
        paramByteBuffer.clear();
        if (paramBufferInfo.length > 0) {
          this.awx.write(paramBufferInfo, 0, paramBufferInfo.length);
        }
        y.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", new Object[] { ayN(), Integer.valueOf(paramInt), Long.valueOf(this.mep.mei) });
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
      }
      catch (Exception paramMediaCodec)
      {
        for (;;)
        {
          y.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { ayN(), paramMediaCodec.toString() });
        }
      }
      return true;
    }
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    y.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { ayN() });
    paramMediaCodec.configure(this.meu, null, null, 0);
    return false;
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    y.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", new Object[] { ayN() });
    this.sampleRate = 0;
    this.channels = 0;
    if (this.awx != null) {}
    try
    {
      this.awx.flush();
      this.awx.release();
      label49:
      this.awx = null;
      return;
    }
    catch (Exception paramMediaCodec)
    {
      break label49;
    }
  }
  
  protected final void onPause()
  {
    y.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { ayN() });
    if ((this.awx != null) && (this.awx.getState() == 1)) {
      this.awx.pause();
    }
  }
  
  protected final void onStart()
  {
    y.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { ayN() });
    if ((this.awx != null) && (this.awx.getState() == 1)) {
      this.awx.play();
    }
  }
  
  public final void release()
  {
    try
    {
      this.awx.flush();
      this.awx.release();
      label14:
      super.release();
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    if (this.awx == null)
    {
      y.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { ayN(), Boolean.valueOf(paramBoolean) });
      this.dnJ = paramBoolean;
      return;
    }
    if (com.tencent.mm.compatible.util.d.gG(21))
    {
      y.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { ayN(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.awx.setStereoVolume(0.0F, 0.0F);
        return;
      }
      this.awx.setStereoVolume(1.0F, 1.0F);
      return;
    }
    y.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { ayN(), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.awx.setVolume(0.0F);
      return;
    }
    this.awx.setVolume(1.0F);
  }
  
  final String type()
  {
    return "audio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */