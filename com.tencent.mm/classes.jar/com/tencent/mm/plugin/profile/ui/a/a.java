package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements f
{
  Activity bMV;
  com.tencent.mm.ui.base.p ksE;
  com.tencent.mm.plugin.profile.a.a mZt;
  private am mZu = new am(new a.1(this), false);
  
  public a(Activity paramActivity)
  {
    this.bMV = paramActivity;
  }
  
  private void KX(String paramString)
  {
    this.mZu.stopTimer();
    if (this.ksE != null) {
      this.ksE.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.bMV.getString(R.l.contact_info_weibo));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    d.b(this.bMV, "webview", ".ui.tools.WebViewUI", paramString);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      y.e("MicroMsg.ViewTWeibo", "null weibo id");
      return;
    }
    au.Dk().a(205, this);
    this.mZt = new com.tencent.mm.plugin.profile.a.a(bk.pm(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    au.Dk().a(this.mZt, 0);
    this.mZu.S(3000L, 3000L);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(205, this);
    paramString = (com.tencent.mm.plugin.profile.a.a)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      KX(paramString.getURL());
      return;
    }
    if (paramInt1 != 4) {
      y.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    KX("http://t.qq.com/" + paramString.mVk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */