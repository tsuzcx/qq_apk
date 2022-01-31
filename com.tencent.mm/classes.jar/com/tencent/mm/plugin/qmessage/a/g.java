package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public final class g
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private e pHT;
  private f pHU;
  private a pHV;
  private b pHW;
  
  static
  {
    AppMethodBeat.i(24095);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new g.1());
    AppMethodBeat.o(24095);
  }
  
  public g()
  {
    AppMethodBeat.i(24087);
    this.pHU = new f();
    this.pHV = new a();
    this.pHW = new b();
    AppMethodBeat.o(24087);
  }
  
  private static g cdq()
  {
    AppMethodBeat.i(24088);
    aw.aat();
    g localg2 = (g)bw.pF("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      aw.aat().a("plugin.qmessage", localg1);
    }
    AppMethodBeat.o(24088);
    return localg1;
  }
  
  public static e cdr()
  {
    AppMethodBeat.i(24089);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (cdq().pHT == null)
    {
      localObject = cdq();
      aw.aaz();
      ((g)localObject).pHT = new e(c.Rq());
    }
    Object localObject = cdq().pHT;
    AppMethodBeat.o(24089);
    return localObject;
  }
  
  public static void cds()
  {
    AppMethodBeat.i(24092);
    aw.aaz();
    if (c.YF().arH("qmessage") == null)
    {
      localObject = new ak();
      ((ak)localObject).setUsername("qmessage");
      ((ak)localObject).setContent("");
      ((ak)localObject).fK(bo.aoy());
      ((ak)localObject).hL(0);
      ((ak)localObject).hJ(0);
      aw.aaz();
      c.YF().d((ak)localObject);
      AppMethodBeat.o(24092);
      return;
    }
    aw.aaz();
    Object localObject = c.YC().Tm("qmessage");
    ak localak = new ak();
    localak.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((dd)localObject).field_content)
    {
      localak.setContent((String)localObject);
      localak.fK(bo.aoy());
      localak.hL(0);
      localak.hJ(0);
      aw.aaz();
      c.YF().a(localak, "qmessage");
      AppMethodBeat.o(24092);
      return;
    }
  }
  
  public static void cdt()
  {
    AppMethodBeat.i(24093);
    bf.aaN();
    aw.aaz();
    c.YF().arG("@qqim");
    aw.aaz();
    c.YF().arF("qmessage");
    AppMethodBeat.o(24093);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(24091);
    ab.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      cdt();
    }
    AppMethodBeat.o(24091);
  }
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24094);
    e.d.a(Integer.valueOf(36), this.pHU);
    e.d.a(Integer.valueOf(39), this.pHU);
    com.tencent.mm.sdk.b.a.ymk.c(this.pHV);
    com.tencent.mm.sdk.b.a.ymk.c(this.pHW);
    AppMethodBeat.o(24094);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24090);
    e.d.b(Integer.valueOf(36), this.pHU);
    e.d.b(Integer.valueOf(39), this.pHU);
    com.tencent.mm.sdk.b.a.ymk.d(this.pHV);
    com.tencent.mm.sdk.b.a.ymk.d(this.pHW);
    AppMethodBeat.o(24090);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */