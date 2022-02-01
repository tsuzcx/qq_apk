package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.ak.i.c;
import com.tencent.mm.ak.i.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.ba;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements i.a, i.b, i.c, i.d, ai, com.tencent.mm.modelvoice.c, SensorController.a
{
  public boolean HKA;
  public boolean HKB;
  public boolean HKC;
  private long HKD;
  private long HKE;
  public boolean HKF;
  private boolean HKG;
  public com.tencent.mm.sdk.b.c HKH;
  private ao HKI;
  private ao HKJ;
  private List<bo> HKv;
  public long HKw;
  private o HKx;
  ba HKy;
  public o HKz;
  public com.tencent.mm.ui.chatting.d.a cLy;
  private int cUB;
  public Context context;
  boolean hba;
  long lastShakeTime;
  public com.tencent.mm.ak.i oUG;
  boolean oUH;
  private boolean oUJ;
  private bj oUK;
  private SensorController oUL;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, ba paramba, String paramString)
  {
    AppMethodBeat.i(34261);
    this.hba = false;
    this.HKw = -1L;
    this.lastShakeTime = -1L;
    this.HKB = true;
    this.HKC = false;
    this.HKD = 0L;
    this.HKE = 0L;
    this.HKF = false;
    this.HKG = false;
    this.HKH = new com.tencent.mm.sdk.b.c() {};
    this.HKI = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34256);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ac.i("MicroMsg.AutoPlay", "reset speaker");
          d.a(d.this);
          paramAnonymousMessage = d.this;
          if (!d.this.HKy.oUI) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousMessage.oUH = bool;
            AppMethodBeat.o(34256);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ac.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34256);
        }
      }
    };
    this.HKJ = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          ac.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.fkt();
          AppMethodBeat.o(34257);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ac.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34257);
        }
      }
    };
    this.oUJ = false;
    this.context = parama.HZF.getContext();
    this.cLy = parama;
    this.HKy = paramba;
    if (this.oUL == null) {
      this.oUL = new SensorController(this.context.getApplicationContext());
    }
    if (this.oUK == null) {
      this.oUK = new bj(this.context.getApplicationContext());
    }
    aPZ(paramString);
    com.tencent.mm.sdk.b.a.GpY.c(this.HKH);
    az.Lt().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void aO(bo parambo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(196414);
    boolean bool1;
    Object localObject;
    if ((parambo != null) && ((parambo.eZl()) || (parambo.fbH()) || (parambo.fbI()) || (parambo.fbJ())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      ac.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(parambo.field_msgId) });
      if (!this.oUL.aKH)
      {
        this.oUL.a(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.this.lastShakeTime = bs.Gn();
            AppMethodBeat.o(34258);
          }
        };
        if (!this.oUK.aE((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      az.ayM();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bs.isNullOrNil(parambo.field_imgPath))) {
        break label178;
      }
      this.HKv.clear();
      t.g(this.context, this.cLy.HZF.getContentView());
      AppMethodBeat.o(196414);
      return;
      bool1 = false;
      break;
    }
    label178:
    az.ayM();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.HKy.oUI))
    {
      if (this.HKx != null) {
        this.HKx.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.bCs();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.bCy();
      ac.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        t.w(this.cLy.HZF.getActivity(), this.context.getString(2131757074), 2131690357);
      }
    }
    else
    {
      am.aKO("keep_app_silent");
      com.tencent.mm.modelvoice.s.Y(parambo);
      this.oUG.stop(true);
      this.HKy.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.bCs()) || (com.tencent.mm.plugin.audio.c.a.bCy()))
      {
        ac.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bCs()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bCy()) });
        this.oUH = false;
      }
      localObject = getFullPath(parambo.field_imgPath);
      ac.i("MicroMsg.AutoPlay", "startplay");
      bool1 = com.tencent.mm.modelvoice.s.EJ(parambo.field_imgPath);
      if (!bool1) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.oUG.a((String)localObject, this.oUH, true, -1))) {
        break label577;
      }
      localObject = this.oUG;
      if (this.HKv.size() <= 1) {
        break label572;
      }
      bool1 = bool2;
      label447:
      ((com.tencent.mm.ak.i)localObject).cr(bool1);
      this.oUG.a(this);
      this.oUG.a(this);
      this.oUG.a(this);
      this.oUG.a(this);
      this.HKw = parambo.field_msgId;
      this.HKE = new p(parambo.field_content).time;
      this.HKD = System.currentTimeMillis();
    }
    for (;;)
    {
      bJU();
      this.HKC = false;
      AppMethodBeat.o(196414);
      return;
      t.w(this.cLy.HZF.getActivity(), this.context.getString(2131757075), 2131690395);
      break;
      label572:
      bool1 = false;
      break label447;
      label577:
      this.HKw = -1L;
      fkq();
      Toast.makeText(this.context, this.context.getString(2131757274), 0).show();
    }
  }
  
  private void bJU()
  {
    AppMethodBeat.i(34276);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.this.cLy.bJU();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void fks()
  {
    AppMethodBeat.i(34270);
    int k = this.HKv.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bo)this.HKv.get(i)).field_msgId != this.HKw) {
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
        this.HKv.remove(j);
      }
      ac.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.HKv.size());
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(196415);
    if (this.cUB == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.bW(paramString, false);
      AppMethodBeat.o(196415);
      return paramString;
    }
    paramString = com.tencent.mm.modelvoice.s.getFullPath(paramString);
    AppMethodBeat.o(196415);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.cLy != null)
    {
      boolean bool = this.cLy.HZF.getController().Hnk;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.cLy != null) {
      this.cLy.HZF.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void V(bo parambo)
  {
    AppMethodBeat.i(34268);
    if ((this.HKB) && (this.HKv.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambo == null) || (!parambo.eZl()) || (parambo.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((parambo.field_talker == null) || (!parambo.field_talker.equals(this.cLy.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!az.agi().foreground) || (!this.cLy.cqM))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (com.tencent.mm.modelvoice.s.X(parambo))
    {
      ac.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    aN(parambo);
    if ((!this.hba) && (!this.oUG.isPlaying()) && (bs.iX(this.context))) {
      xd(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void a(int paramInt, bo parambo)
  {
    AppMethodBeat.i(34266);
    if (parambo == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    fkq();
    az.ayM();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.agA().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(4115, Boolean.TRUE);
      fkv();
      this.HKz = t.a(this.cLy.HZF.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.oUG.isPlaying()) && (parambo.field_msgId == this.HKw))
    {
      ami();
      AppMethodBeat.o(34266);
      return;
    }
    aN(parambo);
    if ((parambo.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.W(parambo))) {
      aay(paramInt + 1);
    }
    xd(true);
    AppMethodBeat.o(34266);
  }
  
  public final void aN(bo parambo)
  {
    AppMethodBeat.i(34265);
    if (parambo == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.HKv.size() > 0)
      {
        this.HKv.clear();
        t.g(this.context, this.cLy.HZF.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.HKv.size();
    int i = 0;
    while (i < j)
    {
      if (((bo)this.HKv.get(i)).field_msgId == parambo.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.HKA) || (this.HKv.size() == 0)) {
      this.HKv.add(parambo);
    }
    ac.d("MicroMsg.AutoPlay", "add voice msg :" + this.HKv.size());
    AppMethodBeat.o(34265);
  }
  
  public final void aPZ(String paramString)
  {
    AppMethodBeat.i(34262);
    ac.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.HKC) });
    if ((this.HKC) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.HKv = new LinkedList();
    this.hba = false;
    this.HKw = -1L;
    this.oUH = false;
    this.lastShakeTime = -1L;
    this.HKA = false;
    this.cUB = 0;
    if (w.xd(paramString))
    {
      this.cUB = 1;
      this.oUG = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.cUB = 0;
    this.oUG = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void aay(int paramInt)
  {
    AppMethodBeat.i(34264);
    for (;;)
    {
      if (this.context == null)
      {
        ac.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(34264);
        return;
      }
      if (this.cLy == null)
      {
        ac.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
      ac.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      bo localbo = ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).aaP(paramInt);
      if (localbo == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localbo.eZl()) && (localbo.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.W(localbo)) && (!com.tencent.mm.modelvoice.s.X(localbo))) {
        aN(localbo);
      }
      paramInt += 1;
    }
  }
  
  public final void ami()
  {
    AppMethodBeat.i(34275);
    ac.i("MicroMsg.AutoPlay", "stop play");
    am.aKP("keep_app_silent");
    this.oUG.cq(true);
    this.oUG.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void ayt()
  {
    AppMethodBeat.i(34286);
    ac.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.HKG = false;
    AppMethodBeat.o(34286);
  }
  
  public final void ayu()
  {
    AppMethodBeat.i(34287);
    ac.m("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.HKG = true;
    ami();
    fkq();
    try
    {
      if (this.oUL != null) {
        this.oUL.eVS();
      }
      if (this.oUK != null) {
        this.oUK.eVT();
      }
      AppMethodBeat.o(34287);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34287);
    }
  }
  
  public final void b(int paramInt, bo parambo)
  {
    AppMethodBeat.i(34267);
    if (parambo == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    fkq();
    az.ayM();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.agA().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(4115, Boolean.TRUE);
      fkv();
      this.HKz = t.a(this.cLy.HZF.getActivity(), this.context.getString(2131757255), 4000L);
    }
    if ((this.oUG.isPlaying()) && (parambo.field_msgId == this.HKw))
    {
      ami();
      AppMethodBeat.o(34267);
      return;
    }
    aN(parambo);
    if ((parambo.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.W(parambo))) {
      aay(paramInt + 1);
    }
    xd(true);
    AppMethodBeat.o(34267);
  }
  
  public final void eA(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    ac.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final void fkq()
  {
    AppMethodBeat.i(34263);
    if (1 == ac.getLogLevel()) {
      ac.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bs.eWi() });
    }
    if (this.HKx != null) {
      this.HKx.dismiss();
    }
    this.HKv.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void fkr()
  {
    AppMethodBeat.i(34269);
    this.hba = false;
    xd(true);
    AppMethodBeat.o(34269);
  }
  
  public final void fkt()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        ac.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.HKv.size());
        if (this.HKv.size() <= 0)
        {
          this.HKI.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((bo)this.HKv.get(0)).field_createTime;
        int k = this.HKv.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((bo)this.HKv.get(i)).field_createTime)
          {
            l = ((bo)this.HKv.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          bo localbo = (bo)this.HKv.get(j);
          if (localbo != null) {
            aO(localbo);
          }
          AppMethodBeat.o(34272);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
        AppMethodBeat.o(34272);
        return;
      }
      i += 1;
    }
  }
  
  public final void fku()
  {
    AppMethodBeat.i(34273);
    if ((this.oUG != null) && (this.oUG.isPlaying()))
    {
      ac.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.oUH), Boolean.valueOf(this.oUG.isPlaying()) });
      this.oUG.cl(this.oUH);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(34285);
    if (this.HKz != null) {
      this.HKz.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.oUG.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void kc(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    ac.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.oUJ + " tick:" + bs.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.oUL.eVS();
      AppMethodBeat.o(34282);
      return;
    }
    ac.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.oUJ = false;
    if (this.oUG.NU())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bCy())
    {
      fkv();
      ac.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.HKy.oUI)
    {
      xe(false);
      if (this.HKw != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.HKC = paramBoolean;; this.HKC = true)
      {
        fku();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.HKw != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.HKC = paramBoolean;
      new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            ac.i("MicroMsg.AutoPlay", "speaker off");
            d.this.xe(false);
            d locald = d.this;
            if (locald.oUG.isPlaying())
            {
              ac.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.oUG.cq(false);
              locald.xd(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            ac.i("MicroMsg.AutoPlay", "speaker true");
            d.this.fkv();
            if (d.this.context != null) {
              d.this.HKz = t.a(d.this.cLy.HZF.getActivity(), d.this.context.getString(2131759558), 2000L);
            }
            d.this.xe(true);
            d.this.fku();
          }
        }
      }, false).au(50L, 50L);
    }
    ac.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.HKC) });
    AppMethodBeat.o(34282);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    ac.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.oUH), Long.valueOf(this.HKw), Long.valueOf(this.HKE) });
    com.tencent.mm.plugin.report.service.h.wUl.f(15160, new Object[] { Long.valueOf(this.HKw), Long.valueOf(this.HKE), Long.valueOf(this.HKE), Integer.valueOf(0) });
    if (this.context != null)
    {
      ac.i("MicroMsg.AutoPlay", "stop play complete");
      am.aKP("keep_app_silent");
      this.HKy.releaseWakeLock();
      fks();
      if (this.HKv.isEmpty())
      {
        this.oUL.eVS();
        this.oUK.eVT();
      }
      bJU();
      this.HKw = -1L;
      fkv();
      this.HKy.releaseWakeLock();
      xd(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    ac.e("MicroMsg.AutoPlay", "voice play error");
    ami();
    xd(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    ac.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.HKw), Long.valueOf(this.HKE), Long.valueOf(bs.Ap(this.HKD)), Boolean.valueOf(this.HKG), Boolean.valueOf(this.HKF), bs.eWi() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.HKw > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.wUl;
      l1 = this.HKw;
      l2 = this.HKE;
      l3 = bs.Ap(this.HKD);
      if (this.HKG) {
        break label251;
      }
      if (!this.HKF) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localh.f(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.HKG = false;
      this.HKF = false;
      this.HKy.releaseWakeLock();
      fks();
      if (this.HKv.isEmpty())
      {
        this.oUL.eVS();
        this.oUK.eVT();
      }
      bJU();
      this.HKw = -1L;
      fkv();
      this.HKC = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    ac.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.oUK != null) {
      this.oUK.eVT();
    }
    AppMethodBeat.o(34274);
  }
  
  public final void xd(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    ac.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.HKv.size()), Boolean.valueOf(paramBoolean) });
    if (this.HKv.size() <= 0)
    {
      this.HKI.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.oUG != null)
    {
      this.oUG.cq(paramBoolean);
      this.oUG.cp(paramBoolean);
    }
    fkt();
    AppMethodBeat.o(34271);
  }
  
  public final void xe(boolean paramBoolean)
  {
    AppMethodBeat.i(196413);
    ac.m("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oUH = paramBoolean;
    AppMethodBeat.o(196413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */