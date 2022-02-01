package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.vlog.model.s;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  int TXY;
  final s UcR;
  boolean UcS;
  boolean active;
  boolean cGv;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  private int hYK;
  int height;
  private int mWn;
  private int mWo;
  private boolean nLP;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, s params, boolean paramBoolean)
  {
    this.TXY = paramInt1;
    this.mWn = paramInt2;
    this.mWo = paramInt3;
    this.UcR = params;
    this.nLP = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void FP(boolean paramBoolean);
  
  public abstract void Z(long paramLong, boolean paramBoolean);
  
  public final int getDrawHeight()
  {
    return this.mWo;
  }
  
  public final int getDrawWidth()
  {
    return this.mWn;
  }
  
  protected final boolean hRX()
  {
    return this.nLP;
  }
  
  public final int hRY()
  {
    return this.hYK;
  }
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  protected final void setMute(boolean paramBoolean)
  {
    this.nLP = paramBoolean;
  }
  
  public abstract void stop();
  
  public final void th(int paramInt)
  {
    this.hYK = paramInt;
  }
  
  public abstract void wG(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */