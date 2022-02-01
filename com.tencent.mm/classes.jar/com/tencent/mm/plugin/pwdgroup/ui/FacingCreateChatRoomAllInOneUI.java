package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
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
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.mm.ui.widget.a.g.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FacingCreateChatRoomAllInOneUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private boolean EPk;
  private TextView NgA;
  private boolean NgB;
  private boolean NgC;
  private LinkedList<ara> NgD;
  private HashMap<String, ara> NgE;
  private LinkedList<ara> NgF;
  private a NgG;
  private View NgH;
  private TextView NgI;
  private MMScrollGridView NgJ;
  private View NgK;
  private View NgL;
  private Button NgM;
  private MMCallBackScrollView NgN;
  private TextView NgO;
  private boolean NgP;
  private Runnable NgQ;
  private MMHandler NgR;
  private MTimerHandler NgS;
  private com.tencent.mm.plugin.pwdgroup.a.a NgT;
  private com.tencent.mm.plugin.pwdgroup.a.a NgU;
  private int NgV;
  private Animation NgW;
  private AnimationSet NgX;
  private Animation NgY;
  public MenuItem.OnMenuItemClickListener NgZ;
  private d Ngn;
  private boolean Ngo;
  private boolean Ngp;
  private boolean Ngq;
  private boolean Ngr;
  private boolean Ngs;
  private Location Ngt;
  private String Ngu;
  private MMPwdInputView Ngv;
  private View Ngw;
  private ProgressBar Ngx;
  private TextView Ngy;
  private MMKeyBoardView Ngz;
  public MMPwdInputView.a Nha;
  private View.OnClickListener Nhb;
  public MMKeyBoardView.a Nhc;
  private MTimerHandler Nhd;
  private String lCS;
  private b.a lsF;
  private MMHandler mHandler;
  private ProgressDialog pNH;
  private boolean vxW;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(27646);
    this.Ngo = false;
    this.Ngs = false;
    this.NgB = false;
    this.NgC = false;
    this.vxW = false;
    this.NgD = new LinkedList();
    this.NgE = new HashMap();
    this.NgF = new LinkedList();
    this.NgP = false;
    this.NgS = new MTimerHandler(new FacingCreateChatRoomAllInOneUI.1(this), false);
    this.mHandler = new FacingCreateChatRoomAllInOneUI.12(this);
    this.NgZ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27633);
        FacingCreateChatRoomAllInOneUI.this.finish();
        AppMethodBeat.o(27633);
        return false;
      }
    };
    this.Nha = new MMPwdInputView.a()
    {
      public final void ar(boolean paramAnonymousBoolean, String paramAnonymousString)
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
    this.Nhb = new FacingCreateChatRoomAllInOneUI.15(this);
    this.Nhc = new FacingCreateChatRoomAllInOneUI.16(this);
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(284565);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (paramAnonymousBoolean)
        {
          Location localLocation = new Location(paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2, paramAnonymousInt, "", "");
          if (!localLocation.iIQ())
          {
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, localLocation);
            FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, true);
            FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(284565);
          return false;
          if ((!FacingCreateChatRoomAllInOneUI.j(FacingCreateChatRoomAllInOneUI.this)) && (!d.bJm()))
          {
            FacingCreateChatRoomAllInOneUI.k(FacingCreateChatRoomAllInOneUI.this);
            k.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(R.l.gps_disable_tip), FacingCreateChatRoomAllInOneUI.this.getString(R.l.app_tip), FacingCreateChatRoomAllInOneUI.this.getString(R.l.jump_to_settings), FacingCreateChatRoomAllInOneUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(27639);
                d.dP(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.o(27639);
              }
            }, null);
          }
          FacingCreateChatRoomAllInOneUI.b(FacingCreateChatRoomAllInOneUI.this, false);
        }
      }
    };
    this.Nhd = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27641);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, false);
        FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.a.Nhm);
        AppMethodBeat.o(27641);
        return true;
      }
    }, false);
    AppMethodBeat.o(27646);
  }
  
  private void AK(boolean paramBoolean)
  {
    AppMethodBeat.i(27657);
    if (this.Ngz != null) {
      this.Ngz.setKeyBoardEnable(paramBoolean);
    }
    AppMethodBeat.o(27657);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(27658);
    if (this.Ngy != null) {}
    switch (11.Nhh[parama.ordinal()])
    {
    default: 
      Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(27658);
      return;
    case 1: 
      AK(true);
      this.Ngo = false;
      this.Ngs = false;
      this.Ngx.setVisibility(8);
      this.Ngy.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 2: 
      AK(false);
      this.Ngy.setText(R.l.gSI);
      this.Ngx.setVisibility(0);
      this.Ngy.setVisibility(8);
      AppMethodBeat.o(27658);
      return;
    case 3: 
      AK(true);
      this.Ngx.setVisibility(8);
      this.Ngy.setVisibility(0);
      this.Ngy.setText(R.l.gSG);
      gDC();
      AppMethodBeat.o(27658);
      return;
    }
    AK(true);
    this.Ngx.setVisibility(8);
    this.Ngy.setVisibility(0);
    this.Ngy.setText(R.l.gSH);
    gDC();
    AppMethodBeat.o(27658);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(27660);
    k.a(this, paramString, "", getString(R.l.app_ok), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27660);
  }
  
  private void bWB()
  {
    AppMethodBeat.i(27648);
    this.Ngn = d.bJl();
    this.Ngn.a(this.lsF, true, true);
    bh.aZW().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    l.kK(3, 10);
    AppMethodBeat.o(27648);
  }
  
  private void gDA()
  {
    AppMethodBeat.i(27661);
    this.vxW = false;
    if (this.NgS != null) {
      this.NgS.startTimer(0L);
    }
    AppMethodBeat.o(27661);
  }
  
  private void gDB()
  {
    AppMethodBeat.i(27662);
    this.vxW = true;
    if (this.NgS != null) {
      this.NgS.stopTimer();
    }
    bh.aZW().a(this.NgT);
    AppMethodBeat.o(27662);
  }
  
  private void gDC()
  {
    AppMethodBeat.i(27663);
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, R.a.alpha_out);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this, R.a.alpha_in);
    localAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimation1.setAnimationListener(new FacingCreateChatRoomAllInOneUI.9(this, localAnimation2));
    localAnimation2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(284573);
        if (FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this).setKeyBoardEnable(true);
        }
        AppMethodBeat.o(284573);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (this.Ngv != null) {
      this.Ngv.startAnimation(localAnimation1);
    }
    if (this.Ngz != null) {
      this.Ngz.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(27663);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(27659);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(27659);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gjQ;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(284715);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.profile.ui.a.b.class);
    AppMethodBeat.o(284715);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27654);
    setMMTitle(R.l.gHV);
    setBackBtn(this.NgZ);
    setActionbarColor(getResources().getColor(R.e.transparent));
    setNavigationbarColor(getResources().getColor(R.e.fkW));
    this.Ngw = findViewById(R.h.fHH);
    this.Ngx = ((ProgressBar)findViewById(R.h.fHG));
    this.Ngy = ((TextView)findViewById(R.h.fHI));
    this.Ngz = ((MMKeyBoardView)findViewById(R.h.fHF));
    this.NgA = ((TextView)findViewById(R.h.fHE));
    this.Ngv = ((MMPwdInputView)findViewById(R.h.fHC));
    this.Ngv.setOnFinishInputListener(this.Nha);
    this.Ngv.requestFocus();
    this.Ngz.setOnInputDeleteListener(this.Nhc);
    a(a.Nhj);
    this.NgH = findViewById(R.h.fHv);
    this.NgI = ((TextView)findViewById(R.h.fHx));
    this.NgJ = ((MMScrollGridView)findViewById(R.h.fHw));
    this.NgJ.setVisibility(4);
    this.NgM = ((Button)findViewById(R.h.fHy));
    this.NgM.setOnClickListener(this.Nhb);
    this.NgK = findViewById(R.h.fHz);
    this.NgL = findViewById(R.h.fHA);
    this.NgI.setText(R.l.gHn);
    this.NgN = ((MMCallBackScrollView)findViewById(R.h.fHJ));
    this.NgO = ((TextView)findViewById(R.h.fHD));
    this.NgN.setMMOnScrollListener(new MMCallBackScrollView.a()
    {
      public final void onScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(284581);
        if (FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this) != null)
        {
          if (paramAnonymousInt == 0)
          {
            FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this).setVisibility(4);
            AppMethodBeat.o(284581);
            return;
          }
          FacingCreateChatRoomAllInOneUI.l(FacingCreateChatRoomAllInOneUI.this).setVisibility(0);
        }
        AppMethodBeat.o(284581);
      }
    });
    this.NgG = new a(this);
    this.NgJ.setAdapter(this.NgG);
    this.NgG.setData(this.NgD);
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
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
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
    if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.sdk.c.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          AppMethodBeat.o(27647);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        AppMethodBeat.o(27647);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, getString(R.l.gHp), new g.b()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(284567);
          if (!paramAnonymousBoolean1) {
            FacingCreateChatRoomAllInOneUI.this.finish();
          }
          AppMethodBeat.o(284567);
        }
      });
      Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27647);
        return;
      }
    }
    bWB();
    AppMethodBeat.o(27647);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27652);
    bh.aZW().b(653, this);
    if (this.Ngn != null) {
      this.Ngn.a(this.lsF);
    }
    if (!this.NgC)
    {
      bh.aZW().cancel(653);
      if (this.Ngt != null)
      {
        this.NgU = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.Ngu, "", this.Ngt.oDT, this.Ngt.oDU, this.Ngt.EOW, this.Ngt.hSq, this.Ngt.mac, this.Ngt.hSs);
        bh.aZW().a(this.NgU, 0);
      }
    }
    if (this.NgP) {
      gDB();
    }
    if ((this.NgR != null) && (this.NgQ != null)) {
      this.NgR.removeCallbacks(this.NgQ);
    }
    super.onDestroy();
    AppMethodBeat.o(27652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27651);
    if (this.Ngn != null) {
      this.Ngn.a(this.lsF);
    }
    if (this.NgP) {
      gDB();
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
        bWB();
        AppMethodBeat.o(27649);
        return;
      }
      k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27623);
          com.tencent.mm.pluginsdk.permission.b.lx(FacingCreateChatRoomAllInOneUI.this.getContext());
          FacingCreateChatRoomAllInOneUI.this.finish();
          AppMethodBeat.o(27623);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(284578);
          FacingCreateChatRoomAllInOneUI.this.finish();
          AppMethodBeat.o(284578);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27650);
    if (this.Ngn != null) {
      this.Ngn.a(this.lsF, true, true);
    }
    if (this.NgP) {
      gDA();
    }
    super.onResume();
    AppMethodBeat.o(27650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(27655);
    Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramp.getType())
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
          paramp = (com.tencent.mm.plugin.pwdgroup.a.a)paramp;
          i = paramp.hHT;
          if (i != 0) {
            break label609;
          }
          this.Ngr = false;
          if (!this.NgP) {
            break;
          }
          if (this.NgS != null) {
            this.NgS.startTimer(3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramp.gDz().YFm;
        if (this.NgR == null) {
          this.NgR = new MMHandler("FacingCreateChatRoomAllInOneUI");
        }
        if (this.NgQ != null) {
          this.NgR.removeCallbacks(this.NgQ);
        }
        this.NgQ = new FacingCreateChatRoomAllInOneUI.8(this, paramString);
        this.NgR.post(this.NgQ);
        this.lCS = paramp.gDz().Njp;
        AppMethodBeat.o(27655);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.Nhj);
          this.NgV = this.NgA.getHeight();
          Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.NgV) });
          this.NgW = AnimationUtils.loadAnimation(this, R.a.faded_out);
          this.NgY = AnimationUtils.loadAnimation(this, R.a.fjw);
          this.NgX = new AnimationSet(true);
          this.NgX.addAnimation(AnimationUtils.loadAnimation(this, R.a.fjB));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.NgV);
          paramString.setDuration(300L);
          this.NgX.addAnimation(paramString);
          this.NgW.setDuration(200L);
          this.NgX.setDuration(300L);
          this.NgY.setDuration(300L);
          this.NgW.setInterpolator(new AccelerateDecelerateInterpolator());
          this.NgX.setInterpolator(new AccelerateDecelerateInterpolator());
          this.NgY.setInterpolator(new AccelerateDecelerateInterpolator());
          this.NgX.setFillAfter(true);
          paramString.setFillAfter(true);
          this.NgX.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(284587);
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
              AppMethodBeat.o(284587);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(284585);
              FacingCreateChatRoomAllInOneUI.m(FacingCreateChatRoomAllInOneUI.this).setVisibility(4);
              AppMethodBeat.o(284585);
            }
          });
          this.Ngv.setVisibility(4);
          this.Ngv.setAnimation(paramString);
          this.Ngz.startAnimation(this.NgW);
          this.Ngw.startAnimation(this.NgW);
          this.NgA.startAnimation(this.NgW);
          this.NgK.startAnimation(this.NgY);
          this.NgH.startAnimation(this.NgX);
          this.NgK.setVisibility(4);
          this.Ngz.setVisibility(8);
          this.NgA.setVisibility(8);
          this.NgP = true;
          gDA();
          AppMethodBeat.o(27655);
          return;
        }
        if (paramInt2 == -431)
        {
          this.Ngo = true;
          a(a.Nhl);
          AppMethodBeat.o(27655);
          return;
        }
        this.Ngo = true;
        a(a.Nhm);
        AppMethodBeat.o(27655);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.Nhl);
        this.Ngo = true;
        AppMethodBeat.o(27655);
        return;
      }
      a(a.Nhm);
      AppMethodBeat.o(27655);
      return;
      if (i != 1) {
        break label902;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramp.gDz().YFk;
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.NgC = true;
        finish();
        paramp = new Intent();
        paramp.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.pFn.d(paramp, this);
        AppMethodBeat.o(27655);
        return;
      }
      if ((paramInt2 == -432) && (!this.NgB))
      {
        this.NgB = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(27655);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      aoP(getString(R.l.gHo));
    } while (this.NgS == null);
    this.NgS.startTimer(3000L);
    AppMethodBeat.o(27655);
    return;
    hideLoading();
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.NgS != null) {
        this.NgS.startTimer(3000L);
      }
      AppMethodBeat.o(27655);
      return;
      aoP(getString(R.l.gSH));
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
      Nhj = new a("Normal", 0);
      Nhk = new a("Loading", 1);
      Nhl = new a("ToSimple", 2);
      Nhm = new a("Unknow", 3);
      Nhn = new a[] { Nhj, Nhk, Nhl, Nhm };
      AppMethodBeat.o(27645);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */