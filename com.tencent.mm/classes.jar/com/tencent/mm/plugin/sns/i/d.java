package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean dfO;
  public String sOz;
  public String wMY;
  public String wMZ;
  public int wNA;
  public List<b> wNB;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.wMZ = "";
    this.wMY = "";
    this.sOz = "";
    this.wNA = 0;
    this.wNB = new ArrayList();
    this.dfO = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.wMZ = paramString1;
    this.wMY = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.wNB.clear();
        this.sOz = bt.by((String)paramMap.get("language"), "");
        if (!this.sOz.equals("zh_cn")) {
          this.dfO = false;
        }
        int k = bt.aGh((String)paramMap.get("tipcount"));
        m = bt.aGh((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = bt.by((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.wNF = bt.aGh((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.dcz = bt.aGh((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = bt.aGh((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.dcz < 6) {
          continue;
        }
        this.dfO = false;
      }
      catch (Exception paramString1)
      {
        int m;
        int i;
        int n;
        a locala;
        ad.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int j = 0;
        continue;
      }
      if (j < n)
      {
        locala = new a();
        locala.index = bt.aGh((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = bt.aGh((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.wNC = bt.by((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = bt.by((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.wND = bt.by((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.wNE = bt.aGh((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.dfO = false;
        }
        paramString2.jfl.add(locala);
        j += 1;
      }
      else
      {
        this.wNB.add(paramString2);
        i += 1;
      }
    }
    ad.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(96131);
    return false;
  }
  
  static final class a
  {
    public int actionType;
    public int index;
    public String jumpUrl;
    public String wNC;
    public String wND;
    public int wNE;
  }
  
  static final class b
  {
    public int dcz;
    public List<d.a> jfl;
    public String title;
    public int wNF;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.jfl = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.d
 * JD-Core Version:    0.7.0.1
 */