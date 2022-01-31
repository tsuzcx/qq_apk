package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import com.tencent.e.a.d.1;
import com.tencent.e.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.CountDownLatch;

@Keep
final class Normsg$C2JBridge
{
  @Keep
  private static String c1()
  {
    AppMethodBeat.i(10255);
    String str2 = "";
    Object localObject = com.tencent.mm.lib.riskscanner.a.a.bS(ah.getContext());
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((Bundle)localObject).getInt("errCode", -100) == 0)
      {
        localObject = ((Bundle)localObject).getByteArray("reqBufferBase64");
        str1 = str2;
        if (localObject != null) {
          str1 = Base64.encodeToString((byte[])localObject, 2);
        }
      }
    }
    AppMethodBeat.o(10255);
    return str1;
  }
  
  @Keep
  private static long c2()
  {
    AppMethodBeat.i(10256);
    long l = com.tencent.mm.plugin.normsg.b.a.bXr().bXs();
    AppMethodBeat.o(10256);
    return l;
  }
  
  @Keep
  private static void c3(int paramInt, String paramString)
  {
    AppMethodBeat.i(10257);
    h.qsU.kvStat(paramInt, paramString);
    AppMethodBeat.o(10257);
  }
  
  @Keep
  private static void c4(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(10258);
    h.qsU.j(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(10258);
  }
  
  @Keep
  private static void c5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(10259);
    h.qsU.d(paramInt1, paramInt2, paramInt3, paramInt4, false);
    AppMethodBeat.o(10259);
  }
  
  @Keep
  private static String c6()
  {
    AppMethodBeat.i(10260);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new String[1];
    localObject[0] = "";
    com.tencent.e.e.a.e.dUE().Ez();
    Context localContext = ah.getContext();
    String str = q.bP(true);
    Normsg.C2JBridge.1 local1 = new Normsg.C2JBridge.1((String[])localObject, localCountDownLatch);
    c localc = new c(localContext);
    com.tencent.e.e.a.e.dUE().a(localContext, str, new d.1(local1, localc));
    try
    {
      localCountDownLatch.await();
      label85:
      localObject = localObject[0];
      AppMethodBeat.o(10260);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label85;
    }
  }
  
  @Keep
  private static String c7()
  {
    AppMethodBeat.i(10261);
    String str = d.cyc().son;
    if (str != null)
    {
      AppMethodBeat.o(10261);
      return str;
    }
    AppMethodBeat.o(10261);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.C2JBridge
 * JD-Core Version:    0.7.0.1
 */