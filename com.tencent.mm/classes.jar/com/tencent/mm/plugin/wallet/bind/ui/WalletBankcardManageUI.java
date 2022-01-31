package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private ListView Nn = null;
  private AdapterView.OnItemClickListener aeW = new WalletBankcardManageUI.9(this);
  private View.OnClickListener fvj = new WalletBankcardManageUI.8(this);
  private q man = new q();
  public ArrayList<Bankcard> qjX = new ArrayList();
  private ArrayList<Bankcard> qjY = new ArrayList();
  protected ag qjZ = null;
  private ListView qka = null;
  private a qkb = null;
  private a qkc = null;
  private TextView qkd;
  private View qke;
  private View qkf;
  private View qkg;
  private CdnImageView qkh;
  private TextView qki;
  private k qkj;
  
  private void aZ()
  {
    label43:
    label68:
    Object localObject1;
    Object localObject2;
    int i;
    label166:
    label182:
    TextView localTextView;
    if (this.qjZ.bVM())
    {
      this.qkd.setEnabled(false);
      if ((this.qjX == null) || (this.qjX.size() <= 0)) {
        break label310;
      }
      this.Nn.setVisibility(0);
      if ((this.qjY == null) || (this.qjY.size() <= 0)) {
        break label322;
      }
      this.qka.setVisibility(0);
      if ((this.qkj == null) || (this.qkj.field_is_show_entry != 1)) {
        break label455;
      }
      ((TextView)this.qkf.findViewById(a.f.wallet_entrance_loan_text)).setText(this.qkj.field_title);
      localObject1 = this.qkj;
      localObject2 = (TextView)findViewById(a.f.wallet_load_red_point);
      i = ((k)localObject1).field_red_dot_index;
      g.DQ();
      if ((((Integer)g.DP().Dz().get(ac.a.uqT, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label334;
      }
      i = 1;
      if (i == 0) {
        break label339;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject2).setVisibility(0);
      localTextView = (TextView)findViewById(a.f.wallet_entrance_loan_credits_tip);
      if (((k)localObject1).field_is_overdue != 1) {
        break label348;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
      localTextView.setText(a.i.wallet_bankcard_manager_ui_loan_overdue);
      localTextView.setTextColor(getResources().getColor(a.c.red));
      label232:
      localTextView.setVisibility(0);
      label238:
      this.qkf.setVisibility(0);
    }
    for (;;)
    {
      this.qkb.R(this.qjX);
      this.qkb.notifyDataSetChanged();
      this.qkc.R(this.qjY);
      this.qkc.notifyDataSetChanged();
      this.qkd.setEnabled(true);
      return;
      this.qjZ.bVK();
      this.qkd.setEnabled(true);
      break;
      label310:
      this.Nn.setVisibility(8);
      break label43;
      label322:
      this.qka.setVisibility(8);
      break label68;
      label334:
      i = 0;
      break label166;
      label339:
      ((TextView)localObject2).setVisibility(8);
      break label182;
      label348:
      if (!bk.bl(((k)localObject1).field_tips))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(((k)localObject1).field_tips);
        break label232;
      }
      if (!bk.bl(((k)localObject1).field_available_otb))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
        i = ((k)localObject1).field_available_otb.indexOf(".");
        localObject2 = ((k)localObject1).field_available_otb;
        localObject1 = localObject2;
        if (i > 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        localTextView.setText(getString(a.i.wallet_bankcard_manager_ui_loan_available_otb, new Object[] { localObject1 }));
        break label232;
      }
      localTextView.setVisibility(8);
      break label238;
      label455:
      this.qkf.setVisibility(8);
    }
  }
  
  private void bTC()
  {
    g.DQ();
    f localf = f.Qn((String)g.DP().Dz().get(ac.a.uxG, ""));
    if ((localf != null) && (!bk.bl(localf.qud)))
    {
      if (!bk.bl(localf.que)) {
        this.qkh.setUrl(localf.que);
      }
      this.qki.setText(localf.qud);
      if (localf.qtY == 1)
      {
        this.qkg.setOnClickListener(new WalletBankcardManageUI.6(this, localf));
        this.qkg.setVisibility(0);
        return;
      }
      if (localf.qtY == 2)
      {
        this.qkg.setOnClickListener(new WalletBankcardManageUI.7(this, localf));
        this.qkg.setVisibility(0);
        return;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localf.qtY) });
    }
    this.qkg.setVisibility(8);
  }
  
  public final void b(Bankcard paramBankcard)
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(ac.a.usm, "");
    if (!bk.bl(str))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
  }
  
  public a bTD()
  {
    return new a(this, this.qjX);
  }
  
  public void bTE()
  {
    WalletBankcardManageUI.10 local10 = new WalletBankcardManageUI.10(this, new Bundle());
    ae localae = new ae();
    this.man.a(new WalletBankcardManageUI.2(this, local10), localae.bVJ());
  }
  
  public final void bTF()
  {
    vN(0);
    this.qjZ.k(this.qjX, this.qjY);
    aZ();
    bTC();
  }
  
  public final boolean bgK()
  {
    return false;
  }
  
  public void c(Bankcard paramBankcard)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localBundle, null);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)))
    {
      this.qkj = o.bVs().qzg;
      bTF();
      return true;
    }
    return false;
  }
  
  public void finish()
  {
    if (!getIntent().getBooleanExtra("intent_finish_self", false))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_bankcard_manage_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new WalletBankcardManageUI.3(this));
    this.qkd = ((TextView)findViewById(a.f.wallet_add_bankcard_for_empty));
    this.qkd.setOnClickListener(new WalletBankcardManageUI.4(this));
    this.Nn = ((ListView)findViewById(a.f.bankcard_list));
    this.qkb = bTD();
    this.Nn.setAdapter(this.qkb);
    this.Nn.setOnItemClickListener(this.aeW);
    this.qka = ((ListView)findViewById(a.f.virtual_bankcard_list));
    this.qkc = new a(this, this.qjY);
    this.qka.setAdapter(this.qkc);
    this.qka.setOnItemClickListener(this.aeW);
    this.qke = findViewById(a.f.wallet_entrance_add_bankcard);
    this.qke.setOnClickListener(this.fvj);
    this.qkf = findViewById(a.f.wallet_entrance_loan);
    this.qkf.setOnClickListener(this.fvj);
    this.qkg = findViewById(a.f.wallet_entrance_apply_credit);
    this.qkh = ((CdnImageView)findViewById(a.f.wallet_entrance_apply_credit_icon_iv));
    this.qki = ((TextView)findViewById(a.f.wallet_entrance_applay_credit_text_tv));
    bTC();
    findViewById(a.f.bank_card_help).setOnClickListener(this.fvj);
    ti localti = new ti();
    localti.ccU.bso = "4";
    localti.bFJ = new WalletBankcardManageUI.5(this, localti);
    com.tencent.mm.sdk.b.a.udP.m(localti);
  }
  
  public void ks(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 12), true, false);
      return;
    }
    a(new com.tencent.mm.plugin.wallet_core.c.y(null, 12), false, false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        this.man.bgR();
      }
    }
    else {
      return;
    }
    this.man.cancel();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    vN(4);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    p.bTK();
    this.qjZ = p.bTL();
    setMMTitle(a.i.wallet_index_ui_title);
    ta(this.mController.uMN.getResources().getColor(a.c.dark_actionbar_color));
    czo();
    initView();
    w.fT(5, 0);
    com.tencent.mm.wallet_core.ui.e.Jc(27);
    this.qkj = o.bVs().qzg;
    this.man.qHp = new WalletBankcardManageUI.1(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.qkb.qjy.destory();
    this.qkc.qjy.destory();
  }
  
  public void onPause()
  {
    super.onPause();
    this.man.onPause();
  }
  
  public void onResume()
  {
    if (!this.qjZ.bVM())
    {
      this.qjZ.k(this.qjX, this.qjY);
      if (this.qjZ.qhj != null) {
        vN(0);
      }
      ks(false);
    }
    for (;;)
    {
      this.man.onResume();
      aZ();
      super.onResume();
      return;
      ks(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */