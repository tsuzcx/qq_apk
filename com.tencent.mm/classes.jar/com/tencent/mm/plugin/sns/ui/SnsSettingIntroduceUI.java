package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bj;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.n;

public class SnsSettingIntroduceUI
  extends MMActivity
{
  private Button RwT;
  private Button RwU;
  private Intent RwV;
  
  public int getLayoutId()
  {
    return b.g.sns_setting_introduce_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99076);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.RwV = getIntent();
    this.RwT = ((Button)findViewById(b.f.back_btn));
    this.RwT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99073);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.OAn.b(14090, new Object[] { Integer.valueOf(3) });
        c.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(SnsSettingIntroduceUI.this));
        SnsSettingIntroduceUI.this.finish();
        SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99073);
      }
    });
    h.OAn.b(14090, new Object[] { Integer.valueOf(1) });
    this.RwU = ((Button)findViewById(b.f.go_btn));
    this.RwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99074);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new bj();
        paramAnonymousView.hBv.index = 3;
        paramAnonymousView.publish();
        paramAnonymousView = new Intent();
        c.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsUI", paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("enter_scene", f.n.adwH);
        c.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
        h.OAn.b(14090, new Object[] { Integer.valueOf(2) });
        SnsSettingIntroduceUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99074);
      }
    });
    AppMethodBeat.o(99076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99075);
    super.onDestroy();
    AppMethodBeat.o(99075);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99077);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      h.OAn.b(14090, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(99077);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(99077);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI
 * JD-Core Version:    0.7.0.1
 */