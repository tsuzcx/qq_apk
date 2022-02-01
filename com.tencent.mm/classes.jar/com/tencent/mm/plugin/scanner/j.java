package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.to.a;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.graphics.MMBitmapFactory.Options;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;

public class j
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> kvw;
  private com.tencent.mm.plugin.scanner.model.e CAA;
  private com.tencent.mm.plugin.scanner.model.s CAx;
  private u CAy;
  private com.tencent.mm.plugin.scanner.h.a CAz;
  private HashMap<Integer, ak> CzE;
  private HashMap<Integer, go> CzF;
  private HashMap<Integer, Long> CzG;
  private k.b CzH;
  private IListener<ay> CzI;
  private IListener<to> CzJ;
  public String hqG;
  private r.a kvx;
  
  static
  {
    AppMethodBeat.i(51571);
    kvw = new HashMap();
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new j.5());
    baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.h.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(51571);
  }
  
  public j()
  {
    AppMethodBeat.i(51562);
    this.CAx = new com.tencent.mm.plugin.scanner.model.s();
    this.CAy = new u();
    this.CzE = new HashMap();
    this.CzF = new HashMap();
    this.CzG = new HashMap();
    this.CzH = new k.b()
    {
      public final void d(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(169947);
        if (j.a(j.this).containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((j.b(j.this).containsKey(Integer.valueOf(paramAnonymousInt))) && (j.c(j.this).containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((go)j.b(j.this).get(Integer.valueOf(paramAnonymousInt))).eJW = (System.currentTimeMillis() - ((Long)j.c(j.this).get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((go)j.b(j.this).get(Integer.valueOf(paramAnonymousInt))).bfK();
            j.b(j.this).remove(Integer.valueOf(paramAnonymousInt));
            j.c(j.this).remove(Integer.valueOf(paramAnonymousInt));
            Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
          }
          if (!com.tencent.mm.kernel.g.aAc())
          {
            AppMethodBeat.o(169947);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new aj();
            paramAnonymousBitmap = (ak)j.a(j.this).get(Integer.valueOf(paramAnonymousInt));
            ((aj)localObject).field_originMD5 = com.tencent.mm.vfs.s.bhK(paramAnonymousBitmap.jrK + com.tencent.mm.vfs.s.boX(paramAnonymousBitmap.jrK));
            ((aj)localObject).field_resultFile = str;
            ((aj)localObject).field_fromLang = paramAnonymousBitmap.eab;
            ((aj)localObject).field_toLang = paramAnonymousBitmap.eac;
            ((aj)localObject).field_brand = paramAnonymousBitmap.brand;
            Log.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a((aj)localObject);
            localObject = new tp();
            ((tp)localObject).dZZ.dEb = paramAnonymousInt;
            ((tp)localObject).dZZ.dDz = true;
            ((tp)localObject).dZZ.eaa = str;
            ((tp)localObject).dZZ.eab = paramAnonymousBitmap.eab;
            ((tp)localObject).dZZ.eac = paramAnonymousBitmap.eac;
            EventCenter.instance.publish((IEvent)localObject);
            j.a(j.this).remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(169947);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            Log.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            j.a(j.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(169947);
      }
    };
    this.CzI = new IListener() {};
    this.CzJ = new IListener()
    {
      private boolean a(to paramAnonymousto)
      {
        AppMethodBeat.i(169952);
        if ((paramAnonymousto.dZY.scene == 1) && (!Util.isNullOrNil(paramAnonymousto.dZY.filePath))) {
          try
          {
            Log.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramAnonymousto.dZY.filePath, Integer.valueOf(paramAnonymousto.dZY.dEb) });
            Object localObject1 = com.tencent.mm.vfs.s.bhK(paramAnonymousto.dZY.filePath + com.tencent.mm.vfs.s.boX(paramAnonymousto.dZY.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG((String)localObject1);
            if (localObject1 != null)
            {
              Log.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
              localObject2 = ((fx)localObject1).field_resultFile;
              if (com.tencent.mm.vfs.s.YS((String)localObject2))
              {
                localObject3 = new tp();
                ((tp)localObject3).dZZ.dEb = paramAnonymousto.dZY.dEb;
                ((tp)localObject3).dZZ.dDz = true;
                ((tp)localObject3).dZZ.eaa = ((String)localObject2);
                ((tp)localObject3).dZZ.eab = ((fx)localObject1).field_fromLang;
                ((tp)localObject3).dZZ.eac = ((fx)localObject1).field_toLang;
                EventCenter.instance.publish((IEvent)localObject3);
                j.a(j.this).remove(Integer.valueOf(paramAnonymousto.dZY.dEb));
                AppMethodBeat.o(169952);
                return true;
              }
              Log.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
            }
            Object localObject3 = new go();
            ((go)localObject3).eDV = 4L;
            j.b(j.this).put(Integer.valueOf(paramAnonymousto.dZY.dEb), localObject3);
            ak localak = new ak();
            localak.jrK = paramAnonymousto.dZY.filePath;
            localak.CHv = paramAnonymousto.dZY.filePath;
            final int i = Exif.fromFile(paramAnonymousto.dZY.filePath).getOrientationInDegree();
            Log.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymousto.dZY.filePath;
            final String str = p.aMv(paramAnonymousto.dZY.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = BitmapUtil.decodeFile(paramAnonymousto.dZY.filePath, new MMBitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = BitmapUtil.rotate(localBitmap, i);
                j.eOR();
                localObject1 = j.genScanTmpImgPath("jpg");
                BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localak.CHv = ((String)localObject1);
              }
            }
            j.a(j.this).put(Integer.valueOf(paramAnonymousto.dZY.dEb), localak);
            final long l = System.currentTimeMillis();
            j.c(j.this).put(Integer.valueOf(paramAnonymousto.dZY.dEb), Long.valueOf(l));
            ((f)com.tencent.mm.kernel.g.ah(f.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new p.a()
            {
              public final void a(String paramAnonymous2String, p.b paramAnonymous2b)
              {
                AppMethodBeat.i(169950);
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.CzM.eJU = (System.currentTimeMillis() - l);
                  Log.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.CzM.eJU) });
                  this.CzM.uq(paramAnonymous2b.fileId);
                  this.CzM.ur(paramAnonymous2b.aeskey);
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  if (this.CAC != 0)
                  {
                    Log.i("delete tmp path %s", i);
                    com.tencent.mm.vfs.s.deleteFile(i);
                  }
                  AppMethodBeat.o(169950);
                  return;
                  if (!Util.isNullOrNil(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    Log.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new m(this.CzO.dZY.dEb, (int)com.tencent.mm.vfs.s.boW(i), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.azz().a(paramAnonymous2String, 0);
                  }
                  else
                  {
                    this.CzM.eEt = 3L;
                    this.CzM.eJW = (System.currentTimeMillis() - l);
                    this.CzM.bfK();
                    j.b(j.this).remove(Integer.valueOf(this.CzO.dZY.dEb));
                    j.c(j.this).remove(Integer.valueOf(this.CzO.dZY.dEb));
                    Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
                    j.a(j.this, this.CzO.dZY.dEb);
                    continue;
                    this.CzM.eEt = 3L;
                    this.CzM.eJW = (System.currentTimeMillis() - l);
                    this.CzM.bfK();
                    j.b(j.this).remove(Integer.valueOf(this.CzO.dZY.dEb));
                    j.c(j.this).remove(Integer.valueOf(this.CzO.dZY.dEb));
                    Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(j.b(j.this).size()), Integer.valueOf(j.c(j.this).size()) });
                    j.a(j.this, this.CzO.dZY.dEb);
                  }
                }
              }
            });
            AppMethodBeat.o(169952);
            return true;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", localException, "", new Object[0]);
            j.a(j.this, paramAnonymousto.dZY.dEb);
          }
        }
        AppMethodBeat.o(169952);
        return false;
      }
    };
    this.CAA = new com.tencent.mm.plugin.scanner.model.e();
    AppMethodBeat.o(51562);
  }
  
  public static j eOR()
  {
    try
    {
      AppMethodBeat.i(51563);
      j localj = (j)y.at(j.class);
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
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "scanner/";
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
  
  public final com.tencent.mm.plugin.scanner.h.a eOS()
  {
    AppMethodBeat.i(51570);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.CAz == null) {
      this.CAz = new com.tencent.mm.plugin.scanner.h.a(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.scanner.h.a locala = this.CAz;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String jP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((com.tencent.mm.kernel.g.aAc()) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.hqG + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = com.tencent.mm.kernel.g.aAh().cachePath + "CommonOneMicroMsg.db";
    this.kvx = r.a(hashCode(), (String)localObject, kvw, false);
    localObject = this.CAA;
    EventCenter.instance.addListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFv);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFw);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFx);
    EventCenter.instance.addListener(this.CAx);
    EventCenter.instance.addListener(this.CAy.CFM);
    EventCenter.instance.addListener(this.CAy.CFN);
    ThreadPool.post(new j.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.CTi;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    EventCenter.instance.removeListener(this.CAx);
    EventCenter.instance.removeListener(this.CAy.CFM);
    EventCenter.instance.removeListener(this.CAy.CFN);
    Object localObject = this.CAA;
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFv);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFw);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.scanner.model.e)localObject).CFx);
    ((com.tencent.mm.plugin.scanner.model.e)localObject).ePN();
    if (this.kvx != null)
    {
      this.kvx.uS(hashCode());
      this.kvx = null;
    }
    this.hqG = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.CTi;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    Log.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.aAh().hqG);
    Object localObject = com.tencent.mm.kernel.g.aAh().hqG;
    Log.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.hqG = ((String)localObject);
    o localo = new o((String)localObject);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localo = new o((String)localObject + "image/scan/img");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localObject = new o((String)localObject + "image/scan/music");
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    localObject = new o(getAccScannerPath());
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    eOR();
    com.tencent.mm.vfs.s.bpc(getScanImageSaveDir());
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j
 * JD-Core Version:    0.7.0.1
 */