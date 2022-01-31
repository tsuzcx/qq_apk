package com.tencent.mm.plugin.sns.ui.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class JsapiSnsLabelUI$10
  implements Runnable
{
  JsapiSnsLabelUI$10(JsapiSnsLabelUI paramJsapiSnsLabelUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(40181);
    JsapiSnsLabelUI.a(this.sjc, (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().bKQ());
    if (JsapiSnsLabelUI.j(this.sjc) == null) {
      JsapiSnsLabelUI.a(this.sjc, new ArrayList());
    }
    if (!bo.isNullOrNil(this.rSk)) {
      if (!JsapiSnsLabelUI.j(this.sjc).contains(this.rSk)) {
        JsapiSnsLabelUI.j(this.sjc).add(this.rSk);
      }
    }
    for (int i = JsapiSnsLabelUI.j(this.sjc).indexOf(this.rSk);; i = -1)
    {
      JsapiSnsLabelUI.a(this.sjc).S(JsapiSnsLabelUI.j(this.sjc));
      JsapiSnsLabelUI.k(this.sjc);
      JsapiSnsLabelUI.a(this.sjc).rSq = JsapiSnsLabelUI.l(this.sjc);
      if ((!bo.isNullOrNil(this.rSk)) && (i != -1))
      {
        if (JsapiSnsLabelUI.l(this.sjc) != this.sjc.siX) {
          break label252;
        }
        JsapiSnsLabelUI.a(this.sjc).rSs.add(this.rSk);
        JsapiSnsLabelUI.a(this.sjc).rSu.clear();
      }
      for (;;)
      {
        JsapiSnsLabelUI.a(this.sjc).notifyDataSetChanged();
        JsapiSnsLabelUI.g(this.sjc).expandGroup(JsapiSnsLabelUI.l(this.sjc));
        JsapiSnsLabelUI.m(this.sjc);
        AppMethodBeat.o(40181);
        return;
        label252:
        if (JsapiSnsLabelUI.l(this.sjc) == this.sjc.siY)
        {
          JsapiSnsLabelUI.a(this.sjc).rSt.add(this.rSk);
          JsapiSnsLabelUI.a(this.sjc).rSv.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.10
 * JD-Core Version:    0.7.0.1
 */