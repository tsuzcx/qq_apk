package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class n$2
  implements AdLandingPagesProxy.a
{
  n$2(n paramn) {}
  
  public final void U(Object paramObject) {}
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      n.a(this.oGd).Ff(5);
      return;
    }
    ny localny = new ny();
    try
    {
      localny.aH((byte[])paramObject);
      if (!TextUtils.isEmpty(localny.sLy))
      {
        y.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localny.sLy);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localny.sLy);
        paramObject.putExtra("showShare", true);
        d.b(this.oGd.context, "webview", ".ui.tools.WebViewUI", paramObject);
        n.a(this.oGd).Ff(10);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        y.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bk.j(paramObject));
      }
      if (localny.sLx != null)
      {
        n.b(this.oGd).oCe = localny.sLx.sLq;
        n.b(this.oGd).bIW = localny.sLx.iQL;
        n.b(this.oGd).downloadUrl = localny.sLx.sLp;
        n.b(this.oGd).fileSize = localny.sLx.sLt;
        n.a(this.oGd).Ff(6);
        return;
      }
      y.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
      n.a(this.oGd).Ff(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.2
 * JD-Core Version:    0.7.0.1
 */