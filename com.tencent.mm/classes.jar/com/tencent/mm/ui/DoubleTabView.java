package com.tencent.mm.ui;

import android.content.Context;
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
import com.tencent.mm.sdk.platformtools.ae;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView Jqm;
  private MMTabView Jqn;
  private String Jqo;
  private String Jqp;
  private DoubleTabView.a Jqq;
  private Matrix mMatrix;
  private int pVJ;
  private int pVK;
  private Bitmap pVL;
  private LinearLayout pVM;
  private ImageView pVN;
  protected View.OnClickListener pVR;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.pVK = 0;
    this.mMatrix = new Matrix();
    this.pVR = new DoubleTabView.1(this);
    init();
    AppMethodBeat.o(141285);
  }
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141286);
    this.pVK = 0;
    this.mMatrix = new Matrix();
    this.pVR = new DoubleTabView.1(this);
    init();
    AppMethodBeat.o(141286);
  }
  
  private MMTabView Cs(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.pVR);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void ckk()
  {
    AppMethodBeat.i(141289);
    this.pVM = new LinearLayout(getContext());
    this.pVM.setBackgroundResource(2131101179);
    this.pVM.setId(2131299184);
    this.pVM.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.pVM, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void ckl()
  {
    AppMethodBeat.i(141290);
    this.pVN = new ImageView(getContext());
    this.pVN.setImageMatrix(this.mMatrix);
    this.pVN.setScaleType(ImageView.ScaleType.MATRIX);
    this.pVN.setId(2131299185);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299184);
    addView(this.pVN, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void fzA()
  {
    AppMethodBeat.i(141294);
    this.Jqn = Cs(1);
    this.Jqn.setText(this.Jqp);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pVM.addView(this.Jqn, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void fzz()
  {
    AppMethodBeat.i(141293);
    this.Jqm = Cs(0);
    this.Jqm.setText(this.Jqo);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pVM.addView(this.Jqm, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    ckk();
    ckl();
    fzz();
    fzA();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.pVK;
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.mMatrix.setTranslate(this.pVJ * (paramInt + paramFloat), 0.0F);
    this.pVN.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(141296);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pVJ = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.pVJ;
    if ((this.pVL == null) || (this.pVL.getWidth() != paramInt2)) {
      if (this.pVL != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.pVL.getWidth())
    {
      ae.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.pVL = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.pVL).drawColor(getResources().getColor(2131101171));
      o(this.pVK, 0.0F);
      this.pVN.setImageBitmap(this.pVL);
      setTo(this.pVK);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.Jqo = paramString;
    this.Jqm.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.Jqm != null) {
      this.Jqm.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(DoubleTabView.a parama)
  {
    this.Jqq = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.Jqp = paramString;
    this.Jqn.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.Jqn != null) {
      this.Jqn.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.pVK = paramInt;
    MMTabView localMMTabView = this.Jqm;
    if (this.pVK == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.Jqn;
      if (this.pVK != 1) {
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
  
  public final void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(141300);
    if (this.Jqn != null) {
      this.Jqn.xv(paramBoolean);
    }
    AppMethodBeat.o(141300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView
 * JD-Core Version:    0.7.0.1
 */