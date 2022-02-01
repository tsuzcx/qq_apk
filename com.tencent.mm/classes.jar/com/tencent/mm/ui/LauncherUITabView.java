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
import com.tencent.mm.g.a.lr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  private c.a JtM;
  protected View.OnClickListener Juc;
  private aq Jud;
  private LinearLayout Jue;
  private int Juf;
  private int Jug;
  private int Juh;
  private boolean Jui;
  private int Juk;
  private boolean Jul;
  private int Jut;
  private Bitmap Juu;
  private ImageView Juv;
  protected a Juw;
  protected a Jux;
  protected a Juy;
  protected a Juz;
  private Matrix gR;
  protected int rss;
  private long uCY;
  private int xSN;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.rss = 0;
    this.gR = new Matrix();
    this.uCY = 0L;
    this.xSN = -1;
    this.Juc = new View.OnClickListener()
    {
      private final long ABq = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ae.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.IvT.l(new lr());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        ae.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.Jud = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ae.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.Juf = 0;
    this.Jug = 0;
    this.Juh = 0;
    this.Juk = 0;
    this.Jui = false;
    this.Jul = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.rss = 0;
    this.gR = new Matrix();
    this.uCY = 0L;
    this.xSN = -1;
    this.Juc = new View.OnClickListener()
    {
      private final long ABq = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ae.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.IvT.l(new lr());
          LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
          LauncherUITabView.a(LauncherUITabView.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33369);
            return;
          }
          LauncherUITabView.c(LauncherUITabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUITabView.a(LauncherUITabView.this, System.currentTimeMillis());
        LauncherUITabView.a(LauncherUITabView.this, i);
        ae.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.Jud = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ae.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.Juf = 0;
    this.Jug = 0;
    this.Juh = 0;
    this.Juk = 0;
    this.Jui = false;
    this.Jul = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a acl(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.JuB = new MMTabView(getContext(), paramInt);
    locala.JuB.setTag(Integer.valueOf(paramInt));
    locala.JuB.setOnClickListener(this.Juc);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = acl(0);
    locala.JuB.setText(2131761037);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.JuB, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private void fAI()
  {
    AppMethodBeat.i(33378);
    this.Juv = new ImageView(getContext());
    this.Juv.setImageMatrix(this.gR);
    this.Juv.setScaleType(ImageView.ScaleType.MATRIX);
    this.Juv.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.Juv, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = acl(1);
    locala.JuB.setText(2131761038);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.JuB, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = acl(2);
    locala.JuB.setText(2131761036);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.JuB, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = acl(3);
    locala.JuB.setText(2131761071);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.JuB, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.Jue = new LinearLayout(getContext());
    this.Jue.setBackgroundColor(getContext().getResources().getColor(2131099649));
    this.Jue.setId(2307141);
    this.Jue.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.Jue, localLayoutParams);
    fAI();
    this.Juw = f(this.Jue);
    this.Jux = g(this.Jue);
    this.Juy = h(this.Jue);
    this.Juz = i(this.Jue);
    AppMethodBeat.o(33379);
  }
  
  public final void aca(int paramInt)
  {
    AppMethodBeat.i(33381);
    ae.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.Juf = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Juw.JuB.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33381);
        return;
      }
      this.Juw.JuB.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.Juw.JuB.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void acb(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.Jug = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Jux.JuB.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33383);
        return;
      }
      this.Jux.JuB.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.Jux.JuB.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void acc(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.Juh = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Juy.JuB.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33384);
        return;
      }
      this.Juy.JuB.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.Juy.JuB.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void acd(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.Juk = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.Juz.JuB.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33385);
        return;
      }
      this.Juz.JuB.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.Juz.JuB.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public final void fza()
  {
    AppMethodBeat.i(33382);
    if ((this.Juw == null) || (this.Jux == null) || (this.Juy == null) || (this.Juz == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.Juw.JuB.fBc();
    this.Jux.JuB.fBc();
    this.Juy.JuB.fBc();
    this.Juz.JuB.fBc();
    AppMethodBeat.o(33382);
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
    AppMethodBeat.i(33388);
    this.gR.setTranslate(this.Jut * (paramInt + paramFloat), 0.0F);
    this.Juv.setImageMatrix(this.gR);
    AppMethodBeat.o(33388);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ae.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.Jut = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.Jut;
    if ((this.Juu == null) || (this.Juu.getWidth() != paramInt2)) {
      if (this.Juu != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.Juu.getWidth())
    {
      ae.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.Juu = Bitmap.createBitmap(paramInt2, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.Juu).drawColor(getResources().getColor(2131101171));
      o(this.rss, 0.0F);
      this.Juv.setImageBitmap(this.Juu);
      setTo(this.rss);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.JtM = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.rss = paramInt;
    MMTabView localMMTabView = this.Juw.JuB;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(2131101171);
      localMMTabView.setTextColor(i);
      localMMTabView = this.Jux.JuB;
      if (paramInt != 1) {
        break label165;
      }
      i = getResources().getColor(2131101171);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.Juy.JuB;
      if (paramInt != 2) {
        break label182;
      }
      i = getResources().getColor(2131101171);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.Juz.JuB;
      if (paramInt != 3) {
        break label199;
      }
    }
    label165:
    label182:
    label199:
    for (paramInt = getResources().getColor(2131101171);; paramInt = getContext().getResources().getColor(2131099732))
    {
      localMMTabView.setTextColor(paramInt);
      this.uCY = System.currentTimeMillis();
      this.xSN = this.rss;
      AppMethodBeat.o(33389);
      return;
      i = getContext().getResources().getColor(2131099732);
      break;
      i = getContext().getResources().getColor(2131099732);
      break label63;
      i = getContext().getResources().getColor(2131099732);
      break label92;
    }
  }
  
  public final void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.Jui = paramBoolean;
    this.Juy.JuB.xv(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.Jul = paramBoolean;
    this.Juz.JuB.xv(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  protected final class a
  {
    MMTabView JuB;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */