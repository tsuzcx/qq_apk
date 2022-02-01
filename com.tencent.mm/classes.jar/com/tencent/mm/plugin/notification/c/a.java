package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
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
  protected b wvD = null;
  protected FailSendMsgNotification wvE = null;
  protected boolean wvF = false;
  protected ArrayList<Long> wvG = null;
  protected ArrayList<Long> wvH = null;
  protected ArrayList<Long> wvI = null;
  private ArrayList<av> wvJ = new ArrayList();
  private av wvK = null;
  private com.tencent.mm.sdk.b.c wvL = new a.1(this);
  
  public a()
  {
    this.wvE.www = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void dvP()
      {
        AppMethodBeat.i(26728);
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            g.yhR.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dvM();
            a.a(a.this);
            a.this.dvD();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void dvQ()
      {
        AppMethodBeat.i(26729);
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            g.yhR.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dvM();
            a.this.dvI();
            a.b(a.this);
            a.this.wvE.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.wvE.wwx = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void dvR()
      {
        AppMethodBeat.i(26730);
        g.yhR.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.dvM();
        a.this.dvO();
        if (!a.this.wvF) {
          a.this.wvE.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.wvE.wwy = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    dvx();
  }
  
  private void dvA()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.wvE.wwA = Mc(this.wvD.wvO.size());
      if (this.wvH.size() <= 0) {
        this.wvE.atA(gP(this.wvD.wvO.size(), this.wvG.size() + this.wvH.size()));
      }
    }
    else
    {
      return;
    }
    this.wvE.atA(ap(this.wvD.wvO.size(), this.wvG.size() + this.wvH.size(), this.wvH.size()));
  }
  
  private void dvB()
  {
    this.wvF = false;
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()), Integer.valueOf(this.wvH.size()), Integer.valueOf(this.wvG.size()) });
    dvE();
    if ((this.wvH.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.Me(getType());
    }
    g.yhR.f(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.wvG.size()), Integer.valueOf(this.wvH.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.wvE.dwc();
      this.wvE.wwA = Mc(this.wvD.wvO.size());
      localObject = this.wvE;
      this.wvD.wvO.size();
      ((FailSendMsgNotification)localObject).atA(gQ(this.wvG.size(), this.wvH.size()));
      this.wvE.dwb();
      if (this.wvH.size() > 0)
      {
        this.wvE.dwd();
        this.wvE.show();
        dvL();
        dvN();
      }
    }
    Object localObject = new mv();
    ((mv)localObject).dAN.type = getType();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    dvy();
    dvH();
    com.tencent.mm.sdk.b.a.IbL.d(this.wvL);
    dvC();
  }
  
  private void dvE()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()), Integer.valueOf(this.wvG.size()), Integer.valueOf(this.wvH.size()) });
    dvF();
    dvG();
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()), Integer.valueOf(this.wvG.size()), Integer.valueOf(this.wvH.size()) });
  }
  
  private void dvF()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.wvD.wvO.size())
    {
      long l = this.wvD.get(i);
      if (!yp(l)) {
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
        this.wvD.remove(localLong.longValue());
      }
    }
  }
  
  private void dvG()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.wvG.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!yp(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.wvG.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.wvH.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!yp(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.wvH.remove(localObject2);
    }
  }
  
  private void dvH()
  {
    Iterator localIterator = this.wvJ.iterator();
    while (localIterator.hasNext()) {
      ((av)localIterator.next()).stopTimer();
    }
    this.wvJ.clear();
    this.wvI.clear();
  }
  
  private String dvJ()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.wvD.wvO.size())
    {
      long l = this.wvD.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void dvL()
  {
    this.wvD.currentIndex = 0;
    if (this.wvG.size() > 0)
    {
      Iterator localIterator = this.wvG.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.wvD.remove(localLong.longValue());
      }
    }
    this.wvG.clear();
    this.wvH.clear();
  }
  
  private void dvN()
  {
    b.a locala = new b.a(this.wvD, this.wvD.currentIndex, this.wvG, this.wvH);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void dvx()
  {
    this.wvK = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.wvF)
        {
          ad.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.wvD.wvO.size()), Integer.valueOf(a.this.wvG.size()), Integer.valueOf(a.this.wvH.size()) });
          a.c(a.this);
          ad.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.wvD.wvO.size()), Integer.valueOf(a.this.wvG.size()), Integer.valueOf(a.this.wvH.size()) });
          if (a.this.wvD.wvO.size() > 0) {
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
  
  private void dvy()
  {
    if (this.wvK != null)
    {
      this.wvK.stopTimer();
      return;
    }
    ad.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void dvz()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.FG()) });
    this.wvE.wwA = Mc(this.wvD.wvO.size());
    this.wvE.dwd();
    if ((!f.FG()) && (!this.wvE.wwF))
    {
      this.wvE.wwz = Mc(this.wvD.wvO.size());
      this.wvE.dwc();
      this.wvE.dwb();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.wvE.show();
      com.tencent.mm.sdk.b.a.IbL.d(this.wvL);
      com.tencent.mm.sdk.b.a.IbL.c(this.wvL);
      return;
    }
    if (this.wvE.wwF)
    {
      this.wvE.dwc();
      this.wvE.dwb();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.wvE.atA(Mc(this.wvD.wvO.size()));
      com.tencent.mm.sdk.b.a.IbL.d(this.wvL);
      com.tencent.mm.sdk.b.a.IbL.c(this.wvL);
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.FG()) });
  }
  
  private void resetStatus()
  {
    this.wvD.clear();
    this.wvF = false;
    this.wvG.clear();
    this.wvH.clear();
    dvH();
  }
  
  protected abstract String Mc(int paramInt);
  
  protected abstract String ap(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract void ap(ArrayList<Long> paramArrayList);
  
  protected abstract long dA(T paramT);
  
  protected abstract ArrayList<Long> dB(T paramT);
  
  protected void dvC() {}
  
  public final void dvD()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()) });
    this.wvF = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.wvE;
      localFailSendMsgNotification.wwH = false;
      localFailSendMsgNotification.wwu = com.tencent.mm.br.a.bI(localFailSendMsgNotification.mContext, com.tencent.mm.br.a.eYF());
      localFailSendMsgNotification.dwa();
      localFailSendMsgNotification.show();
      ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.wvE;
      localFailSendMsgNotification.wwu.f(2, true);
      localFailSendMsgNotification.wwG = true;
      localFailSendMsgNotification.show();
      ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.wvE.atA(gP(this.wvD.wvO.size(), 0));
    }
    this.wvD.currentIndex = 0;
    dvH();
    com.tencent.mm.sdk.b.a.IbL.d(this.wvL);
    com.tencent.mm.sdk.b.a.IbL.c(this.wvL);
    yn(this.wvD.dvS());
    if (this.wvK != null)
    {
      this.wvK.az(300000L, 300000L);
      return;
    }
    ad.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void dvI()
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()) });
    if (this.wvD.wvO.size() > 0)
    {
      Object localObject = this.wvD;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).wvO.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      ap(localArrayList);
    }
  }
  
  public final FailSendMsgNotification dvK()
  {
    return this.wvE;
  }
  
  protected final void dvM()
  {
    b.a locala;
    if ((this.wvD == null) || (this.wvD.wvO.size() == 0))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.Md(getType());
      if (locala == null) {
        ad.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.wvK == null) {
      dvx();
    }
    b localb = locala.wvQ;
    ArrayList localArrayList1 = locala.wvS;
    ArrayList localArrayList2 = locala.wvT;
    int i = locala.wvR;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.wvD.clear();
      this.wvD = localb;
      this.wvG.clear();
      this.wvH.clear();
      dvz();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.wvO.size())
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      dvB();
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.wvD.clear();
    this.wvD = localb;
    this.wvD.currentIndex = i;
    this.wvG.clear();
    this.wvG.addAll(localArrayList1);
    this.wvH.clear();
    this.wvH.addAll(localArrayList2);
    dvA();
  }
  
  protected abstract void dvO();
  
  public final void dy(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dA(paramT)), dvJ(), Boolean.valueOf(this.wvF) });
    if (!this.wvF)
    {
      if (!this.wvI.contains(Long.valueOf(dA(paramT))))
      {
        if (paramT == null)
        {
          ad.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dB(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          ad.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.wvD;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.wvO.addAll(paramT);
        }
        dvN();
        ad.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.wvD.wvO.size()), dvJ() });
        g.yhR.f(11426, new Object[] { Integer.valueOf(getType()) });
        aq.o(new Runnable()
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
      this.wvI.remove(Long.valueOf(dA(paramT)));
      return;
    }
    if ((this.wvD.contains(dA(paramT))) && (!this.wvH.contains(Long.valueOf(dA(paramT))))) {
      this.wvH.add(Long.valueOf(dA(paramT)));
    }
    if (!this.wvD.contains(dA(paramT)))
    {
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.wvD.yq(dA(paramT));
    }
    dvA();
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.wvG.size()), Integer.valueOf(this.wvH.size()) });
    if (this.wvG.size() + this.wvH.size() < this.wvD.wvO.size())
    {
      long l = this.wvD.dvS();
      if (l == -1L)
      {
        ad.e("TAG", "resend error, next msg id is -1");
        return;
      }
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      dvN();
      yn(l);
      return;
    }
    dvB();
  }
  
  public final void dz(T paramT)
  {
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dA(paramT)), dvJ() });
    long l;
    if (this.wvD.contains(dA(paramT)))
    {
      l = dA(paramT);
      if ((this.wvI.contains(Long.valueOf(l))) && (this.wvH.contains(Long.valueOf(l))))
      {
        ad.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.wvI.remove(Long.valueOf(l));
        this.wvH.remove(Long.valueOf(l));
      }
      if (!this.wvF) {
        break label260;
      }
      this.wvG.add(Long.valueOf(l));
      dvA();
      ad.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.wvG.size()), Integer.valueOf(this.wvH.size()) });
      if (this.wvG.size() + this.wvH.size() >= this.wvD.wvO.size()) {
        break label255;
      }
      l = this.wvD.dvS();
      if (l == -1L) {
        ad.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    dvN();
    yn(l);
    return;
    label255:
    dvB();
    return;
    label260:
    this.wvD.remove(dA(paramT));
    if (this.wvD.wvO.size() == 0)
    {
      this.wvE.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.Me(getType());
      return;
    }
    ad.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.wvE.atA(Mc(this.wvD.wvO.size()));
  }
  
  protected abstract String gP(int paramInt1, int paramInt2);
  
  protected abstract String gQ(int paramInt1, int paramInt2);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  final void yn(final long paramLong)
  {
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26734);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26734);
      }
    }, 200L);
  }
  
  public abstract void yo(long paramLong);
  
  public abstract boolean yp(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */