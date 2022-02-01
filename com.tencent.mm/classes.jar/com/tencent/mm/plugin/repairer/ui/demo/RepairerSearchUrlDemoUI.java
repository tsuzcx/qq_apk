package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenWeiXinPage;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerSearchUrlDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerSearchUrlDemoUI
  extends BaseRepairerUI
{
  private final String TAG = "MicroMsg.RepairerAnimationDemoUI";
  
  private static final void a(RepairerSearchUrlDemoUI paramRepairerSearchUrlDemoUI, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(278331);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerSearchUrlDemoUI);
    localb.cH(paramf);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSearchUrlDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSearchUrlDemoUI, "this$0");
    s.u(paramf, "$editText");
    paramRepairerSearchUrlDemoUI.hideVKB();
    paramRepairerSearchUrlDemoUI = JsApiOpenWeiXinPage.XnJ;
    JsApiOpenWeiXinPage.dM(((EditText)paramf.aqH).getText().toString(), true);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerSearchUrlDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278331);
  }
  
  private static final boolean a(RepairerSearchUrlDemoUI paramRepairerSearchUrlDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278323);
    s.u(paramRepairerSearchUrlDemoUI, "this$0");
    paramRepairerSearchUrlDemoUI.finish();
    AppMethodBeat.o(278323);
    return true;
  }
  
  private static final void eV(View paramView)
  {
    AppMethodBeat.i(278336);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerSearchUrlDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerSearchUrlDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278336);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvQ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278366);
    super.onCreate(paramBundle);
    setMMTitle("搜索页面跳转");
    setBackBtn(new RepairerSearchUrlDemoUI..ExternalSyntheticLambda0(this));
    paramBundle = new ah.f();
    paramBundle.aqH = findViewById(b.c.OuZ);
    ((Button)findViewById(b.c.ok_btn)).setOnClickListener(new RepairerSearchUrlDemoUI..ExternalSyntheticLambda1(this, paramBundle));
    ((Button)findViewById(b.c.reset_btn)).setOnClickListener(RepairerSearchUrlDemoUI..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(278366);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerSearchUrlDemoUI
 * JD-Core Version:    0.7.0.1
 */