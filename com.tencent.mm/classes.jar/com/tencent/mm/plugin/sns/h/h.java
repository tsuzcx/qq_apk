package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean ddj;
  public String tWM;
  public String xZE;
  public String xZF;
  public int yag;
  public List<a> yah;
  public String yat;
  public int[] yau;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.xZF = "";
    this.xZE = "";
    this.tWM = "";
    this.yat = "";
    this.yag = 0;
    this.yah = new ArrayList();
    this.ddj = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean dJo()
  {
    AppMethodBeat.i(96141);
    if ((this.ddj) && (this.yah != null) && (this.yah.size() > 0))
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
    this.xZF = paramString1;
    this.xZE = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.yah.clear();
      this.tWM = bs.bG((String)paramMap.get("language"), "");
      this.yat = bs.bG((String)paramMap.get("first_step_order"), "");
      paramString2 = this.yat.split("\\|");
      this.yau = new int[paramString2.length];
      if (this.yau.length != 0) {
        break label476;
      }
      this.ddj = false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        ac.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < paramString2.length)
    {
      this.yau[i] = bs.aLy(paramString2[i]);
      if ((this.yau[i] <= 0) || (this.yau[i] > 3)) {
        this.ddj = false;
      }
    }
    else
    {
      j = bs.aLy((String)paramMap.get("wording_count"));
      k = bs.aLy((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.xYY = bs.aLy((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.xYZ = bs.bG((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.xZa = bs.bG((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.xZb = bs.bG((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.xZc = bs.aLy((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.yah.add(paramString2);
        i += 1;
      }
      ac.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.yat);
      AppMethodBeat.o(96142);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */