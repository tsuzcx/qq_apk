package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "curNum", "", "buildData", "", "Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI$UserData;", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "Adapter", "UserData", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerAccessibilityDemoUI
  extends BaseRepairerUI
{
  private int OwS;
  
  private static final void E(TextView paramTextView)
  {
    AppMethodBeat.i(278357);
    s.u(paramTextView, "$warnTv");
    paramTextView.setText((CharSequence)"Warn Text");
    AppMethodBeat.o(278357);
  }
  
  private static final void a(RepairerAccessibilityDemoUI paramRepairerAccessibilityDemoUI, View paramView)
  {
    AppMethodBeat.i(278317);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerAccessibilityDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerAccessibilityDemoUI, "this$0");
    paramView = ((EditText)paramRepairerAccessibilityDemoUI.findViewById(b.c.OuG)).getText().toString();
    localObject = k.aeZF;
    ((com.tencent.mm.plugin.repairer.ui.demo.a.a)k.d((AppCompatActivity)paramRepairerAccessibilityDemoUI).q(com.tencent.mm.plugin.repairer.ui.demo.a.a.class)).setValue("number_key", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278317);
  }
  
  private static final boolean a(RepairerAccessibilityDemoUI paramRepairerAccessibilityDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278351);
    s.u(paramRepairerAccessibilityDemoUI, "this$0");
    paramRepairerAccessibilityDemoUI.finish();
    AppMethodBeat.o(278351);
    return true;
  }
  
  private static final boolean a(String paramString, Context paramContext, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(278327);
    s.u(paramString, "$string");
    if (paramIntent != null)
    {
      paramContext = paramIntent.getComponent();
      if (paramContext != null)
      {
        paramContext = paramContext.getClassName();
        if ((paramContext != null) && (n.a((CharSequence)paramContext, (CharSequence)paramString, false) == true))
        {
          AppMethodBeat.o(278327);
          return true;
        }
      }
    }
    AppMethodBeat.o(278327);
    return false;
  }
  
  private static final void b(RepairerAccessibilityDemoUI paramRepairerAccessibilityDemoUI, View paramView)
  {
    AppMethodBeat.i(278335);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerAccessibilityDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerAccessibilityDemoUI, "this$0");
    paramRepairerAccessibilityDemoUI.OwS += 1;
    ((TextView)paramRepairerAccessibilityDemoUI.findViewById(b.c.OuR)).setText((CharSequence)String.valueOf(paramRepairerAccessibilityDemoUI.OwS));
    c.a(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda5(((EditText)paramRepairerAccessibilityDemoUI.findViewById(b.c.OuG)).getText().toString()));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278335);
  }
  
  private static final void c(RepairerAccessibilityDemoUI paramRepairerAccessibilityDemoUI, View paramView)
  {
    AppMethodBeat.i(278343);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerAccessibilityDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerAccessibilityDemoUI, "this$0");
    Toast.makeText((Context)paramRepairerAccessibilityDemoUI, (CharSequence)"repairer_dischild_click_btn click!", 0).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278343);
  }
  
  private static final void d(RepairerAccessibilityDemoUI paramRepairerAccessibilityDemoUI, View paramView)
  {
    AppMethodBeat.i(278368);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerAccessibilityDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerAccessibilityDemoUI, "this$0");
    paramRepairerAccessibilityDemoUI = (TextView)paramRepairerAccessibilityDemoUI.findViewById(b.c.OuX);
    paramRepairerAccessibilityDemoUI.setText((CharSequence)"I am warning!");
    paramView.postDelayed(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda6(paramRepairerAccessibilityDemoUI), 3000L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278368);
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovp;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278432);
    super.onCreate(paramBundle);
    ((Button)findViewById(b.c.OuF)).setOnClickListener(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda2(this));
    ((Button)findViewById(b.c.OuE)).setOnClickListener(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda1(this));
    ((Button)findViewById(b.c.OuM)).setOnClickListener(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda3(this));
    setBackBtn(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda0(this));
    ((Button)findViewById(b.c.OuW)).setOnClickListener(new RepairerAccessibilityDemoUI..ExternalSyntheticLambda4(this));
    paramBundle = (RecyclerView)findViewById(b.c.OuK);
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)new RepairerAccessibilityDemoUI.a(p.listOf(new RepairerAccessibilityDemoUI.b[] { new RepairerAccessibilityDemoUI.b("小赵"), new RepairerAccessibilityDemoUI.b("小钱"), new RepairerAccessibilityDemoUI.b("小孙"), new RepairerAccessibilityDemoUI.b("小李"), new RepairerAccessibilityDemoUI.b("小周"), new RepairerAccessibilityDemoUI.b("小吴"), new RepairerAccessibilityDemoUI.b("小郑"), new RepairerAccessibilityDemoUI.b("小王"), new RepairerAccessibilityDemoUI.b("小a"), new RepairerAccessibilityDemoUI.b("小b"), new RepairerAccessibilityDemoUI.b("小c"), new RepairerAccessibilityDemoUI.b("小d"), new RepairerAccessibilityDemoUI.b("小e"), new RepairerAccessibilityDemoUI.b("小f"), new RepairerAccessibilityDemoUI.b("小g"), new RepairerAccessibilityDemoUI.b("小h") })));
    AppMethodBeat.o(278432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(278421);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.repairer.ui.demo.a.a.class);
    AppMethodBeat.o(278421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerAccessibilityDemoUI
 * JD-Core Version:    0.7.0.1
 */