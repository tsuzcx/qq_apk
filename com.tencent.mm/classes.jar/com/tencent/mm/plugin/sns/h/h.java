package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public String DQS;
  public String DQT;
  public String DRG;
  public int[] DRH;
  public int DRt;
  public List<a> DRu;
  public boolean dGX;
  public String yFy;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.DQT = "";
    this.DQS = "";
    this.yFy = "";
    this.DRG = "";
    this.DRt = 0;
    this.DRu = new ArrayList();
    this.dGX = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96142);
    this.DQT = paramString1;
    this.DQS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.DRu.clear();
      this.yFy = Util.nullAs((String)paramMap.get("language"), "");
      this.DRG = Util.nullAs((String)paramMap.get("first_step_order"), "");
      paramString2 = this.DRG.split("\\|");
      this.DRH = new int[paramString2.length];
      if (this.DRH.length != 0) {
        break label476;
      }
      this.dGX = false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        Log.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < paramString2.length)
    {
      this.DRH[i] = Util.safeParseInt(paramString2[i]);
      if ((this.DRH[i] <= 0) || (this.DRH[i] > 3)) {
        this.dGX = false;
      }
    }
    else
    {
      j = Util.safeParseInt((String)paramMap.get("wording_count"));
      k = Util.safeParseInt((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.DQm = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.DQn = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.DQo = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.DQp = Util.nullAs((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.DQq = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.DRu.add(paramString2);
        i += 1;
      }
      Log.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.DRG);
      AppMethodBeat.o(96142);
      return false;
    }
  }
  
  public final boolean fcq()
  {
    AppMethodBeat.i(96141);
    if ((this.dGX) && (this.DRu != null) && (this.DRu.size() > 0))
    {
      AppMethodBeat.o(96141);
      return true;
    }
    AppMethodBeat.o(96141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */