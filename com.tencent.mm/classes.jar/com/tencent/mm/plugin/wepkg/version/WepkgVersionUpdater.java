package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.iy.a;
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
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.eex;
import com.tencent.mm.protocal.protobuf.eey;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.zd;
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
        zd localzd = new zd();
        localzd.ufQ = str;
        localzd.Scene = paramInt1;
        WepkgVersion localWepkgVersion = i.aKR(str);
        if (localWepkgVersion == null)
        {
          localzd.Version = "";
          localLinkedList.add(localzd);
        }
        else
        {
          localzd.Version = localWepkgVersion.version;
          long l = localWepkgVersion.EFH;
          if (d.currentTime() >= l)
          {
            localLinkedList.add(localzd);
            i.aKU(str);
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
    if (!bt.hj(localLinkedList)) {
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
  
  private static void b(LinkedList<zd> paramLinkedList, int paramInt, boolean paramBoolean)
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
      zd localzd = (zd)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localzd.ufQ);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localzd.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localzd.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (aj.cnC())
    {
      d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.EGf.aOA();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    AppBrandMainProcessService.a(localWepkgNetSceneProcessTask);
    AppMethodBeat.o(110842);
  }
  
  public static void y(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(110839);
    if (bt.hj(paramList))
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
    private List<WepkgCheckReq> EGg;
    private boolean EGh;
    private int dOQ;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.EGg = new ArrayList();
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
      paramParcel.writeList(this.EGg);
      paramParcel.writeInt(this.dOQ);
      if (this.EGh) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(110835);
      if (bt.hj(this.EGg))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).funcId = 1313;
      ((b.a)localObject1).hNO = 0;
      ((b.a)localObject1).respCmdId = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new yl();
      Object localObject3 = this.EGg.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        zd localzd = new zd();
        localzd.ufQ = WepkgCheckReq.a(localWepkgCheckReq);
        localzd.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localzd.Scene = WepkgCheckReq.c(localWepkgCheckReq);
        ((yl)localObject2).FXX.add(localzd);
      }
      ((b.a)localObject1).hNM = ((com.tencent.mm.bx.a)localObject2);
      ((b.a)localObject1).hNN = new ym();
      g.yhR.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).aDC();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hNL.hNQ == null))
          {
            ad.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hNL.hNQ });
            g.yhR.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (ym)paramAnonymousb.hNL.hNQ;
            d.bZb().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (bt.hj(((ym)localObject3).FXY))
                  {
                    ad.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((ym)localObject3).FXY.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (ckm)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((ckm)localObject4).ufQ;
                      Object localObject6 = ((ckm)localObject4).HdW;
                      eex localeex = ((ckm)localObject4).HdY;
                      if (!bt.isNullOrNil((String)localObject5))
                      {
                        if (localeex != null)
                        {
                          if (localeex.HQn)
                          {
                            ad.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            g.yhR.idkeyStat(859L, 17L, 1L, false);
                            if (((ckm)localObject4).HdX != null) {
                              ForceUpdateNotify.Ej(((ckm)localObject4).ufQ);
                            }
                          }
                          if (localeex.HQm)
                          {
                            c.eXW().aD((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((efb)localObject6).HQv != null))
                        {
                          if (bt.isNullOrNil(((efb)localObject6).HQv.HQo))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).EN = 2004;
                            ((WepkgCrossProcessTask)localObject4).EET.gsn = ((String)localObject5);
                            if (aj.cnC()) {
                              d.bZb().postToWorker(new i.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              g.yhR.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).krg = new i.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).bhN();
                              AppBrandMainProcessService.a((MainProcessTask)localObject4);
                            }
                          }
                          boolean bool2 = ((efb)localObject6).HQv.HQp;
                          long l1 = ((efb)localObject6).HQv.HQq;
                          long l2 = ((efb)localObject6).HQv.HQr;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).EN = 3004;
                          ((WepkgCrossProcessTask)localObject6).EET.gsn = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).EET.EFB = bool2;
                          ((WepkgCrossProcessTask)localObject6).EET.EFC = l1;
                          ((WepkgCrossProcessTask)localObject6).EET.EFD = l2;
                          if (aj.cnC())
                          {
                            ((WepkgCrossProcessTask)localObject6).aOA();
                            label435:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EN = 3009;
                            ((WepkgCrossProcessTask)localObject6).EET.gsn = ((String)localObject5);
                            if (!aj.cnC()) {
                              break label562;
                            }
                            ((WepkgCrossProcessTask)localObject6).aOA();
                            label473:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).EN = 4006;
                            ((WepkgCrossProcessTask)localObject6).EEW.gsn = ((String)localObject5);
                            if (!aj.cnC()) {
                              break label571;
                            }
                            ((WepkgCrossProcessTask)localObject6).aOA();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = h.a((ckm)localObject4);
                              if (!bt.hj((List)localObject5)) {
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
                  ForceUpdateNotify.cEN();
                  a.a.eYd().r((Set)localObject1);
                  if (!bt.hj((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (ckm)((Iterator)localObject1).next();
                      localObject3 = j.eYc();
                      if ((localObject2 == null) || (((ckm)localObject2).HdX == null))
                      {
                        ad.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((j)localObject3).cx(((ckm)localObject2).ufQ, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((ckm)localObject2).HdX.HQz;
                        localObject5 = ((ckm)localObject2).HdX.HQA;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          ad.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.eXW().aD(((ckm)localObject2).ufQ, 2, 5);
                        }
                        else
                        {
                          i.a((ckm)localObject2, i);
                          ad.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((j)localObject3).cx(((ckm)localObject2).ufQ, false);
                            break;
                          case 1: 
                            if (d.cH(aj.getContext())) {
                              ((j)localObject3).cx(((ckm)localObject2).ufQ, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new iy();
                            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
                            if (((iy)localObject4).dvF.dvG) {
                              ((j)localObject3).cx(((ckm)localObject2).ufQ, false);
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
      if (aj.cnC())
      {
        x.a((com.tencent.mm.al.b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.cH(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EGc = ((com.tencent.mm.al.b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EGd = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).EGa = 1;
      AppBrandMainProcessService.a((MainProcessTask)localObject3);
      AppMethodBeat.o(110835);
    }
    
    public final void aOB() {}
    
    public final void n(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.EGg == null) {
        this.EGg = new ArrayList();
      }
      paramParcel.readList(this.EGg, WepkgCheckReq.class.getClassLoader());
      this.dOQ = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.EGh = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String gsn;
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
        this.gsn = paramParcel.readString();
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
        paramParcel.writeString(this.gsn);
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