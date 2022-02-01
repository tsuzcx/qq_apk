package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

public class r
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(175742);
    Intent localIntent = new Intent();
    String str3 = ((g)paramb.chg).getUrl();
    localIntent.putExtra("req_url", str3);
    String str2 = ((g)paramb.chg).EgL.getAppId();
    String str1 = str2;
    if (bu.isNullOrNil(str2))
    {
      str1 = str2;
      if (!bu.isNullOrNil(str3))
      {
        str1 = str2;
        if (Uri.parse(str3).getHost().equals("game.weixin.qq.com")) {
          str1 = "wx62d9035fd4fd2059";
        }
      }
    }
    localIntent.putExtra("req_app_id", str1);
    localIntent.putExtra("launch_from_webview", true);
    ((MMActivity)((g)paramb.chg).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(175741);
        if (paramAnonymousInt1 == (r.this.hashCode() & 0xFFFF))
        {
          ((MMActivity)((g)paramb.chg).mContext).mmSetOnActivityResultCallback(null);
          if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
          {
            String str1 = bu.bI(paramAnonymousIntent.getStringExtra("nationalCode"), "");
            String str2 = bu.bI(paramAnonymousIntent.getStringExtra("userName"), "");
            String str3 = bu.bI(paramAnonymousIntent.getStringExtra("telNumber"), "");
            String str4 = bu.bI(paramAnonymousIntent.getStringExtra("addressPostalCode"), "");
            String str5 = bu.bI(paramAnonymousIntent.getStringExtra("proviceFirstStageName"), "");
            String str6 = bu.bI(paramAnonymousIntent.getStringExtra("addressCitySecondStageName"), "");
            String str7 = bu.bI(paramAnonymousIntent.getStringExtra("addressCountiesThirdStageName"), "");
            paramAnonymousIntent = bu.bI(paramAnonymousIntent.getStringExtra("addressDetailInfo"), "");
            ae.i("MicroMsg.JsApiEditAddress", "first =  " + str5 + " ; detail =" + paramAnonymousIntent + "; second = " + str6 + " ; tel = " + str3 + "; third = " + str7);
            if (!bu.isNullOrNil(str2))
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
              paramb.e("", localHashMap);
              AppMethodBeat.o(175741);
              return;
            }
          }
          if (paramAnonymousInt2 == 0)
          {
            paramb.a("cancel", null);
            AppMethodBeat.o(175741);
            return;
          }
          paramb.a("fail", null);
        }
        AppMethodBeat.o(175741);
      }
    });
    d.a(((g)paramb.chg).mContext, "address", ".ui.WalletSelectAddrUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(175742);
  }
  
  public final int ced()
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