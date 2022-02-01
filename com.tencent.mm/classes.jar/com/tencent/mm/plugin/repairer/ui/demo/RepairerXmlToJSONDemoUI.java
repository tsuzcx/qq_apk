package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerXmlToJSONDemoUI
  extends BaseRepairerUI
{
  public static final RepairerXmlToJSONDemoUI.a OxA;
  
  static
  {
    AppMethodBeat.i(278180);
    OxA = new RepairerXmlToJSONDemoUI.a((byte)0);
    AppMethodBeat.o(278180);
  }
  
  private static final void a(RepairerXmlToJSONDemoUI paramRepairerXmlToJSONDemoUI, View paramView)
  {
    AppMethodBeat.i(278163);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerXmlToJSONDemoUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXmlToJSONDemoUI, "this$0");
    paramView = ((MMEditText)paramRepairerXmlToJSONDemoUI.findViewById(b.c.Ovm)).getText().toString();
    LifecycleScope.launchDefault$default(paramRepairerXmlToJSONDemoUI.getUICScope(), null, (m)new RepairerXmlToJSONDemoUI.b(paramView, null), 1, null);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278163);
  }
  
  private static final boolean a(RepairerXmlToJSONDemoUI paramRepairerXmlToJSONDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278157);
    s.u(paramRepairerXmlToJSONDemoUI, "this$0");
    paramRepairerXmlToJSONDemoUI.finish();
    AppMethodBeat.o(278157);
    return false;
  }
  
  private static final void b(RepairerXmlToJSONDemoUI paramRepairerXmlToJSONDemoUI, View paramView)
  {
    AppMethodBeat.i(278169);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerXmlToJSONDemoUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXmlToJSONDemoUI, "this$0");
    paramView = ((MMEditText)paramRepairerXmlToJSONDemoUI.findViewById(b.c.Ovm)).getText().toString();
    LifecycleScope.launchDefault$default(paramRepairerXmlToJSONDemoUI.getUICScope(), null, (m)new RepairerXmlToJSONDemoUI.c(paramView, null), 1, null);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278169);
  }
  
  private static final void c(RepairerXmlToJSONDemoUI paramRepairerXmlToJSONDemoUI, View paramView)
  {
    AppMethodBeat.i(278175);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerXmlToJSONDemoUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXmlToJSONDemoUI, "this$0");
    paramView = ((MMEditText)paramRepairerXmlToJSONDemoUI.findViewById(b.c.Ovm)).getText().toString();
    LifecycleScope.launchDefault$default(paramRepairerXmlToJSONDemoUI.getUICScope(), null, (m)new RepairerXmlToJSONDemoUI.d(paramView, null), 1, null);
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerXmlToJSONDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278175);
  }
  
  public final int getLayoutId()
  {
    return b.d.Owh;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278221);
    super.onCreate(paramBundle);
    setMMTitle("微信XmlToJson");
    setBackBtn(new RepairerXmlToJSONDemoUI..ExternalSyntheticLambda0(this));
    findViewById(b.c.Ovn).setOnClickListener(new RepairerXmlToJSONDemoUI..ExternalSyntheticLambda2(this));
    findViewById(b.c.Oue).setOnClickListener(new RepairerXmlToJSONDemoUI..ExternalSyntheticLambda3(this));
    findViewById(b.c.Ous).setOnClickListener(new RepairerXmlToJSONDemoUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(278221);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerXmlToJSONDemoUI
 * JD-Core Version:    0.7.0.1
 */