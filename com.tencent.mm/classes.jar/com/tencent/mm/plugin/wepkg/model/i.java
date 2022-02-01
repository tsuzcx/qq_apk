package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.eew;
import com.tencent.mm.protocal.protobuf.eey;
import com.tencent.mm.protocal.protobuf.eez;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  public static void a(final int paramInt1, final String paramString1, final String paramString2, final String paramString3, final long paramLong, String paramString4, final String paramString5, final int paramInt2, final a parama)
  {
    AppMethodBeat.i(110741);
    final WepkgDownloadProcessTask localWepkgDownloadProcessTask = new WepkgDownloadProcessTask();
    localWepkgDownloadProcessTask.fileType = paramInt1;
    localWepkgDownloadProcessTask.dON = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.EFa = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.EEL = paramInt2;
    if (aj.cnC())
    {
      d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110725);
          WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
          {
            public final void a(String paramAnonymous2String1, String paramAnonymous2String2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymous2RetCode)
            {
              AppMethodBeat.i(110724);
              ad.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymous2RetCode });
              i.1.this.EFn.dON = paramAnonymous2String1;
              i.1.this.EFn.pkgPath = paramAnonymous2String2;
              i.1.this.EFn.EFb = paramAnonymous2RetCode;
              if (i.1.this.EFo != null) {
                i.1.this.EFo.a(i.1.this.EFn);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.eXU().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.eXU().a(paramInt1, bt.nullAsNil(paramString1), "", bt.nullAsNil(paramString2), bt.nullAsNil(paramString3), paramLong, bt.nullAsNil(paramString5), "", bt.nullAsNil(paramInt2), this.EFr, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.EFo != null) {
          this.EFo.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.bhO();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(110741);
  }
  
  public static void a(ckm paramckm, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 2002;
    Object localObject1 = localWepkgCrossProcessTask.EET;
    Object localObject3;
    Object localObject2;
    if (paramckm != null)
    {
      ((WepkgVersion)localObject1).gsn = paramckm.ufQ;
      localObject3 = paramckm.HdW;
      localObject2 = paramckm.HdX;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((efb)localObject3).iht;
        localObject3 = ((efb)localObject3).HQv;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((eey)localObject3).HQo;
          ((WepkgVersion)localObject1).EFB = ((eey)localObject3).HQp;
          ((WepkgVersion)localObject1).EFC = ((eey)localObject3).HQq;
          ((WepkgVersion)localObject1).EFD = ((eey)localObject3).HQr;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).EFF = ((efe)localObject2).HQy;
        ((WepkgVersion)localObject1).charset = ((efe)localObject2).HOx;
        localObject3 = ((efe)localObject2).HQz;
        if ((localObject3 == null) || (((eew)localObject3).HQl == null) || (bt.isNullOrNil(((eew)localObject3).HQl.tRU))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((eew)localObject3).HQl.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((eew)localObject3).HQl.tRU;
        ((WepkgVersion)localObject1).EFG = ((eew)localObject3).HQl.HQt;
        ((WepkgVersion)localObject1).EEL = ((eew)localObject3).HQl.HQs;
        ((WepkgVersion)localObject1).EFI = false;
        localObject2 = ((efe)localObject2).HQA;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).EFK = ((efd)localObject2).HQx;
        }
        if ((localObject2 == null) || (bt.hj(((efd)localObject2).HQw)) || (!((efd)localObject2).HQx)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).EFJ = false;; ((WepkgVersion)localObject1).EFJ = true)
    {
      ((WepkgVersion)localObject1).EFL = 0;
      ((WepkgVersion)localObject1).dOQ = paramInt;
      localObject1 = localWepkgCrossProcessTask.EEV;
      if ((paramckm != null) && (paramckm.HdX != null) && (paramckm.HdX.HQz != null) && (paramckm.HdX.HQz.HQl != null) && (paramckm.HdX.HQz.HQl.HQu != null) && (!bt.isNullOrNil(paramckm.HdX.HQz.HQl.HQu.tRU)))
      {
        localObject2 = paramckm.HdX.HQz.HQl.HQu;
        ((WePkgDiffInfo)localObject1).version = paramckm.HdW.HQv.HQo;
        ((WePkgDiffInfo)localObject1).gsn = paramckm.ufQ;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((efc)localObject2).tRU;
        ((WePkgDiffInfo)localObject1).md5 = ((efc)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((efc)localObject2).HQt;
        ((WePkgDiffInfo)localObject1).EEL = ((efc)localObject2).HQs;
      }
      localObject2 = paramckm.HdX.HQA;
      if ((localObject2 == null) || (bt.hj(((efd)localObject2).HQw))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((efd)localObject2).HQw.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (efa)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramckm.ufQ;
        String str2 = paramckm.HdW.HQv.HQo;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.lp(str1, ((efa)localObject4).GkU);
          ((WepkgPreloadFile)localObject3).gsn = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).EEZ = ((efa)localObject4).GkU;
          ((WepkgPreloadFile)localObject3).mimeType = ((efa)localObject4).GkW;
          localObject4 = ((efa)localObject4).HQl;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((eez)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((eez)localObject4).tRU;
            ((WepkgPreloadFile)localObject3).size = ((eez)localObject4).HQt;
            ((WepkgPreloadFile)localObject3).EEL = ((eez)localObject4).HQs;
          }
          ((WepkgPreloadFile)localObject3).EFm = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).EFI = true;
      break;
    }
    localWepkgCrossProcessTask.EEX = ((List)localObject1);
    label670:
    if (aj.cnC())
    {
      localWepkgCrossProcessTask.aOA();
      AppMethodBeat.o(110742);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    ad.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3002;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC())
    {
      localWepkgCrossProcessTask.aOA();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.EFo != null) {
          this.EFo.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bhO();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4002;
    localWepkgCrossProcessTask.EEW.gsn = paramString1;
    localWepkgCrossProcessTask.EEW.EEZ = paramString2;
    localWepkgCrossProcessTask.EEW.filePath = paramString3;
    localWepkgCrossProcessTask.EEW.EFm = false;
    if (aj.cnC())
    {
      d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.EFt.aOA();
          if (parama != null) {
            parama.a(this.EFt);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.EFo != null) {
          this.EFo.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bhO();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3005;
    localWepkgCrossProcessTask.EET.gsn = paramString1;
    localWepkgCrossProcessTask.EET.pkgPath = paramString2;
    localWepkgCrossProcessTask.EET.EFI = paramBoolean;
    if (aj.cnC())
    {
      d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.EFt.aOA();
          if (parama != null) {
            parama.a(this.EFt);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.EFo != null) {
          this.EFo.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bhO();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion aKR(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3001;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC()) {
      localWepkgCrossProcessTask.aOA();
    }
    while (localWepkgCrossProcessTask.EET == null)
    {
      AppMethodBeat.o(110737);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.EET;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion aKS(String paramString)
  {
    AppMethodBeat.i(110738);
    ad.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3002;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC()) {
      localWepkgCrossProcessTask.aOA();
    }
    while (localWepkgCrossProcessTask.EET == null)
    {
      AppMethodBeat.o(110738);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.EET;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> aKT(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4001;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC()) {
      localWepkgCrossProcessTask.aOA();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.EEX;
      AppMethodBeat.o(110743);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aKU(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3003;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC())
    {
      d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.EFu.aOA();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> aKV(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4003;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC()) {
      localWepkgCrossProcessTask.aOA();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.EEX;
      AppMethodBeat.o(110746);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aKW(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 2006;
    localWepkgCrossProcessTask.EET.gsn = paramString;
    if (aj.cnC())
    {
      localWepkgCrossProcessTask.aOA();
      AppMethodBeat.o(110747);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */