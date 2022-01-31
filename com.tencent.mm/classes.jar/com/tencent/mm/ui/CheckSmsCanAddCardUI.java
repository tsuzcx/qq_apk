package com.tencent.mm.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.w;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class CheckSmsCanAddCardUI
  extends MMActivity
  implements f
{
  private b dmK;
  private String uHK;
  
  private void cxY()
  {
    Toast.makeText(this, getString(R.l.verify_authority_err), 1).show();
    LauncherUI.gp(this);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.jump_to_biz_profile_loading;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    if ((!au.Hz()) || (au.CW()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      return;
    }
    paramBundle = getIntent().getData();
    if (paramBundle != null)
    {
      String str = paramBundle.getHost();
      if ((!bk.bl(str)) && (str.equals("cardpackage"))) {
        break label212;
      }
      y.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[] { str });
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label255;
      }
      au.Dk().a(1038, this);
      paramBundle = new b.a();
      paramBundle.ecH = new pq();
      paramBundle.ecI = new pr();
      paramBundle.ecG = 1038;
      paramBundle.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
      this.dmK = paramBundle.Kt();
      ((pq)this.dmK.ecE.ecN).sNx = this.uHK;
      y.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[] { this.uHK });
      this.dmK = w.b(this.dmK);
      return;
      label212:
      this.uHK = paramBundle.getQueryParameter("encrystr");
      y.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[] { this.uHK });
      if (bk.bl(this.uHK)) {
        break;
      }
    }
    label255:
    cxY();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(1038, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (pr)this.dmK.ecF.ecN;
      paramString = paramm.bZc;
      paramm = paramm.bZd;
      y.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[] { paramString, paramm });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_card_id", paramString);
      localIntent.putExtra("key_card_ext", paramm);
      localIntent.putExtra("key_from_scene", 8);
      localIntent.putExtra("key_is_sms_add_card", true);
      d.c(this, "card", ".ui.CardDetailUI", localIntent);
      finish();
      return;
    }
    cxY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.CheckSmsCanAddCardUI
 * JD-Core Version:    0.7.0.1
 */