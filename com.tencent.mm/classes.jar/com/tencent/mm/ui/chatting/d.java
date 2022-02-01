package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.bf;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements h.a, h.b, h.c, h.d, ak, com.tencent.mm.modelvoice.c, SensorController.a
{
  private List<bv> JTc;
  public long JTd;
  private o JTe;
  bf JTf;
  public o JTg;
  public boolean JTh;
  public boolean JTi;
  public boolean JTj;
  private long JTk;
  private long JTl;
  public boolean JTm;
  private boolean JTn;
  public com.tencent.mm.sdk.b.c JTo;
  private aq JTp;
  private aq JTq;
  public com.tencent.mm.ui.chatting.e.a cXJ;
  public Context context;
  private int dgT;
  boolean hvU;
  long lastShakeTime;
  public com.tencent.mm.ak.h pEU;
  boolean pEV;
  private boolean pEX;
  private bl pEY;
  private SensorController pEZ;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, bf parambf, String paramString)
  {
    AppMethodBeat.i(34261);
    this.hvU = false;
    this.JTd = -1L;
    this.lastShakeTime = -1L;
    this.JTi = true;
    this.JTj = false;
    this.JTk = 0L;
    this.JTl = 0L;
    this.JTm = false;
    this.JTn = false;
    this.JTo = new com.tencent.mm.sdk.b.c() {};
    this.JTp = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34256);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ae.i("MicroMsg.AutoPlay", "reset speaker");
          d.a(d.this);
          paramAnonymousMessage = d.this;
          if (!d.this.JTf.pEW) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousMessage.pEV = bool;
            AppMethodBeat.o(34256);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ae.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34256);
        }
      }
    };
    this.JTq = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ae.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.fEK();
          AppMethodBeat.o(34257);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ae.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34257);
        }
      }
    };
    this.pEX = false;
    this.context = parama.Kkd.getContext();
    this.cXJ = parama;
    this.JTf = parambf;
    if (this.pEZ == null) {
      this.pEZ = new SensorController(this.context.getApplicationContext());
    }
    if (this.pEY == null) {
      this.pEY = new bl(this.context.getApplicationContext());
    }
    aXq(paramString);
    com.tencent.mm.sdk.b.a.IvT.c(this.JTo);
    bc.MW().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void aQ(bv parambv)
  {
    boolean bool2 = true;
    AppMethodBeat.i(187129);
    boolean bool1;
    Object localObject;
    if ((parambv != null) && ((parambv.ftf()) || (parambv.fvL()) || (parambv.fvM()) || (parambv.fvN())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      ae.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(parambv.field_msgId) });
      if (!this.pEZ.aMy)
      {
        this.pEZ.a(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.this.lastShakeTime = bu.HQ();
            AppMethodBeat.o(34258);
          }
        };
        if (!this.pEY.aB((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      bc.aCg();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bu.isNullOrNil(parambv.field_imgPath))) {
        break label178;
      }
      this.JTc.clear();
      t.g(this.context, this.cXJ.Kkd.getContentView());
      AppMethodBeat.o(187129);
      return;
      bool1 = false;
      break;
    }
    label178:
    bc.aCg();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.JTf.pEW))
    {
      if (this.JTe != null) {
        this.JTe.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.bHt();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.bHz();
      ae.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        t.v(this.cXJ.Kkd.getActivity(), this.context.getString(2131757074), 2131690357);
      }
    }
    else
    {
      ao.aRR("keep_app_silent");
      com.tencent.mm.modelvoice.s.aa(parambv);
      this.pEU.stop(true);
      this.JTf.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.bHt()) || (com.tencent.mm.plugin.audio.c.a.bHz()))
      {
        ae.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bHt()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bHz()) });
        this.pEV = false;
      }
      localObject = getFullPath(parambv.field_imgPath);
      ae.i("MicroMsg.AutoPlay", "startplay");
      bool1 = com.tencent.mm.modelvoice.s.IA(parambv.field_imgPath);
      if (!bool1) {
        g.yxI.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.pEU.a((String)localObject, this.pEV, true, -1))) {
        break label577;
      }
      localObject = this.pEU;
      if (this.JTc.size() <= 1) {
        break label572;
      }
      bool1 = bool2;
      label447:
      ((com.tencent.mm.ak.h)localObject).ct(bool1);
      this.pEU.a(this);
      this.pEU.a(this);
      this.pEU.a(this);
      this.pEU.a(this);
      this.JTd = parambv.field_msgId;
      this.JTl = new p(parambv.field_content).time;
      this.JTk = System.currentTimeMillis();
    }
    for (;;)
    {
      bPl();
      this.JTj = false;
      AppMethodBeat.o(187129);
      return;
      t.v(this.cXJ.Kkd.getActivity(), this.context.getString(2131757075), 2131690395);
      break;
      label572:
      bool1 = false;
      break label447;
      label577:
      this.JTd = -1L;
      fEH();
      Toast.makeText(this.context, this.context.getString(2131757274), 0).show();
    }
  }
  
  private void bPl()
  {
    AppMethodBeat.i(34276);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.this.cXJ.bPl();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void fEJ()
  {
    AppMethodBeat.i(34270);
    int k = this.JTc.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bv)this.JTc.get(i)).field_msgId != this.JTd) {
        break label139;
      }
      j = i;
    }
    label139:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.JTc.remove(j);
      }
      ae.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.JTc.size());
      if (this.JTc.size() == 0) {
        com.tencent.mm.sdk.b.a.IvT.a(new ya(), Looper.getMainLooper());
      }
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(187130);
    if (this.dgT == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.ch(paramString, false);
      AppMethodBeat.o(187130);
      return paramString;
    }
    paramString = com.tencent.mm.modelvoice.s.getFullPath(paramString);
    AppMethodBeat.o(187130);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.cXJ != null)
    {
      boolean bool = this.cXJ.Kkd.getController().Jvy;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.cXJ != null) {
      this.cXJ.Kkd.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void X(bv parambv)
  {
    AppMethodBeat.i(34268);
    if ((this.JTi) && (this.JTc.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambv == null) || (!parambv.ftf()) || (parambv.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambv.field_talker == null) || (!parambv.field_talker.equals(this.cXJ.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!bc.ajj().foreground) || (!this.cXJ.cCq))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (com.tencent.mm.modelvoice.s.Z(parambv))
    {
      ae.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    aP(parambv);
    if ((!this.hvU) && (!this.pEU.isPlaying()) && (bu.jn(this.context))) {
      xV(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void a(int paramInt, bv parambv)
  {
    AppMethodBeat.i(34266);
    if (parambv == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    fEH();
    bc.aCg();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajA().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(4115, Boolean.TRUE);
      fEM();
      this.JTg = t.a(this.cXJ.Kkd.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.pEU.isPlaying()) && (parambv.field_msgId == this.JTd))
    {
      apj();
      AppMethodBeat.o(34266);
      return;
    }
    aP(parambv);
    if ((parambv.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Y(parambv))) {
      adq(paramInt + 1);
    }
    xV(true);
    AppMethodBeat.o(34266);
  }
  
  public final void aBN()
  {
    AppMethodBeat.i(34286);
    ae.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.JTn = false;
    AppMethodBeat.o(34286);
  }
  
  public final void aBO()
  {
    AppMethodBeat.i(34287);
    ae.m("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.JTn = true;
    apj();
    fEH();
    try
    {
      if (this.pEZ != null) {
        this.pEZ.fpx();
      }
      if (this.pEY != null) {
        this.pEY.fpy();
      }
      AppMethodBeat.o(34287);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34287);
    }
  }
  
  public final void aP(bv parambv)
  {
    AppMethodBeat.i(34265);
    if (parambv == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.JTc.size() > 0)
      {
        this.JTc.clear();
        t.g(this.context, this.cXJ.Kkd.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.JTc.size();
    int i = 0;
    while (i < j)
    {
      if (((bv)this.JTc.get(i)).field_msgId == parambv.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.JTh) || (this.JTc.size() == 0)) {
      this.JTc.add(parambv);
    }
    ae.d("MicroMsg.AutoPlay", "add voice msg :" + this.JTc.size());
    AppMethodBeat.o(34265);
  }
  
  public final void aXq(String paramString)
  {
    AppMethodBeat.i(34262);
    ae.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.JTj) });
    if ((this.JTj) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.JTc = new LinkedList();
    this.hvU = false;
    this.JTd = -1L;
    this.pEV = false;
    this.lastShakeTime = -1L;
    this.JTh = false;
    this.dgT = 0;
    if (x.AK(paramString))
    {
      this.dgT = 1;
      this.pEU = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.dgT = 0;
    this.pEU = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void adq(int paramInt)
  {
    AppMethodBeat.i(34264);
    for (;;)
    {
      if (this.context == null)
      {
        ae.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(34264);
        return;
      }
      if (this.cXJ == null)
      {
        ae.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((k)this.cXJ.bh(k.class)).getCount();
      ae.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      bv localbv = ((k)this.cXJ.bh(k.class)).adI(paramInt);
      if (localbv == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localbv.ftf()) && (localbv.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Y(localbv)) && (!com.tencent.mm.modelvoice.s.Z(localbv))) {
        aP(localbv);
      }
      paramInt += 1;
    }
  }
  
  public final void apj()
  {
    AppMethodBeat.i(34275);
    ae.i("MicroMsg.AutoPlay", "stop play");
    ao.aRS("keep_app_silent");
    this.pEU.cr(true);
    this.pEU.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void b(int paramInt, bv parambv)
  {
    AppMethodBeat.i(34267);
    if (parambv == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    fEH();
    bc.aCg();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajA().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(4115, Boolean.TRUE);
      fEM();
      this.JTg = t.a(this.cXJ.Kkd.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.pEU.isPlaying()) && (parambv.field_msgId == this.JTd))
    {
      apj();
      AppMethodBeat.o(34267);
      return;
    }
    aP(parambv);
    if ((parambv.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Y(parambv))) {
      adq(paramInt + 1);
    }
    xV(true);
    AppMethodBeat.o(34267);
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    ae.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final void fEH()
  {
    AppMethodBeat.i(34263);
    if (1 == ae.getLogLevel()) {
      ae.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bu.fpN() });
    }
    if (this.JTe != null) {
      this.JTe.dismiss();
    }
    this.JTc.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void fEI()
  {
    AppMethodBeat.i(34269);
    this.hvU = false;
    xV(true);
    AppMethodBeat.o(34269);
  }
  
  public final void fEK()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        ae.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.JTc.size());
        if (this.JTc.size() <= 0)
        {
          this.JTp.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((bv)this.JTc.get(0)).field_createTime;
        int k = this.JTc.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((bv)this.JTc.get(i)).field_createTime)
          {
            l = ((bv)this.JTc.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          bv localbv = (bv)this.JTc.get(j);
          if (localbv != null) {
            aQ(localbv);
          }
          AppMethodBeat.o(34272);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
        AppMethodBeat.o(34272);
        return;
      }
      i += 1;
    }
  }
  
  public final void fEL()
  {
    AppMethodBeat.i(34273);
    if ((this.pEU != null) && (this.pEU.isPlaying()))
    {
      ae.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.pEV), Boolean.valueOf(this.pEU.isPlaying()) });
      this.pEU.cm(this.pEV);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void fEM()
  {
    AppMethodBeat.i(34285);
    if (this.JTg != null) {
      this.JTg.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.pEU.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void km(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    ae.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.pEX + " tick:" + bu.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.pEZ.fpx();
      AppMethodBeat.o(34282);
      return;
    }
    ae.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.pEX = false;
    if (this.pEU.PC())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bHz())
    {
      fEM();
      ae.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.JTf.pEW)
    {
      xW(false);
      if (this.JTd != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.JTj = paramBoolean;; this.JTj = true)
      {
        fEL();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.JTd != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.JTj = paramBoolean;
      new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            ae.i("MicroMsg.AutoPlay", "speaker off");
            d.this.xW(false);
            d locald = d.this;
            if (locald.pEU.isPlaying())
            {
              ae.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.pEU.cr(false);
              locald.xV(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            ae.i("MicroMsg.AutoPlay", "speaker true");
            d.this.fEM();
            if (d.this.context != null) {
              d.this.JTg = t.a(d.this.cXJ.Kkd.getActivity(), d.this.context.getString(2131759558), 2000L);
            }
            d.this.xW(true);
            d.this.fEL();
          }
        }
      }, false).ay(50L, 50L);
    }
    ae.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.JTj) });
    AppMethodBeat.o(34282);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    ae.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.pEV), Long.valueOf(this.JTd), Long.valueOf(this.JTl) });
    g.yxI.f(15160, new Object[] { Long.valueOf(this.JTd), Long.valueOf(this.JTl), Long.valueOf(this.JTl), Integer.valueOf(0) });
    if (this.context != null)
    {
      ae.i("MicroMsg.AutoPlay", "stop play complete");
      ao.aRS("keep_app_silent");
      this.JTf.releaseWakeLock();
      fEJ();
      if (this.JTc.isEmpty())
      {
        this.pEZ.fpx();
        this.pEY.fpy();
      }
      bPl();
      this.JTd = -1L;
      fEM();
      this.JTf.releaseWakeLock();
      xV(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    ae.e("MicroMsg.AutoPlay", "voice play error");
    apj();
    xV(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    ae.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.JTd), Long.valueOf(this.JTl), Long.valueOf(bu.DD(this.JTk)), Boolean.valueOf(this.JTn), Boolean.valueOf(this.JTm), bu.fpN() });
    g localg;
    long l1;
    long l2;
    long l3;
    if (this.JTd > 0L)
    {
      localg = g.yxI;
      l1 = this.JTd;
      l2 = this.JTl;
      l3 = bu.DD(this.JTk);
      if (this.JTn) {
        break label251;
      }
      if (!this.JTm) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localg.f(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.JTn = false;
      this.JTm = false;
      this.JTf.releaseWakeLock();
      fEJ();
      if (this.JTc.isEmpty())
      {
        this.pEZ.fpx();
        this.pEY.fpy();
      }
      bPl();
      this.JTd = -1L;
      fEM();
      this.JTj = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    ae.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.pEY != null) {
      this.pEY.fpy();
    }
    AppMethodBeat.o(34274);
  }
  
  public final void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    ae.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.JTc.size()), Boolean.valueOf(paramBoolean) });
    if (this.JTc.size() <= 0)
    {
      this.JTp.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.pEU != null)
    {
      this.pEU.cr(paramBoolean);
      this.pEU.cq(paramBoolean);
    }
    fEK();
    AppMethodBeat.o(34271);
  }
  
  public final void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(187128);
    ae.m("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pEV = paramBoolean;
    AppMethodBeat.o(187128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */