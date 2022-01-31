package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a
{
  private String fdD = null;
  private ah mHandler = new ah(Looper.getMainLooper());
  private int mStatus;
  private int qPG = 0;
  private int qPH = 0;
  private int qPI = 0;
  private a[] qPJ = null;
  private Animation qPK = null;
  private List<f> qPL = null;
  private List<f> qPM = null;
  private boolean qPN = false;
  private int qPO = 0;
  private m qPP = null;
  private m qPQ = null;
  private String qPR = null;
  private ViewFlipper qPS = null;
  private Dialog qPT = null;
  private boolean qPU = true;
  private boolean qPV = false;
  private String qPW;
  private int qPx = -1;
  
  private void a(String paramString, GestureGuardLogicUI.a parama)
  {
    TextView localTextView = this.qPJ[this.qPI].qQd;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.qPH);
    localTextView.startAnimation(this.qPK);
    this.qPK.setAnimationListener(new GestureGuardLogicUI.15(this, parama));
  }
  
  private void a(String paramString, List<f> paramList, w.a parama)
  {
    b(new GestureGuardLogicUI.4(this));
    if (paramString == null)
    {
      bTy();
      parama.a(3, -6, getString(a.g.gesture_pwd_err_token_not_exists), null, null);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bke();
    ((b.a)localObject).ecI = new bkf();
    ((b.a)localObject).ecG = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).Kt();
    bke localbke = (bke)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localbke.tDV = new bmk().bs(paramString.getBytes());
    localbke.tDW = new bmk().bs(e.cY(paramList));
    w.a((com.tencent.mm.ah.b)localObject, new GestureGuardLogicUI.5(this, parama), false);
  }
  
  private void ad(int paramInt, boolean paramBoolean)
  {
    int i = paramInt - this.qPI;
    if (i == 0) {}
    for (;;)
    {
      return;
      this.qPI = paramInt;
      if (paramBoolean) {
        if (i > 0)
        {
          this.qPS.setInAnimation(this, a.a.slide_right_in);
          this.qPS.setOutAnimation(this, a.a.slide_left_out);
        }
      }
      for (;;)
      {
        paramInt = i;
        if (i <= 0) {
          break label118;
        }
        paramInt = 0;
        while (paramInt < i)
        {
          this.qPS.showNext();
          paramInt += 1;
        }
        break;
        this.qPS.setInAnimation(this, a.a.slide_left_in);
        this.qPS.setOutAnimation(this, a.a.slide_right_out);
        continue;
        this.qPS.setInAnimation(null);
        this.qPS.setOutAnimation(null);
      }
      label118:
      while (paramInt < 0)
      {
        this.qPS.showPrevious();
        paramInt += 1;
      }
    }
  }
  
  private void b(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.qPT == null)
    {
      this.qPT = com.tencent.mm.ui.base.h.b(this, getString(a.g.gesture_pwd_msg_loading), false, paramOnCancelListener);
      return;
    }
    this.qPT.show();
  }
  
  private void bTy()
  {
    if ((this.qPT != null) && (this.qPT.isShowing())) {
      this.qPT.dismiss();
    }
  }
  
  private boolean bYm()
  {
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      String str;
      if (this.qPU)
      {
        str = getIntent().getStringExtra("next_action");
        if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str)))
        {
          str = getString(a.g.gesture_pwd_dlg_tip_is_break_open_proc);
          new c.a(this).nW(false).aeA(str).Is(a.g.gesture_pwd_dlg_btn_yes).a(new GestureGuardLogicUI.20(this)).It(a.g.gesture_pwd_dlg_btn_no).b(new GestureGuardLogicUI.19(this)).aoP().show();
        }
      }
      for (;;)
      {
        return true;
        str = getString(a.g.gesture_pwd_dlg_tip_is_break_modify_proc);
        break;
        new c.a(this).nW(true).Iq(a.g.gesture_pwd_dlg_tip_please_set_a_pwd).Is(a.g.gesture_pwd_dlg_btn_ok).a(new GestureGuardLogicUI.18(this)).aoP().show();
      }
    }
    bYp();
    return false;
  }
  
  private void bYn()
  {
    Object localObject1 = this.qPJ[this.qPI];
    switch (this.mStatus)
    {
    default: 
    case 20: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 0: 
    case 1: 
      Object localObject2;
      do
      {
        Object localObject3;
        Object localObject4;
        do
        {
          do
          {
            return;
            setMMTitle(getString(a.g.gesture_pwd_title_input_pattern));
            setMMTitle(getString(a.g.gesture_pwd_title_modify_pattern));
            if (this.qPx == 1)
            {
              localObject2 = new aa();
              ((aa)localObject2).ckr = 8L;
              ((aa)localObject2).cks = 1L;
              ((aa)localObject2).QX();
            }
            for (;;)
            {
              this.qPN = true;
              ((a)localObject1).qQf.setEnableInput(false);
              ((a)localObject1).qQf.setOnPatternListener(null);
              l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.bYe().qPF / 1000L) / 60.0D);
              ((a)localObject1).qQd.setText(String.format(getString(a.g.gesture_pwd_tip_fmt_tries_too_much), new Object[] { Long.valueOf(l) }));
              ((a)localObject1).qQd.setTextColor(getResources().getColor(a.b.gesture_color_tip_wrong_text));
              return;
              if (this.qPx == 2)
              {
                localObject2 = new aa();
                ((aa)localObject2).ckr = 10L;
                ((aa)localObject2).cks = 1L;
                ((aa)localObject2).QX();
              }
            }
            localObject2 = getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject2))
            {
              setMMTitle(getString(a.g.gesture_pwd_title_modify_pattern));
              localObject2 = new aa();
              ((aa)localObject2).ckr = 5L;
              ((aa)localObject2).cks = 1L;
              ((aa)localObject2).QX();
            }
            for (;;)
            {
              this.qPN = false;
              ((a)localObject1).qQf.setEnableInput(true);
              ((a)localObject1).qQf.setOnPatternListener(this);
              ((a)localObject1).qQd.setText(getString(a.g.gesture_pwd_tip_input_new_pattern));
              ((a)localObject1).qQd.setTextColor(getResources().getColor(a.b.gesture_color_tip_norm_text));
              if (((a)localObject1).qQg.getVisibility() == 8) {
                break;
              }
              ((a)localObject1).qQg.setVisibility(8);
              return;
              if ("next_action.switch_on_pattern".equals(localObject2))
              {
                setMMTitle(getString(a.g.gesture_pwd_title_switch_on_pattern));
                localObject2 = new aa();
                ((aa)localObject2).ckr = 4L;
                ((aa)localObject2).cks = 1L;
                ((aa)localObject2).QX();
              }
              else
              {
                setMMTitle(getString(a.g.gesture_pwd_title_modify_pattern));
                localObject2 = new aa();
                ((aa)localObject2).ckr = 5L;
                ((aa)localObject2).cks = 1L;
                ((aa)localObject2).QX();
              }
            }
            ((a)localObject1).qQd.setText(getResources().getString(a.g.gesture_pwd_tip_input_again));
            ((a)localObject1).qQd.setTextColor(this.qPG);
            ((a)localObject1).qQf.bYt();
            ((a)localObject1).qQf.setEnableInput(true);
          } while (((a)localObject1).qQg.getVisibility() == 8);
          ((a)localObject1).qQg.setVisibility(8);
          return;
          localObject1 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject1))
          {
            if (this.qPV)
            {
              this.qPV = false;
              a(this.fdD, this.qPL, new GestureGuardLogicUI.21(this));
              return;
            }
            localObject1 = this.qPM;
            localObject2 = this.qPL;
            localObject3 = new GestureGuardLogicUI.22(this);
            localObject4 = new b.a();
            b(new GestureGuardLogicUI.8(this));
            ((b.a)localObject4).ecH = new bak();
            ((b.a)localObject4).ecI = new bal();
            ((b.a)localObject4).ecG = 689;
            ((b.a)localObject4).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject4 = ((b.a)localObject4).Kt();
            bak localbak = (bak)((com.tencent.mm.ah.b)localObject4).ecE.ecN;
            localbak.uC = 1;
            localbak.twr = new bmk().bs(e.cY((List)localObject1));
            localbak.tws = new bmk().bs(e.cY((List)localObject2));
            w.a((com.tencent.mm.ah.b)localObject4, new GestureGuardLogicUI.9(this, (w.a)localObject3), false);
            return;
          }
          if ("next_action.switch_on_pattern".equals(localObject1))
          {
            a(this.fdD, this.qPL, new GestureGuardLogicUI.23(this));
            return;
          }
        } while (!"next_action.goto_protected_page".equals(localObject1));
        a(this.fdD, this.qPL, new GestureGuardLogicUI.24(this));
        return;
        ((a)localObject1).qQf.setEnableInput(false);
        ((a)localObject1).qQf.setDisplayMode(PatternLockView.b.qQK);
        a(getResources().getString(a.g.gesture_pwd_tip_input_mismatch), new GestureGuardLogicUI.25(this, (a)localObject1));
        return;
        setMMTitle(getString(a.g.gesture_pwd_title_input_pattern));
        this.qPN = false;
        ((a)localObject1).qQf.setEnableInput(true);
        ((a)localObject1).qQf.setOnPatternListener(this);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
          if (!bk.bl(this.qPW)) {
            ((a)localObject1).qQd.setText(this.qPW);
          }
        }
        for (;;)
        {
          ((a)localObject1).qQd.setTextColor(this.qPG);
          if (((a)localObject1).qQg.getVisibility() == 0) {
            break;
          }
          ((a)localObject1).qQg.setVisibility(0);
          return;
          ((a)localObject1).qQd.setText(getString(a.g.gesture_pwd_tip_input_pattern));
          continue;
          ((a)localObject1).qQd.setText(getString(a.g.gesture_pwd_tip_input_orig_pattern));
        }
        localObject2 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject2))
        {
          ((a)localObject1).qQf.bYt();
          ad(1, true);
          this.mStatus = 16;
          break;
        }
        if ("next_action.switch_off_pattern".equals(localObject2))
        {
          localObject1 = this.qPM;
          localObject2 = new GestureGuardLogicUI.26(this);
          b(new GestureGuardLogicUI.10(this));
          localObject3 = new b.a();
          ((b.a)localObject3).ecH = new bak();
          ((b.a)localObject3).ecI = new bal();
          ((b.a)localObject3).ecG = 689;
          ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/oppatternlock";
          localObject3 = ((b.a)localObject3).Kt();
          localObject4 = (bak)((com.tencent.mm.ah.b)localObject3).ecE.ecN;
          ((bak)localObject4).uC = 3;
          ((bak)localObject4).twr = new bmk().bs(e.cY((List)localObject1));
          w.a((com.tencent.mm.ah.b)localObject3, new GestureGuardLogicUI.11(this, (w.a)localObject2), false);
          return;
        }
      } while (!"next_action.goto_protected_page".equals(localObject2));
      com.tencent.mm.plugin.walletlock.gesture.a.d.gM(SystemClock.elapsedRealtime());
      bYo();
      com.tencent.mm.plugin.walletlock.c.h.Y(this.qPx, 1, 0);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.plugin.walletlock.gesture.a.d.R(l, 0L);
    com.tencent.mm.plugin.walletlock.gesture.a.d.Bb(this.qPO);
    com.tencent.mm.plugin.walletlock.gesture.a.d.bXT();
    if (this.qPO == 5)
    {
      this.qPN = true;
      com.tencent.mm.plugin.walletlock.gesture.a.d.Q(l, 0L);
      ((a)localObject1).qQf.bYt();
      ((a)localObject1).qQf.setEnableInput(false);
      this.mStatus = 20;
      bYn();
      localObject1 = new c.a(this);
      ((c.a)localObject1).nW(false).aeA(String.format(getString(a.g.gesture_pwd_dlg_fmt_tries_too_much), new Object[] { Long.valueOf(10L) }));
      ((c.a)localObject1).Is(a.g.gesture_pwd_dlg_btn_forgot).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].qQg);
        }
      });
      ((c.a)localObject1).It(a.g.gesture_pwd_dlg_btn_cancel).b(new GestureGuardLogicUI.17(this));
      ((c.a)localObject1).aoP().show();
    }
    for (;;)
    {
      localObject1 = getIntent().getStringExtra("next_action");
      y.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
      if (!"next_action.goto_protected_page".equals(localObject1)) {
        break;
      }
      if (this.qPO != 5) {
        break label1530;
      }
      com.tencent.mm.plugin.walletlock.c.h.Y(this.qPx, 1, 2);
      return;
      ((a)localObject1).qQf.setEnableInput(false);
      ((a)localObject1).qQf.setDisplayMode(PatternLockView.b.qQK);
      a(String.format(getResources().getString(a.g.gesture_pwd_fmt_input_pattern_wrong), new Object[] { Integer.valueOf(5 - this.qPO) }), new GestureGuardLogicUI.a()
      {
        public final void onDone()
        {
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
          this.qQb.qQf.bYt();
          this.qQb.qQf.setEnableInput(true);
        }
      });
    }
    label1530:
    com.tencent.mm.plugin.walletlock.c.h.Y(this.qPx, 1, 1);
  }
  
  private void bYo()
  {
    Intent localIntent = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localIntent != null)
    {
      i.qRd.kV(true);
      i.qRd.kW(true);
      localIntent.addFlags(131072);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      y.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void bYp()
  {
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.qRd.bYH();
    }
  }
  
  private void t(int paramInt1, int paramInt2, String paramString)
  {
    y.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(paramInt1, localIntent);
    finish();
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    paramPatternLockView.setDisplayMode(PatternLockView.b.qQJ);
  }
  
  public final void a(PatternLockView paramPatternLockView, List<f> paramList)
  {
    boolean bool2 = true;
    if (this.mStatus == 16)
    {
      if (paramList.size() < 4)
      {
        paramPatternLockView.setEnableInput(false);
        paramPatternLockView.setDisplayMode(PatternLockView.b.qQK);
        a(String.format(getString(a.g.gesture_pwd_fmt_pattern_too_short), new Object[] { Integer.valueOf(4) }), new GestureGuardLogicUI.2(this, paramPatternLockView));
        return;
      }
      this.qPL = paramList;
      paramPatternLockView.bYt();
      this.mStatus = 17;
      ad(2, true);
    }
    for (;;)
    {
      bYn();
      return;
      if (this.mStatus == 0)
      {
        paramPatternLockView = new GestureGuardLogicUI.3(this, paramList);
        Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.bYj();
        Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.bYi();
        com.tencent.mm.plugin.report.service.h.nFQ.f(11453, new Object[0]);
        b(new GestureGuardLogicUI.6(this));
        boolean bool3 = e.b((bcv)localObject1);
        boolean bool4 = e.b((bcu)localObject2);
        if (bool4) {
          if (bool3) {
            if (((bcu)localObject2).version < ((bcv)localObject1).tyg) {
              bool1 = true;
            }
          }
        }
        for (;;)
        {
          y.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
          if (!bool1) {
            break;
          }
          localObject1 = new b.a();
          ((b.a)localObject1).ecH = new bak();
          ((b.a)localObject1).ecI = new bal();
          ((b.a)localObject1).ecG = 689;
          ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
          localObject1 = ((b.a)localObject1).Kt();
          localObject2 = (bak)((com.tencent.mm.ah.b)localObject1).ecE.ecN;
          ((bak)localObject2).uC = 2;
          ((bak)localObject2).twr = new bmk().bs(e.cY(paramList));
          w.a((com.tencent.mm.ah.b)localObject1, new GestureGuardLogicUI.7(this, paramPatternLockView), false);
          return;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = true;
        }
        bTy();
        localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.bYi();
        if (localObject1 == null) {}
        for (boolean bool1 = bool2; bool1; bool1 = new String(((bcu)localObject1).tyd.tFM.oY).equals(com.tencent.mm.a.g.o(((StringBuilder)localObject2).toString().getBytes())))
        {
          paramPatternLockView.a(3, 0, null, null, null);
          return;
          localObject2 = new StringBuilder();
          com.tencent.mm.kernel.g.DN();
          ((StringBuilder)localObject2).append(new o(com.tencent.mm.kernel.a.CK()).longValue());
          ((StringBuilder)localObject2).append('_');
          ((StringBuilder)localObject2).append(new String(e.cY(paramList)));
        }
        paramPatternLockView.a(3, -3, null, null, null);
        return;
      }
      if (this.mStatus != 17) {
        break;
      }
      if (this.qPL.equals(paramList))
      {
        paramPatternLockView.bYt();
        this.qPN = false;
        this.qPO = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.bYl();
        com.tencent.mm.plugin.walletlock.gesture.a.d.bYf();
        com.tencent.mm.plugin.walletlock.gesture.a.d.bYh();
        com.tencent.mm.plugin.walletlock.gesture.a.d.bXT();
        this.mStatus = 18;
      }
      else
      {
        this.mStatus = 19;
      }
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView()
  {
    XM();
    setMMSubTitle(a.g.wechat_authenticate_safely);
    this.qPK = AnimationUtils.loadAnimation(this, a.a.shake_object_animate);
    this.qPG = getResources().getColor(a.b.gesture_color_tip_norm_text);
    this.qPH = getResources().getColor(a.b.gesture_color_tip_wrong_text);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      ad(1, false);
    }
    while (!"action.verify_pattern".equals(str))
    {
      setBackBtn(new GestureGuardLogicUI.1(this));
      y.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      bYn();
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.bYd()) {
      this.qPN = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      ad(0, false);
      break;
      this.qPN = false;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramIntent != null) {
        break label26;
      }
      y.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
    }
    label26:
    do
    {
      return;
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.fdD = paramIntent.getStringExtra("key_token");
        this.qPR = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.qPV = true;
          }
          this.qPU = false;
          setBackBtn(null);
          mT(false);
          this.mStatus = 16;
          ad(1, false);
        }
        for (;;)
        {
          bYn();
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.fdD;
            w.a local12 = new w.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
              {
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.bYl();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.bYf();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.bYh();
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.gesture_pwd_toast_disabled), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.c(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.gesture_pwd_err_runtime), 0).show();
                }
              }
            };
            b(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].qQf.bYt();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).aSd)) {
                  com.tencent.mm.kernel.g.Dk().c(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
              }
            });
            if (paramIntent == null)
            {
              bTy();
              local12.a(3, -6, getString(a.g.gesture_pwd_err_token_not_exists), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).ecH = new bke();
              ((b.a)localObject).ecI = new bkf();
              ((b.a)localObject).ecG = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).Kt();
              bke localbke = (bke)((com.tencent.mm.ah.b)localObject).ecE.ecN;
              localbke.tDV = new bmk().bs(paramIntent.getBytes());
              localbke.uC = 3;
              w.a((com.tencent.mm.ah.b)localObject, new GestureGuardLogicUI.14(this, local12), false);
            }
          }
          else
          {
            this.mStatus = 1;
          }
        }
      }
    } while (paramInt1 != -1);
    Toast.makeText(this, getString(a.g.gesture_pwd_err_runtime), 0).show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == a.d.tv_forgotpwd)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if ((!ae.getPackageName().equals(paramBundle.getPackage())) || (bk.bl(paramBundle.getStringExtra("action"))) || (bk.bl(paramBundle.getStringExtra("next_action"))))
    {
      y.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      return;
    }
    this.qPS = new ViewFlipper(this);
    this.qPJ = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.qPJ;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.qPS.addView(localObject.mView);
      localObject.qQf.setOnPatternListener(this);
      localObject.qQg.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.qPS);
    this.fdD = getIntent().getStringExtra("token");
    this.qPR = getIntent().getStringExtra("type");
    this.qPW = getIntent().getStringExtra("verify_title");
    this.qPx = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.bYD();
    }
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.qPP != null)
    {
      com.tencent.mm.kernel.g.Dk().c(this.qPP);
      this.qPP = null;
    }
    if (this.qPQ != null)
    {
      com.tencent.mm.kernel.g.Dk().c(this.qPQ);
      this.qPQ = null;
    }
    if ((this.qPT != null) && (this.qPT.isShowing())) {
      this.qPT.dismiss();
    }
    if (this.qPS != null)
    {
      this.qPS.removeAllViews();
      this.qPS = null;
    }
    int i = 0;
    while (i < this.qPJ.length)
    {
      a locala = this.qPJ[i];
      locala.qQf.setOnClickListener(null);
      locala.qQg.setOnClickListener(null);
      locala.mView = null;
      locala.qQd = null;
      locala.qQe = null;
      locala.qQf = null;
      locala.qQg = null;
      this.qPJ[i] = null;
      i += 1;
    }
    this.qPJ = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (bYm()) {
        return false;
      }
      t(0, 4, "user cancel when setting gesture");
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mStatus == 0)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.bYg();
      if (localg.qPE == -1L) {
        break label86;
      }
      e.a(localg);
      if (localg.qPF / 1000L >= 600L) {
        break label83;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.R(localg.qPE, localg.qPF);
    }
    label83:
    label86:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.qPO = com.tencent.mm.plugin.walletlock.gesture.a.d.bYk();
        if (this.qPO != -1) {}
      }
      else
      {
        this.qPO = 0;
      }
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.bYh();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Object localObject = this.qPJ[this.qPI];
    if (((a)localObject).qQf != null)
    {
      localObject = ((a)localObject).qQf;
      if ((!paramBoolean) || (this.qPN)) {
        break label41;
      }
    }
    label41:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PatternLockView)localObject).setEnableInput(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */