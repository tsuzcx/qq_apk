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
import com.tencent.mm.g.a.ky;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  protected View.OnClickListener FMF;
  private ap FMG;
  private LinearLayout FMH;
  private int FMI;
  private int FMJ;
  private int FMK;
  private boolean FML;
  private int FMN;
  private boolean FMO;
  private int FMW;
  private Bitmap FMX;
  private ImageView FMY;
  protected a FMZ;
  private c.a FMp;
  protected a FNa;
  protected a FNb;
  protected a FNc;
  private Matrix dY;
  protected int goS;
  private long sln;
  private int vmo;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33371);
    this.goS = 0;
    this.dY = new Matrix();
    this.sln = 0L;
    this.vmo = -1;
    this.FMF = new View.OnClickListener()
    {
      private final long xFP = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.ESL.l(new ky());
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
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33369);
      }
    };
    this.FMG = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.FMI = 0;
    this.FMJ = 0;
    this.FMK = 0;
    this.FMN = 0;
    this.FML = false;
    this.FMO = false;
    init();
    AppMethodBeat.o(33371);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33372);
    this.goS = 0;
    this.dY = new Matrix();
    this.sln = 0L;
    this.vmo = -1;
    this.FMF = new View.OnClickListener()
    {
      private final long xFP = 300L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33369);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUITabView.a(LauncherUITabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(LauncherUITabView.this) <= 300L))
        {
          ad.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUITabView.c(LauncherUITabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.ESL.l(new ky());
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
        ad.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        AppMethodBeat.o(33369);
      }
    };
    this.FMG = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33370);
        ad.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(LauncherUITabView.this).onTabClick(0);
        AppMethodBeat.o(33370);
      }
    };
    this.FMI = 0;
    this.FMJ = 0;
    this.FMK = 0;
    this.FMN = 0;
    this.FML = false;
    this.FMO = false;
    init();
    AppMethodBeat.o(33372);
  }
  
  private a Xj(int paramInt)
  {
    AppMethodBeat.i(33373);
    a locala = new a();
    locala.FNe = new MMTabView(getContext(), paramInt);
    locala.FNe.setTag(Integer.valueOf(paramInt));
    locala.FNe.setOnClickListener(this.FMF);
    AppMethodBeat.o(33373);
    return locala;
  }
  
  private void eQQ()
  {
    AppMethodBeat.i(33378);
    this.FMY = new ImageView(getContext());
    this.FMY.setImageMatrix(this.dY);
    this.FMY.setScaleType(ImageView.ScaleType.MATRIX);
    this.FMY.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.FMY, localLayoutParams);
    AppMethodBeat.o(33378);
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33374);
    a locala = Xj(0);
    locala.FNe.setText(2131761037);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FNe, localLayoutParams);
    AppMethodBeat.o(33374);
    return locala;
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33375);
    a locala = Xj(1);
    locala.FNe.setText(2131761038);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FNe, localLayoutParams);
    AppMethodBeat.o(33375);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33376);
    a locala = Xj(2);
    locala.FNe.setText(2131761036);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FNe, localLayoutParams);
    AppMethodBeat.o(33376);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(33377);
    a locala = Xj(3);
    locala.FNe.setText(2131761071);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.FNe, localLayoutParams);
    AppMethodBeat.o(33377);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(33379);
    this.FMH = new LinearLayout(getContext());
    this.FMH.setBackgroundResource(ao.aD(getContext(), 2130968578));
    this.FMH.setId(2307141);
    this.FMH.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.FMH, localLayoutParams);
    eQQ();
    this.FMZ = f(this.FMH);
    this.FNa = g(this.FMH);
    this.FNb = h(this.FMH);
    this.FNc = i(this.FMH);
    AppMethodBeat.o(33379);
  }
  
  public final void WZ(int paramInt)
  {
    AppMethodBeat.i(33381);
    ad.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.FMI = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FMZ.FNe.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33381);
        return;
      }
      this.FMZ.FNe.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33381);
      return;
    }
    this.FMZ.FNe.setUnread(null);
    AppMethodBeat.o(33381);
  }
  
  public final void Xa(int paramInt)
  {
    AppMethodBeat.i(33383);
    this.FMJ = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FNa.FNe.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33383);
        return;
      }
      this.FNa.FNe.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33383);
      return;
    }
    this.FNa.FNe.setUnread(null);
    AppMethodBeat.o(33383);
  }
  
  public final void Xb(int paramInt)
  {
    AppMethodBeat.i(33384);
    this.FMK = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FNb.FNe.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33384);
        return;
      }
      this.FNb.FNe.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33384);
      return;
    }
    this.FNb.FNe.setUnread(null);
    AppMethodBeat.o(33384);
  }
  
  public final void Xc(int paramInt)
  {
    AppMethodBeat.i(33385);
    this.FMN = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.FNc.FNe.setUnread(getContext().getString(2131764567));
        AppMethodBeat.o(33385);
        return;
      }
      this.FNc.FNe.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(33385);
      return;
    }
    this.FNc.FNe.setUnread(null);
    AppMethodBeat.o(33385);
  }
  
  public final void ePn()
  {
    AppMethodBeat.i(33382);
    if ((this.FMZ == null) || (this.FNa == null) || (this.FNb == null) || (this.FNc == null))
    {
      AppMethodBeat.o(33382);
      return;
    }
    this.FMZ.FNe.eRf();
    this.FNa.FNe.eRf();
    this.FNb.FNe.eRf();
    this.FNc.FNe.eRf();
    AppMethodBeat.o(33382);
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
    AppMethodBeat.i(33388);
    this.dY.setTranslate(this.FMW * (paramInt + paramFloat), 0.0F);
    this.FMY.setImageMatrix(this.dY);
    AppMethodBeat.o(33388);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(33380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.FMW = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.FMW;
    if ((this.FMX == null) || (this.FMX.getWidth() != paramInt2)) {
      if (this.FMX != null) {
        break label187;
      }
    }
    label187:
    for (paramInt1 = -1;; paramInt1 = this.FMX.getWidth())
    {
      ad.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.FMX = Bitmap.createBitmap(paramInt2, com.tencent.mm.cd.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.FMX).drawColor(getResources().getColor(2131101171));
      n(this.goS, 0.0F);
      this.FMY.setImageBitmap(this.FMX);
      setTo(this.goS);
      AppMethodBeat.o(33380);
      return;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.FMp = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(33389);
    this.goS = paramInt;
    MMTabView localMMTabView = this.FMZ.FNe;
    int i;
    if (paramInt == 0)
    {
      i = getResources().getColor(2131101171);
      localMMTabView.setTextColor(i);
      localMMTabView = this.FNa.FNe;
      if (paramInt != 1) {
        break label162;
      }
      i = getResources().getColor(2131101171);
      label63:
      localMMTabView.setTextColor(i);
      localMMTabView = this.FNb.FNe;
      if (paramInt != 2) {
        break label176;
      }
      i = getResources().getColor(2131101171);
      label92:
      localMMTabView.setTextColor(i);
      localMMTabView = this.FNc.FNe;
      if (paramInt != 3) {
        break label190;
      }
    }
    label162:
    label176:
    label190:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aD(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      this.sln = System.currentTimeMillis();
      this.vmo = this.goS;
      AppMethodBeat.o(33389);
      return;
      i = ao.aD(getContext(), 2130968584);
      break;
      i = ao.aD(getContext(), 2130968584);
      break label63;
      i = ao.aD(getContext(), 2130968584);
      break label92;
    }
  }
  
  public final void vj(boolean paramBoolean)
  {
    AppMethodBeat.i(33386);
    this.FML = paramBoolean;
    this.FNb.FNe.vz(paramBoolean);
    AppMethodBeat.o(33386);
  }
  
  public final void vk(boolean paramBoolean)
  {
    AppMethodBeat.i(33387);
    this.FMO = paramBoolean;
    this.FNc.FNe.vz(paramBoolean);
    AppMethodBeat.o(33387);
  }
  
  protected final class a
  {
    MMTabView FNe;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */