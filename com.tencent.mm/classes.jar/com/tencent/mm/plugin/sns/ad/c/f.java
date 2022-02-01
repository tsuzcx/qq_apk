package com.tencent.mm.plugin.sns.ad.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ae;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class f
{
  public static final class a
  {
    protected LinkedList<bx> zns;
    
    public a()
    {
      AppMethodBeat.i(219013);
      this.zns = new LinkedList();
      AppMethodBeat.o(219013);
    }
    
    public final a m(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219014);
      try
      {
        bx localbx = new bx();
        localbx.FMT = 13298;
        localbx.udu = (System.currentTimeMillis() / 1000L);
        String str = "";
        if (!TextUtils.isEmpty(paramString1)) {
          str = URLEncoder.encode(paramString1, "UTF-8");
        }
        paramString1 = str + "," + paramInt1 + "," + paramInt2 + "," + paramString2;
        localbx.FMU = new com.tencent.mm.bw.b(paramString1.getBytes());
        this.zns.add(localbx);
        ae.i("SnsAdLogItemReportHelper", "add logItem:".concat(String.valueOf(paramString1)));
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          ae.e("SnsAdLogItemReportHelper", "appendDelLogItem, exp=" + paramString1.toString());
        }
      }
      AppMethodBeat.o(219014);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(219015);
      LinkedList localLinkedList = this.zns;
      if (localLinkedList.size() > 0)
      {
        ae.i("SnsAdLogItemReportHelper", "report, logList.size=" + localLinkedList.size());
        try
        {
          g.ajS();
          g.ajQ().gDv.a(new l(localLinkedList), 0);
          AppMethodBeat.o(219015);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("SnsAdLogItemReportHelper", "report, exp=" + localThrowable.toString());
          AppMethodBeat.o(219015);
          return;
        }
      }
      ae.e("SnsAdLogItemReportHelper", "report, logList.size=0");
      AppMethodBeat.o(219015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.f
 * JD-Core Version:    0.7.0.1
 */