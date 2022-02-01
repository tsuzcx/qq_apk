package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e Bqn;
  private f Bqo;
  private a Bqp;
  private b Bqq;
  
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
    this.Bqo = new f();
    this.Bqp = new a();
    this.Bqq = new b();
    AppMethodBeat.o(27727);
  }
  
  private static g eFY()
  {
    AppMethodBeat.i(27728);
    bg.aVz();
    g localg2 = (g)cg.KG("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bg.aVz().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e eFZ()
  {
    AppMethodBeat.i(27729);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eFY().Bqn == null)
    {
      localObject = eFY();
      bg.aVF();
      ((g)localObject).Bqn = new e(c.getDataDB());
    }
    Object localObject = eFY().Bqn;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void eGa()
  {
    AppMethodBeat.i(27732);
    bg.aVF();
    if (c.aST().bjY("qmessage") == null)
    {
      localObject = new az();
      ((az)localObject).setUsername("qmessage");
      ((az)localObject).setContent("");
      ((az)localObject).yA(Util.nowMilliSecond());
      ((az)localObject).nv(0);
      ((az)localObject).nt(0);
      bg.aVF();
      c.aST().e((az)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    bg.aVF();
    Object localObject = c.aSQ().aEx("qmessage");
    az localaz = new az();
    localaz.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((eo)localObject).field_content)
    {
      localaz.setContent((String)localObject);
      localaz.yA(Util.nowMilliSecond());
      localaz.nv(0);
      localaz.nt(0);
      bg.aVF();
      c.aST().a(localaz, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void eGb()
  {
    AppMethodBeat.i(27733);
    bp.aVS();
    bg.aVF();
    c.aST().bjX("@qqim");
    bg.aVF();
    c.aST().bjW("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    Log.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      eGb();
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
    h.d.a(Integer.valueOf(36), this.Bqo);
    h.d.a(Integer.valueOf(39), this.Bqo);
    EventCenter.instance.addListener(this.Bqp);
    EventCenter.instance.addListener(this.Bqq);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    h.d.b(Integer.valueOf(36), this.Bqo);
    h.d.b(Integer.valueOf(39), this.Bqo);
    EventCenter.instance.removeListener(this.Bqp);
    EventCenter.instance.removeListener(this.Bqq);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */