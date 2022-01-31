package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pb.a;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class ak
  extends ax<e>
{
  private static int cfa;
  
  public static void BY(int paramInt)
  {
    cfa = paramInt;
  }
  
  public static int cbx()
  {
    return cfa;
  }
  
  public static void cby()
  {
    cfa = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final aw.a parama)
  {
    y.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
    Object localObject1;
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString == null)
        {
          parama.e("data is null", null);
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
              Object localObject1;
              if (paramAnonymousInt1 == 1) {
                localObject1 = paramString.optString("appid");
              }
              switch (paramAnonymousInt2)
              {
              default: 
                parama.e("fail", null);
                return;
              case -1: 
                if (paramAnonymousIntent == null) {}
                for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
                {
                  y.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                  parama.e("fail", null);
                  return;
                }
                if (bk.bl(str))
                {
                  y.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                  return;
                }
                o.OI();
                Object localObject2 = com.tencent.mm.as.c.jK(paramString.optString("img_url"));
                Object localObject3 = ak.az(paramString);
                if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
                {
                  y.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                  localObject4 = new ByteArrayOutputStream();
                  ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                  ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
                }
                Object localObject4 = g.by((String)localObject1, true);
                localObject2 = new pb();
                ((pb)localObject2).bYE.bRd = ((WXMediaMessage)localObject3);
                ((pb)localObject2).bYE.appId = ((String)localObject1);
                localObject3 = ((pb)localObject2).bYE;
                if (localObject4 == null)
                {
                  localObject1 = "";
                  ((pb.a)localObject3).appName = ((String)localObject1);
                  ((pb)localObject2).bYE.toUser = str;
                  ((pb)localObject2).bYE.bYF = 2;
                  if (!bk.bl(paramString.optString("src_username"))) {
                    break label476;
                  }
                  ((pb)localObject2).bYE.bYI = null;
                }
                for (;;)
                {
                  ((pb)localObject2).bYE.bYJ = paramString.optString("shareUrl");
                  ((pb)localObject2).bYE.bYK = paramString.optString("currentUrl");
                  ((pb)localObject2).bYE.bYL = paramString.optString("preVerifyAppId");
                  com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
                  paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                  if (!bk.bl(paramAnonymousIntent))
                  {
                    localObject1 = new pe();
                    ((pe)localObject1).bYQ.bYR = str;
                    ((pe)localObject1).bYQ.content = paramAnonymousIntent;
                    ((pe)localObject1).bYQ.type = s.hW(str);
                    ((pe)localObject1).bYQ.flags = 0;
                    com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
                  }
                  h.bC(paramContext, paramContext.getResources().getString(R.l.app_shared));
                  parama.e(null, null);
                  return;
                  localObject1 = ((f)localObject4).field_appName;
                  break;
                  label476:
                  ((pb)localObject2).bYE.bYG = paramString.optString("src_username");
                  ((pb)localObject2).bYE.bYH = paramString.optString("src_displayname");
                }
              }
              parama.e("cancel", null);
            }
          });
          return;
        }
      }
      y.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
      localObject1 = new cj();
      Object localObject2 = new c.a();
      ((c.a)localObject2).url = paramString.optString("shareUrl");
      ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
      ((c.a)localObject2).title = paramString.optString("title");
      ((c.a)localObject2).desc = paramString.optString("desc");
      ((c.a)localObject2).bOL = paramString.optString("appid");
      if ((paramContext != null) && ((paramContext instanceof MMActivity)))
      {
        ((cj)localObject1).bIw.activity = ((Activity)paramContext);
        ((cj)localObject1).bIw.bID = 36;
      }
      ((cj)localObject1).bIw.bIF = new a.c()
      {
        public final void bSd() {}
        
        public final void onHide()
        {
          y.d("MicroMsg.JsApiSendAppMessage", "onHide");
          parama.e(null, null);
        }
        
        public final void onShow() {}
      };
      com.tencent.mm.plugin.webview.model.c.a((cj)localObject1, (c.a)localObject2);
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
    } while (((cj)localObject1).bIx.ret == 0);
    parama.e("fail", null);
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<e>.a parama) {}
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */