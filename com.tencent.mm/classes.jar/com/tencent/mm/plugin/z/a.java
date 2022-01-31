package com.tencent.mm.plugin.z;

import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.d> dgp;
  private static volatile a mOe;
  private com.tencent.mm.pluginsdk.model.app.c mOf;
  private com.tencent.mm.pluginsdk.model.app.e mOg;
  private com.tencent.mm.pluginsdk.model.app.h mOh;
  private i mOi;
  private k mOj;
  private m mOk;
  private d mOl;
  private com.tencent.mm.sdk.b.c mOm = new a.4(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new a.2());
    dgp.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new a.3());
  }
  
  private a()
  {
    a.a.a(new a.1(this));
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c avh()
  {
    g.DN().CX();
    if (brj().mOf == null) {
      brj().mOf = new com.tencent.mm.pluginsdk.model.app.c(g.DP().dKu);
    }
    return brj().mOf;
  }
  
  public static a brj()
  {
    if (mOe == null) {}
    try
    {
      if (mOe == null) {
        mOe = new a();
      }
      return mOe;
    }
    finally {}
  }
  
  public static String brk()
  {
    return g.DP().dKt + "openapi/";
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e brl()
  {
    g.DN().CX();
    if (brj().mOg == null) {
      brj().mOg = new com.tencent.mm.pluginsdk.model.app.e();
    }
    return brj().mOg;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.h brm()
  {
    g.DN().CX();
    if (brj().mOh == null) {
      brj().mOh = new com.tencent.mm.pluginsdk.model.app.h();
    }
    return brj().mOh;
  }
  
  public static i brn()
  {
    g.DN().CX();
    if (brj().mOi == null) {
      brj().mOi = new i(g.DP().dKu);
    }
    return brj().mOi;
  }
  
  public static k bro()
  {
    g.DN().CX();
    if (brj().mOj == null) {
      brj().mOj = new k(g.DP().dKu);
    }
    return brj().mOj;
  }
  
  public static m brp()
  {
    g.DN().CX();
    if (brj().mOk == null) {
      brj().mOk = new m();
    }
    return brj().mOk;
  }
  
  public static d brq()
  {
    g.DN().CX();
    if (brj().mOl == null) {
      brj().mOl = new d();
    }
    return brj().mOl;
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return dgp;
  }
  
  public List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/" });
    return localLinkedList;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    com.tencent.mm.model.ac.a.dVw = brm();
    com.tencent.mm.sdk.b.a.udP.c(this.mOm);
  }
  
  public void onAccountRelease()
  {
    Object localObject = brj().mOh;
    if (localObject != null)
    {
      g.DO().dJT.b(231, (com.tencent.mm.ah.f)localObject);
      brq().b(7, (t)localObject);
    }
    localObject = brj().mOg;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).rTX.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).nVU.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).fXi.clear();
    }
    localObject = brj().mOk;
    if (localObject != null)
    {
      y.d("MicroMsg.AppSettingService", "stop service");
      ((m)localObject).rUu.clear();
      brq().b(1, (t)localObject);
    }
    if (this.mOl != null)
    {
      localObject = this.mOl;
      g.DO().dJT.b(452, (com.tencent.mm.ah.f)localObject);
      ((d)localObject).edB.clear();
    }
    if (brj().mOi != null) {
      brj().mOi.rUm.clear();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.mOm);
    y.i("XPinOpenApi", "onAccountRelease");
  }
  
  public void onDataBaseClosed(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    this.mOf = null;
    this.mOi = null;
    y.i("XPinOpenApi", "onDataBaseClosed");
  }
  
  public void onDataBaseOpened(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.z.a
 * JD-Core Version:    0.7.0.1
 */