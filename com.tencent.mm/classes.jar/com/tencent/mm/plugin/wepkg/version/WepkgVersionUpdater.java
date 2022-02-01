package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.jo.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.model.j.6;
import com.tencent.mm.plugin.wepkg.model.j.7;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.protocal.protobuf.fbf;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.protocal.protobuf.fbl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class WepkgVersionUpdater
{
  public static void F(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(110839);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(110839);
      return;
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramList);
    a(localHashSet, paramInt, false);
    AppMethodBeat.o(110839);
  }
  
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
      if (!Util.isNullOrNil(str))
      {
        localStringBuffer1.append(str);
        localStringBuffer1.append(";");
        aav localaav = new aav();
        localaav.xJD = str;
        localaav.Scene = paramInt1;
        WepkgVersion localWepkgVersion = j.bcH(str);
        if (localWepkgVersion == null)
        {
          localaav.Version = "";
          localLinkedList.add(localaav);
        }
        else
        {
          localaav.Version = localWepkgVersion.version;
          long l = localWepkgVersion.JNU;
          if (com.tencent.mm.plugin.wepkg.utils.d.currentTime() >= l)
          {
            localLinkedList.add(localaav);
            j.bcK(str);
          }
          else
          {
            localStringBuffer2.append(str);
            localStringBuffer2.append(";");
          }
        }
      }
    }
    Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", new Object[] { localStringBuffer1.toString(), localStringBuffer2.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (!Util.isNullOrNil(localLinkedList)) {
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
  
  private static void b(LinkedList<aav> paramLinkedList, int paramInt, boolean paramBoolean)
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
      aav localaav = (aav)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localaav.xJD);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localaav.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localaav.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.JOr.bjj();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    AppBrandMainProcessService.a(localWepkgNetSceneProcessTask);
    AppMethodBeat.o(110842);
  }
  
  static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR;
    private List<WepkgCheckReq> JOs;
    private boolean JOt;
    private int eij;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.JOs = new ArrayList();
      AppMethodBeat.o(110833);
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110834);
      f(paramParcel);
      AppMethodBeat.o(110834);
    }
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110837);
      paramParcel.writeList(this.JOs);
      paramParcel.writeInt(this.eij);
      if (this.JOt) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(110835);
      if (Util.isNullOrNil(this.JOs))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new d.a();
      ((d.a)localObject1).funcId = 1313;
      ((d.a)localObject1).iLP = 0;
      ((d.a)localObject1).respCmdId = 0;
      ((d.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new aac();
      Object localObject3 = this.JOs.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        aav localaav = new aav();
        localaav.xJD = WepkgCheckReq.a(localWepkgCheckReq);
        localaav.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localaav.Scene = WepkgCheckReq.c(localWepkgCheckReq);
        ((aac)localObject2).Llo.add(localaav);
      }
      ((d.a)localObject1).iLN = ((com.tencent.mm.bw.a)localObject2);
      ((d.a)localObject1).iLO = new aad();
      h.CyF.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((d.a)localObject1).aXF();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousd.iLL.iLR == null))
          {
            Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousd.iLL.iLR });
            h.CyF.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (aad)paramAnonymousd.iLL.iLR;
            com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (Util.isNullOrNil(((aad)localObject3).Llp))
                  {
                    Log.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((aad)localObject3).Llp.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (dbq)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((dbq)localObject4).xJD;
                      Object localObject6 = ((dbq)localObject4).MGz;
                      fbe localfbe = ((dbq)localObject4).MGB;
                      if (!Util.isNullOrNil((String)localObject5))
                      {
                        if (localfbe != null)
                        {
                          if (localfbe.Nxv)
                          {
                            Log.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            h.CyF.idkeyStat(859L, 17L, 1L, false);
                            if (((dbq)localObject4).MGA != null) {
                              ForceUpdateNotify.add(((dbq)localObject4).xJD);
                            }
                          }
                          if (localfbe.Nxu)
                          {
                            c.gkN().aH((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((fbi)localObject6).NxD != null))
                        {
                          if (Util.isNullOrNil(((fbi)localObject6).NxD.Nxw))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).EX = 2004;
                            ((WepkgCrossProcessTask)localObject4).JNh.hhD = ((String)localObject5);
                            if (MMApplicationContext.isMMProcess()) {
                              com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new j.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              h.CyF.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).lyv = new j.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).bDJ();
                              AppBrandMainProcessService.a((MainProcessTask)localObject4);
                            }
                          }
                          boolean bool2 = ((fbi)localObject6).NxD.Nxx;
                          long l1 = ((fbi)localObject6).NxD.Nxy;
                          long l2 = ((fbi)localObject6).NxD.Nxz;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).EX = 3004;
                          ((WepkgCrossProcessTask)localObject6).JNh.hhD = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).JNh.JNP = bool2;
                          ((WepkgCrossProcessTask)localObject6).JNh.JNQ = l1;
                          ((WepkgCrossProcessTask)localObject6).JNh.JNR = l2;
                          if (MMApplicationContext.isMMProcess())
                          {
                            ((WepkgCrossProcessTask)localObject6).bjj();
                            label435:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EX = 3009;
                            ((WepkgCrossProcessTask)localObject6).JNh.hhD = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label562;
                            }
                            ((WepkgCrossProcessTask)localObject6).bjj();
                            label473:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EX = 4006;
                            ((WepkgCrossProcessTask)localObject6).JNk.hhD = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label571;
                            }
                            ((WepkgCrossProcessTask)localObject6).bjj();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = i.a((dbq)localObject4);
                              if (!Util.isNullOrNil((List)localObject5)) {
                                ((Set)localObject1).addAll((Collection)localObject5);
                              }
                            }
                            ((List)localObject2).add(localObject4);
                            break;
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                            break label435;
                            label562:
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                            break label473;
                            label571:
                            AppBrandMainProcessService.b((MainProcessTask)localObject6);
                          }
                        }
                      }
                    }
                  }
                  ForceUpdateNotify.dpY();
                  a.a.gkV().x((Set)localObject1);
                  if (!Util.isNullOrNil((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (dbq)((Iterator)localObject1).next();
                      localObject3 = k.gkU();
                      if ((localObject2 == null) || (((dbq)localObject2).MGA == null))
                      {
                        Log.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((k)localObject3).cW(((dbq)localObject2).xJD, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((dbq)localObject2).MGA.NxH;
                        localObject5 = ((dbq)localObject2).MGA.NxI;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.gkN().aH(((dbq)localObject2).xJD, 2, 5);
                        }
                        else
                        {
                          j.a((dbq)localObject2, i);
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((k)localObject3).cW(((dbq)localObject2).xJD, false);
                            break;
                          case 1: 
                            if (com.tencent.mm.plugin.wepkg.utils.d.isAppOnForeground(MMApplicationContext.getContext())) {
                              ((k)localObject3).cW(((dbq)localObject2).xJD, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new jo();
                            EventCenter.instance.publish((IEvent)localObject4);
                            if (((jo)localObject4).dOr.dOs) {
                              ((k)localObject3).cW(((dbq)localObject2).xJD, false);
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
            Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
            AppMethodBeat.o(110827);
          }
        }
      };
      if (MMApplicationContext.isMMProcess())
      {
        aa.a((com.tencent.mm.ak.d)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      com.tencent.mm.plugin.wepkg.utils.d.cP(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).JOo = ((com.tencent.mm.ak.d)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).JOp = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).JOm = 1;
      AppBrandMainProcessService.a((MainProcessTask)localObject3);
      AppMethodBeat.o(110835);
    }
    
    public final void bjk() {}
    
    public final void p(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.JOs == null) {
        this.JOs = new ArrayList();
      }
      paramParcel.readList(this.JOs, WepkgCheckReq.class.getClassLoader());
      this.eij = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.JOt = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String hhD;
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
        this.hhD = paramParcel.readString();
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
        paramParcel.writeString(this.hhD);
        paramParcel.writeString(this.version);
        paramParcel.writeInt(this.scene);
        AppMethodBeat.o(110831);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater
 * JD-Core Version:    0.7.0.1
 */