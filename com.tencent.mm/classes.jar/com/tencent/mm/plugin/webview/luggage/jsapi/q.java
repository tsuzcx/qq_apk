package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends bo<f>
{
  private ProgressDialog fts = null;
  
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78551);
    Object localObject = b.LK(paramString);
    if (localObject == null)
    {
      ac.i("MicroMsg.JsApiDownLoadImage", "data is null");
      parama.f("invalid_data", null);
      AppMethodBeat.o(78551);
      return;
    }
    paramString = ((JSONObject)localObject).optString("preVerifyAppId");
    final String str = ((JSONObject)localObject).optString("serverId");
    if (bs.getInt(((JSONObject)localObject).optString("isShowProgressTips", "0"), 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, appid is : %s, media id is : %s", new Object[] { paramString, str });
      if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(str))) {
        break;
      }
      parama.f("missing arguments", null);
      AppMethodBeat.o(78551);
      return;
    }
    localObject = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(78549);
        ac.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
        if ((!bs.isNullOrNil(paramAnonymousString2)) && (paramAnonymousString2.equals(str)))
        {
          g.eBZ().b(this);
          if (q.a(q.this) != null)
          {
            q.a(q.this).dismiss();
            q.b(q.this);
          }
          if (!paramAnonymousBoolean)
          {
            parama.f("fail", null);
            AppMethodBeat.o(78549);
            return;
          }
          paramAnonymousString2 = g.eCa().aBU(paramAnonymousString1);
          if (((paramAnonymousString2 instanceof WebViewJSSDKImageItem)) && (bs.isNullOrNil(paramAnonymousString2.kmB))) {
            ((WebViewJSSDKImageItem)paramAnonymousString2).fdb();
          }
          paramAnonymousString2 = new JSONObject();
        }
        try
        {
          paramAnonymousString2.put("localId", paramAnonymousString1);
          label161:
          parama.f(null, paramAnonymousString2);
          AppMethodBeat.o(78549);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          break label161;
        }
      }
    };
    g.eBZ().a(paramString, str, (f.b)localObject);
    ac.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, add cdn download task result : %b", new Object[] { Boolean.TRUE });
    if (i != 0)
    {
      paramContext.getString(2131755906);
      this.fts = h.b(paramContext, paramContext.getString(2131766263), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78550);
          g.eBZ().b(this.CnB);
          g.eBZ();
          am.aBO(str);
          parama.f("downloadImage:fail", null);
          AppMethodBeat.o(78550);
        }
      });
    }
    AppMethodBeat.o(78551);
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "downloadImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.q
 * JD-Core Version:    0.7.0.1
 */