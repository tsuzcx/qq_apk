package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.dv;
import com.tencent.mm.autogen.a.dv.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class SubCoreECard$1
  extends IListener<dv>
{
  SubCoreECard$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(262469);
    this.__eventId = dv.class.getName().hashCode();
    AppMethodBeat.o(262469);
  }
  
  private boolean a(final dv paramdv)
  {
    AppMethodBeat.i(71674);
    final dv.a locala = paramdv.hDG;
    Object localObject1 = new HashMap();
    if (!Util.isNullOrNil(locala.packageExt))
    {
      localObject2 = locala.packageExt.split("&");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int i = 0;
        while (i < localObject2.length)
        {
          if (!Util.isNullOrNil(localObject2[i]))
          {
            String[] arrayOfString = localObject2[i].split("=");
            if ((arrayOfString.length == 2) && (!Util.isNullOrNil(arrayOfString[0]))) {
              ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
            }
          }
          i += 1;
        }
      }
    }
    Object localObject2 = (String)((HashMap)localObject1).get("extradata");
    Log.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
    localObject1 = new d(locala.appId, locala.hhx, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.hDI, 15, "openECard", locala.payChannel);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(580, new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(71673);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.b(580, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.SubCoreECard", "jsapi check success");
          e.brZ(((d)paramAnonymousp).ihJ());
          paramAnonymousString = (Context)locala.contextRef.get();
          if ((paramAnonymousString != null) && ((paramAnonymousString instanceof Activity)))
          {
            a.a(SubCoreECard.1.this.VYC, new a.a(SubCoreECard.1.this.VYC, paramdv));
            b.a(Util.getInt(paramdv.hDG.hDK, 0), paramdv.hDG.token, paramdv.hDG.hDJ, this.VYF, paramAnonymousString, a.a(SubCoreECard.1.this.VYC));
            AppMethodBeat.o(71673);
            return;
          }
          paramdv.hDH.retCode = -1;
          paramdv.hDG.callback.run();
          AppMethodBeat.o(71673);
          return;
        }
        Log.e("MicroMsg.SubCoreECard", "jsapi check fail");
        paramdv.hDH.retCode = -1;
        paramdv.hDG.callback.run();
        AppMethodBeat.o(71673);
      }
    });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
    AppMethodBeat.o(71674);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.SubCoreECard.1
 * JD-Core Version:    0.7.0.1
 */