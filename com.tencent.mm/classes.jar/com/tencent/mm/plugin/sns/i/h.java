package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public String Kca;
  public String QBF;
  public int QCf;
  public List<a> QCg;
  public String QCs;
  public int[] QCt;
  public boolean hEn;
  public String sdF;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.sdF = "";
    this.QBF = "";
    this.Kca = "";
    this.QCs = "";
    this.QCf = 0;
    this.QCg = new ArrayList();
    this.hEn = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96142);
    this.sdF = paramString1;
    this.QBF = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.QCg.clear();
      this.Kca = Util.nullAs((String)paramMap.get("language"), "");
      this.QCs = Util.nullAs((String)paramMap.get("first_step_order"), "");
      paramString2 = this.QCs.split("\\|");
      this.QCt = new int[paramString2.length];
      if (this.QCt.length != 0) {
        break label476;
      }
      this.hEn = false;
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
      this.QCt[i] = Util.safeParseInt(paramString2[i]);
      if ((this.QCt[i] <= 0) || (this.QCt[i] > 3)) {
        this.hEn = false;
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
        paramString2.QAZ = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.QBa = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.QBb = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.QBc = Util.nullAs((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.QBd = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.QCg.add(paramString2);
        i += 1;
      }
      Log.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.QCs);
      AppMethodBeat.o(96142);
      return false;
    }
  }
  
  public final boolean hig()
  {
    AppMethodBeat.i(96141);
    if ((this.hEn) && (this.QCg != null) && (this.QCg.size() > 0))
    {
      AppMethodBeat.o(96141);
      return true;
    }
    AppMethodBeat.o(96141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.h
 * JD-Core Version:    0.7.0.1
 */