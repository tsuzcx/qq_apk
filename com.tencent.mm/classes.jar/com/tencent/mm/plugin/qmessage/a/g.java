package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e xak;
  private f xal;
  private a xam;
  private b xan;
  
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
    this.xal = new f();
    this.xam = new a();
    this.xan = new b();
    AppMethodBeat.o(27727);
  }
  
  private static g dBS()
  {
    AppMethodBeat.i(27728);
    ba.aBK();
    g localg2 = (g)ca.By("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      ba.aBK().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e dBT()
  {
    AppMethodBeat.i(27729);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dBS().xak == null)
    {
      localObject = dBS();
      ba.aBQ();
      ((g)localObject).xak = new e(c.getDataDB());
    }
    Object localObject = dBS().xak;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void dBU()
  {
    AppMethodBeat.i(27732);
    ba.aBQ();
    if (c.azv().aTz("qmessage") == null)
    {
      localObject = new at();
      ((at)localObject).setUsername("qmessage");
      ((at)localObject).setContent("");
      ((at)localObject).qu(bt.flT());
      ((at)localObject).kr(0);
      ((at)localObject).kp(0);
      ba.aBQ();
      c.azv().e((at)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    ba.aBQ();
    Object localObject = c.azs().apX("qmessage");
    at localat = new at();
    localat.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((ei)localObject).field_content)
    {
      localat.setContent((String)localObject);
      localat.qu(bt.flT());
      localat.kr(0);
      localat.kp(0);
      ba.aBQ();
      c.azv().a(localat, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void dBV()
  {
    AppMethodBeat.i(27733);
    bj.aCe();
    ba.aBQ();
    c.azv().aTy("@qqim");
    ba.aBQ();
    c.azv().aTx("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    ad.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      dBV();
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
    e.d.a(Integer.valueOf(36), this.xal);
    e.d.a(Integer.valueOf(39), this.xal);
    com.tencent.mm.sdk.b.a.IbL.c(this.xam);
    com.tencent.mm.sdk.b.a.IbL.c(this.xan);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    e.d.b(Integer.valueOf(36), this.xal);
    e.d.b(Integer.valueOf(39), this.xal);
    com.tencent.mm.sdk.b.a.IbL.d(this.xam);
    com.tencent.mm.sdk.b.a.IbL.d(this.xan);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */