package com.tencent.mm.plugin.repairer.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerXLogUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "sendLogFile", "prefix", "", "LogFile", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerXLogUI
  extends BaseRepairerUI
{
  private static final void a(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277864);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramRepairerXLogUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramRepairerXLogUI, "this$0");
    paramView = com.tencent.mm.loader.i.b.bmG();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("原有的日志文件：");
    localObject2 = y.eB(paramView, false);
    if (localObject2 == null) {}
    for (paramView = null;; paramView = (List)paramView)
    {
      ((StringBuilder)localObject1).append(paramView);
      ((TextView)paramRepairerXLogUI.findViewById(b.c.OuB)).setText((CharSequence)((StringBuilder)localObject1).toString());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277864);
      return;
      paramView = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramView.add(s.X(((j)((Iterator)localObject2).next()).name, "\n"));
      }
    }
  }
  
  private static final boolean a(RepairerXLogUI paramRepairerXLogUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277852);
    s.u(paramRepairerXLogUI, "this$0");
    paramRepairerXLogUI.finish();
    AppMethodBeat.o(277852);
    return true;
  }
  
  private void aUl(String paramString)
  {
    AppMethodBeat.i(277848);
    s.u(paramString, "prefix");
    d.B((kotlin.g.a.a)new RepairerXLogUI.d(paramString, this));
    AppMethodBeat.o(277848);
  }
  
  private static final void b(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277870);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    d.B((kotlin.g.a.a)new RepairerXLogUI.b(paramRepairerXLogUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277870);
  }
  
  private static final void c(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277874);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    d.B((kotlin.g.a.a)new RepairerXLogUI.c(paramRepairerXLogUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277874);
  }
  
  private static final void d(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277882);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    paramRepairerXLogUI.aUl("MM");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277882);
  }
  
  private static final void e(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277884);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    paramRepairerXLogUI.aUl("PUSH");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277884);
  }
  
  private static final void f(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277889);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    paramRepairerXLogUI.aUl("TOOL");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277889);
  }
  
  private static final void g(RepairerXLogUI paramRepairerXLogUI, View paramView)
  {
    AppMethodBeat.i(277898);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerXLogUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerXLogUI, "this$0");
    paramRepairerXLogUI.aUl("TOOLSMP");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerXLogUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277898);
  }
  
  public final int getLayoutId()
  {
    return b.d.Owg;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277962);
    super.onCreate(paramBundle);
    setMMTitle("XLog工具集");
    setBackBtn(new RepairerXLogUI..ExternalSyntheticLambda0(this));
    paramBundle = findViewById(b.c.OtC);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda2(this));
    }
    paramBundle = findViewById(b.c.OtE);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda7(this));
    }
    paramBundle = findViewById(b.c.Oux);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda4(this));
    }
    paramBundle = findViewById(b.c.Ovb);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda6(this));
    }
    paramBundle = findViewById(b.c.Ovc);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda3(this));
    }
    paramBundle = findViewById(b.c.Ovd);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda5(this));
    }
    paramBundle = findViewById(b.c.Ove);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerXLogUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(277962);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerXLogUI
 * JD-Core Version:    0.7.0.1
 */