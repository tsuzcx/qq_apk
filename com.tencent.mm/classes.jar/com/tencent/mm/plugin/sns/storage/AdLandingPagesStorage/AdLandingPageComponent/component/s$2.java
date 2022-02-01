package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;

final class s$2
  implements AdLandingPagesProxy.e
{
  s$2(s params) {}
  
  public final void be(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.a(this.zVD).abg(5);
      AppMethodBeat.o(96506);
      return;
    }
    vu localvu = new vu();
    try
    {
      localvu.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localvu.FPO))
      {
        ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localvu.FPO);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localvu.FPO);
        paramObject.putExtra("showShare", true);
        d.b(this.zVD.context, "webview", ".ui.tools.WebViewUI", paramObject);
        s.a(this.zVD).abg(10);
        AppMethodBeat.o(96506);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ae.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bu.o(paramObject));
      }
      if (localvu.GnG != null)
      {
        paramObject = "";
        if (s.b(this.zVD).zPB)
        {
          s.b(this.zVD).zPC = localvu.GnG.GnA;
          s.b(this.zVD).md5 = localvu.GnG.Gny;
          s.b(this.zVD).downloadUrl = localvu.GnG.Gnz;
          s.b(this.zVD).fileSize = localvu.GnG.GnB;
          String str = localvu.GnG.Gnx;
          if ((!TextUtils.isEmpty(s.b(this.zVD).md5)) && (!TextUtils.isEmpty(s.b(this.zVD).downloadUrl)))
          {
            paramObject = str;
            if (s.b(this.zVD).fileSize != 0L) {}
          }
          else
          {
            s.b(this.zVD).zPB = false;
            ae.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!s.b(this.zVD).zPB)
        {
          s.b(this.zVD).zPC = localvu.GnG.pqV;
          s.b(this.zVD).md5 = localvu.GnG.prI;
          s.b(this.zVD).downloadUrl = localvu.GnG.Gnt;
          s.b(this.zVD).fileSize = localvu.GnG.Gnw;
          paramObject = localvu.GnG.Gns;
        }
        s.a(this.zVD).abg(6);
        ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + s.b(this.zVD).zPC + ", useGameDownloadWidget=" + s.b(this.zVD).zPB + ", fileSize=" + s.b(this.zVD).fileSize + ", apkId=" + paramObject + ", url=" + s.b(this.zVD).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      ae.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      s.a(this.zVD).abg(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.2
 * JD-Core Version:    0.7.0.1
 */