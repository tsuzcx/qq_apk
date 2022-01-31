package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.widget.Scroller;

public final class MusicViewPager$a
  extends Scroller
{
  private int duration = 1000;
  
  public MusicViewPager$a(MusicViewPager paramMusicViewPager, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.duration);
  }
  
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager.a
 * JD-Core Version:    0.7.0.1
 */