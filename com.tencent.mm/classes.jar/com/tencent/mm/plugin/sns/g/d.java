package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean cqS;
  public String nZZ;
  public String rkS;
  public String rkT;
  public int rlu;
  public List<d.b> rlv;
  
  public d()
  {
    AppMethodBeat.i(36802);
    this.rkT = "";
    this.rkS = "";
    this.nZZ = "";
    this.rlu = 0;
    this.rlv = new ArrayList();
    this.cqS = true;
    AppMethodBeat.o(36802);
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(36803);
    this.rkT = paramString1;
    this.rkS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(36803);
      return false;
    }
    for (;;)
    {
      try
      {
        this.rlv.clear();
        this.nZZ = bo.bf((String)paramMap.get("language"), "");
        if (!this.nZZ.equals("zh_cn")) {
          this.cqS = false;
        }
        int k = bo.apV((String)paramMap.get("tipcount"));
        m = bo.apV((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new d.b();
        paramString2.title = bo.bf((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.rlz = bo.apV((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.showType = bo.apV((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = bo.apV((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.showType < 6) {
          continue;
        }
        this.cqS = false;
      }
      catch (Exception paramString1)
      {
        int m;
        int i;
        int n;
        d.a locala;
        ab.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int j = 0;
        continue;
      }
      if (j < n)
      {
        locala = new d.a();
        locala.index = bo.apV((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = bo.apV((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.rlw = bo.bf((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = bo.bf((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.rlx = bo.bf((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.rly = bo.apV((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.cqS = false;
        }
        paramString2.hjU.add(locala);
        j += 1;
      }
      else
      {
        this.rlv.add(paramString2);
        i += 1;
      }
    }
    ab.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(36803);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.d
 * JD-Core Version:    0.7.0.1
 */