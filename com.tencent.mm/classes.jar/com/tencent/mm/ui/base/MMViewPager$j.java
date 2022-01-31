package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ah;

final class MMViewPager$j
  extends MMViewPager.a
{
  float[] kLk = new float[9];
  
  public MMViewPager$j(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
  }
  
  public final void play()
  {
    MMViewPager.c(this.uZn).post(new MMViewPager.j.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.j
 * JD-Core Version:    0.7.0.1
 */