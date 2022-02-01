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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public class DoubleTabView
  extends RelativeLayout
{
  private MMTabView adxN;
  private MMTabView adxO;
  private MMTabView adxP;
  private String adxQ;
  private String adxR;
  private String adxS;
  private DoubleTabView.a adxT;
  boolean adxU;
  private Matrix avQ;
  private int xYF;
  private int xYG;
  private Bitmap xYH;
  private LinearLayout xYI;
  private ImageView xYJ;
  protected View.OnClickListener xYN;
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141285);
    this.xYG = 0;
    this.avQ = new Matrix();
    this.xYN = new DoubleTabView.1(this);
    this.adxU = false;
    init();
    AppMethodBeat.o(141285);
  }
  
  public DoubleTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141286);
    this.xYG = 0;
    this.avQ = new Matrix();
    this.xYN = new DoubleTabView.1(this);
    this.adxU = false;
    init();
    AppMethodBeat.o(141286);
  }
  
  private MMTabView Kv(int paramInt)
  {
    AppMethodBeat.i(141295);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.xYN);
    AppMethodBeat.o(141295);
    return localMMTabView;
  }
  
  private void dCA()
  {
    AppMethodBeat.i(141290);
    this.xYJ = new ImageView(getContext());
    this.xYJ.setImageMatrix(this.avQ);
    this.xYJ.setScaleType(ImageView.ScaleType.MATRIX);
    this.xYJ.setId(a.g.double_tab_shape);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, a.g.double_tab_container);
    addView(this.xYJ, localLayoutParams);
    AppMethodBeat.o(141290);
  }
  
  private void dCz()
  {
    AppMethodBeat.i(141289);
    this.xYI = new LinearLayout(getContext());
    this.xYI.setBackgroundResource(a.d.white);
    this.xYI.setId(a.g.double_tab_container);
    this.xYI.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.xYI, localLayoutParams);
    AppMethodBeat.o(141289);
  }
  
  private void init()
  {
    AppMethodBeat.i(141288);
    dCz();
    dCA();
    jih();
    jii();
    AppMethodBeat.o(141288);
  }
  
  private void jih()
  {
    AppMethodBeat.i(141293);
    this.adxN = Kv(0);
    this.adxN.setText(this.adxQ);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(a.e.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.xYI.addView(this.adxN, localLayoutParams);
    AppMethodBeat.o(141293);
  }
  
  private void jii()
  {
    AppMethodBeat.i(141294);
    this.adxO = Kv(1);
    this.adxO.setText(this.adxR);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(a.e.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.xYI.addView(this.adxO, localLayoutParams);
    AppMethodBeat.o(141294);
  }
  
  public final void KW(boolean paramBoolean)
  {
    AppMethodBeat.i(141300);
    this.adxU = paramBoolean;
    if (this.adxO != null) {
      this.adxO.ol(paramBoolean);
    }
    AppMethodBeat.o(141300);
  }
  
  public int getCurentIndex()
  {
    return this.xYG;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141287);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.xYF = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.xYF;
    if ((this.xYH == null) || (this.xYH.getWidth() != paramInt2)) {
      if (this.xYH != null) {
        break label160;
      }
    }
    label160:
    for (paramInt1 = -1;; paramInt1 = this.xYH.getWidth())
    {
      Log.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.xYH = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.xYH).drawColor(getResources().getColor(a.d.wechat_green));
      t(this.xYG, 0.0F);
      this.xYJ.setImageBitmap(this.xYH);
      setTo(this.xYG);
      AppMethodBeat.o(141287);
      return;
    }
  }
  
  public void setFirstTabString(String paramString)
  {
    AppMethodBeat.i(141291);
    this.adxQ = paramString;
    this.adxN.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141291);
  }
  
  public void setFirstTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141298);
    if (this.adxN != null) {
      this.adxN.setUnread(paramString);
    }
    AppMethodBeat.o(141298);
  }
  
  public void setOnTabClickListener(DoubleTabView.a parama)
  {
    this.adxT = parama;
  }
  
  public void setSecondTabString(String paramString)
  {
    AppMethodBeat.i(141292);
    this.adxR = paramString;
    this.adxO.setText(paramString);
    requestLayout();
    AppMethodBeat.o(141292);
  }
  
  public void setSecondTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(141299);
    if (this.adxO != null) {
      this.adxO.setUnread(paramString);
    }
    AppMethodBeat.o(141299);
  }
  
  public void setThirdTabString(String paramString)
  {
    AppMethodBeat.i(249419);
    this.adxS = paramString;
    this.adxP.setText(paramString);
    requestLayout();
    AppMethodBeat.o(249419);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(141297);
    this.xYG = paramInt;
    MMTabView localMMTabView = this.adxN;
    if (this.xYG == 0)
    {
      paramInt = getResources().getColor(a.d.wechat_green);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.adxO;
      if (this.xYG != 1) {
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
  
  public final void t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141296);
    this.avQ.setTranslate(this.xYF * (paramInt + paramFloat), 0.0F);
    this.xYJ.setImageMatrix(this.avQ);
    AppMethodBeat.o(141296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView
 * JD-Core Version:    0.7.0.1
 */