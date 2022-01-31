package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.am;

final class c
{
  am byQ = new am(new c.1(this), false);
  View view;
  
  public c(View paramView)
  {
    this.view = paramView;
  }
  
  public final void bAB()
  {
    if (this.view != null) {
      this.view.setKeepScreenOn(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.c
 * JD-Core Version:    0.7.0.1
 */