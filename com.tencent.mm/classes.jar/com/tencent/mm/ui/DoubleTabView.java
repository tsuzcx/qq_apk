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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView Hin;
  private MMTabView Hio;
  private String Hip;
  private String Hiq;
  private a Hir;
  private Matrix mMatrix;
  private int plE;
  private int plF;
  private Bitmap plG;
  private LinearLayout plH;
  private ImageView plI;
  protected View.OnClickListener plM;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.plF = 0;
    this.mMatrix = new Matrix();
    this.plM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
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
    this.plF = 0;
    this.mMatrix = new Matrix();
    this.plM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (DoubleTabView.a(DoubleTabView.this) != null) {
          DoubleTabView.a(DoubleTabView.this).onTabClick(i);
        }
        AppMethodBeat.o(141284);
      }
    };
    init();
    AppMethodBeat.o(141286);
  }
  
  private MMTabView By(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.plM);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void cer()
  {
    AppMethodBeat.i(141289);
    this.plH = new LinearLayout(getContext());
    this.plH.setBackgroundResource(2131101179);
    this.plH.setId(2131299184);
    this.plH.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.plH, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void ces()
  {
    AppMethodBeat.i(141290);
    this.plI = new ImageView(getContext());
    this.plI.setImageMatrix(this.mMatrix);
    this.plI.setScaleType(ImageView.ScaleType.MATRIX);
    this.plI.setId(2131299185);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299184);
    addView(this.plI, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void ffr()
  {
    AppMethodBeat.i(141293);
    this.Hin = By(0);
    this.Hin.setText(this.Hip);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.plH.addView(this.Hin, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void ffs()
  {
    AppMethodBeat.i(141294);
    this.Hio = By(1);
    this.Hio.setText(this.Hiq);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.plH.addView(this.Hio, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    cer();
    ces();
    ffr();
    ffs();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.plF;
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.mMatrix.setTranslate(this.plE * (paramInt + paramFloat), 0.0F);
    this.plI.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(141296);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.plE = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.plE;
    if ((this.plG == null) || (this.plG.getWidth() != paramInt2)) {
      if (this.plG != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.plG.getWidth())
    {
      ac.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.plG = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.plG).drawColor(getResources().getColor(2131101171));
      n(this.plF, 0.0F);
      this.plI.setImageBitmap(this.plG);
      setTo(this.plF);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.Hip = paramString;
    this.Hin.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.Hin != null) {
      this.Hin.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.Hir = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.Hiq = paramString;
    this.Hio.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.Hio != null) {
      this.Hio.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.plF = paramInt;
    MMTabView localMMTabView = this.Hin;
    if (this.plF == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.Hio;
      if (this.plF != 1) {
        break label87;
      }
    }
    label87:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aJ(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(141297);
      return;
      paramInt = ao.aJ(getContext(), 2130968584);
      break;
    }
  }
  
  public final void wo(boolean paramBoolean)
  {
    AppMethodBeat.i(141300);
    if (this.Hio != null) {
      this.Hio.wB(paramBoolean);
    }
    AppMethodBeat.o(141300);
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