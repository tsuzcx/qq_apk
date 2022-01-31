package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class aw<T extends n>
  extends a<T>
{
  public abstract void a(Context paramContext, String paramString, aw.a parama);
  
  public void a(a<T>.a parama)
  {
    Object localObject;
    if (aGj() == 1)
    {
      localObject = new JsApiMMTask();
      ((JsApiMMTask)localObject).rdg = parama;
      ((JsApiMMTask)localObject).rdh = getClass().getName();
      ((JsApiMMTask)localObject).giZ = parama.bih.bhk.toString();
      ((JsApiMMTask)localObject).ahC();
      LuggageMainProcessService.a((MainProcessTask)localObject);
      return;
    }
    if (aGj() == 2)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("jsapi_name", getClass().getName());
      ((Bundle)localObject).putString("data", parama.bih.bhk.toString());
      c.a((MMActivity)((n)parama.big).mContext, (Bundle)localObject, com.tencent.mm.plugin.webview.luggage.ipc.e.class, new aw.1(this, parama));
      return;
    }
    b(parama);
  }
  
  public abstract int aGj();
  
  public abstract void b(a<T>.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */