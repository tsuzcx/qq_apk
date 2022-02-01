package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class a
  implements aw
{
  private d.a BNT;
  private c<cz> BNU;
  private c<nt> BNV;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.BNU = new c()
    {
      private boolean a(final cz paramAnonymouscz)
      {
        AppMethodBeat.i(71674);
        final cz.a locala = paramAnonymouscz.dcw;
        Object localObject1 = new HashMap();
        if (!bs.isNullOrNil(locala.packageExt))
        {
          localObject2 = locala.packageExt.split("&");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            int i = 0;
            while (i < localObject2.length)
            {
              if (!bs.isNullOrNil(localObject2[i]))
              {
                String[] arrayOfString = localObject2[i].split("=");
                if ((arrayOfString.length == 2) && (!bs.isNullOrNil(arrayOfString[0]))) {
                  ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
                }
              }
              i += 1;
            }
          }
        }
        Object localObject2 = (String)((HashMap)localObject1).get("extradata");
        ac.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
        localObject1 = new d(locala.appId, locala.cJz, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.dcy, 15, "openECard", locala.dcB);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(580, new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(71673);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.b(580, this);
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              ac.i("MicroMsg.SubCoreECard", "jsapi check success");
              e.aIm(((d)paramAnonymous2n).eqF());
              paramAnonymous2String = (Context)locala.aMw.get();
              if ((paramAnonymous2String != null) && ((paramAnonymous2String instanceof Activity)))
              {
                a.a(a.this, new a.a(a.this, paramAnonymouscz));
                com.tencent.mm.plugin.wallet_ecard.a.b.a(bs.getInt(paramAnonymouscz.dcw.dcA, 0), paramAnonymouscz.dcw.token, paramAnonymouscz.dcw.dcz, this.BNZ, paramAnonymous2String, a.a(a.this));
                AppMethodBeat.o(71673);
                return;
              }
              paramAnonymouscz.dcx.retCode = -1;
              paramAnonymouscz.dcw.callback.run();
              AppMethodBeat.o(71673);
              return;
            }
            ac.e("MicroMsg.SubCoreECard", "jsapi check fail");
            paramAnonymouscz.dcx.retCode = -1;
            paramAnonymouscz.dcw.callback.run();
            AppMethodBeat.o(71673);
          }
        });
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
        AppMethodBeat.o(71674);
        return false;
      }
    };
    this.BNV = new c() {};
    AppMethodBeat.o(71678);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(71679);
    this.BNU.alive();
    this.BNV.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.BNU.dead();
    this.BNV.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements d.a
  {
    private cz BOb;
    
    public a(cz paramcz)
    {
      this.BOb = paramcz;
    }
    
    public final Intent r(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      ac.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.BOb.dcx.retCode = 0;
        h.wUl.f(14954, new Object[] { e.eQx(), "openEcard:ok" });
      }
      for (;;)
      {
        this.BOb.dcw.callback.run();
        if (!e.eQw()) {
          e.eQy();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.BOb.dcx.retCode = -1;
        if (!e.eQw()) {
          h.wUl.f(14954, new Object[] { e.eQx(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */