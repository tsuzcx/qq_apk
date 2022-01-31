package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;

public class GetQRCodeInfoUI
  extends MMBaseActivity
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private com.tencent.mm.plugin.messenger.a.f qFu;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126910);
    b.gmO.p(new Intent(), this);
    finish();
    AppMethodBeat.o(126910);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126906);
    super.onCreate(paramBundle);
    setContentView(2130969422);
    Object localObject = getIntent().getData();
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(126906);
      return;
    }
    paramBundle = bo.nullAsNil(((Uri)localObject).getHost());
    localObject = bo.nullAsNil(((Uri)localObject).getScheme());
    if ((("http".equals(localObject)) && ("weixin.qq.com".equals(paramBundle))) || (("weixin".equals(localObject)) && ("qr".equals(paramBundle))))
    {
      g.Rc().a(new bk(new GetQRCodeInfoUI.1(this)), 0);
      AppMethodBeat.o(126906);
      return;
    }
    finish();
    AppMethodBeat.o(126906);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126908);
    super.onDestroy();
    if (this.qFu != null) {
      g.Rc().a(this.qFu);
    }
    g.Rc().b(106, this);
    AppMethodBeat.o(126908);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126907);
    super.onResume();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131296492), true, new GetQRCodeInfoUI.2(this));
    AppMethodBeat.o(126907);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(126909);
    ab.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.a(this, 2131302239, 2131297087, new GetQRCodeInfoUI.3(this));
      AppMethodBeat.o(126909);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131297087), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126905);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(126905);
        }
      });
      AppMethodBeat.o(126909);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
    paramm = aa.a(paramString.wOT);
    o.acQ().n(paramm, aa.a(paramString.woT));
    Intent localIntent = new Intent();
    ((j)g.E(j.class)).a(localIntent, paramString, 30);
    if (bo.nullAsNil(paramm).length() > 0)
    {
      if ((paramString.xpe & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramm + ",30");
      }
      com.tencent.mm.bq.d.c(this, "profile", ".ui.ContactInfoUI", 1);
    }
    AppMethodBeat.o(126909);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI
 * JD-Core Version:    0.7.0.1
 */