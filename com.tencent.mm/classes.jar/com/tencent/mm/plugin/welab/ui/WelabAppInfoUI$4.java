package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class WelabAppInfoUI$4
  implements View.OnClickListener
{
  WelabAppInfoUI$4(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146273);
    try
    {
      g.afz();
      int i = com.tencent.mm.kernel.a.getUin();
      paramView = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
      Object localObject = URLEncoder.encode(bt.eGH(), "utf-8");
      String str1 = URLEncoder.encode(q.cG(true), "utf-8");
      String str2 = URLEncoder.encode(com.tencent.mm.protocal.d.CpE, "utf-8");
      String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.CpF, "utf-8");
      String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.CpG, "utf-8");
      g.afz();
      String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.aeM(), "utf-8");
      String str6 = URLEncoder.encode(bt.iO(aj.getContext()), "utf-8");
      paramView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
      if (bt.isNullOrNil("")) {}
      for (i = 0;; i = 1)
      {
        paramView = i;
        paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(this.BCd).field_expId).append("|").append(WelabAppInfoUI.b(this.BCd)).toString()) + "&version=" + com.tencent.mm.protocal.d.CpK + "&lang=" + ac.ir(aj.getContext()) + "&" + bt.nullAsNil("") + paramView;
        paramView = paramView + "#/comment/4134";
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", paramView);
        ((Intent)localObject).putExtra("title", "意见反馈");
        ((Intent)localObject).putExtra("neverGetA8Key", true);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
        com.tencent.mm.bs.d.b(this.BCd, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(146273);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramView)
    {
      ad.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramView.getMessage() });
      AppMethodBeat.o(146273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.4
 * JD-Core Version:    0.7.0.1
 */