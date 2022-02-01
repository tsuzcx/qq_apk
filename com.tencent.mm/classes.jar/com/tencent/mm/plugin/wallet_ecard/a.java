package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dg.a;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class a
  implements bd
{
  private d.a Ipd;
  private IListener<dg> Ipe;
  private IListener<ou> Ipf;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.Ipe = new IListener()
    {
      private boolean a(final dg paramAnonymousdg)
      {
        AppMethodBeat.i(71674);
        final dg.a locala = paramAnonymousdg.dGm;
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
        localObject1 = new d(locala.appId, locala.dmc, locala.nonceStr, locala.packageExt, locala.signType, locala.signature, locala.dGo, 15, "openECard", locala.payChannel);
        g.aAi();
        g.aAg().hqi.a(580, new i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(71673);
            g.aAi();
            g.aAg().hqi.b(580, this);
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              Log.i("MicroMsg.SubCoreECard", "jsapi check success");
              e.bfP(((d)paramAnonymous2q).fPP());
              paramAnonymous2String = (Context)locala.aWF.get();
              if ((paramAnonymous2String != null) && ((paramAnonymous2String instanceof Activity)))
              {
                a.a(a.this, new a.a(a.this, paramAnonymousdg));
                com.tencent.mm.plugin.wallet_ecard.a.b.a(Util.getInt(paramAnonymousdg.dGm.dGq, 0), paramAnonymousdg.dGm.token, paramAnonymousdg.dGm.dGp, this.Ipj, paramAnonymous2String, a.a(a.this));
                AppMethodBeat.o(71673);
                return;
              }
              paramAnonymousdg.dGn.retCode = -1;
              paramAnonymousdg.dGm.callback.run();
              AppMethodBeat.o(71673);
              return;
            }
            Log.e("MicroMsg.SubCoreECard", "jsapi check fail");
            paramAnonymousdg.dGn.retCode = -1;
            paramAnonymousdg.dGm.callback.run();
            AppMethodBeat.o(71673);
          }
        });
        g.aAi();
        g.aAg().hqi.a((q)localObject1, 0);
        AppMethodBeat.o(71674);
        return false;
      }
    };
    this.Ipf = new IListener() {};
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
    this.Ipe.alive();
    this.Ipf.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.Ipe.dead();
    this.Ipf.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements d.a
  {
    private dg Ipl;
    
    public a(dg paramdg)
    {
      this.Ipl = paramdg;
    }
    
    public final Intent q(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      Log.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.Ipl.dGn.retCode = 0;
        h.CyF.a(14954, new Object[] { e.gsR(), "openEcard:ok" });
      }
      for (;;)
      {
        this.Ipl.dGm.callback.run();
        if (!e.gsQ()) {
          e.gsS();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.Ipl.dGn.retCode = -1;
        if (!e.gsQ()) {
          h.CyF.a(14954, new Object[] { e.gsR(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */