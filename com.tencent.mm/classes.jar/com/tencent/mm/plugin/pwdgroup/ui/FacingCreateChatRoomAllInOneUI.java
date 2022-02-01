package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements i
{
  private a BoA;
  private View BoB;
  private TextView BoC;
  private MMScrollGridView BoD;
  private View BoE;
  private View BoF;
  private Button BoG;
  private MMCallBackScrollView BoH;
  private TextView BoI;
  private boolean BoJ;
  private Runnable BoK;
  private MMHandler BoL;
  private MTimerHandler BoM;
  private com.tencent.mm.plugin.pwdgroup.a.a BoN;
  private com.tencent.mm.plugin.pwdgroup.a.a BoO;
  private int BoP;
  private Animation BoQ;
  private AnimationSet BoR;
  private Animation BoS;
  public MenuItem.OnMenuItemClickListener BoT;
  public MMPwdInputView.a BoU;
  private View.OnClickListener BoV;
  public MMKeyBoardView.a BoW;
  private MTimerHandler BoX;
  private d Boh;
  private boolean Boi;
  private boolean Boj;
  private boolean Bok;
  private boolean Bol;
  private boolean Bom;
  private Location Bon;
  private String Boo;
  private MMPwdInputView Bop;
  private View Boq;
  private ProgressBar Bor;
  private TextView Bos;
  private MMKeyBoardView Bot;
  private TextView Bou;
  private boolean Bov;
  private boolean Bow;
  private LinkedList<amg> Box;
  private HashMap<String, amg> Boy;
  private LinkedList<amg> Boz;
  private b.a gmA;
  private String gwF;
  private ProgressDialog jZH;
  private MMHandler mHandler;
  private boolean pjO;
  private boolean uSu;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.Boi = false;
    this.Bom = false;
    this.Bov = false;
    this.Bow = false;
    this.pjO = false;
    this.Box = new LinkedList();
    this.Boy = new HashMap();
    this.Boz = new LinkedList();
    this.BoJ = false;
    this.BoM = new MTimerHandler(new FacingCreateChatRoomAllInOneUI.1(this), false);
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27632);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(27632);
          return;
          if (FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this) != null)
          {
            FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this).setData(FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this));
            AppMethodBeat.o(27632);
            return;
            FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
          }
        }
      }
    };
    this.BoT = new FacingCreateChatRoomAllInOneUI.12(this);
    this.BoU = new MMPwdInputView.a()
    {
      public final void z(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(27634);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, paramAnonymousString);
        if (paramAnonymousBoolean)
        {
          FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, true);
          FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
        }
        AppMethodBeat.o(27634);
      }
    };
    this.BoV = new FacingCreateChatRoomAllInOneUI.14(this);
    this.BoW = new MMKeyBoardView.a()
    {
      public final void byC()
      {
        AppMethodBeat.i(27637);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).byC();
        }
        AppMethodBeat.o(27637);
      }
      
      public final void delete()
      {
        AppMethodBeat.i(27638);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null)
        {
          if ((FacingCreateChatRoomAllInOneUI.h(FacingCreateChatRoomAllInOneUI.this)) || (FacingCreateChatRoomAllInOneUI.i(FacingCreateChatRoomAllInOneUI.this)))
          {
            FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).byC();
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.Bpd);
            AppMethodBeat.o(27638);
            return;
          }
          MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
          if (localMMPwdInputView.sWx > 0) {
            localMMPwdInputView.gBy.deleteCharAt(localMMPwdInputView.sWx - 1);
          }
          localMMPwdInputView.cTV();
          localMMPwdInputView.eFX();
        }
        AppMethodBeat.o(27638);
      }
      
      public final void input(String paramAnonymousString)
      {
        AppMethodBeat.i(27636);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null)
        {
          if ((FacingCreateChatRoomAllInOneUI.h(FacingCreateChatRoomAllInOneUI.this)) || (FacingCreateChatRoomAllInOneUI.i(FacingCreateChatRoomAllInOneUI.this)))
          {
            MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
            localMMPwdInputView.byC();
            localMMPwdInputView.input(paramAnonymousString);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.Bpd);
            AppMethodBeat.o(27636);
            return;
          }
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).input(paramAnonymousString);
        }
        AppMethodBeat.o(27636);
      }
    };
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.gnj())
          {
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, localLocation);
            FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, true);
            FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(27640);
          return false;
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.bcc()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(2131761461), FacingCreateChatRoomAllInOneUI.this.getString(2131755998), FacingCreateChatRoomAllInOneUI.this.getString(2131762043), FacingCreateChatRoomAllInOneUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cZ(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.BoX = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.Bpg);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.Bos != null) {}
    switch (10.Bpb[parama.ordinal()])
    {
    default: 
      Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      sQ(true);
      this.Boi = false;
      this.Bom = false;
      this.Bor.setVisibility(8);
      this.Bos.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      sQ(false);
      this.Bos.setText(2131764167);
      this.Bor.setVisibility(0);
      this.Bos.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      sQ(true);
      this.Bor.setVisibility(8);
      this.Bos.setVisibility(0);
      this.Bos.setText(2131764164);
      eFV();
      AppMethodBeat.o(27658);
      return;
    }
    sQ(true);
    this.Bor.setVisibility(8);
    this.Bos.setVisibility(0);
    this.Bos.setText(2131764166);
    eFV();
    AppMethodBeat.o(27658);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(27660);
    h.a(this, paramString, "", getString(2131755921), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void bnD()
  {
    AppMethodBeat.i(27648);
    this.Boh = d.bca();
    this.Boh.a(this.gmA, true);
    bg.azz().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void eFT()
  {
    AppMethodBeat.i(27661);
    this.pjO = false;
    if (this.BoM != null) {
      this.BoM.startTimer(0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void eFU()
  {
    AppMethodBeat.i(27662);
    this.pjO = true;
    if (this.BoM != null) {
      this.BoM.stopTimer();
    }
    bg.azz().a(this.BoN);
    AppMethodBeat.o(27662);
  }
  
  private void eFV()
  {
    AppMethodBeat.i(27663);
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, 2130771982);
    final Animation localAnimation2 = AnimationUtils.loadAnimation(this, 2130771981);
    localAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimation1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(27629);
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).byC();
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).startAnimation(localAnimation2);
        AppMethodBeat.o(27629);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localAnimation2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(27630);
        if (FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this).setKeyBoardEnable(true);
        }
        AppMethodBeat.o(27630);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (this.Bop != null) {
      this.Bop.startAnimation(localAnimation1);
    }
    if (this.Bot != null) {
      this.Bot.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.Bot != null) {
      this.Bot.setKeyBoardEnable(paramBoolean);
    }
    AppMethodBeat.o(27657);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494103;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27654);
    setMMTitle(2131759433);
    setBackBtn(this.BoT);
    setActionbarColor(getResources().getColor(2131101287));
    this.Boq = findViewById(2131300414);
    this.Bor = ((ProgressBar)findViewById(2131300413));
    this.Bos = ((TextView)findViewById(2131300415));
    this.Bot = ((MMKeyBoardView)findViewById(2131300412));
    this.Bou = ((TextView)findViewById(2131300411));
    this.Bop = ((MMPwdInputView)findViewById(2131300409));
    this.Bop.setOnFinishInputListener(this.BoU);
    this.Bop.requestFocus();
    this.Bot.setOnInputDeleteListener(this.BoW);
    a(a.Bpd);
    this.BoB = findViewById(2131300402);
    this.BoC = ((TextView)findViewById(2131300404));
    this.BoD = ((MMScrollGridView)findViewById(2131300403));
    this.BoD.setVisibility(4);
    this.BoG = ((Button)findViewById(2131300405));
    this.BoG.setOnClickListener(this.BoV);
    this.BoE = findViewById(2131300406);
    this.BoF = findViewById(2131300407);
    this.BoC.setText(2131759137);
    this.BoH = ((MMCallBackScrollView)findViewById(2131300416));
    this.BoI = ((TextView)findViewById(2131300410));
    this.BoH.setMMOnScrollListener(new MMCallBackScrollView.a()
    {
      public final void onScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(27624);
        if (FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this) != null)
        {
          if (paramAnonymousInt == 0)
          {
            FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this).setVisibility(4);
            AppMethodBeat.o(27624);
            return;
          }
          FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
        }
        AppMethodBeat.o(27624);
      }
    });
    this.BoA = new a(this);
    this.BoD.setAdapter(this.BoA);
    this.BoA.setData(this.Box);
    AppMethodBeat.o(27654);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27653);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30764)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
          AppMethodBeat.o(27653);
          return;
        }
        finish();
        AppMethodBeat.o(27653);
        return;
      }
      finish();
    }
    AppMethodBeat.o(27653);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27656);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(27656);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27647);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          AppMethodBeat.o(27647);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        AppMethodBeat.o(27647);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
      Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27647);
        return;
      }
    }
    bnD();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    bg.azz().b(653, this);
    if (this.Boh != null) {
      this.Boh.c(this.gmA);
    }
    if (!this.Bow)
    {
      bg.azz().cancel(653);
      if (this.Bon != null)
      {
        this.BoO = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.Boo, "", this.Bon.iUY, this.Bon.iUZ, this.Bon.accuracy, this.Bon.dTl, this.Bon.mac, this.Bon.dTn);
        bg.azz().a(this.BoO, 0);
      }
    }
    if (this.BoJ) {
      eFU();
    }
    if ((this.BoL != null) && (this.BoK != null)) {
      this.BoL.removeCallbacks(this.BoK);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.Boh != null) {
      this.Boh.c(this.gmA);
    }
    if (this.BoJ) {
      eFU();
    }
    super.onPause();
    AppMethodBeat.o(27651);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27649);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27649);
      return;
    }
    Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27649);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bnD();
        AppMethodBeat.o(27649);
        return;
      }
      h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new FacingCreateChatRoomAllInOneUI.18(this), new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.Boh != null) {
      this.Boh.a(this.gmA, true);
    }
    if (this.BoJ) {
      eFT();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(27655);
    Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramq.getType())
    {
    default: 
      Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
    }
    label609:
    do
    {
      int i;
      do
      {
        do
        {
          AppMethodBeat.o(27655);
          return;
          paramq = (com.tencent.mm.plugin.pwdgroup.a.a)paramq;
          i = paramq.dKp;
          if (i != 0) {
            break label609;
          }
          this.Bol = false;
          if (!this.BoJ) {
            break;
          }
          if (this.BoM != null) {
            this.BoM.startTimer(3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramq.eFS().KGQ;
        if (this.BoL == null) {
          this.BoL = new MMHandler("FacingCreateChatRoomAllInOneUI");
        }
        if (this.BoK != null) {
          this.BoL.removeCallbacks(this.BoK);
        }
        this.BoK = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27628);
            if (FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this) != null) {
              FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this).clear();
            }
            if (FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this) != null) {
              FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).clear();
            }
            Object localObject;
            if ((paramString != null) && (paramString.size() > 0))
            {
              j = paramString.size();
              i = 0;
              while (i < j)
              {
                localObject = (amg)paramString.get(i);
                if (!Util.isNullOrNil(((amg)localObject).LuX)) {
                  FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).put(((amg)localObject).LuX, localObject);
                }
                i += 1;
              }
            }
            int j = FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).size();
            int i = 0;
            if (i < j)
            {
              localObject = (amg)FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).get(i);
              if (!FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).containsKey(((amg)localObject).LuX)) {
                Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((amg)localObject).LuX });
              }
              for (;;)
              {
                i += 1;
                break;
                FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).remove(((amg)localObject).LuX);
              }
            }
            if ((FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this) != null) && (FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).size() > 0))
            {
              localObject = FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).entrySet().iterator();
              while (((Iterator)localObject).hasNext())
              {
                amg localamg = (amg)((Map.Entry)((Iterator)localObject).next()).getValue();
                FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this).add(localamg);
                Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localamg.LuX });
              }
            }
            FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).addAll(FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this));
            FacingCreateChatRoomAllInOneUI.u(FacingCreateChatRoomAllInOneUI.this).sendEmptyMessage(10001);
            AppMethodBeat.o(27628);
          }
        };
        this.BoL.post(this.BoK);
        this.gwF = paramq.eFS().Bri;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.Bpd);
          this.BoP = this.Bou.getHeight();
          Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.BoP) });
          this.BoQ = AnimationUtils.loadAnimation(this, 2130772050);
          this.BoS = AnimationUtils.loadAnimation(this, 2130772040);
          this.BoR = new AnimationSet(true);
          this.BoR.addAnimation(AnimationUtils.loadAnimation(this, 2130772149));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.BoP);
          paramString.setDuration(300L);
          this.BoR.addAnimation(paramString);
          this.BoQ.setDuration(200L);
          this.BoR.setDuration(300L);
          this.BoS.setDuration(300L);
          this.BoQ.setInterpolator(new AccelerateDecelerateInterpolator());
          this.BoR.setInterpolator(new AccelerateDecelerateInterpolator());
          this.BoS.setInterpolator(new AccelerateDecelerateInterpolator());
          this.BoR.setFillAfter(true);
          paramString.setFillAfter(true);
          this.BoR.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(27626);
              FacingCreateChatRoomAllInOneUI.n(FacingCreateChatRoomAllInOneUI.this).setVisibility(8);
              FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
              FacingCreateChatRoomAllInOneUI.o(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
              FacingCreateChatRoomAllInOneUI.p(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
              FacingCreateChatRoomAllInOneUI.m(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
              FacingCreateChatRoomAllInOneUI.q(FacingCreateChatRoomAllInOneUI.this).setVisibility(8);
              FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this).setVisibility(8);
              FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).clearAnimation();
              FacingCreateChatRoomAllInOneUI.o(FacingCreateChatRoomAllInOneUI.this).clearAnimation();
              FacingCreateChatRoomAllInOneUI.m(FacingCreateChatRoomAllInOneUI.this).clearAnimation();
              AppMethodBeat.o(27626);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(27625);
              FacingCreateChatRoomAllInOneUI.m(FacingCreateChatRoomAllInOneUI.this).setVisibility(4);
              AppMethodBeat.o(27625);
            }
          });
          this.Bop.setVisibility(4);
          this.Bop.setAnimation(paramString);
          this.Bot.startAnimation(this.BoQ);
          this.Boq.startAnimation(this.BoQ);
          this.Bou.startAnimation(this.BoQ);
          this.BoE.startAnimation(this.BoS);
          this.BoB.startAnimation(this.BoR);
          this.BoE.setVisibility(4);
          this.Bot.setVisibility(8);
          this.Bou.setVisibility(8);
          this.BoJ = true;
          eFT();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.Boi = true;
          a(a.Bpf);
          AppMethodBeat.o(27655);
          return;
        }
        this.Boi = true;
        a(a.Bpg);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.Bpf);
        this.Boi = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.Bpg);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label901;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramq.eFS().KGO;
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.Bow = true;
        finish();
        paramq = new Intent();
        paramq.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.jRt.d(paramq, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.Bov))
      {
        this.Bov = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      amW(getString(2131759139));
    } while (this.BoM == null);
    this.BoM.startTimer(3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.Dk(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.BoM != null) {
        this.BoM.startTimer(3000L);
      }
      AppMethodBeat.o(27655);
      return;
      amW(getString(2131764166));
    }
    label901:
    hideLoading();
    AppMethodBeat.o(27655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(27645);
      Bpd = new a("Normal", 0);
      Bpe = new a("Loading", 1);
      Bpf = new a("ToSimple", 2);
      Bpg = new a("Unknow", 3);
      Bph = new a[] { Bpd, Bpe, Bpf, Bpg };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */