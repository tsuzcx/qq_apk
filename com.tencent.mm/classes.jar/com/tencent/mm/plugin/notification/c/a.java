package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.x.c;
import com.tencent.mm.h.a.kk;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  public Context mContext = null;
  private ArrayList<am> mIA = new ArrayList();
  private am mIB = null;
  private com.tencent.mm.sdk.b.c mIC = new a.1(this);
  public b mIu = null;
  protected FailSendMsgNotification mIv = null;
  protected boolean mIw = false;
  protected ArrayList<Long> mIx = null;
  protected ArrayList<Long> mIy = null;
  protected ArrayList<Long> mIz = null;
  
  public a()
  {
    this.mIv.mJp = new a.2(this);
    this.mIv.mJq = new a.3(this);
    this.mIv.mJr = new a.4(this);
    bpj();
  }
  
  private void bcB()
  {
    this.mIu.clear();
    this.mIw = false;
    this.mIx.clear();
    this.mIy.clear();
    bpq();
  }
  
  private void bpj()
  {
    this.mIB = new am(Looper.getMainLooper(), new a.5(this), true);
  }
  
  private void bpk()
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.bpI()) });
    this.mIv.mJt = vu(this.mIu.mIG.size());
    this.mIv.bpN();
    if ((!f.bpI()) && (!this.mIv.mJy))
    {
      this.mIv.mJs = vu(this.mIu.mIG.size());
      this.mIv.bpM();
      this.mIv.bpL();
      y.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.mIv.show();
      com.tencent.mm.sdk.b.a.udP.d(this.mIC);
      com.tencent.mm.sdk.b.a.udP.c(this.mIC);
      return;
    }
    if (this.mIv.mJy)
    {
      this.mIv.bpM();
      this.mIv.bpL();
      y.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.mIv.Kj(vu(this.mIu.mIG.size()));
      com.tencent.mm.sdk.b.a.udP.d(this.mIC);
      com.tencent.mm.sdk.b.a.udP.c(this.mIC);
      return;
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.bpI()) });
  }
  
  private void bpl()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mIv.mJt = vu(this.mIu.mIG.size());
      if (this.mIy.size() <= 0) {
        this.mIv.Kj(du(this.mIu.mIG.size(), this.mIx.size() + this.mIy.size()));
      }
    }
    else
    {
      return;
    }
    this.mIv.Kj(T(this.mIu.mIG.size(), this.mIx.size() + this.mIy.size(), this.mIy.size()));
  }
  
  private void bpm()
  {
    this.mIw = false;
    y.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()), Integer.valueOf(this.mIy.size()), Integer.valueOf(this.mIx.size()) });
    y.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()), Integer.valueOf(this.mIx.size()), Integer.valueOf(this.mIy.size()) });
    bpp();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.mIx.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!fp(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.mIx.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.mIy.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!fp(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.mIy.remove(localObject2);
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()), Integer.valueOf(this.mIx.size()), Integer.valueOf(this.mIy.size()) });
    if ((this.mIy.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.vw(getType());
    }
    h.nFQ.f(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.mIx.size()), Integer.valueOf(this.mIy.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mIv.bpM();
      this.mIv.mJt = vu(this.mIu.mIG.size());
      localObject1 = this.mIv;
      this.mIu.mIG.size();
      ((FailSendMsgNotification)localObject1).Kj(dv(this.mIx.size(), this.mIy.size()));
      this.mIv.bpL();
      if (this.mIy.size() > 0)
      {
        this.mIv.bpN();
        this.mIv.show();
        bpu();
        bpw();
      }
    }
    localObject1 = new kk();
    ((kk)localObject1).bTy.type = getType();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    if (this.mIB != null) {
      this.mIB.stopTimer();
    }
    for (;;)
    {
      bpq();
      com.tencent.mm.sdk.b.a.udP.d(this.mIC);
      bpn();
      return;
      y.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
    }
  }
  
  private void bpq()
  {
    Iterator localIterator = this.mIA.iterator();
    while (localIterator.hasNext()) {
      ((am)localIterator.next()).stopTimer();
    }
    this.mIA.clear();
    this.mIz.clear();
  }
  
  private String bps()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.mIu.mIG.size())
    {
      long l = this.mIu.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void bpu()
  {
    this.mIu.currentIndex = 0;
    if (this.mIx.size() > 0)
    {
      Iterator localIterator = this.mIx.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.mIu.remove(localLong.longValue());
      }
    }
    this.mIx.clear();
    this.mIy.clear();
  }
  
  private void bpw()
  {
    b.a locala = new b.a(this.mIu, this.mIu.currentIndex, this.mIx, this.mIy);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  public abstract void K(ArrayList<Long> paramArrayList);
  
  public abstract String T(int paramInt1, int paramInt2, int paramInt3);
  
  public void bpn() {}
  
  public final void bpo()
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()) });
    this.mIw = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.mIv;
      localFailSendMsgNotification.mJA = false;
      localFailSendMsgNotification.mJm = new x.c(localFailSendMsgNotification.mContext, (byte)0);
      localFailSendMsgNotification.bpK();
      localFailSendMsgNotification.show();
      y.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.mIv;
      localFailSendMsgNotification.mJm.l(2, true);
      localFailSendMsgNotification.mJz = true;
      localFailSendMsgNotification.show();
      y.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.mIv.Kj(du(this.mIu.mIG.size(), 0));
    }
    this.mIu.currentIndex = 0;
    bpq();
    com.tencent.mm.sdk.b.a.udP.d(this.mIC);
    com.tencent.mm.sdk.b.a.udP.c(this.mIC);
    fn(this.mIu.bpB());
    if (this.mIB != null)
    {
      this.mIB.S(300000L, 300000L);
      return;
    }
    y.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  final void bpp()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.mIu.mIG.size())
    {
      long l = this.mIu.get(i);
      if (!fp(l)) {
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
        this.mIu.remove(localLong.longValue());
      }
    }
  }
  
  public final void bpr()
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()) });
    if (this.mIu.mIG.size() > 0)
    {
      Object localObject = this.mIu;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).mIG.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      K(localArrayList);
    }
  }
  
  public final FailSendMsgNotification bpt()
  {
    return this.mIv;
  }
  
  protected final void bpv()
  {
    b.a locala;
    if ((this.mIu == null) || (this.mIu.mIG.size() == 0))
    {
      y.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.vv(getType());
      if (locala == null) {
        y.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.mIB == null) {
      bpj();
    }
    b localb = locala.mII;
    ArrayList localArrayList1 = locala.mIK;
    ArrayList localArrayList2 = locala.mIL;
    int i = locala.mIJ;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      y.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.mIu.clear();
      this.mIu = localb;
      this.mIx.clear();
      this.mIy.clear();
      bpk();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.mIG.size())
    {
      y.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      bpm();
      return;
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.mIu.clear();
    this.mIu = localb;
    this.mIu.currentIndex = i;
    this.mIx.clear();
    this.mIx.addAll(localArrayList1);
    this.mIy.clear();
    this.mIy.addAll(localArrayList2);
    bpl();
  }
  
  public abstract void bpx();
  
  public final void bv(T paramT)
  {
    if (paramT == null) {
      return;
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(bx(paramT)), bps(), Boolean.valueOf(this.mIw) });
    if (!this.mIw)
    {
      if (!this.mIz.contains(Long.valueOf(bx(paramT))))
      {
        if (paramT == null)
        {
          y.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = by(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          y.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        bcB();
        b localb = this.mIu;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.mIG.addAll(paramT);
        }
        bpw();
        y.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.mIu.mIG.size()), bps() });
        h.nFQ.f(11426, new Object[] { Integer.valueOf(getType()) });
        ai.l(new a.6(this), 1000L);
        return;
      }
      this.mIz.remove(Long.valueOf(bx(paramT)));
      return;
    }
    if ((this.mIu.contains(bx(paramT))) && (!this.mIy.contains(Long.valueOf(bx(paramT))))) {
      this.mIy.add(Long.valueOf(bx(paramT)));
    }
    if (!this.mIu.contains(bx(paramT)))
    {
      y.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.mIu.fq(bx(paramT));
    }
    bpl();
    y.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.mIx.size()), Integer.valueOf(this.mIy.size()) });
    if (this.mIx.size() + this.mIy.size() < this.mIu.mIG.size())
    {
      long l = this.mIu.bpB();
      if (l == -1L)
      {
        y.e("TAG", "resend error, next msg id is -1");
        return;
      }
      y.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      bpw();
      fn(l);
      return;
    }
    bpm();
  }
  
  public final void bw(T paramT)
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(bx(paramT)), bps() });
    long l;
    if (this.mIu.contains(bx(paramT)))
    {
      l = bx(paramT);
      if ((this.mIz.contains(Long.valueOf(l))) && (this.mIy.contains(Long.valueOf(l))))
      {
        y.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.mIz.remove(Long.valueOf(l));
        this.mIy.remove(Long.valueOf(l));
      }
      if (!this.mIw) {
        break label260;
      }
      this.mIx.add(Long.valueOf(l));
      bpl();
      y.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.mIx.size()), Integer.valueOf(this.mIy.size()) });
      if (this.mIx.size() + this.mIy.size() >= this.mIu.mIG.size()) {
        break label255;
      }
      l = this.mIu.bpB();
      if (l == -1L) {
        y.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    bpw();
    fn(l);
    return;
    label255:
    bpm();
    return;
    label260:
    this.mIu.remove(bx(paramT));
    if (this.mIu.mIG.size() == 0)
    {
      this.mIv.dismiss();
      bcB();
      com.tencent.mm.plugin.notification.d.b.vw(getType());
      return;
    }
    y.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.mIv.Kj(vu(this.mIu.mIG.size()));
  }
  
  public abstract long bx(T paramT);
  
  public abstract ArrayList<Long> by(T paramT);
  
  public abstract String du(int paramInt1, int paramInt2);
  
  public abstract String dv(int paramInt1, int paramInt2);
  
  final void fn(long paramLong)
  {
    ai.l(new a.7(this, paramLong), 200L);
  }
  
  public abstract void fo(long paramLong);
  
  public abstract boolean fp(long paramLong);
  
  public abstract int getType();
  
  public abstract String vu(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */