package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public class DoubleTabView
  extends RelativeLayout
{
  private int lrK;
  private int lrL;
  private Bitmap lrM;
  private LinearLayout lrN;
  private ImageView lrO;
  protected View.OnClickListener lrS;
  private Matrix mMatrix;
  private MMTabView yWb;
  private MMTabView yWc;
  private String yWd;
  private String yWe;
  private DoubleTabView.a yWf;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105956);
    this.lrL = 0;
    this.mMatrix = new Matrix();
    this.lrS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105955);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
        AppMethodBeat.o(105955);
      }
    };
    init();
    AppMethodBeat.o(105956);
  }
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105957);
    this.lrL = 0;
    this.mMatrix = new Matrix();
    this.lrS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105955);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
        AppMethodBeat.o(105955);
      }
    };
    init();
    AppMethodBeat.o(105957);
  }
  
  private void bns()
  {
    AppMethodBeat.i(105960);
    this.lrN = new LinearLayout(getContext());
    this.lrN.setBackgroundResource(2131690709);
    this.lrN.setId(2131820592);
    this.lrN.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.lrN, localLayoutParams);
    AppMethodBeat.o(105960);
  }
  
  private void bnt()
  {
    AppMethodBeat.i(105961);
    this.lrO = new ImageView(getContext());
    this.lrO.setImageMatrix(this.mMatrix);
    this.lrO.setScaleType(ImageView.ScaleType.MATRIX);
    this.lrO.setId(2131820593);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131820592);
    addView(this.lrO, localLayoutParams);
    AppMethodBeat.o(105961);
  }
  
  private void dBp()
  {
    AppMethodBeat.i(105964);
    this.yWb = ux(0);
    this.yWb.setText(this.yWd);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    this.lrN.addView(this.yWb, localLayoutParams);
    AppMethodBeat.o(105964);
  }
  
  private void dBq()
  {
    AppMethodBeat.i(105965);
    this.yWc = ux(1);
    this.yWc.setText(this.yWe);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    this.lrN.addView(this.yWc, localLayoutParams);
    AppMethodBeat.o(105965);
  }
  
  private void init()
  {
    AppMethodBeat.i(105959);
    bns();
    bnt();
    dBp();
    dBq();
    AppMethodBeat.o(105959);
  }
  
  private MMTabView ux(int paramInt)
  {
    AppMethodBeat.i(105966);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.lrS);
    AppMethodBeat.o(105966);
    return localMMTabView;
  }
  
  public int getCurentIndex()
  {
    return this.lrL;
  }
  
  public final void k(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(105967);
    this.mMatrix.setTranslate(this.lrK * (paramInt + paramFloat), 0.0F);
    this.lrO.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(105967);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105958);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lrK = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.lrK;
    if ((this.lrM == null) || (this.lrM.getWidth() != paramInt2)) {
      if (this.lrM != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.lrM.getWidth())
    {
      ab.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.lrM = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.lrM).drawColor(getResources().getColor(2131690701));
      k(this.lrL, 0.0F);
      this.lrO.setImageBitmap(this.lrM);
      setTo(this.lrL);
      AppMethodBeat.o(105958);
      return;
    }
  }
  
  public final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(105971);
    if (this.yWc != null) {
      this.yWc.qs(paramBoolean);
    }
    AppMethodBeat.o(105971);
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(105962);
    this.yWd = paramString;
    this.yWb.setText(paramString);
    requestLayout();
    AppMethodBeat.o(105962);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(105969);
    if (this.yWb != null) {
      this.yWb.setUnread(paramString);
    }
    AppMethodBeat.o(105969);
  }
  
  public void setOnTabClickListener(DoubleTabView.a parama)
  {
    this.yWf = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(105963);
    this.yWe = paramString;
    this.yWc.setText(paramString);
    requestLayout();
    AppMethodBeat.o(105963);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(105970);
    if (this.yWc != null) {
      this.yWc.setUnread(paramString);
    }
    AppMethodBeat.o(105970);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(105968);
    this.lrL = paramInt;
    MMTabView localMMTabView = this.yWb;
    if (this.lrL == 0)
    {
      localColorStateList = getResources().getColorStateList(2131690701);
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.yWc;
      if (this.lrL != 1) {
        break label87;
      }
    }
    label87:
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131690701);; localColorStateList = getResources().getColorStateList(2131690759))
    {
      localMMTabView.setTextColor(localColorStateList);
      AppMethodBeat.o(105968);
      return;
      localColorStateList = getResources().getColorStateList(2131690759);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView
 * JD-Core Version:    0.7.0.1
 */