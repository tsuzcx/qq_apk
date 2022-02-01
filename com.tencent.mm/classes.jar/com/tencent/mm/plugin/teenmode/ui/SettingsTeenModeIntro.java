package com.tencent.mm.plugin.teenmode.ui;

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
import com.tencent.mm.am.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.b.i;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class SettingsTeenModeIntro
  extends MMActivity
{
  private CheckBox Psx;
  private TextView Psy;
  private Button zWj;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWn;
  }
  
  public void initView()
  {
    AppMethodBeat.i(279055);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.zWj = ((Button)findViewById(a.d.SVX));
    this.zWj.setEnabled(false);
    this.zWj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(279116);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = k.a(SettingsTeenModeIntro.this.getContext(), SettingsTeenModeIntro.this.getString(a.g.loading_tips_1), false, null);
        new com.tencent.mm.plugin.teenmode.b.f().bFJ().a(SettingsTeenModeIntro.this).b(new com.tencent.mm.vending.c.a() {});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279116);
      }
    });
    this.Psx = ((CheckBox)findViewById(a.d.law_detail_cb));
    Util.expandViewTouchArea(this.Psx, 250, 250, 250, 250);
    this.Psx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(279117);
        if (paramAnonymousBoolean)
        {
          SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(true);
          AppMethodBeat.o(279117);
          return;
        }
        SettingsTeenModeIntro.a(SettingsTeenModeIntro.this).setEnabled(false);
        AppMethodBeat.o(279117);
      }
    });
    Object localObject = getString(a.g.SXu);
    String str = getString(a.g.SXv);
    int i = ((String)localObject).lastIndexOf(str);
    if (i < 0)
    {
      AppMethodBeat.o(279055);
      return;
    }
    int j = str.length();
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new i()
    {
      public final void fSP()
      {
        AppMethodBeat.i(279132);
        SettingsTeenModeIntro.b(SettingsTeenModeIntro.this);
        AppMethodBeat.o(279132);
      }
    }, i, j + i, 18);
    this.Psy = ((TextView)findViewById(a.d.law_detail_tv));
    this.Psy.setOnTouchListener(new s(this));
    this.Psy.setClickable(true);
    this.Psy.setText((CharSequence)localObject);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(279120);
        SettingsTeenModeIntro.this.onBackPressed();
        AppMethodBeat.o(279120);
        return true;
      }
    });
    AppMethodBeat.o(279055);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279041);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    AppMethodBeat.o(279041);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro
 * JD-Core Version:    0.7.0.1
 */