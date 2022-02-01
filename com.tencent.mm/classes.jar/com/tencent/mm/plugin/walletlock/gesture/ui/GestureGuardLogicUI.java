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
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.nv;
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
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a
{
  private int PpI;
  private int PpJ;
  private int PpK;
  private a[] PpL;
  private Animation PpM;
  private List<f> PpN;
  private List<f> PpO;
  private boolean PpP;
  private int PpQ;
  private q PpR;
  private q PpS;
  private String PpT;
  private ViewFlipper PpU;
  private Dialog PpV;
  private boolean PpW;
  private boolean PpX;
  private String PpY;
  private int Ppz;
  private MMHandler mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.PpI = 0;
    this.PpJ = 0;
    this.PpK = 0;
    this.PpL = null;
    this.PpM = null;
    this.PpN = null;
    this.PpO = null;
    this.PpP = false;
    this.PpQ = 0;
    this.PpR = null;
    this.PpS = null;
    this.mToken = null;
    this.PpT = null;
    this.PpU = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.PpV = null;
    this.PpW = true;
    this.PpX = false;
    this.Ppz = -1;
    AppMethodBeat.o(129819);
  }
  
  private void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129827);
    Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
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
    TextView localTextView = this.PpL[this.PpK].Pqf;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.PpJ);
    localTextView.startAnimation(this.PpM);
    this.PpM.setAnimationListener(new Animation.AnimationListener()
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
  
  private void a(String paramString, List<f> paramList, final aa.a parama)
  {
    AppMethodBeat.i(129831);
    d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129794);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqh.gNV();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aGY().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      bsu();
      parama.a(3, -6, getString(a.g.Pok), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).lBU = new dvx();
    ((com.tencent.mm.an.d.a)localObject).lBV = new dvy();
    ((com.tencent.mm.an.d.a)localObject).funcId = 688;
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((com.tencent.mm.an.d.a)localObject).bgN();
    dvx localdvx = (dvx)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localdvx.UbS = new eae().dc(paramString.getBytes());
    localdvx.UbT = new eae().dc(e.iV(paramList));
    aa.a((com.tencent.mm.an.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129795);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dvy)d.c.b(paramAnonymousd.lBS)).TMs);
          GestureGuardLogicUI.gNS();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).amN(1);
        }
        i.Prd.gOh();
        if (parama != null)
        {
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
          AppMethodBeat.o(129795);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129795);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129831);
  }
  
  private void a(List<f> paramList, final aa.a parama)
  {
    AppMethodBeat.i(129833);
    d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129800);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqh.gNV();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aGY().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).lBU = new deq();
    ((com.tencent.mm.an.d.a)localObject).lBV = new der();
    ((com.tencent.mm.an.d.a)localObject).funcId = 689;
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((com.tencent.mm.an.d.a)localObject).bgN();
    deq localdeq = (deq)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localdeq.Vh = 3;
    localdeq.TMq = new eae().dc(e.iV(paramList));
    aa.a((com.tencent.mm.an.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129801);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((der)d.c.b(paramAnonymousd.lBS)).TMs);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.PqZ;
          com.tencent.mm.plugin.walletlock.c.g.Cy(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.gNS();
        }
        if (parama != null)
        {
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
          AppMethodBeat.o(129801);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129801);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129833);
  }
  
  private void a(List<f> paramList1, List<f> paramList2, final aa.a parama)
  {
    AppMethodBeat.i(129832);
    Object localObject = new com.tencent.mm.an.d.a();
    d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129798);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqh.gNV();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aGY().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((com.tencent.mm.an.d.a)localObject).lBU = new deq();
    ((com.tencent.mm.an.d.a)localObject).lBV = new der();
    ((com.tencent.mm.an.d.a)localObject).funcId = 689;
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((com.tencent.mm.an.d.a)localObject).bgN();
    deq localdeq = (deq)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localdeq.Vh = 1;
    localdeq.TMq = new eae().dc(e.iV(paramList1));
    localdeq.TMr = new eae().dc(e.iV(paramList2));
    aa.a((com.tencent.mm.an.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129799);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((der)d.c.b(paramAnonymousd.lBS)).TMs);
          GestureGuardLogicUI.gNS();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new nv();
          ((nv)localObject).gCd = 8L;
          ((nv)localObject).han = 2L;
          ((nv)localObject).bpa();
        }
        for (;;)
        {
          i.Prd.gOh();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new nv();
            ((nv)localObject).gCd = 10L;
            ((nv)localObject).han = 2L;
            ((nv)localObject).bpa();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new nv();
              ((nv)localObject).gCd = 5L;
              ((nv)localObject).han = 2L;
              ((nv)localObject).bpa();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new nv();
              ((nv)localObject).gCd = 4L;
              ((nv)localObject).han = 2L;
              ((nv)localObject).bpa();
            }
            else
            {
              localObject = new nv();
              ((nv)localObject).gCd = 5L;
              ((nv)localObject).han = 2L;
              ((nv)localObject).bpa();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void bA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.PpK;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.PpK = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.PpU.setInAnimation(this, a.a.slide_right_in);
        this.PpU.setOutAnimation(this, a.a.slide_left_out);
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
        this.PpU.showNext();
        paramInt += 1;
      }
      this.PpU.setInAnimation(this, a.a.slide_left_in);
      this.PpU.setOutAnimation(this, a.a.slide_right_out);
      continue;
      this.PpU.setInAnimation(null);
      this.PpU.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.PpU.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void bsu()
  {
    AppMethodBeat.i(129844);
    if ((this.PpV != null) && (this.PpV.isShowing())) {
      this.PpV.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void d(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.PpV == null)
    {
      this.PpV = com.tencent.mm.ui.base.h.a(this, getString(a.g.Pon), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.PpV.show();
    AppMethodBeat.o(129843);
  }
  
  private boolean gNL()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.PpW) {
        gNR();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        gNQ();
      }
    }
    gNO();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void gNM()
  {
    AppMethodBeat.i(129829);
    if (this.PpL == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.PpL[this.PpK];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(a.g.Pou));
      setMMTitle(getString(a.g.Pov));
      if (this.Ppz == 1)
      {
        localObject2 = new nv();
        ((nv)localObject2).gCd = 8L;
        ((nv)localObject2).han = 1L;
        ((nv)localObject2).bpa();
      }
      long l;
      for (;;)
      {
        this.PpP = true;
        ((a)localObject1).Pqh.setEnableInput(false);
        ((a)localObject1).Pqh.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.gND().PpH / 1000L) / 60.0D);
        ((a)localObject1).Pqf.setText(String.format(getString(a.g.Poo), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).Pqf.setTextColor(getResources().getColor(a.b.red_text_color));
        AppMethodBeat.o(129829);
        return;
        if (this.Ppz == 2)
        {
          localObject2 = new nv();
          ((nv)localObject2).gCd = 10L;
          ((nv)localObject2).han = 1L;
          ((nv)localObject2).bpa();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(a.g.Pov));
        localObject2 = new nv();
        ((nv)localObject2).gCd = 5L;
        ((nv)localObject2).han = 1L;
        ((nv)localObject2).bpa();
      }
      for (;;)
      {
        this.PpP = false;
        ((a)localObject1).Pqh.setEnableInput(true);
        ((a)localObject1).Pqh.setOnPatternListener(this);
        ((a)localObject1).Pqf.setText(getString(a.g.Por));
        ((a)localObject1).Pqf.setTextColor(getResources().getColor(a.b.normal_text_color));
        if (((a)localObject1).Pqi.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).Pqi.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(a.g.Pow));
          localObject2 = new nv();
          ((nv)localObject2).gCd = 4L;
          ((nv)localObject2).han = 1L;
          ((nv)localObject2).bpa();
        }
        else
        {
          setMMTitle(getString(a.g.Pov));
          localObject2 = new nv();
          ((nv)localObject2).gCd = 5L;
          ((nv)localObject2).han = 1L;
          ((nv)localObject2).bpa();
        }
      }
      ((a)localObject1).Pqf.setText(getResources().getString(a.g.Pop));
      ((a)localObject1).Pqf.setTextColor(this.PpI);
      ((a)localObject1).Pqh.gNV();
      ((a)localObject1).Pqh.setEnableInput(true);
      if (((a)localObject1).Pqi.getVisibility() != 8)
      {
        ((a)localObject1).Pqi.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.PpX)
          {
            this.PpX = false;
            a(this.mToken, this.PpN, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poz), 0).show();
                  com.tencent.mm.plugin.report.service.h.IzE.a(11474, new Object[0]);
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129811);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          a(this.PpO, this.PpN, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129812);
              if (paramAnonymousInt2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poz), 0).show();
              }
              for (;;)
              {
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(129812);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.switch_on_pattern".equals(localObject1))
        {
          a(this.mToken, this.PpN, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129813);
              GestureGuardLogicUI.b(GestureGuardLogicUI.this);
              GestureGuardLogicUI.d(GestureGuardLogicUI.this);
              if (paramAnonymousInt2 == 0)
              {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poy), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
              }
              for (;;)
              {
                AppMethodBeat.o(129813);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.goto_protected_page".equals(localObject1))
        {
          a(this.mToken, this.PpN, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.Ts(SystemClock.elapsedRealtime());
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poz), 0).show();
                GestureGuardLogicUI.e(GestureGuardLogicUI.this);
              }
              for (;;)
              {
                GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                AppMethodBeat.o(129814);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
          ((a)localObject1).Pqh.setEnableInput(false);
          ((a)localObject1).Pqh.setDisplayMode(PatternLockView.b.PqK);
          a(getResources().getString(a.g.Poq), new a()
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
                  GestureGuardLogicUI.25.this.Pqd.Pqh.gNV();
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
          this.PpP = false;
          ((a)localObject1).Pqh.setEnableInput(true);
          ((a)localObject1).Pqh.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!Util.isNullOrNil(this.PpY)) {
              ((a)localObject1).Pqf.setText(this.PpY);
            }
          }
          for (;;)
          {
            ((a)localObject1).Pqf.setTextColor(this.PpI);
            if (((a)localObject1).Pqi.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).Pqi.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).Pqf.setText(getString(a.g.Pot));
            continue;
            ((a)localObject1).Pqf.setText(getString(a.g.Pos));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).Pqh.gNV();
            bA(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.PpO, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129817);
                if (paramAnonymousInt2 == 0) {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Pox), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129817);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          if ("next_action.goto_protected_page".equals(localObject2))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.d.Ts(SystemClock.elapsedRealtime());
            gNN();
            com.tencent.mm.plugin.walletlock.c.h.aN(this.Ppz, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.aS(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.amP(this.PpQ);
            com.tencent.mm.plugin.walletlock.gesture.a.d.gNs();
            if (this.PpQ == 5)
            {
              this.PpP = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.aR(l, 0L);
              ((a)localObject1).Pqh.gNV();
              ((a)localObject1).Pqh.setEnableInput(false);
              this.mStatus = 20;
              gNM();
              gNP();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.PpQ != 5) {
                break label1275;
              }
              com.tencent.mm.plugin.walletlock.c.h.aN(this.Ppz, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).Pqh.setEnableInput(false);
              ((a)localObject1).Pqh.setDisplayMode(PatternLockView.b.PqK);
              a(String.format(getResources().getString(a.g.Pol), new Object[] { Integer.valueOf(5 - this.PpQ) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.Pqd.Pqh.gNV();
                  this.Pqd.Pqh.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1275:
            com.tencent.mm.plugin.walletlock.c.h.aN(this.Ppz, 1, 1);
          }
        }
      }
    }
  }
  
  private void gNN()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.Prd.CC(true);
      i.Prd.CD(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(129834);
      return;
      Log.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void gNO()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.Prd.gOi();
    }
    AppMethodBeat.o(129835);
  }
  
  private void gNP()
  {
    AppMethodBeat.i(129840);
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    locala.HG(false).bBd(String.format(getString(a.g.Poe), new Object[] { Long.valueOf(10L) }));
    locala.ayj(a.g.Poa).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqi);
        AppMethodBeat.o(129806);
      }
    });
    locala.ayk(a.g.PnZ).d(new DialogInterface.OnClickListener()
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
    locala.icu().show();
    AppMethodBeat.o(129840);
  }
  
  private void gNQ()
  {
    AppMethodBeat.i(129841);
    new com.tencent.mm.ui.widget.a.d.a(this).HG(true).ayg(a.g.Poh).ayj(a.g.Poc).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).icu().show();
    AppMethodBeat.o(129841);
  }
  
  private void gNR()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(a.g.Pog);; str = getString(a.g.Pof))
    {
      new com.tencent.mm.ui.widget.a.d.a(this).HG(false).bBd(str).ayj(a.g.Pod).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).ayk(a.g.Pob).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).icu().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.PqJ);
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
        paramPatternLockView.setDisplayMode(PatternLockView.b.PqK);
        a(String.format(getString(a.g.Pom), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.gNV();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.PpN = paramList;
      paramPatternLockView.gNV();
      this.mStatus = 17;
      bA(2, true);
    }
    for (;;)
    {
      gNM();
      do
      {
        AppMethodBeat.o(129830);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129793);
              if (paramAnonymousInt2 == 0)
              {
                GestureGuardLogicUI.i(GestureGuardLogicUI.this);
                GestureGuardLogicUI.j(GestureGuardLogicUI.this);
                com.tencent.mm.plugin.walletlock.gesture.a.d.gNK();
                com.tencent.mm.plugin.walletlock.gesture.a.d.gNE();
                com.tencent.mm.plugin.walletlock.gesture.a.d.gNG();
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
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poj), 0).show();
                }
              }
            }
          };
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.gNI();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.gNH();
          com.tencent.mm.plugin.report.service.h.IzE.a(11453, new Object[0]);
          d(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqh.gNV();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.h.aGY().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((diz)localObject1);
          boolean bool4 = e.b((diy)localObject2);
          if (bool4) {
            if (bool3) {
              if (((diy)localObject2).version < ((diz)localObject1).TQv) {
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            localObject1 = new com.tencent.mm.an.d.a();
            ((com.tencent.mm.an.d.a)localObject1).lBU = new deq();
            ((com.tencent.mm.an.d.a)localObject1).lBV = new der();
            ((com.tencent.mm.an.d.a)localObject1).funcId = 689;
            ((com.tencent.mm.an.d.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((com.tencent.mm.an.d.a)localObject1).bgN();
            localObject2 = (deq)d.b.b(((com.tencent.mm.an.d)localObject1).lBR);
            ((deq)localObject2).Vh = 2;
            ((deq)localObject2).TMq = new eae().dc(e.iV(paramList));
            aa.a((com.tencent.mm.an.d)localObject1, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129797);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((der)d.c.b(paramAnonymousd.lBS)).TMs);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new nv();
                  ((nv)localObject).gCd = 8L;
                  ((nv)localObject).han = 2L;
                  ((nv)localObject).bpa();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new nv();
                    ((nv)localObject).gCd = 10L;
                    ((nv)localObject).han = 2L;
                    ((nv)localObject).bpa();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new nv();
                      ((nv)localObject).gCd = 5L;
                      ((nv)localObject).han = 2L;
                      ((nv)localObject).bpa();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new nv();
                      ((nv)localObject).gCd = 4L;
                      ((nv)localObject).han = 2L;
                      ((nv)localObject).bpa();
                    }
                    else
                    {
                      localObject = new nv();
                      ((nv)localObject).gCd = 5L;
                      ((nv)localObject).han = 2L;
                      ((nv)localObject).bpa();
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
          bsu();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.gNH();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((diy)localObject1).TQs.Tkb.UH).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.b.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.iV(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.PpN.equals(paramList))
      {
        paramPatternLockView.gNV();
        this.PpP = false;
        this.PpQ = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.gNK();
        com.tencent.mm.plugin.walletlock.gesture.a.d.gNE();
        com.tencent.mm.plugin.walletlock.gesture.a.d.gNG();
        com.tencent.mm.plugin.walletlock.gesture.a.d.gNs();
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
    setActionbarColor(getResources().getColor(a.b.white));
    setMMSubTitle(a.g.wechat_authenticate_safely);
    this.PpM = AnimationUtils.loadAnimation(this, a.a.PnK);
    this.PpI = getResources().getColor(a.b.normal_text_color);
    this.PpJ = getResources().getColor(a.b.red_text_color);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      bA(1, false);
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
      Log.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      gNM();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.gNC()) {
      this.PpP = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      bA(0, false);
      break;
      this.PpP = false;
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
        Log.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
        AppMethodBeat.o(129824);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.mToken = paramIntent.getStringExtra("key_token");
        this.PpT = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.PpX = true;
          }
          this.PpW = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          bA(1, false);
        }
        for (;;)
        {
          gNM();
          AppMethodBeat.o(129824);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            final aa.a local12 = new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129802);
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.gNK();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.gNE();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.gNG();
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Pox), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.c(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129802);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Poi), 0).show();
                }
              }
            };
            d(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(129803);
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Pqh.gNV();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.h.aGY().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              bsu();
              local12.a(3, -6, getString(a.g.Pok), null, null);
            }
            else
            {
              Object localObject = new com.tencent.mm.an.d.a();
              ((com.tencent.mm.an.d.a)localObject).lBU = new dvx();
              ((com.tencent.mm.an.d.a)localObject).lBV = new dvy();
              ((com.tencent.mm.an.d.a)localObject).funcId = 688;
              ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((com.tencent.mm.an.d.a)localObject).bgN();
              dvx localdvx = (dvx)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
              localdvx.UbS = new eae().dc(paramIntent.getBytes());
              localdvx.Vh = 3;
              aa.a((com.tencent.mm.an.d)localObject, new aa.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
                {
                  AppMethodBeat.i(129804);
                  Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dvy)d.c.b(paramAnonymousd.lBS)).TMs);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.PqZ;
                    com.tencent.mm.plugin.walletlock.c.g.Cy(false);
                    GestureGuardLogicUI.gNS();
                  }
                  i.Prd.gOh();
                  if (local12 != null)
                  {
                    paramAnonymousInt1 = local12.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
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
        Toast.makeText(this, getString(a.g.Poi), 0).show();
      }
    }
    AppMethodBeat.o(129824);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(129825);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == a.d.PnW)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(129825);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(129820);
    super.onCreate(paramBundle);
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    paramBundle = getIntent();
    if ((!MMApplicationContext.getPackageName().equals(paramBundle.getPackage())) || (Util.isNullOrNil(paramBundle.getStringExtra("action"))) || (Util.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      Log.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(129820);
      return;
    }
    this.PpU = new ViewFlipper(this);
    this.PpL = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.PpL;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.PpU.addView(localObject.mView);
      localObject.Pqh.setOnPatternListener(this);
      localObject.Pqi.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.PpU);
    this.mToken = getIntent().getStringExtra("token");
    this.PpT = getIntent().getStringExtra("type");
    this.PpY = getIntent().getStringExtra("verify_title");
    this.Ppz = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.gOe();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.PpR != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.PpR);
      this.PpR = null;
    }
    if (this.PpS != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.PpS);
      this.PpS = null;
    }
    if ((this.PpV != null) && (this.PpV.isShowing())) {
      this.PpV.dismiss();
    }
    if (this.PpU != null)
    {
      this.PpU.removeAllViews();
      this.PpU = null;
    }
    int i = 0;
    while (i < this.PpL.length)
    {
      a locala = this.PpL[i];
      locala.Pqh.setOnClickListener(null);
      locala.Pqi.setOnClickListener(null);
      locala.mView = null;
      locala.Pqf = null;
      locala.Pqg = null;
      locala.Pqh = null;
      locala.Pqi = null;
      this.PpL[i] = null;
      i += 1;
    }
    this.PpL = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (gNL())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      L(0, 4, "user cancel when setting gesture");
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
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.gNF();
      if (localg.PpG == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.PpH / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.aS(localg.PpG, localg.PpH);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.PpQ = com.tencent.mm.plugin.walletlock.gesture.a.d.gNJ();
        if (this.PpQ != -1) {}
      }
      else
      {
        this.PpQ = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.gNG();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    AppMethodBeat.at(this, paramBoolean);
    Object localObject = this.PpL[this.PpK];
    if (((a)localObject).Pqh != null)
    {
      localObject = ((a)localObject).Pqh;
      if ((!paramBoolean) || (this.PpP)) {
        break label58;
      }
    }
    label58:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PatternLockView)localObject).setEnableInput(paramBoolean);
      AppMethodBeat.o(129836);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */