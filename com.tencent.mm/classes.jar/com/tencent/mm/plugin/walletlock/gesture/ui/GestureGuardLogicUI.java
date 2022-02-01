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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a
{
  private String BUA;
  private ViewFlipper BUB;
  private Dialog BUC;
  private boolean BUD;
  private boolean BUE;
  private String BUF;
  private int BUg;
  private int BUp;
  private int BUq;
  private int BUr;
  private a[] BUs;
  private Animation BUt;
  private List<f> BUu;
  private List<f> BUv;
  private boolean BUw;
  private int BUx;
  private n BUy;
  private n BUz;
  private ao mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.BUp = 0;
    this.BUq = 0;
    this.BUr = 0;
    this.BUs = null;
    this.BUt = null;
    this.BUu = null;
    this.BUv = null;
    this.BUw = false;
    this.BUx = 0;
    this.BUy = null;
    this.BUz = null;
    this.mToken = null;
    this.BUA = null;
    this.BUB = null;
    this.mHandler = new ao(Looper.getMainLooper());
    this.BUC = null;
    this.BUD = true;
    this.BUE = false;
    this.BUg = -1;
    AppMethodBeat.o(129819);
  }
  
  private void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129827);
    ac.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
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
    TextView localTextView = this.BUs[this.BUr].BUM;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.BUq);
    localTextView.startAnimation(this.BUt);
    this.BUt.setAnimationListener(new Animation.AnimationListener()
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUO.evS();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.agi().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      aLi();
      parama.a(3, -6, getString(2131760045), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cnt();
    ((b.a)localObject).hvu = new cnu();
    ((b.a)localObject).funcId = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).aAz();
    cnt localcnt = (cnt)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localcnt.FAT = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localcnt.FAU = new SKBuiltinBuffer_t().setBuffer(e.gD(paramList));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129795);
        ac.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cnu)paramAnonymousb.hvs.hvw).FoA);
          GestureGuardLogicUI.evP();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).TU(1);
        }
        i.BVK.ewe();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUO.evS();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.agi().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bzo();
    ((b.a)localObject).hvu = new bzp();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aAz();
    bzo localbzo = (bzo)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localbzo.CW = 3;
    localbzo.Foy = new SKBuiltinBuffer_t().setBuffer(e.gD(paramList));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129801);
        ac.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bzp)paramAnonymousb.hvs.hvw).FoA);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
          com.tencent.mm.plugin.walletlock.c.g.tW(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.evP();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUO.evS();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.agi().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((b.a)localObject).hvt = new bzo();
    ((b.a)localObject).hvu = new bzp();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aAz();
    bzo localbzo = (bzo)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localbzo.CW = 1;
    localbzo.Foy = new SKBuiltinBuffer_t().setBuffer(e.gD(paramList1));
    localbzo.Foz = new SKBuiltinBuffer_t().setBuffer(e.gD(paramList2));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129799);
        ac.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bzp)paramAnonymousb.hvs.hvw).FoA);
          GestureGuardLogicUI.evP();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new gd();
          ((gd)localObject).dNx = 8L;
          ((gd)localObject).ebp = 2L;
          ((gd)localObject).aHZ();
        }
        for (;;)
        {
          i.BVK.ewe();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new gd();
            ((gd)localObject).dNx = 10L;
            ((gd)localObject).ebp = 2L;
            ((gd)localObject).aHZ();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new gd();
              ((gd)localObject).dNx = 5L;
              ((gd)localObject).ebp = 2L;
              ((gd)localObject).aHZ();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new gd();
              ((gd)localObject).dNx = 4L;
              ((gd)localObject).ebp = 2L;
              ((gd)localObject).aHZ();
            }
            else
            {
              localObject = new gd();
              ((gd)localObject).dNx = 5L;
              ((gd)localObject).ebp = 2L;
              ((gd)localObject).aHZ();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.BUr;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.BUr = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.BUB.setInAnimation(this, 2130772144);
        this.BUB.setOutAnimation(this, 2130772141);
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
        this.BUB.showNext();
        paramInt += 1;
      }
      this.BUB.setInAnimation(this, 2130772140);
      this.BUB.setOutAnimation(this, 2130772145);
      continue;
      this.BUB.setInAnimation(null);
      this.BUB.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.BUB.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void aLi()
  {
    AppMethodBeat.i(129844);
    if ((this.BUC != null) && (this.BUC.isShowing())) {
      this.BUC.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.BUC == null)
    {
      this.BUC = com.tencent.mm.ui.base.h.b(this, getString(2131760048), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.BUC.show();
    AppMethodBeat.o(129843);
  }
  
  private boolean evI()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.BUD) {
        evO();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        evN();
      }
    }
    evL();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void evJ()
  {
    AppMethodBeat.i(129829);
    if (this.BUs == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.BUs[this.BUr];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(2131760057));
      setMMTitle(getString(2131760058));
      if (this.BUg == 1)
      {
        localObject2 = new gd();
        ((gd)localObject2).dNx = 8L;
        ((gd)localObject2).ebp = 1L;
        ((gd)localObject2).aHZ();
      }
      long l;
      for (;;)
      {
        this.BUw = true;
        ((a)localObject1).BUO.setEnableInput(false);
        ((a)localObject1).BUO.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.evA().BUo / 1000L) / 60.0D);
        ((a)localObject1).BUM.setText(String.format(getString(2131760050), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).BUM.setTextColor(getResources().getColor(2131100800));
        AppMethodBeat.o(129829);
        return;
        if (this.BUg == 2)
        {
          localObject2 = new gd();
          ((gd)localObject2).dNx = 10L;
          ((gd)localObject2).ebp = 1L;
          ((gd)localObject2).aHZ();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131760058));
        localObject2 = new gd();
        ((gd)localObject2).dNx = 5L;
        ((gd)localObject2).ebp = 1L;
        ((gd)localObject2).aHZ();
      }
      for (;;)
      {
        this.BUw = false;
        ((a)localObject1).BUO.setEnableInput(true);
        ((a)localObject1).BUO.setOnPatternListener(this);
        ((a)localObject1).BUM.setText(getString(2131760054));
        ((a)localObject1).BUM.setTextColor(getResources().getColor(2131100711));
        if (((a)localObject1).BUP.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).BUP.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131760059));
          localObject2 = new gd();
          ((gd)localObject2).dNx = 4L;
          ((gd)localObject2).ebp = 1L;
          ((gd)localObject2).aHZ();
        }
        else
        {
          setMMTitle(getString(2131760058));
          localObject2 = new gd();
          ((gd)localObject2).dNx = 5L;
          ((gd)localObject2).ebp = 1L;
          ((gd)localObject2).aHZ();
        }
      }
      ((a)localObject1).BUM.setText(getResources().getString(2131760052));
      ((a)localObject1).BUM.setTextColor(this.BUp);
      ((a)localObject1).BUO.evS();
      ((a)localObject1).BUO.setEnableInput(true);
      if (((a)localObject1).BUP.getVisibility() != 8)
      {
        ((a)localObject1).BUP.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.BUE)
          {
            this.BUE = false;
            a(this.mToken, this.BUu, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
                  com.tencent.mm.plugin.report.service.h.wUl.f(11474, new Object[0]);
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
          a(this.BUv, this.BUu, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
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
          a(this.mToken, this.BUu, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
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
          a(this.mToken, this.BUu, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.zw(SystemClock.elapsedRealtime());
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
          ((a)localObject1).BUO.setEnableInput(false);
          ((a)localObject1).BUO.setDisplayMode(PatternLockView.b.BVr);
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
                  GestureGuardLogicUI.25.this.BUK.BUO.evS();
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
          this.BUw = false;
          ((a)localObject1).BUO.setEnableInput(true);
          ((a)localObject1).BUO.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!bs.isNullOrNil(this.BUF)) {
              ((a)localObject1).BUM.setText(this.BUF);
            }
          }
          for (;;)
          {
            ((a)localObject1).BUM.setTextColor(this.BUp);
            if (((a)localObject1).BUP.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).BUP.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).BUM.setText(getString(2131760056));
            continue;
            ((a)localObject1).BUM.setText(getString(2131760055));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).BUO.evS();
            aK(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.BUv, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
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
            com.tencent.mm.plugin.walletlock.gesture.a.d.zw(SystemClock.elapsedRealtime());
            evK();
            com.tencent.mm.plugin.walletlock.c.h.ay(this.BUg, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.ar(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.TW(this.BUx);
            com.tencent.mm.plugin.walletlock.gesture.a.d.evp();
            if (this.BUx == 5)
            {
              this.BUw = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.aq(l, 0L);
              ((a)localObject1).BUO.evS();
              ((a)localObject1).BUO.setEnableInput(false);
              this.mStatus = 20;
              evJ();
              evM();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              ac.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.BUx != 5) {
                break label1279;
              }
              com.tencent.mm.plugin.walletlock.c.h.ay(this.BUg, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).BUO.setEnableInput(false);
              ((a)localObject1).BUO.setDisplayMode(PatternLockView.b.BVr);
              a(String.format(getResources().getString(2131760046), new Object[] { Integer.valueOf(5 - this.BUx) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.BUK.BUO.evS();
                  this.BUK.BUO.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1279:
            com.tencent.mm.plugin.walletlock.c.h.ay(this.BUg, 1, 1);
          }
        }
      }
    }
  }
  
  private void evK()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.BVK.ua(true);
      i.BVK.ub(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(129834);
      return;
      ac.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void evL()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.BVK.ewf();
    }
    AppMethodBeat.o(129835);
  }
  
  private void evM()
  {
    AppMethodBeat.i(129840);
    d.a locala = new d.a(this);
    locala.yf(false).aRI(String.format(getString(2131760039), new Object[] { Long.valueOf(10L) }));
    locala.acM(2131760035).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUP);
        AppMethodBeat.o(129806);
      }
    });
    locala.acN(2131760034).c(new DialogInterface.OnClickListener()
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
    locala.fvp().show();
    AppMethodBeat.o(129840);
  }
  
  private void evN()
  {
    AppMethodBeat.i(129841);
    new d.a(this).yf(true).acJ(2131760042).acM(2131760037).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).fvp().show();
    AppMethodBeat.o(129841);
  }
  
  private void evO()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131760041);; str = getString(2131760040))
    {
      new d.a(this).yf(false).aRI(str).acM(2131760038).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).acN(2131760036).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).fvp().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.BVq);
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
        paramPatternLockView.setDisplayMode(PatternLockView.b.BVr);
        a(String.format(getString(2131760047), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.evS();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.BUu = paramList;
      paramPatternLockView.evS();
      this.mStatus = 17;
      aK(2, true);
    }
    for (;;)
    {
      evJ();
      do
      {
        AppMethodBeat.o(129830);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129793);
              if (paramAnonymousInt2 == 0)
              {
                GestureGuardLogicUI.i(GestureGuardLogicUI.this);
                GestureGuardLogicUI.j(GestureGuardLogicUI.this);
                com.tencent.mm.plugin.walletlock.gesture.a.d.evH();
                com.tencent.mm.plugin.walletlock.gesture.a.d.evB();
                com.tencent.mm.plugin.walletlock.gesture.a.d.evD();
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
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.evF();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.evE();
          com.tencent.mm.plugin.report.service.h.wUl.f(11453, new Object[0]);
          c(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUO.evS();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.g.agi().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((cdk)localObject1);
          boolean bool4 = e.b((cdj)localObject2);
          if (bool4) {
            if (bool3) {
              if (((cdj)localObject2).version < ((cdk)localObject1).Fse) {
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            localObject1 = new b.a();
            ((b.a)localObject1).hvt = new bzo();
            ((b.a)localObject1).hvu = new bzp();
            ((b.a)localObject1).funcId = 689;
            ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((b.a)localObject1).aAz();
            localObject2 = (bzo)((com.tencent.mm.ak.b)localObject1).hvr.hvw;
            ((bzo)localObject2).CW = 2;
            ((bzo)localObject2).Foy = new SKBuiltinBuffer_t().setBuffer(e.gD(paramList));
            x.a((com.tencent.mm.ak.b)localObject1, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129797);
                ac.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((bzp)paramAnonymousb.hvs.hvw).FoA);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new gd();
                  ((gd)localObject).dNx = 8L;
                  ((gd)localObject).ebp = 2L;
                  ((gd)localObject).aHZ();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new gd();
                    ((gd)localObject).dNx = 10L;
                    ((gd)localObject).ebp = 2L;
                    ((gd)localObject).aHZ();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new gd();
                      ((gd)localObject).dNx = 5L;
                      ((gd)localObject).ebp = 2L;
                      ((gd)localObject).aHZ();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new gd();
                      ((gd)localObject).dNx = 4L;
                      ((gd)localObject).ebp = 2L;
                      ((gd)localObject).aHZ();
                    }
                    else
                    {
                      localObject = new gd();
                      ((gd)localObject).dNx = 5L;
                      ((gd)localObject).ebp = 2L;
                      ((gd)localObject).aHZ();
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
          aLi();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.evE();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((cdj)localObject1).Fsb.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.gD(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.BUu.equals(paramList))
      {
        paramPatternLockView.evS();
        this.BUw = false;
        this.BUx = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.evH();
        com.tencent.mm.plugin.walletlock.gesture.a.d.evB();
        com.tencent.mm.plugin.walletlock.gesture.a.d.evD();
        com.tencent.mm.plugin.walletlock.gesture.a.d.evp();
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
    this.BUt = AnimationUtils.loadAnimation(this, 2130772127);
    this.BUp = getResources().getColor(2131100711);
    this.BUq = getResources().getColor(2131100800);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      aK(1, false);
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
      ac.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      evJ();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.evz()) {
      this.BUw = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      aK(0, false);
      break;
      this.BUw = false;
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
        ac.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
        AppMethodBeat.o(129824);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.mToken = paramIntent.getStringExtra("key_token");
        this.BUA = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.BUE = true;
          }
          this.BUD = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          aK(1, false);
        }
        for (;;)
        {
          evJ();
          AppMethodBeat.o(129824);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            final x.a local12 = new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129802);
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.evH();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.evB();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.evD();
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
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].BUO.evS();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.g.agi().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              aLi();
              local12.a(3, -6, getString(2131760045), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).hvt = new cnt();
              ((b.a)localObject).hvu = new cnu();
              ((b.a)localObject).funcId = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).aAz();
              cnt localcnt = (cnt)((com.tencent.mm.ak.b)localObject).hvr.hvw;
              localcnt.FAT = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localcnt.CW = 3;
              x.a((com.tencent.mm.ak.b)localObject, new x.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
                {
                  AppMethodBeat.i(129804);
                  ac.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cnu)paramAnonymousb.hvs.hvw).FoA);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
                    com.tencent.mm.plugin.walletlock.c.g.tW(false);
                    GestureGuardLogicUI.evP();
                  }
                  i.BVK.ewe();
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
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
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
    if ((!ai.getPackageName().equals(paramBundle.getPackage())) || (bs.isNullOrNil(paramBundle.getStringExtra("action"))) || (bs.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      ac.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(129820);
      return;
    }
    this.BUB = new ViewFlipper(this);
    this.BUs = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.BUs;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.BUB.addView(localObject.mView);
      localObject.BUO.setOnPatternListener(this);
      localObject.BUP.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.BUB);
    this.mToken = getIntent().getStringExtra("token");
    this.BUA = getIntent().getStringExtra("type");
    this.BUF = getIntent().getStringExtra("verify_title");
    this.BUg = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.ewb();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.BUy != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.BUy);
      this.BUy = null;
    }
    if (this.BUz != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.BUz);
      this.BUz = null;
    }
    if ((this.BUC != null) && (this.BUC.isShowing())) {
      this.BUC.dismiss();
    }
    if (this.BUB != null)
    {
      this.BUB.removeAllViews();
      this.BUB = null;
    }
    int i = 0;
    while (i < this.BUs.length)
    {
      a locala = this.BUs[i];
      locala.BUO.setOnClickListener(null);
      locala.BUP.setOnClickListener(null);
      locala.mView = null;
      locala.BUM = null;
      locala.BUN = null;
      locala.BUO = null;
      locala.BUP = null;
      this.BUs[i] = null;
      i += 1;
    }
    this.BUs = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (evI())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      I(0, 4, "user cancel when setting gesture");
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
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.evC();
      if (localg.BUn == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.BUo / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.ar(localg.BUn, localg.BUo);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.BUx = com.tencent.mm.plugin.walletlock.gesture.a.d.evG();
        if (this.BUx != -1) {}
      }
      else
      {
        this.BUx = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.evD();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    Object localObject = this.BUs[this.BUr];
    if (((a)localObject).BUO != null)
    {
      localObject = ((a)localObject).BUO;
      if ((!paramBoolean) || (this.BUw)) {
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