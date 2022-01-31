package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.qq;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramString == null) {
      y.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
    }
    while (!g.DK()) {
      return;
    }
    qq localqq = new qq();
    localqq.sOr = paramInt1;
    localqq.sOt = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localqq.sOs = new bmk().bs(paramString);
    if (!bk.bE(paramArrayOfByte)) {
      localqq.sOu = new bmk().bs(paramArrayOfByte);
    }
    paramString = new qr();
    paramString.sOw.add(localqq);
    paramString.sOv = paramString.sOw.size();
    ((j)g.r(j.class)).Fv().b(new i.a(211, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */