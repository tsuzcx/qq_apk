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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a
{
  private int DuA;
  private int DuJ;
  private int DuK;
  private int DuL;
  private a[] DuM;
  private Animation DuN;
  private List<f> DuO;
  private List<f> DuP;
  private boolean DuQ;
  private int DuR;
  private n DuS;
  private n DuT;
  private String DuU;
  private ViewFlipper DuV;
  private Dialog DuW;
  private boolean DuX;
  private boolean DuY;
  private String DuZ;
  private ap mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.DuJ = 0;
    this.DuK = 0;
    this.DuL = 0;
    this.DuM = null;
    this.DuN = null;
    this.DuO = null;
    this.DuP = null;
    this.DuQ = false;
    this.DuR = 0;
    this.DuS = null;
    this.DuT = null;
    this.mToken = null;
    this.DuU = null;
    this.DuV = null;
    this.mHandler = new ap(Looper.getMainLooper());
    this.DuW = null;
    this.DuX = true;
    this.DuY = false;
    this.DuA = -1;
    AppMethodBeat.o(129819);
  }
  
  private void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129827);
    ad.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(paramInt1, localIntent);
    finish();
    AppMethodBeat.o(129827);
  }
  
  private void a(String paramString, final a parama)
  {
    AppMethodBeat.i(129839);
    TextView localTextView = this.DuM[this.DuL].Dvg;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.DuK);
    localTextView.startAnimation(this.DuN);
    this.DuN.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(129805);
        GestureGuardLogicUI.s(GestureGuardLogicUI.this).setAnimationListener(null);
        if (parama != null) {
          parama.onDone();
        }
        AppMethodBeat.o(129805);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(129839);
  }
  
  private void a(String paramString, List<f> paramList, final x.a parama)
  {
    AppMethodBeat.i(129831);
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129794);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvi.eJY();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aiU().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      aOs();
      parama.a(3, -6, getString(2131760045), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new csw();
    ((b.a)localObject).hNN = new csx();
    ((b.a)localObject).funcId = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).aDC();
    csw localcsw = (csw)((com.tencent.mm.al.b)localObject).hNK.hNQ;
    localcsw.Hlg = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localcsw.Hlh = new SKBuiltinBuffer_t().setBuffer(e.gP(paramList));
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129795);
        ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((csx)paramAnonymousb.hNL.hNQ).GYm);
          GestureGuardLogicUI.eJV();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).VM(1);
        }
        i.Dwe.eKk();
        if (parama != null)
        {
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129795);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129795);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129831);
  }
  
  private void a(List<f> paramList, final x.a parama)
  {
    AppMethodBeat.i(129833);
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129800);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvi.eJY();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aiU().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cef();
    ((b.a)localObject).hNN = new ceg();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aDC();
    cef localcef = (cef)((com.tencent.mm.al.b)localObject).hNK.hNQ;
    localcef.EN = 3;
    localcef.GYk = new SKBuiltinBuffer_t().setBuffer(e.gP(paramList));
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129801);
        ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((ceg)paramAnonymousb.hNL.hNQ).GYm);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.Dwa;
          com.tencent.mm.plugin.walletlock.c.g.uG(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.eJV();
        }
        if (parama != null)
        {
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129801);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129801);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129833);
  }
  
  private void a(List<f> paramList1, List<f> paramList2, final x.a parama)
  {
    AppMethodBeat.i(129832);
    Object localObject = new b.a();
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129798);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvi.eJY();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aiU().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((b.a)localObject).hNM = new cef();
    ((b.a)localObject).hNN = new ceg();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aDC();
    cef localcef = (cef)((com.tencent.mm.al.b)localObject).hNK.hNQ;
    localcef.EN = 1;
    localcef.GYk = new SKBuiltinBuffer_t().setBuffer(e.gP(paramList1));
    localcef.GYl = new SKBuiltinBuffer_t().setBuffer(e.gP(paramList2));
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129799);
        ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((ceg)paramAnonymousb.hNL.hNQ).GYm);
          GestureGuardLogicUI.eJV();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new hg();
          ((hg)localObject).ecM = 8L;
          ((hg)localObject).erV = 2L;
          ((hg)localObject).aLk();
        }
        for (;;)
        {
          i.Dwe.eKk();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new hg();
            ((hg)localObject).ecM = 10L;
            ((hg)localObject).erV = 2L;
            ((hg)localObject).aLk();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new hg();
              ((hg)localObject).ecM = 5L;
              ((hg)localObject).erV = 2L;
              ((hg)localObject).aLk();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new hg();
              ((hg)localObject).ecM = 4L;
              ((hg)localObject).erV = 2L;
              ((hg)localObject).aLk();
            }
            else
            {
              localObject = new hg();
              ((hg)localObject).ecM = 5L;
              ((hg)localObject).erV = 2L;
              ((hg)localObject).aLk();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void aOs()
  {
    AppMethodBeat.i(129844);
    if ((this.DuW != null) && (this.DuW.isShowing())) {
      this.DuW.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void aR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.DuL;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.DuL = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.DuV.setInAnimation(this, 2130772144);
        this.DuV.setOutAnimation(this, 2130772141);
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
        this.DuV.showNext();
        paramInt += 1;
      }
      this.DuV.setInAnimation(this, 2130772140);
      this.DuV.setOutAnimation(this, 2130772145);
      continue;
      this.DuV.setInAnimation(null);
      this.DuV.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.DuV.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.DuW == null)
    {
      this.DuW = com.tencent.mm.ui.base.h.b(this, getString(2131760048), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.DuW.show();
    AppMethodBeat.o(129843);
  }
  
  private boolean eJO()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.DuX) {
        eJU();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        eJT();
      }
    }
    eJR();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void eJP()
  {
    AppMethodBeat.i(129829);
    if (this.DuM == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.DuM[this.DuL];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(2131760057));
      setMMTitle(getString(2131760058));
      if (this.DuA == 1)
      {
        localObject2 = new hg();
        ((hg)localObject2).ecM = 8L;
        ((hg)localObject2).erV = 1L;
        ((hg)localObject2).aLk();
      }
      long l;
      for (;;)
      {
        this.DuQ = true;
        ((a)localObject1).Dvi.setEnableInput(false);
        ((a)localObject1).Dvi.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.eJG().DuI / 1000L) / 60.0D);
        ((a)localObject1).Dvg.setText(String.format(getString(2131760050), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).Dvg.setTextColor(getResources().getColor(2131100800));
        AppMethodBeat.o(129829);
        return;
        if (this.DuA == 2)
        {
          localObject2 = new hg();
          ((hg)localObject2).ecM = 10L;
          ((hg)localObject2).erV = 1L;
          ((hg)localObject2).aLk();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131760058));
        localObject2 = new hg();
        ((hg)localObject2).ecM = 5L;
        ((hg)localObject2).erV = 1L;
        ((hg)localObject2).aLk();
      }
      for (;;)
      {
        this.DuQ = false;
        ((a)localObject1).Dvi.setEnableInput(true);
        ((a)localObject1).Dvi.setOnPatternListener(this);
        ((a)localObject1).Dvg.setText(getString(2131760054));
        ((a)localObject1).Dvg.setTextColor(getResources().getColor(2131100711));
        if (((a)localObject1).Dvj.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).Dvj.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131760059));
          localObject2 = new hg();
          ((hg)localObject2).ecM = 4L;
          ((hg)localObject2).erV = 1L;
          ((hg)localObject2).aLk();
        }
        else
        {
          setMMTitle(getString(2131760058));
          localObject2 = new hg();
          ((hg)localObject2).ecM = 5L;
          ((hg)localObject2).erV = 1L;
          ((hg)localObject2).aLk();
        }
      }
      ((a)localObject1).Dvg.setText(getResources().getString(2131760052));
      ((a)localObject1).Dvg.setTextColor(this.DuJ);
      ((a)localObject1).Dvi.eJY();
      ((a)localObject1).Dvi.setEnableInput(true);
      if (((a)localObject1).Dvj.getVisibility() != 8)
      {
        ((a)localObject1).Dvj.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.DuY)
          {
            this.DuY = false;
            a(this.mToken, this.DuO, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
                  com.tencent.mm.plugin.report.service.g.yhR.f(11474, new Object[0]);
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129811);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          a(this.DuP, this.DuO, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129812);
              if (paramAnonymousInt2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
              }
              for (;;)
              {
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(129812);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.switch_on_pattern".equals(localObject1))
        {
          a(this.mToken, this.DuO, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129813);
              GestureGuardLogicUI.b(GestureGuardLogicUI.this);
              GestureGuardLogicUI.d(GestureGuardLogicUI.this);
              if (paramAnonymousInt2 == 0)
              {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760062), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
              }
              for (;;)
              {
                AppMethodBeat.o(129813);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.goto_protected_page".equals(localObject1))
        {
          a(this.mToken, this.DuO, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.Ci(SystemClock.elapsedRealtime());
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
                GestureGuardLogicUI.e(GestureGuardLogicUI.this);
              }
              for (;;)
              {
                GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                AppMethodBeat.o(129814);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
          ((a)localObject1).Dvi.setEnableInput(false);
          ((a)localObject1).Dvi.setDisplayMode(PatternLockView.b.DvL);
          a(getResources().getString(2131760053), new a()
          {
            public final void onDone()
            {
              AppMethodBeat.i(129816);
              GestureGuardLogicUI.f(GestureGuardLogicUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(129815);
                  GestureGuardLogicUI.f(GestureGuardLogicUI.this).removeCallbacks(this);
                  GestureGuardLogicUI.25.this.Dve.Dvi.eJY();
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 16);
                  GestureGuardLogicUI.g(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                  AppMethodBeat.o(129815);
                }
              }, 500L);
              AppMethodBeat.o(129816);
            }
          });
          AppMethodBeat.o(129829);
          return;
          setMMTitle("");
          this.DuQ = false;
          ((a)localObject1).Dvi.setEnableInput(true);
          ((a)localObject1).Dvi.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!bt.isNullOrNil(this.DuZ)) {
              ((a)localObject1).Dvg.setText(this.DuZ);
            }
          }
          for (;;)
          {
            ((a)localObject1).Dvg.setTextColor(this.DuJ);
            if (((a)localObject1).Dvj.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).Dvj.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).Dvg.setText(getString(2131760056));
            continue;
            ((a)localObject1).Dvg.setText(getString(2131760055));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).Dvi.eJY();
            aR(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.DuP, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129817);
                if (paramAnonymousInt2 == 0) {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760061), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129817);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          if ("next_action.goto_protected_page".equals(localObject2))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.d.Ci(SystemClock.elapsedRealtime());
            eJQ();
            com.tencent.mm.plugin.walletlock.c.h.aA(this.DuA, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.aw(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.VO(this.DuR);
            com.tencent.mm.plugin.walletlock.gesture.a.d.eJv();
            if (this.DuR == 5)
            {
              this.DuQ = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.av(l, 0L);
              ((a)localObject1).Dvi.eJY();
              ((a)localObject1).Dvi.setEnableInput(false);
              this.mStatus = 20;
              eJP();
              eJS();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              ad.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.DuR != 5) {
                break label1275;
              }
              com.tencent.mm.plugin.walletlock.c.h.aA(this.DuA, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).Dvi.setEnableInput(false);
              ((a)localObject1).Dvi.setDisplayMode(PatternLockView.b.DvL);
              a(String.format(getResources().getString(2131760046), new Object[] { Integer.valueOf(5 - this.DuR) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.Dve.Dvi.eJY();
                  this.Dve.Dvi.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1275:
            com.tencent.mm.plugin.walletlock.c.h.aA(this.DuA, 1, 1);
          }
        }
      }
    }
  }
  
  private void eJQ()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.Dwe.uK(true);
      i.Dwe.uL(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(129834);
      return;
      ad.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void eJR()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.Dwe.eKl();
    }
    AppMethodBeat.o(129835);
  }
  
  private void eJS()
  {
    AppMethodBeat.i(129840);
    d.a locala = new d.a(this);
    locala.yR(false).aXG(String.format(getString(2131760039), new Object[] { Long.valueOf(10L) }));
    locala.afl(2131760035).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvj);
        AppMethodBeat.o(129806);
      }
    });
    locala.afm(2131760034).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129807);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.t(GestureGuardLogicUI.this);
        GestureGuardLogicUI.this.finish();
        AppMethodBeat.o(129807);
      }
    });
    locala.fMb().show();
    AppMethodBeat.o(129840);
  }
  
  private void eJT()
  {
    AppMethodBeat.i(129841);
    new d.a(this).yR(true).afi(2131760042).afl(2131760037).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).fMb().show();
    AppMethodBeat.o(129841);
  }
  
  private void eJU()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131760041);; str = getString(2131760040))
    {
      new d.a(this).yR(false).aXG(str).afl(2131760038).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).afm(2131760036).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).fMb().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.DvK);
    AppMethodBeat.o(129837);
  }
  
  public final void a(final PatternLockView paramPatternLockView, final List<f> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(129830);
    if (this.mStatus == 16)
    {
      if (paramList.size() < 4)
      {
        paramPatternLockView.setEnableInput(false);
        paramPatternLockView.setDisplayMode(PatternLockView.b.DvL);
        a(String.format(getString(2131760047), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.eJY();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.DuO = paramList;
      paramPatternLockView.eJY();
      this.mStatus = 17;
      aR(2, true);
    }
    for (;;)
    {
      eJP();
      do
      {
        AppMethodBeat.o(129830);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129793);
              if (paramAnonymousInt2 == 0)
              {
                GestureGuardLogicUI.i(GestureGuardLogicUI.this);
                GestureGuardLogicUI.j(GestureGuardLogicUI.this);
                com.tencent.mm.plugin.walletlock.gesture.a.d.eJN();
                com.tencent.mm.plugin.walletlock.gesture.a.d.eJH();
                com.tencent.mm.plugin.walletlock.gesture.a.d.eJJ();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, paramList);
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, 1);
                GestureGuardLogicUI.h(GestureGuardLogicUI.this);
              }
              for (;;)
              {
                AppMethodBeat.o(129793);
                return 0;
                if (paramAnonymousInt2 == -3)
                {
                  GestureGuardLogicUI.k(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 2);
                  GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                }
                else
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760044), 0).show();
                }
              }
            }
          };
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.eJL();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.eJK();
          com.tencent.mm.plugin.report.service.g.yhR.f(11453, new Object[0]);
          c(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvi.eJY();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.g.aiU().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((cij)localObject1);
          boolean bool4 = e.b((cii)localObject2);
          if (bool4) {
            if (bool3) {
              if (((cii)localObject2).version < ((cij)localObject1).Hck) {
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            localObject1 = new b.a();
            ((b.a)localObject1).hNM = new cef();
            ((b.a)localObject1).hNN = new ceg();
            ((b.a)localObject1).funcId = 689;
            ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((b.a)localObject1).aDC();
            localObject2 = (cef)((com.tencent.mm.al.b)localObject1).hNK.hNQ;
            ((cef)localObject2).EN = 2;
            ((cef)localObject2).GYk = new SKBuiltinBuffer_t().setBuffer(e.gP(paramList));
            x.a((com.tencent.mm.al.b)localObject1, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129797);
                ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((ceg)paramAnonymousb.hNL.hNQ).GYm);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new hg();
                  ((hg)localObject).ecM = 8L;
                  ((hg)localObject).erV = 2L;
                  ((hg)localObject).aLk();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new hg();
                    ((hg)localObject).ecM = 10L;
                    ((hg)localObject).erV = 2L;
                    ((hg)localObject).aLk();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new hg();
                      ((hg)localObject).ecM = 5L;
                      ((hg)localObject).erV = 2L;
                      ((hg)localObject).aLk();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new hg();
                      ((hg)localObject).ecM = 4L;
                      ((hg)localObject).erV = 2L;
                      ((hg)localObject).aLk();
                    }
                    else
                    {
                      localObject = new hg();
                      ((hg)localObject).ecM = 5L;
                      ((hg)localObject).erV = 2L;
                      ((hg)localObject).aLk();
                    }
                  }
                }
                AppMethodBeat.o(129797);
                return 0;
              }
            }, false);
            AppMethodBeat.o(129830);
            return;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            bool1 = true;
          }
          aOs();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.eJK();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((cii)localObject1).Hch.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.ajA();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.gP(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.DuO.equals(paramList))
      {
        paramPatternLockView.eJY();
        this.DuQ = false;
        this.DuR = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.eJN();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eJH();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eJJ();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eJv();
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
    AppMethodBeat.i(129823);
    hideVKB();
    setActionbarColor(getResources().getColor(2131101179));
    setMMSubTitle(2131766182);
    this.DuN = AnimationUtils.loadAnimation(this, 2130772127);
    this.DuJ = getResources().getColor(2131100711);
    this.DuK = getResources().getColor(2131100800);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      aR(1, false);
    }
    while (!"action.verify_pattern".equals(str))
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(129791);
          if (GestureGuardLogicUI.a(GestureGuardLogicUI.this))
          {
            AppMethodBeat.o(129791);
            return true;
          }
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129791);
          return true;
        }
      });
      ad.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      eJP();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.eJF()) {
      this.DuQ = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      aR(0, false);
      break;
      this.DuQ = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramIntent == null)
      {
        ad.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
        AppMethodBeat.o(129824);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.mToken = paramIntent.getStringExtra("key_token");
        this.DuU = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.DuY = true;
          }
          this.DuX = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          aR(1, false);
        }
        for (;;)
        {
          eJP();
          AppMethodBeat.o(129824);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            final x.a local12 = new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129802);
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eJN();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eJH();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eJJ();
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760061), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.c(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129802);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760043), 0).show();
                }
              }
            };
            c(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(129803);
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Dvi.eJY();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.g.aiU().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              aOs();
              local12.a(3, -6, getString(2131760045), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).hNM = new csw();
              ((b.a)localObject).hNN = new csx();
              ((b.a)localObject).funcId = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).aDC();
              csw localcsw = (csw)((com.tencent.mm.al.b)localObject).hNK.hNQ;
              localcsw.Hlg = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localcsw.EN = 3;
              x.a((com.tencent.mm.al.b)localObject, new x.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
                {
                  AppMethodBeat.i(129804);
                  ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((csx)paramAnonymousb.hNL.hNQ).GYm);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.Dwa;
                    com.tencent.mm.plugin.walletlock.c.g.uG(false);
                    GestureGuardLogicUI.eJV();
                  }
                  i.Dwe.eKk();
                  if (local12 != null)
                  {
                    paramAnonymousInt1 = local12.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
                    AppMethodBeat.o(129804);
                    return paramAnonymousInt1;
                  }
                  AppMethodBeat.o(129804);
                  return 0;
                }
              }, false);
            }
          }
          else
          {
            this.mStatus = 1;
          }
        }
      }
      if (paramInt1 == -1) {
        Toast.makeText(this, getString(2131760043), 0).show();
      }
    }
    AppMethodBeat.o(129824);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(129825);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() == 2131306126)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(129825);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(129820);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772144, 2130772141);
    paramBundle = getIntent();
    if ((!aj.getPackageName().equals(paramBundle.getPackage())) || (bt.isNullOrNil(paramBundle.getStringExtra("action"))) || (bt.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      ad.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(129820);
      return;
    }
    this.DuV = new ViewFlipper(this);
    this.DuM = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.DuM;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.DuV.addView(localObject.mView);
      localObject.Dvi.setOnPatternListener(this);
      localObject.Dvj.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.DuV);
    this.mToken = getIntent().getStringExtra("token");
    this.DuU = getIntent().getStringExtra("type");
    this.DuZ = getIntent().getStringExtra("verify_title");
    this.DuA = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.eKh();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.DuS != null)
    {
      com.tencent.mm.kernel.g.aiU().a(this.DuS);
      this.DuS = null;
    }
    if (this.DuT != null)
    {
      com.tencent.mm.kernel.g.aiU().a(this.DuT);
      this.DuT = null;
    }
    if ((this.DuW != null) && (this.DuW.isShowing())) {
      this.DuW.dismiss();
    }
    if (this.DuV != null)
    {
      this.DuV.removeAllViews();
      this.DuV = null;
    }
    int i = 0;
    while (i < this.DuM.length)
    {
      a locala = this.DuM[i];
      locala.Dvi.setOnClickListener(null);
      locala.Dvj.setOnClickListener(null);
      locala.mView = null;
      locala.Dvg = null;
      locala.Dvh = null;
      locala.Dvi = null;
      locala.Dvj = null;
      this.DuM[i] = null;
      i += 1;
    }
    this.DuM = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (eJO())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      K(0, 4, "user cancel when setting gesture");
      AppMethodBeat.o(129826);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(129826);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129821);
    super.onResume();
    if (this.mStatus == 0)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.eJI();
      if (localg.DuH == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.DuI / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.aw(localg.DuH, localg.DuI);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.DuR = com.tencent.mm.plugin.walletlock.gesture.a.d.eJM();
        if (this.DuR != -1) {}
      }
      else
      {
        this.DuR = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.eJJ();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    Object localObject = this.DuM[this.DuL];
    if (((a)localObject).Dvi != null)
    {
      localObject = ((a)localObject).Dvi;
      if ((!paramBoolean) || (this.DuQ)) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      ((PatternLockView)localObject).setEnableInput(bool);
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(129836);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */