package com.tencent.mm.plugin.notification.base;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ps;
import com.tencent.mm.plugin.notification.model.b.a;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
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
  protected b Mwj = null;
  protected FailSendMsgNotification Mwk = null;
  protected boolean Mwl = false;
  protected ArrayList<Long> Mwm = null;
  protected ArrayList<Long> Mwn = null;
  protected ArrayList<Long> Mwo = null;
  private ArrayList<MTimerHandler> Mwp = new ArrayList();
  private MTimerHandler Mwq = null;
  private IListener Mwr = new AbstractSendMsgFailNotification.1(this, com.tencent.mm.app.f.hfK);
  protected Context mContext = null;
  
  public a()
  {
    this.Mwk.Mxd = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void guH()
      {
        AppMethodBeat.i(26728);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            h.OAn.b(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.guE();
            a.a(a.this);
            a.this.guv();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void guI()
      {
        AppMethodBeat.i(26729);
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            h.OAn.b(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.guE();
            a.this.guA();
            a.b(a.this);
            a.this.Mwk.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.Mwk.Mxe = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void guJ()
      {
        AppMethodBeat.i(26730);
        h.OAn.b(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.guE();
        a.this.guG();
        if (!a.this.Mwl) {
          a.this.Mwk.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.Mwk.Mxf = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    gup();
  }
  
  private String guB()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.Mwj.Mwu.size())
    {
      long l = this.Mwj.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void guD()
  {
    this.Mwj.currentIndex = 0;
    if (this.Mwm.size() > 0)
    {
      Iterator localIterator = this.Mwm.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.Mwj.remove(localLong.longValue());
      }
    }
    this.Mwm.clear();
    this.Mwn.clear();
  }
  
  private void guF()
  {
    b.a locala = new b.a(this.Mwj, this.Mwj.currentIndex, this.Mwm, this.Mwn);
    com.tencent.mm.plugin.notification.model.b.a(getType(), locala);
  }
  
  private void gup()
  {
    this.Mwq = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.Mwl)
        {
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.Mwj.Mwu.size()), Integer.valueOf(a.this.Mwm.size()), Integer.valueOf(a.this.Mwn.size()) });
          a.c(a.this);
          Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.Mwj.Mwu.size()), Integer.valueOf(a.this.Mwm.size()), Integer.valueOf(a.this.Mwn.size()) });
          if (a.this.Mwj.Mwu.size() > 0) {
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
  
  private void guq()
  {
    if (this.Mwq != null)
    {
      this.Mwq.stopTimer();
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void gur()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.notification.model.f.atA()) });
    this.Mwk.Mxg = aeX(this.Mwj.Mwu.size());
    this.Mwk.guW();
    if ((!com.tencent.mm.plugin.notification.model.f.atA()) && (!this.Mwk.Mxl))
    {
      this.Mwk.Bmi = aeX(this.Mwj.Mwu.size());
      this.Mwk.guV();
      this.Mwk.guU();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.Mwk.show();
      this.Mwr.dead();
      this.Mwr.alive();
      return;
    }
    if (this.Mwk.Mxl)
    {
      this.Mwk.guV();
      this.Mwk.guU();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.Mwk.aQy(aeX(this.Mwj.Mwu.size()));
      this.Mwr.dead();
      this.Mwr.alive();
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.notification.model.f.atA()) });
  }
  
  private void gus()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Mwk.Mxg = aeX(this.Mwj.Mwu.size());
      if (this.Mwn.size() <= 0) {
        this.Mwk.aQy(km(this.Mwj.Mwu.size(), this.Mwm.size() + this.Mwn.size()));
      }
    }
    else
    {
      return;
    }
    this.Mwk.aQy(aX(this.Mwj.Mwu.size(), this.Mwm.size() + this.Mwn.size(), this.Mwn.size()));
  }
  
  private void gut()
  {
    this.Mwl = false;
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()), Integer.valueOf(this.Mwn.size()), Integer.valueOf(this.Mwm.size()) });
    guw();
    if ((this.Mwn.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.model.b.aeZ(getType());
    }
    h.OAn.b(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.Mwm.size()), Integer.valueOf(this.Mwn.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Mwk.guV();
      this.Mwk.Mxg = aeX(this.Mwj.Mwu.size());
      localObject = this.Mwk;
      this.Mwj.Mwu.size();
      ((FailSendMsgNotification)localObject).aQy(kn(this.Mwm.size(), this.Mwn.size()));
      this.Mwk.guU();
      if (this.Mwn.size() > 0)
      {
        this.Mwk.guW();
        this.Mwk.show();
        guD();
        guF();
      }
    }
    Object localObject = new ps();
    ((ps)localObject).hSU.type = getType();
    ((ps)localObject).publish();
    guq();
    guz();
    this.Mwr.dead();
    guu();
  }
  
  private void guw()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()), Integer.valueOf(this.Mwm.size()), Integer.valueOf(this.Mwn.size()) });
    gux();
    guy();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()), Integer.valueOf(this.Mwm.size()), Integer.valueOf(this.Mwn.size()) });
  }
  
  private void gux()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.Mwj.Mwu.size())
    {
      long l = this.Mwj.get(i);
      if (!sY(l)) {
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
        this.Mwj.remove(localLong.longValue());
      }
    }
  }
  
  private void guy()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.Mwm.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!sY(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.Mwm.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.Mwn.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!sY(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.Mwn.remove(localObject2);
    }
  }
  
  private void guz()
  {
    Iterator localIterator = this.Mwp.iterator();
    while (localIterator.hasNext()) {
      ((MTimerHandler)localIterator.next()).stopTimer();
    }
    this.Mwp.clear();
    this.Mwo.clear();
  }
  
  private void resetStatus()
  {
    this.Mwj.clear();
    this.Mwl = false;
    this.Mwm.clear();
    this.Mwn.clear();
    guz();
  }
  
  protected abstract String aX(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract String aeX(int paramInt);
  
  protected abstract void bl(ArrayList<Long> paramArrayList);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  public final void gf(T paramT)
  {
    if (paramT == null) {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(gh(paramT)), guB(), Boolean.valueOf(this.Mwl) });
    if (!this.Mwl)
    {
      if (!this.Mwo.contains(Long.valueOf(gh(paramT))))
      {
        if (paramT == null)
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = gi(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.Mwj;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.Mwu.addAll(paramT);
        }
        guF();
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()), guB() });
        h.OAn.b(11426, new Object[] { Integer.valueOf(getType()) });
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
      this.Mwo.remove(Long.valueOf(gh(paramT)));
      return;
    }
    if ((this.Mwj.contains(gh(paramT))) && (!this.Mwn.contains(Long.valueOf(gh(paramT))))) {
      this.Mwn.add(Long.valueOf(gh(paramT)));
    }
    if (!this.Mwj.contains(gh(paramT)))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.Mwj.sZ(gh(paramT));
    }
    gus();
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.Mwm.size()), Integer.valueOf(this.Mwn.size()) });
    if (this.Mwm.size() + this.Mwn.size() < this.Mwj.Mwu.size())
    {
      long l = this.Mwj.guK();
      if (l == -1L)
      {
        Log.e("TAG", "resend error, next msg id is -1");
        return;
      }
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      guF();
      sW(l);
      return;
    }
    gut();
  }
  
  public final void gg(T paramT)
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(gh(paramT)), guB() });
    long l;
    if (this.Mwj.contains(gh(paramT)))
    {
      l = gh(paramT);
      if ((this.Mwo.contains(Long.valueOf(l))) && (this.Mwn.contains(Long.valueOf(l))))
      {
        Log.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.Mwo.remove(Long.valueOf(l));
        this.Mwn.remove(Long.valueOf(l));
      }
      if (!this.Mwl) {
        break label260;
      }
      this.Mwm.add(Long.valueOf(l));
      gus();
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.Mwm.size()), Integer.valueOf(this.Mwn.size()) });
      if (this.Mwm.size() + this.Mwn.size() >= this.Mwj.Mwu.size()) {
        break label255;
      }
      l = this.Mwj.guK();
      if (l == -1L) {
        Log.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    guF();
    sW(l);
    return;
    label255:
    gut();
    return;
    label260:
    this.Mwj.remove(gh(paramT));
    if (this.Mwj.Mwu.size() == 0)
    {
      this.Mwk.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.model.b.aeZ(getType());
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.Mwk.aQy(aeX(this.Mwj.Mwu.size()));
  }
  
  protected abstract long gh(T paramT);
  
  protected abstract ArrayList<Long> gi(T paramT);
  
  public final void guA()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()) });
    if (this.Mwj.Mwu.size() > 0)
    {
      Object localObject = this.Mwj;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).Mwu.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      bl(localArrayList);
    }
  }
  
  public final FailSendMsgNotification guC()
  {
    return this.Mwk;
  }
  
  protected final void guE()
  {
    b.a locala;
    if ((this.Mwj == null) || (this.Mwj.Mwu.size() == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.model.b.aeY(getType());
      if (locala == null) {
        Log.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.Mwq == null) {
      gup();
    }
    b localb = locala.Mwx;
    ArrayList localArrayList1 = locala.Mwz;
    ArrayList localArrayList2 = locala.MwA;
    int i = locala.Mwy;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.Mwj.clear();
      this.Mwj = localb;
      this.Mwm.clear();
      this.Mwn.clear();
      gur();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.Mwu.size())
    {
      Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      gut();
      return;
    }
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.Mwj.clear();
    this.Mwj = localb;
    this.Mwj.currentIndex = i;
    this.Mwm.clear();
    this.Mwm.addAll(localArrayList1);
    this.Mwn.clear();
    this.Mwn.addAll(localArrayList2);
    gus();
  }
  
  protected abstract void guG();
  
  protected void guu() {}
  
  public final void guv()
  {
    Log.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()) });
    this.Mwl = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.Mwk;
      localFailSendMsgNotification.Mxn = false;
      localFailSendMsgNotification.Mxa = com.tencent.mm.bq.a.cA(localFailSendMsgNotification.mContext, com.tencent.mm.bq.a.iGp());
      localFailSendMsgNotification.guT();
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.Mwk;
      localFailSendMsgNotification.Mxa.q(2, true);
      localFailSendMsgNotification.Mxm = true;
      localFailSendMsgNotification.show();
      Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.Mwk.aQy(km(this.Mwj.Mwu.size(), 0));
    }
    this.Mwj.currentIndex = 0;
    guz();
    this.Mwr.dead();
    this.Mwr.alive();
    sW(this.Mwj.guK());
    if (this.Mwq != null)
    {
      this.Mwq.startTimer(300000L);
      return;
    }
    Log.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  protected abstract String km(int paramInt1, int paramInt2);
  
  protected abstract String kn(int paramInt1, int paramInt2);
  
  final void sW(final long paramLong)
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
  
  public abstract void sX(long paramLong);
  
  public abstract boolean sY(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.base.a
 * JD-Core Version:    0.7.0.1
 */