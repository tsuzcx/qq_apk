package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class bh<T extends n>
  extends a<T>
{
  public abstract void a(Context paramContext, String paramString, bh.a parama);
  
  public void a(a<T>.a parama)
  {
    Object localObject;
    if (bjL() == 1)
    {
      localObject = new JsApiMMTask();
      ((JsApiMMTask)localObject).uTe = parama;
      ((JsApiMMTask)localObject).uTf = getClass().getName();
      ((JsApiMMTask)localObject).hCt = parama.byF.bxK.toString();
      ((JsApiMMTask)localObject).aBj();
      AppBrandMainProcessService.a((MainProcessTask)localObject);
      return;
    }
    if (bjL() == 2)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("jsapi_name", getClass().getName());
      ((Bundle)localObject).putString("data", parama.byF.bxK.toString());
      b.a((MMActivity)((n)parama.byE).mContext, (Bundle)localObject, d.class, new bh.1(this, parama));
      return;
    }
    b(parama);
  }
  
  public abstract void b(a<T>.a parama);
  
  public abstract int bjL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */