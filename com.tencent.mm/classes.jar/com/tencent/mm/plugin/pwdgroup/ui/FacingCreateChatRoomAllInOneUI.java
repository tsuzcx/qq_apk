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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  private b.a dZA;
  private String eiu;
  private ProgressDialog gsr;
  private boolean jRa;
  private ak mHandler;
  private boolean ogA;
  private d pFO;
  private boolean pFP;
  private boolean pFQ;
  private boolean pFR;
  private boolean pFS;
  private boolean pFT;
  private Location pFU;
  private String pFV;
  private MMPwdInputView pFW;
  private View pFX;
  private ProgressBar pFY;
  private TextView pFZ;
  public MenuItem.OnMenuItemClickListener pGA;
  public MMPwdInputView.a pGB;
  private View.OnClickListener pGC;
  public MMKeyBoardView.a pGD;
  private ap pGE;
  private MMKeyBoardView pGa;
  private TextView pGb;
  private boolean pGc;
  private boolean pGd;
  private LinkedList<abw> pGe;
  private HashMap<String, abw> pGf;
  private LinkedList<abw> pGg;
  private a pGh;
  private View pGi;
  private TextView pGj;
  private MMScrollGridView pGk;
  private View pGl;
  private View pGm;
  private Button pGn;
  private MMCallBackScrollView pGo;
  private TextView pGp;
  private boolean pGq;
  private Runnable pGr;
  private ak pGs;
  private ap pGt;
  private com.tencent.mm.plugin.pwdgroup.a.a pGu;
  private com.tencent.mm.plugin.pwdgroup.a.a pGv;
  private int pGw;
  private Animation pGx;
  private AnimationSet pGy;
  private Animation pGz;
  
  public FacingCreateChatRoomAllInOneUI()
  {
    AppMethodBeat.i(24007);
    this.pFP = false;
    this.pFT = false;
    this.pGc = false;
    this.pGd = false;
    this.jRa = false;
    this.pGe = new LinkedList();
    this.pGf = new HashMap();
    this.pGg = new LinkedList();
    this.pGq = false;
    this.pGt = new ap(new FacingCreateChatRoomAllInOneUI.1(this), false);
    this.mHandler = new FacingCreateChatRoomAllInOneUI.11(this);
    this.pGA = new FacingCreateChatRoomAllInOneUI.12(this);
    this.pGB = new FacingCreateChatRoomAllInOneUI.13(this);
    this.pGC = new FacingCreateChatRoomAllInOneUI.14(this);
    this.pGD = new FacingCreateChatRoomAllInOneUI.15(this);
    this.dZA = new FacingCreateChatRoomAllInOneUI.16(this);
    this.pGE = new ap(new FacingCreateChatRoomAllInOneUI.17(this), false);
    AppMethodBeat.o(24007);
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(24021);
    h.a(this, paramString, "", getString(2131297018), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(24021);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(24019);
    if (this.pFZ != null) {}
    switch (FacingCreateChatRoomAllInOneUI.10.pGI[parama.ordinal()])
    {
    default: 
      ab.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
      AppMethodBeat.o(24019);
      return;
    case 1: 
      ki(true);
      this.pFP = false;
      this.pFT = false;
      this.pFY.setVisibility(8);
      this.pFZ.setVisibility(8);
      AppMethodBeat.o(24019);
      return;
    case 2: 
      ki(false);
      this.pFZ.setText(2131302266);
      this.pFY.setVisibility(0);
      this.pFZ.setVisibility(8);
      AppMethodBeat.o(24019);
      return;
    case 3: 
      ki(true);
      this.pFY.setVisibility(8);
      this.pFZ.setVisibility(0);
      this.pFZ.setText(2131302263);
      cdm();
      AppMethodBeat.o(24019);
      return;
    }
    ki(true);
    this.pFY.setVisibility(8);
    this.pFZ.setVisibility(0);
    this.pFZ.setText(2131302265);
    cdm();
    AppMethodBeat.o(24019);
  }
  
  private void apS()
  {
    AppMethodBeat.i(24009);
    this.pFO = d.agQ();
    this.pFO.a(this.dZA, true);
    aw.Rc().a(653, this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(24009);
  }
  
  private void cdk()
  {
    AppMethodBeat.i(24022);
    this.jRa = false;
    if (this.pGt != null) {
      this.pGt.ag(0L, 0L);
    }
    AppMethodBeat.o(24022);
  }
  
  private void cdl()
  {
    AppMethodBeat.i(24023);
    this.jRa = true;
    if (this.pGt != null) {
      this.pGt.stopTimer();
    }
    aw.Rc().a(this.pGu);
    AppMethodBeat.o(24023);
  }
  
  private void cdm()
  {
    AppMethodBeat.i(24024);
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, 2131034126);
    final Animation localAnimation2 = AnimationUtils.loadAnimation(this, 2131034125);
    localAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimation1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(23990);
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).axH();
        FacingCreateChatRoomAllInOneUI.g(FacingCreateChatRoomAllInOneUI.this).startAnimation(localAnimation2);
        AppMethodBeat.o(23990);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localAnimation2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(23991);
        if (FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this) != null) {
          FacingCreateChatRoomAllInOneUI.r(FacingCreateChatRoomAllInOneUI.this).setKeyBoardEnable(true);
        }
        AppMethodBeat.o(23991);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (this.pFW != null) {
      this.pFW.startAnimation(localAnimation1);
    }
    if (this.pGa != null) {
      this.pGa.setKeyBoardEnable(false);
    }
    AppMethodBeat.o(24024);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(24020);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(24020);
  }
  
  private void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(24018);
    if (this.pGa != null) {
      this.pGa.setKeyBoardEnable(paramBoolean);
    }
    AppMethodBeat.o(24018);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969522;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24015);
    setMMTitle(2131299913);
    setBackBtn(this.pGA);
    setActionbarColor(getResources().getColor(2131690605));
    this.pFX = findViewById(2131823987);
    this.pFY = ((ProgressBar)findViewById(2131823988));
    this.pFZ = ((TextView)findViewById(2131823989));
    this.pGa = ((MMKeyBoardView)findViewById(2131823990));
    this.pGb = ((TextView)findViewById(2131823979));
    this.pFW = ((MMPwdInputView)findViewById(2131823983));
    this.pFW.setOnFinishInputListener(this.pGB);
    this.pFW.requestFocus();
    this.pGa.setOnInputDeleteListener(this.pGD);
    a(a.pGK);
    this.pGi = findViewById(2131823984);
    this.pGj = ((TextView)findViewById(2131823985));
    this.pGk = ((MMScrollGridView)findViewById(2131823986));
    this.pGk.setVisibility(4);
    this.pGn = ((Button)findViewById(2131823992));
    this.pGn.setOnClickListener(this.pGC);
    this.pGl = findViewById(2131823981);
    this.pGm = findViewById(2131823991);
    this.pGj.setText(2131299657);
    this.pGo = ((MMCallBackScrollView)findViewById(2131823980));
    this.pGp = ((TextView)findViewById(2131823982));
    this.pGo.setMMOnScrollListener(new FacingCreateChatRoomAllInOneUI.3(this));
    this.pGh = new a(this);
    this.pGk.setAdapter(this.pGh);
    this.pGh.setData(this.pGe);
    AppMethodBeat.o(24015);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24014);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30764)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          AppMethodBeat.o(24014);
          return;
        }
        finish();
        AppMethodBeat.o(24014);
        return;
      }
      finish();
    }
    AppMethodBeat.o(24014);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(24017);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(24017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24008);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131306183, new Object[] { aa.dsG() }), 30764, true);
          AppMethodBeat.o(24008);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(24008);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(24008);
        return;
      }
    }
    apS();
    AppMethodBeat.o(24008);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24013);
    aw.Rc().b(653, this);
    if (this.pFO != null) {
      this.pFO.c(this.dZA);
    }
    if (!this.pGd)
    {
      aw.Rc().cancel(653);
      if (this.pFU != null)
      {
        this.pGv = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.pFV, "", this.pFU.fBB, this.pFU.fBC, this.pFU.accuracy, this.pFU.cAJ, this.pFU.mac, this.pFU.cAL);
        aw.Rc().a(this.pGv, 0);
      }
    }
    if (this.pGq) {
      cdl();
    }
    if ((this.pGs != null) && (this.pGr != null)) {
      this.pGs.removeCallbacks(this.pGr);
    }
    super.onDestroy();
    AppMethodBeat.o(24013);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24012);
    if (this.pFO != null) {
      this.pFO.c(this.dZA);
    }
    if (this.pGq) {
      cdl();
    }
    super.onPause();
    AppMethodBeat.o(24012);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(24010);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24010);
      return;
    }
    ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24010);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        apS();
        AppMethodBeat.o(24010);
        return;
      }
      h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new DialogInterface.OnClickListener()new FacingCreateChatRoomAllInOneUI.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(24003);
          FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          FacingCreateChatRoomAllInOneUI.this.finish();
          AppMethodBeat.o(24003);
        }
      }, new FacingCreateChatRoomAllInOneUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24011);
    if (this.pFO != null) {
      this.pFO.a(this.dZA, true);
    }
    if (this.pGq) {
      cdk();
    }
    super.onResume();
    AppMethodBeat.o(24011);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    AppMethodBeat.i(24016);
    ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    default: 
      ab.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
    }
    label612:
    do
    {
      int i;
      do
      {
        do
        {
          AppMethodBeat.o(24016);
          return;
          paramm = (com.tencent.mm.plugin.pwdgroup.a.a)paramm;
          i = paramm.cuo;
          if (i != 0) {
            break label612;
          }
          this.pFS = false;
          if (!this.pGq) {
            break;
          }
          if (this.pGt != null) {
            this.pGt.ag(3000L, 3000L);
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = paramm.cdj().wov;
        if (this.pGs == null) {
          this.pGs = new al().caB();
        }
        if (this.pGr != null) {
          this.pGs.removeCallbacks(this.pGr);
        }
        this.pGr = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23989);
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
                localObject = (abw)paramString.get(i);
                if (!bo.isNullOrNil(((abw)localObject).wSo)) {
                  FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).put(((abw)localObject).wSo, localObject);
                }
                i += 1;
              }
            }
            int j = FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).size();
            int i = 0;
            if (i < j)
            {
              localObject = (abw)FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).get(i);
              if (!FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).containsKey(((abw)localObject).wSo)) {
                ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((abw)localObject).wSo });
              }
              for (;;)
              {
                i += 1;
                break;
                FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).remove(((abw)localObject).wSo);
              }
            }
            if ((FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this) != null) && (FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).size() > 0))
            {
              localObject = FacingCreateChatRoomAllInOneUI.t(FacingCreateChatRoomAllInOneUI.this).entrySet().iterator();
              while (((Iterator)localObject).hasNext())
              {
                abw localabw = (abw)((Map.Entry)((Iterator)localObject).next()).getValue();
                FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this).add(localabw);
                ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localabw.wSo });
              }
            }
            FacingCreateChatRoomAllInOneUI.c(FacingCreateChatRoomAllInOneUI.this).addAll(FacingCreateChatRoomAllInOneUI.s(FacingCreateChatRoomAllInOneUI.this));
            FacingCreateChatRoomAllInOneUI.u(FacingCreateChatRoomAllInOneUI.this).sendEmptyMessage(10001);
            AppMethodBeat.o(23989);
          }
        };
        this.pGs.post(this.pGr);
        this.eiu = paramm.cdj().wQf;
        AppMethodBeat.o(24016);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(a.pGK);
          this.pGw = this.pGb.getHeight();
          ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[] { Integer.valueOf(this.pGw) });
          this.pGx = AnimationUtils.loadAnimation(this, 2131034174);
          this.pGz = AnimationUtils.loadAnimation(this, 2131034167);
          this.pGy = new AnimationSet(true);
          this.pGy.addAnimation(AnimationUtils.loadAnimation(this, 2131034247));
          paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.pGw);
          paramString.setDuration(300L);
          this.pGy.addAnimation(paramString);
          this.pGx.setDuration(200L);
          this.pGy.setDuration(300L);
          this.pGz.setDuration(300L);
          this.pGx.setInterpolator(new AccelerateDecelerateInterpolator());
          this.pGy.setInterpolator(new AccelerateDecelerateInterpolator());
          this.pGz.setInterpolator(new AccelerateDecelerateInterpolator());
          this.pGy.setFillAfter(true);
          paramString.setFillAfter(true);
          this.pGy.setAnimationListener(new FacingCreateChatRoomAllInOneUI.4(this));
          this.pFW.setVisibility(4);
          this.pFW.setAnimation(paramString);
          this.pGa.startAnimation(this.pGx);
          this.pFX.startAnimation(this.pGx);
          this.pGb.startAnimation(this.pGx);
          this.pGl.startAnimation(this.pGz);
          this.pGi.startAnimation(this.pGy);
          this.pGl.setVisibility(4);
          this.pGa.setVisibility(8);
          this.pGb.setVisibility(8);
          this.pGq = true;
          cdk();
          AppMethodBeat.o(24016);
          return;
        }
        if (paramInt2 == -431)
        {
          this.pFP = true;
          a(a.pGM);
          AppMethodBeat.o(24016);
          return;
        }
        this.pFP = true;
        a(a.pGN);
        AppMethodBeat.o(24016);
        return;
        if (i != 3) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      if (paramInt2 == -431)
      {
        a(a.pGM);
        this.pFP = true;
        AppMethodBeat.o(24016);
        return;
      }
      a(a.pGN);
      AppMethodBeat.o(24016);
      return;
      if (i != 1) {
        break label910;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hideLoading();
        paramString = paramm.cdj().wot;
        ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[] { String.valueOf(paramString) });
        this.pGd = true;
        finish();
        paramm = new Intent();
        paramm.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.pwdgroup.a.gmO.d(paramm, this);
        AppMethodBeat.o(24016);
        return;
      }
      if ((paramInt2 == -432) && (!this.pGc))
      {
        this.pGc = true;
        this.mHandler.sendEmptyMessageDelayed(10002, 3000L);
        AppMethodBeat.o(24016);
        return;
      }
      if (paramInt2 != -23) {
        break;
      }
      hideLoading();
      La(getString(2131299659));
    } while (this.pGt == null);
    this.pGt.ag(3000L, 3000L);
    AppMethodBeat.o(24016);
    return;
    hideLoading();
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null) {
      paramString.a(getContext(), null, null);
    }
    for (;;)
    {
      if (this.pGt != null) {
        this.pGt.ag(3000L, 3000L);
      }
      AppMethodBeat.o(24016);
      return;
      La(getString(2131302265));
    }
    label910:
    hideLoading();
    AppMethodBeat.o(24016);
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
      AppMethodBeat.i(24006);
      pGK = new a("Normal", 0);
      pGL = new a("Loading", 1);
      pGM = new a("ToSimple", 2);
      pGN = new a("Unknow", 3);
      pGO = new a[] { pGK, pGL, pGM, pGN };
      AppMethodBeat.o(24006);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI
 * JD-Core Version:    0.7.0.1
 */