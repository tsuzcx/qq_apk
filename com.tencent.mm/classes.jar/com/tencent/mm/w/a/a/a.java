package com.tencent.mm.w.a.a;

import com.tencent.mm.w.c;
import com.tencent.mm.w.e;
import java.util.Map;

public abstract class a
  extends com.tencent.mm.w.a
{
  public abstract void a(int paramInt, c paramc);
  
  public final void a(c paramc)
  {
    String str = paramc.fTO;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new e();
        if (str.equals("loadMoreMainEmoticonData"))
        {
          i = 0;
          continue;
          if (str.equals("getEmoticonDownloadProgressMap"))
          {
            i = 1;
            continue;
            if (str.equals("getEmoticonDownloadList"))
            {
              i = 2;
              continue;
              if (str.equals("loadMorePersonEmoticonData"))
              {
                i = 3;
                continue;
                if (str.equals("getEmoticonRewardData"))
                {
                  i = 4;
                  continue;
                  if (str.equals("getEmoticonDetailData"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("loadFirstMainDataFromCache"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("loadFirstPersonDataFromCache"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("startToDownloadEmoticon"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("getEmoticonComplaintUrl"))
                          {
                            i = 9;
                            continue;
                            if (str.equals("getEmoticonPrivacyUrl"))
                            {
                              i = 10;
                              continue;
                              if (str.equals("getShareTimelineSessionId"))
                              {
                                i = 11;
                                continue;
                                if (str.equals("startWebSearch"))
                                {
                                  i = 12;
                                  continue;
                                  if (str.equals("shareEmoticonToFriend"))
                                  {
                                    i = 13;
                                    continue;
                                    if (str.equals("getPreviewEmoticonPath"))
                                    {
                                      i = 14;
                                      continue;
                                      if (str.equals("cancelDownloadEmoticon"))
                                      {
                                        i = 15;
                                        continue;
                                        if (str.equals("checkLocalEmotionData")) {
                                          i = 16;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    b(paramc);
    return;
    c(paramc);
    return;
    d(paramc);
    return;
    e(paramc);
    return;
    a((String)paramc.qa("productId"), paramc);
    return;
    a((String)paramc.qa("productId"), ((Integer)paramc.qa("version")).intValue(), paramc);
    return;
    f(paramc);
    return;
    g(paramc);
    return;
    a((String)paramc.qa("productId"), (String)paramc.qa("packName"), paramc);
    return;
    h(paramc);
    return;
    i(paramc);
    return;
    j(paramc);
    return;
    a(((Integer)paramc.qa("scene")).intValue(), paramc);
    return;
    a((Map)paramc.qa("detailItem"), (String)paramc.qa("selectUserName"), paramc);
    return;
    a((String)paramc.qa("productId"), (Map)paramc.qa("packThumbExtItem"), paramc);
    return;
    a((String)paramc.qa("productId"), (String)paramc.qa("seriesId"), (String)paramc.qa("productName"), (String)paramc.qa("cdnClientID"), ((Integer)paramc.qa("productStatus")).intValue());
    return;
    b((String)paramc.qa("productId"), paramc);
  }
  
  public abstract void a(String paramString, int paramInt, c paramc);
  
  public abstract void a(String paramString, c paramc);
  
  public abstract void a(String paramString1, String paramString2, c paramc);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void a(String paramString, Map<String, Object> paramMap, c paramc);
  
  public abstract void a(Map<String, Object> paramMap, String paramString, c paramc);
  
  public final String acK()
  {
    return "Emoticon";
  }
  
  public abstract void b(c paramc);
  
  public abstract void b(String paramString, c paramc);
  
  public abstract void c(c paramc);
  
  public abstract void d(c paramc);
  
  public abstract void e(c paramc);
  
  public abstract void f(c paramc);
  
  public abstract void g(c paramc);
  
  public abstract void h(c paramc);
  
  public abstract void i(c paramc);
  
  public abstract void j(c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.a.a.a
 * JD-Core Version:    0.7.0.1
 */