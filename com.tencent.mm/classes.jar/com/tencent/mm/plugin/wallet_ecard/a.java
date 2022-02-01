package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.dd.a;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class a
  implements az
{
  private d.a DFR;
  private c<dd> DFS;
  private c<oc> DFT;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.DFS = new c()
    {
      private boolean a(final dd paramAnonymousdd)
      {
        AppMethodBeat.i(71674);
        final dd.a locala = paramAnonymousdd.doX;
        Object localObject1 = new HashMap();
        if (!bu.isNullOrNil(locala.packageExt))
        {
          localObject2 = locala.packageExt.split("&");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            int i = 0;
            while (i < localObject2.length)
            {
              if (!bu.isNullOrNil(localObject2[i]))
              {
                String[] arrayOfString = localObject2[i].split("=");
                if ((arrayOfString.length == 2) && (!bu.isNullOrNil(arrayOfString[0]))) {
                  ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
                }
              }
              i += 1;
            }
          }
        }
        Object localObject2 = (String)((HashMap)localObject1).get("extradata");
        ae.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
        localObject1 = new d(locala.appId, locala.cVJ, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.doZ, 15, "openECard", locala.dpc);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(580, new f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(71673);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.b(580, this);
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              ae.i("MicroMsg.SubCoreECard", "jsapi check success");
              e.aPm(((d)paramAnonymous2n).eIm());
              paramAnonymous2String = (Context)locala.aWN.get();
              if ((paramAnonymous2String != null) && ((paramAnonymous2String instanceof Activity)))
              {
                a.a(a.this, new a.a(a.this, paramAnonymousdd));
                com.tencent.mm.plugin.wallet_ecard.a.b.a(bu.getInt(paramAnonymousdd.doX.dpb, 0), paramAnonymousdd.doX.token, paramAnonymousdd.doX.dpa, this.DFX, paramAnonymous2String, a.a(a.this));
                AppMethodBeat.o(71673);
                return;
              }
              paramAnonymousdd.doY.retCode = -1;
              paramAnonymousdd.doX.callback.run();
              AppMethodBeat.o(71673);
              return;
            }
            ae.e("MicroMsg.SubCoreECard", "jsapi check fail");
            paramAnonymousdd.doY.retCode = -1;
            paramAnonymousdd.doX.callback.run();
            AppMethodBeat.o(71673);
          }
        });
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject1, 0);
        AppMethodBeat.o(71674);
        return false;
      }
    };
    this.DFT = new c() {};
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
    this.DFS.alive();
    this.DFT.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.DFS.dead();
    this.DFT.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements d.a
  {
    private dd DFZ;
    
    public a(dd paramdd)
    {
      this.DFZ = paramdd;
    }
    
    public final Intent s(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      ae.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.DFZ.doY.retCode = 0;
        com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { e.fjr(), "openEcard:ok" });
      }
      for (;;)
      {
        this.DFZ.doX.callback.run();
        if (!e.fjq()) {
          e.fjs();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.DFZ.doY.retCode = -1;
        if (!e.fjq()) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { e.fjr(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */