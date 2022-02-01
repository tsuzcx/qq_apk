package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.scanner.i.a;
import com.tencent.mm.plugin.scanner.model.ProductOperationListener;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public class o
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static HashMap<Integer, h.b> qkO;
  private ProductOperationListener OMn;
  private z OMo;
  private a OMp;
  private com.tencent.mm.plugin.scanner.model.g OMq;
  public String mCJ;
  private o.a qkP;
  
  static
  {
    AppMethodBeat.i(51571);
    qkO = new HashMap();
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.i.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(51571);
  }
  
  public o()
  {
    AppMethodBeat.i(51562);
    this.OMn = new ProductOperationListener();
    this.OMo = new z();
    this.OMq = new com.tencent.mm.plugin.scanner.model.g();
    AppMethodBeat.o(51562);
  }
  
  public static o gPw()
  {
    try
    {
      AppMethodBeat.i(51563);
      o localo = (o)com.tencent.mm.model.y.aL(o.class);
      AppMethodBeat.o(51563);
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void gPx()
  {
    AppMethodBeat.i(313310);
    gPw();
    u localu = new u(getScanImageSaveDir());
    if (!localu.jKS()) {
      localu.jKY();
    }
    gPw();
    com.tencent.mm.vfs.y.bEr(getScanImageSaveDir());
    AppMethodBeat.o(313310);
  }
  
  public static String getAccScannerPath()
  {
    AppMethodBeat.i(51568);
    Object localObject = new StringBuilder();
    h.baF();
    localObject = h.baE().mCJ + "scanner/";
    AppMethodBeat.o(51568);
    return localObject;
  }
  
  public static String getScanImageSaveDir()
  {
    AppMethodBeat.i(51569);
    String str = getAccScannerPath() + "scan_camera/";
    AppMethodBeat.o(51569);
    return str;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final a gPy()
  {
    AppMethodBeat.i(51570);
    h.baC().aZJ();
    if (this.OMp == null) {
      this.OMp = new a(h.baE().mCN);
    }
    a locala = this.OMp;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String lG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((h.baz()) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.mCJ + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = h.baE().cachePath + "CommonOneMicroMsg.db";
    this.qkP = com.tencent.mm.platformtools.o.a(hashCode(), (String)localObject, qkO, false);
    localObject = this.OMq;
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORv.alive();
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORw.alive();
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORx.alive();
    this.OMn.alive();
    this.OMo.ORV.alive();
    this.OMo.ORW.alive();
    ThreadPool.post(new o.1(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.PhX;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    this.OMn.dead();
    this.OMo.ORV.dead();
    this.OMo.ORW.dead();
    Object localObject = this.OMq;
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORv.dead();
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORw.dead();
    ((com.tencent.mm.plugin.scanner.model.g)localObject).ORx.dead();
    ((com.tencent.mm.plugin.scanner.model.g)localObject).gQJ();
    if (this.qkP != null)
    {
      this.qkP.yb(hashCode());
      this.qkP = null;
    }
    this.mCJ = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.PhX;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    Log.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + h.baE().mCJ);
    Object localObject = h.baE().mCJ;
    Log.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.mCJ = ((String)localObject);
    u localu = new u((String)localObject);
    if (!localu.jKS()) {
      localu.jKY();
    }
    localu = new u((String)localObject + "image/scan/img");
    if (!localu.jKS()) {
      localu.jKY();
    }
    localObject = new u((String)localObject + "image/scan/music");
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    localObject = new u(getAccScannerPath());
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    gPx();
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.o
 * JD-Core Version:    0.7.0.1
 */