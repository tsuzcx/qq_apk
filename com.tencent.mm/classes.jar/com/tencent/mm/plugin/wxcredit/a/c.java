package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends m
{
  public double XHw;
  
  public c(List<l> paramList, String paramString)
  {
    AppMethodBeat.i(72301);
    this.XHw = 0.0D;
    HashMap localHashMap = new HashMap();
    localHashMap.put("session_key", paramString);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      paramString = (l)paramList.next();
      localHashMap.put("qt_id_".concat(String.valueOf(i)), paramString.id);
      localHashMap.put("ans_cont_".concat(String.valueOf(i)), paramString.KtE);
      localHashMap.put("level_".concat(String.valueOf(i)), paramString.level);
      localHashMap.put("parent_id_".concat(String.valueOf(i)), paramString.XHR);
      i += 1;
      if ((paramString.XHT == null) || (!"Y".equals(paramString.KtE))) {
        break label324;
      }
      localHashMap.put("qt_id_".concat(String.valueOf(i)), paramString.XHT.id);
      localHashMap.put("ans_cont_".concat(String.valueOf(i)), paramString.XHT.KtE);
      localHashMap.put("level_".concat(String.valueOf(i)), paramString.XHT.level);
      localHashMap.put("parent_id_".concat(String.valueOf(i)), paramString.XHT.XHR);
      i += 1;
    }
    label324:
    for (;;)
    {
      break;
      localHashMap.put("total_num", String.valueOf(i));
      setRequestData(localHashMap);
      AppMethodBeat.o(72301);
      return;
    }
  }
  
  public final int getTenpayCgicmd()
  {
    return 60;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72302);
    Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72302);
      return;
    }
    try
    {
      this.XHw = (paramJSONObject.getInt("credit_amount") / 100.0D);
      AppMethodBeat.o(72302);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
      AppMethodBeat.o(72302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.c
 * JD-Core Version:    0.7.0.1
 */