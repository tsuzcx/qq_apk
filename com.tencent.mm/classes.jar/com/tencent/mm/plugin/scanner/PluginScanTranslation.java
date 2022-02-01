package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.a;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.f, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, e
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j yyE;
  private com.tencent.mm.plugin.scanner.f.b yyF;
  private HashMap<Integer, ah> yyG;
  private HashMap<Integer, dm> yyH;
  private HashMap<Integer, Long> yyI;
  private j.b yyJ;
  private com.tencent.mm.sdk.b.c<aw> yyK;
  private com.tencent.mm.sdk.b.c<sq> yyL;
  
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
    this.yyE = new j();
    this.yyG = new HashMap();
    this.yyH = new HashMap();
    this.yyI = new HashMap();
    this.yyJ = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.yyG.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.yyH.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.yyI.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((dm)PluginScanTranslation.this.yyH.get(Integer.valueOf(paramAnonymousInt))).ehz = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.yyI.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((dm)PluginScanTranslation.this.yyH.get(Integer.valueOf(paramAnonymousInt))).aLH();
            PluginScanTranslation.this.yyH.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.yyI.remove(Integer.valueOf(paramAnonymousInt));
            ae.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yyH.size()), Integer.valueOf(PluginScanTranslation.this.yyI.size()) });
          }
          if (!com.tencent.mm.kernel.g.ajM())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            h.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new ag();
            paramAnonymousBitmap = (ah)PluginScanTranslation.this.yyG.get(Integer.valueOf(paramAnonymousInt));
            ((ag)localObject).field_originMD5 = aj.ej(paramAnonymousBitmap.iwv + o.aZS(paramAnonymousBitmap.iwv));
            ((ag)localObject).field_resultFile = str;
            ((ag)localObject).field_fromLang = paramAnonymousBitmap.dIo;
            ((ag)localObject).field_toLang = paramAnonymousBitmap.dIp;
            ((ag)localObject).field_brand = paramAnonymousBitmap.hTy;
            ae.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((ag)localObject);
            localObject = new sr();
            ((sr)localObject).dIm.dmM = paramAnonymousInt;
            ((sr)localObject).dIm.dmj = true;
            ((sr)localObject).dIm.dIn = str;
            ((sr)localObject).dIm.dIo = paramAnonymousBitmap.dIo;
            ((sr)localObject).dIm.dIp = paramAnonymousBitmap.dIp;
            if (PluginScanTranslation.this.yyH.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((sr)localObject).dIm.doj = ((int)((dm)PluginScanTranslation.this.yyH.get(Integer.valueOf(paramAnonymousInt))).edv);
            }
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            PluginScanTranslation.this.yyG.remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(120838);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            ae.printErrStackTrace("MicroMsg.PluginScanTranslation", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(120838);
      }
    };
    this.yyK = new com.tencent.mm.sdk.b.c() {};
    this.yyL = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sq paramAnonymoussq)
      {
        AppMethodBeat.i(120841);
        if (!bu.isNullOrNil(paramAnonymoussq.dIl.filePath)) {
          try
          {
            ae.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussq.dIl.filePath, Integer.valueOf(paramAnonymoussq.dIl.dmM) });
            Object localObject1 = aj.ej(paramAnonymoussq.dIl.filePath + o.aZS(paramAnonymoussq.dIl.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().ayb((String)localObject1);
            if (localObject1 != null)
            {
              ae.i("MicroMsg.PluginScanTranslation", "already has translation result");
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
                PluginScanTranslation.this.yyG.remove(Integer.valueOf(paramAnonymoussq.dIl.dmM));
                AppMethodBeat.o(120841);
                return true;
              }
              ae.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new dm();
            ((dm)localObject3).edv = a.OS(paramAnonymoussq.dIl.scene);
            PluginScanTranslation.this.yyH.put(Integer.valueOf(paramAnonymoussq.dIl.dmM), localObject3);
            ah localah = new ah();
            localah.iwv = paramAnonymoussq.dIl.filePath;
            localah.yEv = paramAnonymoussq.dIl.filePath;
            int i = Exif.fromFile(paramAnonymoussq.dIl.filePath).getOrientationInDegree();
            ae.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussq.dIl.filePath;
            final String str = m.ayo(paramAnonymoussq.dIl.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = h.decodeFile(paramAnonymoussq.dIl.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = h.a(localBitmap, i);
                localObject1 = ((f)com.tencent.mm.kernel.g.ad(f.class)).genScanTmpImgPath("jpg");
                h.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localah.yEv = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.yyG.put(Integer.valueOf(paramAnonymoussq.dIl.dmM), localah);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.yyI.put(Integer.valueOf(paramAnonymoussq.dIl.dmM), Long.valueOf(l));
            ((f)com.tencent.mm.kernel.g.ad(f.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(120840);
                if ((!bu.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.yyO.ehx = (System.currentTimeMillis() - l);
                  ae.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.yyO.ehx) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(120840);
                  return;
                  if (!bu.V(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ae.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new k(this.yyQ.dIl.scene, this.yyQ.dIl.dmM, (int)o.aZR(this.yyR), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymous2String, 0);
                    AppMethodBeat.o(120840);
                    return;
                  }
                  this.yyO.edS = 3L;
                  this.yyO.ehz = (System.currentTimeMillis() - l);
                  this.yyO.aLH();
                  PluginScanTranslation.this.yyH.remove(Integer.valueOf(this.yyQ.dIl.dmM));
                  PluginScanTranslation.this.yyI.remove(Integer.valueOf(this.yyQ.dIl.dmM));
                  ae.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yyH.size()), Integer.valueOf(PluginScanTranslation.this.yyI.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.yyQ.dIl.dmM);
                  AppMethodBeat.o(120840);
                  return;
                  this.yyO.edS = 3L;
                  this.yyO.ehz = (System.currentTimeMillis() - l);
                  this.yyO.aLH();
                  PluginScanTranslation.this.yyH.remove(Integer.valueOf(this.yyQ.dIl.dmM));
                  PluginScanTranslation.this.yyI.remove(Integer.valueOf(this.yyQ.dIl.dmM));
                  ae.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.yyH.size()), Integer.valueOf(PluginScanTranslation.this.yyI.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.yyQ.dIl.dmM);
                }
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymoussq.dIl.dmM);
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
    sr localsr = new sr();
    localsr.dIm.dmM = paramInt;
    localsr.dIm.dmj = false;
    if (this.yyG.containsKey(Integer.valueOf(paramInt))) {
      localsr.dIm.doj = ((int)((dm)this.yyH.get(Integer.valueOf(paramInt))).edv);
    }
    com.tencent.mm.sdk.b.a.IvT.l(localsr);
    this.yyG.remove(Integer.valueOf(paramInt));
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
    paramString = String.format("%s.%s", new Object[] { ((f)com.tencent.mm.kernel.g.ad(f.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
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
  
  public j getTranslationRender()
  {
    return this.yyE;
  }
  
  public fp getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = aj.ej(paramString + o.aZS(paramString));
    ae.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().ayb(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((f)com.tencent.mm.kernel.g.ad(f.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.f.b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.yyF == null) {
      this.yyF = new com.tencent.mm.plugin.scanner.f.b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.scanner.f.b localb = this.yyF;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(120844);
    com.tencent.mm.sdk.b.a.IvT.b(this.yyL);
    com.tencent.mm.sdk.b.a.IvT.b(this.yyK);
    com.tencent.mm.kernel.g.ajj().a(294, this);
    o.aZX(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    com.tencent.mm.sdk.b.a.IvT.d(this.yyL);
    com.tencent.mm.sdk.b.a.IvT.d(this.yyK);
    com.tencent.mm.kernel.g.ajj().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(120849);
    ae.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 294)
    {
      int i = ((k)paramn).dmM;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((k)paramn).yCO;
        if (paramString != null)
        {
          ae.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((k)paramn).angle), Integer.valueOf(paramString.size()) });
          if (this.yyH.containsKey(Integer.valueOf(i))) {
            ((dm)this.yyH.get(Integer.valueOf(i))).ehy = (System.currentTimeMillis() - ((k)paramn).yCP);
          }
          if ((paramString.size() > 0) && (this.yyG.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ah)this.yyG.get(Integer.valueOf(i));
            ((ah)localObject).dIo = ((cdh)((k)paramn).rr.hQE.hQJ).HpP;
            ((ah)localObject).dIp = ((k)paramn).dOl();
            ((ah)localObject).hTy = ((cdh)((k)paramn).rr.hQE.hQJ).HpR;
            if (this.yyH.containsKey(Integer.valueOf(i))) {
              ((dm)this.yyH.get(Integer.valueOf(i))).edS = 1L;
            }
            j localj = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender();
            float f = ((k)paramn).angle;
            localObject = ((ah)localObject).yEv;
            paramn = this.yyJ;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramn != null))
            {
              localObject = h.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramn.c(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localj.yQb != 0) && (i != localj.yQb))
              {
                ae.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localj.yQb), Integer.valueOf(i) });
                localj.dQj();
              }
              localj.yQb = i;
              localj.yQc = paramn;
              localj.yQd = new j.a(localj, i, paramString, f, (Bitmap)localObject);
              localj.yQd.x(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.yyH.containsKey(Integer.valueOf(i))) && (this.yyI.containsKey(Integer.valueOf(i)))) {
            ((dm)this.yyH.get(Integer.valueOf(i))).ehz = (System.currentTimeMillis() - ((Long)this.yyI.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.yyH.containsKey(Integer.valueOf(i))) && (this.yyI.containsKey(Integer.valueOf(i))))
      {
        ((dm)this.yyH.get(Integer.valueOf(i))).ehz = (System.currentTimeMillis() - ((Long)this.yyI.get(Integer.valueOf(i))).longValue());
        ((dm)this.yyH.get(Integer.valueOf(i))).edS = 5L;
        ((dm)this.yyH.get(Integer.valueOf(i))).aLH();
        this.yyH.remove(Integer.valueOf(i));
        this.yyI.remove(Integer.valueOf(i));
        ae.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.yyH.size()), Integer.valueOf(this.yyI.size()) });
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