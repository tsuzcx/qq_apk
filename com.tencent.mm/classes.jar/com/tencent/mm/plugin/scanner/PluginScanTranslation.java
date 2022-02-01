package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.to.a;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.h.b;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements i, com.tencent.mm.kernel.api.bucket.a, c, e
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k CzC;
  private b CzD;
  private HashMap<Integer, ak> CzE;
  private HashMap<Integer, go> CzF;
  private HashMap<Integer, Long> CzG;
  private k.b CzH;
  private IListener<ay> CzI;
  private IListener<to> CzJ;
  
  static
  {
    AppMethodBeat.i(120855);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(120855);
  }
  
  public PluginScanTranslation()
  {
    AppMethodBeat.i(120843);
    this.CzC = new k();
    this.CzE = new HashMap();
    this.CzF = new HashMap();
    this.CzG = new HashMap();
    this.CzH = new k.b()
    {
      public final void d(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.CzE.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.CzF.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.CzG.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((go)PluginScanTranslation.this.CzF.get(Integer.valueOf(paramAnonymousInt))).eJW = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.CzG.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((go)PluginScanTranslation.this.CzF.get(Integer.valueOf(paramAnonymousInt))).bfK();
            PluginScanTranslation.this.CzF.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.CzG.remove(Integer.valueOf(paramAnonymousInt));
            Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()) });
          }
          if (!com.tencent.mm.kernel.g.aAc())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new aj();
            paramAnonymousBitmap = (ak)PluginScanTranslation.this.CzE.get(Integer.valueOf(paramAnonymousInt));
            ((aj)localObject).field_originMD5 = MD5Util.getMD5String(paramAnonymousBitmap.jrK + s.boX(paramAnonymousBitmap.jrK));
            ((aj)localObject).field_resultFile = str;
            ((aj)localObject).field_fromLang = paramAnonymousBitmap.eab;
            ((aj)localObject).field_toLang = paramAnonymousBitmap.eac;
            ((aj)localObject).field_brand = paramAnonymousBitmap.brand;
            Log.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a((aj)localObject);
            localObject = new tp();
            ((tp)localObject).dZZ.dEb = paramAnonymousInt;
            ((tp)localObject).dZZ.dDz = true;
            ((tp)localObject).dZZ.eaa = str;
            ((tp)localObject).dZZ.eab = paramAnonymousBitmap.eab;
            ((tp)localObject).dZZ.eac = paramAnonymousBitmap.eac;
            if (PluginScanTranslation.this.CzF.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((tp)localObject).dZZ.source = ((int)((go)PluginScanTranslation.this.CzF.get(Integer.valueOf(paramAnonymousInt))).eDV);
            }
            EventCenter.instance.publish((IEvent)localObject);
            PluginScanTranslation.this.CzE.remove(Integer.valueOf(paramAnonymousInt));
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
    this.CzI = new IListener() {};
    this.CzJ = new IListener()
    {
      private boolean a(to paramAnonymousto)
      {
        AppMethodBeat.i(120841);
        if (!Util.isNullOrNil(paramAnonymousto.dZY.filePath)) {
          try
          {
            Log.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymousto.dZY.filePath, Integer.valueOf(paramAnonymousto.dZY.dEb) });
            Object localObject1 = MD5Util.getMD5String(paramAnonymousto.dZY.filePath + s.boX(paramAnonymousto.dZY.filePath));
            localObject1 = ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG((String)localObject1);
            if (localObject1 != null)
            {
              Log.i("MicroMsg.PluginScanTranslation", "already has translation result");
              localObject2 = ((fx)localObject1).field_resultFile;
              if (s.YS((String)localObject2))
              {
                localObject3 = new tp();
                ((tp)localObject3).dZZ.dEb = paramAnonymousto.dZY.dEb;
                ((tp)localObject3).dZZ.dDz = true;
                ((tp)localObject3).dZZ.eaa = ((String)localObject2);
                ((tp)localObject3).dZZ.eab = ((fx)localObject1).field_fromLang;
                ((tp)localObject3).dZZ.eac = ((fx)localObject1).field_toLang;
                EventCenter.instance.publish((IEvent)localObject3);
                PluginScanTranslation.this.CzE.remove(Integer.valueOf(paramAnonymousto.dZY.dEb));
                AppMethodBeat.o(120841);
                return true;
              }
              Log.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new go();
            ((go)localObject3).eDV = a.Wo(paramAnonymousto.dZY.scene);
            PluginScanTranslation.this.CzF.put(Integer.valueOf(paramAnonymousto.dZY.dEb), localObject3);
            ak localak = new ak();
            localak.jrK = paramAnonymousto.dZY.filePath;
            localak.CHv = paramAnonymousto.dZY.filePath;
            int i = Exif.fromFile(paramAnonymousto.dZY.filePath).getOrientationInDegree();
            Log.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymousto.dZY.filePath;
            final String str = p.aMv(paramAnonymousto.dZY.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = BitmapUtil.decodeFile(paramAnonymousto.dZY.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = BitmapUtil.rotate(localBitmap, i);
                localObject1 = ((f)com.tencent.mm.kernel.g.ah(f.class)).genScanTmpImgPath("jpg");
                BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localak.CHv = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.CzE.put(Integer.valueOf(paramAnonymousto.dZY.dEb), localak);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.CzG.put(Integer.valueOf(paramAnonymousto.dZY.dEb), Long.valueOf(l));
            ((f)com.tencent.mm.kernel.g.ah(f.class)).getScanCdnService().a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new p.a()
            {
              public final void a(String paramAnonymous2String, p.b paramAnonymous2b)
              {
                AppMethodBeat.i(120840);
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.CzM.eJU = (System.currentTimeMillis() - l);
                  Log.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.CzM.eJU) });
                  this.CzM.uq(paramAnonymous2b.fileId);
                  this.CzM.ur(paramAnonymous2b.aeskey);
                  switch (paramAnonymous2b.errCode)
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(120840);
                  return;
                  if (!Util.isNullOrNil(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                  {
                    Log.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                    paramAnonymous2String = new m(this.CzO.dZY.scene, this.CzO.dZY.dEb, (int)s.boW(this.CzP), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                    com.tencent.mm.kernel.g.azz().a(paramAnonymous2String, 0);
                    AppMethodBeat.o(120840);
                    return;
                  }
                  this.CzM.eEt = 3L;
                  this.CzM.eJW = (System.currentTimeMillis() - l);
                  this.CzM.bfK();
                  PluginScanTranslation.this.CzF.remove(Integer.valueOf(this.CzO.dZY.dEb));
                  PluginScanTranslation.this.CzG.remove(Integer.valueOf(this.CzO.dZY.dEb));
                  Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.CzO.dZY.dEb);
                  AppMethodBeat.o(120840);
                  return;
                  this.CzM.eEt = 3L;
                  this.CzM.eJW = (System.currentTimeMillis() - l);
                  this.CzM.bfK();
                  PluginScanTranslation.this.CzF.remove(Integer.valueOf(this.CzO.dZY.dEb));
                  PluginScanTranslation.this.CzG.remove(Integer.valueOf(this.CzO.dZY.dEb));
                  Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.CzO.dZY.dEb);
                }
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousto.dZY.dEb);
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
    tp localtp = new tp();
    localtp.dZZ.dEb = paramInt;
    localtp.dZZ.dDz = false;
    if (this.CzE.containsKey(Integer.valueOf(paramInt)))
    {
      go localgo = (go)this.CzF.get(Integer.valueOf(paramInt));
      if (localgo != null) {
        localtp.dZZ.source = ((int)localgo.eDV);
      }
    }
    EventCenter.instance.publish(localtp);
    this.CzE.remove(Integer.valueOf(paramInt));
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
    paramString = String.format("%s.%s", new Object[] { ((f)com.tencent.mm.kernel.g.ah(f.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
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
  
  public k getTranslationRender()
  {
    return this.CzC;
  }
  
  public fx getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = MD5Util.getMD5String(paramString + s.boX(paramString));
    Log.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().aMG(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((f)com.tencent.mm.kernel.g.ah(f.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.CzD == null) {
      this.CzD = new b(com.tencent.mm.kernel.g.aAh().hqK);
    }
    b localb = this.CzD;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(120844);
    EventCenter.instance.add(this.CzJ);
    EventCenter.instance.add(this.CzI);
    com.tencent.mm.kernel.g.azz().a(294, this);
    s.bpc(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    EventCenter.instance.removeListener(this.CzJ);
    EventCenter.instance.removeListener(this.CzI);
    com.tencent.mm.kernel.g.azz().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120849);
    Log.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramq.getType() == 294)
    {
      int i = ((m)paramq).dEb;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((m)paramq).CFD;
        if (paramString != null)
        {
          Log.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((m)paramq).angle), Integer.valueOf(paramString.size()) });
          if (this.CzF.containsKey(Integer.valueOf(i))) {
            ((go)this.CzF.get(Integer.valueOf(i))).eJV = (System.currentTimeMillis() - ((m)paramq).CFE);
          }
          if ((paramString.size() > 0) && (this.CzE.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ak)this.CzE.get(Integer.valueOf(i));
            ((ak)localObject).eab = ((ctn)((m)paramq).rr.iLL.iLR).Myw;
            ((ak)localObject).eac = ((m)paramq).ePR();
            ((ak)localObject).brand = ((ctn)((m)paramq).rr.iLL.iLR).Myy;
            if (this.CzF.containsKey(Integer.valueOf(i))) {
              ((go)this.CzF.get(Integer.valueOf(i))).eEt = 1L;
            }
            k localk = ((PluginScanTranslation)com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).getTranslationRender();
            float f = ((m)paramq).angle;
            localObject = ((ak)localObject).CHv;
            paramq = this.CzH;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramq != null))
            {
              localObject = BitmapUtil.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramq.d(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((localk.CUc != 0) && (i != localk.CUc))
              {
                Log.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localk.CUc), Integer.valueOf(i) });
                localk.eRW();
              }
              localk.CUc = i;
              localk.CUd = paramq;
              localk.CUe = new k.a(localk, i, paramString, f, (Bitmap)localObject);
              localk.CUe.y(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.CzF.containsKey(Integer.valueOf(i))) && (this.CzG.containsKey(Integer.valueOf(i)))) {
            ((go)this.CzF.get(Integer.valueOf(i))).eJW = (System.currentTimeMillis() - ((Long)this.CzG.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.CzF.containsKey(Integer.valueOf(i))) && (this.CzG.containsKey(Integer.valueOf(i))))
      {
        ((go)this.CzF.get(Integer.valueOf(i))).eJW = (System.currentTimeMillis() - ((Long)this.CzG.get(Integer.valueOf(i))).longValue());
        ((go)this.CzF.get(Integer.valueOf(i))).eEt = 5L;
        ((go)this.CzF.get(Integer.valueOf(i))).bfK();
        this.CzF.remove(Integer.valueOf(i));
        this.CzG.remove(Integer.valueOf(i));
        Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.CzF.size()), Integer.valueOf(this.CzG.size()) });
      }
      sendTranslationFailEvent(i);
    }
    AppMethodBeat.o(120849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanTranslation
 * JD-Core Version:    0.7.0.1
 */