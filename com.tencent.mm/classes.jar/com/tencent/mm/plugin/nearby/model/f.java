package com.tencent.mm.plugin.nearby.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.nl;
import com.tencent.mm.autogen.a.oy;
import com.tencent.mm.autogen.a.pg;
import com.tencent.mm.autogen.a.ph;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.pluginsdk.event.OnSceneEndProxy;
import com.tencent.mm.pluginsdk.event.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements be
{
  private IListener MoB;
  private IListener MoC;
  OnSceneEndProxy<pg> MoD;
  OnSceneEndProxy<ph> MoE;
  a MoF;
  private bx.a MoG;
  private IListener<se> MoH;
  private IListener<oy> MoI;
  private IListener lxy;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.MoB = new SubCoreNearby.1(this, com.tencent.mm.app.f.hfK);
    this.MoC = new SubCoreNearby.2(this, com.tencent.mm.app.f.hfK);
    this.MoD = new SubCoreNearby.3(this);
    this.MoE = new SubCoreNearby.4(this);
    this.lxy = new SubCoreNearby.5(this, com.tencent.mm.app.f.hfK);
    this.MoF = new a()
    {
      public final IEvent aFl(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        nl localnl = new nl();
        localnl.hPO.event = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localnl;
      }
      
      public final MStorage fCc()
      {
        AppMethodBeat.i(89787);
        h.baC().aZJ();
        MStorage localMStorage = (MStorage)((n)h.ax(n.class)).gaW();
        AppMethodBeat.o(89787);
        return localMStorage;
      }
    };
    this.MoG = new bx.a()
    {
      public final au JE(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bx paramAnonymousbx, au paramAnonymousau)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbx != null) && (paramAnonymousau != null) && (paramAnonymousau.aSF()))
        {
          h.baC().aZJ();
          ((n)h.ax(n.class)).gaW().aLz(paramAnonymousau.field_username);
        }
        AppMethodBeat.o(89788);
      }
      
      public final int b(au paramAnonymousau, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.MoH = new SubCoreNearby.9(this, com.tencent.mm.app.f.hfK);
    this.MoI = new SubCoreNearby.10(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(89793);
  }
  
  public static void gsO()
  {
    AppMethodBeat.i(262801);
    h.baC().aZJ();
    ((n)h.ax(n.class)).gaW().cju();
    h.aZW().a(new c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
    AppMethodBeat.o(262801);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(89795);
    ((n)h.ax(n.class)).bzA().a(this.MoG);
    this.MoI.alive();
    this.MoH.alive();
    this.lxy.alive();
    this.MoC.alive();
    this.MoD.alive();
    this.MoE.alive();
    this.MoB.alive();
    com.tencent.mm.br.c.a(new c.c()
    {
      public final boolean aR(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(262795);
        if ((paramAnonymousString.startsWith("nearby")) && (((d)h.ax(d.class)).aBu()))
        {
          ((d)h.ax(d.class)).kg(paramAnonymousContext);
          AppMethodBeat.o(262795);
          return true;
        }
        AppMethodBeat.o(262795);
        return false;
      }
    });
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((n)h.ax(n.class)).bzA().b(this.MoG);
    this.MoI.alive();
    this.MoH.dead();
    this.MoC.dead();
    this.lxy.dead();
    this.MoD.dead();
    this.MoE.dead();
    this.MoB.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.f
 * JD-Core Version:    0.7.0.1
 */