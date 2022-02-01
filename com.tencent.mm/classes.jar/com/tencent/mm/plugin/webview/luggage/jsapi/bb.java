package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uw.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class bb
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  private static int gcn;
  
  public static void anM(int paramInt)
  {
    gcn = paramInt;
  }
  
  public static int gVg()
  {
    return gcn;
  }
  
  public static void gVh()
  {
    gcn = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78620);
    Log.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.i("data is null", null);
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
        k.bmW(paramString.optString("img_url"));
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
        com.tencent.mm.by.c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, new MMActivity.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(78619);
            Object localObject1;
            if (paramAnonymousInt1 == 1) {
              localObject1 = paramString.optString("appid");
            }
            switch (paramAnonymousInt2)
            {
            default: 
              parama.i("fail", null);
              AppMethodBeat.o(78619);
              return;
            case -1: 
              if (paramAnonymousIntent == null) {}
              for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
              {
                Log.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.i("fail", null);
                AppMethodBeat.o(78619);
                return;
              }
              if (Util.isNullOrNil(str))
              {
                Log.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(78619);
                return;
              }
              q.bmg();
              Object localObject2 = d.LI(paramString.optString("img_url"));
              Object localObject3 = bb.ck(paramString);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                Log.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                localObject4 = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
                ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
              }
              Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject1, true, false);
              localObject2 = new uw();
              ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject3);
              ((uw)localObject2).fUc.appId = ((String)localObject1);
              localObject3 = ((uw)localObject2).fUc;
              if (localObject4 == null)
              {
                localObject1 = "";
                ((uw.a)localObject3).appName = ((String)localObject1);
                ((uw)localObject2).fUc.toUser = str;
                ((uw)localObject2).fUc.fFO = 2;
                if (!Util.isNullOrNil(paramString.optString("src_username"))) {
                  break label501;
                }
                ((uw)localObject2).fUc.fUf = null;
              }
              for (;;)
              {
                ((uw)localObject2).fUc.fUg = paramString.optString("shareUrl");
                ((uw)localObject2).fUc.fUh = paramString.optString("currentUrl");
                ((uw)localObject2).fUc.fUi = paramString.optString("preVerifyAppId");
                EventCenter.instance.publish((IEvent)localObject2);
                paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
                if (!Util.isNullOrNil(paramAnonymousIntent))
                {
                  localObject1 = new uz();
                  ((uz)localObject1).fUn.fcD = str;
                  ((uz)localObject1).fUn.content = paramAnonymousIntent;
                  ((uz)localObject1).fUn.type = ab.QZ(str);
                  ((uz)localObject1).fUn.flags = 0;
                  EventCenter.instance.publish((IEvent)localObject1);
                }
                com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getResources().getString(c.i.app_shared));
                parama.i(null, null);
                AppMethodBeat.o(78619);
                return;
                localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
                break;
                label501:
                ((uw)localObject2).fUc.fUd = paramString.optString("src_username");
                ((uw)localObject2).fUc.fUe = paramString.optString("src_displayname");
              }
            }
            parama.i("cancel", null);
            AppMethodBeat.o(78619);
          }
        });
        AppMethodBeat.o(78620);
        return;
      }
    }
    Log.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new dd();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).appid = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((dd)localObject1).fyI.activity = ((Activity)paramContext);
      ((dd)localObject1).fyI.fyP = 36;
    }
    ((dd)localObject1).fyI.fyR = new a.c()
    {
      public final void bPL() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        Log.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.i(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    com.tencent.mm.plugin.webview.model.c.a((dd)localObject1, (c.a)localObject2);
    EventCenter.instance.publish((IEvent)localObject1);
    if (((dd)localObject1).fyJ.ret != 0) {
      parama.i("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */