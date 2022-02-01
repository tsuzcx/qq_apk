package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

public class r
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(175742);
    Intent localIntent = new Intent();
    String str3 = ((f)parama.bWR).getUrl();
    localIntent.putExtra("req_url", str3);
    String str2 = ((f)parama.bWR).ClA.getAppId();
    String str1 = str2;
    if (bs.isNullOrNil(str2))
    {
      str1 = str2;
      if (!bs.isNullOrNil(str3))
      {
        str1 = str2;
        if (Uri.parse(str3).getHost().equals("game.weixin.qq.com")) {
          str1 = "wx62d9035fd4fd2059";
        }
      }
    }
    localIntent.putExtra("req_app_id", str1);
    localIntent.putExtra("launch_from_webview", true);
    ((MMActivity)((f)parama.bWR).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(175741);
        if (paramAnonymousInt1 == (r.this.hashCode() & 0xFFFF))
        {
          ((MMActivity)((f)parama.bWR).mContext).mmSetOnActivityResultCallback(null);
          if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
          {
            String str1 = bs.bG(paramAnonymousIntent.getStringExtra("nationalCode"), "");
            String str2 = bs.bG(paramAnonymousIntent.getStringExtra("userName"), "");
            String str3 = bs.bG(paramAnonymousIntent.getStringExtra("telNumber"), "");
            String str4 = bs.bG(paramAnonymousIntent.getStringExtra("addressPostalCode"), "");
            String str5 = bs.bG(paramAnonymousIntent.getStringExtra("proviceFirstStageName"), "");
            String str6 = bs.bG(paramAnonymousIntent.getStringExtra("addressCitySecondStageName"), "");
            String str7 = bs.bG(paramAnonymousIntent.getStringExtra("addressCountiesThirdStageName"), "");
            paramAnonymousIntent = bs.bG(paramAnonymousIntent.getStringExtra("addressDetailInfo"), "");
            ac.i("MicroMsg.JsApiEditAddress", "first =  " + str5 + " ; detail =" + paramAnonymousIntent + "; second = " + str6 + " ; tel = " + str3 + "; third = " + str7);
            if (!bs.isNullOrNil(str2))
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("nationalCode", str1);
              localHashMap.put("userName", str2);
              localHashMap.put("telNumber", str3);
              localHashMap.put("addressPostalCode", str4);
              localHashMap.put("proviceFirstStageName", str5);
              localHashMap.put("addressCitySecondStageName", str6);
              localHashMap.put("addressCountiesThirdStageName", str7);
              localHashMap.put("addressDetailInfo", paramAnonymousIntent);
              parama.c("", localHashMap);
              AppMethodBeat.o(175741);
              return;
            }
          }
          if (paramAnonymousInt2 == 0)
          {
            parama.a("cancel", null);
            AppMethodBeat.o(175741);
            return;
          }
          parama.a("fail", null);
        }
        AppMethodBeat.o(175741);
      }
    });
    d.a(((f)parama.bWR).mContext, "address", ".ui.WalletSelectAddrUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(175742);
  }
  
  public final int bYk()
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