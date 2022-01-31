package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private TextView kPD;
  private int mScene = 0;
  private String utA = null;
  private boolean utB = true;
  private String utC = null;
  private List<Bankcard> utD = null;
  private TextView utx;
  private MaxListView uty;
  private WalletSelectBankcardUI.a utz = null;
  
  public int getLayoutId()
  {
    return 2130971250;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47659);
    super.onCreate(paramBundle);
    setMMTitle(2131304849);
    this.mScene = getInput().getInt("key_scene", 0);
    this.utA = getInput().getString("key_top_tips");
    this.utB = getInput().getBoolean("key_is_show_new_bankcard", true);
    this.utC = getInput().getString("bottom_tips");
    this.utD = getInput().getParcelableArrayList("key_showing_bankcards");
    if (this.utD == null) {
      this.utD = t.cTN().cUF();
    }
    this.utx = ((TextView)findViewById(2131829395));
    this.uty = ((MaxListView)findViewById(2131829396));
    this.kPD = ((TextView)findViewById(2131829397));
    if (!bo.isNullOrNil(this.utA))
    {
      this.utx.setVisibility(0);
      this.utx.setText(this.utA);
      if (bo.isNullOrNil(this.utC)) {
        break label342;
      }
      this.kPD.setVisibility(0);
      this.kPD.setText(this.utC);
    }
    for (;;)
    {
      if (this.mScene == 0)
      {
        this.kPD.setVisibility(0);
        paramBundle = new j(this);
        paramBundle.uqj = new WalletSelectBankcardUI.1(this);
        String str = getString(2131305627);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.kPD.setText(localSpannableString);
        this.kPD.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.utz = new WalletSelectBankcardUI.a(this, (byte)0);
      this.uty.setAdapter(this.utz);
      this.uty.setOnItemClickListener(new WalletSelectBankcardUI.2(this));
      AppMethodBeat.o(47659);
      return;
      this.utx.setVisibility(8);
      break;
      label342:
      this.kPD.setVisibility(8);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */