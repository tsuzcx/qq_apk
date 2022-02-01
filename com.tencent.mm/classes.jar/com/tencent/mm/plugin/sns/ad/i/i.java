package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class i
{
  public static void a(a parama)
  {
    AppMethodBeat.i(202362);
    if (parama != null) {}
    try
    {
      report(parama.eWH(), parama.getContent());
      AppMethodBeat.o(202362);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(202362);
    }
  }
  
  private static void report(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202363);
    try
    {
      Log.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      k.jY(paramString1, paramString2);
      AppMethodBeat.o(202363);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(202363);
    }
  }
  
  public static abstract interface a
  {
    public abstract String eWH();
    
    public abstract String getContent();
  }
  
  public static abstract class b
    implements i.a
  {
    private JSONObject eYm()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bn(localJSONObject);
        return localJSONObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    private JSONObject eYn()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bo(localJSONObject);
        return localJSONObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    protected abstract void bn(JSONObject paramJSONObject);
    
    protected abstract void bo(JSONObject paramJSONObject);
    
    public String getContent()
    {
      try
      {
        Object localObject = eYm();
        if (localObject != null)
        {
          JSONObject localJSONObject = eYn();
          if (localJSONObject != null) {
            ((JSONObject)localObject).putOpt("extInfo", localJSONObject);
          }
          localObject = ((JSONObject)localObject).toString();
          return localObject;
        }
      }
      catch (Throwable localThrowable) {}
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.i
 * JD-Core Version:    0.7.0.1
 */