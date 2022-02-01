package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.autogen.a.li;
import com.tencent.mm.autogen.a.li.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.model.j.6;
import com.tencent.mm.plugin.wepkg.model.j.7;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.giq;
import com.tencent.mm.protocal.protobuf.gir;
import com.tencent.mm.protocal.protobuf.giu;
import com.tencent.mm.protocal.protobuf.gix;
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
  public static void Y(List<String> paramList, int paramInt)
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
        adb localadb = new adb();
        localadb.IHV = str;
        localadb.IJG = paramInt1;
        WepkgVersion localWepkgVersion = j.bou(str);
        if (localWepkgVersion == null)
        {
          localadb.Version = "";
          localLinkedList.add(localadb);
        }
        else
        {
          localadb.Version = localWepkgVersion.version;
          if (a(localWepkgVersion))
          {
            localLinkedList.add(localadb);
            j.box(str);
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
  
  private static boolean a(WepkgVersion paramWepkgVersion)
  {
    AppMethodBeat.i(278674);
    if (paramWepkgVersion == null)
    {
      AppMethodBeat.o(278674);
      return true;
    }
    if (Math.abs(d.currentTime() - paramWepkgVersion.XGL + paramWepkgVersion.XGI) >= paramWepkgVersion.XGI)
    {
      AppMethodBeat.o(278674);
      return true;
    }
    AppMethodBeat.o(278674);
    return false;
  }
  
  private static void b(LinkedList<adb> paramLinkedList, int paramInt, boolean paramBoolean)
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
      adb localadb = (adb)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localadb.IHV);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localadb.Version);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localadb.IJG);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (MMApplicationContext.isMMProcess())
    {
      d.dqg().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110825);
          WepkgVersionUpdater.this.asn();
          AppMethodBeat.o(110825);
        }
      });
      AppMethodBeat.o(110842);
      return;
    }
    localWepkgNetSceneProcessTask.bQt();
    AppMethodBeat.o(110842);
  }
  
  static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR;
    private List<WepkgCheckReq> XHj;
    private boolean XHk;
    private int iiM;
    
    static
    {
      AppMethodBeat.i(110838);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110838);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(110833);
      this.XHj = new ArrayList();
      AppMethodBeat.o(110833);
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110834);
      h(paramParcel);
      AppMethodBeat.o(110834);
    }
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110837);
      paramParcel.writeList(this.XHj);
      paramParcel.writeInt(this.iiM);
      if (this.XHk) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(110837);
        return;
      }
    }
    
    public final void asn()
    {
      AppMethodBeat.i(110835);
      if (Util.isNullOrNil(this.XHj))
      {
        AppMethodBeat.o(110835);
        return;
      }
      Object localObject1 = new c.a();
      ((c.a)localObject1).funcId = 1313;
      ((c.a)localObject1).otG = 0;
      ((c.a)localObject1).respCmdId = 0;
      ((c.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new acg();
      Object localObject3 = this.XHj.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgCheckReq localWepkgCheckReq = (WepkgCheckReq)((Iterator)localObject3).next();
        adb localadb = new adb();
        localadb.IHV = WepkgCheckReq.a(localWepkgCheckReq);
        localadb.Version = WepkgCheckReq.b(localWepkgCheckReq);
        localadb.IJG = WepkgCheckReq.c(localWepkgCheckReq);
        ((acg)localObject2).ZkJ.add(localadb);
      }
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)localObject2);
      ((c.a)localObject1).otF = new ach();
      h.OAn.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
        {
          AppMethodBeat.i(110827);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
          {
            Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, c.c.b(paramAnonymousc.otC) });
            h.OAn.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(110827);
            return;
          }
          try
          {
            paramAnonymousString = (ach)c.c.b(paramAnonymousc.otC);
            d.dqg().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(110826);
                Object localObject3 = paramAnonymousString;
                int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(WepkgVersionUpdater.WepkgNetSceneProcessTask.this);
                if (localObject3 != null)
                {
                  if (Util.isNullOrNil(((ach)localObject3).ZkK))
                  {
                    Log.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                    AppMethodBeat.o(110826);
                    return;
                  }
                  Object localObject1 = new HashSet();
                  Object localObject2 = new ArrayList();
                  localObject3 = ((ach)localObject3).ZkK.iterator();
                  Object localObject4;
                  Object localObject5;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (edq)((Iterator)localObject3).next();
                    if (localObject4 != null)
                    {
                      localObject5 = ((edq)localObject4).IHV;
                      Object localObject6 = ((edq)localObject4).abiL;
                      giq localgiq = ((edq)localObject4).abiN;
                      if (!Util.isNullOrNil((String)localObject5))
                      {
                        if (localgiq != null)
                        {
                          if (localgiq.acfa)
                          {
                            Log.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                            h.OAn.idkeyStat(859L, 17L, 1L, false);
                            if (((edq)localObject4).abiM != null) {
                              ForceUpdateNotify.add(((edq)localObject4).IHV);
                            }
                          }
                          if (localgiq.aceZ)
                          {
                            com.tencent.mm.plugin.wepkg.model.c.iFn().aR((String)localObject5, 2, 3);
                            continue;
                          }
                        }
                        if ((localObject6 != null) && (((giu)localObject6).acfi != null))
                        {
                          if (Util.isNullOrNil(((giu)localObject6).acfi.acfb))
                          {
                            localObject4 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject4).bUl = 2004;
                            ((WepkgCrossProcessTask)localObject4).XFY.mtT = ((String)localObject5);
                            if (MMApplicationContext.isMMProcess()) {
                              d.dqg().postToWorker(new j.6((WepkgCrossProcessTask)localObject4));
                            }
                            for (;;)
                            {
                              h.OAn.idkeyStat(859L, 18L, 1L, false);
                              break;
                              ((WepkgCrossProcessTask)localObject4).rxj = new j.7((WepkgCrossProcessTask)localObject4);
                              ((WepkgCrossProcessTask)localObject4).bQt();
                            }
                          }
                          boolean bool2 = ((giu)localObject6).acfi.acfc;
                          long l1 = ((giu)localObject6).acfi.acfd;
                          long l2 = ((giu)localObject6).acfi.acfe;
                          localObject6 = new WepkgCrossProcessTask();
                          ((WepkgCrossProcessTask)localObject6).bUl = 3004;
                          ((WepkgCrossProcessTask)localObject6).XFY.mtT = ((String)localObject5);
                          ((WepkgCrossProcessTask)localObject6).XFY.XGG = bool2;
                          ((WepkgCrossProcessTask)localObject6).XFY.XGH = l1;
                          ((WepkgCrossProcessTask)localObject6).XFY.XGI = l2;
                          if (MMApplicationContext.isMMProcess())
                          {
                            ((WepkgCrossProcessTask)localObject6).asn();
                            label430:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).bUl = 3009;
                            ((WepkgCrossProcessTask)localObject6).XFY.mtT = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label557;
                            }
                            ((WepkgCrossProcessTask)localObject6).asn();
                            label468:
                            localObject6 = new WepkgCrossProcessTask();
                            ((WepkgCrossProcessTask)localObject6).bUl = 4006;
                            ((WepkgCrossProcessTask)localObject6).XGb.mtT = ((String)localObject5);
                            if (!MMApplicationContext.isMMProcess()) {
                              break label566;
                            }
                            ((WepkgCrossProcessTask)localObject6).asn();
                          }
                          for (;;)
                          {
                            if (bool1)
                            {
                              localObject5 = i.a((edq)localObject4);
                              if (!Util.isNullOrNil((List)localObject5)) {
                                ((Set)localObject1).addAll((Collection)localObject5);
                              }
                            }
                            ((List)localObject2).add(localObject4);
                            break;
                            ((WepkgCrossProcessTask)localObject6).cpB();
                            break label430;
                            label557:
                            ((WepkgCrossProcessTask)localObject6).cpB();
                            break label468;
                            label566:
                            ((WepkgCrossProcessTask)localObject6).cpB();
                          }
                        }
                      }
                    }
                  }
                  ForceUpdateNotify.eGV();
                  a.a.iFw().I((Set)localObject1);
                  if (!Util.isNullOrNil((List)localObject2))
                  {
                    localObject1 = ((List)localObject2).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (edq)((Iterator)localObject1).next();
                      localObject3 = k.iFv();
                      if ((localObject2 == null) || (((edq)localObject2).abiM == null))
                      {
                        Log.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (localObject2 != null) {
                          ((k)localObject3).dU(((edq)localObject2).IHV, false);
                        }
                      }
                      else
                      {
                        localObject4 = ((edq)localObject2).abiM.acfm;
                        localObject5 = ((edq)localObject2).abiM.acfn;
                        if ((localObject4 == null) && (localObject5 == null))
                        {
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                          com.tencent.mm.plugin.wepkg.model.c.iFn().aR(((edq)localObject2).IHV, 2, 5);
                        }
                        else
                        {
                          j.a((edq)localObject2, i);
                          Log.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
                          switch (i)
                          {
                          default: 
                            break;
                          case -1: 
                          case 0: 
                            ((k)localObject3).dU(((edq)localObject2).IHV, false);
                            break;
                          case 1: 
                            if (d.isAppOnForeground(MMApplicationContext.getContext())) {
                              ((k)localObject3).dU(((edq)localObject2).IHV, false);
                            }
                            break;
                          case 2: 
                            localObject4 = new li();
                            ((li)localObject4).publish();
                            if (((li)localObject4).hNc.hNd) {
                              ((k)localObject3).dU(((edq)localObject2).IHV, false);
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
        z.a((com.tencent.mm.am.c)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(110835);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.em(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).XHf = ((com.tencent.mm.am.c)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).XHg = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).XHd = 1;
      ((WepkgRunCgi.RemoteCgiTask)localObject3).bQt();
      AppMethodBeat.o(110835);
    }
    
    public final void bQr() {}
    
    public final void t(Parcel paramParcel)
    {
      AppMethodBeat.i(110836);
      if (this.XHj == null) {
        this.XHj = new ArrayList();
      }
      paramParcel.readList(this.XHj, WepkgCheckReq.class.getClassLoader());
      this.iiM = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.XHk = bool;
        AppMethodBeat.o(110836);
        return;
      }
    }
    
    static class WepkgCheckReq
      implements Parcelable
    {
      public static final Parcelable.Creator<WepkgCheckReq> CREATOR;
      private String mtT;
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
        this.mtT = paramParcel.readString();
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
        paramParcel.writeString(this.mtT);
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