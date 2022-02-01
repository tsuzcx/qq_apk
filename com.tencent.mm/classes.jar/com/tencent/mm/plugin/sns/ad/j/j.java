package com.tencent.mm.plugin.sns.ad.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
{
  public static void a(a parama)
  {
    AppMethodBeat.i(309716);
    if (parama != null) {}
    try
    {
      report(parama.gZE(), parama.getContent());
      return;
    }
    finally
    {
      AppMethodBeat.o(309716);
    }
  }
  
  private static void report(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309725);
    try
    {
      Log.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      m.lU(paramString1, paramString2);
      return;
    }
    finally
    {
      AppMethodBeat.o(309725);
    }
  }
  
  public static abstract interface a
  {
    public abstract String gZE();
    
    public abstract String getContent();
  }
  
  public static abstract class b
    implements j.a
  {
    private JSONObject hcs()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bO(localJSONObject);
        return localJSONObject;
      }
      finally {}
      return null;
    }
    
    protected abstract void bN(JSONObject paramJSONObject);
    
    protected abstract void bO(JSONObject paramJSONObject);
    
    public String getContent()
    {
      try
      {
        Object localObject1 = hcr();
        if (localObject1 != null)
        {
          JSONObject localJSONObject = hcs();
          if (localJSONObject != null) {
            ((JSONObject)localObject1).putOpt("extInfo", localJSONObject);
          }
          localObject1 = ((JSONObject)localObject1).toString();
          return localObject1;
        }
      }
      finally {}
      return "";
    }
    
    protected final JSONObject hcr()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bN(localJSONObject);
        return localJSONObject;
      }
      finally {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.j
 * JD-Core Version:    0.7.0.1
 */