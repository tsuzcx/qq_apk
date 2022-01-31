package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.nx.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

final class s$3
  extends c<nx>
{
  s$3(s params)
  {
    AppMethodBeat.i(36286);
    this.__eventId = nx.class.getName().hashCode();
    AppMethodBeat.o(36286);
  }
  
  private boolean a(nx paramnx)
  {
    AppMethodBeat.i(36287);
    if (!this.reY.reW.containsKey(paramnx.cEx.filePath))
    {
      AppMethodBeat.o(36287);
      return false;
    }
    int i = ((Integer)this.reY.reW.remove(paramnx.cEx.filePath)).intValue();
    String str;
    if (this.reY.reS == 12)
    {
      str = "2,3,,";
      paramnx = str;
      if (i != 0) {}
    }
    try
    {
      paramnx = "2,3,," + "," + URLEncoder.encode(this.reY.reX, "UTF-8");
      ab.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramnx });
      h.qsU.kvStat(13717, paramnx);
      s.a(this.reY);
      AppMethodBeat.o(36287);
      return false;
    }
    catch (UnsupportedEncodingException paramnx)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramnx.getMessage() });
        paramnx = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.3
 * JD-Core Version:    0.7.0.1
 */