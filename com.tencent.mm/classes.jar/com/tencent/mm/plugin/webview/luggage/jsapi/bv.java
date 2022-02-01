package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class bv<T extends com.tencent.luggage.d.a>
  extends com.tencent.luggage.d.b<T>
{
  public abstract void a(Context paramContext, String paramString, a parama);
  
  public void a(final com.tencent.luggage.d.b<T>.a paramb)
  {
    Object localObject;
    if (dgI() == 1)
    {
      localObject = new JsApiMMTask();
      ((JsApiMMTask)localObject).WIj = paramb;
      ((JsApiMMTask)localObject).WIk = getClass().getName();
      ((JsApiMMTask)localObject).rDU = paramb.eiZ.eif.toString();
      ((JsApiMMTask)localObject).bQt();
      return;
    }
    if (dgI() == 2)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("jsapi_name", getClass().getName());
      ((Bundle)localObject).putString("data", paramb.eiZ.eif.toString());
      com.tencent.mm.plugin.webview.luggage.ipc.b.a((MMActivity)((com.tencent.luggage.d.a)paramb.eiY).getContext(), (Bundle)localObject, d.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void J(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78641);
          String str = paramAnonymousBundle.getString("err_msg");
          paramAnonymousBundle = paramAnonymousBundle.getString("data");
          if (!Util.isNullOrNil(str))
          {
            paramb.a(str, null);
            AppMethodBeat.o(78641);
            return;
          }
          try
          {
            paramAnonymousBundle = new JSONObject(paramAnonymousBundle);
            paramb.a("", paramAnonymousBundle);
            AppMethodBeat.o(78641);
            return;
          }
          catch (Exception paramAnonymousBundle)
          {
            paramb.a("", null);
            AppMethodBeat.o(78641);
          }
        }
        
        public final void bn(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(296011);
          String str = paramAnonymousBundle.getString("event");
          paramAnonymousBundle = paramAnonymousBundle.getString("data");
          if (((paramb.eiY instanceof com.tencent.luggage.d.a)) && (!TextUtils.isEmpty(str))) {}
          try
          {
            paramAnonymousBundle = new JSONObject(paramAnonymousBundle);
            ((com.tencent.luggage.d.a)paramb.eiY).aod().b(str, paramAnonymousBundle);
            AppMethodBeat.o(296011);
            return;
          }
          catch (Exception paramAnonymousBundle)
          {
            for (;;)
            {
              paramAnonymousBundle = new JSONObject();
            }
          }
        }
      });
      return;
    }
    b(paramb);
  }
  
  public abstract void b(com.tencent.luggage.d.b<T>.a paramb);
  
  public abstract int dgI();
  
  public static abstract class a
  {
    public abstract void b(String paramString, JSONObject paramJSONObject);
    
    public abstract void j(String paramString, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bv
 * JD-Core Version:    0.7.0.1
 */