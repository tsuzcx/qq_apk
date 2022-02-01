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
import com.tencent.mm.g.a.lq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  private boolean IZA;
  private int IZC;
  private boolean IZD;
  private int IZL;
  private Bitmap IZM;
  private ImageView IZN;
  protected a IZO;
  protected a IZP;
  protected a IZQ;
  protected a IZR;
  private c.a IZe;
  protected View.OnClickListener IZu;
  private ap IZv;
  private LinearLayout IZw;
  private int IZx;
  private int IZy;
  private int IZz;
  private Matrix gR;
  protected int rko;
  private long urF;
  private int xCS;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.rko = 0;
    this.gR = new Matrix();
    this.urF = 0L;
    this.xCS = -1;
    this.IZu = new View.OnClickListener()
    {
      private final long Ake = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.IbL.l(new lq());
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
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.IZv = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.IZx = 0;
    this.IZy = 0;
    this.IZz = 0;
    this.IZC = 0;
    this.IZA = false;
    this.IZD = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.rko = 0;
    this.gR = new Matrix();
    this.urF = 0L;
    this.xCS = -1;
    this.IZu = new View.OnClickListener()
    {
      private final long Ake = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.IbL.l(new lq());
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
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33369);
      }
    };
    this.IZv = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.IZx = 0;
    this.IZy = 0;
    this.IZz = 0;
    this.IZC = 0;
    this.IZA = false;
    this.IZD = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a abD(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.IZT = new MMTabView(getContext(), paramInt);
    locala.IZT.setTag(Integer.valueOf(paramInt));
    locala.IZT.setOnClickListener(this.IZu);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = abD(0);
    locala.IZT.setText(2131761037);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZT, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private void fwI()
  {
    AppMethodBeat.i(33378);
    this.IZN = new ImageView(getContext());
    this.IZN.setImageMatrix(this.gR);
    this.IZN.setScaleType(ImageView.ScaleType.MATRIX);
    this.IZN.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.IZN, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = abD(1);
    locala.IZT.setText(2131761038);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZT, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = abD(2);
    locala.IZT.setText(2131761036);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZT, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = abD(3);
    locala.IZT.setText(2131761071);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.IZT, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.IZw = new LinearLayout(getContext());
    this.IZw.setBackgroundColor(getContext().getResources().getColor(2131099649));
    this.IZw.setId(2307141);
    this.IZw.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.IZw, localLayoutParams);
    fwI();
    this.IZO = f(this.IZw);
    this.IZP = g(this.IZw);
    this.IZQ = h(this.IZw);
    this.IZR = i(this.IZw);
    AppMethodBeat.o(33379);
  }
  
  public final void abs(int paramInt)
  {
    AppMethodBeat.i(33381);
    ad.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.IZx = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZO.IZT.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33381);
        return;
      }
      this.IZO.IZT.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.IZO.IZT.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void abt(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.IZy = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZP.IZT.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33383);
        return;
      }
      this.IZP.IZT.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.IZP.IZT.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void abu(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.IZz = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZQ.IZT.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33384);
        return;
      }
      this.IZQ.IZT.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.IZQ.IZT.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void abv(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.IZC = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.IZR.IZT.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33385);
        return;
      }
      this.IZR.IZT.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.IZR.IZT.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public final void fuZ()
  {
    AppMethodBeat.i(33382);
    if ((this.IZO == null) || (this.IZP == null) || (this.IZQ == null) || (this.IZR == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.IZO.IZT.fxa();
    this.IZP.IZT.fxa();
    this.IZQ.IZT.fxa();
    this.IZR.IZT.fxa();
    AppMethodBeat.o(33382);
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
    AppMethodBeat.i(33388);
    this.gR.setTranslate(this.IZL * (paramInt + paramFloat), 0.0F);
    this.IZN.setImageMatrix(this.gR);
    AppMethodBeat.o(33388);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.IZL = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.IZL;
    if ((this.IZM == null) || (this.IZM.getWidth() != paramInt2)) {
      if (this.IZM != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.IZM.getWidth())
    {
      ad.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.IZM = Bitmap.createBitmap(paramInt2, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.IZM).drawColor(getResources().getColor(2131101171));
      o(this.rko, 0.0F);
      this.IZN.setImageBitmap(this.IZM);
      setTo(this.rko);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.IZe = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.rko = paramInt;
    MMTabView localMMTabView = this.IZO.IZT;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(2131101171);
      localMMTabView.setTextColor(i);
      localMMTabView = this.IZP.IZT;
      if (paramInt != 1) {
        break label165;
      }
      i = getResources().getColor(2131101171);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.IZQ.IZT;
      if (paramInt != 2) {
        break label182;
      }
      i = getResources().getColor(2131101171);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.IZR.IZT;
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
      this.urF = System.currentTimeMillis();
      this.xCS = this.rko;
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
  
  public final void wX(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.IZA = paramBoolean;
    this.IZQ.IZT.xn(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void wY(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.IZD = paramBoolean;
    this.IZR.IZT.xn(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  protected final class a
  {
    MMTabView IZT;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */