package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.vlog.model.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  boolean GBl;
  final s GBm;
  int Gxi;
  boolean active;
  boolean bcY;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int dYT;
  int hEp;
  int hEq;
  int height;
  boolean isb;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, s params, boolean paramBoolean)
  {
    this.Gxi = paramInt1;
    this.hEp = paramInt2;
    this.hEq = paramInt3;
    this.GBm = params;
    this.isb = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void KV(long paramLong);
  
  public abstract void O(long paramLong, boolean paramBoolean);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void stop();
  
  public abstract void wC(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */