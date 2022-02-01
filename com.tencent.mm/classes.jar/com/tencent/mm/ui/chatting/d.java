package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.k.c;
import com.tencent.mm.ak.k.d;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.bi;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements k.a, k.b, k.c, k.d, com.tencent.mm.model.ao, com.tencent.mm.modelvoice.c, SensorController.SensorEventCallBack
{
  private List<ca> Peh;
  public long Pei;
  private com.tencent.mm.ui.base.p Pej;
  private bi Pek;
  public com.tencent.mm.ui.base.p Pel;
  public boolean Pem;
  public boolean Pen;
  public boolean Peo;
  private long Pep;
  private long Peq;
  public boolean Per;
  private boolean Pes;
  public IListener Pet;
  private MMHandler Peu;
  private MMHandler Pev;
  public Context context;
  public com.tencent.mm.ui.chatting.e.a dom;
  private int dyc;
  boolean ipv;
  private long lastShakeTime;
  public com.tencent.mm.ak.k qUl;
  private boolean qUm;
  private boolean qUo;
  private ShakeManager qUp;
  private SensorController qUq;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, bi parambi, String paramString)
  {
    AppMethodBeat.i(34261);
    this.ipv = false;
    this.Pei = -1L;
    this.lastShakeTime = -1L;
    this.Pen = true;
    this.Peo = false;
    this.Pep = 0L;
    this.Peq = 0L;
    this.Per = false;
    this.Pes = false;
    this.Pet = new IListener() {};
    this.Peu = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34256);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          Log.i("MicroMsg.AutoPlay", "reset speaker");
          d.b(d.this);
          paramAnonymousMessage = d.this;
          if (!d.c(d.this).qUn) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(paramAnonymousMessage, bool);
            AppMethodBeat.o(34256);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          Log.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34256);
        }
      }
    };
    this.Pev = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          Log.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.gMR();
          AppMethodBeat.o(34257);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          Log.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34257);
        }
      }
    };
    this.qUo = false;
    this.context = parama.Pwc.getContext();
    this.dom = parama;
    this.Pek = parambi;
    if (this.qUq == null) {
      this.qUq = new SensorController(this.context.getApplicationContext());
    }
    if (this.qUp == null) {
      this.qUp = new ShakeManager(this.context.getApplicationContext());
    }
    bmt(paramString);
    EventCenter.instance.addListener(this.Pet);
    bg.Xi().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void bg(ca paramca)
  {
    boolean bool2 = true;
    AppMethodBeat.i(232835);
    boolean bool1;
    Object localObject;
    if ((paramca != null) && ((paramca.gAy()) || (paramca.gDs()) || (paramca.gDt()) || (paramca.gDu())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      Log.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(paramca.field_msgId) });
      if (!this.qUq.hasRegistered())
      {
        this.qUq.setSensorCallBack(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.a(d.this, Util.currentTicks());
            AppMethodBeat.o(34258);
          }
        };
        if (!this.qUp.startShake((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      bg.aVF();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (Util.isNullOrNil(paramca.field_imgPath))) {
        break label178;
      }
      this.Peh.clear();
      u.g(this.context, this.dom.Pwc.getContentView());
      AppMethodBeat.o(232835);
      return;
      bool1 = false;
      break;
    }
    label178:
    bg.aVF();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.Pek.qUn))
    {
      if (this.Pej != null) {
        this.Pej.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.cdW();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.ceb();
      Log.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        u.u(this.dom.Pwc.getActivity(), this.context.getString(2131757275), 2131690495);
      }
    }
    else
    {
      MMEntryLock.lock("keep_app_silent");
      s.ak(paramca);
      this.qUl.stop(true);
      this.Pek.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.cdW()) || (com.tencent.mm.plugin.audio.c.a.ceb()))
      {
        Log.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cdW()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.ceb()) });
        this.qUm = false;
      }
      localObject = getFullPath(paramca.field_imgPath);
      Log.i("MicroMsg.AutoPlay", "startplay");
      bool1 = s.Rm(paramca.field_imgPath);
      if (!bool1) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.qUl.a((String)localObject, this.qUm, true, -1))) {
        break label577;
      }
      localObject = this.qUl;
      if (this.Peh.size() <= 1) {
        break label572;
      }
      bool1 = bool2;
      label447:
      ((com.tencent.mm.ak.k)localObject).db(bool1);
      this.qUl.a(this);
      this.qUl.a(this);
      this.qUl.a(this);
      this.qUl.a(this);
      this.Pei = paramca.field_msgId;
      this.Peq = new com.tencent.mm.modelvoice.p(paramca.field_content).time;
      this.Pep = System.currentTimeMillis();
    }
    for (;;)
    {
      cmy();
      this.Peo = false;
      AppMethodBeat.o(232835);
      return;
      u.u(this.dom.Pwc.getActivity(), this.context.getString(2131757276), 2131690544);
      break;
      label572:
      bool1 = false;
      break label447;
      label577:
      this.Pei = -1L;
      gMO();
      Toast.makeText(this.context, this.context.getString(2131757488), 0).show();
    }
  }
  
  private void cmy()
  {
    AppMethodBeat.i(34276);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.d(d.this).cmy();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void gMQ()
  {
    AppMethodBeat.i(34270);
    int k = this.Peh.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((ca)this.Peh.get(i)).field_msgId != this.Pei) {
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
        this.Peh.remove(j);
      }
      Log.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.Peh.size());
      if (this.Peh.size() == 0) {
        EventCenter.instance.asyncPublish(new zc(), Looper.getMainLooper());
      }
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(232836);
    if (this.dyc == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.cz(paramString, false);
      AppMethodBeat.o(232836);
      return paramString;
    }
    paramString = s.getFullPath(paramString);
    AppMethodBeat.o(232836);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.dom != null)
    {
      boolean bool = this.dom.Pwc.getController().OFT;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.dom != null) {
      this.dom.Pwc.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void BK(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    Log.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.Peh.size()), Boolean.valueOf(paramBoolean) });
    if (this.Peh.size() <= 0)
    {
      this.Peu.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.qUl != null)
    {
      this.qUl.cZ(paramBoolean);
      this.qUl.cY(paramBoolean);
    }
    gMR();
    AppMethodBeat.o(34271);
  }
  
  public final void BL(boolean paramBoolean)
  {
    AppMethodBeat.i(232834);
    Log.printInfoStack("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qUm = paramBoolean;
    AppMethodBeat.o(232834);
  }
  
  public final void a(int paramInt, ca paramca)
  {
    AppMethodBeat.i(34266);
    if (paramca == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    gMO();
    bg.aVF();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.azQ().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
      gMU();
      this.Pel = u.a(this.dom.Pwc.getActivity(), this.context.getString(2131757468), 4000L);
    }
    if ((this.qUl.isPlaying()) && (paramca.field_msgId == this.Pei))
    {
      gMT();
      AppMethodBeat.o(34266);
      return;
    }
    bf(paramca);
    if ((paramca.field_isSend == 0) && (!s.ai(paramca))) {
      ama(paramInt + 1);
    }
    BK(true);
    AppMethodBeat.o(34266);
  }
  
  public final void aVl()
  {
    AppMethodBeat.i(34286);
    Log.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.Pes = false;
    AppMethodBeat.o(34286);
  }
  
  public final void aVm()
  {
    AppMethodBeat.i(34287);
    Log.printInfoStack("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.Pes = true;
    gMT();
    gMO();
    try
    {
      if (this.qUq != null) {
        this.qUq.removeSensorCallBack();
      }
      if (this.qUp != null) {
        this.qUp.stopShake();
      }
      AppMethodBeat.o(34287);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34287);
    }
  }
  
  public final void ah(ca paramca)
  {
    AppMethodBeat.i(34268);
    if ((this.Pen) && (this.Peh.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramca == null) || (!paramca.gAy()) || (paramca.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramca.field_talker == null) || (!paramca.field_talker.equals(this.dom.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!bg.azz().foreground) || (!this.dom.cQp))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (s.aj(paramca))
    {
      Log.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    bf(paramca);
    if ((!this.ipv) && (!this.qUl.isPlaying()) && (Util.isTopActivity(this.context))) {
      BK(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void ama(int paramInt)
  {
    AppMethodBeat.i(34264);
    for (;;)
    {
      if (this.context == null)
      {
        Log.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(34264);
        return;
      }
      if (this.dom == null)
      {
        Log.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
      Log.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      ca localca = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).amt(paramInt);
      if (localca == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localca.gAy()) && (localca.field_isSend == 0) && (!s.ai(localca)) && (!s.aj(localca))) {
        bf(localca);
      }
      paramInt += 1;
    }
  }
  
  public final void b(int paramInt, ca paramca)
  {
    AppMethodBeat.i(34267);
    if (paramca == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    gMO();
    bg.aVF();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.azQ().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
      gMU();
      this.Pel = u.a(this.dom.Pwc.getActivity(), this.context.getString(2131757468), 4000L);
    }
    if ((this.qUl.isPlaying()) && (paramca.field_msgId == this.Pei))
    {
      gMT();
      AppMethodBeat.o(34267);
      return;
    }
    bf(paramca);
    if ((paramca.field_isSend == 0) && (!s.ai(paramca))) {
      ama(paramInt + 1);
    }
    BK(true);
    AppMethodBeat.o(34267);
  }
  
  public final void bf(ca paramca)
  {
    AppMethodBeat.i(34265);
    if (paramca == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.Peh.size() > 0)
      {
        this.Peh.clear();
        u.g(this.context, this.dom.Pwc.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.Peh.size();
    int i = 0;
    while (i < j)
    {
      if (((ca)this.Peh.get(i)).field_msgId == paramca.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.Pem) || (this.Peh.size() == 0)) {
      this.Peh.add(paramca);
    }
    Log.d("MicroMsg.AutoPlay", "add voice msg :" + this.Peh.size());
    AppMethodBeat.o(34265);
  }
  
  public final void bmt(String paramString)
  {
    AppMethodBeat.i(34262);
    Log.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.Peo) });
    if ((this.Peo) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.Peh = new LinkedList();
    this.ipv = false;
    this.Pei = -1L;
    this.qUm = false;
    this.lastShakeTime = -1L;
    this.Pem = false;
    this.dyc = 0;
    if (ab.Jp(paramString))
    {
      this.dyc = 1;
      this.qUl = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.dyc = 0;
    this.qUl = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void fw(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    Log.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final void gMO()
  {
    AppMethodBeat.i(34263);
    if (1 == Log.getLogLevel()) {
      Log.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { Util.getStack() });
    }
    if (this.Pej != null) {
      this.Pej.dismiss();
    }
    this.Peh.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void gMP()
  {
    AppMethodBeat.i(34269);
    this.ipv = false;
    BK(true);
    AppMethodBeat.o(34269);
  }
  
  public final void gMR()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        Log.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.Peh.size());
        if (this.Peh.size() <= 0)
        {
          this.Peu.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((ca)this.Peh.get(0)).field_createTime;
        int k = this.Peh.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((ca)this.Peh.get(i)).field_createTime)
          {
            l = ((ca)this.Peh.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          ca localca = (ca)this.Peh.get(j);
          if (localca != null) {
            bg(localca);
          }
          AppMethodBeat.o(34272);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
        AppMethodBeat.o(34272);
        return;
      }
      i += 1;
    }
  }
  
  public final void gMS()
  {
    AppMethodBeat.i(34273);
    if ((this.qUl != null) && (this.qUl.isPlaying()))
    {
      Log.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.qUm), Boolean.valueOf(this.qUl.isPlaying()) });
      this.qUl.cU(this.qUm);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void gMT()
  {
    AppMethodBeat.i(34275);
    Log.i("MicroMsg.AutoPlay", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    this.qUl.cZ(true);
    this.qUl.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void gMU()
  {
    AppMethodBeat.i(34285);
    if (this.Pel != null) {
      this.Pel.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.qUl.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    Log.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.qUm), Long.valueOf(this.Pei), Long.valueOf(this.Peq) });
    com.tencent.mm.plugin.report.service.h.CyF.a(15160, new Object[] { Long.valueOf(this.Pei), Long.valueOf(this.Peq), Long.valueOf(this.Peq), Integer.valueOf(0) });
    if (this.context != null)
    {
      Log.i("MicroMsg.AutoPlay", "stop play complete");
      MMEntryLock.unlock("keep_app_silent");
      this.Pek.releaseWakeLock();
      gMQ();
      if (this.Peh.isEmpty())
      {
        this.qUq.removeSensorCallBack();
        this.qUp.stopShake();
      }
      cmy();
      this.Pei = -1L;
      gMU();
      this.Pek.releaseWakeLock();
      BK(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    Log.e("MicroMsg.AutoPlay", "voice play error");
    gMT();
    BK(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onSensorEvent(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.qUo + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.qUo)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.qUo = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.qUq.removeSensorCallBack();
      AppMethodBeat.o(34282);
      return;
    }
    Log.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.qUo = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.qUo = false;
    if (this.qUl.isCalling())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.ceb())
    {
      gMU();
      Log.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.Pek.qUn)
    {
      BL(false);
      if (this.Pei != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.Peo = paramBoolean;; this.Peo = true)
      {
        gMS();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.Pei != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.Peo = paramBoolean;
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            Log.i("MicroMsg.AutoPlay", "speaker off");
            d.this.BL(false);
            d locald = d.this;
            if (locald.qUl.isPlaying())
            {
              Log.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.qUl.cZ(false);
              locald.BK(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            Log.i("MicroMsg.AutoPlay", "speaker true");
            d.e(d.this);
            if (d.f(d.this) != null) {
              d.a(d.this, u.a(d.d(d.this).Pwc.getActivity(), d.f(d.this).getString(2131760875), 2000L));
            }
            d.this.BL(true);
            d.this.gMS();
          }
        }
      }, false).startTimer(50L);
    }
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.Peo) });
    AppMethodBeat.o(34282);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    Log.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.Pei), Long.valueOf(this.Peq), Long.valueOf(Util.milliSecondsToNow(this.Pep)), Boolean.valueOf(this.Pes), Boolean.valueOf(this.Per), Util.getStack() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.Pei > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      l1 = this.Pei;
      l2 = this.Peq;
      l3 = Util.milliSecondsToNow(this.Pep);
      if (this.Pes) {
        break label251;
      }
      if (!this.Per) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localh.a(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.Pes = false;
      this.Per = false;
      this.Pek.releaseWakeLock();
      gMQ();
      if (this.Peh.isEmpty())
      {
        this.qUq.removeSensorCallBack();
        this.qUp.stopShake();
      }
      cmy();
      this.Pei = -1L;
      gMU();
      this.Peo = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    Log.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.qUp != null) {
      this.qUp.stopShake();
    }
    AppMethodBeat.o(34274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */