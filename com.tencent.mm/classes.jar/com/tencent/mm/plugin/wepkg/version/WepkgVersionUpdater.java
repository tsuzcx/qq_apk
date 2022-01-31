package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.w;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class WepkgVersionUpdater
{
  public static void a(Set<String> paramSet, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(63682);
    if (paramSet == null)
    {
      AppMethodBeat.o(63682);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!bo.isNullOrNil(str))
      {
        localStringBuffer1.append(str);
        localStringBuffer1.append(";");
        tu localtu = new tu();
        localtu.nqD = str;
        localtu.Scene = paramInt1;
        WepkgVersion localWepkgVersion = com.tencent.mm.plugin.wepkg.model.h.akF(str);
        if (localWepkgVersion == null)
        {
          localtu.jKg = "";
          localLinkedList.add(localtu);
        }
        else
        {
          localtu.jKg = localWepkgVersion.version;
          long l = localWepkgVersion.vGP;
          if (d.aNY() >= l)
          {
            localLinkedList.add(localtu);
            com.tencent.mm.plugin.wepkg.model.h.akI(str);
          }
          else
          {
            localStringBuffer2.append(str);
            localStringBuffer2.append(";");
          }
        }
      }
    }
    ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", new Object[] { localStringBuffer1.toString(), localStringBuffer2.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (!bo.es(localLinkedList)) {
      b(localLinkedList, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(63682);
  }
  
  public static void a(Set<String> paramSet, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(63681);
    a(paramSet, paramInt, -1, paramBoolean);
    AppMethodBeat.o(63681);
  }
  
  private static void b(LinkedList<tu> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(63683);
    if (paramLinkedList.size() == 0)
    {
      AppMethodBeat.o(63683);
      return;
    }
    WepkgNetSceneProcessTask localWepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramInt);
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramBoolean);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      tu localtu = (tu)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localtu.nqD);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localtu.jKg);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localtu.Scene);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (ah.brt())
    {
      d.aNS().ac(new WepkgVersionUpdater.1(localWepkgNetSceneProcessTask));
      AppMethodBeat.o(63683);
      return;
    }
    WepkgMainProcessService.a(localWepkgNetSceneProcessTask);
    AppMethodBeat.o(63683);
  }
  
  public static void q(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(63680);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(63680);
      return;
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramList);
    a(localHashSet, paramInt, false);
    AppMethodBeat.o(63680);
  }
  
  static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR;
    private int cNS;
    private List<WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq> vHm;
    private boolean vHn;
    
    static
    {
      AppMethodBeat.i(63679);
      CREATOR = new WepkgVersionUpdater.WepkgNetSceneProcessTask.2();
      AppMethodBeat.o(63679);
    }
    
    public WepkgNetSceneProcessTask()
    {
      AppMethodBeat.i(63674);
      this.vHm = new ArrayList();
      AppMethodBeat.o(63674);
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      AppMethodBeat.i(63675);
      f(paramParcel);
      AppMethodBeat.o(63675);
    }
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63678);
      paramParcel.writeList(this.vHm);
      paramParcel.writeInt(this.cNS);
      if (this.vHn) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(63678);
        return;
      }
    }
    
    public final void ata()
    {
      AppMethodBeat.i(63676);
      if (bo.es(this.vHm))
      {
        AppMethodBeat.o(63676);
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).funcId = 1313;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new tj();
      Object localObject3 = this.vHm.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = (WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq)((Iterator)localObject3).next();
        tu localtu = new tu();
        localtu.nqD = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq);
        localtu.jKg = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq);
        localtu.Scene = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.c(localWepkgCheckReq);
        ((tj)localObject2).wLM.add(localtu);
      }
      ((b.a)localObject1).fsX = ((a)localObject2);
      ((b.a)localObject1).fsY = new tk();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).ado();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(63668);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.fsW.fta == null))
          {
            ab.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.fsW.fta });
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 16L, 1L, false);
            AppMethodBeat.o(63668);
            return;
          }
          try
          {
            paramAnonymousString = (tk)paramAnonymousb.fsW.fta;
            d.aNS().ac(new WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1(this, paramAnonymousString));
            AppMethodBeat.o(63668);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ab.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
            AppMethodBeat.o(63668);
          }
        }
      };
      if (ah.brt())
      {
        w.a((b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        AppMethodBeat.o(63676);
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.bq(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).vHi = ((b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).vHj = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).vHg = 1;
      WepkgMainProcessService.a((WepkgMainProcessTask)localObject3);
      AppMethodBeat.o(63676);
    }
    
    public final void atb() {}
    
    public final void m(Parcel paramParcel)
    {
      AppMethodBeat.i(63677);
      if (this.vHm == null) {
        this.vHm = new ArrayList();
      }
      paramParcel.readList(this.vHm, WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.class.getClassLoader());
      this.cNS = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.vHn = bool;
        AppMethodBeat.o(63677);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater
 * JD-Core Version:    0.7.0.1
 */