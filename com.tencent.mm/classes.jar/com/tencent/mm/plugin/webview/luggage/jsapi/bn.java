package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class bn<T extends n>
  extends com.tencent.luggage.d.a<T>
{
  public abstract void a(Context paramContext, String paramString, a parama);
  
  public void a(final com.tencent.luggage.d.a<T>.a parama)
  {
    Object localObject;
    if (bYk() == 1)
    {
      localObject = new JsApiMMTask();
      ((JsApiMMTask)localObject).Cng = parama;
      ((JsApiMMTask)localObject).Cnh = getClass().getName();
      ((JsApiMMTask)localObject).kct = parama.bWS.bVY.toString();
      ((JsApiMMTask)localObject).bej();
      AppBrandMainProcessService.a((MainProcessTask)localObject);
      return;
    }
    if (bYk() == 2)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("jsapi_name", getClass().getName());
      ((Bundle)localObject).putString("data", parama.bWS.bVY.toString());
      b.a((MMActivity)((n)parama.bWR).mContext, (Bundle)localObject, d.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void q(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78641);
          String str = paramAnonymousBundle.getString("err_msg");
          paramAnonymousBundle = paramAnonymousBundle.getString("data");
          if (!bs.isNullOrNil(str))
          {
            parama.a(str, null);
            AppMethodBeat.o(78641);
            return;
          }
          try
          {
            paramAnonymousBundle = new JSONObject(paramAnonymousBundle);
            parama.a("", paramAnonymousBundle);
            AppMethodBeat.o(78641);
            return;
          }
          catch (Exception paramAnonymousBundle)
          {
            parama.a("", null);
            AppMethodBeat.o(78641);
          }
        }
      });
      return;
    }
    b(parama);
  }
  
  public abstract void b(com.tencent.luggage.d.a<T>.a parama);
  
  public abstract int bYk();
  
  public static abstract class a
  {
    public abstract void f(String paramString, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bn
 * JD-Core Version:    0.7.0.1
 */