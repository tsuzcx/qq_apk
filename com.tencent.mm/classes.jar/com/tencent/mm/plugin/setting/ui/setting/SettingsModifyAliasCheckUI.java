package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<aah> PrL;
  private boolean PrM;
  private LinearLayout Pug;
  private List<View> Puh;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(298878);
    this.PrL = null;
    this.Puh = new ArrayList();
    this.PrM = false;
    AppMethodBeat.o(298878);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_alias_check;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298893);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(299301);
        paramAnonymousMenuItem = new jy();
        paramAnonymousMenuItem.sq(SettingsAliasUI.PrO);
        paramAnonymousMenuItem.ila = 7L;
        paramAnonymousMenuItem.bMH();
        SettingsModifyAliasCheckUI.this.onBackPressed();
        AppMethodBeat.o(299301);
        return true;
      }
    });
    this.Pug = ((LinearLayout)findViewById(b.f.settings_modify_alias_conditions));
    ((TextView)findViewById(b.f.settings_modify_alias_help)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(299316);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.account.sdk.c.a.b(SettingsModifyAliasCheckUI.this, SettingsModifyAliasCheckUI.this.getString(b.i.set_alias_help_url, new Object[] { LocaleUtil.getApplicationLanguage() }), -1, true);
        paramAnonymousView = new jy();
        paramAnonymousView.sq(SettingsAliasUI.PrO);
        paramAnonymousView.ila = 8L;
        paramAnonymousView.bMH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299316);
      }
    });
    this.PrL = d.gUP();
    if ((this.PrL != null) && (!this.PrL.isEmpty()))
    {
      Log.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.PrL.size()) });
      this.Pug.removeAllViews();
      this.PrM = true;
      int i = 0;
      if (i < this.PrL.size())
      {
        View localView = View.inflate(this, b.g.settings_modify_alias_check_condition, null);
        this.Puh.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(b.f.modify_alias_condition_title);
        TextView localTextView2 = (TextView)localView.findViewById(b.f.modify_alias_condition_desc);
        TextView localTextView3 = (TextView)localView.findViewById(b.f.modify_alias_condition_result);
        localTextView1.setText(((aah)this.PrL.get(i)).title);
        if (!Util.isNullOrNil(((aah)this.PrL.get(i)).desc))
        {
          localTextView2.setText(((aah)this.PrL.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((aah)this.PrL.get(i)).result);
        if (((aah)this.PrL.get(i)).ZiF)
        {
          localTextView3.setTextColor(getResources().getColor(b.c.green_text_color));
          label336:
          if (i % 2 == 0) {
            localView.findViewById(b.f.modify_alias_condition_top_divider).setVisibility(0);
          }
          localView.findViewById(b.f.modify_alias_condition_bottom_divider).setVisibility(0);
          this.Pug.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.PrM) || (!((aah)this.PrL.get(i)).ZiF)) {
            break label440;
          }
        }
        label440:
        for (boolean bool = true;; bool = false)
        {
          this.PrM = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(b.c.red_text_color));
          break label336;
        }
      }
      AppMethodBeat.o(298893);
      return;
    }
    this.PrM = false;
    this.Pug.removeAllViews();
    AppMethodBeat.o(298893);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298882);
    super.onCreate(paramBundle);
    initView();
    if (i.aRC().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(298882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI
 * JD-Core Version:    0.7.0.1
 */