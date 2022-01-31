package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class aq
  extends bh<n>
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(6356);
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(6356);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("download_id", -1);
        localJSONObject.put("state", "default");
        paramJSONObject.put(str, localJSONObject);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(6356);
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6355);
    ab.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      com.tencent.mm.ch.a.post(new aq.1(this, paramContext, parama));
      AppMethodBeat.o(6355);
      return;
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6355);
    }
  }
  
  public final void b(com.tencent.luggage.d.a<n>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */