package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SettingsTeenModeIntro
  extends MMActivity
{
  private TextView MtA;
  private CheckBox Mtz;
  private Button wzY;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.MsD;
  }
  
  public void initView()
  {
    AppMethodBeat.i(259441);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.wzY = ((Button)findViewById(a.d.Msr));
    this.wzY.setEnabled(false);
    this.wzY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(259290);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_scenen", 3);
        c.b(SettingsTeenModeIntro.this, "teenmode", ".ui.TeenModeVerifyPwdUI", paramAnonymousView);
        h.ZvG.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(259469);
            SettingsTeenModeIntro.this.finish();
            AppMethodBeat.o(259469);
          }
        }, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(259290);
      }
    });
    this.Mtz = ((CheckBox)findViewById(a.d.Msj));
    Util.expandViewTouchArea(this.Mtz, 250, 250, 250, 250);
    this.Mtz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(259452);
        if (paramAnonymousBoolean)
        {
          SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(true);
          AppMethodBeat.o(259452);
          return;
        }
        SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(false);
        AppMethodBeat.o(259452);
      }
    });
    Object localObject = getString(a.g.MsY);
    String str = getString(a.g.MsZ);
    int i = ((String)localObject).lastIndexOf(str);
    if (i < 0)
    {
      AppMethodBeat.o(259441);
      return;
    }
    int j = str.length();
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.teenmode.b.a()
    {
      public final void eKQ()
      {
        AppMethodBeat.i(259554);
        SettingsTeenModeIntro.b(SettingsTeenModeIntro.this);
        AppMethodBeat.o(259554);
      }
    }, i, j + i, 18);
    this.MtA = ((TextView)findViewById(a.d.Msk));
    this.MtA.setOnTouchListener(new o(this));
    this.MtA.setClickable(true);
    this.MtA.setText((CharSequence)localObject);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(259430);
        SettingsTeenModeIntro.this.onBackPressed();
        AppMethodBeat.o(259430);
        return true;
      }
    });
    AppMethodBeat.o(259441);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259438);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    AppMethodBeat.o(259438);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro
 * JD-Core Version:    0.7.0.1
 */