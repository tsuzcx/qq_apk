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
import com.tencent.mm.g.a.lh;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.tools.u;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  protected a HlA;
  protected a HlB;
  private int HlC;
  private int HlD;
  private int HlE;
  private int HlF;
  private int HlG;
  private int HlH;
  private int HlI;
  private int HlJ;
  private int HlK;
  private int HlL;
  private int HlM;
  protected View.OnClickListener HlN;
  private com.tencent.mm.sdk.platformtools.ao HlO;
  private LinearLayout HlP;
  private int HlQ;
  private int HlR;
  private int HlS;
  private boolean HlT;
  private boolean HlU;
  private int HlV;
  private boolean HlW;
  private c.a Hlx;
  protected a Hly;
  protected a Hlz;
  private int cBJ;
  protected int gPA;
  private Context mContext;
  private long ttg;
  private int wuW;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.gPA = 0;
    this.HlC = 0;
    this.cBJ = 0;
    this.ttg = 0L;
    this.wuW = -1;
    this.HlM = 0;
    this.HlN = new View.OnClickListener()
    {
      private final long ySC = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ac.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lh();
          paramAnonymousView.dna.dnb = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.a.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ac.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ac.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ac.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.HlO = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ac.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.HlQ = 0;
    this.HlR = 0;
    this.HlS = 0;
    this.HlT = false;
    this.HlU = false;
    this.HlV = 0;
    this.HlW = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.gPA = 0;
    this.HlC = 0;
    this.cBJ = 0;
    this.ttg = 0L;
    this.wuW = -1;
    this.HlM = 0;
    this.HlN = new View.OnClickListener()
    {
      private final long ySC = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ac.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lh();
          paramAnonymousView.dna.dnb = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.a.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ac.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ac.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ac.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.HlO = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ac.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.HlQ = 0;
    this.HlR = 0;
    this.HlS = 0;
    this.HlT = false;
    this.HlU = false;
    this.HlV = 0;
    this.HlW = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.gPA = 0;
    this.HlC = 0;
    this.cBJ = 0;
    this.ttg = 0L;
    this.wuW = -1;
    this.HlM = 0;
    this.HlN = new View.OnClickListener()
    {
      private final long ySC = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ac.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          paramAnonymousView = new lh();
          paramAnonymousView.dna.dnb = LauncherUIBottomTabView.d(LauncherUIBottomTabView.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (i == 0) {
          com.tencent.mm.plugin.report.a.a.a(1L, LauncherUIBottomTabView.d(LauncherUIBottomTabView.this), 0L, "");
        }
        if (LauncherUIBottomTabView.e(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ac.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ac.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ac.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.HlO = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ac.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.HlQ = 0;
    this.HlR = 0;
    this.HlS = 0;
    this.HlT = false;
    this.HlU = false;
    this.HlV = 0;
    this.HlW = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a Zs(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cc.a.ie(getContext())) {
      b.ahR();
    }
    for (locala.HlY = b.c((Activity)getContext(), 2131494777);; locala.HlY = b.c((Activity)getContext(), 2131494776))
    {
      locala.HlZ = ((TabIconView)locala.HlY.findViewById(2131300891));
      locala.Hma = ((TextView)locala.HlY.findViewById(2131300902));
      locala.Hmb = ((TextView)locala.HlY.findViewById(2131306196));
      locala.Hmb.setBackgroundResource(u.ks(getContext()));
      locala.Hmc = ((ImageView)locala.HlY.findViewById(2131299183));
      locala.HlY.setTag(Integer.valueOf(paramInt));
      locala.HlY.setOnClickListener(this.HlN);
      float f1 = com.tencent.mm.cc.a.av(getContext(), 2131165576);
      float f2 = com.tencent.mm.cc.a.ib(getContext());
      locala.Hma.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      b.ahR();
    }
  }
  
  private a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = Zs(0);
    locala.HlY.setId(-16777215);
    locala.Hma.setText(2131761077);
    locala.Hma.setTextColor(ao.aJ(this.mContext, 2130968584));
    locala.HlZ.h(2131690369, 2131690533, 2131690532, com.tencent.mm.cc.a.ie(getContext()));
    locala.Hmb.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.HlM);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.HlY, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = Zs(1);
    locala.HlY.setId(-16777214);
    locala.Hma.setText(2131761038);
    locala.Hma.setTextColor(ao.aJ(this.mContext, 2130968584));
    locala.HlZ.h(2131690379, 2131690549, 2131690548, com.tencent.mm.cc.a.ie(getContext()));
    locala.Hmb.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.HlM);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.HlY, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = Zs(2);
    locala.HlY.setId(-16777213);
    locala.Hma.setText(2131761036);
    locala.Hma.setTextColor(ao.aJ(this.mContext, 2130968584));
    locala.HlZ.h(2131690389, 2131690554, 2131690553, com.tencent.mm.cc.a.ie(getContext()));
    locala.Hmb.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.dkb().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.HlM);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.HlY, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = Zs(3);
    locala.HlY.setId(-16777212);
    locala.Hma.setText(2131761071);
    locala.Hma.setTextColor(ao.aJ(this.mContext, 2130968584));
    locala.HlZ.h(2131690427, 2131690592, 2131690592, com.tencent.mm.cc.a.ie(getContext()));
    locala.Hmb.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.dkb().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.HlM);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.HlY, localLayoutParams);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.HlP = new LinearLayout(getContext());
    this.HlP.setBackgroundColor(ao.aJ(this.mContext, 2130968578));
    this.HlP.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.HlP, localLayoutParams);
    this.HlM = ((int)(com.tencent.mm.cc.a.av(getContext(), 2131165256) * com.tencent.mm.cc.a.ib(getContext())));
    this.Hly = b(this.HlP);
    this.HlA = c(this.HlP);
    this.Hlz = d(this.HlP);
    this.HlB = e(this.HlP);
    this.HlC = getResources().getColor(2131100693);
    this.HlD = ((this.HlC & 0xFF0000) >> 16);
    this.HlE = ((this.HlC & 0xFF00) >> 8);
    this.HlF = (this.HlC & 0xFF);
    this.cBJ = ao.aJ(this.mContext, 2130968584);
    this.HlG = ((this.cBJ & 0xFF0000) >> 16);
    this.HlH = ((this.cBJ & 0xFF00) >> 8);
    this.HlI = (this.cBJ & 0xFF);
    this.HlJ = (this.HlD - this.HlG);
    this.HlK = (this.HlE - this.HlH);
    this.HlL = (this.HlF - this.HlI);
    AppMethodBeat.o(33350);
  }
  
  public final void Zj(int paramInt)
  {
    AppMethodBeat.i(33351);
    ac.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.HlQ = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Hly.Hmb.setText("");
        this.Hly.Hmb.setBackgroundResource(2131689744);
        this.Hly.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949));
        this.Hly.Hmb.setVisibility(0);
        this.Hly.Hmc.setVisibility(4);
        AppMethodBeat.o(33351);
        return;
      }
      this.Hly.Hmb.setText(String.valueOf(paramInt));
      this.Hly.Hmb.setBackgroundResource(u.aM(getContext(), paramInt));
      this.Hly.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949) * com.tencent.mm.cc.a.ib(getContext()));
      this.Hly.Hmb.setVisibility(0);
      this.Hly.Hmc.setVisibility(4);
      AppMethodBeat.o(33351);
      return;
    }
    this.Hly.Hmb.setText("");
    this.Hly.Hmb.setVisibility(4);
    AppMethodBeat.o(33351);
  }
  
  public final void Zk(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.HlR = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.HlA.Hmb.setText("");
        this.HlA.Hmb.setBackgroundResource(2131689744);
        this.HlA.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949));
        this.HlA.Hmb.setVisibility(0);
        this.HlA.Hmc.setVisibility(4);
        AppMethodBeat.o(33352);
        return;
      }
      this.HlA.Hmb.setText(String.valueOf(paramInt));
      this.HlA.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949) * com.tencent.mm.cc.a.ib(getContext()));
      this.HlA.Hmb.setBackgroundResource(u.aM(getContext(), paramInt));
      this.HlA.Hmb.setVisibility(0);
      this.HlA.Hmc.setVisibility(4);
      AppMethodBeat.o(33352);
      return;
    }
    this.HlA.Hmb.setText("");
    this.HlA.Hmb.setVisibility(4);
    AppMethodBeat.o(33352);
  }
  
  public final void Zl(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.HlS = paramInt;
    a locala = this.Hlz;
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
        this.Hlz.Hmb.setText("");
        this.Hlz.Hmb.setBackgroundResource(2131689744);
        this.Hlz.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949));
        this.Hlz.Hmb.setVisibility(0);
        this.Hlz.Hmc.setVisibility(4);
      }
      for (;;)
      {
        this.Hlz.a(k.vny, true);
        AppMethodBeat.o(33353);
        return;
        this.Hlz.Hmb.setText(String.valueOf(paramInt));
        this.Hlz.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949) * com.tencent.mm.cc.a.ib(getContext()));
        this.Hlz.Hmb.setVisibility(0);
        this.Hlz.Hmb.setBackgroundResource(u.aM(getContext(), paramInt));
        this.Hlz.Hmc.setVisibility(4);
      }
    }
    this.Hlz.Hmb.setText("");
    this.Hlz.Hmb.setVisibility(4);
    this.Hlz.a(k.vny, false);
    AppMethodBeat.o(33353);
  }
  
  public final void Zm(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.HlU)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.HlV = paramInt;
    a locala = this.HlB;
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
        this.HlB.Hmb.setText("");
        this.HlB.Hmb.setBackgroundResource(2131689744);
        this.HlB.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949));
        this.HlB.Hmb.setVisibility(0);
        this.HlB.Hmc.setVisibility(4);
      }
      for (;;)
      {
        this.HlB.a(k.vny, true);
        AppMethodBeat.o(33355);
        return;
        this.HlB.Hmb.setText(String.valueOf(paramInt));
        this.HlB.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166949) * com.tencent.mm.cc.a.ib(getContext()));
        this.HlB.Hmb.setVisibility(0);
        this.HlB.Hmb.setBackgroundResource(u.aM(getContext(), paramInt));
        this.HlB.Hmc.setVisibility(4);
      }
    }
    this.HlB.Hmb.setText("");
    this.HlB.Hmb.setVisibility(4);
    this.HlB.a(k.vny, false);
    AppMethodBeat.o(33355);
  }
  
  public final void feR()
  {
    if ((this.Hly != null) && (this.HlA != null) && (this.Hlz == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.HlR;
  }
  
  public int getCurIdx()
  {
    return this.gPA;
  }
  
  public int getFriendTabUnread()
  {
    return this.HlS;
  }
  
  public int getMainTabUnread()
  {
    return this.HlQ;
  }
  
  public boolean getSettingsPoint()
  {
    return this.HlW;
  }
  
  public int getSettingsTabUnread()
  {
    return this.HlV;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.HlT;
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.HlJ * paramFloat + this.HlG) << 16) + ((int)(this.HlK * paramFloat + this.HlH) << 8) + (int)(this.HlL * paramFloat + this.HlI) + (this.cBJ & 0xFF000000);
    int m = ((int)(this.HlJ * (1.0F - paramFloat) + this.HlG) << 16) + ((int)(this.HlK * (1.0F - paramFloat) + this.HlH) << 8) + (int)(this.HlL * (1.0F - paramFloat) + this.HlI) + (this.cBJ & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.Hly.HlZ.setFocusAlpha(j);
      this.HlA.HlZ.setFocusAlpha(i);
      this.Hly.Hma.setTextColor(m);
      this.HlA.Hma.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.HlA.HlZ.setFocusAlpha(j);
      this.Hlz.HlZ.setFocusAlpha(i);
      this.HlA.Hma.setTextColor(m);
      this.Hlz.Hma.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.Hlz.HlZ.setFocusAlpha(j);
      this.HlB.HlZ.setFocusAlpha(i);
      this.Hlz.Hma.setTextColor(m);
      this.HlB.Hma.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.Hlx = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.gPA = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.ttg = System.currentTimeMillis();
      this.wuW = this.gPA;
      AppMethodBeat.o(33358);
      return;
      this.Hly.HlZ.setFocusAlpha(255);
      this.Hlz.HlZ.setFocusAlpha(0);
      this.HlA.HlZ.setFocusAlpha(0);
      this.HlB.HlZ.setFocusAlpha(0);
      this.Hly.Hma.setTextColor(this.HlC);
      this.Hlz.Hma.setTextColor(this.cBJ);
      this.HlA.Hma.setTextColor(this.cBJ);
      this.HlB.Hma.setTextColor(this.cBJ);
      continue;
      this.Hly.HlZ.setFocusAlpha(0);
      this.Hlz.HlZ.setFocusAlpha(255);
      this.HlA.HlZ.setFocusAlpha(0);
      this.HlB.HlZ.setFocusAlpha(0);
      this.Hly.Hma.setTextColor(this.cBJ);
      this.Hlz.Hma.setTextColor(this.HlC);
      this.HlA.Hma.setTextColor(this.cBJ);
      this.HlB.Hma.setTextColor(this.cBJ);
      continue;
      this.Hly.HlZ.setFocusAlpha(0);
      this.Hlz.HlZ.setFocusAlpha(0);
      this.HlA.HlZ.setFocusAlpha(255);
      this.HlB.HlZ.setFocusAlpha(0);
      this.Hly.Hma.setTextColor(this.cBJ);
      this.Hlz.Hma.setTextColor(this.cBJ);
      this.HlA.Hma.setTextColor(this.HlC);
      this.HlB.Hma.setTextColor(this.cBJ);
      continue;
      this.Hly.HlZ.setFocusAlpha(0);
      this.Hlz.HlZ.setFocusAlpha(0);
      this.HlA.HlZ.setFocusAlpha(0);
      this.HlB.HlZ.setFocusAlpha(255);
      this.Hly.Hma.setTextColor(this.cBJ);
      this.Hlz.Hma.setTextColor(this.cBJ);
      this.HlA.Hma.setTextColor(this.cBJ);
      this.HlB.Hma.setTextColor(this.HlC);
    }
  }
  
  public final void wl(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.Hlz))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.HlT = paramBoolean;
    this.Hlz.Hmb.setVisibility(4);
    ImageView localImageView = this.Hlz.Hmc;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.Hlz.a(k.vnt, paramBoolean);
    AppMethodBeat.o(33354);
  }
  
  public final void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.HlU)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.HlB))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.zAU;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.yr(l);
      this.HlW = paramBoolean;
      this.HlB.Hmb.setVisibility(4);
      localObject = this.HlB.Hmc;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.HlB.a(k.vnt, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View HlY;
    TabIconView HlZ;
    TextView Hma;
    TextView Hmb;
    ImageView Hmc;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dhn paramdhn)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramdhn.gMk > 99)
        {
          this.Hmb.setText("");
          this.Hmb.setBackgroundResource(2131689744);
          this.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(LauncherUIBottomTabView.this.getContext(), 2131166949));
          this.Hmb.setVisibility(0);
          this.Hmc.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.Hmb.setText(String.valueOf(paramdhn.gMk));
        this.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(LauncherUIBottomTabView.this.getContext(), 2131166949) * com.tencent.mm.cc.a.ib(LauncherUIBottomTabView.this.getContext()));
        this.Hmb.setVisibility(0);
        this.Hmb.setBackgroundResource(u.aM(LauncherUIBottomTabView.this.getContext(), paramdhn.gMk));
        this.Hmc.setVisibility(4);
        continue;
        this.Hmb.setText("");
        this.Hmb.setVisibility(4);
      }
    }
    
    public final boolean dbk()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.HlY;
    }
    
    public final boolean nR(boolean paramBoolean)
    {
      AppMethodBeat.i(210123);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(210123);
      return paramBoolean;
    }
    
    public final boolean nS(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.Hmb.setVisibility(4);
      ImageView localImageView = this.Hmc;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean nT(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.Hmb.setText(LauncherUIBottomTabView.this.getResources().getString(2131764544));
        this.Hmb.setBackgroundResource(2131233430);
        this.Hmb.setTextSize(0, com.tencent.mm.cc.a.av(LauncherUIBottomTabView.this.getContext(), 2131165267));
        this.Hmb.setVisibility(0);
        this.Hmc.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.Hmb.setText("");
        this.Hmb.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */