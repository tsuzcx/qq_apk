package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e vTa;
  private f vTb;
  private a vTc;
  private b vTd;
  
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
    this.vTb = new f();
    this.vTc = new a();
    this.vTd = new b();
    AppMethodBeat.o(27727);
  }
  
  private static g drq()
  {
    AppMethodBeat.i(27728);
    az.ayG();
    g localg2 = (g)bz.yz("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      az.ayG().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e drr()
  {
    AppMethodBeat.i(27729);
    com.tencent.mm.kernel.g.agP().afT();
    if (drq().vTa == null)
    {
      localObject = drq();
      az.ayM();
      ((g)localObject).vTa = new e(c.agw());
    }
    Object localObject = drq().vTa;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void drs()
  {
    AppMethodBeat.i(27732);
    az.ayM();
    if (c.awG().aNI("qmessage") == null)
    {
      localObject = new ap();
      ((ap)localObject).setUsername("qmessage");
      ((ap)localObject).setContent("");
      ((ap)localObject).ou(bs.eWj());
      ((ap)localObject).jT(0);
      ((ap)localObject).jR(0);
      az.ayM();
      c.awG().e((ap)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    az.ayM();
    Object localObject = c.awD().alk("qmessage");
    ap localap = new ap();
    localap.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((dy)localObject).field_content)
    {
      localap.setContent((String)localObject);
      localap.ou(bs.eWj());
      localap.jT(0);
      localap.jR(0);
      az.ayM();
      c.awG().a(localap, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void drt()
  {
    AppMethodBeat.i(27733);
    bi.aza();
    az.ayM();
    c.awG().aNH("@qqim");
    az.ayM();
    c.awG().aNG("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    ac.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      drt();
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
    f.d.a(Integer.valueOf(36), this.vTb);
    f.d.a(Integer.valueOf(39), this.vTb);
    com.tencent.mm.sdk.b.a.GpY.c(this.vTc);
    com.tencent.mm.sdk.b.a.GpY.c(this.vTd);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    f.d.b(Integer.valueOf(36), this.vTb);
    f.d.b(Integer.valueOf(39), this.vTb);
    com.tencent.mm.sdk.b.a.GpY.d(this.vTc);
    com.tencent.mm.sdk.b.a.GpY.d(this.vTd);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */