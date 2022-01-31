package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b$a
{
  public List<b.b> list = new LinkedList();
  
  public final a q(Map<String, String> paramMap, String paramString)
  {
    String str1 = paramString + ".adxml.feedbackInfo.feedbackList.item";
    int i = 0;
    if (i > 0) {}
    for (paramString = str1 + i;; paramString = str1)
    {
      String str2 = paramString + ".url";
      if ((paramMap.get(str2) != null) && (((String)paramMap.get(str2)).length() > 0))
      {
        b.b localb = new b.b();
        localb.url = bk.aM((String)paramMap.get(str2), "");
        localb.oBI = bk.aM((String)paramMap.get(paramString + ".Wording.zh"), "");
        localb.ovu = bk.aM((String)paramMap.get(paramString + ".Wording.en"), "");
        localb.oBJ = bk.aM((String)paramMap.get(paramString + ".Wording.tw"), "");
        if (localb.oBI.length() + localb.ovu.length() + localb.oBJ.length() > 0) {
          this.list.add(localb);
        }
        i += 1;
        break;
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.a
 * JD-Core Version:    0.7.0.1
 */