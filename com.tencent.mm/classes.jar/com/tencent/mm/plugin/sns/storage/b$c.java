package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b$c
{
  public List<b.d> ygS;
  
  public b$c()
  {
    AppMethodBeat.i(200133);
    this.ygS = new ArrayList();
    AppMethodBeat.o(200133);
  }
  
  public final c s(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(200134);
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
    if (i == 0) {}
    for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
    {
      String str = localObject1;
      if (!paramMap.containsKey(str)) {
        break label297;
      }
      ac.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { paramMap.get(str) });
      if (!bs.isNullOrNil((String)paramMap.get(str)))
      {
        localObject1 = new b.d();
        ((b.d)localObject1).ygT = bs.bG((String)paramMap.get(str), "");
        localObject2 = str + ".$light_mode_url";
        str = str + ".$dark_mode_url";
        ((b.d)localObject1).ygU = bs.bG((String)paramMap.get(localObject2), "");
        ((b.d)localObject1).ygV = bs.bG((String)paramMap.get(str), "");
        ac.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((b.d)localObject1).ygT + ", Tag light iconUrl = " + ((b.d)localObject1).ygU + ", Tag dark iconUrl = " + ((b.d)localObject1).ygV });
        this.ygS.add(localObject1);
      }
      i += 1;
      break;
    }
    label297:
    AppMethodBeat.o(200134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.c
 * JD-Core Version:    0.7.0.1
 */