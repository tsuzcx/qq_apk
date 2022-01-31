package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int mBj = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 16);
  public static int mBk = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 10);
  private int aVl = this.mBl;
  private long dYi;
  private int height;
  private GestureDetector jEK;
  private float lvi;
  private com.tencent.mm.plugin.music.model.a mBd;
  private TextPaint mBe;
  private TextPaint mBf;
  private int mBg;
  private int mBh;
  private int mBi = -1;
  private int mBl = mBj + mBk;
  private boolean mBm;
  private boolean mBn;
  private int mBo;
  private float mhn;
  private int width;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.mBe = new TextPaint();
    this.mBe.setTextSize(mBj);
    this.mBe.setColor(-1);
    this.mBe.setAntiAlias(true);
    this.mBe.setTextAlign(Paint.Align.CENTER);
    this.mBf = new TextPaint();
    this.mBf.setTextSize(mBj);
    this.mBf.setColor(-1);
    this.mBf.setAlpha(127);
    this.mBf.setAntiAlias(true);
    this.mBf.setTextAlign(Paint.Align.CENTER);
    this.jEK = new GestureDetector(getContext(), new LyricView.a(this, (byte)0));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mBd == null) {
      y.v("MicroMsg.Music.LyricView", "lyricObj is null");
    }
    label86:
    label343:
    label344:
    label347:
    for (;;)
    {
      return;
      if ((this.height == 0) || (this.width == 0))
      {
        this.height = getMeasuredHeight();
        this.width = getMeasuredWidth();
      }
      if (this.mBi >= 0)
      {
        int i = this.aVl;
        if ((this.mBd == null) || (this.mBd.mzk.size() <= this.mBi))
        {
          if (!this.mBm) {
            break label343;
          }
          if (this.aVl == 0) {
            break label344;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label347;
          }
          this.aVl = ((int)(this.aVl * 0.9F));
          invalidate();
          return;
          int j = this.height / 2 - i;
          if ((j < this.height) && (j > 0)) {
            paramCanvas.drawText(this.mBd.uN(this.mBi).content, this.width / 2, j, this.mBe);
          }
          i = this.mBi - 1;
          int k;
          while (i >= 0)
          {
            k = j - (this.mBi - i) * (mBj + mBk);
            if ((k > 0) && (k < this.height)) {
              paramCanvas.drawText(this.mBd.uN(i).content, this.width / 2, k, this.mBf);
            }
            i -= 1;
          }
          i = this.mBi + 1;
          while (i < this.mBd.mzk.size())
          {
            k = (i - this.mBi) * (mBj + mBk) + j;
            if ((k < this.height) && (k > 0)) {
              paramCanvas.drawText(this.mBd.uN(i).content, this.width / 2, k, this.mBf);
            }
            i += 1;
          }
          break label86;
          break;
        }
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jEK.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.lvi = paramMotionEvent.getY();
      this.mhn = paramMotionEvent.getX();
      this.mBo = this.aVl;
      this.mBn = true;
      this.mBm = false;
      return true;
    case 2: 
      int k = (int)(paramMotionEvent.getX() - this.mhn);
      int m = (int)(paramMotionEvent.getY() - this.lvi);
      int i = this.mBo - m;
      if (i > 0)
      {
        if (i > this.mBh) {}
        for (j = this.mBh;; j = i)
        {
          this.aVl = j;
          invalidate();
          y.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.mBo) });
          return true;
        }
      }
      if (i < -this.mBg) {}
      for (int j = -this.mBg;; j = i)
      {
        this.aVl = j;
        break;
      }
    }
    this.mBn = false;
    return true;
  }
  
  public void setCurrentTime(long paramLong)
  {
    if (this.dYi != paramLong)
    {
      this.dYi = paramLong;
      if ((this.mBd != null) && (this.mBd.mzk.size() != 0)) {
        break label35;
      }
    }
    label35:
    int j;
    do
    {
      return;
      j = -1;
      int i = 0;
      while ((i < this.mBd.mzk.size()) && (this.mBd.uN(i).timestamp < paramLong))
      {
        if (!this.mBd.uN(i).mzq) {
          j = i;
        }
        i += 1;
      }
    } while ((this.mBn) || (j == this.mBi));
    this.mBi = j;
    this.mBg = ((mBj + mBk) * this.mBi);
    this.mBh = ((mBj + mBk) * (this.mBd.mzk.size() - this.mBi - 1));
    if (this.aVl == 0) {
      this.aVl = (-this.mBl);
    }
    this.mBm = true;
    invalidate();
  }
  
  public void setLyricColor(int paramInt)
  {
    this.mBe.setColor(paramInt);
    this.mBe.setAlpha(255);
    this.mBf.setColor(paramInt);
    this.mBf.setAlpha(127);
  }
  
  public void setLyricObj(com.tencent.mm.plugin.music.model.a parama)
  {
    this.mBd = parama;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */