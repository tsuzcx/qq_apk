package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI
  extends MMActivity
  implements c.a
{
  private p efs;
  private MMEditText egJ;
  private com.tencent.mm.sdk.b.c ehn;
  private j.b qFI;
  private boolean qFK;
  
  public SettingsModifyNameUI()
  {
    AppMethodBeat.i(127310);
    this.qFK = false;
    this.efs = null;
    this.ehn = new SettingsModifyNameUI.1(this);
    AppMethodBeat.o(127310);
  }
  
  public final void JU()
  {
    AppMethodBeat.i(127315);
    h.h(this, 2131303316, 2131303319);
    AppMethodBeat.o(127315);
  }
  
  public int getLayoutId()
  {
    return 2130970696;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127313);
    setMMTitle(2131303315);
    this.egJ = ((MMEditText)findViewById(2131827623));
    this.egJ.setText(j.b(this, (String)g.RL().Ru().get(4, null), this.egJ.getTextSize()));
    this.egJ.setSelection(this.egJ.getText().length());
    this.egJ.addTextChangedListener(new SettingsModifyNameUI.2(this));
    com.tencent.mm.ui.tools.b.c localc = com.tencent.mm.ui.tools.b.c.d(this.egJ).hR(1, 32);
    localc.AyD = false;
    localc.a(null);
    addTextOptionMenu(0, getString(2131297063), new SettingsModifyNameUI.3(this), null, q.b.zby);
    enableOptionMenu(false);
    setBackBtn(new SettingsModifyNameUI.4(this));
    AppMethodBeat.o(127313);
  }
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(127314);
    ab.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : ".concat(String.valueOf(paramString)));
    this.qFK = true;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.efs = h.b(localAppCompatActivity, getString(2131298567), false, null);
    this.qFI = r.u(2, paramString);
    AppMethodBeat.o(127314);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127311);
    super.onCreate(paramBundle);
    a.ymk.c(this.ehn);
    initView();
    AppMethodBeat.o(127311);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127312);
    a.ymk.d(this.ehn);
    super.onDestroy();
    AppMethodBeat.o(127312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(127316);
    h.h(this, 2131303317, 2131303319);
    AppMethodBeat.o(127316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI
 * JD-Core Version:    0.7.0.1
 */