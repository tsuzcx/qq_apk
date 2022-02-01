package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e HkG;
  private f HkH;
  private a HkI;
  private com.tencent.mm.plugin.qmessage.b HkJ;
  
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
    this.HkH = new f();
    this.HkI = new a();
    this.HkJ = new com.tencent.mm.plugin.qmessage.b();
    AppMethodBeat.o(27727);
  }
  
  private static g frZ()
  {
    AppMethodBeat.i(27728);
    bh.beC();
    g localg2 = (g)ch.RZ("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bh.beC().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e fsa()
  {
    AppMethodBeat.i(27729);
    h.aHE().aGH();
    if (frZ().HkG == null)
    {
      localObject = frZ();
      bh.beI();
      ((g)localObject).HkG = new e(c.getDataDB());
    }
    Object localObject = frZ().HkG;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void fsb()
  {
    AppMethodBeat.i(27732);
    bh.beI();
    if (c.bbR().bwx("qmessage") == null)
    {
      localObject = new az();
      ((az)localObject).setUsername("qmessage");
      ((az)localObject).setContent("");
      ((az)localObject).EB(Util.nowMilliSecond());
      ((az)localObject).pJ(0);
      ((az)localObject).pH(0);
      bh.beI();
      c.bbR().e((az)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    bh.beI();
    Object localObject = c.bbO().aOH("qmessage");
    az localaz = new az();
    localaz.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((et)localObject).field_content)
    {
      localaz.setContent((String)localObject);
      localaz.EB(Util.nowMilliSecond());
      localaz.pJ(0);
      localaz.pH(0);
      bh.beI();
      c.bbR().a(localaz, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void fsc()
  {
    AppMethodBeat.i(27733);
    bq.beV();
    bh.beI();
    c.bbR().bww("@qqim");
    bh.beI();
    c.bbR().bwv("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    Log.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      fsc();
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
    h.d.a(Integer.valueOf(36), this.HkH);
    h.d.a(Integer.valueOf(39), this.HkH);
    EventCenter.instance.addListener(this.HkI);
    EventCenter.instance.addListener(this.HkJ);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    h.d.b(Integer.valueOf(36), this.HkH);
    h.d.b(Integer.valueOf(39), this.HkH);
    EventCenter.instance.removeListener(this.HkI);
    EventCenter.instance.removeListener(this.HkJ);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */