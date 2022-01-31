package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cp;
import com.tencent.mm.h.a.cp.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$1
  extends c<cp>
{
  a$1(a parama)
  {
    this.udX = cp.class.getName().hashCode();
  }
  
  private boolean a(cp paramcp)
  {
    cp.a locala = paramcp.bII;
    Object localObject1 = new HashMap();
    if (!bk.bl(locala.packageExt))
    {
      localObject2 = locala.packageExt.split("&");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int i = 0;
        while (i < localObject2.length)
        {
          if (!bk.bl(localObject2[i]))
          {
            String[] arrayOfString = localObject2[i].split("=");
            if ((arrayOfString.length == 2) && (!bk.bl(arrayOfString[0]))) {
              ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
            }
          }
          i += 1;
        }
      }
    }
    Object localObject2 = (String)((HashMap)localObject1).get("extradata");
    y.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
    localObject1 = new com.tencent.mm.plugin.wallet_core.c.a(locala.appId, locala.bIK, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.bIL, 15, "openECard", locala.bIO);
    g.DQ();
    g.DO().dJT.a(580, new a.1.1(this, locala, paramcp, (String)localObject2));
    g.DQ();
    g.DO().dJT.a((m)localObject1, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.1
 * JD-Core Version:    0.7.0.1
 */