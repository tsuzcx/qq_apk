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
import com.tencent.mm.g.a.lq;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.tools.u;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  private boolean IZA;
  private boolean IZB;
  private int IZC;
  private boolean IZD;
  private c.a IZe;
  protected a IZf;
  protected a IZg;
  protected a IZh;
  protected a IZi;
  private int IZj;
  private int IZk;
  private int IZl;
  private int IZm;
  private int IZn;
  private int IZo;
  private int IZp;
  private int IZq;
  private int IZr;
  private int IZs;
  private int IZt;
  protected View.OnClickListener IZu;
  private ap IZv;
  private LinearLayout IZw;
  private int IZx;
  private int IZy;
  private int IZz;
  private int cMI;
  private Context mContext;
  protected int rko;
  private long urF;
  private int xCS;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.rko = 0;
    this.IZj = 0;
    this.cMI = 0;
    this.urF = 0L;
    this.xCS = -1;
    this.IZt = 0;
    this.IZu = new View.OnClickListener()
    {
      private final long Ake = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lq();
          paramAnonymousView.dyO.dyP = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
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
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.IZv = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.IZx = 0;
    this.IZy = 0;
    this.IZz = 0;
    this.IZA = false;
    this.IZB = false;
    this.IZC = 0;
    this.IZD = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.rko = 0;
    this.IZj = 0;
    this.cMI = 0;
    this.urF = 0L;
    this.xCS = -1;
    this.IZt = 0;
    this.IZu = new View.OnClickListener()
    {
      private final long Ake = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lq();
          paramAnonymousView.dyO.dyP = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
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
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.IZv = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.IZx = 0;
    this.IZy = 0;
    this.IZz = 0;
    this.IZA = false;
    this.IZB = false;
    this.IZC = 0;
    this.IZD = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.rko = 0;
    this.IZj = 0;
    this.cMI = 0;
    this.urF = 0L;
    this.xCS = -1;
    this.IZt = 0;
    this.IZu = new View.OnClickListener()
    {
      private final long Ake = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lq();
          paramAnonymousView.dyO.dyP = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
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
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.IZv = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.IZx = 0;
    this.IZy = 0;
    this.IZz = 0;
    this.IZA = false;
    this.IZB = false;
    this.IZC = 0;
    this.IZD = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a abC(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cc.a.in(getContext())) {
      com.tencent.mm.kiss.a.b.akC();
    }
    for (locala.IZF = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131494777);; locala.IZF = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131494776))
    {
      locala.IZG = ((TabIconView)locala.IZF.findViewById(2131300891));
      locala.IZH = ((TextView)locala.IZF.findViewById(2131300902));
      locala.IZI = ((TextView)locala.IZF.findViewById(2131306196));
      locala.IZI.setBackgroundResource(u.kE(getContext()));
      locala.IZJ = ((ImageView)locala.IZF.findViewById(2131299183));
      locala.IZF.setTag(Integer.valueOf(paramInt));
      locala.IZF.setOnClickListener(this.IZu);
      float f1 = com.tencent.mm.cc.a.ay(getContext(), 2131165576);
      float f2 = com.tencent.mm.cc.a.ik(getContext());
      locala.IZH.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      com.tencent.mm.kiss.a.b.akC();
    }
  }
  
  private a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = abC(0);
    locala.IZF.setId(-16777215);
    locala.IZH.setText(2131761077);
    locala.IZH.setTextColor(getResources().getColor(2131099732));
    locala.IZG.h(2131690369, 2131690533, 2131690532, com.tencent.mm.cc.a.in(getContext()));
    locala.IZI.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.IZt);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZF, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = abC(1);
    locala.IZF.setId(-16777214);
    locala.IZH.setText(2131761038);
    locala.IZH.setTextColor(getResources().getColor(2131099732));
    locala.IZG.h(2131690379, 2131690549, 2131690548, com.tencent.mm.cc.a.in(getContext()));
    locala.IZI.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.IZt);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZF, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = abC(2);
    locala.IZF.setId(-16777213);
    locala.IZH.setText(2131761036);
    locala.IZH.setTextColor(getResources().getColor(2131099732));
    locala.IZG.h(2131690389, 2131690554, 2131690553, com.tencent.mm.cc.a.in(getContext()));
    locala.IZI.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.dun().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.IZt);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZF, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = abC(3);
    locala.IZF.setId(-16777212);
    locala.IZH.setText(2131761071);
    locala.IZH.setTextColor(getResources().getColor(2131099732));
    locala.IZG.h(2131690427, 2131690592, 2131690592, com.tencent.mm.cc.a.in(getContext()));
    locala.IZI.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.dun().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.IZt);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZF, localLayoutParams);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.IZw = new LinearLayout(getContext());
    this.IZw.setBackgroundColor(getResources().getColor(2131099649));
    this.IZw.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.IZw, localLayoutParams);
    this.IZt = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131165256) * com.tencent.mm.cc.a.ik(getContext())));
    this.IZf = b(this.IZw);
    this.IZh = c(this.IZw);
    this.IZg = d(this.IZw);
    this.IZi = e(this.IZw);
    this.IZj = getResources().getColor(2131100693);
    this.IZk = ((this.IZj & 0xFF0000) >> 16);
    this.IZl = ((this.IZj & 0xFF00) >> 8);
    this.IZm = (this.IZj & 0xFF);
    this.cMI = getResources().getColor(2131099732);
    this.IZn = ((this.cMI & 0xFF0000) >> 16);
    this.IZo = ((this.cMI & 0xFF00) >> 8);
    this.IZp = (this.cMI & 0xFF);
    this.IZq = (this.IZk - this.IZn);
    this.IZr = (this.IZl - this.IZo);
    this.IZs = (this.IZm - this.IZp);
    AppMethodBeat.o(33350);
  }
  
  public final void abs(int paramInt)
  {
    AppMethodBeat.i(33351);
    ad.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.IZx = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZf.IZI.setText("");
        this.IZf.IZI.setBackgroundResource(2131689744);
        this.IZf.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949));
        this.IZf.IZI.setVisibility(0);
        this.IZf.IZJ.setVisibility(4);
        AppMethodBeat.o(33351);
        return;
      }
      this.IZf.IZI.setText(String.valueOf(paramInt));
      this.IZf.IZI.setBackgroundResource(u.aP(getContext(), paramInt));
      this.IZf.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949) * com.tencent.mm.cc.a.ik(getContext()));
      this.IZf.IZI.setVisibility(0);
      this.IZf.IZJ.setVisibility(4);
      AppMethodBeat.o(33351);
      return;
    }
    this.IZf.IZI.setText("");
    this.IZf.IZI.setVisibility(4);
    AppMethodBeat.o(33351);
  }
  
  public final void abt(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.IZy = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZh.IZI.setText("");
        this.IZh.IZI.setBackgroundResource(2131689744);
        this.IZh.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949));
        this.IZh.IZI.setVisibility(0);
        this.IZh.IZJ.setVisibility(4);
        AppMethodBeat.o(33352);
        return;
      }
      this.IZh.IZI.setText(String.valueOf(paramInt));
      this.IZh.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949) * com.tencent.mm.cc.a.ik(getContext()));
      this.IZh.IZI.setBackgroundResource(u.aP(getContext(), paramInt));
      this.IZh.IZI.setVisibility(0);
      this.IZh.IZJ.setVisibility(4);
      AppMethodBeat.o(33352);
      return;
    }
    this.IZh.IZI.setText("");
    this.IZh.IZI.setVisibility(4);
    AppMethodBeat.o(33352);
  }
  
  public final void abu(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.IZz = paramInt;
    a locala = this.IZg;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33353);
      return;
    }
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZg.IZI.setText("");
        this.IZg.IZI.setBackgroundResource(2131689744);
        this.IZg.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949));
        this.IZg.IZI.setVisibility(0);
        this.IZg.IZJ.setVisibility(4);
      }
      for (;;)
      {
        this.IZg.a(k.wsQ, true);
        AppMethodBeat.o(33353);
        return;
        this.IZg.IZI.setText(String.valueOf(paramInt));
        this.IZg.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949) * com.tencent.mm.cc.a.ik(getContext()));
        this.IZg.IZI.setVisibility(0);
        this.IZg.IZI.setBackgroundResource(u.aP(getContext(), paramInt));
        this.IZg.IZJ.setVisibility(4);
      }
    }
    this.IZg.IZI.setText("");
    this.IZg.IZI.setVisibility(4);
    this.IZg.a(k.wsQ, false);
    AppMethodBeat.o(33353);
  }
  
  public final void abv(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.IZB)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.IZC = paramInt;
    a locala = this.IZi;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33355);
      return;
    }
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZi.IZI.setText("");
        this.IZi.IZI.setBackgroundResource(2131689744);
        this.IZi.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949));
        this.IZi.IZI.setVisibility(0);
        this.IZi.IZJ.setVisibility(4);
      }
      for (;;)
      {
        this.IZi.a(k.wsQ, true);
        AppMethodBeat.o(33355);
        return;
        this.IZi.IZI.setText(String.valueOf(paramInt));
        this.IZi.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166949) * com.tencent.mm.cc.a.ik(getContext()));
        this.IZi.IZI.setVisibility(0);
        this.IZi.IZI.setBackgroundResource(u.aP(getContext(), paramInt));
        this.IZi.IZJ.setVisibility(4);
      }
    }
    this.IZi.IZI.setText("");
    this.IZi.IZI.setVisibility(4);
    this.IZi.a(k.wsQ, false);
    AppMethodBeat.o(33355);
  }
  
  public final void fuZ()
  {
    if ((this.IZf != null) && (this.IZh != null) && (this.IZg == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.IZy;
  }
  
  public int getCurIdx()
  {
    return this.rko;
  }
  
  public int getFriendTabUnread()
  {
    return this.IZz;
  }
  
  public int getMainTabUnread()
  {
    return this.IZx;
  }
  
  public boolean getSettingsPoint()
  {
    return this.IZD;
  }
  
  public int getSettingsTabUnread()
  {
    return this.IZC;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.IZA;
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.IZq * paramFloat + this.IZn) << 16) + ((int)(this.IZr * paramFloat + this.IZo) << 8) + (int)(this.IZs * paramFloat + this.IZp) + (this.cMI & 0xFF000000);
    int m = ((int)(this.IZq * (1.0F - paramFloat) + this.IZn) << 16) + ((int)(this.IZr * (1.0F - paramFloat) + this.IZo) << 8) + (int)(this.IZs * (1.0F - paramFloat) + this.IZp) + (this.cMI & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.IZf.IZG.setFocusAlpha(j);
      this.IZh.IZG.setFocusAlpha(i);
      this.IZf.IZH.setTextColor(m);
      this.IZh.IZH.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.IZh.IZG.setFocusAlpha(j);
      this.IZg.IZG.setFocusAlpha(i);
      this.IZh.IZH.setTextColor(m);
      this.IZg.IZH.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.IZg.IZG.setFocusAlpha(j);
      this.IZi.IZG.setFocusAlpha(i);
      this.IZg.IZH.setTextColor(m);
      this.IZi.IZH.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.IZe = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.rko = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.urF = System.currentTimeMillis();
      this.xCS = this.rko;
      AppMethodBeat.o(33358);
      return;
      this.IZf.IZG.setFocusAlpha(255);
      this.IZg.IZG.setFocusAlpha(0);
      this.IZh.IZG.setFocusAlpha(0);
      this.IZi.IZG.setFocusAlpha(0);
      this.IZf.IZH.setTextColor(this.IZj);
      this.IZg.IZH.setTextColor(this.cMI);
      this.IZh.IZH.setTextColor(this.cMI);
      this.IZi.IZH.setTextColor(this.cMI);
      continue;
      this.IZf.IZG.setFocusAlpha(0);
      this.IZg.IZG.setFocusAlpha(255);
      this.IZh.IZG.setFocusAlpha(0);
      this.IZi.IZG.setFocusAlpha(0);
      this.IZf.IZH.setTextColor(this.cMI);
      this.IZg.IZH.setTextColor(this.IZj);
      this.IZh.IZH.setTextColor(this.cMI);
      this.IZi.IZH.setTextColor(this.cMI);
      continue;
      this.IZf.IZG.setFocusAlpha(0);
      this.IZg.IZG.setFocusAlpha(0);
      this.IZh.IZG.setFocusAlpha(255);
      this.IZi.IZG.setFocusAlpha(0);
      this.IZf.IZH.setTextColor(this.cMI);
      this.IZg.IZH.setTextColor(this.cMI);
      this.IZh.IZH.setTextColor(this.IZj);
      this.IZi.IZH.setTextColor(this.cMI);
      continue;
      this.IZf.IZG.setFocusAlpha(0);
      this.IZg.IZG.setFocusAlpha(0);
      this.IZh.IZG.setFocusAlpha(0);
      this.IZi.IZG.setFocusAlpha(255);
      this.IZf.IZH.setTextColor(this.cMI);
      this.IZg.IZH.setTextColor(this.cMI);
      this.IZh.IZH.setTextColor(this.cMI);
      this.IZi.IZH.setTextColor(this.IZj);
    }
  }
  
  public final void wX(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.IZg))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.IZA = paramBoolean;
    this.IZg.IZI.setVisibility(4);
    ImageView localImageView = this.IZg.IZJ;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.IZg.a(k.wsL, paramBoolean);
    AppMethodBeat.o(33354);
  }
  
  public final void wY(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.IZB)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.IZi))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.ASt;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.AP(l);
      this.IZD = paramBoolean;
      this.IZi.IZI.setVisibility(4);
      localObject = this.IZi.IZJ;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.IZi.a(k.wsL, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View IZF;
    TabIconView IZG;
    TextView IZH;
    TextView IZI;
    ImageView IZJ;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnc paramdnc)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramdnc.hgh > 99)
        {
          this.IZI.setText("");
          this.IZI.setBackgroundResource(2131689744);
          this.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(LauncherUIBottomTabView.this.getContext(), 2131166949));
          this.IZI.setVisibility(0);
          this.IZJ.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.IZI.setText(String.valueOf(paramdnc.hgh));
        this.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(LauncherUIBottomTabView.this.getContext(), 2131166949) * com.tencent.mm.cc.a.ik(LauncherUIBottomTabView.this.getContext()));
        this.IZI.setVisibility(0);
        this.IZI.setBackgroundResource(u.aP(LauncherUIBottomTabView.this.getContext(), paramdnc.hgh));
        this.IZJ.setVisibility(4);
        continue;
        this.IZI.setText("");
        this.IZI.setVisibility(4);
      }
    }
    
    public final boolean dkD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.IZF;
    }
    
    public final boolean ol(boolean paramBoolean)
    {
      AppMethodBeat.i(221391);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(221391);
      return paramBoolean;
    }
    
    public final boolean om(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.IZI.setVisibility(4);
      ImageView localImageView = this.IZJ;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean on(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.IZI.setText(LauncherUIBottomTabView.this.getResources().getString(2131764544));
        this.IZI.setBackgroundResource(2131233430);
        this.IZI.setTextSize(0, com.tencent.mm.cc.a.ay(LauncherUIBottomTabView.this.getContext(), 2131165267));
        this.IZI.setVisibility(0);
        this.IZJ.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.IZI.setText("");
        this.IZI.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */