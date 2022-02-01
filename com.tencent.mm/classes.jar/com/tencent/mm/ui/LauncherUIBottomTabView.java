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
import com.tencent.mm.g.a.lr;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.tools.u;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  private c.a JtM;
  protected a JtN;
  protected a JtO;
  protected a JtP;
  protected a JtQ;
  private int JtR;
  private int JtS;
  private int JtT;
  private int JtU;
  private int JtV;
  private int JtW;
  private int JtX;
  private int JtY;
  private int JtZ;
  private int Jua;
  private int Jub;
  protected View.OnClickListener Juc;
  private aq Jud;
  private LinearLayout Jue;
  private int Juf;
  private int Jug;
  private int Juh;
  private boolean Jui;
  private boolean Juj;
  private int Juk;
  private boolean Jul;
  private int cNr;
  private Context mContext;
  protected int rss;
  private long uCY;
  private int xSN;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.rss = 0;
    this.JtR = 0;
    this.cNr = 0;
    this.uCY = 0L;
    this.xSN = -1;
    this.Jub = 0;
    this.Juc = new View.OnClickListener()
    {
      private final long ABq = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ae.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lr();
          paramAnonymousView.dzT.dzU = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
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
            ae.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ae.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ae.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.Jud = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ae.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.Juf = 0;
    this.Jug = 0;
    this.Juh = 0;
    this.Jui = false;
    this.Juj = false;
    this.Juk = 0;
    this.Jul = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.rss = 0;
    this.JtR = 0;
    this.cNr = 0;
    this.uCY = 0L;
    this.xSN = -1;
    this.Jub = 0;
    this.Juc = new View.OnClickListener()
    {
      private final long ABq = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ae.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lr();
          paramAnonymousView.dzT.dzU = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
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
            ae.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ae.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ae.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.Jud = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ae.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.Juf = 0;
    this.Jug = 0;
    this.Juh = 0;
    this.Jui = false;
    this.Juj = false;
    this.Juk = 0;
    this.Jul = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.rss = 0;
    this.JtR = 0;
    this.cNr = 0;
    this.uCY = 0L;
    this.xSN = -1;
    this.Jub = 0;
    this.Juc = new View.OnClickListener()
    {
      private final long ABq = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ae.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lr();
          paramAnonymousView.dzT.dzU = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
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
            ae.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
            return;
          }
          ae.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ae.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33335);
      }
    };
    this.Jud = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ae.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.Juf = 0;
    this.Jug = 0;
    this.Juh = 0;
    this.Jui = false;
    this.Juj = false;
    this.Juk = 0;
    this.Jul = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a ack(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cb.a.is(getContext())) {
      com.tencent.mm.kiss.a.b.akR();
    }
    for (locala.Jun = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131494777);; locala.Jun = com.tencent.mm.kiss.a.b.c((Activity)getContext(), 2131494776))
    {
      locala.Juo = ((TabIconView)locala.Jun.findViewById(2131300891));
      locala.Jup = ((TextView)locala.Jun.findViewById(2131300902));
      locala.Juq = ((TextView)locala.Jun.findViewById(2131306196));
      locala.Juq.setBackgroundResource(u.kL(getContext()));
      locala.Jur = ((ImageView)locala.Jun.findViewById(2131299183));
      locala.Jun.setTag(Integer.valueOf(paramInt));
      locala.Jun.setOnClickListener(this.Juc);
      float f1 = com.tencent.mm.cb.a.ay(getContext(), 2131165576);
      float f2 = com.tencent.mm.cb.a.ip(getContext());
      locala.Jup.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      com.tencent.mm.kiss.a.b.akR();
    }
  }
  
  private a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = ack(0);
    locala.Jun.setId(-16777215);
    locala.Jup.setText(2131761077);
    locala.Jup.setTextColor(getResources().getColor(2131099732));
    locala.Juo.h(2131690369, 2131690533, 2131690532, com.tencent.mm.cb.a.is(getContext()));
    locala.Juq.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.Jub);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Jun, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = ack(1);
    locala.Jun.setId(-16777214);
    locala.Jup.setText(2131761038);
    locala.Jup.setTextColor(getResources().getColor(2131099732));
    locala.Juo.h(2131690379, 2131690549, 2131690548, com.tencent.mm.cb.a.is(getContext()));
    locala.Juq.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.Jub);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Jun, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = ack(2);
    locala.Jun.setId(-16777213);
    locala.Jup.setText(2131761036);
    locala.Jup.setTextColor(getResources().getColor(2131099732));
    locala.Juo.h(2131690389, 2131690554, 2131690553, com.tencent.mm.cb.a.is(getContext()));
    locala.Juq.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.dxD().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.Jub);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Jun, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = ack(3);
    locala.Jun.setId(-16777212);
    locala.Jup.setText(2131761071);
    locala.Jup.setTextColor(getResources().getColor(2131099732));
    locala.Juo.h(2131690427, 2131690592, 2131690592, com.tencent.mm.cb.a.is(getContext()));
    locala.Juq.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.dxD().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.Jub);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Jun, localLayoutParams);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.Jue = new LinearLayout(getContext());
    this.Jue.setBackgroundColor(getResources().getColor(2131099649));
    this.Jue.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.Jue, localLayoutParams);
    this.Jub = ((int)(com.tencent.mm.cb.a.ay(getContext(), 2131165256) * com.tencent.mm.cb.a.ip(getContext())));
    this.JtN = b(this.Jue);
    this.JtP = c(this.Jue);
    this.JtO = d(this.Jue);
    this.JtQ = e(this.Jue);
    this.JtR = getResources().getColor(2131100693);
    this.JtS = ((this.JtR & 0xFF0000) >> 16);
    this.JtT = ((this.JtR & 0xFF00) >> 8);
    this.JtU = (this.JtR & 0xFF);
    this.cNr = getResources().getColor(2131099732);
    this.JtV = ((this.cNr & 0xFF0000) >> 16);
    this.JtW = ((this.cNr & 0xFF00) >> 8);
    this.JtX = (this.cNr & 0xFF);
    this.JtY = (this.JtS - this.JtV);
    this.JtZ = (this.JtT - this.JtW);
    this.Jua = (this.JtU - this.JtX);
    AppMethodBeat.o(33350);
  }
  
  public final void aca(int paramInt)
  {
    AppMethodBeat.i(33351);
    ae.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.Juf = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.JtN.Juq.setText("");
        this.JtN.Juq.setBackgroundResource(2131689744);
        this.JtN.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949));
        this.JtN.Juq.setVisibility(0);
        this.JtN.Jur.setVisibility(4);
        AppMethodBeat.o(33351);
        return;
      }
      this.JtN.Juq.setText(String.valueOf(paramInt));
      this.JtN.Juq.setBackgroundResource(u.aP(getContext(), paramInt));
      this.JtN.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949) * com.tencent.mm.cb.a.ip(getContext()));
      this.JtN.Juq.setVisibility(0);
      this.JtN.Jur.setVisibility(4);
      AppMethodBeat.o(33351);
      return;
    }
    this.JtN.Juq.setText("");
    this.JtN.Juq.setVisibility(4);
    AppMethodBeat.o(33351);
  }
  
  public final void acb(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.Jug = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.JtP.Juq.setText("");
        this.JtP.Juq.setBackgroundResource(2131689744);
        this.JtP.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949));
        this.JtP.Juq.setVisibility(0);
        this.JtP.Jur.setVisibility(4);
        AppMethodBeat.o(33352);
        return;
      }
      this.JtP.Juq.setText(String.valueOf(paramInt));
      this.JtP.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949) * com.tencent.mm.cb.a.ip(getContext()));
      this.JtP.Juq.setBackgroundResource(u.aP(getContext(), paramInt));
      this.JtP.Juq.setVisibility(0);
      this.JtP.Jur.setVisibility(4);
      AppMethodBeat.o(33352);
      return;
    }
    this.JtP.Juq.setText("");
    this.JtP.Juq.setVisibility(4);
    AppMethodBeat.o(33352);
  }
  
  public final void acc(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.Juh = paramInt;
    a locala = this.JtO;
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
        this.JtO.Juq.setText("");
        this.JtO.Juq.setBackgroundResource(2131689744);
        this.JtO.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949));
        this.JtO.Juq.setVisibility(0);
        this.JtO.Jur.setVisibility(4);
      }
      for (;;)
      {
        this.JtO.a(k.wIA, true);
        AppMethodBeat.o(33353);
        return;
        this.JtO.Juq.setText(String.valueOf(paramInt));
        this.JtO.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949) * com.tencent.mm.cb.a.ip(getContext()));
        this.JtO.Juq.setVisibility(0);
        this.JtO.Juq.setBackgroundResource(u.aP(getContext(), paramInt));
        this.JtO.Jur.setVisibility(4);
      }
    }
    this.JtO.Juq.setText("");
    this.JtO.Juq.setVisibility(4);
    this.JtO.a(k.wIA, false);
    AppMethodBeat.o(33353);
  }
  
  public final void acd(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.Juj)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.Juk = paramInt;
    a locala = this.JtQ;
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
        this.JtQ.Juq.setText("");
        this.JtQ.Juq.setBackgroundResource(2131689744);
        this.JtQ.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949));
        this.JtQ.Juq.setVisibility(0);
        this.JtQ.Jur.setVisibility(4);
      }
      for (;;)
      {
        this.JtQ.a(k.wIA, true);
        AppMethodBeat.o(33355);
        return;
        this.JtQ.Juq.setText(String.valueOf(paramInt));
        this.JtQ.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166949) * com.tencent.mm.cb.a.ip(getContext()));
        this.JtQ.Juq.setVisibility(0);
        this.JtQ.Juq.setBackgroundResource(u.aP(getContext(), paramInt));
        this.JtQ.Jur.setVisibility(4);
      }
    }
    this.JtQ.Juq.setText("");
    this.JtQ.Juq.setVisibility(4);
    this.JtQ.a(k.wIA, false);
    AppMethodBeat.o(33355);
  }
  
  public final void fza()
  {
    if ((this.JtN != null) && (this.JtP != null) && (this.JtO == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.Jug;
  }
  
  public int getCurIdx()
  {
    return this.rss;
  }
  
  public int getFriendTabUnread()
  {
    return this.Juh;
  }
  
  public int getMainTabUnread()
  {
    return this.Juf;
  }
  
  public boolean getSettingsPoint()
  {
    return this.Jul;
  }
  
  public int getSettingsTabUnread()
  {
    return this.Juk;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.Jui;
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.JtY * paramFloat + this.JtV) << 16) + ((int)(this.JtZ * paramFloat + this.JtW) << 8) + (int)(this.Jua * paramFloat + this.JtX) + (this.cNr & 0xFF000000);
    int m = ((int)(this.JtY * (1.0F - paramFloat) + this.JtV) << 16) + ((int)(this.JtZ * (1.0F - paramFloat) + this.JtW) << 8) + (int)(this.Jua * (1.0F - paramFloat) + this.JtX) + (this.cNr & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.JtN.Juo.setFocusAlpha(j);
      this.JtP.Juo.setFocusAlpha(i);
      this.JtN.Jup.setTextColor(m);
      this.JtP.Jup.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.JtP.Juo.setFocusAlpha(j);
      this.JtO.Juo.setFocusAlpha(i);
      this.JtP.Jup.setTextColor(m);
      this.JtO.Jup.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.JtO.Juo.setFocusAlpha(j);
      this.JtQ.Juo.setFocusAlpha(i);
      this.JtO.Jup.setTextColor(m);
      this.JtQ.Jup.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.JtM = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.rss = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.uCY = System.currentTimeMillis();
      this.xSN = this.rss;
      AppMethodBeat.o(33358);
      return;
      this.JtN.Juo.setFocusAlpha(255);
      this.JtO.Juo.setFocusAlpha(0);
      this.JtP.Juo.setFocusAlpha(0);
      this.JtQ.Juo.setFocusAlpha(0);
      this.JtN.Jup.setTextColor(this.JtR);
      this.JtO.Jup.setTextColor(this.cNr);
      this.JtP.Jup.setTextColor(this.cNr);
      this.JtQ.Jup.setTextColor(this.cNr);
      continue;
      this.JtN.Juo.setFocusAlpha(0);
      this.JtO.Juo.setFocusAlpha(255);
      this.JtP.Juo.setFocusAlpha(0);
      this.JtQ.Juo.setFocusAlpha(0);
      this.JtN.Jup.setTextColor(this.cNr);
      this.JtO.Jup.setTextColor(this.JtR);
      this.JtP.Jup.setTextColor(this.cNr);
      this.JtQ.Jup.setTextColor(this.cNr);
      continue;
      this.JtN.Juo.setFocusAlpha(0);
      this.JtO.Juo.setFocusAlpha(0);
      this.JtP.Juo.setFocusAlpha(255);
      this.JtQ.Juo.setFocusAlpha(0);
      this.JtN.Jup.setTextColor(this.cNr);
      this.JtO.Jup.setTextColor(this.cNr);
      this.JtP.Jup.setTextColor(this.JtR);
      this.JtQ.Jup.setTextColor(this.cNr);
      continue;
      this.JtN.Juo.setFocusAlpha(0);
      this.JtO.Juo.setFocusAlpha(0);
      this.JtP.Juo.setFocusAlpha(0);
      this.JtQ.Juo.setFocusAlpha(255);
      this.JtN.Jup.setTextColor(this.cNr);
      this.JtO.Jup.setTextColor(this.cNr);
      this.JtP.Jup.setTextColor(this.cNr);
      this.JtQ.Jup.setTextColor(this.JtR);
    }
  }
  
  public final void xf(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.JtO))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.Jui = paramBoolean;
    this.JtO.Juq.setVisibility(4);
    ImageView localImageView = this.JtO.Jur;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.JtO.a(k.wIv, paramBoolean);
    AppMethodBeat.o(33354);
  }
  
  public final void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.Juj)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.JtQ))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.BjR;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.Bn(l);
      this.Jul = paramBoolean;
      this.JtQ.Juq.setVisibility(4);
      localObject = this.JtQ.Jur;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.JtQ.a(k.wIv, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View Jun;
    TabIconView Juo;
    TextView Jup;
    TextView Juq;
    ImageView Jur;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnz paramdnz)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramdnz.hiV > 99)
        {
          this.Juq.setText("");
          this.Juq.setBackgroundResource(2131689744);
          this.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(LauncherUIBottomTabView.this.getContext(), 2131166949));
          this.Juq.setVisibility(0);
          this.Jur.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.Juq.setText(String.valueOf(paramdnz.hiV));
        this.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(LauncherUIBottomTabView.this.getContext(), 2131166949) * com.tencent.mm.cb.a.ip(LauncherUIBottomTabView.this.getContext()));
        this.Juq.setVisibility(0);
        this.Juq.setBackgroundResource(u.aP(LauncherUIBottomTabView.this.getContext(), paramdnz.hiV));
        this.Jur.setVisibility(4);
        continue;
        this.Juq.setText("");
        this.Juq.setVisibility(4);
      }
    }
    
    public final boolean dnD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.Jun;
    }
    
    public final boolean oq(boolean paramBoolean)
    {
      AppMethodBeat.i(224188);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(224188);
      return paramBoolean;
    }
    
    public final boolean or(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.Juq.setVisibility(4);
      ImageView localImageView = this.Jur;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean os(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.Juq.setText(LauncherUIBottomTabView.this.getResources().getString(2131764544));
        this.Juq.setBackgroundResource(2131233430);
        this.Juq.setTextSize(0, com.tencent.mm.cb.a.ay(LauncherUIBottomTabView.this.getContext(), 2131165267));
        this.Juq.setVisibility(0);
        this.Jur.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.Juq.setText("");
        this.Juq.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */