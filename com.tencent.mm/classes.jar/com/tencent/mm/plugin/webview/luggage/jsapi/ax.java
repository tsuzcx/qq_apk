package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
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

public class ax
  extends bo<f>
{
  private static int dEE;
  
  public static void SL(int paramInt)
  {
    dEE = paramInt;
  }
  
  public static int elA()
  {
    return dEE;
  }
  
  public static void elB()
  {
    dEE = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
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
        i.ayy(paramString.optString("img_url"));
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
              o.ayE();
              Object localObject2 = com.tencent.mm.aw.c.pT(paramString.optString("img_url"));
              Object localObject3 = ax.br(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ad.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.j((String)localObject1, true, false);
              localObject2 = new ry();
              ((ry)localObject2).dxx.doG = ((WXMediaMessage)localObject3);
              ((ry)localObject2).dxx.appId = ((String)localObject1);
              localObject3 = ((ry)localObject2).dxx;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((ry.a)localObject3).appName = ((String)localObject1);
                ((ry)localObject2).dxx.toUser = str;
                ((ry)localObject2).dxx.dxy = 2;
                if (!bt.isNullOrNil(paramString.optString("src_username"))) {
                  break label500;
                }
                ((ry)localObject2).dxx.dxB = null;
              }
              for (;;)
              {
                ((ry)localObject2).dxx.dxC = paramString.optString("shareUrl");
                ((ry)localObject2).dxx.dxD = paramString.optString("currentUrl");
                ((ry)localObject2).dxx.dxE = paramString.optString("preVerifyAppId");
                com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!bt.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new sb();
                  ((sb)localObject1).dxJ.dxK = str;
                  ((sb)localObject1).dxJ.content = paramAnonymousIntent;
                  ((sb)localObject1).dxJ.type = w.tq(str);
                  ((sb)localObject1).dxJ.flags = 0;
                  com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
                }
                com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getResources().getString(2131755894));
                parama.f(null, null);
                AppMethodBeat.o(78619);
                return;
                localObject1 = ((g)localObject4).field_appName;
                break;
                label500:
                ((ry)localObject2).dxx.dxz = paramString.optString("src_username");
                ((ry)localObject2).dxx.dxA = paramString.optString("src_displayname");
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
    Object localObject1 = new cs();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).dlB = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((cs)localObject1).deQ.activity = ((Activity)paramContext);
      ((cs)localObject1).deQ.deW = 36;
    }
    ((cs)localObject1).deQ.deY = new a.c()
    {
      public final void aXN() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        ad.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.f(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    com.tencent.mm.plugin.webview.model.c.a((cs)localObject1, (c.a)localObject2);
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
    if (((cs)localObject1).deR.ret != 0) {
      parama.f("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bQV()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */