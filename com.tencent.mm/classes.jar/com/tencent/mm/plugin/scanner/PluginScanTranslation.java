package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.ru.a;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.h;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.a;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.protocal.protobuf.btf;
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
  implements com.tencent.mm.al.g, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j vLi;
  private com.tencent.mm.plugin.scanner.e.b vLj;
  private HashMap<Integer, ab> vLk;
  private HashMap<Integer, be> vLl;
  private HashMap<Integer, Long> vLm;
  private j.b vLn;
  private com.tencent.mm.sdk.b.c<at> vLo;
  private com.tencent.mm.sdk.b.c<ru> vLp;
  
  static
  {
    AppMethodBeat.i(120855);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.e.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(120855);
  }
  
  public PluginScanTranslation()
  {
    AppMethodBeat.i(120843);
    this.vLi = new j();
    this.vLk = new HashMap();
    this.vLl = new HashMap();
    this.vLm = new HashMap();
    this.vLn = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.vLk.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.vLl.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.vLm.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((be)PluginScanTranslation.this.vLl.get(Integer.valueOf(paramAnonymousInt))).dOB = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.vLm.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((be)PluginScanTranslation.this.vLl.get(Integer.valueOf(paramAnonymousInt))).aBj();
            PluginScanTranslation.this.vLl.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.vLm.remove(Integer.valueOf(paramAnonymousInt));
            ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.vLl.size()), Integer.valueOf(PluginScanTranslation.this.vLm.size()) });
          }
          if (!com.tencent.mm.kernel.g.afw())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new aa();
            paramAnonymousBitmap = (ab)PluginScanTranslation.this.vLk.get(Integer.valueOf(paramAnonymousInt));
            ((aa)localObject).field_originMD5 = ai.du(paramAnonymousBitmap.hzF + i.aMO(paramAnonymousBitmap.hzF));
            ((aa)localObject).field_resultFile = str;
            ((aa)localObject).field_fromLang = paramAnonymousBitmap.dxu;
            ((aa)localObject).field_toLang = paramAnonymousBitmap.dxv;
            ad.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((aa)localObject);
            localObject = new rv();
            ((rv)localObject).dxs.dcS = paramAnonymousInt;
            ((rv)localObject).dxs.dcq = true;
            ((rv)localObject).dxs.dxt = str;
            ((rv)localObject).dxs.dxu = paramAnonymousBitmap.dxu;
            ((rv)localObject).dxs.dxv = paramAnonymousBitmap.dxv;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            PluginScanTranslation.this.vLk.remove(Integer.valueOf(paramAnonymousInt));
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
    this.vLo = new com.tencent.mm.sdk.b.c() {};
    this.vLp = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ru paramAnonymousru)
      {
        AppMethodBeat.i(120841);
        if (!bt.isNullOrNil(paramAnonymousru.dxr.filePath)) {
          try
          {
            ad.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymousru.dxr.filePath, Integer.valueOf(paramAnonymousru.dxr.dcS) });
            Object localObject1 = ai.du(paramAnonymousru.dxr.filePath + i.aMO(paramAnonymousru.dxr.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().amC((String)localObject1);
            if (localObject1 != null)
            {
              ad.i("MicroMsg.PluginScanTranslation", "already has translation result");
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
                PluginScanTranslation.this.vLk.remove(Integer.valueOf(paramAnonymousru.dxr.dcS));
                AppMethodBeat.o(120841);
                return true;
              }
              ad.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new be();
            ((be)localObject3).dMB = PluginScanTranslation.access$400(PluginScanTranslation.this, paramAnonymousru.dxr.scene);
            PluginScanTranslation.this.vLl.put(Integer.valueOf(paramAnonymousru.dxr.dcS), localObject3);
            ab localab = new ab();
            localab.hzF = paramAnonymousru.dxr.filePath;
            localab.vPQ = paramAnonymousru.dxr.filePath;
            int i = Exif.fromFile(paramAnonymousru.dxr.filePath).getOrientationInDegree();
            ad.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymousru.dxr.filePath;
            final String str = m.amP(paramAnonymousru.dxr.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousru.dxr.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = com.tencent.mm.sdk.platformtools.f.a(localBitmap, i);
                localObject1 = ((d)com.tencent.mm.kernel.g.ad(d.class)).genScanTmpImgPath("jpg");
                com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localab.vPQ = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.vLk.put(Integer.valueOf(paramAnonymousru.dxr.dcS), localab);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.vLm.put(Integer.valueOf(paramAnonymousru.dxr.dcS), Long.valueOf(l));
            ((d)com.tencent.mm.kernel.g.ad(d.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(120840);
                if ((!bt.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.vLs.dOz = (System.currentTimeMillis() - l);
                  ad.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.vLs.dOz) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(120840);
                  return;
                  if (!bt.T(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    ad.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new h(this.vLu.dxr.scene, this.vLu.dxr.dcS, (int)i.aMN(this.vLv), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymous2String, 0);
                    AppMethodBeat.o(120840);
                    return;
                  }
                  this.vLs.dMH = 3L;
                  this.vLs.dOB = (System.currentTimeMillis() - l);
                  this.vLs.aBj();
                  PluginScanTranslation.this.vLl.remove(Integer.valueOf(this.vLu.dxr.dcS));
                  PluginScanTranslation.this.vLm.remove(Integer.valueOf(this.vLu.dxr.dcS));
                  ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.vLl.size()), Integer.valueOf(PluginScanTranslation.this.vLm.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.vLu.dxr.dcS);
                  AppMethodBeat.o(120840);
                  return;
                  this.vLs.dMH = 3L;
                  this.vLs.dOB = (System.currentTimeMillis() - l);
                  this.vLs.aBj();
                  PluginScanTranslation.this.vLl.remove(Integer.valueOf(this.vLu.dxr.dcS));
                  PluginScanTranslation.this.vLm.remove(Integer.valueOf(this.vLu.dxr.dcS));
                  ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.vLl.size()), Integer.valueOf(PluginScanTranslation.this.vLm.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.vLu.dxr.dcS);
                }
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousru.dxr.dcS);
          }
        }
        AppMethodBeat.o(120841);
        return false;
      }
    };
    AppMethodBeat.o(120843);
  }
  
  private int getSource(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 4;
    case 2: 
      return 5;
    case 3: 
      return 6;
    case 4: 
      return 7;
    case 5: 
      return 8;
    }
    return 9;
  }
  
  private void sendTranslationFailEvent(int paramInt)
  {
    AppMethodBeat.i(120848);
    rv localrv = new rv();
    localrv.dxs.dcS = paramInt;
    localrv.dxs.dcq = false;
    com.tencent.mm.sdk.b.a.ESL.l(localrv);
    this.vLk.remove(Integer.valueOf(paramInt));
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
    paramString = String.format("%s.%s", new Object[] { ((d)com.tencent.mm.kernel.g.ad(d.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
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
    return this.vLi;
  }
  
  public fb getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = ai.du(paramString + i.aMO(paramString));
    ad.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().amC(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((d)com.tencent.mm.kernel.g.ad(d.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.e.b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.vLj == null) {
      this.vLj = new com.tencent.mm.plugin.scanner.e.b(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.scanner.e.b localb = this.vLj;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(120844);
    com.tencent.mm.sdk.b.a.ESL.b(this.vLp);
    com.tencent.mm.sdk.b.a.ESL.b(this.vLo);
    com.tencent.mm.kernel.g.aeS().a(294, this);
    i.aMT(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    com.tencent.mm.sdk.b.a.ESL.d(this.vLp);
    com.tencent.mm.sdk.b.a.ESL.d(this.vLo);
    com.tencent.mm.kernel.g.aeS().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(120849);
    ad.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 294)
    {
      int i = ((h)paramn).dcS;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((h)paramn).vOA;
        if (paramString != null)
        {
          ad.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((h)paramn).angle), Integer.valueOf(paramString.size()) });
          if (this.vLl.containsKey(Integer.valueOf(i))) {
            ((be)this.vLl.get(Integer.valueOf(i))).dOA = (System.currentTimeMillis() - ((h)paramn).vOB);
          }
          if ((paramString.size() > 0) && (this.vLk.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ab)this.vLk.get(Integer.valueOf(i));
            ((ab)localObject).dxu = ((btf)((h)paramn).rr.gUT.gUX).DQp;
            ((ab)localObject).dxv = ((h)paramn).dlt();
            if (this.vLl.containsKey(Integer.valueOf(i))) {
              ((be)this.vLl.get(Integer.valueOf(i))).dMH = 1L;
            }
            j localj = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender();
            float f = ((h)paramn).angle;
            localObject = ((ab)localObject).vPQ;
            paramn = this.vLn;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramn != null))
            {
              localObject = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramn.c(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localj.waU != 0) && (i != localj.waU))
              {
                ad.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localj.waU), Integer.valueOf(i) });
                localj.dnk();
              }
              localj.waU = i;
              localj.waV = paramn;
              localj.waW = new j.a(localj, i, paramString, f, (Bitmap)localObject);
              localj.waW.v(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.vLl.containsKey(Integer.valueOf(i))) && (this.vLm.containsKey(Integer.valueOf(i)))) {
            ((be)this.vLl.get(Integer.valueOf(i))).dOB = (System.currentTimeMillis() - ((Long)this.vLm.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.vLl.containsKey(Integer.valueOf(i))) && (this.vLm.containsKey(Integer.valueOf(i))))
      {
        ((be)this.vLl.get(Integer.valueOf(i))).dOB = (System.currentTimeMillis() - ((Long)this.vLm.get(Integer.valueOf(i))).longValue());
        ((be)this.vLl.get(Integer.valueOf(i))).dMH = 5L;
        ((be)this.vLl.get(Integer.valueOf(i))).aBj();
        this.vLl.remove(Integer.valueOf(i));
        this.vLm.remove(Integer.valueOf(i));
        ad.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.vLl.size()), Integer.valueOf(this.vLm.size()) });
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