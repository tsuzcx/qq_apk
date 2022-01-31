package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class ah
  extends aw<n>
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    if (bk.dk(paramLinkedList)) {}
    for (;;)
    {
      return;
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
          y.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
        }
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      com.tencent.mm.cg.a.post(new ah.1(this, paramContext, parama));
      return;
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
    }
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(com.tencent.luggage.e.a<n>.a parama) {}
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */