package com.tencent.mm.plugin.sns.ui.jsapi;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsapiSnsLabelUI$6
  implements ExpandableListView.OnChildClickListener
{
  JsapiSnsLabelUI$6(JsapiSnsLabelUI paramJsapiSnsLabelUI) {}
  
  public final boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(40177);
    if (paramInt2 == JsapiSnsLabelUI.a(this.sjc).getChildrenCount(paramInt1) - 1)
    {
      JsapiSnsLabelUI.b(this.sjc, paramInt1);
      JsapiSnsLabelUI.f(this.sjc);
    }
    for (;;)
    {
      AppMethodBeat.o(40177);
      return false;
      paramExpandableListView = (String)JsapiSnsLabelUI.a(this.sjc).getChild(paramInt1, paramInt2);
      JsapiSnsLabelUI.a(this.sjc);
      a.acg(paramExpandableListView);
      if (paramInt1 == this.sjc.siX) {
        JsapiSnsLabelUI.a(this.sjc, 1, JsapiSnsLabelUI.a(this.sjc).rSs, paramExpandableListView, paramView);
      } else if (paramInt1 == this.sjc.siY) {
        JsapiSnsLabelUI.a(this.sjc, 2, JsapiSnsLabelUI.a(this.sjc).rSt, paramExpandableListView, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.6
 * JD-Core Version:    0.7.0.1
 */