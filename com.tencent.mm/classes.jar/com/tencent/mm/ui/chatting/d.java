package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.i.c;
import com.tencent.mm.al.i.d;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.ba;
import com.tencent.mm.ui.r;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements i.a, i.b, i.c, i.d, ai, com.tencent.mm.modelvoice.c, SensorController.a
{
  private List<bl> GkG;
  public long GkH;
  private o GkI;
  ba GkJ;
  public o GkK;
  public boolean GkL;
  public boolean GkM;
  public boolean GkN;
  private long GkO;
  private long GkP;
  public boolean GkQ;
  private boolean GkR;
  public com.tencent.mm.sdk.b.c GkS;
  private ap GkT;
  private ap GkU;
  public com.tencent.mm.ui.chatting.d.a cOd;
  private int cXf;
  public Context context;
  boolean gAF;
  long lastShakeTime;
  public com.tencent.mm.al.i org;
  boolean orh;
  private boolean orj;
  private bk ork;
  private SensorController orl;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, ba paramba, String paramString)
  {
    AppMethodBeat.i(34261);
    this.gAF = false;
    this.GkH = -1L;
    this.lastShakeTime = -1L;
    this.GkM = true;
    this.GkN = false;
    this.GkO = 0L;
    this.GkP = 0L;
    this.GkQ = false;
    this.GkR = false;
    this.GkS = new com.tencent.mm.sdk.b.c() {};
    this.GkT = new ap(Looper.getMainLooper())
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
          if (!d.this.GkJ.ori) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousMessage.orh = bool;
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
    this.GkU = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ad.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.eUG();
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
    this.orj = false;
    this.context = parama.GzJ.getContext();
    this.cOd = parama;
    this.GkJ = paramba;
    if (this.orl == null) {
      this.orl = new SensorController(this.context.getApplicationContext());
    }
    if (this.ork == null) {
      this.ork = new bk(this.context.getApplicationContext());
    }
    aKw(paramString);
    com.tencent.mm.sdk.b.a.ESL.c(this.GkS);
    az.Lv().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void aM(bl parambl)
  {
    boolean bool2 = true;
    AppMethodBeat.i(191472);
    boolean bool1;
    Object localObject;
    if ((parambl != null) && ((parambl.eJN()) || (parambl.eMc()) || (parambl.eMd()) || (parambl.eMe())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      ad.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(parambl.field_msgId) });
      if (!this.orl.aJR)
      {
        this.orl.a(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.this.lastShakeTime = bt.GC();
            AppMethodBeat.o(34258);
          }
        };
        if (!this.ork.aC((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      az.arV();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bt.isNullOrNil(parambl.field_imgPath))) {
        break label178;
      }
      this.GkG.clear();
      t.g(this.context, this.cOd.GzJ.getContentView());
      AppMethodBeat.o(191472);
      return;
      bool1 = false;
      break;
    }
    label178:
    az.arV();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.GkJ.ori))
    {
      if (this.GkI != null) {
        this.GkI.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.bvw();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.bvC();
      ad.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        this.GkI = com.tencent.mm.ui.widget.a.h.c(this.cOd.GzJ.getActivity(), 2131690357, this.cOd.GzJ.getMMResources().getColor(2131099699), this.context.getString(2131757074));
      }
    }
    else
    {
      an.aFx("keep_app_silent");
      s.Y(parambl);
      this.org.stop(true);
      this.GkJ.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.bvw()) || (com.tencent.mm.plugin.audio.c.a.bvC()))
      {
        ad.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bvw()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bvC()) });
        this.orh = false;
      }
      localObject = getFullPath(parambl.field_imgPath);
      ad.i("MicroMsg.AutoPlay", "startplay");
      bool1 = s.AE(parambl.field_imgPath);
      if (!bool1) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.org.a((String)localObject, this.orh, true, -1))) {
        break label617;
      }
      localObject = this.org;
      if (this.GkG.size() <= 1) {
        break label612;
      }
      bool1 = bool2;
      label467:
      ((com.tencent.mm.al.i)localObject).cq(bool1);
      this.org.a(this);
      this.org.a(this);
      this.org.a(this);
      this.org.a(this);
      this.GkH = parambl.field_msgId;
      this.GkP = new p(parambl.field_content).time;
      this.GkO = System.currentTimeMillis();
    }
    for (;;)
    {
      bCM();
      this.GkN = false;
      AppMethodBeat.o(191472);
      return;
      this.GkI = com.tencent.mm.ui.widget.a.h.c(this.cOd.GzJ.getActivity(), 2131690395, this.cOd.GzJ.getMMResources().getColor(2131099699), this.context.getString(2131757075));
      break;
      label612:
      bool1 = false;
      break label467;
      label617:
      this.GkH = -1L;
      eUD();
      Toast.makeText(this.context, this.context.getString(2131757274), 0).show();
    }
  }
  
  private void bCM()
  {
    AppMethodBeat.i(34276);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.this.cOd.bCM();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void eUF()
  {
    AppMethodBeat.i(34270);
    int k = this.GkG.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bl)this.GkG.get(i)).field_msgId != this.GkH) {
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
        this.GkG.remove(j);
      }
      ad.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.GkG.size());
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(191473);
    if (this.cXf == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.bP(paramString, false);
      AppMethodBeat.o(191473);
      return paramString;
    }
    paramString = s.getFullPath(paramString);
    AppMethodBeat.o(191473);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.cOd != null)
    {
      boolean bool = this.cOd.GzJ.getController().FNz;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.cOd != null) {
      this.cOd.GzJ.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void V(bl parambl)
  {
    AppMethodBeat.i(34268);
    if ((this.GkM) && (this.GkG.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambl == null) || (!parambl.eJN()) || (parambl.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambl.field_talker == null) || (!parambl.field_talker.equals(this.cOd.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!az.aeS().foreground) || (!this.cOd.ctF))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (s.X(parambl))
    {
      ad.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    aL(parambl);
    if ((!this.gAF) && (!this.org.isPlaying()) && (bt.iM(this.context))) {
      vZ(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void Yn(int paramInt)
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
      if (this.cOd == null)
      {
        ad.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
      ad.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      bl localbl = ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).YE(paramInt);
      if (localbl == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localbl.eJN()) && (localbl.field_isSend == 0) && (!s.W(localbl)) && (!s.X(localbl))) {
        aL(localbl);
      }
      paramInt += 1;
    }
  }
  
  public final void a(int paramInt, bl parambl)
  {
    AppMethodBeat.i(34266);
    if (parambl == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    eUD();
    az.arV();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.afk().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(4115, Boolean.TRUE);
      eUJ();
      this.GkK = t.a(this.cOd.GzJ.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.org.isPlaying()) && (parambl.field_msgId == this.GkH))
    {
      eUI();
      AppMethodBeat.o(34266);
      return;
    }
    aL(parambl);
    if ((parambl.field_isSend == 0) && (!s.W(parambl))) {
      Yn(paramInt + 1);
    }
    vZ(true);
    AppMethodBeat.o(34266);
  }
  
  public final void aKw(String paramString)
  {
    AppMethodBeat.i(34262);
    ad.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.GkN) });
    if ((this.GkN) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.GkG = new LinkedList();
    this.gAF = false;
    this.GkH = -1L;
    this.orh = false;
    this.lastShakeTime = -1L;
    this.GkL = false;
    this.cXf = 0;
    if (w.ta(paramString))
    {
      this.cXf = 1;
      this.org = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.cXf = 0;
    this.org = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void aL(bl parambl)
  {
    AppMethodBeat.i(34265);
    if (parambl == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.GkG.size() > 0)
      {
        this.GkG.clear();
        t.g(this.context, this.cOd.GzJ.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.GkG.size();
    int i = 0;
    while (i < j)
    {
      if (((bl)this.GkG.get(i)).field_msgId == parambl.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.GkL) || (this.GkG.size() == 0)) {
      this.GkG.add(parambl);
    }
    ad.d("MicroMsg.AutoPlay", "add voice msg :" + this.GkG.size());
    AppMethodBeat.o(34265);
  }
  
  public final void arC()
  {
    AppMethodBeat.i(34286);
    ad.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.GkR = false;
    AppMethodBeat.o(34286);
  }
  
  public final void arD()
  {
    AppMethodBeat.i(34287);
    ad.m("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.GkR = true;
    eUI();
    eUD();
    try
    {
      if (this.orl != null) {
        this.orl.eGx();
      }
      if (this.ork != null) {
        this.ork.eGy();
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
  
  public final void b(int paramInt, bl parambl)
  {
    AppMethodBeat.i(34267);
    if (parambl == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    eUD();
    az.arV();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.afk().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(4115, Boolean.TRUE);
      eUJ();
      this.GkK = t.a(this.cOd.GzJ.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.org.isPlaying()) && (parambl.field_msgId == this.GkH))
    {
      eUI();
      AppMethodBeat.o(34267);
      return;
    }
    aL(parambl);
    if ((parambl.field_isSend == 0) && (!s.W(parambl))) {
      Yn(paramInt + 1);
    }
    vZ(true);
    AppMethodBeat.o(34267);
  }
  
  public final void eUD()
  {
    AppMethodBeat.i(34263);
    if (1 == ad.getLogLevel()) {
      ad.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bt.eGN() });
    }
    if (this.GkI != null) {
      this.GkI.dismiss();
    }
    this.GkG.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void eUE()
  {
    AppMethodBeat.i(34269);
    this.gAF = false;
    vZ(true);
    AppMethodBeat.o(34269);
  }
  
  public final void eUG()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        ad.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.GkG.size());
        if (this.GkG.size() <= 0)
        {
          this.GkT.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((bl)this.GkG.get(0)).field_createTime;
        int k = this.GkG.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((bl)this.GkG.get(i)).field_createTime)
          {
            l = ((bl)this.GkG.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          bl localbl = (bl)this.GkG.get(j);
          if (localbl != null) {
            aM(localbl);
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
  
  public final void eUH()
  {
    AppMethodBeat.i(34273);
    if ((this.org != null) && (this.org.isPlaying()))
    {
      ad.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.orh), Boolean.valueOf(this.org.isPlaying()) });
      this.org.cj(this.orh);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void eUI()
  {
    AppMethodBeat.i(34275);
    ad.i("MicroMsg.AutoPlay", "stop play");
    an.aFy("keep_app_silent");
    this.org.co(true);
    this.org.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void eUJ()
  {
    AppMethodBeat.i(34285);
    if (this.GkK != null) {
      this.GkK.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    ad.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.org.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void jz(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    ad.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.orj + " tick:" + bt.aS(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.orl.eGx();
      AppMethodBeat.o(34282);
      return;
    }
    ad.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.orj = false;
    if (this.org.NY())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bvC())
    {
      eUJ();
      ad.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.GkJ.ori)
    {
      wa(false);
      if (this.GkH != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.GkN = paramBoolean;; this.GkN = true)
      {
        eUH();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.GkH != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.GkN = paramBoolean;
      new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            ad.i("MicroMsg.AutoPlay", "speaker off");
            d.this.wa(false);
            d locald = d.this;
            if (locald.org.isPlaying())
            {
              ad.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.org.co(false);
              locald.vZ(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            ad.i("MicroMsg.AutoPlay", "speaker true");
            d.this.eUJ();
            if (d.this.context != null) {
              d.this.GkK = t.a(d.this.cOd.GzJ.getActivity(), d.this.context.getString(2131759558), 2000L);
            }
            d.this.wa(true);
            d.this.eUH();
          }
        }
      }, false).av(50L, 50L);
    }
    ad.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.GkN) });
    AppMethodBeat.o(34282);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    ad.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.orh), Long.valueOf(this.GkH), Long.valueOf(this.GkP) });
    com.tencent.mm.plugin.report.service.h.vKh.f(15160, new Object[] { Long.valueOf(this.GkH), Long.valueOf(this.GkP), Long.valueOf(this.GkP), Integer.valueOf(0) });
    if (this.context != null)
    {
      ad.i("MicroMsg.AutoPlay", "stop play complete");
      an.aFy("keep_app_silent");
      this.GkJ.releaseWakeLock();
      eUF();
      if (this.GkG.isEmpty())
      {
        this.orl.eGx();
        this.ork.eGy();
      }
      bCM();
      this.GkH = -1L;
      eUJ();
      this.GkJ.releaseWakeLock();
      vZ(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    ad.e("MicroMsg.AutoPlay", "voice play error");
    eUI();
    vZ(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    ad.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.GkH), Long.valueOf(this.GkP), Long.valueOf(bt.vM(this.GkO)), Boolean.valueOf(this.GkR), Boolean.valueOf(this.GkQ), bt.eGN() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.GkH > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.vKh;
      l1 = this.GkH;
      l2 = this.GkP;
      l3 = bt.vM(this.GkO);
      if (this.GkR) {
        break label251;
      }
      if (!this.GkQ) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localh.f(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.GkR = false;
      this.GkQ = false;
      this.GkJ.releaseWakeLock();
      eUF();
      if (this.GkG.isEmpty())
      {
        this.orl.eGx();
        this.ork.eGy();
      }
      bCM();
      this.GkH = -1L;
      eUJ();
      this.GkN = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    ad.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.ork != null) {
      this.ork.eGy();
    }
    AppMethodBeat.o(34274);
  }
  
  public final void vZ(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    ad.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.GkG.size()), Boolean.valueOf(paramBoolean) });
    if (this.GkG.size() <= 0)
    {
      this.GkT.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.org != null)
    {
      this.org.co(paramBoolean);
      this.org.cn(paramBoolean);
    }
    eUG();
    AppMethodBeat.o(34271);
  }
  
  public final void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(191471);
    ad.m("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.orh = paramBoolean;
    AppMethodBeat.o(191471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */