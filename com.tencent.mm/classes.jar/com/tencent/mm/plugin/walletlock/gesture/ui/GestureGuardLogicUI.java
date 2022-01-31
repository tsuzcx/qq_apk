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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a
{
  private ak mHandler;
  private int mStatus;
  private String mToken;
  private int uEF;
  private int uEO;
  private int uEP;
  private int uEQ;
  private a[] uER;
  private Animation uES;
  private List<f> uET;
  private List<f> uEU;
  private boolean uEV;
  private int uEW;
  private m uEX;
  private m uEY;
  private String uEZ;
  private ViewFlipper uFa;
  private Dialog uFb;
  private boolean uFc;
  private boolean uFd;
  private String uFe;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(51614);
    this.uEO = 0;
    this.uEP = 0;
    this.uEQ = 0;
    this.uER = null;
    this.uES = null;
    this.uET = null;
    this.uEU = null;
    this.uEV = false;
    this.uEW = 0;
    this.uEX = null;
    this.uEY = null;
    this.mToken = null;
    this.uEZ = null;
    this.uFa = null;
    this.mHandler = new ak(Looper.getMainLooper());
    this.uFb = null;
    this.uFc = true;
    this.uFd = false;
    this.uEF = -1;
    AppMethodBeat.o(51614);
  }
  
  private void a(String paramString, GestureGuardLogicUI.a parama)
  {
    AppMethodBeat.i(51634);
    TextView localTextView = this.uER[this.uEQ].uFl;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.uEP);
    localTextView.startAnimation(this.uES);
    this.uES.setAnimationListener(new GestureGuardLogicUI.15(this, parama));
    AppMethodBeat.o(51634);
  }
  
  private void a(String paramString, List<f> paramList, w.a parama)
  {
    AppMethodBeat.i(51626);
    c(new GestureGuardLogicUI.4(this));
    if (paramString == null)
    {
      aCV();
      parama.a(3, -6, getString(2131300506), null, null);
      AppMethodBeat.o(51626);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bte();
    ((b.a)localObject).fsY = new btf();
    ((b.a)localObject).funcId = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).ado();
    bte localbte = (bte)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localbte.xGL = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localbte.xGM = new SKBuiltinBuffer_t().setBuffer(e.ec(paramList));
    w.a((com.tencent.mm.ai.b)localObject, new GestureGuardLogicUI.5(this, parama), false);
    AppMethodBeat.o(51626);
  }
  
  private void a(List<f> paramList, w.a parama)
  {
    AppMethodBeat.i(51628);
    c(new GestureGuardLogicUI.10(this));
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhn();
    ((b.a)localObject).fsY = new bho();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).ado();
    bhn localbhn = (bhn)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localbhn.vA = 3;
    localbhn.xwF = new SKBuiltinBuffer_t().setBuffer(e.ec(paramList));
    w.a((com.tencent.mm.ai.b)localObject, new GestureGuardLogicUI.11(this, parama), false);
    AppMethodBeat.o(51628);
  }
  
  private void a(List<f> paramList1, List<f> paramList2, w.a parama)
  {
    AppMethodBeat.i(51627);
    Object localObject = new b.a();
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(51593);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].uFn.cYe();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.Rc().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(51593);
      }
    });
    ((b.a)localObject).fsX = new bhn();
    ((b.a)localObject).fsY = new bho();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).ado();
    bhn localbhn = (bhn)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localbhn.vA = 1;
    localbhn.xwF = new SKBuiltinBuffer_t().setBuffer(e.ec(paramList1));
    localbhn.xwG = new SKBuiltinBuffer_t().setBuffer(e.ec(paramList2));
    w.a((com.tencent.mm.ai.b)localObject, new GestureGuardLogicUI.9(this, parama), false);
    AppMethodBeat.o(51627);
  }
  
  private void aCV()
  {
    AppMethodBeat.i(51639);
    if ((this.uFb != null) && (this.uFb.isShowing())) {
      this.uFb.dismiss();
    }
    AppMethodBeat.o(51639);
  }
  
  private void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51633);
    int i = paramInt - this.uEQ;
    if (i == 0)
    {
      AppMethodBeat.o(51633);
      return;
    }
    this.uEQ = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.uFa.setInAnimation(this, 2131034266);
        this.uFa.setOutAnimation(this, 2131034263);
      }
    }
    for (;;)
    {
      paramInt = i;
      if (i <= 0) {
        break label137;
      }
      paramInt = 0;
      while (paramInt < i)
      {
        this.uFa.showNext();
        paramInt += 1;
      }
      this.uFa.setInAnimation(this, 2131034262);
      this.uFa.setOutAnimation(this, 2131034267);
      continue;
      this.uFa.setInAnimation(null);
      this.uFa.setOutAnimation(null);
    }
    AppMethodBeat.o(51633);
    return;
    label137:
    while (paramInt < 0)
    {
      this.uFa.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(51633);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51638);
    if (this.uFb == null)
    {
      this.uFb = com.tencent.mm.ui.base.h.b(this, getString(2131300509), false, paramOnCancelListener);
      AppMethodBeat.o(51638);
      return;
    }
    this.uFb.show();
    AppMethodBeat.o(51638);
  }
  
  private boolean cXU()
  {
    AppMethodBeat.i(51623);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.uFc) {
        cYa();
      }
      for (;;)
      {
        AppMethodBeat.o(51623);
        return true;
        cXZ();
      }
    }
    cXX();
    AppMethodBeat.o(51623);
    return false;
  }
  
  private void cXV()
  {
    AppMethodBeat.i(51624);
    Object localObject1 = this.uER[this.uEQ];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51624);
      return;
      setMMTitle(getString(2131300518));
      setMMTitle(getString(2131300519));
      if (this.uEF == 1)
      {
        localObject2 = new bt();
        ((bt)localObject2).cRI = 8L;
        ((bt)localObject2).cYT = 1L;
        ((bt)localObject2).ake();
      }
      long l;
      for (;;)
      {
        this.uEV = true;
        ((a)localObject1).uFn.setEnableInput(false);
        ((a)localObject1).uFn.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.cXM().uEN / 1000L) / 60.0D);
        ((a)localObject1).uFl.setText(String.format(getString(2131300511), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).uFl.setTextColor(getResources().getColor(2131690137));
        AppMethodBeat.o(51624);
        return;
        if (this.uEF == 2)
        {
          localObject2 = new bt();
          ((bt)localObject2).cRI = 10L;
          ((bt)localObject2).cYT = 1L;
          ((bt)localObject2).ake();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131300519));
        localObject2 = new bt();
        ((bt)localObject2).cRI = 5L;
        ((bt)localObject2).cYT = 1L;
        ((bt)localObject2).ake();
      }
      for (;;)
      {
        this.uEV = false;
        ((a)localObject1).uFn.setEnableInput(true);
        ((a)localObject1).uFn.setOnPatternListener(this);
        ((a)localObject1).uFl.setText(getString(2131300515));
        ((a)localObject1).uFl.setTextColor(getResources().getColor(2131690136));
        if (((a)localObject1).uFo.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).uFo.setVisibility(8);
        AppMethodBeat.o(51624);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131300520));
          localObject2 = new bt();
          ((bt)localObject2).cRI = 4L;
          ((bt)localObject2).cYT = 1L;
          ((bt)localObject2).ake();
        }
        else
        {
          setMMTitle(getString(2131300519));
          localObject2 = new bt();
          ((bt)localObject2).cRI = 5L;
          ((bt)localObject2).cYT = 1L;
          ((bt)localObject2).ake();
        }
      }
      ((a)localObject1).uFl.setText(getResources().getString(2131300513));
      ((a)localObject1).uFl.setTextColor(this.uEO);
      ((a)localObject1).uFn.cYe();
      ((a)localObject1).uFn.setEnableInput(true);
      if (((a)localObject1).uFo.getVisibility() != 8)
      {
        ((a)localObject1).uFo.setVisibility(8);
        AppMethodBeat.o(51624);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.uFd)
          {
            this.uFd = false;
            a(this.mToken, this.uET, new GestureGuardLogicUI.21(this));
            AppMethodBeat.o(51624);
            return;
          }
          a(this.uEU, this.uET, new GestureGuardLogicUI.22(this));
          AppMethodBeat.o(51624);
          return;
        }
        if ("next_action.switch_on_pattern".equals(localObject1))
        {
          a(this.mToken, this.uET, new GestureGuardLogicUI.23(this));
          AppMethodBeat.o(51624);
          return;
        }
        if ("next_action.goto_protected_page".equals(localObject1))
        {
          a(this.mToken, this.uET, new GestureGuardLogicUI.24(this));
          AppMethodBeat.o(51624);
          return;
          ((a)localObject1).uFn.setEnableInput(false);
          ((a)localObject1).uFn.setDisplayMode(PatternLockView.b.uFS);
          a(getResources().getString(2131300514), new GestureGuardLogicUI.25(this, (a)localObject1));
          AppMethodBeat.o(51624);
          return;
          setMMTitle(getString(2131300518));
          this.uEV = false;
          ((a)localObject1).uFn.setEnableInput(true);
          ((a)localObject1).uFn.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!bo.isNullOrNil(this.uFe)) {
              ((a)localObject1).uFl.setText(this.uFe);
            }
          }
          for (;;)
          {
            ((a)localObject1).uFl.setTextColor(this.uEO);
            if (((a)localObject1).uFo.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).uFo.setVisibility(0);
            AppMethodBeat.o(51624);
            return;
            ((a)localObject1).uFl.setText(getString(2131300517));
            continue;
            ((a)localObject1).uFl.setText(getString(2131300516));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).uFn.cYe();
            as(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.uEU, new GestureGuardLogicUI.26(this));
            AppMethodBeat.o(51624);
            return;
          }
          if ("next_action.goto_protected_page".equals(localObject2))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.d.ni(SystemClock.elapsedRealtime());
            cXW();
            com.tencent.mm.plugin.walletlock.c.h.al(this.uEF, 1, 0);
            AppMethodBeat.o(51624);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.af(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.IN(this.uEW);
            com.tencent.mm.plugin.walletlock.gesture.a.d.cXB();
            if (this.uEW == 5)
            {
              this.uEV = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.ae(l, 0L);
              ((a)localObject1).uFn.cYe();
              ((a)localObject1).uFn.setEnableInput(false);
              this.mStatus = 20;
              cXV();
              cXY();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              ab.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.uEW != 5) {
                break label1268;
              }
              com.tencent.mm.plugin.walletlock.c.h.al(this.uEF, 1, 2);
              AppMethodBeat.o(51624);
              return;
              ((a)localObject1).uFn.setEnableInput(false);
              ((a)localObject1).uFn.setDisplayMode(PatternLockView.b.uFS);
              a(String.format(getResources().getString(2131300507), new Object[] { Integer.valueOf(5 - this.uEW) }), new GestureGuardLogicUI.27(this, (a)localObject1));
            }
            label1268:
            com.tencent.mm.plugin.walletlock.c.h.al(this.uEF, 1, 1);
          }
        }
      }
    }
  }
  
  private void cXW()
  {
    AppMethodBeat.i(51629);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localIntent != null)
    {
      i.uGl.oe(true);
      i.uGl.of(true);
      localIntent.addFlags(131072);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(51629);
      return;
      ab.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void cXX()
  {
    AppMethodBeat.i(51630);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.uGl.cYr();
    }
    AppMethodBeat.o(51630);
  }
  
  private void cXY()
  {
    AppMethodBeat.i(51635);
    c.a locala = new c.a(this);
    locala.rG(false).avn(String.format(getString(2131300500), new Object[] { Long.valueOf(10L) }));
    locala.Ri(2131300496).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(51601);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].uFo);
        AppMethodBeat.o(51601);
      }
    });
    locala.Rj(2131300495).b(new GestureGuardLogicUI.17(this));
    locala.aLZ().show();
    AppMethodBeat.o(51635);
  }
  
  private void cXZ()
  {
    AppMethodBeat.i(51636);
    new c.a(this).rG(true).Rf(2131300503).Ri(2131300498).a(new GestureGuardLogicUI.18(this)).aLZ().show();
    AppMethodBeat.o(51636);
  }
  
  private void cYa()
  {
    AppMethodBeat.i(51637);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131300502);; str = getString(2131300501))
    {
      new c.a(this).rG(false).avn(str).Ri(2131300499).a(new GestureGuardLogicUI.20(this)).Rj(2131300497).b(new GestureGuardLogicUI.19(this)).aLZ().show();
      AppMethodBeat.o(51637);
      return;
    }
  }
  
  private void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51622);
    ab.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(paramInt1, localIntent);
    finish();
    AppMethodBeat.o(51622);
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(51632);
    paramPatternLockView.setDisplayMode(PatternLockView.b.uFR);
    AppMethodBeat.o(51632);
  }
  
  public final void a(PatternLockView paramPatternLockView, List<f> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51625);
    if (this.mStatus == 16)
    {
      if (paramList.size() < 4)
      {
        paramPatternLockView.setEnableInput(false);
        paramPatternLockView.setDisplayMode(PatternLockView.b.uFS);
        a(String.format(getString(2131300508), new Object[] { Integer.valueOf(4) }), new GestureGuardLogicUI.2(this, paramPatternLockView));
        AppMethodBeat.o(51625);
        return;
      }
      this.uET = paramList;
      paramPatternLockView.cYe();
      this.mStatus = 17;
      as(2, true);
    }
    for (;;)
    {
      cXV();
      do
      {
        AppMethodBeat.o(51625);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new GestureGuardLogicUI.3(this, paramList);
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.cXR();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.cXQ();
          com.tencent.mm.plugin.report.service.h.qsU.e(11453, new Object[0]);
          c(new GestureGuardLogicUI.6(this));
          boolean bool3 = e.b((bko)localObject1);
          boolean bool4 = e.b((bkn)localObject2);
          if (bool4) {
            if (bool3) {
              if (((bkn)localObject2).version < ((bko)localObject1).xzj) {
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ab.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            localObject1 = new b.a();
            ((b.a)localObject1).fsX = new bhn();
            ((b.a)localObject1).fsY = new bho();
            ((b.a)localObject1).funcId = 689;
            ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((b.a)localObject1).ado();
            localObject2 = (bhn)((com.tencent.mm.ai.b)localObject1).fsV.fta;
            ((bhn)localObject2).vA = 2;
            ((bhn)localObject2).xwF = new SKBuiltinBuffer_t().setBuffer(e.ec(paramList));
            w.a((com.tencent.mm.ai.b)localObject1, new GestureGuardLogicUI.7(this, paramPatternLockView), false);
            AppMethodBeat.o(51625);
            return;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            bool1 = true;
          }
          aCV();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.cXQ();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((bkn)localObject1).xzg.getBufferToBytes()).equals(com.tencent.mm.a.g.w(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(51625);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.RJ();
            ((StringBuilder)localObject2).append(new com.tencent.mm.a.p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.ec(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(51625);
          return;
        }
      } while (this.mStatus != 17);
      if (this.uET.equals(paramList))
      {
        paramPatternLockView.cYe();
        this.uEV = false;
        this.uEW = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.cXT();
        com.tencent.mm.plugin.walletlock.gesture.a.d.cXN();
        com.tencent.mm.plugin.walletlock.gesture.a.d.cXP();
        com.tencent.mm.plugin.walletlock.gesture.a.d.cXB();
        this.mStatus = 18;
      }
      else
      {
        this.mStatus = 19;
      }
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51618);
    hideVKB();
    setMMSubTitle(2131305936);
    this.uES = AnimationUtils.loadAnimation(this, 2131034249);
    this.uEO = getResources().getColor(2131690136);
    this.uEP = getResources().getColor(2131690137);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      as(1, false);
    }
    while (!"action.verify_pattern".equals(str))
    {
      setBackBtn(new GestureGuardLogicUI.1(this));
      ab.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      cXV();
      AppMethodBeat.o(51618);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.cXL()) {
      this.uEV = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      as(0, false);
      break;
      this.uEV = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51619);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramIntent == null)
      {
        ab.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
        AppMethodBeat.o(51619);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.mToken = paramIntent.getStringExtra("key_token");
        this.uEZ = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.uFd = true;
          }
          this.uFc = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          as(1, false);
        }
        for (;;)
        {
          cXV();
          AppMethodBeat.o(51619);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            GestureGuardLogicUI.12 local12 = new GestureGuardLogicUI.12(this);
            c(new GestureGuardLogicUI.13(this));
            if (paramIntent == null)
            {
              aCV();
              local12.a(3, -6, getString(2131300506), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).fsX = new bte();
              ((b.a)localObject).fsY = new btf();
              ((b.a)localObject).funcId = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).ado();
              bte localbte = (bte)((com.tencent.mm.ai.b)localObject).fsV.fta;
              localbte.xGL = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localbte.vA = 3;
              w.a((com.tencent.mm.ai.b)localObject, new GestureGuardLogicUI.14(this, local12), false);
            }
          }
          else
          {
            this.mStatus = 1;
          }
        }
      }
      if (paramInt1 == -1) {
        Toast.makeText(this, getString(2131300504), 0).show();
      }
    }
    AppMethodBeat.o(51619);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51620);
    if (paramView.getId() == 2131825144)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.bq.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
    }
    AppMethodBeat.o(51620);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(51615);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if ((!ah.getPackageName().equals(paramBundle.getPackage())) || (bo.isNullOrNil(paramBundle.getStringExtra("action"))) || (bo.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      ab.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(51615);
      return;
    }
    this.uFa = new ViewFlipper(this);
    this.uER = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.uER;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.uFa.addView(localObject.mView);
      localObject.uFn.setOnPatternListener(this);
      localObject.uFo.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.uFa);
    this.mToken = getIntent().getStringExtra("token");
    this.uEZ = getIntent().getStringExtra("type");
    this.uFe = getIntent().getStringExtra("verify_title");
    this.uEF = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.cYn();
    }
    initView();
    AppMethodBeat.o(51615);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51617);
    super.onDestroy();
    if (this.uEX != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.uEX);
      this.uEX = null;
    }
    if (this.uEY != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.uEY);
      this.uEY = null;
    }
    if ((this.uFb != null) && (this.uFb.isShowing())) {
      this.uFb.dismiss();
    }
    if (this.uFa != null)
    {
      this.uFa.removeAllViews();
      this.uFa = null;
    }
    int i = 0;
    while (i < this.uER.length)
    {
      a locala = this.uER[i];
      locala.uFn.setOnClickListener(null);
      locala.uFo.setOnClickListener(null);
      locala.mView = null;
      locala.uFl = null;
      locala.uFm = null;
      locala.uFn = null;
      locala.uFo = null;
      this.uER[i] = null;
      i += 1;
    }
    this.uER = null;
    AppMethodBeat.o(51617);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(51621);
    if (paramInt == 4)
    {
      if (cXU())
      {
        AppMethodBeat.o(51621);
        return false;
      }
      z(0, 4, "user cancel when setting gesture");
      AppMethodBeat.o(51621);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(51621);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51616);
    super.onResume();
    if (this.mStatus == 0)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.cXO();
      if (localg.uEM == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.uEN / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.af(localg.uEM, localg.uEN);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uEW = com.tencent.mm.plugin.walletlock.gesture.a.d.cXS();
        if (this.uEW != -1) {}
      }
      else
      {
        this.uEW = 0;
      }
      AppMethodBeat.o(51616);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.cXP();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(51631);
    Object localObject = this.uER[this.uEQ];
    if (((a)localObject).uFn != null)
    {
      localObject = ((a)localObject).uFn;
      if ((!paramBoolean) || (this.uEV)) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      ((PatternLockView)localObject).setEnableInput(bool);
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(51631);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */