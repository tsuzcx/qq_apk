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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
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
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements f
{
  private b.a fHp;
  private String fRw;
  private ProgressDialog jbE;
  private aq mHandler;
  private boolean nYQ;
  private boolean vsk;
  private d xnV;
  private boolean xnW;
  private boolean xnX;
  private boolean xnY;
  private boolean xnZ;
  private aw xoA;
  private com.tencent.mm.plugin.pwdgroup.a.a xoB;
  private com.tencent.mm.plugin.pwdgroup.a.a xoC;
  private int xoD;
  private Animation xoE;
  private AnimationSet xoF;
  private Animation xoG;
  public MenuItem.OnMenuItemClickListener xoH;
  public MMPwdInputView.a xoI;
  private View.OnClickListener xoJ;
  public MMKeyBoardView.a xoK;
  private aw xoL;
  private boolean xoa;
  private Location xob;
  private String xoc;
  private MMPwdInputView xod;
  private View xoe;
  private ProgressBar xof;
  private TextView xog;
  private MMKeyBoardView xoh;
  private TextView xoi;
  private boolean xoj;
  private boolean xok;
  private LinkedList<ajs> xol;
  private HashMap<String, ajs> xom;
  private LinkedList<ajs> xon;
  private a xoo;
  private View xop;
  private TextView xoq;
  private MMScrollGridView xor;
  private View xos;
  private View xot;
  private Button xou;
  private MMCallBackScrollView xov;
  private TextView xow;
  private boolean xox;
  private Runnable xoy;
  private aq xoz;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.xnW = false;
    this.xoa = false;
    this.xoj = false;
    this.xok = false;
    this.nYQ = false;
    this.xol = new LinkedList();
    this.xom = new HashMap();
    this.xon = new LinkedList();
    this.xox = false;
    this.xoA = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27622);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this);
        AppMethodBeat.o(27622);
        return false;
      }
    }, false);
    this.mHandler = new FacingCreateChatRoomAllInOneUI.11(this);
    this.xoH = new FacingCreateChatRoomAllInOneUI.12(this);
    this.xoI = new MMPwdInputView.a()
    {
      public final void y(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(27634);
        ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, paramAnonymousString);
        if (paramAnonymousBoolean)
        {
          FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, true);
          FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
        }
        AppMethodBeat.o(27634);
      }
    };
    this.xoJ = new FacingCreateChatRoomAllInOneUI.14(this);
    this.xoK = new MMKeyBoardView.a()
    {
      public final void bdi()
      {
        AppMethodBeat.i(27637);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bdi();
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
            FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bdi();
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.xoR);
            AppMethodBeat.o(27638);
            return;
          }
          MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
          if (localMMPwdInputView.rwA > 0) {
            localMMPwdInputView.fWs.deleteCharAt(localMMPwdInputView.rwA - 1);
          }
          localMMPwdInputView.cvL();
          localMMPwdInputView.dFh();
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
            localMMPwdInputView.bdi();
            localMMPwdInputView.input(paramAnonymousString);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.xoR);
            AppMethodBeat.o(27636);
            return;
          }
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).input(paramAnonymousString);
        }
        AppMethodBeat.o(27636);
      }
    };
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.fdY())
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
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.aIi()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(2131760082), FacingCreateChatRoomAllInOneUI.this.getString(2131755906), FacingCreateChatRoomAllInOneUI.this.getString(2131760598), FacingCreateChatRoomAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cD(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.xoL = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.xoU);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.xog != null) {}
    switch (10.xoP[parama.ordinal()])
    {
    default: 
      ae.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      pF(true);
      this.xnW = false;
      this.xoa = false;
      this.xof.setVisibility(8);
      this.xog.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      pF(false);
      this.xog.setText(2131762146);
      this.xof.setVisibility(0);
      this.xog.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      pF(true);
      this.xof.setVisibility(8);
      this.xog.setVisibility(0);
      this.xog.setText(2131762143);
      dFf();
      AppMethodBeat.o(27658);
      return;
    }
    pF(true);
    this.xof.setVisibility(8);
    this.xog.setVisibility(0);
    this.xog.setText(2131762145);
    dFf();
    AppMethodBeat.o(27658);
  }
  
  private void aSQ()
  {
    AppMethodBeat.i(27648);
    this.xnV = d.aIh();
    this.xnV.a(this.fHp, true);
    bc.ajj().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(27660);
    h.a(this, paramString, "", getString(2131755835), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void dFd()
  {
    AppMethodBeat.i(27661);
    this.nYQ = false;
    if (this.xoA != null) {
      this.xoA.ay(0L, 0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void dFe()
  {
    AppMethodBeat.i(27662);
    this.nYQ = true;
    if (this.xoA != null) {
      this.xoA.stopTimer();
    }
    bc.ajj().a(this.xoB);
    AppMethodBeat.o(27662);
  }
  
  private void dFf()
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
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bdi();
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
    if (this.xod != null) {
      this.xod.startAnimation(localAnimation1);
    }
    if (this.xoh != null) {
      this.xoh.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.xoh != null) {
      this.xoh.setKeyBoardEnable(paramBoolean);
    }
    AppMethodBeat.o(27657);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493935;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27654);
    setMMTitle(2131759100);
    setBackBtn(this.xoH);
    setActionbarColor(getResources().getColor(2131101053));
    this.xoe = findViewById(2131299748);
    this.xof = ((ProgressBar)findViewById(2131299747));
    this.xog = ((TextView)findViewById(2131299749));
    this.xoh = ((MMKeyBoardView)findViewById(2131299746));
    this.xoi = ((TextView)findViewById(2131299745));
    this.xod = ((MMPwdInputView)findViewById(2131299743));
    this.xod.setOnFinishInputListener(this.xoI);
    this.xod.requestFocus();
    this.xoh.setOnInputDeleteListener(this.xoK);
    a(a.xoR);
    this.xop = findViewById(2131299736);
    this.xoq = ((TextView)findViewById(2131299738));
    this.xor = ((MMScrollGridView)findViewById(2131299737));
    this.xor.setVisibility(4);
    this.xou = ((Button)findViewById(2131299739));
    this.xou.setOnClickListener(this.xoJ);
    this.xos = findViewById(2131299740);
    this.xot = findViewById(2131299741);
    this.xoq.setText(2131758816);
    this.xov = ((MMCallBackScrollView)findViewById(2131299750));
    this.xow = ((TextView)findViewById(2131299744));
    this.xov.setMMOnScrollListener(new MMCallBackScrollView.a()
    {
      public final void cp(int paramAnonymousInt)
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
    this.xoo = new a(this);
    this.xor.setAdapter(this.xoo);
    this.xoo.setData(this.xol);
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
          g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
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
    if (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ad.fom() }), 30764, true);
          AppMethodBeat.o(27647);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(27647);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ae.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27647);
        return;
      }
    }
    aSQ();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    bc.ajj().b(653, this);
    if (this.xnV != null) {
      this.xnV.c(this.fHp);
    }
    if (!this.xok)
    {
      bc.ajj().cancel(653);
      if (this.xob != null)
      {
        this.xoC = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.xoc, "", this.xob.iab, this.xob.iac, this.xob.accuracy, this.xob.dBw, this.xob.mac, this.xob.dBy);
        bc.ajj().a(this.xoC, 0);
      }
    }
    if (this.xox) {
      dFe();
    }
    if ((this.xoz != null) && (this.xoy != null)) {
      this.xoz.removeCallbacks(this.xoy);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.xnV != null) {
      this.xnV.c(this.fHp);
    }
    if (this.xox) {
      dFe();
    }
    super.onPause();
    AppMethodBeat.o(27651);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27649);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27649);
      return;
    }
    ae.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27649);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aSQ();
        AppMethodBeat.o(27649);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FacingCreateChatRoomAllInOneUI.18(this), new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.xnV != null) {
      this.xnV.a(this.fHp, true);
    }
    if (this.xox) {
      dFd();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27655);
    ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    default: 
      ae.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
    }
    label612:
    do
    {
      int i;
      do
      {
        do
        {
          AppMethodBeat.o(27655);
          return;
          paramn = (com.tencent.mm.plugin.pwdgroup.a.a)paramn;
          i = paramn.dtf;
          if (i != 0) {
            break label612;
          }
          this.xnZ = false;
          if (!this.xox) {
            break;
          }
          if (this.xoA != null) {
            this.xoA.ay(3000L, 3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramn.dFc().FNl;
        if (this.xoz == null) {
          this.xoz = new aq("FacingCreateChatRoomAllInOneUI");
        }
        if (this.xoy != null) {
          this.xoz.removeCallbacks(this.xoy);
        }
        this.xoy = new FacingCreateChatRoomAllInOneUI.7(this, paramString);
        this.xoz.post(this.xoy);
        this.fRw = paramn.dFc().xrf;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.xoR);
          this.xoD = this.xoi.getHeight();
          ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.xoD) });
          this.xoE = AnimationUtils.loadAnimation(this, 2130772040);
          this.xoG = AnimationUtils.loadAnimation(this, 2130772033);
          this.xoF = new AnimationSet(true);
          this.xoF.addAnimation(AnimationUtils.loadAnimation(this, 2130772125));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.xoD);
          paramString.setDuration(300L);
          this.xoF.addAnimation(paramString);
          this.xoE.setDuration(200L);
          this.xoF.setDuration(300L);
          this.xoG.setDuration(300L);
          this.xoE.setInterpolator(new AccelerateDecelerateInterpolator());
          this.xoF.setInterpolator(new AccelerateDecelerateInterpolator());
          this.xoG.setInterpolator(new AccelerateDecelerateInterpolator());
          this.xoF.setFillAfter(true);
          paramString.setFillAfter(true);
          this.xoF.setAnimationListener(new Animation.AnimationListener()
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
          this.xod.setVisibility(4);
          this.xod.setAnimation(paramString);
          this.xoh.startAnimation(this.xoE);
          this.xoe.startAnimation(this.xoE);
          this.xoi.startAnimation(this.xoE);
          this.xos.startAnimation(this.xoG);
          this.xop.startAnimation(this.xoF);
          this.xos.setVisibility(4);
          this.xoh.setVisibility(8);
          this.xoi.setVisibility(8);
          this.xox = true;
          dFd();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.xnW = true;
          a(a.xoT);
          AppMethodBeat.o(27655);
          return;
        }
        this.xnW = true;
        a(a.xoU);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.xoT);
        this.xnW = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.xoU);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label910;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramn.dFc().FNj;
        ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.xok = true;
        finish();
        paramn = new Intent();
        paramn.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.iUz.d(paramn, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.xoj))
      {
        this.xoj = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      acP(getString(2131758818));
    } while (this.xoA == null);
    this.xoA.ay(3000L, 3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.uU(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.xoA != null) {
        this.xoA.ay(3000L, 3000L);
      }
      AppMethodBeat.o(27655);
      return;
      acP(getString(2131762145));
    }
    label910:
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
      xoR = new a("Normal", 0);
      xoS = new a("Loading", 1);
      xoT = new a("ToSimple", 2);
      xoU = new a("Unknow", 3);
      xoV = new a[] { xoR, xoS, xoT, xoU };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */