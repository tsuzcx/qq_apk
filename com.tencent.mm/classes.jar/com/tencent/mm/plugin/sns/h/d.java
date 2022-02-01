package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean doF;
  public String uZv;
  public String zpD;
  public String zpE;
  public int zqe;
  public List<b> zqf;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.zpE = "";
    this.zpD = "";
    this.uZv = "";
    this.zqe = 0;
    this.zqf = new ArrayList();
    this.doF = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.zpE = paramString1;
    this.zpD = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.zqf.clear();
        this.uZv = bt.bI((String)paramMap.get("language"), "");
        if (!this.uZv.equals("zh_cn")) {
          this.doF = false;
        }
        int k = bt.aRe((String)paramMap.get("tipcount"));
        m = bt.aRe((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = bt.bI((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.zqj = bt.aRe((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.dlp = bt.aRe((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = bt.aRe((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.dlp < 6) {
          continue;
        }
        this.doF = false;
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
        locala.index = bt.aRe((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = bt.aRe((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.zqg = bt.bI((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = bt.bI((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.zqh = bt.bI((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.zqi = bt.aRe((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.doF = false;
        }
        paramString2.jZF.add(locala);
        j += 1;
      }
      else
      {
        this.zqf.add(paramString2);
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
    public String zqg;
    public String zqh;
    public int zqi;
  }
  
  static final class b
  {
    public int dlp;
    public List<d.a> jZF;
    public String title;
    public int zqj;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.jZF = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */