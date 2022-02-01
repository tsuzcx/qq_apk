package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

public class r
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(175742);
    Intent localIntent = new Intent();
    String str3 = ((g)paramb.eiY).getUrl();
    localIntent.putExtra("req_url", str3);
    String str2 = ((g)paramb.eiY).WGh.getAppId();
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      str1 = str2;
      if (!Util.isNullOrNil(str3))
      {
        str1 = str2;
        if (Uri.parse(str3).getHost().equals(WeChatHosts.domainString(c.i.host_game_weixin_qq_com))) {
          str1 = "wx62d9035fd4fd2059";
        }
      }
    }
    localIntent.putExtra("req_app_id", str1);
    localIntent.putExtra("launch_from_webview", true);
    ((MMActivity)((g)paramb.eiY).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(175741);
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str1;
        if (paramAnonymousInt1 == (r.this.hashCode() & 0xFFFF))
        {
          ((MMActivity)((g)paramb.eiY).mContext).mmSetOnActivityResultCallback(null);
          if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
          {
            str2 = Util.nullAs(paramAnonymousIntent.getStringExtra("nationalCode"), "");
            str3 = Util.nullAs(paramAnonymousIntent.getStringExtra("userName"), "");
            str4 = Util.nullAs(paramAnonymousIntent.getStringExtra("telNumber"), "");
            str5 = Util.nullAs(paramAnonymousIntent.getStringExtra("addressPostalCode"), "");
            str6 = Util.nullAs(paramAnonymousIntent.getStringExtra("proviceFirstStageName"), "");
            str7 = Util.nullAs(paramAnonymousIntent.getStringExtra("addressCitySecondStageName"), "");
            str8 = Util.nullAs(paramAnonymousIntent.getStringExtra("addressCountiesThirdStageName"), "");
            str9 = Util.nullAs(paramAnonymousIntent.getStringExtra("addressCountiesFourStageName"), "");
            str1 = Util.nullAs(paramAnonymousIntent.getStringExtra("addressDetailInfo"), "");
            if ((TextUtils.isEmpty(str9)) || (str1.startsWith(str9))) {
              break label469;
            }
          }
        }
        label469:
        for (paramAnonymousIntent = String.format("%s%s", new Object[] { str9, str1 });; paramAnonymousIntent = str1)
        {
          Log.i("MicroMsg.JsApiEditAddress", "first =  " + str6 + " ; detail =" + str1 + "; second = " + str7 + " ; tel = " + str4 + "; third = " + str8);
          if (!Util.isNullOrNil(str3))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("nationalCode", r.bkd(str2));
            localHashMap.put("nationalCodeFull", str2);
            localHashMap.put("userName", str3);
            localHashMap.put("telNumber", str4);
            localHashMap.put("addressPostalCode", str5);
            localHashMap.put("proviceFirstStageName", str6);
            localHashMap.put("addressCitySecondStageName", str7);
            localHashMap.put("addressCountiesThirdStageName", str8);
            localHashMap.put("addressStreetFourthStageName", str9);
            localHashMap.put("addressDetailInfo", paramAnonymousIntent);
            localHashMap.put("addressDetailInfoNew", str1);
            paramb.d("", localHashMap);
            AppMethodBeat.o(175741);
            return;
          }
          if (paramAnonymousInt2 == 0)
          {
            paramb.a("cancel", null);
            AppMethodBeat.o(175741);
            return;
          }
          paramb.a("fail", null);
          AppMethodBeat.o(175741);
          return;
        }
      }
    });
    c.a(((g)paramb.eiY).mContext, "address", ".ui.WalletSelectAddrUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(175742);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "editAddress";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.r
 * JD-Core Version:    0.7.0.1
 */