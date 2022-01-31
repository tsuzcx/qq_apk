package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public boolean bJy = true;
  public String lCN = "";
  public String ovY = "";
  public String ovZ = "";
  public int owA = 0;
  public List<b> owB = new ArrayList();
  
  public final boolean e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.ovZ = paramString1;
    this.ovY = paramString2;
    if (paramMap == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        this.owB.clear();
        this.lCN = bk.aM((String)paramMap.get("language"), "");
        if (!this.lCN.equals("zh_cn")) {
          this.bJy = false;
        }
        int k = bk.ZR((String)paramMap.get("tipcount"));
        int m = bk.ZR((String)paramMap.get("expertype"));
        int i = 0;
        if (i < k)
        {
          paramString2 = new b();
          paramString2.title = bk.aM((String)paramMap.get(String.format("tip_%d_basetextformat", new Object[] { Integer.valueOf(i) })), "");
          paramString2.owF = bk.ZR((String)paramMap.get(String.format("tip_%d_id", new Object[] { Integer.valueOf(i) })));
          paramString2.showType = bk.ZR((String)paramMap.get(String.format("tip_%d_showtype", new Object[] { Integer.valueOf(i) })));
          int n = bk.ZR((String)paramMap.get(String.format("tip_%d_button_count", new Object[] { Integer.valueOf(i) })));
          if (paramString2.showType >= 6)
          {
            this.bJy = false;
            break label639;
            if (j < n)
            {
              a locala = new a();
              locala.index = bk.ZR((String)paramMap.get(String.format("tip_%d_button_%d_index", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
              locala.actionType = bk.ZR((String)paramMap.get(String.format("tip_%d_button_%d_actiontype", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
              locala.owC = bk.aM((String)paramMap.get(String.format("tip_%d_button_%d_basetextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
              locala.jumpUrl = bk.aM((String)paramMap.get(String.format("tip_%d_button_%d_jumpurl", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
              locala.owD = bk.aM((String)paramMap.get(String.format("tip_%d_button_%d_priortextformat", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })), "");
              locala.owE = bk.ZR((String)paramMap.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })));
              if (locala.actionType >= 9) {
                this.bJy = false;
              }
              paramString2.fRi.add(locala);
              j += 1;
              continue;
            }
            this.owB.add(paramString2);
            i += 1;
          }
        }
        else
        {
          y.i("Micromsg.SnsABTestInfo", "expertType " + m + " " + paramString1);
          return false;
        }
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("Micromsg.SnsABTestInfo", paramString1, "feed xml error ", new Object[0]);
        return false;
      }
      label639:
      int j = 0;
    }
  }
  
  static final class a
  {
    public int actionType;
    public int index;
    public String jumpUrl;
    public String owC;
    public String owD;
    public int owE;
  }
  
  static final class b
  {
    public List<d.a> fRi = new ArrayList();
    public int owF;
    public int showType;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.d
 * JD-Core Version:    0.7.0.1
 */