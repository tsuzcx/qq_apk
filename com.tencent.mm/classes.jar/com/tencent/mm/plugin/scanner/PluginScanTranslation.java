package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.bg;
import com.tencent.mm.autogen.a.wg;
import com.tencent.mm.autogen.a.wg.a;
import com.tencent.mm.autogen.a.wh;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.ld;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.scanner.model.aq;
import com.tencent.mm.plugin.scanner.model.ar;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.plugin.scanner.util.n.b;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, f
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n OHm;
  private com.tencent.mm.plugin.scanner.i.b OHn;
  private HashMap<Integer, ar> OHo;
  private HashMap<Integer, ld> OHp;
  private HashMap<Integer, Long> OHq;
  private n.b OHr;
  private IListener<bg> OHs;
  private IListener<wg> OHt;
  
  static
  {
    AppMethodBeat.i(120855);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.scanner.i.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(120855);
  }
  
  public PluginScanTranslation()
  {
    AppMethodBeat.i(120843);
    this.OHm = new n();
    this.OHo = new HashMap();
    this.OHp = new HashMap();
    this.OHq = new HashMap();
    this.OHr = new n.b()
    {
      public final void f(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if ((paramAnonymousBitmap != null) && (PluginScanTranslation.this.OHo.containsKey(Integer.valueOf(paramAnonymousInt))))
        {
          if ((PluginScanTranslation.this.OHp.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.OHq.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((ld)PluginScanTranslation.this.OHp.get(Integer.valueOf(paramAnonymousInt))).iPP = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.OHq.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((ld)PluginScanTranslation.this.OHp.get(Integer.valueOf(paramAnonymousInt))).bMH();
            PluginScanTranslation.this.OHp.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.OHq.remove(Integer.valueOf(paramAnonymousInt));
            Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.OHp.size()), Integer.valueOf(PluginScanTranslation.this.OHq.size()) });
          }
          if (!com.tencent.mm.kernel.h.baz())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new aq();
            paramAnonymousBitmap = (ar)PluginScanTranslation.this.OHo.get(Integer.valueOf(paramAnonymousInt));
            ((aq)localObject).field_originMD5 = MD5Util.getMD5String(paramAnonymousBitmap.pax + y.bEm(paramAnonymousBitmap.pax));
            ((aq)localObject).field_resultFile = str;
            ((aq)localObject).field_fromLang = paramAnonymousBitmap.hZU;
            ((aq)localObject).field_toLang = paramAnonymousBitmap.hZV;
            ((aq)localObject).field_brand = paramAnonymousBitmap.brand;
            Log.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().a((aq)localObject);
            localObject = new wh();
            ((wh)localObject).hZS.hBm = paramAnonymousInt;
            ((wh)localObject).hZS.hAE = true;
            ((wh)localObject).hZS.hZT = str;
            ((wh)localObject).hZS.hZU = paramAnonymousBitmap.hZU;
            ((wh)localObject).hZS.hZV = paramAnonymousBitmap.hZV;
            if (PluginScanTranslation.this.OHp.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((wh)localObject).hZS.source = ((int)((ld)PluginScanTranslation.this.OHp.get(Integer.valueOf(paramAnonymousInt))).iOd);
            }
            ((wh)localObject).publish();
            PluginScanTranslation.this.OHo.remove(Integer.valueOf(paramAnonymousInt));
            AppMethodBeat.o(120838);
            return;
          }
          catch (IOException paramAnonymousBitmap)
          {
            Log.printErrStackTrace("MicroMsg.PluginScanTranslation", paramAnonymousBitmap, "save translate result file error", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(120838);
      }
    };
    this.OHs = new IListener(com.tencent.mm.app.f.hfK) {};
    this.OHt = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(wg paramAnonymouswg)
      {
        AppMethodBeat.i(120841);
        if (!Util.isNullOrNil(paramAnonymouswg.hZR.filePath)) {
          try
          {
            Log.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymouswg.hZR.filePath, Integer.valueOf(paramAnonymouswg.hZR.hBm) });
            Object localObject1 = MD5Util.getMD5String(paramAnonymouswg.hZR.filePath + y.bEm(paramAnonymouswg.hZR.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().aUV((String)localObject1);
            if (localObject1 != null)
            {
              Log.i("MicroMsg.PluginScanTranslation", "already has translation result");
              localObject2 = ((gy)localObject1).field_resultFile;
              if (y.ZC((String)localObject2))
              {
                localObject3 = new wh();
                ((wh)localObject3).hZS.hBm = paramAnonymouswg.hZR.hBm;
                ((wh)localObject3).hZS.hAE = true;
                ((wh)localObject3).hZS.hZT = ((String)localObject2);
                ((wh)localObject3).hZS.hZU = ((gy)localObject1).field_fromLang;
                ((wh)localObject3).hZS.hZV = ((gy)localObject1).field_toLang;
                ((wh)localObject3).publish();
                PluginScanTranslation.this.OHo.remove(Integer.valueOf(paramAnonymouswg.hZR.hBm));
                AppMethodBeat.o(120841);
                return true;
              }
              Log.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new ld();
            ((ld)localObject3).iOd = b.ahB(paramAnonymouswg.hZR.scene);
            PluginScanTranslation.this.OHp.put(Integer.valueOf(paramAnonymouswg.hZR.hBm), localObject3);
            ar localar = new ar();
            localar.pax = paramAnonymouswg.hZR.filePath;
            localar.OTK = paramAnonymouswg.hZR.filePath;
            int i = Exif.fromFile(paramAnonymouswg.hZR.filePath).getOrientationInDegree();
            Log.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymouswg.hZR.filePath;
            final String str = m.aVi(paramAnonymouswg.hZR.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = BitmapUtil.decodeFile(paramAnonymouswg.hZR.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = BitmapUtil.rotate(localBitmap, i);
                localObject1 = ((g)com.tencent.mm.kernel.h.az(g.class)).genScanTmpImgPath("jpg");
                BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localar.OTK = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.OHo.put(Integer.valueOf(paramAnonymouswg.hZR.hBm), localar);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.OHq.put(Integer.valueOf(paramAnonymouswg.hZR.hBm), Long.valueOf(l));
            m.a(str, (String)localObject1, com.tencent.mm.g.a.MediaType_IMAGE, new m.a()
            {
              public final void a(String paramAnonymous2String, m.b paramAnonymous2b)
              {
                AppMethodBeat.i(313226);
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.OHw.iYN = (System.currentTimeMillis() - l);
                  Log.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.OHw.iYN) });
                  this.OHw.ua(paramAnonymous2b.fileId);
                  this.OHw.ub(paramAnonymous2b.aeskey);
                }
                switch (paramAnonymous2b.errCode)
                {
                default: 
                  this.OHw.iOQ = 3L;
                  this.OHw.iPP = (System.currentTimeMillis() - l);
                  this.OHw.bMH();
                  PluginScanTranslation.this.OHp.remove(Integer.valueOf(this.OHy.hZR.hBm));
                  PluginScanTranslation.this.OHq.remove(Integer.valueOf(this.OHy.hZR.hBm));
                  Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d, errCode: %s", new Object[] { Integer.valueOf(PluginScanTranslation.this.OHp.size()), Integer.valueOf(PluginScanTranslation.this.OHq.size()), Integer.valueOf(paramAnonymous2b.errCode) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.OHy.hZR.hBm);
                  AppMethodBeat.o(313226);
                  return;
                }
                if (!Util.isNullOrNil(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                {
                  Log.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                  paramAnonymous2String = new com.tencent.mm.plugin.scanner.model.s(this.OHy.hZR.scene, this.OHy.hZR.hBm, (int)y.bEl(this.OHz), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymous2String, 0);
                  AppMethodBeat.o(313226);
                  return;
                }
                this.OHw.iOQ = 3L;
                this.OHw.iPP = (System.currentTimeMillis() - l);
                this.OHw.bMH();
                PluginScanTranslation.this.OHp.remove(Integer.valueOf(this.OHy.hZR.hBm));
                PluginScanTranslation.this.OHq.remove(Integer.valueOf(this.OHy.hZR.hBm));
                Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.OHp.size()), Integer.valueOf(PluginScanTranslation.this.OHq.size()) });
                PluginScanTranslation.access$300(PluginScanTranslation.this, this.OHy.hZR.hBm);
                AppMethodBeat.o(313226);
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymouswg.hZR.hBm);
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
    wh localwh = new wh();
    localwh.hZS.hBm = paramInt;
    localwh.hZS.hAE = false;
    if (this.OHo.containsKey(Integer.valueOf(paramInt)))
    {
      ld localld = (ld)this.OHp.get(Integer.valueOf(paramInt));
      if (localld != null) {
        localwh.hZS.source = ((int)localld.iOd);
      }
    }
    localwh.publish();
    this.OHo.remove(Integer.valueOf(paramInt));
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
    paramString = String.format("%s.%s", new Object[] { ((g)com.tencent.mm.kernel.h.az(g.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
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
  
  public n getTranslationRender()
  {
    return this.OHm;
  }
  
  public gy getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = MD5Util.getMD5String(paramString + y.bEm(paramString));
    Log.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().aUV(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((g)com.tencent.mm.kernel.h.az(g.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.i.b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.OHn == null) {
      this.OHn = new com.tencent.mm.plugin.scanner.i.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.scanner.i.b localb = this.OHn;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(120844);
    this.OHt.alive();
    this.OHs.alive();
    com.tencent.mm.kernel.h.aZW().a(294, this);
    y.bEr(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    this.OHt.dead();
    this.OHs.dead();
    com.tencent.mm.kernel.h.aZW().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(120849);
    Log.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramp.getType() == 294)
    {
      int i = ((com.tencent.mm.plugin.scanner.model.s)paramp).hBm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.scanner.model.s)paramp).ORL;
        if (paramString != null)
        {
          Log.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((com.tencent.mm.plugin.scanner.model.s)paramp).angle), Integer.valueOf(paramString.size()) });
          if (this.OHp.containsKey(Integer.valueOf(i))) {
            ((ld)this.OHp.get(Integer.valueOf(i))).iYO = (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.s)paramp).ORM);
          }
          if ((paramString.size() > 0) && (this.OHo.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ar)this.OHo.get(Integer.valueOf(i));
            ((ar)localObject).hZU = ((due)c.c.b(((com.tencent.mm.plugin.scanner.model.s)paramp).rr.otC)).aaZM;
            ((ar)localObject).hZV = ((com.tencent.mm.plugin.scanner.model.s)paramp).gQU();
            ((ar)localObject).brand = ((due)c.c.b(((com.tencent.mm.plugin.scanner.model.s)paramp).rr.otC)).aaZO;
            if (this.OHp.containsKey(Integer.valueOf(i))) {
              ((ld)this.OHp.get(Integer.valueOf(i))).iOQ = 1L;
            }
            n localn = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationRender();
            float f = ((com.tencent.mm.plugin.scanner.model.s)paramp).angle;
            localObject = ((ar)localObject).OTK;
            paramp = this.OHr;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramp != null))
            {
              localObject = BitmapUtil.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramp.f(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localn.Pjr != 0) && (i != localn.Pjr))
              {
                Log.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localn.Pjr), Integer.valueOf(i) });
                localn.gUe();
              }
              localn.Pjr = i;
              localn.Pjs = paramp;
              localn.Pjt = new n.a(localn, i, paramString, f, (Bitmap)localObject);
              localn.Pjt.A(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.OHp.containsKey(Integer.valueOf(i))) && (this.OHq.containsKey(Integer.valueOf(i)))) {
            ((ld)this.OHp.get(Integer.valueOf(i))).iPP = (System.currentTimeMillis() - ((Long)this.OHq.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.OHp.containsKey(Integer.valueOf(i))) && (this.OHq.containsKey(Integer.valueOf(i))))
      {
        ((ld)this.OHp.get(Integer.valueOf(i))).iPP = (System.currentTimeMillis() - ((Long)this.OHq.get(Integer.valueOf(i))).longValue());
        ((ld)this.OHp.get(Integer.valueOf(i))).iOQ = 5L;
        ((ld)this.OHp.get(Integer.valueOf(i))).bMH();
        this.OHp.remove(Integer.valueOf(i));
        this.OHq.remove(Integer.valueOf(i));
        Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.OHp.size()), Integer.valueOf(this.OHq.size()) });
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