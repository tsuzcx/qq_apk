package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ah.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

final class PluginWebSearch$7
  implements p
{
  PluginWebSearch$7(PluginWebSearch paramPluginWebSearch) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(168801);
    long l2;
    ah localah;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        ac.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = bs.u((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = bs.aLz((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = bs.aLy((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = bs.aLz((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localah = ah.exx();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new ah.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.BZB = k;
            paramMap.BZz = i;
            paramMap.BZA = m;
            paramMap.ipQ = l1;
            paramMap.BYF = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.drM = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.hDR = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localah.save();
      paramString = new sg();
      a.GpY.l(paramString);
      AppMethodBeat.o(168801);
      return;
      paramString = localah.BZw;
      break;
      ac.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.7
 * JD-Core Version:    0.7.0.1
 */