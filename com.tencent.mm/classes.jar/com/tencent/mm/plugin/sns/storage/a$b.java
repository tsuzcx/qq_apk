package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a$b
{
  private List<a.b.a> oAw = new ArrayList();
  public Map<String, List<a.b.a>> oAx = new HashMap();
  
  public a$b() {}
  
  public a$b(Map<String, String> paramMap, String paramString)
  {
    String str = paramString + ".dislikeInfo.ReasonList";
    int i = 0;
    paramString = str + ".Reason";
    if (i > 0) {
      paramString = paramString + i;
    }
    for (;;)
    {
      if (paramMap.get(paramString + ".ReasonId") != null)
      {
        this.oAw.add(new a.b.a(bk.aM((String)paramMap.get(paramString + ".Wording.zh"), ""), bk.aM((String)paramMap.get(paramString + ".Wording.tw"), ""), bk.aM((String)paramMap.get(paramString + ".Wording.en"), ""), bk.ZR((String)paramMap.get(paramString + ".ReasonId"))));
        i += 1;
        break;
      }
      return;
    }
  }
  
  public final List<a.b.a> bED()
  {
    String str = x.fB(ae.getContext());
    if ((!"zh_CN".equals(str)) && (!"zh_TW".equals(str)) && (!"zh_HK".equals(str))) {
      str = "en";
    }
    for (;;)
    {
      if (!this.oAx.containsKey(str))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.oAw.iterator();
        while (localIterator.hasNext())
        {
          a.b.a locala = (a.b.a)localIterator.next();
          if (("zh_CN".equals(str)) && (!bk.bl(locala.oAz))) {
            localArrayList.add(locala);
          } else if ((("zh_TW".equals(str)) || ("zh_HK".equals(str))) && (!bk.bl(locala.oAA))) {
            localArrayList.add(locala);
          } else if (("en".equals(str)) && (!bk.bl(locala.oAB))) {
            localArrayList.add(locala);
          }
        }
        this.oAx.put(str, localArrayList);
      }
      return (List)this.oAx.get(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a.b
 * JD-Core Version:    0.7.0.1
 */