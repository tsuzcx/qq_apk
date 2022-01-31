package com.tencent.mm.plugin.music.ui;

import android.view.View;
import java.util.HashMap;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, long paramLong) {}
  
  public final void run()
  {
    View localView = (View)this.mBz.mBv.get(Integer.valueOf(this.doB));
    if (localView != null) {
      ((b.a)localView.getTag()).mBH.setCurrentTime(this.mBy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b.1
 * JD-Core Version:    0.7.0.1
 */