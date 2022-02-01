package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  private ProgressDialog lzP = null;
  
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78551);
    Object localObject = c.ZL(paramString);
    if (localObject == null)
    {
      Log.i("MicroMsg.JsApiDownLoadImage", "data is null");
      parama.j("invalid_data", null);
      AppMethodBeat.o(78551);
      return;
    }
    paramString = ((JSONObject)localObject).optString("preVerifyAppId");
    final String str = ((JSONObject)localObject).optString("serverId");
    if (Util.getInt(((JSONObject)localObject).optString("isShowProgressTips", "0"), 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, appid is : %s, media id is : %s", new Object[] { paramString, str });
      if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(str))) {
        break;
      }
      parama.j("missing arguments", null);
      AppMethodBeat.o(78551);
      return;
    }
    localObject = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(78549);
        Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
        if ((!Util.isNullOrNil(paramAnonymousString2)) && (paramAnonymousString2.equals(str)))
        {
          com.tencent.mm.plugin.webview.modeltools.g.ivY().b(this);
          if (q.a(q.this) != null)
          {
            q.a(q.this).dismiss();
            q.b(q.this);
          }
          if (!paramAnonymousBoolean)
          {
            parama.j("fail", null);
            AppMethodBeat.o(78549);
            return;
          }
          paramAnonymousString2 = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks(paramAnonymousString1);
          if (((paramAnonymousString2 instanceof WebViewJSSDKImageItem)) && (Util.isNullOrNil(paramAnonymousString2.rPM))) {
            ((WebViewJSSDKImageItem)paramAnonymousString2).kLU();
          }
          paramAnonymousString2 = new JSONObject();
        }
        try
        {
          paramAnonymousString2.put("localId", paramAnonymousString1);
          label161:
          parama.j(null, paramAnonymousString2);
          AppMethodBeat.o(78549);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          break label161;
        }
      }
    };
    boolean bool = com.tencent.mm.plugin.webview.modeltools.g.ivY().a(paramString, str, (f.b)localObject);
    Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, add cdn download task result : %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      parama.j("fail", null);
      AppMethodBeat.o(78551);
      return;
    }
    if (i != 0)
    {
      paramContext.getString(c.i.app_tip);
      this.lzP = k.a(paramContext, paramContext.getString(c.i.wv_downloading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78550);
          com.tencent.mm.plugin.webview.modeltools.g.ivY().b(this.WID);
          com.tencent.mm.plugin.webview.modeltools.g.ivY();
          an.bkn(str);
          parama.j("downloadImage:fail", null);
          AppMethodBeat.o(78550);
        }
      });
    }
    AppMethodBeat.o(78551);
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dgI()
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