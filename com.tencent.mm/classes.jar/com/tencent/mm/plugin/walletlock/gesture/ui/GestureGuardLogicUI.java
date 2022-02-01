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
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.a;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.i;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a
{
  private List<com.tencent.mm.plugin.walletlock.gesture.a.h> WgA;
  private List<com.tencent.mm.plugin.walletlock.gesture.a.h> WgB;
  private boolean WgC;
  private int WgD;
  private com.tencent.mm.am.p WgE;
  private com.tencent.mm.am.p WgF;
  private String WgG;
  private ViewFlipper WgH;
  private Dialog WgI;
  private boolean WgJ;
  private boolean WgK;
  private String WgL;
  private int Wgi;
  private int Wgv;
  private int Wgw;
  private int Wgx;
  private a[] Wgy;
  private Animation Wgz;
  private MMHandler mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.Wgv = 0;
    this.Wgw = 0;
    this.Wgx = 0;
    this.Wgy = null;
    this.Wgz = null;
    this.WgA = null;
    this.WgB = null;
    this.WgC = false;
    this.WgD = 0;
    this.WgE = null;
    this.WgF = null;
    this.mToken = null;
    this.WgG = null;
    this.WgH = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.WgI = null;
    this.WgJ = true;
    this.WgK = false;
    this.Wgi = -1;
    AppMethodBeat.o(129819);
  }
  
  private void U(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129827);
    Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_err_code", paramInt2);
    ((Intent)localObject).putExtra("key_err_msg", paramString);
    setResult(paramInt1, (Intent)localObject);
    finish();
    if ((paramInt2 == 4) || (paramInt2 == 0))
    {
      paramString = new ada();
      localObject = paramString.igZ;
      if (paramInt2 != 4) {
        break label105;
      }
    }
    label105:
    for (paramInt1 = 5;; paramInt1 = 6)
    {
      ((ada.a)localObject).ihb = paramInt1;
      paramString.igZ.activity = this;
      paramString.publish();
      AppMethodBeat.o(129827);
      return;
    }
  }
  
  private void a(String paramString, final a parama)
  {
    AppMethodBeat.i(129839);
    TextView localTextView = this.Wgy[this.Wgx].WgS;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.Wgw);
    localTextView.startAnimation(this.Wgz);
    this.Wgz.setAnimationListener(new Animation.AnimationListener()
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
  
  private void a(String paramString, List<com.tencent.mm.plugin.walletlock.gesture.a.h> paramList, final z.a parama)
  {
    AppMethodBeat.i(129831);
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129794);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgU.ink();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aZW().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      bQa();
      parama.callback(3, -6, getString(a.g.WeL), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eox();
    ((c.a)localObject).otF = new eoy();
    ((c.a)localObject).funcId = 688;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((c.a)localObject).bEF();
    eox localeox = (eox)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localeox.abtd = new gol().df(paramString.getBytes());
    localeox.abte = new gol().df(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList));
    z.a((com.tencent.mm.am.c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(129795);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.f.a(((eoy)c.c.b(paramAnonymousc.otC)).abcB);
          GestureGuardLogicUI.inh();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).asE(1);
        }
        com.tencent.mm.plugin.walletlock.model.h.WhQ.inw();
        if (parama != null)
        {
          paramAnonymousInt1 = parama.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, paramAnonymousp);
          AppMethodBeat.o(129795);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129795);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129831);
  }
  
  private void a(List<com.tencent.mm.plugin.walletlock.gesture.a.h> paramList, final z.a parama)
  {
    AppMethodBeat.i(129833);
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129800);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgU.ink();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aZW().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwp();
    ((c.a)localObject).otF = new dwq();
    ((c.a)localObject).funcId = 689;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((c.a)localObject).bEF();
    dwp localdwp = (dwp)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localdwp.bUl = 3;
    localdwp.abcz = new gol().df(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList));
    z.a((com.tencent.mm.am.c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(129801);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.f.a(((dwq)c.c.b(paramAnonymousc.otC)).abcB);
          com.tencent.mm.plugin.walletlock.model.f localf = com.tencent.mm.plugin.walletlock.model.f.WhM;
          com.tencent.mm.plugin.walletlock.model.f.Id(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.inh();
        }
        if (parama != null)
        {
          paramAnonymousInt1 = parama.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, paramAnonymousp);
          AppMethodBeat.o(129801);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(129801);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129833);
  }
  
  private void a(List<com.tencent.mm.plugin.walletlock.gesture.a.h> paramList1, List<com.tencent.mm.plugin.walletlock.gesture.a.h> paramList2, final z.a parama)
  {
    AppMethodBeat.i(129832);
    Object localObject = new c.a();
    c(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129798);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgU.ink();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.h.aZW().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((c.a)localObject).otE = new dwp();
    ((c.a)localObject).otF = new dwq();
    ((c.a)localObject).funcId = 689;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((c.a)localObject).bEF();
    dwp localdwp = (dwp)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localdwp.bUl = 1;
    localdwp.abcz = new gol().df(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList1));
    localdwp.abcA = new gol().df(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList2));
    z.a((com.tencent.mm.am.c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(129799);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.f.a(((dwq)c.c.b(paramAnonymousc.otC)).abcB);
          GestureGuardLogicUI.inh();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new rn();
          ((rn)localObject).iPe = 8L;
          ((rn)localObject).jvX = 2L;
          ((rn)localObject).bMH();
        }
        for (;;)
        {
          com.tencent.mm.plugin.walletlock.model.h.WhQ.inw();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, paramAnonymousp);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new rn();
            ((rn)localObject).iPe = 10L;
            ((rn)localObject).jvX = 2L;
            ((rn)localObject).bMH();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new rn();
              ((rn)localObject).iPe = 5L;
              ((rn)localObject).jvX = 2L;
              ((rn)localObject).bMH();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new rn();
              ((rn)localObject).iPe = 4L;
              ((rn)localObject).jvX = 2L;
              ((rn)localObject).bMH();
            }
            else
            {
              localObject = new rn();
              ((rn)localObject).iPe = 5L;
              ((rn)localObject).jvX = 2L;
              ((rn)localObject).bMH();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void bQa()
  {
    AppMethodBeat.i(129844);
    if ((this.WgI != null) && (this.WgI.isShowing())) {
      this.WgI.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.WgI == null)
    {
      this.WgI = k.a(this, getString(a.g.WeO), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.WgI.show();
    AppMethodBeat.o(129843);
  }
  
  private void ci(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.Wgx;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.Wgx = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.WgH.setInAnimation(this, a.a.slide_right_in);
        this.WgH.setOutAnimation(this, a.a.slide_left_out);
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
        this.WgH.showNext();
        paramInt += 1;
      }
      this.WgH.setInAnimation(this, a.a.slide_left_in);
      this.WgH.setOutAnimation(this, a.a.slide_right_out);
      continue;
      this.WgH.setInAnimation(null);
      this.WgH.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.WgH.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private boolean ina()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.WgJ) {
        ing();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        inf();
      }
    }
    ind();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void inb()
  {
    AppMethodBeat.i(129829);
    if (this.Wgy == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.Wgy[this.Wgx];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(a.g.WeV));
      setMMTitle(getString(a.g.WeW));
      if (this.Wgi == 1)
      {
        localObject2 = new rn();
        ((rn)localObject2).iPe = 8L;
        ((rn)localObject2).jvX = 1L;
        ((rn)localObject2).bMH();
      }
      long l;
      for (;;)
      {
        this.WgC = true;
        ((a)localObject1).WgU.setEnableInput(false);
        ((a)localObject1).WgU.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.f.imS().Wgu / 1000L) / 60.0D);
        ((a)localObject1).WgS.setText(String.format(getString(a.g.WeP), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).WgS.setTextColor(getResources().getColor(a.b.red_text_color));
        AppMethodBeat.o(129829);
        return;
        if (this.Wgi == 2)
        {
          localObject2 = new rn();
          ((rn)localObject2).iPe = 10L;
          ((rn)localObject2).jvX = 1L;
          ((rn)localObject2).bMH();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(a.g.WeW));
        localObject2 = new rn();
        ((rn)localObject2).iPe = 5L;
        ((rn)localObject2).jvX = 1L;
        ((rn)localObject2).bMH();
      }
      for (;;)
      {
        this.WgC = false;
        ((a)localObject1).WgU.setEnableInput(true);
        ((a)localObject1).WgU.setOnPatternListener(this);
        ((a)localObject1).WgS.setText(getString(a.g.WeS));
        ((a)localObject1).WgS.setTextColor(getResources().getColor(a.b.normal_text_color));
        if (((a)localObject1).WgV.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).WgV.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(a.g.WeX));
          localObject2 = new rn();
          ((rn)localObject2).iPe = 4L;
          ((rn)localObject2).jvX = 1L;
          ((rn)localObject2).bMH();
        }
        else
        {
          setMMTitle(getString(a.g.WeW));
          localObject2 = new rn();
          ((rn)localObject2).iPe = 5L;
          ((rn)localObject2).jvX = 1L;
          ((rn)localObject2).bMH();
        }
      }
      ((a)localObject1).WgS.setText(getResources().getString(a.g.WeQ));
      ((a)localObject1).WgS.setTextColor(this.Wgv);
      ((a)localObject1).WgU.ink();
      ((a)localObject1).WgU.setEnableInput(true);
      if (((a)localObject1).WgV.getVisibility() != 8)
      {
        ((a)localObject1).WgV.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.WgK)
          {
            this.WgK = false;
            a(this.mToken, this.WgA, new z.a()
            {
              public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Wfb), 0).show();
                  com.tencent.mm.plugin.report.service.h.OAn.b(11474, new Object[0]);
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129811);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          a(this.WgB, this.WgA, new z.a()
          {
            public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
            {
              AppMethodBeat.i(129812);
              if (paramAnonymousInt2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Wfb), 0).show();
              }
              for (;;)
              {
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(129812);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.switch_on_pattern".equals(localObject1))
        {
          a(this.mToken, this.WgA, new z.a()
          {
            public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
            {
              AppMethodBeat.i(129813);
              GestureGuardLogicUI.b(GestureGuardLogicUI.this);
              GestureGuardLogicUI.d(GestureGuardLogicUI.this);
              if (paramAnonymousInt2 == 0)
              {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Wfa), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
              }
              for (;;)
              {
                AppMethodBeat.o(129813);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.goto_protected_page".equals(localObject1))
        {
          a(this.mToken, this.WgA, new z.a()
          {
            public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.f.xB(SystemClock.elapsedRealtime());
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.Wfb), 0).show();
                GestureGuardLogicUI.e(GestureGuardLogicUI.this);
              }
              for (;;)
              {
                GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                AppMethodBeat.o(129814);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
          ((a)localObject1).WgU.setEnableInput(false);
          ((a)localObject1).WgU.setDisplayMode(PatternLockView.b.Whx);
          a(getResources().getString(a.g.WeR), new a()
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
                  GestureGuardLogicUI.25.this.WgQ.WgU.ink();
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
          setMMTitle(getString(a.g.WeY));
          this.WgC = false;
          ((a)localObject1).WgU.setEnableInput(true);
          ((a)localObject1).WgU.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!Util.isNullOrNil(this.WgL)) {
              ((a)localObject1).WgS.setText(this.WgL);
            }
          }
          for (;;)
          {
            ((a)localObject1).WgS.setTextColor(this.Wgv);
            if (((a)localObject1).WgV.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).WgV.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).WgS.setText(getString(a.g.WeU));
            continue;
            ((a)localObject1).WgS.setText(getString(a.g.WeT));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).WgU.ink();
            ci(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.WgB, new z.a()
            {
              public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
              {
                AppMethodBeat.i(129817);
                if (paramAnonymousInt2 == 0) {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeZ), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129817);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          if ("next_action.goto_protected_page".equals(localObject2))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.f.xB(SystemClock.elapsedRealtime());
            inc();
            com.tencent.mm.plugin.walletlock.model.g.bp(this.Wgi, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.f.bE(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.f.asG(this.WgD);
            com.tencent.mm.plugin.walletlock.gesture.a.f.imH();
            if (this.WgD == 5)
            {
              this.WgC = true;
              com.tencent.mm.plugin.walletlock.gesture.a.f.bD(l, 0L);
              ((a)localObject1).WgU.ink();
              ((a)localObject1).WgU.setEnableInput(false);
              this.mStatus = 20;
              inb();
              ine();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.WgD != 5) {
                break label1279;
              }
              com.tencent.mm.plugin.walletlock.model.g.bp(this.Wgi, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).WgU.setEnableInput(false);
              ((a)localObject1).WgU.setDisplayMode(PatternLockView.b.Whx);
              a(String.format(getResources().getString(a.g.WeM), new Object[] { Integer.valueOf(5 - this.WgD) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.WgQ.WgU.ink();
                  this.WgQ.WgU.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1279:
            com.tencent.mm.plugin.walletlock.model.g.bp(this.Wgi, 1, 1);
          }
        }
      }
    }
  }
  
  private void inc()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      com.tencent.mm.plugin.walletlock.model.h.WhQ.Ih(true);
      com.tencent.mm.plugin.walletlock.model.h.WhQ.Ii(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
  
  private void ind()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      com.tencent.mm.plugin.walletlock.model.h.WhQ.inx();
    }
    AppMethodBeat.o(129835);
  }
  
  private void ine()
  {
    AppMethodBeat.i(129840);
    e.a locala = new e.a(this);
    locala.NC(false).bDw(String.format(getString(a.g.WeF), new Object[] { Long.valueOf(10L) }));
    locala.aER(a.g.WeB).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgV);
        AppMethodBeat.o(129806);
      }
    });
    locala.aES(a.g.WeA).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129807);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.t(GestureGuardLogicUI.this);
        GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
        AppMethodBeat.o(129807);
      }
    });
    locala.jHH().show();
    AppMethodBeat.o(129840);
  }
  
  private void inf()
  {
    AppMethodBeat.i(129841);
    new e.a(this).NC(true).aEO(a.g.WeI).aER(a.g.WeD).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).jHH().show();
    AppMethodBeat.o(129841);
  }
  
  private void ing()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(a.g.WeH);; str = getString(a.g.WeG))
    {
      new e.a(this).NC(false).bDw(str).aER(a.g.WeE).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).aES(a.g.WeC).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).jHH().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.Whw);
    AppMethodBeat.o(129837);
  }
  
  public final void a(final PatternLockView paramPatternLockView, final List<com.tencent.mm.plugin.walletlock.gesture.a.h> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(129830);
    if (this.mStatus == 16)
    {
      if (paramList.size() < 4)
      {
        paramPatternLockView.setEnableInput(false);
        paramPatternLockView.setDisplayMode(PatternLockView.b.Whx);
        a(String.format(getString(a.g.WeN), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.ink();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.WgA = paramList;
      paramPatternLockView.ink();
      this.mStatus = 17;
      ci(2, true);
    }
    for (;;)
    {
      inb();
      do
      {
        AppMethodBeat.o(129830);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new z.a()
          {
            public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
            {
              AppMethodBeat.i(129793);
              if (paramAnonymousInt2 == 0)
              {
                GestureGuardLogicUI.i(GestureGuardLogicUI.this);
                GestureGuardLogicUI.j(GestureGuardLogicUI.this);
                com.tencent.mm.plugin.walletlock.gesture.a.f.imZ();
                com.tencent.mm.plugin.walletlock.gesture.a.f.imT();
                com.tencent.mm.plugin.walletlock.gesture.a.f.imV();
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
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeK), 0).show();
                }
              }
            }
          };
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.f.imX();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.f.imW();
          com.tencent.mm.plugin.report.service.h.OAn.b(11453, new Object[0]);
          c(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgU.ink();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.h.aZW().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = com.tencent.mm.plugin.walletlock.gesture.a.g.b((ebj)localObject1);
          boolean bool4 = com.tencent.mm.plugin.walletlock.gesture.a.g.b((ebi)localObject2);
          if (bool4) {
            if (bool3) {
              if (((ebi)localObject2).version < ((ebj)localObject1).abgU) {
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
            localObject1 = new c.a();
            ((c.a)localObject1).otE = new dwp();
            ((c.a)localObject1).otF = new dwq();
            ((c.a)localObject1).funcId = 689;
            ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((c.a)localObject1).bEF();
            localObject2 = (dwp)c.b.b(((com.tencent.mm.am.c)localObject1).otB);
            ((dwp)localObject2).bUl = 2;
            ((dwp)localObject2).abcz = new gol().df(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList));
            z.a((com.tencent.mm.am.c)localObject1, new z.a()
            {
              public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
              {
                AppMethodBeat.i(129797);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.f.a(((dwq)c.c.b(paramAnonymousc.otC)).abcB);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new rn();
                  ((rn)localObject).iPe = 8L;
                  ((rn)localObject).jvX = 2L;
                  ((rn)localObject).bMH();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, paramAnonymousp);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new rn();
                    ((rn)localObject).iPe = 10L;
                    ((rn)localObject).jvX = 2L;
                    ((rn)localObject).bMH();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new rn();
                      ((rn)localObject).iPe = 5L;
                      ((rn)localObject).jvX = 2L;
                      ((rn)localObject).bMH();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new rn();
                      ((rn)localObject).iPe = 4L;
                      ((rn)localObject).jvX = 2L;
                      ((rn)localObject).bMH();
                    }
                    else
                    {
                      localObject = new rn();
                      ((rn)localObject).iPe = 5L;
                      ((rn)localObject).jvX = 2L;
                      ((rn)localObject).bMH();
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
          bQa();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.f.imW();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((ebi)localObject1).abgR.aaxD.Op).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.callback(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            ((StringBuilder)localObject2).append(new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(com.tencent.mm.plugin.walletlock.gesture.a.g.md(paramList)));
          }
          paramPatternLockView.callback(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.WgA.equals(paramList))
      {
        paramPatternLockView.ink();
        this.WgC = false;
        this.WgD = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.f.imZ();
        com.tencent.mm.plugin.walletlock.gesture.a.f.imT();
        com.tencent.mm.plugin.walletlock.gesture.a.f.imV();
        com.tencent.mm.plugin.walletlock.gesture.a.f.imH();
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
    return a.e.Wez;
  }
  
  public void initView()
  {
    AppMethodBeat.i(129823);
    hideVKB();
    setActionbarColor(getResources().getColor(a.b.white));
    this.Wgz = AnimationUtils.loadAnimation(this, a.a.Wej);
    this.Wgv = getResources().getColor(a.b.normal_text_color);
    this.Wgw = getResources().getColor(a.b.red_text_color);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      ci(1, false);
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
      inb();
      AppMethodBeat.o(129823);
      return;
    }
    if (d.imR()) {
      this.WgC = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      ci(0, false);
      break;
      this.WgC = false;
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
        this.WgG = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.WgK = true;
          }
          this.WgJ = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          ci(1, false);
        }
        for (;;)
        {
          inb();
          AppMethodBeat.o(129824);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            final z.a local12 = new z.a()
            {
              public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
              {
                AppMethodBeat.i(129802);
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.f.imZ();
                  com.tencent.mm.plugin.walletlock.gesture.a.f.imT();
                  com.tencent.mm.plugin.walletlock.gesture.a.f.imV();
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeZ), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.c(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129802);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(a.g.WeJ), 0).show();
                }
              }
            };
            c(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(129803);
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].WgU.ink();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.h.aZW().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              bQa();
              local12.callback(3, -6, getString(a.g.WeL), null, null);
            }
            else
            {
              Object localObject = new c.a();
              ((c.a)localObject).otE = new eox();
              ((c.a)localObject).otF = new eoy();
              ((c.a)localObject).funcId = 688;
              ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((c.a)localObject).bEF();
              eox localeox = (eox)c.b.b(((com.tencent.mm.am.c)localObject).otB);
              localeox.abtd = new gol().df(paramIntent.getBytes());
              localeox.bUl = 3;
              z.a((com.tencent.mm.am.c)localObject, new z.a()
              {
                public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
                {
                  AppMethodBeat.i(129804);
                  Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.f.a(((eoy)c.c.b(paramAnonymousc.otC)).abcB);
                    com.tencent.mm.plugin.walletlock.model.f localf = com.tencent.mm.plugin.walletlock.model.f.WhM;
                    com.tencent.mm.plugin.walletlock.model.f.Id(false);
                    GestureGuardLogicUI.inh();
                  }
                  com.tencent.mm.plugin.walletlock.model.h.WhQ.inw();
                  if (local12 != null)
                  {
                    paramAnonymousInt1 = local12.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, paramAnonymousp);
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
        Toast.makeText(this, getString(a.g.WeJ), 0).show();
      }
    }
    AppMethodBeat.o(129824);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(129825);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.d.Wex)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
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
    this.WgH = new ViewFlipper(this);
    this.Wgy = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.Wgy;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.WgH.addView(localObject.mView);
      localObject.WgU.setOnPatternListener(this);
      localObject.WgV.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.WgH);
    this.mToken = getIntent().getStringExtra("token");
    this.WgG = getIntent().getStringExtra("type");
    this.WgL = getIntent().getStringExtra("verify_title");
    this.Wgi = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.model.g.jdMethod_int();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.WgE != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.WgE);
      this.WgE = null;
    }
    if (this.WgF != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.WgF);
      this.WgF = null;
    }
    if ((this.WgI != null) && (this.WgI.isShowing())) {
      this.WgI.dismiss();
    }
    if (this.WgH != null)
    {
      this.WgH.removeAllViews();
      this.WgH = null;
    }
    int i = 0;
    while (i < this.Wgy.length)
    {
      a locala = this.Wgy[i];
      locala.WgU.setOnClickListener(null);
      locala.WgV.setOnClickListener(null);
      locala.mView = null;
      locala.WgS = null;
      locala.WgT = null;
      locala.WgU = null;
      locala.WgV = null;
      this.Wgy[i] = null;
      i += 1;
    }
    this.Wgy = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (ina())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      U(0, 4, "user cancel when setting gesture");
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
      i locali = com.tencent.mm.plugin.walletlock.gesture.a.f.imU();
      if (locali.Wgt == -1L) {
        break label98;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.g.a(locali);
      if (locali.Wgu / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.f.bE(locali.Wgt, locali.Wgu);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.WgD = com.tencent.mm.plugin.walletlock.gesture.a.f.imY();
        if (this.WgD != -1) {}
      }
      else
      {
        this.WgD = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.f.imV();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    AppMethodBeat.at(this, paramBoolean);
    Object localObject = this.Wgy[this.Wgx];
    if (((a)localObject).WgU != null)
    {
      localObject = ((a)localObject).WgU;
      if ((!paramBoolean) || (this.WgC)) {
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(266984);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.walletlock.gesture.a.c.class);
    AppMethodBeat.o(266984);
  }
  
  static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */