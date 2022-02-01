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
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.tools.u;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  private int FMA;
  private int FMB;
  private int FMC;
  private int FMD;
  private int FME;
  protected View.OnClickListener FMF;
  private ap FMG;
  private LinearLayout FMH;
  private int FMI;
  private int FMJ;
  private int FMK;
  private boolean FML;
  private boolean FMM;
  private int FMN;
  private boolean FMO;
  private c.a FMp;
  protected a FMq;
  protected a FMr;
  protected a FMs;
  protected a FMt;
  private int FMu;
  private int FMv;
  private int FMw;
  private int FMx;
  private int FMy;
  private int FMz;
  private int cEB;
  protected int goS;
  private Context mContext;
  private long sln;
  private int vmo;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.goS = 0;
    this.FMu = 0;
    this.cEB = 0;
    this.sln = 0L;
    this.vmo = -1;
    this.FME = 0;
    this.FMF = new View.OnClickListener()
    {
      private final long xFP = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.ESL.l(new ky());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.FMG = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.FMI = 0;
    this.FMJ = 0;
    this.FMK = 0;
    this.FML = false;
    this.FMM = false;
    this.FMN = 0;
    this.FMO = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.goS = 0;
    this.FMu = 0;
    this.cEB = 0;
    this.sln = 0L;
    this.vmo = -1;
    this.FME = 0;
    this.FMF = new View.OnClickListener()
    {
      private final long xFP = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.ESL.l(new ky());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.FMG = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.FMI = 0;
    this.FMJ = 0;
    this.FMK = 0;
    this.FML = false;
    this.FMM = false;
    this.FMN = 0;
    this.FMO = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.goS = 0;
    this.FMu = 0;
    this.cEB = 0;
    this.sln = 0L;
    this.vmo = -1;
    this.FME = 0;
    this.FMF = new View.OnClickListener()
    {
      private final long xFP = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.ESL.l(new ky());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          AppMethodBeat.o(33335);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            ad.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(i);
            AppMethodBeat.o(33335);
            return;
          }
          ad.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33335);
      }
    };
    this.FMG = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.FMI = 0;
    this.FMJ = 0;
    this.FMK = 0;
    this.FML = false;
    this.FMM = false;
    this.FMN = 0;
    this.FMO = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a Xi(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cd.a.hT(getContext())) {
      b.agA();
    }
    for (locala.FMQ = b.c((Activity)getContext(), 2131494777);; locala.FMQ = b.c((Activity)getContext(), 2131494776))
    {
      locala.FMR = ((TabIconView)locala.FMQ.findViewById(2131300891));
      locala.FMS = ((TextView)locala.FMQ.findViewById(2131300902));
      locala.FMT = ((TextView)locala.FMQ.findViewById(2131306196));
      locala.FMT.setBackgroundResource(u.kh(getContext()));
      locala.FMU = ((ImageView)locala.FMQ.findViewById(2131299183));
      locala.FMQ.setTag(Integer.valueOf(paramInt));
      locala.FMQ.setOnClickListener(this.FMF);
      float f1 = com.tencent.mm.cd.a.ap(getContext(), 2131165576);
      float f2 = com.tencent.mm.cd.a.hQ(getContext());
      locala.FMS.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      b.agA();
    }
  }
  
  private a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = Xi(0);
    locala.FMQ.setId(-16777215);
    locala.FMS.setText(2131761077);
    locala.FMS.setTextColor(ao.aD(this.mContext, 2130968584));
    locala.FMR.g(2131690369, 2131690533, 2131690532, com.tencent.mm.cd.a.hT(getContext()));
    locala.FMT.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.FME);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FMQ, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = Xi(1);
    locala.FMQ.setId(-16777214);
    locala.FMS.setText(2131761038);
    locala.FMS.setTextColor(ao.aD(this.mContext, 2130968584));
    locala.FMR.g(2131690379, 2131690549, 2131690548, com.tencent.mm.cd.a.hT(getContext()));
    locala.FMT.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.FME);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FMQ, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = Xi(2);
    locala.FMQ.setId(-16777213);
    locala.FMS.setText(2131761036);
    locala.FMS.setTextColor(ao.aD(this.mContext, 2130968584));
    locala.FMR.g(2131690389, 2131690554, 2131690553, com.tencent.mm.cd.a.hT(getContext()));
    locala.FMT.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.cWs().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.FME);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FMQ, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = Xi(3);
    locala.FMQ.setId(-16777212);
    locala.FMS.setText(2131761071);
    locala.FMS.setTextColor(ao.aD(this.mContext, 2130968584));
    locala.FMR.g(2131690427, 2131690592, 2131690592, com.tencent.mm.cd.a.hT(getContext()));
    locala.FMT.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.cWs().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.FME);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FMQ, localLayoutParams);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.FMH = new LinearLayout(getContext());
    this.FMH.setBackgroundColor(ao.aD(this.mContext, 2130968578));
    this.FMH.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.FMH, localLayoutParams);
    this.FME = ((int)(com.tencent.mm.cd.a.ap(getContext(), 2131165256) * com.tencent.mm.cd.a.hQ(getContext())));
    this.FMq = b(this.FMH);
    this.FMs = c(this.FMH);
    this.FMr = d(this.FMH);
    this.FMt = e(this.FMH);
    this.FMu = getResources().getColor(2131100693);
    this.FMv = ((this.FMu & 0xFF0000) >> 16);
    this.FMw = ((this.FMu & 0xFF00) >> 8);
    this.FMx = (this.FMu & 0xFF);
    this.cEB = ao.aD(this.mContext, 2130968584);
    this.FMy = ((this.cEB & 0xFF0000) >> 16);
    this.FMz = ((this.cEB & 0xFF00) >> 8);
    this.FMA = (this.cEB & 0xFF);
    this.FMB = (this.FMv - this.FMy);
    this.FMC = (this.FMw - this.FMz);
    this.FMD = (this.FMx - this.FMA);
    AppMethodBeat.o(33350);
  }
  
  public final void WZ(int paramInt)
  {
    AppMethodBeat.i(33351);
    ad.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.FMI = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FMq.FMT.setText("");
        this.FMq.FMT.setBackgroundResource(2131689744);
        this.FMq.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949));
        this.FMq.FMT.setVisibility(0);
        this.FMq.FMU.setVisibility(4);
        AppMethodBeat.o(33351);
        return;
      }
      this.FMq.FMT.setText(String.valueOf(paramInt));
      this.FMq.FMT.setBackgroundResource(u.aG(getContext(), paramInt));
      this.FMq.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949) * com.tencent.mm.cd.a.hQ(getContext()));
      this.FMq.FMT.setVisibility(0);
      this.FMq.FMU.setVisibility(4);
      AppMethodBeat.o(33351);
      return;
    }
    this.FMq.FMT.setText("");
    this.FMq.FMT.setVisibility(4);
    AppMethodBeat.o(33351);
  }
  
  public final void Xa(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.FMJ = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FMs.FMT.setText("");
        this.FMs.FMT.setBackgroundResource(2131689744);
        this.FMs.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949));
        this.FMs.FMT.setVisibility(0);
        this.FMs.FMU.setVisibility(4);
        AppMethodBeat.o(33352);
        return;
      }
      this.FMs.FMT.setText(String.valueOf(paramInt));
      this.FMs.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949) * com.tencent.mm.cd.a.hQ(getContext()));
      this.FMs.FMT.setBackgroundResource(u.aG(getContext(), paramInt));
      this.FMs.FMT.setVisibility(0);
      this.FMs.FMU.setVisibility(4);
      AppMethodBeat.o(33352);
      return;
    }
    this.FMs.FMT.setText("");
    this.FMs.FMT.setVisibility(4);
    AppMethodBeat.o(33352);
  }
  
  public final void Xb(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.FMK = paramInt;
    a locala = this.FMr;
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
        this.FMr.FMT.setText("");
        this.FMr.FMT.setBackgroundResource(2131689744);
        this.FMr.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949));
        this.FMr.FMT.setVisibility(0);
        this.FMr.FMU.setVisibility(4);
      }
      for (;;)
      {
        this.FMr.a(k.ueA, true);
        AppMethodBeat.o(33353);
        return;
        this.FMr.FMT.setText(String.valueOf(paramInt));
        this.FMr.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949) * com.tencent.mm.cd.a.hQ(getContext()));
        this.FMr.FMT.setVisibility(0);
        this.FMr.FMT.setBackgroundResource(u.aG(getContext(), paramInt));
        this.FMr.FMU.setVisibility(4);
      }
    }
    this.FMr.FMT.setText("");
    this.FMr.FMT.setVisibility(4);
    this.FMr.a(k.ueA, false);
    AppMethodBeat.o(33353);
  }
  
  public final void Xc(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.FMM)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.FMN = paramInt;
    a locala = this.FMt;
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
        this.FMt.FMT.setText("");
        this.FMt.FMT.setBackgroundResource(2131689744);
        this.FMt.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949));
        this.FMt.FMT.setVisibility(0);
        this.FMt.FMU.setVisibility(4);
      }
      for (;;)
      {
        this.FMt.a(k.ueA, true);
        AppMethodBeat.o(33355);
        return;
        this.FMt.FMT.setText(String.valueOf(paramInt));
        this.FMt.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166949) * com.tencent.mm.cd.a.hQ(getContext()));
        this.FMt.FMT.setVisibility(0);
        this.FMt.FMT.setBackgroundResource(u.aG(getContext(), paramInt));
        this.FMt.FMU.setVisibility(4);
      }
    }
    this.FMt.FMT.setText("");
    this.FMt.FMT.setVisibility(4);
    this.FMt.a(k.ueA, false);
    AppMethodBeat.o(33355);
  }
  
  public final void ePn()
  {
    if ((this.FMq != null) && (this.FMs != null) && (this.FMr == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.FMJ;
  }
  
  public int getCurIdx()
  {
    return this.goS;
  }
  
  public int getFriendTabUnread()
  {
    return this.FMK;
  }
  
  public int getMainTabUnread()
  {
    return this.FMI;
  }
  
  public boolean getSettingsPoint()
  {
    return this.FMO;
  }
  
  public int getSettingsTabUnread()
  {
    return this.FMN;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.FML;
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.FMB * paramFloat + this.FMy) << 16) + ((int)(this.FMC * paramFloat + this.FMz) << 8) + (int)(this.FMD * paramFloat + this.FMA) + (this.cEB & 0xFF000000);
    int m = ((int)(this.FMB * (1.0F - paramFloat) + this.FMy) << 16) + ((int)(this.FMC * (1.0F - paramFloat) + this.FMz) << 8) + (int)(this.FMD * (1.0F - paramFloat) + this.FMA) + (this.cEB & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.FMq.FMR.setFocusAlpha(j);
      this.FMs.FMR.setFocusAlpha(i);
      this.FMq.FMS.setTextColor(m);
      this.FMs.FMS.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.FMs.FMR.setFocusAlpha(j);
      this.FMr.FMR.setFocusAlpha(i);
      this.FMs.FMS.setTextColor(m);
      this.FMr.FMS.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.FMr.FMR.setFocusAlpha(j);
      this.FMt.FMR.setFocusAlpha(i);
      this.FMr.FMS.setTextColor(m);
      this.FMt.FMS.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.FMp = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.goS = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.sln = System.currentTimeMillis();
      this.vmo = this.goS;
      AppMethodBeat.o(33358);
      return;
      this.FMq.FMR.setFocusAlpha(255);
      this.FMr.FMR.setFocusAlpha(0);
      this.FMs.FMR.setFocusAlpha(0);
      this.FMt.FMR.setFocusAlpha(0);
      this.FMq.FMS.setTextColor(this.FMu);
      this.FMr.FMS.setTextColor(this.cEB);
      this.FMs.FMS.setTextColor(this.cEB);
      this.FMt.FMS.setTextColor(this.cEB);
      continue;
      this.FMq.FMR.setFocusAlpha(0);
      this.FMr.FMR.setFocusAlpha(255);
      this.FMs.FMR.setFocusAlpha(0);
      this.FMt.FMR.setFocusAlpha(0);
      this.FMq.FMS.setTextColor(this.cEB);
      this.FMr.FMS.setTextColor(this.FMu);
      this.FMs.FMS.setTextColor(this.cEB);
      this.FMt.FMS.setTextColor(this.cEB);
      continue;
      this.FMq.FMR.setFocusAlpha(0);
      this.FMr.FMR.setFocusAlpha(0);
      this.FMs.FMR.setFocusAlpha(255);
      this.FMt.FMR.setFocusAlpha(0);
      this.FMq.FMS.setTextColor(this.cEB);
      this.FMr.FMS.setTextColor(this.cEB);
      this.FMs.FMS.setTextColor(this.FMu);
      this.FMt.FMS.setTextColor(this.cEB);
      continue;
      this.FMq.FMR.setFocusAlpha(0);
      this.FMr.FMR.setFocusAlpha(0);
      this.FMs.FMR.setFocusAlpha(0);
      this.FMt.FMR.setFocusAlpha(255);
      this.FMq.FMS.setTextColor(this.cEB);
      this.FMr.FMS.setTextColor(this.cEB);
      this.FMs.FMS.setTextColor(this.cEB);
      this.FMt.FMS.setTextColor(this.FMu);
    }
  }
  
  public final void vj(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.FMr))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.FML = paramBoolean;
    this.FMr.FMT.setVisibility(4);
    ImageView localImageView = this.FMr.FMU;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.FMr.a(k.uev, paramBoolean);
    AppMethodBeat.o(33354);
  }
  
  public final void vk(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.FMM)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.FMt))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.ynv;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.tO(l);
      this.FMO = paramBoolean;
      this.FMt.FMT.setVisibility(4);
      localObject = this.FMt.FMU;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.FMt.a(k.uev, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View FMQ;
    TabIconView FMR;
    TextView FMS;
    TextView FMT;
    ImageView FMU;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean cND()
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dcb paramdcb)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramdcb.glx > 99)
        {
          this.FMT.setText("");
          this.FMT.setBackgroundResource(2131689744);
          this.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(LauncherUIBottomTabView.this.getContext(), 2131166949));
          this.FMT.setVisibility(0);
          this.FMU.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.FMT.setText(String.valueOf(paramdcb.glx));
        this.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(LauncherUIBottomTabView.this.getContext(), 2131166949) * com.tencent.mm.cd.a.hQ(LauncherUIBottomTabView.this.getContext()));
        this.FMT.setVisibility(0);
        this.FMT.setBackgroundResource(u.aG(LauncherUIBottomTabView.this.getContext(), paramdcb.glx));
        this.FMU.setVisibility(4);
        continue;
        this.FMT.setText("");
        this.FMT.setVisibility(4);
      }
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.FMQ;
    }
    
    public final boolean mY(boolean paramBoolean)
    {
      AppMethodBeat.i(204899);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(204899);
      return paramBoolean;
    }
    
    public final boolean mZ(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.FMT.setVisibility(4);
      ImageView localImageView = this.FMU;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean na(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.FMT.setText(LauncherUIBottomTabView.this.getResources().getString(2131764544));
        this.FMT.setBackgroundResource(2131233430);
        this.FMT.setTextSize(0, com.tencent.mm.cd.a.ap(LauncherUIBottomTabView.this.getContext(), 2131165267));
        this.FMT.setVisibility(0);
        this.FMU.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.FMT.setText("");
        this.FMT.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */