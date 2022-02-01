package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.gl;
import com.tencent.mm.f.a.gl.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Calendar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sport/ui/SportExptSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-sport_release"})
public final class SportExptSettingUI
  extends MMActivity
{
  final String TAG = "MicroMsg.Repairer.SportExptSettingUI";
  
  public final int getLayoutId()
  {
    return b.c.sport_reset_step_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221793);
    super.onCreate(paramBundle);
    setMMTitle(b.e.exdevice_wechat_sport);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(b.b.ok_btn).setOnClickListener((View.OnClickListener)new b(this));
    findViewById(b.b.open_btn).setOnClickListener((View.OnClickListener)new c(this));
    findViewById(b.b.get_sport_config_btn).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(221793);
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
    a(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(221683);
      this.LyR.finish();
      AppMethodBeat.o(221683);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221449);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LyR.findViewById(b.b.value_et);
      p.j(paramView, "findViewById<MMEditText>(R.id.value_et)");
      paramView = n.bHC(((MMEditText)paramView).getText().toString());
      if (paramView != null) {}
      for (int i = paramView.intValue();; i = 1)
      {
        paramView = Calendar.getInstance();
        paramView.set(11, 0);
        paramView.set(12, 0);
        paramView.set(13, 0);
        p.j(paramView, "cal");
        long l1 = paramView.getTimeInMillis();
        long l2 = System.currentTimeMillis();
        ((com.tencent.mm.plugin.sport.a.b)h.ae(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, cl.hAM());
        Toast.makeText((Context)this.LyR, b.e.app_modify_success, 0).show();
        a.a(this, "com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221449);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221397);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://fm.m.tencent.com/an:mhr/sports/");
      c.b((Context)this.LyR, "webview", ".ui.tools.WebviewMpUI", paramView);
      a.a(this, "com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221397);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221543);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new gl();
      paramView.fCE.action = 3;
      EventCenter.instance.publish((IEvent)paramView);
      Log.i(this.LyR.TAG, "getconfig:  " + paramView.fCF.fCJ + ' ' + paramView.fCF.config);
      a.a(this, "com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportExptSettingUI
 * JD-Core Version:    0.7.0.1
 */