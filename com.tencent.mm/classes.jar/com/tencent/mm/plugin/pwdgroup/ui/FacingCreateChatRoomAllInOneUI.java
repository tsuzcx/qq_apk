package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
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
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  implements f
{
  private b.a fFl;
  private String fPq;
  private ProgressDialog iYL;
  private ap mHandler;
  private boolean nTk;
  private boolean vgd;
  private MMScrollGridView wYA;
  private View wYB;
  private View wYC;
  private Button wYD;
  private MMCallBackScrollView wYE;
  private TextView wYF;
  private boolean wYG;
  private Runnable wYH;
  private ap wYI;
  private av wYJ;
  private com.tencent.mm.plugin.pwdgroup.a.a wYK;
  private com.tencent.mm.plugin.pwdgroup.a.a wYL;
  private int wYM;
  private Animation wYN;
  private AnimationSet wYO;
  private Animation wYP;
  public MenuItem.OnMenuItemClickListener wYQ;
  public MMPwdInputView.a wYR;
  private View.OnClickListener wYS;
  public MMKeyBoardView.a wYT;
  private av wYU;
  private d wYe;
  private boolean wYf;
  private boolean wYg;
  private boolean wYh;
  private boolean wYi;
  private boolean wYj;
  private Location wYk;
  private String wYl;
  private MMPwdInputView wYm;
  private View wYn;
  private ProgressBar wYo;
  private TextView wYp;
  private MMKeyBoardView wYq;
  private TextView wYr;
  private boolean wYs;
  private boolean wYt;
  private LinkedList<aji> wYu;
  private HashMap<String, aji> wYv;
  private LinkedList<aji> wYw;
  private a wYx;
  private View wYy;
  private TextView wYz;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.wYf = false;
    this.wYj = false;
    this.wYs = false;
    this.wYt = false;
    this.nTk = false;
    this.wYu = new LinkedList();
    this.wYv = new HashMap();
    this.wYw = new LinkedList();
    this.wYG = false;
    this.wYJ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27622);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this);
        AppMethodBeat.o(27622);
        return false;
      }
    }, false);
    this.mHandler = new ap()
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
    this.wYQ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27633);
        FacingCreateChatRoomAllInOneUI.this.finish();
        AppMethodBeat.o(27633);
        return false;
      }
    };
    this.wYR = new MMPwdInputView.a()
    {
      public final void x(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(27634);
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, paramAnonymousString);
        if (paramAnonymousBoolean)
        {
          FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, true);
          FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
        }
        AppMethodBeat.o(27634);
      }
    };
    this.wYS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27635);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FacingCreateChatRoomAllInOneUI.f(FacingCreateChatRoomAllInOneUI.this);
        FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27635);
      }
    };
    this.wYT = new MMKeyBoardView.a()
    {
      public final void bcD()
      {
        AppMethodBeat.i(27637);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bcD();
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
            FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bcD();
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.wZa);
            AppMethodBeat.o(27638);
            return;
          }
          MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
          if (localMMPwdInputView.rov > 0) {
            localMMPwdInputView.fUm.deleteCharAt(localMMPwdInputView.rov - 1);
          }
          localMMPwdInputView.cuk();
          localMMPwdInputView.dBQ();
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
            localMMPwdInputView.bcD();
            localMMPwdInputView.input(paramAnonymousString);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.wZa);
            AppMethodBeat.o(27636);
            return;
          }
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).input(paramAnonymousString);
        }
        AppMethodBeat.o(27636);
      }
    };
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.fak())
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
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.aHR()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(2131760082), FacingCreateChatRoomAllInOneUI.this.getString(2131755906), FacingCreateChatRoomAllInOneUI.this.getString(2131760598), FacingCreateChatRoomAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cB(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.wYU = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.wZd);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.wYp != null) {}
    switch (10.wYY[parama.ordinal()])
    {
    default: 
      ad.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      px(true);
      this.wYf = false;
      this.wYj = false;
      this.wYo.setVisibility(8);
      this.wYp.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      px(false);
      this.wYp.setText(2131762146);
      this.wYo.setVisibility(0);
      this.wYp.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      px(true);
      this.wYo.setVisibility(8);
      this.wYp.setVisibility(0);
      this.wYp.setText(2131762143);
      dBO();
      AppMethodBeat.o(27658);
      return;
    }
    px(true);
    this.wYo.setVisibility(8);
    this.wYp.setVisibility(0);
    this.wYp.setText(2131762145);
    dBO();
    AppMethodBeat.o(27658);
  }
  
  private void aSr()
  {
    AppMethodBeat.i(27648);
    this.wYe = d.aHQ();
    this.wYe.a(this.fFl, true);
    ba.aiU().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(27660);
    h.a(this, paramString, "", getString(2131755835), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void dBM()
  {
    AppMethodBeat.i(27661);
    this.nTk = false;
    if (this.wYJ != null) {
      this.wYJ.az(0L, 0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void dBN()
  {
    AppMethodBeat.i(27662);
    this.nTk = true;
    if (this.wYJ != null) {
      this.wYJ.stopTimer();
    }
    ba.aiU().a(this.wYK);
    AppMethodBeat.o(27662);
  }
  
  private void dBO()
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
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).bcD();
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
    if (this.wYm != null) {
      this.wYm.startAnimation(localAnimation1);
    }
    if (this.wYq != null) {
      this.wYq.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void px(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.wYq != null) {
      this.wYq.setKeyBoardEnable(paramBoolean);
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
    setBackBtn(this.wYQ);
    setActionbarColor(getResources().getColor(2131101053));
    this.wYn = findViewById(2131299748);
    this.wYo = ((ProgressBar)findViewById(2131299747));
    this.wYp = ((TextView)findViewById(2131299749));
    this.wYq = ((MMKeyBoardView)findViewById(2131299746));
    this.wYr = ((TextView)findViewById(2131299745));
    this.wYm = ((MMPwdInputView)findViewById(2131299743));
    this.wYm.setOnFinishInputListener(this.wYR);
    this.wYm.requestFocus();
    this.wYq.setOnInputDeleteListener(this.wYT);
    a(a.wZa);
    this.wYy = findViewById(2131299736);
    this.wYz = ((TextView)findViewById(2131299738));
    this.wYA = ((MMScrollGridView)findViewById(2131299737));
    this.wYA.setVisibility(4);
    this.wYD = ((Button)findViewById(2131299739));
    this.wYD.setOnClickListener(this.wYS);
    this.wYB = findViewById(2131299740);
    this.wYC = findViewById(2131299741);
    this.wYz.setText(2131758816);
    this.wYE = ((MMCallBackScrollView)findViewById(2131299750));
    this.wYF = ((TextView)findViewById(2131299744));
    this.wYE.setMMOnScrollListener(new MMCallBackScrollView.a()
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
    this.wYx = new a(this);
    this.wYA.setAdapter(this.wYx);
    this.wYx.setData(this.wYu);
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
          g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
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
    if (com.tencent.mm.ax.b.FU((String)g.ajC().ajl().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ac.fks() }), 30764, true);
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
      ad.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27647);
        return;
      }
    }
    aSr();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    ba.aiU().b(653, this);
    if (this.wYe != null) {
      this.wYe.c(this.fFl);
    }
    if (!this.wYt)
    {
      ba.aiU().cancel(653);
      if (this.wYk != null)
      {
        this.wYL = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.wYl, "", this.wYk.hXj, this.wYk.hXk, this.wYk.accuracy, this.wYk.dAr, this.wYk.mac, this.wYk.dAt);
        ba.aiU().a(this.wYL, 0);
      }
    }
    if (this.wYG) {
      dBN();
    }
    if ((this.wYI != null) && (this.wYH != null)) {
      this.wYI.removeCallbacks(this.wYH);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.wYe != null) {
      this.wYe.c(this.fFl);
    }
    if (this.wYG) {
      dBN();
    }
    super.onPause();
    AppMethodBeat.o(27651);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27649);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27649);
      return;
    }
    ad.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27649);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aSr();
        AppMethodBeat.o(27649);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27642);
          paramAnonymousDialogInterface = FacingCreateChatRoomAllInOneUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          FacingCreateChatRoomAllInOneUI.this.finish();
          AppMethodBeat.o(27642);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27623);
          FacingCreateChatRoomAllInOneUI.this.finish();
          AppMethodBeat.o(27623);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.wYe != null) {
      this.wYe.a(this.fFl, true);
    }
    if (this.wYG) {
      dBM();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(27655);
    ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    default: 
      ad.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
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
          i = paramn.drZ;
          if (i != 0) {
            break label612;
          }
          this.wYi = false;
          if (!this.wYG) {
            break;
          }
          if (this.wYJ != null) {
            this.wYJ.az(3000L, 3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramn.dBL().FuN;
        if (this.wYI == null) {
          this.wYI = new ap("FacingCreateChatRoomAllInOneUI");
        }
        if (this.wYH != null) {
          this.wYI.removeCallbacks(this.wYH);
        }
        this.wYH = new Runnable()
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
                localObject = (aji)paramString.get(i);
                if (!bt.isNullOrNil(((aji)localObject).GgA)) {
                  FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).put(((aji)localObject).GgA, localObject);
                }
                i += 1;
              }
            }
            int j = FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).size();
            int i = 0;
            if (i < j)
            {
              localObject = (aji)FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).get(i);
              if (!FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).containsKey(((aji)localObject).GgA)) {
                ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((aji)localObject).GgA });
              }
              for (;;)
              {
                i += 1;
                break;
                FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).remove(((aji)localObject).GgA);
              }
            }
            if ((FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this) != null) && (FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).size() > 0))
            {
              localObject = FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).entrySet().iterator();
              while (((Iterator)localObject).hasNext())
              {
                aji localaji = (aji)((Map.Entry)((Iterator)localObject).next()).getValue();
                FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this).add(localaji);
                ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localaji.GgA });
              }
            }
            FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).addAll(FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this));
            FacingCreateChatRoomAllInOneUI.u(FacingCreateChatRoomAllInOneUI.this).sendEmptyMessage(10001);
            AppMethodBeat.o(27628);
          }
        };
        this.wYI.post(this.wYH);
        this.fPq = paramn.dBL().xbo;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.wZa);
          this.wYM = this.wYr.getHeight();
          ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.wYM) });
          this.wYN = AnimationUtils.loadAnimation(this, 2130772040);
          this.wYP = AnimationUtils.loadAnimation(this, 2130772033);
          this.wYO = new AnimationSet(true);
          this.wYO.addAnimation(AnimationUtils.loadAnimation(this, 2130772125));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.wYM);
          paramString.setDuration(300L);
          this.wYO.addAnimation(paramString);
          this.wYN.setDuration(200L);
          this.wYO.setDuration(300L);
          this.wYP.setDuration(300L);
          this.wYN.setInterpolator(new AccelerateDecelerateInterpolator());
          this.wYO.setInterpolator(new AccelerateDecelerateInterpolator());
          this.wYP.setInterpolator(new AccelerateDecelerateInterpolator());
          this.wYO.setFillAfter(true);
          paramString.setFillAfter(true);
          this.wYO.setAnimationListener(new Animation.AnimationListener()
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
          this.wYm.setVisibility(4);
          this.wYm.setAnimation(paramString);
          this.wYq.startAnimation(this.wYN);
          this.wYn.startAnimation(this.wYN);
          this.wYr.startAnimation(this.wYN);
          this.wYB.startAnimation(this.wYP);
          this.wYy.startAnimation(this.wYO);
          this.wYB.setVisibility(4);
          this.wYq.setVisibility(8);
          this.wYr.setVisibility(8);
          this.wYG = true;
          dBM();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.wYf = true;
          a(a.wZc);
          AppMethodBeat.o(27655);
          return;
        }
        this.wYf = true;
        a(a.wZd);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.wZc);
        this.wYf = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.wZd);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label910;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramn.dBL().FuL;
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.wYt = true;
        finish();
        paramn = new Intent();
        paramn.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.iRG.d(paramn, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.wYs))
      {
        this.wYs = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      abY(getString(2131758818));
    } while (this.wYJ == null);
    this.wYJ.az(3000L, 3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.uz(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.wYJ != null) {
        this.wYJ.az(3000L, 3000L);
      }
      AppMethodBeat.o(27655);
      return;
      abY(getString(2131762145));
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
      wZa = new a("Normal", 0);
      wZb = new a("Loading", 1);
      wZc = new a("ToSimple", 2);
      wZd = new a("Unknow", 3);
      wZe = new a[] { wZa, wZb, wZc, wZd };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */