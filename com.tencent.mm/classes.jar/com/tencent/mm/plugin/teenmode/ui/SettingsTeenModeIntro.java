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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SettingsTeenModeIntro
  extends MMActivity
{
  private CheckBox FWn;
  private TextView FWo;
  private Button sUc;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496270;
  }
  
  public void initView()
  {
    AppMethodBeat.i(187390);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.sUc = ((Button)findViewById(2131308921));
    this.sUc.setEnabled(false);
    this.sUc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187385);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeIntro.this.finish();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_scenen", 3);
        c.b(SettingsTeenModeIntro.this, "teenmode", ".ui.TeenModeVerifyPwdUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187385);
      }
    });
    this.FWn = ((CheckBox)findViewById(2131303057));
    Util.expandViewTouchArea(this.FWn, 250, 250, 250, 250);
    this.FWn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187386);
        if (paramAnonymousBoolean)
        {
          SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(true);
          AppMethodBeat.o(187386);
          return;
        }
        SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(false);
        AppMethodBeat.o(187386);
      }
    });
    Object localObject = getString(2131766656);
    String str = getString(2131766657);
    int i = ((String)localObject).lastIndexOf(str);
    if (i < 0)
    {
      AppMethodBeat.o(187390);
      return;
    }
    int j = str.length();
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.teenmode.b.a()
    {
      public final void ebS()
      {
        AppMethodBeat.i(187387);
        SettingsTeenModeIntro.b(SettingsTeenModeIntro.this);
        AppMethodBeat.o(187387);
      }
    }, i, j + i, 18);
    this.FWo = ((TextView)findViewById(2131303058));
    this.FWo.setOnTouchListener(new o(this));
    this.FWo.setClickable(true);
    this.FWo.setText((CharSequence)localObject);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187388);
        SettingsTeenModeIntro.this.onBackPressed();
        AppMethodBeat.o(187388);
        return true;
      }
    });
    AppMethodBeat.o(187390);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187389);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    AppMethodBeat.o(187389);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro
 * JD-Core Version:    0.7.0.1
 */