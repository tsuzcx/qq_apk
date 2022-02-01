package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public String Kca;
  public String QBF;
  public int QCf;
  public List<b> QCg;
  public boolean hEn;
  public String sdF;
  
  public d()
  {
    AppMethodBeat.i(96130);
    this.sdF = "";
    this.QBF = "";
    this.Kca = "";
    this.QCf = 0;
    this.QCg = new ArrayList();
    this.hEn = true;
    AppMethodBeat.o(96130);
  }
  
  public final boolean f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96131);
    this.sdF = paramString1;
    this.QBF = paramString2;
    if (paramMap == null)
    {
      AppMethodBeat.o(96131);
      return false;
    }
    for (;;)
    {
      try
      {
        this.QCg.clear();
        this.Kca = Util.nullAs((String)paramMap.get("language"), "");
        if (!this.Kca.equals("zh_cn")) {
          this.hEn = false;
        }
        int k = Util.safeParseInt((String)paramMap.get("tipcount"));
        m = Util.safeParseInt((String)paramMap.get("expertype"));
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString2 = new b();
        paramString2.title = Util.nullAs((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
        paramString2.QCk = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
        paramString2.hAN = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
        n = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
        if (paramString2.hAN < 6) {
          continue;
        }
        this.hEn = false;
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
        locala.QCh = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.jumpUrl = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.QCi = Util.nullAs((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
        locala.QCj = Util.safeParseInt((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
        if (locala.actionType >= 9) {
          this.hEn = false;
        }
        paramString2.rbP.add(locala);
        j += 1;
      }
      else
      {
        this.QCg.add(paramString2);
        i += 1;
      }
    }
    Log.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
    AppMethodBeat.o(96131);
    return false;
  }
  
  static final class a
  {
    public String QCh;
    public String QCi;
    public int QCj;
    public int actionType;
    public int index;
    public String jumpUrl;
  }
  
  static final class b
  {
    public int QCk;
    public int hAN;
    public List<d.a> rbP;
    public String title;
    
    b()
    {
      AppMethodBeat.i(96129);
      this.rbP = new ArrayList();
      AppMethodBeat.o(96129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.d
 * JD-Core Version:    0.7.0.1
 */