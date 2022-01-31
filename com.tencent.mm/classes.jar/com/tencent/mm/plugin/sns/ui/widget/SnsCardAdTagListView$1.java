package com.tencent.mm.plugin.sns.ui.widget;

import android.text.Layout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class SnsCardAdTagListView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsCardAdTagListView$1(SnsCardAdTagListView paramSnsCardAdTagListView, TextView paramTextView, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(40464);
    if ((this.smR.getLayout() != null) && (!bo.aa(this.smR.getLayout().getText())) && (this.smR.getLayout().getText().charAt(0) == '…'))
    {
      this.smT.removeView(this.smS);
      SnsCardAdTagListView.a(this.smT).remove(this.smS);
    }
    this.smT.getViewTreeObserver().removeOnPreDrawListener(this);
    AppMethodBeat.o(40464);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView.1
 * JD-Core Version:    0.7.0.1
 */