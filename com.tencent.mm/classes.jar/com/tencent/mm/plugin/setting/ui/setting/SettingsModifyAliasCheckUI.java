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
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<yk> JgT;
  private boolean JgU;
  private LinearLayout Jia;
  private List<View> Jib;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(263658);
    this.JgT = null;
    this.Jib = new ArrayList();
    this.JgU = false;
    AppMethodBeat.o(263658);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_alias_check;
  }
  
  public void initView()
  {
    AppMethodBeat.i(263661);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    setBackBtn(new SettingsModifyAliasCheckUI.1(this));
    this.Jia = ((LinearLayout)findViewById(b.f.settings_modify_alias_conditions));
    ((TextView)findViewById(b.f.settings_modify_alias_help)).setOnClickListener(new SettingsModifyAliasCheckUI.2(this));
    this.JgT = d.fFH();
    if ((this.JgT != null) && (!this.JgT.isEmpty()))
    {
      Log.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.JgT.size()) });
      this.Jia.removeAllViews();
      this.JgU = true;
      int i = 0;
      if (i < this.JgT.size())
      {
        View localView = View.inflate(this, b.g.settings_modify_alias_check_condition, null);
        this.Jib.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(b.f.modify_alias_condition_title);
        TextView localTextView2 = (TextView)localView.findViewById(b.f.modify_alias_condition_desc);
        TextView localTextView3 = (TextView)localView.findViewById(b.f.modify_alias_condition_result);
        localTextView1.setText(((yk)this.JgT.get(i)).title);
        if (!Util.isNullOrNil(((yk)this.JgT.get(i)).desc))
        {
          localTextView2.setText(((yk)this.JgT.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((yk)this.JgT.get(i)).result);
        if (((yk)this.JgT.get(i)).Skv)
        {
          localTextView3.setTextColor(getResources().getColor(b.c.green_text_color));
          label336:
          if (i % 2 == 0) {
            localView.findViewById(b.f.modify_alias_condition_top_divider).setVisibility(0);
          }
          localView.findViewById(b.f.modify_alias_condition_bottom_divider).setVisibility(0);
          this.Jia.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.JgU) || (!((yk)this.JgT.get(i)).Skv)) {
            break label440;
          }
        }
        label440:
        for (boolean bool = true;; bool = false)
        {
          this.JgU = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(b.c.red_text_color));
          break label336;
        }
      }
      AppMethodBeat.o(263661);
      return;
    }
    this.JgU = false;
    this.Jia.removeAllViews();
    AppMethodBeat.o(263661);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263659);
    super.onCreate(paramBundle);
    initView();
    if (h.axc().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(263659);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI
 * JD-Core Version:    0.7.0.1
 */