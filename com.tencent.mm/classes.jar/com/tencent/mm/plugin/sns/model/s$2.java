package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

final class s$2
  extends c<nb>
{
  s$2(s params)
  {
    this.udX = nb.class.getName().hashCode();
  }
  
  private boolean a(nb paramnb)
  {
    if (!this.oqp.oqn.containsKey(paramnb.bWI.filePath)) {
      return false;
    }
    int i = ((Integer)this.oqp.oqn.remove(paramnb.bWI.filePath)).intValue();
    try
    {
      str1 = URLEncoder.encode(paramnb.bWI.result, "UTF-8");
      if (this.oqp.dFZ != 0)
      {
        awd localawd = (awd)this.oqp.oqm.get(paramnb.bWI.filePath);
        this.oqp.oql += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localawd.tsd, localawd.kSC, Integer.valueOf(paramnb.bWI.bIj) });
      }
      if (this.oqp.oqk == 12)
      {
        str1 = "2,3,," + str1;
        paramnb = str1;
        if (i != 0) {}
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        String str1;
        paramnb = str1 + "," + URLEncoder.encode(this.oqp.oqo, "UTF-8");
        y.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramnb });
        h.nFQ.aC(13717, paramnb);
        s.a(this.oqp);
        return false;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        y.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
        str2 = "";
      }
      catch (UnsupportedEncodingException paramnb)
      {
        for (;;)
        {
          String str2;
          y.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramnb.getMessage() });
          paramnb = str2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.2
 * JD-Core Version:    0.7.0.1
 */