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
import com.tencent.mm.g.a.ax;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.i;

public class SnsSettingIntroduceUI
  extends MMActivity
{
  private Button yQW;
  private Button yQX;
  private Intent yQY;
  
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
    this.yQY = getIntent();
    this.yQW = ((Button)findViewById(2131297026));
    this.yQW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99073);
        h.wUl.f(14090, new Object[] { Integer.valueOf(3) });
        d.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(SnsSettingIntroduceUI.this));
        SnsSettingIntroduceUI.this.finish();
        SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
        AppMethodBeat.o(99073);
      }
    });
    h.wUl.f(14090, new Object[] { Integer.valueOf(1) });
    this.yQX = ((Button)findViewById(2131300595));
    this.yQX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99074);
        paramAnonymousView = new ax();
        paramAnonymousView.daz.index = 3;
        a.GpY.l(paramAnonymousView);
        paramAnonymousView = new Intent();
        d.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsUI", paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("enter_scene", e.i.Hhn);
        d.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
        h.wUl.f(14090, new Object[] { Integer.valueOf(2) });
        SnsSettingIntroduceUI.this.finish();
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
      h.wUl.f(14090, new Object[] { Integer.valueOf(3) });
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