package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public class LyricView
  extends View
{
  private static int FUb;
  private static int FUc;
  private int DqN;
  private e FTB;
  private TextPaint FTU;
  private TextPaint FTV;
  private Paint.Align FTW;
  private boolean FTX;
  private int FTY;
  private int FTZ;
  private int FUa;
  private int FUd;
  private boolean FUe;
  private boolean FUf;
  private int FUg;
  private int[] FUh;
  private int[] FUi;
  private int bCO;
  private int bCP;
  private float diu;
  private int height;
  private float jLa;
  private float jLb;
  private long lwE;
  private GestureDetector mBn;
  private int mode;
  private int textSize;
  private int width;
  
  static
  {
    AppMethodBeat.i(63192);
    FUb = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    FUc = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.mode = 1;
    this.FTW = Paint.Align.CENTER;
    this.FTX = false;
    this.bCO = 0;
    this.textSize = FUb;
    this.bCP = FUc;
    this.FUa = -1;
    this.FUd = (this.bCO + this.textSize + this.bCP);
    this.DqN = this.FUd;
    this.FUh = new int[2];
    this.FUi = new int[2];
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.mode = 1;
    this.FTW = Paint.Align.CENTER;
    this.FTX = false;
    this.bCO = 0;
    this.textSize = FUb;
    this.bCP = FUc;
    this.FUa = -1;
    this.FUd = (this.bCO + this.textSize + this.bCP);
    this.DqN = this.FUd;
    this.FUh = new int[2];
    this.FUi = new int[2];
    initView();
    AppMethodBeat.o(63185);
  }
  
  private static float h(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(259442);
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(259442);
      return -1.0F;
    }
    float f = paramMotionEvent.getY(paramInt);
    AppMethodBeat.o(259442);
    return f;
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    setNestedScrollingEnabled(true);
    this.FTU = new TextPaint();
    this.FTU.setTextSize(this.textSize);
    this.FTU.setColor(-1);
    this.FTU.setAntiAlias(true);
    this.FTU.setTextAlign(this.FTW);
    this.FTV = new TextPaint();
    this.FTV.setTextSize(this.textSize);
    this.FTV.setColor(-1);
    this.FTV.setAlpha(127);
    this.FTV.setAntiAlias(true);
    this.FTV.setTextAlign(this.FTW);
    this.mBn = new GestureDetector(getContext(), new LyricView.a(this, (byte)0));
    this.mBn.setIsLongpressEnabled(false);
    AppMethodBeat.o(63186);
  }
  
  public final void a(Paint.Align paramAlign, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(259432);
    this.FTX = true;
    this.FTW = paramAlign;
    this.FTU.setTextAlign(paramAlign);
    this.FTU.setFakeBoldText(false);
    this.FTV.setTextAlign(paramAlign);
    this.FTU.setFakeBoldText(false);
    this.bCO = paramInt2;
    this.textSize = paramInt1;
    this.bCP = paramInt3;
    this.FUd = (paramInt2 + paramInt1 + paramInt3);
    this.DqN = this.FUd;
    this.FTU.setTextSize(paramInt1);
    this.FTV.setTextSize(paramInt1);
    AppMethodBeat.o(259432);
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(259436);
    float f = (int)this.FTU.getTextSize();
    AppMethodBeat.o(259436);
    return f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    int j;
    if ((this.FTB == null) || (this.FTB.FRr.size() <= 2))
    {
      Log.d("MicroMsg.Music.LyricView", "lyricObj is null | no lyric");
      j = this.height;
      i = j;
      if (j > 300) {
        i = this.FUd;
      }
      j = i / 2 + this.bCO - (int)(this.FTU.descent() + this.FTU.ascent()) / 2;
      if ((j < i) && (j > 0)) {
        paramCanvas.drawText("", 0.0F, j, this.FTU);
      }
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.FUa < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    if (Paint.Align.LEFT == this.FTW)
    {
      i = this.DqN;
      if ((this.FTB == null) || (this.FTB.FRr.size() <= this.FUa)) {
        if (this.FUe) {
          if (this.DqN == 0) {
            break label960;
          }
        }
      }
    }
    label960:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.DqN = ((int)(this.DqN * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      this.FUd = (this.bCO + this.textSize + this.bCP);
      if (this.FTX)
      {
        if ((this.FTB == null) || (this.FTB.FRr.size() <= this.FUa)) {
          break;
        }
        i = this.height / 2 + this.bCO - (int)(this.FTU.descent() + this.FTU.ascent()) / 2;
        if ((i >= this.height) || (i <= 0) || (this.FTB.Zm(this.FUa) == null) || (this.FTB.Zm(this.FUa).isEmpty())) {
          break;
        }
        paramCanvas.drawText(this.FTB.Zm(this.FUa).content, 0.0F, i, this.FTU);
        break;
      }
      j = this.height / 2;
      j = this.bCO + (j - i);
      if ((j < this.height) && (j > 0) && (this.FTB.Zm(this.FUa) != null) && (!this.FTB.Zm(this.FUa).isEmpty())) {
        paramCanvas.drawText(this.FTB.Zm(this.FUa).content, 0.0F, j, this.FTU);
      }
      i = this.FUa - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.FUa - i) * this.FUd;
        if ((k > 0) && (k < this.height) && (this.FTB.Zm(i) != null) && (!this.FTB.Zm(i).isEmpty())) {
          paramCanvas.drawText(this.FTB.Zm(i).content, 0.0F, k, this.FTV);
        }
        i -= 1;
      }
      i = this.FUa + 1;
      while (i < this.FTB.FRr.size())
      {
        k = (i - this.FUa) * this.FUd + j;
        if ((k < this.height) && (k > 0) && (this.FTB.Zm(i) != null) && (!this.FTB.Zm(i).isEmpty())) {
          paramCanvas.drawText(this.FTB.Zm(i).content, 0.0F, k, this.FTV);
        }
        i += 1;
      }
      break;
      i = this.DqN;
      if ((this.FTB == null) || (this.FTB.FRr.size() <= this.FUa)) {
        break;
      }
      j = this.height / 2;
      j = this.bCO + (j - i);
      if ((j < this.height) && (j > 0) && (this.FTB.Zm(this.FUa) != null)) {
        paramCanvas.drawText(this.FTB.Zm(this.FUa).content, this.width / 2, j, this.FTU);
      }
      i = this.FUa - 1;
      while (i >= 0)
      {
        k = j - (this.FUa - i) * this.FUd;
        if ((k > 0) && (k < this.height) && (this.FTB.Zm(i) != null)) {
          paramCanvas.drawText(this.FTB.Zm(i).content, this.width / 2, k, this.FTV);
        }
        i -= 1;
      }
      i = this.FUa + 1;
      while (i < this.FTB.FRr.size())
      {
        k = (i - this.FUa) * this.FUd + j;
        if ((k < this.height) && (k > 0) && (this.FTB.Zm(i) != null)) {
          paramCanvas.drawText(this.FTB.Zm(i).content, this.width / 2, k, this.FTV);
        }
        i += 1;
      }
      break;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(63189);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
    AppMethodBeat.o(63189);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63190);
    GestureDetector localGestureDetector = this.mBn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int k = paramMotionEvent.getPointerId(0);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.jLb = paramMotionEvent.getY();
      this.jLa = paramMotionEvent.getX();
      this.FUg = this.DqN;
      this.FUf = true;
      this.FUe = false;
      this.diu = h(paramMotionEvent, k);
      if (this.diu == -1.0F)
      {
        AppMethodBeat.o(63190);
        return false;
      }
      if (2 == this.mode)
      {
        startNestedScroll(2);
        continue;
        int m = (int)(paramMotionEvent.getX() - this.jLa);
        int n = (int)(paramMotionEvent.getY() - this.jLb);
        int i = this.FUg - n;
        float f1;
        if (i > 0)
        {
          if (i > this.FTZ) {}
          for (j = this.FTZ;; j = i)
          {
            this.DqN = j;
            invalidate();
            Log.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.FUg) });
            if (2 != this.mode) {
              break;
            }
            f1 = h(paramMotionEvent, k);
            if (f1 != -1.0F) {
              break label394;
            }
            AppMethodBeat.o(63190);
            return false;
          }
        }
        if (i < -this.FTY) {}
        for (int j = -this.FTY;; j = i)
        {
          this.DqN = j;
          break;
        }
        label394:
        float f2 = this.diu;
        dispatchNestedPreScroll(0, 0, this.FUh, this.FUi);
        dispatchNestedScroll(0, (int)(f1 - f2), 0, 0, null);
        continue;
        this.FUf = false;
      }
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.lwE != paramLong)
    {
      this.lwE = paramLong;
      if ((this.FTB == null) || (this.FTB.FRr.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.FTB.FRr.size()) && (this.FTB.Zm(i).timestamp < paramLong))
      {
        if (!this.FTB.Zm(i).FRx) {
          j = i;
        }
        i += 1;
      }
      if ((!this.FUf) && (j != this.FUa))
      {
        this.FUa = j;
        this.FTY = (this.FUd * this.FUa);
        this.FTZ = (this.FUd * (this.FTB.FRr.size() - this.FUa - 1));
        if (this.DqN == 0) {
          this.DqN = (-this.FUd);
        }
        this.FUe = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.FTU.setColor(paramInt);
    this.FTU.setAlpha(255);
    this.FTV.setColor(paramInt);
    this.FTV.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(63182);
    this.FTB = parame;
    invalidate();
    AppMethodBeat.o(63182);
  }
  
  public void setMode(int paramInt)
  {
    boolean bool = true;
    this.mode = paramInt;
    if (1 == paramInt) {}
    for (;;)
    {
      this.FTX = bool;
      return;
      bool = false;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(259435);
    this.FTU.setTextSize(paramFloat);
    this.FTV.setTextSize(paramFloat);
    AppMethodBeat.o(259435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */