package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class ba
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  private static int dOD;
  
  public static void WJ(int paramInt)
  {
    dOD = paramInt;
  }
  
  public static int ePO()
  {
    return dOD;
  }
  
  public static void ePP()
  {
    dOD = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78620);
    ad.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.f("data is null", null);
        AppMethodBeat.o(78620);
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
        i.aJq(paramString.optString("img_url"));
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
        com.tencent.mm.bs.d.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, new MMActivity.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(78619);
            Object localObject1;
            if (paramAnonymousInt1 == 1) {
              localObject1 = paramString.optString("appid");
            }
            switch (paramAnonymousInt2)
            {
            default: 
              parama.f("fail", null);
              AppMethodBeat.o(78619);
              return;
            case -1: 
              if (paramAnonymousIntent == null) {}
              for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
              {
                ad.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.f("fail", null);
                AppMethodBeat.o(78619);
                return;
              }
              if (bt.isNullOrNil(str))
              {
                ad.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(78619);
                return;
              }
              q.aIE();
              Object localObject2 = com.tencent.mm.aw.d.vT(paramString.optString("img_url"));
              Object localObject3 = ba.bA(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ad.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.m((String)localObject1, true, false);
              localObject2 = new su();
              ((su)localObject2).dHn.dtZ = ((WXMediaMessage)localObject3);
              ((su)localObject2).dHn.appId = ((String)localObject1);
              localObject3 = ((su)localObject2).dHn;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((su.a)localObject3).appName = ((String)localObject1);
                ((su)localObject2).dHn.toUser = str;
                ((su)localObject2).dHn.dua = 2;
                if (!bt.isNullOrNil(paramString.optString("src_username"))) {
                  break label500;
                }
                ((su)localObject2).dHn.dHq = null;
              }
              for (;;)
              {
                ((su)localObject2).dHn.dHr = paramString.optString("shareUrl");
                ((su)localObject2).dHn.dHs = paramString.optString("currentUrl");
                ((su)localObject2).dHn.dHt = paramString.optString("preVerifyAppId");
                a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!bt.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new sx();
                  ((sx)localObject1).dHy.dHz = str;
                  ((sx)localObject1).dHy.content = paramAnonymousIntent;
                  ((sx)localObject1).dHy.type = w.Ar(str);
                  ((sx)localObject1).dHy.flags = 0;
                  a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
                }
                com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getResources().getString(2131755894));
                parama.f(null, null);
                AppMethodBeat.o(78619);
                return;
                localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
                break;
                label500:
                ((su)localObject2).dHn.dHo = paramString.optString("src_username");
                ((su)localObject2).dHn.dHp = paramString.optString("src_displayname");
              }
            }
            parama.f("cancel", null);
            AppMethodBeat.o(78619);
          }
        });
        AppMethodBeat.o(78620);
        return;
      }
    }
    ad.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new cv();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).duW = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((cv)localObject1).dnG.activity = ((Activity)paramContext);
      ((cv)localObject1).dnG.dnM = 36;
    }
    ((cv)localObject1).dnG.dnO = new a.c()
    {
      public final void bio() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        ad.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.f(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    c.a((cv)localObject1, (c.a)localObject2);
    a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    if (((cv)localObject1).dnH.ret != 0) {
      parama.f("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */