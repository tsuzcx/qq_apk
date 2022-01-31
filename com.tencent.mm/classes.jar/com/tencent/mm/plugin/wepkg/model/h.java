package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt2, a parama)
  {
    AppMethodBeat.i(63583);
    WepkgDownloadProcessTask localWepkgDownloadProcessTask = new WepkgDownloadProcessTask();
    localWepkgDownloadProcessTask.fileType = paramInt1;
    localWepkgDownloadProcessTask.cNP = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.vGi = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.cqq = paramString5;
    localWepkgDownloadProcessTask.vFT = paramInt2;
    if (ah.brt())
    {
      d.aNS().ac(new h.1(localWepkgDownloadProcessTask, parama, paramInt1, paramString1, paramString2, paramString3, paramLong, paramString4, paramString5, paramInt2));
      AppMethodBeat.o(63583);
      return;
    }
    localWepkgDownloadProcessTask.hxp = new h.2(parama, localWepkgDownloadProcessTask);
    localWepkgDownloadProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgDownloadProcessTask);
    AppMethodBeat.o(63583);
  }
  
  public static void a(bml parambml, int paramInt)
  {
    AppMethodBeat.i(63584);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 2002;
    Object localObject1 = localWepkgCrossProcessTask.vGb;
    Object localObject3;
    Object localObject2;
    if (parambml != null)
    {
      ((WepkgVersion)localObject1).ezY = parambml.nqD;
      localObject3 = parambml.xAN;
      localObject2 = parambml.xAO;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((cyu)localObject3).fKw;
        localObject3 = ((cyu)localObject3).yfQ;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((cyr)localObject3).yfJ;
          ((WepkgVersion)localObject1).vGJ = ((cyr)localObject3).yfK;
          ((WepkgVersion)localObject1).vGK = ((cyr)localObject3).yfL;
          ((WepkgVersion)localObject1).vGL = ((cyr)localObject3).yfM;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).vGN = ((cyx)localObject2).yfT;
        ((WepkgVersion)localObject1).charset = ((cyx)localObject2).yew;
        localObject3 = ((cyx)localObject2).yfU;
        if ((localObject3 == null) || (((cyp)localObject3).yfG == null) || (bo.isNullOrNil(((cyp)localObject3).yfG.wxa))) {
          break label649;
        }
        ((WepkgVersion)localObject1).cqq = ((cyp)localObject3).yfG.Md5;
        ((WepkgVersion)localObject1).downloadUrl = ((cyp)localObject3).yfG.wxa;
        ((WepkgVersion)localObject1).vGO = ((cyp)localObject3).yfG.yfO;
        ((WepkgVersion)localObject1).vFT = ((cyp)localObject3).yfG.yfN;
        ((WepkgVersion)localObject1).vGQ = false;
        localObject2 = ((cyx)localObject2).yfV;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).vGS = ((cyw)localObject2).yfS;
        }
        if ((localObject2 == null) || (bo.es(((cyw)localObject2).yfR)) || (!((cyw)localObject2).yfS)) {
          break label657;
        }
      }
    }
    label649:
    label657:
    for (((WepkgVersion)localObject1).vGR = false;; ((WepkgVersion)localObject1).vGR = true)
    {
      ((WepkgVersion)localObject1).vGT = 0;
      ((WepkgVersion)localObject1).cNS = paramInt;
      localObject1 = localWepkgCrossProcessTask.vGd;
      if ((parambml != null) && (parambml.xAO != null) && (parambml.xAO.yfU != null) && (parambml.xAO.yfU.yfG != null) && (parambml.xAO.yfU.yfG.yfP != null) && (!bo.isNullOrNil(parambml.xAO.yfU.yfG.yfP.wxa)))
      {
        localObject2 = parambml.xAO.yfU.yfG.yfP;
        ((WePkgDiffInfo)localObject1).version = parambml.xAN.yfQ.yfJ;
        ((WePkgDiffInfo)localObject1).ezY = parambml.nqD;
        ((WePkgDiffInfo)localObject1).downloadUrl = ((cyv)localObject2).wxa;
        ((WePkgDiffInfo)localObject1).cqq = ((cyv)localObject2).Md5;
        ((WePkgDiffInfo)localObject1).fileSize = ((cyv)localObject2).yfO;
        ((WePkgDiffInfo)localObject1).vFT = ((cyv)localObject2).yfN;
      }
      localObject2 = parambml.xAO.yfV;
      if ((localObject2 == null) || (bo.es(((cyw)localObject2).yfR))) {
        break label670;
      }
      localObject1 = new ArrayList();
      localObject2 = ((cyw)localObject2).yfR.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (cyt)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = parambml.nqD;
        String str2 = parambml.xAN.yfQ.yfJ;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.hQ(str1, ((cyt)localObject4).wWA);
          ((WepkgPreloadFile)localObject3).ezY = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).vGh = ((cyt)localObject4).wWA;
          ((WepkgPreloadFile)localObject3).mimeType = ((cyt)localObject4).wWC;
          localObject4 = ((cyt)localObject4).yfG;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).cqq = ((cys)localObject4).Md5;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((cys)localObject4).wxa;
            ((WepkgPreloadFile)localObject3).size = ((cys)localObject4).yfO;
            ((WepkgPreloadFile)localObject3).vFT = ((cys)localObject4).yfN;
          }
          ((WepkgPreloadFile)localObject3).vGu = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).vGQ = true;
      break;
    }
    localWepkgCrossProcessTask.vGf = ((List)localObject1);
    label670:
    if (ah.brt())
    {
      localWepkgCrossProcessTask.ata();
      AppMethodBeat.o(63584);
      return;
    }
    WepkgMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(63584);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(63581);
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3002;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt())
    {
      localWepkgCrossProcessTask.ata();
      AppMethodBeat.o(63581);
      return;
    }
    localWepkgCrossProcessTask.hxp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63574);
        if (this.vGw != null) {
          this.vGw.a(localWepkgCrossProcessTask);
        }
        localWepkgCrossProcessTask.aBk();
        AppMethodBeat.o(63574);
      }
    };
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63581);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(63586);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 4002;
    localWepkgCrossProcessTask.vGe.ezY = paramString1;
    localWepkgCrossProcessTask.vGe.vGh = paramString2;
    localWepkgCrossProcessTask.vGe.filePath = paramString3;
    localWepkgCrossProcessTask.vGe.vGu = false;
    if (ah.brt())
    {
      d.aNS().ac(new h.3(localWepkgCrossProcessTask, parama));
      AppMethodBeat.o(63586);
      return;
    }
    localWepkgCrossProcessTask.hxp = new h.4(parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63586);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(63582);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3005;
    localWepkgCrossProcessTask.vGb.ezY = paramString1;
    localWepkgCrossProcessTask.vGb.gUy = paramString2;
    localWepkgCrossProcessTask.vGb.vGQ = paramBoolean;
    if (ah.brt())
    {
      d.aNS().ac(new h.9(localWepkgCrossProcessTask, parama));
      AppMethodBeat.o(63582);
      return;
    }
    localWepkgCrossProcessTask.hxp = new h.10(parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63582);
  }
  
  public static WepkgVersion akF(String paramString)
  {
    AppMethodBeat.i(63579);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3001;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt()) {
      localWepkgCrossProcessTask.ata();
    }
    while (localWepkgCrossProcessTask.vGb == null)
    {
      AppMethodBeat.o(63579);
      return null;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.vGb;
    AppMethodBeat.o(63579);
    return paramString;
  }
  
  public static WepkgVersion akG(String paramString)
  {
    AppMethodBeat.i(63580);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3002;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt()) {
      localWepkgCrossProcessTask.ata();
    }
    while (localWepkgCrossProcessTask.vGb == null)
    {
      AppMethodBeat.o(63580);
      return null;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
    paramString = localWepkgCrossProcessTask.vGb;
    AppMethodBeat.o(63580);
    return paramString;
  }
  
  public static List<WepkgPreloadFile> akH(String paramString)
  {
    AppMethodBeat.i(63585);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 4001;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt()) {
      localWepkgCrossProcessTask.ata();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.vGf;
      AppMethodBeat.o(63585);
      return paramString;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void akI(String paramString)
  {
    AppMethodBeat.i(63587);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3003;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt())
    {
      d.aNS().ac(new h.5(localWepkgCrossProcessTask));
      AppMethodBeat.o(63587);
      return;
    }
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63587);
  }
  
  public static List<WepkgPreloadFile> akJ(String paramString)
  {
    AppMethodBeat.i(63588);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 4003;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt()) {
      localWepkgCrossProcessTask.ata();
    }
    for (;;)
    {
      paramString = localWepkgCrossProcessTask.vGf;
      AppMethodBeat.o(63588);
      return paramString;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void akK(String paramString)
  {
    AppMethodBeat.i(63589);
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 2006;
    localWepkgCrossProcessTask.vGb.ezY = paramString;
    if (ah.brt())
    {
      localWepkgCrossProcessTask.ata();
      AppMethodBeat.o(63589);
      return;
    }
    WepkgMainProcessService.b(localWepkgCrossProcessTask);
    AppMethodBeat.o(63589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h
 * JD-Core Version:    0.7.0.1
 */