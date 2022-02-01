package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.graphics.MMBitmapFactory.Options;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;

public class j
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> oBW;
  public String gDT;
  private r.a oBY;
  private HashMap<Integer, ah> yyG;
  private HashMap<Integer, dm> yyH;
  private HashMap<Integer, Long> yyI;
  private j.b yyJ;
  private c<aw> yyK;
  private c<sq> yyL;
  private com.tencent.mm.plugin.scanner.model.q yzt;
  private s yzu;
  private com.tencent.mm.plugin.scanner.f.a yzv;
  private d yzw;
  
  static
  {
    AppMethodBeat.i(51571);
    oBW = new HashMap();
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.f.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.f.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(51571);
  }
  
  public j()
  {
    AppMethodBeat.i(51562);
    this.yzt = new com.tencent.mm.plugin.scanner.model.q();
    this.yzu = new s();
    this.yyG = new HashMap();
    this.yyH = new HashMap();
    this.yyI = new HashMap();
    this.yyJ = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(169947);
        if (j.a(j.this).containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((j.b(j.this).containsKey(Integer.valueOf(paramAnonymousInt))) && (j.c(j.this).containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((dm)j.b(j.this).get(Integer.valueOf(paramAnonymousInt))).ehz = (System.currentTimeMillis() - ((Long)j.c(j.this).get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((dm)j.b(j.this).get(Integer.valueOf(paramAnonymousInt))).aLH();
            j.b(j.this).remove(Integer.valueOf(paramAnonymousInt));
            j.c(j.this).remove(Integer.valueOf(paramAnonymousInt));
            ae.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
          }
          if (!com.tencent.mm.kernel.g.ajM())
          {
            AppMethodBeat.o(169947);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            h.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new ag();
            paramAnonymousBitmap = (ah)j.a(j.this).get(Integer.valueOf(paramAnonymousInt));
            ((ag)localObject).field_originMD5 = o.aRh(paramAnonymousBitmap.iwv + o.aZS(paramAnonymousBitmap.iwv));
            ((ag)localObject).field_resultFile = str;
            ((ag)localObject).field_fromLang = paramAnonymousBitmap.dIo;
            ((ag)localObject).field_toLang = paramAnonymousBitmap.dIp;
            ((ag)localObject).field_brand = paramAnonymousBitmap.hTy;
            ae.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((ag)localObject);
            localObject = new sr();
            ((sr)localObject).dIm.dmM = paramAnonymousInt;
            ((sr)localObject).dIm.dmj = true;
            ((sr)localObject).dIm.dIn = str;
            ((sr)localObject).dIm.dIo = paramAnonymousBitmap.dIo;
            ((sr)localObject).dIm.dIp = paramAnonymousBitmap.dIp;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            j.a(j.this).remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(169947);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            ae.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            j.a(j.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(169947);
      }
    };
    this.yyK = new c() {};
    this.yyL = new c()
    {
      private boolean a(sq paramAnonymoussq)
      {
        AppMethodBeat.i(169952);
        if ((paramAnonymoussq.dIl.scene == 1) && (!bu.isNullOrNil(paramAnonymoussq.dIl.filePath))) {
          try
          {
            ae.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussq.dIl.filePath, Integer.valueOf(paramAnonymoussq.dIl.dmM) });
            Object localObject1 = o.aRh(paramAnonymoussq.dIl.filePath + o.aZS(paramAnonymoussq.dIl.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().ayb((String)localObject1);
            if (localObject1 != null)
            {
              ae.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
              localObject2 = ((fp)localObject1).field_resultFile;
              if (o.fB((String)localObject2))
              {
                localObject3 = new sr();
                ((sr)localObject3).dIm.dmM = paramAnonymoussq.dIl.dmM;
                ((sr)localObject3).dIm.dmj = true;
                ((sr)localObject3).dIm.dIn = ((String)localObject2);
                ((sr)localObject3).dIm.dIo = ((fp)localObject1).field_fromLang;
                ((sr)localObject3).dIm.dIp = ((fp)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                j.a(j.this).remove(Integer.valueOf(paramAnonymoussq.dIl.dmM));
                AppMethodBeat.o(169952);
                return true;
              }
              ae.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
            }
            Object localObject3 = new dm();
            ((dm)localObject3).edv = 4L;
            j.b(j.this).put(Integer.valueOf(paramAnonymoussq.dIl.dmM), localObject3);
            ah localah = new ah();
            localah.iwv = paramAnonymoussq.dIl.filePath;
            localah.yEv = paramAnonymoussq.dIl.filePath;
            final int i = Exif.fromFile(paramAnonymoussq.dIl.filePath).getOrientationInDegree();
            ae.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussq.dIl.filePath;
            final String str = m.ayo(paramAnonymoussq.dIl.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = h.decodeFile(paramAnonymoussq.dIl.filePath, new MMBitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = h.a(localBitmap, i);
                j.dNQ();
                localObject1 = j.genScanTmpImgPath("jpg");
                h.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localah.yEv = ((String)localObject1);
              }
            }
            j.a(j.this).put(Integer.valueOf(paramAnonymoussq.dIl.dmM), localah);
            final long l = System.currentTimeMillis();
            j.c(j.this).put(Integer.valueOf(paramAnonymoussq.dIl.dmM), Long.valueOf(l));
            ((f)com.tencent.mm.kernel.g.ad(f.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(169950);
                if ((!bu.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.yyO.ehx = (System.currentTimeMillis() - l);
                  ae.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.yyO.ehx) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  if (this.yzy != 0)
                  {
                    ae.i("delete tmp path %s", i);
                    o.deleteFile(i);
                  }
                  AppMethodBeat.o(169950);
                  return;
                  if (!bu.V(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ae.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new com.tencent.mm.plugin.scanner.model.k(this.yyQ.dIl.dmM, (int)o.aZR(i), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymous2String, 0);
                  }
                  else
                  {
                    this.yyO.edS = 3L;
                    this.yyO.ehz = (System.currentTimeMillis() - l);
                    this.yyO.aLH();
                    j.b(j.this).remove(Integer.valueOf(this.yyQ.dIl.dmM));
                    j.c(j.this).remove(Integer.valueOf(this.yyQ.dIl.dmM));
                    ae.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
                    j.a(j.this, this.yyQ.dIl.dmM);
                    continue;
                    this.yyO.edS = 3L;
                    this.yyO.ehz = (System.currentTimeMillis() - l);
                    this.yyO.aLH();
                    j.b(j.this).remove(Integer.valueOf(this.yyQ.dIl.dmM));
                    j.c(j.this).remove(Integer.valueOf(this.yyQ.dIl.dmM));
                    ae.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
                    j.a(j.this, this.yyQ.dIl.dmM);
                  }
                }
              }
            });
            AppMethodBeat.o(169952);
            return true;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", localException, "", new Object[0]);
            j.a(j.this, paramAnonymoussq.dIl.dmM);
          }
        }
        AppMethodBeat.o(169952);
        return false;
      }
    };
    this.yzw = new d();
    AppMethodBeat.o(51562);
  }
  
  public static j dNQ()
  {
    try
    {
      AppMethodBeat.i(51563);
      j localj = (j)u.ap(j.class);
      AppMethodBeat.o(51563);
      return localj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(169956);
    paramString = getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "tmp", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(169956);
    return paramString;
  }
  
  public static String getAccScannerPath()
  {
    AppMethodBeat.i(51568);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "scanner/";
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
  
  public final com.tencent.mm.plugin.scanner.f.a dNR()
  {
    AppMethodBeat.i(51570);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.yzv == null) {
      this.yzv = new com.tencent.mm.plugin.scanner.f.a(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.scanner.f.a locala = this.yzv;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((com.tencent.mm.kernel.g.ajM()) && (!bu.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.gDT + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = com.tencent.mm.kernel.g.ajR().cachePath + "CommonOneMicroMsg.db";
    this.oBY = r.a(hashCode(), (String)localObject, oBW, false);
    localObject = this.yzw;
    com.tencent.mm.sdk.b.a.IvT.c(((d)localObject).yCG);
    com.tencent.mm.sdk.b.a.IvT.c(((d)localObject).yCH);
    com.tencent.mm.sdk.b.a.IvT.c(((d)localObject).yCI);
    com.tencent.mm.sdk.b.a.IvT.c(this.yzt);
    com.tencent.mm.sdk.b.a.IvT.c(this.yzu.yCX);
    com.tencent.mm.sdk.b.a.IvT.c(this.yzu.yCY);
    com.tencent.mm.sdk.g.b.c(new j.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.yPj;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    com.tencent.mm.sdk.b.a.IvT.d(this.yzt);
    com.tencent.mm.sdk.b.a.IvT.d(this.yzu.yCX);
    com.tencent.mm.sdk.b.a.IvT.d(this.yzu.yCY);
    Object localObject = this.yzw;
    com.tencent.mm.sdk.b.a.IvT.d(((d)localObject).yCG);
    com.tencent.mm.sdk.b.a.IvT.d(((d)localObject).yCH);
    com.tencent.mm.sdk.b.a.IvT.d(((d)localObject).yCI);
    ((d)localObject).dOi();
    if (this.oBY != null)
    {
      this.oBY.ra(hashCode());
      this.oBY = null;
    }
    this.gDT = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.yPj;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    ae.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.ajR().gDT);
    Object localObject = com.tencent.mm.kernel.g.ajR().gDT;
    ae.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.gDT = ((String)localObject);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k((String)localObject);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k((String)localObject + "image/scan/img");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localObject = new com.tencent.mm.vfs.k((String)localObject + "image/scan/music");
    if (!((com.tencent.mm.vfs.k)localObject).exists()) {
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    localObject = new com.tencent.mm.vfs.k(getAccScannerPath());
    if (!((com.tencent.mm.vfs.k)localObject).exists()) {
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    dNQ();
    o.aZX(getScanImageSaveDir());
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j
 * JD-Core Version:    0.7.0.1
 */