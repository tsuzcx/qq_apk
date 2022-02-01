package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.g.a.a.a;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements a
{
  protected final Properties Sft;
  
  public h()
  {
    this(null);
  }
  
  public h(Properties paramProperties)
  {
    AppMethodBeat.i(189659);
    this.Sft = new Properties();
    if (paramProperties != null)
    {
      paramProperties = paramProperties.entrySet().iterator();
      while (paramProperties.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProperties.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(189659);
  }
  
  public final Properties getProperties()
  {
    return this.Sft;
  }
  
  public final void put(String paramString, float paramFloat)
  {
    AppMethodBeat.i(189663);
    this.Sft.put(paramString, String.valueOf(paramFloat));
    AppMethodBeat.o(189663);
  }
  
  public final void put(String paramString, int paramInt)
  {
    AppMethodBeat.i(189661);
    this.Sft.put(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(189661);
  }
  
  public final void put(String paramString, long paramLong)
  {
    AppMethodBeat.i(189662);
    this.Sft.put(paramString, String.valueOf(paramLong));
    AppMethodBeat.o(189662);
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189660);
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.Sft.put(paramString1, paramString2);
        AppMethodBeat.o(189660);
        return;
      }
      this.Sft.put(paramString1, "");
    }
    AppMethodBeat.o(189660);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189664);
    Object localObject = new JSONObject(this.Sft);
    if (((JSONObject)localObject).has("data")) {}
    try
    {
      String str = ((JSONObject)localObject).getString("data");
      ((JSONObject)localObject).remove("data");
      ((JSONObject)localObject).put("data", new JSONObject(str));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(189664);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.e("TPProperties", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.h
 * JD-Core Version:    0.7.0.1
 */