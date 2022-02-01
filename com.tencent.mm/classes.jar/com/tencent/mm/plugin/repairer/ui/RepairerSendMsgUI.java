package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerSendMsgUI
  extends BaseRepairerUI
{
  private final String TAG = "MicroMsg.RepairerSendMsgUI";
  
  private static final void a(RepairerSendMsgUI paramRepairerSendMsgUI, View paramView)
  {
    AppMethodBeat.i(277912);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerSendMsgUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSendMsgUI, "this$0");
    paramView = ((EditText)paramRepairerSendMsgUI.findViewById(b.c.OtY)).getText().toString();
    localObject = com.tencent.mm.plugin.repairer.ui.c.a.Oyl;
    com.tencent.mm.plugin.repairer.ui.c.a.bI((Context)paramRepairerSendMsgUI, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277912);
  }
  
  private static final boolean a(RepairerSendMsgUI paramRepairerSendMsgUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277899);
    s.u(paramRepairerSendMsgUI, "this$0");
    paramRepairerSendMsgUI.finish();
    AppMethodBeat.o(277899);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.Owa;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277932);
    super.onCreate(paramBundle);
    setMMTitle("发送微信消息");
    setBackBtn(new RepairerSendMsgUI..ExternalSyntheticLambda0(this));
    findViewById(b.c.ok_btn).setOnClickListener(new RepairerSendMsgUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(277932);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerSendMsgUI
 * JD-Core Version:    0.7.0.1
 */