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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView IVE;
  private MMTabView IVF;
  private String IVG;
  private String IVH;
  private a IVI;
  private Matrix mMatrix;
  private int pPe;
  private int pPf;
  private Bitmap pPg;
  private LinearLayout pPh;
  private ImageView pPi;
  protected View.OnClickListener pPm;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.pPf = 0;
    this.mMatrix = new Matrix();
    this.pPm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.pPf = 0;
    this.mMatrix = new Matrix();
    this.pPm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  private MMTabView Cg(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.pPm);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void ciU()
  {
    AppMethodBeat.i(141289);
    this.pPh = new LinearLayout(getContext());
    this.pPh.setBackgroundResource(2131101179);
    this.pPh.setId(2131299184);
    this.pPh.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.pPh, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void ciV()
  {
    AppMethodBeat.i(141290);
    this.pPi = new ImageView(getContext());
    this.pPi.setImageMatrix(this.mMatrix);
    this.pPi.setScaleType(ImageView.ScaleType.MATRIX);
    this.pPi.setId(2131299185);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299184);
    addView(this.pPi, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void fvA()
  {
    AppMethodBeat.i(141294);
    this.IVF = Cg(1);
    this.IVF.setText(this.IVH);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pPh.addView(this.IVF, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void fvz()
  {
    AppMethodBeat.i(141293);
    this.IVE = Cg(0);
    this.IVE.setText(this.IVG);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pPh.addView(this.IVE, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    ciU();
    ciV();
    fvz();
    fvA();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.pPf;
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.mMatrix.setTranslate(this.pPe * (paramInt + paramFloat), 0.0F);
    this.pPi.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(141296);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pPe = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.pPe;
    if ((this.pPg == null) || (this.pPg.getWidth() != paramInt2)) {
      if (this.pPg != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.pPg.getWidth())
    {
      ad.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.pPg = Bitmap.createBitmap(paramInt2, com.tencent.mm.cc.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.pPg).drawColor(getResources().getColor(2131101171));
      o(this.pPf, 0.0F);
      this.pPi.setImageBitmap(this.pPg);
      setTo(this.pPf);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.IVG = paramString;
    this.IVE.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.IVE != null) {
      this.IVE.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.IVI = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.IVH = paramString;
    this.IVF.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.IVF != null) {
      this.IVF.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.pPf = paramInt;
    MMTabView localMMTabView = this.IVE;
    if (this.pPf == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.IVF;
      if (this.pPf != 1) {
        break label90;
      }
    }
    label90:
    for (paramInt = getResources().getColor(2131101171);; paramInt = getContext().getResources().getColor(2131099732))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(141297);
      return;
      paramInt = getContext().getResources().getColor(2131099732);
      break;
    }
  }
  
  public final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(141300);
    if (this.IVF != null) {
      this.IVF.xn(paramBoolean);
    }
    AppMethodBeat.o(141300);
  }
  
  public static abstract interface a
  {
    public abstract void onTabClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView
 * JD-Core Version:    0.7.0.1
 */