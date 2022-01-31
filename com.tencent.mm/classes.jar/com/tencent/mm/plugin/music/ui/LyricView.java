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
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int pbo;
  public static int pbp;
  private int blU;
  private float fac;
  private float fad;
  private long fom;
  private int height;
  private GestureDetector lOj;
  private com.tencent.mm.plugin.music.model.a pbi;
  private TextPaint pbj;
  private TextPaint pbk;
  private int pbl;
  private int pbm;
  private int pbn;
  private int pbq;
  private boolean pbr;
  private boolean pbs;
  private int pbt;
  private int width;
  
  static
  {
    AppMethodBeat.i(105054);
    pbo = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 16);
    pbp = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 10);
    AppMethodBeat.o(105054);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105046);
    this.pbn = -1;
    this.pbq = (pbo + pbp);
    this.blU = this.pbq;
    initView();
    AppMethodBeat.o(105046);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105047);
    this.pbn = -1;
    this.pbq = (pbo + pbp);
    this.blU = this.pbq;
    initView();
    AppMethodBeat.o(105047);
  }
  
  private void initView()
  {
    AppMethodBeat.i(105048);
    this.pbj = new TextPaint();
    this.pbj.setTextSize(pbo);
    this.pbj.setColor(-1);
    this.pbj.setAntiAlias(true);
    this.pbj.setTextAlign(Paint.Align.CENTER);
    this.pbk = new TextPaint();
    this.pbk.setTextSize(pbo);
    this.pbk.setColor(-1);
    this.pbk.setAlpha(127);
    this.pbk.setAntiAlias(true);
    this.pbk.setTextAlign(Paint.Align.CENTER);
    this.lOj = new GestureDetector(getContext(), new LyricView.a(this, (byte)0));
    AppMethodBeat.o(105048);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105050);
    super.onDraw(paramCanvas);
    if (this.pbi == null)
    {
      ab.v("MicroMsg.Music.LyricView", "lyricObj is null");
      AppMethodBeat.o(105050);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.pbn < 0)
    {
      AppMethodBeat.o(105050);
      return;
    }
    int i = this.blU;
    if ((this.pbi == null) || (this.pbi.oZq.size() <= this.pbn)) {
      if (this.pbr) {
        if (this.blU == 0) {
          break label401;
        }
      }
    }
    label401:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.blU = ((int)(this.blU * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(105050);
      return;
      int j = this.height / 2 - i;
      if ((j < this.height) && (j > 0) && (this.pbi.Aj(this.pbn) != null)) {
        paramCanvas.drawText(this.pbi.Aj(this.pbn).content, this.width / 2, j, this.pbj);
      }
      i = this.pbn - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.pbn - i) * (pbo + pbp);
        if ((k > 0) && (k < this.height) && (this.pbi.Aj(i) != null)) {
          paramCanvas.drawText(this.pbi.Aj(i).content, this.width / 2, k, this.pbk);
        }
        i -= 1;
      }
      i = this.pbn + 1;
      while (i < this.pbi.oZq.size())
      {
        k = (i - this.pbn) * (pbo + pbp) + j;
        if ((k < this.height) && (k > 0) && (this.pbi.Aj(i) != null)) {
          paramCanvas.drawText(this.pbi.Aj(i).content, this.width / 2, k, this.pbk);
        }
        i += 1;
      }
      break;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105051);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
    AppMethodBeat.o(105051);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105052);
    this.lOj.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105052);
      return true;
      this.fad = paramMotionEvent.getY();
      this.fac = paramMotionEvent.getX();
      this.pbt = this.blU;
      this.pbs = true;
      this.pbr = false;
      continue;
      int k = (int)(paramMotionEvent.getX() - this.fac);
      int m = (int)(paramMotionEvent.getY() - this.fad);
      int i = this.pbt - m;
      if (i > 0)
      {
        if (i > this.pbm) {}
        for (j = this.pbm;; j = i)
        {
          this.blU = j;
          invalidate();
          ab.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.pbt) });
          break;
        }
      }
      if (i < -this.pbl) {}
      for (int j = -this.pbl;; j = i)
      {
        this.blU = j;
        break;
      }
      this.pbs = false;
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(105045);
    if (this.fom != paramLong)
    {
      this.fom = paramLong;
      if ((this.pbi == null) || (this.pbi.oZq.size() == 0))
      {
        AppMethodBeat.o(105045);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.pbi.oZq.size()) && (this.pbi.Aj(i).timestamp < paramLong))
      {
        if (!this.pbi.Aj(i).oZw) {
          j = i;
        }
        i += 1;
      }
      if ((!this.pbs) && (j != this.pbn))
      {
        this.pbn = j;
        this.pbl = ((pbo + pbp) * this.pbn);
        this.pbm = ((pbo + pbp) * (this.pbi.oZq.size() - this.pbn - 1));
        if (this.blU == 0) {
          this.blU = (-this.pbq);
        }
        this.pbr = true;
        invalidate();
      }
    }
    AppMethodBeat.o(105045);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(105049);
    this.pbj.setColor(paramInt);
    this.pbj.setAlpha(255);
    this.pbk.setColor(paramInt);
    this.pbk.setAlpha(127);
    AppMethodBeat.o(105049);
  }
  
  public void setLyricObj(com.tencent.mm.plugin.music.model.a parama)
  {
    AppMethodBeat.i(105044);
    this.pbi = parama;
    invalidate();
    AppMethodBeat.o(105044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */