package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lt.a;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements bd
{
  c<ng> AzA;
  c<nh> AzB;
  d AzC;
  private bv.a AzD;
  private IListener<ps> AzE;
  private IListener<my> AzF;
  private IListener Azy;
  private IListener Azz;
  private IListener grk;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.Azy = new IListener()
    {
      private static boolean a(lt paramAnonymouslt)
      {
        int i = 3;
        AppMethodBeat.i(89776);
        Object localObject = paramAnonymouslt.dRf.dRg;
        paramAnonymouslt = paramAnonymouslt.dRf.dCM;
        if ((((bp.b)localObject).iEw != null) && (((bp.b)localObject).scene == 1))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(73729, Integer.valueOf(1));
          bx localbx = new bx();
          localbx.field_content = paramAnonymouslt.field_content;
          localbx.field_createtime = Util.nowSecond();
          localbx.field_imgpath = "";
          localbx.field_sayhicontent = MMApplicationContext.getContext().getString(2131763490);
          localbx.field_sayhiuser = paramAnonymouslt.field_talker;
          localbx.field_scene = 18;
          if (paramAnonymouslt.field_status > 3) {
            i = paramAnonymouslt.field_status;
          }
          localbx.field_status = i;
          localbx.field_svrid = paramAnonymouslt.field_msgSvrId;
          localbx.field_talker = paramAnonymouslt.field_talker;
          localbx.field_type = 34;
          localbx.field_isSend = 0;
          localbx.field_sayhiencryptuser = paramAnonymouslt.field_talker;
          localbx.field_ticket = ((bp.b)localObject).iEw;
          com.tencent.mm.kernel.g.aAf().azk();
          ((by)((l)com.tencent.mm.kernel.g.af(l.class)).eiv()).a(localbx);
          localObject = new ls();
          ((ls)localObject).dRd.dRe = paramAnonymouslt.field_talker;
          EventCenter.instance.publish((IEvent)localObject);
        }
        AppMethodBeat.o(89776);
        return false;
      }
    };
    this.Azz = new IListener() {};
    this.AzA = new f.3(this);
    this.AzB = new c()
    {
      public final int alY()
      {
        return 377;
      }
    };
    this.grk = new IListener() {};
    this.AzC = new d()
    {
      public final IEvent azl(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        lo locallo = new lo();
        locallo.dQS.event = paramAnonymousString;
        AppMethodBeat.o(89786);
        return locallo;
      }
      
      public final MStorage dSG()
      {
        AppMethodBeat.i(89787);
        com.tencent.mm.kernel.g.aAf().azk();
        MStorage localMStorage = (MStorage)((l)com.tencent.mm.kernel.g.af(l.class)).eiv();
        AppMethodBeat.o(89787);
        return localMStorage;
      }
    };
    this.AzD = new bv.a()
    {
      public final as Kn(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bv paramAnonymousbv, as paramAnonymousas)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbv != null) && (paramAnonymousas != null) && (paramAnonymousas.ary()))
        {
          com.tencent.mm.kernel.g.aAf().azk();
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiv().aEq(paramAnonymousas.field_username);
        }
        AppMethodBeat.o(89788);
      }
      
      public final int b(as paramAnonymousas, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.AzE = new IListener()
    {
      private static boolean bet()
      {
        AppMethodBeat.i(89789);
        f.ewU();
        AppMethodBeat.o(89789);
        return false;
      }
    };
    this.AzF = new IListener()
    {
      private static boolean ewV()
      {
        AppMethodBeat.i(89791);
        f.ewU();
        AppMethodBeat.o(89791);
        return false;
      }
    };
    AppMethodBeat.o(89793);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(89795);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().a(this.AzD);
    this.AzF.alive();
    this.AzE.alive();
    EventCenter.instance.addListener(this.grk);
    EventCenter.instance.addListener(this.Azz);
    EventCenter.instance.addListener(this.AzA);
    EventCenter.instance.addListener(this.AzB);
    this.Azy.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().b(this.AzD);
    this.AzF.alive();
    this.AzE.dead();
    EventCenter.instance.removeListener(this.Azz);
    EventCenter.instance.removeListener(this.grk);
    EventCenter.instance.removeListener(this.AzA);
    EventCenter.instance.removeListener(this.AzB);
    this.Azy.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */