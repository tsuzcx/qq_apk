package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class p$1
  extends v.a
{
  p$1(p paramp) {}
  
  public final void onComplete()
  {
    this.ndY.status = this.ndY.ndX;
  }
  
  public final void onError(int paramInt, String paramString)
  {
    paramString = this.ndY.dhm.iterator();
    while (paramString.hasNext()) {
      ((p.a)paramString.next()).onComplete();
    }
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    p localp = this.ndY;
    int m = bk.getInt((String)paramMap.get(".Response.result.Count"), 0);
    if (m > 0)
    {
      int i;
      int j;
      Object localObject1;
      if (localp.ndT.ncZ.size() == 0)
      {
        i = 1;
        j = 0;
        if (j >= m) {
          break label469;
        }
        localObject1 = new StringBuilder(".Response.result.List.item");
        if (j <= 0) {
          break label323;
        }
      }
      String str1;
      Object localObject2;
      int n;
      int k;
      label323:
      for (paramString = String.valueOf(j);; paramString = "")
      {
        paramString = paramString + ".";
        String str2 = (String)paramMap.get(paramString + "Del");
        str1 = (String)paramMap.get(paramString + "Freq");
        localObject2 = (String)paramMap.get(paramString + "Name");
        localObject1 = (String)paramMap.get(paramString + "Addr");
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break label396;
        }
        if (localObject2 != null)
        {
          paramString = (String)localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          paramString = (String)localObject1;
        }
        n = ((String)localObject1).hashCode();
        if (!str2.equals("0")) {
          break label405;
        }
        localObject2 = localp.ndT.ncZ;
        k = 0;
        while ((i == 0) && (k < ((List)localObject2).size()) && (((o)((List)localObject2).get(k)).ndO != n)) {
          k += 1;
        }
        i = 0;
        break;
      }
      if ((k >= ((List)localObject2).size()) || (i != 0))
      {
        localObject2 = new o();
        ((o)localObject2).ndO = n;
        ((o)localObject2).name = paramString;
        ((o)localObject2).lCF = ((String)localObject1);
        ((o)localObject2).ndP = bk.getInt(str1, 0);
        localp.ndT.a((o)localObject2);
      }
      label396:
      label405:
      label467:
      for (;;)
      {
        j += 1;
        break;
        paramString = localp.ndT.ncZ.iterator();
        k = 0;
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label467;
          }
          if (((o)paramString.next()).ndO == n)
          {
            localp.ndT.wj(k);
            break;
          }
          k += 1;
        }
      }
      label469:
      localp.ndT.Ld((String)paramMap.get(".Response.result.SyncInfo"));
      localp.save();
    }
    if (((String)paramMap.get(".Response.result.ContinueFlag")).equals("1")) {
      new ah().postDelayed(new Runnable()
      {
        public final void run()
        {
          p.1.this.ndY.status = p.1.this.ndY.ndV;
          p.1.this.ndY.btu();
        }
      }, 0L);
    }
    for (;;)
    {
      return;
      this.ndY.ndR = bk.UY();
      paramString = this.ndY.dhm.iterator();
      while (paramString.hasNext()) {
        ((p.a)paramString.next()).onComplete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p.1
 * JD-Core Version:    0.7.0.1
 */