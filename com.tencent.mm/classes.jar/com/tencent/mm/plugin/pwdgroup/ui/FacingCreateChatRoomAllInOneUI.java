package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements i
{
  private d HiA;
  private boolean HiB;
  private boolean HiC;
  private boolean HiD;
  private boolean HiE;
  private boolean HiF;
  private Location HiG;
  private String HiH;
  private MMPwdInputView HiI;
  private View HiJ;
  private ProgressBar HiK;
  private TextView HiL;
  private MMKeyBoardView HiM;
  private TextView HiN;
  private boolean HiO;
  private boolean HiP;
  private LinkedList<anh> HiQ;
  private HashMap<String, anh> HiR;
  private LinkedList<anh> HiS;
  private a HiT;
  private View HiU;
  private TextView HiV;
  private MMScrollGridView HiW;
  private View HiX;
  private View HiY;
  private Button HiZ;
  private MMCallBackScrollView Hja;
  private TextView Hjb;
  private boolean Hjc;
  private Runnable Hjd;
  private MMHandler Hje;
  private MTimerHandler Hjf;
  private com.tencent.mm.plugin.pwdgroup.a.a Hjg;
  private com.tencent.mm.plugin.pwdgroup.a.a Hjh;
  private int Hji;
  private Animation Hjj;
  private AnimationSet Hjk;
  private Animation Hjl;
  public MenuItem.OnMenuItemClickListener Hjm;
  public MMPwdInputView.a Hjn;
  private View.OnClickListener Hjo;
  public MMKeyBoardView.a Hjp;
  private MTimerHandler Hjq;
  private b.a iQJ;
  private String jaS;
  private MMHandler mHandler;
  private ProgressDialog mRa;
  private boolean slX;
  private boolean zHI;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.HiB = false;
    this.HiF = false;
    this.HiO = false;
    this.HiP = false;
    this.slX = false;
    this.HiQ = new LinkedList();
    this.HiR = new HashMap();
    this.HiS = new LinkedList();
    this.Hjc = false;
    this.Hjf = new MTimerHandler(new FacingCreateChatRoomAllInOneUI.1(this), false);
    this.mHandler = new FacingCreateChatRoomAllInOneUI.11(this);
    this.Hjm = new FacingCreateChatRoomAllInOneUI.12(this);
    this.Hjn = new MMPwdInputView.a()
    {
      public final void E(boolean paramAnonymousBoolean, String paramAnonymousString)
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
    this.Hjo = new FacingCreateChatRoomAllInOneUI.14(this);
    this.Hjp = new FacingCreateChatRoomAllInOneUI.15(this);
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.hhP())
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
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.blr()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            com.tencent.mm.ui.base.h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(R.l.gps_disable_tip), FacingCreateChatRoomAllInOneUI.this.getString(R.l.app_tip), FacingCreateChatRoomAllInOneUI.this.getString(R.l.jump_to_settings), FacingCreateChatRoomAllInOneUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cW(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.Hjq = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.Hjz);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.HiL != null) {}
    switch (10.Hju[parama.ordinal()])
    {
    default: 
      Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      wk(true);
      this.HiB = false;
      this.HiF = false;
      this.HiK.setVisibility(8);
      this.HiL.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      wk(false);
      this.HiL.setText(R.l.eQd);
      this.HiK.setVisibility(0);
      this.HiL.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      wk(true);
      this.HiK.setVisibility(8);
      this.HiL.setVisibility(0);
      this.HiL.setText(R.l.eQb);
      frU();
      AppMethodBeat.o(27658);
      return;
    }
    wk(true);
    this.HiK.setVisibility(8);
    this.HiL.setVisibility(0);
    this.HiL.setText(R.l.eQc);
    frU();
    AppMethodBeat.o(27658);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(27660);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(R.l.app_ok), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void bxM()
  {
    AppMethodBeat.i(27648);
    this.HiA = d.blq();
    this.HiA.a(this.iQJ, true);
    bh.aGY().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void frS()
  {
    AppMethodBeat.i(27661);
    this.slX = false;
    if (this.Hjf != null) {
      this.Hjf.startTimer(0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void frT()
  {
    AppMethodBeat.i(27662);
    this.slX = true;
    if (this.Hjf != null) {
      this.Hjf.stopTimer();
    }
    bh.aGY().a(this.Hjg);
    AppMethodBeat.o(27662);
  }
  
  private void frU()
  {
    AppMethodBeat.i(27663);
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, R.a.alpha_out);
    final Animation localAnimation2 = AnimationUtils.loadAnimation(this, R.a.alpha_in);
    localAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimation1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(27629);
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bJQ();
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
    if (this.HiI != null) {
      this.HiI.startAnimation(localAnimation1);
    }
    if (this.HiM != null) {
      this.HiM.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void wk(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.HiM != null) {
      this.HiM.setKeyBoardEnable(paramBoolean);
    }
    AppMethodBeat.o(27657);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.egU;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27654);
    setMMTitle(R.l.eFc);
    setBackBtn(this.Hjm);
    setActionbarColor(getResources().getColor(R.e.transparent));
    setNavigationbarColor(getResources().getColor(R.e.dkH));
    this.HiJ = findViewById(R.h.dGB);
    this.HiK = ((ProgressBar)findViewById(R.h.dGA));
    this.HiL = ((TextView)findViewById(R.h.dGC));
    this.HiM = ((MMKeyBoardView)findViewById(R.h.dGz));
    this.HiN = ((TextView)findViewById(R.h.dGy));
    this.HiI = ((MMPwdInputView)findViewById(R.h.dGw));
    this.HiI.setOnFinishInputListener(this.Hjn);
    this.HiI.requestFocus();
    this.HiM.setOnInputDeleteListener(this.Hjp);
    a(a.Hjw);
    this.HiU = findViewById(R.h.dGp);
    this.HiV = ((TextView)findViewById(R.h.dGr));
    this.HiW = ((MMScrollGridView)findViewById(R.h.dGq));
    this.HiW.setVisibility(4);
    this.HiZ = ((Button)findViewById(R.h.dGs));
    this.HiZ.setOnClickListener(this.Hjo);
    this.HiX = findViewById(R.h.dGt);
    this.HiY = findViewById(R.h.dGu);
    this.HiV.setText(R.l.eEv);
    this.Hja = ((MMCallBackScrollView)findViewById(R.h.dGD));
    this.Hjb = ((TextView)findViewById(R.h.dGx));
    this.Hja.setMMOnScrollListener(new MMCallBackScrollView.a()
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
    this.HiT = new a(this);
    this.HiW.setAdapter(this.HiT);
    this.HiT.setData(this.HiQ);
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
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
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
    if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.sdk.b.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
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
    bxM();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    bh.aGY().b(653, this);
    if (this.HiA != null) {
      this.HiA.b(this.iQJ);
    }
    if (!this.HiP)
    {
      bh.aGY().cancel(653);
      if (this.HiG != null)
      {
        this.Hjh = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.HiH, "", this.HiG.lLr, this.HiG.lLs, this.HiG.zHu, this.HiG.fMG, this.HiG.mac, this.HiG.fMI);
        bh.aGY().a(this.Hjh, 0);
      }
    }
    if (this.Hjc) {
      frT();
    }
    if ((this.Hje != null) && (this.Hjd != null)) {
      this.Hje.removeCallbacks(this.Hjd);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.HiA != null) {
      this.HiA.b(this.iQJ);
    }
    if (this.Hjc) {
      frT();
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
        bxM();
        AppMethodBeat.o(27649);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new FacingCreateChatRoomAllInOneUI.18(this), new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.HiA != null) {
      this.HiA.a(this.iQJ, true);
    }
    if (this.Hjc) {
      frS();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
          i = paramq.fDe;
          if (i != 0) {
            break label609;
          }
          this.HiE = false;
          if (!this.Hjc) {
            break;
          }
          if (this.Hjf != null) {
            this.Hjf.startTimer(3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramq.frR().RIk;
        if (this.Hje == null) {
          this.Hje = new MMHandler("FacingCreateChatRoomAllInOneUI");
        }
        if (this.Hjd != null) {
          this.Hje.removeCallbacks(this.Hjd);
        }
        this.Hjd = new FacingCreateChatRoomAllInOneUI.7(this, paramString);
        this.Hje.post(this.Hjd);
        this.jaS = paramq.frR().HlB;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.Hjw);
          this.Hji = this.HiN.getHeight();
          Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.Hji) });
          this.Hjj = AnimationUtils.loadAnimation(this, R.a.faded_out);
          this.Hjl = AnimationUtils.loadAnimation(this, R.a.djA);
          this.Hjk = new AnimationSet(true);
          this.Hjk.addAnimation(AnimationUtils.loadAnimation(this, R.a.djF));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.Hji);
          paramString.setDuration(300L);
          this.Hjk.addAnimation(paramString);
          this.Hjj.setDuration(200L);
          this.Hjk.setDuration(300L);
          this.Hjl.setDuration(300L);
          this.Hjj.setInterpolator(new AccelerateDecelerateInterpolator());
          this.Hjk.setInterpolator(new AccelerateDecelerateInterpolator());
          this.Hjl.setInterpolator(new AccelerateDecelerateInterpolator());
          this.Hjk.setFillAfter(true);
          paramString.setFillAfter(true);
          this.Hjk.setAnimationListener(new Animation.AnimationListener()
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
          this.HiI.setVisibility(4);
          this.HiI.setAnimation(paramString);
          this.HiM.startAnimation(this.Hjj);
          this.HiJ.startAnimation(this.Hjj);
          this.HiN.startAnimation(this.Hjj);
          this.HiX.startAnimation(this.Hjl);
          this.HiU.startAnimation(this.Hjk);
          this.HiX.setVisibility(4);
          this.HiM.setVisibility(8);
          this.HiN.setVisibility(8);
          this.Hjc = true;
          frS();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.HiB = true;
          a(a.Hjy);
          AppMethodBeat.o(27655);
          return;
        }
        this.HiB = true;
        a(a.Hjz);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.Hjy);
        this.HiB = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.Hjz);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label902;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramq.frR().RIi;
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.HiP = true;
        finish();
        paramq = new Intent();
        paramq.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.mIG.d(paramq, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.HiO))
      {
        this.HiO = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      auQ(getString(R.l.eEw));
    } while (this.Hjf == null);
    this.Hjf.startTimer(3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.Kb(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.Hjf != null) {
        this.Hjf.startTimer(3000L);
      }
      AppMethodBeat.o(27655);
      return;
      auQ(getString(R.l.eQc));
    }
    label902:
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
      Hjw = new a("Normal", 0);
      Hjx = new a("Loading", 1);
      Hjy = new a("ToSimple", 2);
      Hjz = new a("Unknow", 3);
      HjA = new a[] { Hjw, Hjx, Hjy, Hjz };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */