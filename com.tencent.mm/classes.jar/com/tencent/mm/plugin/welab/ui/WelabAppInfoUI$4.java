package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class WelabAppInfoUI$4
  implements View.OnClickListener
{
  WelabAppInfoUI$4(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80602);
    try
    {
      g.RJ();
      int i = com.tencent.mm.kernel.a.getUin();
      paramView = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
      Object localObject = URLEncoder.encode(bo.dtS(), "utf-8");
      String str1 = URLEncoder.encode(q.bP(true), "utf-8");
      String str2 = URLEncoder.encode(com.tencent.mm.protocal.d.whB, "utf-8");
      String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.whC, "utf-8");
      String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.whD, "utf-8");
      g.RJ();
      String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.QX(), "utf-8");
      String str6 = URLEncoder.encode(bo.hk(ah.getContext()), "utf-8");
      paramView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
      if (bo.isNullOrNil("")) {}
      for (i = 0;; i = 1)
      {
        paramView = i;
        paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(this.vvu).field_expId).append("|").append(WelabAppInfoUI.b(this.vvu)).toString()) + "&version=" + com.tencent.mm.protocal.d.whH + "&lang=" + aa.gP(ah.getContext()) + "&" + bo.nullAsNil("") + paramView;
        paramView = paramView + "#/comment/4134";
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", paramView);
        ((Intent)localObject).putExtra("title", "意见反馈");
        ((Intent)localObject).putExtra("neverGetA8Key", true);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
        com.tencent.mm.bq.d.b(this.vvu, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(80602);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramView)
    {
      ab.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramView.getMessage() });
      AppMethodBeat.o(80602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.4
 * JD-Core Version:    0.7.0.1
 */