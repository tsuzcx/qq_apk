package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class h
{
  public String dvP;
  public int type;
  public String xZu;
  public int xZv;
  public int xZw;
  
  public static h aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(100592);
    try
    {
      h localh = new h();
      localh.xZu = paramJSONObject.getString("waid");
      localh.xZw = paramJSONObject.optInt("expire");
      localh.xZv = paramJSONObject.optInt("timeStamp");
      localh.dvP = paramJSONObject.optString("pkg");
      localh.type = paramJSONObject.optInt("type");
      AppMethodBeat.o(100592);
      return localh;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("ad.waid.WaidItem", "parseFromJson exp=" + paramJSONObject.toString());
      AppMethodBeat.o(100592);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100596);
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      if (this.type == 2)
      {
        if ((paramObject.xZu != null) && (paramObject.xZu.equals(this.xZu)))
        {
          AppMethodBeat.o(100596);
          return true;
        }
        AppMethodBeat.o(100596);
        return false;
      }
      if (this.type == 1)
      {
        if ((paramObject.dvP != null) && (paramObject.dvP.equals(this.dvP)))
        {
          AppMethodBeat.o(100596);
          return true;
        }
        AppMethodBeat.o(100596);
        return false;
      }
    }
    AppMethodBeat.o(100596);
    return false;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(100595);
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      int i = ce.asT();
      l = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("ad.waid.WaidItem", "isExpired exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(100595);
    }
    if (this.xZv + this.xZw <= l)
    {
      AppMethodBeat.o(100595);
      return true;
    }
    return false;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(100593);
    if (this.type == 2)
    {
      if ((!TextUtils.isEmpty(this.xZu)) && (this.xZw > 0))
      {
        AppMethodBeat.o(100593);
        return true;
      }
      AppMethodBeat.o(100593);
      return false;
    }
    if (this.type == 1)
    {
      if ((!TextUtils.isEmpty(this.xZu)) && (!TextUtils.isEmpty(this.dvP)) && (this.xZw > 0))
      {
        AppMethodBeat.o(100593);
        return true;
      }
      AppMethodBeat.o(100593);
      return false;
    }
    AppMethodBeat.o(100593);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(100594);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("waid", this.xZu);
      localJSONObject.put("expire", this.xZw);
      localJSONObject.put("timeStamp", this.xZv);
      localJSONObject.put("pkg", this.dvP);
      localJSONObject.put("type", this.type);
      AppMethodBeat.o(100594);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      ad.e("ad.waid.WaidItem", "toJson exp=" + localException.toString());
      AppMethodBeat.o(100594);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(100597);
    Object localObject = toJson();
    if (localObject == null)
    {
      AppMethodBeat.o(100597);
      return "";
    }
    localObject = ((JSONObject)localObject).toString();
    AppMethodBeat.o(100597);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.h
 * JD-Core Version:    0.7.0.1
 */