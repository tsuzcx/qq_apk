package com.tencent.mm.plugin.y;

import com.tencent.mm.aw.b;
import com.tencent.mm.aw.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bn;
import java.util.HashMap;

public final class a
  extends com.tencent.mm.model.p
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.d> dgp;
  private static a mFQ;
  private d mFR = null;
  private bn mFS = null;
  private com.tencent.mm.aw.c mFT = null;
  private com.tencent.mm.aw.e mFU = new com.tencent.mm.aw.e();
  private final com.tencent.mm.ah.f mFV = new a.1(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new a.2());
  }
  
  private a()
  {
    super(com.tencent.mm.aw.f.class);
  }
  
  public static a bos()
  {
    try
    {
      if (mFQ == null) {
        mFQ = new a();
      }
      a locala = mFQ;
      return locala;
    }
    finally {}
  }
  
  public static d bot()
  {
    g.DN().CX();
    if (bos().mFR == null) {
      bos().mFR = new d();
    }
    return bos().mFR;
  }
  
  public static bn bou()
  {
    g.DN().CX();
    if (bos().mFS == null)
    {
      a locala = bos();
      g.DQ();
      locala.mFS = new bn(g.DP().dKu);
    }
    return bos().mFS;
  }
  
  public static com.tencent.mm.aw.c bov()
  {
    g.DN().CX();
    if (bos().mFT == null) {
      bos().mFT = new com.tencent.mm.aw.c();
    }
    return bos().mFT;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return dgp;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    super.onAccountInitialized(paramc);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("newtips", this.mFU);
    g.Dk().a(597, this.mFV);
    bot();
    int i = b.evf;
    paramc = b.evm;
    d.b(i, b.eve, "", paramc);
    y.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
  }
  
  public final void onAccountRelease()
  {
    super.onAccountRelease();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("newtips", this.mFU);
    g.Dk().b(597, this.mFV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.y.a
 * JD-Core Version:    0.7.0.1
 */