package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

final class s$2
  implements AdLandingPagesProxy.e
{
  s$2(s params) {}
  
  public final void bn(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(96506);
    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.a(this.EdK).sendMessage(5);
      AppMethodBeat.o(96506);
      return;
    }
    xc localxc = new xc();
    try
    {
      localxc.parseFrom((byte[])paramObject);
      if (!TextUtils.isEmpty(localxc.KJw))
      {
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localxc.KJw);
        paramObject = new Intent();
        paramObject.putExtra("rawUrl", localxc.KJw);
        paramObject.putExtra("showShare", true);
        c.b(this.EdK.context, "webview", ".ui.tools.WebViewUI", paramObject);
        s.a(this.EdK).sendMessage(10);
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
      if (localxc.Lik != null)
      {
        paramObject = "";
        if (s.b(this.EdK).DXz)
        {
          s.b(this.EdK).DXA = localxc.Lik.Lie;
          s.b(this.EdK).md5 = localxc.Lik.Lic;
          s.b(this.EdK).downloadUrl = localxc.Lik.Lid;
          s.b(this.EdK).fileSize = localxc.Lik.Lif;
          String str = localxc.Lik.Lib;
          if ((!TextUtils.isEmpty(s.b(this.EdK).md5)) && (!TextUtils.isEmpty(s.b(this.EdK).downloadUrl)))
          {
            paramObject = str;
            if (s.b(this.EdK).fileSize != 0L) {}
          }
          else
          {
            s.b(this.EdK).DXz = false;
            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
            paramObject = str;
          }
        }
        if (!s.b(this.EdK).DXz)
        {
          s.b(this.EdK).DXA = localxc.Lik.qGA;
          s.b(this.EdK).md5 = localxc.Lik.qHn;
          s.b(this.EdK).downloadUrl = localxc.Lik.LhX;
          s.b(this.EdK).fileSize = localxc.Lik.Lia;
          paramObject = localxc.Lik.LhW;
        }
        s.a(this.EdK).sendMessage(6);
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + s.b(this.EdK).DXA + ", useGameDownloadWidget=" + s.b(this.EdK).DXz + ", fileSize=" + s.b(this.EdK).fileSize + ", apkId=" + paramObject + ", url=" + s.b(this.EdK).downloadUrl);
        AppMethodBeat.o(96506);
        return;
      }
      Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
      s.a(this.EdK).sendMessage(5);
      AppMethodBeat.o(96506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.2
 * JD-Core Version:    0.7.0.1
 */