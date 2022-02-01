package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean doF;
  public String uZv;
  public String zpD;
  public String zpE;
  public int zqe;
  public List<a> zqf;
  public String zqr;
  public int[] zqs;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.zpE = "";
    this.zpD = "";
    this.uZv = "";
    this.zqr = "";
    this.zqe = 0;
    this.zqf = new ArrayList();
    this.doF = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean dVB()
  {
    AppMethodBeat.i(96141);
    if ((this.doF) && (this.zqf != null) && (this.zqf.size() > 0))
    {
      AppMethodBeat.o(96141);
      return true;
    }
    AppMethodBeat.o(96141);
    return false;
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96142);
    this.zpE = paramString1;
    this.zpD = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.zqf.clear();
      this.uZv = bt.bI((String)paramMap.get("language"), "");
      this.zqr = bt.bI((String)paramMap.get("first_step_order"), "");
      paramString2 = this.zqr.split("\\|");
      this.zqs = new int[paramString2.length];
      if (this.zqs.length != 0) {
        break label476;
      }
      this.doF = false;
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
      this.zqs[i] = bt.aRe(paramString2[i]);
      if ((this.zqs[i] <= 0) || (this.zqs[i] > 3)) {
        this.doF = false;
      }
    }
    else
    {
      j = bt.aRe((String)paramMap.get("wording_count"));
      k = bt.aRe((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.zoX = bt.aRe((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.zoY = bt.bI((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zoZ = bt.bI((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zpa = bt.bI((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zpb = bt.aRe((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.zqf.add(paramString2);
        i += 1;
      }
      ad.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.zqr);
      AppMethodBeat.o(96142);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */