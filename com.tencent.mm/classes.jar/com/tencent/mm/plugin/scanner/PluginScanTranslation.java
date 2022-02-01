package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.sd.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.h;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.a;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.g, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, d
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j wVj;
  private com.tencent.mm.plugin.scanner.f.b wVk;
  private HashMap<Integer, ad> wVl;
  private HashMap<Integer, cr> wVm;
  private HashMap<Integer, Long> wVn;
  private j.b wVo;
  private com.tencent.mm.sdk.b.c<au> wVp;
  private com.tencent.mm.sdk.b.c<sd> wVq;
  
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
    this.wVj = new j();
    this.wVl = new HashMap();
    this.wVm = new HashMap();
    this.wVn = new HashMap();
    this.wVo = new j.b()
    {
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.wVl.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.wVm.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.wVn.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((cr)PluginScanTranslation.this.wVm.get(Integer.valueOf(paramAnonymousInt))).dQs = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.wVn.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((cr)PluginScanTranslation.this.wVm.get(Integer.valueOf(paramAnonymousInt))).aHZ();
            PluginScanTranslation.this.wVm.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.wVn.remove(Integer.valueOf(paramAnonymousInt));
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.wVm.size()), Integer.valueOf(PluginScanTranslation.this.wVn.size()) });
          }
          if (!com.tencent.mm.kernel.g.agM())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new com.tencent.mm.plugin.scanner.model.ac();
            paramAnonymousBitmap = (ad)PluginScanTranslation.this.wVl.get(Integer.valueOf(paramAnonymousInt));
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_originMD5 = ah.dg(paramAnonymousBitmap.iag + i.aSq(paramAnonymousBitmap.iag));
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_resultFile = str;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_fromLang = paramAnonymousBitmap.dvh;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_toLang = paramAnonymousBitmap.dvi;
            ((com.tencent.mm.plugin.scanner.model.ac)localObject).field_brand = paramAnonymousBitmap.hym;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a((com.tencent.mm.plugin.scanner.model.ac)localObject);
            localObject = new se();
            ((se)localObject).dvf.daq = paramAnonymousInt;
            ((se)localObject).dvf.cZP = true;
            ((se)localObject).dvf.dvg = str;
            ((se)localObject).dvf.dvh = paramAnonymousBitmap.dvh;
            ((se)localObject).dvf.dvi = paramAnonymousBitmap.dvi;
            if (PluginScanTranslation.this.wVm.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((se)localObject).dvf.dbL = ((int)((cr)PluginScanTranslation.this.wVm.get(Integer.valueOf(paramAnonymousInt))).dNc);
            }
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            PluginScanTranslation.this.wVl.remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(120838);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.PluginScanTranslation", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(120838);
      }
    };
    this.wVp = new com.tencent.mm.sdk.b.c() {};
    this.wVq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sd paramAnonymoussd)
      {
        AppMethodBeat.i(120841);
        if (!bs.isNullOrNil(paramAnonymoussd.dve.filePath)) {
          try
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymoussd.dve.filePath, Integer.valueOf(paramAnonymoussd.dve.daq) });
            Object localObject1 = ah.dg(paramAnonymoussd.dve.filePath + i.aSq(paramAnonymoussd.dve.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().arL((String)localObject1);
            if (localObject1 != null)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "already has translation result");
              localObject2 = ((ff)localObject1).field_resultFile;
              if (i.eA((String)localObject2))
              {
                localObject3 = new se();
                ((se)localObject3).dvf.daq = paramAnonymoussd.dve.daq;
                ((se)localObject3).dvf.cZP = true;
                ((se)localObject3).dvf.dvg = ((String)localObject2);
                ((se)localObject3).dvf.dvh = ((ff)localObject1).field_fromLang;
                ((se)localObject3).dvf.dvi = ((ff)localObject1).field_toLang;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                PluginScanTranslation.this.wVl.remove(Integer.valueOf(paramAnonymoussd.dve.daq));
                AppMethodBeat.o(120841);
                return true;
              }
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new cr();
            ((cr)localObject3).dNc = a.MK(paramAnonymoussd.dve.scene);
            PluginScanTranslation.this.wVm.put(Integer.valueOf(paramAnonymoussd.dve.daq), localObject3);
            ad localad = new ad();
            localad.iag = paramAnonymoussd.dve.filePath;
            localad.xax = paramAnonymoussd.dve.filePath;
            int i = Exif.fromFile(paramAnonymoussd.dve.filePath).getOrientationInDegree();
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymoussd.dve.filePath;
            final String str = m.arY(paramAnonymoussd.dve.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymoussd.dve.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = com.tencent.mm.sdk.platformtools.f.a(localBitmap, i);
                localObject1 = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanTmpImgPath("jpg");
                com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localad.xax = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.wVl.put(Integer.valueOf(paramAnonymoussd.dve.daq), localad);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.wVn.put(Integer.valueOf(paramAnonymoussd.dve.daq), Long.valueOf(l));
            ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(120840);
                if ((!bs.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.wVt.dQq = (System.currentTimeMillis() - l);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.wVt.dQq) });
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(120840);
                  return;
                  if (!bs.T(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new h(this.wVv.dve.scene, this.wVv.dve.daq, (int)i.aSp(this.wVw), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.agi().a(paramAnonymous2String, 0);
                    AppMethodBeat.o(120840);
                    return;
                  }
                  this.wVt.dNi = 3L;
                  this.wVt.dQs = (System.currentTimeMillis() - l);
                  this.wVt.aHZ();
                  PluginScanTranslation.this.wVm.remove(Integer.valueOf(this.wVv.dve.daq));
                  PluginScanTranslation.this.wVn.remove(Integer.valueOf(this.wVv.dve.daq));
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.wVm.size()), Integer.valueOf(PluginScanTranslation.this.wVn.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.wVv.dve.daq);
                  AppMethodBeat.o(120840);
                  return;
                  this.wVt.dNi = 3L;
                  this.wVt.dQs = (System.currentTimeMillis() - l);
                  this.wVt.aHZ();
                  PluginScanTranslation.this.wVm.remove(Integer.valueOf(this.wVv.dve.daq));
                  PluginScanTranslation.this.wVn.remove(Integer.valueOf(this.wVv.dve.daq));
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.wVm.size()), Integer.valueOf(PluginScanTranslation.this.wVn.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.wVv.dve.daq);
                }
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymoussd.dve.daq);
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
    se localse = new se();
    localse.dvf.daq = paramInt;
    localse.dvf.cZP = false;
    if (this.wVl.containsKey(Integer.valueOf(paramInt))) {
      localse.dvf.dbL = ((int)((cr)this.wVm.get(Integer.valueOf(paramInt))).dNc);
    }
    com.tencent.mm.sdk.b.a.GpY.l(localse);
    this.wVl.remove(Integer.valueOf(paramInt));
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
  
  public j getTranslationRender()
  {
    return this.wVj;
  }
  
  public ff getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = ah.dg(paramString + i.aSq(paramString));
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().arL(str);
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
    com.tencent.mm.kernel.g.agP().afT();
    if (this.wVk == null) {
      this.wVk = new com.tencent.mm.plugin.scanner.f.b(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.scanner.f.b localb = this.wVk;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(120844);
    com.tencent.mm.sdk.b.a.GpY.b(this.wVq);
    com.tencent.mm.sdk.b.a.GpY.b(this.wVp);
    com.tencent.mm.kernel.g.agi().a(294, this);
    i.aSv(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    com.tencent.mm.sdk.b.a.GpY.d(this.wVq);
    com.tencent.mm.sdk.b.a.GpY.d(this.wVp);
    com.tencent.mm.kernel.g.agi().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(120849);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 294)
    {
      int i = ((h)paramn).daq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((h)paramn).wYW;
        if (paramString != null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((h)paramn).angle), Integer.valueOf(paramString.size()) });
          if (this.wVm.containsKey(Integer.valueOf(i))) {
            ((cr)this.wVm.get(Integer.valueOf(i))).dQr = (System.currentTimeMillis() - ((h)paramn).wYX);
          }
          if ((paramString.size() > 0) && (this.wVl.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ad)this.wVl.get(Integer.valueOf(i));
            ((ad)localObject).dvh = ((bxw)((h)paramn).rr.hvs.hvw).FmG;
            ((ad)localObject).dvi = ((h)paramn).dzv();
            ((ad)localObject).hym = ((bxw)((h)paramn).rr.hvs.hvw).FmI;
            if (this.wVm.containsKey(Integer.valueOf(i))) {
              ((cr)this.wVm.get(Integer.valueOf(i))).dNi = 1L;
            }
            j localj = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender();
            float f = ((h)paramn).angle;
            localObject = ((ad)localObject).xax;
            paramn = this.wVo;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramn != null))
            {
              localObject = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramn.c(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localj.xma != 0) && (i != localj.xma))
              {
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localj.xma), Integer.valueOf(i) });
                localj.dBs();
              }
              localj.xma = i;
              localj.xmb = paramn;
              localj.xmc = new j.a(localj, i, paramString, f, (Bitmap)localObject);
              localj.xmc.x(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.wVm.containsKey(Integer.valueOf(i))) && (this.wVn.containsKey(Integer.valueOf(i)))) {
            ((cr)this.wVm.get(Integer.valueOf(i))).dQs = (System.currentTimeMillis() - ((Long)this.wVn.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.wVm.containsKey(Integer.valueOf(i))) && (this.wVn.containsKey(Integer.valueOf(i))))
      {
        ((cr)this.wVm.get(Integer.valueOf(i))).dQs = (System.currentTimeMillis() - ((Long)this.wVn.get(Integer.valueOf(i))).longValue());
        ((cr)this.wVm.get(Integer.valueOf(i))).dNi = 5L;
        ((cr)this.wVm.get(Integer.valueOf(i))).aHZ();
        this.wVm.remove(Integer.valueOf(i));
        this.wVn.remove(Integer.valueOf(i));
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.wVm.size()), Integer.valueOf(this.wVn.size()) });
      }
      sendTranslationFailEvent(i);
    }
    AppMethodBeat.o(120849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanTranslation
 * JD-Core Version:    0.7.0.1
 */