package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
    localWepkgDownloadProcessTask.dQd = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.EXw = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.EXh = paramInt2;
    if (ak.cpe())
    {
      d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110725);
          WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
          {
            public final void a(String paramAnonymous2String1, String paramAnonymous2String2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymous2RetCode)
            {
              AppMethodBeat.i(110724);
              ae.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymous2RetCode });
              i.1.this.EXJ.dQd = paramAnonymous2String1;
              i.1.this.EXJ.pkgPath = paramAnonymous2String2;
              i.1.this.EXJ.EXx = paramAnonymous2RetCode;
              if (i.1.this.EXK != null) {
                i.1.this.EXK.a(i.1.this.EXJ);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.fbG().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.fbG().a(paramInt1, bu.nullAsNil(paramString1), "", bu.nullAsNil(paramString2), bu.nullAsNil(paramString3), paramLong, bu.nullAsNil(paramString5), "", bu.nullAsNil(paramInt2), this.EXN, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.EXK != null) {
          this.EXK.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.bix();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.biw();
    AppBrandMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(110741);
  }
  
  public static void a(clg paramclg, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 2002;
    Object localObject1 = localWepkgCrossProcessTask.EXp;
    Object localObject3;
    Object localObject2;
    if (paramclg != null)
    {
      ((WepkgVersion)localObject1).guO = paramclg.urm;
      localObject3 = paramclg.Hxw;
      localObject2 = paramclg.Hxx;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((egs)localObject3).ikm;
        localObject3 = ((egs)localObject3).IkC;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((egp)localObject3).Ikv;
          ((WepkgVersion)localObject1).EXX = ((egp)localObject3).Ikw;
          ((WepkgVersion)localObject1).EXY = ((egp)localObject3).Ikx;
          ((WepkgVersion)localObject1).EXZ = ((egp)localObject3).Iky;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).EYb = ((egv)localObject2).IkF;
        ((WepkgVersion)localObject1).charset = ((egv)localObject2).IiE;
        localObject3 = ((egv)localObject2).IkG;
        if ((localObject3 == null) || (((egn)localObject3).Iks == null) || (bu.isNullOrNil(((egn)localObject3).Iks.ucL))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((egn)localObject3).Iks.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((egn)localObject3).Iks.ucL;
        ((WepkgVersion)localObject1).EYc = ((egn)localObject3).Iks.IkA;
        ((WepkgVersion)localObject1).EXh = ((egn)localObject3).Iks.Ikz;
        ((WepkgVersion)localObject1).EYe = false;
        localObject2 = ((egv)localObject2).IkH;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).EYg = ((egu)localObject2).IkE;
        }
        if ((localObject2 == null) || (bu.ht(((egu)localObject2).IkD)) || (!((egu)localObject2).IkE)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).EYf = false;; ((WepkgVersion)localObject1).EYf = true)
    {
      ((WepkgVersion)localObject1).EYh = 0;
      ((WepkgVersion)localObject1).dQg = paramInt;
      localObject1 = localWepkgCrossProcessTask.EXr;
      if ((paramclg != null) && (paramclg.Hxx != null) && (paramclg.Hxx.IkG != null) && (paramclg.Hxx.IkG.Iks != null) && (paramclg.Hxx.IkG.Iks.IkB != null) && (!bu.isNullOrNil(paramclg.Hxx.IkG.Iks.IkB.ucL)))
      {
        localObject2 = paramclg.Hxx.IkG.Iks.IkB;
        ((WePkgDiffInfo)localObject1).version = paramclg.Hxw.IkC.Ikv;
        ((WePkgDiffInfo)localObject1).guO = paramclg.urm;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((egt)localObject2).ucL;
        ((WePkgDiffInfo)localObject1).md5 = ((egt)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((egt)localObject2).IkA;
        ((WePkgDiffInfo)localObject1).EXh = ((egt)localObject2).Ikz;
      }
      localObject2 = paramclg.Hxx.IkH;
      if ((localObject2 == null) || (bu.ht(((egu)localObject2).IkD))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((egu)localObject2).IkD.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (egr)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramclg.urm;
        String str2 = paramclg.Hxw.IkC.Ikv;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.lw(str1, ((egr)localObject4).GDE);
          ((WepkgPreloadFile)localObject3).guO = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).EXv = ((egr)localObject4).GDE;
          ((WepkgPreloadFile)localObject3).mimeType = ((egr)localObject4).GDG;
          localObject4 = ((egr)localObject4).Iks;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((egq)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((egq)localObject4).ucL;
            ((WepkgPreloadFile)localObject3).size = ((egq)localObject4).IkA;
            ((WepkgPreloadFile)localObject3).EXh = ((egq)localObject4).Ikz;
          }
          ((WepkgPreloadFile)localObject3).EXI = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).EYe = true;
      break;
    }
    localWepkgCrossProcessTask.EXt = ((List)localObject1);
    label670:
    if (ak.cpe())
    {
      localWepkgCrossProcessTask.aOX();
      AppMethodBeat.o(110742);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    ae.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3002;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe())
    {
      localWepkgCrossProcessTask.aOX();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.EXK != null) {
          this.EXK.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bix();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.biw();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4002;
    localWepkgCrossProcessTask.EXs.guO = paramString1;
    localWepkgCrossProcessTask.EXs.EXv = paramString2;
    localWepkgCrossProcessTask.EXs.filePath = paramString3;
    localWepkgCrossProcessTask.EXs.EXI = false;
    if (ak.cpe())
    {
      d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.EXP.aOX();
          if (parama != null) {
            parama.a(this.EXP);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.EXK != null) {
          this.EXK.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bix();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.biw();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3005;
    localWepkgCrossProcessTask.EXp.guO = paramString1;
    localWepkgCrossProcessTask.EXp.pkgPath = paramString2;
    localWepkgCrossProcessTask.EXp.EYe = paramBoolean;
    if (ak.cpe())
    {
      d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.EXP.aOX();
          if (parama != null) {
            parama.a(this.EXP);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.EXK != null) {
          this.EXK.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bix();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.biw();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion aMn(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3001;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe()) {
      localWepkgCrossProcessTask.aOX();
    }
    while (localWepkgCrossProcessTask.EXp == null)
    {
      AppMethodBeat.o(110737);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.EXp;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion aMo(String paramString)
  {
    AppMethodBeat.i(110738);
    ae.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3002;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe()) {
      localWepkgCrossProcessTask.aOX();
    }
    while (localWepkgCrossProcessTask.EXp == null)
    {
      AppMethodBeat.o(110738);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.EXp;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> aMp(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4001;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe()) {
      localWepkgCrossProcessTask.aOX();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.EXt;
      AppMethodBeat.o(110743);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aMq(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 3003;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe())
    {
      d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.EXQ.aOX();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> aMr(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 4003;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe()) {
      localWepkgCrossProcessTask.aOX();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.EXt;
      AppMethodBeat.o(110746);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aMs(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 2006;
    localWepkgCrossProcessTask.EXp.guO = paramString;
    if (ak.cpe())
    {
      localWepkgCrossProcessTask.aOX();
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