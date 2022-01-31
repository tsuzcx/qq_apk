package com.tencent.mm.plugin.sns.ui.jsapi;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class JsapiSnsLabelUI$5
  implements ExpandableListView.OnGroupClickListener
{
  JsapiSnsLabelUI$5(JsapiSnsLabelUI paramJsapiSnsLabelUI) {}
  
  public final boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(40176);
    int i = JsapiSnsLabelUI.a(this.sjc).rSq;
    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if ((JsapiSnsLabelUI.a(this.sjc, paramInt).equals("visible")) || (JsapiSnsLabelUI.a(this.sjc, paramInt).equals("invisible")))
    {
      if ((JsapiSnsLabelUI.b(this.sjc) != null) && (JsapiSnsLabelUI.b(this.sjc).size() != 0) && (JsapiSnsLabelUI.cwW() == 0))
      {
        JsapiSnsLabelUI.b(this.sjc, paramInt);
        JsapiSnsLabelUI.c(this.sjc);
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
        AppMethodBeat.o(40176);
        return true;
      }
      if (JsapiSnsLabelUI.d(this.sjc))
      {
        JsapiSnsLabelUI.e(this.sjc);
        JsapiSnsLabelUI.b(this.sjc, paramInt);
        JsapiSnsLabelUI.a(this.sjc, h.b(this.sjc, this.sjc.getString(2131303858), false, null));
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
        AppMethodBeat.o(40176);
        return true;
      }
      if ((JsapiSnsLabelUI.a(this.sjc).rSp == null) || (JsapiSnsLabelUI.a(this.sjc).rSp.size() == 0))
      {
        JsapiSnsLabelUI.b(this.sjc, paramInt);
        JsapiSnsLabelUI.f(this.sjc);
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
        AppMethodBeat.o(40176);
        return true;
      }
      if (i == paramInt)
      {
        if (JsapiSnsLabelUI.g(this.sjc).isGroupExpanded(paramInt)) {
          JsapiSnsLabelUI.g(this.sjc).Rp(paramInt);
        }
        for (;;)
        {
          JsapiSnsLabelUI.a(this.sjc).rSq = paramInt;
          AppMethodBeat.o(40176);
          return true;
          JsapiSnsLabelUI.g(this.sjc).Ro(paramInt);
        }
      }
      if (JsapiSnsLabelUI.a(this.sjc, i).equals("visible"))
      {
        JsapiSnsLabelUI.g(this.sjc).collapseGroup(i);
        JsapiSnsLabelUI.a(this.sjc).rSs.clear();
        JsapiSnsLabelUI.a(this.sjc).rSu.clear();
      }
      for (;;)
      {
        JsapiSnsLabelUI.g(this.sjc).post(new JsapiSnsLabelUI.5.1(this, paramInt));
        break;
        if (JsapiSnsLabelUI.a(this.sjc, i).equals("invisible"))
        {
          JsapiSnsLabelUI.g(this.sjc).collapseGroup(i);
          JsapiSnsLabelUI.a(this.sjc).rSt.clear();
          JsapiSnsLabelUI.a(this.sjc).rSv.clear();
        }
      }
    }
    if ((i >= 0) && ((JsapiSnsLabelUI.a(this.sjc, i).equals("visible")) || (JsapiSnsLabelUI.a(this.sjc, i).equals("invisible")))) {
      JsapiSnsLabelUI.g(this.sjc).Rp(i);
    }
    JsapiSnsLabelUI.a(this.sjc).rSq = paramInt;
    AppMethodBeat.o(40176);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.5
 * JD-Core Version:    0.7.0.1
 */