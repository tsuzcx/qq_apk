package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.flw;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.protocal.protobuf.flz;
import com.tencent.mm.protocal.protobuf.fma;
import com.tencent.mm.protocal.protobuf.fmb;
import com.tencent.mm.protocal.protobuf.fmc;
import com.tencent.mm.protocal.protobuf.fmd;
import com.tencent.mm.protocal.protobuf.fme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  public static void a(final int paramInt1, final String paramString1, final String paramString2, final String paramString3, final long paramLong, String paramString4, final String paramString5, final int paramInt2, final a parama)
  {
    AppMethodBeat.i(110741);
    final WepkgDownloadProcessTask localWepkgDownloadProcessTask = new WepkgDownloadProcessTask();
    localWepkgDownloadProcessTask.fileType = paramInt1;
    localWepkgDownloadProcessTask.gcx = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.QMH = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.QMs = paramInt2;
    if (MMApplicationContext.isMMProcess())
    {
      d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110725);
          WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
          {
            public final void a(String paramAnonymous2String1, String paramAnonymous2String2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymous2RetCode)
            {
              AppMethodBeat.i(110724);
              Log.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymous2RetCode });
              j.1.this.QMU.gcx = paramAnonymous2String1;
              j.1.this.QMU.pkgPath = paramAnonymous2String2;
              j.1.this.QMU.QMI = paramAnonymous2RetCode;
              if (j.1.this.QMV != null) {
                j.1.this.QMV.a(j.1.this.QMU);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.heD().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.heD().a(paramInt1, Util.nullAsNil(paramString1), "", Util.nullAsNil(paramString2), Util.nullAsNil(paramString3), paramLong, Util.nullAsNil(paramString5), "", Util.nullAsNil(paramInt2), this.QMY, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.QMV != null) {
          this.QMV.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.bPk();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.bsM();
    AppMethodBeat.o(110741);
  }
  
  public static void a(dlf paramdlf, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 2002;
    Object localObject1 = localWepkgCrossProcessTask.QMA;
    Object localObject3;
    Object localObject2;
    if (paramdlf != null)
    {
      ((WepkgVersion)localObject1).jTB = paramdlf.CNL;
      localObject3 = paramdlf.TSm;
      localObject2 = paramdlf.TSn;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((fmb)localObject3).lVG;
        localObject3 = ((fmb)localObject3).UKU;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((fly)localObject3).UKN;
          ((WepkgVersion)localObject1).QNi = ((fly)localObject3).UKO;
          ((WepkgVersion)localObject1).QNj = ((fly)localObject3).UKP;
          ((WepkgVersion)localObject1).QNk = ((fly)localObject3).UKQ;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).domain = ((fme)localObject2).UKX;
        ((WepkgVersion)localObject1).charset = ((fme)localObject2).UIr;
        localObject3 = ((fme)localObject2).UKY;
        if ((localObject3 == null) || (((flw)localObject3).UKK == null) || (Util.isNullOrNil(((flw)localObject3).UKK.Cqt))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((flw)localObject3).UKK.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((flw)localObject3).UKK.Cqt;
        ((WepkgVersion)localObject1).QNm = ((flw)localObject3).UKK.UKS;
        ((WepkgVersion)localObject1).QMs = ((flw)localObject3).UKK.UKR;
        ((WepkgVersion)localObject1).QNo = false;
        localObject2 = ((fme)localObject2).UKZ;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).QNq = ((fmd)localObject2).UKW;
        }
        if ((localObject2 == null) || (Util.isNullOrNil(((fmd)localObject2).UKV)) || (!((fmd)localObject2).UKW)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).QNp = false;; ((WepkgVersion)localObject1).QNp = true)
    {
      ((WepkgVersion)localObject1).QNr = 0;
      ((WepkgVersion)localObject1).gcA = paramInt;
      localObject1 = localWepkgCrossProcessTask.QMC;
      if ((paramdlf != null) && (paramdlf.TSn != null) && (paramdlf.TSn.UKY != null) && (paramdlf.TSn.UKY.UKK != null) && (paramdlf.TSn.UKY.UKK.UKT != null) && (!Util.isNullOrNil(paramdlf.TSn.UKY.UKK.UKT.Cqt)))
      {
        localObject2 = paramdlf.TSn.UKY.UKK.UKT;
        ((WePkgDiffInfo)localObject1).version = paramdlf.TSm.UKU.UKN;
        ((WePkgDiffInfo)localObject1).jTB = paramdlf.CNL;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((fmc)localObject2).Cqt;
        ((WePkgDiffInfo)localObject1).md5 = ((fmc)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((fmc)localObject2).UKS;
        ((WePkgDiffInfo)localObject1).QMs = ((fmc)localObject2).UKR;
      }
      localObject2 = paramdlf.TSn.UKZ;
      if ((localObject2 == null) || (Util.isNullOrNil(((fmd)localObject2).UKV))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((fmd)localObject2).UKV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (fma)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramdlf.CNL;
        String str2 = paramdlf.TSm.UKU.UKN;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.mY(str1, ((fma)localObject4).SCg);
          ((WepkgPreloadFile)localObject3).jTB = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).QMG = ((fma)localObject4).SCg;
          ((WepkgPreloadFile)localObject3).mimeType = ((fma)localObject4).SCi;
          localObject4 = ((fma)localObject4).UKK;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((flz)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((flz)localObject4).Cqt;
            ((WepkgPreloadFile)localObject3).size = ((flz)localObject4).UKS;
            ((WepkgPreloadFile)localObject3).QMs = ((flz)localObject4).UKR;
          }
          ((WepkgPreloadFile)localObject3).QMT = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).QNo = true;
      break;
    }
    localWepkgCrossProcessTask.QME = ((List)localObject1);
    label670:
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.RW();
      AppMethodBeat.o(110742);
      return;
    }
    localWepkgCrossProcessTask.bPu();
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 3002;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.RW();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.QMV != null) {
          this.QMV.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bPk();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.bsM();
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 4002;
    localWepkgCrossProcessTask.QMD.jTB = paramString1;
    localWepkgCrossProcessTask.QMD.QMG = paramString2;
    localWepkgCrossProcessTask.QMD.filePath = paramString3;
    localWepkgCrossProcessTask.QMD.QMT = false;
    if (MMApplicationContext.isMMProcess())
    {
      d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.QNa.RW();
          if (parama != null) {
            parama.a(this.QNa);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.QMV != null) {
          this.QMV.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bPk();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.bsM();
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 3005;
    localWepkgCrossProcessTask.QMA.jTB = paramString1;
    localWepkgCrossProcessTask.QMA.pkgPath = paramString2;
    localWepkgCrossProcessTask.QMA.QNo = paramBoolean;
    if (MMApplicationContext.isMMProcess())
    {
      d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.QNa.RW();
          if (parama != null) {
            parama.a(this.QNa);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.QMV != null) {
          this.QMV.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bPk();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.bsM();
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion boG(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 3001;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.RW();
    }
    while (localWepkgCrossProcessTask.QMA == null)
    {
      AppMethodBeat.o(110737);
      return null;
      localWepkgCrossProcessTask.bPu();
    }
    paramString = localWepkgCrossProcessTask.QMA;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion boH(String paramString)
  {
    AppMethodBeat.i(110738);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 3002;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.RW();
    }
    while (localWepkgCrossProcessTask.QMA == null)
    {
      AppMethodBeat.o(110738);
      return null;
      localWepkgCrossProcessTask.bPu();
    }
    paramString = localWepkgCrossProcessTask.QMA;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> boI(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 4001;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.RW();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.QME;
      AppMethodBeat.o(110743);
      return paramString;
      localWepkgCrossProcessTask.bPu();
    }
  }
  
  public static void boJ(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 3003;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.QNb.RW();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    localWepkgCrossProcessTask.bsM();
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> boK(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 4003;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.RW();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.QME;
      AppMethodBeat.o(110746);
      return paramString;
      localWepkgCrossProcessTask.bPu();
    }
  }
  
  public static void boL(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 2006;
    localWepkgCrossProcessTask.QMA.jTB = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.RW();
      AppMethodBeat.o(110747);
      return;
    }
    localWepkgCrossProcessTask.bPu();
    AppMethodBeat.o(110747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */