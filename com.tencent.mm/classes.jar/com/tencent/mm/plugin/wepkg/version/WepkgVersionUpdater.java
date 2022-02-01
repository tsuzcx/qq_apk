package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.iq.a;
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
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
      if (!bs.isNullOrNil(str))
      {
        localStringBuffer1.append(str);
        localStringBuffer1.append(";");
        xe localxe = new xe();
        localxe.thZ = str;
        localxe.Scene = paramInt1;
        WepkgVersion localWepkgVersion = i.aFr(str);
        if (localWepkgVersion == null)
        {
          localxe.Version = "";
          localLinkedList.add(localxe);
        }
        else
        {
          localxe.Version = localWepkgVersion.version;
          long l = localWepkgVersion.DbI;
          if (d.bxm() >= l)
          {
            localLinkedList.add(localxe);
            i.aFu(str);
          }
          else
          {
            localStringBuffer2.append(str);
            localStringBuffer2.append(";");
          }
        }
      }
    }
    ac.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", new Object[] { localStringBuffer1.toString(), localStringBuffer2.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (!bs.gY(localLinkedList)) {
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
  
  private static void b(LinkedList<xe> paramLinkedList, int paramInt, boolean paramBoolean)
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
      xe localxe = (xe)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localxe.thZ);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localxe.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localxe.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (ai.ciE())
    {
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.Dcf.aLq();
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
    if (bs.gY(paramList))
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
    private List<WepkgCheckReq> Dcg;
    private boolean Dch;
    private int dCD;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.Dcg = new ArrayList();
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
      paramParcel.writeList(this.Dcg);
      paramParcel.writeInt(this.dCD);
      if (this.Dch) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(110835);
      if (bs.gY(this.Dcg))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).funcId = 1313;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new wm();
      Object localObject3 = this.Dcg.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        xe localxe = new xe();
        localxe.thZ = WepkgCheckReq.a(localWepkgCheckReq);
        localxe.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localxe.Scene = WepkgCheckReq.c(localWepkgCheckReq);
        ((wm)localObject2).EqN.add(localxe);
      }
      ((b.a)localObject1).hvt = ((com.tencent.mm.bw.a)localObject2);
      ((b.a)localObject1).hvu = new wn();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).aAz();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hvs.hvw == null))
          {
            ac.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hvs.hvw });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (wn)paramAnonymousb.hvs.hvw;
            d.bUw().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (bs.gY(((wn)localObject3).EqO))
                  {
                    ac.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((wn)localObject3).EqO.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (cfn)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((cfn)localObject4).thZ;
                      Object localObject6 = ((cfn)localObject4).FtR;
                      dyv localdyv = ((cfn)localObject4).FtT;
                      if (!bs.isNullOrNil((String)localObject5))
                      {
                        if (localdyv != null)
                        {
                          if (localdyv.Gfg)
                          {
                            ac.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 17L, 1L, false);
                            if (((cfn)localObject4).FtS != null) {
                              ForceUpdateNotify.Bk(((cfn)localObject4).thZ);
                            }
                          }
                          if (localdyv.Gff)
                          {
                            c.eJd().az((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((dyz)localObject6).Gfo != null))
                        {
                          if (bs.isNullOrNil(((dyz)localObject6).Gfo.Gfh))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).CW = 2004;
                            ((WepkgCrossProcessTask)localObject4).DaU.fYR = ((String)localObject5);
                            if (ai.ciE()) {
                              d.bUw().postToWorker(new i.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).jWP = new i.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).bej();
                              AppBrandMainProcessService.a((MainProcessTask)localObject4);
                            }
                          }
                          boolean bool2 = ((dyz)localObject6).Gfo.Gfi;
                          long l1 = ((dyz)localObject6).Gfo.Gfj;
                          long l2 = ((dyz)localObject6).Gfo.Gfk;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).CW = 3004;
                          ((WepkgCrossProcessTask)localObject6).DaU.fYR = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).DaU.DbC = bool2;
                          ((WepkgCrossProcessTask)localObject6).DaU.DbD = l1;
                          ((WepkgCrossProcessTask)localObject6).DaU.DbE = l2;
                          if (ai.ciE())
                          {
                            ((WepkgCrossProcessTask)localObject6).aLq();
                            label435:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).CW = 3009;
                            ((WepkgCrossProcessTask)localObject6).DaU.fYR = ((String)localObject5);
                            if (!ai.ciE()) {
                              break label562;
                            }
                            ((WepkgCrossProcessTask)localObject6).aLq();
                            label473:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).CW = 4006;
                            ((WepkgCrossProcessTask)localObject6).DaX.fYR = ((String)localObject5);
                            if (!ai.ciE()) {
                              break label571;
                            }
                            ((WepkgCrossProcessTask)localObject6).aLq();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = com.tencent.mm.plugin.wepkg.model.h.a((cfn)localObject4);
                              if (!bs.gY((List)localObject5)) {
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
                  ForceUpdateNotify.cxQ();
                  a.a.eJj().k((Set)localObject1);
                  if (!bs.gY((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (cfn)((Iterator)localObject1).next();
                      localObject3 = j.eJi();
                      if ((localObject2 == null) || (((cfn)localObject2).FtS == null))
                      {
                        ac.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((j)localObject3).cs(((cfn)localObject2).thZ, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((cfn)localObject2).FtS.Gfs;
                        localObject5 = ((cfn)localObject2).FtS.Gft;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          ac.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.eJd().az(((cfn)localObject2).thZ, 2, 5);
                        }
                        else
                        {
                          i.a((cfn)localObject2, i);
                          ac.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((j)localObject3).cs(((cfn)localObject2).thZ, false);
                            break;
                          case 1: 
                            if (d.cK(ai.getContext())) {
                              ((j)localObject3).cs(((cfn)localObject2).thZ, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new iq();
                            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject4);
                            if (((iq)localObject4).djS.djT) {
                              ((j)localObject3).cs(((cfn)localObject2).thZ, false);
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
            ac.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
            AppMethodBeat.o(110827);
          }
        }
      };
      if (ai.ciE())
      {
        x.a((com.tencent.mm.ak.b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.cF(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).Dcc = ((com.tencent.mm.ak.b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).Dcd = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).Dca = 1;
      AppBrandMainProcessService.a((MainProcessTask)localObject3);
      AppMethodBeat.o(110835);
    }
    
    public final void aLr() {}
    
    public final void n(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.Dcg == null) {
        this.Dcg = new ArrayList();
      }
      paramParcel.readList(this.Dcg, WepkgCheckReq.class.getClassLoader());
      this.dCD = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Dch = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String fYR;
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
        this.fYR = paramParcel.readString();
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
        paramParcel.writeString(this.fYR);
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