package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.a;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.graphics.MMBitmapFactory.Options;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.HashMap;

public class i
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> ovv;
  public String gBm;
  private r.a ovx;
  private HashMap<Integer, ag> yiO;
  private HashMap<Integer, dk> yiP;
  private HashMap<Integer, Long> yiQ;
  private j.b yiR;
  private c<aw> yiS;
  private c<sp> yiT;
  private d yjA;
  private p yjx;
  private com.tencent.mm.plugin.scanner.model.r yjy;
  private com.tencent.mm.plugin.scanner.f.a yjz;
  
  static
  {
    AppMethodBeat.i(51571);
    ovv = new HashMap();
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
  
  public i()
  {
    AppMethodBeat.i(51562);
    this.yjx = new p();
    this.yjy = new com.tencent.mm.plugin.scanner.model.r();
    this.yiO = new HashMap();
    this.yiP = new HashMap();
    this.yiQ = new HashMap();
    this.yiR = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(169947);
        if (i.a(i.this).containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((i.b(i.this).containsKey(Integer.valueOf(paramAnonymousInt))) && (i.c(i.this).containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((dk)i.b(i.this).get(Integer.valueOf(paramAnonymousInt))).efO = (System.currentTimeMillis() - ((Long)i.c(i.this).get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((dk)i.b(i.this).get(Integer.valueOf(paramAnonymousInt))).aLk();
            i.b(i.this).remove(Integer.valueOf(paramAnonymousInt));
            i.c(i.this).remove(Integer.valueOf(paramAnonymousInt));
            ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
          }
          if (!com.tencent.mm.kernel.g.ajx())
          {
            AppMethodBeat.o(169947);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new af();
            paramAnonymousBitmap = (ag)i.a(i.this).get(Integer.valueOf(paramAnonymousInt));
            ((af)localObject).field_originMD5 = com.tencent.mm.vfs.i.aPK(paramAnonymousBitmap.itB + com.tencent.mm.vfs.i.aYp(paramAnonymousBitmap.itB));
            ((af)localObject).field_resultFile = str;
            ((af)localObject).field_fromLang = paramAnonymousBitmap.dHi;
            ((af)localObject).field_toLang = paramAnonymousBitmap.dHj;
            ((af)localObject).field_brand = paramAnonymousBitmap.hQG;
            ad.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((af)localObject);
            localObject = new sq();
            ((sq)localObject).dHg.dlK = paramAnonymousInt;
            ((sq)localObject).dHg.dlh = true;
            ((sq)localObject).dHg.dHh = str;
            ((sq)localObject).dHg.dHi = paramAnonymousBitmap.dHi;
            ((sq)localObject).dHg.dHj = paramAnonymousBitmap.dHj;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            i.a(i.this).remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(169947);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            ad.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            i.a(i.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(169947);
      }
    };
    this.yiS = new c() {};
    this.yiT = new c()
    {
      private boolean a(sp paramAnonymoussp)
      {
        AppMethodBeat.i(169952);
        if ((paramAnonymoussp.dHf.scene == 1) && (!bt.isNullOrNil(paramAnonymoussp.dHf.filePath))) {
          try
          {
            ad.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussp.dHf.filePath, Integer.valueOf(paramAnonymoussp.dHf.dlK) });
            Object localObject1 = com.tencent.mm.vfs.i.aPK(paramAnonymoussp.dHf.filePath + com.tencent.mm.vfs.i.aYp(paramAnonymoussp.dHf.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().awM((String)localObject1);
            if (localObject1 != null)
            {
              ad.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
              localObject2 = ((fp)localObject1).field_resultFile;
              if (com.tencent.mm.vfs.i.fv((String)localObject2))
              {
                localObject3 = new sq();
                ((sq)localObject3).dHg.dlK = paramAnonymoussp.dHf.dlK;
                ((sq)localObject3).dHg.dlh = true;
                ((sq)localObject3).dHg.dHh = ((String)localObject2);
                ((sq)localObject3).dHg.dHi = ((fp)localObject1).field_fromLang;
                ((sq)localObject3).dHg.dHj = ((fp)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                i.a(i.this).remove(Integer.valueOf(paramAnonymoussp.dHf.dlK));
                AppMethodBeat.o(169952);
                return true;
              }
              ad.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
            }
            Object localObject3 = new dk();
            ((dk)localObject3).eca = 4L;
            i.b(i.this).put(Integer.valueOf(paramAnonymoussp.dHf.dlK), localObject3);
            ag localag = new ag();
            localag.itB = paramAnonymoussp.dHf.filePath;
            localag.yow = paramAnonymoussp.dHf.filePath;
            final int i = Exif.fromFile(paramAnonymoussp.dHf.filePath).getOrientationInDegree();
            ad.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussp.dHf.filePath;
            final String str = m.awZ(paramAnonymoussp.dHf.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymoussp.dHf.filePath, new MMBitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = com.tencent.mm.sdk.platformtools.g.a(localBitmap, i);
                i.dKy();
                localObject1 = i.genScanTmpImgPath("jpg");
                com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localag.yow = ((String)localObject1);
              }
            }
            i.a(i.this).put(Integer.valueOf(paramAnonymoussp.dHf.dlK), localag);
            final long l = System.currentTimeMillis();
            i.c(i.this).put(Integer.valueOf(paramAnonymoussp.dHf.dlK), Long.valueOf(l));
            ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(169950);
                if ((!bt.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.yiW.efM = (System.currentTimeMillis() - l);
                  ad.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.yiW.efM) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  if (this.yjC != 0)
                  {
                    ad.i("delete tmp path %s", i);
                    com.tencent.mm.vfs.i.deleteFile(i);
                  }
                  AppMethodBeat.o(169950);
                  return;
                  if (!bt.V(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ad.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new j(this.yiY.dHf.dlK, (int)com.tencent.mm.vfs.i.aYo(i), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymous2String, 0);
                  }
                  else
                  {
                    this.yiW.ecx = 3L;
                    this.yiW.efO = (System.currentTimeMillis() - l);
                    this.yiW.aLk();
                    i.b(i.this).remove(Integer.valueOf(this.yiY.dHf.dlK));
                    i.c(i.this).remove(Integer.valueOf(this.yiY.dHf.dlK));
                    ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
                    i.a(i.this, this.yiY.dHf.dlK);
                    continue;
                    this.yiW.ecx = 3L;
                    this.yiW.efO = (System.currentTimeMillis() - l);
                    this.yiW.aLk();
                    i.b(i.this).remove(Integer.valueOf(this.yiY.dHf.dlK));
                    i.c(i.this).remove(Integer.valueOf(this.yiY.dHf.dlK));
                    ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
                    i.a(i.this, this.yiY.dHf.dlK);
                  }
                }
              }
            });
            AppMethodBeat.o(169952);
            return true;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", localException, "", new Object[0]);
            i.a(i.this, paramAnonymoussp.dHf.dlK);
          }
        }
        AppMethodBeat.o(169952);
        return false;
      }
    };
    this.yjA = new d();
    AppMethodBeat.o(51562);
  }
  
  public static i dKy()
  {
    try
    {
      AppMethodBeat.i(51563);
      i locali = (i)t.ap(i.class);
      AppMethodBeat.o(51563);
      return locali;
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
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "scanner/";
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
  
  public final com.tencent.mm.plugin.scanner.f.a dKz()
  {
    AppMethodBeat.i(51570);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.yjz == null) {
      this.yjz = new com.tencent.mm.plugin.scanner.f.a(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.scanner.f.a locala = this.yjz;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((com.tencent.mm.kernel.g.ajx()) && (!bt.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.gBm + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = com.tencent.mm.kernel.g.ajC().cachePath + "CommonOneMicroMsg.db";
    this.ovx = com.tencent.mm.platformtools.r.a(hashCode(), (String)localObject, ovv, false);
    localObject = this.yjA;
    com.tencent.mm.sdk.b.a.IbL.c(((d)localObject).ymI);
    com.tencent.mm.sdk.b.a.IbL.c(((d)localObject).ymJ);
    com.tencent.mm.sdk.b.a.IbL.c(((d)localObject).ymK);
    com.tencent.mm.sdk.b.a.IbL.c(this.yjx);
    com.tencent.mm.sdk.b.a.IbL.c(this.yjy.ymY);
    com.tencent.mm.sdk.b.a.IbL.c(this.yjy.ymZ);
    com.tencent.mm.sdk.g.b.c(new i.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.yzj;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    com.tencent.mm.sdk.b.a.IbL.d(this.yjx);
    com.tencent.mm.sdk.b.a.IbL.d(this.yjy.ymY);
    com.tencent.mm.sdk.b.a.IbL.d(this.yjy.ymZ);
    Object localObject = this.yjA;
    com.tencent.mm.sdk.b.a.IbL.d(((d)localObject).ymI);
    com.tencent.mm.sdk.b.a.IbL.d(((d)localObject).ymJ);
    com.tencent.mm.sdk.b.a.IbL.d(((d)localObject).ymK);
    ((d)localObject).dKQ();
    if (this.ovx != null)
    {
      this.ovx.qX(hashCode());
      this.ovx = null;
    }
    this.gBm = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.yzj;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    ad.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.ajC().gBm);
    Object localObject = com.tencent.mm.kernel.g.ajC().gBm;
    ad.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.gBm = ((String)localObject);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e((String)localObject + "image/scan/img");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    localObject = new com.tencent.mm.vfs.e((String)localObject + "image/scan/music");
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    localObject = new com.tencent.mm.vfs.e(getAccScannerPath());
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    dKy();
    com.tencent.mm.vfs.i.aYu(getScanImageSaveDir());
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i
 * JD-Core Version:    0.7.0.1
 */