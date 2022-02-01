package com.tencent.mm.plugin.ringtone.j;

import com.tencent.mm.plugin.ringtone.g.b.b;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/service/RingtonePlayer;", "", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "soundInfo", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "isOutCall", "", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;Z)V", "()Z", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "getSoundInfo", "()Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "adjustVolume", "", "left", "", "right", "getCurrentPosition", "", "getStreamType", "", "isPlaying", "pause", "play", "prepare", "seekStartMs", "release", "seek", "timeMs", "setMute", "mute", "setOnErrorListener", "listener", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "error", "stopAsync", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public static final b.a ODY = new b.a((byte)0);
  final com.tencent.mm.plugin.thumbplayer.a.b GvR;
  private final b.b ODZ;
  private final boolean OEa;
  
  public b(com.tencent.mm.plugin.thumbplayer.a.b paramb, b.b paramb1, boolean paramBoolean)
  {
    this.GvR = paramb;
    this.ODZ = paramb1;
    this.OEa = paramBoolean;
  }
  
  public abstract void aC(kotlin.g.a.b<? super Exception, ah> paramb);
  
  public abstract void da(float paramFloat);
  
  protected final b.b gOK()
  {
    return this.ODZ;
  }
  
  public abstract long getCurrentPosition();
  
  public abstract int getStreamType();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void release();
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void stopAsync();
  
  public abstract void tL(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.j.b
 * JD-Core Version:    0.7.0.1
 */