package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
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
import com.tencent.mm.autogen.a.adq;
import com.tencent.mm.autogen.a.adq.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.v;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements d
{
  private static int akmf;
  private static int akmg;
  private long ITx;
  private int NMH;
  private d.a adBV;
  protected a adBW;
  protected a adBX;
  protected a adBY;
  protected a adBZ;
  private int adCa;
  private int adCb;
  private int adCc;
  private int adCd;
  private int adCe;
  private int adCf;
  private int adCg;
  private int adCh;
  private int adCi;
  private int adCj;
  private int adCk;
  protected View.OnClickListener adCl;
  private MMHandler adCm;
  private LinearLayout adCn;
  private int adCo;
  private int adCp;
  private int adCq;
  private boolean adCr;
  private boolean adCs;
  private int adCt;
  private boolean adCu;
  private boolean akmh;
  private int fhH;
  private Context mContext;
  protected int zVI;
  
  static
  {
    AppMethodBeat.i(369629);
    akmf = (int)MMApplicationContext.getContext().getResources().getDimension(R.f.Edge_1_5_A);
    akmg = (int)MMApplicationContext.getContext().getResources().getDimension(R.f.finder_2_25_A);
    AppMethodBeat.o(369629);
  }
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33342);
    this.zVI = 0;
    this.adCa = 0;
    this.fhH = 0;
    this.ITx = 0L;
    this.NMH = -1;
    this.adCk = 0;
    this.adCl = new View.OnClickListener()
    {
      private final long WZx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.adCm = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.adCo = 0;
    this.adCp = 0;
    this.adCq = 0;
    this.adCr = false;
    this.akmh = false;
    this.adCs = false;
    this.adCt = 0;
    this.adCu = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33342);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33343);
    this.zVI = 0;
    this.adCa = 0;
    this.fhH = 0;
    this.ITx = 0L;
    this.NMH = -1;
    this.adCk = 0;
    this.adCl = new View.OnClickListener()
    {
      private final long WZx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.adCm = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.adCo = 0;
    this.adCp = 0;
    this.adCq = 0;
    this.adCr = false;
    this.akmh = false;
    this.adCs = false;
    this.adCt = 0;
    this.adCu = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33343);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33344);
    this.zVI = 0;
    this.adCa = 0;
    this.fhH = 0;
    this.ITx = 0L;
    this.NMH = -1;
    this.adCk = 0;
    this.adCl = new View.OnClickListener()
    {
      private final long WZx = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).publish(Integer.valueOf(LauncherUIBottomTabView.d(LauncherUIBottomTabView.this)));
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
    this.adCm = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33336);
        Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.e(LauncherUIBottomTabView.this).onTabClick(0);
        AppMethodBeat.o(33336);
      }
    };
    this.adCo = 0;
    this.adCp = 0;
    this.adCq = 0;
    this.adCr = false;
    this.akmh = false;
    this.adCs = false;
    this.adCt = 0;
    this.adCu = false;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(33344);
  }
  
  private a aAd(int paramInt)
  {
    AppMethodBeat.i(33345);
    a locala = new a();
    if (com.tencent.mm.cd.a.mq(getContext())) {
      com.tencent.mm.kiss.layout.b.bbG();
    }
    for (locala.adCw = com.tencent.mm.kiss.layout.b.d((Activity)getContext(), R.i.glJ);; locala.adCw = com.tencent.mm.kiss.layout.b.d((Activity)getContext(), R.i.glI))
    {
      locala.adCx = ((TabIconView)locala.adCw.findViewById(R.h.icon_iv));
      locala.adCy = ((TextView)locala.adCw.findViewById(R.h.fJU));
      locala.yaQ = ((TextView)locala.adCw.findViewById(R.h.gbj));
      locala.yaQ.setBackgroundResource(v.nH(getContext()));
      locala.adCz = ((ImageView)locala.adCw.findViewById(R.h.dot_iv));
      locala.adCw.setTag(Integer.valueOf(paramInt));
      locala.adCw.setOnClickListener(this.adCl);
      float f1 = com.tencent.mm.cd.a.bs(getContext(), R.f.SmallestTextSize);
      float f2 = com.tencent.mm.cd.a.jO(getContext());
      locala.adCy.setTextSize(0, f1 * f2);
      AppMethodBeat.o(33345);
      return locala;
      com.tencent.mm.kiss.layout.b.bbG();
    }
  }
  
  private void aAe(int paramInt)
  {
    AppMethodBeat.i(249955);
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
        Object localObject = locala.yaQ.getText().toString().trim();
        adq localadq = new adq();
        localadq.ihP.idY = paramInt;
        localadq.ihP.ihR = Util.getInt((String)localObject, 0);
        localObject = localadq.ihP;
        if (locala.adCz.getVisibility() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((adq.a)localObject).ihQ = bool;
          localadq.publish();
          AppMethodBeat.o(249955);
          return;
          locala = this.adBW;
          break;
          locala = this.adBY;
          break;
          locala = this.adBX;
          break;
          locala = this.adBZ;
          break;
        }
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUITabView", localException, "notify tab reddot tabIndex [%d]", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(249955);
      }
    }
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33346);
    a locala = aAd(0);
    locala.adCy.setText(R.l.main_title);
    locala.adCy.setTextColor(getResources().getColor(R.e.FG_0));
    locala.adCx.h(R.k.icons_filled_chats_hl, R.k.icons_outlined_chats_middle, R.k.icons_outlined_chats, com.tencent.mm.cd.a.mq(getContext()));
    locala.yaQ.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.adCk);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCw, localLayoutParams);
    AppMethodBeat.o(33346);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33347);
    a locala = aAd(1);
    locala.adCy.setText(R.l.gMU);
    locala.adCy.setTextColor(getResources().getColor(R.e.FG_0));
    locala.adCx.h(R.k.icons_filled_contacts_hl, R.k.icons_outlined_contacts_middle, R.k.icons_outlined_contacts, com.tencent.mm.cd.a.mq(getContext()));
    locala.yaQ.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.adCk);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCw, localLayoutParams);
    AppMethodBeat.o(33347);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33350);
    this.adCn = new LinearLayout(getContext());
    this.adCn.setBackgroundColor(getResources().getColor(R.e.BG_1));
    this.adCn.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.adCn, localLayoutParams);
    this.adCk = ((int)(com.tencent.mm.cd.a.bs(getContext(), R.f.DefaultTabbarHeight) * com.tencent.mm.cd.a.jO(getContext())));
    this.adBW = h(this.adCn);
    this.adBY = i(this.adCn);
    this.adBX = j(this.adCn);
    this.adBZ = k(this.adCn);
    this.adCa = getResources().getColor(R.e.navbar_text_focus);
    this.adCb = ((this.adCa & 0xFF0000) >> 16);
    this.adCc = ((this.adCa & 0xFF00) >> 8);
    this.adCd = (this.adCa & 0xFF);
    this.fhH = getResources().getColor(R.e.FG_0);
    this.adCe = ((this.fhH & 0xFF0000) >> 16);
    this.adCf = ((this.fhH & 0xFF00) >> 8);
    this.adCg = (this.fhH & 0xFF);
    this.adCh = (this.adCb - this.adCe);
    this.adCi = (this.adCc - this.adCf);
    this.adCj = (this.adCd - this.adCg);
    AppMethodBeat.o(33350);
  }
  
  private a j(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33348);
    a locala = aAd(2);
    locala.adCy.setText(R.l.gMS);
    locala.adCy.setTextColor(getResources().getColor(R.e.FG_0));
    locala.adCx.h(R.k.icons_filled_discover_hl, R.k.icons_outlined_discover_middle, R.k.icons_outlined_discover, com.tencent.mm.cd.a.mq(getContext()));
    locala.yaQ.setVisibility(4);
    locala.path = "discovery";
    com.tencent.mm.plugin.newtips.a.gtf().h(locala);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.adCk);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.adCw, localLayoutParams);
    AppMethodBeat.o(33348);
    return locala;
  }
  
  private void jjt()
  {
    AppMethodBeat.i(249949);
    this.adBW.adCw.setTag(R.h.fMs, Boolean.FALSE);
    this.adBW.adCw.setSelected(false);
    this.adBX.adCw.setTag(R.h.fMs, Boolean.FALSE);
    this.adBX.adCw.setSelected(false);
    this.adBY.adCw.setTag(R.h.fMs, Boolean.FALSE);
    this.adBY.adCw.setSelected(false);
    this.adBZ.adCw.setTag(R.h.fMs, Boolean.FALSE);
    this.adBZ.adCw.setSelected(false);
    AppMethodBeat.o(249949);
  }
  
  private a k(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33349);
    a locala = aAd(3);
    locala.adCy.setText(R.l.gNo);
    locala.adCy.setTextColor(getResources().getColor(R.e.FG_0));
    Object localObject = locala.adCx;
    int i = R.k.icons_filled_me_hl;
    int j = R.k.icons_outlined_me;
    ((TabIconView)localObject).h(i, j, j, com.tencent.mm.cd.a.mq(getContext()));
    locala.yaQ.setVisibility(4);
    locala.path = "me";
    com.tencent.mm.plugin.newtips.a.gtf().h(locala);
    localObject = new LinearLayout.LayoutParams(0, this.adCk);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    paramLinearLayout.addView(locala.adCw, (ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(33349);
    return locala;
  }
  
  private void setFriendUnreadMargin(int paramInt)
  {
    AppMethodBeat.i(369627);
    Log.i("MicroMsg.LauncherUITabView", "setFriendUnreadMargin: leftMargin:".concat(String.valueOf(paramInt)));
    if (this.adBX.yaQ != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.adBX.yaQ.getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = paramInt;
        this.adBX.yaQ.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(369627);
  }
  
  private void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(369628);
    Log.i("MicroMsg.LauncherUITabView", "setTextBold: isBold:".concat(String.valueOf(paramBoolean)));
    if ((this.adBX != null) && (this.adBX.yaQ != null))
    {
      if (paramBoolean)
      {
        aw.a(this.adBX.yaQ.getPaint(), 0.8F);
        AppMethodBeat.o(369628);
        return;
      }
      aw.e(this.adBX.yaQ.getPaint());
    }
    AppMethodBeat.o(369628);
  }
  
  public final void KT(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(33354);
    if (g.a(paramBoolean, this.adBX))
    {
      AppMethodBeat.o(33354);
      return;
    }
    if (this.akmh)
    {
      Log.i("MicroMsg.LauncherUITabView", "showFriendPoint return for FinderTextPoint isShowing!");
      AppMethodBeat.o(33354);
      return;
    }
    setFriendUnreadMargin(-akmf);
    setTextBold(false);
    this.adCr = paramBoolean;
    this.adBX.yaQ.setVisibility(4);
    ImageView localImageView = this.adBX.adCz;
    if (paramBoolean) {}
    for (;;)
    {
      localImageView.setVisibility(i);
      this.adBX.a(k.MsK, paramBoolean);
      aAe(2);
      AppMethodBeat.o(33354);
      return;
      i = 4;
    }
  }
  
  public final void KU(boolean paramBoolean)
  {
    AppMethodBeat.i(33356);
    if (this.adCs)
    {
      AppMethodBeat.o(33356);
      return;
    }
    if (g.a(paramBoolean, this.adBZ))
    {
      AppMethodBeat.o(33356);
      return;
    }
    Object localObject = h.SqZ;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      h.vV(l);
      this.adCu = paramBoolean;
      this.adBZ.yaQ.setVisibility(4);
      localObject = this.adBZ.adCz;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.adBZ.a(k.MsK, paramBoolean);
      AppMethodBeat.o(33356);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void aX(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(369630);
    if (g.a(paramBoolean, this.adBX))
    {
      AppMethodBeat.o(369630);
      return;
    }
    this.adCr = paramBoolean;
    Log.i("MicroMsg.LauncherUITabView", "showFriendTextPoint show:" + paramBoolean + " text:" + paramString + " isShowFinderTextPoint ：" + this.akmh);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.akmh = true;
      this.adBX.yaQ.setText(paramString);
      this.adBX.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      this.adBX.yaQ.setVisibility(0);
      this.adBX.yaQ.setBackgroundResource(v.bC(getContext(), 20));
      this.adBX.adCz.setVisibility(4);
      if (com.tencent.mm.cd.a.mq(this.mContext))
      {
        setFriendUnreadMargin(-akmg);
        setTextBold(true);
        this.adBX.a(k.MsP, true);
      }
    }
    for (;;)
    {
      aAe(2);
      AppMethodBeat.o(369630);
      return;
      setFriendUnreadMargin(-akmf);
      break;
      setTextBold(false);
      if (this.adCq > 0)
      {
        this.akmh = paramBoolean;
        azU(this.adCq);
      }
      else
      {
        if (this.akmh)
        {
          this.adBX.yaQ.setText("");
          this.adBX.yaQ.setVisibility(4);
        }
        this.akmh = paramBoolean;
        this.adBX.a(k.MsP, false);
      }
    }
  }
  
  public final void azS(int paramInt)
  {
    AppMethodBeat.i(33351);
    Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.adCo = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.adBW.yaQ.setText("");
        this.adBW.yaQ.setBackgroundResource(R.k.badge_count_more);
        this.adBW.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize));
        this.adBW.yaQ.setVisibility(0);
        this.adBW.yaQ.setContentDescription(getContext().getString(R.l.unread_count_overt_100_content_desc));
        this.adBW.adCz.setVisibility(4);
      }
    }
    for (;;)
    {
      aAe(0);
      AppMethodBeat.o(33351);
      return;
      this.adBW.yaQ.setText(String.valueOf(paramInt));
      this.adBW.yaQ.setBackgroundResource(v.bC(getContext(), paramInt));
      this.adBW.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      this.adBW.yaQ.setVisibility(0);
      this.adBW.yaQ.setContentDescription(null);
      this.adBW.adCz.setVisibility(4);
      continue;
      this.adBW.yaQ.setText("");
      this.adBW.yaQ.setVisibility(4);
    }
  }
  
  public final void azT(int paramInt)
  {
    AppMethodBeat.i(33352);
    this.adCp = paramInt;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.adBY.yaQ.setText("");
        this.adBY.yaQ.setBackgroundResource(R.k.badge_count_more);
        this.adBY.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize));
        this.adBY.yaQ.setVisibility(0);
        this.adBY.adCz.setVisibility(4);
      }
    }
    for (;;)
    {
      aAe(1);
      AppMethodBeat.o(33352);
      return;
      this.adBY.yaQ.setText(String.valueOf(paramInt));
      this.adBY.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      this.adBY.yaQ.setBackgroundResource(v.bC(getContext(), paramInt));
      this.adBY.yaQ.setVisibility(0);
      this.adBY.adCz.setVisibility(4);
      continue;
      this.adBY.yaQ.setText("");
      this.adBY.yaQ.setVisibility(4);
    }
  }
  
  public final void azU(int paramInt)
  {
    AppMethodBeat.i(33353);
    this.adCq = paramInt;
    a locala = this.adBX;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33353);
      return;
    }
    if (this.akmh)
    {
      Log.i("MicroMsg.LauncherUITabView", "showFriendPoint return for FinderTextPoint isShowing!");
      AppMethodBeat.o(33353);
      return;
    }
    setFriendUnreadMargin(-akmf);
    setTextBold(false);
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.adBX.yaQ.setText("");
        this.adBX.yaQ.setBackgroundResource(R.k.badge_count_more);
        this.adBX.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize));
        this.adBX.yaQ.setVisibility(0);
        this.adBX.adCz.setVisibility(4);
        this.adBX.a(k.MsP, true);
      }
    }
    for (;;)
    {
      aAe(2);
      AppMethodBeat.o(33353);
      return;
      this.adBX.yaQ.setText(String.valueOf(paramInt));
      this.adBX.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      this.adBX.yaQ.setVisibility(0);
      this.adBX.yaQ.setBackgroundResource(v.bC(getContext(), paramInt));
      this.adBX.adCz.setVisibility(4);
      break;
      this.adBX.yaQ.setText("");
      this.adBX.yaQ.setVisibility(4);
      this.adBX.a(k.MsP, false);
    }
  }
  
  public final void azV(int paramInt)
  {
    AppMethodBeat.i(33355);
    if (this.adCs)
    {
      AppMethodBeat.o(33355);
      return;
    }
    this.adCt = paramInt;
    a locala = this.adBZ;
    if (paramInt > 0) {}
    for (boolean bool = true; g.a(bool, locala); bool = false)
    {
      AppMethodBeat.o(33355);
      return;
    }
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        this.adBZ.yaQ.setText("");
        this.adBZ.yaQ.setBackgroundResource(R.k.badge_count_more);
        this.adBZ.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize));
        this.adBZ.yaQ.setVisibility(0);
        this.adBZ.adCz.setVisibility(4);
        this.adBZ.a(k.MsP, true);
      }
    }
    for (;;)
    {
      aAe(3);
      AppMethodBeat.o(33355);
      return;
      this.adBZ.yaQ.setText(String.valueOf(paramInt));
      this.adBZ.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      this.adBZ.yaQ.setVisibility(0);
      this.adBZ.yaQ.setBackgroundResource(v.bC(getContext(), paramInt));
      this.adBZ.adCz.setVisibility(4);
      break;
      this.adBZ.yaQ.setText("");
      this.adBZ.yaQ.setVisibility(4);
      this.adBZ.a(k.MsP, false);
    }
  }
  
  public int getContactTabUnread()
  {
    return this.adCp;
  }
  
  public int getCurIdx()
  {
    return this.zVI;
  }
  
  public int getFriendTabUnread()
  {
    return this.adCq;
  }
  
  public int getMainTabUnread()
  {
    return this.adCo;
  }
  
  public boolean getSettingsPoint()
  {
    return this.adCu;
  }
  
  public int getSettingsTabUnread()
  {
    return this.adCt;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.adCr;
  }
  
  public final void jhJ()
  {
    if ((this.adBW != null) && (this.adBY != null) && (this.adBX == null)) {}
  }
  
  public void setOnTabClickListener(d.a parama)
  {
    this.adBV = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33358);
    this.zVI = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.ITx = System.currentTimeMillis();
      this.NMH = this.zVI;
      AppMethodBeat.o(33358);
      return;
      this.adBW.adCx.setFocusAlpha(255);
      this.adBX.adCx.setFocusAlpha(0);
      this.adBY.adCx.setFocusAlpha(0);
      this.adBZ.adCx.setFocusAlpha(0);
      this.adBW.adCy.setTextColor(this.adCa);
      this.adBX.adCy.setTextColor(this.fhH);
      this.adBY.adCy.setTextColor(this.fhH);
      this.adBZ.adCy.setTextColor(this.fhH);
      jjt();
      this.adBW.adCw.setTag(R.h.fMs, Boolean.TRUE);
      this.adBW.adCw.setSelected(true);
      continue;
      this.adBW.adCx.setFocusAlpha(0);
      this.adBX.adCx.setFocusAlpha(255);
      this.adBY.adCx.setFocusAlpha(0);
      this.adBZ.adCx.setFocusAlpha(0);
      this.adBW.adCy.setTextColor(this.fhH);
      this.adBX.adCy.setTextColor(this.adCa);
      this.adBY.adCy.setTextColor(this.fhH);
      this.adBZ.adCy.setTextColor(this.fhH);
      jjt();
      this.adBX.adCw.setTag(R.h.fMs, Boolean.TRUE);
      this.adBX.adCw.setSelected(true);
      continue;
      this.adBW.adCx.setFocusAlpha(0);
      this.adBX.adCx.setFocusAlpha(0);
      this.adBY.adCx.setFocusAlpha(255);
      this.adBZ.adCx.setFocusAlpha(0);
      this.adBW.adCy.setTextColor(this.fhH);
      this.adBX.adCy.setTextColor(this.fhH);
      this.adBY.adCy.setTextColor(this.adCa);
      this.adBZ.adCy.setTextColor(this.fhH);
      jjt();
      this.adBY.adCw.setTag(R.h.fMs, Boolean.TRUE);
      this.adBY.adCw.setSelected(true);
      continue;
      this.adBW.adCx.setFocusAlpha(0);
      this.adBX.adCx.setFocusAlpha(0);
      this.adBY.adCx.setFocusAlpha(0);
      this.adBZ.adCx.setFocusAlpha(255);
      this.adBW.adCy.setTextColor(this.fhH);
      this.adBX.adCy.setTextColor(this.fhH);
      this.adBY.adCy.setTextColor(this.fhH);
      this.adBZ.adCy.setTextColor(this.adCa);
      jjt();
      this.adBZ.adCw.setTag(R.h.fMs, Boolean.TRUE);
      this.adBZ.adCw.setSelected(true);
    }
  }
  
  public final void t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(33357);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.adCh * paramFloat + this.adCe) << 16) + ((int)(this.adCi * paramFloat + this.adCf) << 8) + (int)(this.adCj * paramFloat + this.adCg) + (this.fhH & 0xFF000000);
    int m = ((int)(this.adCh * (1.0F - paramFloat) + this.adCe) << 16) + ((int)(this.adCi * (1.0F - paramFloat) + this.adCf) << 8) + (int)(this.adCj * (1.0F - paramFloat) + this.adCg) + (this.fhH & 0xFF000000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramFloat == 0.0F) {
        setTo(paramInt);
      }
      AppMethodBeat.o(33357);
      return;
      this.adBW.adCx.setFocusAlpha(j);
      this.adBY.adCx.setFocusAlpha(i);
      this.adBW.adCy.setTextColor(m);
      this.adBY.adCy.setTextColor(k);
      continue;
      this.adBY.adCx.setFocusAlpha(j);
      this.adBX.adCx.setFocusAlpha(i);
      this.adBY.adCy.setTextColor(m);
      this.adBX.adCy.setTextColor(k);
      continue;
      this.adBX.adCx.setFocusAlpha(j);
      this.adBZ.adCx.setFocusAlpha(i);
      this.adBX.adCy.setTextColor(m);
      this.adBZ.adCy.setTextColor(k);
    }
  }
  
  protected final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    View adCw;
    TabIconView adCx;
    TextView adCy;
    ImageView adCz;
    String path;
    TextView yaQ;
    
    protected a() {}
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(33337);
      g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(33337);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      AppMethodBeat.i(33341);
      if (paramBoolean) {
        if (paramfng.num > 99)
        {
          this.yaQ.setText("");
          this.yaQ.setBackgroundResource(R.k.badge_count_more);
          this.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(LauncherUIBottomTabView.this.getContext(), R.f.unReadCountTextSize));
          this.yaQ.setVisibility(0);
          this.adCz.setVisibility(4);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33341);
        return true;
        this.yaQ.setText(String.valueOf(paramfng.num));
        this.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(LauncherUIBottomTabView.this.getContext(), R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(LauncherUIBottomTabView.this.getContext()));
        this.yaQ.setVisibility(0);
        this.yaQ.setBackgroundResource(v.bC(LauncherUIBottomTabView.this.getContext(), paramfng.num));
        this.adCz.setVisibility(4);
        continue;
        this.yaQ.setText("");
        this.yaQ.setVisibility(4);
      }
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.adCw;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      AppMethodBeat.i(369614);
      paramBoolean = g.a(paramBoolean, this);
      AppMethodBeat.o(369614);
      return paramBoolean;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      int i = 4;
      AppMethodBeat.i(33339);
      this.yaQ.setVisibility(4);
      ImageView localImageView = this.adCz;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      AppMethodBeat.o(33339);
      return true;
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      AppMethodBeat.i(33340);
      if (paramBoolean)
      {
        this.yaQ.setText(LauncherUIBottomTabView.this.getResources().getString(R.l.ui_new));
        this.yaQ.setBackgroundResource(R.g.new_tips_bg);
        this.yaQ.setTextSize(0, com.tencent.mm.cd.a.bs(LauncherUIBottomTabView.this.getContext(), R.f.DialogUserNameSize));
        this.yaQ.setVisibility(0);
        this.adCz.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(33340);
        return true;
        this.yaQ.setText("");
        this.yaQ.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */