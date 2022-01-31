package com.tencent.mm.plugin.sns.ui;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.ui.tools.e;

final class SnsSightPlayerUI$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsSightPlayerUI$3(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final boolean onPreDraw()
  {
    this.pdk.oge.getViewTreeObserver().removeOnPreDrawListener(this);
    this.pdk.itA.a(this.pdk.oge, SnsSightPlayerUI.t(this.pdk), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.3
 * JD-Core Version:    0.7.0.1
 */