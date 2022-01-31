package com.tencent.mm.plugin.translate;

import com.tencent.mm.h.a.sc;
import com.tencent.mm.h.a.sc.a;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2, sc paramsc) {}
  
  public final void run()
  {
    c localc = this.pKB.pKx.pKs;
    Object localObject = this.pKA.cbJ.cbK;
    String str1 = this.pKA.cbJ.id;
    int i = this.pKA.cbJ.type;
    String str2 = this.pKA.cbJ.aWf;
    boolean bool = this.pKA.cbJ.cbL;
    byte[] arrayOfByte = this.pKA.cbJ.cbM;
    y.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[] { str1, Integer.valueOf(i) });
    if (localc.PT(str1))
    {
      y.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[] { str1 });
      return;
    }
    localObject = new c.c((String)localObject, str1, i, str2, arrayOfByte);
    if (bool) {
      ((LinkedList)localc.pKE).add(0, localObject);
    }
    for (;;)
    {
      localc.pKF.put(((c.c)localObject).id, Integer.valueOf(((c.c)localObject).pKI));
      y.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[] { Integer.valueOf(localc.iks) });
      localc.bOW();
      return;
      localc.pKE.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.2.1
 * JD-Core Version:    0.7.0.1
 */