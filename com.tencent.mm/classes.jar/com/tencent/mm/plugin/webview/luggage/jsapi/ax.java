package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sh.a;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static int dCq;
  
  public static void UT(int paramInt)
  {
    dCq = paramInt;
  }
  
  public static int eAW()
  {
    return dCq;
  }
  
  public static void eAX()
  {
    dCq = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78620);
    ac.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
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
        i.aDP(paramString.optString("img_url"));
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
                ac.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.f("fail", null);
                AppMethodBeat.o(78619);
                return;
              }
              if (bs.isNullOrNil(str))
              {
                ac.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(78619);
                return;
              }
              o.aFw();
              Object localObject2 = com.tencent.mm.av.c.te(paramString.optString("img_url"));
              Object localObject3 = ax.br(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ac.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.k((String)localObject1, true, false);
              localObject2 = new sh();
              ((sh)localObject2).dvk.dis = ((WXMediaMessage)localObject3);
              ((sh)localObject2).dvk.appId = ((String)localObject1);
              localObject3 = ((sh)localObject2).dvk;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((sh.a)localObject3).appName = ((String)localObject1);
                ((sh)localObject2).dvk.toUser = str;
                ((sh)localObject2).dvk.dit = 2;
                if (!bs.isNullOrNil(paramString.optString("src_username"))) {
                  break label500;
                }
                ((sh)localObject2).dvk.dvn = null;
              }
              for (;;)
              {
                ((sh)localObject2).dvk.dvo = paramString.optString("shareUrl");
                ((sh)localObject2).dvk.dvp = paramString.optString("currentUrl");
                ((sh)localObject2).dvk.dvq = paramString.optString("preVerifyAppId");
                com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!bs.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new sk();
                  ((sk)localObject1).dvv.dvw = str;
                  ((sk)localObject1).dvv.content = paramAnonymousIntent;
                  ((sk)localObject1).dvv.type = w.xt(str);
                  ((sk)localObject1).dvv.flags = 0;
                  com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
                }
                com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getResources().getString(2131755894));
                parama.f(null, null);
                AppMethodBeat.o(78619);
                return;
                localObject1 = ((g)localObject4).field_appName;
                break;
                label500:
                ((sh)localObject2).dvk.dvl = paramString.optString("src_username");
                ((sh)localObject2).dvk.dvm = paramString.optString("src_displayname");
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
    ac.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new cs();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).djj = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((cs)localObject1).dck.activity = ((Activity)paramContext);
      ((cs)localObject1).dck.dcq = 36;
    }
    ((cs)localObject1).dck.dcs = new a.c()
    {
      public final void beK() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        ac.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.f(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    com.tencent.mm.plugin.webview.model.c.a((cs)localObject1, (c.a)localObject2);
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
    if (((cs)localObject1).dcl.ret != 0) {
      parama.f("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bYk()
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