package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.y;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private ColorStateList dP;
  private float lgI;
  private Context mContext;
  private Button nbE;
  private Button nbF;
  private Button nbG;
  private Button nbH;
  private Button nbI;
  private Button nbJ;
  private Button nbK;
  private Button nbL;
  private Button nbM;
  private Button nbN;
  private ImageButton nbO;
  private View nbP;
  private View nbQ;
  private View nbR;
  private View nbS;
  private View nbT;
  private View nbU;
  private boolean nbV = true;
  private int nbW;
  private int nbX;
  private int nbY;
  private int nbZ;
  private MMKeyBoardView.a nbm;
  private int nca;
  private int ncb;
  private int ncc;
  private int ncd;
  private int nce;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.nbW = getResources().getDimensionPixelSize(R.f.keyboard_button_padding_height);
    this.nbX = getResources().getDimensionPixelSize(R.f.keyboard_button_padding_width);
    this.lgI = getResources().getDimensionPixelSize(R.f.keyboard_button_text_size);
    this.dP = getResources().getColorStateList(R.e.keyboard_text_color);
    this.nbY = getResources().getColor(R.e.keyboard_div_line_color);
    this.nbE = new Button(this.mContext);
    this.nbF = new Button(this.mContext);
    this.nbG = new Button(this.mContext);
    this.nbH = new Button(this.mContext);
    this.nbI = new Button(this.mContext);
    this.nbJ = new Button(this.mContext);
    this.nbK = new Button(this.mContext);
    this.nbL = new Button(this.mContext);
    this.nbM = new Button(this.mContext);
    this.nbN = new Button(this.mContext);
    this.nbO = new ImageButton(this.mContext);
    this.nbP = new View(this.mContext);
    this.nbP = new View(this.mContext);
    this.nbQ = new View(this.mContext);
    this.nbR = new View(this.mContext);
    this.nbS = new View(this.mContext);
    this.nbT = new View(this.mContext);
    this.nbU = new View(this.mContext);
    this.nbE.setBackgroundResource(R.g.keyboard_btn);
    this.nbF.setBackgroundResource(R.g.keyboard_btn);
    this.nbG.setBackgroundResource(R.g.keyboard_btn);
    this.nbH.setBackgroundResource(R.g.keyboard_btn);
    this.nbI.setBackgroundResource(R.g.keyboard_btn);
    this.nbJ.setBackgroundResource(R.g.keyboard_btn);
    this.nbK.setBackgroundResource(R.g.keyboard_btn);
    this.nbL.setBackgroundResource(R.g.keyboard_btn);
    this.nbM.setBackgroundResource(R.g.keyboard_btn);
    this.nbJ.setBackgroundResource(R.g.keyboard_btn);
    this.nbN.setBackgroundResource(R.g.keyboard_btn);
    this.nbO.setBackgroundResource(R.g.keyboard_btn);
    this.nbO.setImageResource(R.g.keyboard_delete_btn);
    this.nbE.setText("0");
    this.nbF.setText("1");
    this.nbG.setText("2");
    this.nbH.setText("3");
    this.nbI.setText("4");
    this.nbJ.setText("5");
    this.nbK.setText("6");
    this.nbL.setText("7");
    this.nbM.setText("8");
    this.nbN.setText("9");
    this.nbE.setGravity(17);
    this.nbF.setGravity(17);
    this.nbG.setGravity(17);
    this.nbH.setGravity(17);
    this.nbI.setGravity(17);
    this.nbJ.setGravity(17);
    this.nbK.setGravity(17);
    this.nbL.setGravity(17);
    this.nbM.setGravity(17);
    this.nbN.setGravity(17);
    this.nbE.setTextSize(0, this.lgI);
    this.nbF.setTextSize(0, this.lgI);
    this.nbG.setTextSize(0, this.lgI);
    this.nbH.setTextSize(0, this.lgI);
    this.nbI.setTextSize(0, this.lgI);
    this.nbJ.setTextSize(0, this.lgI);
    this.nbK.setTextSize(0, this.lgI);
    this.nbL.setTextSize(0, this.lgI);
    this.nbM.setTextSize(0, this.lgI);
    this.nbN.setTextSize(0, this.lgI);
    this.nbE.setTextColor(this.dP);
    this.nbF.setTextColor(this.dP);
    this.nbG.setTextColor(this.dP);
    this.nbH.setTextColor(this.dP);
    this.nbI.setTextColor(this.dP);
    this.nbJ.setTextColor(this.dP);
    this.nbK.setTextColor(this.dP);
    this.nbL.setTextColor(this.dP);
    this.nbM.setTextColor(this.dP);
    this.nbN.setTextColor(this.dP);
    this.nbE.setOnClickListener(this);
    this.nbF.setOnClickListener(this);
    this.nbG.setOnClickListener(this);
    this.nbH.setOnClickListener(this);
    this.nbI.setOnClickListener(this);
    this.nbJ.setOnClickListener(this);
    this.nbK.setOnClickListener(this);
    this.nbL.setOnClickListener(this);
    this.nbM.setOnClickListener(this);
    this.nbN.setOnClickListener(this);
    this.nbO.setOnClickListener(this);
    this.nbO.setOnLongClickListener(this);
    this.nbP.setBackgroundColor(this.nbY);
    this.nbP.setBackgroundColor(this.nbY);
    this.nbQ.setBackgroundColor(this.nbY);
    this.nbR.setBackgroundColor(this.nbY);
    this.nbS.setBackgroundColor(this.nbY);
    this.nbT.setBackgroundColor(this.nbY);
    this.nbU.setBackgroundColor(this.nbY);
    addView(this.nbE);
    addView(this.nbF);
    addView(this.nbG);
    addView(this.nbH);
    addView(this.nbI);
    addView(this.nbJ);
    addView(this.nbK);
    addView(this.nbL);
    addView(this.nbM);
    addView(this.nbN);
    addView(this.nbO);
    addView(this.nbP);
    addView(this.nbQ);
    addView(this.nbR);
    addView(this.nbS);
    addView(this.nbT);
    addView(this.nbU);
    post(new MMKeyBoardView.1(this));
  }
  
  private void input(String paramString)
  {
    if ((this.nbm != null) && (this.nbV)) {
      this.nbm.input(paramString);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.nbV) {
      y.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
    }
    do
    {
      return;
      if (paramView == this.nbE)
      {
        input("0");
        return;
      }
      if (paramView == this.nbF)
      {
        input("1");
        return;
      }
      if (paramView == this.nbG)
      {
        input("2");
        return;
      }
      if (paramView == this.nbH)
      {
        input("3");
        return;
      }
      if (paramView == this.nbI)
      {
        input("4");
        return;
      }
      if (paramView == this.nbJ)
      {
        input("5");
        return;
      }
      if (paramView == this.nbK)
      {
        input("6");
        return;
      }
      if (paramView == this.nbL)
      {
        input("7");
        return;
      }
      if (paramView == this.nbM)
      {
        input("8");
        return;
      }
      if (paramView == this.nbN)
      {
        input("9");
        return;
      }
    } while ((paramView != this.nbO) || (this.nbm == null) || (!this.nbV));
    this.nbm.delete();
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.nbZ = getWidth();
    this.nca = getHeight();
    paramInt1 = -this.nbX;
    paramInt2 = this.ncd - this.nbX + 1;
    paramInt3 = this.ncd * 2 - this.nbX + 2;
    paramInt4 = this.nce + 2;
    int i = this.nce * 2 + 3;
    int j = this.nce * 3 + 4;
    this.nbF.layout(paramInt1, 1, this.ncb + paramInt1, this.ncc + 1);
    this.nbG.layout(paramInt2, 1, this.ncb + paramInt2, this.ncc + 1);
    this.nbH.layout(paramInt3, 1, this.ncb + paramInt3, this.ncc + 1);
    this.nbI.layout(paramInt1, paramInt4, this.ncb + paramInt1, this.ncc + paramInt4);
    this.nbJ.layout(paramInt2, paramInt4, this.ncb + paramInt2, this.ncc + paramInt4);
    this.nbK.layout(paramInt3, paramInt4, this.ncb + paramInt3, this.ncc + paramInt4);
    this.nbL.layout(paramInt1, i, this.ncb + paramInt1, this.ncc + i);
    this.nbM.layout(paramInt2, i, this.ncb + paramInt2, this.ncc + i);
    this.nbN.layout(paramInt3, i, this.ncb + paramInt3, this.ncc + i);
    this.nbE.layout(paramInt2, j, this.ncb + paramInt2, this.ncc + j);
    this.nbO.layout(paramInt3, j, this.ncb + paramInt3, this.ncc + j);
    this.nbP.layout(0, this.nbW + 1, this.nbZ, this.nbW + 1 + 1);
    this.nbQ.layout(0, this.nbW + paramInt4, this.nbZ, paramInt4 + this.nbW + 1);
    this.nbR.layout(0, this.nbW + i, this.nbZ, i + this.nbW + 1);
    this.nbS.layout(0, this.nbW + j, this.nbZ, this.nbW + j + 1);
    this.nbT.layout(this.ncd + 1, this.nbW, this.ncd + 2, this.nca);
    this.nbU.layout(this.ncd * 2 + 2, this.nbW, this.ncd * 2 + 3, this.nca);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == this.nbO) && (this.nbm != null) && (this.nbV)) {
      this.nbm.aUK();
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.nbZ = getWidth();
    this.nca = getHeight();
    if ((this.nbZ != 0) && (this.nca != 0))
    {
      this.ncd = ((this.nbZ - 2) / 3);
      this.nce = ((this.nca - this.nbW - 4) / 4);
      this.ncb = (this.ncd + this.nbX * 2);
      this.ncc = (this.nce + this.nbW * 2);
    }
    this.nbF.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbG.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbH.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbI.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbJ.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbK.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbL.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbM.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbN.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbE.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbO.measure(View.MeasureSpec.makeMeasureSpec(this.ncb, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ncc, 1073741824));
    this.nbP.measure(View.MeasureSpec.makeMeasureSpec(this.nbZ, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.nbQ.measure(View.MeasureSpec.makeMeasureSpec(this.nbZ, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.nbR.measure(View.MeasureSpec.makeMeasureSpec(this.nbZ, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.nbS.measure(View.MeasureSpec.makeMeasureSpec(this.nbZ, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.nbT.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.nca, 1073741824));
    this.nbU.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.nca, 1073741824));
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    this.nbV = paramBoolean;
    this.nbE.setEnabled(paramBoolean);
    this.nbF.setEnabled(paramBoolean);
    this.nbG.setEnabled(paramBoolean);
    this.nbH.setEnabled(paramBoolean);
    this.nbI.setEnabled(paramBoolean);
    this.nbJ.setEnabled(paramBoolean);
    this.nbK.setEnabled(paramBoolean);
    this.nbL.setEnabled(paramBoolean);
    this.nbM.setEnabled(paramBoolean);
    this.nbN.setEnabled(paramBoolean);
    this.nbO.setEnabled(paramBoolean);
  }
  
  public void setOnInputDeleteListener(MMKeyBoardView.a parama)
  {
    this.nbm = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */