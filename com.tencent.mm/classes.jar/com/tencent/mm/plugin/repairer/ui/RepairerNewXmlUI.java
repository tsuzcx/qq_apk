package com.tencent.mm.plugin.repairer.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerNewXmlUI
  extends BaseRepairerUI
{
  private static final void a(RepairerNewXmlUI paramRepairerNewXmlUI, View paramView)
  {
    AppMethodBeat.i(277832);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerNewXmlUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerNewXmlUI, "this$0");
    paramView = new dl();
    paramView.IIs = 10002;
    paramRepairerNewXmlUI = ((MMEditText)paramRepairerNewXmlUI.findViewById(b.c.Ovm)).getText().toString();
    paramView.YFG = new etl().btH(paramRepairerNewXmlUI);
    paramRepairerNewXmlUI = new g.a(paramView, false, false, false);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b(paramRepairerNewXmlUI);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277832);
  }
  
  private static final boolean a(RepairerNewXmlUI paramRepairerNewXmlUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277821);
    s.u(paramRepairerNewXmlUI, "this$0");
    paramRepairerNewXmlUI.finish();
    AppMethodBeat.o(277821);
    return false;
  }
  
  public final int getLayoutId()
  {
    return b.d.OvX;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277843);
    super.onCreate(paramBundle);
    setMMTitle("微信推送NewXML");
    setBackBtn(new RepairerNewXmlUI..ExternalSyntheticLambda0(this));
    findViewById(b.c.ok_btn).setOnClickListener(new RepairerNewXmlUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(277843);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerNewXmlUI
 * JD-Core Version:    0.7.0.1
 */