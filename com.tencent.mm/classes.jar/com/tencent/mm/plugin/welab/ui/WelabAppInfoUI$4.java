package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class WelabAppInfoUI$4
  implements View.OnClickListener
{
  WelabAppInfoUI$4(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      g.DN();
      int i = com.tencent.mm.kernel.a.CK();
      paramView = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
      Object localObject = URLEncoder.encode(bk.crV(), "utf-8");
      String str1 = URLEncoder.encode(q.zf(), "utf-8");
      String str2 = URLEncoder.encode(com.tencent.mm.protocal.d.soU, "utf-8");
      String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.soV, "utf-8");
      String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.soW, "utf-8");
      g.DN();
      String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.Df(), "utf-8");
      String str6 = URLEncoder.encode(bk.fU(ae.getContext()), "utf-8");
      paramView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
      if (bk.bl("")) {}
      for (i = 0;; i = 1)
      {
        paramView = i;
        paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(this.rEL).field_expId).append("|").append(WelabAppInfoUI.b(this.rEL)).toString()) + "&version=" + com.tencent.mm.protocal.d.spa + "&lang=" + x.fB(ae.getContext()) + "&" + bk.pm("") + paramView;
        paramView = paramView + "#/comment/4134";
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", paramView);
        ((Intent)localObject).putExtra("title", "意见反馈");
        ((Intent)localObject).putExtra("neverGetA8Key", true);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
        com.tencent.mm.br.d.b(this.rEL, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramView)
    {
      y.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramView.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.4
 * JD-Core Version:    0.7.0.1
 */