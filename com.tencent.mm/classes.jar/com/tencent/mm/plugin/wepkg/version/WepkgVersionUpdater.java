package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.ij.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.i.6;
import com.tencent.mm.plugin.wepkg.model.i.7;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.dte;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class WepkgVersionUpdater
{
  public static void a(Set<String> paramSet, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110841);
    if (paramSet == null)
    {
      AppMethodBeat.o(110841);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!bt.isNullOrNil(str))
      {
        localStringBuffer1.append(str);
        localStringBuffer1.append(";");
        ws localws = new ws();
        localws.sag = str;
        localws.Scene = paramInt1;
        WepkgVersion localWepkgVersion = i.azZ(str);
        if (localWepkgVersion == null)
        {
          localws.Version = "";
          localLinkedList.add(localws);
        }
        else
        {
          localws.Version = localWepkgVersion.version;
          long l = localWepkgVersion.BJz;
          if (d.bqp() >= l)
          {
            localLinkedList.add(localws);
            i.aAc(str);
          }
          else
          {
            localStringBuffer2.append(str);
            localStringBuffer2.append(";");
          }
        }
      }
    }
    ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", new Object[] { localStringBuffer1.toString(), localStringBuffer2.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (!bt.gL(localLinkedList)) {
      b(localLinkedList, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(110841);
  }
  
  public static void a(Set<String> paramSet, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110840);
    a(paramSet, paramInt, -1, paramBoolean);
    AppMethodBeat.o(110840);
  }
  
  private static void b(LinkedList<ws> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110842);
    if (paramLinkedList.size() == 0)
    {
      AppMethodBeat.o(110842);
      return;
    }
    WepkgNetSceneProcessTask localWepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramInt);
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramBoolean);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      ws localws = (ws)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localws.sag);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localws.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localws.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (aj.cbv())
    {
      d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.BJW.aEz();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    AppBrandMainProcessService.a(localWepkgNetSceneProcessTask);
    AppMethodBeat.o(110842);
  }
  
  public static void w(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(110839);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(110839);
      return;
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramList);
    a(localHashSet, paramInt, false);
    AppMethodBeat.o(110839);
  }
  
  static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR;
    private List<WepkgCheckReq> BJX;
    private boolean BJY;
    private int dER;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.BJX = new ArrayList();
      AppMethodBeat.o(110833);
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110834);
      e(paramParcel);
      AppMethodBeat.o(110834);
    }
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110837);
      paramParcel.writeList(this.BJX);
      paramParcel.writeInt(this.dER);
      if (this.BJY) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void aEA() {}
    
    public final void aEz()
    {
      AppMethodBeat.i(110835);
      if (bt.gL(this.BJX))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).funcId = 1313;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new wc();
      Object localObject3 = this.BJX.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        ws localws = new ws();
        localws.sag = WepkgCheckReq.a(localWepkgCheckReq);
        localws.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localws.Scene = WepkgCheckReq.c(localWepkgCheckReq);
        ((wc)localObject2).CYe.add(localws);
      }
      ((b.a)localObject1).gUU = ((com.tencent.mm.bx.a)localObject2);
      ((b.a)localObject1).gUV = new wd();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).atI();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.gUT.gUX == null))
          {
            ad.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.gUT.gUX });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (wd)paramAnonymousb.gUT.gUX;
            d.bNl().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (bt.gL(((wd)localObject3).CYf))
                  {
                    ad.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((wd)localObject3).CYf.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (cao)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((cao)localObject4).sag;
                      Object localObject6 = ((cao)localObject4).DWY;
                      dte localdte = ((cao)localObject4).DXa;
                      if (!bt.isNullOrNil((String)localObject5))
                      {
                        if (localdte != null)
                        {
                          if (localdte.EHU)
                          {
                            ad.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 17L, 1L, false);
                            if (((cao)localObject4).DWZ != null) {
                              ForceUpdateNotify.xe(((cao)localObject4).sag);
                            }
                          }
                          if (localdte.EHT)
                          {
                            c.etK().fn((String)localObject5, 2);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((dti)localObject6).EIc != null))
                        {
                          if (bt.isNullOrNil(((dti)localObject6).EIc.EHV))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).BX = 2004;
                            ((WepkgCrossProcessTask)localObject4).BIL.fUW = ((String)localObject5);
                            if (aj.cbv()) {
                              d.bNl().postToWorker(new i.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).jwt = new i.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).aXm();
                              AppBrandMainProcessService.a((MainProcessTask)localObject4);
                            }
                          }
                          boolean bool2 = ((dti)localObject6).EIc.EHW;
                          long l1 = ((dti)localObject6).EIc.EHX;
                          long l2 = ((dti)localObject6).EIc.EHY;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).BX = 3004;
                          ((WepkgCrossProcessTask)localObject6).BIL.fUW = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).BIL.BJt = bool2;
                          ((WepkgCrossProcessTask)localObject6).BIL.BJu = l1;
                          ((WepkgCrossProcessTask)localObject6).BIL.BJv = l2;
                          if (aj.cbv())
                          {
                            ((WepkgCrossProcessTask)localObject6).aEz();
                            label434:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).BX = 3009;
                            ((WepkgCrossProcessTask)localObject6).BIL.fUW = ((String)localObject5);
                            if (!aj.cbv()) {
                              break label561;
                            }
                            ((WepkgCrossProcessTask)localObject6).aEz();
                            label472:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).BX = 4006;
                            ((WepkgCrossProcessTask)localObject6).BIO.fUW = ((String)localObject5);
                            if (!aj.cbv()) {
                              break label570;
                            }
                            ((WepkgCrossProcessTask)localObject6).aEz();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = com.tencent.mm.plugin.wepkg.model.h.a((cao)localObject4);
                              if (!bt.gL((List)localObject5)) {
                                ((Set)localObject1).addAll((Collection)localObject5);
                              }
                            }
                            ((List)localObject2).add(localObject4);
                            break;
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                            break label434;
                            label561:
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                            break label472;
                            label570:
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                          }
                        }
                      }
                    }
                  }
                  ForceUpdateNotify.cot();
                  a.a.etQ().j((Set)localObject1);
                  if (!bt.gL((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (cao)((Iterator)localObject1).next();
                      localObject3 = j.etP();
                      if ((localObject2 == null) || (((cao)localObject2).DWZ == null))
                      {
                        ad.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((j)localObject3).cm(((cao)localObject2).sag, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((cao)localObject2).DWZ.EIg;
                        localObject5 = ((cao)localObject2).DWZ.EIh;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          ad.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.etK().fn(((cao)localObject2).sag, 2);
                        }
                        else
                        {
                          i.a((cao)localObject2, i);
                          ad.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((j)localObject3).cm(((cao)localObject2).sag, false);
                            break;
                          case 1: 
                            if (d.cB(aj.getContext())) {
                              ((j)localObject3).cm(((cao)localObject2).sag, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new ij();
                            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject4);
                            if (((ij)localObject4).dmk.dml) {
                              ((j)localObject3).cm(((cao)localObject2).sag, false);
                            }
                            break;
                          }
                        }
                      }
                    }
                  }
                }
                AppMethodBeat.o(110826);
              }
            });
            AppMethodBeat.o(110827);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
            AppMethodBeat.o(110827);
          }
        }
      };
      if (aj.cbv())
      {
        x.a((com.tencent.mm.al.b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.cG(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).BJT = ((com.tencent.mm.al.b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).BJU = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).BJR = 1;
      AppBrandMainProcessService.a((MainProcessTask)localObject3);
      AppMethodBeat.o(110835);
    }
    
    public final void m(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.BJX == null) {
        this.BJX = new ArrayList();
      }
      paramParcel.readList(this.BJX, WepkgCheckReq.class.getClassLoader());
      this.dER = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.BJY = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String fUW;
      private int scene;
      private String version;
      
      static
      {
        AppMethodBeat.i(110832);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(110832);
      }
      
      private WepkgCheckReq() {}
      
      private WepkgCheckReq(Parcel paramParcel)
      {
        AppMethodBeat.i(110830);
        this.fUW = paramParcel.readString();
        this.version = paramParcel.readString();
        this.scene = paramParcel.readInt();
        AppMethodBeat.o(110830);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(110831);
        paramParcel.writeString(this.fUW);
        paramParcel.writeString(this.version);
        paramParcel.writeInt(this.scene);
        AppMethodBeat.o(110831);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater
 * JD-Core Version:    0.7.0.1
 */