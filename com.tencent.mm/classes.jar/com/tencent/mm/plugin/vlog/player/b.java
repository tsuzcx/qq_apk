package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.vlog.model.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  boolean aRL;
  boolean active;
  int dwp;
  boolean gCJ;
  int guK;
  int guL;
  int height;
  int width;
  int yZN;
  int yZO;
  int yZP;
  int yZQ;
  boolean yZR;
  int yZS;
  final d yZT;
  
  public b(int paramInt1, int paramInt2, int paramInt3, d paramd, boolean paramBoolean)
  {
    this.yZS = paramInt1;
    this.guK = paramInt2;
    this.guL = paramInt3;
    this.yZT = paramd;
    this.gCJ = paramBoolean;
    this.yZN = -1;
    this.yZO = -1;
    this.yZP = -1;
    this.yZQ = -1;
  }
  
  public abstract void H(long paramLong, boolean paramBoolean);
  
  public abstract boolean isOES();
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void rl(boolean paramBoolean);
  
  public abstract void stop();
  
  public abstract void ug(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */