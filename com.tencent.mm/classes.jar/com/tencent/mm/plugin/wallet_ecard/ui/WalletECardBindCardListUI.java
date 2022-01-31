package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletECardBindCardListUI
  extends WalletECardBaseUI
{
  private ListView qKC;
  private TextView qKD;
  private List<fv> qKE = new ArrayList();
  private WalletECardBindCardListUI.c qKF;
  private boolean qKG = true;
  private int quJ;
  
  private void YE()
  {
    y.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    a(new f("WEB_DEBIT", this.quJ), true, false);
  }
  
  private void bXx()
  {
    Bundle localBundle = new Bundle();
    if (this.quJ == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", this.BX.getString("key_pwd1"));
      y.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.quJ) });
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, new WalletECardBindCardListUI.2(this));
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof f))
    {
      paramm = (f)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bk.bl(paramm.qKx.tBG)) {
          this.qKD.setText(paramm.qKx.tBG);
        }
        if (paramm.qKx.ino == 0)
        {
          y.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramm.qKx.tBH.size()) });
          y.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramm.qKx.qsJ });
          this.BX.putString(com.tencent.mm.plugin.wallet_ecard.a.a.qKi, paramm.qKx.qsJ);
          if (paramm.qKx.tBH.size() == 0)
          {
            y.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.qKG) });
            if (this.qKG) {
              bXx();
            }
          }
        }
        while (b.a(this, paramm.qKx.sAW))
        {
          return true;
          this.qKE.clear();
          this.qKE.addAll(paramm.qKx.tBH);
          this.qKF.notifyDataSetChanged();
          return true;
        }
        paramString = b.d(this.mController.uMN, new String[] { paramm.qKx.inp, paramString });
        h.b(this.mController.uMN, paramString, "", false);
        return true;
      }
      y.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramm });
      paramString = b.d(this.mController.uMN, new String[] { paramString });
      h.b(this.mController.uMN, paramString, "", false);
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.ecard_bind_card_list;
  }
  
  protected final void initView()
  {
    this.qKC = ((ListView)findViewById(a.f.bcard_bind_card_list));
    View localView = LayoutInflater.from(this).inflate(a.g.ecard_bind_card_list_header_layout, this.qKC, false);
    this.qKD = ((TextView)localView.findViewById(a.f.ecard_bind_list_desc_tv));
    this.qKC.addHeaderView(localView, null, false);
    this.qKF = new WalletECardBindCardListUI.c(this, (byte)0);
    this.qKC.setAdapter(this.qKF);
    this.qKC.setOnItemClickListener(new WalletECardBindCardListUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ta(getResources().getColor(a.c.white));
    czo();
    this.wCh.kh(1988);
    this.quJ = this.BX.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.qJR, 2);
    y.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.quJ) });
    setMMTitle("");
    initView();
    this.qKG = true;
    YE();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wCh.ki(1988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */