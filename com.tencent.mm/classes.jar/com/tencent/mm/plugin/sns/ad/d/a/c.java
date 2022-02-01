package com.tencent.mm.plugin.sns.ad.d.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class c
{
  public String JfB;
  public String POQ;
  public String PPh;
  public String PPi;
  public int PPj;
  public long PPk;
  
  public static boolean aWs(String paramString)
  {
    AppMethodBeat.i(309990);
    if ((paramString != null) && (paramString.contains("<giveHBCardInfo>")))
    {
      AppMethodBeat.o(309990);
      return true;
    }
    AppMethodBeat.o(309990);
    return false;
  }
  
  public static c aWt(String paramString)
  {
    AppMethodBeat.i(309999);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(309999);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("subCardType");
      if (i != 4)
      {
        AppMethodBeat.o(309999);
        return null;
      }
      c localc = new c();
      localc.POQ = paramString.optString("giveCardId");
      localc.PPj = i;
      localc.PPi = paramString.optString("senderUserName");
      localc.JfB = paramString.optString("senderNickName");
      localc.PPk = paramString.optLong("shareTime");
      AppMethodBeat.o(309999);
      return localc;
    }
    catch (Exception paramString)
    {
      Log.e("ShareGiveHBCardInfo", "toExtInfoJsonString, exp=" + paramString.toString());
      AppMethodBeat.o(309999);
    }
    return null;
  }
  
  public final String gZZ()
  {
    AppMethodBeat.i(310006);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("giveCardId", this.POQ);
      ((JSONObject)localObject).put("subCardType", this.PPj);
      ((JSONObject)localObject).put("cardType", 2);
      ((JSONObject)localObject).put("senderUserName", this.PPi);
      ((JSONObject)localObject).put("senderNickName", this.JfB);
      ((JSONObject)localObject).put("shareTime", this.PPk);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(310006);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("ShareGiveHBCardInfo", "toExtInfoJsonString, exp=" + localException.toString());
      AppMethodBeat.o(310006);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.c
 * JD-Core Version:    0.7.0.1
 */