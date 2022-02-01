package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.uq;
import com.tencent.mm.f.a.uq.a;
import com.tencent.mm.f.a.ur;
import com.tencent.mm.f.b.a.it;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.ai;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.l.a;
import com.tencent.mm.plugin.scanner.util.l.b;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation
  extends com.tencent.mm.kernel.b.f
  implements i, com.tencent.mm.kernel.api.bucket.a, c, f
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private l IBk;
  private com.tencent.mm.plugin.scanner.i.b IBl;
  private HashMap<Integer, ai> IBm;
  private HashMap<Integer, it> IBn;
  private HashMap<Integer, Long> IBo;
  private l.b IBp;
  private IListener<ba> IBq;
  private IListener<uq> IBr;
  
  static
  {
    AppMethodBeat.i(120855);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new PluginScanTranslation.1());
    AppMethodBeat.o(120855);
  }
  
  public PluginScanTranslation()
  {
    AppMethodBeat.i(120843);
    this.IBk = new l();
    this.IBm = new HashMap();
    this.IBn = new HashMap();
    this.IBo = new HashMap();
    this.IBp = new l.b()
    {
      public final void d(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(120838);
        if (PluginScanTranslation.this.IBm.containsKey(Integer.valueOf(paramAnonymousInt)))
        {
          if ((PluginScanTranslation.this.IBn.containsKey(Integer.valueOf(paramAnonymousInt))) && (PluginScanTranslation.this.IBo.containsKey(Integer.valueOf(paramAnonymousInt))))
          {
            ((it)PluginScanTranslation.this.IBn.get(Integer.valueOf(paramAnonymousInt))).gCN = (System.currentTimeMillis() - ((Long)PluginScanTranslation.this.IBo.get(Integer.valueOf(paramAnonymousInt))).longValue());
            ((it)PluginScanTranslation.this.IBn.get(Integer.valueOf(paramAnonymousInt))).bpa();
            PluginScanTranslation.this.IBn.remove(Integer.valueOf(paramAnonymousInt));
            PluginScanTranslation.this.IBo.remove(Integer.valueOf(paramAnonymousInt));
            Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.IBn.size()), Integer.valueOf(PluginScanTranslation.this.IBo.size()) });
          }
          if (!h.aHB())
          {
            AppMethodBeat.o(120838);
            return;
          }
          String str = ((PluginScanTranslation)h.ag(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
            Object localObject = new ah();
            paramAnonymousBitmap = (ai)PluginScanTranslation.this.IBm.get(Integer.valueOf(paramAnonymousInt));
            ((ah)localObject).field_originMD5 = MD5Util.getMD5String(paramAnonymousBitmap.mhn + u.bBR(paramAnonymousBitmap.mhn));
            ((ah)localObject).field_resultFile = str;
            ((ah)localObject).field_fromLang = paramAnonymousBitmap.fTW;
            ((ah)localObject).field_toLang = paramAnonymousBitmap.fTX;
            ((ah)localObject).field_brand = paramAnonymousBitmap.brand;
            Log.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            ((PluginScanTranslation)h.ag(PluginScanTranslation.class)).getTranslationResultStorage().a((ah)localObject);
            localObject = new ur();
            ((ur)localObject).fTU.fwM = paramAnonymousInt;
            ((ur)localObject).fTU.fwi = true;
            ((ur)localObject).fTU.fTV = str;
            ((ur)localObject).fTU.fTW = paramAnonymousBitmap.fTW;
            ((ur)localObject).fTU.fTX = paramAnonymousBitmap.fTX;
            if (PluginScanTranslation.this.IBn.containsKey(Integer.valueOf(paramAnonymousInt))) {
              ((ur)localObject).fTU.source = ((int)((it)PluginScanTranslation.this.IBn.get(Integer.valueOf(paramAnonymousInt))).gBe);
            }
            EventCenter.instance.publish((IEvent)localObject);
            PluginScanTranslation.this.IBm.remove(Integer.valueOf(paramAnonymousInt));
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
    this.IBq = new IListener() {};
    this.IBr = new IListener()
    {
      private boolean a(uq paramAnonymousuq)
      {
        AppMethodBeat.i(120841);
        if (!Util.isNullOrNil(paramAnonymousuq.fTT.filePath)) {
          try
          {
            Log.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", new Object[] { paramAnonymousuq.fTT.filePath, Integer.valueOf(paramAnonymousuq.fTT.fwM) });
            Object localObject1 = MD5Util.getMD5String(paramAnonymousuq.fTT.filePath + u.bBR(paramAnonymousuq.fTT.filePath));
            localObject1 = ((PluginScanTranslation)h.ag(PluginScanTranslation.class)).getTranslationResultStorage().aXn((String)localObject1);
            if (localObject1 != null)
            {
              Log.i("MicroMsg.PluginScanTranslation", "already has translation result");
              localObject2 = ((ge)localObject1).field_resultFile;
              if (u.agG((String)localObject2))
              {
                localObject3 = new ur();
                ((ur)localObject3).fTU.fwM = paramAnonymousuq.fTT.fwM;
                ((ur)localObject3).fTU.fwi = true;
                ((ur)localObject3).fTU.fTV = ((String)localObject2);
                ((ur)localObject3).fTU.fTW = ((ge)localObject1).field_fromLang;
                ((ur)localObject3).fTU.fTX = ((ge)localObject1).field_toLang;
                EventCenter.instance.publish((IEvent)localObject3);
                PluginScanTranslation.this.IBm.remove(Integer.valueOf(paramAnonymousuq.fTT.fwM));
                AppMethodBeat.o(120841);
                return true;
              }
              Log.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
            }
            Object localObject3 = new it();
            ((it)localObject3).gBe = b.ade(paramAnonymousuq.fTT.scene);
            PluginScanTranslation.this.IBn.put(Integer.valueOf(paramAnonymousuq.fTT.fwM), localObject3);
            ai localai = new ai();
            localai.mhn = paramAnonymousuq.fTT.filePath;
            localai.IMH = paramAnonymousuq.fTT.filePath;
            int i = Exif.fromFile(paramAnonymousuq.fTT.filePath).getOrientationInDegree();
            Log.i("MicroMsg.PluginScanTranslation", "original img degree %s", new Object[] { Integer.valueOf(i) });
            Object localObject2 = paramAnonymousuq.fTT.filePath;
            final String str = com.tencent.mm.plugin.scanner.util.k.aXA(paramAnonymousuq.fTT.filePath);
            localObject1 = localObject2;
            if (i != 0)
            {
              Bitmap localBitmap = BitmapUtil.decodeFile(paramAnonymousuq.fTT.filePath, new BitmapFactory.Options());
              localObject1 = localObject2;
              if (localBitmap != null)
              {
                localObject2 = BitmapUtil.rotate(localBitmap, i);
                localObject1 = ((g)h.ag(g.class)).genScanTmpImgPath("jpg");
                BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
                localai.IMH = ((String)localObject1);
              }
            }
            PluginScanTranslation.this.IBm.put(Integer.valueOf(paramAnonymousuq.fTT.fwM), localai);
            final long l = System.currentTimeMillis();
            PluginScanTranslation.this.IBo.put(Integer.valueOf(paramAnonymousuq.fTT.fwM), Long.valueOf(l));
            com.tencent.mm.plugin.scanner.util.k.a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new k.a()
            {
              public final void a(String paramAnonymous2String, k.b paramAnonymous2b)
              {
                AppMethodBeat.i(212277);
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (paramAnonymous2String.equals(str)))
                {
                  this.IBu.gJx = (System.currentTimeMillis() - l);
                  Log.i("MicroMsg.PluginScanTranslation", "upload img cost %d", new Object[] { Long.valueOf(this.IBu.gJx) });
                  this.IBu.zP(paramAnonymous2b.fileId);
                  this.IBu.zQ(paramAnonymous2b.aeskey);
                }
                switch (paramAnonymous2b.errCode)
                {
                default: 
                  this.IBu.gBP = 3L;
                  this.IBu.gCN = (System.currentTimeMillis() - l);
                  this.IBu.bpa();
                  PluginScanTranslation.this.IBn.remove(Integer.valueOf(this.IBw.fTT.fwM));
                  PluginScanTranslation.this.IBo.remove(Integer.valueOf(this.IBw.fTT.fwM));
                  Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d, errCode: %s", new Object[] { Integer.valueOf(PluginScanTranslation.this.IBn.size()), Integer.valueOf(PluginScanTranslation.this.IBo.size()), Integer.valueOf(paramAnonymous2b.errCode) });
                  PluginScanTranslation.access$300(PluginScanTranslation.this, this.IBw.fTT.fwM);
                  AppMethodBeat.o(212277);
                  return;
                }
                if (!Util.isNullOrNil(new String[] { paramAnonymous2b.fileId, paramAnonymous2b.aeskey }))
                {
                  Log.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", new Object[] { paramAnonymous2b.fileId });
                  paramAnonymous2String = new com.tencent.mm.plugin.scanner.model.k(this.IBw.fTT.scene, this.IBw.fTT.fwM, (int)u.bBQ(this.IBx), paramAnonymous2b.fileId, paramAnonymous2b.aeskey);
                  h.aGY().a(paramAnonymous2String, 0);
                  AppMethodBeat.o(212277);
                  return;
                }
                this.IBu.gBP = 3L;
                this.IBu.gCN = (System.currentTimeMillis() - l);
                this.IBu.bpa();
                PluginScanTranslation.this.IBn.remove(Integer.valueOf(this.IBw.fTT.fwM));
                PluginScanTranslation.this.IBo.remove(Integer.valueOf(this.IBw.fTT.fwM));
                Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(PluginScanTranslation.this.IBn.size()), Integer.valueOf(PluginScanTranslation.this.IBo.size()) });
                PluginScanTranslation.access$300(PluginScanTranslation.this, this.IBw.fTT.fwM);
                AppMethodBeat.o(212277);
              }
            });
            AppMethodBeat.o(120841);
            return true;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.PluginScanTranslation", localException, "", new Object[0]);
            PluginScanTranslation.access$300(PluginScanTranslation.this, paramAnonymousuq.fTT.fwM);
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
    ur localur = new ur();
    localur.fTU.fwM = paramInt;
    localur.fTU.fwi = false;
    if (this.IBm.containsKey(Integer.valueOf(paramInt)))
    {
      it localit = (it)this.IBn.get(Integer.valueOf(paramInt));
      if (localit != null) {
        localur.fTU.source = ((int)localit.gBe);
      }
    }
    EventCenter.instance.publish(localur);
    this.IBm.remove(Integer.valueOf(paramInt));
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
    paramString = String.format("%s.%s", new Object[] { ((g)h.ag(g.class)).getScanImageSaveDir() + "scan_translation_bg", paramString });
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
  
  public l getTranslationRender()
  {
    return this.IBk;
  }
  
  public ge getTranslationResult(String paramString)
  {
    AppMethodBeat.i(120847);
    String str = MD5Util.getMD5String(paramString + u.bBR(paramString));
    Log.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", new Object[] { paramString, str });
    paramString = getTranslationResultStorage().aXn(str);
    AppMethodBeat.o(120847);
    return paramString;
  }
  
  public String getTranslationResultDir()
  {
    AppMethodBeat.i(120850);
    String str = ((g)h.ag(g.class)).getAccScannerPath() + "scan_result/";
    AppMethodBeat.o(120850);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.i.b getTranslationResultStorage()
  {
    AppMethodBeat.i(120846);
    h.aHE().aGH();
    if (this.IBl == null) {
      this.IBl = new com.tencent.mm.plugin.scanner.i.b(h.aHG().kcF);
    }
    com.tencent.mm.plugin.scanner.i.b localb = this.IBl;
    AppMethodBeat.o(120846);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(120844);
    EventCenter.instance.add(this.IBr);
    EventCenter.instance.add(this.IBq);
    h.aGY().a(294, this);
    u.bBX(getTranslationResultDir());
    AppMethodBeat.o(120844);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(120845);
    EventCenter.instance.removeListener(this.IBr);
    EventCenter.instance.removeListener(this.IBq);
    h.aGY().b(294, this);
    AppMethodBeat.o(120845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120849);
    Log.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramq.getType() == 294)
    {
      int i = ((com.tencent.mm.plugin.scanner.model.k)paramq).fwM;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.scanner.model.k)paramq).IKQ;
        if (paramString != null)
        {
          Log.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", new Object[] { Integer.valueOf(i), Float.valueOf(((com.tencent.mm.plugin.scanner.model.k)paramq).angle), Integer.valueOf(paramString.size()) });
          if (this.IBn.containsKey(Integer.valueOf(i))) {
            ((it)this.IBn.get(Integer.valueOf(i))).gJy = (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.k)paramq).IKR);
          }
          if ((paramString.size() > 0) && (this.IBm.containsKey(Integer.valueOf(i))))
          {
            Object localObject = (ai)this.IBm.get(Integer.valueOf(i));
            ((ai)localObject).fTW = ((dcm)d.c.b(((com.tencent.mm.plugin.scanner.model.k)paramq).rr.lBS)).TJX;
            ((ai)localObject).fTX = ((com.tencent.mm.plugin.scanner.model.k)paramq).fCM();
            ((ai)localObject).brand = ((dcm)d.c.b(((com.tencent.mm.plugin.scanner.model.k)paramq).rr.lBS)).TJZ;
            if (this.IBn.containsKey(Integer.valueOf(i))) {
              ((it)this.IBn.get(Integer.valueOf(i))).gBP = 1L;
            }
            l locall = ((PluginScanTranslation)h.ag(PluginScanTranslation.class)).getTranslationRender();
            float f = ((com.tencent.mm.plugin.scanner.model.k)paramq).angle;
            localObject = ((ai)localObject).IMH;
            paramq = this.IBp;
            if ((i != 0) && (paramString != null) && (paramString.size() > 0) && (paramq != null))
            {
              localObject = BitmapUtil.decodeFile((String)localObject, new BitmapFactory.Options());
              if (localObject == null)
              {
                paramq.d(i, null);
                AppMethodBeat.o(120849);
                return;
              }
              if ((locall.IZx != 0) && (i != locall.IZx))
              {
                Log.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(locall.IZx), Integer.valueOf(i) });
                locall.fEV();
              }
              locall.IZx = i;
              locall.IZy = paramq;
              locall.IZz = new l.a(locall, i, paramString, f, (Bitmap)localObject);
              locall.IZz.y(new Void[0]);
            }
            AppMethodBeat.o(120849);
            return;
          }
          if ((this.IBn.containsKey(Integer.valueOf(i))) && (this.IBo.containsKey(Integer.valueOf(i)))) {
            ((it)this.IBn.get(Integer.valueOf(i))).gCN = (System.currentTimeMillis() - ((Long)this.IBo.get(Integer.valueOf(i))).longValue());
          }
          sendTranslationFailEvent(i);
        }
        AppMethodBeat.o(120849);
        return;
      }
      if ((this.IBn.containsKey(Integer.valueOf(i))) && (this.IBo.containsKey(Integer.valueOf(i))))
      {
        ((it)this.IBn.get(Integer.valueOf(i))).gCN = (System.currentTimeMillis() - ((Long)this.IBo.get(Integer.valueOf(i))).longValue());
        ((it)this.IBn.get(Integer.valueOf(i))).gBP = 5L;
        ((it)this.IBn.get(Integer.valueOf(i))).bpa();
        this.IBn.remove(Integer.valueOf(i));
        this.IBo.remove(Integer.valueOf(i));
        Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(this.IBn.size()), Integer.valueOf(this.IBo.size()) });
      }
      sendTranslationFailEvent(i);
    }
    AppMethodBeat.o(120849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanTranslation
 * JD-Core Version:    0.7.0.1
 */