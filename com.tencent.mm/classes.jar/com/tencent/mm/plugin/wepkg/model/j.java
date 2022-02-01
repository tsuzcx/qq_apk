package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.gip;
import com.tencent.mm.protocal.protobuf.gir;
import com.tencent.mm.protocal.protobuf.gis;
import com.tencent.mm.protocal.protobuf.git;
import com.tencent.mm.protocal.protobuf.giu;
import com.tencent.mm.protocal.protobuf.giv;
import com.tencent.mm.protocal.protobuf.giw;
import com.tencent.mm.protocal.protobuf.gix;
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
    localWepkgDownloadProcessTask.iiJ = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.XGf = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.md5 = paramString5;
    localWepkgDownloadProcessTask.XFQ = paramInt2;
    if (MMApplicationContext.isMMProcess())
    {
      d.dqg().postToWorker(new Runnable()
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
              j.this.iiJ = paramAnonymous2String1;
              j.this.pkgPath = paramAnonymous2String2;
              j.this.XGg = paramAnonymous2RetCode;
              if (j.1.this.XGt != null) {
                j.1.this.XGt.a(j.this);
              }
              AppMethodBeat.o(110724);
            }
          };
          if (paramInt1 == 1)
          {
            WePkgDownloader.iFl().a(paramString1, local1);
            AppMethodBeat.o(110725);
            return;
          }
          WePkgDownloader.iFl().a(paramInt1, Util.nullAsNil(paramString1), "", Util.nullAsNil(paramString2), Util.nullAsNil(paramString3), paramLong, Util.nullAsNil(paramString5), "", Util.nullAsNil(paramInt2), this.XGw, local1);
          AppMethodBeat.o(110725);
        }
      });
      AppMethodBeat.o(110741);
      return;
    }
    localWepkgDownloadProcessTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110726);
        if (j.this != null) {
          j.this.a(localWepkgDownloadProcessTask);
        }
        localWepkgDownloadProcessTask.cpx();
        AppMethodBeat.o(110726);
      }
    };
    localWepkgDownloadProcessTask.bQt();
    AppMethodBeat.o(110741);
  }
  
  public static void a(edq paramedq, int paramInt)
  {
    AppMethodBeat.i(110742);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 2002;
    Object localObject1 = localWepkgCrossProcessTask.XFY;
    Object localObject3;
    Object localObject2;
    if (paramedq != null)
    {
      ((WepkgVersion)localObject1).mtT = paramedq.IHV;
      localObject3 = paramedq.abiL;
      localObject2 = paramedq.abiM;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((giu)localObject3).oOI;
        localObject3 = ((giu)localObject3).acfi;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((gir)localObject3).acfb;
          ((WepkgVersion)localObject1).XGG = ((gir)localObject3).acfc;
          ((WepkgVersion)localObject1).XGH = ((gir)localObject3).acfd;
          ((WepkgVersion)localObject1).XGI = ((gir)localObject3).acfe;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).domain = ((gix)localObject2).acfl;
        ((WepkgVersion)localObject1).charset = ((gix)localObject2).accA;
        localObject3 = ((gix)localObject2).acfm;
        if ((localObject3 == null) || (((gip)localObject3).aceY == null) || (Util.isNullOrNil(((gip)localObject3).aceY.IcC))) {
          break label649;
        }
        ((WepkgVersion)localObject1).md5 = ((gip)localObject3).aceY.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((gip)localObject3).aceY.IcC;
        ((WepkgVersion)localObject1).XGK = ((gip)localObject3).aceY.acfg;
        ((WepkgVersion)localObject1).XFQ = ((gip)localObject3).aceY.acff;
        ((WepkgVersion)localObject1).XGM = false;
        localObject2 = ((gix)localObject2).acfn;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).XGO = ((giw)localObject2).acfk;
        }
        if ((localObject2 == null) || (Util.isNullOrNil(((giw)localObject2).acfj)) || (!((giw)localObject2).acfk)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).XGN = false;; ((WepkgVersion)localObject1).XGN = true)
    {
      ((WepkgVersion)localObject1).XGP = 0;
      ((WepkgVersion)localObject1).iiM = paramInt;
      localObject1 = localWepkgCrossProcessTask.XGa;
      if ((paramedq != null) && (paramedq.abiM != null) && (paramedq.abiM.acfm != null) && (paramedq.abiM.acfm.aceY != null) && (paramedq.abiM.acfm.aceY.acfh != null) && (!Util.isNullOrNil(paramedq.abiM.acfm.aceY.acfh.IcC)))
      {
        localObject2 = paramedq.abiM.acfm.aceY.acfh;
        ((WePkgDiffInfo)localObject1).version = paramedq.abiL.acfi.acfb;
        ((WePkgDiffInfo)localObject1).mtT = paramedq.IHV;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((giv)localObject2).IcC;
        ((WePkgDiffInfo)localObject1).md5 = ((giv)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((giv)localObject2).acfg;
        ((WePkgDiffInfo)localObject1).XFQ = ((giv)localObject2).acff;
      }
      localObject2 = paramedq.abiM.acfn;
      if ((localObject2 == null) || (Util.isNullOrNil(((giw)localObject2).acfj))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((giw)localObject2).acfj.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (git)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = paramedq.IHV;
        String str2 = paramedq.abiL.acfi.acfb;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.oO(str1, ((git)localObject4).ZCY);
          ((WepkgPreloadFile)localObject3).mtT = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).XGe = ((git)localObject4).ZCY;
          ((WepkgPreloadFile)localObject3).mimeType = ((git)localObject4).ZDa;
          localObject4 = ((git)localObject4).aceY;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).md5 = ((gis)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((gis)localObject4).IcC;
            ((WepkgPreloadFile)localObject3).size = ((gis)localObject4).acfg;
            ((WepkgPreloadFile)localObject3).XFQ = ((gis)localObject4).acff;
          }
          ((WepkgPreloadFile)localObject3).XGr = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).XGM = true;
      break;
    }
    localWepkgCrossProcessTask.XGc = ((List)localObject1);
    label670:
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.asn();
      AppMethodBeat.o(110742);
      return;
    }
    localWepkgCrossProcessTask.cpB();
    AppMethodBeat.o(110742);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110739);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 3002;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.asn();
      AppMethodBeat.o(110739);
      return;
    }
    localWepkgCrossProcessTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110732);
        if (j.this != null) {
          j.this.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.cpx();
        AppMethodBeat.o(110732);
      }
    };
    localWepkgCrossProcessTask.bQt();
    AppMethodBeat.o(110739);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(110744);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 4002;
    localWepkgCrossProcessTask.XGb.mtT = paramString1;
    localWepkgCrossProcessTask.XGb.XGe = paramString2;
    localWepkgCrossProcessTask.XGb.filePath = paramString3;
    localWepkgCrossProcessTask.XGb.XGr = false;
    if (MMApplicationContext.isMMProcess())
    {
      d.dqg().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110727);
          j.this.asn();
          if (parama != null) {
            parama.a(j.this);
          }
          AppMethodBeat.o(110727);
        }
      });
      AppMethodBeat.o(110744);
      return;
    }
    localWepkgCrossProcessTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110728);
        if (j.this != null) {
          j.this.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.cpx();
        AppMethodBeat.o(110728);
      }
    };
    localWepkgCrossProcessTask.bQt();
    AppMethodBeat.o(110744);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(110740);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 3005;
    localWepkgCrossProcessTask.XFY.mtT = paramString1;
    localWepkgCrossProcessTask.XFY.pkgPath = paramString2;
    localWepkgCrossProcessTask.XFY.XGM = paramBoolean;
    if (MMApplicationContext.isMMProcess())
    {
      d.dqg().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110733);
          j.this.asn();
          if (parama != null) {
            parama.a(j.this);
          }
          AppMethodBeat.o(110733);
        }
      });
      AppMethodBeat.o(110740);
      return;
    }
    localWepkgCrossProcessTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110734);
        if (j.this != null) {
          j.this.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.cpx();
        AppMethodBeat.o(110734);
      }
    };
    localWepkgCrossProcessTask.bQt();
    AppMethodBeat.o(110740);
  }
  
  public static WepkgVersion bou(String paramString)
  {
    AppMethodBeat.i(110737);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 3001;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.asn();
    }
    while (localWepkgCrossProcessTask.XFY == null)
    {
      AppMethodBeat.o(110737);
      return null;
      localWepkgCrossProcessTask.cpB();
    }
    paramString = localWepkgCrossProcessTask.XFY;
    AppMethodBeat.o(110737);
    return paramString;
  }
  
  public static WepkgVersion bov(String paramString)
  {
    AppMethodBeat.i(110738);
    Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 3002;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.asn();
    }
    while (localWepkgCrossProcessTask.XFY == null)
    {
      AppMethodBeat.o(110738);
      return null;
      localWepkgCrossProcessTask.cpB();
    }
    paramString = localWepkgCrossProcessTask.XFY;
    AppMethodBeat.o(110738);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> bow(String paramString)
  {
    AppMethodBeat.i(110743);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 4001;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.asn();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.XGc;
      AppMethodBeat.o(110743);
      return paramString;
      localWepkgCrossProcessTask.cpB();
    }
  }
  
  public static void box(String paramString)
  {
    AppMethodBeat.i(110745);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 3003;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      d.dqg().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110729);
          j.this.asn();
          AppMethodBeat.o(110729);
        }
      });
      AppMethodBeat.o(110745);
      return;
    }
    localWepkgCrossProcessTask.bQt();
    AppMethodBeat.o(110745);
  }
  
  public static List<WepkgPreloadFile> boy(String paramString)
  {
    AppMethodBeat.i(110746);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 4003;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess()) {
      localWepkgCrossProcessTask.asn();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.XGc;
      AppMethodBeat.o(110746);
      return paramString;
      localWepkgCrossProcessTask.cpB();
    }
  }
  
  public static void boz(String paramString)
  {
    AppMethodBeat.i(110747);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 2006;
    localWepkgCrossProcessTask.XFY.mtT = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      localWepkgCrossProcessTask.asn();
      AppMethodBeat.o(110747);
      return;
    }
    localWepkgCrossProcessTask.cpB();
    AppMethodBeat.o(110747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */