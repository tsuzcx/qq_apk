package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.abt;
import com.tencent.mm.f.a.abt.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.w;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements d
{
  private long CZh;
  private int HQb;
  protected a VXA;
  protected a VXB;
  protected a VXC;
  protected a VXD;
  private int VXE;
  private int VXF;
  private int VXG;
  private int VXH;
  private int VXI;
  private int VXJ;
  private int VXK;
  private int VXL;
  private int VXM;
  private int VXN;
  private int VXO;
  protected View.OnClickListener VXP;
  private MMHandler VXQ;
  private LinearLayout VXR;
  private int VXS;
  private int VXT;
  private int VXU;
  private boolean VXV;
  private boolean VXW;
  private int VXX;
  private boolean VXY;
  private d.a VXz;
  private int dhS;
  private Context mContext;
  protected int wzx;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.wzx = 0;
    this.VXE = 0;
    this.dhS = 0;
    this.CZh = 0L;
    this.HQb = -1;
    this.VXO = 0;
    this.VXP = new View.OnClickListener()
    {
      private final long Qhx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.VXQ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.VXS = 0;
    this.VXT = 0;
    this.VXU = 0;
    this.VXV = false;
    this.VXW = false;
    this.VXX = 0;
    this.VXY = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.wzx = 0;
    this.VXE = 0;
    this.dhS = 0;
    this.CZh = 0L;
    this.HQb = -1;
    this.VXO = 0;
    this.VXP = new View.OnClickListener()
    {
      private final long Qhx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.VXQ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.VXS = 0;
    this.VXT = 0;
    this.VXU = 0;
    this.VXV = false;
    this.VXW = false;
    this.VXX = 0;
    this.VXY = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.wzx = 0;
    this.VXE = 0;
    this.dhS = 0;
    this.CZh = 0L;
    this.HQb = -1;
    this.VXO = 0;
    this.VXP = new View.OnClickListener()
    {
      private final long Qhx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.VXQ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.VXS = 0;
    this.VXT = 0;
    this.VXU = 0;
    this.VXV = false;
    this.VXW = false;
    this.VXX = 0;
    this.VXY = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a atL(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.ci.a.kp(getContext())) {
      com.tencent.mm.kiss.a.b.aIK();
    }
    for (locala.VYa = com.tencent.mm.kiss.a.b.d((Activity)getContext(), R.i.eiK);; locala.VYa = com.tencent.mm.kiss.a.b.d((Activity)getContext(), R.i.eiJ))
    {
      locala.VYb = ((TabIconView)locala.VYa.findViewById(R.h.icon_iv));
      locala.VYc = ((TextView)locala.VYa.findViewById(R.h.dIC));
      locala.VYd = ((TextView)locala.VYa.findViewById(R.h.dYv));
      locala.VYd.setBackgroundResource(w.lE(getContext()));
      locala.VYe = ((ImageView)locala.VYa.findViewById(R.h.dot_iv));
      locala.VYa.setTag(Integer.valueOf(paramInt));
      locala.VYa.setOnClickListener(this.VXP);
      float f1 = com.tencent.mm.ci.a.aZ(getContext(), R.f.SmallestTextSize);
      float f2 = com.tencent.mm.ci.a.km(getContext());
      locala.VYc.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      com.tencent.mm.kiss.a.b.aIK();
    }
  }
  
  private void atM(int paramInt)
  {
    AppMethodBeat.i(289542);
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
        Object localObject = locala.VYd.getText().toString().trim();
        abt localabt = new abt();
        localabt.gbD.fXY = paramInt;
        localabt.gbD.gbF = Util.getInt((String)localObject, 0);
        localObject = localabt.gbD;
        if (locala.VYe.getVisibility() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((abt.a)localObject).gbE = bool;
          EventCenter.instance.publish(localabt);
          AppMethodBeat.o(289542);
          return;
          locala = this.VXA;
          break;
          locala = this.VXC;
          break;
          locala = this.VXB;
          break;
          locala = this.VXD;
          break;
        }
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUITabView", localException, "notify tab reddot tabIndex [%d]", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(289542);
      }
    }
  }
  
  private a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = atL(0);
    locala.VYa.setId(-16777215);
    locala.VYc.setText(R.l.main_title);
    locala.VYc.setTextColor(getResources().getColor(R.e.FG_0));
    locala.VYb.i(R.k.icons_filled_chats_hl, R.k.icons_outlined_chats_middle, R.k.icons_outlined_chats, com.tencent.mm.ci.a.kp(getContext()));
    locala.VYd.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.VXO);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYa, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = atL(1);
    locala.VYa.setId(-16777214);
    locala.VYc.setText(R.l.eKZ);
    locala.VYc.setTextColor(getResources().getColor(R.e.FG_0));
    locala.VYb.i(R.k.icons_filled_contacts_hl, R.k.icons_outlined_contacts_middle, R.k.icons_outlined_contacts, com.tencent.mm.ci.a.kp(getContext()));
    locala.VYd.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.VXO);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYa, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = atL(2);
    locala.VYa.setId(-16777213);
    locala.VYc.setText(R.l.eKX);
    locala.VYc.setTextColor(getResources().getColor(R.e.FG_0));
    locala.VYb.i(R.k.icons_filled_discover_hl, R.k.icons_outlined_discover_middle, R.k.icons_outlined_discover, com.tencent.mm.ci.a.kp(getContext()));
    locala.VYd.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.fiO().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.VXO);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.VYa, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = atL(3);
    locala.VYa.setId(-16777212);
    locala.VYc.setText(R.l.eLu);
    locala.VYc.setTextColor(getResources().getColor(R.e.FG_0));
    Object localObject = locala.VYb;
    int i = R.k.icons_filled_me_hl;
    int j = R.k.icons_outlined_me;
    ((TabIconView)localObject).i(i, j, j, com.tencent.mm.ci.a.kp(getContext()));
    locala.VYd.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.fiO().h(locala);
    localObject = new LinearLayout.LayoutParams(0, this.VXO);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    paramLinearLayout.addView(locala.VYa, (ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.VXR = new LinearLayout(getContext());
    this.VXR.setBackgroundColor(getResources().getColor(R.e.BG_1));
    this.VXR.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.VXR, localLayoutParams);
    this.VXO = ((int)(com.tencent.mm.ci.a.aZ(getContext(), R.f.DefaultTabbarHeight) * com.tencent.mm.ci.a.km(getContext())));
    this.VXA = e(this.VXR);
    this.VXC = f(this.VXR);
    this.VXB = g(this.VXR);
    this.VXD = h(this.VXR);
    this.VXE = getResources().getColor(R.e.navbar_text_focus);
    this.VXF = ((this.VXE & 0xFF0000) >> 16);
    this.VXG = ((this.VXE & 0xFF00) >> 8);
    this.VXH = (this.VXE & 0xFF);
    this.dhS = getResources().getColor(R.e.FG_0);
    this.VXI = ((this.dhS & 0xFF0000) >> 16);
    this.VXJ = ((this.dhS & 0xFF00) >> 8);
    this.VXK = (this.dhS & 0xFF);
    this.VXL = (this.VXF - this.VXI);
    this.VXM = (this.VXG - this.VXJ);
    this.VXN = (this.VXH - this.VXK);
    AppMethodBeat.o(33350);
  }
  
  public final void Fi(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.VXB))
    {
      AppMethodBeat.o(33354);
      return;
    }
    this.VXV = paramBoolean;
    this.VXB.VYd.setVisibility(4);
    ImageView localImageView = this.VXB.VYe;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.VXB.a(k.GwK, paramBoolean);
    atM(2);
    AppMethodBeat.o(33354);
  }
  
  public final void Fj(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.VXW)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.VXD))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.LOJ;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.RM(l);
      this.VXY = paramBoolean;
      this.VXD.VYd.setVisibility(4);
      localObject = this.VXD.VYe;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.VXD.a(k.GwK, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void atB(int paramInt)
  {
    AppMethodBeat.i(33351);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.VXS = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.VXA.VYd.setText("");
        this.VXA.VYd.setBackgroundResource(R.k.badge_count_more);
        this.VXA.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize));
        this.VXA.VYd.setVisibility(0);
        this.VXA.VYe.setVisibility(4);
      }
    }
    for (;;)
    {
      atM(0);
      AppMethodBeat.o(33351);
      return;
      this.VXA.VYd.setText(String.valueOf(paramInt));
      this.VXA.VYd.setBackgroundResource(w.bj(getContext(), paramInt));
      this.VXA.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(getContext()));
      this.VXA.VYd.setVisibility(0);
      this.VXA.VYe.setVisibility(4);
      continue;
      this.VXA.VYd.setText("");
      this.VXA.VYd.setVisibility(4);
    }
  }
  
  public final void atC(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.VXT = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.VXC.VYd.setText("");
        this.VXC.VYd.setBackgroundResource(R.k.badge_count_more);
        this.VXC.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize));
        this.VXC.VYd.setVisibility(0);
        this.VXC.VYe.setVisibility(4);
      }
    }
    for (;;)
    {
      atM(1);
      AppMethodBeat.o(33352);
      return;
      this.VXC.VYd.setText(String.valueOf(paramInt));
      this.VXC.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(getContext()));
      this.VXC.VYd.setBackgroundResource(w.bj(getContext(), paramInt));
      this.VXC.VYd.setVisibility(0);
      this.VXC.VYe.setVisibility(4);
      continue;
      this.VXC.VYd.setText("");
      this.VXC.VYd.setVisibility(4);
    }
  }
  
  public final void atD(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.VXU = paramInt;
    a locala = this.VXB;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33353);
      return;
    }
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.VXB.VYd.setText("");
        this.VXB.VYd.setBackgroundResource(R.k.badge_count_more);
        this.VXB.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize));
        this.VXB.VYd.setVisibility(0);
        this.VXB.VYe.setVisibility(4);
        this.VXB.a(k.GwP, true);
      }
    }
    for (;;)
    {
      atM(2);
      AppMethodBeat.o(33353);
      return;
      this.VXB.VYd.setText(String.valueOf(paramInt));
      this.VXB.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(getContext()));
      this.VXB.VYd.setVisibility(0);
      this.VXB.VYd.setBackgroundResource(w.bj(getContext(), paramInt));
      this.VXB.VYe.setVisibility(4);
      break;
      this.VXB.VYd.setText("");
      this.VXB.VYd.setVisibility(4);
      this.VXB.a(k.GwP, false);
    }
  }
  
  public final void atE(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.VXW)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.VXX = paramInt;
    a locala = this.VXD;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33355);
      return;
    }
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.VXD.VYd.setText("");
        this.VXD.VYd.setBackgroundResource(R.k.badge_count_more);
        this.VXD.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize));
        this.VXD.VYd.setVisibility(0);
        this.VXD.VYe.setVisibility(4);
        this.VXD.a(k.GwP, true);
      }
    }
    for (;;)
    {
      atM(3);
      AppMethodBeat.o(33355);
      return;
      this.VXD.VYd.setText(String.valueOf(paramInt));
      this.VXD.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(getContext()));
      this.VXD.VYd.setVisibility(0);
      this.VXD.VYd.setBackgroundResource(w.bj(getContext(), paramInt));
      this.VXD.VYe.setVisibility(4);
      break;
      this.VXD.VYd.setText("");
      this.VXD.VYd.setVisibility(4);
      this.VXD.a(k.GwP, false);
    }
  }
  
  public int getContactTabUnread()
  {
    return this.VXT;
  }
  
  public int getCurIdx()
  {
    return this.wzx;
  }
  
  public int getFriendTabUnread()
  {
    return this.VXU;
  }
  
  public int getMainTabUnread()
  {
    return this.VXS;
  }
  
  public boolean getSettingsPoint()
  {
    return this.VXY;
  }
  
  public int getSettingsTabUnread()
  {
    return this.VXX;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.VXV;
  }
  
  public final void hFw()
  {
    if ((this.VXA != null) && (this.VXC != null) && (this.VXB == null)) {}
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.VXL * paramFloat + this.VXI) << 16) + ((int)(this.VXM * paramFloat + this.VXJ) << 8) + (int)(this.VXN * paramFloat + this.VXK) + (this.dhS & 0xFF000000);
    int m = ((int)(this.VXL * (1.0F - paramFloat) + this.VXI) << 16) + ((int)(this.VXM * (1.0F - paramFloat) + this.VXJ) << 8) + (int)(this.VXN * (1.0F - paramFloat) + this.VXK) + (this.dhS & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33357);
      return;
      this.VXA.VYb.setFocusAlpha(j);
      this.VXC.VYb.setFocusAlpha(i);
      this.VXA.VYc.setTextColor(m);
      this.VXC.VYc.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.VXC.VYb.setFocusAlpha(j);
      this.VXB.VYb.setFocusAlpha(i);
      this.VXC.VYc.setTextColor(m);
      this.VXB.VYc.setTextColor(k);
      AppMethodBeat.o(33357);
      return;
      this.VXB.VYb.setFocusAlpha(j);
      this.VXD.VYb.setFocusAlpha(i);
      this.VXB.VYc.setTextColor(m);
      this.VXD.VYc.setTextColor(k);
    }
  }
  
  public void setOnTabClickListener(d.a parama)
  {
    this.VXz = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.wzx = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.CZh = System.currentTimeMillis();
      this.HQb = this.wzx;
      AppMethodBeat.o(33358);
      return;
      this.VXA.VYb.setFocusAlpha(255);
      this.VXB.VYb.setFocusAlpha(0);
      this.VXC.VYb.setFocusAlpha(0);
      this.VXD.VYb.setFocusAlpha(0);
      this.VXA.VYc.setTextColor(this.VXE);
      this.VXB.VYc.setTextColor(this.dhS);
      this.VXC.VYc.setTextColor(this.dhS);
      this.VXD.VYc.setTextColor(this.dhS);
      continue;
      this.VXA.VYb.setFocusAlpha(0);
      this.VXB.VYb.setFocusAlpha(255);
      this.VXC.VYb.setFocusAlpha(0);
      this.VXD.VYb.setFocusAlpha(0);
      this.VXA.VYc.setTextColor(this.dhS);
      this.VXB.VYc.setTextColor(this.VXE);
      this.VXC.VYc.setTextColor(this.dhS);
      this.VXD.VYc.setTextColor(this.dhS);
      continue;
      this.VXA.VYb.setFocusAlpha(0);
      this.VXB.VYb.setFocusAlpha(0);
      this.VXC.VYb.setFocusAlpha(255);
      this.VXD.VYb.setFocusAlpha(0);
      this.VXA.VYc.setTextColor(this.dhS);
      this.VXB.VYc.setTextColor(this.dhS);
      this.VXC.VYc.setTextColor(this.VXE);
      this.VXD.VYc.setTextColor(this.dhS);
      continue;
      this.VXA.VYb.setFocusAlpha(0);
      this.VXB.VYb.setFocusAlpha(0);
      this.VXC.VYb.setFocusAlpha(0);
      this.VXD.VYb.setFocusAlpha(255);
      this.VXA.VYc.setTextColor(this.dhS);
      this.VXB.VYc.setTextColor(this.dhS);
      this.VXC.VYc.setTextColor(this.dhS);
      this.VXD.VYc.setTextColor(this.VXE);
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View VYa;
    TabIconView VYb;
    TextView VYc;
    TextView VYd;
    ImageView VYe;
    String path;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramerx.num > 99)
        {
          this.VYd.setText("");
          this.VYd.setBackgroundResource(R.k.badge_count_more);
          this.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(LauncherUIBottomTabView.this.getContext(), R.f.unReadCountTextSize));
          this.VYd.setVisibility(0);
          this.VYe.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.VYd.setText(String.valueOf(paramerx.num));
        this.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(LauncherUIBottomTabView.this.getContext(), R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(LauncherUIBottomTabView.this.getContext()));
        this.VYd.setVisibility(0);
        this.VYd.setBackgroundResource(w.bj(LauncherUIBottomTabView.this.getContext(), paramerx.num));
        this.VYe.setVisibility(4);
        continue;
        this.VYd.setText("");
        this.VYd.setVisibility(4);
      }
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.VYa;
    }
    
    public final boolean tX(boolean paramBoolean)
    {
      AppMethodBeat.i(293355);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(293355);
      return paramBoolean;
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.VYd.setVisibility(4);
      ImageView localImageView = this.VYe;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.VYd.setText(LauncherUIBottomTabView.this.getResources().getString(R.l.ui_new));
        this.VYd.setBackgroundResource(R.g.new_tips_bg);
        this.VYd.setTextSize(0, com.tencent.mm.ci.a.aZ(LauncherUIBottomTabView.this.getContext(), R.f.DialogUserNameSize));
        this.VYd.setVisibility(0);
        this.VYe.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.VYd.setText("");
        this.VYd.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */