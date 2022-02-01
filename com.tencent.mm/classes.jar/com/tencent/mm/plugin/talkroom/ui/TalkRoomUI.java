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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.rr;
import com.tencent.mm.bc.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.talkroom.model.c;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.protocal.protobuf.fly;
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
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI
  extends MMBaseActivity
  implements com.tencent.mm.am.h, d
{
  private boolean Kgb;
  private String Kgc;
  private String Kgd;
  private boolean Kgf;
  private int Kgg;
  private long Kgh;
  private long Kgi;
  private MTimerHandler Kgj;
  private MTimerHandler Kgk;
  private MTimerHandler Kgl;
  private final MTimerHandler Kgo;
  private boolean Kgp;
  private Chronometer Kgu;
  private int Kgv;
  private TextView SOB;
  private ImageButton SOC;
  private Button SOD;
  private ImageView SOE;
  private TalkRoomVolumeMeter SOF;
  private TalkRoomAvatarsFrame SOG;
  private a SOH;
  private boolean SOI;
  private int SOJ;
  private AlphaAnimation SOK;
  private AlphaAnimation SOL;
  private AlphaAnimation SOM;
  private AlphaAnimation SON;
  private float SOO;
  private float SOP;
  private List<String> hSb;
  private TextView noi;
  private w psR;
  private float radius;
  private TextView titleTv;
  private PowerManager.WakeLock wakeLock;
  
  public TalkRoomUI()
  {
    AppMethodBeat.i(29608);
    this.Kgp = true;
    this.hSb = new LinkedList();
    this.Kgg = 0;
    this.Kgb = true;
    this.Kgk = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29590);
        Log.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
        TalkRoomUI.a(TalkRoomUI.this);
        AppMethodBeat.o(29590);
        return false;
      }
    }, false);
    this.SOI = true;
    this.SOJ = 0;
    this.Kgo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        int j = 15;
        boolean bool = false;
        AppMethodBeat.i(29597);
        int i;
        if (TalkRoomUI.b(TalkRoomUI.this) == 3)
        {
          i = com.tencent.mm.plugin.talkroom.model.b.hCo().bNq();
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
          i = com.tencent.mm.plugin.talkroom.model.b.hCo().bNr();
          break;
          i = 0;
          break label47;
        }
      }
    }, true);
    this.radius = -1.0F;
    this.SOO = -1.0F;
    this.SOP = -1.0F;
    this.Kgf = false;
    this.Kgh = 500L;
    this.Kgi = 0L;
    this.Kgj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29593);
        Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
        TalkRoomUI.q(TalkRoomUI.this);
        AppMethodBeat.o(29593);
        return false;
      }
    }, false);
    this.Kgl = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29596);
        TalkRoomUI.m(TalkRoomUI.this);
        AppMethodBeat.o(29596);
        return false;
      }
    }, false);
    this.Kgv = 0;
    AppMethodBeat.o(29608);
  }
  
  private void anR(int paramInt)
  {
    AppMethodBeat.i(29635);
    if ((paramInt != 0) && (this.Kgv == paramInt))
    {
      AppMethodBeat.o(29635);
      return;
    }
    this.Kgu.setVisibility(0);
    this.Kgu.startAnimation(this.SOK);
    this.Kgu.setBase(Util.currentTicks());
    this.Kgu.start();
    this.Kgv = paramInt;
    AppMethodBeat.o(29635);
  }
  
  private void bdi(String paramString)
  {
    AppMethodBeat.i(29623);
    if (!this.Kgp)
    {
      Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29623);
      return;
    }
    this.Kgp = false;
    com.tencent.mm.plugin.talkroom.model.b.hCo().hCE();
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      if (NetStatusUtil.isConnected(getApplication())) {
        break label79;
      }
    }
    label79:
    for (str = getString(R.l.gWS); isFinishing(); str = getString(R.l.gWR))
    {
      AppMethodBeat.o(29623);
      return;
    }
    k.d(this, str, "", new DialogInterface.OnClickListener()
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
  
  private void fVg()
  {
    AppMethodBeat.i(29620);
    if (this.Kgg != 5)
    {
      AppMethodBeat.o(29620);
      return;
    }
    this.Kgj.stopTimer();
    fVh();
    hCN();
    PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_begin, new PlaySound.OnPlayCompletionListener()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(29594);
        TalkRoomUI.o(TalkRoomUI.this).stopTimer();
        TalkRoomUI.a(TalkRoomUI.this);
        AppMethodBeat.o(29594);
      }
    });
    this.Kgk.startTimer(1000L);
    AppMethodBeat.o(29620);
  }
  
  private void fVh()
  {
    AppMethodBeat.i(29631);
    if (this.Kgb)
    {
      AppMethodBeat.o(29631);
      return;
    }
    if (com.tencent.mm.plugin.talkroom.model.b.hCo().GNB)
    {
      i(getString(R.l.gWT), R.e.fla);
      this.SOG.setCurMemeber(null);
      this.SOE.setImageResource(R.g.fpq);
      hCQ();
      AppMethodBeat.o(29631);
      return;
    }
    switch (this.Kgg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29631);
      return;
      if (!Util.isNullOrNil(this.Kgd))
      {
        ho(aa.getDisplayName(this.Kgd), R.e.fkZ);
        this.SOG.setCurMemeber(this.Kgd);
        this.SOE.setImageResource(R.g.fpq);
        anR(1);
        AppMethodBeat.o(29631);
        return;
      }
      if (com.tencent.mm.plugin.talkroom.model.b.hCo().fUJ().size() == 1) {}
      for (String str = getString(R.l.gXb);; str = "")
      {
        i(str, R.e.fkZ);
        this.SOG.setCurMemeber(null);
        this.SOE.setImageResource(R.g.fpq);
        hCQ();
        AppMethodBeat.o(29631);
        return;
      }
      i(getString(R.l.gWH), R.e.fkZ);
      this.SOE.setImageResource(R.g.fpu);
      AppMethodBeat.o(29631);
      return;
      i(getString(R.l.gWX), R.e.fkZ);
      this.SOG.setCurMemeber(z.bAM());
      this.SOE.setImageResource(R.g.fpr);
      anR(2);
      AppMethodBeat.o(29631);
      return;
      i(getString(R.l.gWW), R.e.fla);
      this.SOE.setImageResource(R.g.fpt);
      AppMethodBeat.o(29631);
      return;
      i(getString(R.l.gWY), R.e.fla);
      this.SOE.setImageResource(R.g.fpt);
      hCQ();
    }
  }
  
  private void hCN()
  {
    AppMethodBeat.i(29609);
    if ((this.Kgg == 3) || (this.Kgg == 5))
    {
      this.SOF.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    if (!Util.isNullOrNil(this.Kgd))
    {
      this.SOF.setShowFlame(true);
      AppMethodBeat.o(29609);
      return;
    }
    this.SOF.setShowFlame(false);
    AppMethodBeat.o(29609);
  }
  
  private void hCO()
  {
    AppMethodBeat.i(29629);
    Object localObject = com.tencent.mm.plugin.talkroom.model.b.hCo().fUJ();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((fly)((Iterator)localObject).next()).UserName);
    }
    this.SOG.setMembersList(localLinkedList);
    AppMethodBeat.o(29629);
  }
  
  private void hCP()
  {
    AppMethodBeat.i(29632);
    int i = com.tencent.mm.plugin.talkroom.model.b.hCo().fUJ().size();
    Log.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[] { Integer.valueOf(i) });
    this.noi.setText(String.valueOf(i));
    AppMethodBeat.o(29632);
  }
  
  private void hCQ()
  {
    AppMethodBeat.i(29636);
    if (this.Kgv == 0)
    {
      AppMethodBeat.o(29636);
      return;
    }
    this.Kgu.stop();
    this.Kgv = 0;
    this.Kgu.startAnimation(this.SOL);
    AppMethodBeat.o(29636);
  }
  
  private void ho(String paramString, int paramInt)
  {
    AppMethodBeat.i(262693);
    i(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramString, this.SOB.getTextSize()), paramInt);
    AppMethodBeat.o(262693);
  }
  
  private void i(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(29634);
    if (Util.isNullOrNil(paramCharSequence.toString()))
    {
      this.SOB.startAnimation(this.SON);
      AppMethodBeat.o(29634);
      return;
    }
    this.SOB.setTextColor(getResources().getColor(paramInt));
    this.SOB.setText(paramCharSequence);
    this.SOB.startAnimation(this.SOM);
    AppMethodBeat.o(29634);
  }
  
  public final void Pw(String paramString)
  {
    AppMethodBeat.i(29624);
    Log.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[] { paramString });
    this.Kgd = paramString;
    hCN();
    fVh();
    if (!Util.isNullOrNil(paramString))
    {
      PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_othersbegin, new PlaySound.OnPlayCompletionListener()
      {
        public final void onCompletion() {}
      });
      this.Kgo.startTimer(100L);
      AppMethodBeat.o(29624);
      return;
    }
    this.Kgo.stopTimer();
    AppMethodBeat.o(29624);
  }
  
  public final void bNv()
  {
    AppMethodBeat.i(29616);
    this.Kgb = false;
    this.SOC.setEnabled(true);
    this.SOC.setImageResource(R.g.fpv);
    this.SOD.setVisibility(0);
    fVh();
    hCP();
    hCO();
    AppMethodBeat.o(29616);
  }
  
  public final void bNw()
  {
    AppMethodBeat.i(29619);
    Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
    if (this.Kgg != 1)
    {
      AppMethodBeat.o(29619);
      return;
    }
    this.Kgg = 5;
    if (Util.ticksToNow(this.Kgi) < this.Kgh)
    {
      Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
      this.Kgj.startTimer(this.Kgh - Util.ticksToNow(this.Kgi));
      AppMethodBeat.o(29619);
      return;
    }
    fVg();
    AppMethodBeat.o(29619);
  }
  
  public final void bNx()
  {
    AppMethodBeat.i(29625);
    if (!this.Kgp)
    {
      Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
      AppMethodBeat.o(29625);
      return;
    }
    this.Kgp = false;
    finish();
    AppMethodBeat.o(29625);
  }
  
  public final void bNy()
  {
    AppMethodBeat.i(29626);
    fVh();
    AppMethodBeat.o(29626);
  }
  
  public final void bNz()
  {
    AppMethodBeat.i(29627);
    fVh();
    AppMethodBeat.o(29627);
  }
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29630);
    Log.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    hCO();
    if (this.Kgb)
    {
      AppMethodBeat.o(29630);
      return;
    }
    hCP();
    if (!Util.isNullOrNil(paramString1))
    {
      ho(getString(R.l.gWI, new Object[] { aa.getDisplayName(paramString1) }), R.e.fkZ);
      this.Kgl.startTimer(3000L);
    }
    if (!Util.isNullOrNil(paramString2))
    {
      ho(getString(R.l.gWM, new Object[] { aa.getDisplayName(paramString2) }), R.e.fkZ);
      this.Kgl.startTimer(3000L);
    }
    AppMethodBeat.o(29630);
  }
  
  public void finish()
  {
    AppMethodBeat.i(29614);
    super.finish();
    AppMethodBeat.o(29614);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(29621);
    Log.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bdi("");
    AppMethodBeat.o(29621);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(29610);
    Log.d("MicroMsg.TalkRoomUI", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("enter_room_username");
    Log.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[] { paramBundle });
    Log.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[] { paramBundle });
    this.Kgc = paramBundle;
    if (Util.isNullOrNil(this.Kgc))
    {
      bdi("");
      Log.d("MicroMsg.TalkRoomUI", "onCreate before initView");
      setContentView(af.mU(MMApplicationContext.getContext()).inflate(R.i.goy, null));
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
      this.titleTv = ((TextView)findViewById(R.h.title_tv));
      this.SOB = ((TextView)findViewById(R.h.fOi));
      this.noi = ((TextView)findViewById(R.h.count_tv));
      this.SOD = ((Button)findViewById(R.h.fKA));
      this.Kgu = ((Chronometer)findViewById(R.h.chronometer));
      this.SOE = ((ImageView)findViewById(R.h.fMI));
      this.SOH = new a(this);
      this.SOD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29599);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.a(TalkRoomUI.this, TalkRoomUI.this.getString(R.l.gWO), TalkRoomUI.this.getString(R.l.gWN), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(29598);
              TalkRoomUI.j(TalkRoomUI.this);
              com.tencent.mm.plugin.talkroom.model.b.hCo().hCE();
              TalkRoomUI.this.finish();
              AppMethodBeat.o(29598);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29599);
        }
      });
      findViewById(R.h.gbl).setOnClickListener(new TalkRoomUI.12(this));
      this.SOC = ((ImageButton)findViewById(R.h.fOh));
      this.SOC.setEnabled(false);
      this.SOC.setImageResource(R.g.fpx);
      this.SOC.setOnTouchListener(new View.OnTouchListener()
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
              TalkRoomUI.l(TalkRoomUI.this).setImageResource(R.g.fpw);
              PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_press, new PlaySound.OnPlayCompletionListener()
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
              com.tencent.mm.plugin.talkroom.model.b.hCo().bNs();
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
                TalkRoomUI.l(TalkRoomUI.this).setImageResource(R.g.fpv);
                TalkRoomUI.a(TalkRoomUI.this, 0);
                TalkRoomUI.d(TalkRoomUI.this);
                TalkRoomUI.p(TalkRoomUI.this).stopTimer();
                com.tencent.mm.plugin.talkroom.model.b.hCo().bNt();
                PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_up, new PlaySound.OnPlayCompletionListener()
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
      this.SOF = ((TalkRoomVolumeMeter)findViewById(R.h.volume_meter));
      paramBundle = new TalkRoomUI.14(this);
      findViewById(R.h.gaE).setOnTouchListener(new TalkRoomUI.15(this, paramBundle));
      this.SOG = ((TalkRoomAvatarsFrame)findViewById(R.h.avatar_frame));
      this.titleTv.setOnClickListener(new TalkRoomUI.16(this));
      this.SOK = new AlphaAnimation(0.0F, 1.0F);
      this.SOK.setDuration(300L);
      this.SOK.setFillAfter(true);
      this.SOL = new AlphaAnimation(1.0F, 0.0F);
      this.SOL.setDuration(300L);
      this.SOL.setFillAfter(true);
      this.SOM = new AlphaAnimation(0.0F, 1.0F);
      this.SOM.setDuration(300L);
      this.SOM.setFillAfter(true);
      this.SON = new AlphaAnimation(1.0F, 0.0F);
      this.SON.setDuration(300L);
      this.SON.setFillAfter(true);
      bh.aZW().a(364, this);
      Log.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
      com.tencent.mm.plugin.talkroom.model.b.hCo().a(this);
      Log.d("MicroMsg.TalkRoomUI", "onCreate end");
      AppMethodBeat.o(29610);
      return;
    }
    List localList;
    if (au.bwE(paramBundle))
    {
      localList = v.Il(paramBundle);
      if (localList == null) {
        az.a.okP.aZ(paramBundle, "");
      }
    }
    for (;;)
    {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29592);
          com.tencent.mm.plugin.talkroom.model.b.hCo().ba(paramBundle, 0);
          AppMethodBeat.o(29592);
        }
      });
      break;
      this.hSb = localList;
      continue;
      this.hSb.clear();
      this.hSb.add(paramBundle);
      this.hSb.add(z.bAM());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29613);
    com.tencent.mm.plugin.talkroom.model.b.hCo().b(this);
    bh.aZW().b(364, this);
    if ((this.psR != null) && (this.psR.isShowing())) {
      this.psR.cancel();
    }
    super.onDestroy();
    AppMethodBeat.o(29613);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29615);
    if (paramInt == 25)
    {
      com.tencent.mm.plugin.audio.c.a.EZ(3);
      AppMethodBeat.o(29615);
      return true;
    }
    if (paramInt == 24)
    {
      com.tencent.mm.plugin.audio.c.a.EY(3);
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
    Object localObject = this.wakeLock;
    com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    ((PowerManager.WakeLock)localObject).release();
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    this.Kgo.stopTimer();
    com.tencent.mm.plugin.talkroom.model.b.hCs().SNd = false;
    com.tencent.mm.plugin.talkroom.model.b.hCs();
    localObject = com.tencent.mm.plugin.talkroom.model.b.hCs();
    if (((c)localObject).Kgb) {
      ((c)localObject).bdf(MMApplicationContext.getContext().getString(R.l.gWU));
    }
    for (;;)
    {
      localObject = new rr();
      ((rr)localObject).hUK.pause = false;
      ((rr)localObject).asyncPublish(getMainLooper());
      Log.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
      AppMethodBeat.o(29612);
      return;
      if (!Util.isNullOrNil(((c)localObject).Kfz))
      {
        String str = MMApplicationContext.getContext().getString(R.l.gWZ, new Object[] { aa.getDisplayName(((c)localObject).Kfz) });
        c.hCx();
        ((c)localObject).bdf(str);
      }
      else
      {
        ((c)localObject).bdf(com.tencent.mm.plugin.talkroom.model.h.bU(MMApplicationContext.getContext(), com.tencent.mm.plugin.talkroom.model.b.hCo().SNR));
      }
    }
  }
  
  public final void onReconnect()
  {
    AppMethodBeat.i(29628);
    i(getString(R.l.gWV), R.e.fla);
    AppMethodBeat.o(29628);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29611);
    super.onResume();
    sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WeChatPermissions.PERMISSION_MM_MESSAGE());
    Object localObject = this.wakeLock;
    com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI", "onResume", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    ((PowerManager.WakeLock)localObject).acquire();
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI", "onResume", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    localObject = com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.plugin.talkroom.model.h.bU(this, this.Kgc), this.titleTv.getTextSize());
    this.titleTv.setText((CharSequence)localObject);
    com.tencent.mm.plugin.talkroom.model.b.hCs().SNd = true;
    com.tencent.mm.plugin.talkroom.model.b.hCs();
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    com.tencent.mm.plugin.talkroom.model.b.hCs();
    c.hCx();
    localObject = new rr();
    ((rr)localObject).hUK.pause = true;
    ((rr)localObject).asyncPublish(getMainLooper());
    Log.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    AppMethodBeat.o(29611);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(29622);
    if ((paramp.getType() == 364) && (this.psR != null) && (this.psR.isShowing())) {
      this.psR.cancel();
    }
    AppMethodBeat.o(29622);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29617);
    Log.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[] { paramString });
    paramString = "";
    if (paramInt1 == 4)
    {
      if (paramInt2 != -1)
      {
        this.Kgp = false;
        finish();
        AppMethodBeat.o(29617);
        return;
      }
      paramString = getString(R.l.gWR);
    }
    bdi(paramString);
    AppMethodBeat.o(29617);
  }
  
  public final void wZ(int paramInt)
  {
    AppMethodBeat.i(29618);
    Log.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.Kgg != 3)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
    for (this.Kgg = 4;; this.Kgg = 2)
    {
      hCN();
      fVh();
      PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_sasasa, true, new PlaySound.OnPlayCompletionListener()
      {
        public final void onCompletion() {}
      });
      AppMethodBeat.o(29618);
      return;
      if (this.Kgg != 1)
      {
        AppMethodBeat.o(29618);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI
 * JD-Core Version:    0.7.0.1
 */