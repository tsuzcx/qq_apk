package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

final class r$2
  implements AdLandingPagesProxy.e
{
  r$2(r paramr) {}
  
  public final void be(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      r.a(this.zEx).aaA(5);
      AppMethodBeat.o(96506);
      return;
    }
    vs localvs = new vs();
    try
    {
      localvs.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localvs.Fxq))
      {
        ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localvs.Fxq);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localvs.Fxq);
        paramObject.putExtra("showShare", true);
        d.b(this.zEx.context, "webview", ".ui.tools.WebViewUI", paramObject);
        r.a(this.zEx).aaA(10);
        AppMethodBeat.o(96506);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bt.n(paramObject));
      }
      if (localvs.FVh != null)
      {
        paramObject = "";
        if (r.b(this.zEx).zyc)
        {
          r.b(this.zEx).zyd = localvs.FVh.FVb;
          r.b(this.zEx).md5 = localvs.FVh.FUZ;
          r.b(this.zEx).downloadUrl = localvs.FVh.FVa;
          r.b(this.zEx).fileSize = localvs.FVh.FVc;
          String str = localvs.FVh.FUY;
          if ((!TextUtils.isEmpty(r.b(this.zEx).md5)) && (!TextUtils.isEmpty(r.b(this.zEx).downloadUrl)))
          {
            paramObject = str;
            if (r.b(this.zEx).fileSize != 0L) {}
          }
          else
          {
            r.b(this.zEx).zyc = false;
            ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!r.b(this.zEx).zyc)
        {
          r.b(this.zEx).zyd = localvs.FVh.pkq;
          r.b(this.zEx).md5 = localvs.FVh.pld;
          r.b(this.zEx).downloadUrl = localvs.FVh.FUU;
          r.b(this.zEx).fileSize = localvs.FVh.FUX;
          paramObject = localvs.FVh.FUT;
        }
        r.a(this.zEx).aaA(6);
        ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + r.b(this.zEx).zyd + ", useGameDownloadWidget=" + r.b(this.zEx).zyc + ", fileSize=" + r.b(this.zEx).fileSize + ", apkId=" + paramObject + ", url=" + r.b(this.zEx).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      r.a(this.zEx).aaA(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.2
 * JD-Core Version:    0.7.0.1
 */