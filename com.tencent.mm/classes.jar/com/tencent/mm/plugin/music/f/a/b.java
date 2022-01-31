package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.av.e;
import com.tencent.mm.sdk.platformtools.ai;

public abstract class b
{
  protected f mAR;
  public g mAS = new g();
  protected e myu;
  
  public final void J(e parame)
  {
    this.myu = parame;
  }
  
  public abstract void JG(String paramString);
  
  public final void a(f paramf)
  {
    this.mAR = paramf;
  }
  
  public abstract boolean bnE();
  
  public abstract int bnF();
  
  public abstract String bnG();
  
  public abstract int getDuration();
  
  public void hS(boolean paramBoolean)
  {
    if (this.mAR != null) {
      ai.d(new b.1(this, paramBoolean));
    }
  }
  
  public void hT(boolean paramBoolean)
  {
    if (this.mAR != null) {
      ai.d(new b.4(this, paramBoolean));
    }
  }
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.mAR != null) {
      ai.d(new b.2(this));
    }
  }
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
  
  public final void uU(int paramInt)
  {
    if (this.mAR != null) {
      ai.d(new b.3(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */