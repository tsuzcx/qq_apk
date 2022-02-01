package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean ddj;
  public String tWM;
  public String xZE;
  public String xZF;
  public int yag;
  public List<b> yah;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.xZF = "";
    this.xZE = "";
    this.tWM = "";
    this.yag = 0;
    this.yah = new ArrayList();
    this.ddj = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.xZF = paramString1;
    this.xZE = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.yah.clear();
        this.tWM = bs.bG((String)paramMap.get("language"), "");
        if (!this.tWM.equals("zh_cn")) {
          this.ddj = false;
        }
        int k = bs.aLy((String)paramMap.get("tipcount"));
        m = bs.aLy((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = bs.bG((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.yal = bs.aLy((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.cZX = bs.aLy((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = bs.aLy((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.cZX < 6) {
          continue;
        }
        this.ddj = false;
      }
      catch (Exception paramString1)
      {
        int m;
        int i;
        int n;
        a locala;
        ac.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int j = 0;
        continue;
      }
      if (j < n)
      {
        locala = new a();
        locala.index = bs.aLy((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = bs.aLy((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.yai = bs.bG((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = bs.bG((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.yaj = bs.bG((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.yak = bs.aLy((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.ddj = false;
        }
        paramString2.jFA.add(locala);
        j += 1;
      }
      else
      {
        this.yah.add(paramString2);
        i += 1;
      }
    }
    ac.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(96131);
    return false;
  }
  
  static final class a
  {
    public int actionType;
    public int index;
    public String jumpUrl;
    public String yai;
    public String yaj;
    public int yak;
  }
  
  static final class b
  {
    public int cZX;
    public List<d.a> jFA;
    public String title;
    public int yal;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.jFA = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */