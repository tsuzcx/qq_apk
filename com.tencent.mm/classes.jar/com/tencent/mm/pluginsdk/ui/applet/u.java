package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class u
  implements f
{
  Context context;
  com.tencent.mm.ui.base.p ksE;
  private am mZu = new am(new u.1(this), false);
  h nOj;
  private String sdv;
  
  public u(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void WK(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(R.l.contact_info_qzone_url, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
  }
  
  public final void WJ(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      return;
    }
    this.sdv = paramString;
    au.Hx();
    String str1 = (String)c.Dz().get(46, null);
    au.Hx();
    String str2 = bk.pm((String)c.Dz().get(72, null));
    y.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((bk.bl(str1)) && (bk.bl(str2)))
    {
      WK(paramString);
      return;
    }
    au.Dk().a(233, this);
    this.nOj = new h(o.bS(paramString), (int)System.currentTimeMillis());
    au.Dk().a(this.nOj, 0);
    this.mZu.S(3000L, 3000L);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.mZu.stopTimer();
    if (this.ksE != null) {
      this.ksE.dismiss();
    }
    au.Dk().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (h)paramm;
      paramm = paramString.Qf();
      if ((paramm == null) || (paramm.length() == 0))
      {
        WK(this.sdv);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramm);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.Qn());
      d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      return;
    }
    y.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    WK(this.sdv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u
 * JD-Core Version:    0.7.0.1
 */