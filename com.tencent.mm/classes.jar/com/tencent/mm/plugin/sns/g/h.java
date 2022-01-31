package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean cqS;
  public String nZZ;
  public String rkS;
  public String rkT;
  public String rlH;
  public int[] rlI;
  public int rlu;
  public List<a> rlv;
  
  public h()
  {
    AppMethodBeat.i(36812);
    this.rkT = "";
    this.rkS = "";
    this.nZZ = "";
    this.rlH = "";
    this.rlu = 0;
    this.rlv = new ArrayList();
    this.cqS = true;
    AppMethodBeat.o(36812);
  }
  
  public final boolean cqc()
  {
    AppMethodBeat.i(36813);
    if ((this.cqS) && (this.rlv != null) && (this.rlv.size() > 0))
    {
      AppMethodBeat.o(36813);
      return true;
    }
    AppMethodBeat.o(36813);
    return false;
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(36814);
    this.rkT = paramString1;
    this.rkS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(36814);
      return false;
    }
    try
    {
      this.rlv.clear();
      this.nZZ = bo.bf((String)paramMap.get("language"), "");
      this.rlH = bo.bf((String)paramMap.get("first_step_order"), "");
      paramString2 = this.rlH.split("\\|");
      this.rlI = new int[paramString2.length];
      if (this.rlI.length != 0) {
        break label476;
      }
      this.cqS = false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        ab.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < paramString2.length)
    {
      this.rlI[i] = bo.apV(paramString2[i]);
      if ((this.rlI[i] <= 0) || (this.rlI[i] > 3)) {
        this.cqS = false;
      }
    }
    else
    {
      j = bo.apV((String)paramMap.get("wording_count"));
      k = bo.apV((String)paramMap.get("expertype"));
      i = 0;
      while (i < j)
      {
        paramString2 = new a();
        paramString2.rkm = bo.apV((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.rkn = bo.bf((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.rko = bo.bf((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.rkp = bo.bf((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.rkq = bo.apV((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.rlv.add(paramString2);
        i += 1;
      }
      ab.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.rlH);
      AppMethodBeat.o(36814);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.h
 * JD-Core Version:    0.7.0.1
 */