package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.mf;
import com.tencent.mm.f.a.ml;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.ny;
import com.tencent.mm.f.a.nz;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.f.a.yp;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements be
{
  private IListener GsB;
  private IListener GsC;
  com.tencent.mm.pluginsdk.d.c<ny> GsD;
  com.tencent.mm.pluginsdk.d.c<nz> GsE;
  d GsF;
  private bv.a GsG;
  private IListener<qq> GsH;
  private IListener<nq> GsI;
  private IListener iVt;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.GsB = new f.1(this);
    this.GsC = new IListener() {};
    this.GsD = new com.tencent.mm.pluginsdk.d.c()
    {
      public final int arZ()
      {
        return 148;
      }
    };
    this.GsE = new com.tencent.mm.pluginsdk.d.c()
    {
      public final int arZ()
      {
        return 377;
      }
    };
    this.iVt = new IListener() {};
    this.GsF = new d()
    {
      public final IEvent aIL(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        mf localmf = new mf();
        localmf.fKi.event = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localmf;
      }
      
      public final MStorage evj()
      {
        AppMethodBeat.i(89787);
        h.aHE().aGH();
        MStorage localMStorage = (MStorage)((n)h.ae(n.class)).eSb();
        AppMethodBeat.o(89787);
        return localMStorage;
      }
    };
    this.GsG = new bv.a()
    {
      public final as RG(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bv paramAnonymousbv, as paramAnonymousas)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbv != null) && (paramAnonymousas != null) && (paramAnonymousas.ayc()))
        {
          h.aHE().aGH();
          ((n)h.ae(n.class)).eSb().aOA(paramAnonymousas.field_username);
        }
        AppMethodBeat.o(89788);
      }
      
      public final int b(as paramAnonymousas, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.GsH = new IListener() {};
    this.GsI = new IListener() {};
    AppMethodBeat.o(89793);
  }
  
  public static void fix()
  {
    AppMethodBeat.i(232258);
    h.aHE().aGH();
    ((n)h.ae(n.class)).eSb().bJQ();
    h.aGY().a(new c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
    AppMethodBeat.o(232258);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(89795);
    ((n)h.ae(n.class)).bbL().a(this.GsG);
    this.GsI.alive();
    this.GsH.alive();
    EventCenter.instance.addListener(this.iVt);
    EventCenter.instance.addListener(this.GsC);
    EventCenter.instance.addListener(this.GsD);
    EventCenter.instance.addListener(this.GsE);
    this.GsB.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((n)h.ae(n.class)).bbL().b(this.GsG);
    this.GsI.alive();
    this.GsH.dead();
    EventCenter.instance.removeListener(this.GsC);
    EventCenter.instance.removeListener(this.iVt);
    EventCenter.instance.removeListener(this.GsD);
    EventCenter.instance.removeListener(this.GsE);
    this.GsB.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */