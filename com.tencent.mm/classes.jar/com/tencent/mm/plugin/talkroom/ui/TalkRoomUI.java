package com.tencent.mm.plugin.talkroom.ui;

import android.app.Activity;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.talkroom.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI
  extends MMBaseActivity
  implements com.tencent.mm.al.g, d
{
  private List<String> dqB;
  private p fqw;
  private float radius;
  private TextView sIt;
  private boolean sSE;
  private String sSF;
  private String sSG;
  private boolean sSI;
  private int sSJ;
  private long sSK;
  private long sSL;
  private av sSM;
  private av sSN;
  private av sSO;
  private final av sSR;
  private boolean sSS;
  private Chronometer sSX;
  private int sSY;
  private TextView titleTv;
  private PowerManager.WakeLock wakeLock;
  private TextView yJZ;
  private ImageButton yKa;
  private Button yKb;
  private ImageView yKc;
  private TalkRoomVolumeMeter yKd;
  private TalkRoomAvatarsFrame yKe;
  private a yKf;
  private boolean yKg;
  private int yKh;
  private AlphaAnimation yKi;
  private AlphaAnimation yKj;
  private AlphaAnimation yKk;
  private AlphaAnimation yKl;
  private float yKm;
  private float yKn;
  
  public TalkRoomUI()
  {
    AppMethodBeat.i(29608);
    this.sSS = true;
    this.dqB = new LinkedList();
    this.sSJ = 0;
    this.sSE = true;
    this.sSN = new av(new TalkRoomUI.1(this), false);
    this.yKg = true;
    this.yKh = 0;
    this.sSR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        int j = 15;
        boolean bool = false;
        AppMethodBeat.i(29597);
        int i;
        if (TalkRoomUI.b(TalkRoomUI.this) == 3)
        {
          i = com.tencent.mm.plugin.talkroom.model.b.dMM().aBW();
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
          if (bt.isNullOrNil(TalkRoomUI.c(TalkRoomUI.this)))
          {
            TalkRoomUI.d(TalkRoomUI.this);
            AppMethodBeat.o(29597);
            return false;
          }
          i = com.tencent.mm.plugin.talkroom.model.b.dMM().aBX();
          break;
          i = 0;
          break label47;
        }
      }
    }, true);
    this.radius = -1.0F;
    this.yKm = -1.0F;
    this.yKn = -1.0F;
    this.sSI = false;
    this.sSK = 500L;
    this.sSL = 0L;
    this.sSM = new av(new TalkRoomUI.5(this), false);
    this.sSO = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29596);
        TalkRoomUI.m(TalkRoomUI.this);
        AppMethodBeat.o(29596);
        return false;
      }
    }, false);
    this.sSY = 0;
    AppMethodBeat.o(29608);
  }
  
  private void Pa(int paramInt)
  {
    AppMethodBeat.i(29635);
    if ((paramInt != 0) && (this.sSY == paramInt))
    {
      AppMethodBeat.o(29635);
      return;
    }
    this.sSX.setVisibility(0);
    this.sSX.startAnimation(this.yKi);
    this.sSX.setBase(bt.GC());
    this.sSX.start();
    this.sSY = paramInt;
    AppMethodBeat.o(29635);
  }
  
  private void asv(String paramString)
  {
    AppMethodBeat.i(29623);
    if (!this.sSS)
    {
      ad.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29623);
      return;
    }
    this.sSS = false;
    com.tencent.mm.plugin.talkroom.model.b.dMM().dNa();
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      if (ay.isConnected(getApplication())) {
        break label79;
      }
    }
    label79:
    for (str = getString(2131764359); isFinishing(); str = getString(2131764358))
    {
      AppMethodBeat.o(29623);
      return;
    }
    com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29595);
        TalkRoomUI.this.finish();
        AppMethodBeat.o(29595);
      }
    });
    AppMethodBeat.o(29623);
  }
  
  private void asw(String paramString)
  {
    AppMethodBeat.i(29633);
    n(k.b(this, paramString, this.yJZ.getTextSize()), 2131101011);
    AppMethodBeat.o(29633);
  }
  
  private void cJT()
  {
    AppMethodBeat.i(29620);
    if (this.sSJ != 5)
    {
      AppMethodBeat.o(29620);
      return;
    }
    this.sSM.stopTimer();
    display();
    dNk();
    bd.a(aj.getContext(), 2131764373, new bd.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(29594);
        TalkRoomUI.o(TalkRoomUI.this).stopTimer();
        TalkRoomUI.a(TalkRoomUI.this);
        AppMethodBeat.o(29594);
      }
    });
    this.sSN.av(1000L, 1000L);
    AppMethodBeat.o(29620);
  }
  
  private void dNk()
  {
    AppMethodBeat.i(29609);
    if ((this.sSJ == 3) || (this.sSJ == 5))
    {
      this.yKd.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    if (!bt.isNullOrNil(this.sSG))
    {
      this.yKd.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    this.yKd.setShowFlame(false);
    AppMethodBeat.o(29609);
  }
  
  private void dNl()
  {
    AppMethodBeat.i(29629);
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.dMM().cJx();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((dbf)((Iterator)localObject).next()).mAQ);
    }
    this.yKe.setMembersList(localLinkedList);
    AppMethodBeat.o(29629);
  }
  
  private void dNm()
  {
    AppMethodBeat.i(29632);
    int i = com.tencent.mm.plugin.talkroom.model.b.dMM().cJx().size();
    ad.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[] { Integer.valueOf(i) });
    this.sIt.setText(String.valueOf(i));
    AppMethodBeat.o(29632);
  }
  
  private void dNn()
  {
    AppMethodBeat.i(29636);
    if (this.sSY == 0)
    {
      AppMethodBeat.o(29636);
      return;
    }
    this.sSX.stop();
    this.sSY = 0;
    this.sSX.startAnimation(this.yKj);
    AppMethodBeat.o(29636);
  }
  
  private void display()
  {
    AppMethodBeat.i(29631);
    if (this.sSE)
    {
      AppMethodBeat.o(29631);
      return;
    }
    if (com.tencent.mm.plugin.talkroom.model.b.dMM().yJC)
    {
      n(getString(2131764360), 2131101012);
      this.yKe.setCurMemeber(null);
      this.yKc.setImageResource(2131234313);
      dNn();
      AppMethodBeat.o(29631);
      return;
    }
    switch (this.sSJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29631);
      return;
      if (!bt.isNullOrNil(this.sSG))
      {
        asw(v.sh(this.sSG));
        this.yKe.setCurMemeber(this.sSG);
        this.yKc.setImageResource(2131234313);
        Pa(1);
        AppMethodBeat.o(29631);
        return;
      }
      if (com.tencent.mm.plugin.talkroom.model.b.dMM().cJx().size() == 1) {}
      for (String str = getString(2131764369);; str = "")
      {
        n(str, 2131101011);
        this.yKe.setCurMemeber(null);
        this.yKc.setImageResource(2131234313);
        dNn();
        AppMethodBeat.o(29631);
        return;
      }
      n(getString(2131764347), 2131101011);
      this.yKc.setImageResource(2131234316);
      AppMethodBeat.o(29631);
      return;
      n(getString(2131764364), 2131101011);
      this.yKe.setCurMemeber(u.aqG());
      this.yKc.setImageResource(2131234314);
      Pa(2);
      AppMethodBeat.o(29631);
      return;
      n(getString(2131764363), 2131101012);
      this.yKc.setImageResource(2131234315);
      AppMethodBeat.o(29631);
      return;
      n(getString(2131764366), 2131101012);
      this.yKc.setImageResource(2131234315);
      dNn();
    }
  }
  
  private void n(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(29634);
    if (bt.isNullOrNil(paramCharSequence.toString()))
    {
      this.yJZ.startAnimation(this.yKl);
      AppMethodBeat.o(29634);
      return;
    }
    this.yJZ.setTextColor(getResources().getColor(paramInt));
    this.yJZ.setText(paramCharSequence);
    this.yJZ.startAnimation(this.yKk);
    AppMethodBeat.o(29634);
  }
  
  public final void aCb()
  {
    AppMethodBeat.i(29616);
    this.sSE = false;
    this.yKa.setEnabled(true);
    this.yKa.setImageResource(2131234317);
    this.yKb.setVisibility(0);
    display();
    dNm();
    dNl();
    AppMethodBeat.o(29616);
  }
  
  public final void aCc()
  {
    AppMethodBeat.i(29619);
    ad.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
    if (this.sSJ != 1)
    {
      AppMethodBeat.o(29619);
      return;
    }
    this.sSJ = 5;
    if (bt.aS(this.sSL) < this.sSK)
    {
      ad.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
      av localav = this.sSM;
      long l = this.sSK - bt.aS(this.sSL);
      localav.av(l, l);
      AppMethodBeat.o(29619);
      return;
    }
    cJT();
    AppMethodBeat.o(29619);
  }
  
  public final void aCd()
  {
    AppMethodBeat.i(29625);
    if (!this.sSS)
    {
      ad.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29625);
      return;
    }
    this.sSS = false;
    finish();
    AppMethodBeat.o(29625);
  }
  
  public final void aCe()
  {
    AppMethodBeat.i(29626);
    display();
    AppMethodBeat.o(29626);
  }
  
  public final void aCf()
  {
    AppMethodBeat.i(29627);
    display();
    AppMethodBeat.o(29627);
  }
  
  public final void aCg()
  {
    AppMethodBeat.i(29628);
    n(getString(2131764362), 2131101012);
    AppMethodBeat.o(29628);
  }
  
  public final void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29630);
    ad.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    dNl();
    if (this.sSE)
    {
      AppMethodBeat.o(29630);
      return;
    }
    dNm();
    if (!bt.isNullOrNil(paramString1))
    {
      asw(getString(2131764348, new Object[] { v.sh(paramString1) }));
      this.sSO.av(3000L, 3000L);
    }
    if (!bt.isNullOrNil(paramString2))
    {
      asw(getString(2131764353, new Object[] { v.sh(paramString2) }));
      this.sSO.av(3000L, 3000L);
    }
    AppMethodBeat.o(29630);
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
    ad.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    asv("");
    AppMethodBeat.o(29621);
  }
  
  public final void oQ(int paramInt)
  {
    AppMethodBeat.i(29618);
    ad.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.sSJ != 3)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
    for (this.sSJ = 4;; this.sSJ = 2)
    {
      dNk();
      display();
      bd.a(aj.getContext(), new bd.a()
      {
        public final void onCompletion() {}
      });
      AppMethodBeat.o(29618);
      return;
      if (this.sSJ != 1)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(29610);
    ad.d("MicroMsg.TalkRoomUI", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("enter_room_username");
    ad.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[] { paramBundle });
    ad.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[] { paramBundle });
    this.sSF = paramBundle;
    if (bt.isNullOrNil(this.sSF))
    {
      asv("");
      ad.d("MicroMsg.TalkRoomUI", "onCreate before initView");
      setContentView(y.js(aj.getContext()).inflate(2131495740, null));
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
      this.titleTv = ((TextView)findViewById(2131305948));
      this.yJZ = ((TextView)findViewById(2131302271));
      this.sIt = ((TextView)findViewById(2131298799));
      this.yKb = ((Button)findViewById(2131301005));
      this.sSX = ((Chronometer)findViewById(2131298329));
      this.yKc = ((ImageView)findViewById(2131301378));
      this.yKf = new a(this);
      this.yKb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29599);
          com.tencent.mm.ui.base.h.a(TalkRoomUI.this, TalkRoomUI.this.getString(2131764355), TalkRoomUI.this.getString(2131764354), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(29598);
              TalkRoomUI.j(TalkRoomUI.this);
              com.tencent.mm.plugin.talkroom.model.b.dMM().dNa();
              TalkRoomUI.this.finish();
              AppMethodBeat.o(29598);
            }
          }, null);
          AppMethodBeat.o(29599);
        }
      });
      findViewById(2131306199).setOnClickListener(new TalkRoomUI.12(this));
      this.yKa = ((ImageButton)findViewById(2131302270));
      this.yKa.setEnabled(false);
      this.yKa.setImageResource(2131234319);
      this.yKa.setOnTouchListener(new View.OnTouchListener()
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
              TalkRoomUI.l(TalkRoomUI.this).setImageResource(2131234318);
              bd.a(aj.getContext(), 2131764377, new bd.a()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(29601);
                  ad.i("MicroMsg.TalkRoomUI", "play press sound end");
                  AppMethodBeat.o(29601);
                }
              });
              TalkRoomUI.a(TalkRoomUI.this, 1);
              TalkRoomUI.d(TalkRoomUI.this);
              ad.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
              TalkRoomUI.a(TalkRoomUI.this, bt.GC());
              com.tencent.mm.plugin.talkroom.model.b.dMM().aBY();
              TalkRoomUI.m(TalkRoomUI.this);
              continue;
              if ((TalkRoomUI.k(TalkRoomUI.this)) && (!TalkRoomUI.a(TalkRoomUI.this, paramAnonymousMotionEvent)) && (TalkRoomUI.k(TalkRoomUI.this)))
              {
                TalkRoomUI.b(TalkRoomUI.this, false);
                if (TalkRoomUI.b(TalkRoomUI.this) == 5)
                {
                  ad.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
                  TalkRoomUI.n(TalkRoomUI.this).stopTimer();
                  TalkRoomUI.o(TalkRoomUI.this).stopTimer();
                }
                TalkRoomUI.l(TalkRoomUI.this).setImageResource(2131234317);
                TalkRoomUI.a(TalkRoomUI.this, 0);
                TalkRoomUI.d(TalkRoomUI.this);
                TalkRoomUI.p(TalkRoomUI.this).stopTimer();
                com.tencent.mm.plugin.talkroom.model.b.dMM().aBZ();
                bd.a(aj.getContext(), 2131764380, new bd.a()
                {
                  public final void onCompletion()
                  {
                    AppMethodBeat.i(29602);
                    ad.i("MicroMsg.TalkRoomUI", "play up sound end");
                    AppMethodBeat.o(29602);
                  }
                });
                TalkRoomUI.m(TalkRoomUI.this);
              }
            }
          }
        }
      });
      this.yKd = ((TalkRoomVolumeMeter)findViewById(2131306633));
      paramBundle = new TalkRoomUI.14(this);
      findViewById(2131306048).setOnTouchListener(new TalkRoomUI.15(this, paramBundle));
      this.yKe = ((TalkRoomAvatarsFrame)findViewById(2131297004));
      this.titleTv.setOnClickListener(new TalkRoomUI.16(this));
      this.yKi = new AlphaAnimation(0.0F, 1.0F);
      this.yKi.setDuration(300L);
      this.yKi.setFillAfter(true);
      this.yKj = new AlphaAnimation(1.0F, 0.0F);
      this.yKj.setDuration(300L);
      this.yKj.setFillAfter(true);
      this.yKk = new AlphaAnimation(0.0F, 1.0F);
      this.yKk.setDuration(300L);
      this.yKk.setFillAfter(true);
      this.yKl = new AlphaAnimation(1.0F, 0.0F);
      this.yKl.setDuration(300L);
      this.yKl.setFillAfter(true);
      az.aeS().a(364, this);
      ad.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
      com.tencent.mm.plugin.talkroom.model.b.dMM().a(this);
      ad.d("MicroMsg.TalkRoomUI", "onCreate end");
      AppMethodBeat.o(29610);
      return;
    }
    List localList;
    if (w.pF(paramBundle))
    {
      localList = com.tencent.mm.model.q.rW(paramBundle);
      if (localList == null) {
        ar.a.gMW.aB(paramBundle, "");
      }
    }
    for (;;)
    {
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29592);
          com.tencent.mm.plugin.talkroom.model.b.dMM().al(paramBundle, 0);
          AppMethodBeat.o(29592);
        }
      });
      break;
      this.dqB = localList;
      continue;
      this.dqB.clear();
      this.dqB.add(paramBundle);
      this.dqB.add(u.aqG());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29613);
    com.tencent.mm.plugin.talkroom.model.b.dMM().b(this);
    az.aeS().b(364, this);
    if ((this.fqw != null) && (this.fqw.isShowing())) {
      this.fqw.cancel();
    }
    super.onDestroy();
    AppMethodBeat.o(29613);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29615);
    if (paramInt == 25)
    {
      com.tencent.mm.plugin.audio.c.a.vP(3);
      AppMethodBeat.o(29615);
      return true;
    }
    if (paramInt == 24)
    {
      com.tencent.mm.plugin.audio.c.a.vO(3);
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
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.release();
    this.sSR.stopTimer();
    com.tencent.mm.plugin.talkroom.model.b.dML().yIu.yIA = false;
    com.tencent.mm.plugin.talkroom.model.b.dML();
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.dML().yIu;
    if (((c)localObject).sSE) {
      ((c)localObject).ass(aj.getContext().getString(2131764361));
    }
    for (;;)
    {
      localObject = new nv();
      ((nv)localObject).dsT.dsU = false;
      com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
      ad.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
      AppMethodBeat.o(29612);
      return;
      if (!bt.isNullOrNil(((c)localObject).sSb))
      {
        String str = aj.getContext().getString(2131764367, new Object[] { v.sh(((c)localObject).sSb) });
        c.dMT();
        ((c)localObject).ass(str);
      }
      else
      {
        ((c)localObject).ass(com.tencent.mm.plugin.talkroom.model.h.bf(aj.getContext(), com.tencent.mm.plugin.talkroom.model.b.dMM().yJo));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29611);
    super.onResume();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
    this.wakeLock.acquire();
    Object localObject = k.b(this, com.tencent.mm.plugin.talkroom.model.h.bf(this, this.sSF), this.titleTv.getTextSize());
    this.titleTv.setText((CharSequence)localObject);
    com.tencent.mm.plugin.talkroom.model.b.dML().yIu.yIA = true;
    com.tencent.mm.plugin.talkroom.model.b.dML();
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    com.tencent.mm.plugin.talkroom.model.b.dML();
    c.dMT();
    localObject = new nv();
    ((nv)localObject).dsT.dsU = true;
    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, getMainLooper());
    ad.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    AppMethodBeat.o(29611);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29622);
    if ((paramn.getType() == 364) && (this.fqw != null) && (this.fqw.isShowing())) {
      this.fqw.cancel();
    }
    AppMethodBeat.o(29622);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29617);
    ad.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[] { paramString });
    paramString = "";
    if (paramInt1 == 4)
    {
      if (paramInt2 != -1)
      {
        this.sSS = false;
        finish();
        AppMethodBeat.o(29617);
        return;
      }
      paramString = getString(2131764358);
    }
    asv(paramString);
    AppMethodBeat.o(29617);
  }
  
  public final void zy(String paramString)
  {
    AppMethodBeat.i(29624);
    ad.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[] { paramString });
    this.sSG = paramString;
    dNk();
    display();
    if (!bt.isNullOrNil(paramString))
    {
      bd.a(aj.getContext(), 2131764376, new bd.a()
      {
        public final void onCompletion() {}
      });
      this.sSR.av(100L, 100L);
      AppMethodBeat.o(29624);
      return;
    }
    this.sSR.stopTimer();
    AppMethodBeat.o(29624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI
 * JD-Core Version:    0.7.0.1
 */