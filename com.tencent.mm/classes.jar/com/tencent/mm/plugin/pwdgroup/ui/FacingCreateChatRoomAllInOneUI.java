package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private b.a fnd;
  private String fwd;
  private ProgressDialog iFC;
  private ao mHandler;
  private boolean nso;
  private boolean udt;
  private d vQU;
  private boolean vQV;
  private boolean vQW;
  private boolean vQX;
  private boolean vQY;
  private boolean vQZ;
  private com.tencent.mm.plugin.pwdgroup.a.a vRA;
  private com.tencent.mm.plugin.pwdgroup.a.a vRB;
  private int vRC;
  private Animation vRD;
  private AnimationSet vRE;
  private Animation vRF;
  public MenuItem.OnMenuItemClickListener vRG;
  public MMPwdInputView.a vRH;
  private View.OnClickListener vRI;
  public MMKeyBoardView.a vRJ;
  private au vRK;
  private Location vRa;
  private String vRb;
  private MMPwdInputView vRc;
  private View vRd;
  private ProgressBar vRe;
  private TextView vRf;
  private MMKeyBoardView vRg;
  private TextView vRh;
  private boolean vRi;
  private boolean vRj;
  private LinkedList<ags> vRk;
  private HashMap<String, ags> vRl;
  private LinkedList<ags> vRm;
  private a vRn;
  private View vRo;
  private TextView vRp;
  private MMScrollGridView vRq;
  private View vRr;
  private View vRs;
  private Button vRt;
  private MMCallBackScrollView vRu;
  private TextView vRv;
  private boolean vRw;
  private Runnable vRx;
  private ao vRy;
  private au vRz;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.vQV = false;
    this.vQZ = false;
    this.vRi = false;
    this.vRj = false;
    this.nso = false;
    this.vRk = new LinkedList();
    this.vRl = new HashMap();
    this.vRm = new LinkedList();
    this.vRw = false;
    this.vRz = new au(new au.a()
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
    this.vRG = new FacingCreateChatRoomAllInOneUI.12(this);
    this.vRH = new MMPwdInputView.a()
    {
      public final void t(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(27634);
        ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, paramAnonymousString);
        if (paramAnonymousBoolean)
        {
          FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, true);
          FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
        }
        AppMethodBeat.o(27634);
      }
    };
    this.vRI = new FacingCreateChatRoomAllInOneUI.14(this);
    this.vRJ = new MMKeyBoardView.a()
    {
      public final void aZf()
      {
        AppMethodBeat.i(27637);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aZf();
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
            FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aZf();
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.vRQ);
            AppMethodBeat.o(27638);
            return;
          }
          MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
          if (localMMPwdInputView.qEF > 0) {
            localMMPwdInputView.fAW.deleteCharAt(localMMPwdInputView.qEF - 1);
          }
          localMMPwdInputView.coF();
          localMMPwdInputView.dro();
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
            localMMPwdInputView.aZf();
            localMMPwdInputView.input(paramAnonymousString);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.vRQ);
            AppMethodBeat.o(27636);
            return;
          }
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).input(paramAnonymousString);
        }
        AppMethodBeat.o(27636);
      }
    };
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.eLp())
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
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.aEM()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(2131760082), FacingCreateChatRoomAllInOneUI.this.getString(2131755906), FacingCreateChatRoomAllInOneUI.this.getString(2131760598), FacingCreateChatRoomAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cE(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.vRK = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.vRT);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(27660);
    h.a(this, paramString, "", getString(2131755835), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.vRf != null) {}
    switch (10.vRO[parama.ordinal()])
    {
    default: 
      ac.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      oY(true);
      this.vQV = false;
      this.vQZ = false;
      this.vRe.setVisibility(8);
      this.vRf.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      oY(false);
      this.vRf.setText(2131762146);
      this.vRe.setVisibility(0);
      this.vRf.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      oY(true);
      this.vRe.setVisibility(8);
      this.vRf.setVisibility(0);
      this.vRf.setText(2131762143);
      drm();
      AppMethodBeat.o(27658);
      return;
    }
    oY(true);
    this.vRe.setVisibility(8);
    this.vRf.setVisibility(0);
    this.vRf.setText(2131762145);
    drm();
    AppMethodBeat.o(27658);
  }
  
  private void aPf()
  {
    AppMethodBeat.i(27648);
    this.vQU = d.aEL();
    this.vQU.a(this.fnd, true);
    az.agi().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void drk()
  {
    AppMethodBeat.i(27661);
    this.nso = false;
    if (this.vRz != null) {
      this.vRz.au(0L, 0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void drl()
  {
    AppMethodBeat.i(27662);
    this.nso = true;
    if (this.vRz != null) {
      this.vRz.stopTimer();
    }
    az.agi().a(this.vRA);
    AppMethodBeat.o(27662);
  }
  
  private void drm()
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
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aZf();
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
    if (this.vRc != null) {
      this.vRc.startAnimation(localAnimation1);
    }
    if (this.vRg != null) {
      this.vRg.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void oY(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.vRg != null) {
      this.vRg.setKeyBoardEnable(paramBoolean);
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
    setBackBtn(this.vRG);
    setActionbarColor(getResources().getColor(2131101053));
    this.vRd = findViewById(2131299748);
    this.vRe = ((ProgressBar)findViewById(2131299747));
    this.vRf = ((TextView)findViewById(2131299749));
    this.vRg = ((MMKeyBoardView)findViewById(2131299746));
    this.vRh = ((TextView)findViewById(2131299745));
    this.vRc = ((MMPwdInputView)findViewById(2131299743));
    this.vRc.setOnFinishInputListener(this.vRH);
    this.vRc.requestFocus();
    this.vRg.setOnInputDeleteListener(this.vRJ);
    a(a.vRQ);
    this.vRo = findViewById(2131299736);
    this.vRp = ((TextView)findViewById(2131299738));
    this.vRq = ((MMScrollGridView)findViewById(2131299737));
    this.vRq.setVisibility(4);
    this.vRt = ((Button)findViewById(2131299739));
    this.vRt.setOnClickListener(this.vRI);
    this.vRr = findViewById(2131299740);
    this.vRs = findViewById(2131299741);
    this.vRp.setText(2131758816);
    this.vRu = ((MMCallBackScrollView)findViewById(2131299750));
    this.vRv = ((TextView)findViewById(2131299744));
    this.vRu.setMMOnScrollListener(new MMCallBackScrollView.a()
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
    this.vRn = new a(this);
    this.vRq.setAdapter(this.vRn);
    this.vRn.setData(this.vRk);
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
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
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
    if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ab.eUO() }), 30764, true);
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
      ac.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27647);
        return;
      }
    }
    aPf();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    az.agi().b(653, this);
    if (this.vQU != null) {
      this.vQU.c(this.fnd);
    }
    if (!this.vRj)
    {
      az.agi().cancel(653);
      if (this.vRa != null)
      {
        this.vRB = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.vRb, "", this.vRa.hEE, this.vRa.hEF, this.vRa.accuracy, this.vRa.doD, this.vRa.mac, this.vRa.doF);
        az.agi().a(this.vRB, 0);
      }
    }
    if (this.vRw) {
      drl();
    }
    if ((this.vRy != null) && (this.vRx != null)) {
      this.vRy.removeCallbacks(this.vRx);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.vQU != null) {
      this.vQU.c(this.fnd);
    }
    if (this.vRw) {
      drl();
    }
    super.onPause();
    AppMethodBeat.o(27651);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27649);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27649);
      return;
    }
    ac.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27649);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aPf();
        AppMethodBeat.o(27649);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FacingCreateChatRoomAllInOneUI.18(this), new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.vQU != null) {
      this.vQU.a(this.fnd, true);
    }
    if (this.vRw) {
      drk();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27655);
    ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    default: 
      ac.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
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
          i = paramn.dgD;
          if (i != 0) {
            break label612;
          }
          this.vQY = false;
          if (!this.vRw) {
            break;
          }
          if (this.vRz != null) {
            this.vRz.au(3000L, 3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramn.drj().DPz;
        if (this.vRy == null) {
          this.vRy = new ao("FacingCreateChatRoomAllInOneUI");
        }
        if (this.vRx != null) {
          this.vRy.removeCallbacks(this.vRx);
        }
        this.vRx = new FacingCreateChatRoomAllInOneUI.7(this, paramString);
        this.vRy.post(this.vRx);
        this.fwd = paramn.drj().Ewu;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.vRQ);
          this.vRC = this.vRh.getHeight();
          ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.vRC) });
          this.vRD = AnimationUtils.loadAnimation(this, 2130772040);
          this.vRF = AnimationUtils.loadAnimation(this, 2130772033);
          this.vRE = new AnimationSet(true);
          this.vRE.addAnimation(AnimationUtils.loadAnimation(this, 2130772125));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.vRC);
          paramString.setDuration(300L);
          this.vRE.addAnimation(paramString);
          this.vRD.setDuration(200L);
          this.vRE.setDuration(300L);
          this.vRF.setDuration(300L);
          this.vRD.setInterpolator(new AccelerateDecelerateInterpolator());
          this.vRE.setInterpolator(new AccelerateDecelerateInterpolator());
          this.vRF.setInterpolator(new AccelerateDecelerateInterpolator());
          this.vRE.setFillAfter(true);
          paramString.setFillAfter(true);
          this.vRE.setAnimationListener(new Animation.AnimationListener()
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
          this.vRc.setVisibility(4);
          this.vRc.setAnimation(paramString);
          this.vRg.startAnimation(this.vRD);
          this.vRd.startAnimation(this.vRD);
          this.vRh.startAnimation(this.vRD);
          this.vRr.startAnimation(this.vRF);
          this.vRo.startAnimation(this.vRE);
          this.vRr.setVisibility(4);
          this.vRg.setVisibility(8);
          this.vRh.setVisibility(8);
          this.vRw = true;
          drk();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.vQV = true;
          a(a.vRS);
          AppMethodBeat.o(27655);
          return;
        }
        this.vQV = true;
        a(a.vRT);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.vRS);
        this.vQV = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.vRT);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label910;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramn.drj().DPx;
        ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.vRj = true;
        finish();
        paramn = new Intent();
        paramn.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.iyx.d(paramn, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.vRi))
      {
        this.vRi = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      Ys(getString(2131758818));
    } while (this.vRz == null);
    this.vRz.au(3000L, 3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.rM(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.vRz != null) {
        this.vRz.au(3000L, 3000L);
      }
      AppMethodBeat.o(27655);
      return;
      Ys(getString(2131762145));
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
      vRQ = new a("Normal", 0);
      vRR = new a("Loading", 1);
      vRS = new a("ToSimple", 2);
      vRT = new a("Unknow", 3);
      vRU = new a[] { vRQ, vRR, vRS, vRT };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */