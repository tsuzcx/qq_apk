package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<wr> yGu;
  private boolean yGv;
  private LinearLayout yHx;
  private List<View> yHy;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(220999);
    this.yGu = null;
    this.yHy = new ArrayList();
    this.yGv = false;
    AppMethodBeat.o(220999);
  }
  
  public int getLayoutId()
  {
    return 2131495385;
  }
  
  public void initView()
  {
    AppMethodBeat.i(221001);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new SettingsModifyAliasCheckUI.1(this));
    this.yHx = ((LinearLayout)findViewById(2131304658));
    ((TextView)findViewById(2131304659)).setOnClickListener(new SettingsModifyAliasCheckUI.2(this));
    this.yGu = c.dNh();
    if ((this.yGu != null) && (!this.yGu.isEmpty()))
    {
      ad.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.yGu.size()) });
      this.yHx.removeAllViews();
      this.yGv = true;
      int i = 0;
      if (i < this.yGu.size())
      {
        View localView = View.inflate(this, 2131495397, null);
        this.yHy.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(2131302431);
        TextView localTextView2 = (TextView)localView.findViewById(2131302429);
        TextView localTextView3 = (TextView)localView.findViewById(2131302430);
        localTextView1.setText(((wr)this.yGu.get(i)).title);
        if (!bt.isNullOrNil(((wr)this.yGu.get(i)).desc))
        {
          localTextView2.setText(((wr)this.yGu.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((wr)this.yGu.get(i)).result);
        if (((wr)this.yGu.get(i)).FVU)
        {
          localTextView3.setTextColor(getResources().getColor(2131100464));
          label328:
          if (i % 2 == 0) {
            localView.findViewById(2131302432).setVisibility(0);
          }
          localView.findViewById(2131302428).setVisibility(0);
          this.yHx.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.yGv) || (!((wr)this.yGu.get(i)).FVU)) {
            break label429;
          }
        }
        label429:
        for (boolean bool = true;; bool = false)
        {
          this.yGv = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(2131100800));
          break label328;
        }
      }
      AppMethodBeat.o(221001);
      return;
    }
    this.yGv = false;
    this.yHx.removeAllViews();
    AppMethodBeat.o(221001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221000);
    super.onCreate(paramBundle);
    initView();
    if (g.acA().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(221000);
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