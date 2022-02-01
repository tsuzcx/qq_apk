package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean dpK;
  public String vlG;
  public String zGS;
  public String zGT;
  public int zHt;
  public List<b> zHu;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.zGT = "";
    this.zGS = "";
    this.vlG = "";
    this.zHt = 0;
    this.zHu = new ArrayList();
    this.dpK = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.zGT = paramString1;
    this.zGS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.zHu.clear();
        this.vlG = bu.bI((String)paramMap.get("language"), "");
        if (!this.vlG.equals("zh_cn")) {
          this.dpK = false;
        }
        int k = bu.aSB((String)paramMap.get("tipcount"));
        m = bu.aSB((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = bu.bI((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.zHy = bu.aSB((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.dmr = bu.aSB((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = bu.aSB((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.dmr < 6) {
          continue;
        }
        this.dpK = false;
      }
      catch (Exception paramString1)
      {
        int m;
        int i;
        int n;
        a locala;
        ae.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int j = 0;
        continue;
      }
      if (j < n)
      {
        locala = new a();
        locala.index = bu.aSB((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = bu.aSB((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.zHv = bu.bI((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = bu.bI((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.zHw = bu.bI((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.zHx = bu.aSB((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.dpK = false;
        }
        paramString2.kcW.add(locala);
        j += 1;
      }
      else
      {
        this.zHu.add(paramString2);
        i += 1;
      }
    }
    ae.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(96131);
    return false;
  }
  
  static final class a
  {
    public int actionType;
    public int index;
    public String jumpUrl;
    public String zHv;
    public String zHw;
    public int zHx;
  }
  
  static final class b
  {
    public int dmr;
    public List<d.a> kcW;
    public String title;
    public int zHy;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.kcW = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */