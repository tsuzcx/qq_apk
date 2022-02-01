package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
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
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    for (;;)
    {
      try
      {
        g.aAf();
        i = com.tencent.mm.kernel.a.getUin();
        paramView = URLEncoder.encode(d.DEVICE_NAME, "utf-8");
        localObject = URLEncoder.encode(Util.getTimeZoneOffset(), "utf-8");
        String str1 = URLEncoder.encode(q.dr(true), "utf-8");
        String str2 = URLEncoder.encode(d.KyI, "utf-8");
        String str3 = URLEncoder.encode(d.KyJ, "utf-8");
        String str4 = URLEncoder.encode(d.KyK, "utf-8");
        g.aAf();
        String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.azt(), "utf-8");
        String str6 = URLEncoder.encode(Util.getSourceeMd5(MMApplicationContext.getContext()), "utf-8");
        paramView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
        if (!Util.isNullOrNil("")) {
          continue;
        }
        i = 0;
        paramView = i;
        localObject = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index";
        paramView = (String)localObject + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(this.JGp).field_expId).append("|").append(WelabAppInfoUI.b(this.JGp)).toString()) + "&version=" + d.KyO + "&lang=" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) + "&" + Util.nullAsNil("") + paramView;
        paramView = paramView + "#/comment/4134";
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", paramView);
        ((Intent)localObject).putExtra("title", "意见反馈");
        ((Intent)localObject).putExtra("neverGetA8Key", true);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        c.b(this.JGp, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      catch (UnsupportedEncodingException paramView)
      {
        int i;
        Log.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramView.getMessage() });
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