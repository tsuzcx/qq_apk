package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e xqb;
  private f xqc;
  private a xqd;
  private b xqe;
  
  static
  {
    AppMethodBeat.i(27735);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(27735);
  }
  
  public g()
  {
    AppMethodBeat.i(27727);
    this.xqc = new f();
    this.xqd = new a();
    this.xqe = new b();
    AppMethodBeat.o(27727);
  }
  
  private static g dFj()
  {
    AppMethodBeat.i(27728);
    bc.aCa();
    g localg2 = (g)cc.Ca("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bc.aCa().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e dFk()
  {
    AppMethodBeat.i(27729);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dFj().xqb == null)
    {
      localObject = dFj();
      bc.aCg();
      ((g)localObject).xqb = new e(c.getDataDB());
    }
    Object localObject = dFj().xqb;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void dFl()
  {
    AppMethodBeat.i(27732);
    bc.aCg();
    if (c.azL().aVa("qmessage") == null)
    {
      localObject = new au();
      ((au)localObject).setUsername("qmessage");
      ((au)localObject).setContent("");
      ((au)localObject).qH(bu.fpO());
      ((au)localObject).kt(0);
      ((au)localObject).kr(0);
      bc.aCg();
      c.azL().e((au)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    bc.aCg();
    Object localObject = c.azI().arc("qmessage");
    au localau = new au();
    localau.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((ei)localObject).field_content)
    {
      localau.setContent((String)localObject);
      localau.qH(bu.fpO());
      localau.kt(0);
      localau.kr(0);
      bc.aCg();
      c.azL().a(localau, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void dFm()
  {
    AppMethodBeat.i(27733);
    bl.aCu();
    bc.aCg();
    c.azL().aUZ("@qqim");
    bc.aCg();
    c.azL().aUY("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    ae.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      dFm();
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
    e.d.a(Integer.valueOf(36), this.xqc);
    e.d.a(Integer.valueOf(39), this.xqc);
    com.tencent.mm.sdk.b.a.IvT.c(this.xqd);
    com.tencent.mm.sdk.b.a.IvT.c(this.xqe);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    e.d.b(Integer.valueOf(36), this.xqc);
    e.d.b(Integer.valueOf(39), this.xqc);
    com.tencent.mm.sdk.b.a.IvT.d(this.xqd);
    com.tencent.mm.sdk.b.a.IvT.d(this.xqe);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */