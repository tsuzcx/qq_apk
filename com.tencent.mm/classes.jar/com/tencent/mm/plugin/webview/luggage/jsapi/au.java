package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qg.a;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class au
  extends bi<e>
{
  private static int cNG;
  
  public static void JS(int paramInt)
  {
    cNG = paramInt;
  }
  
  public static int dbB()
  {
    return cNG;
  }
  
  public static void dbC()
  {
    cNG = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bh.a parama)
  {
    AppMethodBeat.i(6369);
    ab.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.c("data is null", null);
        AppMethodBeat.o(6369);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      switch (paramString.optInt("sendAppMessageScene", 0))
      {
      default: 
        k.ajm(paramString.optString("img_url"));
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("img_url", paramString.optString("img_url"));
        ((HashMap)localObject1).put("desc", paramString.optString("desc"));
        ((HashMap)localObject1).put("title", paramString.optString("title"));
        ((HashMap)localObject1).put("url", paramString.optString("shareUrl"));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
        ((Intent)localObject2).putExtra("scene_from", 2);
        ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
        ((Intent)localObject2).putExtra("webview_params", (Serializable)localObject1);
        ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
        d.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, new MMActivity.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(6368);
            Object localObject1;
            if (paramAnonymousInt1 == 1) {
              localObject1 = paramString.optString("appid");
            }
            switch (paramAnonymousInt2)
            {
            default: 
              parama.c("fail", null);
              AppMethodBeat.o(6368);
              return;
            case -1: 
              if (paramAnonymousIntent == null) {}
              for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
              {
                ab.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.c("fail", null);
                AppMethodBeat.o(6368);
                return;
              }
              if (bo.isNullOrNil(str))
              {
                ab.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(6368);
                return;
              }
              o.ahB();
              Object localObject2 = com.tencent.mm.at.c.lK(paramString.optString("img_url"));
              Object localObject3 = au.aS(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ab.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = g.ca((String)localObject1, true);
              localObject2 = new qg();
              ((qg)localObject2).cGL.cyF = ((WXMediaMessage)localObject3);
              ((qg)localObject2).cGL.appId = ((String)localObject1);
              localObject3 = ((qg)localObject2).cGL;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((qg.a)localObject3).appName = ((String)localObject1);
                ((qg)localObject2).cGL.toUser = str;
                ((qg)localObject2).cGL.cGM = 2;
                if (!bo.isNullOrNil(paramString.optString("src_username"))) {
                  break label503;
                }
                ((qg)localObject2).cGL.cGP = null;
              }
              for (;;)
              {
                ((qg)localObject2).cGL.cGQ = paramString.optString("shareUrl");
                ((qg)localObject2).cGL.cGR = paramString.optString("currentUrl");
                ((qg)localObject2).cGL.cGS = paramString.optString("preVerifyAppId");
                com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!bo.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new qj();
                  ((qj)localObject1).cGX.cGY = str;
                  ((qj)localObject1).cGX.content = paramAnonymousIntent;
                  ((qj)localObject1).cGX.type = t.oF(str);
                  ((qj)localObject1).cGX.flags = 0;
                  com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
                }
                h.bO(paramContext, paramContext.getResources().getString(2131297076));
                parama.c(null, null);
                AppMethodBeat.o(6368);
                return;
                localObject1 = ((f)localObject4).field_appName;
                break;
                label503:
                ((qg)localObject2).cGL.cGN = paramString.optString("src_username");
                ((qg)localObject2).cGL.cGO = paramString.optString("src_displayname");
              }
            }
            parama.c("cancel", null);
            AppMethodBeat.o(6368);
          }
        });
        AppMethodBeat.o(6369);
        return;
      }
    }
    ab.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new cm();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).cwc = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((cm)localObject1).cpR.activity = ((Activity)paramContext);
      ((cm)localObject1).cpR.cpY = 36;
    }
    ((cm)localObject1).cpR.cqa = new a.c()
    {
      public final void cPa() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(6367);
        ab.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.c(null, null);
        AppMethodBeat.o(6367);
      }
      
      public final void onShow() {}
    };
    com.tencent.mm.plugin.webview.model.c.a((cm)localObject1, (c.a)localObject2);
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
    if (((cm)localObject1).cpS.ret != 0) {
      parama.c("fail", null);
    }
    AppMethodBeat.o(6369);
  }
  
  public final void b(com.tencent.luggage.d.a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.au
 * JD-Core Version:    0.7.0.1
 */