package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dc.a;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class a
  implements ax
{
  private d.a Dol;
  private c<dc> Dom;
  private c<ob> Don;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.Dom = new c()
    {
      private boolean a(final dc paramAnonymousdc)
      {
        AppMethodBeat.i(71674);
        final dc.a locala = paramAnonymousdc.dnS;
        Object localObject1 = new HashMap();
        if (!bt.isNullOrNil(locala.packageExt))
        {
          localObject2 = locala.packageExt.split("&");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            int i = 0;
            while (i < localObject2.length)
            {
              if (!bt.isNullOrNil(localObject2[i]))
              {
                String[] arrayOfString = localObject2[i].split("=");
                if ((arrayOfString.length == 2) && (!bt.isNullOrNil(arrayOfString[0]))) {
                  ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
                }
              }
              i += 1;
            }
          }
        }
        Object localObject2 = (String)((HashMap)localObject1).get("extradata");
        ad.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[] { localObject2, localObject1 });
        localObject1 = new d(locala.appId, locala.cUM, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.dnU, 15, "openECard", locala.dnX);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(580, new f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(71673);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.b(580, this);
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              ad.i("MicroMsg.SubCoreECard", "jsapi check success");
              e.aNP(((d)paramAnonymous2n).eEF());
              paramAnonymous2String = (Context)locala.aWN.get();
              if ((paramAnonymous2String != null) && ((paramAnonymous2String instanceof Activity)))
              {
                a.a(a.this, new a.a(a.this, paramAnonymousdc));
                com.tencent.mm.plugin.wallet_ecard.a.b.a(bt.getInt(paramAnonymousdc.dnS.dnW, 0), paramAnonymousdc.dnS.token, paramAnonymousdc.dnS.dnV, this.Dor, paramAnonymous2String, a.a(a.this));
                AppMethodBeat.o(71673);
                return;
              }
              paramAnonymousdc.dnT.retCode = -1;
              paramAnonymousdc.dnS.callback.run();
              AppMethodBeat.o(71673);
              return;
            }
            ad.e("MicroMsg.SubCoreECard", "jsapi check fail");
            paramAnonymousdc.dnT.retCode = -1;
            paramAnonymousdc.dnS.callback.run();
            AppMethodBeat.o(71673);
          }
        });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
        AppMethodBeat.o(71674);
        return false;
      }
    };
    this.Don = new c() {};
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
    this.Dom.alive();
    this.Don.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.Dom.dead();
    this.Don.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements d.a
  {
    private dc Dot;
    
    public a(dc paramdc)
    {
      this.Dot = paramdc;
    }
    
    public final Intent s(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      ad.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.Dot.dnT.retCode = 0;
        com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { e.ffB(), "openEcard:ok" });
      }
      for (;;)
      {
        this.Dot.dnS.callback.run();
        if (!e.ffA()) {
          e.ffC();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.Dot.dnT.retCode = -1;
        if (!e.ffA()) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { e.ffB(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */