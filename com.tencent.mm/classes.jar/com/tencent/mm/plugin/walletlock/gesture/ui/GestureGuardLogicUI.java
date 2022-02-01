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
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI
  extends MMActivity
  implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a
{
  private ViewFlipper DMA;
  private Dialog DMB;
  private boolean DMC;
  private boolean DMD;
  private String DME;
  private int DMf;
  private int DMo;
  private int DMp;
  private int DMq;
  private a[] DMr;
  private Animation DMs;
  private List<f> DMt;
  private List<f> DMu;
  private boolean DMv;
  private int DMw;
  private n DMx;
  private n DMy;
  private String DMz;
  private aq mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.DMo = 0;
    this.DMp = 0;
    this.DMq = 0;
    this.DMr = null;
    this.DMs = null;
    this.DMt = null;
    this.DMu = null;
    this.DMv = false;
    this.DMw = 0;
    this.DMx = null;
    this.DMy = null;
    this.mToken = null;
    this.DMz = null;
    this.DMA = null;
    this.mHandler = new aq(Looper.getMainLooper());
    this.DMB = null;
    this.DMC = true;
    this.DMD = false;
    this.DMf = -1;
    AppMethodBeat.o(129819);
  }
  
  private void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129827);
    ae.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
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
    TextView localTextView = this.DMr[this.DMq].DML;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.DMp);
    localTextView.startAnimation(this.DMs);
    this.DMs.setAnimationListener(new Animation.AnimationListener()
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMN.eNG();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.ajj().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      aOP();
      parama.a(3, -6, getString(2131760045), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ctq();
    ((b.a)localObject).hQG = new ctr();
    ((b.a)localObject).funcId = 688;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((b.a)localObject).aDS();
    ctq localctq = (ctq)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localctq.HEG = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localctq.HEH = new SKBuiltinBuffer_t().setBuffer(e.gZ(paramList));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129795);
        ae.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((ctr)paramAnonymousb.hQE.hQJ).HrN);
          GestureGuardLogicUI.eND();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).Wt(1);
        }
        i.DNJ.eNS();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMN.eNG();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.ajj().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cez();
    ((b.a)localObject).hQG = new cfa();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aDS();
    cez localcez = (cez)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localcez.EN = 3;
    localcez.HrL = new SKBuiltinBuffer_t().setBuffer(e.gZ(paramList));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129801);
        ae.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cfa)paramAnonymousb.hQE.hQJ).HrN);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.DNF;
          com.tencent.mm.plugin.walletlock.c.g.uO(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.eND();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMN.eNG();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.ajj().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((b.a)localObject).hQF = new cez();
    ((b.a)localObject).hQG = new cfa();
    ((b.a)localObject).funcId = 689;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((b.a)localObject).aDS();
    cez localcez = (cez)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localcez.EN = 1;
    localcez.HrL = new SKBuiltinBuffer_t().setBuffer(e.gZ(paramList1));
    localcez.HrM = new SKBuiltinBuffer_t().setBuffer(e.gZ(paramList2));
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(129799);
        ae.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cfa)paramAnonymousb.hQE.hQJ).HrN);
          GestureGuardLogicUI.eND();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new hi();
          ((hi)localObject).eeh = 8L;
          ((hi)localObject).etC = 2L;
          ((hi)localObject).aLH();
        }
        for (;;)
        {
          i.DNJ.eNS();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new hi();
            ((hi)localObject).eeh = 10L;
            ((hi)localObject).etC = 2L;
            ((hi)localObject).aLH();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new hi();
              ((hi)localObject).eeh = 5L;
              ((hi)localObject).etC = 2L;
              ((hi)localObject).aLH();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new hi();
              ((hi)localObject).eeh = 4L;
              ((hi)localObject).etC = 2L;
              ((hi)localObject).aLH();
            }
            else
            {
              localObject = new hi();
              ((hi)localObject).eeh = 5L;
              ((hi)localObject).etC = 2L;
              ((hi)localObject).aLH();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void aOP()
  {
    AppMethodBeat.i(129844);
    if ((this.DMB != null) && (this.DMB.isShowing())) {
      this.DMB.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void aX(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.DMq;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.DMq = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.DMA.setInAnimation(this, 2130772144);
        this.DMA.setOutAnimation(this, 2130772141);
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
        this.DMA.showNext();
        paramInt += 1;
      }
      this.DMA.setInAnimation(this, 2130772140);
      this.DMA.setOutAnimation(this, 2130772145);
      continue;
      this.DMA.setInAnimation(null);
      this.DMA.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.DMA.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.DMB == null)
    {
      this.DMB = com.tencent.mm.ui.base.h.b(this, getString(2131760048), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.DMB.show();
    AppMethodBeat.o(129843);
  }
  
  private void eNA()
  {
    AppMethodBeat.i(129840);
    d.a locala = new d.a(this);
    locala.zf(false).aZi(String.format(getString(2131760039), new Object[] { Long.valueOf(10L) }));
    locala.afU(2131760035).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMO);
        AppMethodBeat.o(129806);
      }
    });
    locala.afV(2131760034).d(new DialogInterface.OnClickListener()
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
    locala.fQv().show();
    AppMethodBeat.o(129840);
  }
  
  private void eNB()
  {
    AppMethodBeat.i(129841);
    new d.a(this).zf(true).afR(2131760042).afU(2131760037).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).fQv().show();
    AppMethodBeat.o(129841);
  }
  
  private void eNC()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131760041);; str = getString(2131760040))
    {
      new d.a(this).zf(false).aZi(str).afU(2131760038).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).afV(2131760036).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).fQv().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  private boolean eNw()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.DMC) {
        eNC();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        eNB();
      }
    }
    eNz();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void eNx()
  {
    AppMethodBeat.i(129829);
    if (this.DMr == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.DMr[this.DMq];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(2131760057));
      setMMTitle(getString(2131760058));
      if (this.DMf == 1)
      {
        localObject2 = new hi();
        ((hi)localObject2).eeh = 8L;
        ((hi)localObject2).etC = 1L;
        ((hi)localObject2).aLH();
      }
      long l;
      for (;;)
      {
        this.DMv = true;
        ((a)localObject1).DMN.setEnableInput(false);
        ((a)localObject1).DMN.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.eNo().DMn / 1000L) / 60.0D);
        ((a)localObject1).DML.setText(String.format(getString(2131760050), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).DML.setTextColor(getResources().getColor(2131100800));
        AppMethodBeat.o(129829);
        return;
        if (this.DMf == 2)
        {
          localObject2 = new hi();
          ((hi)localObject2).eeh = 10L;
          ((hi)localObject2).etC = 1L;
          ((hi)localObject2).aLH();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131760058));
        localObject2 = new hi();
        ((hi)localObject2).eeh = 5L;
        ((hi)localObject2).etC = 1L;
        ((hi)localObject2).aLH();
      }
      for (;;)
      {
        this.DMv = false;
        ((a)localObject1).DMN.setEnableInput(true);
        ((a)localObject1).DMN.setOnPatternListener(this);
        ((a)localObject1).DML.setText(getString(2131760054));
        ((a)localObject1).DML.setTextColor(getResources().getColor(2131100711));
        if (((a)localObject1).DMO.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).DMO.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131760059));
          localObject2 = new hi();
          ((hi)localObject2).eeh = 4L;
          ((hi)localObject2).etC = 1L;
          ((hi)localObject2).aLH();
        }
        else
        {
          setMMTitle(getString(2131760058));
          localObject2 = new hi();
          ((hi)localObject2).eeh = 5L;
          ((hi)localObject2).etC = 1L;
          ((hi)localObject2).aLH();
        }
      }
      ((a)localObject1).DML.setText(getResources().getString(2131760052));
      ((a)localObject1).DML.setTextColor(this.DMo);
      ((a)localObject1).DMN.eNG();
      ((a)localObject1).DMN.setEnableInput(true);
      if (((a)localObject1).DMO.getVisibility() != 8)
      {
        ((a)localObject1).DMO.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.DMD)
          {
            this.DMD = false;
            a(this.mToken, this.DMt, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131760063), 0).show();
                  com.tencent.mm.plugin.report.service.g.yxI.f(11474, new Object[0]);
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
          a(this.DMu, this.DMt, new x.a()
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
          a(this.mToken, this.DMt, new x.a()
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
          a(this.mToken, this.DMt, new x.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.CG(SystemClock.elapsedRealtime());
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
          ((a)localObject1).DMN.setEnableInput(false);
          ((a)localObject1).DMN.setDisplayMode(PatternLockView.b.DNq);
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
                  GestureGuardLogicUI.25.this.DMJ.DMN.eNG();
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
          this.DMv = false;
          ((a)localObject1).DMN.setEnableInput(true);
          ((a)localObject1).DMN.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!bu.isNullOrNil(this.DME)) {
              ((a)localObject1).DML.setText(this.DME);
            }
          }
          for (;;)
          {
            ((a)localObject1).DML.setTextColor(this.DMo);
            if (((a)localObject1).DMO.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).DMO.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).DML.setText(getString(2131760056));
            continue;
            ((a)localObject1).DML.setText(getString(2131760055));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).DMN.eNG();
            aX(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.DMu, new x.a()
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
            com.tencent.mm.plugin.walletlock.gesture.a.d.CG(SystemClock.elapsedRealtime());
            eNy();
            com.tencent.mm.plugin.walletlock.c.h.aB(this.DMf, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.av(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.Wv(this.DMw);
            com.tencent.mm.plugin.walletlock.gesture.a.d.eNd();
            if (this.DMw == 5)
            {
              this.DMv = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.au(l, 0L);
              ((a)localObject1).DMN.eNG();
              ((a)localObject1).DMN.setEnableInput(false);
              this.mStatus = 20;
              eNx();
              eNA();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              ae.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.DMw != 5) {
                break label1275;
              }
              com.tencent.mm.plugin.walletlock.c.h.aB(this.DMf, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).DMN.setEnableInput(false);
              ((a)localObject1).DMN.setDisplayMode(PatternLockView.b.DNq);
              a(String.format(getResources().getString(2131760046), new Object[] { Integer.valueOf(5 - this.DMw) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.DMJ.DMN.eNG();
                  this.DMJ.DMN.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1275:
            com.tencent.mm.plugin.walletlock.c.h.aB(this.DMf, 1, 1);
          }
        }
      }
    }
  }
  
  private void eNy()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.DNJ.uS(true);
      i.DNJ.uT(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(129834);
      return;
      ae.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void eNz()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.DNJ.eNT();
    }
    AppMethodBeat.o(129835);
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.DNp);
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
        paramPatternLockView.setDisplayMode(PatternLockView.b.DNq);
        a(String.format(getString(2131760047), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.eNG();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.DMt = paramList;
      paramPatternLockView.eNG();
      this.mStatus = 17;
      aX(2, true);
    }
    for (;;)
    {
      eNx();
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
                com.tencent.mm.plugin.walletlock.gesture.a.d.eNv();
                com.tencent.mm.plugin.walletlock.gesture.a.d.eNp();
                com.tencent.mm.plugin.walletlock.gesture.a.d.eNr();
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
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.eNt();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.eNs();
          com.tencent.mm.plugin.report.service.g.yxI.f(11453, new Object[0]);
          c(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMN.eNG();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.g.ajj().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((cjd)localObject1);
          boolean bool4 = e.b((cjc)localObject2);
          if (bool4) {
            if (bool3) {
              if (((cjc)localObject2).version < ((cjd)localObject1).HvK) {
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            localObject1 = new b.a();
            ((b.a)localObject1).hQF = new cez();
            ((b.a)localObject1).hQG = new cfa();
            ((b.a)localObject1).funcId = 689;
            ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((b.a)localObject1).aDS();
            localObject2 = (cez)((com.tencent.mm.ak.b)localObject1).hQD.hQJ;
            ((cez)localObject2).EN = 2;
            ((cez)localObject2).HrL = new SKBuiltinBuffer_t().setBuffer(e.gZ(paramList));
            x.a((com.tencent.mm.ak.b)localObject1, new x.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
              {
                AppMethodBeat.i(129797);
                ae.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cfa)paramAnonymousb.hQE.hQJ).HrN);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new hi();
                  ((hi)localObject).eeh = 8L;
                  ((hi)localObject).etC = 2L;
                  ((hi)localObject).aLH();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, paramAnonymousn);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new hi();
                    ((hi)localObject).eeh = 10L;
                    ((hi)localObject).etC = 2L;
                    ((hi)localObject).aLH();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new hi();
                      ((hi)localObject).eeh = 5L;
                      ((hi)localObject).etC = 2L;
                      ((hi)localObject).aLH();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new hi();
                      ((hi)localObject).eeh = 4L;
                      ((hi)localObject).etC = 2L;
                      ((hi)localObject).aLH();
                    }
                    else
                    {
                      localObject = new hi();
                      ((hi)localObject).eeh = 5L;
                      ((hi)localObject).etC = 2L;
                      ((hi)localObject).aLH();
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
          aOP();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.eNs();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((cjc)localObject1).HvH.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.gZ(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.DMt.equals(paramList))
      {
        paramPatternLockView.eNG();
        this.DMv = false;
        this.DMw = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.eNv();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eNp();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eNr();
        com.tencent.mm.plugin.walletlock.gesture.a.d.eNd();
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
    this.DMs = AnimationUtils.loadAnimation(this, 2130772127);
    this.DMo = getResources().getColor(2131100711);
    this.DMp = getResources().getColor(2131100800);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      aX(1, false);
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
      ae.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[] { Integer.valueOf(this.mStatus) }));
      eNx();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.eNn()) {
      this.DMv = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      aX(0, false);
      break;
      this.DMv = false;
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
        ae.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
        AppMethodBeat.o(129824);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      if (paramInt1 == 0)
      {
        this.mToken = paramIntent.getStringExtra("key_token");
        this.DMz = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.DMD = true;
          }
          this.DMC = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          aX(1, false);
        }
        for (;;)
        {
          eNx();
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
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eNv();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eNp();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.eNr();
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
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].DMN.eNG();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.g.ajj().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              aOP();
              local12.a(3, -6, getString(2131760045), null, null);
            }
            else
            {
              Object localObject = new b.a();
              ((b.a)localObject).hQF = new ctq();
              ((b.a)localObject).hQG = new ctr();
              ((b.a)localObject).funcId = 688;
              ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((b.a)localObject).aDS();
              ctq localctq = (ctq)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
              localctq.HEG = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localctq.EN = 3;
              x.a((com.tencent.mm.ak.b)localObject, new x.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
                {
                  AppMethodBeat.i(129804);
                  ae.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((ctr)paramAnonymousb.hQE.hQJ).HrN);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.DNF;
                    com.tencent.mm.plugin.walletlock.c.g.uO(false);
                    GestureGuardLogicUI.eND();
                  }
                  i.DNJ.eNS();
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131306126)
    {
      paramView = new Intent();
      paramView.putExtra("action", "action.verify_paypwd");
      paramView.putExtra("key_wallet_lock_type", 1);
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", paramView, 1001);
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
    if ((!ak.getPackageName().equals(paramBundle.getPackage())) || (bu.isNullOrNil(paramBundle.getStringExtra("action"))) || (bu.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      ae.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(129820);
      return;
    }
    this.DMA = new ViewFlipper(this);
    this.DMr = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.DMr;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.DMA.addView(localObject.mView);
      localObject.DMN.setOnPatternListener(this);
      localObject.DMO.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.DMA);
    this.mToken = getIntent().getStringExtra("token");
    this.DMz = getIntent().getStringExtra("type");
    this.DME = getIntent().getStringExtra("verify_title");
    this.DMf = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.eNP();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.DMx != null)
    {
      com.tencent.mm.kernel.g.ajj().a(this.DMx);
      this.DMx = null;
    }
    if (this.DMy != null)
    {
      com.tencent.mm.kernel.g.ajj().a(this.DMy);
      this.DMy = null;
    }
    if ((this.DMB != null) && (this.DMB.isShowing())) {
      this.DMB.dismiss();
    }
    if (this.DMA != null)
    {
      this.DMA.removeAllViews();
      this.DMA = null;
    }
    int i = 0;
    while (i < this.DMr.length)
    {
      a locala = this.DMr[i];
      locala.DMN.setOnClickListener(null);
      locala.DMO.setOnClickListener(null);
      locala.mView = null;
      locala.DML = null;
      locala.DMM = null;
      locala.DMN = null;
      locala.DMO = null;
      this.DMr[i] = null;
      i += 1;
    }
    this.DMr = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (eNw())
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
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.eNq();
      if (localg.DMm == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.DMn / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.av(localg.DMm, localg.DMn);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.DMw = com.tencent.mm.plugin.walletlock.gesture.a.d.eNu();
        if (this.DMw != -1) {}
      }
      else
      {
        this.DMw = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.eNr();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    AppMethodBeat.at(this, paramBoolean);
    Object localObject = this.DMr[this.DMq];
    if (((a)localObject).DMN != null)
    {
      localObject = ((a)localObject).DMN;
      if ((!paramBoolean) || (this.DMv)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */