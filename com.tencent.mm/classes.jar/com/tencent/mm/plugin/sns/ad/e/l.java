package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class l
{
  public static final class a
  {
    protected LinkedList<cg> DsY;
    
    public a()
    {
      AppMethodBeat.i(201941);
      this.DsY = new LinkedList();
      AppMethodBeat.o(201941);
    }
    
    public final a m(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201942);
      try
      {
        cg localcg = new cg();
        localcg.KGy = 13298;
        localcg.xvg = (System.currentTimeMillis() / 1000L);
        String str = "";
        if (!TextUtils.isEmpty(paramString1)) {
          str = URLEncoder.encode(paramString1, "UTF-8");
        }
        paramString1 = str + "," + paramInt1 + "," + paramInt2 + "," + paramString2;
        localcg.KGz = new com.tencent.mm.bw.b(paramString1.getBytes());
        this.DsY.add(localcg);
        Log.i("SnsAdLogItemReportHelper", "add logItem:".concat(String.valueOf(paramString1)));
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          Log.e("SnsAdLogItemReportHelper", "appendDelLogItem, exp=" + paramString1.toString());
        }
      }
      AppMethodBeat.o(201942);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(201943);
      LinkedList localLinkedList = this.DsY;
      if (localLinkedList.size() > 0)
      {
        Log.i("SnsAdLogItemReportHelper", "report, logList.size=" + localLinkedList.size());
        try
        {
          g.aAi();
          g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.l(localLinkedList), 0);
          AppMethodBeat.o(201943);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SnsAdLogItemReportHelper", "report, exp=" + localThrowable.toString());
          AppMethodBeat.o(201943);
          return;
        }
      }
      Log.e("SnsAdLogItemReportHelper", "report, logList.size=0");
      AppMethodBeat.o(201943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.l
 * JD-Core Version:    0.7.0.1
 */