package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.a;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.util.j.a;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.al.f, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, d
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.scanner.util.j yiM;
  private com.tencent.mm.plugin.scanner.f.b yiN;
  private HashMap<Integer, ag> yiO;
  private HashMap<Integer, dk> yiP;
  private HashMap<Integer, Long> yiQ;
  private j.b yiR;
  private com.tencent.mm.sdk.b.c<aw> yiS;
  private com.tencent.mm.sdk.b.c<sp> yiT;
  
  static
  {
    AppMethodBeat.i(120855);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.f.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(120855);
  }
  
  public PluginScanTranslation()
  {
    AppMethodBeat.i(120843);
    this.yiM = new com.tencent.mm.plugin.scanner.util.j();
    this.yiO = new HashMap();
    this.yiP = new HashMap();
    this.yiQ = new HashMap();
    this.yiR = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.yiO.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.yiP.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.yiQ.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((dk)PluginScanTranslation.this.yiP.get(Integer.valueOf(paramAnonymousInt))).efO = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.yiQ.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((dk)PluginScanTranslation.this.yiP.get(Integer.valueOf(paramAnonymousInt))).aLk();
            PluginScanTranslation.this.yiP.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.yiQ.remove(Integer.valueOf(paramAnonymousInt));
            ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yiP.size()), Integer.valueOf(PluginScanTranslation.this.yiQ.size()) });
          }
          if (!com.tencent.mm.kernel.g.ajx())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new af();
            paramAnonymousBitmap = (ag)PluginScanTranslation.this.yiO.get(Integer.valueOf(paramAnonymousInt));
            ((af)localObject).field_originMD5 = ai.ee(paramAnonymousBitmap.itB + i.aYp(paramAnonymousBitmap.itB));
            ((af)localObject).field_resultFile = str;
            ((af)localObject).field_fromLang = paramAnonymousBitmap.dHi;
            ((af)localObject).field_toLang = paramAnonymousBitmap.dHj;
            ((af)localObject).field_brand = paramAnonymousBitmap.hQG;
            ad.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((af)localObject);
            localObject = new sq();
            ((sq)localObject).dHg.dlK = paramAnonymousInt;
            ((sq)localObject).dHg.dlh = true;
            ((sq)localObject).dHg.dHh = str;
            ((sq)localObject).dHg.dHi = paramAnonymousBitmap.dHi;
            ((sq)localObject).dHg.dHj = paramAnonymousBitmap.dHj;
            if (PluginScanTranslation.this.yiP.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((sq)localObject).dHg.dnh = ((int)((dk)PluginScanTranslation.this.yiP.get(Integer.valueOf(paramAnonymousInt))).eca);
            }
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            PluginScanTranslation.this.yiO.remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(120838);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            ad.printErrStackTrace("MicroMsg.PluginScanTranslation", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(120838);
      }
    };
    this.yiS = new com.tencent.mm.sdk.b.c() {};
    this.yiT = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sp paramAnonymoussp)
      {
        AppMethodBeat.i(120841);
        if (!bt.isNullOrNil(paramAnonymoussp.dHf.filePath)) {
          try
          {
            ad.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussp.dHf.filePath, Integer.valueOf(paramAnonymoussp.dHf.dlK) });
            Object localObject1 = ai.ee(paramAnonymoussp.dHf.filePath + i.aYp(paramAnonymoussp.dHf.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().awM((String)localObject1);
            if (localObject1 != null)
            {
              ad.i("MicroMsg.PluginScanTranslation", "already has translation result");
              localObject2 = ((fp)localObject1).field_resultFile;
              if (i.fv((String)localObject2))
              {
                localObject3 = new sq();
                ((sq)localObject3).dHg.dlK = paramAnonymoussp.dHf.dlK;
                ((sq)localObject3).dHg.dlh = true;
                ((sq)localObject3).dHg.dHh = ((String)localObject2);
                ((sq)localObject3).dHg.dHi = ((fp)localObject1).field_fromLang;
                ((sq)localObject3).dHg.dHj = ((fp)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                PluginScanTranslation.this.yiO.remove(Integer.valueOf(paramAnonymoussp.dHf.dlK));
                AppMethodBeat.o(120841);
                return true;
              }
              ad.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new dk();
            ((dk)localObject3).eca = a.Om(paramAnonymoussp.dHf.scene);
            PluginScanTranslation.this.yiP.put(Integer.valueOf(paramAnonymoussp.dHf.dlK), localObject3);
            ag localag = new ag();
            localag.itB = paramAnonymoussp.dHf.filePath;
            localag.yow = paramAnonymoussp.dHf.filePath;
            int i = Exif.fromFile(paramAnonymoussp.dHf.filePath).getOrientationInDegree();
            ad.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussp.dHf.filePath;
            final String str = m.awZ(paramAnonymoussp.dHf.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymoussp.dHf.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = com.tencent.mm.sdk.platformtools.g.a(localBitmap, i);
                localObject1 = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanTmpImgPath("jpg");
                com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localag.yow = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.yiO.put(Integer.valueOf(paramAnonymoussp.dHf.dlK), localag);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.yiQ.put(Integer.valueOf(paramAnonymoussp.dHf.dlK), Long.valueOf(l));
            ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(120840);
                if ((!bt.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.yiW.efM = (System.currentTimeMillis() - l);
                  ad.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.yiW.efM) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(120840);
                  return;
                  if (!bt.V(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ad.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new com.tencent.mm.plugin.scanner.model.j(this.yiY.dHf.scene, this.yiY.dHf.dlK, (int)i.aYo(this.yiZ), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymous2String, 0);
                    AppMethodBeat.o(120840);
                    return;
                  }
                  this.yiW.ecx = 3L;
                  this.yiW.efO = (System.currentTimeMillis() - l);
                  this.yiW.aLk();
                  PluginScanTranslation.this.yiP.remove(Integer.valueOf(this.yiY.dHf.dlK));
                  PluginScanTranslation.this.yiQ.remove(Integer.valueOf(this.yiY.dHf.dlK));
                  ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yiP.size()), Integer.valueOf(PluginScanTranslation.this.yiQ.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.yiY.dHf.dlK);
                  AppMethodBeat.o(120840);
                  return;
                  this.yiW.ecx = 3L;
                  this.yiW.efO = (System.currentTimeMillis() - l);
                  this.yiW.aLk();
                  PluginScanTranslation.this.yiP.remove(Integer.valueOf(this.yiY.dHf.dlK));
                  PluginScanTranslation.this.yiQ.remove(Integer.valueOf(this.yiY.dHf.dlK));
                  ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yiP.size()), Integer.valueOf(PluginScanTranslation.this.yiQ.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.yiY.dHf.dlK);
                }
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymoussp.dHf.dlK);
          }
        }
        AppMethodBeat.o(120841);
        return false;
      }
    };
    AppMethodBeat.o(120843);
  }
  
  private void sendTranslationFailEvent(int paramInt)
  {
    AppMethodBeat.i(120848);
    sq localsq = new sq();
    localsq.dHg.dlK = paramInt;
    localsq.dHg.dlh = false;
    if (this.yiO.containsKey(Integer.valueOf(paramInt))) {
      localsq.dHg.dnh = ((int)((dk)this.yiP.get(Integer.valueOf(paramInt))).eca);
    }
    com.tencent.mm.sdk.b.a.IbL.l(localsq);
    this.yiO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(120848);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return null;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String genScanTranslateBgImgPath(String paramString)
  {
    AppMethodBeat.i(120852);
    paramString = String.format("%s.%s", new Object[] { ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
    AppMethodBeat.o(120852);
    return paramString;
  }
  
  public String genTranslationResultImgPath(String paramString)
  {
    AppMethodBeat.i(120851);
    paramString = getTranslationResultDir() + String.format("%s_%d.%s", new Object[] { "translation", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(120851);
    return paramString;
  }
  
  public com.tencent.mm.plugin.scanner.util.j getTranslationRender()
  {
    return this.yiM;
  }
  
  public fp getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = ai.ee(paramString + i.aYp(paramString));
    ad.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().awM(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((e)com.tencent.mm.kernel.g.ad(e.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.f.b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.yiN == null) {
      this.yiN = new com.tencent.mm.plugin.scanner.f.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.scanner.f.b localb = this.yiN;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(120844);
    com.tencent.mm.sdk.b.a.IbL.b(this.yiT);
    com.tencent.mm.sdk.b.a.IbL.b(this.yiS);
    com.tencent.mm.kernel.g.aiU().a(294, this);
    i.aYu(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    com.tencent.mm.sdk.b.a.IbL.d(this.yiT);
    com.tencent.mm.sdk.b.a.IbL.d(this.yiS);
    com.tencent.mm.kernel.g.aiU().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(120849);
    ad.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 294)
    {
      int i = ((com.tencent.mm.plugin.scanner.model.j)paramn).dlK;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.scanner.model.j)paramn).ymP;
        if (paramString != null)
        {
          ad.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((com.tencent.mm.plugin.scanner.model.j)paramn).angle), Integer.valueOf(paramString.size()) });
          if (this.yiP.containsKey(Integer.valueOf(i))) {
            ((dk)this.yiP.get(Integer.valueOf(i))).efN = (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.j)paramn).ymQ);
          }
          if ((paramString.size() > 0) && (this.yiO.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ag)this.yiO.get(Integer.valueOf(i));
            ((ag)localObject).dHi = ((ccn)((com.tencent.mm.plugin.scanner.model.j)paramn).rr.hNL.hNQ).GWp;
            ((ag)localObject).dHj = ((com.tencent.mm.plugin.scanner.model.j)paramn).dKT();
            ((ag)localObject).hQG = ((ccn)((com.tencent.mm.plugin.scanner.model.j)paramn).rr.hNL.hNQ).GWr;
            if (this.yiP.containsKey(Integer.valueOf(i))) {
              ((dk)this.yiP.get(Integer.valueOf(i))).ecx = 1L;
            }
            com.tencent.mm.plugin.scanner.util.j localj = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender();
            float f = ((com.tencent.mm.plugin.scanner.model.j)paramn).angle;
            localObject = ((ag)localObject).yow;
            paramn = this.yiR;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramn != null))
            {
              localObject = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramn.c(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localj.yAb != 0) && (i != localj.yAb))
              {
                ad.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localj.yAb), Integer.valueOf(i) });
                localj.dMQ();
              }
              localj.yAb = i;
              localj.yAc = paramn;
              localj.yAd = new j.a(localj, i, paramString, f, (Bitmap)localObject);
              localj.yAd.x(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.yiP.containsKey(Integer.valueOf(i))) && (this.yiQ.containsKey(Integer.valueOf(i)))) {
            ((dk)this.yiP.get(Integer.valueOf(i))).efO = (System.currentTimeMillis() - ((Long)this.yiQ.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.yiP.containsKey(Integer.valueOf(i))) && (this.yiQ.containsKey(Integer.valueOf(i))))
      {
        ((dk)this.yiP.get(Integer.valueOf(i))).efO = (System.currentTimeMillis() - ((Long)this.yiQ.get(Integer.valueOf(i))).longValue());
        ((dk)this.yiP.get(Integer.valueOf(i))).ecx = 5L;
        ((dk)this.yiP.get(Integer.valueOf(i))).aLk();
        this.yiP.remove(Integer.valueOf(i));
        this.yiQ.remove(Integer.valueOf(i));
        ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.yiP.size()), Integer.valueOf(this.yiQ.size()) });
      }
      sendTranslationFailEvent(i);
    }
    AppMethodBeat.o(120849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanTranslation
 * JD-Core Version:    0.7.0.1
 */