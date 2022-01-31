package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.na;
import com.tencent.mm.h.a.na.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

final class s$3
  extends c<na>
{
  s$3(s params)
  {
    this.udX = na.class.getName().hashCode();
  }
  
  private boolean a(na paramna)
  {
    if (!this.oqp.oqn.containsKey(paramna.bWH.filePath)) {
      return false;
    }
    int i = ((Integer)this.oqp.oqn.remove(paramna.bWH.filePath)).intValue();
    String str;
    if (this.oqp.oqk == 12)
    {
      str = "2,3,,";
      paramna = str;
      if (i != 0) {}
    }
    try
    {
      paramna = "2,3,," + "," + URLEncoder.encode(this.oqp.oqo, "UTF-8");
      y.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramna });
      h.nFQ.aC(13717, paramna);
      s.a(this.oqp);
      return false;
    }
    catch (UnsupportedEncodingException paramna)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramna.getMessage() });
        paramna = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.3
 * JD-Core Version:    0.7.0.1
 */