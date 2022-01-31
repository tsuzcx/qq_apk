package com.tencent.mm.plugin.sns.ui.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

final class JsapiSnsLabelUI$3
  implements Runnable
{
  JsapiSnsLabelUI$3(JsapiSnsLabelUI paramJsapiSnsLabelUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(40174);
    JsapiSnsLabelUI.a(this.sjc).rSq = JsapiSnsLabelUI.l(this.sjc);
    if (JsapiSnsLabelUI.b(this.sjc) != null)
    {
      if (JsapiSnsLabelUI.j(this.sjc) == null) {
        JsapiSnsLabelUI.a(this.sjc, JsapiSnsLabelUI.b(this.sjc));
      }
      for (;;)
      {
        localObject = JsapiSnsLabelUI.b(this.sjc).iterator();
        while (((Iterator)localObject).hasNext())
        {
          JsapiSnsLabelUI.a(this.sjc);
          a.acg((String)((Iterator)localObject).next());
        }
        JsapiSnsLabelUI.j(this.sjc).addAll(JsapiSnsLabelUI.b(this.sjc));
      }
      Object localObject = new HashSet(JsapiSnsLabelUI.j(this.sjc));
      JsapiSnsLabelUI.j(this.sjc).clear();
      JsapiSnsLabelUI.j(this.sjc).addAll((Collection)localObject);
      JsapiSnsLabelUI.b(this.sjc).clear();
      JsapiSnsLabelUI.q(this.sjc);
      ((HashSet)localObject).clear();
    }
    JsapiSnsLabelUI.a(this.sjc).S(JsapiSnsLabelUI.j(this.sjc));
    JsapiSnsLabelUI.k(this.sjc);
    JsapiSnsLabelUI.a(this.sjc).notifyDataSetChanged();
    JsapiSnsLabelUI.g(this.sjc).Ro(JsapiSnsLabelUI.a(this.sjc).rSq);
    if ((JsapiSnsLabelUI.r(this.sjc) != null) && (JsapiSnsLabelUI.r(this.sjc).isShowing())) {
      JsapiSnsLabelUI.r(this.sjc).dismiss();
    }
    AppMethodBeat.o(40174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.3
 * JD-Core Version:    0.7.0.1
 */