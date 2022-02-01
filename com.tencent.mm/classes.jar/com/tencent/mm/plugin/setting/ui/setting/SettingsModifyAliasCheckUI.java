package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<us> xrL;
  private boolean xrM;
  private LinearLayout xsO;
  private List<View> xsP;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(191032);
    this.xrL = null;
    this.xsP = new ArrayList();
    this.xrM = false;
    AppMethodBeat.o(191032);
  }
  
  public int getLayoutId()
  {
    return 2131495385;
  }
  
  public void initView()
  {
    AppMethodBeat.i(191034);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191030);
        paramAnonymousMenuItem = new cp();
        paramAnonymousMenuItem.kA(SettingsAliasUI.xrO);
        paramAnonymousMenuItem.dCS = 7L;
        paramAnonymousMenuItem.aHZ();
        SettingsModifyAliasCheckUI.this.onBackPressed();
        AppMethodBeat.o(191030);
        return true;
      }
    });
    this.xsO = ((LinearLayout)findViewById(2131304658));
    ((TextView)findViewById(2131304659)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191031);
        a.b(SettingsModifyAliasCheckUI.this, SettingsModifyAliasCheckUI.this.getString(2131766392, new Object[] { ab.eUO() }), -1, true);
        paramAnonymousView = new cp();
        paramAnonymousView.kA(SettingsAliasUI.xrO);
        paramAnonymousView.dCS = 8L;
        paramAnonymousView.aHZ();
        AppMethodBeat.o(191031);
      }
    });
    this.xrL = c.dBE();
    if ((this.xrL != null) && (!this.xrL.isEmpty()))
    {
      ac.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.xrL.size()) });
      this.xsO.removeAllViews();
      this.xrM = true;
      int i = 0;
      if (i < this.xrL.size())
      {
        View localView = View.inflate(this, 2131495397, null);
        this.xsP.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(2131302431);
        TextView localTextView2 = (TextView)localView.findViewById(2131302429);
        TextView localTextView3 = (TextView)localView.findViewById(2131302430);
        localTextView1.setText(((us)this.xrL.get(i)).title);
        if (!bs.isNullOrNil(((us)this.xrL.get(i)).desc))
        {
          localTextView2.setText(((us)this.xrL.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((us)this.xrL.get(i)).result);
        if (((us)this.xrL.get(i)).EoI)
        {
          localTextView3.setTextColor(getResources().getColor(2131100464));
          label328:
          if (i % 2 == 0) {
            localView.findViewById(2131302432).setVisibility(0);
          }
          localView.findViewById(2131302428).setVisibility(0);
          this.xsO.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.xrM) || (!((us)this.xrL.get(i)).EoI)) {
            break label429;
          }
        }
        label429:
        for (boolean bool = true;; bool = false)
        {
          this.xrM = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(2131100800));
          break label328;
        }
      }
      AppMethodBeat.o(191034);
      return;
    }
    this.xrM = false;
    this.xsO.removeAllViews();
    AppMethodBeat.o(191034);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191033);
    super.onCreate(paramBundle);
    initView();
    if (g.ZY().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(191033);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI
 * JD-Core Version:    0.7.0.1
 */