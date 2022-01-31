package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.ah.h.c;
import com.tencent.mm.ah.h.d;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.b.aq;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements h.a, h.b, h.c, h.d, f.a, ae, com.tencent.mm.modelvoice.c, SensorController.a
{
  private static SensorController iah;
  private int bBt;
  private boolean bBv = false;
  public com.tencent.mm.ui.chatting.c.a byx;
  public Context context;
  public boolean iak;
  private bb ial;
  long iam = -1L;
  private boolean iar = false;
  boolean isRecording = false;
  public com.tencent.mm.ah.h jZC;
  private o vhA;
  aq vhB;
  public o vhC;
  public boolean vhD;
  public boolean vhE = true;
  public boolean vhF = false;
  private long vhG = 0L;
  private long vhH = 0L;
  public boolean vhI = false;
  private boolean vhJ = false;
  public com.tencent.mm.sdk.b.c vhK = new d.1(this);
  private ah vhL = new d.2(this, Looper.getMainLooper());
  private ah vhM = new d.3(this, Looper.getMainLooper());
  private List<bi> vhy;
  public long vhz = -1L;
  
  public d(com.tencent.mm.ui.chatting.c.a parama, aq paramaq, String paramString)
  {
    this.context = parama.vtz.getContext();
    this.byx = parama;
    this.vhB = paramaq;
    if (iah == null) {
      iah = new SensorController(this.context.getApplicationContext());
    }
    if (this.ial == null) {
      this.ial = new bb(this.context.getApplicationContext());
    }
    adm(paramString);
    com.tencent.mm.sdk.b.a.udP.c(this.vhK);
    au.tu().a(this);
  }
  
  private void axW()
  {
    ai.d(new d.5(this));
  }
  
  private void cBY()
  {
    int k = this.vhy.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((bi)this.vhy.get(i)).field_msgId != this.vhz) {
        break label98;
      }
      j = i;
    }
    label98:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.vhy.remove(j);
      }
      y.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.vhy.size());
      return;
    }
  }
  
  private boolean isScreenEnable()
  {
    if (this.byx != null) {
      return this.byx.vtz.getController().uMD;
    }
    return false;
  }
  
  public final void D(bi parambi)
  {
    if ((this.vhE) && (this.vhy.isEmpty())) {}
    do
    {
      do
      {
        return;
      } while ((parambi == null) || (!parambi.ctA()) || (parambi.field_isSend == 1) || (parambi.field_talker == null) || (!parambi.field_talker.equals(this.byx.getTalkerUserName())) || (!au.Dk().foreground) || (!this.byx.euf));
      if (q.G(parambi))
      {
        y.e("MicroMsg.AutoPlay", "should not in this route");
        return;
      }
      an(parambi);
    } while ((this.isRecording) || (this.jZC.isPlaying()) || (!bk.bU(this.context)));
    ni(true);
  }
  
  public final void GI(int paramInt)
  {
    for (;;)
    {
      if (this.context == null) {
        y.e("MicroMsg.AutoPlay", "context is null");
      }
      bi localbi;
      do
      {
        int i;
        do
        {
          return;
          if (this.byx == null)
          {
            y.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
            return;
          }
          i = ((g)this.byx.ac(g.class)).getCount();
          y.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + i);
        } while ((paramInt < 0) || (paramInt >= i));
        localbi = ((g)this.byx.ac(g.class)).GW(paramInt);
      } while (localbi == null);
      if ((localbi.ctA()) && (localbi.field_isSend == 0) && (!q.F(localbi)) && (!q.G(localbi))) {
        an(localbi);
      }
      paramInt += 1;
    }
  }
  
  public final void Hf()
  {
    y.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    this.vhJ = false;
  }
  
  public final void Hg()
  {
    y.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
    this.vhJ = true;
    cCb();
    cBW();
    try
    {
      if (iah != null) {
        iah.crJ();
      }
      if (this.ial != null) {
        this.ial.crK();
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AutoPlay", localException, "reset sensor error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void a(int paramInt, bi parambi)
  {
    if (parambi == null) {
      return;
    }
    cBW();
    au.Hx();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Dz().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(4115, Boolean.valueOf(true));
      cCc();
      this.vhC = com.tencent.mm.ui.base.s.a(this.byx.vtz.getActivity(), this.context.getString(R.l.chatting_music_volumn_change), 4000L);
    }
    if ((this.jZC.isPlaying()) && (parambi.field_msgId == this.vhz))
    {
      cCb();
      return;
    }
    an(parambi);
    if ((parambi.field_isSend == 0) && (!q.F(parambi))) {
      GI(paramInt + 1);
    }
    ni(true);
  }
  
  public final void adm(String paramString)
  {
    y.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.vhF) });
    if ((this.vhF) || (this.context == null)) {
      return;
    }
    this.vhy = new LinkedList();
    this.isRecording = false;
    this.vhz = -1L;
    this.iak = false;
    this.iam = -1L;
    this.vhD = false;
    this.bBt = 0;
    if (com.tencent.mm.model.s.hH(paramString))
    {
      this.bBt = 1;
      this.jZC = new com.tencent.mm.f.a.a(this.context, 1);
      return;
    }
    this.bBt = 0;
    this.jZC = new com.tencent.mm.f.a.a(this.context, 0);
  }
  
  public final void an(bi parambi)
  {
    if (parambi == null) {}
    do
    {
      return;
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        break;
      }
    } while (this.vhy.size() <= 0);
    this.vhy.clear();
    com.tencent.mm.ui.base.s.gM(this.context);
    return;
    int j = this.vhy.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label92;
      }
      if (((bi)this.vhy.get(i)).field_msgId == parambi.field_msgId) {
        break;
      }
      i += 1;
    }
    label92:
    if ((this.vhD) || (this.vhy.size() == 0)) {
      this.vhy.add(parambi);
    }
    y.d("MicroMsg.AutoPlay", "add voice msg :" + this.vhy.size());
  }
  
  public final void b(int paramInt, bi parambi)
  {
    if (parambi == null) {
      return;
    }
    cBW();
    au.Hx();
    Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Dz().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(4115, Boolean.valueOf(true));
      cCc();
      this.vhC = com.tencent.mm.ui.base.s.a(this.byx.vtz.getActivity(), this.context.getString(R.l.chatting_music_volumn_change), 4000L);
    }
    if ((this.jZC.isPlaying()) && (parambi.field_msgId == this.vhz))
    {
      cCb();
      return;
    }
    an(parambi);
    if ((parambi.field_isSend == 0) && (!q.F(parambi))) {
      GI(paramInt + 1);
    }
    ni(true);
  }
  
  public final void bL(boolean paramBoolean)
  {
    y.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    onStop();
  }
  
  public final void cBW()
  {
    y.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { bk.csb() });
    if (this.vhA != null) {
      this.vhA.dismiss();
    }
    this.vhy.clear();
  }
  
  public final void cBX()
  {
    this.isRecording = false;
    ni(true);
  }
  
  public final void cBZ()
  {
    int i;
    bi localbi;
    try
    {
      y.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.vhy.size());
      if (this.vhy.size() <= 0)
      {
        this.vhL.sendEmptyMessageDelayed(0, 1000L);
        return;
      }
      long l = ((bi)this.vhy.get(0)).field_createTime;
      int k = this.vhy.size();
      i = 1;
      int j = 0;
      if (i < k)
      {
        if (l <= ((bi)this.vhy.get(i)).field_createTime) {
          break label849;
        }
        l = ((bi)this.vhy.get(i)).field_createTime;
        j = i;
        break label853;
      }
      localbi = (bi)this.vhy.get(j);
      if (localbi == null) {
        break label852;
      }
      if (localbi == null) {
        break label323;
      }
      if ((localbi.ctA()) || (localbi.cvs()) || (localbi.cvt())) {
        break label860;
      }
      if (!localbi.cvu()) {
        break label323;
      }
    }
    catch (Exception localException)
    {
      label197:
      d.4 local4;
      y.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
      return;
    }
    Assert.assertTrue(bool1);
    y.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(localbi.field_msgId) });
    if (!iah.uil)
    {
      iah.a(this);
      local4 = new d.4(this);
      if (!this.ial.W(local4)) {
        break label329;
      }
      this.iam = 0L;
    }
    label323:
    label329:
    Object localObject;
    for (;;)
    {
      au.Hx();
      if ((!com.tencent.mm.model.c.isSDCardAvailable()) && (!bk.bl(localbi.field_imgPath)))
      {
        this.vhy.clear();
        com.tencent.mm.ui.base.s.gM(this.context);
        return;
        bool1 = false;
        break;
        this.iam = -1L;
        continue;
      }
      au.Hx();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) && (this.vhB.ian))
      {
        if (this.vhA != null) {
          this.vhA.dismiss();
        }
        bool1 = f.yi().yt();
        boolean bool2 = f.yi().yn();
        y.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bool1) && (bool2)) {
          this.vhA = com.tencent.mm.ui.base.s.a(this.byx.vtz.getActivity(), R.k.tipsbar_bluetooth_icon, this.context.getString(R.l.chatfooter_SpeakerOff_bluetooth_now));
        }
      }
      else
      {
        ag.Zm("keep_app_silent");
        q.H(localbi);
        this.jZC.stop(true);
        this.vhB.acquireWakeLock();
        if ((f.yi().yt()) || (f.yi().yn()))
        {
          y.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(f.yi().yt()), Boolean.valueOf(f.yi().yn()) });
          this.iak = false;
        }
        localObject = localbi.field_imgPath;
        if (this.bBt != 1) {
          break label779;
        }
        localObject = com.tencent.mm.plugin.subapp.c.h.bh((String)localObject, false);
        label568:
        y.i("MicroMsg.AutoPlay", "startplay");
        bool1 = q.oE(localbi.field_imgPath);
        if (!bool1) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 175L, 1L, false);
        }
        if ((!bool1) || (!this.jZC.a((String)localObject, this.iak, true, -1))) {
          break label789;
        }
        localObject = this.jZC;
        if (this.vhy.size() <= 1) {
          break label866;
        }
      }
    }
    label779:
    label789:
    label849:
    label852:
    label853:
    label860:
    label866:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ah.h)localObject).aW(bool1);
      this.jZC.a(this);
      this.jZC.a(this);
      this.jZC.a(this);
      this.jZC.a(this);
      this.vhz = localbi.field_msgId;
      this.vhH = new n(localbi.field_content).time;
      this.vhG = System.currentTimeMillis();
      for (;;)
      {
        axW();
        this.vhF = false;
        return;
        this.vhA = com.tencent.mm.ui.base.s.a(this.byx.vtz.getActivity(), R.k.tipsbar_receiver_icon, this.context.getString(R.l.chatfooter_SpeakerOff_now));
        break;
        localObject = q.getFullPath((String)localObject);
        break label568;
        this.vhz = -1L;
        if (this.bBv)
        {
          f.yi().yl();
          this.bBv = false;
        }
        f.yi().b(this);
        cBW();
        Toast.makeText(this.context, this.context.getString(R.l.chatting_play_err), 0).show();
      }
      break label853;
      return;
      i += 1;
      break;
      bool1 = true;
      break label197;
    }
  }
  
  public final void cCa()
  {
    if ((this.jZC != null) && (this.jZC.isPlaying()))
    {
      y.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.iak), Boolean.valueOf(this.jZC.isPlaying()) });
      this.jZC.aV(this.iak);
    }
  }
  
  public final void cCb()
  {
    y.i("MicroMsg.AutoPlay", "stop play");
    ag.Zn("keep_app_silent");
    this.jZC.stop();
  }
  
  public final void cCc()
  {
    if (this.vhC != null) {
      this.vhC.dismiss();
    }
  }
  
  public final void eq(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.iar + " tick:" + bk.cp(this.iam) + "  lt:" + this.iam);
    if (this.iar) {
      if (!paramBoolean)
      {
        paramBoolean = bool;
        this.iar = paramBoolean;
      }
    }
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        if (this.context == null)
        {
          iah.crJ();
          return;
        }
        y.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(isScreenEnable()) });
        if ((!paramBoolean) && (this.iam != -1L) && (bk.cp(this.iam) > 400L))
        {
          this.iar = true;
          return;
        }
        this.iar = false;
      } while (this.jZC.uc());
      if (au.Hy().yn())
      {
        cCc();
        y.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
        return;
      }
      if (this.vhB.ian)
      {
        this.iak = false;
        if (this.vhz != -1L) {
          setScreenEnable(paramBoolean);
        }
        for (this.vhF = paramBoolean;; this.vhF = true)
        {
          cCa();
          return;
          setScreenEnable(true);
        }
      }
      if (this.vhz == -1L) {
        break label309;
      }
    } while (isScreenEnable() == paramBoolean);
    setScreenEnable(paramBoolean);
    this.vhF = paramBoolean;
    new am(new d.6(this, paramBoolean), false).S(50L, 50L);
    label309:
    y.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.vhF) });
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bBv) });
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.vhM.hasMessages(0));
      this.vhM.removeMessages(0);
      this.vhM.sendEmptyMessage(0);
      return;
      if (this.vhM.hasMessages(0)) {
        this.vhM.removeMessages(0);
      }
    } while (!this.bBv);
    f.yi().yl();
    this.bBv = false;
  }
  
  public final boolean isPlaying()
  {
    return this.jZC.isPlaying();
  }
  
  public final void ni(boolean paramBoolean)
  {
    y.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", new Object[] { Integer.valueOf(this.vhy.size()), Boolean.valueOf(paramBoolean) });
    if (this.vhy.size() <= 0)
    {
      this.vhL.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    if (!f.yi().yt())
    {
      f.yi();
      if (f.yq())
      {
        f.yi().a(this);
        int i = f.yi().yk();
        this.bBv = true;
        if ((i != -1) && (i != 0))
        {
          y.i("MicroMsg.AutoPlay", "play next: ret = " + i);
          this.vhM.sendEmptyMessageDelayed(0, 1000L);
          return;
        }
      }
    }
    if (this.jZC != null) {
      this.jZC.aT(paramBoolean);
    }
    cBZ();
  }
  
  public final void onError()
  {
    y.e("MicroMsg.AutoPlay", "voice play error");
    cCb();
    ni(true);
  }
  
  public final void onStop()
  {
    int i = 1;
    y.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[] { Long.valueOf(this.vhz), Long.valueOf(this.vhH), Long.valueOf(bk.co(this.vhG)), Boolean.valueOf(this.vhJ), Boolean.valueOf(this.vhI), bk.csb() });
    com.tencent.mm.plugin.report.service.h localh;
    long l1;
    long l2;
    long l3;
    if (this.vhz > 0L)
    {
      localh = com.tencent.mm.plugin.report.service.h.nFQ;
      l1 = this.vhz;
      l2 = this.vhH;
      l3 = bk.co(this.vhG);
      if (this.vhJ) {
        break label261;
      }
      if (!this.vhI) {
        break label256;
      }
    }
    for (;;)
    {
      localh.f(15160, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
      this.vhJ = false;
      this.vhI = false;
      this.vhB.releaseWakeLock();
      cBY();
      if (this.bBv)
      {
        f.yi().yl();
        this.bBv = false;
      }
      f.yi().b(this);
      if (this.vhy.isEmpty())
      {
        iah.crJ();
        this.ial.crK();
      }
      axW();
      this.vhz = -1L;
      cCc();
      this.vhF = false;
      return;
      label256:
      i = 2;
      continue;
      label261:
      i = 3;
    }
  }
  
  public final void release()
  {
    y.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.ial != null) {
      this.ial.crK();
    }
  }
  
  final void setScreenEnable(boolean paramBoolean)
  {
    if (this.byx != null) {
      this.byx.vtz.getController().setScreenEnable(paramBoolean);
    }
  }
  
  public final void ug()
  {
    y.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[] { Boolean.valueOf(this.iak), Long.valueOf(this.vhz), Long.valueOf(this.vhH) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(15160, new Object[] { Long.valueOf(this.vhz), Long.valueOf(this.vhH), Long.valueOf(this.vhH), Integer.valueOf(0) });
    if (this.context != null)
    {
      y.i("MicroMsg.AutoPlay", "stop play complete");
      ag.Zn("keep_app_silent");
      this.vhB.releaseWakeLock();
      cBY();
      if ((this.vhy.isEmpty()) && (this.bBv))
      {
        f.yi().yl();
        this.bBv = false;
      }
      f.yi().b(this);
      if (this.vhy.isEmpty())
      {
        iah.crJ();
        this.ial.crK();
      }
      axW();
      this.vhz = -1L;
      cCc();
      this.vhB.releaseWakeLock();
      ni(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d
 * JD-Core Version:    0.7.0.1
 */