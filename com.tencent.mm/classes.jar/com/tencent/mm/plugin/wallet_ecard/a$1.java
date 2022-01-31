package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$1
  extends c<cs>
{
  a$1(a parama)
  {
    AppMethodBeat.i(48039);
    this.__eventId = cs.class.getName().hashCode();
    AppMethodBeat.o(48039);
  }
  
  private boolean a(cs paramcs)
  {
    AppMethodBeat.i(48040);
    cs.a locala = paramcs.cqd;
    Object localObject1 = new HashMap();
    if (!bo.isNullOrNil(locala.packageExt))
    {
      localObject2 = locala.packageExt.split("&");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int i = 0;
        while (i < localObject2.length)
        {
          if (!bo.isNullOrNil(localObject2[i]))
          {
            String[] arrayOfString = localObject2[i].split("=");
            if ((arrayOfString.length == 2) && (!bo.isNullOrNil(arrayOfString[0]))) {
              ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
            }
          }
          i += 1;
        }
      }
    }
    Object localObject2 = (String)((HashMap)localObject1).get("extradata");
    ab.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
    localObject1 = new d(locala.appId, locala.cqf, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.cqg, 15, "openECard", locala.cqj);
    g.RM();
    g.RK().eHt.a(580, new a.1.1(this, locala, paramcs, (String)localObject2));
    g.RM();
    g.RK().eHt.a((m)localObject1, 0);
    AppMethodBeat.o(48040);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.1
 * JD-Core Version:    0.7.0.1
 */