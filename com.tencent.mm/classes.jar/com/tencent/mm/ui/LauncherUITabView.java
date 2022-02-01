package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.sdk.platformtools.ac;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  protected View.OnClickListener HlN;
  private com.tencent.mm.sdk.platformtools.ao HlO;
  private LinearLayout HlP;
  private int HlQ;
  private int HlR;
  private int HlS;
  private boolean HlT;
  private int HlV;
  private boolean HlW;
  private c.a Hlx;
  private int Hme;
  private Bitmap Hmf;
  private ImageView Hmg;
  protected a Hmh;
  protected a Hmi;
  protected a Hmj;
  protected a Hmk;
  private Matrix eY;
  protected int gPA;
  private long ttg;
  private int wuW;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.gPA = 0;
    this.eY = new Matrix();
    this.ttg = 0L;
    this.wuW = -1;
    this.HlN = new View.OnClickListener()
    {
      private final long ySC = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ac.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.GpY.l(new lh());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          AppMethodBeat.o(33369);
          return;
        }
        if (LauncherUITabView.d(LauncherUITabView.this) != null)
        {
          if ((i != 0) || (LauncherUITabView.a(LauncherUITabView.this) != 0))
          {
            LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
            LauncherUITabView.a(LauncherUITabView.this, i);
            LauncherUITabView.d(LauncherUITabView.this).onTabClick(i);
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        ac.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33369);
      }
    };
    this.HlO = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ac.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.HlQ = 0;
    this.HlR = 0;
    this.HlS = 0;
    this.HlV = 0;
    this.HlT = false;
    this.HlW = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.gPA = 0;
    this.eY = new Matrix();
    this.ttg = 0L;
    this.wuW = -1;
    this.HlN = new View.OnClickListener()
    {
      private final long ySC = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ac.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.GpY.l(new lh());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          AppMethodBeat.o(33369);
          return;
        }
        if (LauncherUITabView.d(LauncherUITabView.this) != null)
        {
          if ((i != 0) || (LauncherUITabView.a(LauncherUITabView.this) != 0))
          {
            LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
            LauncherUITabView.a(LauncherUITabView.this, i);
            LauncherUITabView.d(LauncherUITabView.this).onTabClick(i);
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        ac.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33369);
      }
    };
    this.HlO = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ac.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.HlQ = 0;
    this.HlR = 0;
    this.HlS = 0;
    this.HlV = 0;
    this.HlT = false;
    this.HlW = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a Zt(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.Hmm = new MMTabView(getContext(), paramInt);
    locala.Hmm.setTag(Integer.valueOf(paramInt));
    locala.Hmm.setOnClickListener(this.HlN);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = Zt(0);
    locala.Hmm.setText(2131761037);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Hmm, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private void fgw()
  {
    AppMethodBeat.i(33378);
    this.Hmg = new ImageView(getContext());
    this.Hmg.setImageMatrix(this.eY);
    this.Hmg.setScaleType(ImageView.ScaleType.MATRIX);
    this.Hmg.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.Hmg, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = Zt(1);
    locala.Hmm.setText(2131761038);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Hmm, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = Zt(2);
    locala.Hmm.setText(2131761036);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Hmm, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = Zt(3);
    locala.Hmm.setText(2131761071);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.Hmm, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.HlP = new LinearLayout(getContext());
    this.HlP.setBackgroundResource(ao.aJ(getContext(), 2130968578));
    this.HlP.setId(2307141);
    this.HlP.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.HlP, localLayoutParams);
    fgw();
    this.Hmh = f(this.HlP);
    this.Hmi = g(this.HlP);
    this.Hmj = h(this.HlP);
    this.Hmk = i(this.HlP);
    AppMethodBeat.o(33379);
  }
  
  public final void Zj(int paramInt)
  {
    AppMethodBeat.i(33381);
    ac.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.HlQ = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Hmh.Hmm.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33381);
        return;
      }
      this.Hmh.Hmm.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.Hmh.Hmm.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void Zk(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.HlR = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Hmi.Hmm.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33383);
        return;
      }
      this.Hmi.Hmm.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.Hmi.Hmm.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void Zl(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.HlS = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Hmj.Hmm.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33384);
        return;
      }
      this.Hmj.Hmm.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.Hmj.Hmm.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void Zm(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.HlV = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Hmk.Hmm.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33385);
        return;
      }
      this.Hmk.Hmm.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.Hmk.Hmm.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public final void feR()
  {
    AppMethodBeat.i(33382);
    if ((this.Hmh == null) || (this.Hmi == null) || (this.Hmj == null) || (this.Hmk == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.Hmh.Hmm.fgO();
    this.Hmi.Hmm.fgO();
    this.Hmj.Hmm.fgO();
    this.Hmk.Hmm.fgO();
    AppMethodBeat.o(33382);
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
    AppMethodBeat.i(33388);
    this.eY.setTranslate(this.Hme * (paramInt + paramFloat), 0.0F);
    this.Hmg.setImageMatrix(this.eY);
    AppMethodBeat.o(33388);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ac.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.Hme = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.Hme;
    if ((this.Hmf == null) || (this.Hmf.getWidth() != paramInt2)) {
      if (this.Hmf != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.Hmf.getWidth())
    {
      ac.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.Hmf = Bitmap.createBitmap(paramInt2, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.Hmf).drawColor(getResources().getColor(2131101171));
      n(this.gPA, 0.0F);
      this.Hmg.setImageBitmap(this.Hmf);
      setTo(this.gPA);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.Hlx = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.gPA = paramInt;
    MMTabView localMMTabView = this.Hmh.Hmm;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(2131101171);
      localMMTabView.setTextColor(i);
      localMMTabView = this.Hmi.Hmm;
      if (paramInt != 1) {
        break label162;
      }
      i = getResources().getColor(2131101171);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.Hmj.Hmm;
      if (paramInt != 2) {
        break label176;
      }
      i = getResources().getColor(2131101171);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.Hmk.Hmm;
      if (paramInt != 3) {
        break label190;
      }
    }
    label162:
    label176:
    label190:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aJ(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      this.ttg = System.currentTimeMillis();
      this.wuW = this.gPA;
      AppMethodBeat.o(33389);
      return;
      i = ao.aJ(getContext(), 2130968584);
      break;
      i = ao.aJ(getContext(), 2130968584);
      break label63;
      i = ao.aJ(getContext(), 2130968584);
      break label92;
    }
  }
  
  public final void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.HlT = paramBoolean;
    this.Hmj.Hmm.wB(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.HlW = paramBoolean;
    this.Hmk.Hmm.wB(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  protected final class a
  {
    MMTabView Hmm;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */