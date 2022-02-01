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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.c;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI
  extends MMBaseActivity
  implements i, d
{
  private TextView FRg;
  private ImageButton FRh;
  private Button FRi;
  private ImageView FRj;
  private TalkRoomVolumeMeter FRk;
  private TalkRoomAvatarsFrame FRl;
  private a FRm;
  private boolean FRn;
  private int FRo;
  private AlphaAnimation FRp;
  private AlphaAnimation FRq;
  private AlphaAnimation FRr;
  private AlphaAnimation FRs;
  private float FRt;
  private float FRu;
  private List<String> dSU;
  private com.tencent.mm.ui.base.q gut;
  private TextView hXK;
  private float radius;
  private TextView titleTv;
  private PowerManager.WakeLock wakeLock;
  private boolean yJA;
  private String yJB;
  private String yJC;
  private boolean yJE;
  private int yJF;
  private long yJG;
  private long yJH;
  private MTimerHandler yJI;
  private MTimerHandler yJJ;
  private MTimerHandler yJK;
  private final MTimerHandler yJN;
  private boolean yJO;
  private Chronometer yJT;
  private int yJU;
  
  public TalkRoomUI()
  {
    AppMethodBeat.i(29608);
    this.yJO = true;
    this.dSU = new LinkedList();
    this.yJF = 0;
    this.yJA = true;
    this.yJJ = new MTimerHandler(new TalkRoomUI.1(this), false);
    this.FRn = true;
    this.FRo = 0;
    this.yJN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        int j = 15;
        boolean bool = false;
        AppMethodBeat.i(29597);
        int i;
        if (TalkRoomUI.b(TalkRoomUI.this) == 3)
        {
          i = b.ftN().bgu();
          if (i > 15) {
            break label172;
          }
          if (!TalkRoomUI.e(TalkRoomUI.this)) {
            break label167;
          }
          i = j;
          label47:
          TalkRoomUI.f(TalkRoomUI.this);
          j = i;
          if (TalkRoomUI.g(TalkRoomUI.this) >= 5)
          {
            TalkRoomUI localTalkRoomUI = TalkRoomUI.this;
            if (!TalkRoomUI.e(TalkRoomUI.this)) {
              bool = true;
            }
            TalkRoomUI.a(localTalkRoomUI, bool);
            TalkRoomUI.h(TalkRoomUI.this);
          }
        }
        label167:
        label172:
        for (j = i;; j = i)
        {
          TalkRoomUI.d(TalkRoomUI.this);
          TalkRoomUI.i(TalkRoomUI.this).setValue(j);
          AppMethodBeat.o(29597);
          return true;
          if (Util.isNullOrNil(TalkRoomUI.c(TalkRoomUI.this)))
          {
            TalkRoomUI.d(TalkRoomUI.this);
            AppMethodBeat.o(29597);
            return false;
          }
          i = b.ftN().bgv();
          break;
          i = 0;
          break label47;
        }
      }
    }, true);
    this.radius = -1.0F;
    this.FRt = -1.0F;
    this.FRu = -1.0F;
    this.yJE = false;
    this.yJG = 500L;
    this.yJH = 0L;
    this.yJI = new MTimerHandler(new TalkRoomUI.5(this), false);
    this.yJK = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29596);
        TalkRoomUI.m(TalkRoomUI.this);
        AppMethodBeat.o(29596);
        return false;
      }
    }, false);
    this.yJU = 0;
    AppMethodBeat.o(29608);
  }
  
  private void aSW(String paramString)
  {
    AppMethodBeat.i(29623);
    if (!this.yJO)
    {
      Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29623);
      return;
    }
    this.yJO = false;
    b.ftN().fub();
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      if (NetStatusUtil.isConnected(getApplication())) {
        break label78;
      }
    }
    label78:
    for (str = getString(2131766620); isFinishing(); str = getString(2131766619))
    {
      AppMethodBeat.o(29623);
      return;
    }
    com.tencent.mm.ui.base.h.d(this, str, "", new TalkRoomUI.7(this));
    AppMethodBeat.o(29623);
  }
  
  private void aSX(String paramString)
  {
    AppMethodBeat.i(29633);
    l(l.b(this, paramString, this.FRg.getTextSize()), 2131101241);
    AppMethodBeat.o(29633);
  }
  
  private void abt(int paramInt)
  {
    AppMethodBeat.i(29635);
    if ((paramInt != 0) && (this.yJU == paramInt))
    {
      AppMethodBeat.o(29635);
      return;
    }
    this.yJT.setVisibility(0);
    this.yJT.startAnimation(this.FRp);
    this.yJT.setBase(Util.currentTicks());
    this.yJT.start();
    this.yJU = paramInt;
    AppMethodBeat.o(29635);
  }
  
  private void display()
  {
    AppMethodBeat.i(29631);
    if (this.yJA)
    {
      AppMethodBeat.o(29631);
      return;
    }
    if (b.ftN().FQJ)
    {
      l(getString(2131766621), 2131101242);
      this.FRl.setCurMemeber(null);
      this.FRj.setImageResource(2131235196);
      fuo();
      AppMethodBeat.o(29631);
      return;
    }
    switch (this.yJF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29631);
      return;
      if (!Util.isNullOrNil(this.yJC))
      {
        aSX(com.tencent.mm.model.aa.getDisplayName(this.yJC));
        this.FRl.setCurMemeber(this.yJC);
        this.FRj.setImageResource(2131235196);
        abt(1);
        AppMethodBeat.o(29631);
        return;
      }
      if (b.ftN().ecY().size() == 1) {}
      for (String str = getString(2131766630);; str = "")
      {
        l(str, 2131101241);
        this.FRl.setCurMemeber(null);
        this.FRj.setImageResource(2131235196);
        fuo();
        AppMethodBeat.o(29631);
        return;
      }
      l(getString(2131766608), 2131101241);
      this.FRj.setImageResource(2131235199);
      AppMethodBeat.o(29631);
      return;
      l(getString(2131766625), 2131101241);
      this.FRl.setCurMemeber(z.aTY());
      this.FRj.setImageResource(2131235197);
      abt(2);
      AppMethodBeat.o(29631);
      return;
      l(getString(2131766624), 2131101242);
      this.FRj.setImageResource(2131235198);
      AppMethodBeat.o(29631);
      return;
      l(getString(2131766627), 2131101242);
      this.FRj.setImageResource(2131235198);
      fuo();
    }
  }
  
  private void edu()
  {
    AppMethodBeat.i(29620);
    if (this.yJF != 5)
    {
      AppMethodBeat.o(29620);
      return;
    }
    this.yJI.stopTimer();
    display();
    ful();
    PlaySound.play(MMApplicationContext.getContext(), 2131766634, new PlaySound.OnPlayCompletionListener()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(29594);
        TalkRoomUI.o(TalkRoomUI.this).stopTimer();
        TalkRoomUI.a(TalkRoomUI.this);
        AppMethodBeat.o(29594);
      }
    });
    this.yJJ.startTimer(1000L);
    AppMethodBeat.o(29620);
  }
  
  private void ful()
  {
    AppMethodBeat.i(29609);
    if ((this.yJF == 3) || (this.yJF == 5))
    {
      this.FRk.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    if (!Util.isNullOrNil(this.yJC))
    {
      this.FRk.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    this.FRk.setShowFlame(false);
    AppMethodBeat.o(29609);
  }
  
  private void fum()
  {
    AppMethodBeat.i(29629);
    Object localObject = b.ftN().ecY();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((egs)((Iterator)localObject).next()).UserName);
    }
    this.FRl.setMembersList(localLinkedList);
    AppMethodBeat.o(29629);
  }
  
  private void fun()
  {
    AppMethodBeat.i(29632);
    int i = b.ftN().ecY().size();
    Log.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[] { Integer.valueOf(i) });
    this.hXK.setText(String.valueOf(i));
    AppMethodBeat.o(29632);
  }
  
  private void fuo()
  {
    AppMethodBeat.i(29636);
    if (this.yJU == 0)
    {
      AppMethodBeat.o(29636);
      return;
    }
    this.yJT.stop();
    this.yJU = 0;
    this.yJT.startAnimation(this.FRq);
    AppMethodBeat.o(29636);
  }
  
  private void l(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(29634);
    if (Util.isNullOrNil(paramCharSequence.toString()))
    {
      this.FRg.startAnimation(this.FRs);
      AppMethodBeat.o(29634);
      return;
    }
    this.FRg.setTextColor(getResources().getColor(paramInt));
    this.FRg.setText(paramCharSequence);
    this.FRg.startAnimation(this.FRr);
    AppMethodBeat.o(29634);
  }
  
  public final void PX(String paramString)
  {
    AppMethodBeat.i(29624);
    Log.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[] { paramString });
    this.yJC = paramString;
    ful();
    display();
    if (!Util.isNullOrNil(paramString))
    {
      PlaySound.play(MMApplicationContext.getContext(), 2131766637, new PlaySound.OnPlayCompletionListener()
      {
        public final void onCompletion() {}
      });
      this.yJN.startTimer(100L);
      AppMethodBeat.o(29624);
      return;
    }
    this.yJN.stopTimer();
    AppMethodBeat.o(29624);
  }
  
  public final void bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29630);
    Log.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    fum();
    if (this.yJA)
    {
      AppMethodBeat.o(29630);
      return;
    }
    fun();
    if (!Util.isNullOrNil(paramString1))
    {
      aSX(getString(2131766609, new Object[] { com.tencent.mm.model.aa.getDisplayName(paramString1) }));
      this.yJK.startTimer(3000L);
    }
    if (!Util.isNullOrNil(paramString2))
    {
      aSX(getString(2131766614, new Object[] { com.tencent.mm.model.aa.getDisplayName(paramString2) }));
      this.yJK.startTimer(3000L);
    }
    AppMethodBeat.o(29630);
  }
  
  public final void bgA()
  {
    AppMethodBeat.i(29619);
    Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
    if (this.yJF != 1)
    {
      AppMethodBeat.o(29619);
      return;
    }
    this.yJF = 5;
    if (Util.ticksToNow(this.yJH) < this.yJG)
    {
      Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
      this.yJI.startTimer(this.yJG - Util.ticksToNow(this.yJH));
      AppMethodBeat.o(29619);
      return;
    }
    edu();
    AppMethodBeat.o(29619);
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(29625);
    if (!this.yJO)
    {
      Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29625);
      return;
    }
    this.yJO = false;
    finish();
    AppMethodBeat.o(29625);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(29626);
    display();
    AppMethodBeat.o(29626);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(29627);
    display();
    AppMethodBeat.o(29627);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(29628);
    l(getString(2131766623), 2131101242);
    AppMethodBeat.o(29628);
  }
  
  public final void bgz()
  {
    AppMethodBeat.i(29616);
    this.yJA = false;
    this.FRh.setEnabled(true);
    this.FRh.setImageResource(2131235200);
    this.FRi.setVisibility(0);
    display();
    fun();
    fum();
    AppMethodBeat.o(29616);
  }
  
  public void finish()
  {
    AppMethodBeat.i(29614);
    super.finish();
    AppMethodBeat.o(29614);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(29621);
    Log.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    aSW("");
    AppMethodBeat.o(29621);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29610);
    Log.d("MicroMsg.TalkRoomUI", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("enter_room_username");
    Log.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[] { paramBundle });
    Log.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[] { paramBundle });
    this.yJB = paramBundle;
    if (Util.isNullOrNil(this.yJB))
    {
      aSW("");
      Log.d("MicroMsg.TalkRoomUI", "onCreate before initView");
      setContentView(com.tencent.mm.ui.aa.jQ(MMApplicationContext.getContext()).inflate(2131496646, null));
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
      this.titleTv = ((TextView)findViewById(2131309249));
      this.FRg = ((TextView)findViewById(2131304658));
      this.hXK = ((TextView)findViewById(2131299258));
      this.FRi = ((Button)findViewById(2131302649));
      this.yJT = ((Chronometer)findViewById(2131298721));
      this.FRj = ((ImageView)findViewById(2131303131));
      this.FRm = new a(this);
      this.FRi.setOnClickListener(new TalkRoomUI.11(this));
      findViewById(2131309597).setOnClickListener(new TalkRoomUI.12(this));
      this.FRh = ((ImageButton)findViewById(2131304657));
      this.FRh.setEnabled(false);
      this.FRh.setImageResource(2131235202);
      this.FRh.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(29603);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(29603);
            return false;
            TalkRoomUI.b(TalkRoomUI.this, TalkRoomUI.a(TalkRoomUI.this, paramAnonymousMotionEvent));
            if (TalkRoomUI.k(TalkRoomUI.this))
            {
              TalkRoomUI.l(TalkRoomUI.this).setImageResource(2131235201);
              PlaySound.play(MMApplicationContext.getContext(), 2131766638, new PlaySound.OnPlayCompletionListener()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(29601);
                  Log.i("MicroMsg.TalkRoomUI", "play press sound end");
                  AppMethodBeat.o(29601);
                }
              });
              TalkRoomUI.a(TalkRoomUI.this, 1);
              TalkRoomUI.d(TalkRoomUI.this);
              Log.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
              TalkRoomUI.a(TalkRoomUI.this, Util.currentTicks());
              b.ftN().bgw();
              TalkRoomUI.m(TalkRoomUI.this);
              continue;
              if ((TalkRoomUI.k(TalkRoomUI.this)) && (!TalkRoomUI.a(TalkRoomUI.this, paramAnonymousMotionEvent)) && (TalkRoomUI.k(TalkRoomUI.this)))
              {
                TalkRoomUI.b(TalkRoomUI.this, false);
                if (TalkRoomUI.b(TalkRoomUI.this) == 5)
                {
                  Log.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
                  TalkRoomUI.n(TalkRoomUI.this).stopTimer();
                  TalkRoomUI.o(TalkRoomUI.this).stopTimer();
                }
                TalkRoomUI.l(TalkRoomUI.this).setImageResource(2131235200);
                TalkRoomUI.a(TalkRoomUI.this, 0);
                TalkRoomUI.d(TalkRoomUI.this);
                TalkRoomUI.p(TalkRoomUI.this).stopTimer();
                b.ftN().bgx();
                PlaySound.play(MMApplicationContext.getContext(), 2131766641, new PlaySound.OnPlayCompletionListener()
                {
                  public final void onCompletion()
                  {
                    AppMethodBeat.i(29602);
                    Log.i("MicroMsg.TalkRoomUI", "play up sound end");
                    AppMethodBeat.o(29602);
                  }
                });
                TalkRoomUI.m(TalkRoomUI.this);
              }
            }
          }
        }
      });
      this.FRk = ((TalkRoomVolumeMeter)findViewById(2131310093));
      paramBundle = new TalkRoomUI.14(this);
      findViewById(2131309371).setOnTouchListener(new TalkRoomUI.15(this, paramBundle));
      this.FRl = ((TalkRoomAvatarsFrame)findViewById(2131297130));
      this.titleTv.setOnClickListener(new TalkRoomUI.16(this));
      this.FRp = new AlphaAnimation(0.0F, 1.0F);
      this.FRp.setDuration(300L);
      this.FRp.setFillAfter(true);
      this.FRq = new AlphaAnimation(1.0F, 0.0F);
      this.FRq.setDuration(300L);
      this.FRq.setFillAfter(true);
      this.FRr = new AlphaAnimation(0.0F, 1.0F);
      this.FRr.setDuration(300L);
      this.FRr.setFillAfter(true);
      this.FRs = new AlphaAnimation(1.0F, 0.0F);
      this.FRs.setDuration(300L);
      this.FRs.setFillAfter(true);
      bg.azz().a(364, this);
      Log.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
      b.ftN().a(this);
      Log.d("MicroMsg.TalkRoomUI", "onCreate end");
      AppMethodBeat.o(29610);
      return;
    }
    List localList;
    if (ab.Eq(paramBundle))
    {
      localList = v.Ic(paramBundle);
      if (localList == null) {
        ay.a.iDq.aL(paramBundle, "");
      }
    }
    for (;;)
    {
      new MMHandler(Looper.getMainLooper()).post(new TalkRoomUI.3(this, paramBundle));
      break;
      this.dSU = localList;
      continue;
      this.dSU.clear();
      this.dSU.add(paramBundle);
      this.dSU.add(z.aTY());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29613);
    b.ftN().b(this);
    bg.azz().b(364, this);
    if ((this.gut != null) && (this.gut.isShowing())) {
      this.gut.cancel();
    }
    super.onDestroy();
    AppMethodBeat.o(29613);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29615);
    if (paramInt == 25)
    {
      com.tencent.mm.plugin.audio.c.a.AX(3);
      AppMethodBeat.o(29615);
      return true;
    }
    if (paramInt == 24)
    {
      com.tencent.mm.plugin.audio.c.a.AW(3);
      AppMethodBeat.o(29615);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29615);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29612);
    super.onPause();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WeChatPermissions.PERMISSION_MM_MESSAGE());
    this.wakeLock.release();
    this.yJN.stopTimer();
    b.ftM().FPB.FPH = false;
    b.ftM();
    Object localObject = b.ftM().FPB;
    if (((c)localObject).yJA) {
      ((c)localObject).aST(MMApplicationContext.getContext().getString(2131766622));
    }
    for (;;)
    {
      localObject = new pg();
      ((pg)localObject).dVo.pause = false;
      EventCenter.instance.asyncPublish((IEvent)localObject, getMainLooper());
      Log.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
      AppMethodBeat.o(29612);
      return;
      if (!Util.isNullOrNil(((c)localObject).yIY))
      {
        String str = MMApplicationContext.getContext().getString(2131766628, new Object[] { com.tencent.mm.model.aa.getDisplayName(((c)localObject).yIY) });
        c.ftU();
        ((c)localObject).aST(str);
      }
      else
      {
        ((c)localObject).aST(com.tencent.mm.plugin.talkroom.model.h.bC(MMApplicationContext.getContext(), b.ftN().FQv));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29611);
    super.onResume();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WeChatPermissions.PERMISSION_MM_MESSAGE());
    this.wakeLock.acquire();
    Object localObject = l.b(this, com.tencent.mm.plugin.talkroom.model.h.bC(this, this.yJB), this.titleTv.getTextSize());
    this.titleTv.setText((CharSequence)localObject);
    b.ftM().FPB.FPH = true;
    b.ftM();
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    b.ftM();
    c.ftU();
    localObject = new pg();
    ((pg)localObject).dVo.pause = true;
    EventCenter.instance.asyncPublish((IEvent)localObject, getMainLooper());
    Log.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    AppMethodBeat.o(29611);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(29622);
    if ((paramq.getType() == 364) && (this.gut != null) && (this.gut.isShowing())) {
      this.gut.cancel();
    }
    AppMethodBeat.o(29622);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29617);
    Log.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[] { paramString });
    paramString = "";
    if (paramInt1 == 4)
    {
      if (paramInt2 != -1)
      {
        this.yJO = false;
        finish();
        AppMethodBeat.o(29617);
        return;
      }
      paramString = getString(2131766619);
    }
    aSW(paramString);
    AppMethodBeat.o(29617);
  }
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(29618);
    Log.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.yJF != 3)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
    for (this.yJF = 4;; this.yJF = 2)
    {
      ful();
      display();
      PlaySound.play(MMApplicationContext.getContext(), 2131766640, true, new PlaySound.OnPlayCompletionListener()
      {
        public final void onCompletion() {}
      });
      AppMethodBeat.o(29618);
      return;
      if (this.yJF != 1)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI
 * JD-Core Version:    0.7.0.1
 */