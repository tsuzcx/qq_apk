package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.h.a.jw;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.f.6;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.j.a;
import com.tencent.mm.plugin.multitalk.a.n;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.multitalk.ui.widget.f.a;
import com.tencent.mm.plugin.multitalk.ui.widget.f.b;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
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
  implements b
{
  protected ah jge;
  private com.tencent.mm.plugin.multitalk.ui.widget.c mve;
  private com.tencent.mm.plugin.multitalk.ui.widget.f mvf;
  private boolean mvg;
  private boolean mvh = true;
  private boolean mvi = false;
  private Runnable mvj = new MultiTalkMainUI.1(this);
  private boolean mvk;
  private BroadcastReceiver mvl = new MultiTalkMainUI.3(this);
  
  private static int bcy()
  {
    if (com.tencent.mm.compatible.b.f.yi().yn()) {
      return com.tencent.mm.compatible.b.f.yi().yz();
    }
    if (!p.blF().lpn.amn()) {
      return 3;
    }
    return 0;
  }
  
  public final int IE(String paramString)
  {
    paramString = this.mvf.IN(paramString);
    if (paramString == null) {
      return -1;
    }
    return ((f.a)paramString.getTag()).mwy.getPosition();
  }
  
  public final void a(j.a parama)
  {
    if (parama == j.a.muq) {
      p.blD().C(this);
    }
    do
    {
      return;
      if (parama == j.a.mur)
      {
        p.blD().B(this);
        return;
      }
    } while (parama != j.a.mus);
    com.tencent.mm.bf.e.a(this, a.g.voip_net_unavailable, null);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    if (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mwa)
    {
      parame = this.mvf;
      if (parame.mwv > 0L) {
        parame.mwv = System.currentTimeMillis();
      }
    }
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mvf.a(paramString, paramBitmap, paramInt1, paramInt2);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if (p.blF().blh()) {
      this.mvf.a(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void bbP()
  {
    jw localjw = new jw();
    localjw.bSp.action = 0;
    com.tencent.mm.sdk.b.a.udP.m(localjw);
    this.mvf.hQ(true);
    p.blF().mtQ = null;
    p.blF().stopRing();
    finish();
  }
  
  public final void bbQ()
  {
    Object localObject3 = this.mvf;
    Object localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).dsz;
    long l = p.blF().mtK;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject4 = p.blF();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.a.f)localObject4).mtH.wJL;
    localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.a.f)localObject4).mtH.wJM;
    }
    localObject1 = p.blE().mtp.afw((String)localObject1);
    localObject2 = p.blF().mtF;
    Object localObject5;
    if (localObject1 != null)
    {
      localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).mwo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (f.a)((RelativeLayout)((Iterator)localObject4).next()).getTag();
        String str = ((f.a)localObject5).mwy.getUsername();
        if (((!q.Gj().equals(str)) || (!((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).bkH())) && (((List)localObject1).contains(str)) && (!((HashSet)localObject2).contains(str)))
        {
          ((f.a)localObject5).mwz.setVisibility(0);
          y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", new Object[] { str });
        }
        else
        {
          ((f.a)localObject5).mwz.setVisibility(8);
          y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", new Object[] { str });
        }
      }
    }
    localObject4 = p.blF();
    localObject2 = ((com.tencent.mm.plugin.multitalk.a.f)localObject4).mtH.wJL;
    localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.a.f)localObject4).mtH.wJM;
    }
    if (n.muS == null) {
      n.muS = new n();
    }
    localObject4 = n.muS;
    localObject2 = new ArrayList();
    ((n)localObject4).muT = com.tencent.wecall.talkroom.model.c.cRC().agw((String)localObject1);
    if (((n)localObject4).muT != null)
    {
      localObject1 = ((n)localObject4).muT.cRz().iterator();
      label514:
      label517:
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (a.av)((Iterator)localObject1).next();
        int i = ((a.av)localObject4).iEo;
        if (i >= 0)
        {
          localObject5 = new byte[4];
          if (p.blE().mtp.setAppCmd(10, (byte[])localObject5, i) < 0)
          {
            y.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
            i = -1;
            label453:
            if ((i == -1) || (i >= 5)) {
              break label514;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label517;
            }
            ((List)localObject2).add(((a.av)localObject4).wHY);
            break;
            i = bk.aI((byte[])localObject5);
            y.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label453;
          }
        }
      }
    }
    localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.f)localObject3).mwo.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (f.a)((RelativeLayout)((Iterator)localObject1).next()).getTag();
      if (((List)localObject2).contains(((f.a)localObject3).mwy.getUsername())) {
        ((f.a)localObject3).mwA.setVisibility(0);
      } else {
        ((f.a)localObject3).mwA.setVisibility(8);
      }
    }
  }
  
  public final void bhw()
  {
    this.mve.blL();
    this.mvf.o(p.blF().mtH);
  }
  
  public final void bkE()
  {
    com.tencent.mm.compatible.b.f.yi().yl();
    com.tencent.mm.sdk.f.e.post(new f.6(p.blF()), "MultiTalkManager_play_end_sound");
    jw localjw = new jw();
    localjw.bSp.action = 0;
    com.tencent.mm.sdk.b.a.udP.m(localjw);
    this.mvf.hQ(false);
    p.blF().mtQ = null;
    p.blF().stopRing();
    finish();
  }
  
  public final void bkF()
  {
    switch (MultiTalkMainUI.6.mvn[p.blF().mtG.ordinal()])
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 4: 
      this.mvf.o(p.blF().mtH);
      return;
    }
    this.mve.n(p.blF().mtH);
  }
  
  public final void bkG()
  {
    y.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + p.blF().mtF.size());
    if (p.blF().blh())
    {
      if (p.blF().mtF.size() <= 0) {
        break label101;
      }
      j.blw();
      p.blF().blp();
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.mvf;
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(p.blF().mtF);
      if (p.blF().blg()) {
        localf.d(localHashSet);
      }
      return;
      label101:
      p.blF().blq();
    }
  }
  
  public final boolean bkH()
  {
    if (this.mvf != null) {
      return this.mvf.bkH();
    }
    return false;
  }
  
  public final void blK()
  {
    this.mvk = true;
    Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = p.blF().mtH.wJP.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
        localArrayList.add(localMultiTalkGroupMember.wJQ);
      }
    }
    localIntent.putExtra("titile", getString(a.g.multitalk_add_contact));
    localIntent.putExtra("chatroomName", p.blF().mtH.wJN);
    localIntent.putExtra("always_select_contact", bk.c(localArrayList, ","));
    localIntent.putExtra("key_need_gallery", false);
    startActivityForResult(localIntent, 1);
  }
  
  public final void dk(int paramInt1, int paramInt2)
  {
    com.tencent.mm.plugin.multitalk.ui.widget.f localf;
    Object localObject;
    if (p.blF().blh())
    {
      localf = this.mvf;
      localObject = (f.a)localf.IN(q.Gj()).getTag();
      if (j.uq(paramInt2)) {
        break label160;
      }
      if (j.uq(paramInt1))
      {
        localf.mwj.setChecked(false);
        ((f.a)localObject).mwy.blQ();
        localf.mwi.setVisibility(8);
        if ((localf.mwt.equals(q.Gj())) && (localf.mwd.getVisibility() == 0))
        {
          localf.mwt = "";
          localf.mwc.setVisibility(0);
          localf.mwd.setVisibility(8);
        }
      }
      localf.hP(false);
    }
    label160:
    do
    {
      for (;;)
      {
        localObject = new HashSet();
        ((HashSet)localObject).addAll(p.blF().mtF);
        if (j.ur(paramInt2)) {
          break;
        }
        if (j.ur(paramInt1)) {
          localf.blM();
        }
        return;
        if ((j.uq(paramInt2)) && (!j.uq(paramInt1)))
        {
          localf.mwj.setChecked(true);
          ((f.a)localObject).mwy.blR();
          ((f.a)localObject).mwB.setVisibility(8);
          ai.l(new f.b(localf, (f.a)localObject), 1500L);
          localf.mwi.setVisibility(0);
        }
      }
    } while ((!j.ur(paramInt2)) || (j.ur(paramInt1)));
    localf.d((HashSet)localObject);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.e.multitalk_main_ui;
  }
  
  public final void hE(boolean paramBoolean)
  {
    if (p.blF().blh()) {
      this.mvf.mwk.setChecked(paramBoolean);
    }
  }
  
  public final void hF(boolean paramBoolean)
  {
    if (p.blF().blh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.mvf;
      localf.mwl.setChecked(paramBoolean);
      localf.blO();
    }
  }
  
  public final void hG(boolean paramBoolean)
  {
    if (p.blF().blh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.mvf;
      if (localf.mwl != null) {
        localf.mwl.setEnabled(paramBoolean);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mvk = false;
    ArrayList localArrayList;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      y.i("MicroMsg.MT.MultiTalkMainUI", "add member " + paramIntent);
      localArrayList = bk.G(paramIntent.split(","));
      if (localArrayList != null) {
        break label104;
      }
    }
    label104:
    com.tencent.mm.plugin.multitalk.a.f localf;
    do
    {
      return;
      localf = p.blF();
    } while (!localf.bkD());
    String str = localf.mtH.wJL;
    paramIntent = str;
    if (bk.bl(str)) {
      paramIntent = localf.mtH.wJM;
    }
    p.blE().mtp.y(paramIntent, localArrayList);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    int i = getIntent().getIntExtra("enterMainUiSource", 0);
    if ((i == 1) || (i == 2))
    {
      overridePendingTransition(a.a.pop_in, a.a.anim_not_change);
      getWindow().addFlags(6815872);
      p.blF().bbJ();
      if (p.blF().bkD()) {
        break label103;
      }
      finish();
      if (i == 2) {
        getIntent().getStringExtra("enterMainUiWxGroupId");
      }
    }
    label103:
    do
    {
      return;
      overridePendingTransition(a.a.slide_top_in, a.a.slide_top_out);
      break;
      this.mve = new com.tencent.mm.plugin.multitalk.ui.widget.c(this);
      this.mvf = new com.tencent.mm.plugin.multitalk.ui.widget.f(this);
      p.blF().hM(p.blF().mtB);
      p.blF().mtQ = this;
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.mvl, paramBundle);
      this.mvi = true;
      this.jge = new ah();
      com.tencent.mm.compatible.b.f.yi().yk();
    } while (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", ""));
    y.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
  }
  
  protected void onDestroy()
  {
    if (this.mvk) {
      p.blF().hL(false);
    }
    if (this.mvi) {
      unregisterReceiver(this.mvl);
    }
    super.onDestroy();
  }
  
  public final void onError(int paramInt)
  {
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.f localf = this.mvf;
      y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localf.hP(false);
      p.blF().up(1);
      localf.mwj.setChecked(false);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      h.a(this, a.g.multitalk_exit_tip, a.g.multitalk, a.g.app_alert_exit, a.g.app_cancel, new MultiTalkMainUI.2(this), null);
      return true;
    }
    if (p.blF().mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mvX)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        p.blF().stopRing();
        this.mvh = false;
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        com.tencent.mm.compatible.b.f.yi().gr(bcy());
        return true;
      }
      if (paramInt == 24)
      {
        com.tencent.mm.compatible.b.f.yi().gq(bcy());
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)ae.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ae.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.mvg = bool1;
      y.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.mvg) });
      if (p.blF().blh())
      {
        p.blF().blq();
        this.mvf.hP(true);
      }
      super.onPause();
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      y.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    y.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      y.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
      return;
    }
    h.a(this, getString(a.g.permission_microphone_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new MultiTalkMainUI.4(this), new MultiTalkMainUI.5(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    switch (MultiTalkMainUI.6.mvn[p.blF().mtG.ordinal()])
    {
    }
    for (;;)
    {
      if (p.blF().blh())
      {
        if (p.blF().blf()) {
          this.mvf.hO(true);
        }
        this.jge.postDelayed(this.mvj, 2000L);
      }
      return;
      this.mvf.mwf.setVisibility(8);
      this.mve.n(p.blF().mtH);
      if (aq.is4G(this)) {
        p.blD().C(this);
      }
      while (this.mvh)
      {
        p.blF().hN(false);
        break;
        if ((aq.is2G(this)) || (aq.is3G(this))) {
          p.blD().B(this);
        }
      }
      this.mve.blL();
      this.mvf.o(p.blF().mtH);
      if (aq.is4G(this)) {
        p.blD().C(this);
      }
      for (;;)
      {
        p.blF().hN(true);
        break;
        if ((aq.is2G(this)) || (aq.is3G(this))) {
          p.blD().B(this);
        }
      }
      this.mve.blL();
      this.mvf.o(p.blF().mtH);
    }
  }
  
  protected void onStop()
  {
    if ((!this.mvk) && (this.mvg)) {
      p.blF().hL(false);
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */