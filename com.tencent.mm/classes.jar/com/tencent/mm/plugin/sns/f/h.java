package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public boolean bJy = true;
  public String lCN = "";
  public String ovY = "";
  public String ovZ = "";
  public int owA = 0;
  public List<a> owB = new ArrayList();
  public String owN = "";
  public int[] owO;
  
  public final boolean bEA()
  {
    return (this.bJy) && (this.owB != null) && (this.owB.size() > 0);
  }
  
  public final boolean e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.ovZ = paramString1;
    this.ovY = paramString2;
    if (paramMap == null) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        this.owB.clear();
        this.lCN = bk.aM((String)paramMap.get("language"), "");
        this.owN = bk.aM((String)paramMap.get("first_step_order"), "");
        paramString2 = this.owN.split("\\|");
        this.owO = new int[paramString2.length];
        if (this.owO.length != 0) {
          break label460;
        }
        this.bJy = false;
      }
      catch (Exception paramString1)
      {
        int j;
        int k;
        y.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", paramString1, "feed xml error ", new Object[0]);
        return false;
      }
      if (i < paramString2.length)
      {
        this.owO[i] = bk.ZR(paramString2[i]);
        if ((this.owO[i] <= 0) || (this.owO[i] > 3)) {
          this.bJy = false;
        }
      }
      else
      {
        j = bk.ZR((String)paramMap.get("wording_count"));
        k = bk.ZR((String)paramMap.get("expertype"));
        i = 0;
        if (i < j)
        {
          paramString2 = new a();
          paramString2.ovr = bk.ZR((String)paramMap.get(String.format("wording_%d_id", new Object[] { Integer.valueOf(i + 1) })));
          paramString2.ovs = bk.aM((String)paramMap.get(String.format("wording_%d_zh_CN", new Object[] { Integer.valueOf(i + 1) })), "");
          paramString2.ovt = bk.aM((String)paramMap.get(String.format("wording_%d_zh_TW", new Object[] { Integer.valueOf(i + 1) })), "");
          paramString2.ovu = bk.aM((String)paramMap.get(String.format("wording_%d_en", new Object[] { Integer.valueOf(i + 1) })), "");
          paramString2.ovv = bk.ZR((String)paramMap.get(String.format("wording_%d_action_type", new Object[] { Integer.valueOf(i + 1) })));
          this.owB.add(paramString2);
          i += 1;
          continue;
        }
        y.i("MicroMsg.SnsAdAbTestInfo", "expertType " + k + " " + paramString1 + " " + this.owN);
        return false;
        label460:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.h
 * JD-Core Version:    0.7.0.1
 */