package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b$a
{
  public List<b.b> list;
  
  public b$a()
  {
    AppMethodBeat.i(36900);
    this.list = new LinkedList();
    AppMethodBeat.o(36900);
  }
  
  public final a q(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36901);
    String str1 = paramString + ".adxml.feedbackInfo.feedbackList.item";
    int i = 0;
    if (i > 0) {}
    for (paramString = str1 + i;; paramString = str1)
    {
      String str2 = paramString + ".url";
      if ((paramMap.get(str2) != null) && (((String)paramMap.get(str2)).length() > 0))
      {
        b.b localb = new b.b();
        localb.url = bo.bf((String)paramMap.get(str2), "");
        localb.rqT = bo.bf((String)paramMap.get(paramString + ".Wording.zh"), "");
        localb.rkp = bo.bf((String)paramMap.get(paramString + ".Wording.en"), "");
        localb.rqU = bo.bf((String)paramMap.get(paramString + ".Wording.tw"), "");
        if (localb.rqT.length() + localb.rkp.length() + localb.rqU.length() > 0) {
          this.list.add(localb);
        }
        i += 1;
        break;
      }
      AppMethodBeat.o(36901);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.a
 * JD-Core Version:    0.7.0.1
 */