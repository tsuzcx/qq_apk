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
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmh;
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
  private int IvD;
  private int IvE;
  private int IvF;
  private a[] IvG;
  private Animation IvH;
  private List<f> IvI;
  private List<f> IvJ;
  private boolean IvK;
  private int IvL;
  private q IvM;
  private q IvN;
  private String IvO;
  private ViewFlipper IvP;
  private Dialog IvQ;
  private boolean IvR;
  private boolean IvS;
  private String IvT;
  private int Ivu;
  private MMHandler mHandler;
  private int mStatus;
  private String mToken;
  
  public GestureGuardLogicUI()
  {
    AppMethodBeat.i(129819);
    this.IvD = 0;
    this.IvE = 0;
    this.IvF = 0;
    this.IvG = null;
    this.IvH = null;
    this.IvI = null;
    this.IvJ = null;
    this.IvK = false;
    this.IvL = 0;
    this.IvM = null;
    this.IvN = null;
    this.mToken = null;
    this.IvO = null;
    this.IvP = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.IvQ = null;
    this.IvR = true;
    this.IvS = false;
    this.Ivu = -1;
    AppMethodBeat.o(129819);
  }
  
  private void M(int paramInt1, int paramInt2, String paramString)
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
    TextView localTextView = this.IvG[this.IvF].Iwa;
    localTextView.getText().toString();
    localTextView.setText(paramString);
    localTextView.setTextColor(this.IvE);
    localTextView.startAnimation(this.IvH);
    this.IvH.setAnimationListener(new Animation.AnimationListener()
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwc.fVp();
        if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.azz().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129794);
      }
    });
    if (paramString == null)
    {
      biW();
      parama.a(3, -6, getString(2131761423), null, null);
      AppMethodBeat.o(129831);
      return;
    }
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).iLN = new dmg();
    ((com.tencent.mm.ak.d.a)localObject).iLO = new dmh();
    ((com.tencent.mm.ak.d.a)localObject).funcId = 688;
    ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
    localObject = ((com.tencent.mm.ak.d.a)localObject).aXF();
    dmg localdmg = (dmg)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localdmg.MPO = new SKBuiltinBuffer_t().setBuffer(paramString.getBytes());
    localdmg.MPP = new SKBuiltinBuffer_t().setBuffer(e.jdMethod_if(paramList));
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129795);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dmh)paramAnonymousd.iLL.iLR).MAJ);
          GestureGuardLogicUI.fVm();
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(1);
        }
        i.IwY.fVB();
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
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwc.fVp();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.azz().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129800);
      }
    });
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).iLN = new cvg();
    ((com.tencent.mm.ak.d.a)localObject).iLO = new cvh();
    ((com.tencent.mm.ak.d.a)localObject).funcId = 689;
    ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((com.tencent.mm.ak.d.a)localObject).aXF();
    cvg localcvg = (cvg)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localcvg.EX = 3;
    localcvg.MAH = new SKBuiltinBuffer_t().setBuffer(e.jdMethod_if(paramList));
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129801);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh)paramAnonymousd.iLL.iLR).MAJ);
          com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
          com.tencent.mm.plugin.walletlock.c.g.yD(false);
          GestureGuardLogicUI.i(GestureGuardLogicUI.this);
          GestureGuardLogicUI.fVm();
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
    Object localObject = new com.tencent.mm.ak.d.a();
    d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(129798);
        GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwc.fVp();
        if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
          com.tencent.mm.kernel.g.azz().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
        }
        AppMethodBeat.o(129798);
      }
    });
    ((com.tencent.mm.ak.d.a)localObject).iLN = new cvg();
    ((com.tencent.mm.ak.d.a)localObject).iLO = new cvh();
    ((com.tencent.mm.ak.d.a)localObject).funcId = 689;
    ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/oppatternlock";
    localObject = ((com.tencent.mm.ak.d.a)localObject).aXF();
    cvg localcvg = (cvg)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localcvg.EX = 1;
    localcvg.MAH = new SKBuiltinBuffer_t().setBuffer(e.jdMethod_if(paramList1));
    localcvg.MAI = new SKBuiltinBuffer_t().setBuffer(e.jdMethod_if(paramList2));
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(129799);
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
        Object localObject;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh)paramAnonymousd.iLL.iLR).MAJ);
          GestureGuardLogicUI.fVm();
          if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
            break label206;
          }
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
            break label161;
          }
          localObject = new kz();
          ((kz)localObject).eEH = 8L;
          ((kz)localObject).eXI = 2L;
          ((kz)localObject).bfK();
        }
        for (;;)
        {
          i.IwY.fVB();
          if (parama == null) {
            break;
          }
          paramAnonymousInt1 = parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
          AppMethodBeat.o(129799);
          return paramAnonymousInt1;
          label161:
          if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
          {
            localObject = new kz();
            ((kz)localObject).eEH = 10L;
            ((kz)localObject).eXI = 2L;
            ((kz)localObject).bfK();
            continue;
            label206:
            localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
            if ("next_action.modify_pattern".equals(localObject))
            {
              localObject = new kz();
              ((kz)localObject).eEH = 5L;
              ((kz)localObject).eXI = 2L;
              ((kz)localObject).bfK();
            }
            else if ("next_action.switch_on_pattern".equals(localObject))
            {
              localObject = new kz();
              ((kz)localObject).eEH = 4L;
              ((kz)localObject).eXI = 2L;
              ((kz)localObject).bfK();
            }
            else
            {
              localObject = new kz();
              ((kz)localObject).eEH = 5L;
              ((kz)localObject).eXI = 2L;
              ((kz)localObject).bfK();
            }
          }
        }
        AppMethodBeat.o(129799);
        return 0;
      }
    }, false);
    AppMethodBeat.o(129832);
  }
  
  private void biW()
  {
    AppMethodBeat.i(129844);
    if ((this.IvQ != null) && (this.IvQ.isShowing())) {
      this.IvQ.dismiss();
    }
    AppMethodBeat.o(129844);
  }
  
  private void bp(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129838);
    int i = paramInt - this.IvF;
    if (i == 0)
    {
      AppMethodBeat.o(129838);
      return;
    }
    this.IvF = paramInt;
    if (paramBoolean) {
      if (i > 0)
      {
        this.IvP.setInAnimation(this, 2130772169);
        this.IvP.setOutAnimation(this, 2130772166);
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
        this.IvP.showNext();
        paramInt += 1;
      }
      this.IvP.setInAnimation(this, 2130772165);
      this.IvP.setOutAnimation(this, 2130772170);
      continue;
      this.IvP.setInAnimation(null);
      this.IvP.setOutAnimation(null);
    }
    AppMethodBeat.o(129838);
    return;
    label137:
    while (paramInt < 0)
    {
      this.IvP.showPrevious();
      paramInt += 1;
    }
    AppMethodBeat.o(129838);
  }
  
  private void d(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(129843);
    if (this.IvQ == null)
    {
      this.IvQ = com.tencent.mm.ui.base.h.a(this, getString(2131761426), false, paramOnCancelListener);
      AppMethodBeat.o(129843);
      return;
    }
    this.IvQ.show();
    AppMethodBeat.o(129843);
  }
  
  private boolean fVf()
  {
    AppMethodBeat.i(129828);
    if ((this.mStatus != 20) && (this.mStatus != 0) && (this.mStatus != 2) && (this.mStatus != 1))
    {
      if (this.IvR) {
        fVl();
      }
      for (;;)
      {
        AppMethodBeat.o(129828);
        return true;
        fVk();
      }
    }
    fVi();
    AppMethodBeat.o(129828);
    return false;
  }
  
  private void fVg()
  {
    AppMethodBeat.i(129829);
    if (this.IvG == null)
    {
      AppMethodBeat.o(129829);
      return;
    }
    Object localObject1 = this.IvG[this.IvF];
    switch (this.mStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129829);
      return;
      setMMTitle(getString(2131761435));
      setMMTitle(getString(2131761436));
      if (this.Ivu == 1)
      {
        localObject2 = new kz();
        ((kz)localObject2).eEH = 8L;
        ((kz)localObject2).eXI = 1L;
        ((kz)localObject2).bfK();
      }
      long l;
      for (;;)
      {
        this.IvK = true;
        ((a)localObject1).Iwc.setEnableInput(false);
        ((a)localObject1).Iwc.setOnPatternListener(null);
        l = Math.ceil((600L - com.tencent.mm.plugin.walletlock.gesture.a.d.fUX().IvC / 1000L) / 60.0D);
        ((a)localObject1).Iwa.setText(String.format(getString(2131761428), new Object[] { Long.valueOf(l) }));
        ((a)localObject1).Iwa.setTextColor(getResources().getColor(2131100996));
        AppMethodBeat.o(129829);
        return;
        if (this.Ivu == 2)
        {
          localObject2 = new kz();
          ((kz)localObject2).eEH = 10L;
          ((kz)localObject2).eXI = 1L;
          ((kz)localObject2).bfK();
        }
      }
      Object localObject2 = getIntent().getStringExtra("next_action");
      if ("next_action.modify_pattern".equals(localObject2))
      {
        setMMTitle(getString(2131761436));
        localObject2 = new kz();
        ((kz)localObject2).eEH = 5L;
        ((kz)localObject2).eXI = 1L;
        ((kz)localObject2).bfK();
      }
      for (;;)
      {
        this.IvK = false;
        ((a)localObject1).Iwc.setEnableInput(true);
        ((a)localObject1).Iwc.setOnPatternListener(this);
        ((a)localObject1).Iwa.setText(getString(2131761432));
        ((a)localObject1).Iwa.setTextColor(getResources().getColor(2131100904));
        if (((a)localObject1).Iwd.getVisibility() == 8) {
          break;
        }
        ((a)localObject1).Iwd.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        if ("next_action.switch_on_pattern".equals(localObject2))
        {
          setMMTitle(getString(2131761437));
          localObject2 = new kz();
          ((kz)localObject2).eEH = 4L;
          ((kz)localObject2).eXI = 1L;
          ((kz)localObject2).bfK();
        }
        else
        {
          setMMTitle(getString(2131761436));
          localObject2 = new kz();
          ((kz)localObject2).eEH = 5L;
          ((kz)localObject2).eXI = 1L;
          ((kz)localObject2).bfK();
        }
      }
      ((a)localObject1).Iwa.setText(getResources().getString(2131761430));
      ((a)localObject1).Iwa.setTextColor(this.IvD);
      ((a)localObject1).Iwc.fVp();
      ((a)localObject1).Iwc.setEnableInput(true);
      if (((a)localObject1).Iwd.getVisibility() != 8)
      {
        ((a)localObject1).Iwd.setVisibility(8);
        AppMethodBeat.o(129829);
        return;
        localObject1 = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject1))
        {
          if (this.IvS)
          {
            this.IvS = false;
            a(this.mToken, this.IvI, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129811);
                if (paramAnonymousInt2 == 0)
                {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761441), 0).show();
                  com.tencent.mm.plugin.report.service.h.CyF.a(11474, new Object[0]);
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129811);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          a(this.IvJ, this.IvI, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129812);
              if (paramAnonymousInt2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761441), 0).show();
              }
              for (;;)
              {
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(129812);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.switch_on_pattern".equals(localObject1))
        {
          a(this.mToken, this.IvI, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129813);
              GestureGuardLogicUI.b(GestureGuardLogicUI.this);
              GestureGuardLogicUI.d(GestureGuardLogicUI.this);
              if (paramAnonymousInt2 == 0)
              {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761440), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
              }
              for (;;)
              {
                AppMethodBeat.o(129813);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
        }
        if ("next_action.goto_protected_page".equals(localObject1))
        {
          a(this.mToken, this.IvI, new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129814);
              if (paramAnonymousInt2 == 0)
              {
                com.tencent.mm.plugin.walletlock.gesture.a.d.LU(SystemClock.elapsedRealtime());
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761441), 0).show();
                GestureGuardLogicUI.e(GestureGuardLogicUI.this);
              }
              for (;;)
              {
                GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                GestureGuardLogicUI.d(GestureGuardLogicUI.this);
                AppMethodBeat.o(129814);
                return 0;
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
              }
            }
          });
          AppMethodBeat.o(129829);
          return;
          ((a)localObject1).Iwc.setEnableInput(false);
          ((a)localObject1).Iwc.setDisplayMode(PatternLockView.b.IwF);
          a(getResources().getString(2131761431), new a()
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
                  GestureGuardLogicUI.25.this.IvY.Iwc.fVp();
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
          this.IvK = false;
          ((a)localObject1).Iwc.setEnableInput(true);
          ((a)localObject1).Iwc.setOnPatternListener(this);
          if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            if (!Util.isNullOrNil(this.IvT)) {
              ((a)localObject1).Iwa.setText(this.IvT);
            }
          }
          for (;;)
          {
            ((a)localObject1).Iwa.setTextColor(this.IvD);
            if (((a)localObject1).Iwd.getVisibility() == 0) {
              break;
            }
            ((a)localObject1).Iwd.setVisibility(0);
            AppMethodBeat.o(129829);
            return;
            ((a)localObject1).Iwa.setText(getString(2131761434));
            continue;
            ((a)localObject1).Iwa.setText(getString(2131761433));
          }
          localObject2 = getIntent().getStringExtra("next_action");
          if ("next_action.modify_pattern".equals(localObject2))
          {
            ((a)localObject1).Iwc.fVp();
            bp(1, true);
            this.mStatus = 16;
            break;
          }
          if ("next_action.switch_off_pattern".equals(localObject2))
          {
            a(this.IvJ, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129817);
                if (paramAnonymousInt2 == 0) {
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761439), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, null);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129817);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
                }
              }
            });
            AppMethodBeat.o(129829);
            return;
          }
          if ("next_action.goto_protected_page".equals(localObject2))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.d.LU(SystemClock.elapsedRealtime());
            fVh();
            com.tencent.mm.plugin.walletlock.c.h.aJ(this.Ivu, 1, 0);
            AppMethodBeat.o(129829);
            return;
            l = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.walletlock.gesture.a.d.aC(l, 0L);
            com.tencent.mm.plugin.walletlock.gesture.a.d.afb(this.IvL);
            com.tencent.mm.plugin.walletlock.gesture.a.d.fUM();
            if (this.IvL == 5)
            {
              this.IvK = true;
              com.tencent.mm.plugin.walletlock.gesture.a.d.aB(l, 0L);
              ((a)localObject1).Iwc.fVp();
              ((a)localObject1).Iwc.setEnableInput(false);
              this.mStatus = 20;
              fVg();
              fVj();
            }
            for (;;)
            {
              localObject1 = getIntent().getStringExtra("next_action");
              Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[] { localObject1 });
              if (!"next_action.goto_protected_page".equals(localObject1)) {
                break;
              }
              if (this.IvL != 5) {
                break label1275;
              }
              com.tencent.mm.plugin.walletlock.c.h.aJ(this.Ivu, 1, 2);
              AppMethodBeat.o(129829);
              return;
              ((a)localObject1).Iwc.setEnableInput(false);
              ((a)localObject1).Iwc.setDisplayMode(PatternLockView.b.IwF);
              a(String.format(getResources().getString(2131761424), new Object[] { Integer.valueOf(5 - this.IvL) }), new a()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(129818);
                  GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0);
                  this.IvY.Iwc.fVp();
                  this.IvY.Iwc.setEnableInput(true);
                  AppMethodBeat.o(129818);
                }
              });
            }
            label1275:
            com.tencent.mm.plugin.walletlock.c.h.aJ(this.Ivu, 1, 1);
          }
        }
      }
    }
  }
  
  private void fVh()
  {
    AppMethodBeat.i(129834);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      i.IwY.yH(true);
      i.IwY.yI(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(129834);
      return;
      Log.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
    }
  }
  
  private void fVi()
  {
    AppMethodBeat.i(129835);
    String str = getIntent().getStringExtra("next_action");
    if ((this.mStatus == 20) || ("next_action.goto_protected_page".equals(str))) {
      i.IwY.fVC();
    }
    AppMethodBeat.o(129835);
  }
  
  private void fVj()
  {
    AppMethodBeat.i(129840);
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    locala.Dk(false).boo(String.format(getString(2131761417), new Object[] { Long.valueOf(10L) }));
    locala.aoV(2131761413).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129806);
        paramAnonymousDialogInterface.dismiss();
        GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwd);
        AppMethodBeat.o(129806);
      }
    });
    locala.aoW(2131761412).d(new DialogInterface.OnClickListener()
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
    locala.hbn().show();
    AppMethodBeat.o(129840);
  }
  
  private void fVk()
  {
    AppMethodBeat.i(129841);
    new com.tencent.mm.ui.widget.a.d.a(this).Dk(true).aoS(2131761420).aoV(2131761415).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129808);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(129808);
      }
    }).hbn().show();
    AppMethodBeat.o(129841);
  }
  
  private void fVl()
  {
    AppMethodBeat.i(129842);
    String str = getIntent().getStringExtra("next_action");
    if ((!"next_action.modify_pattern".equals(str)) && ("next_action.switch_on_pattern".equals(str))) {}
    for (str = getString(2131761419);; str = getString(2131761418))
    {
      new com.tencent.mm.ui.widget.a.d.a(this).Dk(false).boo(str).aoV(2131761416).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129810);
          paramAnonymousDialogInterface.dismiss();
          GestureGuardLogicUI.t(GestureGuardLogicUI.this);
          GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
          AppMethodBeat.o(129810);
        }
      }).aoW(2131761414).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129809);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(129809);
        }
      }).hbn().show();
      AppMethodBeat.o(129842);
      return;
    }
  }
  
  public final void a(PatternLockView paramPatternLockView)
  {
    AppMethodBeat.i(129837);
    paramPatternLockView.setDisplayMode(PatternLockView.b.IwE);
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
        paramPatternLockView.setDisplayMode(PatternLockView.b.IwF);
        a(String.format(getString(2131761425), new Object[] { Integer.valueOf(4) }), new a()
        {
          public final void onDone()
          {
            AppMethodBeat.i(129792);
            paramPatternLockView.fVp();
            paramPatternLockView.setEnableInput(true);
            AppMethodBeat.o(129792);
          }
        });
        AppMethodBeat.o(129830);
        return;
      }
      this.IvI = paramList;
      paramPatternLockView.fVp();
      this.mStatus = 17;
      bp(2, true);
    }
    for (;;)
    {
      fVg();
      do
      {
        AppMethodBeat.o(129830);
        return;
        if (this.mStatus == 0)
        {
          paramPatternLockView = new aa.a()
          {
            public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
            {
              AppMethodBeat.i(129793);
              if (paramAnonymousInt2 == 0)
              {
                GestureGuardLogicUI.i(GestureGuardLogicUI.this);
                GestureGuardLogicUI.j(GestureGuardLogicUI.this);
                com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
                com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
                com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
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
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761422), 0).show();
                }
              }
            }
          };
          Object localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.fVc();
          Object localObject2 = com.tencent.mm.plugin.walletlock.gesture.a.d.fVb();
          com.tencent.mm.plugin.report.service.h.CyF.a(11453, new Object[0]);
          d(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(129796);
              GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwc.fVp();
              if ((GestureGuardLogicUI.p(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.p(GestureGuardLogicUI.this).isCanceled())) {
                com.tencent.mm.kernel.g.azz().a(GestureGuardLogicUI.p(GestureGuardLogicUI.this));
              }
              AppMethodBeat.o(129796);
            }
          });
          boolean bool3 = e.b((czl)localObject1);
          boolean bool4 = e.b((czk)localObject2);
          if (bool4) {
            if (bool3) {
              if (((czk)localObject2).version < ((czl)localObject1).MEJ) {
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
            localObject1 = new com.tencent.mm.ak.d.a();
            ((com.tencent.mm.ak.d.a)localObject1).iLN = new cvg();
            ((com.tencent.mm.ak.d.a)localObject1).iLO = new cvh();
            ((com.tencent.mm.ak.d.a)localObject1).funcId = 689;
            ((com.tencent.mm.ak.d.a)localObject1).uri = "/cgi-bin/micromsg-bin/oppatternlock";
            localObject1 = ((com.tencent.mm.ak.d.a)localObject1).aXF();
            localObject2 = (cvg)((com.tencent.mm.ak.d)localObject1).iLK.iLR;
            ((cvg)localObject2).EX = 2;
            ((cvg)localObject2).MAH = new SKBuiltinBuffer_t().setBuffer(e.jdMethod_if(paramList));
            aa.a((com.tencent.mm.ak.d)localObject1, new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129797);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                Object localObject;
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh)paramAnonymousd.iLL.iLR).MAJ);
                  if (GestureGuardLogicUI.q(GestureGuardLogicUI.this) != 0) {
                    break label197;
                  }
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) != 1) {
                    break label152;
                  }
                  localObject = new kz();
                  ((kz)localObject).eEH = 8L;
                  ((kz)localObject).eXI = 2L;
                  ((kz)localObject).bfK();
                }
                while (paramPatternLockView != null)
                {
                  paramAnonymousInt1 = paramPatternLockView.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, paramAnonymousq);
                  AppMethodBeat.o(129797);
                  return paramAnonymousInt1;
                  label152:
                  if (GestureGuardLogicUI.r(GestureGuardLogicUI.this) == 2)
                  {
                    localObject = new kz();
                    ((kz)localObject).eEH = 10L;
                    ((kz)localObject).eXI = 2L;
                    ((kz)localObject).bfK();
                    continue;
                    label197:
                    localObject = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(localObject))
                    {
                      localObject = new kz();
                      ((kz)localObject).eEH = 5L;
                      ((kz)localObject).eXI = 2L;
                      ((kz)localObject).bfK();
                    }
                    else if ("next_action.switch_on_pattern".equals(localObject))
                    {
                      localObject = new kz();
                      ((kz)localObject).eEH = 4L;
                      ((kz)localObject).eXI = 2L;
                      ((kz)localObject).bfK();
                    }
                    else
                    {
                      localObject = new kz();
                      ((kz)localObject).eEH = 5L;
                      ((kz)localObject).eXI = 2L;
                      ((kz)localObject).bfK();
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
          biW();
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.d.fVb();
          if (localObject1 == null) {}
          for (boolean bool1 = bool2; bool1; bool1 = new String(((czk)localObject1).MEG.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject2).toString().getBytes())))
          {
            paramPatternLockView.a(3, 0, null, null, null);
            AppMethodBeat.o(129830);
            return;
            localObject2 = new StringBuilder();
            com.tencent.mm.kernel.g.aAf();
            ((StringBuilder)localObject2).append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(new String(e.jdMethod_if(paramList)));
          }
          paramPatternLockView.a(3, -3, null, null, null);
          AppMethodBeat.o(129830);
          return;
        }
      } while (this.mStatus != 17);
      if (this.IvI.equals(paramList))
      {
        paramPatternLockView.fVp();
        this.IvK = false;
        this.IvL = 0;
        com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
        com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
        com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
        com.tencent.mm.plugin.walletlock.gesture.a.d.fUM();
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
    setActionbarColor(getResources().getColor(2131101424));
    setMMSubTitle(2131768658);
    this.IvH = AnimationUtils.loadAnimation(this, 2130772151);
    this.IvD = getResources().getColor(2131100904);
    this.IvE = getResources().getColor(2131100996);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("action");
    localIntent.getStringExtra("next_action");
    if ("action.switch_on_pattern".equals(str))
    {
      this.mStatus = 16;
      bp(1, false);
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
      fVg();
      AppMethodBeat.o(129823);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.gesture.a.b.fUW()) {
      this.IvK = true;
    }
    for (this.mStatus = 20;; this.mStatus = 0)
    {
      bp(0, false);
      break;
      this.IvK = false;
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
        this.IvO = paramIntent.getStringExtra("key_type");
        paramIntent = getIntent().getStringExtra("next_action");
        if (("next_action.goto_protected_page".equals(paramIntent)) || ("next_action.modify_pattern".equals(paramIntent)))
        {
          if ("next_action.modify_pattern".equals(paramIntent)) {
            this.IvS = true;
          }
          this.IvR = false;
          setBackBtn(null);
          setBackBtnVisible(false);
          this.mStatus = 16;
          bp(1, false);
        }
        for (;;)
        {
          fVg();
          AppMethodBeat.o(129824);
          return;
          if ("next_action.switch_off_pattern".equals(paramIntent))
          {
            paramIntent = this.mToken;
            final aa.a local12 = new aa.a()
            {
              public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
              {
                AppMethodBeat.i(129802);
                if (paramAnonymousInt2 == 0)
                {
                  com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
                  com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761439), 0).show();
                }
                for (;;)
                {
                  GestureGuardLogicUI.b(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.c(GestureGuardLogicUI.this);
                  GestureGuardLogicUI.this.finish();
                  AppMethodBeat.o(129802);
                  return 0;
                  Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(2131761421), 0).show();
                }
              }
            };
            d(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(129803);
                GestureGuardLogicUI.l(GestureGuardLogicUI.this)[GestureGuardLogicUI.m(GestureGuardLogicUI.this)].Iwc.fVp();
                if ((GestureGuardLogicUI.n(GestureGuardLogicUI.this) != null) && (!GestureGuardLogicUI.n(GestureGuardLogicUI.this).isCanceled())) {
                  com.tencent.mm.kernel.g.azz().a(GestureGuardLogicUI.n(GestureGuardLogicUI.this));
                }
                AppMethodBeat.o(129803);
              }
            });
            if (paramIntent == null)
            {
              biW();
              local12.a(3, -6, getString(2131761423), null, null);
            }
            else
            {
              Object localObject = new com.tencent.mm.ak.d.a();
              ((com.tencent.mm.ak.d.a)localObject).iLN = new dmg();
              ((com.tencent.mm.ak.d.a)localObject).iLO = new dmh();
              ((com.tencent.mm.ak.d.a)localObject).funcId = 688;
              ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
              localObject = ((com.tencent.mm.ak.d.a)localObject).aXF();
              dmg localdmg = (dmg)((com.tencent.mm.ak.d)localObject).iLK.iLR;
              localdmg.MPO = new SKBuiltinBuffer_t().setBuffer(paramIntent.getBytes());
              localdmg.EX = 3;
              aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
              {
                public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
                {
                  AppMethodBeat.i(129804);
                  Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString }));
                  GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dmh)paramAnonymousd.iLL.iLR).MAJ);
                    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
                    com.tencent.mm.plugin.walletlock.c.g.yD(false);
                    GestureGuardLogicUI.fVm();
                  }
                  i.IwY.fVB();
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
        Toast.makeText(this, getString(2131761421), 0).show();
      }
    }
    AppMethodBeat.o(129824);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(129825);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131309484)
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
    overridePendingTransition(2130772169, 2130772166);
    paramBundle = getIntent();
    if ((!MMApplicationContext.getPackageName().equals(paramBundle.getPackage())) || (Util.isNullOrNil(paramBundle.getStringExtra("action"))) || (Util.isNullOrNil(paramBundle.getStringExtra("next_action"))))
    {
      Log.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
      finish();
      AppMethodBeat.o(129820);
      return;
    }
    this.IvP = new ViewFlipper(this);
    this.IvG = new a[] { new a(this), new a(this), new a(this) };
    paramBundle = this.IvG;
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.IvP.addView(localObject.mView);
      localObject.Iwc.setOnPatternListener(this);
      localObject.Iwd.setOnClickListener(this);
      i += 1;
    }
    setContentView(this.IvP);
    this.mToken = getIntent().getStringExtra("token");
    this.IvO = getIntent().getStringExtra("type");
    this.IvT = getIntent().getStringExtra("verify_title");
    this.Ivu = getIntent().getIntExtra("scene", -1);
    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
      com.tencent.mm.plugin.walletlock.c.h.fVy();
    }
    initView();
    AppMethodBeat.o(129820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(129822);
    super.onDestroy();
    if (this.IvM != null)
    {
      com.tencent.mm.kernel.g.azz().a(this.IvM);
      this.IvM = null;
    }
    if (this.IvN != null)
    {
      com.tencent.mm.kernel.g.azz().a(this.IvN);
      this.IvN = null;
    }
    if ((this.IvQ != null) && (this.IvQ.isShowing())) {
      this.IvQ.dismiss();
    }
    if (this.IvP != null)
    {
      this.IvP.removeAllViews();
      this.IvP = null;
    }
    int i = 0;
    while (i < this.IvG.length)
    {
      a locala = this.IvG[i];
      locala.Iwc.setOnClickListener(null);
      locala.Iwd.setOnClickListener(null);
      locala.mView = null;
      locala.Iwa = null;
      locala.Iwb = null;
      locala.Iwc = null;
      locala.Iwd = null;
      this.IvG[i] = null;
      i += 1;
    }
    this.IvG = null;
    AppMethodBeat.o(129822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(129826);
    if (paramInt == 4)
    {
      if (fVf())
      {
        AppMethodBeat.o(129826);
        return false;
      }
      M(0, 4, "user cancel when setting gesture");
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
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = com.tencent.mm.plugin.walletlock.gesture.a.d.fUZ();
      if (localg.IvB == -1L) {
        break label98;
      }
      e.a(localg);
      if (localg.IvC / 1000L >= 600L) {
        break label95;
      }
      com.tencent.mm.plugin.walletlock.gesture.a.d.aC(localg.IvB, localg.IvC);
    }
    label95:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.IvL = com.tencent.mm.plugin.walletlock.gesture.a.d.fVd();
        if (this.IvL != -1) {}
      }
      else
      {
        this.IvL = 0;
      }
      AppMethodBeat.o(129821);
      return;
      com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(129836);
    AppMethodBeat.at(this, paramBoolean);
    Object localObject = this.IvG[this.IvF];
    if (((a)localObject).Iwc != null)
    {
      localObject = ((a)localObject).Iwc;
      if ((!paramBoolean) || (this.IvK)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI
 * JD-Core Version:    0.7.0.1
 */