package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerAnimationDemoUI
  extends MMSecDataActivity
{
  final String TAG = "MicroMsg.RepairerAnimationDemoUI";
  
  public final int getLayoutId()
  {
    return b.b.IwE;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(226802);
    super.onCreate(paramBundle);
    setMMTitle("动画组件Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = findViewById(com.tencent.mm.plugin.repairer.ui.b.a.IvM);
    ((Button)findViewById(com.tencent.mm.plugin.repairer.ui.b.a.ok_btn)).setOnClickListener((View.OnClickListener)new b(this, paramBundle));
    ((Button)findViewById(com.tencent.mm.plugin.repairer.ui.b.a.reset_btn)).setOnClickListener((View.OnClickListener)new c(paramBundle));
    AppMethodBeat.o(226802);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(RepairerAnimationDemoUI paramRepairerAnimationDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226660);
      this.Ixs.finish();
      AppMethodBeat.o(226660);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RepairerAnimationDemoUI paramRepairerAnimationDemoUI, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226879);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      try
      {
        paramView = this.Ixs.findViewById(com.tencent.mm.plugin.repairer.ui.b.a.Iww);
        p.j(paramView, "findViewById<MMEditText>(R.id.scale_value)");
        paramView = ((MMEditText)paramView).getText().toString();
        if (!Util.isNullOrNil(paramView))
        {
          f1 = Float.parseFloat(paramView);
          paramView = this.Ixs.findViewById(com.tencent.mm.plugin.repairer.ui.b.a.Iwv);
          p.j(paramView, "findViewById<MMEditText>(R.id.rotate_value)");
          paramView = ((MMEditText)paramView).getText().toString();
          if (!Util.isNullOrNil(paramView))
          {
            f2 = Float.parseFloat(paramView);
            paramView = this.Ixs.findViewById(com.tencent.mm.plugin.repairer.ui.b.a.IwB);
            p.j(paramView, "findViewById<MMEditText>(R.id.translation_value)");
            paramView = ((MMEditText)paramView).getText().toString();
            if (!Util.isNullOrNil(paramView))
            {
              f3 = Float.parseFloat(paramView);
              com.tencent.mm.ui.c.a.a.hF(paramBundle).aQ((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(226781);
                  View localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setScaleX(1.0F);
                  localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setScaleY(1.0F);
                  localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setTranslationX(0.0F);
                  localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setTranslationY(0.0F);
                  localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setRotationX(0.0F);
                  localView = this.Ixu.Ixt;
                  p.j(localView, "animationView");
                  localView.setRotationY(0.0F);
                  AppMethodBeat.o(226781);
                }
              }).a((com.tencent.mm.ui.c.a.b.a)2.Ixv).Vw(1000L).cH(f1).cI(f1).cF(f3).cG(f3).cE(f2).start();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(226879);
              return;
            }
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.w(this.Ixs.TAG, "start animation failed ".concat(String.valueOf(paramView)));
          continue;
          float f3 = 0.0F;
          continue;
          float f2 = 0.0F;
          continue;
          float f1 = 1.0F;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226794);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setScaleX(1.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setScaleY(1.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setTranslationX(0.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setTranslationY(0.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setRotationX(0.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setRotationY(0.0F);
      paramView = this.Ixt;
      p.j(paramView, "animationView");
      paramView.setRotation(0.0F);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerAnimationDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerAnimationDemoUI
 * JD-Core Version:    0.7.0.1
 */