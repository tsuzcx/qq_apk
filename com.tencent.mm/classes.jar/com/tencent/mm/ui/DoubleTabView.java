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
import com.tencent.mm.sdk.platformtools.Log;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView OAq;
  MMTabView OAr;
  private MMTabView OAs;
  private String OAt;
  private String OAu;
  private String OAv;
  private a OAw;
  private Matrix mMatrix;
  private int rmI;
  private int rmJ;
  private Bitmap rmK;
  private LinearLayout rmL;
  private ImageView rmM;
  protected View.OnClickListener rmQ;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.rmJ = 0;
    this.mMatrix = new Matrix();
    this.rmQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.rmJ = 0;
    this.mMatrix = new Matrix();
    this.rmQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141284);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  private MMTabView Gd(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.rmQ);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void cIm()
  {
    AppMethodBeat.i(141289);
    this.rmL = new LinearLayout(getContext());
    this.rmL.setBackgroundResource(2131101424);
    this.rmL.setId(2131299735);
    this.rmL.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.rmL, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void cIn()
  {
    AppMethodBeat.i(141290);
    this.rmM = new ImageView(getContext());
    this.rmM.setImageMatrix(this.mMatrix);
    this.rmM.setScaleType(ImageView.ScaleType.MATRIX);
    this.rmM.setId(2131299736);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299735);
    addView(this.rmM, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void gHn()
  {
    AppMethodBeat.i(141293);
    this.OAq = Gd(0);
    this.OAq.setText(this.OAt);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    this.rmL.addView(this.OAq, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void gHo()
  {
    AppMethodBeat.i(141294);
    this.OAr = Gd(1);
    this.OAr.setText(this.OAu);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    this.rmL.addView(this.OAr, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    cIm();
    cIn();
    gHn();
    gHo();
    AppMethodBeat.o(141288);
  }
  
  public int getCurentIndex()
  {
    return this.rmJ;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.rmI = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.rmI;
    if ((this.rmK == null) || (this.rmK.getWidth() != paramInt2)) {
      if (this.rmK != null) {
        break label159;
      }
    }
    label159:
    for (paramInt1 = -1;; paramInt1 = this.rmK.getWidth())
    {
      Log.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.rmK = Bitmap.createBitmap(paramInt2, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.rmK).drawColor(getResources().getColor(2131101414));
      p(this.rmJ, 0.0F);
      this.rmM.setImageBitmap(this.rmK);
      setTo(this.rmJ);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public final void p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.mMatrix.setTranslate(this.rmI * (paramInt + paramFloat), 0.0F);
    this.rmM.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(141296);
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.OAt = paramString;
    this.OAq.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.OAq != null) {
      this.OAq.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.OAw = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.OAu = paramString;
    this.OAr.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.OAr != null) {
      this.OAr.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setThirdTabString(String paramString)
  {
    AppMethodBeat.i(205108);
    this.OAv = paramString;
    this.OAs.setText(paramString);
    requestLayout();
    AppMethodBeat.o(205108);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.rmJ = paramInt;
    MMTabView localMMTabView = this.OAq;
    if (this.rmJ == 0)
    {
      paramInt = getResources().getColor(2131101414);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.OAr;
      if (this.rmJ != 1) {
        break label90;
      }
    }
    label90:
    for (paramInt = getResources().getColor(2131101414);; paramInt = getContext().getResources().getColor(2131099746))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(141297);
      return;
      paramInt = getContext().getResources().getColor(2131099746);
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