package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.b;
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
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    for (;;)
    {
      try
      {
        g.ajA();
        i = com.tencent.mm.kernel.a.getUin();
        paramView = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
        localObject = URLEncoder.encode(bt.flM(), "utf-8");
        String str1 = URLEncoder.encode(q.cH(true), "utf-8");
        String str2 = URLEncoder.encode(com.tencent.mm.protocal.d.Fnd, "utf-8");
        String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.Fne, "utf-8");
        String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.Fnf, "utf-8");
        g.ajA();
        String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.aiO(), "utf-8");
        String str6 = URLEncoder.encode(bt.jj(aj.getContext()), "utf-8");
        paramView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
        if (!bt.isNullOrNil("")) {
          continue;
        }
        i = 0;
        paramView = i;
        paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(this.Eyg).field_expId).append("|").append(WelabAppInfoUI.b(this.Eyg)).toString()) + "&version=" + com.tencent.mm.protocal.d.Fnj + "&lang=" + ac.iM(aj.getContext()) + "&" + bt.nullAsNil("") + paramView;
        paramView = paramView + "#/comment/4134";
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", paramView);
        ((Intent)localObject).putExtra("title", "意见反馈");
        ((Intent)localObject).putExtra("neverGetA8Key", true);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
        com.tencent.mm.bs.d.b(this.Eyg, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      catch (UnsupportedEncodingException paramView)
      {
        int i;
        ad.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramView.getMessage() });
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(146273);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.4
 * JD-Core Version:    0.7.0.1
 */