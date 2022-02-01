package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class av
  extends br<s>
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78607);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(78607);
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
        Log.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(78607);
  }
  
  public final void a(final Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(78606);
    Log.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78605);
          Object localObject = paramContext.optJSONArray("appIdArray");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            av.a((JSONArray)localObject, parama);
            AppMethodBeat.o(78605);
            return;
          }
          long l = paramContext.optLong("download_id", -1L);
          localObject = paramContext.optString("appid");
          FileDownloadTaskInfo localFileDownloadTaskInfo;
          if (l > 0L)
          {
            localFileDownloadTaskInfo = f.cPZ().Ix(l);
            localObject = localFileDownloadTaskInfo;
            if (localFileDownloadTaskInfo == null) {
              localObject = new FileDownloadTaskInfo();
            }
            av.a((FileDownloadTaskInfo)localObject, parama);
            AppMethodBeat.o(78605);
            return;
          }
          if (!Util.isNullOrNil((String)localObject))
          {
            localFileDownloadTaskInfo = f.cPZ().asZ((String)localObject);
            localObject = localFileDownloadTaskInfo;
            if (localFileDownloadTaskInfo == null) {
              localObject = new FileDownloadTaskInfo();
            }
            av.a((FileDownloadTaskInfo)localObject, parama);
            AppMethodBeat.o(78605);
            return;
          }
          parama.i("fail", null);
          AppMethodBeat.o(78605);
        }
      });
      AppMethodBeat.o(78606);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.i("fail", null);
      AppMethodBeat.o(78606);
    }
  }
  
  public final void b(b<s>.a paramb) {}
  
  public final int cDj()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av
 * JD-Core Version:    0.7.0.1
 */