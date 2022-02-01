package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.e.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class bf
  extends bw<g>
{
  private static int iiz;
  
  public static void atG(int paramInt)
  {
    iiz = paramInt;
  }
  
  public static int iuR()
  {
    return iiz;
  }
  
  public static void iuS()
  {
    iiz = 0;
  }
  
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78620);
    Log.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.j("data is null", null);
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
        m.bmB(paramString.optString("img_url"));
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
        com.tencent.mm.br.c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, new MMActivity.a()
        {
          public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(78619);
            final String str2;
            if (paramAnonymousInt1 == 1) {
              str2 = paramString.optString("appid");
            }
            switch (paramAnonymousInt2)
            {
            default: 
              parama.j("fail", null);
              AppMethodBeat.o(78619);
              return;
            case -1: 
              if (paramAnonymousIntent == null) {}
              for (final String str1 = null; (str1 == null) || (str1.length() == 0); str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
              {
                Log.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                parama.j("fail", null);
                AppMethodBeat.o(78619);
                return;
              }
              if (Util.isNullOrNil(str1))
              {
                Log.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                AppMethodBeat.o(78619);
                return;
              }
              final String str3 = paramString.optString("img_url");
              final w localw = k.a(paramContext, paramContext.getResources().getString(c.i.app_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(296052);
                  r.bJZ().NO(str3);
                  bf.2.this.Ive.j("cancel", null);
                  AppMethodBeat.o(296052);
                }
              });
              r.bJZ().a(str3, true, new e.c()
              {
                public final void a(Bitmap paramAnonymous2Bitmap, byte[] paramAnonymous2ArrayOfByte)
                {
                  AppMethodBeat.i(296047);
                  if (localw != null) {
                    localw.dismiss();
                  }
                  bf.a(bf.2.this.val$context, str2, str1, bf.2.this.ejE, paramAnonymousIntent);
                  bf.2.this.Ive.j(null, null);
                  AppMethodBeat.o(296047);
                }
              });
              AppMethodBeat.o(78619);
              return;
            }
            parama.j("cancel", null);
            AppMethodBeat.o(78619);
          }
        });
        AppMethodBeat.o(78620);
        return;
      }
    }
    Log.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
    Object localObject1 = new dn();
    Object localObject2 = new c.a();
    ((c.a)localObject2).url = paramString.optString("shareUrl");
    ((c.a)localObject2).thumbUrl = paramString.optString("img_url");
    ((c.a)localObject2).title = paramString.optString("title");
    ((c.a)localObject2).desc = paramString.optString("desc");
    ((c.a)localObject2).appid = paramString.optString("appid");
    if ((paramContext != null) && ((paramContext instanceof MMActivity)))
    {
      ((dn)localObject1).hDr.activity = ((Activity)paramContext);
      ((dn)localObject1).hDr.hDy = 36;
    }
    ((dn)localObject1).hDr.hDA = new a.c()
    {
      public final void cpT() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(78618);
        Log.d("MicroMsg.JsApiSendAppMessage", "onHide");
        parama.j(null, null);
        AppMethodBeat.o(78618);
      }
      
      public final void onShow() {}
    };
    com.tencent.mm.plugin.webview.model.c.a((dn)localObject1, (c.a)localObject2);
    ((dn)localObject1).publish();
    if (((dn)localObject1).hDs.ret != 0) {
      parama.j("fail", null);
    }
    AppMethodBeat.o(78620);
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bf
 * JD-Core Version:    0.7.0.1
 */