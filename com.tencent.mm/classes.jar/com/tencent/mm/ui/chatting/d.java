package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.h.c;
import com.tencent.mm.ai.h.d;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.af;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.c.as;
import com.tencent.mm.ui.q;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements h.a, h.b, h.c, h.d, g.a, af, com.tencent.mm.modelvoice.c, SensorController.a
{
  private static SensorController mub;
  public com.tencent.mm.ui.chatting.d.a caz;
  private int cii;
  private boolean cik;
  public Context context;
  boolean isRecording;
  long lastShakeTime;
  public com.tencent.mm.ai.h mtU;
  public boolean mtV;
  private boolean mtX;
  private bf mtY;
  private long zwA;
  private long zwB;
  public boolean zwC;
  private boolean zwD;
  public com.tencent.mm.sdk.b.c zwE;
  private ak zwF;
  private ak zwG;
  private List<bi> zws;
  public long zwt;
  private o zwu;
  as zwv;
  public o zww;
  public boolean zwx;
  public boolean zwy;
  public boolean zwz;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, as paramas, String paramString)
  {
    AppMethodBeat.i(30411);
    this.isRecording = false;
    this.zwt = -1L;
    this.lastShakeTime = -1L;
    this.zwy = true;
    this.zwz = false;
    this.cik = false;
    this.zwA = 0L;
    this.zwB = 0L;
    this.zwC = false;
    this.zwD = false;
    this.zwE = new com.tencent.mm.sdk.b.c() {};
    this.zwF = new d.2(this, Looper.getMainLooper());
    this.zwG = new d.3(this, Looper.getMainLooper());
    this.mtX = false;
    this.context = parama.zJz.getContext();
    this.caz = parama;
    this.zwv = paramas;
    if (mub == null) {
      mub = new SensorController(this.context.getApplicationContext());
    }
    if (this.mtY == null) {
      this.mtY = new bf(this.context.getApplicationContext());
    }
    atI(paramString);
    com.tencent.mm.sdk.b.a.ymk.c(this.zwE);
    aw.BY().a(this);
    AppMethodBeat.o(30411);
  }
  
  private void aWN()
  {
    AppMethodBeat.i(30426);
    al.d(new d.5(this));
    AppMethodBeat.o(30426);
  }
  
  private void dFK()
  {
    AppMethodBeat.i(30420);
    int k = this.zws.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bi)this.zws.get(i)).field_msgId != this.zwt) {
        break label110;
      }
      j = i;
    }
    label110:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.zws.remove(j);
      }
      ab.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.zws.size());
      AppMethodBeat.o(30420);
      return;
    }
  }
  
  private boolean isScreenEnable()
  {
    AppMethodBeat.i(30434);
    if (this.caz != null)
    {
      boolean bool = this.caz.zJz.getController().zaC;
      AppMethodBeat.o(30434);
      return bool;
    }
    AppMethodBeat.o(30434);
    return false;
  }
  
  private void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(30433);
    if (this.caz != null) {
      this.caz.zJz.getController().setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(30433);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(30428);
    ab.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.mtV), Long.valueOf(this.zwt), Long.valueOf(this.zwB) });
    com.tencent.mm.plugin.report.service.h.qsU.e(15160, new Object[] { Long.valueOf(this.zwt), Long.valueOf(this.zwB), Long.valueOf(this.zwB), Integer.valueOf(0) });
    if (this.context != null)
    {
      ab.i("MicroMsg.AutoPlay", "stop play complete");
      aj.apl("keep_app_silent");
      this.zwv.releaseWakeLock();
      dFK();
      if ((this.zws.isEmpty()) && (this.cik))
      {
        g.KC().KF();
        this.cik = false;
      }
      g.KC().b(this);
      if (this.zws.isEmpty())
      {
        mub.dtJ();
        this.mtY.dtK();
      }
      aWN();
      this.zwt = -1L;
      dFO();
      this.zwv.releaseWakeLock();
      qR(false);
    }
    AppMethodBeat.o(30428);
  }
  
  public final void J(bi parambi)
  {
    AppMethodBeat.i(30418);
    if ((this.zwy) && (this.zws.isEmpty()))
    {
      AppMethodBeat.o(30418);
      return;
    }
    if ((parambi == null) || (!parambi.dvW()) || (parambi.field_isSend == 1))
    {
      AppMethodBeat.o(30418);
      return;
    }
    if ((parambi.field_talker == null) || (!parambi.field_talker.equals(this.caz.getTalkerUserName())))
    {
      AppMethodBeat.o(30418);
      return;
    }
    if ((!aw.Rc().foreground) || (!this.caz.bSe))
    {
      AppMethodBeat.o(30418);
      return;
    }
    if (s.L(parambi))
    {
      ab.e("MicroMsg.AutoPlay", "should not in this route");
      AppMethodBeat.o(30418);
      return;
    }
    av(parambi);
    if ((!this.isRecording) && (!this.mtU.isPlaying()) && (bo.cB(this.context))) {
      qR(true);
    }
    AppMethodBeat.o(30418);
  }
  
  public final void Ph(int paramInt)
  {
    AppMethodBeat.i(30414);
    for (;;)
    {
      if (this.context == null)
      {
        ab.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(30414);
        return;
      }
      if (this.caz == null)
      {
        ab.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
        AppMethodBeat.o(30414);
        return;
      }
      int i = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).getCount();
      ab.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
      if ((paramInt < 0) || (paramInt >= i))
      {
        AppMethodBeat.o(30414);
        return;
      }
      bi localbi = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).Pz(paramInt);
      if (localbi == null)
      {
        AppMethodBeat.o(30414);
        return;
      }
      if ((localbi.dvW()) && (localbi.field_isSend == 0) && (!s.K(localbi)) && (!s.L(localbi))) {
        av(localbi);
      }
      paramInt += 1;
    }
  }
  
  public final void a(int paramInt, bi parambi)
  {
    AppMethodBeat.i(30416);
    if (parambi == null)
    {
      AppMethodBeat.o(30416);
      return;
    }
    dFI();
    aw.aaz();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Ru().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4115, Boolean.TRUE);
      dFO();
      this.zww = com.tencent.mm.ui.base.t.a(this.caz.zJz.getActivity(), this.context.getString(2131298264), 4000L);
    }
    if ((this.mtU.isPlaying()) && (parambi.field_msgId == this.zwt))
    {
      dFN();
      AppMethodBeat.o(30416);
      return;
    }
    av(parambi);
    if ((parambi.field_isSend == 0) && (!s.K(parambi))) {
      Ph(paramInt + 1);
    }
    qR(true);
    AppMethodBeat.o(30416);
  }
  
  public final void aah()
  {
    AppMethodBeat.i(30436);
    ab.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.zwD = false;
    AppMethodBeat.o(30436);
  }
  
  public final void aai()
  {
    AppMethodBeat.i(30437);
    ab.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
    this.zwD = true;
    dFN();
    dFI();
    try
    {
      if (mub != null) {
        mub.dtJ();
      }
      if (this.mtY != null) {
        this.mtY.dtK();
      }
      AppMethodBeat.o(30437);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(30437);
    }
  }
  
  public final void atI(String paramString)
  {
    AppMethodBeat.i(30412);
    ab.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.zwz) });
    if ((this.zwz) || (this.context == null))
    {
      AppMethodBeat.o(30412);
      return;
    }
    this.zws = new LinkedList();
    this.isRecording = false;
    this.zwt = -1L;
    this.mtV = false;
    this.lastShakeTime = -1L;
    this.zwx = false;
    this.cii = 0;
    if (com.tencent.mm.model.t.oq(paramString))
    {
      this.cii = 1;
      this.mtU = new com.tencent.mm.audio.a.a(this.context, 1);
      AppMethodBeat.o(30412);
      return;
    }
    this.cii = 0;
    this.mtU = new com.tencent.mm.audio.a.a(this.context, 0);
    AppMethodBeat.o(30412);
  }
  
  public final void av(bi parambi)
  {
    AppMethodBeat.i(30415);
    if (parambi == null)
    {
      AppMethodBeat.o(30415);
      return;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (this.zws.size() > 0)
      {
        this.zws.clear();
        com.tencent.mm.ui.base.t.ii(this.context);
      }
      AppMethodBeat.o(30415);
      return;
    }
    int j = this.zws.size();
    int i = 0;
    while (i < j)
    {
      if (((bi)this.zws.get(i)).field_msgId == parambi.field_msgId)
      {
        AppMethodBeat.o(30415);
        return;
      }
      i += 1;
    }
    if ((this.zwx) || (this.zws.size() == 0)) {
      this.zws.add(parambi);
    }
    ab.d("MicroMsg.AutoPlay", "add voice msg :" + this.zws.size());
    AppMethodBeat.o(30415);
  }
  
  public final void b(int paramInt, bi parambi)
  {
    AppMethodBeat.i(30417);
    if (parambi == null)
    {
      AppMethodBeat.o(30417);
      return;
    }
    dFI();
    aw.aaz();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Ru().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4115, Boolean.TRUE);
      dFO();
      this.zww = com.tencent.mm.ui.base.t.a(this.caz.zJz.getActivity(), this.context.getString(2131298264), 4000L);
    }
    if ((this.mtU.isPlaying()) && (parambi.field_msgId == this.zwt))
    {
      dFN();
      AppMethodBeat.o(30417);
      return;
    }
    av(parambi);
    if ((parambi.field_isSend == 0) && (!s.K(parambi))) {
      Ph(paramInt + 1);
    }
    qR(true);
    AppMethodBeat.o(30417);
  }
  
  public final void cN(boolean paramBoolean)
  {
    AppMethodBeat.i(30430);
    ab.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
    AppMethodBeat.o(30430);
  }
  
  public final void dFI()
  {
    AppMethodBeat.i(30413);
    if (1 == ab.getLogLevel()) {
      ab.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bo.dtY() });
    }
    if (this.zwu != null) {
      this.zwu.dismiss();
    }
    this.zws.clear();
    AppMethodBeat.o(30413);
  }
  
  public final void dFJ()
  {
    AppMethodBeat.i(30419);
    this.isRecording = false;
    qR(true);
    AppMethodBeat.o(30419);
  }
  
  public final void dFL()
  {
    AppMethodBeat.i(30422);
    int i;
    bi localbi;
    try
    {
      ab.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.zws.size());
      if (this.zws.size() <= 0)
      {
        this.zwF.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(30422);
        return;
      }
      long l = ((bi)this.zws.get(0)).field_createTime;
      int k = this.zws.size();
      i = 1;
      int j = 0;
      if (i < k)
      {
        if (l <= ((bi)this.zws.get(i)).field_createTime) {
          break label879;
        }
        l = ((bi)this.zws.get(i)).field_createTime;
        j = i;
        break label879;
      }
      localbi = (bi)this.zws.get(j);
      if (localbi == null) {
        break label769;
      }
      if (localbi == null) {
        break label347;
      }
      if ((localbi.dvW()) || (localbi.dxW()) || (localbi.dxX())) {
        break label886;
      }
      if (!localbi.dxY()) {
        break label347;
      }
    }
    catch (Exception localException)
    {
      label209:
      d.4 local4;
      ab.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
      AppMethodBeat.o(30422);
      return;
    }
    Assert.assertTrue(bool1);
    ab.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(localbi.field_msgId) });
    if (!mub.yqq)
    {
      mub.a(this);
      local4 = new d.4(this);
      if (!this.mtY.ai(local4)) {
        break label353;
      }
    }
    label347:
    label353:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      aw.aaz();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bo.isNullOrNil(localbi.field_imgPath))) {
        break label363;
      }
      this.zws.clear();
      com.tencent.mm.ui.base.t.ii(this.context);
      AppMethodBeat.o(30422);
      return;
      bool1 = false;
      break;
    }
    label363:
    aw.aaz();
    Object localObject;
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.zwv.mtW))
    {
      if (this.zwu != null) {
        this.zwu.dismiss();
      }
      bool1 = g.KC().KN();
      boolean bool2 = g.KC().KH();
      ab.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        this.zwu = com.tencent.mm.ui.base.t.a(this.caz.zJz.getActivity(), 2131232083, this.context.getString(2131298108));
      }
    }
    else
    {
      aj.apk("keep_app_silent");
      s.M(localbi);
      this.mtU.stop(true);
      this.zwv.acquireWakeLock();
      if ((g.KC().KN()) || (g.KC().KH()))
      {
        ab.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(g.KC().KN()), Boolean.valueOf(g.KC().KH()) });
        this.mtV = false;
      }
      localObject = localbi.field_imgPath;
      if (this.cii != 1) {
        break label809;
      }
      localObject = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject, false);
      label592:
      ab.i("MicroMsg.AutoPlay", "startplay");
      bool1 = s.vR(localbi.field_imgPath);
      if (!bool1) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 175L, 1L, false);
      }
      if ((!bool1) || (!this.mtU.a((String)localObject, this.mtV, true, -1))) {
        break label819;
      }
      localObject = this.mtU;
      if (this.zws.size() <= 1) {
        break label892;
      }
    }
    label769:
    label809:
    label819:
    label879:
    label886:
    label892:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ai.h)localObject).by(bool1);
      this.mtU.a(this);
      this.mtU.a(this);
      this.mtU.a(this);
      this.mtU.a(this);
      this.zwt = localbi.field_msgId;
      this.zwB = new com.tencent.mm.modelvoice.p(localbi.field_content).time;
      this.zwA = System.currentTimeMillis();
      for (;;)
      {
        aWN();
        this.zwz = false;
        AppMethodBeat.o(30422);
        return;
        this.zwu = com.tencent.mm.ui.base.t.a(this.caz.zJz.getActivity(), 2131232096, this.context.getString(2131298109));
        break;
        localObject = s.getFullPath((String)localObject);
        break label592;
        this.zwt = -1L;
        if (this.cik)
        {
          g.KC().KF();
          this.cik = false;
        }
        g.KC().b(this);
        dFI();
        Toast.makeText(this.context, this.context.getString(2131298283), 0).show();
      }
      i += 1;
      break;
      bool1 = true;
      break label209;
    }
  }
  
  public final void dFM()
  {
    AppMethodBeat.i(30423);
    if ((this.mtU != null) && (this.mtU.isPlaying()))
    {
      ab.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.mtV), Boolean.valueOf(this.mtU.isPlaying()) });
      this.mtU.bx(this.mtV);
    }
    AppMethodBeat.o(30423);
  }
  
  public final void dFN()
  {
    AppMethodBeat.i(30425);
    ab.i("MicroMsg.AutoPlay", "stop play");
    aj.apl("keep_app_silent");
    this.mtU.bv(true);
    this.mtU.stop();
    AppMethodBeat.o(30425);
  }
  
  public final void dFO()
  {
    AppMethodBeat.i(30435);
    if (this.zww != null) {
      this.zww.dismiss();
    }
    AppMethodBeat.o(30435);
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(30438);
    ab.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.cik) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30438);
      return;
      if (this.zwG.hasMessages(0))
      {
        this.zwG.removeMessages(0);
        this.zwG.sendEmptyMessage(0);
        AppMethodBeat.o(30438);
        return;
        if (this.zwG.hasMessages(0)) {
          this.zwG.removeMessages(0);
        }
        if (this.cik)
        {
          g.KC().KF();
          this.cik = false;
          AppMethodBeat.o(30438);
          return;
          g.KC().KE();
        }
      }
    }
  }
  
  public final void hv(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(30432);
    ab.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.mtX + " tick:" + bo.av(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.mtX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.mtX = paramBoolean;
        AppMethodBeat.o(30432);
        return;
      }
    }
    if (this.context == null)
    {
      mub.dtJ();
      AppMethodBeat.o(30432);
      return;
    }
    ab.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bo.av(this.lastShakeTime) > 400L))
    {
      this.mtX = true;
      AppMethodBeat.o(30432);
      return;
    }
    this.mtX = false;
    if (this.mtU.Ep())
    {
      AppMethodBeat.o(30432);
      return;
    }
    if (aw.aaA().KH())
    {
      dFO();
      ab.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(30432);
      return;
    }
    if (this.zwv.mtW)
    {
      this.mtV = false;
      if (this.zwt != -1L) {
        setScreenEnable(paramBoolean);
      }
      for (this.zwz = paramBoolean;; this.zwz = true)
      {
        dFM();
        AppMethodBeat.o(30432);
        return;
        setScreenEnable(true);
      }
    }
    if (this.zwt != -1L)
    {
      if (isScreenEnable() == paramBoolean)
      {
        AppMethodBeat.o(30432);
        return;
      }
      setScreenEnable(paramBoolean);
      this.zwz = paramBoolean;
      new ap(new d.6(this, paramBoolean), false).ag(50L, 50L);
    }
    ab.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.zwz) });
    AppMethodBeat.o(30432);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(30427);
    boolean bool = this.mtU.isPlaying();
    AppMethodBeat.o(30427);
    return bool;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(30429);
    ab.e("MicroMsg.AutoPlay", "voice play error");
    dFN();
    qR(true);
    AppMethodBeat.o(30429);
  }
  
  public final void onStop()
  {
    int i = 2;
    AppMethodBeat.i(30431);
    ab.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.zwt), Long.valueOf(this.zwB), Long.valueOf(bo.hl(this.zwA)), Boolean.valueOf(this.zwD), Boolean.valueOf(this.zwC), bo.dtY() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.zwt > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.qsU;
      l1 = this.zwt;
      l2 = this.zwB;
      l3 = bo.hl(this.zwA);
      if (this.zwD) {
        break label275;
      }
      if (!this.zwC) {}
    }
    label275:
    for (i = 1;; i = 3)
    {
      localh.e(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.zwD = false;
      this.zwC = false;
      this.zwv.releaseWakeLock();
      dFK();
      if (this.cik)
      {
        g.KC().KF();
        this.cik = false;
      }
      g.KC().b(this);
      if (this.zws.isEmpty())
      {
        mub.dtJ();
        this.mtY.dtK();
      }
      aWN();
      this.zwt = -1L;
      dFO();
      this.zwz = false;
      setScreenEnable(true);
      AppMethodBeat.o(30431);
      return;
    }
  }
  
  public final void qR(boolean paramBoolean)
  {
    AppMethodBeat.i(30421);
    ab.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.zws.size()), Boolean.valueOf(paramBoolean) });
    if (this.zws.size() <= 0)
    {
      this.zwF.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(30421);
      return;
    }
    if (!g.KC().KN())
    {
      g.KC();
      if (g.KK())
      {
        g.KC().a(this);
        int i = g.KC().KE();
        this.cik = true;
        if ((i != -1) && (i != 0))
        {
          ab.i("MicroMsg.AutoPlay", "play next: ret = ".concat(String.valueOf(i)));
          this.zwG.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(30421);
          return;
        }
      }
    }
    if (this.mtU != null)
    {
      this.mtU.bv(paramBoolean);
      this.mtU.bu(paramBoolean);
    }
    dFL();
    AppMethodBeat.o(30421);
  }
  
  public final void release()
  {
    AppMethodBeat.i(30424);
    ab.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.mtY != null) {
      this.mtY.dtK();
    }
    AppMethodBeat.o(30424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */