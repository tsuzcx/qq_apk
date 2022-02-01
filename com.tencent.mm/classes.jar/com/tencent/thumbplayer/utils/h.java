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
  protected final Properties ahNh;
  
  public h()
  {
    this(null);
  }
  
  public h(Properties paramProperties)
  {
    AppMethodBeat.i(227064);
    this.ahNh = new Properties();
    if (paramProperties != null)
    {
      paramProperties = paramProperties.entrySet().iterator();
      while (paramProperties.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProperties.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(227064);
  }
  
  public final void cG(String paramString, long paramLong)
  {
    AppMethodBeat.i(227087);
    this.ahNh.put(paramString, String.valueOf(paramLong));
    AppMethodBeat.o(227087);
  }
  
  public final void cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(227084);
    this.ahNh.put(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(227084);
  }
  
  public final Properties kbu()
  {
    return this.ahNh;
  }
  
  public final void p(String paramString, float paramFloat)
  {
    AppMethodBeat.i(227096);
    this.ahNh.put(paramString, String.valueOf(paramFloat));
    AppMethodBeat.o(227096);
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227073);
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.ahNh.put(paramString1, paramString2);
        AppMethodBeat.o(227073);
        return;
      }
      this.ahNh.put(paramString1, "");
    }
    AppMethodBeat.o(227073);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(227113);
    Object localObject = new JSONObject(this.ahNh);
    if (((JSONObject)localObject).has("data")) {}
    try
    {
      String str = ((JSONObject)localObject).getString("data");
      ((JSONObject)localObject).remove("data");
      ((JSONObject)localObject).put("data", new JSONObject(str));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(227113);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.h
 * JD-Core Version:    0.7.0.1
 */