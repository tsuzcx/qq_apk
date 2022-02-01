package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.an.k.c;
import com.tencent.mm.an.k.d;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaj;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.p;
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
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.d.bl;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements k.a, k.b, k.c, k.d, ap, com.tencent.mm.modelvoice.c, SensorController.SensorEventCallBack
{
  public long WxA;
  private r WxB;
  private bl WxC;
  public r WxD;
  public boolean WxF;
  public boolean WxG;
  private long WxH;
  private long WxI;
  public boolean WxJ;
  private boolean WxK;
  public IListener WxL;
  private MMHandler WxM;
  private MMHandler WxN;
  private List<ca> Wxz;
  public boolean auto;
  public Context context;
  public com.tencent.mm.ui.chatting.e.a fgR;
  private int fqR;
  private long lastShakeTime;
  boolean leA;
  public com.tencent.mm.an.k uwr;
  private boolean uws;
  private boolean uwu;
  private ShakeManager uwv;
  private SensorController uww;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, bl parambl, String paramString)
  {
    AppMethodBeat.i(34261);
    this.leA = false;
    this.WxA = -1L;
    this.lastShakeTime = -1L;
    this.WxF = true;
    this.WxG = false;
    this.WxH = 0L;
    this.WxI = 0L;
    this.WxJ = false;
    this.WxK = false;
    this.WxL = new IListener() {};
    this.WxM = new MMHandler(Looper.getMainLooper())
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
          if (!d.c(d.this).uwt) {}
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
    this.WxN = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          Log.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          d.this.hMa();
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
    this.uwu = false;
    this.context = parama.WQv.getContext();
    this.fgR = parama;
    this.WxC = parambl;
    if (this.uww == null) {
      this.uww = new SensorController(this.context.getApplicationContext());
    }
    if (this.uwv == null) {
      this.uwv = new ShakeManager(this.context.getApplicationContext());
    }
    byU(paramString);
    EventCenter.instance.addListener(this.WxL);
    bh.abL().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void bz(ca paramca)
  {
    boolean bool2 = true;
    AppMethodBeat.i(269846);
    boolean bool1;
    Object localObject;
    if ((paramca != null) && ((paramca.hwF()) || (paramca.hzG()) || (paramca.hzH()) || (paramca.hzI())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      Log.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(paramca.field_msgId) });
      if (!this.uww.hasRegistered())
      {
        this.uww.setSensorCallBack(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.a(d.this, Util.currentTicks());
            AppMethodBeat.o(34258);
          }
        };
        if (!this.uwv.startShake((Runnable)localObject)) {
          break label168;
        }
      }
    }
    label168:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      bh.beI();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (Util.isNullOrNil(paramca.field_imgPath))) {
        break label178;
      }
      this.Wxz.clear();
      com.tencent.mm.ui.base.w.g(this.context, this.fgR.WQv.getContentView());
      AppMethodBeat.o(269846);
      return;
      bool1 = false;
      break;
    }
    label178:
    bh.beI();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.WxC.uwt))
    {
      if (this.WxB != null) {
        this.WxB.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.crh();
      boolean bool3 = com.tencent.mm.plugin.audio.c.a.cro();
      Log.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool1) && (bool3)) {
        com.tencent.mm.ui.base.w.w(this.fgR.WQv.getActivity(), this.context.getString(R.l.chatfooter_SpeakerOff_bluetooth_now), R.k.icons_filled_bluetooth);
      }
    }
    else
    {
      MMEntryLock.lock("keep_app_silent");
      s.as(paramca);
      this.uwr.stop(true);
      this.WxC.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.crh()) || (com.tencent.mm.plugin.audio.c.a.cro()))
      {
        Log.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.crh()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cro()) });
        this.uws = false;
      }
      localObject = getFullPath(paramca.field_imgPath);
      Log.i("MicroMsg.AutoPlay", "startplay");
      bool1 = s.YJ(paramca.field_imgPath);
      if (!bool1) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.uwr.a((String)localObject, this.uws, true, -1))) {
        break label577;
      }
      localObject = this.uwr;
      if (this.Wxz.size() <= 1) {
        break label572;
      }
      bool1 = bool2;
      label447:
      ((com.tencent.mm.an.k)localObject).dB(bool1);
      this.uwr.a(this);
      this.uwr.a(this);
      this.uwr.a(this);
      this.uwr.a(this);
      this.WxA = paramca.field_msgId;
      this.WxI = new p(paramca.field_content).time;
      this.WxH = System.currentTimeMillis();
    }
    for (;;)
    {
      cAe();
      this.WxG = false;
      AppMethodBeat.o(269846);
      return;
      com.tencent.mm.ui.base.w.w(this.fgR.WQv.getActivity(), this.context.getString(R.l.chatfooter_SpeakerOff_now), R.k.icons_filled_ear);
      break;
      label572:
      bool1 = false;
      break label447;
      label577:
      this.WxA = -1L;
      hLX();
      Toast.makeText(this.context, this.context.getString(R.l.ewD), 0).show();
    }
  }
  
  private void cAe()
  {
    AppMethodBeat.i(34276);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.d(d.this).cAe();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(269847);
    if (this.fqR == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.d.h.cN(paramString, false);
      AppMethodBeat.o(269847);
      return paramString;
    }
    paramString = s.getFullPath(paramString);
    AppMethodBeat.o(269847);
    return paramString;
  }
  
  private void hLZ()
  {
    AppMethodBeat.i(34270);
    int k = this.Wxz.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((ca)this.Wxz.get(i)).field_msgId != this.WxA) {
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
        this.Wxz.remove(j);
      }
      Log.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.Wxz.size());
      if (this.Wxz.size() == 0) {
        EventCenter.instance.asyncPublish(new aaj(), Looper.getMainLooper());
      }
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.fgR != null)
    {
      boolean bool = this.fgR.WQv.getController().VZn;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.fgR != null) {
      this.fgR.WQv.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void Gg(boolean paramBoolean)
  {
    AppMethodBeat.i(269844);
    Log.printInfoStack("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uws = paramBoolean;
    AppMethodBeat.o(269844);
  }
  
  public final void a(int paramInt, ca paramca)
  {
    AppMethodBeat.i(34266);
    if (paramca == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    hLX();
    bh.beI();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.aHp().b(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(4115, Boolean.TRUE);
      hMd();
      this.WxD = com.tencent.mm.ui.base.w.a(this.fgR.WQv.getActivity(), this.context.getString(R.l.ewq), 4000L);
    }
    if ((this.uwr.isPlaying()) && (paramca.field_msgId == this.WxA))
    {
      hMc();
      AppMethodBeat.o(34266);
      return;
    }
    by(paramca);
    if ((paramca.field_isSend == 0) && (!s.aq(paramca))) {
      ava(paramInt + 1);
    }
    oO(true);
    AppMethodBeat.o(34266);
  }
  
  public final void ap(ca paramca)
  {
    AppMethodBeat.i(34268);
    if ((this.WxF) && (this.Wxz.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramca == null) || (!paramca.hwF()) || (paramca.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramca.field_talker == null) || (!paramca.field_talker.equals(this.fgR.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!bh.aGY().foreground) || (!this.fgR.dgo))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (s.ar(paramca))
    {
      Log.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    by(paramca);
    if ((!this.leA) && (!this.uwr.isPlaying()) && (Util.isTopActivity(this.context))) {
      oO(true);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void ava(int paramInt)
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
      if (this.fgR == null)
      {
        Log.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
      Log.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      ca localca = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).avt(paramInt);
      if (localca == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localca.hwF()) && (localca.field_isSend == 0) && (!s.aq(localca)) && (!s.ar(localca))) {
        by(localca);
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
    hLX();
    bh.beI();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.aHp().b(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(4115, Boolean.TRUE);
      hMd();
      this.WxD = com.tencent.mm.ui.base.w.a(this.fgR.WQv.getActivity(), this.context.getString(R.l.ewq), 4000L);
    }
    if ((this.uwr.isPlaying()) && (paramca.field_msgId == this.WxA))
    {
      hMc();
      AppMethodBeat.o(34267);
      return;
    }
    by(paramca);
    if ((paramca.field_isSend == 0) && (!s.aq(paramca))) {
      ava(paramInt + 1);
    }
    oO(true);
    AppMethodBeat.o(34267);
  }
  
  public final void beo()
  {
    AppMethodBeat.i(34286);
    Log.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.WxK = false;
    AppMethodBeat.o(34286);
  }
  
  public final void bep()
  {
    AppMethodBeat.i(34287);
    Log.printInfoStack("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.WxK = true;
    hMc();
    hLX();
    try
    {
      if (this.uww != null) {
        this.uww.removeSensorCallBack();
      }
      if (this.uwv != null) {
        this.uwv.stopShake();
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
  
  public final void by(ca paramca)
  {
    AppMethodBeat.i(34265);
    if (paramca == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.Wxz.size() > 0)
      {
        this.Wxz.clear();
        com.tencent.mm.ui.base.w.g(this.context, this.fgR.WQv.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.Wxz.size();
    int i = 0;
    while (i < j)
    {
      if (((ca)this.Wxz.get(i)).field_msgId == paramca.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.auto) || (this.Wxz.size() == 0)) {
      this.Wxz.add(paramca);
    }
    Log.d("MicroMsg.AutoPlay", "add voice msg :" + this.Wxz.size());
    AppMethodBeat.o(34265);
  }
  
  public final void byU(String paramString)
  {
    AppMethodBeat.i(34262);
    Log.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.WxG) });
    if ((this.WxG) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.Wxz = new LinkedList();
    this.leA = false;
    this.WxA = -1L;
    this.uws = false;
    this.lastShakeTime = -1L;
    this.auto = false;
    this.fqR = 0;
    if (ab.QI(paramString))
    {
      this.fqR = 1;
      this.uwr = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(34262);
      return;
    }
    this.fqR = 0;
    this.uwr = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(34262);
  }
  
  public final void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    Log.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final void hLX()
  {
    AppMethodBeat.i(34263);
    if (1 == Log.getLogLevel()) {
      Log.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { Util.getStack() });
    }
    if (this.WxB != null) {
      this.WxB.dismiss();
    }
    this.Wxz.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void hLY()
  {
    AppMethodBeat.i(34269);
    this.leA = false;
    oO(true);
    AppMethodBeat.o(34269);
  }
  
  public final void hMa()
  {
    AppMethodBeat.i(34272);
    for (;;)
    {
      int i;
      try
      {
        Log.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.Wxz.size());
        if (this.Wxz.size() <= 0)
        {
          this.WxM.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(34272);
          return;
        }
        long l = ((ca)this.Wxz.get(0)).field_createTime;
        int k = this.Wxz.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((ca)this.Wxz.get(i)).field_createTime)
          {
            l = ((ca)this.Wxz.get(i)).field_createTime;
            j = i;
          }
        }
        else
        {
          ca localca = (ca)this.Wxz.get(j);
          if (localca != null) {
            bz(localca);
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
  
  public final void hMb()
  {
    AppMethodBeat.i(34273);
    if ((this.uwr != null) && (this.uwr.isPlaying()))
    {
      Log.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.uws), Boolean.valueOf(this.uwr.isPlaying()) });
      this.uwr.dr(this.uws);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void hMc()
  {
    AppMethodBeat.i(34275);
    Log.i("MicroMsg.AutoPlay", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    this.uwr.dz(true);
    this.uwr.stop();
    AppMethodBeat.o(34275);
  }
  
  public final void hMd()
  {
    AppMethodBeat.i(34285);
    if (this.WxD != null) {
      this.WxD.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.uwr.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void oO(boolean paramBoolean)
  {
    AppMethodBeat.i(34271);
    Log.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.Wxz.size()), Boolean.valueOf(paramBoolean) });
    if (this.Wxz.size() <= 0)
    {
      this.WxM.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(34271);
      return;
    }
    if (this.uwr != null)
    {
      this.uwr.dz(paramBoolean);
      this.uwr.dy(paramBoolean);
    }
    hMa();
    AppMethodBeat.o(34271);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    Log.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.uws), Long.valueOf(this.WxA), Long.valueOf(this.WxI) });
    com.tencent.mm.plugin.report.service.h.IzE.a(15160, new Object[] { Long.valueOf(this.WxA), Long.valueOf(this.WxI), Long.valueOf(this.WxI), Integer.valueOf(0) });
    if (this.context != null)
    {
      Log.i("MicroMsg.AutoPlay", "stop play complete");
      MMEntryLock.unlock("keep_app_silent");
      this.WxC.releaseWakeLock();
      hLZ();
      if (this.Wxz.isEmpty())
      {
        this.uww.removeSensorCallBack();
        this.uwv.stopShake();
      }
      cAe();
      this.WxA = -1L;
      hMd();
      this.WxC.releaseWakeLock();
      oO(false);
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(34279);
    Log.e("MicroMsg.AutoPlay", "voice play error");
    hMc();
    oO(true);
    AppMethodBeat.o(34279);
  }
  
  public final void onSensorEvent(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.uwu + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.uww.removeSensorCallBack();
      AppMethodBeat.o(34282);
      return;
    }
    Log.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.uwu = false;
    if (this.uwr.isCalling())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.cro())
    {
      hMd();
      Log.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.WxC.uwt)
    {
      Gg(false);
      if (this.WxA != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.WxG = paramBoolean;; this.WxG = true)
      {
        hMb();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.WxA != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.WxG = paramBoolean;
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            Log.i("MicroMsg.AutoPlay", "speaker off");
            d.this.Gg(false);
            d locald = d.this;
            if (locald.uwr.isPlaying())
            {
              Log.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.uwr.dz(false);
              locald.oO(false);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            Log.i("MicroMsg.AutoPlay", "speaker true");
            d.e(d.this);
            if (d.f(d.this) != null) {
              d.a(d.this, com.tencent.mm.ui.base.w.a(d.d(d.this).WQv.getActivity(), d.f(d.this).getString(R.l.eFM), 2000L));
            }
            d.this.Gg(true);
            d.this.hMb();
          }
        }
      }, false).startTimer(50L);
    }
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.WxG) });
    AppMethodBeat.o(34282);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    Log.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.WxA), Long.valueOf(this.WxI), Long.valueOf(Util.milliSecondsToNow(this.WxH)), Boolean.valueOf(this.WxK), Boolean.valueOf(this.WxJ), Util.getStack() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.WxA > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      l1 = this.WxA;
      l2 = this.WxI;
      l3 = Util.milliSecondsToNow(this.WxH);
      if (this.WxK) {
        break label251;
      }
      if (!this.WxJ) {}
    }
    label251:
    for (i = 1;; i = 3)
    {
      localh.a(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.WxK = false;
      this.WxJ = false;
      this.WxC.releaseWakeLock();
      hLZ();
      if (this.Wxz.isEmpty())
      {
        this.uww.removeSensorCallBack();
        this.uwv.stopShake();
      }
      cAe();
      this.WxA = -1L;
      hMd();
      this.WxG = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    Log.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.uwv != null) {
      this.uwv.stopShake();
    }
    AppMethodBeat.o(34274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */