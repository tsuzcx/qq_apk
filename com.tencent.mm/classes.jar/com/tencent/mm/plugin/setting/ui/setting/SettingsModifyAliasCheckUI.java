package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<ye> Dbs;
  private boolean Dbt;
  private List<View> DcA;
  private LinearLayout Dcz;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(256550);
    this.Dbs = null;
    this.DcA = new ArrayList();
    this.Dbt = false;
    AppMethodBeat.o(256550);
  }
  
  public int getLayoutId()
  {
    return 2131496246;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256552);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackBtn(new SettingsModifyAliasCheckUI.1(this));
    this.Dcz = ((LinearLayout)findViewById(2131307711));
    ((TextView)findViewById(2131307712)).setOnClickListener(new SettingsModifyAliasCheckUI.2(this));
    this.Dbs = d.eSE();
    if ((this.Dbs != null) && (!this.Dbs.isEmpty()))
    {
      Log.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.Dbs.size()) });
      this.Dcz.removeAllViews();
      this.Dbt = true;
      int i = 0;
      if (i < this.Dbs.size())
      {
        View localView = View.inflate(this, 2131496258, null);
        this.DcA.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(2131304831);
        TextView localTextView2 = (TextView)localView.findViewById(2131304829);
        TextView localTextView3 = (TextView)localView.findViewById(2131304830);
        localTextView1.setText(((ye)this.Dbs.get(i)).title);
        if (!Util.isNullOrNil(((ye)this.Dbs.get(i)).desc))
        {
          localTextView2.setText(((ye)this.Dbs.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((ye)this.Dbs.get(i)).result);
        if (((ye)this.Dbs.get(i)).Lje)
        {
          localTextView3.setTextColor(getResources().getColor(2131100566));
          label328:
          if (i % 2 == 0) {
            localView.findViewById(2131304832).setVisibility(0);
          }
          localView.findViewById(2131304828).setVisibility(0);
          this.Dcz.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.Dbt) || (!((ye)this.Dbs.get(i)).Lje)) {
            break label429;
          }
        }
        label429:
        for (boolean bool = true;; bool = false)
        {
          this.Dbt = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(2131100996));
          break label328;
        }
      }
      AppMethodBeat.o(256552);
      return;
    }
    this.Dbt = false;
    this.Dcz.removeAllViews();
    AppMethodBeat.o(256552);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256551);
    super.onCreate(paramBundle);
    initView();
    if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(256551);
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