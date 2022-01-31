package com.tencent.mm.plugin.pwdgroup.ui;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements f
{
  private a.a dig = new a.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
      if (paramAnonymousBoolean)
      {
        Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
        if (!localLocation.clg())
        {
          FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, localLocation);
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, true);
          FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
        }
      }
      for (;;)
      {
        return false;
        FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
      }
    }
  };
  private String dqS;
  private ProgressDialog faz;
  private boolean hXh = false;
  private ah mHandler = new FacingCreateChatRoomAllInOneUI.11(this);
  private boolean naA;
  private boolean naB;
  private boolean naC;
  private boolean naD = false;
  private Location naE;
  private String naF;
  private MMPwdInputView naG;
  private View naH;
  private ProgressBar naI;
  private TextView naJ;
  private MMKeyBoardView naK;
  private TextView naL;
  private boolean naM = false;
  private boolean naN = false;
  private LinkedList<xr> naO = new LinkedList();
  private HashMap<String, xr> naP = new HashMap();
  private LinkedList<xr> naQ = new LinkedList();
  private a naR;
  private View naS;
  private TextView naT;
  private MMScrollGridView naU;
  private View naV;
  private View naW;
  private Button naX;
  private MMCallBackScrollView naY;
  private TextView naZ;
  private c nay;
  private boolean naz = false;
  private boolean nba = false;
  private ai nbb = new ai();
  private am nbc = new am(new FacingCreateChatRoomAllInOneUI.1(this), false);
  private com.tencent.mm.plugin.pwdgroup.a.a nbd;
  private com.tencent.mm.plugin.pwdgroup.a.a nbe;
  private int nbf;
  private Animation nbg;
  private AnimationSet nbh;
  private Animation nbi;
  public MenuItem.OnMenuItemClickListener nbj = new FacingCreateChatRoomAllInOneUI.12(this);
  public MMPwdInputView.a nbk = new FacingCreateChatRoomAllInOneUI.13(this);
  private View.OnClickListener nbl = new FacingCreateChatRoomAllInOneUI.14(this);
  public MMKeyBoardView.a nbm = new FacingCreateChatRoomAllInOneUI.15(this);
  private am nbn = new am(new FacingCreateChatRoomAllInOneUI.17(this), false);
  
  private void AY(String paramString)
  {
    h.a(this, paramString, "", getString(R.l.app_ok), new FacingCreateChatRoomAllInOneUI.6(this));
  }
  
  private void a(FacingCreateChatRoomAllInOneUI.a parama)
  {
    if (this.naJ != null) {}
    switch (FacingCreateChatRoomAllInOneUI.10.nbr[parama.ordinal()])
    {
    default: 
      y.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      return;
    case 1: 
      ih(true);
      this.naz = false;
      this.naD = false;
      this.naI.setVisibility(8);
      this.naJ.setVisibility(8);
      return;
    case 2: 
      ih(false);
      this.naJ.setText(R.l.radar_join_group_verify_tip);
      this.naI.setVisibility(0);
      this.naJ.setVisibility(8);
      return;
    case 3: 
      ih(true);
      this.naI.setVisibility(8);
      this.naJ.setVisibility(0);
      this.naJ.setText(R.l.radar_join_group_simplepwd_error);
      bte();
      return;
    }
    ih(true);
    this.naI.setVisibility(8);
    this.naJ.setVisibility(0);
    this.naJ.setText(R.l.radar_join_group_unknow_error);
    bte();
  }
  
  private void bdC()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  private void btb()
  {
    this.nay = c.Ob();
    this.nay.a(this.dig, true);
    au.Dk().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
  }
  
  private void btc()
  {
    this.hXh = false;
    if (this.nbc != null) {
      this.nbc.S(0L, 0L);
    }
  }
  
  private void btd()
  {
    this.hXh = true;
    if (this.nbc != null) {
      this.nbc.stopTimer();
    }
    au.Dk().c(this.nbd);
  }
  
  private void bte()
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, R.a.alpha_out);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this, R.a.alpha_in);
    localAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimation1.setAnimationListener(new FacingCreateChatRoomAllInOneUI.8(this, localAnimation2));
    localAnimation2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (FacingCreateChatRoomAllInOneUI.p(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.p(FacingCreateChatRoomAllInOneUI.this).setKeyBoardEnable(true);
        }
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (this.naG != null) {
      this.naG.startAnimation(localAnimation1);
    }
    if (this.naK != null) {
      this.naK.setKeyBoardEnable(false);
    }
  }
  
  private void ih(boolean paramBoolean)
  {
    if (this.naK != null) {
      this.naK.setKeyBoardEnable(paramBoolean);
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.facing_create_chatroom_allin;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.find_friends_create_pwdgroup);
    setBackBtn(this.nbj);
    ta(getResources().getColor(R.e.transparent));
    this.naH = findViewById(R.h.facing_loading_container);
    this.naI = ((ProgressBar)findViewById(R.h.facing_loading));
    this.naJ = ((TextView)findViewById(R.h.facing_loading_msg));
    this.naK = ((MMKeyBoardView)findViewById(R.h.facing_keyboard));
    this.naL = ((TextView)findViewById(R.h.facing_input_msg));
    this.naG = ((MMPwdInputView)findViewById(R.h.facing_input));
    this.naG.setOnFinishInputListener(this.nbk);
    this.naG.requestFocus();
    this.naK.setOnInputDeleteListener(this.nbm);
    a(FacingCreateChatRoomAllInOneUI.a.nbs);
    this.naS = findViewById(R.h.facing_content_container);
    this.naT = ((TextView)findViewById(R.h.facing_content_msg));
    this.naU = ((MMScrollGridView)findViewById(R.h.facing_content_member));
    this.naU.setVisibility(4);
    this.naX = ((Button)findViewById(R.h.facing_enter_chatroom));
    this.naX.setOnClickListener(this.nbl);
    this.naV = findViewById(R.h.facing_enter_container);
    this.naW = findViewById(R.h.facing_enter_div);
    this.naT.setText(R.l.facing_detail_tip);
    this.naY = ((MMCallBackScrollView)findViewById(R.h.facing_scroll));
    this.naZ = ((TextView)findViewById(R.h.facing_input_copy));
    this.naY.setMMOnScrollListener(new FacingCreateChatRoomAllInOneUI.3(this));
    this.naR = new a(this);
    this.naU.setAdapter(this.naR);
    this.naR.setData(this.naO);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30764)
    {
      if (paramIntent == null) {
        break label79;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
        com.tencent.mm.pluginsdk.permission.a.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
    }
    else
    {
      return;
    }
    finish();
    return;
    label79:
    finish();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (b.mC((String)g.DP().Dz().get(274436, null)))
    {
      if (com.tencent.mm.pluginsdk.permission.a.j(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        break label133;
      }
      if (!((Boolean)g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue()) {
        com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30764, true);
      }
    }
    boolean bool;
    do
    {
      return;
      com.tencent.mm.pluginsdk.permission.a.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      y.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    label133:
    btb();
  }
  
  protected void onDestroy()
  {
    au.Dk().b(653, this);
    if (this.nay != null) {
      this.nay.c(this.dig);
    }
    if (!this.naN)
    {
      au.Dk().cancel(653);
      if (this.naE != null)
      {
        this.nbe = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.naF, "", this.naE.elk, this.naE.ell, this.naE.accuracy, this.naE.bTe, this.naE.mac, this.naE.bTg);
        au.Dk().a(this.nbe, 0);
      }
    }
    if (this.nba) {
      btd();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.nay != null) {
      this.nay.c(this.dig);
    }
    if (this.nba) {
      btd();
    }
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      btb();
      return;
    }
    h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new FacingCreateChatRoomAllInOneUI.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        FacingCreateChatRoomAllInOneUI.this.finish();
      }
    }, new FacingCreateChatRoomAllInOneUI.2(this));
  }
  
  protected void onResume()
  {
    if (this.nay != null) {
      this.nay.a(this.dig, true);
    }
    if (this.nba) {
      btc();
    }
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    default: 
      y.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
    }
    for (;;)
    {
      return;
      paramm = (com.tencent.mm.plugin.pwdgroup.a.a)paramm;
      int i = paramm.bMU;
      if (i == 0)
      {
        this.naC = false;
        if (this.nba)
        {
          if (this.nbc != null) {
            this.nbc.S(3000L, 3000L);
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = paramm.bta().svo;
            this.nbb.O(new FacingCreateChatRoomAllInOneUI.7(this, paramString));
            this.dqS = paramm.bta().sRr;
          }
        }
        else
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            a(FacingCreateChatRoomAllInOneUI.a.nbs);
            this.nbf = this.naL.getHeight();
            y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.nbf) });
            this.nbg = AnimationUtils.loadAnimation(this, R.a.faded_out);
            this.nbi = AnimationUtils.loadAnimation(this, R.a.enter_view_in);
            this.nbh = new AnimationSet(true);
            this.nbh.addAnimation(AnimationUtils.loadAnimation(this, R.a.scroll_view_in));
            paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.nbf);
            paramString.setDuration(300L);
            this.nbh.addAnimation(paramString);
            this.nbg.setDuration(200L);
            this.nbh.setDuration(300L);
            this.nbi.setDuration(300L);
            this.nbg.setInterpolator(new AccelerateDecelerateInterpolator());
            this.nbh.setInterpolator(new AccelerateDecelerateInterpolator());
            this.nbi.setInterpolator(new AccelerateDecelerateInterpolator());
            this.nbh.setFillAfter(true);
            paramString.setFillAfter(true);
            this.nbh.setAnimationListener(new FacingCreateChatRoomAllInOneUI.4(this));
            this.naG.setVisibility(4);
            this.naG.setAnimation(paramString);
            this.naK.startAnimation(this.nbg);
            this.naH.startAnimation(this.nbg);
            this.naL.startAnimation(this.nbg);
            this.naV.startAnimation(this.nbi);
            this.naS.startAnimation(this.nbh);
            this.naV.setVisibility(4);
            this.naK.setVisibility(8);
            this.naL.setVisibility(8);
            this.nba = true;
            btc();
            return;
          }
          if (paramInt2 == -431)
          {
            this.naz = true;
            a(FacingCreateChatRoomAllInOneUI.a.nbu);
            return;
          }
          this.naz = true;
          a(FacingCreateChatRoomAllInOneUI.a.nbv);
        }
      }
      else if (i == 3)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          if (paramInt2 == -431)
          {
            a(FacingCreateChatRoomAllInOneUI.a.nbu);
            this.naz = true;
            return;
          }
          a(FacingCreateChatRoomAllInOneUI.a.nbv);
        }
      }
      else
      {
        if (i != 1) {
          break;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bdC();
          paramString = paramm.bta().svm;
          y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { paramString });
          this.naN = true;
          finish();
          paramm = new Intent();
          paramm.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.pwdgroup.a.eUR.e(paramm, this);
          return;
        }
        if ((paramInt2 == -432) && (!this.naM))
        {
          this.naM = true;
          this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
          return;
        }
        if (paramInt2 == -23)
        {
          bdC();
          AY(getString(R.l.facing_join_group_overmember));
          if (this.nbc != null) {
            this.nbc.S(3000L, 3000L);
          }
        }
        else
        {
          bdC();
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null) {
            paramString.a(this.mController.uMN, null, null);
          }
          while (this.nbc != null)
          {
            this.nbc.S(3000L, 3000L);
            return;
            AY(getString(R.l.radar_join_group_unknow_error));
          }
        }
      }
    }
    bdC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */