package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerAnimationDemoUI
  extends BaseRepairerUI
{
  private final String TAG = "MicroMsg.RepairerAnimationDemoUI";
  
  private static final void a(RepairerAnimationDemoUI paramRepairerAnimationDemoUI, View paramView1, View paramView2)
  {
    AppMethodBeat.i(278279);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerAnimationDemoUI);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerAnimationDemoUI, "this$0");
    s.u(paramView1, "$animationView");
    try
    {
      paramView2 = ((MMEditText)paramRepairerAnimationDemoUI.findViewById(b.c.Ova)).getText().toString();
      if (!Util.isNullOrNil(paramView2))
      {
        f1 = Float.parseFloat(paramView2);
        paramView2 = ((MMEditText)paramRepairerAnimationDemoUI.findViewById(b.c.OuZ)).getText().toString();
        if (!Util.isNullOrNil(paramView2))
        {
          f2 = Float.parseFloat(paramView2);
          paramView2 = ((MMEditText)paramRepairerAnimationDemoUI.findViewById(b.c.Ovi)).getText().toString();
          if (!Util.isNullOrNil(paramView2))
          {
            f3 = Float.parseFloat(paramView2);
            com.tencent.mm.ui.anim.a.a.kY(paramView1).aY(new RepairerAnimationDemoUI..ExternalSyntheticLambda4(paramView1)).a(RepairerAnimationDemoUI..ExternalSyntheticLambda3.INSTANCE).zE(1000L).dU(f1).dV(f1).dS(f3).dT(f3).dR(f2).start();
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(278279);
            return;
          }
        }
      }
    }
    catch (Exception paramView1)
    {
      for (;;)
      {
        Log.w(paramRepairerAnimationDemoUI.TAG, s.X("start animation failed ", paramView1));
        continue;
        float f3 = 0.0F;
        continue;
        float f2 = 0.0F;
        continue;
        float f1 = 1.0F;
      }
    }
  }
  
  private static final boolean a(RepairerAnimationDemoUI paramRepairerAnimationDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278251);
    s.u(paramRepairerAnimationDemoUI, "this$0");
    paramRepairerAnimationDemoUI.finish();
    AppMethodBeat.o(278251);
    return true;
  }
  
  private static final void cZ(float paramFloat) {}
  
  private static final void iP(View paramView)
  {
    AppMethodBeat.i(278257);
    s.u(paramView, "$animationView");
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setRotationY(0.0F);
    AppMethodBeat.o(278257);
  }
  
  private static final void r(View paramView1, View paramView2)
  {
    AppMethodBeat.i(278285);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$animationView");
    paramView1.setScaleX(1.0F);
    paramView1.setScaleY(1.0F);
    paramView1.setTranslationX(0.0F);
    paramView1.setTranslationY(0.0F);
    paramView1.setRotationX(0.0F);
    paramView1.setRotationY(0.0F);
    paramView1.setRotation(0.0F);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278285);
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovq;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278314);
    super.onCreate(paramBundle);
    setMMTitle("动画组件Demo");
    setBackBtn(new RepairerAnimationDemoUI..ExternalSyntheticLambda0(this));
    paramBundle = findViewById(b.c.Otq);
    ((Button)findViewById(b.c.ok_btn)).setOnClickListener(new RepairerAnimationDemoUI..ExternalSyntheticLambda2(this, paramBundle));
    ((Button)findViewById(b.c.reset_btn)).setOnClickListener(new RepairerAnimationDemoUI..ExternalSyntheticLambda1(paramBundle));
    AppMethodBeat.o(278314);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerAnimationDemoUI
 * JD-Core Version:    0.7.0.1
 */