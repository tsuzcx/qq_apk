package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

final class b$1
  implements o
{
  b$1(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, com.tencent.mm.ai.e.a parama)
  {
    AppMethodBeat.i(65453);
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      i = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 2)
      {
        paramString = new cku();
        b.c(paramString);
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        paramString.xUI = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        paramString.uKd = i;
        paramString.cDC = bo.p((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        paramString.uKf = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        paramString.uKe = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        paramString.fSm = bo.apW((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        paramString.uJc = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        paramString.type = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        paramString.text = ((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
        paramString.cDz = ((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
        paramString.xUH = bo.apW((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        paramString.xUJ = System.currentTimeMillis();
        paramString.fQD = bo.apV((String)paramMap.get(".sysmsg.mmsearch_reddot_new.seq"));
        paramString.extInfo = bo.p((String)paramMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
        if (paramString.xUI == 1)
        {
          paramMap = this.teJ;
          switch (paramString.type)
          {
          case 5: 
          case 6: 
          case 9: 
          default: 
            switch (paramString.type)
            {
            default: 
              i = 1;
            }
            break;
          }
          for (;;)
          {
            an.a(paramString, 100, i, 0, 0L, "");
            AppMethodBeat.o(65453);
            return;
            b.aed("");
            break;
            paramMap.a(paramString.xUH, true, paramString.fQD, false);
            paramMap = new qf();
            a.ymk.l(paramMap);
            break;
            paramMap.B(paramString.xUH, false);
            paramMap = new qf();
            a.ymk.l(paramMap);
            break;
            paramMap.o("", "", 0L);
            break;
            i = 2;
            continue;
            i = 3;
            continue;
            i = 4;
          }
        }
      }
    }
    switch (paramString.type)
    {
    case 5: 
    case 6: 
    default: 
      an.a(paramString, 109, 0, 0, 0L, "r12|" + paramString.type);
    case 9: 
      do
      {
        AppMethodBeat.o(65453);
        return;
      } while (this.teJ.teD == null);
      this.teJ.teD.aee(paramString.extInfo);
      an.a(paramString, 100, 4, 0, 0L, "");
      AppMethodBeat.o(65453);
      return;
    case 8: 
      an.a(paramString, 100, 3, 0, 0L, "");
      b.aed(paramString.cDC);
      AppMethodBeat.o(65453);
      return;
    case 7: 
      an.a(paramString, 100, 2, this.teJ.teC.size(), 0L, "");
      this.teJ.b(paramString);
      AppMethodBeat.o(65453);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      an.a(paramString, 100, 1, 0, 0L, "");
      this.teJ.a(paramString);
      AppMethodBeat.o(65453);
      return;
    case 10: 
      an.a(paramString, 100, 5, 0, 0L, "");
      this.teJ.o(paramString.cDC, paramString.extInfo, paramString.xUH);
      AppMethodBeat.o(65453);
      return;
    }
    an.a(paramString, 100, 11, 0, 0L, "");
    int i = paramString.uJc;
    int j = aa.Jf(1);
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "startToUploadTopStoryTemplate currentVersion %d serverVersion %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (i > j)
    {
      b.c.dmg();
      com.tencent.mm.pluginsdk.g.a.a.b.LE(27);
    }
    AppMethodBeat.o(65453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b.1
 * JD-Core Version:    0.7.0.1
 */