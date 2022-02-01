package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class u
{
  public static final class a
  {
    protected LinkedList<co> POF;
    
    public a()
    {
      AppMethodBeat.i(309927);
      this.POF = new LinkedList();
      AppMethodBeat.o(309927);
    }
    
    public final a q(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(309939);
      try
      {
        co localco = new co();
        localco.YET = 13298;
        localco.IdF = (System.currentTimeMillis() / 1000L);
        String str = "";
        if (!TextUtils.isEmpty(paramString1)) {
          str = URLEncoder.encode(paramString1, "UTF-8");
        }
        paramString1 = str + "," + paramInt1 + "," + paramInt2 + "," + paramString2;
        localco.YEU = new b(paramString1.getBytes());
        this.POF.add(localco);
        Log.i("SnsAdLogItemReportHelper", "add logItem:".concat(String.valueOf(paramString1)));
      }
      finally
      {
        for (;;)
        {
          Log.e("SnsAdLogItemReportHelper", "appendDelLogItem, exp=" + paramString1.toString());
        }
      }
      AppMethodBeat.o(309939);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(309947);
      LinkedList localLinkedList = this.POF;
      if (localLinkedList.size() > 0)
      {
        Log.i("SnsAdLogItemReportHelper", "report, logList.size=" + localLinkedList.size());
        try
        {
          h.baF();
          h.baD().mCm.a(new l(localLinkedList), 0);
          AppMethodBeat.o(309947);
          return;
        }
        finally
        {
          Log.e("SnsAdLogItemReportHelper", "report, exp=" + localObject.toString());
          AppMethodBeat.o(309947);
          return;
        }
      }
      Log.e("SnsAdLogItemReportHelper", "report, logList.size=0");
      AppMethodBeat.o(309947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.u
 * JD-Core Version:    0.7.0.1
 */