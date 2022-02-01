package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;

final class q$2
  implements AdLandingPagesProxy.e
{
  q$2(q paramq) {}
  
  public final void bc(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      q.a(this.ynC).Yv(5);
      AppMethodBeat.o(96506);
      return;
    }
    tx localtx = new tx();
    try
    {
      localtx.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localtx.DRX))
      {
        ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localtx.DRX);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localtx.DRX);
        paramObject.putExtra("showShare", true);
        d.b(this.ynC.context, "webview", ".ui.tools.WebViewUI", paramObject);
        q.a(this.ynC).Yv(10);
        AppMethodBeat.o(96506);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ac.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bs.m(paramObject));
      }
      if (localtx.EnY != null)
      {
        paramObject = "";
        if (q.b(this.ynC).yhU)
        {
          q.b(this.ynC).yhV = localtx.EnY.EnS;
          q.b(this.ynC).md5 = localtx.EnY.EnQ;
          q.b(this.ynC).downloadUrl = localtx.EnY.EnR;
          q.b(this.ynC).fileSize = localtx.EnY.EnT;
          String str = localtx.EnY.EnP;
          if ((!TextUtils.isEmpty(q.b(this.ynC).md5)) && (!TextUtils.isEmpty(q.b(this.ynC).downloadUrl)))
          {
            paramObject = str;
            if (q.b(this.ynC).fileSize != 0L) {}
          }
          else
          {
            q.b(this.ynC).yhU = false;
            ac.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!q.b(this.ynC).yhU)
        {
          q.b(this.ynC).yhV = localtx.EnY.oGM;
          q.b(this.ynC).md5 = localtx.EnY.oHz;
          q.b(this.ynC).downloadUrl = localtx.EnY.EnL;
          q.b(this.ynC).fileSize = localtx.EnY.EnO;
          paramObject = localtx.EnY.EnK;
        }
        q.a(this.ynC).Yv(6);
        ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + q.b(this.ynC).yhV + ", useGameDownloadWidget=" + q.b(this.ynC).yhU + ", fileSize=" + q.b(this.ynC).fileSize + ", apkId=" + paramObject + ", url=" + q.b(this.ynC).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      ac.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      q.a(this.ynC).Yv(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.2
 * JD-Core Version:    0.7.0.1
 */