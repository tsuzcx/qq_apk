package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlphabetScrollBar
  extends VerticalScrollBar
{
  private int adNY = -1;
  private Drawable adNZ;
  private Drawable adOa;
  private int adOb = 0;
  private WeImageView adOc;
  
  public AlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(251448);
    if ((paramInt < this.JMk.length) && (this.JMk[paramInt].equals("🔍"))) {
      paramFloat2 -= 10.0F;
    }
    for (;;)
    {
      super.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramPaint, paramInt);
      AppMethodBeat.o(251448);
      return;
    }
  }
  
  protected final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(251445);
    if ((paramInt < this.JMk.length) && (this.JMk[paramInt].equals("🔍")))
    {
      if ((this.adNZ == null) || (this.adOa == null))
      {
        if (this.adNY == -1) {
          break label218;
        }
        this.adNZ = bb.e(getResources().getDrawable(a.j.icons_filled_search), this.adNY);
      }
      for (;;)
      {
        this.adOb = a.fromDPToPix(getContext(), 13);
        this.adOa = bb.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.White));
        if (!paramBoolean) {
          break;
        }
        paramPaint.setStyle(Paint.Style.FILL);
        paramPaint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(paramFloat1, paramFloat2 - 10.0F, this.adXl, paramPaint);
        this.adOa.setBounds((int)(paramFloat1 - this.adOb / 2), (int)(paramFloat2 - this.adOb / 2 - 10.0F), (int)(this.adOb / 2 + paramFloat1), (int)(this.adOb / 2 + paramFloat2 - 10.0F));
        this.adOa.draw(paramCanvas);
        AppMethodBeat.o(251445);
        return;
        label218:
        if (aw.isDarkMode()) {
          this.adNZ = bb.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.FG_2));
        } else {
          this.adNZ = bb.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.FG_0));
        }
      }
      this.adNZ.setBounds((int)(paramFloat1 - this.adOb / 2), (int)(paramFloat2 - this.adOb / 2 - 10.0F), (int)(this.adOb / 2 + paramFloat1), (int)(this.adOb / 2 + paramFloat2 - 10.0F));
      this.adNZ.draw(paramCanvas);
      AppMethodBeat.o(251445);
      return;
    }
    super.a(paramCanvas, paramFloat1, paramFloat2, paramPaint, paramInt, paramBoolean);
    AppMethodBeat.o(251445);
  }
  
  protected void aNw()
  {
    this.JMk = new String[] { "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.JMi = 1.6F;
    this.JMj = 79;
  }
  
  protected final void bzZ(String paramString)
  {
    AppMethodBeat.i(251455);
    if (this.adOc == null) {
      this.adOc = ((WeImageView)this.adUp.findViewById(a.g.show_head_toast_iv));
    }
    if (paramString.equals("🔍"))
    {
      this.adOc.setVisibility(0);
      this.JMn.setVisibility(8);
      AppMethodBeat.o(251455);
      return;
    }
    this.JMn.setVisibility(0);
    this.adOc.setVisibility(8);
    super.bzZ(paramString);
    AppMethodBeat.o(251455);
  }
  
  protected int getToastLayoutId()
  {
    return a.h.show_head_toast;
  }
  
  public void setAlphabet(String[] paramArrayOfString)
  {
    AppMethodBeat.i(251440);
    this.JMk = paramArrayOfString;
    this.JMl = 0.0F;
    invalidate();
    AppMethodBeat.o(251440);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setSearchIconColor(int paramInt)
  {
    this.adNY = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setWhiteTextColor(int paramInt)
  {
    this.adXk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.AlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */