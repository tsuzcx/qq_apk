package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aam;
import com.tencent.mm.g.a.aam.a;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.v;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  private int BTn;
  private int OEA;
  private int OEB;
  private boolean OEC;
  private boolean OED;
  private int OEE;
  private boolean OEF;
  private c.a OEg;
  protected a OEh;
  protected a OEi;
  protected a OEj;
  protected a OEk;
  private int OEl;
  private int OEm;
  private int OEn;
  private int OEo;
  private int OEp;
  private int OEq;
  private int OEr;
  private int OEs;
  private int OEt;
  private int OEu;
  private int OEv;
  protected View.OnClickListener OEw;
  private MMHandler OEx;
  private LinearLayout OEy;
  private int OEz;
  private int ddP;
  private Context mContext;
  protected int sTB;
  private long xUW;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.sTB = 0;
    this.OEl = 0;
    this.ddP = 0;
    this.xUW = 0L;
    this.BTn = -1;
    this.OEv = 0;
    this.OEw = new View.OnClickListener()
    {
      private final long EKO = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new mh();
          paramAnonymousView.dRG.dRH = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          EventCenter.instance.publish(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.business.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            Log.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          Log.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.OEx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.OEz = 0;
    this.OEA = 0;
    this.OEB = 0;
    this.OEC = false;
    this.OED = false;
    this.OEE = 0;
    this.OEF = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.sTB = 0;
    this.OEl = 0;
    this.ddP = 0;
    this.xUW = 0L;
    this.BTn = -1;
    this.OEv = 0;
    this.OEw = new View.OnClickListener()
    {
      private final long EKO = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new mh();
          paramAnonymousView.dRG.dRH = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          EventCenter.instance.publish(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.business.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            Log.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          Log.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.OEx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.OEz = 0;
    this.OEA = 0;
    this.OEB = 0;
    this.OEC = false;
    this.OED = false;
    this.OEE = 0;
    this.OEF = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.sTB = 0;
    this.OEl = 0;
    this.ddP = 0;
    this.xUW = 0L;
    this.BTn = -1;
    this.OEv = 0;
    this.OEw = new View.OnClickListener()
    {
      private final long EKO = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new mh();
          paramAnonymousView.dRG.dRH = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          EventCenter.instance.publish(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.business.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            Log.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          Log.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.OEx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.OEz = 0;
    this.OEA = 0;
    this.OEB = 0;
    this.OEC = false;
    this.OED = false;
    this.OEE = 0;
    this.OEF = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a akR(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cb.a.jl(getContext())) {
      com.tencent.mm.kiss.a.b.aBh();
    }
    for (locala.OEH = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131495511);; locala.OEH = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131495510))
    {
      locala.OEI = ((TabIconView)locala.OEH.findViewById(2131302497));
      locala.OEJ = ((TextView)locala.OEH.findViewById(2131302512));
      locala.OEK = ((TextView)locala.OEH.findViewById(2131309594));
      locala.OEK.setBackgroundResource(v.kH(getContext()));
      locala.OEL = ((ImageView)locala.OEH.findViewById(2131299734));
      locala.OEH.setTag(Integer.valueOf(paramInt));
      locala.OEH.setOnClickListener(this.OEw);
      float f1 = com.tencent.mm.cb.a.aH(getContext(), 2131165594);
      float f2 = com.tencent.mm.cb.a.ji(getContext());
      locala.OEJ.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      com.tencent.mm.kiss.a.b.aBh();
    }
  }
  
  private void akS(int paramInt)
  {
    AppMethodBeat.i(232601);
    a locala;
    switch (paramInt)
    {
    default: 
      locala = null;
    }
    for (;;)
    {
      if (locala != null) {}
      try
      {
        Object localObject = locala.OEK.getText().toString().trim();
        aam localaam = new aam();
        localaam.ehm.ehn = paramInt;
        localaam.ehm.ehp = Util.getInt((String)localObject, 0);
        localObject = localaam.ehm;
        if (locala.OEL.getVisibility() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((aam.a)localObject).eho = bool;
          EventCenter.instance.publish(localaam);
          AppMethodBeat.o(232601);
          return;
          locala = this.OEh;
          break;
          locala = this.OEj;
          break;
          locala = this.OEi;
          break;
          locala = this.OEk;
          break;
        }
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUITabView", localException, "notify tab reddot tabIndex [%d]", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(232601);
      }
    }
  }
  
  private a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = akR(0);
    locala.OEH.setId(-16777215);
    locala.OEJ.setText(2131762863);
    locala.OEJ.setTextColor(getResources().getColor(2131099746));
    locala.OEI.i(2131690511, 2131690758, 2131690757, com.tencent.mm.cb.a.jl(getContext()));
    locala.OEK.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.OEv);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEH, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = akR(1);
    locala.OEH.setId(-16777214);
    locala.OEJ.setText(2131762819);
    locala.OEJ.setTextColor(getResources().getColor(2131099746));
    locala.OEI.i(2131690522, 2131690777, 2131690776, com.tencent.mm.cb.a.jl(getContext()));
    locala.OEK.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.OEv);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEH, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = akR(2);
    locala.OEH.setId(-16777213);
    locala.OEJ.setText(2131762817);
    locala.OEJ.setTextColor(getResources().getColor(2131099746));
    locala.OEI.i(2131690534, 2131690783, 2131690782, com.tencent.mm.cb.a.jl(getContext()));
    locala.OEK.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.exl().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.OEv);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEH, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = akR(3);
    locala.OEH.setId(-16777212);
    locala.OEJ.setText(2131762857);
    locala.OEJ.setTextColor(getResources().getColor(2131099746));
    locala.OEI.i(2131690596, 2131690829, 2131690829, com.tencent.mm.cb.a.jl(getContext()));
    locala.OEK.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.exl().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.OEv);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.OEH, localLayoutParams);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.OEy = new LinearLayout(getContext());
    this.OEy.setBackgroundColor(getResources().getColor(2131099649));
    this.OEy.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.OEy, localLayoutParams);
    this.OEv = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131165260) * com.tencent.mm.cb.a.ji(getContext())));
    this.OEh = b(this.OEy);
    this.OEj = c(this.OEy);
    this.OEi = d(this.OEy);
    this.OEk = e(this.OEy);
    this.OEl = getResources().getColor(2131100886);
    this.OEm = ((this.OEl & 0xFF0000) >> 16);
    this.OEn = ((this.OEl & 0xFF00) >> 8);
    this.OEo = (this.OEl & 0xFF);
    this.ddP = getResources().getColor(2131099746);
    this.OEp = ((this.ddP & 0xFF0000) >> 16);
    this.OEq = ((this.ddP & 0xFF00) >> 8);
    this.OEr = (this.ddP & 0xFF);
    this.OEs = (this.OEm - this.OEp);
    this.OEt = (this.OEn - this.OEq);
    this.OEu = (this.OEo - this.OEr);
    AppMethodBeat.o(33350);
  }
  
  public final void AT(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.OEi))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.OEC = paramBoolean;
    this.OEi.OEK.setVisibility(4);
    ImageView localImageView = this.OEi.OEL;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.OEi.a(k.ADG, paramBoolean);
    akS(2);
    AppMethodBeat.o(33354);
  }
  
  public final void AU(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.OED)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.OEk))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.FuH;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.Ks(l);
      this.OEF = paramBoolean;
      this.OEk.OEK.setVisibility(4);
      localObject = this.OEk.OEL;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.OEk.a(k.ADG, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void akH(int paramInt)
  {
    AppMethodBeat.i(33351);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.OEz = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.OEh.OEK.setText("");
        this.OEh.OEK.setBackgroundResource(2131689753);
        this.OEh.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084));
        this.OEh.OEK.setVisibility(0);
        this.OEh.OEL.setVisibility(4);
      }
    }
    for (;;)
    {
      akS(0);
      AppMethodBeat.o(33351);
      return;
      this.OEh.OEK.setText(String.valueOf(paramInt));
      this.OEh.OEK.setBackgroundResource(v.aQ(getContext(), paramInt));
      this.OEh.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084) * com.tencent.mm.cb.a.ji(getContext()));
      this.OEh.OEK.setVisibility(0);
      this.OEh.OEL.setVisibility(4);
      continue;
      this.OEh.OEK.setText("");
      this.OEh.OEK.setVisibility(4);
    }
  }
  
  public final void akI(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.OEA = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.OEj.OEK.setText("");
        this.OEj.OEK.setBackgroundResource(2131689753);
        this.OEj.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084));
        this.OEj.OEK.setVisibility(0);
        this.OEj.OEL.setVisibility(4);
      }
    }
    for (;;)
    {
      akS(1);
      AppMethodBeat.o(33352);
      return;
      this.OEj.OEK.setText(String.valueOf(paramInt));
      this.OEj.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084) * com.tencent.mm.cb.a.ji(getContext()));
      this.OEj.OEK.setBackgroundResource(v.aQ(getContext(), paramInt));
      this.OEj.OEK.setVisibility(0);
      this.OEj.OEL.setVisibility(4);
      continue;
      this.OEj.OEK.setText("");
      this.OEj.OEK.setVisibility(4);
    }
  }
  
  public final void akJ(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.OEB = paramInt;
    a locala = this.OEi;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33353);
      return;
    }
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.OEi.OEK.setText("");
        this.OEi.OEK.setBackgroundResource(2131689753);
        this.OEi.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084));
        this.OEi.OEK.setVisibility(0);
        this.OEi.OEL.setVisibility(4);
        this.OEi.a(k.ADL, true);
      }
    }
    for (;;)
    {
      akS(2);
      AppMethodBeat.o(33353);
      return;
      this.OEi.OEK.setText(String.valueOf(paramInt));
      this.OEi.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084) * com.tencent.mm.cb.a.ji(getContext()));
      this.OEi.OEK.setVisibility(0);
      this.OEi.OEK.setBackgroundResource(v.aQ(getContext(), paramInt));
      this.OEi.OEL.setVisibility(4);
      break;
      this.OEi.OEK.setText("");
      this.OEi.OEK.setVisibility(4);
      this.OEi.a(k.ADL, false);
    }
  }
  
  public final void akK(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.OED)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.OEE = paramInt;
    a locala = this.OEk;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33355);
      return;
    }
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.OEk.OEK.setText("");
        this.OEk.OEK.setBackgroundResource(2131689753);
        this.OEk.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084));
        this.OEk.OEK.setVisibility(0);
        this.OEk.OEL.setVisibility(4);
        this.OEk.a(k.ADL, true);
      }
    }
    for (;;)
    {
      akS(3);
      AppMethodBeat.o(33355);
      return;
      this.OEk.OEK.setText(String.valueOf(paramInt));
      this.OEk.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167084) * com.tencent.mm.cb.a.ji(getContext()));
      this.OEk.OEK.setVisibility(0);
      this.OEk.OEK.setBackgroundResource(v.aQ(getContext(), paramInt));
      this.OEk.OEL.setVisibility(4);
      break;
      this.OEk.OEK.setText("");
      this.OEk.OEK.setVisibility(4);
      this.OEk.a(k.ADL, false);
    }
  }
  
  public final void gGO()
  {
    if ((this.OEh != null) && (this.OEj != null) && (this.OEi == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.OEA;
  }
  
  public int getCurIdx()
  {
    return this.sTB;
  }
  
  public int getFriendTabUnread()
  {
    return this.OEB;
  }
  
  public int getMainTabUnread()
  {
    return this.OEz;
  }
  
  public boolean getSettingsPoint()
  {
    return this.OEF;
  }
  
  public int getSettingsTabUnread()
  {
    return this.OEE;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.OEC;
  }
  
  public final void p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.OEs * paramFloat + this.OEp) << 16) + ((int)(this.OEt * paramFloat + this.OEq) << 8) + (int)(this.OEu * paramFloat + this.OEr) + (this.ddP & 0xFF000000);
    int m = ((int)(this.OEs * (1.0F - paramFloat) + this.OEp) << 16) + ((int)(this.OEt * (1.0F - paramFloat) + this.OEq) << 8) + (int)(this.OEu * (1.0F - paramFloat) + this.OEr) + (this.ddP & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.OEh.OEI.setFocusAlpha(j);
      this.OEj.OEI.setFocusAlpha(i);
      this.OEh.OEJ.setTextColor(m);
      this.OEj.OEJ.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.OEj.OEI.setFocusAlpha(j);
      this.OEi.OEI.setFocusAlpha(i);
      this.OEj.OEJ.setTextColor(m);
      this.OEi.OEJ.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.OEi.OEI.setFocusAlpha(j);
      this.OEk.OEI.setFocusAlpha(i);
      this.OEi.OEJ.setTextColor(m);
      this.OEk.OEJ.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.OEg = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.sTB = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.xUW = System.currentTimeMillis();
      this.BTn = this.sTB;
      AppMethodBeat.o(33358);
      return;
      this.OEh.OEI.setFocusAlpha(255);
      this.OEi.OEI.setFocusAlpha(0);
      this.OEj.OEI.setFocusAlpha(0);
      this.OEk.OEI.setFocusAlpha(0);
      this.OEh.OEJ.setTextColor(this.OEl);
      this.OEi.OEJ.setTextColor(this.ddP);
      this.OEj.OEJ.setTextColor(this.ddP);
      this.OEk.OEJ.setTextColor(this.ddP);
      continue;
      this.OEh.OEI.setFocusAlpha(0);
      this.OEi.OEI.setFocusAlpha(255);
      this.OEj.OEI.setFocusAlpha(0);
      this.OEk.OEI.setFocusAlpha(0);
      this.OEh.OEJ.setTextColor(this.ddP);
      this.OEi.OEJ.setTextColor(this.OEl);
      this.OEj.OEJ.setTextColor(this.ddP);
      this.OEk.OEJ.setTextColor(this.ddP);
      continue;
      this.OEh.OEI.setFocusAlpha(0);
      this.OEi.OEI.setFocusAlpha(0);
      this.OEj.OEI.setFocusAlpha(255);
      this.OEk.OEI.setFocusAlpha(0);
      this.OEh.OEJ.setTextColor(this.ddP);
      this.OEi.OEJ.setTextColor(this.ddP);
      this.OEj.OEJ.setTextColor(this.OEl);
      this.OEk.OEJ.setTextColor(this.ddP);
      continue;
      this.OEh.OEI.setFocusAlpha(0);
      this.OEi.OEI.setFocusAlpha(0);
      this.OEj.OEI.setFocusAlpha(0);
      this.OEk.OEI.setFocusAlpha(255);
      this.OEh.OEJ.setTextColor(this.ddP);
      this.OEi.OEJ.setTextColor(this.ddP);
      this.OEj.OEJ.setTextColor(this.ddP);
      this.OEk.OEJ.setTextColor(this.OEl);
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View OEH;
    TabIconView OEI;
    TextView OEJ;
    TextView OEK;
    ImageView OEL;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramehv.ibS > 99)
        {
          this.OEK.setText("");
          this.OEK.setBackgroundResource(2131689753);
          this.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), 2131167084));
          this.OEK.setVisibility(0);
          this.OEL.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.OEK.setText(String.valueOf(paramehv.ibS));
        this.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), 2131167084) * com.tencent.mm.cb.a.ji(LauncherUIBottomTabView.this.getContext()));
        this.OEK.setVisibility(0);
        this.OEK.setBackgroundResource(v.aQ(LauncherUIBottomTabView.this.getContext(), paramehv.ibS));
        this.OEL.setVisibility(4);
        continue;
        this.OEK.setText("");
        this.OEK.setVisibility(4);
      }
    }
    
    public final boolean ehp()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.OEH;
    }
    
    public final boolean qV(boolean paramBoolean)
    {
      AppMethodBeat.i(258275);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(258275);
      return paramBoolean;
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.OEK.setVisibility(4);
      ImageView localImageView = this.OEL;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.OEK.setText(LauncherUIBottomTabView.this.getResources().getString(2131766889));
        this.OEK.setBackgroundResource(2131234232);
        this.OEK.setTextSize(0, com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), 2131165271));
        this.OEK.setVisibility(0);
        this.OEL.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.OEK.setText("");
        this.OEK.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */