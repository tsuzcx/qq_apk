package com.tencent.mm.plugin.shake.e;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
{
  public LinkedList<a.a> eAm = new LinkedList();
  
  private static a.a a(Map<String, String> paramMap, int paramInt, String paramString)
  {
    a.a locala = new a.a(paramInt);
    locala.title = bk.pm((String)paramMap.get(paramString + ".title"));
    locala.summary = bk.pm((String)paramMap.get(paramString + ".summary"));
    String str = paramString + ".thumburl";
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = (String)paramMap.get(localObject);
        if (bk.bl((String)localObject)) {
          break label191;
        }
        locala.odQ.add(localObject);
        i += 1;
        break;
      }
    }
    switch (paramInt)
    {
    default: 
      return locala;
    case 3: 
      locala.odP = bk.pm((String)paramMap.get(paramString + ".h5url.link"));
      locala.odR = bk.pm((String)paramMap.get(paramString + ".h5url.title"));
      locala.odS = bk.pm((String)paramMap.get(paramString + ".h5url.username"));
      return locala;
    case 4: 
      locala.odP = bk.pm((String)paramMap.get(paramString + ".bizprofile.username"));
      locala.odR = bk.pm((String)paramMap.get(paramString + ".bizprofile.showchat"));
      return locala;
    case 5: 
      label191:
      locala.odP = bk.pm((String)paramMap.get(paramString + ".nativepay.wx_pay_url"));
      return locala;
    }
    locala.odP = bk.pm((String)paramMap.get(paramString + ".product.product_id"));
    return locala;
  }
  
  public static LinkedList<a> l(Map<String, String> paramMap, String paramString)
  {
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
          break label486;
        }
        localObject3 = new StringBuilder().append(str).append(".action");
        if (k <= 0) {
          break label181;
        }
      }
      label181:
      for (localObject1 = Integer.valueOf(k);; localObject1 = "")
      {
        localObject3 = localObject1;
        if (!bk.bl((String)paramMap.get((String)localObject3 + ".type"))) {
          break label212;
        }
        if (i == 0) {
          break label188;
        }
        return localLinkedList;
        localObject1 = "";
        break;
      }
      label188:
      locala1.eAm = ((LinkedList)localObject2);
      i = 1;
    }
    label197:
    label212:
    label486:
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
            break label406;
          }
          localObject1 = new a.a(m);
          ((a.a)localObject1).odP = bk.pm((String)paramMap.get((String)localObject3 + ".comment.id"));
          ((a.a)localObject1).title = bk.pm((String)paramMap.get((String)localObject3 + ".comment.title"));
          if (localObject1 != null) {
            ((LinkedList)localObject2).add(localObject1);
          }
          k += 1;
          i = 0;
        }
        catch (Exception localException)
        {
          new StringBuilder("Exception in parseActionList: ").append(localException.getMessage());
          if (i != 0) {
            return localLinkedList;
          }
          locala1.eAm = ((LinkedList)localObject2);
          i = 1;
        }
        break label197;
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
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.a
 * JD-Core Version:    0.7.0.1
 */