package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceSaveUI
  extends WalletBaseUI
{
  private final int eYf = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 270);
  protected Button frP;
  protected WalletFormView iKG;
  private View ipf;
  private HashMap<String, Integer> mNg = new HashMap();
  public double nzU;
  private ArrayList<Bankcard> qgr;
  protected Bankcard qgs;
  private String qgt;
  public LinearLayout qgv;
  
  private void aZ()
  {
    final ImageView localImageView;
    Object localObject;
    if (this.qgv != null)
    {
      if (this.qgs == null) {
        break label282;
      }
      localImageView = (ImageView)this.qgv.findViewById(a.f.bankcard_logo_iv);
      localObject = "";
      e locale = b.h(this, this.qgs.field_bankcardType, this.qgs.bUP());
      if (locale != null) {
        localObject = locale.mEi;
      }
      localImageView.setImageBitmap(null);
      if (!this.qgs.bUQ()) {
        break label188;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
    }
    for (;;)
    {
      ((TextView)this.qgv.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.qgs.field_bankName, this.qgs.field_bankcardTail }));
      ((TextView)this.qgv.findViewById(a.f.wallet_title)).setText(this.qgs.field_bankcardTypeName);
      if (bk.bl(this.qgs.field_avail_save_wording)) {
        break;
      }
      ((TextView)this.qgv.findViewById(a.f.hint_1)).setText(this.qgs.field_avail_save_wording);
      return;
      label188:
      localObject = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      x.a(new x.a()
      {
        public final void l(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          ai.d(new WalletBalanceSaveUI.7.1(this, paramAnonymousBitmap));
        }
      });
      if ((localObject != null) && (localObject != null)) {
        localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
    ((TextView)this.qgv.findViewById(a.f.hint_1)).setText("");
    return;
    label282:
    ((TextView)this.qgv.findViewById(a.f.balance_bankcard_tv)).setText(this.qgt);
    ((TextView)this.qgv.findViewById(a.f.hint_1)).setText("");
    ((ImageView)this.qgv.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
    ((TextView)this.qgv.findViewById(a.f.wallet_title)).setText(getString(a.i.wallet_balance_save_bankcard_default_tips));
  }
  
  private void bwc()
  {
    p.bTK();
    Object localObject = p.bTL();
    this.qgr = ((ag)localObject).bWb();
    this.qgs = ((ag)localObject).a(this.qgr, null, false, true);
    int i;
    if ((this.qgs != null) && (bk.bl(this.qgs.field_forbidWord)))
    {
      this.qgs = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.qgr.size())
      {
        if ((this.qgr.get(i) != null) && (bk.bl(((Bankcard)this.qgr.get(i)).field_forbidWord))) {
          this.qgs = ((Bankcard)this.qgr.get(i));
        }
      }
      else
      {
        if ((this.qgs != null) && (!bk.bl(this.qgs.field_forbidWord))) {
          this.qgs = null;
        }
        localObject = this.qgr;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
          i += 1;
        }
      }
      i += 1;
    }
  }
  
  public void bTt()
  {
    if (this.qgs != null)
    {
      a(new com.tencent.mm.plugin.wallet.balance.a.c(this.nzU, "CNY", this.qgs.field_bindSerial, this.qgs.field_bankcardType), true, true);
      return;
    }
    g localg = g.bUY();
    if (localg.akH())
    {
      com.tencent.mm.ui.base.h.b(this, localg.mOd, getString(a.i.app_tip), true);
      return;
    }
    a(new com.tencent.mm.plugin.wallet.balance.a.c(this.nzU, "CNY", "", ""), true, true);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.balance.a.c))
      {
        localObject = (com.tencent.mm.plugin.wallet.balance.a.c)paramm;
        if ("1".equals(((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdl))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
          paramString.putString("realname_verify_process_jump_plugin", "wallet");
          str = ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdm;
          str = ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdn;
          localObject = ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdo;
          aSk();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 0);
          if (!bool) {
            break label206;
          }
        }
      }
    }
    label206:
    while (!(paramm instanceof com.tencent.mm.plugin.wallet.balance.a.c))
    {
      do
      {
        for (;;)
        {
          Object localObject;
          String str;
          boolean bool;
          return false;
          if ("2".equals(((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdl))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdm, ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdp, ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdn, ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdo, aSk(), null);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + ((com.tencent.mm.plugin.wallet.balance.a.c)localObject).cdl);
            bool = false;
          }
        }
        paramm = ((com.tencent.mm.plugin.wallet.balance.a.c)paramm).bOT;
        aa.l(11, paramm, paramInt2);
        if (com.tencent.mm.plugin.wallet.b.a.bUG())
        {
          if (this.qgs == null) {}
          for (paramString = "";; paramString = this.qgs.field_bindSerial)
          {
            double d = this.nzU;
            if (bk.bl(paramm)) {
              break;
            }
            paramm = com.tencent.mm.pluginsdk.wallet.h.J(paramm, "", 11);
            paramm.soe = d;
            com.tencent.mm.pluginsdk.wallet.h.a(this, true, paramString, paramm, 1);
            return false;
          }
        }
        if (this.qgs == null) {}
        for (paramString = "";; paramString = this.qgs.field_bindSerial)
        {
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, paramm, "", 11, 1);
          return false;
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y));
      bwc();
      aZ();
      return false;
    }
    aa.l(11, "", paramInt2);
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_balance_save_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_balance_save_title);
    this.ipf = findViewById(a.f.save_root_view);
    this.iKG = ((WalletFormView)findViewById(a.f.money_ev));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.iKG);
    this.iKG.getTitleTv().setText(com.tencent.mm.wallet_core.c.ab.cML());
    e(this.iKG, 2, false);
    this.frP = ((Button)findViewById(a.f.next_btn));
    this.frP.setOnClickListener(new WalletBalanceSaveUI.1(this));
    this.qgv = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    if (this.qgv != null) {
      this.qgv.setOnClickListener(new WalletBalanceSaveUI.2(this));
    }
    this.lTH = new WalletBalanceSaveUI.3(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!q.Gw())
    {
      if (!com.tencent.mm.plugin.wallet.b.a.bUG()) {
        break label59;
      }
      a(new com.tencent.mm.plugin.wallet_core.c.ab(), false, false);
    }
    for (;;)
    {
      bwc();
      this.qgt = getString(a.i.wallet_balance_save_bind_new_card_to_save);
      initView();
      aZ();
      w.fT(3, 0);
      return;
      label59:
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 3), false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */