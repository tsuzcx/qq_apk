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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView FJf;
  private MMTabView FJg;
  private String FJh;
  private String FJi;
  private a FJj;
  private Matrix mMatrix;
  private int oIe;
  private int oIf;
  private Bitmap oIg;
  private LinearLayout oIh;
  private ImageView oIi;
  protected View.OnClickListener oIm;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.oIf = 0;
    this.mMatrix = new Matrix();
    this.oIm = new View.OnClickListener()
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
    this.oIf = 0;
    this.mMatrix = new Matrix();
    this.oIm = new View.OnClickListener()
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
  
  private MMTabView AG(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.oIm);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void bXe()
  {
    AppMethodBeat.i(141289);
    this.oIh = new LinearLayout(getContext());
    this.oIh.setBackgroundResource(2131101179);
    this.oIh.setId(2131299184);
    this.oIh.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.oIh, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void bXf()
  {
    AppMethodBeat.i(141290);
    this.oIi = new ImageView(getContext());
    this.oIi.setImageMatrix(this.mMatrix);
    this.oIi.setScaleType(ImageView.ScaleType.MATRIX);
    this.oIi.setId(2131299185);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299184);
    addView(this.oIi, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void ePM()
  {
    AppMethodBeat.i(141293);
    this.FJf = AG(0);
    this.FJf.setText(this.FJh);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.oIh.addView(this.FJf, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void ePN()
  {
    AppMethodBeat.i(141294);
    this.FJg = AG(1);
    this.FJg.setText(this.FJi);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.oIh.addView(this.FJg, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    bXe();
    bXf();
    ePM();
    ePN();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.oIf;
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.mMatrix.setTranslate(this.oIe * (paramInt + paramFloat), 0.0F);
    this.oIi.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(141296);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.oIe = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.oIe;
    if ((this.oIg == null) || (this.oIg.getWidth() != paramInt2)) {
      if (this.oIg != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.oIg.getWidth())
    {
      ad.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.oIg = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.oIg).drawColor(getResources().getColor(2131101171));
      n(this.oIf, 0.0F);
      this.oIi.setImageBitmap(this.oIg);
      setTo(this.oIf);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.FJh = paramString;
    this.FJf.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.FJf != null) {
      this.FJf.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.FJj = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.FJi = paramString;
    this.FJg.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.FJg != null) {
      this.FJg.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.oIf = paramInt;
    MMTabView localMMTabView = this.FJf;
    if (this.oIf == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.FJg;
      if (this.oIf != 1) {
        break label87;
      }
    }
    label87:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aD(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(141297);
      return;
      paramInt = ao.aD(getContext(), 2130968584);
      break;
    }
  }
  
  public final void vm(boolean paramBoolean)
  {
    AppMethodBeat.i(141300);
    if (this.FJg != null) {
      this.FJg.vz(paramBoolean);
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