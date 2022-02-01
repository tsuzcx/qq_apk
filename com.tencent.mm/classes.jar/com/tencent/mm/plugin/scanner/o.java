package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.i.a;
import com.tencent.mm.plugin.scanner.model.c;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.sdk.event.EventCenter;
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
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> nnH;
  private com.tencent.mm.plugin.scanner.model.q IGf;
  private s IGg;
  private a IGh;
  private c IGi;
  public String kcB;
  private r.a nnI;
  
  static
  {
    AppMethodBeat.i(51571);
    nnH = new HashMap();
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
    this.IGf = new com.tencent.mm.plugin.scanner.model.q();
    this.IGg = new s();
    this.IGi = new c();
    AppMethodBeat.o(51562);
  }
  
  public static o fBS()
  {
    try
    {
      AppMethodBeat.i(51563);
      o localo = (o)y.as(o.class);
      AppMethodBeat.o(51563);
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void fBT()
  {
    AppMethodBeat.i(217310);
    fBS();
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(getScanImageSaveDir());
    if (!localq.ifE()) {
      localq.ifL();
    }
    fBS();
    u.bBX(getScanImageSaveDir());
    AppMethodBeat.o(217310);
  }
  
  public static String getAccScannerPath()
  {
    AppMethodBeat.i(51568);
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = h.aHG().kcB + "scanner/";
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
  
  public final a fBU()
  {
    AppMethodBeat.i(51570);
    h.aHE().aGH();
    if (this.IGh == null) {
      this.IGh = new a(h.aHG().kcF);
    }
    a locala = this.IGh;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String kh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((h.aHB()) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.kcB + "image/scan/img", paramString2, g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = h.aHG().cachePath + "CommonOneMicroMsg.db";
    this.nnI = r.a(hashCode(), (String)localObject, nnH, false);
    localObject = this.IGi;
    EventCenter.instance.addListener(((c)localObject).IKI);
    EventCenter.instance.addListener(((c)localObject).IKJ);
    EventCenter.instance.addListener(((c)localObject).IKK);
    EventCenter.instance.addListener(this.IGf);
    EventCenter.instance.addListener(this.IGg.IKY);
    EventCenter.instance.addListener(this.IGg.IKZ);
    ThreadPool.post(new o.1(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.IYA;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    EventCenter.instance.removeListener(this.IGf);
    EventCenter.instance.removeListener(this.IGg.IKY);
    EventCenter.instance.removeListener(this.IGg.IKZ);
    Object localObject = this.IGi;
    EventCenter.instance.removeListener(((c)localObject).IKI);
    EventCenter.instance.removeListener(((c)localObject).IKJ);
    EventCenter.instance.removeListener(((c)localObject).IKK);
    ((c)localObject).fCI();
    if (this.nnI != null)
    {
      this.nnI.xW(hashCode());
      this.nnI = null;
    }
    this.kcB = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.IYA;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    Log.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + h.aHG().kcB);
    Object localObject = h.aHG().kcB;
    Log.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.kcB = ((String)localObject);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject);
    if (!localq.ifE()) {
      localq.ifL();
    }
    localq = new com.tencent.mm.vfs.q((String)localObject + "image/scan/img");
    if (!localq.ifE()) {
      localq.ifL();
    }
    localObject = new com.tencent.mm.vfs.q((String)localObject + "image/scan/music");
    if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
      ((com.tencent.mm.vfs.q)localObject).ifL();
    }
    localObject = new com.tencent.mm.vfs.q(getAccScannerPath());
    if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
      ((com.tencent.mm.vfs.q)localObject).ifL();
    }
    fBT();
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.o
 * JD-Core Version:    0.7.0.1
 */