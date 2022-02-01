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
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.protocal.protobuf.cio;
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
  private int ABL;
  private int ABU;
  private int ABV;
  private int ABW;
  private a[] ABX;
  private Animation ABY;
  private List<f> ABZ;
  private List<f> ACa;
  private boolean ACb;
  private int ACc;
  private n ACd;
  private n ACe;
  private String ACf;
  private ViewFlipper ACg;
  private Dialog ACh;
  private boolean ACi;
  private boolean ACj;
  private String ACk;
  private ap mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.ABU = 0;
    this.ABV = 0;
    this.ABW = 0;
    this.ABX = null;
    this.ABY = null;
    this.ABZ = null;
    this.ACa = null;
    this.ACb = false;
    this.ACc = 0;
    this.ACd = null;
    this.ACe = null;
    this.mToken = null;
    this.ACf = null;
    this.ACg = null;
    this.mHandler = new ap(Looper.getMainLooper());
    this.ACh = null;
    this.ACi = true;
    this.ACj = false;
    this.ABL = -1;
    AppMethodBeat.o(129819);
  }
  
  private void J(int paramInt1, int paramInt2, String paramString)
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
    TextView localTextView = this.ABX[this.ABW].ACr;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.ABV);
    localTextView.startAnimation(this.ABY);
    this.ABY.setAnimationListener(new Animation.AnimationListener()
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACt.egy();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aeS().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      aEr();
      parama.a(3, -6, getString(2131760045), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cin();
    ((b.a)localObject).gUV = new cio();
    ((b.a)localObject).funcId = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).atI();
    cin localcin = (cin)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localcin.EdU = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localcin.EdV = new SKBuiltinBuffer_t().setBuffer(e.gs(paramList));
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129795);
        ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cio)paramAnonymousb.gUT.gUX).DSe);
          GestureGuardLogicUI.egv();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).RK(1);
        }
        i.ADp.egK();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACt.egy();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aeS().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new buw();
    ((b.a)localObject).gUV = new bux();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).atI();
    buw localbuw = (buw)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localbuw.BX = 3;
    localbuw.DSc = new SKBuiltinBuffer_t().setBuffer(e.gs(paramList));
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129801);
        ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bux)paramAnonymousb.gUT.gUX).DSe);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
          com.tencent.mm.plugin.walletlock.c.g.sV(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.egv();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACt.egy();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.aeS().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((b.a)localObject).gUU = new buw();
    ((b.a)localObject).gUV = new bux();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).atI();
    buw localbuw = (buw)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localbuw.BX = 1;
    localbuw.DSc = new SKBuiltinBuffer_t().setBuffer(e.gs(paramList1));
    localbuw.DSd = new SKBuiltinBuffer_t().setBuffer(e.gs(paramList2));
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
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bux)paramAnonymousb.gUT.gUX).DSe);
          GestureGuardLogicUI.egv();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new en();
          ((en)localObject).dMW = 8L;
          ((en)localObject).dZx = 2L;
          ((en)localObject).aBj();
        }
        for (;;)
        {
          i.ADp.egK();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new en();
            ((en)localObject).dMW = 10L;
            ((en)localObject).dZx = 2L;
            ((en)localObject).aBj();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new en();
              ((en)localObject).dMW = 5L;
              ((en)localObject).dZx = 2L;
              ((en)localObject).aBj();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new en();
              ((en)localObject).dMW = 4L;
              ((en)localObject).dZx = 2L;
              ((en)localObject).aBj();
            }
            else
            {
              localObject = new en();
              ((en)localObject).dMW = 5L;
              ((en)localObject).dZx = 2L;
              ((en)localObject).aBj();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void aEr()
  {
    AppMethodBeat.i(129844);
    if ((this.ACh != null) && (this.ACh.isShowing())) {
      this.ACh.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void aG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.ABW;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.ABW = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.ACg.setInAnimation(this, 2130772144);
        this.ACg.setOutAnimation(this, 2130772141);
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
        this.ACg.showNext();
        paramInt += 1;
      }
      this.ACg.setInAnimation(this, 2130772140);
      this.ACg.setOutAnimation(this, 2130772145);
      continue;
      this.ACg.setInAnimation(null);
      this.ACg.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.ACg.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.ACh == null)
    {
      this.ACh = com.tencent.mm.ui.base.h.b(this, getString(2131760048), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.ACh.show();
    AppMethodBeat.o(129843);
  }
  
  private boolean ego()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.ACi) {
        egu();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        egt();
      }
    }
    egr();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void egp()
  {
    AppMethodBeat.i(129829);
    if (this.ABX == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.ABX[this.ABW];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(2131760057));
      setMMTitle(getString(2131760058));
      if (this.ABL == 1)
      {
        localObject2 = new en();
        ((en)localObject2).dMW = 8L;
        ((en)localObject2).dZx = 1L;
        ((en)localObject2).aBj();
      }
      long l;
      for (;;)
      {
        this.ACb = true;
        ((a)localObject1).ACt.setEnableInput(false);
        ((a)localObject1).ACt.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.egg().ABT / 1000L) / 60.0D);
        ((a)localObject1).ACr.setText(String.format(getString(2131760050), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).ACr.setTextColor(getResources().getColor(2131100800));
        AppMethodBeat.o(129829);
        return;
        if (this.ABL == 2)
        {
          localObject2 = new en();
          ((en)localObject2).dMW = 10L;
          ((en)localObject2).dZx = 1L;
          ((en)localObject2).aBj();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131760058));
        localObject2 = new en();
        ((en)localObject2).dMW = 5L;
        ((en)localObject2).dZx = 1L;
        ((en)localObject2).aBj();
      }
      for (;;)
      {
        this.ACb = false;
        ((a)localObject1).ACt.setEnableInput(true);
        ((a)localObject1).ACt.setOnPatternListener(this);
        ((a)localObject1).ACr.setText(getString(2131760054));
        ((a)localObject1).ACr.setTextColor(getResources().getColor(2131100711));
        if (((a)localObject1).ACu.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).ACu.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131760059));
          localObject2 = new en();
          ((en)localObject2).dMW = 4L;
          ((en)localObject2).dZx = 1L;
          ((en)localObject2).aBj();
        }
        else
        {
          setMMTitle(getString(2131760058));
          localObject2 = new en();
          ((en)localObject2).dMW = 5L;
          ((en)localObject2).dZx = 1L;
          ((en)localObject2).aBj();
        }
      }
      ((a)localObject1).ACr.setText(getResources().getString(2131760052));
      ((a)localObject1).ACr.setTextColor(this.ABU);
      ((a)localObject1).ACt.egy();
      ((a)localObject1).ACt.setEnableInput(true);
      if (((a)localObject1).ACu.getVisibility() != 8)
      {
        ((a)localObject1).ACu.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.ACj)
          {
            this.ACj = false;
            a(this.mToken, this.ABZ, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
                  com.tencent.mm.plugin.report.service.h.vKh.f(11474, new Object[0]);
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
          a(this.ACa, this.ABZ, new x.a()
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
          a(this.mToken, this.ABZ, new x.a()
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
          a(this.mToken, this.ABZ, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.uT(SystemClock.elapsedRealtime());
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
          ((a)localObject1).ACt.setEnableInput(false);
          ((a)localObject1).ACt.setDisplayMode(PatternLockView.b.ACW);
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
                  GestureGuardLogicUI.25.this.ACp.ACt.egy();
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
          setMMTitle(getString(2131760057));
          this.ACb = false;
          ((a)localObject1).ACt.setEnableInput(true);
          ((a)localObject1).ACt.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!bt.isNullOrNil(this.ACk)) {
              ((a)localObject1).ACr.setText(this.ACk);
            }
          }
          for (;;)
          {
            ((a)localObject1).ACr.setTextColor(this.ABU);
            if (((a)localObject1).ACu.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).ACu.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).ACr.setText(getString(2131760056));
            continue;
            ((a)localObject1).ACr.setText(getString(2131760055));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).ACt.egy();
            aG(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.ACa, new x.a()
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
            com.tencent.mm.plugin.walletlock.gesture.a.d.uT(SystemClock.elapsedRealtime());
            egq();
            com.tencent.mm.plugin.walletlock.c.h.ax(this.ABL, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.as(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.RM(this.ACc);
            com.tencent.mm.plugin.walletlock.gesture.a.d.efV();
            if (this.ACc == 5)
            {
              this.ACb = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.ar(l, 0L);
              ((a)localObject1).ACt.egy();
              ((a)localObject1).ACt.setEnableInput(false);
              this.mStatus = 20;
              egp();
              egs();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              ad.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.ACc != 5) {
                break label1279;
              }
              com.tencent.mm.plugin.walletlock.c.h.ax(this.ABL, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).ACt.setEnableInput(false);
              ((a)localObject1).ACt.setDisplayMode(PatternLockView.b.ACW);
              a(String.format(getResources().getString(2131760046), new Object[] { Integer.valueOf(5 - this.ACc) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.ACp.ACt.egy();
                  this.ACp.ACt.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1279:
            com.tencent.mm.plugin.walletlock.c.h.ax(this.ABL, 1, 1);
          }
        }
      }
    }
  }
  
  private void egq()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.ADp.sZ(true);
      i.ADp.ta(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
  
  private void egr()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.ADp.egL();
    }
    AppMethodBeat.o(129835);
  }
  
  private void egs()
  {
    AppMethodBeat.i(129840);
    d.a locala = new d.a(this);
    locala.wX(false).aMg(String.format(getString(2131760039), new Object[] { Long.valueOf(10L) }));
    locala.aaB(2131760035).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACu);
        AppMethodBeat.o(129806);
      }
    });
    locala.aaC(2131760034).c(new DialogInterface.OnClickListener()
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
    locala.fft().show();
    AppMethodBeat.o(129840);
  }
  
  private void egt()
  {
    AppMethodBeat.i(129841);
    new d.a(this).wX(true).aay(2131760042).aaB(2131760037).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).fft().show();
    AppMethodBeat.o(129841);
  }
  
  private void egu()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131760041);; str = getString(2131760040))
    {
      new d.a(this).wX(false).aMg(str).aaB(2131760038).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).aaC(2131760036).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).fft().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.ACV);
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
        paramPatternLockView.setDisplayMode(PatternLockView.b.ACW);
        a(String.format(getString(2131760047), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.egy();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.ABZ = paramList;
      paramPatternLockView.egy();
      this.mStatus = 17;
      aG(2, true);
    }
    for (;;)
    {
      egp();
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
                com.tencent.mm.plugin.walletlock.gesture.a.d.egn();
                com.tencent.mm.plugin.walletlock.gesture.a.d.egh();
                com.tencent.mm.plugin.walletlock.gesture.a.d.egj();
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
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.egl();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.egk();
          com.tencent.mm.plugin.report.service.h.vKh.f(11453, new Object[0]);
          c(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACt.egy();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.g.aeS().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((byo)localObject1);
          boolean bool4 = e.b((byn)localObject2);
          if (bool4) {
            if (bool3) {
              if (((byn)localObject2).version < ((byo)localObject1).DVq) {
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
            ((b.a)localObject1).gUU = new buw();
            ((b.a)localObject1).gUV = new bux();
            ((b.a)localObject1).funcId = 689;
            ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((b.a)localObject1).atI();
            localObject2 = (buw)((com.tencent.mm.al.b)localObject1).gUS.gUX;
            ((buw)localObject2).BX = 2;
            ((buw)localObject2).DSc = new SKBuiltinBuffer_t().setBuffer(e.gs(paramList));
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
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bux)paramAnonymousb.gUT.gUX).DSe);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new en();
                  ((en)localObject).dMW = 8L;
                  ((en)localObject).dZx = 2L;
                  ((en)localObject).aBj();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new en();
                    ((en)localObject).dMW = 10L;
                    ((en)localObject).dZx = 2L;
                    ((en)localObject).aBj();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new en();
                      ((en)localObject).dMW = 5L;
                      ((en)localObject).dZx = 2L;
                      ((en)localObject).aBj();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new en();
                      ((en)localObject).dMW = 4L;
                      ((en)localObject).dZx = 2L;
                      ((en)localObject).aBj();
                    }
                    else
                    {
                      localObject = new en();
                      ((en)localObject).dMW = 5L;
                      ((en)localObject).dZx = 2L;
                      ((en)localObject).aBj();
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
          aEr();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.egk();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((byn)localObject1).DVn.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.gs(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.ABZ.equals(paramList))
      {
        paramPatternLockView.egy();
        this.ACb = false;
        this.ACc = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.egn();
        com.tencent.mm.plugin.walletlock.gesture.a.d.egh();
        com.tencent.mm.plugin.walletlock.gesture.a.d.egj();
        com.tencent.mm.plugin.walletlock.gesture.a.d.efV();
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
    this.ABY = AnimationUtils.loadAnimation(this, 2130772127);
    this.ABU = getResources().getColor(2131100711);
    this.ABV = getResources().getColor(2131100800);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      aG(1, false);
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
      egp();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.egf()) {
      this.ACb = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      aG(0, false);
      break;
      this.ACb = false;
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
        this.ACf = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.ACj = true;
          }
          this.ACi = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          aG(1, false);
        }
        for (;;)
        {
          egp();
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
                  com.tencent.mm.plugin.walletlock.gesture.a.d.egn();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.egh();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.egj();
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
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].ACt.egy();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.g.aeS().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              aEr();
              local12.a(3, -6, getString(2131760045), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).gUU = new cin();
              ((b.a)localObject).gUV = new cio();
              ((b.a)localObject).funcId = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).atI();
              cin localcin = (cin)((com.tencent.mm.al.b)localObject).gUS.gUX;
              localcin.EdU = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localcin.BX = 3;
              x.a((com.tencent.mm.al.b)localObject, new x.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
                {
                  AppMethodBeat.i(129804);
                  ad.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cio)paramAnonymousb.gUT.gUX).DSe);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
                    com.tencent.mm.plugin.walletlock.c.g.sV(false);
                    GestureGuardLogicUI.egv();
                  }
                  i.ADp.egK();
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
    if (paramView.getId() == 2131306126)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
    }
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
    this.ACg = new ViewFlipper(this);
    this.ABX = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.ABX;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.ACg.addView(localObject.mView);
      localObject.ACt.setOnPatternListener(this);
      localObject.ACu.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.ACg);
    this.mToken = getIntent().getStringExtra("token");
    this.ACf = getIntent().getStringExtra("type");
    this.ACk = getIntent().getStringExtra("verify_title");
    this.ABL = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.egH();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.ACd != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.ACd);
      this.ACd = null;
    }
    if (this.ACe != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.ACe);
      this.ACe = null;
    }
    if ((this.ACh != null) && (this.ACh.isShowing())) {
      this.ACh.dismiss();
    }
    if (this.ACg != null)
    {
      this.ACg.removeAllViews();
      this.ACg = null;
    }
    int i = 0;
    while (i < this.ABX.length)
    {
      a locala = this.ABX[i];
      locala.ACt.setOnClickListener(null);
      locala.ACu.setOnClickListener(null);
      locala.mView = null;
      locala.ACr = null;
      locala.ACs = null;
      locala.ACt = null;
      locala.ACu = null;
      this.ABX[i] = null;
      i += 1;
    }
    this.ABX = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (ego())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      J(0, 4, "user cancel when setting gesture");
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
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.egi();
      if (localg.ABS == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.ABT / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.as(localg.ABS, localg.ABT);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ACc = com.tencent.mm.plugin.walletlock.gesture.a.d.egm();
        if (this.ACc != -1) {}
      }
      else
      {
        this.ACc = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.egj();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    Object localObject = this.ABX[this.ABW];
    if (((a)localObject).ACt != null)
    {
      localObject = ((a)localObject).ACt;
      if ((!paramBoolean) || (this.ACb)) {
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