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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Calendar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sport/ui/SportExptSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-sport_release"})
public final class SportExptSettingUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2131496542;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199379);
    super.onCreate(paramBundle);
    setMMTitle(2131758927);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(2131305592).setOnClickListener((View.OnClickListener)new b(this));
    findViewById(2131305616).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(199379);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199376);
      this.Fkg.finish();
      AppMethodBeat.o(199376);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199377);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.Fkg.findViewById(2131309674);
      p.g(paramView, "findViewById<MMEditText>(R.id.value_et)");
      paramView = ((MMEditText)paramView).getText().toString();
      localObject = (CharSequence)paramView;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          i = Integer.parseInt(paramView);
          paramView = Calendar.getInstance();
          paramView.set(11, 0);
          paramView.set(12, 0);
          paramView.set(13, 0);
          p.g(paramView, "cal");
          long l1 = paramView.getTimeInMillis();
          long l2 = System.currentTimeMillis();
          ((com.tencent.mm.plugin.sport.a.b)g.af(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, ck.getFingerprint());
          Toast.makeText((Context)this.Fkg, 2131755898, 0).show();
        }
        a.a(this, "com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199377);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SportExptSettingUI paramSportExptSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199378);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://fm.m.tencent.com/an:mhr/sports/");
      c.b((Context)this.Fkg, "webview", ".ui.tools.WebviewMpUI", paramView);
      a.a(this, "com/tencent/mm/plugin/sport/ui/SportExptSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199378);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportExptSettingUI
 * JD-Core Version:    0.7.0.1
 */