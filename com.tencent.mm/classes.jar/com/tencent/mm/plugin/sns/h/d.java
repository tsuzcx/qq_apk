package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public String DQS;
  public String DQT;
  public int DRt;
  public List<b> DRu;
  public boolean dGX;
  public String yFy;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.DQT = "";
    this.DQS = "";
    this.yFy = "";
    this.DRt = 0;
    this.DRu = new ArrayList();
    this.dGX = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.DQT = paramString1;
    this.DQS = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.DRu.clear();
        this.yFy = Util.nullAs((String)paramMap.get("language"), "");
        if (!this.yFy.equals("zh_cn")) {
          this.dGX = false;
        }
        int k = Util.safeParseInt((String)paramMap.get("tipcount"));
        m = Util.safeParseInt((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = Util.nullAs((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.DRy = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.dDG = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.dDG < 6) {
          continue;
        }
        this.dGX = false;
      }
      catch (Exception paramString1)
      {
        int m;
        int i;
        int n;
        a locala;
        Log.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        continue;
        int j = 0;
        continue;
      }
      if (j < n)
      {
        locala = new a();
        locala.index = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.actionType = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        locala.DRv = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.DRw = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.DRx = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.dGX = false;
        }
        paramString2.lgB.add(locala);
        j += 1;
      }
      else
      {
        this.DRu.add(paramString2);
        i += 1;
      }
    }
    Log.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(96131);
    return false;
  }
  
  static final class a
  {
    public String DRv;
    public String DRw;
    public int DRx;
    public int actionType;
    public int index;
    public String jumpUrl;
  }
  
  static final class b
  {
    public int DRy;
    public int dDG;
    public List<d.a> lgB;
    public String title;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.lgB = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */