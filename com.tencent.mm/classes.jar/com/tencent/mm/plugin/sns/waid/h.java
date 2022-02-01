package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class h
{
  public String dtC;
  public int type;
  public String zmu;
  public int zmv;
  public int zmw;
  
  public static h aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(100592);
    try
    {
      h localh = new h();
      localh.zmu = paramJSONObject.getString("waid");
      localh.zmw = paramJSONObject.optInt("expire");
      localh.zmv = paramJSONObject.optInt("timeStamp");
      localh.dtC = paramJSONObject.optString("pkg");
      localh.type = paramJSONObject.optInt("type");
      AppMethodBeat.o(100592);
      return localh;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("ad.waid.WaidItem", "parseFromJson exp=" + paramJSONObject.toString());
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
        if ((paramObject.zmu != null) && (paramObject.zmu.equals(this.zmu)))
        {
          AppMethodBeat.o(100596);
          return true;
        }
        AppMethodBeat.o(100596);
        return false;
      }
      if (this.type == 1)
      {
        if ((paramObject.dtC != null) && (paramObject.dtC.equals(this.dtC)))
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
      int i = ce.azK();
      l = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("ad.waid.WaidItem", "isExpired exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(100595);
    }
    if (this.zmv + this.zmw <= l)
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
      if ((!TextUtils.isEmpty(this.zmu)) && (this.zmw > 0))
      {
        AppMethodBeat.o(100593);
        return true;
      }
      AppMethodBeat.o(100593);
      return false;
    }
    if (this.type == 1)
    {
      if ((!TextUtils.isEmpty(this.zmu)) && (!TextUtils.isEmpty(this.dtC)) && (this.zmw > 0))
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
      localJSONObject.put("waid", this.zmu);
      localJSONObject.put("expire", this.zmw);
      localJSONObject.put("timeStamp", this.zmv);
      localJSONObject.put("pkg", this.dtC);
      localJSONObject.put("type", this.type);
      AppMethodBeat.o(100594);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      ac.e("ad.waid.WaidItem", "toJson exp=" + localException.toString());
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