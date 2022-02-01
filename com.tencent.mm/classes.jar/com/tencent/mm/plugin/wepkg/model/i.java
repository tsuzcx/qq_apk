package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dtl;
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
    localWepkgDownloadProcessTask.dEO = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.BIS = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.BID = paramInt2;
    if (aj.cbv())
    {
      d.bNl().postToWorker(new Runnable()
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
              i.1.this.BJf.dEO = paramAnonymous2String1;
              i.1.this.BJf.pkgPath = paramAnonymous2String2;
              i.1.this.BJf.BIT = paramAnonymous2RetCode;
              if (i.1.this.BJg != null) {
                i.1.this.BJg.a(i.1.this.BJf);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.etH().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.etH().a(paramInt1, bt.nullAsNil(paramString1), "", bt.nullAsNil(paramString2), bt.nullAsNil(paramString3), paramLong, bt.nullAsNil(paramString5), "", bt.nullAsNil(paramInt2), this.BJj, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.BJg != null) {
          this.BJg.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.aXn();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.aXm();
    AppBrandMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(110741);
  }
  
  public static void a(cao paramcao, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 2002;
    Object localObject1 = localWepkgCrossProcessTask.BIL;
    Object localObject3;
    Object localObject2;
    if (paramcao != null)
    {
      ((WepkgVersion)localObject1).fUW = paramcao.sag;
      localObject3 = paramcao.DWY;
      localObject2 = paramcao.DWZ;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((dti)localObject3).hnC;
        localObject3 = ((dti)localObject3).EIc;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((dtf)localObject3).EHV;
          ((WepkgVersion)localObject1).BJt = ((dtf)localObject3).EHW;
          ((WepkgVersion)localObject1).BJu = ((dtf)localObject3).EHX;
          ((WepkgVersion)localObject1).BJv = ((dtf)localObject3).EHY;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).BJx = ((dtl)localObject2).EIf;
        ((WepkgVersion)localObject1).charset = ((dtl)localObject2).EGf;
        localObject3 = ((dtl)localObject2).EIg;
        if ((localObject3 == null) || (((dtd)localObject3).EHS == null) || (bt.isNullOrNil(((dtd)localObject3).EHS.rNA))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((dtd)localObject3).EHS.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((dtd)localObject3).EHS.rNA;
        ((WepkgVersion)localObject1).BJy = ((dtd)localObject3).EHS.EIa;
        ((WepkgVersion)localObject1).BID = ((dtd)localObject3).EHS.EHZ;
        ((WepkgVersion)localObject1).BJA = false;
        localObject2 = ((dtl)localObject2).EIh;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).BJC = ((dtk)localObject2).EIe;
        }
        if ((localObject2 == null) || (bt.gL(((dtk)localObject2).EId)) || (!((dtk)localObject2).EIe)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).BJB = false;; ((WepkgVersion)localObject1).BJB = true)
    {
      ((WepkgVersion)localObject1).BJD = 0;
      ((WepkgVersion)localObject1).dER = paramInt;
      localObject1 = localWepkgCrossProcessTask.BIN;
      if ((paramcao != null) && (paramcao.DWZ != null) && (paramcao.DWZ.EIg != null) && (paramcao.DWZ.EIg.EHS != null) && (paramcao.DWZ.EIg.EHS.EIb != null) && (!bt.isNullOrNil(paramcao.DWZ.EIg.EHS.EIb.rNA)))
      {
        localObject2 = paramcao.DWZ.EIg.EHS.EIb;
        ((WePkgDiffInfo)localObject1).version = paramcao.DWY.EIc.EHV;
        ((WePkgDiffInfo)localObject1).fUW = paramcao.sag;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((dtj)localObject2).rNA;
        ((WePkgDiffInfo)localObject1).md5 = ((dtj)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((dtj)localObject2).EIa;
        ((WePkgDiffInfo)localObject1).BID = ((dtj)localObject2).EHZ;
      }
      localObject2 = paramcao.DWZ.EIh;
      if ((localObject2 == null) || (bt.gL(((dtk)localObject2).EId))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((dtk)localObject2).EId.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (dth)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramcao.sag;
        String str2 = paramcao.DWY.EIc.EHV;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.kw(str1, ((dth)localObject4).Dke);
          ((WepkgPreloadFile)localObject3).fUW = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).BIR = ((dth)localObject4).Dke;
          ((WepkgPreloadFile)localObject3).mimeType = ((dth)localObject4).Dkg;
          localObject4 = ((dth)localObject4).EHS;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((dtg)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((dtg)localObject4).rNA;
            ((WepkgPreloadFile)localObject3).size = ((dtg)localObject4).EIa;
            ((WepkgPreloadFile)localObject3).BID = ((dtg)localObject4).EHZ;
          }
          ((WepkgPreloadFile)localObject3).BJe = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).BJA = true;
      break;
    }
    localWepkgCrossProcessTask.BIP = ((List)localObject1);
    label670:
    if (aj.cbv())
    {
      localWepkgCrossProcessTask.aEz();
      AppMethodBeat.o(110742);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 3002;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv())
    {
      localWepkgCrossProcessTask.aEz();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.BJg != null) {
          this.BJg.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.aXn();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.aXm();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 4002;
    localWepkgCrossProcessTask.BIO.fUW = paramString1;
    localWepkgCrossProcessTask.BIO.BIR = paramString2;
    localWepkgCrossProcessTask.BIO.filePath = paramString3;
    localWepkgCrossProcessTask.BIO.BJe = false;
    if (aj.cbv())
    {
      d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.BJl.aEz();
          if (parama != null) {
            parama.a(this.BJl);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.BJg != null) {
          this.BJg.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.aXn();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.aXm();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 3005;
    localWepkgCrossProcessTask.BIL.fUW = paramString1;
    localWepkgCrossProcessTask.BIL.pkgPath = paramString2;
    localWepkgCrossProcessTask.BIL.BJA = paramBoolean;
    if (aj.cbv())
    {
      d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.BJl.aEz();
          if (parama != null) {
            parama.a(this.BJl);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.BJg != null) {
          this.BJg.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.aXn();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.aXm();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion aAa(String paramString)
  {
    AppMethodBeat.i(110738);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 3002;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv()) {
      localWepkgCrossProcessTask.aEz();
    }
    while (localWepkgCrossProcessTask.BIL == null)
    {
      AppMethodBeat.o(110738);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.BIL;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> aAb(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 4001;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv()) {
      localWepkgCrossProcessTask.aEz();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.BIP;
      AppMethodBeat.o(110743);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aAc(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 3003;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv())
    {
      d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.BJm.aEz();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> aAd(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 4003;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv()) {
      localWepkgCrossProcessTask.aEz();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.BIP;
      AppMethodBeat.o(110746);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aAe(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 2006;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv())
    {
      localWepkgCrossProcessTask.aEz();
      AppMethodBeat.o(110747);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110747);
  }
  
  public static WepkgVersion azZ(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 3001;
    localWepkgCrossProcessTask.BIL.fUW = paramString;
    if (aj.cbv()) {
      localWepkgCrossProcessTask.aEz();
    }
    while (localWepkgCrossProcessTask.BIL == null)
    {
      AppMethodBeat.o(110737);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.BIL;
    AppMethodBeat.o(110737);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */