package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

final class m$2
  implements AdLandingPagesProxy.e
{
  m$2(m paramm) {}
  
  public final void ad(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(37101);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      m.a(this.rvI).sendMessage(5);
      AppMethodBeat.o(37101);
      return;
    }
    ra localra = new ra();
    try
    {
      localra.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localra.wqy))
      {
        ab.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localra.wqy);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localra.wqy);
        paramObject.putExtra("showShare", true);
        d.b(this.rvI.context, "webview", ".ui.tools.WebViewUI", paramObject);
        m.a(this.rvI).sendMessage(10);
        AppMethodBeat.o(37101);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ab.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bo.l(paramObject));
      }
      if (localra.wJl != null)
      {
        m.b(this.rvI).rrD = localra.wJl.kWx;
        m.b(this.rvI).cqq = localra.wJl.kXk;
        m.b(this.rvI).downloadUrl = localra.wJl.wJe;
        m.b(this.rvI).fileSize = localra.wJl.wJh;
        m.a(this.rvI).sendMessage(6);
        ab.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + localra.wJl.kWx + ", url=" + localra.wJl.wJe + ", id=" + localra.wJl.wJd);
        AppMethodBeat.o(37101);
        return;
      }
      ab.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
      m.a(this.rvI).sendMessage(5);
      AppMethodBeat.o(37101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.2
 * JD-Core Version:    0.7.0.1
 */