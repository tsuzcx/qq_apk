package com.tencent.mm.plugin.qmessage.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qmessage.QMsgOperationListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private d Nit;
  private e Niu;
  private BindQQEventListenerImpl Niv;
  private QMsgOperationListener Niw;
  
  static
  {
    AppMethodBeat.i(27735);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(27735);
  }
  
  public f()
  {
    AppMethodBeat.i(27727);
    this.Niu = new e();
    this.Niv = new BindQQEventListenerImpl();
    this.Niw = new QMsgOperationListener();
    AppMethodBeat.o(27727);
  }
  
  private static f gDH()
  {
    AppMethodBeat.i(27728);
    bh.bCt();
    f localf2 = (f)ci.Ka("plugin.qmessage");
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f();
      bh.bCt().a("plugin.qmessage", localf1);
    }
    AppMethodBeat.o(27728);
    return localf1;
  }
  
  public static d gDI()
  {
    AppMethodBeat.i(27729);
    h.baC().aZJ();
    if (gDH().Nit == null)
    {
      localObject = gDH();
      bh.bCz();
      ((f)localObject).Nit = new d(c.getDataDB());
    }
    Object localObject = gDH().Nit;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void gDJ()
  {
    AppMethodBeat.i(27732);
    bh.bCz();
    if (c.bzG().bxM("qmessage") == null)
    {
      localObject = new bb();
      ((bb)localObject).setUsername("qmessage");
      ((bb)localObject).setContent("");
      ((bb)localObject).gR(Util.nowMilliSecond());
      ((bb)localObject).pI(0);
      ((bb)localObject).pG(0);
      bh.bCz();
      c.bzG().h((bb)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    bh.bCz();
    Object localObject = c.bzD().aLG("qmessage");
    bb localbb = new bb();
    localbb.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((fi)localObject).field_content)
    {
      localbb.setContent((String)localObject);
      localbb.gR(Util.nowMilliSecond());
      localbb.pI(0);
      localbb.pG(0);
      bh.bCz();
      c.bzG().c(localbb, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void gDK()
  {
    AppMethodBeat.i(27733);
    br.bCM();
    bh.bCz();
    c.bzG().bxL("@qqim");
    bh.bCz();
    c.bzG().bxK("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    Log.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      gDK();
    }
    AppMethodBeat.o(27731);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(27734);
    g.d.a(Integer.valueOf(36), this.Niu);
    g.d.a(Integer.valueOf(39), this.Niu);
    this.Niv.alive();
    this.Niw.alive();
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    g.d.b(Integer.valueOf(36), this.Niu);
    g.d.b(Integer.valueOf(39), this.Niu);
    this.Niv.dead();
    this.Niw.dead();
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.f
 * JD-Core Version:    0.7.0.1
 */