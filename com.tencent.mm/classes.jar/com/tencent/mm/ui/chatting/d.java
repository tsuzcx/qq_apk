package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.am.j.c;
import com.tencent.mm.am.j.d;
import com.tencent.mm.am.j.e;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acg;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.bt;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements j.a, j.b, j.c, j.e, com.tencent.mm.model.aq, com.tencent.mm.modelvoice.c, SensorController.SensorEventCallBack
{
  private String NBt;
  private List<cc> aeeR;
  private p aeeS;
  public long aeeT;
  private v aeeU;
  private bt aeeV;
  public v aeeW;
  private a aeeX;
  private boolean aeeY;
  private long aeeZ;
  public boolean aefa;
  public boolean aefb;
  private long aefc;
  private long aefd;
  private boolean aefe;
  private boolean aeff;
  private j.d aefg;
  public IListener aefh;
  private MMHandler aefi;
  public boolean auto;
  public Context context;
  private final MultiProcessMMKV eMf;
  public com.tencent.mm.ui.chatting.d.a hlc;
  private int hva;
  private long lastShakeTime;
  boolean nJm;
  public j xCQ;
  private boolean xCR;
  private boolean xCT;
  private ShakeManager xCU;
  private SensorController xCV;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, bt parambt, String paramString)
  {
    AppMethodBeat.i(34261);
    this.eMf = MultiProcessMMKV.getSingleMMKV("voice_continue_play_info");
    this.aeeS = null;
    this.nJm = false;
    this.aeeT = -1L;
    this.aeeX = null;
    this.aeeY = true;
    this.lastShakeTime = -1L;
    this.aeeZ = -1L;
    this.NBt = "";
    this.aefa = true;
    this.aefb = false;
    this.aefc = 0L;
    this.aefd = 0L;
    this.aefe = false;
    this.aeff = false;
    this.aefg = new j.d()
    {
      public final void eb(long paramAnonymousLong)
      {
        AppMethodBeat.i(253712);
        d.a(d.this, paramAnonymousLong);
        AppMethodBeat.o(253712);
      }
    };
    this.aefh = new AutoPlay.2(this, f.hfK);
    this.aefi = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34257);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          Log.i("MicroMsg.AutoPlay", "reset speaker");
          d.b(d.this);
          paramAnonymousMessage = d.this;
          if (!d.c(d.this).xCS) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(paramAnonymousMessage, bool);
            AppMethodBeat.o(34257);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          Log.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          AppMethodBeat.o(34257);
        }
      }
    };
    this.xCT = false;
    this.context = parama.aezO.getContext();
    this.hlc = parama;
    this.aeeV = parambt;
    if (this.xCV == null) {
      this.xCV = new SensorController(this.context.getApplicationContext());
    }
    if (this.xCU == null) {
      this.xCU = new ShakeManager(this.context.getApplicationContext());
    }
    bAx(paramString);
    this.aefh.alive();
    bh.aDI().a(this);
    AppMethodBeat.o(34261);
  }
  
  private void LS(boolean paramBoolean)
  {
    AppMethodBeat.i(253895);
    for (;;)
    {
      int i;
      try
      {
        Log.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.aeeR.size());
        if (this.aeeR.size() <= 0)
        {
          this.aefi.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(253895);
          return;
        }
        long l = ((cc)this.aeeR.get(0)).getCreateTime();
        int k = this.aeeR.size();
        i = 1;
        int j = 0;
        if (i < k)
        {
          if (l > ((cc)this.aeeR.get(i)).getCreateTime())
          {
            l = ((cc)this.aeeR.get(i)).getCreateTime();
            j = i;
          }
        }
        else
        {
          cc localcc = (cc)this.aeeR.get(j);
          if (localcc != null) {
            f(localcc, paramBoolean);
          }
          AppMethodBeat.o(253895);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
        AppMethodBeat.o(253895);
        return;
      }
      i += 1;
    }
  }
  
  private void dcZ()
  {
    AppMethodBeat.i(34276);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34259);
        d.d(d.this).dcZ();
        AppMethodBeat.o(34259);
      }
    });
    AppMethodBeat.o(34276);
  }
  
  private void f(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(253902);
    boolean bool1;
    Object localObject;
    if ((paramcc != null) && ((paramcc.iYj()) || (paramcc.jbL()) || (paramcc.jbM()) || (paramcc.jbN())))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      Log.i("MicroMsg.AutoPlay", "start play msg: %d, recordInterrupt: %b", new Object[] { Long.valueOf(paramcc.field_msgId), Boolean.valueOf(paramBoolean) });
      if (!this.xCV.hasRegistered())
      {
        this.xCV.setSensorCallBack(this);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34258);
            d.b(d.this, Util.currentTicks());
            AppMethodBeat.o(34258);
          }
        };
        if (!this.xCU.startShake((Runnable)localObject)) {
          break label176;
        }
      }
    }
    label176:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      bh.bCz();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (Util.isNullOrNil(paramcc.field_imgPath))) {
        break label186;
      }
      this.aeeR.clear();
      aa.j(this.context, this.hlc.aezO.getContentView());
      AppMethodBeat.o(253902);
      return;
      bool1 = false;
      break;
    }
    label186:
    bh.bCz();
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.aeeV.xCS))
    {
      if (this.aeeU != null) {
        this.aeeU.dismiss();
      }
      bool1 = com.tencent.mm.plugin.audio.c.a.cTQ();
      boolean bool2 = com.tencent.mm.plugin.audio.c.a.cTX();
      Log.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        aa.y(this.hlc.aezO.getActivity(), this.context.getString(R.l.chatfooter_SpeakerOff_bluetooth_now), R.k.icons_filled_bluetooth);
      }
    }
    else
    {
      MMEntryLock.lock("keep_app_silent");
      com.tencent.mm.modelvoice.s.ay(paramcc);
      if ((this.xCQ.isPlaying()) && (paramBoolean)) {
        joE();
      }
      this.xCQ.stop(true);
      this.aeeZ = -1L;
      this.aeeV.acquireWakeLock();
      if ((com.tencent.mm.plugin.audio.c.a.cTQ()) || (com.tencent.mm.plugin.audio.c.a.cTX()))
      {
        Log.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTQ()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTX()) });
        this.xCR = false;
      }
      localObject = getFullPath(paramcc.field_imgPath);
      Log.i("MicroMsg.AutoPlay", "startplay");
      paramBoolean = com.tencent.mm.modelvoice.s.QO(paramcc.field_imgPath);
      if (!paramBoolean) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!paramBoolean) || (!this.xCQ.a((String)localObject, this.xCR, true, -1))) {
        break label628;
      }
      this.aeeS = new p(paramcc.field_content);
      localObject = this.xCQ;
      if (this.aeeR.size() <= 1) {
        break label623;
      }
      paramBoolean = true;
      label497:
      ((j)localObject).en(paramBoolean);
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.aeeT = paramcc.field_msgId;
      this.aefd = new p(paramcc.field_content).time;
      this.aefc = System.currentTimeMillis();
    }
    for (;;)
    {
      dcZ();
      this.aefb = false;
      AppMethodBeat.o(253902);
      return;
      aa.y(this.hlc.aezO.getActivity(), this.context.getString(R.l.chatfooter_SpeakerOff_now), R.k.icons_filled_ear);
      break;
      label623:
      paramBoolean = false;
      break label497;
      label628:
      this.aeeT = -1L;
      joz();
      Toast.makeText(this.context, this.context.getString(R.l.gze), 0).show();
    }
  }
  
  private String getFullPath(String paramString)
  {
    AppMethodBeat.i(253906);
    if (this.hva == 1)
    {
      paramString = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt(paramString, false);
      AppMethodBeat.o(253906);
      return paramString;
    }
    paramString = com.tencent.mm.modelvoice.s.getFullPath(paramString);
    AppMethodBeat.o(253906);
    return paramString;
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(34284);
    if (this.hlc != null)
    {
      boolean bool = this.hlc.aezO.getController().adDI;
      AppMethodBeat.o(34284);
      return bool;
    }
    AppMethodBeat.o(34284);
    return false;
  }
  
  private void joB()
  {
    AppMethodBeat.i(34270);
    int k = this.aeeR.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((cc)this.aeeR.get(i)).field_msgId != this.aeeT) {
        break label136;
      }
      j = i;
    }
    label136:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.aeeR.remove(j);
      }
      Log.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.aeeR.size());
      if (this.aeeR.size() == 0) {
        new acg().asyncPublish(Looper.getMainLooper());
      }
      AppMethodBeat.o(34270);
      return;
    }
  }
  
  private void joE()
  {
    AppMethodBeat.i(253911);
    if ((this.aeeT >= 0L) && (this.aeeZ > 2000L))
    {
      String str1 = this.aeeT;
      String str2 = this.aeeZ + "," + System.currentTimeMillis();
      this.eMf.putString(str1, str2);
      this.eMf.putLong("current_interrupt_msg_id-" + this.NBt, this.aeeT);
      Log.i("MicroMsg.AutoPlay", "[voice interrupt] record id: " + str1 + " info: " + str2 + this.NBt);
    }
    AppMethodBeat.o(253911);
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(34283);
    if (this.hlc != null) {
      this.hlc.aezO.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(34283);
  }
  
  public final void LT(boolean paramBoolean)
  {
    AppMethodBeat.i(253975);
    Log.printInfoStack("MicroMsg.AutoPlay", "speakerOn has been set %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.xCR = paramBoolean;
    AppMethodBeat.o(253975);
  }
  
  public final void a(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(253955);
    if ((paramcc == null) || (!paramcc.iYj()))
    {
      AppMethodBeat.o(253955);
      return;
    }
    Object localObject = new p(paramcc.field_content);
    if (((((p)localObject).time == 0L) && (paramcc.field_isSend == 0)) || ((paramcc.field_status == 1) && (paramcc.field_isSend == 1)))
    {
      AppMethodBeat.o(253955);
      return;
    }
    if ((paramcc.field_isSend == 0) && (((p)localObject).time == -1L))
    {
      AppMethodBeat.o(253955);
      return;
    }
    joz();
    bh.bCz();
    localObject = (Boolean)com.tencent.mm.model.c.ban().d(4115, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4115, Boolean.TRUE);
      joF();
      this.aeeW = aa.a(this.hlc.aezO.getActivity(), this.context.getString(R.l.gyQ), 4000L);
    }
    if ((this.xCQ.isPlaying()) && (paramcc.field_msgId == this.aeeT))
    {
      this.aefe = true;
      joD();
      AppMethodBeat.o(253955);
      return;
    }
    bL(paramcc);
    if ((paramcc.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.aw(paramcc))) {
      aBC(paramInt + 1);
    }
    bN(true, false);
    AppMethodBeat.o(253955);
  }
  
  public final void aBC(int paramInt)
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
      if (this.hlc == null)
      {
        Log.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(34264);
        return;
      }
      int i = ((m)this.hlc.cm(m.class)).getCount();
      Log.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(34264);
        return;
      }
      cc localcc = ((m)this.hlc.cm(m.class)).aBV(paramInt);
      if (localcc == null)
      {
        AppMethodBeat.o(34264);
        return;
      }
      if ((localcc.iYj()) && (localcc.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.aw(localcc)) && (!com.tencent.mm.modelvoice.s.ax(localcc))) {
        bL(localcc);
      }
      paramInt += 1;
    }
  }
  
  public final void atR()
  {
    AppMethodBeat.i(34279);
    Log.e("MicroMsg.AutoPlay", "voice play error");
    joD();
    bN(true, false);
    AppMethodBeat.o(34279);
  }
  
  public final void av(cc paramcc)
  {
    AppMethodBeat.i(34268);
    if ((this.aefa) && (this.aeeR.isEmpty()))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramcc == null) || (!paramcc.iYj()) || (paramcc.field_isSend == 1))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((paramcc.field_talker == null) || (!paramcc.field_talker.equals(this.hlc.getTalkerUserName())))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if ((!bh.aZW().foreground) || (!this.hlc.ffv))
    {
      AppMethodBeat.o(34268);
      return;
    }
    if (com.tencent.mm.modelvoice.s.ax(paramcc))
    {
      Log.e("MicroMsg.AutoPlay", "should not in this setData");
      AppMethodBeat.o(34268);
      return;
    }
    bL(paramcc);
    if ((!this.nJm) && (!this.xCQ.isPlaying()) && (Util.isTopActivity(this.context))) {
      bN(true, false);
    }
    AppMethodBeat.o(34268);
  }
  
  public final void b(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(34266);
    if (paramcc == null)
    {
      AppMethodBeat.o(34266);
      return;
    }
    joz();
    bh.bCz();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ban().d(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4115, Boolean.TRUE);
      joF();
      this.aeeW = aa.a(this.hlc.aezO.getActivity(), this.context.getString(R.l.gyQ), 4000L);
    }
    if ((this.xCQ.isPlaying()) && (paramcc.field_msgId == this.aeeT))
    {
      joD();
      AppMethodBeat.o(34266);
      return;
    }
    bL(paramcc);
    if ((paramcc.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.aw(paramcc))) {
      aBC(paramInt + 1);
    }
    bN(true, false);
    AppMethodBeat.o(34266);
  }
  
  public final void bAx(String paramString)
  {
    AppMethodBeat.i(34262);
    Log.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.aefb) });
    if ((this.aefb) || (this.context == null))
    {
      AppMethodBeat.o(34262);
      return;
    }
    this.NBt = paramString;
    if (this.NBt == null) {
      this.NBt = "";
    }
    this.aeeR = new LinkedList();
    this.nJm = false;
    joE();
    this.aeeT = -1L;
    this.xCR = false;
    this.lastShakeTime = -1L;
    this.auto = false;
    this.hva = 0;
    if (this.xCQ != null) {
      this.xCQ.b(this.aefg);
    }
    if (au.bwm(paramString)) {
      this.hva = 1;
    }
    for (this.xCQ = new com.tencent.mm.audio.a.a(this.context, 1);; this.xCQ = new com.tencent.mm.audio.a.a(this.context, 0))
    {
      this.xCQ.a(this.aefg);
      AppMethodBeat.o(34262);
      return;
      this.hva = 0;
    }
  }
  
  public final void bCh()
  {
    AppMethodBeat.i(34286);
    Log.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.aeff = false;
    AppMethodBeat.o(34286);
  }
  
  public final void bCi()
  {
    AppMethodBeat.i(34287);
    Log.printInfoStack("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
    this.aeff = true;
    joD();
    joz();
    try
    {
      if (this.xCV != null) {
        this.xCV.removeSensorCallBack();
      }
      if (this.xCU != null) {
        this.xCU.stopShake();
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
  
  public final void bL(cc paramcc)
  {
    AppMethodBeat.i(34265);
    if (paramcc == null)
    {
      AppMethodBeat.o(34265);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.aeeR.size() > 0)
      {
        this.aeeR.clear();
        aa.j(this.context, this.hlc.aezO.getContentView());
      }
      AppMethodBeat.o(34265);
      return;
    }
    int j = this.aeeR.size();
    int i = 0;
    while (i < j)
    {
      if (((cc)this.aeeR.get(i)).field_msgId == paramcc.field_msgId)
      {
        AppMethodBeat.o(34265);
        return;
      }
      i += 1;
    }
    if ((this.auto) || (this.aeeR.size() == 0)) {
      this.aeeR.add(paramcc);
    }
    Log.d("MicroMsg.AutoPlay", "add voice msg :" + this.aeeR.size());
    AppMethodBeat.o(34265);
  }
  
  public final void bN(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    AppMethodBeat.i(253974);
    Log.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.aeeR.size()), Boolean.valueOf(paramBoolean1) });
    if (this.aeeR.size() <= 0)
    {
      this.aefi.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(253974);
      return;
    }
    if (this.xCQ != null)
    {
      this.xCQ.el(paramBoolean1);
      this.xCQ.ek(paramBoolean1);
    }
    if (!paramBoolean2) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      LS(paramBoolean1);
      AppMethodBeat.o(253974);
      return;
    }
  }
  
  public final void c(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(34267);
    if (paramcc == null)
    {
      AppMethodBeat.o(34267);
      return;
    }
    joz();
    bh.bCz();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ban().d(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4115, Boolean.TRUE);
      joF();
      this.aeeW = aa.a(this.hlc.aezO.getActivity(), this.context.getString(R.l.gyQ), 4000L);
    }
    if ((this.xCQ.isPlaying()) && (paramcc.field_msgId == this.aeeT))
    {
      joD();
      AppMethodBeat.o(34267);
      return;
    }
    bL(paramcc);
    if ((paramcc.field_isSend == 0) && (!com.tencent.mm.modelvoice.s.aw(paramcc))) {
      aBC(paramInt + 1);
    }
    bN(true, false);
    AppMethodBeat.o(34267);
  }
  
  public final void gY(boolean paramBoolean)
  {
    AppMethodBeat.i(34280);
    Log.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(34280);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(34277);
    boolean bool = this.xCQ.isPlaying();
    AppMethodBeat.o(34277);
    return bool;
  }
  
  public final void joA()
  {
    AppMethodBeat.i(34269);
    this.nJm = false;
    bN(true, false);
    AppMethodBeat.o(34269);
  }
  
  public final void joC()
  {
    AppMethodBeat.i(34273);
    if ((this.xCQ != null) && (this.xCQ.isPlaying()))
    {
      Log.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.xCR), Boolean.valueOf(this.xCQ.isPlaying()) });
      this.xCQ.ed(this.xCR);
    }
    AppMethodBeat.o(34273);
  }
  
  public final void joD()
  {
    AppMethodBeat.i(34275);
    Log.i("MicroMsg.AutoPlay", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    joE();
    this.xCQ.el(true);
    this.xCQ.stop();
    this.aeeS = null;
    AppMethodBeat.o(34275);
  }
  
  public final void joF()
  {
    AppMethodBeat.i(34285);
    if (this.aeeW != null) {
      this.aeeW.dismiss();
    }
    AppMethodBeat.o(34285);
  }
  
  public final void joz()
  {
    AppMethodBeat.i(34263);
    if (1 == Log.getLogLevel()) {
      Log.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { Util.getStack() });
    }
    if (this.aeeU != null) {
      this.aeeU.dismiss();
    }
    this.aeeR.clear();
    AppMethodBeat.o(34263);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(34278);
    Log.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.xCR), Long.valueOf(this.aeeT), Long.valueOf(this.aefd) });
    com.tencent.mm.plugin.report.service.h.OAn.b(15160, new Object[] { Long.valueOf(this.aeeT), Long.valueOf(this.aefd), Long.valueOf(this.aefd), Integer.valueOf(0) });
    if (this.context != null)
    {
      Log.i("MicroMsg.AutoPlay", "stop play complete");
      MMEntryLock.unlock("keep_app_silent");
      this.aeeV.releaseWakeLock();
      joB();
      if (this.aeeR.isEmpty())
      {
        this.xCV.removeSensorCallBack();
        this.xCU.stopShake();
      }
      dcZ();
      this.aeeT = -1L;
      joF();
      this.aeeV.releaseWakeLock();
      if (this.aeeY) {
        bN(false, false);
      }
    }
    AppMethodBeat.o(34278);
  }
  
  public final void onSensorEvent(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(34282);
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.xCT + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(34282);
        return;
      }
    }
    if (this.context == null)
    {
      this.xCV.removeSensorCallBack();
      AppMethodBeat.o(34282);
      return;
    }
    Log.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(34282);
      return;
    }
    this.xCT = false;
    if (this.xCQ.isCalling())
    {
      AppMethodBeat.o(34282);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.cTX())
    {
      joF();
      Log.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(34282);
      return;
    }
    if (this.aeeV.xCS)
    {
      LT(false);
      if (this.aeeT != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.aefb = paramBoolean;; this.aefb = true)
      {
        joC();
        AppMethodBeat.o(34282);
        return;
        setScreenEnable(true);
      }
    }
    if (this.aeeT != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(34282);
        return;
      }
      setScreenEnable(paramBoolean);
      this.aefb = paramBoolean;
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34260);
          if (!paramBoolean)
          {
            Log.i("MicroMsg.AutoPlay", "speaker off");
            d.this.LT(false);
            d locald = d.this;
            if (locald.xCQ.isPlaying())
            {
              Log.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              locald.xCQ.el(false);
              locald.bN(false, true);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(34260);
            return false;
            Log.i("MicroMsg.AutoPlay", "speaker true");
            d.e(d.this);
            if (d.f(d.this) != null) {
              d.a(d.this, aa.a(d.d(d.this).aezO.getActivity(), d.f(d.this).getString(R.l.gIH), 2000L));
            }
            d.this.LT(true);
            d.this.joC();
          }
        }
      }, false).startTimer(50L);
    }
    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.aefb) });
    AppMethodBeat.o(34282);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(34281);
    Log.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.aeeT), Long.valueOf(this.aefd), Long.valueOf(Util.milliSecondsToNow(this.aefc)), Boolean.valueOf(this.aeff), Boolean.valueOf(this.aefe), Util.getStack() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.aeeT > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      l1 = this.aeeT;
      l2 = this.aefd;
      l3 = Util.milliSecondsToNow(this.aefc);
      if (this.aeff) {
        break label255;
      }
      if (!this.aefe) {}
    }
    label255:
    for (i = 1;; i = 3)
    {
      localh.b(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.aeff = false;
      this.aefe = false;
      this.aeeV.releaseWakeLock();
      joE();
      joB();
      if (this.aeeR.isEmpty())
      {
        this.xCV.removeSensorCallBack();
        this.xCU.stopShake();
      }
      dcZ();
      this.aeeT = -1L;
      joF();
      this.aefb = false;
      setScreenEnable(true);
      AppMethodBeat.o(34281);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(34274);
    Log.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.xCU != null) {
      this.xCU.stopShake();
    }
    AppMethodBeat.o(34274);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */