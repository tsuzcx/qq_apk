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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.b.a;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int vhv;
  public static int vhw;
  private float fTg;
  private float fTh;
  private int height;
  private long hqp;
  private GestureDetector irA;
  private int tAa;
  private int vhA;
  private b vhk;
  private TextPaint vhq;
  private TextPaint vhr;
  private int vhs;
  private int vht;
  private int vhu;
  private int vhx;
  private boolean vhy;
  private boolean vhz;
  private int width;
  
  static
  {
    AppMethodBeat.i(63192);
    vhv = a.fromDPToPix(ai.getContext(), 16);
    vhw = a.fromDPToPix(ai.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.vhu = -1;
    this.vhx = (vhv + vhw);
    this.tAa = this.vhx;
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.vhu = -1;
    this.vhx = (vhv + vhw);
    this.tAa = this.vhx;
    initView();
    AppMethodBeat.o(63185);
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    this.vhq = new TextPaint();
    this.vhq.setTextSize(vhv);
    this.vhq.setColor(-1);
    this.vhq.setAntiAlias(true);
    this.vhq.setTextAlign(Paint.Align.CENTER);
    this.vhr = new TextPaint();
    this.vhr.setTextSize(vhv);
    this.vhr.setColor(-1);
    this.vhr.setAlpha(127);
    this.vhr.setAntiAlias(true);
    this.vhr.setTextAlign(Paint.Align.CENTER);
    this.irA = new GestureDetector(getContext(), new a((byte)0));
    AppMethodBeat.o(63186);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    if (this.vhk == null)
    {
      ac.v("MicroMsg.Music.LyricView", "lyricObj is null");
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.vhu < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    int i = this.tAa;
    if ((this.vhk == null) || (this.vhk.vfm.size() <= this.vhu)) {
      if (this.vhy) {
        if (this.tAa == 0) {
          break label401;
        }
      }
    }
    label401:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.tAa = ((int)(this.tAa * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      int j = this.height / 2 - i;
      if ((j < this.height) && (j > 0) && (this.vhk.JM(this.vhu) != null)) {
        paramCanvas.drawText(this.vhk.JM(this.vhu).content, this.width / 2, j, this.vhq);
      }
      i = this.vhu - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.vhu - i) * (vhv + vhw);
        if ((k > 0) && (k < this.height) && (this.vhk.JM(i) != null)) {
          paramCanvas.drawText(this.vhk.JM(i).content, this.width / 2, k, this.vhr);
        }
        i -= 1;
      }
      i = this.vhu + 1;
      while (i < this.vhk.vfm.size())
      {
        k = (i - this.vhu) * (vhv + vhw) + j;
        if ((k < this.height) && (k > 0) && (this.vhk.JM(i) != null)) {
          paramCanvas.drawText(this.vhk.JM(i).content, this.width / 2, k, this.vhr);
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
    this.irA.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.fTh = paramMotionEvent.getY();
      this.fTg = paramMotionEvent.getX();
      this.vhA = this.tAa;
      this.vhz = true;
      this.vhy = false;
      continue;
      int k = (int)(paramMotionEvent.getX() - this.fTg);
      int m = (int)(paramMotionEvent.getY() - this.fTh);
      int i = this.vhA - m;
      if (i > 0)
      {
        if (i > this.vht) {}
        for (j = this.vht;; j = i)
        {
          this.tAa = j;
          invalidate();
          ac.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.vhA) });
          break;
        }
      }
      if (i < -this.vhs) {}
      for (int j = -this.vhs;; j = i)
      {
        this.tAa = j;
        break;
      }
      this.vhz = false;
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.hqp != paramLong)
    {
      this.hqp = paramLong;
      if ((this.vhk == null) || (this.vhk.vfm.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.vhk.vfm.size()) && (this.vhk.JM(i).timestamp < paramLong))
      {
        if (!this.vhk.JM(i).vfs) {
          j = i;
        }
        i += 1;
      }
      if ((!this.vhz) && (j != this.vhu))
      {
        this.vhu = j;
        this.vhs = ((vhv + vhw) * this.vhu);
        this.vht = ((vhv + vhw) * (this.vhk.vfm.size() - this.vhu - 1));
        if (this.tAa == 0) {
          this.tAa = (-this.vhx);
        }
        this.vhy = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.vhq.setColor(paramInt);
    this.vhq.setAlpha(255);
    this.vhr.setColor(paramInt);
    this.vhr.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(b paramb)
  {
    AppMethodBeat.i(63182);
    this.vhk = paramb;
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
      if (!bs.isNullOrNil(paramMotionEvent))
      {
        f.diU().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
        Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(2131761463, new Object[] { paramMotionEvent }), 0).show();
        AppMethodBeat.o(63181);
        return;
      }
      ac.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
      AppMethodBeat.o(63181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */