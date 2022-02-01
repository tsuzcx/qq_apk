package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e uKj;
  private f uKk;
  private a uKl;
  private b uKm;
  
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
    this.uKk = new f();
    this.uKl = new a();
    this.uKm = new b();
    AppMethodBeat.o(27727);
  }
  
  private static g ddI()
  {
    AppMethodBeat.i(27728);
    az.arP();
    g localg2 = (g)bz.ut("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      az.arP().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(27728);
    return localg1;
  }
  
  public static e ddJ()
  {
    AppMethodBeat.i(27729);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ddI().uKj == null)
    {
      localObject = ddI();
      az.arV();
      ((g)localObject).uKj = new e(c.afg());
    }
    Object localObject = ddI().uKj;
    AppMethodBeat.o(27729);
    return localObject;
  }
  
  public static void ddK()
  {
    AppMethodBeat.i(27732);
    az.arV();
    if (c.apR().aIn("qmessage") == null)
    {
      localObject = new am();
      ((am)localObject).setUsername("qmessage");
      ((am)localObject).setContent("");
      ((am)localObject).kS(bt.eGO());
      ((am)localObject).jV(0);
      ((am)localObject).jT(0);
      az.arV();
      c.apR().e((am)localObject);
      AppMethodBeat.o(27732);
      return;
    }
    az.arV();
    Object localObject = c.apO().agq("qmessage");
    am localam = new am();
    localam.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((du)localObject).field_content)
    {
      localam.setContent((String)localObject);
      localam.kS(bt.eGO());
      localam.jV(0);
      localam.jT(0);
      az.arV();
      c.apR().a(localam, "qmessage");
      AppMethodBeat.o(27732);
      return;
    }
  }
  
  public static void ddL()
  {
    AppMethodBeat.i(27733);
    bi.asj();
    az.arV();
    c.apR().aIm("@qqim");
    az.arV();
    c.apR().aIl("qmessage");
    AppMethodBeat.o(27733);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(27731);
    ad.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      ddL();
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
    f.d.a(Integer.valueOf(36), this.uKk);
    f.d.a(Integer.valueOf(39), this.uKk);
    com.tencent.mm.sdk.b.a.ESL.c(this.uKl);
    com.tencent.mm.sdk.b.a.ESL.c(this.uKm);
    AppMethodBeat.o(27734);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(27730);
    f.d.b(Integer.valueOf(36), this.uKk);
    f.d.b(Integer.valueOf(39), this.uKk);
    com.tencent.mm.sdk.b.a.ESL.d(this.uKl);
    com.tencent.mm.sdk.b.a.ESL.d(this.uKm);
    AppMethodBeat.o(27730);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */