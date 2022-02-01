package com.tencent.mm.plugin.music.ui;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class LyricView
  extends View
{
  private static int LPb;
  private static int LPc;
  private int Jkv;
  private e LOA;
  private TextPaint LOT;
  private TextPaint LOU;
  private Paint.Align LOV;
  private boolean LOX;
  private int LOY;
  private int LOZ;
  private int LPa;
  private int LPd;
  private boolean LPe;
  private boolean LPf;
  private int LPg;
  private int[] LPh;
  private int[] LPi;
  private int dvQ;
  private int dvR;
  private float fig;
  private int height;
  private float mkm;
  private float mkn;
  private int mode;
  private GestureDetector nwZ;
  private long ood;
  private int textSize;
  private int width;
  
  static
  {
    AppMethodBeat.i(63192);
    LPb = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    LPc = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.mode = 1;
    this.LOV = Paint.Align.CENTER;
    this.LOX = false;
    this.dvQ = 0;
    this.textSize = LPb;
    this.dvR = LPc;
    this.LPa = -1;
    this.LPd = (this.dvQ + this.textSize + this.dvR);
    this.Jkv = this.LPd;
    this.LPh = new int[2];
    this.LPi = new int[2];
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.mode = 1;
    this.LOV = Paint.Align.CENTER;
    this.LOX = false;
    this.dvQ = 0;
    this.textSize = LPb;
    this.dvR = LPc;
    this.LPa = -1;
    this.LPd = (this.dvQ + this.textSize + this.dvR);
    this.Jkv = this.LPd;
    this.LPh = new int[2];
    this.LPi = new int[2];
    initView();
    AppMethodBeat.o(63185);
  }
  
  private static float i(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(270960);
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(270960);
      return -1.0F;
    }
    float f = paramMotionEvent.getY(paramInt);
    AppMethodBeat.o(270960);
    return f;
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    setNestedScrollingEnabled(true);
    this.LOT = new TextPaint();
    this.LOT.setTextSize(this.textSize);
    this.LOT.setColor(-1);
    this.LOT.setAntiAlias(true);
    this.LOT.setTextAlign(this.LOV);
    this.LOU = new TextPaint();
    this.LOU.setTextSize(this.textSize);
    this.LOU.setColor(-1);
    this.LOU.setAlpha(127);
    this.LOU.setAntiAlias(true);
    this.LOU.setTextAlign(this.LOV);
    this.nwZ = new GestureDetector(getContext(), new a((byte)0));
    this.nwZ.setIsLongpressEnabled(false);
    AppMethodBeat.o(63186);
  }
  
  public final void a(Paint.Align paramAlign, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(270985);
    this.LOX = true;
    this.LOV = paramAlign;
    this.LOT.setTextAlign(paramAlign);
    this.LOT.setFakeBoldText(false);
    this.LOU.setTextAlign(paramAlign);
    this.LOT.setFakeBoldText(false);
    this.dvQ = paramInt2;
    this.textSize = paramInt1;
    this.dvR = paramInt3;
    this.LPd = (paramInt2 + paramInt1 + paramInt3);
    this.Jkv = this.LPd;
    this.LOT.setTextSize(paramInt1);
    this.LOU.setTextSize(paramInt1);
    AppMethodBeat.o(270985);
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(270998);
    float f = (int)this.LOT.getTextSize();
    AppMethodBeat.o(270998);
    return f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    int j;
    if ((this.LOA == null) || (this.LOA.LMm.size() <= 2))
    {
      Log.d("MicroMsg.Music.LyricView", "lyricObj is null | no lyric");
      j = this.height;
      i = j;
      if (j > 300) {
        i = this.LPd;
      }
      j = i / 2 + this.dvQ - (int)(this.LOT.descent() + this.LOT.ascent()) / 2;
      if ((j < i) && (j > 0)) {
        paramCanvas.drawText("", 0.0F, j, this.LOT);
      }
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.LPa < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    if (Paint.Align.LEFT == this.LOV)
    {
      i = this.Jkv;
      if ((this.LOA == null) || (this.LOA.LMm.size() <= this.LPa)) {
        if (this.LPe) {
          if (this.Jkv == 0) {
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
        this.Jkv = ((int)(this.Jkv * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      this.LPd = (this.dvQ + this.textSize + this.dvR);
      if (this.LOX)
      {
        if ((this.LOA == null) || (this.LOA.LMm.size() <= this.LPa)) {
          break;
        }
        i = this.height / 2 + this.dvQ - (int)(this.LOT.descent() + this.LOT.ascent()) / 2;
        if ((i >= this.height) || (i <= 0) || (this.LOA.adz(this.LPa) == null) || (this.LOA.adz(this.LPa).isEmpty())) {
          break;
        }
        paramCanvas.drawText(this.LOA.adz(this.LPa).content, 0.0F, i, this.LOT);
        break;
      }
      j = this.height / 2;
      j = this.dvQ + (j - i);
      if ((j < this.height) && (j > 0) && (this.LOA.adz(this.LPa) != null) && (!this.LOA.adz(this.LPa).isEmpty())) {
        paramCanvas.drawText(this.LOA.adz(this.LPa).content, 0.0F, j, this.LOT);
      }
      i = this.LPa - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.LPa - i) * this.LPd;
        if ((k > 0) && (k < this.height) && (this.LOA.adz(i) != null) && (!this.LOA.adz(i).isEmpty())) {
          paramCanvas.drawText(this.LOA.adz(i).content, 0.0F, k, this.LOU);
        }
        i -= 1;
      }
      i = this.LPa + 1;
      while (i < this.LOA.LMm.size())
      {
        k = (i - this.LPa) * this.LPd + j;
        if ((k < this.height) && (k > 0) && (this.LOA.adz(i) != null) && (!this.LOA.adz(i).isEmpty())) {
          paramCanvas.drawText(this.LOA.adz(i).content, 0.0F, k, this.LOU);
        }
        i += 1;
      }
      break;
      i = this.Jkv;
      if ((this.LOA == null) || (this.LOA.LMm.size() <= this.LPa)) {
        break;
      }
      j = this.height / 2;
      j = this.dvQ + (j - i);
      if ((j < this.height) && (j > 0) && (this.LOA.adz(this.LPa) != null)) {
        paramCanvas.drawText(this.LOA.adz(this.LPa).content, this.width / 2, j, this.LOT);
      }
      i = this.LPa - 1;
      while (i >= 0)
      {
        k = j - (this.LPa - i) * this.LPd;
        if ((k > 0) && (k < this.height) && (this.LOA.adz(i) != null)) {
          paramCanvas.drawText(this.LOA.adz(i).content, this.width / 2, k, this.LOU);
        }
        i -= 1;
      }
      i = this.LPa + 1;
      while (i < this.LOA.LMm.size())
      {
        k = (i - this.LPa) * this.LPd + j;
        if ((k < this.height) && (k > 0) && (this.LOA.adz(i) != null)) {
          paramCanvas.drawText(this.LOA.adz(i).content, this.width / 2, k, this.LOU);
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
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int k = paramMotionEvent.getPointerId(0);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.mkn = paramMotionEvent.getY();
      this.mkm = paramMotionEvent.getX();
      this.LPg = this.Jkv;
      this.LPf = true;
      this.LPe = false;
      this.fig = i(paramMotionEvent, k);
      if (this.fig == -1.0F)
      {
        AppMethodBeat.o(63190);
        return false;
      }
      if (2 == this.mode)
      {
        startNestedScroll(2);
        continue;
        int m = (int)(paramMotionEvent.getX() - this.mkm);
        int n = (int)(paramMotionEvent.getY() - this.mkn);
        int i = this.LPg - n;
        float f1;
        if (i > 0)
        {
          if (i > this.LOZ) {}
          for (j = this.LOZ;; j = i)
          {
            this.Jkv = j;
            invalidate();
            Log.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.LPg) });
            if (2 != this.mode) {
              break;
            }
            f1 = i(paramMotionEvent, k);
            if (f1 != -1.0F) {
              break label394;
            }
            AppMethodBeat.o(63190);
            return false;
          }
        }
        if (i < -this.LOY) {}
        for (int j = -this.LOY;; j = i)
        {
          this.Jkv = j;
          break;
        }
        label394:
        float f2 = this.fig;
        dispatchNestedPreScroll(0, 0, this.LPh, this.LPi);
        dispatchNestedScroll(0, (int)(f1 - f2), 0, 0, null);
        continue;
        this.LPf = false;
      }
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.ood != paramLong)
    {
      this.ood = paramLong;
      if ((this.LOA == null) || (this.LOA.LMm.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.LOA.LMm.size()) && (this.LOA.adz(i).timestamp < paramLong))
      {
        if (!this.LOA.adz(i).LMr) {
          j = i;
        }
        i += 1;
      }
      if ((!this.LPf) && (j != this.LPa))
      {
        this.LPa = j;
        this.LOY = (this.LPd * this.LPa);
        this.LOZ = (this.LPd * (this.LOA.LMm.size() - this.LPa - 1));
        if (this.Jkv == 0) {
          this.Jkv = (-this.LPd);
        }
        this.LPe = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.LOT.setColor(paramInt);
    this.LOT.setAlpha(255);
    this.LOU.setColor(paramInt);
    this.LOU.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(63182);
    this.LOA = parame;
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
      this.LOX = bool;
      return;
      bool = false;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(270991);
    this.LOT.setTextSize(paramFloat);
    this.LOU.setTextSize(paramFloat);
    AppMethodBeat.o(270991);
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270911);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270911);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270909);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270909);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(63181);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      paramMotionEvent = LyricView.a(LyricView.this, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!Util.isNullOrNil(paramMotionEvent))
      {
        ClipboardHelper.setText(MMApplicationContext.getContext(), "MicroMsg.Music", paramMotionEvent);
        Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(a.h.music_clipboard_toast, new Object[] { paramMotionEvent }), 0).show();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(63181);
        return;
        Log.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270907);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270907);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */