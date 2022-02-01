package com.tencent.mm.plugin.vlog.player;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  boolean BZx;
  int BZy;
  final com.tencent.mm.plugin.vlog.model.l BZz;
  boolean active;
  boolean bdb;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int dHi;
  int gOm;
  int gOn;
  int height;
  boolean hyd;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.vlog.model.l paraml, boolean paramBoolean)
  {
    this.BZy = paramInt1;
    this.gOm = paramInt2;
    this.gOn = paramInt3;
    this.BZz = paraml;
    this.hyd = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void BK(long paramLong);
  
  public abstract void J(long paramLong, boolean paramBoolean);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void sY(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */