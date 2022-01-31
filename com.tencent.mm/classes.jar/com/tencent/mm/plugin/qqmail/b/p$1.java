package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
    this.pJo.status = this.pJo.pJn;
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(67963);
    paramString = this.pJo.callbacks.iterator();
    while (paramString.hasNext()) {
      ((p.a)paramString.next()).onComplete();
    }
    AppMethodBeat.o(67963);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(67962);
    p localp = this.pJo;
    int m = bo.getInt((String)paramMap.get(".Response.result.Count"), 0);
    if (m > 0)
    {
      int i;
      int j;
      Object localObject1;
      if (localp.pJj.pIr.size() == 0)
      {
        i = 1;
        j = 0;
        if (j >= m) {
          break label474;
        }
        localObject1 = new StringBuilder(".Response.result.List.item");
        if (j <= 0) {
          break label328;
        }
      }
      String str1;
      Object localObject2;
      int n;
      int k;
      label328:
      for (paramString = String.valueOf(j);; paramString = "")
      {
        paramString = paramString + ".";
        String str2 = (String)paramMap.get(paramString + "Del");
        str1 = (String)paramMap.get(paramString + "Freq");
        localObject2 = (String)paramMap.get(paramString + "Name");
        localObject1 = (String)paramMap.get(paramString + "Addr");
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break label401;
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
          break label410;
        }
        localObject2 = localp.pJj.pIr;
        k = 0;
        while ((i == 0) && (k < ((List)localObject2).size()) && (((o)((List)localObject2).get(k)).pJe != n)) {
          k += 1;
        }
        i = 0;
        break;
      }
      if ((k >= ((List)localObject2).size()) || (i != 0))
      {
        localObject2 = new o();
        ((o)localObject2).pJe = n;
        ((o)localObject2).name = paramString;
        ((o)localObject2).nZR = ((String)localObject1);
        ((o)localObject2).pJf = bo.getInt(str1, 0);
        localp.pJj.a((o)localObject2);
      }
      label401:
      label410:
      label472:
      for (;;)
      {
        j += 1;
        break;
        paramString = localp.pJj.pIr.iterator();
        k = 0;
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label472;
          }
          if (((o)paramString.next()).pJe == n)
          {
            localp.pJj.BU(k);
            break;
          }
          k += 1;
        }
      }
      label474:
      localp.pJj.Xm((String)paramMap.get(".Response.result.SyncInfo"));
      localp.save();
    }
    if (((String)paramMap.get(".Response.result.ContinueFlag")).equals("1"))
    {
      new ak().postDelayed(new p.1.1(this), 0L);
      AppMethodBeat.o(67962);
      return;
    }
    this.pJo.pJh = bo.aoy();
    paramString = this.pJo.callbacks.iterator();
    while (paramString.hasNext()) {
      ((p.a)paramString.next()).onComplete();
    }
    AppMethodBeat.o(67962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p.1
 * JD-Core Version:    0.7.0.1
 */