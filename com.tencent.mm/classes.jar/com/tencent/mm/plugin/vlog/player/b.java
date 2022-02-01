package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.vlog.model.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  boolean Apr;
  int Aps;
  final i Apt;
  boolean aSG;
  boolean active;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int duc;
  int grV;
  int grW;
  boolean hdh;
  int height;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, i parami, boolean paramBoolean)
  {
    this.Aps = paramInt1;
    this.grV = paramInt2;
    this.grW = paramInt3;
    this.Apt = parami;
    this.hdh = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void H(long paramLong, boolean paramBoolean);
  
  public abstract boolean isOES();
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void sk(boolean paramBoolean);
  
  public abstract void stop();
  
  public abstract void yJ(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */