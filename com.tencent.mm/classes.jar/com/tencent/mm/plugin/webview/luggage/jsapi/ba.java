package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static int dPT;
  
  public static void Xq(int paramInt)
  {
    dPT = paramInt;
  }
  
  public static int eTA()
  {
    return dPT;
  }
  
  public static void eTB()
  {
    dPT = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78620);
    ae.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
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
        i.aKJ(paramString.optString("img_url"));
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
        com.tencent.mm.br.d.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, new MMActivity.a()
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
                ae.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.f("fail", null);
                AppMethodBeat.o(78619);
                return;
              }
              if (bu.isNullOrNil(str))
              {
                ae.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(78619);
                return;
              }
              q.aIW();
              Object localObject2 = com.tencent.mm.av.d.wA(paramString.optString("img_url"));
              Object localObject3 = ba.bA(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ae.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.m((String)localObject1, true, false);
              localObject2 = new sv();
              ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject3);
              ((sv)localObject2).dIs.appId = ((String)localObject1);
              localObject3 = ((sv)localObject2).dIs;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((sv.a)localObject3).appName = ((String)localObject1);
                ((sv)localObject2).dIs.toUser = str;
                ((sv)localObject2).dIs.dvf = 2;
                if (!bu.isNullOrNil(paramString.optString("src_username"))) {
                  break label500;
                }
                ((sv)localObject2).dIs.dIv = null;
              }
              for (;;)
              {
                ((sv)localObject2).dIs.dIw = paramString.optString("shareUrl");
                ((sv)localObject2).dIs.dIx = paramString.optString("currentUrl");
                ((sv)localObject2).dIs.dIy = paramString.optString("preVerifyAppId");
                a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!bu.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new sy();
                  ((sy)localObject1).dID.cUB = str;
                  ((sy)localObject1).dID.content = paramAnonymousIntent;
                  ((sy)localObject1).dID.type = x.Bb(str);
                  ((sy)localObject1).dID.flags = 0;
                  a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
                }
                com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getResources().getString(2131755894));
                parama.f(null, null);
                AppMethodBeat.o(78619);
                return;
                localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
                break;
                label500:
                ((sv)localObject2).dIs.dIt = paramString.optString("src_username");
                ((sv)localObject2).dIs.dIu = paramString.optString("src_displayname");
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
    ae.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new cw();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).dwb = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((cw)localObject1).doL.activity = ((Activity)paramContext);
      ((cw)localObject1).doL.doR = 36;
    }
    ((cw)localObject1).doL.doT = new a.c()
    {
      public final void biX() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        ae.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.f(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    c.a((cw)localObject1, (c.a)localObject2);
    a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    if (((cw)localObject1).doM.ret != 0) {
      parama.f("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ced()
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