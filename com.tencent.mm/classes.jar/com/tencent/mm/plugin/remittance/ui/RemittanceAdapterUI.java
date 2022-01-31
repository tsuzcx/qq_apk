package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ag.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  public String djD = null;
  public int fzn;
  protected int lTG;
  public boolean nzO = false;
  protected com.tencent.mm.plugin.wallet.a nzP = null;
  
  public void bwn()
  {
    w localw = new w(this.djD, this.lTG);
    localw.dIA = "RemittanceProcess";
    a(localw, true, false);
  }
  
  public void c(String paramString, int paramInt, Intent paramIntent)
  {
    y.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.fzn + ", name=" + paramString);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.nzP, paramIntent);
      if (paramIntent.getIntExtra("busi_type", 0) != 1) {
        break label138;
      }
      paramIntent.setClass(this, RemittanceBusiUI.class);
    }
    for (;;)
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.fzn);
      paramIntent.putExtra("pay_scene", paramInt);
      paramIntent.putExtra("pay_channel", this.lTG);
      startActivity(paramIntent);
      setResult(-1);
      finish();
      return;
      paramIntent = new Intent();
      break;
      label138:
      paramIntent.setClass(this, RemittanceUI.class);
    }
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    if ((paramm instanceof w)) {
      this.nzO = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof w))
      {
        paramString = (w)paramm;
        paramm = paramString.nzl;
        this.djD = paramString.username;
        if ((bk.bl(this.djD)) && (bk.bl(paramm)))
        {
          y.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.fzn);
          finish();
          bool = true;
        }
      }
      label512:
      while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        return bool;
        if (this.fzn == 1)
        {
          if (paramString.scene == 33)
          {
            this.nzP = com.tencent.mm.plugin.wallet.a.cE(this.djD, 2);
            this.nzP.aO(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramm = new Intent();
          paramm.putExtra("fee", paramString.iHP);
          paramm.putExtra("desc", paramString.desc);
          paramm.putExtra("scan_remittance_id", paramString.nzc);
          paramm.putExtra("receiver_true_name", e.afj(paramString.nzb));
          paramm.putExtra("receiver_true_name_busi", paramString.nyK);
          paramm.putExtra("receiver_tips", paramString.nzd);
          paramm.putExtra("rcvr_new_desc", paramString.nze);
          paramm.putExtra("payer_desc", paramString.nzf);
          paramm.putExtra("rcvr_open_id", paramString.nzl);
          paramm.putExtra("mch_name", paramString.nzi);
          paramm.putExtra("mch_info", paramString.nzo);
          paramm.putExtra("mch_photo", paramString.nzj);
          paramm.putExtra("mch_type", paramString.nzm);
          paramm.putExtra("mch_time", paramString.nzk);
          if (paramString.nzh == 1)
          {
            paramm.putExtra("busi_type", paramString.nzh);
            paramm.putExtra("rcvr_ticket", paramString.nzg);
            paramm.putExtra("rcvr_open_id", paramString.nzl);
            paramm.putExtra("get_pay_wifi", paramString.nzn);
            if (paramString.nzp != null) {
              paramm.putExtra("BusiRemittanceResp", paramString.nzp);
            }
          }
          g.DQ();
          ad localad = ((j)g.r(j.class)).Fw().abk(this.djD);
          b.M(this.djD, 3);
          if ((localad == null) && (!this.djD.equals(""))) {
            break label512;
          }
          c(this.djD, paramString.scene, paramm);
        }
        for (;;)
        {
          return true;
          this.nzP = com.tencent.mm.plugin.wallet.a.cE(this.djD, 3);
          this.nzP.aO(10, getIntent().getStringExtra("receiver_name"));
          break;
          y.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          long l = bk.UY();
          am.a.dVy.a(this.djD, "", new RemittanceAdapterUI.1(this, l, paramString, paramm));
        }
      }
      f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
      c(null, 31, null);
      return true;
    }
    setResult(0);
    h.bC(this, paramString);
    finish();
    return true;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    if (!this.nzO)
    {
      y.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      return;
    }
    y.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    this.fzn = getIntent().getIntExtra("scene", 0);
    this.djD = getIntent().getStringExtra("receiver_name");
    this.lTG = getIntent().getIntExtra("pay_channel", -1);
    this.nzP = com.tencent.mm.plugin.wallet.a.Y(getIntent());
    if (this.lTG == -1)
    {
      paramBundle = cNj();
      if (paramBundle != null) {
        this.lTG = paramBundle.kke.getInt("pay_channel", -1);
      }
    }
    if (this.fzn == 1)
    {
      this.nzO = true;
      bwn();
      return;
    }
    if (this.fzn == 3)
    {
      kh(580);
      if (getIntent() == null)
      {
        y.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        finish();
        return;
      }
      paramBundle = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
      paramBundle.dIA = "RemittanceProcess";
      a(paramBundle, true, false);
      return;
    }
    if (this.fzn == 2)
    {
      if (bk.bl(this.djD))
      {
        y.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.fzn);
        finish();
        return;
      }
      c(this.djD, 31, null);
      return;
    }
    if ((this.fzn == 5) || (this.fzn == 6))
    {
      if (bk.bl(this.djD))
      {
        y.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.fzn);
        finish();
        return;
      }
      paramBundle = this.djD;
      y.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.fzn + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.nzP, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.fzn);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.lTG);
      startActivity(localIntent);
      setResult(-1);
      finish();
      return;
    }
    c(null, 31, null);
  }
  
  public void onDestroy()
  {
    if (this.fzn == 3) {
      ki(580);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */