package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nn;
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
  protected b AGQ = null;
  protected FailSendMsgNotification AGR = null;
  protected boolean AGS = false;
  protected ArrayList<Long> AGT = null;
  protected ArrayList<Long> AGU = null;
  protected ArrayList<Long> AGV = null;
  private ArrayList<MTimerHandler> AGW = new ArrayList();
  private MTimerHandler AGX = null;
  private IListener AGY = new a.1(this);
  protected Context mContext = null;
  
  public a()
  {
    this.AGR.AHJ = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void eyL()
      {
        AppMethodBeat.i(26728);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            h.CyF.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.eyI();
            a.a(a.this);
            a.this.eyz();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void eyM()
      {
        AppMethodBeat.i(26729);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            h.CyF.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.eyI();
            a.this.eyE();
            a.b(a.this);
            a.this.AGR.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.AGR.AHK = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void eyN()
      {
        AppMethodBeat.i(26730);
        h.CyF.a(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.eyI();
        a.this.eyK();
        if (!a.this.AGS) {
          a.this.AGR.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.AGR.AHL = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    eyt();
  }
  
  private void eyA()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()) });
    eyB();
    eyC();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()) });
  }
  
  private void eyB()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.AGQ.AHb.size())
    {
      long l = this.AGQ.get(i);
      if (!HB(l)) {
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
        this.AGQ.remove(localLong.longValue());
      }
    }
  }
  
  private void eyC()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.AGT.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!HB(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.AGT.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.AGU.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!HB(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.AGU.remove(localObject2);
    }
  }
  
  private void eyD()
  {
    Iterator localIterator = this.AGW.iterator();
    while (localIterator.hasNext()) {
      ((MTimerHandler)localIterator.next()).stopTimer();
    }
    this.AGW.clear();
    this.AGV.clear();
  }
  
  private String eyF()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.AGQ.AHb.size())
    {
      long l = this.AGQ.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void eyH()
  {
    this.AGQ.currentIndex = 0;
    if (this.AGT.size() > 0)
    {
      Iterator localIterator = this.AGT.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.AGQ.remove(localLong.longValue());
      }
    }
    this.AGT.clear();
    this.AGU.clear();
  }
  
  private void eyJ()
  {
    b.a locala = new b.a(this.AGQ, this.AGQ.currentIndex, this.AGT, this.AGU);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void eyt()
  {
    this.AGX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.AGS)
        {
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.AGQ.AHb.size()), Integer.valueOf(a.this.AGT.size()), Integer.valueOf(a.this.AGU.size()) });
          a.c(a.this);
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.AGQ.AHb.size()), Integer.valueOf(a.this.AGT.size()), Integer.valueOf(a.this.AGU.size()) });
          if (a.this.AGQ.AHb.size() > 0) {
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
  
  private void eyu()
  {
    if (this.AGX != null)
    {
      this.AGX.stopTimer();
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void eyv()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.Pv()) });
    this.AGR.AHN = TR(this.AGQ.AHb.size());
    this.AGR.eza();
    if ((!f.Pv()) && (!this.AGR.AHS))
    {
      this.AGR.AHM = TR(this.AGQ.AHb.size());
      this.AGR.eyZ();
      this.AGR.eyY();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.AGR.show();
      EventCenter.instance.removeListener(this.AGY);
      EventCenter.instance.addListener(this.AGY);
      return;
    }
    if (this.AGR.AHS)
    {
      this.AGR.eyZ();
      this.AGR.eyY();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.AGR.aJb(TR(this.AGQ.AHb.size()));
      EventCenter.instance.removeListener(this.AGY);
      EventCenter.instance.addListener(this.AGY);
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.Pv()) });
  }
  
  private void eyw()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.AGR.AHN = TR(this.AGQ.AHb.size());
      if (this.AGU.size() <= 0) {
        this.AGR.aJb(hB(this.AGQ.AHb.size(), this.AGT.size() + this.AGU.size()));
      }
    }
    else
    {
      return;
    }
    this.AGR.aJb(av(this.AGQ.AHb.size(), this.AGT.size() + this.AGU.size(), this.AGU.size()));
  }
  
  private void eyx()
  {
    this.AGS = false;
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGU.size()), Integer.valueOf(this.AGT.size()) });
    eyA();
    if ((this.AGU.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.TT(getType());
    }
    h.CyF.a(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.AGR.eyZ();
      this.AGR.AHN = TR(this.AGQ.AHb.size());
      localObject = this.AGR;
      this.AGQ.AHb.size();
      ((FailSendMsgNotification)localObject).aJb(hC(this.AGT.size(), this.AGU.size()));
      this.AGR.eyY();
      if (this.AGU.size() > 0)
      {
        this.AGR.eza();
        this.AGR.show();
        eyH();
        eyJ();
      }
    }
    Object localObject = new nn();
    ((nn)localObject).dTH.type = getType();
    EventCenter.instance.publish((IEvent)localObject);
    eyu();
    eyD();
    EventCenter.instance.removeListener(this.AGY);
    eyy();
  }
  
  private void resetStatus()
  {
    this.AGQ.clear();
    this.AGS = false;
    this.AGT.clear();
    this.AGU.clear();
    eyD();
  }
  
  public abstract void HA(long paramLong);
  
  public abstract boolean HB(long paramLong);
  
  final void Hz(final long paramLong)
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
  
  protected abstract String TR(int paramInt);
  
  protected abstract void aH(ArrayList<Long> paramArrayList);
  
  protected abstract String av(int paramInt1, int paramInt2, int paramInt3);
  
  public final void dI(T paramT)
  {
    if (paramT == null) {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dK(paramT)), eyF(), Boolean.valueOf(this.AGS) });
    if (!this.AGS)
    {
      if (!this.AGV.contains(Long.valueOf(dK(paramT))))
      {
        if (paramT == null)
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dL(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.AGQ;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.AHb.addAll(paramT);
        }
        eyJ();
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.AGQ.AHb.size()), eyF() });
        h.CyF.a(11426, new Object[] { Integer.valueOf(getType()) });
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
      this.AGV.remove(Long.valueOf(dK(paramT)));
      return;
    }
    if ((this.AGQ.contains(dK(paramT))) && (!this.AGU.contains(Long.valueOf(dK(paramT))))) {
      this.AGU.add(Long.valueOf(dK(paramT)));
    }
    if (!this.AGQ.contains(dK(paramT)))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.AGQ.HC(dK(paramT));
    }
    eyw();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()) });
    if (this.AGT.size() + this.AGU.size() < this.AGQ.AHb.size())
    {
      long l = this.AGQ.eyO();
      if (l == -1L)
      {
        Log.e("TAG", "resend error, next msg id is -1");
        return;
      }
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      eyJ();
      Hz(l);
      return;
    }
    eyx();
  }
  
  public final void dJ(T paramT)
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dK(paramT)), eyF() });
    long l;
    if (this.AGQ.contains(dK(paramT)))
    {
      l = dK(paramT);
      if ((this.AGV.contains(Long.valueOf(l))) && (this.AGU.contains(Long.valueOf(l))))
      {
        Log.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.AGV.remove(Long.valueOf(l));
        this.AGU.remove(Long.valueOf(l));
      }
      if (!this.AGS) {
        break label260;
      }
      this.AGT.add(Long.valueOf(l));
      eyw();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()) });
      if (this.AGT.size() + this.AGU.size() >= this.AGQ.AHb.size()) {
        break label255;
      }
      l = this.AGQ.eyO();
      if (l == -1L) {
        Log.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    eyJ();
    Hz(l);
    return;
    label255:
    eyx();
    return;
    label260:
    this.AGQ.remove(dK(paramT));
    if (this.AGQ.AHb.size() == 0)
    {
      this.AGR.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.TT(getType());
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.AGR.aJb(TR(this.AGQ.AHb.size()));
  }
  
  protected abstract long dK(T paramT);
  
  protected abstract ArrayList<Long> dL(T paramT);
  
  public final void eyE()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()) });
    if (this.AGQ.AHb.size() > 0)
    {
      Object localObject = this.AGQ;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).AHb.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      aH(localArrayList);
    }
  }
  
  public final FailSendMsgNotification eyG()
  {
    return this.AGR;
  }
  
  protected final void eyI()
  {
    b.a locala;
    if ((this.AGQ == null) || (this.AGQ.AHb.size() == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.TS(getType());
      if (locala == null) {
        Log.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.AGX == null) {
      eyt();
    }
    b localb = locala.AHe;
    ArrayList localArrayList1 = locala.AHg;
    ArrayList localArrayList2 = locala.AHh;
    int i = locala.AHf;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.AGQ.clear();
      this.AGQ = localb;
      this.AGT.clear();
      this.AGU.clear();
      eyv();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.AHb.size())
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      eyx();
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.AGQ.clear();
    this.AGQ = localb;
    this.AGQ.currentIndex = i;
    this.AGT.clear();
    this.AGT.addAll(localArrayList1);
    this.AGU.clear();
    this.AGU.addAll(localArrayList2);
    eyw();
  }
  
  protected abstract void eyK();
  
  protected void eyy() {}
  
  public final void eyz()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()) });
    this.AGS = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.AGR;
      localFailSendMsgNotification.AHU = false;
      localFailSendMsgNotification.AHH = com.tencent.mm.bq.a.cd(localFailSendMsgNotification.mContext, com.tencent.mm.bq.a.glE());
      localFailSendMsgNotification.eyX();
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.AGR;
      localFailSendMsgNotification.AHH.g(2, true);
      localFailSendMsgNotification.AHT = true;
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.AGR.aJb(hB(this.AGQ.AHb.size(), 0));
    }
    this.AGQ.currentIndex = 0;
    eyD();
    EventCenter.instance.removeListener(this.AGY);
    EventCenter.instance.addListener(this.AGY);
    Hz(this.AGQ.eyO());
    if (this.AGX != null)
    {
      this.AGX.startTimer(300000L);
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  protected abstract String hB(int paramInt1, int paramInt2);
  
  protected abstract String hC(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */