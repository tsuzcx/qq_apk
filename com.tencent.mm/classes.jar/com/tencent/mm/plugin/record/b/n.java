package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;

public final class n
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private k ntp = null;
  private d ntq = null;
  private l ntr = new l();
  private com.tencent.mm.sdk.b.c nts = new n.1(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new n.2());
    dgp.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new n.3());
  }
  
  public static k bvA()
  {
    g.DN().CX();
    if (bvy().ntp == null) {
      bvy().ntp = new k();
    }
    return bvy().ntp;
  }
  
  public static d bvB()
  {
    g.DN().CX();
    if (bvy().ntq == null) {
      bvy().ntq = new d();
    }
    return bvy().ntq;
  }
  
  private static n bvy()
  {
    au.Hq();
    n localn2 = (n)bu.iR("plugin.record");
    n localn1 = localn2;
    if (localn2 == null)
    {
      localn1 = new n();
      au.Hq().a("plugin.record", localn1);
    }
    return localn1;
  }
  
  public static e bvz()
  {
    return ((com.tencent.mm.plugin.record.a.a)g.t(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgInfoStorage();
  }
  
  public static com.tencent.mm.plugin.record.a.d getRecordMsgCDNStorage()
  {
    return ((com.tencent.mm.plugin.record.a.a)g.t(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage();
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.udP.c(this.ntr);
    com.tencent.mm.sdk.b.a.udP.c(this.nts);
    au.Hx();
    File localFile = new File(com.tencent.mm.model.c.FQ());
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      y.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
      localFile.mkdirs();
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.d("MicroMsg.SubCoreRecordMsg", "on account post release");
    com.tencent.mm.sdk.b.a.udP.d(this.ntr);
    com.tencent.mm.sdk.b.a.udP.d(this.nts);
    Object localObject = bvy().ntp;
    if (localObject != null)
    {
      ((k)localObject).finish();
      au.Dk().b(632, (f)localObject);
      getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.c)localObject);
    }
    localObject = bvy().ntq;
    if (localObject != null) {
      ((c)localObject).finish();
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.n
 * JD-Core Version:    0.7.0.1
 */