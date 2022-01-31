package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private LinearLayout dtF;
  private Button fpF;
  private ListView fuF;
  private ArrayList<Bankcard> qjX = new ArrayList();
  com.tencent.mm.sdk.b.c qkv = new WalletForgotPwdUI.8(this);
  private List<ElementQuery> qoK = new LinkedList();
  private Bankcard qoL;
  private WalletForgotPwdUI.a qoM;
  private WalletFormView qoN;
  private WalletFormView qoO;
  private int qoP = 1;
  private boolean qoQ = false;
  private boolean qoR = false;
  com.tencent.mm.sdk.b.c qoS = new WalletForgotPwdUI.7(this);
  
  private void XX()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", this.BX.getBoolean("key_is_reset_with_new_card", false));
    bUx();
    if ((this.qoL == null) && (!this.qoQ)) {
      a(new t(null, this.qoN.getText(), null), true, true);
    }
    do
    {
      return;
      if (!this.qoQ) {
        break;
      }
      localObject = o.bVo().bWq();
      if (!bk.bl(((af)localObject).field_find_passwd_url))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        e.l(this, ((af)localObject).field_find_passwd_url, false);
        return;
      }
      localBundle.putBoolean("key_is_force_bind", true);
      localBundle.putBoolean("key_is_reset_with_new_card", true);
    } while (cNj() == null);
    cNj().a(this, 0, localBundle);
    return;
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aj(this);
    localBundle.putParcelable("key_bankcard", this.qoL);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.qoK.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.mOb);
      if ((!bk.bl(localElementQuery.mOb)) && (!bk.bl(this.qoL.field_bankcardType)) && (localElementQuery.mOb.trim().equals(this.qoL.field_bankcardType.trim()))) {
        localObject = localElementQuery;
      }
    }
    for (;;)
    {
      localBundle.putParcelable("elemt_query", (Parcelable)localObject);
      if (localc == null) {
        break;
      }
      localc.a(this, 0, localBundle);
      return;
    }
  }
  
  private boolean YH()
  {
    if ((this.fuF.getVisibility() == 0) || ((this.qoO.YL()) && (this.qoN.YL())))
    {
      this.fpF.setEnabled(true);
      this.fpF.setClickable(true);
      return true;
    }
    this.fpF.setEnabled(false);
    this.fpF.setClickable(false);
    return false;
  }
  
  private void bUx()
  {
    this.BX.remove("elemt_query");
    this.BX.remove("key_bankcard");
    this.BX.remove("bank_name");
    this.BX.remove("key_card_id");
  }
  
  private void update()
  {
    p.bTK();
    this.qjX = p.bTL().bVZ();
    if ((this.qjX == null) || (this.qjX.size() == 0) || (this.qoR))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.qoR) });
      this.qjX = new ArrayList();
      this.dtF.setVisibility(0);
      this.fuF.setVisibility(8);
      setMMTitle(a.i.wallet_elment_title);
      ((TextView)findViewById(a.f.wallet_forgot_pwd_tips)).setText(getString(a.i.wallet_password_forget_passwd_bind_new_tip));
      WalletFormView localWalletFormView = this.qoO;
      p.bTK();
      localWalletFormView.setText(e.afl(p.bTL().aEZ()));
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.aj(this) != null) {
      a(new t(), true, false);
    }
    this.dtF.setVisibility(8);
    this.fpF.setVisibility(8);
    findViewById(a.f.more_button_tip).setVisibility(0);
    this.qoM = new WalletForgotPwdUI.a(this, this);
    this.fuF.setAdapter(this.qoM);
    this.qoM.items = this.qjX;
    this.qoM.notifyDataSetChanged();
  }
  
  public final boolean aSk()
  {
    af localaf;
    if ((this.qjX == null) || (this.qjX.size() == 0)) {
      localaf = o.bVo().bWq();
    }
    return (!bk.bl(localaf.field_find_passwd_url)) || (!bk.bl(localaf.field_forget_passwd_url));
  }
  
  protected final boolean aSl()
  {
    if (aSk()) {}
    for (int i = 4;; i = 0)
    {
      vN(i);
      return true;
    }
  }
  
  protected boolean bTZ()
  {
    return true;
  }
  
  public final boolean bgK()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof t)) {
        break label298;
      }
      paramString = (t)paramm;
      paramm = new Bundle();
      if (bk.bl(paramString.ijW))
      {
        this.qoK = paramString.qqW;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        return true;
      }
      if (paramString.qqX != null)
      {
        if (paramString.qqX.isError())
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          com.tencent.mm.ui.base.h.h(this, a.i.wallet_bank_broken, a.i.app_tip);
          return true;
        }
        if (this.qjX == null) {}
        for (paramInt1 = 0;; paramInt1 = this.qjX.size())
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.qjX != null) && (this.qjX.size() != 0)) {
            break;
          }
          bUx();
          paramm.putString("bank_name", paramString.qqX.lnT);
          paramm.putParcelable("elemt_query", paramString.qqX);
          paramm.putString("key_card_id", this.qoN.getText());
          paramm.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.j(this, paramm);
          return true;
        }
      }
      paramm.putString("bank_name", "");
      paramm.putParcelable("elemt_query", new ElementQuery());
      paramm.putString("key_card_id", this.qoN.getText());
      paramm.putBoolean("key_is_reset_with_new_card", true);
      com.tencent.mm.wallet_core.a.j(this, paramm);
    }
    label298:
    boolean bool;
    do
    {
      do
      {
        return false;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y));
      if (this.qoM != null) {
        break;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.qoM == null);
    paramString = null;
    if (o.bVs() != null) {
      paramString = o.bVs().bVZ();
    }
    paramm = com.tencent.mm.wallet_core.a.aj(this);
    ArrayList localArrayList;
    if (paramm != null)
    {
      paramm.cMm();
      paramm = new ArrayList();
      localArrayList = new ArrayList();
      paramString = paramString.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label464;
        }
        Bankcard localBankcard = (Bankcard)paramString.next();
        if (localBankcard.field_bankcardTag == 1)
        {
          paramm.add(localBankcard);
          continue;
          bool = false;
          break;
        }
        if (localBankcard.field_bankcardTag == 2) {
          localArrayList.add(localBankcard);
        }
      }
      label464:
      if (paramm.size() > 0) {
        this.qjX = paramm;
      }
    }
    else
    {
      label478:
      if (this.qjX != null) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 0;; paramInt1 = this.qjX.size())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.qoM.items = this.qjX;
      new ah(Looper.getMainLooper()).post(new WalletForgotPwdUI.4(this));
      break;
      this.qjX = localArrayList;
      break label478;
    }
  }
  
  public final void gG(boolean paramBoolean)
  {
    YH();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_forgot_pwd_ui;
  }
  
  public void initView()
  {
    this.fuF = ((ListView)findViewById(a.f.settings_lv_bankcard));
    this.dtF = ((LinearLayout)findViewById(a.f.forget_ll));
    this.qoO = ((WalletFormView)findViewById(a.f.name_et));
    this.qoN = ((WalletFormView)findViewById(a.f.card_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qoN);
    if (this.BX.getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.qoO);
    }
    for (;;)
    {
      this.qoO.setOnInputValidChangeListener(this);
      this.qoN.setOnInputValidChangeListener(this);
      this.fpF = ((Button)findViewById(a.f.next_btn));
      this.fpF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletForgotPwdUI.a(WalletForgotPwdUI.this);
        }
      });
      this.qoQ = false;
      p.bTK();
      this.qjX = p.bTL().bVZ();
      update();
      findViewById(a.f.more_button_tip).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          e.l(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
        }
      });
      YH();
      a(this.qoN, 0, false, false);
      this.qoN.setOnInfoIvClickListener(new WalletForgotPwdUI.3(this));
      this.qoN.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      this.qoN.getInfoIv().setVisibility(0);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.qoO);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt1, paramIntent);
    if ((paramInt2 == -1) && (1 == paramInt1))
    {
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.qoN.set3DesValStr(paramIntent);
      XX();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_password_setting_ui_forget_title);
    this.qoR = this.BX.getBoolean("key_is_force_bind", false);
    if (!this.qoR)
    {
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 6), true, true);
      vN(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.udP.c(this.qoS);
    com.tencent.mm.sdk.b.a.udP.c(this.qkv);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qoS);
    com.tencent.mm.sdk.b.a.udP.d(this.qkv);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    update();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI
 * JD-Core Version:    0.7.0.1
 */