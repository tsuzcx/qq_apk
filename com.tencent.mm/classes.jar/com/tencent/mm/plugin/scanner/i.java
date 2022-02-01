package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.sd.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.graphics.MMBitmapFactory.Options;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.h;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.HashMap;

public class i
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.b> nSa;
  public String ghC;
  private r.a nSc;
  private n wVQ;
  private p wVR;
  private com.tencent.mm.plugin.scanner.f.a wVS;
  private com.tencent.mm.plugin.scanner.model.c wVT;
  private HashMap<Integer, ad> wVl;
  private HashMap<Integer, cr> wVm;
  private HashMap<Integer, Long> wVn;
  private j.b wVo;
  private com.tencent.mm.sdk.b.c<au> wVp;
  private com.tencent.mm.sdk.b.c<sd> wVq;
  
  static
  {
    AppMethodBeat.i(51571);
    nSa = new HashMap();
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
    this.wVQ = new n();
    this.wVR = new p();
    this.wVl = new HashMap();
    this.wVm = new HashMap();
    this.wVn = new HashMap();
    this.wVo = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(169947);
        if (i.a(i.this).containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((i.b(i.this).containsKey(Integer.valueOf(paramAnonymousInt))) && (i.c(i.this).containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((cr)i.b(i.this).get(Integer.valueOf(paramAnonymousInt))).dQs = (System.currentTimeMillis() - ((Long)i.c(i.this).get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((cr)i.b(i.this).get(Integer.valueOf(paramAnonymousInt))).aHZ();
            i.b(i.this).remove(Integer.valueOf(paramAnonymousInt));
            i.c(i.this).remove(Integer.valueOf(paramAnonymousInt));
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
          }
          if (!com.tencent.mm.kernel.g.agM())
          {
            AppMethodBeat.o(169947);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            f.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new com.tencent.mm.plugin.scanner.model.ac();
            paramAnonymousBitmap = (ad)i.a(i.this).get(Integer.valueOf(paramAnonymousInt));
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_originMD5 = com.tencent.mm.vfs.i.aKe(paramAnonymousBitmap.iag + com.tencent.mm.vfs.i.aSq(paramAnonymousBitmap.iag));
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_resultFile = str;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_fromLang = paramAnonymousBitmap.dvh;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_toLang = paramAnonymousBitmap.dvi;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_brand = paramAnonymousBitmap.hym;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((com.tencent.mm.plugin.scanner.model.ac)localObject);
            localObject = new se();
            ((se)localObject).dvf.daq = paramAnonymousInt;
            ((se)localObject).dvf.cZP = true;
            ((se)localObject).dvf.dvg = str;
            ((se)localObject).dvf.dvh = paramAnonymousBitmap.dvh;
            ((se)localObject).dvf.dvi = paramAnonymousBitmap.dvi;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            i.a(i.this).remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(169947);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            i.a(i.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(169947);
      }
    };
    this.wVp = new com.tencent.mm.sdk.b.c() {};
    this.wVq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sd paramAnonymoussd)
      {
        AppMethodBeat.i(169952);
        if ((paramAnonymoussd.dve.scene == 1) && (!bs.isNullOrNil(paramAnonymoussd.dve.filePath))) {
          try
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussd.dve.filePath, Integer.valueOf(paramAnonymoussd.dve.daq) });
            Object localObject1 = com.tencent.mm.vfs.i.aKe(paramAnonymoussd.dve.filePath + com.tencent.mm.vfs.i.aSq(paramAnonymoussd.dve.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().arL((String)localObject1);
            if (localObject1 != null)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
              localObject2 = ((ff)localObject1).field_resultFile;
              if (com.tencent.mm.vfs.i.eA((String)localObject2))
              {
                localObject3 = new se();
                ((se)localObject3).dvf.daq = paramAnonymoussd.dve.daq;
                ((se)localObject3).dvf.cZP = true;
                ((se)localObject3).dvf.dvg = ((String)localObject2);
                ((se)localObject3).dvf.dvh = ((ff)localObject1).field_fromLang;
                ((se)localObject3).dvf.dvi = ((ff)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                i.a(i.this).remove(Integer.valueOf(paramAnonymoussd.dve.daq));
                AppMethodBeat.o(169952);
                return true;
              }
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
            }
            Object localObject3 = new cr();
            ((cr)localObject3).dNc = 4L;
            i.b(i.this).put(Integer.valueOf(paramAnonymoussd.dve.daq), localObject3);
            ad localad = new ad();
            localad.iag = paramAnonymoussd.dve.filePath;
            localad.xax = paramAnonymoussd.dve.filePath;
            final int i = Exif.fromFile(paramAnonymoussd.dve.filePath).getOrientationInDegree();
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussd.dve.filePath;
            final String str = m.arY(paramAnonymoussd.dve.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = f.decodeFile(paramAnonymoussd.dve.filePath, new MMBitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = f.a(localBitmap, i);
                i.dza();
                localObject1 = i.genScanTmpImgPath("jpg");
                f.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localad.xax = ((String)localObject1);
              }
            }
            i.a(i.this).put(Integer.valueOf(paramAnonymoussd.dve.daq), localad);
            final long l = System.currentTimeMillis();
            i.c(i.this).put(Integer.valueOf(paramAnonymoussd.dve.daq), Long.valueOf(l));
            ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(169950);
                if ((!bs.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.wVt.dQq = (System.currentTimeMillis() - l);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.wVt.dQq) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  if (this.wVV != 0)
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("delete tmp path %s", i);
                    com.tencent.mm.vfs.i.deleteFile(i);
                  }
                  AppMethodBeat.o(169950);
                  return;
                  if (!bs.T(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new h(this.wVv.dve.daq, (int)com.tencent.mm.vfs.i.aSp(i), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.agi().a(paramAnonymous2String, 0);
                  }
                  else
                  {
                    this.wVt.dNi = 3L;
                    this.wVt.dQs = (System.currentTimeMillis() - l);
                    this.wVt.aHZ();
                    i.b(i.this).remove(Integer.valueOf(this.wVv.dve.daq));
                    i.c(i.this).remove(Integer.valueOf(this.wVv.dve.daq));
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
                    i.a(i.this, this.wVv.dve.daq);
                    continue;
                    this.wVt.dNi = 3L;
                    this.wVt.dQs = (System.currentTimeMillis() - l);
                    this.wVt.aHZ();
                    i.b(i.this).remove(Integer.valueOf(this.wVv.dve.daq));
                    i.c(i.this).remove(Integer.valueOf(this.wVv.dve.daq));
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(i.b(i.this).size()), Integer.valueOf(i.c(i.this).size()) });
                    i.a(i.this, this.wVv.dve.daq);
                  }
                }
              }
            });
            AppMethodBeat.o(169952);
            return true;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", localException, "", new Object[0]);
            i.a(i.this, paramAnonymoussd.dve.daq);
          }
        }
        AppMethodBeat.o(169952);
        return false;
      }
    };
    this.wVT = new com.tencent.mm.plugin.scanner.model.c();
    AppMethodBeat.o(51562);
  }
  
  public static i dza()
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
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "scanner/";
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
  
  public final com.tencent.mm.plugin.scanner.f.a dzb()
  {
    AppMethodBeat.i(51570);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.wVS == null) {
      this.wVS = new com.tencent.mm.plugin.scanner.f.a(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.scanner.f.a locala = this.wVS;
    AppMethodBeat.o(51570);
    return locala;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final String iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51567);
    if ((com.tencent.mm.kernel.g.agM()) && (!bs.isNullOrNil(paramString1)))
    {
      paramString1 = String.format("%s/scanbook%s_%s", new Object[] { this.ghC + "image/scan/img", paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(51567);
      return paramString1;
    }
    AppMethodBeat.o(51567);
    return "";
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51565);
    Object localObject = com.tencent.mm.kernel.g.agR().cachePath + "CommonOneMicroMsg.db";
    this.nSc = r.a(hashCode(), (String)localObject, nSa, false);
    localObject = this.wVT;
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.scanner.model.c)localObject).wYQ);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.scanner.model.c)localObject).wYR);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.scanner.model.c)localObject).wYS);
    com.tencent.mm.sdk.b.a.GpY.c(this.wVQ);
    com.tencent.mm.sdk.b.a.GpY.c(this.wVR.wZf);
    com.tencent.mm.sdk.b.a.GpY.c(this.wVR.wZg);
    com.tencent.mm.sdk.g.b.c(new i.4(this), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
    localObject = com.tencent.mm.plugin.scanner.util.b.xlh;
    com.tencent.mm.plugin.scanner.util.b.init();
    AppMethodBeat.o(51565);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51564);
    com.tencent.mm.sdk.b.a.GpY.d(this.wVQ);
    com.tencent.mm.sdk.b.a.GpY.d(this.wVR.wZf);
    com.tencent.mm.sdk.b.a.GpY.d(this.wVR.wZg);
    Object localObject = this.wVT;
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.scanner.model.c)localObject).wYQ);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.scanner.model.c)localObject).wYR);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.scanner.model.c)localObject).wYS);
    ((com.tencent.mm.plugin.scanner.model.c)localObject).dzs();
    if (this.nSc != null)
    {
      this.nSc.qx(hashCode());
      this.nSc = null;
    }
    this.ghC = "";
    localObject = com.tencent.mm.plugin.scanner.util.b.xlh;
    com.tencent.mm.plugin.scanner.util.b.release();
    AppMethodBeat.o(51564);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(51566);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + com.tencent.mm.kernel.g.agR().ghC);
    Object localObject = com.tencent.mm.kernel.g.agR().ghC;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(localObject)));
    this.ghC = ((String)localObject);
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
    dza();
    com.tencent.mm.vfs.i.aSv(getScanImageSaveDir());
    AppMethodBeat.o(51566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i
 * JD-Core Version:    0.7.0.1
 */