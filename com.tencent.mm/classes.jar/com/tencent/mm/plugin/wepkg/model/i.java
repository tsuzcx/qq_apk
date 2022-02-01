package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
    localWepkgDownloadProcessTask.dCA = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.Dbb = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.DaM = paramInt2;
    if (ai.ciE())
    {
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110725);
          WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
          {
            public final void a(String paramAnonymous2String1, String paramAnonymous2String2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymous2RetCode)
            {
              AppMethodBeat.i(110724);
              ac.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymous2RetCode });
              i.1.this.Dbo.dCA = paramAnonymous2String1;
              i.1.this.Dbo.pkgPath = paramAnonymous2String2;
              i.1.this.Dbo.Dbc = paramAnonymous2RetCode;
              if (i.1.this.Dbp != null) {
                i.1.this.Dbp.a(i.1.this.Dbo);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.eJa().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.eJa().a(paramInt1, bs.nullAsNil(paramString1), "", bs.nullAsNil(paramString2), bs.nullAsNil(paramString3), paramLong, bs.nullAsNil(paramString5), "", bs.nullAsNil(paramInt2), this.Dbs, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (this.Dbp != null) {
          this.Dbp.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.bek();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.bej();
    AppBrandMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(110741);
  }
  
  public static void a(cfn paramcfn, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 2002;
    Object localObject1 = localWepkgCrossProcessTask.DaU;
    Object localObject3;
    Object localObject2;
    if (paramcfn != null)
    {
      ((WepkgVersion)localObject1).fYR = paramcfn.thZ;
      localObject3 = paramcfn.FtR;
      localObject2 = paramcfn.FtS;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((dyz)localObject3).hOf;
        localObject3 = ((dyz)localObject3).Gfo;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((dyw)localObject3).Gfh;
          ((WepkgVersion)localObject1).DbC = ((dyw)localObject3).Gfi;
          ((WepkgVersion)localObject1).DbD = ((dyw)localObject3).Gfj;
          ((WepkgVersion)localObject1).DbE = ((dyw)localObject3).Gfk;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).DbG = ((dzc)localObject2).Gfr;
        ((WepkgVersion)localObject1).charset = ((dzc)localObject2).Gdr;
        localObject3 = ((dzc)localObject2).Gfs;
        if ((localObject3 == null) || (((dyu)localObject3).Gfe == null) || (bs.isNullOrNil(((dyu)localObject3).Gfe.sVp))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((dyu)localObject3).Gfe.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((dyu)localObject3).Gfe.sVp;
        ((WepkgVersion)localObject1).DbH = ((dyu)localObject3).Gfe.Gfm;
        ((WepkgVersion)localObject1).DaM = ((dyu)localObject3).Gfe.Gfl;
        ((WepkgVersion)localObject1).DbJ = false;
        localObject2 = ((dzc)localObject2).Gft;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).DbL = ((dzb)localObject2).Gfq;
        }
        if ((localObject2 == null) || (bs.gY(((dzb)localObject2).Gfp)) || (!((dzb)localObject2).Gfq)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).DbK = false;; ((WepkgVersion)localObject1).DbK = true)
    {
      ((WepkgVersion)localObject1).DbM = 0;
      ((WepkgVersion)localObject1).dCD = paramInt;
      localObject1 = localWepkgCrossProcessTask.DaW;
      if ((paramcfn != null) && (paramcfn.FtS != null) && (paramcfn.FtS.Gfs != null) && (paramcfn.FtS.Gfs.Gfe != null) && (paramcfn.FtS.Gfs.Gfe.Gfn != null) && (!bs.isNullOrNil(paramcfn.FtS.Gfs.Gfe.Gfn.sVp)))
      {
        localObject2 = paramcfn.FtS.Gfs.Gfe.Gfn;
        ((WePkgDiffInfo)localObject1).version = paramcfn.FtR.Gfo.Gfh;
        ((WePkgDiffInfo)localObject1).fYR = paramcfn.thZ;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((dza)localObject2).sVp;
        ((WePkgDiffInfo)localObject1).md5 = ((dza)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((dza)localObject2).Gfm;
        ((WePkgDiffInfo)localObject1).DaM = ((dza)localObject2).Gfl;
      }
      localObject2 = paramcfn.FtS.Gft;
      if ((localObject2 == null) || (bs.gY(((dzb)localObject2).Gfp))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((dzb)localObject2).Gfp.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (dyy)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramcfn.thZ;
        String str2 = paramcfn.FtR.Gfo.Gfh;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.kS(str1, ((dyy)localObject4).EDk);
          ((WepkgPreloadFile)localObject3).fYR = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).Dba = ((dyy)localObject4).EDk;
          ((WepkgPreloadFile)localObject3).mimeType = ((dyy)localObject4).EDm;
          localObject4 = ((dyy)localObject4).Gfe;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((dyx)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((dyx)localObject4).sVp;
            ((WepkgPreloadFile)localObject3).size = ((dyx)localObject4).Gfm;
            ((WepkgPreloadFile)localObject3).DaM = ((dyx)localObject4).Gfl;
          }
          ((WepkgPreloadFile)localObject3).Dbn = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).DbJ = true;
      break;
    }
    localWepkgCrossProcessTask.DaY = ((List)localObject1);
    label670:
    if (ai.ciE())
    {
      localWepkgCrossProcessTask.aLq();
      AppMethodBeat.o(110742);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    ac.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 3002;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE())
    {
      localWepkgCrossProcessTask.aLq();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (this.Dbp != null) {
          this.Dbp.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bek();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.bej();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 4002;
    localWepkgCrossProcessTask.DaX.fYR = paramString1;
    localWepkgCrossProcessTask.DaX.Dba = paramString2;
    localWepkgCrossProcessTask.DaX.filePath = paramString3;
    localWepkgCrossProcessTask.DaX.Dbn = false;
    if (ai.ciE())
    {
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          this.Dbu.aLq();
          if (parama != null) {
            parama.a(this.Dbu);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (this.Dbp != null) {
          this.Dbp.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bek();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.bej();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 3005;
    localWepkgCrossProcessTask.DaU.fYR = paramString1;
    localWepkgCrossProcessTask.DaU.pkgPath = paramString2;
    localWepkgCrossProcessTask.DaU.DbJ = paramBoolean;
    if (ai.ciE())
    {
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          this.Dbu.aLq();
          if (parama != null) {
            parama.a(this.Dbu);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (this.Dbp != null) {
          this.Dbp.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.bek();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.bej();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion aFr(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 3001;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE()) {
      localWepkgCrossProcessTask.aLq();
    }
    while (localWepkgCrossProcessTask.DaU == null)
    {
      AppMethodBeat.o(110737);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.DaU;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion aFs(String paramString)
  {
    AppMethodBeat.i(110738);
    ac.m("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 3002;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE()) {
      localWepkgCrossProcessTask.aLq();
    }
    while (localWepkgCrossProcessTask.DaU == null)
    {
      AppMethodBeat.o(110738);
      return null;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.DaU;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> aFt(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 4001;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE()) {
      localWepkgCrossProcessTask.aLq();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.DaY;
      AppMethodBeat.o(110743);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aFu(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 3003;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE())
    {
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          this.Dbv.aLq();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> aFv(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 4003;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE()) {
      localWepkgCrossProcessTask.aLq();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.DaY;
      AppMethodBeat.o(110746);
      return paramString;
      AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void aFw(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 2006;
    localWepkgCrossProcessTask.DaU.fYR = paramString;
    if (ai.ciE())
    {
      localWepkgCrossProcessTask.aLq();
      AppMethodBeat.o(110747);
      return;
    }
    AppBrandMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(110747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */