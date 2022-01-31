package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;

public class GetQRCodeInfoUI
  extends MMBaseActivity
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.plugin.messenger.a.f nRw;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b.eUR.q(new Intent(), this);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.g.empty);
    Object localObject = getIntent().getData();
    if (localObject == null)
    {
      finish();
      return;
    }
    paramBundle = bk.pm(((Uri)localObject).getHost());
    localObject = bk.pm(((Uri)localObject).getScheme());
    if ((("http".equals(localObject)) && ("weixin.qq.com".equals(paramBundle))) || (("weixin".equals(localObject)) && ("qr".equals(paramBundle))))
    {
      g.Dk().a(new bi(new GetQRCodeInfoUI.1(this)), 0);
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.nRw != null) {
      g.Dk().c(this.nRw);
    }
    g.Dk().b(106, this);
  }
  
  public void onResume()
  {
    super.onResume();
    getString(a.i.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(a.i.address_searching), true, new GetQRCodeInfoUI.2(this));
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004)) {
      com.tencent.mm.ui.base.h.a(this, a.i.qrcode_ban_by_expose, a.i.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GetQRCodeInfoUI.this.finish();
        }
      });
    }
    do
    {
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(a.i.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GetQRCodeInfoUI.this.finish();
          }
        });
        return;
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
      paramm = aa.a(paramString.sQs);
      o.JQ().h(paramm, aa.a(paramString.svJ));
      Intent localIntent = new Intent();
      ((i)g.r(i.class)).a(localIntent, paramString, 30);
    } while (bk.pm(paramm).length() <= 0);
    if ((paramString.tpg & 0x8) > 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramm + ",30");
    }
    com.tencent.mm.br.d.c(this, "profile", ".ui.ContactInfoUI", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI
 * JD-Core Version:    0.7.0.1
 */