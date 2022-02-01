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
  protected final Properties ZIe;
  
  public h()
  {
    this(null);
  }
  
  public h(Properties paramProperties)
  {
    AppMethodBeat.i(222289);
    this.ZIe = new Properties();
    if (paramProperties != null)
    {
      paramProperties = paramProperties.entrySet().iterator();
      while (paramProperties.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProperties.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(222289);
  }
  
  public final void bR(String paramString, int paramInt)
  {
    AppMethodBeat.i(222293);
    this.ZIe.put(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(222293);
  }
  
  public final void cu(String paramString, long paramLong)
  {
    AppMethodBeat.i(222295);
    this.ZIe.put(paramString, String.valueOf(paramLong));
    AppMethodBeat.o(222295);
  }
  
  public final Properties irU()
  {
    return this.ZIe;
  }
  
  public final void o(String paramString, float paramFloat)
  {
    AppMethodBeat.i(222297);
    this.ZIe.put(paramString, String.valueOf(paramFloat));
    AppMethodBeat.o(222297);
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222292);
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.ZIe.put(paramString1, paramString2);
        AppMethodBeat.o(222292);
        return;
      }
      this.ZIe.put(paramString1, "");
    }
    AppMethodBeat.o(222292);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(222300);
    Object localObject = new JSONObject(this.ZIe);
    if (((JSONObject)localObject).has("data")) {}
    try
    {
      String str = ((JSONObject)localObject).getString("data");
      ((JSONObject)localObject).remove("data");
      ((JSONObject)localObject).put("data", new JSONObject(str));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(222300);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.h
 * JD-Core Version:    0.7.0.1
 */