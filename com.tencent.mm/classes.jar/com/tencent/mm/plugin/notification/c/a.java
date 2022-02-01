package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  protected Context mContext = null;
  protected b vql = null;
  protected FailSendMsgNotification vqm = null;
  protected boolean vqn = false;
  protected ArrayList<Long> vqo = null;
  protected ArrayList<Long> vqp = null;
  protected ArrayList<Long> vqq = null;
  private ArrayList<au> vqr = new ArrayList();
  private au vqs = null;
  private com.tencent.mm.sdk.b.c vqt = new a.1(this);
  
  public a()
  {
    this.vqm.vre = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void dly()
      {
        AppMethodBeat.i(26728);
        ac.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            h.wUl.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dlv();
            a.a(a.this);
            a.this.dlm();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void dlz()
      {
        AppMethodBeat.i(26729);
        ac.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            h.wUl.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dlv();
            a.this.dlr();
            a.b(a.this);
            a.this.vqm.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.vqm.vrf = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void dlA()
      {
        AppMethodBeat.i(26730);
        h.wUl.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.dlv();
        a.this.dlx();
        if (!a.this.vqn) {
          a.this.vqm.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.vqm.vrg = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    dlg();
  }
  
  private void dlg()
  {
    this.vqs = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.vqn)
        {
          ac.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.vql.vqw.size()), Integer.valueOf(a.this.vqo.size()), Integer.valueOf(a.this.vqp.size()) });
          a.c(a.this);
          ac.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.vql.vqw.size()), Integer.valueOf(a.this.vqo.size()), Integer.valueOf(a.this.vqp.size()) });
          if (a.this.vql.vqw.size() > 0) {
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
  
  private void dlh()
  {
    if (this.vqs != null)
    {
      this.vqs.stopTimer();
      return;
    }
    ac.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void dli()
  {
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.bqq()) });
    this.vqm.vri = KA(this.vql.vqw.size());
    this.vqm.dlM();
    if ((!f.bqq()) && (!this.vqm.vrn))
    {
      this.vqm.vrh = KA(this.vql.vqw.size());
      this.vqm.dlL();
      this.vqm.dlK();
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.vqm.show();
      com.tencent.mm.sdk.b.a.GpY.d(this.vqt);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqt);
      return;
    }
    if (this.vqm.vrn)
    {
      this.vqm.dlL();
      this.vqm.dlK();
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.vqm.aoA(KA(this.vql.vqw.size()));
      com.tencent.mm.sdk.b.a.GpY.d(this.vqt);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqt);
      return;
    }
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.bqq()) });
  }
  
  private void dlj()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.vqm.vri = KA(this.vql.vqw.size());
      if (this.vqp.size() <= 0) {
        this.vqm.aoA(gx(this.vql.vqw.size(), this.vqo.size() + this.vqp.size()));
      }
    }
    else
    {
      return;
    }
    this.vqm.aoA(ap(this.vql.vqw.size(), this.vqo.size() + this.vqp.size(), this.vqp.size()));
  }
  
  private void dlk()
  {
    this.vqn = false;
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()), Integer.valueOf(this.vqp.size()), Integer.valueOf(this.vqo.size()) });
    dln();
    if ((this.vqp.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.KC(getType());
    }
    h.wUl.f(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.vqo.size()), Integer.valueOf(this.vqp.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.vqm.dlL();
      this.vqm.vri = KA(this.vql.vqw.size());
      localObject = this.vqm;
      this.vql.vqw.size();
      ((FailSendMsgNotification)localObject).aoA(gy(this.vqo.size(), this.vqp.size()));
      this.vqm.dlK();
      if (this.vqp.size() > 0)
      {
        this.vqm.dlM();
        this.vqm.show();
        dlu();
        dlw();
      }
    }
    Object localObject = new mm();
    ((mm)localObject).doZ.type = getType();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    dlh();
    dlq();
    com.tencent.mm.sdk.b.a.GpY.d(this.vqt);
    dll();
  }
  
  private void dln()
  {
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()), Integer.valueOf(this.vqo.size()), Integer.valueOf(this.vqp.size()) });
    dlo();
    dlp();
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()), Integer.valueOf(this.vqo.size()), Integer.valueOf(this.vqp.size()) });
  }
  
  private void dlo()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.vql.vqw.size())
    {
      long l = this.vql.get(i);
      if (!wg(l)) {
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
        this.vql.remove(localLong.longValue());
      }
    }
  }
  
  private void dlp()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.vqo.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!wg(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.vqo.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.vqp.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!wg(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.vqp.remove(localObject2);
    }
  }
  
  private void dlq()
  {
    Iterator localIterator = this.vqr.iterator();
    while (localIterator.hasNext()) {
      ((au)localIterator.next()).stopTimer();
    }
    this.vqr.clear();
    this.vqq.clear();
  }
  
  private String dls()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.vql.vqw.size())
    {
      long l = this.vql.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void dlu()
  {
    this.vql.currentIndex = 0;
    if (this.vqo.size() > 0)
    {
      Iterator localIterator = this.vqo.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.vql.remove(localLong.longValue());
      }
    }
    this.vqo.clear();
    this.vqp.clear();
  }
  
  private void dlw()
  {
    b.a locala = new b.a(this.vql, this.vql.currentIndex, this.vqo, this.vqp);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void resetStatus()
  {
    this.vql.clear();
    this.vqn = false;
    this.vqo.clear();
    this.vqp.clear();
    dlq();
  }
  
  protected abstract String KA(int paramInt);
  
  protected abstract String ap(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract void aq(ArrayList<Long> paramArrayList);
  
  protected void dll() {}
  
  public final void dlm()
  {
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()) });
    this.vqn = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.vqm;
      localFailSendMsgNotification.vrp = false;
      localFailSendMsgNotification.vrc = com.tencent.mm.bq.a.bE(localFailSendMsgNotification.mContext, com.tencent.mm.bq.a.eJR());
      localFailSendMsgNotification.dlJ();
      localFailSendMsgNotification.show();
      ac.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.vqm;
      localFailSendMsgNotification.vrc.f(2, true);
      localFailSendMsgNotification.vro = true;
      localFailSendMsgNotification.show();
      ac.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.vqm.aoA(gx(this.vql.vqw.size(), 0));
    }
    this.vql.currentIndex = 0;
    dlq();
    com.tencent.mm.sdk.b.a.GpY.d(this.vqt);
    com.tencent.mm.sdk.b.a.GpY.c(this.vqt);
    we(this.vql.dlB());
    if (this.vqs != null)
    {
      this.vqs.au(300000L, 300000L);
      return;
    }
    ac.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void dlr()
  {
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()) });
    if (this.vql.vqw.size() > 0)
    {
      Object localObject = this.vql;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).vqw.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      aq(localArrayList);
    }
  }
  
  public final FailSendMsgNotification dlt()
  {
    return this.vqm;
  }
  
  protected final void dlv()
  {
    b.a locala;
    if ((this.vql == null) || (this.vql.vqw.size() == 0))
    {
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.KB(getType());
      if (locala == null) {
        ac.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.vqs == null) {
      dlg();
    }
    b localb = locala.vqy;
    ArrayList localArrayList1 = locala.vqA;
    ArrayList localArrayList2 = locala.vqB;
    int i = locala.vqz;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.vql.clear();
      this.vql = localb;
      this.vqo.clear();
      this.vqp.clear();
      dli();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.vqw.size())
    {
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      dlk();
      return;
    }
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.vql.clear();
    this.vql = localb;
    this.vql.currentIndex = i;
    this.vqo.clear();
    this.vqo.addAll(localArrayList1);
    this.vqp.clear();
    this.vqp.addAll(localArrayList2);
    dlj();
  }
  
  protected abstract void dlx();
  
  public final void dv(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dx(paramT)), dls(), Boolean.valueOf(this.vqn) });
    if (!this.vqn)
    {
      if (!this.vqq.contains(Long.valueOf(dx(paramT))))
      {
        if (paramT == null)
        {
          ac.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dy(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          ac.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.vql;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.vqw.addAll(paramT);
        }
        dlw();
        ac.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.vql.vqw.size()), dls() });
        h.wUl.f(11426, new Object[] { Integer.valueOf(getType()) });
        ap.n(new Runnable()
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
      this.vqq.remove(Long.valueOf(dx(paramT)));
      return;
    }
    if ((this.vql.contains(dx(paramT))) && (!this.vqp.contains(Long.valueOf(dx(paramT))))) {
      this.vqp.add(Long.valueOf(dx(paramT)));
    }
    if (!this.vql.contains(dx(paramT)))
    {
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.vql.wh(dx(paramT));
    }
    dlj();
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.vqo.size()), Integer.valueOf(this.vqp.size()) });
    if (this.vqo.size() + this.vqp.size() < this.vql.vqw.size())
    {
      long l = this.vql.dlB();
      if (l == -1L)
      {
        ac.e("TAG", "resend error, next msg id is -1");
        return;
      }
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      dlw();
      we(l);
      return;
    }
    dlk();
  }
  
  public final void dw(T paramT)
  {
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dx(paramT)), dls() });
    long l;
    if (this.vql.contains(dx(paramT)))
    {
      l = dx(paramT);
      if ((this.vqq.contains(Long.valueOf(l))) && (this.vqp.contains(Long.valueOf(l))))
      {
        ac.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.vqq.remove(Long.valueOf(l));
        this.vqp.remove(Long.valueOf(l));
      }
      if (!this.vqn) {
        break label260;
      }
      this.vqo.add(Long.valueOf(l));
      dlj();
      ac.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.vqo.size()), Integer.valueOf(this.vqp.size()) });
      if (this.vqo.size() + this.vqp.size() >= this.vql.vqw.size()) {
        break label255;
      }
      l = this.vql.dlB();
      if (l == -1L) {
        ac.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    dlw();
    we(l);
    return;
    label255:
    dlk();
    return;
    label260:
    this.vql.remove(dx(paramT));
    if (this.vql.vqw.size() == 0)
    {
      this.vqm.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.KC(getType());
      return;
    }
    ac.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.vqm.aoA(KA(this.vql.vqw.size()));
  }
  
  protected abstract long dx(T paramT);
  
  protected abstract ArrayList<Long> dy(T paramT);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  protected abstract String gx(int paramInt1, int paramInt2);
  
  protected abstract String gy(int paramInt1, int paramInt2);
  
  final void we(final long paramLong)
  {
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26734);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26734);
      }
    }, 200L);
  }
  
  public abstract void wf(long paramLong);
  
  public abstract boolean wg(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */