package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean dfO;
  public String sOz;
  public String wMY;
  public String wMZ;
  public int wNA;
  public List<a> wNB;
  public String wNN;
  public int[] wNO;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.wMZ = "";
    this.wMY = "";
    this.sOz = "";
    this.wNN = "";
    this.wNA = 0;
    this.wNB = new ArrayList();
    this.dfO = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean duO()
  {
    AppMethodBeat.i(96141);
    if ((this.dfO) && (this.wNB != null) && (this.wNB.size() > 0))
    {
      AppMethodBeat.o(96141);
      return true;
    }
    AppMethodBeat.o(96141);
    return false;
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96142);
    this.wMZ = paramString1;
    this.wMY = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.wNB.clear();
      this.sOz = bt.by((String)paramMap.get("language"), "");
      this.wNN = bt.by((String)paramMap.get("first_step_order"), "");
      paramString2 = this.wNN.split("\\|");
      this.wNO = new int[paramString2.length];
      if (this.wNO.length != 0) {
        break label476;
      }
      this.dfO = false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        ad.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < paramString2.length)
    {
      this.wNO[i] = bt.aGh(paramString2[i]);
      if ((this.wNO[i] <= 0) || (this.wNO[i] > 3)) {
        this.dfO = false;
      }
    }
    else
    {
      j = bt.aGh((String)paramMap.get("wording_count"));
      k = bt.aGh((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.wMs = bt.aGh((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.wMt = bt.by((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.wMu = bt.by((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.wMv = bt.by((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.wMw = bt.aGh((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.wNB.add(paramString2);
        i += 1;
      }
      ad.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.wNN);
      AppMethodBeat.o(96142);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.h
 * JD-Core Version:    0.7.0.1
 */