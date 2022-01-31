package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends j
{
  public double rQI = 0.0D;
  
  public c(List<l> paramList, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("session_key", paramString);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      paramString = (l)paramList.next();
      localHashMap.put("qt_id_" + i, paramString.id);
      localHashMap.put("ans_cont_" + i, paramString.lQN);
      localHashMap.put("level_" + i, paramString.level);
      localHashMap.put("parent_id_" + i, paramString.rRe);
      i += 1;
      if ((paramString.rRg == null) || (!"Y".equals(paramString.lQN))) {
        break label370;
      }
      localHashMap.put("qt_id_" + i, paramString.rRg.id);
      localHashMap.put("ans_cont_" + i, paramString.rRg.lQN);
      localHashMap.put("level_" + i, paramString.rRg.level);
      localHashMap.put("parent_id_" + i, paramString.rRg.rRe);
      i += 1;
    }
    label370:
    for (;;)
    {
      break;
      localHashMap.put("total_num", String.valueOf(i));
      D(localHashMap);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    try
    {
      this.rQI = (paramJSONObject.getInt("credit_amount") / 100.0D);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
    }
  }
  
  public final int aEC()
  {
    return 60;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.c
 * JD-Core Version:    0.7.0.1
 */