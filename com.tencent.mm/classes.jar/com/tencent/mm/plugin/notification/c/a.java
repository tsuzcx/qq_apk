package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.plugin.notification.d.b.a;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T>
  implements c
{
  protected Context mContext = null;
  protected b piK = null;
  protected FailSendMsgNotification piL = null;
  protected boolean piM = false;
  protected ArrayList<Long> piN = null;
  protected ArrayList<Long> piO = null;
  protected ArrayList<Long> piP = null;
  private ArrayList<ap> piQ = new ArrayList();
  private ap piR = null;
  private com.tencent.mm.sdk.b.c piS = new a.1(this);
  
  public a()
  {
    this.piL.pjE = new a.2(this);
    this.piL.pjF = new a.3(this);
    this.piL.pjG = new a.4(this);
    bXM();
  }
  
  private void aEa()
  {
    this.piK.clear();
    this.piM = false;
    this.piN.clear();
    this.piO.clear();
    bXW();
  }
  
  private void bXM()
  {
    this.piR = new ap(Looper.getMainLooper(), new a.5(this), true);
  }
  
  private void bXN()
  {
    if (this.piR != null)
    {
      this.piR.stopTimer();
      return;
    }
    ab.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
  }
  
  private void bXO()
  {
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[] { Boolean.valueOf(f.aJh()) });
    this.piL.pjI = AS(this.piK.piV.size());
    this.piL.bYs();
    if ((!f.aJh()) && (!this.piL.pjN))
    {
      this.piL.pjH = AS(this.piK.piV.size());
      this.piL.bYr();
      this.piL.bYq();
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
      this.piL.show();
      com.tencent.mm.sdk.b.a.ymk.d(this.piS);
      com.tencent.mm.sdk.b.a.ymk.c(this.piS);
      return;
    }
    if (this.piL.pjN)
    {
      this.piL.bYr();
      this.piL.bYq();
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
      this.piL.Wi(AS(this.piK.piV.size()));
      com.tencent.mm.sdk.b.a.ymk.d(this.piS);
      com.tencent.mm.sdk.b.a.ymk.c(this.piS);
      return;
    }
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[] { Boolean.valueOf(f.aJh()) });
  }
  
  private void bXP()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.piL.pjI = AS(this.piK.piV.size());
      if (this.piO.size() <= 0) {
        this.piL.Wi(eU(this.piK.piV.size(), this.piN.size() + this.piO.size()));
      }
    }
    else
    {
      return;
    }
    this.piL.Wi(ae(this.piK.piV.size(), this.piN.size() + this.piO.size(), this.piO.size()));
  }
  
  private void bXQ()
  {
    this.piM = false;
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()), Integer.valueOf(this.piO.size()), Integer.valueOf(this.piN.size()) });
    bXT();
    if ((this.piO.size() <= 0) || (Build.VERSION.SDK_INT < 16)) {
      com.tencent.mm.plugin.notification.d.b.AU(getType());
    }
    h.qsU.e(11425, new Object[] { Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.piN.size()), Integer.valueOf(this.piO.size()) });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.piL.bYr();
      this.piL.pjI = AS(this.piK.piV.size());
      localObject = this.piL;
      this.piK.piV.size();
      ((FailSendMsgNotification)localObject).Wi(eV(this.piN.size(), this.piO.size()));
      this.piL.bYq();
      if (this.piO.size() > 0)
      {
        this.piL.bYs();
        this.piL.show();
        bYa();
        bYc();
      }
    }
    Object localObject = new ky();
    ((ky)localObject).cBf.type = getType();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    bXN();
    bXW();
    com.tencent.mm.sdk.b.a.ymk.d(this.piS);
    bXR();
  }
  
  private void bXT()
  {
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()), Integer.valueOf(this.piN.size()), Integer.valueOf(this.piO.size()) });
    bXU();
    bXV();
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()), Integer.valueOf(this.piN.size()), Integer.valueOf(this.piO.size()) });
  }
  
  private void bXU()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.piK.piV.size())
    {
      long l = this.piK.get(i);
      if (!kN(l)) {
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
        this.piK.remove(localLong.longValue());
      }
    }
  }
  
  private void bXV()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.piN.iterator();
    Long localLong;
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!kN(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      this.piN.remove(localLong);
    }
    ((ArrayList)localObject1).clear();
    localObject2 = this.piO.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localLong = (Long)((Iterator)localObject2).next();
      if (!kN(localLong.longValue())) {
        ((ArrayList)localObject1).add(localLong);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      this.piO.remove(localObject2);
    }
  }
  
  private void bXW()
  {
    Iterator localIterator = this.piQ.iterator();
    while (localIterator.hasNext()) {
      ((ap)localIterator.next()).stopTimer();
    }
    this.piQ.clear();
    this.piP.clear();
  }
  
  private String bXY()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < this.piK.piV.size())
    {
      long l = this.piK.get(i);
      localStringBuilder.append(l + ", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void bYa()
  {
    this.piK.currentIndex = 0;
    if (this.piN.size() > 0)
    {
      Iterator localIterator = this.piN.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.piK.remove(localLong.longValue());
      }
    }
    this.piN.clear();
    this.piO.clear();
  }
  
  private void bYc()
  {
    b.a locala = new b.a(this.piK, this.piK.currentIndex, this.piN, this.piO);
    com.tencent.mm.plugin.notification.d.b.a(getType(), locala);
  }
  
  protected abstract String AS(int paramInt);
  
  protected abstract void M(ArrayList<Long> paramArrayList);
  
  protected abstract String ae(int paramInt1, int paramInt2, int paramInt3);
  
  protected void bXR() {}
  
  public final void bXS()
  {
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()) });
    this.piM = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      FailSendMsgNotification localFailSendMsgNotification = this.piL;
      localFailSendMsgNotification.pjP = false;
      localFailSendMsgNotification.pjB = com.tencent.mm.bp.a.br(localFailSendMsgNotification.mContext, com.tencent.mm.bp.a.dkN());
      localFailSendMsgNotification.bYp();
      localFailSendMsgNotification.show();
      ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
      localFailSendMsgNotification = this.piL;
      localFailSendMsgNotification.pjB.g(2, true);
      localFailSendMsgNotification.pjO = true;
      localFailSendMsgNotification.show();
      ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
      this.piL.Wi(eU(this.piK.piV.size(), 0));
    }
    this.piK.currentIndex = 0;
    bXW();
    com.tencent.mm.sdk.b.a.ymk.d(this.piS);
    com.tencent.mm.sdk.b.a.ymk.c(this.piS);
    kL(this.piK.bYh());
    if (this.piR != null)
    {
      this.piR.ag(300000L, 300000L);
      return;
    }
    ab.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
  }
  
  public final void bXX()
  {
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()) });
    if (this.piK.piV.size() > 0)
    {
      Object localObject = this.piK;
      ArrayList localArrayList = new ArrayList();
      localObject = ((b)localObject).piV.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject).next()).longValue()));
      }
      M(localArrayList);
    }
  }
  
  public final FailSendMsgNotification bXZ()
  {
    return this.piL;
  }
  
  protected final void bYb()
  {
    b.a locala;
    if ((this.piK == null) || (this.piK.piV.size() == 0))
    {
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
      locala = com.tencent.mm.plugin.notification.d.b.AT(getType());
      if (locala == null) {
        ab.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
      }
    }
    else
    {
      return;
    }
    if (this.piR == null) {
      bXM();
    }
    b localb = locala.piX;
    ArrayList localArrayList1 = locala.piZ;
    ArrayList localArrayList2 = locala.pja;
    int i = locala.piY;
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0) && (i == 0))
    {
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
      this.piK.clear();
      this.piK = localb;
      this.piN.clear();
      this.piO.clear();
      bXO();
      return;
    }
    if (localArrayList1.size() + localArrayList2.size() >= localb.piV.size())
    {
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
      bXQ();
      return;
    }
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
    this.piK.clear();
    this.piK = localb;
    this.piK.currentIndex = i;
    this.piN.clear();
    this.piN.addAll(localArrayList1);
    this.piO.clear();
    this.piO.addAll(localArrayList2);
    bXP();
  }
  
  protected abstract void bYd();
  
  public final void bZ(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[] { Long.valueOf(cc(paramT)), bXY(), Boolean.valueOf(this.piM) });
    if (!this.piM)
    {
      if (!this.piP.contains(Long.valueOf(cc(paramT))))
      {
        if (paramT == null)
        {
          ab.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
          return;
        }
        paramT = cd(paramT);
        if ((paramT == null) || (paramT.size() <= 0))
        {
          ab.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
          return;
        }
        aEa();
        b localb = this.piK;
        if ((paramT != null) && (paramT.size() > 0)) {
          localb.piV.addAll(paramT);
        }
        bYc();
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[] { Integer.valueOf(this.piK.piV.size()), bXY() });
        h.qsU.e(11426, new Object[] { Integer.valueOf(getType()) });
        al.p(new a.6(this), 1000L);
        return;
      }
      this.piP.remove(Long.valueOf(cc(paramT)));
      return;
    }
    if ((this.piK.contains(cc(paramT))) && (!this.piO.contains(Long.valueOf(cc(paramT))))) {
      this.piO.add(Long.valueOf(cc(paramT)));
    }
    if (!this.piK.contains(cc(paramT)))
    {
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
      this.piK.kO(cc(paramT));
    }
    bXP();
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.piN.size()), Integer.valueOf(this.piO.size()) });
    if (this.piN.size() + this.piO.size() < this.piK.piV.size())
    {
      long l = this.piK.bYh();
      if (l == -1L)
      {
        ab.e("TAG", "resend error, next msg id is -1");
        return;
      }
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
      bYc();
      kL(l);
      return;
    }
    bXQ();
  }
  
  public final void ca(T paramT)
  {
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[] { Long.valueOf(cc(paramT)), bXY() });
    long l;
    if (this.piK.contains(cc(paramT)))
    {
      l = cc(paramT);
      if ((this.piP.contains(Long.valueOf(l))) && (this.piO.contains(Long.valueOf(l))))
      {
        ab.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
        this.piP.remove(Long.valueOf(l));
        this.piO.remove(Long.valueOf(l));
      }
      if (!this.piM) {
        break label260;
      }
      this.piN.add(Long.valueOf(l));
      bXP();
      ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[] { Integer.valueOf(this.piN.size()), Integer.valueOf(this.piO.size()) });
      if (this.piN.size() + this.piO.size() >= this.piK.piV.size()) {
        break label255;
      }
      l = this.piK.bYh();
      if (l == -1L) {
        ab.e("TAG", "resend error, next msg id is -1");
      }
    }
    else
    {
      return;
    }
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[] { Long.valueOf(l) });
    bYc();
    kL(l);
    return;
    label255:
    bXQ();
    return;
    label260:
    this.piK.remove(cc(paramT));
    if (this.piK.piV.size() == 0)
    {
      this.piL.dismiss();
      aEa();
      com.tencent.mm.plugin.notification.d.b.AU(getType());
      return;
    }
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
    this.piL.Wi(AS(this.piK.piV.size()));
  }
  
  protected abstract long cc(T paramT);
  
  protected abstract ArrayList<Long> cd(T paramT);
  
  protected abstract String eU(int paramInt1, int paramInt2);
  
  protected abstract String eV(int paramInt1, int paramInt2);
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  protected abstract int getType();
  
  final void kL(long paramLong)
  {
    al.p(new a.7(this, paramLong), 200L);
  }
  
  public abstract void kM(long paramLong);
  
  public abstract boolean kN(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a
 * JD-Core Version:    0.7.0.1
 */