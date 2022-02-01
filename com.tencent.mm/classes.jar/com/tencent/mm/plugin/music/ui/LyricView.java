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
  private static int AmU;
  private static int AmV;
  private TextPaint AmN;
  private TextPaint AmO;
  private Paint.Align AmP;
  private boolean AmQ;
  private int AmR;
  private int AmS;
  private int AmT;
  private int AmW;
  private boolean AmX;
  private boolean AmY;
  private int AmZ;
  private e Amv;
  private int[] Ana;
  private int[] Anb;
  private float dep;
  private float gZZ;
  private float haa;
  private int height;
  private long iGC;
  private GestureDetector jKk;
  private int mode;
  private int paddingBottom;
  private int paddingTop;
  private int textSize;
  private int width;
  private int ygL;
  
  static
  {
    AppMethodBeat.i(63192);
    AmU = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AmV = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.mode = 1;
    this.AmP = Paint.Align.CENTER;
    this.AmQ = false;
    this.paddingTop = 0;
    this.textSize = AmU;
    this.paddingBottom = AmV;
    this.AmT = -1;
    this.AmW = (this.paddingTop + this.textSize + this.paddingBottom);
    this.ygL = this.AmW;
    this.Ana = new int[2];
    this.Anb = new int[2];
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.mode = 1;
    this.AmP = Paint.Align.CENTER;
    this.AmQ = false;
    this.paddingTop = 0;
    this.textSize = AmU;
    this.paddingBottom = AmV;
    this.AmT = -1;
    this.AmW = (this.paddingTop + this.textSize + this.paddingBottom);
    this.ygL = this.AmW;
    this.Ana = new int[2];
    this.Anb = new int[2];
    initView();
    AppMethodBeat.o(63185);
  }
  
  private static float h(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(219876);
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(219876);
      return -1.0F;
    }
    float f = paramMotionEvent.getY(paramInt);
    AppMethodBeat.o(219876);
    return f;
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    setNestedScrollingEnabled(true);
    this.AmN = new TextPaint();
    this.AmN.setTextSize(this.textSize);
    this.AmN.setColor(-1);
    this.AmN.setAntiAlias(true);
    this.AmN.setTextAlign(this.AmP);
    this.AmO = new TextPaint();
    this.AmO.setTextSize(this.textSize);
    this.AmO.setColor(-1);
    this.AmO.setAlpha(127);
    this.AmO.setAntiAlias(true);
    this.AmO.setTextAlign(this.AmP);
    this.jKk = new GestureDetector(getContext(), new LyricView.a(this, (byte)0));
    this.jKk.setIsLongpressEnabled(false);
    AppMethodBeat.o(63186);
  }
  
  public final void a(Paint.Align paramAlign, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219873);
    this.AmQ = true;
    this.AmP = paramAlign;
    this.AmN.setTextAlign(paramAlign);
    this.AmN.setFakeBoldText(false);
    this.AmO.setTextAlign(paramAlign);
    this.AmN.setFakeBoldText(false);
    this.paddingTop = paramInt2;
    this.textSize = paramInt1;
    this.paddingBottom = paramInt3;
    this.AmW = (paramInt2 + paramInt1 + paramInt3);
    this.ygL = this.AmW;
    this.AmN.setTextSize(paramInt1);
    this.AmO.setTextSize(paramInt1);
    AppMethodBeat.o(219873);
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(219875);
    float f = (int)this.AmN.getTextSize();
    AppMethodBeat.o(219875);
    return f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    int j;
    if ((this.Amv == null) || (this.Amv.Akn.size() <= 2))
    {
      Log.d("MicroMsg.Music.LyricView", "lyricObj is null | no lyric");
      j = this.height;
      i = j;
      if (j > 300) {
        i = this.AmW;
      }
      j = i / 2 + this.paddingTop - (int)(this.AmN.descent() + this.AmN.ascent()) / 2;
      if ((j < i) && (j > 0)) {
        paramCanvas.drawText("", 0.0F, j, this.AmN);
      }
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.AmT < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    if (Paint.Align.LEFT == this.AmP)
    {
      i = this.ygL;
      if ((this.Amv == null) || (this.Amv.Akn.size() <= this.AmT)) {
        if (this.AmX) {
          if (this.ygL == 0) {
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
        this.ygL = ((int)(this.ygL * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      this.AmW = (this.paddingTop + this.textSize + this.paddingBottom);
      if (this.AmQ)
      {
        if ((this.Amv == null) || (this.Amv.Akn.size() <= this.AmT)) {
          break;
        }
        i = this.height / 2 + this.paddingTop - (int)(this.AmN.descent() + this.AmN.ascent()) / 2;
        if ((i >= this.height) || (i <= 0) || (this.Amv.SQ(this.AmT) == null) || (this.Amv.SQ(this.AmT).isEmpty())) {
          break;
        }
        paramCanvas.drawText(this.Amv.SQ(this.AmT).content, 0.0F, i, this.AmN);
        break;
      }
      j = this.height / 2;
      j = this.paddingTop + (j - i);
      if ((j < this.height) && (j > 0) && (this.Amv.SQ(this.AmT) != null) && (!this.Amv.SQ(this.AmT).isEmpty())) {
        paramCanvas.drawText(this.Amv.SQ(this.AmT).content, 0.0F, j, this.AmN);
      }
      i = this.AmT - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.AmT - i) * this.AmW;
        if ((k > 0) && (k < this.height) && (this.Amv.SQ(i) != null) && (!this.Amv.SQ(i).isEmpty())) {
          paramCanvas.drawText(this.Amv.SQ(i).content, 0.0F, k, this.AmO);
        }
        i -= 1;
      }
      i = this.AmT + 1;
      while (i < this.Amv.Akn.size())
      {
        k = (i - this.AmT) * this.AmW + j;
        if ((k < this.height) && (k > 0) && (this.Amv.SQ(i) != null) && (!this.Amv.SQ(i).isEmpty())) {
          paramCanvas.drawText(this.Amv.SQ(i).content, 0.0F, k, this.AmO);
        }
        i += 1;
      }
      break;
      i = this.ygL;
      if ((this.Amv == null) || (this.Amv.Akn.size() <= this.AmT)) {
        break;
      }
      j = this.height / 2;
      j = this.paddingTop + (j - i);
      if ((j < this.height) && (j > 0) && (this.Amv.SQ(this.AmT) != null)) {
        paramCanvas.drawText(this.Amv.SQ(this.AmT).content, this.width / 2, j, this.AmN);
      }
      i = this.AmT - 1;
      while (i >= 0)
      {
        k = j - (this.AmT - i) * this.AmW;
        if ((k > 0) && (k < this.height) && (this.Amv.SQ(i) != null)) {
          paramCanvas.drawText(this.Amv.SQ(i).content, this.width / 2, k, this.AmO);
        }
        i -= 1;
      }
      i = this.AmT + 1;
      while (i < this.Amv.Akn.size())
      {
        k = (i - this.AmT) * this.AmW + j;
        if ((k < this.height) && (k > 0) && (this.Amv.SQ(i) != null)) {
          paramCanvas.drawText(this.Amv.SQ(i).content, this.width / 2, k, this.AmO);
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
    GestureDetector localGestureDetector = this.jKk;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int k = paramMotionEvent.getPointerId(0);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.haa = paramMotionEvent.getY();
      this.gZZ = paramMotionEvent.getX();
      this.AmZ = this.ygL;
      this.AmY = true;
      this.AmX = false;
      this.dep = h(paramMotionEvent, k);
      if (this.dep == -1.0F)
      {
        AppMethodBeat.o(63190);
        return false;
      }
      if (2 == this.mode)
      {
        startNestedScroll(2);
        continue;
        int m = (int)(paramMotionEvent.getX() - this.gZZ);
        int n = (int)(paramMotionEvent.getY() - this.haa);
        int i = this.AmZ - n;
        float f1;
        if (i > 0)
        {
          if (i > this.AmS) {}
          for (j = this.AmS;; j = i)
          {
            this.ygL = j;
            invalidate();
            Log.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.AmZ) });
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
        if (i < -this.AmR) {}
        for (int j = -this.AmR;; j = i)
        {
          this.ygL = j;
          break;
        }
        label394:
        float f2 = this.dep;
        dispatchNestedPreScroll(0, 0, this.Ana, this.Anb);
        dispatchNestedScroll(0, (int)(f1 - f2), 0, 0, null);
        continue;
        this.AmY = false;
      }
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.iGC != paramLong)
    {
      this.iGC = paramLong;
      if ((this.Amv == null) || (this.Amv.Akn.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.Amv.Akn.size()) && (this.Amv.SQ(i).timestamp < paramLong))
      {
        if (!this.Amv.SQ(i).Akt) {
          j = i;
        }
        i += 1;
      }
      if ((!this.AmY) && (j != this.AmT))
      {
        this.AmT = j;
        this.AmR = (this.AmW * this.AmT);
        this.AmS = (this.AmW * (this.Amv.Akn.size() - this.AmT - 1));
        if (this.ygL == 0) {
          this.ygL = (-this.AmW);
        }
        this.AmX = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.AmN.setColor(paramInt);
    this.AmN.setAlpha(255);
    this.AmO.setColor(paramInt);
    this.AmO.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(63182);
    this.Amv = parame;
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
      this.AmQ = bool;
      return;
      bool = false;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(219874);
    this.AmN.setTextSize(paramFloat);
    this.AmO.setTextSize(paramFloat);
    AppMethodBeat.o(219874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */