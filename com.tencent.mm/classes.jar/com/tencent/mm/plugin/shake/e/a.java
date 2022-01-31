package com.tencent.mm.plugin.shake.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
{
  public LinkedList<a.a> fQb;
  
  public a()
  {
    AppMethodBeat.i(24945);
    this.fQb = new LinkedList();
    AppMethodBeat.o(24945);
  }
  
  private static a.a a(Map<String, String> paramMap, int paramInt, String paramString)
  {
    AppMethodBeat.i(24947);
    a.a locala = new a.a(paramInt);
    locala.title = bo.nullAsNil((String)paramMap.get(paramString + ".title"));
    locala.summary = bo.nullAsNil((String)paramMap.get(paramString + ".summary"));
    String str = paramString + ".thumburl";
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = (String)paramMap.get(localObject);
        if (bo.isNullOrNil((String)localObject)) {
          break label197;
        }
        locala.qRX.add(localObject);
        i += 1;
        break;
      }
    }
    label197:
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24947);
      return locala;
      locala.qRW = bo.nullAsNil((String)paramMap.get(paramString + ".h5url.link"));
      locala.qRY = bo.nullAsNil((String)paramMap.get(paramString + ".h5url.title"));
      locala.qRZ = bo.nullAsNil((String)paramMap.get(paramString + ".h5url.username"));
      continue;
      locala.qRW = bo.nullAsNil((String)paramMap.get(paramString + ".bizprofile.username"));
      locala.qRY = bo.nullAsNil((String)paramMap.get(paramString + ".bizprofile.showchat"));
      continue;
      locala.qRW = bo.nullAsNil((String)paramMap.get(paramString + ".nativepay.wx_pay_url"));
      continue;
      locala.qRW = bo.nullAsNil((String)paramMap.get(paramString + ".product.product_id"));
    }
  }
  
  public static LinkedList<a> l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(24946);
    LinkedList localLinkedList = new LinkedList();
    int j = 0;
    int i = 0;
    a locala1;
    Object localObject2;
    Object localObject1;
    int k;
    Object localObject3;
    if (j < 1000)
    {
      locala1 = new a();
      localObject2 = new StringBuilder().append(paramString).append(".actionlist");
      if (j > 0)
      {
        localObject1 = Integer.valueOf(j);
        String str = localObject1;
        localObject2 = new LinkedList();
        k = 0;
        if (k >= 1000) {
          break label510;
        }
        localObject3 = new StringBuilder().append(str).append(".action");
        if (k <= 0) {
          break label193;
        }
      }
      label193:
      for (localObject1 = Integer.valueOf(k);; localObject1 = "")
      {
        localObject3 = localObject1;
        if (!bo.isNullOrNil((String)paramMap.get((String)localObject3 + ".type"))) {
          break label224;
        }
        if (i == 0) {
          break label200;
        }
        AppMethodBeat.o(24946);
        return localLinkedList;
        localObject1 = "";
        break;
      }
      label200:
      locala1.fQb = ((LinkedList)localObject2);
      i = 1;
    }
    label209:
    label224:
    label510:
    for (;;)
    {
      localLinkedList.add(locala1);
      j += 1;
      break;
      for (;;)
      {
        int m;
        try
        {
          m = Integer.valueOf((String)paramMap.get((String)localObject3 + ".type")).intValue();
          localObject1 = null;
          if (m != 2) {
            break label424;
          }
          localObject1 = new a.a(m);
          ((a.a)localObject1).qRW = bo.nullAsNil((String)paramMap.get((String)localObject3 + ".comment.id"));
          ((a.a)localObject1).title = bo.nullAsNil((String)paramMap.get((String)localObject3 + ".comment.title"));
          if (localObject1 != null) {
            ((LinkedList)localObject2).add(localObject1);
          }
          k += 1;
          i = 0;
        }
        catch (Exception localException)
        {
          new StringBuilder("Exception in parseActionList: ").append(localException.getMessage());
          if (i != 0)
          {
            AppMethodBeat.o(24946);
            return localLinkedList;
          }
          locala1.fQb = ((LinkedList)localObject2);
          i = 1;
        }
        break label209;
        a.a locala;
        if (m == 3) {
          locala = a(paramMap, m, (String)localObject3);
        } else if (m == 4) {
          locala = a(paramMap, m, (String)localObject3);
        } else if (m == 5) {
          locala = a(paramMap, m, (String)localObject3);
        } else if (m == 6) {
          locala = a(paramMap, m, (String)localObject3);
        }
      }
      AppMethodBeat.o(24946);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.a
 * JD-Core Version:    0.7.0.1
 */