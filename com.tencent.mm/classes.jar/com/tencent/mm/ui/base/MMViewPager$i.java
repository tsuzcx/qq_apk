package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ah;

final class MMViewPager$i
  extends MMViewPager.a
{
  float[] kLk = new float[9];
  
  public MMViewPager$i(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
  }
  
  public final void play()
  {
    MMViewPager.c(this.uZn).post(new MMViewPager.i.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.i
 * JD-Core Version:    0.7.0.1
 */