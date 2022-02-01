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
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int wmQ;
  public static int wmR;
  private float gmK;
  private float gmL;
  private long hIH;
  private int height;
  private GestureDetector iKD;
  private int uCJ;
  private int width;
  private b wmF;
  private TextPaint wmL;
  private TextPaint wmM;
  private int wmN;
  private int wmO;
  private int wmP;
  private int wmS;
  private boolean wmT;
  private boolean wmU;
  private int wmV;
  
  static
  {
    AppMethodBeat.i(63192);
    wmQ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
    wmR = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.wmP = -1;
    this.wmS = (wmQ + wmR);
    this.uCJ = this.wmS;
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.wmP = -1;
    this.wmS = (wmQ + wmR);
    this.uCJ = this.wmS;
    initView();
    AppMethodBeat.o(63185);
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    this.wmL = new TextPaint();
    this.wmL.setTextSize(wmQ);
    this.wmL.setColor(-1);
    this.wmL.setAntiAlias(true);
    this.wmL.setTextAlign(Paint.Align.CENTER);
    this.wmM = new TextPaint();
    this.wmM.setTextSize(wmQ);
    this.wmM.setColor(-1);
    this.wmM.setAlpha(127);
    this.wmM.setAntiAlias(true);
    this.wmM.setTextAlign(Paint.Align.CENTER);
    this.iKD = new GestureDetector(getContext(), new LyricView.a(this, (byte)0));
    AppMethodBeat.o(63186);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    if (this.wmF == null)
    {
      ad.v("MicroMsg.Music.LyricView", "lyricObj is null");
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.wmP < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    int i = this.uCJ;
    if ((this.wmF == null) || (this.wmF.wkH.size() <= this.wmP)) {
      if (this.wmT) {
        if (this.uCJ == 0) {
          break label401;
        }
      }
    }
    label401:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uCJ = ((int)(this.uCJ * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      int j = this.height / 2 - i;
      if ((j < this.height) && (j > 0) && (this.wmF.Lo(this.wmP) != null)) {
        paramCanvas.drawText(this.wmF.Lo(this.wmP).content, this.width / 2, j, this.wmL);
      }
      i = this.wmP - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.wmP - i) * (wmQ + wmR);
        if ((k > 0) && (k < this.height) && (this.wmF.Lo(i) != null)) {
          paramCanvas.drawText(this.wmF.Lo(i).content, this.width / 2, k, this.wmM);
        }
        i -= 1;
      }
      i = this.wmP + 1;
      while (i < this.wmF.wkH.size())
      {
        k = (i - this.wmP) * (wmQ + wmR) + j;
        if ((k < this.height) && (k > 0) && (this.wmF.Lo(i) != null)) {
          paramCanvas.drawText(this.wmF.Lo(i).content, this.width / 2, k, this.wmM);
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
    GestureDetector localGestureDetector = this.iKD;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.gmL = paramMotionEvent.getY();
      this.gmK = paramMotionEvent.getX();
      this.wmV = this.uCJ;
      this.wmU = true;
      this.wmT = false;
      continue;
      int k = (int)(paramMotionEvent.getX() - this.gmK);
      int m = (int)(paramMotionEvent.getY() - this.gmL);
      int i = this.wmV - m;
      if (i > 0)
      {
        if (i > this.wmO) {}
        for (j = this.wmO;; j = i)
        {
          this.uCJ = j;
          invalidate();
          ad.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.wmV) });
          break;
        }
      }
      if (i < -this.wmN) {}
      for (int j = -this.wmN;; j = i)
      {
        this.uCJ = j;
        break;
      }
      this.wmU = false;
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.hIH != paramLong)
    {
      this.hIH = paramLong;
      if ((this.wmF == null) || (this.wmF.wkH.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.wmF.wkH.size()) && (this.wmF.Lo(i).timestamp < paramLong))
      {
        if (!this.wmF.Lo(i).wkN) {
          j = i;
        }
        i += 1;
      }
      if ((!this.wmU) && (j != this.wmP))
      {
        this.wmP = j;
        this.wmN = ((wmQ + wmR) * this.wmP);
        this.wmO = ((wmQ + wmR) * (this.wmF.wkH.size() - this.wmP - 1));
        if (this.uCJ == 0) {
          this.uCJ = (-this.wmS);
        }
        this.wmT = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.wmL.setColor(paramInt);
    this.wmL.setAlpha(255);
    this.wmM.setColor(paramInt);
    this.wmM.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(b paramb)
  {
    AppMethodBeat.i(63182);
    this.wmF = paramb;
    invalidate();
    AppMethodBeat.o(63182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */