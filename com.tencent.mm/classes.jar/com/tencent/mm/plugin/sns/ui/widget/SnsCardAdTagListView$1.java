package com.tencent.mm.plugin.sns.ui.widget;

import android.text.Layout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class SnsCardAdTagListView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsCardAdTagListView$1(SnsCardAdTagListView paramSnsCardAdTagListView, TextView paramTextView, View paramView) {}
  
  public final boolean onPreDraw()
  {
    if ((this.prh.getLayout() != null) && (!bk.L(this.prh.getLayout().getText())) && (this.prh.getLayout().getText().charAt(0) == '…'))
    {
      this.prj.removeView(this.pri);
      SnsCardAdTagListView.a(this.prj).remove(this.pri);
    }
    this.prj.getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView.1
 * JD-Core Version:    0.7.0.1
 */