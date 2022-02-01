package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  protected Context mContext = null;
  protected b wLo = null;
  protected FailSendMsgNotification wLp = null;
  protected boolean wLq = false;
  protected ArrayList<Long> wLr = null;
  protected ArrayList<Long> wLs = null;
  protected ArrayList<Long> wLt = null;
  private ArrayList<aw> wLu = new ArrayList();
  private aw wLv = null;
  private com.tencent.mm.sdk.b.c wLw = new a.1(this);
  
  public a()
  {
    this.wLp.wMh = new com.tencent.mm.plugin.notification.ui.a()
    {
      public final void dze()
      {
        AppMethodBeat.i(26728);
        ae.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26726);
            g.yxI.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dzb();
            a.a(a.this);
            a.this.dyS();
            AppMethodBeat.o(26726);
          }
        });
        AppMethodBeat.o(26728);
      }
      
      public final void dzf()
      {
        AppMethodBeat.i(26729);
        ae.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26727);
            g.yxI.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
            a.this.dzb();
            a.this.dyX();
            a.b(a.this);
            a.this.wLp.dismiss();
            AppMethodBeat.o(26727);
          }
        });
        AppMethodBeat.o(26729);
      }
    };
    this.wLp.wMi = new com.tencent.mm.plugin.notification.ui.b()
    {
      public final void dzg()
      {
        AppMethodBeat.i(26730);
        g.yxI.f(11425, new Object[] { Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        a.this.dzb();
        a.this.dzd();
        if (!a.this.wLq) {
          a.this.wLp.dismiss();
        }
        AppMethodBeat.o(26730);
      }
    };
    this.wLp.wMj = new com.tencent.mm.plugin.notification.ui.c()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(26731);
        a.b(a.this);
        AppMethodBeat.o(26731);
      }
    };
    dyM();
  }
  
  private void dyM()
  {
    this.wLv = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26732);
        if (a.this.wLq)
        {
          ae.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.wLo.wLz.size()), Integer.valueOf(a.this.wLr.size()), Integer.valueOf(a.this.wLs.size()) });
          a.c(a.this);
          ae.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(a.this.wLo.wLz.size()), Integer.valueOf(a.this.wLr.size()), Integer.valueOf(a.this.wLs.size()) });
          if (a.this.wLo.wLz.size() > 0) {
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
  
  private void dyN()
  {
    if (this.wLv != null)
    {
      this.wLv.stopTimer();
      return;
    }
    ae.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void dyO()
  {
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.FM()) });
    this.wLp.wMl = MH(this.wLo.wLz.size());
    this.wLp.dzt();
    if ((!f.FM()) && (!this.wLp.wMq))
    {
      this.wLp.wMk = MH(this.wLo.wLz.size());
      this.wLp.dzs();
      this.wLp.dzr();
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.wLp.show();
      com.tencent.mm.sdk.b.a.IvT.d(this.wLw);
      com.tencent.mm.sdk.b.a.IvT.c(this.wLw);
      return;
    }
    if (this.wLp.wMq)
    {
      this.wLp.dzs();
      this.wLp.dzr();
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.wLp.auP(MH(this.wLo.wLz.size()));
      com.tencent.mm.sdk.b.a.IvT.d(this.wLw);
      com.tencent.mm.sdk.b.a.IvT.c(this.wLw);
      return;
    }
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.FM()) });
  }
  
  private void dyP()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.wLp.wMl = MH(this.wLo.wLz.size());
      if (this.wLs.size() <= 0) {
        this.wLp.auP(gQ(this.wLo.wLz.size(), this.wLr.size() + this.wLs.size()));
      }
    }
    else
    {
      return;
    }
    this.wLp.auP(ap(this.wLo.wLz.size(), this.wLr.size() + this.wLs.size(), this.wLs.size()));
  }
  
  private void dyQ()
  {
    this.wLq = false;
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()), Integer.valueOf(this.wLs.size()), Integer.valueOf(this.wLr.size()) });
    dyT();
    if ((this.wLs.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.MJ(getType());
    }
    g.yxI.f(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.wLr.size()), Integer.valueOf(this.wLs.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.wLp.dzs();
      this.wLp.wMl = MH(this.wLo.wLz.size());
      localObject = this.wLp;
      this.wLo.wLz.size();
      ((FailSendMsgNotification)localObject).auP(gR(this.wLr.size(), this.wLs.size()));
      this.wLp.dzr();
      if (this.wLs.size() > 0)
      {
        this.wLp.dzt();
        this.wLp.show();
        dza();
        dzc();
      }
    }
    Object localObject = new mw();
    ((mw)localObject).dBS.type = getType();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    dyN();
    dyW();
    com.tencent.mm.sdk.b.a.IvT.d(this.wLw);
    dyR();
  }
  
  private void dyT()
  {
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()), Integer.valueOf(this.wLr.size()), Integer.valueOf(this.wLs.size()) });
    dyU();
    dyV();
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()), Integer.valueOf(this.wLr.size()), Integer.valueOf(this.wLs.size()) });
  }
  
  private void dyU()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.wLo.wLz.size())
    {
      long l = this.wLo.get(i);
      if (!yJ(l)) {
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
        this.wLo.remove(localLong.longValue());
      }
    }
  }
  
  private void dyV()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.wLr.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!yJ(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.wLr.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.wLs.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!yJ(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.wLs.remove(localObject2);
    }
  }
  
  private void dyW()
  {
    Iterator localIterator = this.wLu.iterator();
    while (localIterator.hasNext()) {
      ((aw)localIterator.next()).stopTimer();
    }
    this.wLu.clear();
    this.wLt.clear();
  }
  
  private String dyY()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.wLo.wLz.size())
    {
      long l = this.wLo.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void dza()
  {
    this.wLo.currentIndex = 0;
    if (this.wLr.size() > 0)
    {
      Iterator localIterator = this.wLr.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.wLo.remove(localLong.longValue());
      }
    }
    this.wLr.clear();
    this.wLs.clear();
  }
  
  private void dzc()
  {
    b.a locala = new b.a(this.wLo, this.wLo.currentIndex, this.wLr, this.wLs);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  private void resetStatus()
  {
    this.wLo.clear();
    this.wLq = false;
    this.wLr.clear();
    this.wLs.clear();
    dyW();
  }
  
  protected abstract String MH(int paramInt);
  
  protected abstract String ap(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract void aq(ArrayList<Long> paramArrayList);
  
  public final void dA(T paramT)
  {
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(dB(paramT)), dyY() });
    long l;
    if (this.wLo.contains(dB(paramT)))
    {
      l = dB(paramT);
      if ((this.wLt.contains(Long.valueOf(l))) && (this.wLs.contains(Long.valueOf(l))))
      {
        ae.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.wLt.remove(Long.valueOf(l));
        this.wLs.remove(Long.valueOf(l));
      }
      if (!this.wLq) {
        break label260;
      }
      this.wLr.add(Long.valueOf(l));
      dyP();
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.wLr.size()), Integer.valueOf(this.wLs.size()) });
      if (this.wLr.size() + this.wLs.size() >= this.wLo.wLz.size()) {
        break label255;
      }
      l = this.wLo.dzh();
      if (l == -1L) {
        ae.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    dzc();
    yH(l);
    return;
    label255:
    dyQ();
    return;
    label260:
    this.wLo.remove(dB(paramT));
    if (this.wLo.wLz.size() == 0)
    {
      this.wLp.dismiss();
      resetStatus();
      com.tencent.mm.plugin.notification.d.b.MJ(getType());
      return;
    }
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.wLp.auP(MH(this.wLo.wLz.size()));
  }
  
  protected abstract long dB(T paramT);
  
  protected abstract ArrayList<Long> dC(T paramT);
  
  protected void dyR() {}
  
  public final void dyS()
  {
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()) });
    this.wLq = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.wLp;
      localFailSendMsgNotification.wMs = false;
      localFailSendMsgNotification.wMf = com.tencent.mm.bq.a.bJ(localFailSendMsgNotification.mContext, com.tencent.mm.bq.a.fct());
      localFailSendMsgNotification.dzq();
      localFailSendMsgNotification.show();
      ae.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.wLp;
      localFailSendMsgNotification.wMf.f(2, true);
      localFailSendMsgNotification.wMr = true;
      localFailSendMsgNotification.show();
      ae.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.wLp.auP(gQ(this.wLo.wLz.size(), 0));
    }
    this.wLo.currentIndex = 0;
    dyW();
    com.tencent.mm.sdk.b.a.IvT.d(this.wLw);
    com.tencent.mm.sdk.b.a.IvT.c(this.wLw);
    yH(this.wLo.dzh());
    if (this.wLv != null)
    {
      this.wLv.ay(300000L, 300000L);
      return;
    }
    ae.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void dyX()
  {
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()) });
    if (this.wLo.wLz.size() > 0)
    {
      Object localObject = this.wLo;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).wLz.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      aq(localArrayList);
    }
  }
  
  public final FailSendMsgNotification dyZ()
  {
    return this.wLp;
  }
  
  public final void dz(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(dB(paramT)), dyY(), Boolean.valueOf(this.wLq) });
    if (!this.wLq)
    {
      if (!this.wLt.contains(Long.valueOf(dB(paramT))))
      {
        if (paramT == null)
        {
          ae.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = dC(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          ae.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        resetStatus();
        b localb = this.wLo;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.wLz.addAll(paramT);
        }
        dzc();
        ae.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.wLo.wLz.size()), dyY() });
        g.yxI.f(11426, new Object[] { Integer.valueOf(getType()) });
        ar.o(new Runnable()
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
      this.wLt.remove(Long.valueOf(dB(paramT)));
      return;
    }
    if ((this.wLo.contains(dB(paramT))) && (!this.wLs.contains(Long.valueOf(dB(paramT))))) {
      this.wLs.add(Long.valueOf(dB(paramT)));
    }
    if (!this.wLo.contains(dB(paramT)))
    {
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.wLo.yK(dB(paramT));
    }
    dyP();
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.wLr.size()), Integer.valueOf(this.wLs.size()) });
    if (this.wLr.size() + this.wLs.size() < this.wLo.wLz.size())
    {
      long l = this.wLo.dzh();
      if (l == -1L)
      {
        ae.e("TAG", "resend error, next msg id is -1");
        return;
      }
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      dzc();
      yH(l);
      return;
    }
    dyQ();
  }
  
  protected final void dzb()
  {
    b.a locala;
    if ((this.wLo == null) || (this.wLo.wLz.size() == 0))
    {
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.MI(getType());
      if (locala == null) {
        ae.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.wLv == null) {
      dyM();
    }
    b localb = locala.wLC;
    ArrayList localArrayList1 = locala.wLE;
    ArrayList localArrayList2 = locala.wLF;
    int i = locala.wLD;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.wLo.clear();
      this.wLo = localb;
      this.wLr.clear();
      this.wLs.clear();
      dyO();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.wLz.size())
    {
      ae.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      dyQ();
      return;
    }
    ae.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.wLo.clear();
    this.wLo = localb;
    this.wLo.currentIndex = i;
    this.wLr.clear();
    this.wLr.addAll(localArrayList1);
    this.wLs.clear();
    this.wLs.addAll(localArrayList2);
    dyP();
  }
  
  protected abstract void dzd();
  
  protected abstract String gQ(int paramInt1, int paramInt2);
  
  protected abstract String gR(int paramInt1, int paramInt2);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  final void yH(final long paramLong)
  {
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26734);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26734);
      }
    }, 200L);
  }
  
  public abstract void yI(long paramLong);
  
  public abstract boolean yJ(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */