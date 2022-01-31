package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a$b
{
  private List<a.b.a> rpG;
  public Map<String, List<a.b.a>> rpH;
  
  public a$b()
  {
    AppMethodBeat.i(36895);
    this.rpG = new ArrayList();
    this.rpH = new HashMap();
    AppMethodBeat.o(36895);
  }
  
  public a$b(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36896);
    this.rpG = new ArrayList();
    this.rpH = new HashMap();
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
        this.rpG.add(new a.b.a(bo.bf((String)paramMap.get(paramString + ".Wording.zh"), ""), bo.bf((String)paramMap.get(paramString + ".Wording.tw"), ""), bo.bf((String)paramMap.get(paramString + ".Wording.en"), ""), bo.apV((String)paramMap.get(paramString + ".ReasonId"))));
        i += 1;
        break;
      }
      AppMethodBeat.o(36896);
      return;
    }
  }
  
  public final List<a.b.a> cqj()
  {
    AppMethodBeat.i(36894);
    Object localObject = aa.gP(ah.getContext());
    if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
      localObject = "en";
    }
    for (;;)
    {
      if (!this.rpH.containsKey(localObject))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.rpG.iterator();
        while (localIterator.hasNext())
        {
          a.b.a locala = (a.b.a)localIterator.next();
          if (("zh_CN".equals(localObject)) && (!bo.isNullOrNil(locala.rpJ))) {
            localArrayList.add(locala);
          } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!bo.isNullOrNil(locala.rpK))) {
            localArrayList.add(locala);
          } else if (("en".equals(localObject)) && (!bo.isNullOrNil(locala.rpL))) {
            localArrayList.add(locala);
          }
        }
        this.rpH.put(localObject, localArrayList);
      }
      localObject = (List)this.rpH.get(localObject);
      AppMethodBeat.o(36894);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a.b
 * JD-Core Version:    0.7.0.1
 */