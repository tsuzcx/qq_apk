package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.ru.a;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.graphics.MMBitmapFactory.Options;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;

public class h
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> npa;
  public String gcW;
  private r.a npc;
  private n vLP;
  private p vLQ;
  private com.tencent.mm.plugin.scanner.e.a vLR;
  private com.tencent.mm.plugin.scanner.model.c vLS;
  private HashMap<Integer, ab> vLk;
  private HashMap<Integer, be> vLl;
  private HashMap<Integer, Long> vLm;
  private j.b vLn;
  private com.tencent.mm.sdk.b.c<at> vLo;
  private com.tencent.mm.sdk.b.c<ru> vLp;
  
  static
  {
    AppMethodBeat.i(51571);
    npa = new HashMap();
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new h.5());
    baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.e.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(51571);
  }
  
  public h()
  {
    AppMethodBeat.i(51562);
    this.vLP = new n();
    this.vLQ = new p();
    this.vLk = new HashMap();
    this.vLl = new HashMap();
    this.vLm = new HashMap();
    this.vLn = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(169947);
        if (h.a(h.this).containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((h.b(h.this).containsKey(Integer.valueOf(paramAnonymousInt))) && (h.c(h.this).containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((be)h.b(h.this).get(Integer.valueOf(paramAnonymousInt))).dOB = (System.currentTimeMillis() - ((Long)h.c(h.this).get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((be)h.b(h.this).get(Integer.valueOf(paramAnonymousInt))).aBj();
            h.b(h.this).remove(Integer.valueOf(paramAnonymousInt));
            h.c(h.this).remove(Integer.valueOf(paramAnonymousInt));
            ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(h.b(h.this).size()), Integer.valueOf(h.c(h.this).size()) });
          }
          if (!com.tencent.mm.kernel.g.afw())
          {
            AppMethodBeat.o(169947);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            f.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new aa();
            paramAnonymousBitmap = (ab)h.a(h.this).get(Integer.valueOf(paramAnonymousInt));
            ((aa)localObject).field_originMD5 = i.aEN(paramAnonymousBitmap.hzF + i.aMO(paramAnonymousBitmap.hzF));
            ((aa)localObject).field_resultFile = str;
            ((aa)localObject).field_fromLang = paramAnonymousBitmap.dxu;
            ((aa)localObject).field_toLang = paramAnonymousBitmap.dxv;
            ad.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((aa)localObject);
            localObject = new rv();
            ((rv)localObject).dxs.dcS = paramAnonymousInt;
            ((rv)localObject).dxs.dcq = true;
            ((rv)localObject).dxs.dxt = str;
            ((rv)localObject).dxs.dxu = paramAnonymousBitmap.dxu;
            ((rv)localObject).dxs.dxv = paramAnonymousBitmap.dxv;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            h.a(h.this).remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(169947);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            ad.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            h.a(h.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(169947);
      }
    };
    this.vLo = new com.tencent.mm.sdk.b.c() {};
    this.vLp = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ru paramAnonymousru)
      {
        AppMethodBeat.i(169952);
        if ((paramAnonymousru.dxr.scene == 1) && (!bt.isNullOrNil(paramAnonymousru.dxr.filePath))) {
          try
          {
            ad.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramAnonymousru.dxr.filePath, Integer.valueOf(paramAnonymousru.dxr.dcS) });
            Object localObject1 = i.aEN(paramAnonymousru.dxr.filePath + i.aMO(paramAnonymousru.dxr.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().amC((String)localObject1);
            if (localObject1 != null)
            {
              ad.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
              localObject2 = ((fb)localObject1).field_resultFile;
              if (i.eK((String)localObject2))
              {
                localObject3 = new rv();
                ((rv)localObject3).dxs.dcS = paramAnonymousru.dxr.dcS;
                ((rv)localObject3).dxs.dcq = true;
                ((rv)localObject3).dxs.dxt = ((String)localObject2);
                ((rv)localObject3).dxs.dxu = ((fb)localObject1).field_fromLang;
                ((rv)localObject3).dxs.dxv = ((fb)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
                h.a(h.this).remove(Integer.valueOf(paramAnonymousru.dxr.dcS));
                AppMethodBeat.o(169952);
                return true;
              }
              ad.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
            }
            Object localObject3 = new be();
            ((be)localObject3).dMB = 4L;
            h.b(h.this).put(Integer.valueOf(paramAnonymousru.dxr.dcS), localObject3);
            ab localab = new ab();
            localab.hzF = paramAnonymousru.dxr.filePath;
            localab.vPQ = paramAnonymousru.dxr.filePath;
            final int i = Exif.fromFile(paramAnonymousru.dxr.filePath).getOrientationInDegree();
            ad.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymousru.dxr.filePath;
            final String str = m.amP(paramAnonymousru.dxr.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = f.decodeFile(paramAnonymousru.dxr.filePath, new MMBitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = f.a(localBitmap, i);
                h.dkY();
                localObject1 = h.genScanTmpImgPath("jpg");
                f.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localab.vPQ = ((String)localObject1);
              }
            }
            h.a(h.this).put(Integer.valueOf(paramAnonymousru.dxr.dcS), localab);
            final long l = System.currentTimeMillis();
            h.c(h.this).put(Integer.valueOf(paramAnonymousru.dxr.dcS), Long.valueOf(l));
            ((d)com.tencent.mm.kernel.g.ad(d.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(169950);
                if ((!bt.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.vLs.dOz = (System.currentTimeMillis() - l);
                  ad.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.vLs.dOz) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  if (this.vLU != 0)
                  {
                    ad.i("delete tmp path %s", i);
                    i.deleteFile(i);
                  }
                  AppMethodBeat.o(169950);
                  return;
                  if (!bt.T(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ad.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new com.tencent.mm.plugin.scanner.model.h(this.vLu.dxr.dcS, (int)i.aMN(i), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymous2String, 0);
                  }
                  else
                  {
                    this.vLs.dMH = 3L;
                    this.vLs.dOB = (System.currentTimeMillis() - l);
                    this.vLs.aBj();
                    h.b(h.this).remove(Integer.valueOf(this.vLu.dxr.dcS));
                    h.c(h.this).remove(Integer.valueOf(this.vLu.dxr.dcS));
                    ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(h.b(h.this).size()), Integer.valueOf(h.c(h.this).size()) });
                    h.a(h.this, this.vLu.dxr.dcS);
                    continue;
                    this.vLs.dMH = 3L;
                    this.vLs.dOB = (System.currentTimeMillis() - l);
                    this.vLs.aBj();
                    h.b(h.this).remove(Integer.valueOf(this.vLu.dxr.dcS));
                    h.c(h.this).remove(Integer.valueOf(this.vLu.dxr.dcS));
                    ad.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(h.b(h.this).size()), Integer.valueOf(h.c(h.this).size()) });
                    h.a(h.this, this.vLu.dxr.dcS);
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
            h.a(h.this, paramAnonymousru.dxr.dcS);
          }
        }
        AppMethodBeat.o(169952);
        return false;
      }
    };
    this.vLS = new com.tencent.mm.plugin.scanner.model.c();
    AppMethodBeat.o(51562);
  }
  
  public static h dkY()
  {
    try
    {
      AppMethodBeat.i(51563);
      h localh = (h)t.ap(h.class);
      AppMethodBeat.o(51563);
      return localh;
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
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "scanner/";
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
  
  public final com.tencent.mm.plugin.scanner.e.a dkZ()
  {
    AppMethodBeat.i(51570);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.vLR == null) {
      this.vLR = new com.tencent.mm.plugin.scanner.e.a(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.scanner.e.a locala = this.vLR;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((com.tencent.mm.kernel.g.afw()) && (!bt.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.gcW + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = com.tencent.mm.kernel.g.afB().cachePath + "CommonOneMicroMsg.db";
    this.npc = r.a(hashCode(), (String)localObject, npa, false);
    localObject = this.vLS;
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.scanner.model.c)localObject).vOu);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.scanner.model.c)localObject).vOv);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.scanner.model.c)localObject).vOw);
    com.tencent.mm.sdk.b.a.ESL.c(this.vLP);
    com.tencent.mm.sdk.b.a.ESL.c(this.vLQ.vOJ);
    com.tencent.mm.sdk.b.a.ESL.c(this.vLQ.vOK);
    com.tencent.mm.sdk.g.b.c(new h.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.wab;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    com.tencent.mm.sdk.b.a.ESL.d(this.vLP);
    com.tencent.mm.sdk.b.a.ESL.d(this.vLQ.vOJ);
    com.tencent.mm.sdk.b.a.ESL.d(this.vLQ.vOK);
    Object localObject = this.vLS;
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.scanner.model.c)localObject).vOu);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.scanner.model.c)localObject).vOv);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.scanner.model.c)localObject).vOw);
    ((com.tencent.mm.plugin.scanner.model.c)localObject).dlq();
    if (this.npc != null)
    {
      this.npc.pK(hashCode());
      this.npc = null;
    }
    this.gcW = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.wab;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    ad.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.afB().gcW);
    Object localObject = com.tencent.mm.kernel.g.afB().gcW;
    ad.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.gcW = ((String)localObject);
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
    dkY();
    i.aMT(getScanImageSaveDir());
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h
 * JD-Core Version:    0.7.0.1
 */