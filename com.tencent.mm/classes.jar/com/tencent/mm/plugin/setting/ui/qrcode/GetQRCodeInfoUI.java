package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMBaseActivity;

public class GetQRCodeInfoUI
  extends MMBaseActivity
  implements com.tencent.mm.am.h
{
  private f PoM;
  private ProgressDialog lzP = null;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73839);
    com.tencent.mm.plugin.setting.c.pFn.n(new Intent(), this);
    finish();
    AppMethodBeat.o(73839);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73835);
    super.onCreate(paramBundle);
    setContentView(b.g.empty);
    Object localObject = getIntent().getData();
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(73835);
      return;
    }
    paramBundle = Util.nullAsNil(((Uri)localObject).getHost());
    localObject = Util.nullAsNil(((Uri)localObject).getScheme());
    if ((("http".equals(localObject)) && (WeChatHosts.domainString(b.i.host_weixin_qq_com).equals(paramBundle))) || (("weixin".equals(localObject)) && ("qr".equals(paramBundle))))
    {
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(73831);
          if (paramAnonymousg == null)
          {
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.o(73831);
            return;
          }
          if ((com.tencent.mm.kernel.h.baz()) && (!b.aZG()))
          {
            GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
            AppMethodBeat.o(73831);
            return;
          }
          com.tencent.mm.plugin.setting.c.pFn.n(new Intent(), GetQRCodeInfoUI.this);
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
    if (this.PoM != null) {
      com.tencent.mm.kernel.h.aZW().a(this.PoM);
    }
    com.tencent.mm.kernel.h.aZW().b(106, this);
    AppMethodBeat.o(73837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73836);
    super.onResume();
    getString(b.i.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(this, getString(b.i.address_searching), true, new DialogInterface.OnCancelListener()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(73838);
    Log.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.k.a(this, b.i.qrcode_ban_by_expose, b.i.app_tip, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.k.d(this, getString(b.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(b.i.app_tip), new DialogInterface.OnClickListener()
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
    paramString = ((f)paramp).gaH();
    paramp = w.a(paramString.ZqL);
    q.bFp().j(paramp, w.a(paramString.YFI));
    Intent localIntent = new Intent();
    ((com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.k.class)).a(localIntent, paramString, 30);
    if (Util.nullAsNil(paramp).length() > 0)
    {
      if ((paramString.aaMm & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramp + ",30");
      }
      com.tencent.mm.br.c.g(this, "profile", ".ui.ContactInfoUI", 1);
    }
    AppMethodBeat.o(73838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI
 * JD-Core Version:    0.7.0.1
 */