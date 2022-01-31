package com.tencent.mm.plugin.websearch;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.pa;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.an.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class PluginWebSearch$6
  implements o
{
  PluginWebSearch$6(PluginWebSearch paramPluginWebSearch) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    long l2;
    an localan;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        y.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = bk.q((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = bk.ZS((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = bk.ZS((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localan = an.bZJ();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new an.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.qUU = k;
            paramMap.qUS = i;
            paramMap.qUT = m;
            paramMap.lSJ = l1;
            paramMap.qTU = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.bVO = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.eud = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localan.save();
      paramString = new pa();
      a.udP.m(paramString);
      return;
      paramString = localan.qUQ;
      break;
      y.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.6
 * JD-Core Version:    0.7.0.1
 */