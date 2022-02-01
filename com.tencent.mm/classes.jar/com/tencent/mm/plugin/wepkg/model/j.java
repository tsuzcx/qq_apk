package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.fbd;
import com.tencent.mm.protocal.protobuf.fbf;
import com.tencent.mm.protocal.protobuf.fbg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.protocal.protobuf.fbj;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.protocal.protobuf.fbl;
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
    localWepkgDownloadProcessTask.eig = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.JNo = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.JMZ = paramInt2;
    if (MMApplicationContext.isMMProcess())
    {
      d.cyh().postToWorker(new Runnable()
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
              j.1.this.JNB.eig = paramAnonymous2String1;
              j.1.this.JNB.pkgPath = paramAnonymous2String2;
              j.1.this.JNB.JNp = paramAnonymous2RetCode;
              if (j.1.this.JNC != null) {
                j.1.this.JNC.a(j.1.this.JNB);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.gkM().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.gkM().a(paramInt1, Util.nullAsNil(paramString1), "", Util.nullAsNil(paramString2), Util.nullAsNil(paramString3), paramLong, Util.nullAsNil(paramString5), "", Util.nullAsNil(paramInt2), this.JNF, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.JNC != null) {
          this.JNC.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.bDK();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(110741);
  }
  
  public static void a(dbq paramdbq, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 2002;
    Object localObject1 = localWepkgCrossProcessTask.JNh;
    Object localObject3;
    Object localObject2;
    if (paramdbq != null)
    {
      ((WepkgVersion)localObject1).hhD = paramdbq.xJD;
      localObject3 = paramdbq.MGz;
      localObject2 = paramdbq.MGA;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((fbi)localObject3).jfi;
        localObject3 = ((fbi)localObject3).NxD;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((fbf)localObject3).Nxw;
          ((WepkgVersion)localObject1).JNP = ((fbf)localObject3).Nxx;
          ((WepkgVersion)localObject1).JNQ = ((fbf)localObject3).Nxy;
          ((WepkgVersion)localObject1).JNR = ((fbf)localObject3).Nxz;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).domain = ((fbl)localObject2).NxG;
        ((WepkgVersion)localObject1).charset = ((fbl)localObject2).Nvi;
        localObject3 = ((fbl)localObject2).NxH;
        if ((localObject3 == null) || (((fbd)localObject3).Nxt == null) || (Util.isNullOrNil(((fbd)localObject3).Nxt.xuc))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((fbd)localObject3).Nxt.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((fbd)localObject3).Nxt.xuc;
        ((WepkgVersion)localObject1).JNT = ((fbd)localObject3).Nxt.NxB;
        ((WepkgVersion)localObject1).JMZ = ((fbd)localObject3).Nxt.NxA;
        ((WepkgVersion)localObject1).JNV = false;
        localObject2 = ((fbl)localObject2).NxI;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).JNX = ((fbk)localObject2).NxF;
        }
        if ((localObject2 == null) || (Util.isNullOrNil(((fbk)localObject2).NxE)) || (!((fbk)localObject2).NxF)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).JNW = false;; ((WepkgVersion)localObject1).JNW = true)
    {
      ((WepkgVersion)localObject1).JNY = 0;
      ((WepkgVersion)localObject1).eij = paramInt;
      localObject1 = localWepkgCrossProcessTask.JNj;
      if ((paramdbq != null) && (paramdbq.MGA != null) && (paramdbq.MGA.NxH != null) && (paramdbq.MGA.NxH.Nxt != null) && (paramdbq.MGA.NxH.Nxt.NxC != null) && (!Util.isNullOrNil(paramdbq.MGA.NxH.Nxt.NxC.xuc)))
      {
        localObject2 = paramdbq.MGA.NxH.Nxt.NxC;
        ((WePkgDiffInfo)localObject1).version = paramdbq.MGz.NxD.Nxw;
        ((WePkgDiffInfo)localObject1).hhD = paramdbq.xJD;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((fbj)localObject2).xuc;
        ((WePkgDiffInfo)localObject1).md5 = ((fbj)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((fbj)localObject2).NxB;
        ((WePkgDiffInfo)localObject1).JMZ = ((fbj)localObject2).NxA;
      }
      localObject2 = paramdbq.MGA.NxI;
      if ((localObject2 == null) || (Util.isNullOrNil(((fbk)localObject2).NxE))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((fbk)localObject2).NxE.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (fbh)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramdbq.xJD;
        String str2 = paramdbq.MGz.NxD.Nxw;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.mv(str1, ((fbh)localObject4).LzG);
          ((WepkgPreloadFile)localObject3).hhD = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).JNn = ((fbh)localObject4).LzG;
          ((WepkgPreloadFile)localObject3).mimeType = ((fbh)localObject4).LzI;
          localObject4 = ((fbh)localObject4).Nxt;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((fbg)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((fbg)localObject4).xuc;
            ((WepkgPreloadFile)localObject3).size = ((fbg)localObject4).NxB;
            ((WepkgPreloadFile)localObject3).JMZ = ((fbg)localObject4).NxA;
          }
          ((WepkgPreloadFile)localObject3).JNA = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).JNV = true;
      break;
    }
    localWepkgCrossProcessTask.JNl = ((List)localObject1);
    label670:
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.bjj();
      AppMethodBeat.o(110742);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 3002;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.bjj();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.JNC != null) {
          this.JNC.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bDK();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 4002;
    localWepkgCrossProcessTask.JNk.hhD = paramString1;
    localWepkgCrossProcessTask.JNk.JNn = paramString2;
    localWepkgCrossProcessTask.JNk.filePath = paramString3;
    localWepkgCrossProcessTask.JNk.JNA = false;
    if (MMApplicationContext.isMMProcess())
    {
      d.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.JNH.bjj();
          if (parama != null) {
            parama.a(this.JNH);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.JNC != null) {
          this.JNC.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bDK();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 3005;
    localWepkgCrossProcessTask.JNh.hhD = paramString1;
    localWepkgCrossProcessTask.JNh.pkgPath = paramString2;
    localWepkgCrossProcessTask.JNh.JNV = paramBoolean;
    if (MMApplicationContext.isMMProcess())
    {
      d.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.JNH.bjj();
          if (parama != null) {
            parama.a(this.JNH);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.JNC != null) {
          this.JNC.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bDK();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion bcH(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 3001;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.bjj();
    }
    while (localWepkgCrossProcessTask.JNh == null)
    {
      AppMethodBeat.o(110737);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.JNh;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion bcI(String paramString)
  {
    AppMethodBeat.i(110738);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 3002;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.bjj();
    }
    while (localWepkgCrossProcessTask.JNh == null)
    {
      AppMethodBeat.o(110738);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.JNh;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> bcJ(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 4001;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.bjj();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.JNl;
      AppMethodBeat.o(110743);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void bcK(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 3003;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      d.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.JNI.bjj();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> bcL(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 4003;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.bjj();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.JNl;
      AppMethodBeat.o(110746);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void bcM(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 2006;
    localWepkgCrossProcessTask.JNh.hhD = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.bjj();
      AppMethodBeat.o(110747);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */