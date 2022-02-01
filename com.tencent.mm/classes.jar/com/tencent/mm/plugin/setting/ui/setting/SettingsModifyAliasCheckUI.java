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
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<ui> wgv;
  private boolean wgw;
  private LinearLayout why;
  private List<View> whz;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(186566);
    this.wgv = null;
    this.whz = new ArrayList();
    this.wgw = false;
    AppMethodBeat.o(186566);
  }
  
  public int getLayoutId()
  {
    return 2131495385;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186568);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186564);
        paramAnonymousMenuItem = new bd();
        paramAnonymousMenuItem.hY(SettingsAliasUI.wgy);
        paramAnonymousMenuItem.dFf = 7L;
        paramAnonymousMenuItem.aBj();
        SettingsModifyAliasCheckUI.this.onBackPressed();
        AppMethodBeat.o(186564);
        return true;
      }
    });
    this.why = ((LinearLayout)findViewById(2131304658));
    ((TextView)findViewById(2131304659)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186565);
        a.b(SettingsModifyAliasCheckUI.this, SettingsModifyAliasCheckUI.this.getString(2131766392, new Object[] { ac.eFu() }), -1, true);
        paramAnonymousView = new bd();
        paramAnonymousView.hY(SettingsAliasUI.wgy);
        paramAnonymousView.dFf = 8L;
        paramAnonymousView.aBj();
        AppMethodBeat.o(186565);
      }
    });
    this.wgv = c.dnw();
    if ((this.wgv != null) && (!this.wgv.isEmpty()))
    {
      ad.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.wgv.size()) });
      this.why.removeAllViews();
      this.wgw = true;
      int i = 0;
      if (i < this.wgv.size())
      {
        View localView = View.inflate(this, 2131495397, null);
        this.whz.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(2131302431);
        TextView localTextView2 = (TextView)localView.findViewById(2131302429);
        TextView localTextView3 = (TextView)localView.findViewById(2131302430);
        localTextView1.setText(((ui)this.wgv.get(i)).title);
        if (!bt.isNullOrNil(((ui)this.wgv.get(i)).desc))
        {
          localTextView2.setText(((ui)this.wgv.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((ui)this.wgv.get(i)).result);
        if (((ui)this.wgv.get(i)).CVZ)
        {
          localTextView3.setTextColor(getResources().getColor(2131100464));
          label328:
          if (i % 2 == 0) {
            localView.findViewById(2131302432).setVisibility(0);
          }
          localView.findViewById(2131302428).setVisibility(0);
          this.why.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.wgw) || (!((ui)this.wgv.get(i)).CVZ)) {
            break label429;
          }
        }
        label429:
        for (boolean bool = true;; bool = false)
        {
          this.wgw = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(2131100800));
          break label328;
        }
      }
      AppMethodBeat.o(186568);
      return;
    }
    this.wgw = false;
    this.why.removeAllViews();
    AppMethodBeat.o(186568);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186567);
    super.onCreate(paramBundle);
    initView();
    if (g.Zd().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(186567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI
 * JD-Core Version:    0.7.0.1
 */