package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

final class q$2
  implements AdLandingPagesProxy.e
{
  q$2(q paramq) {}
  
  public final void bf(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      q.a(this.xaN).Wm(5);
      AppMethodBeat.o(96506);
      return;
    }
    tn localtn = new tn();
    try
    {
      localtn.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localtn.CzB))
      {
        ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localtn.CzB);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localtn.CzB);
        paramObject.putExtra("showShare", true);
        d.b(this.xaN.context, "webview", ".ui.tools.WebViewUI", paramObject);
        q.a(this.xaN).Wm(10);
        AppMethodBeat.o(96506);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bt.m(paramObject));
      }
      if (localtn.CVo != null)
      {
        paramObject = "";
        if (q.b(this.xaN).wVg)
        {
          q.b(this.xaN).wVh = localtn.CVo.CVi;
          q.b(this.xaN).md5 = localtn.CVo.CVg;
          q.b(this.xaN).downloadUrl = localtn.CVo.CVh;
          q.b(this.xaN).fileSize = localtn.CVo.CVj;
          String str = localtn.CVo.CVf;
          if ((!TextUtils.isEmpty(q.b(this.xaN).md5)) && (!TextUtils.isEmpty(q.b(this.xaN).downloadUrl)))
          {
            paramObject = str;
            if (q.b(this.xaN).fileSize != 0L) {}
          }
          else
          {
            q.b(this.xaN).wVg = false;
            ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!q.b(this.xaN).wVg)
        {
          q.b(this.xaN).wVh = localtn.CVo.odn;
          q.b(this.xaN).md5 = localtn.CVo.oea;
          q.b(this.xaN).downloadUrl = localtn.CVo.CVb;
          q.b(this.xaN).fileSize = localtn.CVo.CVe;
          paramObject = localtn.CVo.CVa;
        }
        q.a(this.xaN).Wm(6);
        ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + q.b(this.xaN).wVh + ", useGameDownloadWidget=" + q.b(this.xaN).wVg + ", fileSize=" + q.b(this.xaN).fileSize + ", apkId=" + paramObject + ", url=" + q.b(this.xaN).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      q.a(this.xaN).Wm(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.2
 * JD-Core Version:    0.7.0.1
 */