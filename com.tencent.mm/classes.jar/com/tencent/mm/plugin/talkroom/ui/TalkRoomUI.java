package com.tencent.mm.plugin.talkroom.ui;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.talkroom.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI
  extends MMBaseActivity
  implements f, d
{
  private List<String> cAs;
  private com.tencent.mm.ui.base.p efs;
  private TextView nUz;
  private boolean odR;
  private String odS;
  private String odT;
  private boolean odV;
  private int odW;
  private long odX;
  private long odY;
  private ap odZ;
  private ap oea;
  private ap oeb;
  private final ap oee;
  private boolean oef;
  private Chronometer oek;
  private int oel;
  private float radius;
  private TextView tdE;
  private ImageButton tdF;
  private Button tdG;
  private ImageView tdH;
  private TalkRoomVolumeMeter tdI;
  private TalkRoomAvatarsFrame tdJ;
  private a tdK;
  private boolean tdL;
  private int tdM;
  private AlphaAnimation tdN;
  private AlphaAnimation tdO;
  private AlphaAnimation tdP;
  private AlphaAnimation tdQ;
  private float tdR;
  private float tdS;
  private TextView titleTv;
  private PowerManager.WakeLock wakeLock;
  
  public TalkRoomUI()
  {
    AppMethodBeat.i(25925);
    this.oef = true;
    this.cAs = new LinkedList();
    this.odW = 0;
    this.odR = true;
    this.oea = new ap(new TalkRoomUI.1(this), false);
    this.tdL = true;
    this.tdM = 0;
    this.oee = new ap(new TalkRoomUI.10(this), true);
    this.radius = -1.0F;
    this.tdR = -1.0F;
    this.tdS = -1.0F;
    this.odV = false;
    this.odX = 500L;
    this.odY = 0L;
    this.odZ = new ap(new TalkRoomUI.5(this), false);
    this.oeb = new ap(new TalkRoomUI.9(this), false);
    this.oel = 0;
    AppMethodBeat.o(25925);
  }
  
  private void Gt(int paramInt)
  {
    AppMethodBeat.i(25952);
    if ((paramInt != 0) && (this.oel == paramInt))
    {
      AppMethodBeat.o(25952);
      return;
    }
    this.oek.setVisibility(0);
    this.oek.startAnimation(this.tdN);
    this.oek.setBase(bo.yB());
    this.oek.start();
    this.oel = paramInt;
    AppMethodBeat.o(25952);
  }
  
  private void aeb(String paramString)
  {
    AppMethodBeat.i(25940);
    if (!this.oef)
    {
      ab.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(25940);
      return;
    }
    this.oef = false;
    com.tencent.mm.plugin.talkroom.model.b.cHs().cHH();
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      if (at.isConnected(getApplication())) {
        break label78;
      }
    }
    label78:
    for (str = getString(2131304241); isFinishing(); str = getString(2131304240))
    {
      AppMethodBeat.o(25940);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, str, "", new TalkRoomUI.7(this));
    AppMethodBeat.o(25940);
  }
  
  private void aec(String paramString)
  {
    AppMethodBeat.i(25950);
    n(j.b(this, paramString, this.tdE.getTextSize()), 2131690566);
    AppMethodBeat.o(25950);
  }
  
  private void bLS()
  {
    AppMethodBeat.i(25937);
    if (this.odW != 5)
    {
      AppMethodBeat.o(25937);
      return;
    }
    this.odZ.stopTimer();
    display();
    cHR();
    ay.a(ah.getContext(), 2131304253, new TalkRoomUI.6(this));
    this.oea.ag(1000L, 1000L);
    AppMethodBeat.o(25937);
  }
  
  private void cHR()
  {
    AppMethodBeat.i(25926);
    if ((this.odW == 3) || (this.odW == 5))
    {
      this.tdI.setShowFlame(true);
      AppMethodBeat.o(25926);
      return;
    }
    if (!bo.isNullOrNil(this.odT))
    {
      this.tdI.setShowFlame(true);
      AppMethodBeat.o(25926);
      return;
    }
    this.tdI.setShowFlame(false);
    AppMethodBeat.o(25926);
  }
  
  private void cHS()
  {
    AppMethodBeat.i(25946);
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.cHs().bLy();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((cjn)((Iterator)localObject).next()).jJA);
    }
    this.tdJ.setMembersList(localLinkedList);
    AppMethodBeat.o(25946);
  }
  
  private void cHT()
  {
    AppMethodBeat.i(25949);
    int i = com.tencent.mm.plugin.talkroom.model.b.cHs().bLy().size();
    ab.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[] { Integer.valueOf(i) });
    this.nUz.setText(String.valueOf(i));
    AppMethodBeat.o(25949);
  }
  
  private void cHU()
  {
    AppMethodBeat.i(25953);
    if (this.oel == 0)
    {
      AppMethodBeat.o(25953);
      return;
    }
    this.oek.stop();
    this.oel = 0;
    this.oek.startAnimation(this.tdO);
    AppMethodBeat.o(25953);
  }
  
  private void display()
  {
    AppMethodBeat.i(25948);
    if (this.odR)
    {
      AppMethodBeat.o(25948);
      return;
    }
    if (com.tencent.mm.plugin.talkroom.model.b.cHs().tdg)
    {
      n(getString(2131304242), 2131690567);
      this.tdJ.setCurMemeber(null);
      this.tdH.setImageResource(2130840524);
      cHU();
      AppMethodBeat.o(25948);
      return;
    }
    switch (this.odW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25948);
      return;
      if (!bo.isNullOrNil(this.odT))
      {
        aec(s.nE(this.odT));
        this.tdJ.setCurMemeber(this.odT);
        this.tdH.setImageResource(2130840524);
        Gt(1);
        AppMethodBeat.o(25948);
        return;
      }
      if (com.tencent.mm.plugin.talkroom.model.b.cHs().bLy().size() == 1) {}
      for (String str = getString(2131304251);; str = "")
      {
        n(str, 2131690566);
        this.tdJ.setCurMemeber(null);
        this.tdH.setImageResource(2130840524);
        cHU();
        AppMethodBeat.o(25948);
        return;
      }
      n(getString(2131304229), 2131690566);
      this.tdH.setImageResource(2130840527);
      AppMethodBeat.o(25948);
      return;
      n(getString(2131304246), 2131690566);
      this.tdJ.setCurMemeber(r.Zn());
      this.tdH.setImageResource(2130840525);
      Gt(2);
      AppMethodBeat.o(25948);
      return;
      n(getString(2131304245), 2131690567);
      this.tdH.setImageResource(2130840526);
      AppMethodBeat.o(25948);
      return;
      n(getString(2131304248), 2131690567);
      this.tdH.setImageResource(2130840526);
      cHU();
    }
  }
  
  private void n(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(25951);
    if (bo.isNullOrNil(paramCharSequence.toString()))
    {
      this.tdE.startAnimation(this.tdQ);
      AppMethodBeat.o(25951);
      return;
    }
    this.tdE.setTextColor(getResources().getColor(paramInt));
    this.tdE.setText(paramCharSequence);
    this.tdE.startAnimation(this.tdP);
    AppMethodBeat.o(25951);
  }
  
  public final void aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25947);
    ab.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    cHS();
    if (this.odR)
    {
      AppMethodBeat.o(25947);
      return;
    }
    cHT();
    if (!bo.isNullOrNil(paramString1))
    {
      aec(getString(2131304230, new Object[] { s.nE(paramString1) }));
      this.oeb.ag(3000L, 3000L);
    }
    if (!bo.isNullOrNil(paramString2))
    {
      aec(getString(2131304235, new Object[] { s.nE(paramString2) }));
      this.oeb.ag(3000L, 3000L);
    }
    AppMethodBeat.o(25947);
  }
  
  public final void akV()
  {
    AppMethodBeat.i(25933);
    this.odR = false;
    this.tdF.setEnabled(true);
    this.tdF.setImageResource(2130840528);
    this.tdG.setVisibility(0);
    display();
    cHT();
    cHS();
    AppMethodBeat.o(25933);
  }
  
  public final void akW()
  {
    AppMethodBeat.i(25936);
    ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
    if (this.odW != 1)
    {
      AppMethodBeat.o(25936);
      return;
    }
    this.odW = 5;
    if (bo.av(this.odY) < this.odX)
    {
      ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
      ap localap = this.odZ;
      long l = this.odX - bo.av(this.odY);
      localap.ag(l, l);
      AppMethodBeat.o(25936);
      return;
    }
    bLS();
    AppMethodBeat.o(25936);
  }
  
  public final void akX()
  {
    AppMethodBeat.i(25942);
    if (!this.oef)
    {
      ab.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(25942);
      return;
    }
    this.oef = false;
    finish();
    AppMethodBeat.o(25942);
  }
  
  public final void akY()
  {
    AppMethodBeat.i(25943);
    display();
    AppMethodBeat.o(25943);
  }
  
  public final void akZ()
  {
    AppMethodBeat.i(25944);
    display();
    AppMethodBeat.o(25944);
  }
  
  public final void ala()
  {
    AppMethodBeat.i(25945);
    n(getString(2131304244), 2131690567);
    AppMethodBeat.o(25945);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25931);
    super.finish();
    AppMethodBeat.o(25931);
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(25938);
    ab.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    aeb("");
    AppMethodBeat.o(25938);
  }
  
  public final void mh(int paramInt)
  {
    AppMethodBeat.i(25935);
    ab.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.odW != 3)
      {
        AppMethodBeat.o(25935);
        return;
      }
    }
    for (this.odW = 4;; this.odW = 2)
    {
      cHR();
      display();
      ay.a(ah.getContext(), new TalkRoomUI.4(this));
      AppMethodBeat.o(25935);
      return;
      if (this.odW != 1)
      {
        AppMethodBeat.o(25935);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25927);
    ab.d("MicroMsg.TalkRoomUI", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("enter_room_username");
    ab.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[] { paramBundle });
    ab.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[] { paramBundle });
    this.odS = paramBundle;
    if (bo.isNullOrNil(this.odS))
    {
      aeb("");
      ab.d("MicroMsg.TalkRoomUI", "onCreate before initView");
      setContentView(w.hM(ah.getContext()).inflate(2130970984, null));
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
      this.titleTv = ((TextView)findViewById(2131821212));
      this.tdE = ((TextView)findViewById(2131828473));
      this.nUz = ((TextView)findViewById(2131823263));
      this.tdG = ((Button)findViewById(2131828469));
      this.oek = ((Chronometer)findViewById(2131826636));
      this.tdH = ((ImageView)findViewById(2131828474));
      this.tdK = new a(this);
      this.tdG.setOnClickListener(new TalkRoomUI.11(this));
      findViewById(2131828470).setOnClickListener(new TalkRoomUI.12(this));
      this.tdF = ((ImageButton)findViewById(2131828475));
      this.tdF.setEnabled(false);
      this.tdF.setImageResource(2130840530);
      this.tdF.setOnTouchListener(new TalkRoomUI.13(this));
      this.tdI = ((TalkRoomVolumeMeter)findViewById(2131824811));
      paramBundle = new TalkRoomUI.14(this);
      findViewById(2131828468).setOnTouchListener(new TalkRoomUI.15(this, paramBundle));
      this.tdJ = ((TalkRoomAvatarsFrame)findViewById(2131828471));
      this.titleTv.setOnClickListener(new TalkRoomUI.16(this));
      this.tdN = new AlphaAnimation(0.0F, 1.0F);
      this.tdN.setDuration(300L);
      this.tdN.setFillAfter(true);
      this.tdO = new AlphaAnimation(1.0F, 0.0F);
      this.tdO.setDuration(300L);
      this.tdO.setFillAfter(true);
      this.tdP = new AlphaAnimation(0.0F, 1.0F);
      this.tdP.setDuration(300L);
      this.tdP.setFillAfter(true);
      this.tdQ = new AlphaAnimation(1.0F, 0.0F);
      this.tdQ.setDuration(300L);
      this.tdQ.setFillAfter(true);
      aw.Rc().a(364, this);
      ab.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
      com.tencent.mm.plugin.talkroom.model.b.cHs().a(this);
      ab.d("MicroMsg.TalkRoomUI", "onCreate end");
      AppMethodBeat.o(25927);
      return;
    }
    List localList;
    if (t.lA(paramBundle))
    {
      localList = n.nt(paramBundle);
      if (localList == null) {
        ao.a.flI.am(paramBundle, "");
      }
    }
    for (;;)
    {
      new ak(Looper.getMainLooper()).post(new TalkRoomUI.3(this, paramBundle));
      break;
      this.cAs = localList;
      continue;
      this.cAs.clear();
      this.cAs.add(paramBundle);
      this.cAs.add(r.Zn());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25930);
    com.tencent.mm.plugin.talkroom.model.b.cHs().b(this);
    aw.Rc().b(364, this);
    if ((this.efs != null) && (this.efs.isShowing())) {
      this.efs.cancel();
    }
    super.onDestroy();
    AppMethodBeat.o(25930);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25932);
    if (paramInt == 25)
    {
      aw.aaA().iG(3);
      AppMethodBeat.o(25932);
      return true;
    }
    if (paramInt == 24)
    {
      aw.aaA().iF(3);
      AppMethodBeat.o(25932);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25932);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25929);
    super.onPause();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.release();
    this.oee.stopTimer();
    com.tencent.mm.plugin.talkroom.model.b.cHr().tbZ.tce = false;
    com.tencent.mm.plugin.talkroom.model.b.cHr();
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.cHr().tbZ;
    if (((c)localObject).odR) {
      ((c)localObject).adZ(ah.getContext().getString(2131304243));
    }
    for (;;)
    {
      localObject = new mj();
      ((mj)localObject).cCu.cCv = false;
      com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
      ab.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
      AppMethodBeat.o(25929);
      return;
      if (!bo.isNullOrNil(((c)localObject).odp))
      {
        String str = ah.getContext().getString(2131304249, new Object[] { s.nE(((c)localObject).odp) });
        c.cHz();
        ((c)localObject).adZ(str);
      }
      else
      {
        ((c)localObject).adZ(com.tencent.mm.plugin.talkroom.model.h.aT(ah.getContext(), com.tencent.mm.plugin.talkroom.model.b.cHs().tcS));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25928);
    super.onResume();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.acquire();
    Object localObject = j.b(this, com.tencent.mm.plugin.talkroom.model.h.aT(this, this.odS), this.titleTv.getTextSize());
    this.titleTv.setText((CharSequence)localObject);
    com.tencent.mm.plugin.talkroom.model.b.cHr().tbZ.tce = true;
    com.tencent.mm.plugin.talkroom.model.b.cHr();
    ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    com.tencent.mm.plugin.talkroom.model.b.cHr();
    c.cHz();
    localObject = new mj();
    ((mj)localObject).cCu.cCv = true;
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
    ab.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    AppMethodBeat.o(25928);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25939);
    if ((paramm.getType() == 364) && (this.efs != null) && (this.efs.isShowing())) {
      this.efs.cancel();
    }
    AppMethodBeat.o(25939);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25934);
    ab.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[] { paramString });
    paramString = "";
    if (paramInt1 == 4)
    {
      if (paramInt2 != -1)
      {
        this.oef = false;
        finish();
        AppMethodBeat.o(25934);
        return;
      }
      paramString = getString(2131304240);
    }
    aeb(paramString);
    AppMethodBeat.o(25934);
  }
  
  public final void uM(String paramString)
  {
    AppMethodBeat.i(25941);
    ab.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[] { paramString });
    this.odT = paramString;
    cHR();
    display();
    if (!bo.isNullOrNil(paramString))
    {
      ay.a(ah.getContext(), 2131304256, new TalkRoomUI.8(this));
      this.oee.ag(100L, 100L);
      AppMethodBeat.o(25941);
      return;
    }
    this.oee.stopTimer();
    AppMethodBeat.o(25941);
  }
  
  abstract class a
  {
    float bTE;
    float bTF;
    long tdY;
    
    private a() {}
    
    public abstract void cHV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI
 * JD-Core Version:    0.7.0.1
 */