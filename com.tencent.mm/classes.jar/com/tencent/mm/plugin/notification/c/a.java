package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.md;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  protected Context mContext = null;
  protected b uhn = null;
  protected FailSendMsgNotification uho = null;
  protected boolean uhp = false;
  protected ArrayList<Long> uhq = null;
  protected ArrayList<Long> uhr = null;
  protected ArrayList<Long> uhs = null;
  private ArrayList<av> uht = new ArrayList();
  private av uhu = null;
  private com.tencent.mm.sdk.b.c uhv = new a.1(this);
  
  public a()
  {
    this.uho.uih = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void cXQ()
      {
        AppMethodBeat.i(26728);
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            h.vKh.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.cXN();
            a.a(a.this);
            a.this.cXE();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void cXR()
      {
        AppMethodBeat.i(26729);
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            h.vKh.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.cXN();
            a.this.cXJ();
            a.b(a.this);
            a.this.uho.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.uho.uii = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void cXS()
      {
        AppMethodBeat.i(26730);
        h.vKh.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.cXN();
        a.this.cXP();
        if (!a.this.uhp) {
          a.this.uho.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.uho.uij = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    cXy();
  }
  
  private void cXA()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.bjz()) });
    this.uho.uil = IB(this.uhn.uhy.size());
    this.uho.cYe();
    if ((!f.bjz()) && (!this.uho.uir))
    {
      this.uho.uik = IB(this.uhn.uhy.size());
      this.uho.cYd();
      this.uho.cYc();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.uho.show();
      com.tencent.mm.sdk.b.a.ESL.d(this.uhv);
      com.tencent.mm.sdk.b.a.ESL.c(this.uhv);
      return;
    }
    if (this.uho.uir)
    {
      this.uho.cYd();
      this.uho.cYc();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.uho.ajC(IB(this.uhn.uhy.size()));
      com.tencent.mm.sdk.b.a.ESL.d(this.uhv);
      com.tencent.mm.sdk.b.a.ESL.c(this.uhv);
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.bjz()) });
  }
  
  private void cXB()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.uho.uil = IB(this.uhn.uhy.size());
      if (this.uhr.size() <= 0) {
        this.uho.ajC(gq(this.uhn.uhy.size(), this.uhq.size() + this.uhr.size()));
      }
    }
    else
    {
      return;
    }
    this.uho.ajC(an(this.uhn.uhy.size(), this.uhq.size() + this.uhr.size(), this.uhr.size()));
  }
  
  private void cXC()
  {
    this.uhp = false;
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()), Integer.valueOf(this.uhr.size()), Integer.valueOf(this.uhq.size()) });
    cXF();
    if ((this.uhr.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.ID(getType());
    }
    h.vKh.f(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.uhq.size()), Integer.valueOf(this.uhr.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.uho.cYd();
      this.uho.uil = IB(this.uhn.uhy.size());
      localObject = this.uho;
      this.uhn.uhy.size();
      ((FailSendMsgNotification)localObject).ajC(gr(this.uhq.size(), this.uhr.size()));
      this.uho.cYc();
      if (this.uhr.size() > 0)
      {
        this.uho.cYe();
        this.uho.show();
        cXM();
        cXO();
      }
    }
    Object localObject = new md();
    ((md)localObject).dro.type = getType();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    cXz();
    cXI();
    com.tencent.mm.sdk.b.a.ESL.d(this.uhv);
    cXD();
  }
  
  private void cXF()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()), Integer.valueOf(this.uhq.size()), Integer.valueOf(this.uhr.size()) });
    cXG();
    cXH();
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()), Integer.valueOf(this.uhq.size()), Integer.valueOf(this.uhr.size()) });
  }
  
  private void cXG()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.uhn.uhy.size())
    {
      long l = this.uhn.get(i);
      if (!rD(l)) {
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
        this.uhn.remove(localLong.longValue());
      }
    }
  }
  
  private void cXH()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.uhq.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!rD(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.uhq.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.uhr.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!rD(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.uhr.remove(localObject2);
    }
  }
  
  private void cXI()
  {
    Iterator localIterator = this.uht.iterator();
    while (localIterator.hasNext()) {
      ((av)localIterator.next()).stopTimer();
    }
    this.uht.clear();
    this.uhs.clear();
  }
  
  private String cXK()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.uhn.uhy.size())
    {
      long l = this.uhn.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void cXM()
  {
    this.uhn.currentIndex = 0;
    if (this.uhq.size() > 0)
    {
      Iterator localIterator = this.uhq.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.uhn.remove(localLong.longValue());
      }
    }
    this.uhq.clear();
    this.uhr.clear();
  }
  
  private void cXO()
  {
    b.a locala = new b.a(this.uhn, this.uhn.currentIndex, this.uhq, this.uhr);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void cXy()
  {
    this.uhu = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.uhp)
        {
          ad.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.uhn.uhy.size()), Integer.valueOf(a.this.uhq.size()), Integer.valueOf(a.this.uhr.size()) });
          a.c(a.this);
          ad.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.uhn.uhy.size()), Integer.valueOf(a.this.uhq.size()), Integer.valueOf(a.this.uhr.size()) });
          if (a.this.uhn.uhy.size() > 0) {
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
  
  private void cXz()
  {
    if (this.uhu != null)
    {
      this.uhu.stopTimer();
      return;
    }
    ad.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void resetStatus()
  {
    this.uhn.clear();
    this.uhp = false;
    this.uhq.clear();
    this.uhr.clear();
    cXI();
  }
  
  protected abstract String IB(int paramInt);
  
  protected abstract void af(ArrayList<Long> paramArrayList);
  
  protected abstract String an(int paramInt1, int paramInt2, int paramInt3);
  
  protected void cXD() {}
  
  public final void cXE()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()) });
    this.uhp = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.uho;
      localFailSendMsgNotification.uit = false;
      localFailSendMsgNotification.uif = com.tencent.mm.br.a.bD(localFailSendMsgNotification.mContext, com.tencent.mm.br.a.euy());
      localFailSendMsgNotification.cYb();
      localFailSendMsgNotification.show();
      ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.uho;
      localFailSendMsgNotification.uif.f(2, true);
      localFailSendMsgNotification.uis = true;
      localFailSendMsgNotification.show();
      ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.uho.ajC(gq(this.uhn.uhy.size(), 0));
    }
    this.uhn.currentIndex = 0;
    cXI();
    com.tencent.mm.sdk.b.a.ESL.d(this.uhv);
    com.tencent.mm.sdk.b.a.ESL.c(this.uhv);
    rB(this.uhn.cXT());
    if (this.uhu != null)
    {
      this.uhu.av(300000L, 300000L);
      return;
    }
    ad.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void cXJ()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()) });
    if (this.uhn.uhy.size() > 0)
    {
      Object localObject = this.uhn;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).uhy.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      af(localArrayList);
    }
  }
  
  public final FailSendMsgNotification cXL()
  {
    return this.uho;
  }
  
  protected final void cXN()
  {
    b.a locala;
    if ((this.uhn == null) || (this.uhn.uhy.size() == 0))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.IC(getType());
      if (locala == null) {
        ad.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.uhu == null) {
      cXy();
    }
    b localb = locala.uhA;
    ArrayList localArrayList1 = locala.uhC;
    ArrayList localArrayList2 = locala.uhD;
    int i = locala.uhB;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.uhn.clear();
      this.uhn = localb;
      this.uhq.clear();
      this.uhr.clear();
      cXA();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.uhy.size())
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      cXC();
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.uhn.clear();
    this.uhn = localb;
    this.uhn.currentIndex = i;
    this.uhq.clear();
    this.uhq.addAll(localArrayList1);
    this.uhr.clear();
    this.uhr.addAll(localArrayList2);
    cXB();
  }
  
  protected abstract void cXP();
  
  public final void du(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dw(paramT)), cXK(), Boolean.valueOf(this.uhp) });
    if (!this.uhp)
    {
      if (!this.uhs.contains(Long.valueOf(dw(paramT))))
      {
        if (paramT == null)
        {
          ad.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dx(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          ad.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.uhn;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.uhy.addAll(paramT);
        }
        cXO();
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.uhn.uhy.size()), cXK() });
        h.vKh.f(11426, new Object[] { Integer.valueOf(getType()) });
        aq.n(new Runnable()
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
      this.uhs.remove(Long.valueOf(dw(paramT)));
      return;
    }
    if ((this.uhn.contains(dw(paramT))) && (!this.uhr.contains(Long.valueOf(dw(paramT))))) {
      this.uhr.add(Long.valueOf(dw(paramT)));
    }
    if (!this.uhn.contains(dw(paramT)))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.uhn.rE(dw(paramT));
    }
    cXB();
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.uhq.size()), Integer.valueOf(this.uhr.size()) });
    if (this.uhq.size() + this.uhr.size() < this.uhn.uhy.size())
    {
      long l = this.uhn.cXT();
      if (l == -1L)
      {
        ad.e("TAG", "resend error, next msg id is -1");
        return;
      }
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      cXO();
      rB(l);
      return;
    }
    cXC();
  }
  
  public final void dv(T paramT)
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dw(paramT)), cXK() });
    long l;
    if (this.uhn.contains(dw(paramT)))
    {
      l = dw(paramT);
      if ((this.uhs.contains(Long.valueOf(l))) && (this.uhr.contains(Long.valueOf(l))))
      {
        ad.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.uhs.remove(Long.valueOf(l));
        this.uhr.remove(Long.valueOf(l));
      }
      if (!this.uhp) {
        break label260;
      }
      this.uhq.add(Long.valueOf(l));
      cXB();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.uhq.size()), Integer.valueOf(this.uhr.size()) });
      if (this.uhq.size() + this.uhr.size() >= this.uhn.uhy.size()) {
        break label255;
      }
      l = this.uhn.cXT();
      if (l == -1L) {
        ad.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    cXO();
    rB(l);
    return;
    label255:
    cXC();
    return;
    label260:
    this.uhn.remove(dw(paramT));
    if (this.uhn.uhy.size() == 0)
    {
      this.uho.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.ID(getType());
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.uho.ajC(IB(this.uhn.uhy.size()));
  }
  
  protected abstract long dw(T paramT);
  
  protected abstract ArrayList<Long> dx(T paramT);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  protected abstract String gq(int paramInt1, int paramInt2);
  
  protected abstract String gr(int paramInt1, int paramInt2);
  
  final void rB(final long paramLong)
  {
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26734);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26734);
      }
    }, 200L);
  }
  
  public abstract void rC(long paramLong);
  
  public abstract boolean rD(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */