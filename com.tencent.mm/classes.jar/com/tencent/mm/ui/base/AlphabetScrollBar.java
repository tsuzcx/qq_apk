package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
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
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlphabetScrollBar
  extends VerticalScrollBar
{
  private Drawable Whd;
  private Drawable Whe;
  private int Whf = 0;
  private WeImageView Whg;
  
  public AlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(204385);
    if ((paramInt < this.DVb.length) && (this.DVb[paramInt].equals("🔍"))) {
      paramFloat2 -= 10.0F;
    }
    for (;;)
    {
      super.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramPaint, paramInt);
      AppMethodBeat.o(204385);
      return;
    }
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204384);
    if ((paramInt < this.DVb.length) && (this.DVb[paramInt].equals("🔍")))
    {
      if ((this.Whd == null) || (this.Whe == null)) {
        if (!ar.isDarkMode()) {
          break label222;
        }
      }
      label222:
      for (this.Whd = au.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.FG_2));; this.Whd = au.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.FG_0)))
      {
        this.Whf = a.fromDPToPix(getContext(), 13);
        this.Whe = au.e(getResources().getDrawable(a.j.icons_filled_search), getResources().getColor(a.d.White));
        if (!paramBoolean) {
          break;
        }
        paramPaint.setStyle(Paint.Style.FILL);
        paramPaint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(paramFloat1, paramFloat2 - 10.0F, this.WpZ, paramPaint);
        this.Whe.setBounds((int)(paramFloat1 - this.Whf / 2), (int)(paramFloat2 - this.Whf / 2 - 10.0F), (int)(this.Whf / 2 + paramFloat1), (int)(this.Whf / 2 + paramFloat2 - 10.0F));
        this.Whe.draw(paramCanvas);
        AppMethodBeat.o(204384);
        return;
      }
      this.Whd.setBounds((int)(paramFloat1 - this.Whf / 2), (int)(paramFloat2 - this.Whf / 2 - 10.0F), (int)(this.Whf / 2 + paramFloat1), (int)(this.Whf / 2 + paramFloat2 - 10.0F));
      this.Whd.draw(paramCanvas);
      AppMethodBeat.o(204384);
      return;
    }
    super.a(paramCanvas, paramFloat1, paramFloat2, paramPaint, paramInt, paramBoolean);
    AppMethodBeat.o(204384);
  }
  
  protected void atp()
  {
    this.DVb = new String[] { "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.DUZ = 1.6F;
    this.DVa = 79;
  }
  
  protected final void byB(String paramString)
  {
    AppMethodBeat.i(204388);
    if (this.Whg == null) {
      this.Whg = ((WeImageView)this.Wnb.findViewById(a.g.show_head_toast_iv));
    }
    if (paramString.equals("🔍"))
    {
      this.Whg.setVisibility(0);
      this.DVe.setVisibility(8);
      AppMethodBeat.o(204388);
      return;
    }
    this.DVe.setVisibility(0);
    this.Whg.setVisibility(8);
    super.byB(paramString);
    AppMethodBeat.o(204388);
  }
  
  protected int getToastLayoutId()
  {
    return a.h.show_head_toast;
  }
  
  public void setAlphabet(String[] paramArrayOfString)
  {
    AppMethodBeat.i(204383);
    this.DVb = paramArrayOfString;
    this.DVc = 0.0F;
    invalidate();
    AppMethodBeat.o(204383);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setWhiteTextColor(int paramInt)
  {
    this.WpY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.AlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */