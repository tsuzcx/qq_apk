package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.scanner.model.l;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e
  implements f, at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.d> kjX;
  public String eHR;
  private t.a kjZ;
  private HashMap<Integer, Long> qtA;
  private p.b qtB;
  private com.tencent.mm.sdk.b.c<ap> qtC;
  private com.tencent.mm.sdk.b.c<qc> qtD;
  private com.tencent.mm.plugin.scanner.model.b qtE;
  public com.tencent.mm.plugin.u.a.b qtq;
  private l qtr;
  private com.tencent.mm.plugin.scanner.model.p qts;
  private o qtt;
  public com.tencent.mm.plugin.scanner.util.r qtu;
  public com.tencent.mm.plugin.scanner.util.p qtv;
  private com.tencent.mm.plugin.scanner.a.a qtw;
  private com.tencent.mm.plugin.scanner.a.b qtx;
  private HashMap<Integer, com.tencent.mm.plugin.scanner.model.r> qty;
  private HashMap<Integer, com.tencent.mm.g.b.a.t> qtz;
  
  static
  {
    AppMethodBeat.i(80798);
    kjX = new HashMap();
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new e.5());
    baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new e.6());
    AppMethodBeat.o(80798);
  }
  
  public e()
  {
    AppMethodBeat.i(80781);
    this.qtq = new com.tencent.mm.plugin.u.a.b();
    this.qtr = new l();
    this.qts = new com.tencent.mm.plugin.scanner.model.p();
    this.qtt = new o();
    this.qtu = new com.tencent.mm.plugin.scanner.util.r();
    this.qtv = new com.tencent.mm.plugin.scanner.util.p();
    this.qty = new HashMap();
    this.qtz = new HashMap();
    this.qtA = new HashMap();
    this.qtB = new e.1(this);
    this.qtC = new e.2(this);
    this.qtD = new e.3(this);
    this.qtE = new com.tencent.mm.plugin.scanner.model.b();
    AppMethodBeat.o(80781);
  }
  
  private void CC(int paramInt)
  {
    AppMethodBeat.i(80782);
    qd localqd = new qd();
    localqd.cGG.cnU = paramInt;
    localqd.cGG.cnz = false;
    com.tencent.mm.sdk.b.a.ymk.l(localqd);
    this.qty.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(80782);
  }
  
  public static String Yu(String paramString)
  {
    AppMethodBeat.i(80791);
    paramString = cia() + String.format("%s_%d.%s", new Object[] { "translation", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(80791);
    return paramString;
  }
  
  public static String Yv(String paramString)
  {
    AppMethodBeat.i(80792);
    paramString = chZ() + String.format("%s_%d.%s", new Object[] { "tmp", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(80792);
    return paramString;
  }
  
  public static String Yw(String paramString)
  {
    AppMethodBeat.i(80793);
    paramString = String.format("%s.%s", new Object[] { chZ() + "scan_translation_bg", paramString });
    AppMethodBeat.o(80793);
    return paramString;
  }
  
  public static e chX()
  {
    try
    {
      AppMethodBeat.i(80783);
      e locale = (e)q.S(e.class);
      AppMethodBeat.o(80783);
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String chY()
  {
    AppMethodBeat.i(80788);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "scanner/";
    AppMethodBeat.o(80788);
    return localObject;
  }
  
  public static String chZ()
  {
    AppMethodBeat.i(80789);
    String str = chY() + "scan_camera/";
    AppMethodBeat.o(80789);
    return str;
  }
  
  private static String cia()
  {
    AppMethodBeat.i(80790);
    String str = chY() + "scan_result/";
    AppMethodBeat.o(80790);
    return str;
  }
  
  public final com.tencent.mm.plugin.scanner.a.a cib()
  {
    AppMethodBeat.i(80794);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.qtw == null) {
      this.qtw = new com.tencent.mm.plugin.scanner.a.a(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.plugin.scanner.a.a locala = this.qtw;
    AppMethodBeat.o(80794);
    return locala;
  }
  
  public final com.tencent.mm.plugin.scanner.a.b cic()
  {
    AppMethodBeat.i(80795);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.qtx == null) {
      this.qtx = new com.tencent.mm.plugin.scanner.a.b(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.plugin.scanner.a.b localb = this.qtx;
    AppMethodBeat.o(80795);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final String gb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80787);
    if ((com.tencent.mm.kernel.g.RG()) && (!bo.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.eHR + "image/scan/img", paramString2, com.tencent.mm.a.g.w(paramString1.getBytes()) });
      AppMethodBeat.o(80787);
      return paramString1;
    }
    AppMethodBeat.o(80787);
    return "";
  }
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(80785);
    Object localObject = com.tencent.mm.kernel.g.RL().cachePath + "CommonOneMicroMsg.db";
    this.kjZ = com.tencent.mm.platformtools.t.a(hashCode(), (String)localObject, kjX, false);
    localObject = this.qtE;
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.scanner.model.b)localObject).quh);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.scanner.model.b)localObject).qui);
    com.tencent.mm.sdk.b.a.ymk.c(this.qtr);
    com.tencent.mm.sdk.b.a.ymk.c(this.qts.quU);
    com.tencent.mm.sdk.b.a.ymk.c(this.qts.quV);
    com.tencent.mm.sdk.b.a.ymk.b(this.qtt);
    com.tencent.mm.sdk.b.a.ymk.b(this.qtD);
    com.tencent.mm.sdk.b.a.ymk.b(this.qtC);
    com.tencent.mm.kernel.g.Rc().a(294, this);
    localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("NewOCRTranslationRedDot");
    ab.i("MicroMsg.scanner.SubCoreScanner", "redDotStr %s", new Object[] { localObject });
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = br.F((String)localObject, "Id");
      if (((Map)localObject).containsKey(".Id"))
      {
        int i = bo.getInt((String)((Map)localObject).get(".Id"), 0);
        int j = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yKE, 0);
        if ((i != 0) && (j != i))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKE, Integer.valueOf(i));
          com.tencent.mm.x.c.PJ().b(ac.a.yKC, true);
        }
      }
    }
    com.tencent.mm.sdk.g.d.post(new e.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.c.qCh;
    com.tencent.mm.plugin.scanner.util.c.init();
    AppMethodBeat.o(80785);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(80784);
    com.tencent.mm.sdk.b.a.ymk.d(this.qtr);
    com.tencent.mm.sdk.b.a.ymk.d(this.qts.quU);
    com.tencent.mm.sdk.b.a.ymk.d(this.qts.quV);
    com.tencent.mm.sdk.b.a.ymk.d(this.qtt);
    com.tencent.mm.sdk.b.a.ymk.d(this.qtD);
    com.tencent.mm.sdk.b.a.ymk.d(this.qtC);
    com.tencent.mm.kernel.g.Rc().b(294, this);
    Object localObject = this.qtE;
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.scanner.model.b)localObject).quh);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.scanner.model.b)localObject).qui);
    ((com.tencent.mm.plugin.scanner.model.b)localObject).cid();
    localObject = this.qtq;
    ((com.tencent.mm.plugin.u.a.b)localObject).fGO.clear();
    ((com.tencent.mm.plugin.u.a.b)localObject).bZ.clear();
    ((com.tencent.mm.plugin.u.a.b)localObject).pPm.clear();
    if (this.kjZ != null)
    {
      this.kjZ.mG(hashCode());
      this.kjZ = null;
    }
    this.eHR = "";
    localObject = com.tencent.mm.plugin.scanner.util.c.qCh;
    com.tencent.mm.plugin.scanner.util.c.release();
    AppMethodBeat.o(80784);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(80796);
    ab.i("MicroMsg.scanner.SubCoreScanner", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 294)
    {
      int i = ((com.tencent.mm.plugin.scanner.model.e)paramm).cnU;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.scanner.model.e)paramm).quk;
        if (paramString != null)
        {
          ab.i("MicroMsg.scanner.SubCoreScanner", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((com.tencent.mm.plugin.scanner.model.e)paramm).angle), Integer.valueOf(paramString.size()) });
          if (this.qtz.containsKey(Integer.valueOf(i))) {
            ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).cSO = (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.e)paramm).qul);
          }
          if ((paramString.size() > 0) && (this.qty.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (com.tencent.mm.plugin.scanner.model.r)this.qty.get(Integer.valueOf(i));
            ((com.tencent.mm.plugin.scanner.model.r)localObject).cGI = ((bge)((com.tencent.mm.plugin.scanner.model.e)paramm).rr.fsW.fta).qun;
            ((com.tencent.mm.plugin.scanner.model.r)localObject).cGJ = ((com.tencent.mm.plugin.scanner.model.e)paramm).cie();
            if (this.qtz.containsKey(Integer.valueOf(i))) {
              ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).cSM = 1L;
            }
            com.tencent.mm.plugin.scanner.util.p localp = chX().qtv;
            float f = ((com.tencent.mm.plugin.scanner.model.e)paramm).angle;
            localObject = ((com.tencent.mm.plugin.scanner.model.r)localObject).quY;
            paramm = this.qtB;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramm != null))
            {
              localObject = com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramm.b(i, null);
                AppMethodBeat.o(80796);
                return;
              }
              if ((localp.qDz != 0) && (i != localp.qDz))
              {
                ab.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localp.qDz), Integer.valueOf(i) });
                localp.cjM();
              }
              localp.qDz = i;
              localp.qDA = paramm;
              localp.qDB = new p.a(localp, i, paramString, f, (Bitmap)localObject);
              localp.qDB.v(new Void[0]);
            }
            AppMethodBeat.o(80796);
            return;
          }
          if ((this.qtz.containsKey(Integer.valueOf(i))) && (this.qtA.containsKey(Integer.valueOf(i)))) {
            ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).cSP = (System.currentTimeMillis() - ((Long)this.qtA.get(Integer.valueOf(i))).longValue());
          }
          CC(i);
        }
        AppMethodBeat.o(80796);
        return;
      }
      if ((this.qtz.containsKey(Integer.valueOf(i))) && (this.qtA.containsKey(Integer.valueOf(i))))
      {
        ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).cSP = (System.currentTimeMillis() - ((Long)this.qtA.get(Integer.valueOf(i))).longValue());
        ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).cSM = 5L;
        ((com.tencent.mm.g.b.a.t)this.qtz.get(Integer.valueOf(i))).ake();
        this.qtz.remove(Integer.valueOf(i));
        this.qtA.remove(Integer.valueOf(i));
        ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.qtz.size()), Integer.valueOf(this.qtA.size()) });
      }
      CC(i);
    }
    AppMethodBeat.o(80796);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(80786);
    ab.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.RL().eHR);
    Object localObject = com.tencent.mm.kernel.g.RL().eHR;
    ab.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.eHR = ((String)localObject);
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File((String)localObject + "image/scan/img");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localObject = new File((String)localObject + "image/scan/music");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(chY());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    chX();
    com.tencent.mm.vfs.e.avN(chZ());
    chX();
    com.tencent.mm.vfs.e.avN(cia());
    AppMethodBeat.o(80786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e
 * JD-Core Version:    0.7.0.1
 */