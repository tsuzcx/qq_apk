package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

final class s$2
  extends c<ny>
{
  s$2(s params)
  {
    AppMethodBeat.i(36283);
    this.__eventId = ny.class.getName().hashCode();
    AppMethodBeat.o(36283);
  }
  
  private boolean a(ny paramny)
  {
    AppMethodBeat.i(36284);
    if (!this.reY.reW.containsKey(paramny.cEy.filePath))
    {
      AppMethodBeat.o(36284);
      return false;
    }
    int i = ((Integer)this.reY.reW.remove(paramny.cEy.filePath)).intValue();
    try
    {
      str1 = URLEncoder.encode(paramny.cEy.result, "UTF-8");
      if (this.reY.eDB != 0)
      {
        bcs localbcs = (bcs)this.reY.reV.get(paramny.cEy.filePath);
        this.reY.reU += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localbcs.xsg, localbcs.Url, Integer.valueOf(paramny.cEy.cpE) });
      }
      if (this.reY.reS == 12)
      {
        str1 = "2,3,,".concat(String.valueOf(str1));
        paramny = str1;
        if (i != 0) {}
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        String str1;
        paramny = str1 + "," + URLEncoder.encode(this.reY.reX, "UTF-8");
        ab.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramny });
        h.qsU.kvStat(13717, paramny);
        s.a(this.reY);
        AppMethodBeat.o(36284);
        return false;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
        str2 = "";
      }
      catch (UnsupportedEncodingException paramny)
      {
        for (;;)
        {
          String str2;
          ab.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramny.getMessage() });
          paramny = str2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.2
 * JD-Core Version:    0.7.0.1
 */