package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

final class s$2
  implements AdLandingPagesProxy.e
{
  s$2(s params) {}
  
  public final void aH(Object paramObject) {}
  
  public final void i(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.a(this.Kro).sendMessage(5);
      AppMethodBeat.o(96506);
      return;
    }
    xi localxi = new xi();
    try
    {
      localxi.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localxi.SjB))
      {
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localxi.SjB);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localxi.SjB);
        paramObject.putExtra("showShare", true);
        c.b(this.Kro.context, "webview", ".ui.tools.WebViewUI", paramObject);
        s.a(this.Kro).sendMessage(10);
        AppMethodBeat.o(96506);
        return;
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", Util.stackTraceToString(paramObject));
      }
      if (localxi.SjA != null)
      {
        paramObject = "";
        if (s.b(this.Kro).KkI)
        {
          s.b(this.Kro).KkJ = localxi.SjA.Sju;
          s.b(this.Kro).md5 = localxi.SjA.Sjs;
          s.b(this.Kro).downloadUrl = localxi.SjA.Sjt;
          s.b(this.Kro).fileSize = localxi.SjA.Sjv;
          String str = localxi.SjA.Sjr;
          if ((!TextUtils.isEmpty(s.b(this.Kro).md5)) && (!TextUtils.isEmpty(s.b(this.Kro).downloadUrl)))
          {
            paramObject = str;
            if (s.b(this.Kro).fileSize != 0L) {}
          }
          else
          {
            s.b(this.Kro).KkI = false;
            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!s.b(this.Kro).KkI)
        {
          s.b(this.Kro).KkJ = localxi.SjA.ufB;
          s.b(this.Kro).md5 = localxi.SjA.ugo;
          s.b(this.Kro).downloadUrl = localxi.SjA.Sjn;
          s.b(this.Kro).fileSize = localxi.SjA.Sjq;
          paramObject = localxi.SjA.Sjm;
        }
        s.a(this.Kro).sendMessage(6);
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + s.b(this.Kro).KkJ + ", useGameDownloadWidget=" + s.b(this.Kro).KkI + ", fileSize=" + s.b(this.Kro).fileSize + ", apkId=" + paramObject + ", url=" + s.b(this.Kro).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      s.a(this.Kro).sendMessage(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.2
 * JD-Core Version:    0.7.0.1
 */