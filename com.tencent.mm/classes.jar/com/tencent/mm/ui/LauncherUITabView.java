package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class LauncherUITabView
  extends RelativeLayout
  implements c
{
  private Matrix asO;
  protected int eSO;
  private long nBO;
  private ak yZA;
  private int yZB;
  private int yZC;
  private int yZD;
  private boolean yZE;
  private int yZG;
  private boolean yZH;
  private int yZQ;
  private Bitmap yZR;
  private ImageView yZS;
  protected a yZT;
  protected a yZU;
  protected a yZV;
  protected a yZW;
  private c.a yZh;
  private int yZx;
  protected View.OnClickListener yZz;
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29517);
    this.eSO = 0;
    this.asO = new Matrix();
    this.nBO = 0L;
    this.yZx = -1;
    this.yZz = new LauncherUITabView.1(this);
    this.yZA = new LauncherUITabView.2(this);
    this.yZB = 0;
    this.yZC = 0;
    this.yZD = 0;
    this.yZG = 0;
    this.yZE = false;
    this.yZH = false;
    init();
    AppMethodBeat.o(29517);
  }
  
  public LauncherUITabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29518);
    this.eSO = 0;
    this.asO = new Matrix();
    this.nBO = 0L;
    this.yZx = -1;
    this.yZz = new LauncherUITabView.1(this);
    this.yZA = new LauncherUITabView.2(this);
    this.yZB = 0;
    this.yZC = 0;
    this.yZD = 0;
    this.yZG = 0;
    this.yZE = false;
    this.yZH = false;
    init();
    AppMethodBeat.o(29518);
  }
  
  private a Oe(int paramInt)
  {
    AppMethodBeat.i(29519);
    a locala = new a();
    locala.yZY = new MMTabView(getContext(), paramInt);
    locala.yZY.setTag(Integer.valueOf(paramInt));
    locala.yZY.setOnClickListener(this.yZz);
    AppMethodBeat.o(29519);
    return locala;
  }
  
  private void dCn()
  {
    AppMethodBeat.i(29524);
    this.yZS = new ImageView(getContext());
    this.yZS.setImageMatrix(this.asO);
    this.yZS.setScaleType(ImageView.ScaleType.MATRIX);
    this.yZS.setId(2307142);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2307141);
    addView(this.yZS, localLayoutParams);
    AppMethodBeat.o(29524);
  }
  
  private a f(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29520);
    a locala = Oe(0);
    locala.yZY.setText(2131301391);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZY, localLayoutParams);
    AppMethodBeat.o(29520);
    return locala;
  }
  
  private a g(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29521);
    a locala = Oe(1);
    locala.yZY.setText(2131301392);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZY, localLayoutParams);
    AppMethodBeat.o(29521);
    return locala;
  }
  
  private a h(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29522);
    a locala = Oe(2);
    locala.yZY.setText(2131301390);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZY, localLayoutParams);
    AppMethodBeat.o(29522);
    return locala;
  }
  
  private a i(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29523);
    a locala = Oe(3);
    locala.yZY.setText(2131301424);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZY, localLayoutParams);
    AppMethodBeat.o(29523);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(29525);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundResource(2131690709);
    localLinearLayout.setId(2307141);
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -2));
    dCn();
    this.yZT = f(localLinearLayout);
    this.yZU = g(localLinearLayout);
    this.yZV = h(localLinearLayout);
    this.yZW = i(localLinearLayout);
    AppMethodBeat.o(29525);
  }
  
  public final void NU(int paramInt)
  {
    AppMethodBeat.i(29527);
    ab.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.yZB = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZT.yZY.setUnread(getContext().getString(2131304422));
        AppMethodBeat.o(29527);
        return;
      }
      this.yZT.yZY.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(29527);
      return;
    }
    this.yZT.yZY.setUnread(null);
    AppMethodBeat.o(29527);
  }
  
  public final void NV(int paramInt)
  {
    AppMethodBeat.i(29529);
    this.yZC = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZU.yZY.setUnread(getContext().getString(2131304422));
        AppMethodBeat.o(29529);
        return;
      }
      this.yZU.yZY.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(29529);
      return;
    }
    this.yZU.yZY.setUnread(null);
    AppMethodBeat.o(29529);
  }
  
  public final void NW(int paramInt)
  {
    AppMethodBeat.i(29530);
    this.yZD = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZV.yZY.setUnread(getContext().getString(2131304422));
        AppMethodBeat.o(29530);
        return;
      }
      this.yZV.yZY.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(29530);
      return;
    }
    this.yZV.yZY.setUnread(null);
    AppMethodBeat.o(29530);
  }
  
  public final void NX(int paramInt)
  {
    AppMethodBeat.i(29531);
    this.yZG = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZW.yZY.setUnread(getContext().getString(2131304422));
        AppMethodBeat.o(29531);
        return;
      }
      this.yZW.yZY.setUnread(String.valueOf(paramInt));
      AppMethodBeat.o(29531);
      return;
    }
    this.yZW.yZY.setUnread(null);
    AppMethodBeat.o(29531);
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(29528);
    if ((this.yZT == null) || (this.yZU == null) || (this.yZV == null) || (this.yZW == null))
    {
      AppMethodBeat.o(29528);
      return;
    }
    this.yZT.yZY.dCA();
    this.yZU.yZY.dCA();
    this.yZV.yZY.dCA();
    this.yZW.yZY.dCA();
    AppMethodBeat.o(29528);
  }
  
  public int getContactTabUnread()
  {
    return this.yZC;
  }
  
  public int getCurIdx()
  {
    return this.eSO;
  }
  
  public int getFriendTabUnread()
  {
    return this.yZD;
  }
  
  public int getMainTabUnread()
  {
    return this.yZB;
  }
  
  public boolean getSettingsPoint()
  {
    return this.yZH;
  }
  
  public int getSettingsTabUnread()
  {
    return this.yZG;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.yZE;
  }
  
  public final void k(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(29534);
    this.asO.setTranslate(this.yZQ * (paramInt + paramFloat), 0.0F);
    this.yZS.setImageMatrix(this.asO);
    AppMethodBeat.o(29534);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(29526);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ab.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[] { Integer.valueOf(paramInt3 - paramInt1) });
    this.yZQ = ((paramInt3 - paramInt1) / 4);
    paramInt2 = this.yZQ;
    if ((this.yZR == null) || (this.yZR.getWidth() != paramInt2)) {
      if (this.yZR != null) {
        break label185;
      }
    }
    label185:
    for (paramInt1 = -1;; paramInt1 = this.yZR.getWidth())
    {
      ab.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.yZR = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.yZR).drawColor(getResources().getColor(2131690701));
      k(this.eSO, 0.0F);
      this.yZS.setImageBitmap(this.yZR);
      setTo(this.eSO);
      AppMethodBeat.o(29526);
      return;
    }
  }
  
  public final void qa(boolean paramBoolean)
  {
    AppMethodBeat.i(29532);
    this.yZE = paramBoolean;
    this.yZV.yZY.qs(paramBoolean);
    AppMethodBeat.o(29532);
  }
  
  public final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(29533);
    this.yZH = paramBoolean;
    this.yZW.yZY.qs(paramBoolean);
    AppMethodBeat.o(29533);
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.yZh = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(29535);
    this.eSO = paramInt;
    MMTabView localMMTabView = this.yZT.yZY;
    if (paramInt == 0)
    {
      localColorStateList = getResources().getColorStateList(2131690701);
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.yZU.yZY;
      if (paramInt != 1) {
        break label162;
      }
      localColorStateList = getResources().getColorStateList(2131690701);
      label63:
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.yZV.yZY;
      if (paramInt != 2) {
        break label176;
      }
      localColorStateList = getResources().getColorStateList(2131690701);
      label92:
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.yZW.yZY;
      if (paramInt != 3) {
        break label190;
      }
    }
    label162:
    label176:
    label190:
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131690701);; localColorStateList = getResources().getColorStateList(2131690759))
    {
      localMMTabView.setTextColor(localColorStateList);
      this.nBO = System.currentTimeMillis();
      this.yZx = this.eSO;
      AppMethodBeat.o(29535);
      return;
      localColorStateList = getResources().getColorStateList(2131690759);
      break;
      localColorStateList = getResources().getColorStateList(2131690759);
      break label63;
      localColorStateList = getResources().getColorStateList(2131690759);
      break label92;
    }
  }
  
  protected final class a
  {
    MMTabView yZY;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView
 * JD-Core Version:    0.7.0.1
 */