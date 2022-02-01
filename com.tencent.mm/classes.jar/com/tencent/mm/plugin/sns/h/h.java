package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public String Ejr;
  public String KdZ;
  public int KeA;
  public List<a> KeB;
  public String KeN;
  public int[] KeO;
  public String Kea;
  public boolean fzO;
  
  public h()
  {
    AppMethodBeat.i(96140);
    this.Kea = "";
    this.KdZ = "";
    this.Ejr = "";
    this.KeN = "";
    this.KeA = 0;
    this.KeB = new ArrayList();
    this.fzO = true;
    AppMethodBeat.o(96140);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96142);
    this.Kea = paramString1;
    this.KdZ = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96142);
      return false;
    }
    try
    {
      this.KeB.clear();
      this.Ejr = Util.nullAs((String)paramMap.get("language"), "");
      this.KeN = Util.nullAs((String)paramMap.get("first_step_order"), "");
      paramString2 = this.KeN.split("\\|");
      this.KeO = new int[paramString2.length];
      if (this.KeO.length != 0) {
        break label476;
      }
      this.fzO = false;
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
      this.KeO[i] = Util.safeParseInt(paramString2[i]);
      if ((this.KeO[i] <= 0) || (this.KeO[i] > 3)) {
        this.fzO = false;
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
        paramString2.Kdt = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
        paramString2.Kdu = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.Kdv = Util.nullAs((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.Kdw = Util.nullAs((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
        paramString2.Kdx = Util.safeParseInt((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
        this.KeB.add(paramString2);
        i += 1;
      }
      Log.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.KeN);
      AppMethodBeat.o(96142);
      return false;
    }
  }
  
  public final boolean fQj()
  {
    AppMethodBeat.i(96141);
    if ((this.fzO) && (this.KeB != null) && (this.KeB.size() > 0))
    {
      AppMethodBeat.o(96141);
      return true;
    }
    AppMethodBeat.o(96141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */