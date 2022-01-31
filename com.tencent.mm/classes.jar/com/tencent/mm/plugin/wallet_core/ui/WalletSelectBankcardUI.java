package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private int fzn = 0;
  private TextView iIX;
  private TextView qGr;
  private MaxListView qGs;
  private WalletSelectBankcardUI.a qGt = null;
  private String qGu = null;
  private boolean qGv = true;
  private String qGw = null;
  private List<Bankcard> qGx = null;
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_select_bankcard_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_bancard_list_dialog_title);
    this.fzn = this.BX.getInt("key_scene", 0);
    this.qGu = this.BX.getString("key_top_tips");
    this.qGv = this.BX.getBoolean("key_is_show_new_bankcard", true);
    this.qGw = this.BX.getString("bottom_tips");
    this.qGx = this.BX.getParcelableArrayList("key_showing_bankcards");
    if (this.qGx == null) {
      this.qGx = o.bVs().bVZ();
    }
    this.qGr = ((TextView)findViewById(a.f.title_tips_tv));
    this.qGs = ((MaxListView)findViewById(a.f.bankcard_lv));
    this.iIX = ((TextView)findViewById(a.f.bottom_tips_tv));
    if (!bk.bl(this.qGu))
    {
      this.qGr.setVisibility(0);
      this.qGr.setText(this.qGu);
      if (bk.bl(this.qGw)) {
        break label337;
      }
      this.iIX.setVisibility(0);
      this.iIX.setText(this.qGw);
    }
    for (;;)
    {
      if (this.fzn == 0)
      {
        this.iIX.setVisibility(0);
        paramBundle = new h(this);
        paramBundle.qDo = new WalletSelectBankcardUI.1(this);
        String str = getString(a.i.wallet_select_bankcard_bcp_bottom_tips);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.iIX.setText(localSpannableString);
        this.iIX.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.qGt = new WalletSelectBankcardUI.a(this, (byte)0);
      this.qGs.setAdapter(this.qGt);
      this.qGs.setOnItemClickListener(new WalletSelectBankcardUI.2(this));
      return;
      this.qGr.setVisibility(8);
      break;
      label337:
      this.iIX.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */