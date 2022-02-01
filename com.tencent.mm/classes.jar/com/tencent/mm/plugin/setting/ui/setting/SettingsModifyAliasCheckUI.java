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
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI
  extends MMWizardActivity
{
  private List<wu> yWD;
  private boolean yWE;
  private LinearLayout yXH;
  private List<View> yXI;
  
  public SettingsModifyAliasCheckUI()
  {
    AppMethodBeat.i(190374);
    this.yWD = null;
    this.yXI = new ArrayList();
    this.yWE = false;
    AppMethodBeat.o(190374);
  }
  
  public int getLayoutId()
  {
    return 2131495385;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190376);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(190372);
        paramAnonymousMenuItem = new dh();
        paramAnonymousMenuItem.mO(SettingsAliasUI.yWG);
        paramAnonymousMenuItem.dQX = 7L;
        paramAnonymousMenuItem.aLH();
        SettingsModifyAliasCheckUI.this.onBackPressed();
        AppMethodBeat.o(190372);
        return true;
      }
    });
    this.yXH = ((LinearLayout)findViewById(2131304658));
    ((TextView)findViewById(2131304659)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190373);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.account.a.b.a.b(SettingsModifyAliasCheckUI.this, SettingsModifyAliasCheckUI.this.getString(2131766392, new Object[] { ad.fom() }), -1, true);
        paramAnonymousView = new dh();
        paramAnonymousView.mO(SettingsAliasUI.yWG);
        paramAnonymousView.dQX = 8L;
        paramAnonymousView.aLH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190373);
      }
    });
    this.yWD = d.dQD();
    if ((this.yWD != null) && (!this.yWD.isEmpty()))
    {
      ae.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", new Object[] { Integer.valueOf(this.yWD.size()) });
      this.yXH.removeAllViews();
      this.yWE = true;
      int i = 0;
      if (i < this.yWD.size())
      {
        View localView = View.inflate(this, 2131495397, null);
        this.yXI.add(localView);
        TextView localTextView1 = (TextView)localView.findViewById(2131302431);
        TextView localTextView2 = (TextView)localView.findViewById(2131302429);
        TextView localTextView3 = (TextView)localView.findViewById(2131302430);
        localTextView1.setText(((wu)this.yWD.get(i)).title);
        if (!bu.isNullOrNil(((wu)this.yWD.get(i)).desc))
        {
          localTextView2.setText(((wu)this.yWD.get(i)).desc);
          localTextView2.setVisibility(0);
        }
        localTextView3.setText(((wu)this.yWD.get(i)).result);
        if (((wu)this.yWD.get(i)).Got)
        {
          localTextView3.setTextColor(getResources().getColor(2131100464));
          label328:
          if (i % 2 == 0) {
            localView.findViewById(2131302432).setVisibility(0);
          }
          localView.findViewById(2131302428).setVisibility(0);
          this.yXH.addView(localView, new LinearLayout.LayoutParams(-1, -2));
          if ((!this.yWE) || (!((wu)this.yWD.get(i)).Got)) {
            break label429;
          }
        }
        label429:
        for (boolean bool = true;; bool = false)
        {
          this.yWE = bool;
          i += 1;
          break;
          localTextView3.setTextColor(getResources().getColor(2131100800));
          break label328;
        }
      }
      AppMethodBeat.o(190376);
      return;
    }
    this.yWE = false;
    this.yXH.removeAllViews();
    AppMethodBeat.o(190376);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190375);
    super.onCreate(paramBundle);
    initView();
    if (g.acL().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(190375);
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