package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  private ProgressDialog fOC = null;
  
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78551);
    Object localObject = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (localObject == null)
    {
      ae.i("MicroMsg.JsApiDownLoadImage", "data is null");
      parama.f("invalid_data", null);
      AppMethodBeat.o(78551);
      return;
    }
    paramString = ((JSONObject)localObject).optString("preVerifyAppId");
    final String str = ((JSONObject)localObject).optString("serverId");
    if (bu.getInt(((JSONObject)localObject).optString("isShowProgressTips", "0"), 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, appid is : %s, media id is : %s", new Object[] { paramString, str });
      if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(str))) {
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
        ae.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
        if ((!bu.isNullOrNil(paramAnonymousString2)) && (paramAnonymousString2.equals(str)))
        {
          com.tencent.mm.plugin.webview.modeltools.g.eUF().b(this);
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
          paramAnonymousString2 = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN(paramAnonymousString1);
          if (((paramAnonymousString2 instanceof WebViewJSSDKImageItem)) && (bu.isNullOrNil(paramAnonymousString2.kKQ))) {
            ((WebViewJSSDKImageItem)paramAnonymousString2).fwO();
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
    com.tencent.mm.plugin.webview.modeltools.g.eUF().a(paramString, str, (f.b)localObject);
    ae.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, add cdn download task result : %b", new Object[] { Boolean.TRUE });
    if (i != 0)
    {
      paramContext.getString(2131755906);
      this.fOC = h.b(paramContext, paramContext.getString(2131766263), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78550);
          com.tencent.mm.plugin.webview.modeltools.g.eUF().b(this.EiV);
          com.tencent.mm.plugin.webview.modeltools.g.eUF();
          an.aIH(str);
          parama.f("downloadImage:fail", null);
          AppMethodBeat.o(78550);
        }
      });
    }
    AppMethodBeat.o(78551);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ced()
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