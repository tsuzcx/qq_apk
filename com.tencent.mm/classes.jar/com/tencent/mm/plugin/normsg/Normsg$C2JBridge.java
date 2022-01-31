package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import com.tencent.d.a.d.1;
import com.tencent.d.b.c;
import com.tencent.d.e.a.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.CountDownLatch;

@Keep
final class Normsg$C2JBridge
{
  @Keep
  private static String c1()
  {
    String str2 = "";
    Object localObject = com.tencent.mm.lib.riskscanner.a.a.bo(ae.getContext());
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
    return str1;
  }
  
  @Keep
  private static long c2()
  {
    return com.tencent.mm.plugin.normsg.b.a.boQ().boR();
  }
  
  @Keep
  private static void c3(int paramInt, String paramString)
  {
    h.nFQ.aC(paramInt, paramString);
  }
  
  @Keep
  private static void c4(int paramInt1, int paramInt2, int paramInt3)
  {
    h.nFQ.h(paramInt1, paramInt2, paramInt3);
  }
  
  @Keep
  private static void c5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h.nFQ.d(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  @Keep
  private static String c6()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    e.cOP().un();
    Context localContext = ae.getContext();
    String str = q.zf();
    Normsg.C2JBridge.1 local1 = new Normsg.C2JBridge.1(arrayOfString, localCountDownLatch);
    c localc = new c(localContext);
    e.cOP().a(localContext, str, new d.1(local1, localc));
    try
    {
      localCountDownLatch.await();
      label78:
      return arrayOfString[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.C2JBridge
 * JD-Core Version:    0.7.0.1
 */