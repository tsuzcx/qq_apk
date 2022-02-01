package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;

public abstract class CardLayoutManager$d
{
  protected int JNi;
  protected int JNj;
  CardLayoutManager JNk;
  protected int JNl;
  
  public abstract void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3);
  
  public final void aft(int paramInt)
  {
    this.JNl = paramInt;
  }
  
  public boolean afu(int paramInt)
  {
    return false;
  }
  
  public void gl(View paramView) {}
  
  public final void jz(int paramInt1, int paramInt2)
  {
    this.JNi = paramInt1;
    this.JNj = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.d
 * JD-Core Version:    0.7.0.1
 */