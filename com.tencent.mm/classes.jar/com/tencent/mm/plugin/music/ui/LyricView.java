package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.b.a;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int tYC;
  public static int tYD;
  private float fPl;
  private float fPm;
  private long gPP;
  private GestureDetector hRv;
  private int height;
  private int ssk;
  private int tYA;
  private int tYB;
  private int tYE;
  private boolean tYF;
  private boolean tYG;
  private int tYH;
  private b tYw;
  private TextPaint tYx;
  private TextPaint tYy;
  private int tYz;
  private int width;
  
  static
  {
    AppMethodBeat.i(63192);
    tYC = a.fromDPToPix(aj.getContext(), 16);
    tYD = a.fromDPToPix(aj.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.tYB = -1;
    this.tYE = (tYC + tYD);
    this.ssk = this.tYE;
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.tYB = -1;
    this.tYE = (tYC + tYD);
    this.ssk = this.tYE;
    initView();
    AppMethodBeat.o(63185);
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    this.tYx = new TextPaint();
    this.tYx.setTextSize(tYC);
    this.tYx.setColor(-1);
    this.tYx.setAntiAlias(true);
    this.tYx.setTextAlign(Paint.Align.CENTER);
    this.tYy = new TextPaint();
    this.tYy.setTextSize(tYC);
    this.tYy.setColor(-1);
    this.tYy.setAlpha(127);
    this.tYy.setAntiAlias(true);
    this.tYy.setTextAlign(Paint.Align.CENTER);
    this.hRv = new GestureDetector(getContext(), new a((byte)0));
    AppMethodBeat.o(63186);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    if (this.tYw == null)
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
    if (this.tYB < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    int i = this.ssk;
    if ((this.tYw == null) || (this.tYw.tWB.size() <= this.tYB)) {
      if (this.tYF) {
        if (this.ssk == 0) {
          break label401;
        }
      }
    }
    label401:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ssk = ((int)(this.ssk * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      int j = this.height / 2 - i;
      if ((j < this.height) && (j > 0) && (this.tYw.HN(this.tYB) != null)) {
        paramCanvas.drawText(this.tYw.HN(this.tYB).content, this.width / 2, j, this.tYx);
      }
      i = this.tYB - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.tYB - i) * (tYC + tYD);
        if ((k > 0) && (k < this.height) && (this.tYw.HN(i) != null)) {
          paramCanvas.drawText(this.tYw.HN(i).content, this.width / 2, k, this.tYy);
        }
        i -= 1;
      }
      i = this.tYB + 1;
      while (i < this.tYw.tWB.size())
      {
        k = (i - this.tYB) * (tYC + tYD) + j;
        if ((k < this.height) && (k > 0) && (this.tYw.HN(i) != null)) {
          paramCanvas.drawText(this.tYw.HN(i).content, this.width / 2, k, this.tYy);
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
    this.hRv.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.fPm = paramMotionEvent.getY();
      this.fPl = paramMotionEvent.getX();
      this.tYH = this.ssk;
      this.tYG = true;
      this.tYF = false;
      continue;
      int k = (int)(paramMotionEvent.getX() - this.fPl);
      int m = (int)(paramMotionEvent.getY() - this.fPm);
      int i = this.tYH - m;
      if (i > 0)
      {
        if (i > this.tYA) {}
        for (j = this.tYA;; j = i)
        {
          this.ssk = j;
          invalidate();
          ad.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.tYH) });
          break;
        }
      }
      if (i < -this.tYz) {}
      for (int j = -this.tYz;; j = i)
      {
        this.ssk = j;
        break;
      }
      this.tYG = false;
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.gPP != paramLong)
    {
      this.gPP = paramLong;
      if ((this.tYw == null) || (this.tYw.tWB.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.tYw.tWB.size()) && (this.tYw.HN(i).timestamp < paramLong))
      {
        if (!this.tYw.HN(i).tWH) {
          j = i;
        }
        i += 1;
      }
      if ((!this.tYG) && (j != this.tYB))
      {
        this.tYB = j;
        this.tYz = ((tYC + tYD) * this.tYB);
        this.tYA = ((tYC + tYD) * (this.tYw.tWB.size() - this.tYB - 1));
        if (this.ssk == 0) {
          this.ssk = (-this.tYE);
        }
        this.tYF = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.tYx.setColor(paramInt);
    this.tYx.setAlpha(255);
    this.tYy.setColor(paramInt);
    this.tYy.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(b paramb)
  {
    AppMethodBeat.i(63182);
    this.tYw = paramb;
    invalidate();
    AppMethodBeat.o(63182);
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(63181);
      paramMotionEvent = LyricView.a(LyricView.this, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!bt.isNullOrNil(paramMotionEvent))
      {
        f.cVo().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
        Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(2131761463, new Object[] { paramMotionEvent }), 0).show();
        AppMethodBeat.o(63181);
        return;
      }
      ad.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
      AppMethodBeat.o(63181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */