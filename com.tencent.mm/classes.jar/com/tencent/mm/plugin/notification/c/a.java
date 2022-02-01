package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  protected FailSendMsgNotification GAa = null;
  protected boolean GAb = false;
  protected ArrayList<Long> GAc = null;
  protected ArrayList<Long> GAd = null;
  protected ArrayList<Long> GAe = null;
  private ArrayList<MTimerHandler> GAf = new ArrayList();
  private MTimerHandler GAg = null;
  private IListener GAh = new a.1(this);
  protected b GzZ = null;
  protected Context mContext = null;
  
  public a()
  {
    this.GAa.GAT = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void fkq()
      {
        AppMethodBeat.i(26728);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            h.IzE.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.fkn();
            a.a(a.this);
            a.this.fke();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void fkr()
      {
        AppMethodBeat.i(26729);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            h.IzE.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.fkn();
            a.this.fkj();
            a.b(a.this);
            a.this.GAa.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.GAa.GAU = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void fks()
      {
        AppMethodBeat.i(26730);
        h.IzE.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.fkn();
        a.this.fkp();
        if (!a.this.GAb) {
          a.this.GAa.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.GAa.GAV = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    fjY();
  }
  
  private void fjY()
  {
    this.GAg = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.GAb)
        {
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.GzZ.GAk.size()), Integer.valueOf(a.this.GAc.size()), Integer.valueOf(a.this.GAd.size()) });
          a.c(a.this);
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.GzZ.GAk.size()), Integer.valueOf(a.this.GAc.size()), Integer.valueOf(a.this.GAd.size()) });
          if (a.this.GzZ.GAk.size() > 0) {
            a.d(a.this);
          }
          for (;;)
          {
            AppMethodBeat.o(26732);
            return true;
            a.e(a.this);
          }
        }
        AppMethodBeat.o(26732);
        return false;
      }
    }, true);
  }
  
  private void fjZ()
  {
    if (this.GAg != null)
    {
      this.GAg.stopTimer();
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void fka()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.SV()) });
    this.GAa.GAX = aaE(this.GzZ.GAk.size());
    this.GAa.fkF();
    if ((!f.SV()) && (!this.GAa.GBc))
    {
      this.GAa.GAW = aaE(this.GzZ.GAk.size());
      this.GAa.fkE();
      this.GAa.fkD();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.GAa.show();
      EventCenter.instance.removeListener(this.GAh);
      EventCenter.instance.addListener(this.GAh);
      return;
    }
    if (this.GAa.GBc)
    {
      this.GAa.fkE();
      this.GAa.fkD();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.GAa.aTx(aaE(this.GzZ.GAk.size()));
      EventCenter.instance.removeListener(this.GAh);
      EventCenter.instance.addListener(this.GAh);
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.SV()) });
  }
  
  private void fkb()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.GAa.GAX = aaE(this.GzZ.GAk.size());
      if (this.GAd.size() <= 0) {
        this.GAa.aTx(iG(this.GzZ.GAk.size(), this.GAc.size() + this.GAd.size()));
      }
    }
    else
    {
      return;
    }
    this.GAa.aTx(az(this.GzZ.GAk.size(), this.GAc.size() + this.GAd.size(), this.GAd.size()));
  }
  
  private void fkc()
  {
    this.GAb = false;
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()), Integer.valueOf(this.GAd.size()), Integer.valueOf(this.GAc.size()) });
    fkf();
    if ((this.GAd.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.aaG(getType());
    }
    h.IzE.a(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.GAc.size()), Integer.valueOf(this.GAd.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.GAa.fkE();
      this.GAa.GAX = aaE(this.GzZ.GAk.size());
      localObject = this.GAa;
      this.GzZ.GAk.size();
      ((FailSendMsgNotification)localObject).aTx(iH(this.GAc.size(), this.GAd.size()));
      this.GAa.fkD();
      if (this.GAd.size() > 0)
      {
        this.GAa.fkF();
        this.GAa.show();
        fkm();
        fko();
      }
    }
    Object localObject = new oj();
    ((oj)localObject).fNi.type = getType();
    EventCenter.instance.publish((IEvent)localObject);
    fjZ();
    fki();
    EventCenter.instance.removeListener(this.GAh);
    fkd();
  }
  
  private void fkf()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()), Integer.valueOf(this.GAc.size()), Integer.valueOf(this.GAd.size()) });
    fkg();
    fkh();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()), Integer.valueOf(this.GAc.size()), Integer.valueOf(this.GAd.size()) });
  }
  
  private void fkg()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.GzZ.GAk.size())
    {
      long l = this.GzZ.get(i);
      if (!OV(l)) {
        ((ArrayList)localObject).add(Long.valueOf(l));
      }
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        this.GzZ.remove(localLong.longValue());
      }
    }
  }
  
  private void fkh()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.GAc.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!OV(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.GAc.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.GAd.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!OV(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.GAd.remove(localObject2);
    }
  }
  
  private void fki()
  {
    Iterator localIterator = this.GAf.iterator();
    while (localIterator.hasNext()) {
      ((MTimerHandler)localIterator.next()).stopTimer();
    }
    this.GAf.clear();
    this.GAe.clear();
  }
  
  private String fkk()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.GzZ.GAk.size())
    {
      long l = this.GzZ.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void fkm()
  {
    this.GzZ.currentIndex = 0;
    if (this.GAc.size() > 0)
    {
      Iterator localIterator = this.GAc.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.GzZ.remove(localLong.longValue());
      }
    }
    this.GAc.clear();
    this.GAd.clear();
  }
  
  private void fko()
  {
    b.a locala = new b.a(this.GzZ, this.GzZ.currentIndex, this.GAc, this.GAd);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void resetStatus()
  {
    this.GzZ.clear();
    this.GAb = false;
    this.GAc.clear();
    this.GAd.clear();
    fki();
  }
  
  final void OT(final long paramLong)
  {
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26734);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26734);
      }
    }, 200L);
  }
  
  public abstract void OU(long paramLong);
  
  public abstract boolean OV(long paramLong);
  
  protected abstract void aP(ArrayList<Long> paramArrayList);
  
  protected abstract String aaE(int paramInt);
  
  protected abstract String az(int paramInt1, int paramInt2, int paramInt3);
  
  public final void dL(T paramT)
  {
    if (paramT == null) {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dN(paramT)), fkk(), Boolean.valueOf(this.GAb) });
    if (!this.GAb)
    {
      if (!this.GAe.contains(Long.valueOf(dN(paramT))))
      {
        if (paramT == null)
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dO(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.GzZ;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.GAk.addAll(paramT);
        }
        fko();
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.GzZ.GAk.size()), fkk() });
        h.IzE.a(11426, new Object[] { Integer.valueOf(getType()) });
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26733);
            a.f(a.this);
            AppMethodBeat.o(26733);
          }
        }, 1000L);
        return;
      }
      this.GAe.remove(Long.valueOf(dN(paramT)));
      return;
    }
    if ((this.GzZ.contains(dN(paramT))) && (!this.GAd.contains(Long.valueOf(dN(paramT))))) {
      this.GAd.add(Long.valueOf(dN(paramT)));
    }
    if (!this.GzZ.contains(dN(paramT)))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.GzZ.OW(dN(paramT));
    }
    fkb();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.GAc.size()), Integer.valueOf(this.GAd.size()) });
    if (this.GAc.size() + this.GAd.size() < this.GzZ.GAk.size())
    {
      long l = this.GzZ.fkt();
      if (l == -1L)
      {
        Log.e("TAG", "resend error, next msg id is -1");
        return;
      }
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      fko();
      OT(l);
      return;
    }
    fkc();
  }
  
  public final void dM(T paramT)
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dN(paramT)), fkk() });
    long l;
    if (this.GzZ.contains(dN(paramT)))
    {
      l = dN(paramT);
      if ((this.GAe.contains(Long.valueOf(l))) && (this.GAd.contains(Long.valueOf(l))))
      {
        Log.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.GAe.remove(Long.valueOf(l));
        this.GAd.remove(Long.valueOf(l));
      }
      if (!this.GAb) {
        break label260;
      }
      this.GAc.add(Long.valueOf(l));
      fkb();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.GAc.size()), Integer.valueOf(this.GAd.size()) });
      if (this.GAc.size() + this.GAd.size() >= this.GzZ.GAk.size()) {
        break label255;
      }
      l = this.GzZ.fkt();
      if (l == -1L) {
        Log.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    fko();
    OT(l);
    return;
    label255:
    fkc();
    return;
    label260:
    this.GzZ.remove(dN(paramT));
    if (this.GzZ.GAk.size() == 0)
    {
      this.GAa.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.aaG(getType());
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.GAa.aTx(aaE(this.GzZ.GAk.size()));
  }
  
  protected abstract long dN(T paramT);
  
  protected abstract ArrayList<Long> dO(T paramT);
  
  protected void fkd() {}
  
  public final void fke()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()) });
    this.GAb = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.GAa;
      localFailSendMsgNotification.GBe = false;
      localFailSendMsgNotification.GAQ = com.tencent.mm.bx.a.cp(localFailSendMsgNotification.mContext, com.tencent.mm.bx.a.hfv());
      localFailSendMsgNotification.fkC();
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.GAa;
      localFailSendMsgNotification.GAQ.e(2, true);
      localFailSendMsgNotification.GBd = true;
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.GAa.aTx(iG(this.GzZ.GAk.size(), 0));
    }
    this.GzZ.currentIndex = 0;
    fki();
    EventCenter.instance.removeListener(this.GAh);
    EventCenter.instance.addListener(this.GAh);
    OT(this.GzZ.fkt());
    if (this.GAg != null)
    {
      this.GAg.startTimer(300000L);
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void fkj()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()) });
    if (this.GzZ.GAk.size() > 0)
    {
      Object localObject = this.GzZ;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).GAk.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      aP(localArrayList);
    }
  }
  
  public final FailSendMsgNotification fkl()
  {
    return this.GAa;
  }
  
  protected final void fkn()
  {
    b.a locala;
    if ((this.GzZ == null) || (this.GzZ.GAk.size() == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.aaF(getType());
      if (locala == null) {
        Log.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.GAg == null) {
      fjY();
    }
    b localb = locala.GAn;
    ArrayList localArrayList1 = locala.GAp;
    ArrayList localArrayList2 = locala.GAq;
    int i = locala.GAo;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.GzZ.clear();
      this.GzZ = localb;
      this.GAc.clear();
      this.GAd.clear();
      fka();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.GAk.size())
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      fkc();
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.GzZ.clear();
    this.GzZ = localb;
    this.GzZ.currentIndex = i;
    this.GAc.clear();
    this.GAc.addAll(localArrayList1);
    this.GAd.clear();
    this.GAd.addAll(localArrayList2);
    fkb();
  }
  
  protected abstract void fkp();
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  protected abstract String iG(int paramInt1, int paramInt2);
  
  protected abstract String iH(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */