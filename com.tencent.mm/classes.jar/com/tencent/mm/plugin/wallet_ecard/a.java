package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dl;
import com.tencent.mm.f.a.dl.a;
import com.tencent.mm.f.a.pr;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class a
  implements be
{
  private d.a PhL;
  private IListener<dl> PhM;
  private IListener<pr> PhN;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.PhM = new IListener()
    {
      private boolean a(final dl paramAnonymousdl)
      {
        AppMethodBeat.i(71674);
        final dl.a locala = paramAnonymousdl.fyX;
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
        localObject1 = new d(locala.appId, locala.fdH, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.fyZ, 15, "openECard", locala.payChannel);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(580, new i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(71673);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.b(580, this);
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              Log.i("MicroMsg.SubCoreECard", "jsapi check success");
              e.bsi(((d)paramAnonymous2q).gIv());
              paramAnonymous2String = (Context)locala.aFX.get();
              if ((paramAnonymous2String != null) && ((paramAnonymous2String instanceof Activity)))
              {
                a.a(a.this, new a.a(a.this, paramAnonymousdl));
                b.a(Util.getInt(paramAnonymousdl.fyX.fzb, 0), paramAnonymousdl.fyX.token, paramAnonymousdl.fyX.fza, this.PhR, paramAnonymous2String, a.a(a.this));
                AppMethodBeat.o(71673);
                return;
              }
              paramAnonymousdl.fyY.retCode = -1;
              paramAnonymousdl.fyX.callback.run();
              AppMethodBeat.o(71673);
              return;
            }
            Log.e("MicroMsg.SubCoreECard", "jsapi check fail");
            paramAnonymousdl.fyY.retCode = -1;
            paramAnonymousdl.fyX.callback.run();
            AppMethodBeat.o(71673);
          }
        });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
        AppMethodBeat.o(71674);
        return false;
      }
    };
    this.PhN = new IListener() {};
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
    this.PhM.alive();
    this.PhN.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.PhM.dead();
    this.PhN.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements d.a
  {
    private dl PhT;
    
    public a(dl paramdl)
    {
      this.PhT = paramdl;
    }
    
    public final Intent s(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      Log.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.PhT.fyY.retCode = 0;
        com.tencent.mm.plugin.report.service.h.IzE.a(14954, new Object[] { e.hoe(), "openEcard:ok" });
      }
      for (;;)
      {
        this.PhT.fyX.callback.run();
        if (!e.hod()) {
          e.hof();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.PhT.fyY.retCode = -1;
        if (!e.hod()) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14954, new Object[] { e.hoe(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */