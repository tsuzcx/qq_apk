package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.ke;
import com.tencent.mm.f.a.ke.a;
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
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.flx;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.protocal.protobuf.fmb;
import com.tencent.mm.protocal.protobuf.fme;
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
  public static void G(List<String> paramList, int paramInt)
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
        abb localabb = new abb();
        localabb.CNL = str;
        localabb.CPw = paramInt1;
        WepkgVersion localWepkgVersion = j.boG(str);
        if (localWepkgVersion == null)
        {
          localabb.Version = "";
          localLinkedList.add(localabb);
        }
        else
        {
          localabb.Version = localWepkgVersion.version;
          long l = localWepkgVersion.QNn;
          if (com.tencent.mm.plugin.wepkg.utils.d.currentTime() >= l)
          {
            localLinkedList.add(localabb);
            j.boJ(str);
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
  
  private static void b(LinkedList<abb> paramLinkedList, int paramInt, boolean paramBoolean)
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
      abb localabb = (abb)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localabb.CNL);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localabb.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localabb.CPw);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.plugin.wepkg.utils.d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          this.QNK.RW();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    localWepkgNetSceneProcessTask.bsM();
    AppMethodBeat.o(110842);
  }
  
  static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR;
    private List<WepkgCheckReq> QNL;
    private boolean QNM;
    private int gcA;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.QNL = new ArrayList();
      AppMethodBeat.o(110833);
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110834);
      f(paramParcel);
      AppMethodBeat.o(110834);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(110835);
      if (Util.isNullOrNil(this.QNL))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new d.a();
      ((d.a)localObject1).funcId = 1313;
      ((d.a)localObject1).lBW = 0;
      ((d.a)localObject1).respCmdId = 0;
      ((d.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new aag();
      Object localObject3 = this.QNL.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        abb localabb = new abb();
        localabb.CNL = WepkgCheckReq.a(localWepkgCheckReq);
        localabb.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localabb.CPw = WepkgCheckReq.c(localWepkgCheckReq);
        ((aag)localObject2).Smx.add(localabb);
      }
      ((d.a)localObject1).lBU = ((com.tencent.mm.cd.a)localObject2);
      ((d.a)localObject1).lBV = new aah();
      h.IzE.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((d.a)localObject1).bgN();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (d.c.b(paramAnonymousd.lBS) == null))
          {
            Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, d.c.b(paramAnonymousd.lBS) });
            h.IzE.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (aah)d.c.b(paramAnonymousd.lBS);
            com.tencent.mm.plugin.wepkg.utils.d.cMC().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (Util.isNullOrNil(((aah)localObject3).Smy))
                  {
                    Log.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((aah)localObject3).Smy.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (dlf)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((dlf)localObject4).CNL;
                      Object localObject6 = ((dlf)localObject4).TSm;
                      flx localflx = ((dlf)localObject4).TSo;
                      if (!Util.isNullOrNil((String)localObject5))
                      {
                        if (localflx != null)
                        {
                          if (localflx.UKM)
                          {
                            Log.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            h.IzE.idkeyStat(859L, 17L, 1L, false);
                            if (((dlf)localObject4).TSn != null) {
                              ForceUpdateNotify.add(((dlf)localObject4).CNL);
                            }
                          }
                          if (localflx.UKL)
                          {
                            c.heF().aJ((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((fmb)localObject6).UKU != null))
                        {
                          if (Util.isNullOrNil(((fmb)localObject6).UKU.UKN))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).Vh = 2004;
                            ((WepkgCrossProcessTask)localObject4).QMA.jTB = ((String)localObject5);
                            if (MMApplicationContext.isMMProcess()) {
                              com.tencent.mm.plugin.wepkg.utils.d.cMC().postToWorker(new j.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              h.IzE.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).otv = new j.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).bsM();
                            }
                          }
                          boolean bool2 = ((fmb)localObject6).UKU.UKO;
                          long l1 = ((fmb)localObject6).UKU.UKP;
                          long l2 = ((fmb)localObject6).UKU.UKQ;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).Vh = 3004;
                          ((WepkgCrossProcessTask)localObject6).QMA.jTB = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).QMA.QNi = bool2;
                          ((WepkgCrossProcessTask)localObject6).QMA.QNj = l1;
                          ((WepkgCrossProcessTask)localObject6).QMA.QNk = l2;
                          if (MMApplicationContext.isMMProcess())
                          {
                            ((WepkgCrossProcessTask)localObject6).RW();
                            label430:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).Vh = 3009;
                            ((WepkgCrossProcessTask)localObject6).QMA.jTB = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label557;
                            }
                            ((WepkgCrossProcessTask)localObject6).RW();
                            label468:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).Vh = 4006;
                            ((WepkgCrossProcessTask)localObject6).QMD.jTB = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label566;
                            }
                            ((WepkgCrossProcessTask)localObject6).RW();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = i.a((dlf)localObject4);
                              if (!Util.isNullOrNil((List)localObject5)) {
                                ((Set)localObject1).addAll((Collection)localObject5);
                              }
                            }
                            ((List)localObject2).add(localObject4);
                            break;
                            ((WepkgCrossProcessTask)localObject6).bPu();
                            break label430;
                            label557:
                            ((WepkgCrossProcessTask)localObject6).bPu();
                            break label468;
                            label566:
                            ((WepkgCrossProcessTask)localObject6).bPu();
                          }
                        }
                      }
                    }
                  }
                  ForceUpdateNotify.dRf();
                  a.a.heO().x((Set)localObject1);
                  if (!Util.isNullOrNil((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (dlf)((Iterator)localObject1).next();
                      localObject3 = k.heN();
                      if ((localObject2 == null) || (((dlf)localObject2).TSn == null))
                      {
                        Log.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((k)localObject3).dk(((dlf)localObject2).CNL, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((dlf)localObject2).TSn.UKY;
                        localObject5 = ((dlf)localObject2).TSn.UKZ;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          c.heF().aJ(((dlf)localObject2).CNL, 2, 5);
                        }
                        else
                        {
                          j.a((dlf)localObject2, i);
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((k)localObject3).dk(((dlf)localObject2).CNL, false);
                            break;
                          case 1: 
                            if (com.tencent.mm.plugin.wepkg.utils.d.isAppOnForeground(MMApplicationContext.getContext())) {
                              ((k)localObject3).dk(((dlf)localObject2).CNL, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new ke();
                            EventCenter.instance.publish((IEvent)localObject4);
                            if (((ke)localObject4).fHC.fHD) {
                              ((k)localObject3).dk(((dlf)localObject2).CNL, false);
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
        aa.a((com.tencent.mm.an.d)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      com.tencent.mm.plugin.wepkg.utils.d.cQ(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).QNH = ((com.tencent.mm.an.d)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).QNI = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).QNF = 1;
      ((WepkgRunCgi.RemoteCgiTask)localObject3).bsM();
      AppMethodBeat.o(110835);
    }
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110837);
      paramParcel.writeList(this.QNL);
      paramParcel.writeInt(this.gcA);
      if (this.QNM) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void bsK() {}
    
    public final void p(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.QNL == null) {
        this.QNL = new ArrayList();
      }
      paramParcel.readList(this.QNL, WepkgCheckReq.class.getClassLoader());
      this.gcA = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.QNM = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String jTB;
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
        this.jTB = paramParcel.readString();
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
        paramParcel.writeString(this.jTB);
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