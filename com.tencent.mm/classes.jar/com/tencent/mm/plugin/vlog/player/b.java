package com.tencent.mm.plugin.vlog.player;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  boolean BHY;
  int BHZ;
  final com.tencent.mm.plugin.vlog.model.l BIa;
  boolean active;
  boolean bdb;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int dGc;
  int gLD;
  int gLE;
  int height;
  boolean hvp;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.vlog.model.l paraml, boolean paramBoolean)
  {
    this.BHZ = paramInt1;
    this.gLD = paramInt2;
    this.gLE = paramInt3;
    this.BIa = paraml;
    this.hvp = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void Bm(long paramLong);
  
  public abstract void H(long paramLong, boolean paramBoolean);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void sR(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */