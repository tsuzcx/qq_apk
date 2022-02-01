package com.tencent.mm.plugin.shake.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  public LinkedList<a> sXD;
  
  public b()
  {
    AppMethodBeat.i(28614);
    this.sXD = new LinkedList();
    AppMethodBeat.o(28614);
  }
  
  private static a a(Map<String, String> paramMap, int paramInt, String paramString)
  {
    AppMethodBeat.i(28616);
    a locala = new a(paramInt);
    locala.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
    locala.summary = Util.nullAsNil((String)paramMap.get(paramString + ".summary"));
    String str = paramString + ".thumburl";
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = (String)paramMap.get(localObject);
        if (Util.isNullOrNil((String)localObject)) {
          break label197;
        }
        locala.PEP.add(localObject);
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
      AppMethodBeat.o(28616);
      return locala;
      locala.MOW = Util.nullAsNil((String)paramMap.get(paramString + ".h5url.link"));
      locala.PEQ = Util.nullAsNil((String)paramMap.get(paramString + ".h5url.title"));
      locala.PER = Util.nullAsNil((String)paramMap.get(paramString + ".h5url.username"));
      continue;
      locala.MOW = Util.nullAsNil((String)paramMap.get(paramString + ".bizprofile.username"));
      locala.PEQ = Util.nullAsNil((String)paramMap.get(paramString + ".bizprofile.showchat"));
      continue;
      locala.MOW = Util.nullAsNil((String)paramMap.get(paramString + ".nativepay.wx_pay_url"));
      continue;
      locala.MOW = Util.nullAsNil((String)paramMap.get(paramString + ".product.product_id"));
    }
  }
  
  public static LinkedList<b> q(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(28615);
    LinkedList localLinkedList = new LinkedList();
    int j = 0;
    int i = 0;
    b localb;
    Object localObject2;
    Object localObject1;
    int k;
    Object localObject3;
    if (j < 1000)
    {
      localb = new b();
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
        if (!Util.isNullOrNil((String)paramMap.get((String)localObject3 + ".type"))) {
          break label224;
        }
        if (i == 0) {
          break label200;
        }
        AppMethodBeat.o(28615);
        return localLinkedList;
        localObject1 = "";
        break;
      }
      label200:
      localb.sXD = ((LinkedList)localObject2);
      i = 1;
    }
    label209:
    label224:
    label510:
    for (;;)
    {
      localLinkedList.add(localb);
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
          localObject1 = new a(m);
          ((a)localObject1).MOW = Util.nullAsNil((String)paramMap.get((String)localObject3 + ".comment.id"));
          ((a)localObject1).title = Util.nullAsNil((String)paramMap.get((String)localObject3 + ".comment.title"));
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
            AppMethodBeat.o(28615);
            return localLinkedList;
          }
          localb.sXD = ((LinkedList)localObject2);
          i = 1;
        }
        break label209;
        a locala;
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
      AppMethodBeat.o(28615);
      return localLinkedList;
    }
  }
  
  public static final class a
  {
    public String MOW;
    public List<String> PEP;
    public String PEQ;
    public String PER;
    public String summary;
    public String title;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(28612);
      this.PEP = new ArrayList();
      this.PEQ = "";
      this.PER = "";
      AppMethodBeat.o(28612);
    }
    
    public a(int paramInt)
    {
      AppMethodBeat.i(28613);
      this.PEP = new ArrayList();
      this.PEQ = "";
      this.PER = "";
      this.type = paramInt;
      AppMethodBeat.o(28613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b
 * JD-Core Version:    0.7.0.1
 */