package com.tencent.mm.plugin.ringtone.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.g.b.b;
import com.tencent.mm.plugin.thumbplayer.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/service/TPRingtonePlayer;", "Lcom/tencent/mm/plugin/ringtone/service/RingtonePlayer;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "soundInfo", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "isOutCall", "", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;Z)V", "mPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "adjustVolume", "", "left", "", "right", "getCurrentPosition", "", "getStreamType", "", "isPlaying", "pause", "play", "prepare", "seekStartMs", "release", "seek", "timeMs", "setMute", "mute", "setOnErrorListener", "listener", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "error", "stopAsync", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  private final com.tencent.mm.plugin.thumbplayer.e.b CNh;
  
  public d(com.tencent.mm.plugin.thumbplayer.a.b paramb, b.b paramb1, boolean paramBoolean)
  {
    super(paramb, paramb1, paramBoolean);
    AppMethodBeat.i(272858);
    paramb = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
    paramb = MMApplicationContext.getContext();
    s.s(paramb, "getContext()");
    this.CNh = com.tencent.mm.plugin.thumbplayer.e.d.a.ks(paramb);
    AppMethodBeat.o(272858);
  }
  
  public final void aC(kotlin.g.a.b<? super Exception, ah> paramb)
  {
    AppMethodBeat.i(272910);
    s.u(paramb, "listener");
    this.CNh.j((q)new d.a(paramb));
    AppMethodBeat.o(272910);
  }
  
  public final void da(float paramFloat)
  {
    AppMethodBeat.i(272876);
    Object localObject = this.CNh;
    Log.i(((com.tencent.mm.plugin.thumbplayer.e.b)localObject).TAG, s.X("setVolume: ", Float.valueOf(paramFloat)));
    localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flb;
    if (localObject != null) {
      ((a)localObject).setAudioGainRatio(paramFloat);
    }
    AppMethodBeat.o(272876);
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(272900);
    long l = this.CNh.getCurrentPositionMs();
    AppMethodBeat.o(272900);
    return l;
  }
  
  public final int getStreamType()
  {
    AppMethodBeat.i(272893);
    int i = gOK().streamType;
    AppMethodBeat.o(272893);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(272889);
    boolean bool = this.CNh.isPlaying();
    AppMethodBeat.o(272889);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272873);
    com.tencent.mm.plugin.thumbplayer.e.b.b(this.CNh);
    AppMethodBeat.o(272873);
  }
  
  public final void play()
  {
    AppMethodBeat.i(272871);
    this.CNh.hLh();
    AppMethodBeat.o(272871);
  }
  
  public final void release()
  {
    AppMethodBeat.i(272924);
    this.CNh.recycle();
    AppMethodBeat.o(272924);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272881);
    this.CNh.setMute(paramBoolean);
    AppMethodBeat.o(272881);
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(272915);
    this.CNh.stopAsync();
    AppMethodBeat.o(272915);
  }
  
  public final void tL(long paramLong)
  {
    AppMethodBeat.i(272864);
    this.CNh.setMediaInfo(this.GvR);
    this.CNh.setLoop(this.GvR.loop);
    this.CNh.Flr = true;
    this.CNh.TFv = paramLong;
    this.CNh.TFq = gOK().streamType;
    AppMethodBeat.o(272864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.j.d
 * JD-Core Version:    0.7.0.1
 */