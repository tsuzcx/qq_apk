package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.cla;
import com.tencent.mm.protocal.c.clc;
import com.tencent.mm.protocal.c.cld;
import com.tencent.mm.protocal.c.cle;
import com.tencent.mm.protocal.c.clf;
import com.tencent.mm.protocal.c.clg;
import com.tencent.mm.protocal.c.clh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  public static WepkgVersion Vj(String paramString)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 3001;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV()) {
      localWepkgCrossProcessTask.Zu();
    }
    while (localWepkgCrossProcessTask.rPj == null)
    {
      return null;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
    return localWepkgCrossProcessTask.rPj;
  }
  
  public static WepkgVersion Vk(String paramString)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 3002;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV()) {
      localWepkgCrossProcessTask.Zu();
    }
    while (localWepkgCrossProcessTask.rPj == null)
    {
      return null;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
    return localWepkgCrossProcessTask.rPj;
  }
  
  public static List<WepkgPreloadFile> Vl(String paramString)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 4001;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV()) {
      localWepkgCrossProcessTask.Zu();
    }
    for (;;)
    {
      return localWepkgCrossProcessTask.rPm;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static List<WepkgPreloadFile> Vm(String paramString)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 4003;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV()) {
      localWepkgCrossProcessTask.Zu();
    }
    for (;;)
    {
      return localWepkgCrossProcessTask.rPm;
      WepkgMainProcessService.b(localWepkgCrossProcessTask);
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt2, a parama)
  {
    WepkgDownloadProcessTask localWepkgDownloadProcessTask = new WepkgDownloadProcessTask();
    localWepkgDownloadProcessTask.fileType = paramInt1;
    localWepkgDownloadProcessTask.cfi = paramString1;
    localWepkgDownloadProcessTask.downloadUrl = paramString3;
    localWepkgDownloadProcessTask.rPp = paramLong;
    localWepkgDownloadProcessTask.version = paramString4;
    localWepkgDownloadProcessTask.bIW = paramString5;
    localWepkgDownloadProcessTask.rPq = paramInt2;
    if (ae.cqV())
    {
      d.DS().O(new f.14(paramInt1, paramString1, paramString2, paramString3, paramLong, paramString4, paramString5, paramInt2, localWepkgDownloadProcessTask, parama));
      return;
    }
    localWepkgDownloadProcessTask.gfD = new f.1(parama, localWepkgDownloadProcessTask);
    localWepkgDownloadProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgDownloadProcessTask);
  }
  
  public static void a(bet parambet, int paramInt)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 2002;
    Object localObject1 = localWepkgCrossProcessTask.rPj;
    Object localObject3;
    Object localObject2;
    if (parambet != null)
    {
      ((WepkgVersion)localObject1).dCD = parambet.kSE;
      localObject3 = parambet.tzD;
      localObject2 = parambet.tzE;
      if (localObject3 != null)
      {
        ((WepkgVersion)localObject1).appId = ((clf)localObject3).euK;
        localObject3 = ((clf)localObject3).tYx;
        if (localObject3 != null)
        {
          ((WepkgVersion)localObject1).version = ((clc)localObject3).tYr;
          ((WepkgVersion)localObject1).rPS = ((clc)localObject3).tYs;
          ((WepkgVersion)localObject1).rPT = ((clc)localObject3).tYt;
          ((WepkgVersion)localObject1).rPU = ((clc)localObject3).tYu;
        }
      }
      if (localObject2 != null)
      {
        ((WepkgVersion)localObject1).ceG = ((clh)localObject2).tYA;
        ((WepkgVersion)localObject1).charset = ((clh)localObject2).tXb;
        localObject3 = ((clh)localObject2).tYB;
        if ((localObject3 == null) || (((cla)localObject3).tYo == null) || (bk.bl(((cla)localObject3).tYo.sww))) {
          break label494;
        }
        ((WepkgVersion)localObject1).bIW = ((cla)localObject3).tYo.jnU;
        ((WepkgVersion)localObject1).downloadUrl = ((cla)localObject3).tYo.sww;
        ((WepkgVersion)localObject1).rPW = ((cla)localObject3).tYo.tYw;
        ((WepkgVersion)localObject1).rPq = ((cla)localObject3).tYo.tYv;
        ((WepkgVersion)localObject1).rPY = false;
        localObject2 = ((clh)localObject2).tYC;
        if (localObject2 != null) {
          ((WepkgVersion)localObject1).rQa = ((clg)localObject2).tYz;
        }
        if ((localObject2 == null) || (bk.dk(((clg)localObject2).tYy)) || (!((clg)localObject2).tYz)) {
          break label502;
        }
      }
    }
    label494:
    label502:
    for (((WepkgVersion)localObject1).rPZ = false;; ((WepkgVersion)localObject1).rPZ = true)
    {
      ((WepkgVersion)localObject1).rQb = 0;
      ((WepkgVersion)localObject1).cfl = paramInt;
      localObject2 = parambet.tzE.tYC;
      if ((localObject2 == null) || (bk.dk(((clg)localObject2).tYy))) {
        break label515;
      }
      localObject1 = new ArrayList();
      localObject2 = ((clg)localObject2).tYy.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (cle)((Iterator)localObject2).next();
        localObject3 = new WepkgPreloadFile();
        String str1 = parambet.kSE;
        String str2 = parambet.tzD.tYx.tYr;
        if (localObject4 != null)
        {
          ((WepkgPreloadFile)localObject3).key = d.fO(str1, ((cle)localObject4).sYw);
          ((WepkgPreloadFile)localObject3).dCD = str1;
          ((WepkgPreloadFile)localObject3).version = str2;
          ((WepkgPreloadFile)localObject3).rPo = ((cle)localObject4).sYw;
          ((WepkgPreloadFile)localObject3).mimeType = ((cle)localObject4).sYy;
          localObject4 = ((cle)localObject4).tYo;
          if (localObject4 != null)
          {
            ((WepkgPreloadFile)localObject3).bIW = ((cld)localObject4).jnU;
            ((WepkgPreloadFile)localObject3).downloadUrl = ((cld)localObject4).sww;
            ((WepkgPreloadFile)localObject3).size = ((cld)localObject4).tYw;
            ((WepkgPreloadFile)localObject3).rPq = ((cld)localObject4).tYv;
          }
          ((WepkgPreloadFile)localObject3).rPD = false;
        }
        ((List)localObject1).add(localObject3);
      }
      ((WepkgVersion)localObject1).rPY = true;
      break;
    }
    localWepkgCrossProcessTask.rPm = ((List)localObject1);
    label515:
    if (ae.cqV())
    {
      localWepkgCrossProcessTask.Zu();
      return;
    }
    WepkgMainProcessService.b(localWepkgCrossProcessTask);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 4002;
    localWepkgCrossProcessTask.rPl.dCD = paramString1;
    localWepkgCrossProcessTask.rPl.rPo = paramString2;
    localWepkgCrossProcessTask.rPl.filePath = paramString3;
    localWepkgCrossProcessTask.rPl.rPD = false;
    if (ae.cqV())
    {
      d.DS().O(new f.6(localWepkgCrossProcessTask, parama));
      return;
    }
    localWepkgCrossProcessTask.gfD = new f.7(parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 3005;
    localWepkgCrossProcessTask.rPj.dCD = paramString1;
    localWepkgCrossProcessTask.rPj.fCl = paramString2;
    localWepkgCrossProcessTask.rPj.rPY = paramBoolean;
    if (ae.cqV())
    {
      d.DS().O(new f.10(localWepkgCrossProcessTask, parama));
      return;
    }
    localWepkgCrossProcessTask.gfD = new f.11(parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */