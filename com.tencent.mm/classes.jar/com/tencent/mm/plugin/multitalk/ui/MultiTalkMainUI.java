package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.model.f.6;
import com.tencent.mm.plugin.multitalk.model.i;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.j.a;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.multitalk.ui.widget.f.a;
import com.tencent.mm.plugin.multitalk.ui.widget.f.b;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, com.tencent.mm.plugin.multitalk.model.b
{
  protected ak loX;
  private com.tencent.mm.plugin.multitalk.ui.widget.c oUS;
  private com.tencent.mm.plugin.multitalk.ui.widget.f oUT;
  private boolean oUU;
  private Notification oUV;
  private boolean oUW;
  private boolean oUX;
  boolean oUY;
  private MultiTalkMainUI.ScreenActionReceiver oUZ;
  private Runnable oVa;
  private boolean oVb;
  private BroadcastReceiver oVc;
  ak oVd;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(54129);
    this.oUW = true;
    this.oUX = false;
    this.oUY = false;
    this.oVa = new MultiTalkMainUI.1(this);
    this.oVc = new MultiTalkMainUI.5(this);
    this.oVd = new MultiTalkMainUI.10(this);
    AppMethodBeat.o(54129);
  }
  
  private static int bJG()
  {
    AppMethodBeat.i(54136);
    if (g.KC().KH())
    {
      int i = g.KC().KU();
      AppMethodBeat.o(54136);
      return i;
    }
    if (!p.bTF().nMJ.Dt())
    {
      AppMethodBeat.o(54136);
      return 3;
    }
    AppMethodBeat.o(54136);
    return 0;
  }
  
  public final int Ut(String paramString)
  {
    AppMethodBeat.i(54151);
    paramString = this.oUT.UD(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(54151);
      return -1;
    }
    int i = ((f.a)paramString.getTag()).oWq.getPosition();
    AppMethodBeat.o(54151);
    return i;
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(54153);
    if (parama == j.a.oUf)
    {
      p.bTD().X(this);
      AppMethodBeat.o(54153);
      return;
    }
    if (parama == j.a.oUg)
    {
      p.bTD().W(this);
      AppMethodBeat.o(54153);
      return;
    }
    if (parama == j.a.oUh) {
      com.tencent.mm.bg.e.a(this, 2131304713, null);
    }
    AppMethodBeat.o(54153);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    AppMethodBeat.i(54152);
    if (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVS)
    {
      parame = this.oUT;
      if (parame.oWn > 0L) {
        parame.oWn = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(54152);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54150);
    this.oUT.a(paramString, paramBitmap, paramInt1, paramInt2);
    AppMethodBeat.o(54150);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54149);
    if (p.bTF().bTh()) {
      this.oUT.a(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(54149);
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(54141);
    kf localkf = new kf();
    localkf.czQ.action = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localkf);
    this.oUT.jK(true);
    p.bTF().oTC = null;
    p.bTF().stopRing();
    finish();
    AppMethodBeat.o(54141);
  }
  
  public final void bIX()
  {
    AppMethodBeat.i(54154);
    Object localObject3 = this.oUT;
    Object localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).ekh;
    long l = p.bTF().oTv;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject4 = p.bTF();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject4).oTs.Bhl;
    localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject4).oTs.Bhm;
    }
    localObject1 = p.bTE().oTa.awu((String)localObject1);
    localObject2 = p.bTF().oTq;
    Object localObject5;
    if (localObject1 != null)
    {
      localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).oWg.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (f.a)((RelativeLayout)((Iterator)localObject4).next()).getTag();
        String str = ((f.a)localObject5).oWq.getUsername();
        if (((!r.Zn().equals(str)) || (!((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).bSH())) && (((List)localObject1).contains(str)) && (!((HashSet)localObject2).contains(str)))
        {
          ((f.a)localObject5).oWr.setVisibility(0);
          ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", new Object[] { str });
        }
        else
        {
          ((f.a)localObject5).oWr.setVisibility(8);
          ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", new Object[] { str });
        }
      }
    }
    localObject4 = p.bTF();
    localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject4).oTs.Bhl;
    localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject4).oTs.Bhm;
    }
    if (n.oUG == null) {
      n.oUG = new n();
    }
    localObject4 = n.oUG;
    localObject2 = new ArrayList();
    ((n)localObject4).oUH = com.tencent.wecall.talkroom.model.c.dXv().axp((String)localObject1);
    if (((n)localObject4).oUH != null)
    {
      localObject1 = ((n)localObject4).oUH.dXp().iterator();
      label519:
      label522:
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (a.av)((Iterator)localObject1).next();
        int i = ((a.av)localObject4).kJx;
        if (i >= 0)
        {
          localObject5 = new byte[4];
          if (p.bTE().oTa.setAppCmd(10, (byte[])localObject5, i) < 0)
          {
            ab.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
            i = -1;
            label458:
            if ((i == -1) || (i > 3)) {
              break label519;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label522;
            }
            ((List)localObject2).add(((a.av)localObject4).Bfy);
            break;
            i = bo.bg((byte[])localObject5);
            ab.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label458;
          }
        }
      }
    }
    localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).oWg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (f.a)((RelativeLayout)((Iterator)localObject1).next()).getTag();
      if (((List)localObject2).contains(((f.a)localObject3).oWq.getUsername())) {
        ((f.a)localObject3).oWs.setVisibility(0);
      } else {
        ((f.a)localObject3).oWs.setVisibility(8);
      }
    }
    AppMethodBeat.o(54154);
  }
  
  public final void bPy()
  {
    AppMethodBeat.i(54140);
    this.oUS.bTM();
    this.oUT.o(p.bTF().oTs);
    AppMethodBeat.o(54140);
  }
  
  public final void bSE()
  {
    AppMethodBeat.i(54142);
    g.KC().KF();
    com.tencent.mm.sdk.g.d.post(new f.6(p.bTF()), "MultiTalkManager_play_end_sound");
    kf localkf = new kf();
    localkf.czQ.action = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localkf);
    this.loX.post(new MultiTalkMainUI.4(this));
    p.bTF().oTC = null;
    p.bTF().stopRing();
    finish();
    AppMethodBeat.o(54142);
  }
  
  public final void bSF()
  {
    AppMethodBeat.i(54139);
    switch (MultiTalkMainUI.2.oVf[p.bTF().oTr.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54139);
      return;
      this.oUT.o(p.bTF().oTs);
      AppMethodBeat.o(54139);
      return;
      this.oUS.n(p.bTF().oTs);
    }
  }
  
  public final void bSG()
  {
    AppMethodBeat.i(54144);
    ab.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + p.bTF().oTq.size());
    if (p.bTF().bTh())
    {
      if (p.bTF().oTq.size() <= 0) {
        break label113;
      }
      j.bTw();
      p.bTF().bTp();
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.oUT;
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(p.bTF().oTq);
      if (p.bTF().bTg()) {
        localf.d(localHashSet);
      }
      AppMethodBeat.o(54144);
      return;
      label113:
      p.bTF().bTq();
    }
  }
  
  public final boolean bSH()
  {
    AppMethodBeat.i(54155);
    if (this.oUT != null)
    {
      boolean bool = this.oUT.bSH();
      AppMethodBeat.o(54155);
      return bool;
    }
    AppMethodBeat.o(54155);
    return false;
  }
  
  public final void bTK()
  {
    AppMethodBeat.i(54137);
    this.oVb = true;
    Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
    ArrayList localArrayList = new ArrayList();
    if (p.bTF().oTs != null)
    {
      Iterator localIterator = p.bTF().oTs.Bhp.iterator();
      while (localIterator.hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
        if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
          localArrayList.add(localMultiTalkGroupMember.Bhq);
        }
      }
      localIntent.putExtra("titile", getString(2131301656));
      localIntent.putExtra("chatroomName", p.bTF().oTs.Bhn);
      localIntent.putExtra("always_select_contact", bo.d(localArrayList, ","));
      localIntent.putExtra("key_need_gallery", false);
      startActivityForResult(localIntent, 1);
    }
    AppMethodBeat.o(54137);
  }
  
  public final ViewGroup bTL()
  {
    AppMethodBeat.i(54157);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131826407);
    AppMethodBeat.o(54157);
    return localViewGroup;
  }
  
  public final void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54147);
    if (p.bTF().bTh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.oUT;
      Object localObject = localf.UD(r.Zn());
      if (localObject != null)
      {
        localObject = (f.a)((RelativeLayout)localObject).getTag();
        if (!j.zG(paramInt2))
        {
          if (j.zG(paramInt1))
          {
            localf.oWb.setChecked(false);
            ((f.a)localObject).oWq.bTQ();
            localf.oWa.setVisibility(8);
            if ((localf.oWl.equals(r.Zn())) && (localf.oVV.getVisibility() == 0))
            {
              localf.oWl = "";
              localf.oVU.setVisibility(0);
              localf.oVV.setVisibility(8);
            }
          }
          localf.jJ(false);
        }
        for (;;)
        {
          localObject = new HashSet();
          ((HashSet)localObject).addAll(p.bTF().oTq);
          if (j.zH(paramInt2)) {
            break;
          }
          if (!j.zH(paramInt1)) {
            break label268;
          }
          localf.bTN();
          AppMethodBeat.o(54147);
          return;
          if ((j.zG(paramInt2)) && (!j.zG(paramInt1)))
          {
            localf.oWb.setChecked(true);
            ((f.a)localObject).oWq.bTR();
            ((f.a)localObject).oWt.setVisibility(8);
            al.p(new f.b(localf, (f.a)localObject), 1500L);
            localf.oWa.setVisibility(0);
          }
        }
        if ((j.zH(paramInt2)) && (!j.zH(paramInt1))) {
          localf.d((HashSet)localObject);
        }
      }
    }
    label268:
    AppMethodBeat.o(54147);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970321;
  }
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(54145);
    if (p.bTF().bTh()) {
      this.oUT.oWc.setChecked(paramBoolean);
    }
    AppMethodBeat.o(54145);
  }
  
  public final void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(54146);
    if (p.bTF().bTh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.oUT;
      localf.oWd.setChecked(paramBoolean);
      localf.bTO();
    }
    AppMethodBeat.o(54146);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(54148);
    if (p.bTF().bTh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.oUT;
      if (localf.oWd != null) {
        localf.oWd.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(54148);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(54138);
    ab.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.oVb = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ab.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      ArrayList localArrayList = bo.P(paramIntent.split(","));
      if (localArrayList == null)
      {
        AppMethodBeat.o(54138);
        return;
      }
      com.tencent.mm.plugin.multitalk.model.f localf = p.bTF();
      if (localf.bSD())
      {
        String str = localf.oTs.Bhl;
        paramIntent = str;
        if (bo.isNullOrNil(str)) {
          paramIntent = localf.oTs.Bhm;
        }
        p.bTE().oTa.D(paramIntent, localArrayList);
      }
    }
    AppMethodBeat.o(54138);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54130);
    super.onCreate(paramBundle);
    hideTitleView();
    g.KC().KE();
    int i = getIntent().getIntExtra("enterMainUiSource", 0);
    if ((i == 1) || (i == 2)) {
      overridePendingTransition(2131034217, 2131034130);
    }
    for (;;)
    {
      getWindow().addFlags(6815872);
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(67108864);
      }
      p.bTF().bIQ();
      if (p.bTF().bSD()) {
        break;
      }
      finish();
      if (i == 2) {
        getIntent().getStringExtra("enterMainUiWxGroupId");
      }
      AppMethodBeat.o(54130);
      return;
      overridePendingTransition(2131034268, 2131034269);
    }
    this.oUS = new com.tencent.mm.plugin.multitalk.ui.widget.c(this);
    this.oUT = new com.tencent.mm.plugin.multitalk.ui.widget.f(this);
    p.bTF().jF(p.bTF().oTm);
    p.bTF().oTC = this;
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.oVc, paramBundle);
    this.oUX = true;
    this.loX = new ak();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      ab.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.fv(26))
    {
      ab.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.oUZ = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      ah.getContext().registerReceiver(this.oUZ, paramBundle);
    }
    this.oUV = ((Notification)getIntent().getParcelableExtra("notification"));
    AppMethodBeat.o(54130);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54133);
    if (this.oVb) {
      p.bTF().jE(false);
    }
    if (this.oUX) {
      unregisterReceiver(this.oVc);
    }
    this.oVd.removeCallbacksAndMessages(null);
    this.oVd.sendEmptyMessage(1);
    ab.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.fv(26)) && (this.oUY))
      {
        ah.getContext().unbindService(this);
        this.oUY = false;
      }
      if (com.tencent.mm.compatible.util.d.fv(26))
      {
        ab.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.oUZ == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        ah.getContext().unregisterReceiver(this.oUZ);
        this.oUZ = null;
        super.onDestroy();
        AppMethodBeat.o(54133);
        return;
        localException1 = localException1;
        ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", localException1, "unbindVoiceServiceIfNeed error: %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(54143);
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.oUT;
      ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localf.jJ(false);
      p.bTF().zF(1);
      localf.oWb.setChecked(false);
    }
    AppMethodBeat.o(54143);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(54135);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.ui.base.h.a(this, 2131301676, 2131301655, 2131296542, 2131296888, new MultiTalkMainUI.3(this), null);
      AppMethodBeat.o(54135);
      return true;
    }
    if (p.bTF().oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVP)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        p.bTF().stopRing();
        this.oUW = false;
        AppMethodBeat.o(54135);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        g.KC().iG(bJG());
        AppMethodBeat.o(54135);
        return true;
      }
      if (paramInt == 24)
      {
        g.KC().iF(bJG());
        AppMethodBeat.o(54135);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(54135);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(54132);
    KeyguardManager localKeyguardManager = (KeyguardManager)ah.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ah.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.oUU = bool1;
      ab.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.oUU) });
      if (p.bTF().bTh())
      {
        p.bTF().bTq();
        this.oUT.jJ(true);
      }
      super.onPause();
      AppMethodBeat.o(54132);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(54156);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ab.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(54156);
      return;
    }
    ab.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54156);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ab.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
        AppMethodBeat.o(54156);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131296888), false, new MultiTalkMainUI.6(this), new MultiTalkMainUI.7(this));
      AppMethodBeat.o(54156);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ab.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(54156);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new MultiTalkMainUI.8(this), new MultiTalkMainUI.9(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(54131);
    ab.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    switch (MultiTalkMainUI.2.oVf[p.bTF().oTr.ordinal()])
    {
    }
    for (;;)
    {
      if (p.bTF().bTh())
      {
        if (p.bTF().bTf()) {
          this.oUT.jI(true);
        }
        this.loX.postDelayed(this.oVa, 2000L);
      }
      AppMethodBeat.o(54131);
      return;
      this.oUT.oVX.setVisibility(8);
      this.oUS.n(p.bTF().oTs);
      if (at.is4G(this)) {
        p.bTD().X(this);
      }
      while (this.oUW)
      {
        p.bTF().jG(false);
        break;
        if ((at.is2G(this)) || (at.is3G(this))) {
          p.bTD().W(this);
        }
      }
      this.oUS.bTM();
      this.oUT.o(p.bTF().oTs);
      if (at.is4G(this)) {
        p.bTD().X(this);
      }
      for (;;)
      {
        p.bTF().jG(true);
        break;
        if ((at.is2G(this)) || (at.is3G(this))) {
          p.bTD().W(this);
        }
      }
      this.oUS.bTM();
      this.oUT.o(p.bTF().oTs);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(54134);
    if ((!this.oVb) && (this.oUU)) {
      p.bTF().jE(false);
    }
    super.onStop();
    AppMethodBeat.o(54134);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */