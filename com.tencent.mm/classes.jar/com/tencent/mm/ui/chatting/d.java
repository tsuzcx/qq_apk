package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.h.c;
import com.tencent.mm.al.h.d;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.be;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements h.a, h.b, h.c, h.d, aj, com.tencent.mm.modelvoice.c, SensorController.a
{
  private ap JyA;
  private List<bu> Jym;
  public long Jyn;
  private o Jyo;
  be Jyp;
  public o Jyq;
  public boolean Jyr;
  public boolean Jys;
  public boolean Jyt;
  private long Jyu;
  private long Jyv;
  public boolean Jyw;
  private boolean Jyx;
  public com.tencent.mm.sdk.b.c Jyy;
  private ap Jyz;
  public com.tencent.mm.ui.chatting.e.a cWM;
  public Context context;
  private int dfR;
  boolean htg;
  long lastShakeTime;
  public com.tencent.mm.al.h pyq;
  boolean pyr;
  private boolean pyt;
  private bk pyu;
  private SensorController pyv;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, be parambe, String paramString)
  {
    AppMethodBeat.i(34261);
    this.htg = false;
    this.Jyn = -1L;
    this.lastShakeTime = -1L;
    this.Jys = true;
    this.Jyt = false;
    this.Jyu = 0L;
    this.Jyv = 0L;
    this.Jyw = false;
    this.Jyx = false;
    this.Jyy = new com.tencent.mm.sdk.b.c() {};
    this.Jyz = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34256);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ad.i("MicroMsg.AutoPlay", "reset speaker");
          d.a(d.this);
          paramAnonymousMessage = d.this;
          if (!d.this.Jyp.pys) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousMessage.pyr = bool;
            AppMethodBeat.o(34256);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ad.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34256);
        }
      }
    };
    this.JyA = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ad.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.fAI();
          AppMethodBeat.o(34257);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ad.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34257);
        }
      }
    };
    this.pyt = false;
    this.context = parama.JOR.getContext();
    this.cWM = parama;
    this.Jyp = parambe;
    if (this.pyv == null) {
      this.pyv = new SensorController(this.context.getApplicationContext());
    }
    if (this.pyu == null) {
      this.pyu = new bk(this.context.getApplicationContext());
    }
    aVP(paramString);
    com.tencent.mm.sdk.b.a.IbL.c(this.Jyy);
    ba.Nb().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void aR(bu parambu)
  {
    boolean bool2 = true;
    AppMethodBeat.i(193833);
    boolean bool1;
    Object localObject;
    if ((parambu != null) && ((parambu.fph()) || (parambu.frL()) || (parambu.frM()) || (parambu.frN())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      ad.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(parambu.field_msgId) });
      if (!this.pyv.aMy)
      {
        this.pyv.a(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.this.lastShakeTime = bt.HI();
            AppMethodBeat.o(34258);
          }
        };
        if (!this.pyu.aD((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      ba.aBQ();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bt.isNullOrNil(parambu.field_imgPath))) {
        break label178;
      }
      this.Jym.clear();
      t.g(this.context, this.cWM.JOR.getContentView());
      AppMethodBeat.o(193833);
      return;
      bool1 = false;
      break;
    }
    label178:
    ba.aBQ();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.Jyp.pys))
    {
      if (this.Jyo != null) {
        this.Jyo.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.bGx();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.bGD();
      ad.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        t.w(this.cWM.JOR.getActivity(), this.context.getString(2131757074), 2131690357);
      }
    }
    else
    {
      an.aQu("keep_app_silent");
      com.tencent.mm.modelvoice.s.ab(parambu);
      this.pyq.stop(true);
      this.Jyp.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.bGx()) || (com.tencent.mm.plugin.audio.c.a.bGD()))
      {
        ad.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bGx()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bGD()) });
        this.pyr = false;
      }
      localObject = getFullPath(parambu.field_imgPath);
      ad.i("MicroMsg.AutoPlay", "startplay");
      bool1 = com.tencent.mm.modelvoice.s.HY(parambu.field_imgPath);
      if (!bool1) {
        g.yhR.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.pyq.a((String)localObject, this.pyr, true, -1))) {
        break label577;
      }
      localObject = this.pyq;
      if (this.Jym.size() <= 1) {
        break label572;
      }
      bool1 = bool2;
      label447:
      ((com.tencent.mm.al.h)localObject).ct(bool1);
      this.pyq.a(this);
      this.pyq.a(this);
      this.pyq.a(this);
      this.pyq.a(this);
      this.Jyn = parambu.field_msgId;
      this.Jyv = new p(parambu.field_content).time;
      this.Jyu = System.currentTimeMillis();
    }
    for (;;)
    {
      bOo();
      this.Jyt = false;
      AppMethodBeat.o(193833);
      return;
      t.w(this.cWM.JOR.getActivity(), this.context.getString(2131757075), 2131690395);
      break;
      label572:
      bool1 = false;
      break label447;
      label577:
      this.Jyn = -1L;
      fAF();
      Toast.makeText(this.context, this.context.getString(2131757274), 0).show();
    }
  }
  
  private void bOo()
  {
    AppMethodBeat.i(34276);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.this.cWM.bOo();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void fAH()
  {
    AppMethodBeat.i(34270);
    int k = this.Jym.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bu)this.Jym.get(i)).field_msgId != this.Jyn) {
        break label111;
      }
      j = i;
    }
    label111:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.Jym.remove(j);
      }
      ad.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.Jym.size());
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(193834);
    if (this.dfR == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.cd(paramString, false);
      AppMethodBeat.o(193834);
      return paramString;
    }
    paramString = com.tencent.mm.modelvoice.s.getFullPath(paramString);
    AppMethodBeat.o(193834);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.cWM != null)
    {
      boolean bool = this.cWM.JOR.getController().JaQ;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.cWM != null) {
      this.cWM.JOR.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void Y(bu parambu)
  {
    AppMethodBeat.i(34268);
    if ((this.Jys) && (this.Jym.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambu == null) || (!parambu.fph()) || (parambu.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambu.field_talker == null) || (!parambu.field_talker.equals(this.cWM.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!ba.aiU().foreground) || (!this.cWM.cBJ))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (com.tencent.mm.modelvoice.s.aa(parambu))
    {
      ad.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    aQ(parambu);
    if ((!this.htg) && (!this.pyq.isPlaying()) && (bt.jh(this.context))) {
      xO(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void a(int paramInt, bu parambu)
  {
    AppMethodBeat.i(34266);
    if (parambu == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    fAF();
    ba.aBQ();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajl().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4115, Boolean.TRUE);
      fAK();
      this.Jyq = t.a(this.cWM.JOR.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.pyq.isPlaying()) && (parambu.field_msgId == this.Jyn))
    {
      aoV();
      AppMethodBeat.o(34266);
      return;
    }
    aQ(parambu);
    if ((parambu.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Z(parambu))) {
      acI(paramInt + 1);
    }
    xO(true);
    AppMethodBeat.o(34266);
  }
  
  public final void aBx()
  {
    AppMethodBeat.i(34286);
    ad.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.Jyx = false;
    AppMethodBeat.o(34286);
  }
  
  public final void aBy()
  {
    AppMethodBeat.i(34287);
    ad.m("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.Jyx = true;
    aoV();
    fAF();
    try
    {
      if (this.pyv != null) {
        this.pyv.flC();
      }
      if (this.pyu != null) {
        this.pyu.flD();
      }
      AppMethodBeat.o(34287);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34287);
    }
  }
  
  public final void aQ(bu parambu)
  {
    AppMethodBeat.i(34265);
    if (parambu == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.Jym.size() > 0)
      {
        this.Jym.clear();
        t.g(this.context, this.cWM.JOR.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.Jym.size();
    int i = 0;
    while (i < j)
    {
      if (((bu)this.Jym.get(i)).field_msgId == parambu.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.Jyr) || (this.Jym.size() == 0)) {
      this.Jym.add(parambu);
    }
    ad.d("MicroMsg.AutoPlay", "add voice msg :" + this.Jym.size());
    AppMethodBeat.o(34265);
  }
  
  public final void aVP(String paramString)
  {
    AppMethodBeat.i(34262);
    ad.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.Jyt) });
    if ((this.Jyt) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.Jym = new LinkedList();
    this.htg = false;
    this.Jyn = -1L;
    this.pyr = false;
    this.lastShakeTime = -1L;
    this.Jyr = false;
    this.dfR = 0;
    if (w.Aa(paramString))
    {
      this.dfR = 1;
      this.pyq = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.dfR = 0;
    this.pyq = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void acI(int paramInt)
  {
    AppMethodBeat.i(34264);
    for (;;)
    {
      if (this.context == null)
      {
        ad.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(34264);
        return;
      }
      if (this.cWM == null)
      {
        ad.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((k)this.cWM.bh(k.class)).getCount();
      ad.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      bu localbu = ((k)this.cWM.bh(k.class)).ada(paramInt);
      if (localbu == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localbu.fph()) && (localbu.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Z(localbu)) && (!com.tencent.mm.modelvoice.s.aa(localbu))) {
        aQ(localbu);
      }
      paramInt += 1;
    }
  }
  
  public final void aoV()
  {
    AppMethodBeat.i(34275);
    ad.i("MicroMsg.AutoPlay", "stop play");
    an.aQv("keep_app_silent");
    this.pyq.cr(true);
    this.pyq.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void b(int paramInt, bu parambu)
  {
    AppMethodBeat.i(34267);
    if (parambu == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    fAF();
    ba.aBQ();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajl().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4115, Boolean.TRUE);
      fAK();
      this.Jyq = t.a(this.cWM.JOR.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.pyq.isPlaying()) && (parambu.field_msgId == this.Jyn))
    {
      aoV();
      AppMethodBeat.o(34267);
      return;
    }
    aQ(parambu);
    if ((parambu.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.Z(parambu))) {
      acI(paramInt + 1);
    }
    xO(true);
    AppMethodBeat.o(34267);
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    ad.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final void fAF()
  {
    AppMethodBeat.i(34263);
    if (1 == ad.getLogLevel()) {
      ad.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bt.flS() });
    }
    if (this.Jyo != null) {
      this.Jyo.dismiss();
    }
    this.Jym.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void fAG()
  {
    AppMethodBeat.i(34269);
    this.htg = false;
    xO(true);
    AppMethodBeat.o(34269);
  }
  
  public final void fAI()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        ad.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.Jym.size());
        if (this.Jym.size() <= 0)
        {
          this.Jyz.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((bu)this.Jym.get(0)).field_createTime;
        int k = this.Jym.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((bu)this.Jym.get(i)).field_createTime)
          {
            l = ((bu)this.Jym.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          bu localbu = (bu)this.Jym.get(j);
          if (localbu != null) {
            aR(localbu);
          }
          AppMethodBeat.o(34272);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
        AppMethodBeat.o(34272);
        return;
      }
      i += 1;
    }
  }
  
  public final void fAJ()
  {
    AppMethodBeat.i(34273);
    if ((this.pyq != null) && (this.pyq.isPlaying()))
    {
      ad.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.pyr), Boolean.valueOf(this.pyq.isPlaying()) });
      this.pyq.cm(this.pyr);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void fAK()
  {
    AppMethodBeat.i(34285);
    if (this.Jyq != null) {
      this.Jyq.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.pyq.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void kn(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    ad.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.pyt + " tick:" + bt.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.pyv.flC();
      AppMethodBeat.o(34282);
      return;
    }
    ad.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.pyt = false;
    if (this.pyq.PD())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bGD())
    {
      fAK();
      ad.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.Jyp.pys)
    {
      xP(false);
      if (this.Jyn != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.Jyt = paramBoolean;; this.Jyt = true)
      {
        fAJ();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.Jyn != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.Jyt = paramBoolean;
      new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            ad.i("MicroMsg.AutoPlay", "speaker off");
            d.this.xP(false);
            d locald = d.this;
            if (locald.pyq.isPlaying())
            {
              ad.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.pyq.cr(false);
              locald.xO(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            ad.i("MicroMsg.AutoPlay", "speaker true");
            d.this.fAK();
            if (d.this.context != null) {
              d.this.Jyq = t.a(d.this.cWM.JOR.getActivity(), d.this.context.getString(2131759558), 2000L);
            }
            d.this.xP(true);
            d.this.fAJ();
          }
        }
      }, false).az(50L, 50L);
    }
    ad.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.Jyt) });
    AppMethodBeat.o(34282);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    ad.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.pyr), Long.valueOf(this.Jyn), Long.valueOf(this.Jyv) });
    g.yhR.f(15160, new Object[] { Long.valueOf(this.Jyn), Long.valueOf(this.Jyv), Long.valueOf(this.Jyv), Integer.valueOf(0) });
    if (this.context != null)
    {
      ad.i("MicroMsg.AutoPlay", "stop play complete");
      an.aQv("keep_app_silent");
      this.Jyp.releaseWakeLock();
      fAH();
      if (this.Jym.isEmpty())
      {
        this.pyv.flC();
        this.pyu.flD();
      }
      bOo();
      this.Jyn = -1L;
      fAK();
      this.Jyp.releaseWakeLock();
      xO(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    ad.e("MicroMsg.AutoPlay", "voice play error");
    aoV();
    xO(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    ad.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.Jyn), Long.valueOf(this.Jyv), Long.valueOf(bt.Df(this.Jyu)), Boolean.valueOf(this.Jyx), Boolean.valueOf(this.Jyw), bt.flS() });
    g localg;
    long l1;
    long l2;
    long l3;
    if (this.Jyn > 0L)
    {
      localg = g.yhR;
      l1 = this.Jyn;
      l2 = this.Jyv;
      l3 = bt.Df(this.Jyu);
      if (this.Jyx) {
        break label251;
      }
      if (!this.Jyw) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localg.f(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.Jyx = false;
      this.Jyw = false;
      this.Jyp.releaseWakeLock();
      fAH();
      if (this.Jym.isEmpty())
      {
        this.pyv.flC();
        this.pyu.flD();
      }
      bOo();
      this.Jyn = -1L;
      fAK();
      this.Jyt = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    ad.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.pyu != null) {
      this.pyu.flD();
    }
    AppMethodBeat.o(34274);
  }
  
  public final void xO(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    ad.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.Jym.size()), Boolean.valueOf(paramBoolean) });
    if (this.Jym.size() <= 0)
    {
      this.Jyz.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.pyq != null)
    {
      this.pyq.cr(paramBoolean);
      this.pyq.cq(paramBoolean);
    }
    fAI();
    AppMethodBeat.o(34271);
  }
  
  public final void xP(boolean paramBoolean)
  {
    AppMethodBeat.i(193832);
    ad.m("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pyr = paramBoolean;
    AppMethodBeat.o(193832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */