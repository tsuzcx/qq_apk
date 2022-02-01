package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean dpK;
  public String vlG;
  public String zGS;
  public String zGT;
  public String zHG;
  public int[] zHH;
  public int zHt;
  public List<a> zHu;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.zGT = "";
    this.zGS = "";
    this.vlG = "";
    this.zHG = "";
    this.zHt = 0;
    this.zHu = new ArrayList();
    this.dpK = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean dZc()
  {
    AppMethodBeat.i(96141);
    if ((this.dpK) && (this.zHu != null) && (this.zHu.size() > 0))
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
    this.zGT = paramString1;
    this.zGS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.zHu.clear();
      this.vlG = bu.bI((String)paramMap.get("language"), "");
      this.zHG = bu.bI((String)paramMap.get("first_step_order"), "");
      paramString2 = this.zHG.split("\\|");
      this.zHH = new int[paramString2.length];
      if (this.zHH.length != 0) {
        break label476;
      }
      this.dpK = false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        ae.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < paramString2.length)
    {
      this.zHH[i] = bu.aSB(paramString2[i]);
      if ((this.zHH[i] <= 0) || (this.zHH[i] > 3)) {
        this.dpK = false;
      }
    }
    else
    {
      j = bu.aSB((String)paramMap.get("wording_count"));
      k = bu.aSB((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.zGm = bu.aSB((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.zGn = bu.bI((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zGo = bu.bI((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zGp = bu.bI((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.zGq = bu.aSB((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.zHu.add(paramString2);
        i += 1;
      }
      ae.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.zHG);
      AppMethodBeat.o(96142);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */