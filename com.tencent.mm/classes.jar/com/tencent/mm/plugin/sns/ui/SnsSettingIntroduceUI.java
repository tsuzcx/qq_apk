package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.i;

public class SnsSettingIntroduceUI
  extends MMActivity
{
  private Button AzD;
  private Button AzE;
  private Intent AzF;
  
  public int getLayoutId()
  {
    return 2131495585;
  }
  
  @TargetApi(17)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99076);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.AzF = getIntent();
    this.AzD = ((Button)findViewById(2131297026));
    this.AzD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99073);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.yxI.f(14090, new Object[] { Integer.valueOf(3) });
        d.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(SnsSettingIntroduceUI.this));
        SnsSettingIntroduceUI.this.finish();
        SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99073);
      }
    });
    g.yxI.f(14090, new Object[] { Integer.valueOf(1) });
    this.AzE = ((Button)findViewById(2131300595));
    this.AzE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99074);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new az();
        paramAnonymousView.dmV.index = 3;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
        paramAnonymousView = new Intent();
        d.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsUI", paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("enter_scene", e.i.Jpl);
        d.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
        g.yxI.f(14090, new Object[] { Integer.valueOf(2) });
        SnsSettingIntroduceUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      g.yxI.f(14090, new Object[] { Integer.valueOf(3) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI
 * JD-Core Version:    0.7.0.1
 */