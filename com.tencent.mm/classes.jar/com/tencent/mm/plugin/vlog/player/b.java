package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.vlog.model.s;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", "duration", "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", "rotate", "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b
{
  int NkK;
  boolean NoX;
  final s NoY;
  boolean aMy;
  boolean active;
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  private int fSM;
  int height;
  private int ksu;
  private int ksv;
  private boolean lhf;
  int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3, s params, boolean paramBoolean)
  {
    this.NkK = paramInt1;
    this.ksu = paramInt2;
    this.ksv = paramInt3;
    this.NoY = params;
    this.lhf = paramBoolean;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public abstract void Aq(boolean paramBoolean);
  
  public abstract void O(long paramLong, boolean paramBoolean);
  
  public abstract void Ss(long paramLong);
  
  public final int aVr()
  {
    return this.fSM;
  }
  
  public final int getDrawHeight()
  {
    return this.ksv;
  }
  
  public final int getDrawWidth()
  {
    return this.ksu;
  }
  
  protected final boolean guj()
  {
    return this.lhf;
  }
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void resume();
  
  protected final void setMute(boolean paramBoolean)
  {
    this.lhf = paramBoolean;
  }
  
  public abstract void stop();
  
  public final void tm(int paramInt)
  {
    this.fSM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.b
 * JD-Core Version:    0.7.0.1
 */