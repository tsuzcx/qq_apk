package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class q
{
  public static final class a
  {
    protected LinkedList<ce> JzN;
    
    public a()
    {
      AppMethodBeat.i(264597);
      this.JzN = new LinkedList();
      AppMethodBeat.o(264597);
    }
    
    public final a m(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(264598);
      try
      {
        ce localce = new ce();
        localce.RHQ = 13298;
        localce.Crz = (System.currentTimeMillis() / 1000L);
        String str = "";
        if (!TextUtils.isEmpty(paramString1)) {
          str = URLEncoder.encode(paramString1, "UTF-8");
        }
        paramString1 = str + "," + paramInt1 + "," + paramInt2 + "," + paramString2;
        localce.RHR = new b(paramString1.getBytes());
        this.JzN.add(localce);
        Log.i("SnsAdLogItemReportHelper", "add logItem:".concat(String.valueOf(paramString1)));
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          Log.e("SnsAdLogItemReportHelper", "appendDelLogItem, exp=" + paramString1.toString());
        }
      }
      AppMethodBeat.o(264598);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(264599);
      LinkedList localLinkedList = this.JzN;
      if (localLinkedList.size() > 0)
      {
        Log.i("SnsAdLogItemReportHelper", "report, logList.size=" + localLinkedList.size());
        try
        {
          h.aHH();
          h.aHF().kcd.a(new l(localLinkedList), 0);
          AppMethodBeat.o(264599);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SnsAdLogItemReportHelper", "report, exp=" + localThrowable.toString());
          AppMethodBeat.o(264599);
          return;
        }
      }
      Log.e("SnsAdLogItemReportHelper", "report, logList.size=0");
      AppMethodBeat.o(264599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.q
 * JD-Core Version:    0.7.0.1
 */