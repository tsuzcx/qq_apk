package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.iz.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.i.6;
import com.tencent.mm.plugin.wepkg.model.i.7;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
      if (!bu.isNullOrNil(str))
      {
        localStringBuffer1.append(str);
        localStringBuffer1.append(";");
        zg localzg = new zg();
        localzg.urm = str;
        localzg.Scene = paramInt1;
        WepkgVersion localWepkgVersion = i.aMn(str);
        if (localWepkgVersion == null)
        {
          localzg.Version = "";
          localLinkedList.add(localzg);
        }
        else
        {
          localzg.Version = localWepkgVersion.version;
          long l = localWepkgVersion.EYd;
          if (d.currentTime() >= l)
          {
            localLinkedList.add(localzg);
            i.aMq(str);
          }
          else
          {
            localStringBuffer2.append(str);
            localStringBuffer2.append(";");
          }
        }
      }
    }
    ae.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", new Object[] { localStringBuffer1.toString(), localStringBuffer2.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (!bu.ht(localLinkedList)) {
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
  
  private static void b(LinkedList<zg> paramLinkedList, int paramInt, boolean paramBoolean)
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
      zg localzg = (zg)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localzg.urm);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localzg.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localzg.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (ak.cpe())
    {
      d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.EYB.aOX();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    AppBrandMainProcessService.a(localWepkgNetSceneProcessTask);
    AppMethodBeat.o(110842);
  }
  
  public static void z(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(110839);
    if (bu.ht(paramList))
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
    private List<WepkgCheckReq> EYC;
    private boolean EYD;
    private int dQg;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.EYC = new ArrayList();
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
      paramParcel.writeList(this.EYC);
      paramParcel.writeInt(this.dQg);
      if (this.EYD) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(110835);
      if (bu.ht(this.EYC))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).funcId = 1313;
      ((b.a)localObject1).hQH = 0;
      ((b.a)localObject1).respCmdId = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new yo();
      Object localObject3 = this.EYC.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        zg localzg = new zg();
        localzg.urm = WepkgCheckReq.a(localWepkgCheckReq);
        localzg.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localzg.Scene = WepkgCheckReq.c(localWepkgCheckReq);
        ((yo)localObject2).Gqw.add(localzg);
      }
      ((b.a)localObject1).hQF = ((com.tencent.mm.bw.a)localObject2);
      ((b.a)localObject1).hQG = new yp();
      g.yxI.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).aDS();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hQE.hQJ == null))
          {
            ae.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hQE.hQJ });
            g.yxI.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (yp)paramAnonymousb.hQE.hQJ;
            d.caq().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (bu.ht(((yp)localObject3).Gqx))
                  {
                    ae.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((yp)localObject3).Gqx.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (clg)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((clg)localObject4).urm;
                      Object localObject6 = ((clg)localObject4).Hxw;
                      ego localego = ((clg)localObject4).Hxy;
                      if (!bu.isNullOrNil((String)localObject5))
                      {
                        if (localego != null)
                        {
                          if (localego.Iku)
                          {
                            ae.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            g.yxI.idkeyStat(859L, 17L, 1L, false);
                            if (((clg)localObject4).Hxx != null) {
                              ForceUpdateNotify.EL(((clg)localObject4).urm);
                            }
                          }
                          if (localego.Ikt)
                          {
                            c.fbI().aF((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((egs)localObject6).IkC != null))
                        {
                          if (bu.isNullOrNil(((egs)localObject6).IkC.Ikv))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).EN = 2004;
                            ((WepkgCrossProcessTask)localObject4).EXp.guO = ((String)localObject5);
                            if (ak.cpe()) {
                              d.caq().postToWorker(new i.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              g.yxI.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).kuv = new i.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).biw();
                              AppBrandMainProcessService.a((MainProcessTask)localObject4);
                            }
                          }
                          boolean bool2 = ((egs)localObject6).IkC.Ikw;
                          long l1 = ((egs)localObject6).IkC.Ikx;
                          long l2 = ((egs)localObject6).IkC.Iky;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).EN = 3004;
                          ((WepkgCrossProcessTask)localObject6).EXp.guO = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).EXp.EXX = bool2;
                          ((WepkgCrossProcessTask)localObject6).EXp.EXY = l1;
                          ((WepkgCrossProcessTask)localObject6).EXp.EXZ = l2;
                          if (ak.cpe())
                          {
                            ((WepkgCrossProcessTask)localObject6).aOX();
                            label435:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EN = 3009;
                            ((WepkgCrossProcessTask)localObject6).EXp.guO = ((String)localObject5);
                            if (!ak.cpe()) {
                              break label562;
                            }
                            ((WepkgCrossProcessTask)localObject6).aOX();
                            label473:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EN = 4006;
                            ((WepkgCrossProcessTask)localObject6).EXs.guO = ((String)localObject5);
                            if (!ak.cpe()) {
                              break label571;
                            }
                            ((WepkgCrossProcessTask)localObject6).aOX();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = h.a((clg)localObject4);
                              if (!bu.ht((List)localObject5)) {
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
                  ForceUpdateNotify.cGJ();
                  a.a.fbP().r((Set)localObject1);
                  if (!bu.ht((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (clg)((Iterator)localObject1).next();
                      localObject3 = j.fbO();
                      if ((localObject2 == null) || (((clg)localObject2).Hxx == null))
                      {
                        ae.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((j)localObject3).cB(((clg)localObject2).urm, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((clg)localObject2).Hxx.IkG;
                        localObject5 = ((clg)localObject2).Hxx.IkH;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          ae.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.fbI().aF(((clg)localObject2).urm, 2, 5);
                        }
                        else
                        {
                          i.a((clg)localObject2, i);
                          ae.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((j)localObject3).cB(((clg)localObject2).urm, false);
                            break;
                          case 1: 
                            if (d.cJ(ak.getContext())) {
                              ((j)localObject3).cB(((clg)localObject2).urm, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new iz();
                            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
                            if (((iz)localObject4).dwK.dwL) {
                              ((j)localObject3).cB(((clg)localObject2).urm, false);
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
            ae.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
            AppMethodBeat.o(110827);
          }
        }
      };
      if (ak.cpe())
      {
        x.a((com.tencent.mm.ak.b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.cI(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EYy = ((com.tencent.mm.ak.b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EYz = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EYw = 1;
      AppBrandMainProcessService.a((MainProcessTask)localObject3);
      AppMethodBeat.o(110835);
    }
    
    public final void aOY() {}
    
    public final void n(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.EYC == null) {
        this.EYC = new ArrayList();
      }
      paramParcel.readList(this.EYC, WepkgCheckReq.class.getClassLoader());
      this.dQg = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.EYD = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String guO;
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
        this.guO = paramParcel.readString();
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
        paramParcel.writeString(this.guO);
        paramParcel.writeString(this.version);
        paramParcel.writeInt(this.scene);
        AppMethodBeat.o(110831);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater
 * JD-Core Version:    0.7.0.1
 */