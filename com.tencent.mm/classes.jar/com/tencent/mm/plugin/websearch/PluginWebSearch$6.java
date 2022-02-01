package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.plugin.websearch.api.aq.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class PluginWebSearch$6
  implements q
{
  PluginWebSearch$6(PluginWebSearch paramPluginWebSearch)
  {
    AppMethodBeat.i(168798);
    AppMethodBeat.o(168798);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(116516);
    long l2;
    aq localaq;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = Util.safeFormatString((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localaq = aq.fYk();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new aq.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.IFp = k;
            paramMap.IFn = i;
            paramMap.IFo = m;
            paramMap.jIU = l1;
            paramMap.IEj = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.icon = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.iUm = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localaq.save();
      paramString = new ts();
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(116516);
      return;
      paramString = localaq.IFk;
      break;
      Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.6
 * JD-Core Version:    0.7.0.1
 */