package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
{
  public static void a(a parama)
  {
    AppMethodBeat.i(229477);
    if (parama != null) {}
    try
    {
      report(parama.fJK(), parama.getContent());
      AppMethodBeat.o(229477);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(229477);
    }
  }
  
  private static void report(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229479);
    try
    {
      Log.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      m.ks(paramString1, paramString2);
      AppMethodBeat.o(229479);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(229479);
    }
  }
  
  public static abstract interface a
  {
    public abstract String fJK();
    
    public abstract String getContent();
  }
  
  public static abstract class b
    implements j.a
  {
    private JSONObject fLZ()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bx(localJSONObject);
        return localJSONObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    protected abstract void bw(JSONObject paramJSONObject);
    
    protected abstract void bx(JSONObject paramJSONObject);
    
    protected final JSONObject fLY()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bw(localJSONObject);
        return localJSONObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public String getContent()
    {
      try
      {
        Object localObject = fLY();
        if (localObject != null)
        {
          JSONObject localJSONObject = fLZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.j
 * JD-Core Version:    0.7.0.1
 */