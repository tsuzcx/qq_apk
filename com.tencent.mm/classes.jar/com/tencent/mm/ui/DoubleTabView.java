package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView VTD;
  MMTabView VTE;
  private MMTabView VTF;
  private String VTG;
  private String VTH;
  private String VTI;
  private a VTJ;
  private Matrix aqj;
  private int uPU;
  private int uPV;
  private Bitmap uPW;
  private LinearLayout uPX;
  private ImageView uPY;
  protected View.OnClickListener uQc;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.uPV = 0;
    this.aqj = new Matrix();
    this.uQc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(141284);
      }
    };
    init();
    AppMethodBeat.o(141285);
  }
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141286);
    this.uPV = 0;
    this.aqj = new Matrix();
    this.uQc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(141284);
      }
    };
    init();
    AppMethodBeat.o(141286);
  }
  
  private MMTabView JK(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.uQc);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void cWT()
  {
    AppMethodBeat.i(141289);
    this.uPX = new LinearLayout(getContext());
    this.uPX.setBackgroundResource(a.d.white);
    this.uPX.setId(a.g.double_tab_container);
    this.uPX.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.uPX, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void cWU()
  {
    AppMethodBeat.i(141290);
    this.uPY = new ImageView(getContext());
    this.uPY.setImageMatrix(this.aqj);
    this.uPY.setScaleType(ImageView.ScaleType.MATRIX);
    this.uPY.setId(a.g.double_tab_shape);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, a.g.double_tab_container);
    addView(this.uPY, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void hFW()
  {
    AppMethodBeat.i(141293);
    this.VTD = JK(0);
    this.VTD.setText(this.VTG);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(a.e.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.uPX.addView(this.VTD, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void hFX()
  {
    AppMethodBeat.i(141294);
    this.VTE = JK(1);
    this.VTE.setText(this.VTH);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(a.e.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.uPX.addView(this.VTE, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    cWT();
    cWU();
    hFW();
    hFX();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.uPV;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.uPU = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.uPU;
    if ((this.uPW == null) || (this.uPW.getWidth() != paramInt2)) {
      if (this.uPW != null) {
        break label160;
      }
    }
    label160:
    for (paramInt1 = -1;; paramInt1 = this.uPW.getWidth())
    {
      Log.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.uPW = Bitmap.createBitmap(paramInt2, com.tencent.mm.ci.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.uPW).drawColor(getResources().getColor(a.d.wechat_green));
      q(this.uPV, 0.0F);
      this.uPY.setImageBitmap(this.uPW);
      setTo(this.uPV);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.aqj.setTranslate(this.uPU * (paramInt + paramFloat), 0.0F);
    this.uPY.setImageMatrix(this.aqj);
    AppMethodBeat.o(141296);
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.VTG = paramString;
    this.VTD.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.VTD != null) {
      this.VTD.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.VTJ = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.VTH = paramString;
    this.VTE.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.VTE != null) {
      this.VTE.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setThirdTabString(String paramString)
  {
    AppMethodBeat.i(213927);
    this.VTI = paramString;
    this.VTF.setText(paramString);
    requestLayout();
    AppMethodBeat.o(213927);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.uPV = paramInt;
    MMTabView localMMTabView = this.VTD;
    if (this.uPV == 0)
    {
      paramInt = getResources().getColor(a.d.wechat_green);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.VTE;
      if (this.uPV != 1) {
        break label92;
      }
    }
    label92:
    for (paramInt = getResources().getColor(a.d.wechat_green);; paramInt = getContext().getResources().getColor(a.d.FG_0))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(141297);
      return;
      paramInt = getContext().getResources().getColor(a.d.FG_0);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onTabClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView
 * JD-Core Version:    0.7.0.1
 */