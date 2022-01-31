package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.d> iiX = new HashMap();
  public String dKt;
  private t.a iiZ;
  public com.tencent.mm.plugin.ad.a.b nGn = new com.tencent.mm.plugin.ad.a.b();
  private k nGo = new k();
  private o nGp = new o();
  private com.tencent.mm.plugin.scanner.a.n nGq = new com.tencent.mm.plugin.scanner.a.n();
  public p nGr = new p();
  public com.tencent.mm.plugin.scanner.util.n nGs = new com.tencent.mm.plugin.scanner.util.n();
  private com.tencent.mm.plugin.scanner.history.a.b nGt;
  private com.tencent.mm.plugin.scanner.a.b nGu = new com.tencent.mm.plugin.scanner.a.b();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.plugin.scanner.history.a.b.dXp;
      }
    });
  }
  
  public static String FU()
  {
    return bxd().dKt;
  }
  
  public static c bxd()
  {
    au.Hq();
    c localc2 = (c)bu.iR("plugin.scanner");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      au.Hq().a("plugin.scanner", localc1);
    }
    return localc1;
  }
  
  public static com.tencent.mm.plugin.scanner.history.a.b bxe()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bxd().nGt == null)
    {
      c localc = bxd();
      au.Hx();
      localc.nGt = new com.tencent.mm.plugin.scanner.history.a.b(com.tencent.mm.model.c.Dv());
    }
    return bxd().nGt;
  }
  
  public final void bh(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    au.Hx();
    localObject = com.tencent.mm.model.c.FT() + "CommonOneMicroMsg.db";
    this.iiZ = t.a(hashCode(), (String)localObject, iiX, false);
    localObject = this.nGu;
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.scanner.a.b)localObject).nGQ);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.scanner.a.b)localObject).nGR);
    com.tencent.mm.sdk.b.a.udP.c(this.nGo);
    com.tencent.mm.sdk.b.a.udP.c(this.nGp.nHv);
    com.tencent.mm.sdk.b.a.udP.c(this.nGp.nHw);
    com.tencent.mm.sdk.b.a.udP.b(this.nGq);
    localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("NewOCRTranslationRedDot");
    y.i("MicroMsg.scanner.SubCoreScanner", "redDotStr %s", new Object[] { localObject });
    if (!bk.bl((String)localObject))
    {
      localObject = bn.s((String)localObject, "Id");
      if (((Map)localObject).containsKey(".Id"))
      {
        int i = bk.getInt((String)((Map)localObject).get(".Id"), 0);
        int j = com.tencent.mm.kernel.g.DP().Dz().j(ac.a.uzM);
        if ((i != 0) && (j != i))
        {
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzM, Integer.valueOf(i));
          com.tencent.mm.y.c.BS().b(ac.a.uzK, true);
        }
      }
    }
    au.DS().O(new Runnable()
    {
      public final void run()
      {
        if (!au.DK()) {
          return;
        }
        if (bk.bl(c.a(c.this)))
        {
          y.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
          return;
        }
        bk.h(c.a(c.this) + "image/scan/img", "scanbook", 604800000L);
      }
      
      public final String toString()
      {
        return super.toString() + "|onAccountPostReset";
      }
    });
  }
  
  public final void bi(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("onSdcardMount ");
    au.Hx();
    y.d("MicroMsg.scanner.SubCoreScanner", com.tencent.mm.model.c.FU());
    Object localObject2 = bxd();
    au.Hx();
    localObject1 = com.tencent.mm.model.c.FU();
    y.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + (String)localObject1);
    ((c)localObject2).dKt = ((String)localObject1);
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new File((String)localObject1 + "image/scan/img");
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File((String)localObject1 + "image/scan/music");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
  }
  
  public final String eA(String paramString1, String paramString2)
  {
    if ((au.DK()) && (!bk.bl(paramString1))) {
      return String.format("%s/scanbook%s_%s", new Object[] { this.dKt + "image/scan/img", paramString2, com.tencent.mm.a.g.o(paramString1.getBytes()) });
    }
    return "";
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.nGo);
    com.tencent.mm.sdk.b.a.udP.d(this.nGp.nHv);
    com.tencent.mm.sdk.b.a.udP.d(this.nGp.nHw);
    com.tencent.mm.sdk.b.a.udP.d(this.nGq);
    Object localObject = this.nGu;
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.scanner.a.b)localObject).nGQ);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.scanner.a.b)localObject).nGR);
    ((com.tencent.mm.plugin.scanner.a.b)localObject).bxf();
    localObject = this.nGn;
    ((com.tencent.mm.plugin.ad.a.b)localObject).eqn.clear();
    ((com.tencent.mm.plugin.ad.a.b)localObject).bV.clear();
    ((com.tencent.mm.plugin.ad.a.b)localObject).njZ.clear();
    if (this.iiZ != null)
    {
      this.iiZ.jK(hashCode());
      this.iiZ = null;
    }
    this.dKt = "";
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c
 * JD-Core Version:    0.7.0.1
 */