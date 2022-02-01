package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMBaseActivity;

public class GetQRCodeInfoUI
  extends MMBaseActivity
  implements i
{
  private f CYG;
  private ProgressDialog gtM = null;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73839);
    com.tencent.mm.plugin.setting.c.jRt.o(new Intent(), this);
    finish();
    AppMethodBeat.o(73839);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73835);
    super.onCreate(paramBundle);
    setContentView(2131493988);
    Object localObject = getIntent().getData();
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(73835);
      return;
    }
    paramBundle = Util.nullAsNil(((Uri)localObject).getHost());
    localObject = Util.nullAsNil(((Uri)localObject).getScheme());
    if ((("http".equals(localObject)) && (WeChatHosts.domainString(2131761749).equals(paramBundle))) || (("weixin".equals(localObject)) && ("qr".equals(paramBundle))))
    {
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(73831);
          if (paramAnonymousg == null)
          {
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.o(73831);
            return;
          }
          if ((com.tencent.mm.kernel.g.aAc()) && (!a.azj()))
          {
            GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
            AppMethodBeat.o(73831);
            return;
          }
          com.tencent.mm.plugin.setting.c.jRt.o(new Intent(), GetQRCodeInfoUI.this);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73831);
        }
      }), 0);
      AppMethodBeat.o(73835);
      return;
    }
    finish();
    AppMethodBeat.o(73835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73837);
    super.onDestroy();
    if (this.CYG != null) {
      com.tencent.mm.kernel.g.azz().a(this.CYG);
    }
    com.tencent.mm.kernel.g.azz().b(106, this);
    AppMethodBeat.o(73837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73836);
    super.onResume();
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131755257), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(73832);
        GetQRCodeInfoUI.this.finish();
        AppMethodBeat.o(73832);
      }
    });
    AppMethodBeat.o(73836);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73838);
    Log.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764139, 2131755998, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73833);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73833);
        }
      });
      AppMethodBeat.o(73838);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131760877, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755998), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73834);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73834);
        }
      });
      AppMethodBeat.o(73838);
      return;
    }
    paramString = ((f)paramq).eiq();
    paramq = z.a(paramString.Lqk);
    p.aYn().h(paramq, z.a(paramString.KHp));
    Intent localIntent = new Intent();
    ((k)com.tencent.mm.kernel.g.af(k.class)).a(localIntent, paramString, 30);
    if (Util.nullAsNil(paramq).length() > 0)
    {
      if ((paramString.MmK & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramq + ",30");
      }
      com.tencent.mm.br.c.d(this, "profile", ".ui.ContactInfoUI", 1);
    }
    AppMethodBeat.o(73838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI
 * JD-Core Version:    0.7.0.1
 */