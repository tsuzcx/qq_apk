package com.tencent.mm.plugin.topstory;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$1
  implements o
{
  b$1(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if ((i == 2) || (i == 3))
      {
        paramString = new byd();
        b.b(paramString);
        y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        paramString.tOi = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        paramString.qUS = i;
        paramString.bVP = bk.q((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        paramString.qUU = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        paramString.qUT = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        paramString.eCv = bk.ZS((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        paramString.qTU = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        paramString.type = bk.ZR((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        paramString.text = ((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
        paramString.bVO = ((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
        paramString.tOh = bk.ZS((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        paramString.tOj = System.currentTimeMillis();
        this.pCU.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b.1
 * JD-Core Version:    0.7.0.1
 */