package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class WepkgVersionUpdater
{
  public static void Vv(String paramString)
  {
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 3003;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV())
    {
      d.DS().O(new WepkgVersionUpdater.1(localWepkgCrossProcessTask));
      return;
    }
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
  
  public static void ag(String paramString, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString))
    {
      paramString = com.tencent.mm.plugin.wepkg.a.Dv(paramInt1);
      if (paramString != null)
      {
        localObject = new LinkedList();
        ((LinkedList)localObject).add(paramString);
        b((LinkedList)localObject, paramInt2, false);
      }
      return;
    }
    Object localObject = f.Vj(paramString);
    if (localObject == null)
    {
      p(paramString, "", paramInt1, paramInt2);
      return;
    }
    long l1 = ((WepkgVersion)localObject).rPX;
    long l2 = d.aqv();
    if (l2 >= l1)
    {
      p(paramString, ((WepkgVersion)localObject).version, paramInt1, paramInt2);
      Vv(paramString);
      return;
    }
    y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "currTime[%s]s < nextCheckTime[%s]s, no net request", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static void b(LinkedList<qp> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    if (paramLinkedList.size() == 0) {
      return;
    }
    WepkgNetSceneProcessTask localWepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramInt);
    WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask, paramBoolean);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      qp localqp = (qp)paramLinkedList.next();
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq((byte)0);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localqp.kSE);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq, localqp.hQE);
      WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq, localqp.pyo);
      WepkgNetSceneProcessTask.a(localWepkgNetSceneProcessTask).add(localWepkgCheckReq);
    }
    if (ae.cqV())
    {
      d.DS().O(new WepkgVersionUpdater.2(localWepkgNetSceneProcessTask));
      return;
    }
    WepkgMainProcessService.a(localWepkgNetSceneProcessTask);
  }
  
  private static void p(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgId = " + paramString1 + ", version = " + paramString2 + ", scene = " + paramInt1 + ", downloadTriggerType = " + paramInt2);
    LinkedList localLinkedList = new LinkedList();
    qp localqp = new qp();
    localqp.kSE = paramString1;
    localqp.hQE = paramString2;
    localqp.pyo = paramInt1;
    localLinkedList.add(localqp);
    paramString1 = com.tencent.mm.plugin.wepkg.a.Dv(paramInt1);
    if (paramString1 != null) {
      localLinkedList.add(paramString1);
    }
    b(localLinkedList, paramInt2, false);
  }
  
  public static final class WepkgNetSceneProcessTask
    extends BaseWepkgProcessTask
  {
    public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR = new WepkgVersionUpdater.WepkgNetSceneProcessTask.2();
    private int cfl;
    private List<WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq> rQv;
    private boolean rQw;
    
    public WepkgNetSceneProcessTask()
    {
      this.rQv = new ArrayList();
    }
    
    private WepkgNetSceneProcessTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public final void Zu()
    {
      if (bk.dk(this.rQv)) {
        return;
      }
      Object localObject1 = new b.a();
      ((b.a)localObject1).ecG = 1313;
      ((b.a)localObject1).ecJ = 0;
      ((b.a)localObject1).ecK = 0;
      ((b.a)localObject1).uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
      Object localObject2 = new qe();
      Object localObject3 = this.rQv.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq localWepkgCheckReq = (WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq)((Iterator)localObject3).next();
        qp localqp = new qp();
        localqp.kSE = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.a(localWepkgCheckReq);
        localqp.hQE = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.b(localWepkgCheckReq);
        localqp.pyo = WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.c(localWepkgCheckReq);
        ((qe)localObject2).sNS.add(localqp);
      }
      ((b.a)localObject1).ecH = ((com.tencent.mm.bv.a)localObject2);
      ((b.a)localObject1).ecI = new qf();
      h.nFQ.a(859L, 15L, 1L, false);
      localObject1 = ((b.a)localObject1).Kt();
      localObject2 = new WepkgRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.ecF.ecN == null))
          {
            y.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.ecF.ecN });
            h.nFQ.a(859L, 16L, 1L, false);
            return;
          }
          try
          {
            paramAnonymousString = (qf)paramAnonymousb.ecF.ecN;
            d.DS().O(new WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1(this, paramAnonymousString));
            return;
          }
          catch (Exception paramAnonymousString)
          {
            y.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
          }
        }
      };
      if (ae.cqV())
      {
        w.a((b)localObject1, new WepkgRunCgi.1((WepkgRunCgi.a)localObject2));
        return;
      }
      localObject3 = new WepkgRunCgi.RemoteCgiTask();
      d.aU(localObject3);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).rQq = ((b)localObject1);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).rQr = ((WepkgRunCgi.a)localObject2);
      ((WepkgRunCgi.RemoteCgiTask)localObject3).rQo = 1;
      WepkgMainProcessService.a((WepkgMainProcessTask)localObject3);
    }
    
    public final void Zv() {}
    
    public final void a(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeList(this.rQv);
      paramParcel.writeInt(this.cfl);
      if (this.rQw) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
    
    public final void j(Parcel paramParcel)
    {
      if (this.rQv == null) {
        this.rQv = new ArrayList();
      }
      paramParcel.readList(this.rQv, WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.class.getClassLoader());
      this.cfl = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.rQw = bool;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater
 * JD-Core Version:    0.7.0.1
 */