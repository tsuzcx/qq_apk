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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
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
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private b.a fjJ;
  private String fsw;
  private ProgressDialog ift;
  private ap mHandler;
  private boolean mQd;
  private boolean sVh;
  private View uIA;
  private View uIB;
  private Button uIC;
  private MMCallBackScrollView uID;
  private TextView uIE;
  private boolean uIF;
  private Runnable uIG;
  private ap uIH;
  private av uII;
  private com.tencent.mm.plugin.pwdgroup.a.a uIJ;
  private com.tencent.mm.plugin.pwdgroup.a.a uIK;
  private int uIL;
  private Animation uIM;
  private AnimationSet uIN;
  private Animation uIO;
  public MenuItem.OnMenuItemClickListener uIP;
  public MMPwdInputView.a uIQ;
  private View.OnClickListener uIR;
  public MMKeyBoardView.a uIS;
  private av uIT;
  private d uId;
  private boolean uIe;
  private boolean uIf;
  private boolean uIg;
  private boolean uIh;
  private boolean uIi;
  private Location uIj;
  private String uIk;
  private MMPwdInputView uIl;
  private View uIm;
  private ProgressBar uIn;
  private TextView uIo;
  private MMKeyBoardView uIp;
  private TextView uIq;
  private boolean uIr;
  private boolean uIs;
  private LinkedList<aft> uIt;
  private HashMap<String, aft> uIu;
  private LinkedList<aft> uIv;
  private a uIw;
  private View uIx;
  private TextView uIy;
  private MMScrollGridView uIz;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.uIe = false;
    this.uIi = false;
    this.uIr = false;
    this.uIs = false;
    this.mQd = false;
    this.uIt = new LinkedList();
    this.uIu = new HashMap();
    this.uIv = new LinkedList();
    this.uIF = false;
    this.uII = new av(new FacingCreateChatRoomAllInOneUI.1(this), false);
    this.mHandler = new FacingCreateChatRoomAllInOneUI.11(this);
    this.uIP = new FacingCreateChatRoomAllInOneUI.12(this);
    this.uIQ = new MMPwdInputView.a()
    {
      public final void s(boolean paramAnonymousBoolean, String paramAnonymousString)
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
    this.uIR = new FacingCreateChatRoomAllInOneUI.14(this);
    this.uIS = new MMKeyBoardView.a()
    {
      public final void aSi()
      {
        AppMethodBeat.i(27637);
        if (FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aSi();
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
            FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aSi();
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.uIZ);
            AppMethodBeat.o(27638);
            return;
          }
          MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this);
          if (localMMPwdInputView.pWa > 0) {
            localMMPwdInputView.fxp.deleteCharAt(localMMPwdInputView.pWa - 1);
          }
          localMMPwdInputView.cgY();
          localMMPwdInputView.ddG();
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
            localMMPwdInputView.aSi();
            localMMPwdInputView.input(paramAnonymousString);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.uIZ);
            AppMethodBeat.o(27636);
            return;
          }
          FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).input(paramAnonymousString);
        }
        AppMethodBeat.o(27636);
      }
    };
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(27640);
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.evV())
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
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.axU()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(2131760082), FacingCreateChatRoomAllInOneUI.this.getString(2131755906), FacingCreateChatRoomAllInOneUI.this.getString(2131760598), FacingCreateChatRoomAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.cv(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.uIT = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.uJc);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void Ug(String paramString)
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
    if (this.uIo != null) {}
    switch (10.uIX[parama.ordinal()])
    {
    default: 
      ad.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      oe(true);
      this.uIe = false;
      this.uIi = false;
      this.uIn.setVisibility(8);
      this.uIo.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      oe(false);
      this.uIo.setText(2131762146);
      this.uIn.setVisibility(0);
      this.uIo.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      oe(true);
      this.uIn.setVisibility(8);
      this.uIo.setVisibility(0);
      this.uIo.setText(2131762143);
      ddE();
      AppMethodBeat.o(27658);
      return;
    }
    oe(true);
    this.uIn.setVisibility(8);
    this.uIo.setVisibility(0);
    this.uIo.setText(2131762145);
    ddE();
    AppMethodBeat.o(27658);
  }
  
  private void aIo()
  {
    AppMethodBeat.i(27648);
    this.uId = d.axT();
    this.uId.a(this.fjJ, true);
    az.aeS().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(27648);
  }
  
  private void ddC()
  {
    AppMethodBeat.i(27661);
    this.mQd = false;
    if (this.uII != null) {
      this.uII.av(0L, 0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void ddD()
  {
    AppMethodBeat.i(27662);
    this.mQd = true;
    if (this.uII != null) {
      this.uII.stopTimer();
    }
    az.aeS().a(this.uIJ);
    AppMethodBeat.o(27662);
  }
  
  private void ddE()
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
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).aSi();
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
    if (this.uIl != null) {
      this.uIl.startAnimation(localAnimation1);
    }
    if (this.uIp != null) {
      this.uIp.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  private void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.uIp != null) {
      this.uIp.setKeyBoardEnable(paramBoolean);
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
    setBackBtn(this.uIP);
    setActionbarColor(getResources().getColor(2131101053));
    this.uIm = findViewById(2131299748);
    this.uIn = ((ProgressBar)findViewById(2131299747));
    this.uIo = ((TextView)findViewById(2131299749));
    this.uIp = ((MMKeyBoardView)findViewById(2131299746));
    this.uIq = ((TextView)findViewById(2131299745));
    this.uIl = ((MMPwdInputView)findViewById(2131299743));
    this.uIl.setOnFinishInputListener(this.uIQ);
    this.uIl.requestFocus();
    this.uIp.setOnInputDeleteListener(this.uIS);
    a(a.uIZ);
    this.uIx = findViewById(2131299736);
    this.uIy = ((TextView)findViewById(2131299738));
    this.uIz = ((MMScrollGridView)findViewById(2131299737));
    this.uIz.setVisibility(4);
    this.uIC = ((Button)findViewById(2131299739));
    this.uIC.setOnClickListener(this.uIR);
    this.uIA = findViewById(2131299740);
    this.uIB = findViewById(2131299741);
    this.uIy.setText(2131758816);
    this.uID = ((MMCallBackScrollView)findViewById(2131299750));
    this.uIE = ((TextView)findViewById(2131299744));
    this.uID.setMMOnScrollListener(new MMCallBackScrollView.a()
    {
      public final void cq(int paramAnonymousInt)
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
    this.uIw = new a(this);
    this.uIz.setAdapter(this.uIw);
    this.uIw.setData(this.uIt);
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
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
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
    if (com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ac.eFu() }), 30764, true);
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
    aIo();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    az.aeS().b(653, this);
    if (this.uId != null) {
      this.uId.c(this.fjJ);
    }
    if (!this.uIs)
    {
      az.aeS().cancel(653);
      if (this.uIj != null)
      {
        this.uIK = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.uIk, "", this.uIj.heb, this.uIj.hec, this.uIj.accuracy, this.uIj.dqS, this.uIj.mac, this.uIj.dqU);
        az.aeS().a(this.uIK, 0);
      }
    }
    if (this.uIF) {
      ddD();
    }
    if ((this.uIH != null) && (this.uIG != null)) {
      this.uIH.removeCallbacks(this.uIG);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.uId != null) {
      this.uId.c(this.fjJ);
    }
    if (this.uIF) {
      ddD();
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
        aIo();
        AppMethodBeat.o(27649);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FacingCreateChatRoomAllInOneUI.18(this), new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.uId != null) {
      this.uId.a(this.fjJ, true);
    }
    if (this.uIF) {
      ddC();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
          i = paramn.dji;
          if (i != 0) {
            break label612;
          }
          this.uIh = false;
          if (!this.uIF) {
            break;
          }
          if (this.uII != null) {
            this.uII.av(3000L, 3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramn.ddB().Cxd;
        if (this.uIH == null) {
          this.uIH = new ap("FacingCreateChatRoomAllInOneUI");
        }
        if (this.uIG != null) {
          this.uIH.removeCallbacks(this.uIG);
        }
        this.uIG = new FacingCreateChatRoomAllInOneUI.7(this, paramString);
        this.uIH.post(this.uIG);
        this.fsw = paramn.ddB().Ddo;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.uIZ);
          this.uIL = this.uIq.getHeight();
          ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.uIL) });
          this.uIM = AnimationUtils.loadAnimation(this, 2130772040);
          this.uIO = AnimationUtils.loadAnimation(this, 2130772033);
          this.uIN = new AnimationSet(true);
          this.uIN.addAnimation(AnimationUtils.loadAnimation(this, 2130772125));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.uIL);
          paramString.setDuration(300L);
          this.uIN.addAnimation(paramString);
          this.uIM.setDuration(200L);
          this.uIN.setDuration(300L);
          this.uIO.setDuration(300L);
          this.uIM.setInterpolator(new AccelerateDecelerateInterpolator());
          this.uIN.setInterpolator(new AccelerateDecelerateInterpolator());
          this.uIO.setInterpolator(new AccelerateDecelerateInterpolator());
          this.uIN.setFillAfter(true);
          paramString.setFillAfter(true);
          this.uIN.setAnimationListener(new Animation.AnimationListener()
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
          this.uIl.setVisibility(4);
          this.uIl.setAnimation(paramString);
          this.uIp.startAnimation(this.uIM);
          this.uIm.startAnimation(this.uIM);
          this.uIq.startAnimation(this.uIM);
          this.uIA.startAnimation(this.uIO);
          this.uIx.startAnimation(this.uIN);
          this.uIA.setVisibility(4);
          this.uIp.setVisibility(8);
          this.uIq.setVisibility(8);
          this.uIF = true;
          ddC();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.uIe = true;
          a(a.uJb);
          AppMethodBeat.o(27655);
          return;
        }
        this.uIe = true;
        a(a.uJc);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.uJb);
        this.uIe = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.uJc);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label910;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramn.ddB().Cxb;
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.uIs = true;
        finish();
        paramn = new Intent();
        paramn.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.hYt.d(paramn, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.uIr))
      {
        this.uIr = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      Ug(getString(2131758818));
    } while (this.uII == null);
    this.uII.av(3000L, 3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.oG(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.uII != null) {
        this.uII.av(3000L, 3000L);
      }
      AppMethodBeat.o(27655);
      return;
      Ug(getString(2131762145));
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
      uIZ = new a("Normal", 0);
      uJa = new a("Loading", 1);
      uJb = new a("ToSimple", 2);
      uJc = new a("Unknow", 3);
      uJd = new a[] { uIZ, uJa, uJb, uJc };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */