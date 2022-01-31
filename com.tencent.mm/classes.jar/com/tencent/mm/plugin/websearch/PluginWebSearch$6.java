package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.am.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class PluginWebSearch$6
  implements o
{
  PluginWebSearch$6(PluginWebSearch paramPluginWebSearch) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(91314);
    long l2;
    am localam;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        ab.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = bo.p((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = bo.apW((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = bo.apW((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localam = am.cZF();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new am.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.uKf = k;
            paramMap.uKd = i;
            paramMap.uKe = m;
            paramMap.ghy = l1;
            paramMap.uJc = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.cDz = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.fJQ = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localam.save();
      paramString = new qf();
      a.ymk.l(paramString);
      AppMethodBeat.o(91314);
      return;
      paramString = localam.uKa;
      break;
      ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.6
 * JD-Core Version:    0.7.0.1
 */