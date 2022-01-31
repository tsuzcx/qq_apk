package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.d;
import com.tencent.mm.h.a.lt;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.talkroom.model.c;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI
  extends MMBaseActivity
  implements com.tencent.mm.ah.f, d
{
  private List<String> bSN = new LinkedList();
  private com.tencent.mm.ui.base.p dnV;
  private TextView eXr;
  private boolean lGE = true;
  private String lGF;
  private String lGG;
  private boolean lGI = false;
  private int lGJ = 0;
  private long lGK = 500L;
  private long lGL = 0L;
  private am lGM = new am(new com.tencent.mm.sdk.platformtools.am.a()
  {
    public final boolean tC()
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
      TalkRoomUI.q(TalkRoomUI.this);
      return false;
    }
  }, false);
  private am lGN = new am(new TalkRoomUI.1(this), false);
  private am lGO = new am(new TalkRoomUI.9(this), false);
  private final am lGR = new am(new TalkRoomUI.10(this), true);
  private boolean lGS = true;
  private Chronometer lGX;
  private int lGY = 0;
  private TextView lxm;
  private TextView pBV;
  private ImageButton pBW;
  private Button pBX;
  private ImageView pBY;
  private TalkRoomVolumeMeter pBZ;
  private TalkRoomAvatarsFrame pCa;
  private a pCb;
  private boolean pCc = true;
  private int pCd = 0;
  private AlphaAnimation pCe;
  private AlphaAnimation pCf;
  private AlphaAnimation pCg;
  private AlphaAnimation pCh;
  private float pCi = -1.0F;
  private float pCj = -1.0F;
  private float radius = -1.0F;
  private PowerManager.WakeLock wakeLock;
  
  private void PI(String paramString)
  {
    if (!this.lGS) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }
    for (;;)
    {
      return;
      this.lGS = false;
      com.tencent.mm.plugin.talkroom.model.b.bMu().beA();
      String str = paramString;
      if (bk.bl(paramString)) {
        if (aq.isConnected(getApplication())) {
          break label77;
        }
      }
      label77:
      for (str = getString(R.l.talk_room_network_not_conn); !isFinishing(); str = getString(R.l.talk_room_network_failed))
      {
        com.tencent.mm.ui.base.h.a(this, str, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            TalkRoomUI.this.finish();
          }
        });
        return;
      }
    }
  }
  
  private void bMO()
  {
    if ((this.lGJ == 3) || (this.lGJ == 5))
    {
      this.pBZ.setShowFlame(true);
      return;
    }
    if (!bk.bl(this.lGG))
    {
      this.pBZ.setShowFlame(true);
      return;
    }
    this.pBZ.setShowFlame(false);
  }
  
  private void bMP()
  {
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.bMu().bee();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((bxc)((Iterator)localObject).next()).hPY);
    }
    this.pCa.setMembersList(localLinkedList);
  }
  
  private void bMQ()
  {
    int i = com.tencent.mm.plugin.talkroom.model.b.bMu().bee().size();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[] { Integer.valueOf(i) });
    this.lxm.setText(String.valueOf(i));
  }
  
  private void bMR()
  {
    if (this.lGY == 0) {
      return;
    }
    this.lGX.stop();
    this.lGY = 0;
    this.lGX.startAnimation(this.pCf);
  }
  
  private void bey()
  {
    if (this.lGJ != 5) {
      return;
    }
    this.lGM.stopTimer();
    bez();
    bMO();
    com.tencent.mm.sdk.platformtools.au.b(ae.getContext(), R.l.talkroom_begin, new au.a()
    {
      public final void ug()
      {
        TalkRoomUI.o(TalkRoomUI.this).stopTimer();
        TalkRoomUI.a(TalkRoomUI.this);
      }
    });
    this.lGN.S(1000L, 1000L);
  }
  
  private void bez()
  {
    if (this.lGE) {
      return;
    }
    if (com.tencent.mm.plugin.talkroom.model.b.bMu().pBw)
    {
      e(getString(R.l.talk_room_pausing), R.e.talk_room_tv_red);
      this.pCa.setCurMemeber(null);
      this.pBY.setImageResource(R.g.talk_room_led_black);
      bMR();
      return;
    }
    switch (this.lGJ)
    {
    default: 
      return;
    case 0: 
      if (!bk.bl(this.lGG))
      {
        cA(r.gV(this.lGG), R.e.talk_room_tv_green);
        this.pCa.setCurMemeber(this.lGG);
        this.pBY.setImageResource(R.g.talk_room_led_black);
        zt(1);
        return;
      }
      if (com.tencent.mm.plugin.talkroom.model.b.bMu().bee().size() == 1) {}
      for (String str = getString(R.l.talk_room_waiting_for_others);; str = "")
      {
        e(str, R.e.talk_room_tv_green);
        this.pCa.setCurMemeber(null);
        this.pBY.setImageResource(R.g.talk_room_led_black);
        bMR();
        return;
      }
    case 1: 
      e(getString(R.l.talk_room_connecting), R.e.talk_room_tv_green);
      this.pBY.setImageResource(R.g.talk_room_led_yellow);
      return;
    case 3: 
    case 5: 
      e(getString(R.l.talk_room_self_speaking), R.e.talk_room_tv_green);
      this.pCa.setCurMemeber(q.Gj());
      this.pBY.setImageResource(R.g.talk_room_led_green);
      zt(2);
      return;
    case 2: 
      e(getString(R.l.talk_room_seize_mic_failed), R.e.talk_room_tv_red);
      this.pBY.setImageResource(R.g.talk_room_led_red);
      return;
    }
    e(getString(R.l.talk_room_speak_too_long), R.e.talk_room_tv_red);
    this.pBY.setImageResource(R.g.talk_room_led_red);
    bMR();
  }
  
  private void cA(String paramString, int paramInt)
  {
    e(j.a(this, paramString, this.pBV.getTextSize()), paramInt);
  }
  
  private void e(CharSequence paramCharSequence, int paramInt)
  {
    if (bk.bl(paramCharSequence.toString()))
    {
      this.pBV.startAnimation(this.pCh);
      return;
    }
    this.pBV.setTextColor(getResources().getColor(paramInt));
    this.pBV.setText(paramCharSequence);
    this.pBV.startAnimation(this.pCg);
  }
  
  private void zt(int paramInt)
  {
    if ((paramInt != 0) && (this.lGY == paramInt)) {
      return;
    }
    this.lGX.setVisibility(0);
    this.lGX.startAnimation(this.pCe);
    this.lGX.setBase(bk.UZ());
    this.lGX.start();
    this.lGY = paramInt;
  }
  
  public final void RM()
  {
    this.lGE = false;
    this.pBW.setEnabled(true);
    this.pBW.setImageResource(R.g.talk_room_mic_btn_normal);
    this.pBX.setVisibility(0);
    bez();
    bMQ();
    bMP();
  }
  
  public final void RN()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
    if (this.lGJ != 1) {
      return;
    }
    this.lGJ = 5;
    if (bk.cp(this.lGL) < this.lGK)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
      am localam = this.lGM;
      long l = this.lGK - bk.cp(this.lGL);
      localam.S(l, l);
      return;
    }
    bey();
  }
  
  public final void RO()
  {
    if (!this.lGS)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      return;
    }
    this.lGS = false;
    finish();
  }
  
  public final void RP()
  {
    bez();
  }
  
  public final void RQ()
  {
    bez();
  }
  
  public final void RR()
  {
    e(getString(R.l.talk_room_reconnecting), R.e.talk_room_tv_red);
  }
  
  public final void aE(String paramString1, String paramString2)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    bMP();
    if (this.lGE) {}
    do
    {
      return;
      bMQ();
      if (!bk.bl(paramString1))
      {
        cA(getString(R.l.talk_room_enter_4short, new Object[] { r.gV(paramString1) }), R.e.talk_room_tv_green);
        this.lGO.S(3000L, 3000L);
      }
    } while (bk.bl(paramString2));
    cA(getString(R.l.talk_room_exit_4short, new Object[] { r.gV(paramString2) }), R.e.talk_room_tv_green);
    this.lGO.S(3000L, 3000L);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    PI("");
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public final void i(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[] { paramString });
    paramString = "";
    if (paramInt1 == 4)
    {
      if (paramInt2 != -1)
      {
        this.lGS = false;
        finish();
        return;
      }
      paramString = getString(R.l.talk_room_network_failed);
    }
    PI(paramString);
  }
  
  public final void jp(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.lGJ != 3) {
        return;
      }
    }
    for (this.lGJ = 4;; this.lGJ = 2)
    {
      bMO();
      bez();
      com.tencent.mm.sdk.platformtools.au.a(ae.getContext(), R.l.talkroom_sasasa, new TalkRoomUI.4(this));
      return;
      if (this.lGJ != 1) {
        break;
      }
    }
  }
  
  public final void ny(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[] { paramString });
    this.lGG = paramString;
    bMO();
    bez();
    if (!bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.au.b(ae.getContext(), R.l.talkroom_othersbegin, new TalkRoomUI.8(this));
      this.lGR.S(100L, 100L);
      return;
    }
    this.lGR.stopTimer();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("enter_room_username");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[] { paramBundle });
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[] { paramBundle });
    this.lGF = paramBundle;
    if (bk.bl(this.lGF))
    {
      PI("");
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "onCreate before initView");
      setContentView(com.tencent.mm.ui.y.gt(ae.getContext()).inflate(R.i.talk_room, null));
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
      this.eXr = ((TextView)findViewById(R.h.title_tv));
      this.pBV = ((TextView)findViewById(R.h.mic_info));
      this.lxm = ((TextView)findViewById(R.h.count_tv));
      this.pBX = ((Button)findViewById(R.h.info_btn));
      this.lGX = ((Chronometer)findViewById(R.h.chronometer));
      this.pBY = ((ImageView)findViewById(R.h.led_iv));
      this.pCb = new a(this);
      this.pBX.setOnClickListener(new TalkRoomUI.11(this));
      findViewById(R.h.up_btn).setOnClickListener(new TalkRoomUI.12(this));
      this.pBW = ((ImageButton)findViewById(R.h.mic_btn));
      this.pBW.setEnabled(false);
      this.pBW.setImageResource(R.g.talk_room_mic_btn_unable);
      this.pBW.setOnTouchListener(new TalkRoomUI.13(this));
      this.pBZ = ((TalkRoomVolumeMeter)findViewById(R.h.volume_meter));
      paramBundle = new TalkRoomUI.14(this);
      findViewById(R.h.touch_view).setOnTouchListener(new TalkRoomUI.15(this, paramBundle));
      this.pCa = ((TalkRoomAvatarsFrame)findViewById(R.h.avatar_frame));
      this.eXr.setOnClickListener(new TalkRoomUI.16(this));
      this.pCe = new AlphaAnimation(0.0F, 1.0F);
      this.pCe.setDuration(300L);
      this.pCe.setFillAfter(true);
      this.pCf = new AlphaAnimation(1.0F, 0.0F);
      this.pCf.setDuration(300L);
      this.pCf.setFillAfter(true);
      this.pCg = new AlphaAnimation(0.0F, 1.0F);
      this.pCg.setDuration(300L);
      this.pCg.setFillAfter(true);
      this.pCh = new AlphaAnimation(1.0F, 0.0F);
      this.pCh.setDuration(300L);
      this.pCh.setFillAfter(true);
      com.tencent.mm.model.au.Dk().a(364, this);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
      com.tencent.mm.plugin.talkroom.model.b.bMu().a(this);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "onCreate end");
      return;
    }
    List localList;
    if (s.fn(paramBundle))
    {
      localList = com.tencent.mm.model.m.gK(paramBundle);
      if (localList == null) {
        com.tencent.mm.model.am.a.dVy.V(paramBundle, "");
      }
    }
    for (;;)
    {
      new ah(Looper.getMainLooper()).post(new TalkRoomUI.3(this, paramBundle));
      break;
      this.bSN = localList;
      continue;
      this.bSN.clear();
      this.bSN.add(paramBundle);
      this.bSN.add(q.Gj());
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.plugin.talkroom.model.b.bMu().b(this);
    com.tencent.mm.model.au.Dk().b(364, this);
    if ((this.dnV != null) && (this.dnV.isShowing())) {
      this.dnV.cancel();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 25)
    {
      com.tencent.mm.model.au.Hy().gr(3);
      return true;
    }
    if (paramInt == 24)
    {
      com.tencent.mm.model.au.Hy().gq(3);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.release();
    this.lGR.stopTimer();
    com.tencent.mm.plugin.talkroom.model.b.bMt().pAn.pAs = false;
    com.tencent.mm.plugin.talkroom.model.b.bMt();
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.bMt().pAn;
    if (((c)localObject).lGE) {
      ((c)localObject).PG(ae.getContext().getString(R.l.talk_room_readying));
    }
    for (;;)
    {
      localObject = new lt();
      ((lt)localObject).bUN.bUO = false;
      com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
      return;
      if (!bk.bl(((c)localObject).lGc))
      {
        String str = ae.getContext().getString(R.l.talk_room_speaking, new Object[] { r.gV(((c)localObject).lGc) });
        c.bMA();
        ((c)localObject).PG(str);
      }
      else
      {
        ((c)localObject).PG(com.tencent.mm.plugin.talkroom.model.h.aJ(ae.getContext(), com.tencent.mm.plugin.talkroom.model.b.bMu().pBi));
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.acquire();
    Object localObject = j.a(this, com.tencent.mm.plugin.talkroom.model.h.aJ(this, this.lGF), this.eXr.getTextSize());
    this.eXr.setText((CharSequence)localObject);
    com.tencent.mm.plugin.talkroom.model.b.bMt().pAn.pAs = true;
    com.tencent.mm.plugin.talkroom.model.b.bMt();
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    com.tencent.mm.plugin.talkroom.model.b.bMt();
    c.bMA();
    localObject = new lt();
    ((lt)localObject).bUN.bUO = true;
    com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm.getType() == 364) && (this.dnV != null) && (this.dnV.isShowing())) {
      this.dnV.cancel();
    }
  }
  
  private abstract class a
  {
    float fSy;
    float fSz;
    long pCo;
    
    private a() {}
    
    public abstract void bMS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI
 * JD-Core Version:    0.7.0.1
 */