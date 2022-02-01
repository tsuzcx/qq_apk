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
import com.tencent.mm.plugin.music.model.b.a;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public class LyricView
  extends View
{
  public static int wCA;
  public static int wCz;
  private float gpg;
  private float gph;
  private long hLA;
  private int height;
  private GestureDetector iNw;
  private int uOo;
  private int wCB;
  private boolean wCC;
  private boolean wCD;
  private int wCE;
  private com.tencent.mm.plugin.music.model.b wCo;
  private TextPaint wCu;
  private TextPaint wCv;
  private int wCw;
  private int wCx;
  private int wCy;
  private int width;
  
  static
  {
    AppMethodBeat.i(63192);
    wCz = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
    wCA = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 10);
    AppMethodBeat.o(63192);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63184);
    this.wCy = -1;
    this.wCB = (wCz + wCA);
    this.uOo = this.wCB;
    initView();
    AppMethodBeat.o(63184);
  }
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63185);
    this.wCy = -1;
    this.wCB = (wCz + wCA);
    this.uOo = this.wCB;
    initView();
    AppMethodBeat.o(63185);
  }
  
  private void initView()
  {
    AppMethodBeat.i(63186);
    this.wCu = new TextPaint();
    this.wCu.setTextSize(wCz);
    this.wCu.setColor(-1);
    this.wCu.setAntiAlias(true);
    this.wCu.setTextAlign(Paint.Align.CENTER);
    this.wCv = new TextPaint();
    this.wCv.setTextSize(wCz);
    this.wCv.setColor(-1);
    this.wCv.setAlpha(127);
    this.wCv.setAntiAlias(true);
    this.wCv.setTextAlign(Paint.Align.CENTER);
    this.iNw = new GestureDetector(getContext(), new a((byte)0));
    AppMethodBeat.o(63186);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63188);
    super.onDraw(paramCanvas);
    if (this.wCo == null)
    {
      ae.v("MicroMsg.Music.LyricView", "lyricObj is null");
      AppMethodBeat.o(63188);
      return;
    }
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    if (this.wCy < 0)
    {
      AppMethodBeat.o(63188);
      return;
    }
    int i = this.uOo;
    if ((this.wCo == null) || (this.wCo.wAq.size() <= this.wCy)) {
      if (this.wCC) {
        if (this.uOo == 0) {
          break label401;
        }
      }
    }
    label401:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uOo = ((int)(this.uOo * 0.9F));
        invalidate();
      }
      AppMethodBeat.o(63188);
      return;
      int j = this.height / 2 - i;
      if ((j < this.height) && (j > 0) && (this.wCo.LT(this.wCy) != null)) {
        paramCanvas.drawText(this.wCo.LT(this.wCy).content, this.width / 2, j, this.wCu);
      }
      i = this.wCy - 1;
      int k;
      while (i >= 0)
      {
        k = j - (this.wCy - i) * (wCz + wCA);
        if ((k > 0) && (k < this.height) && (this.wCo.LT(i) != null)) {
          paramCanvas.drawText(this.wCo.LT(i).content, this.width / 2, k, this.wCv);
        }
        i -= 1;
      }
      i = this.wCy + 1;
      while (i < this.wCo.wAq.size())
      {
        k = (i - this.wCy) * (wCz + wCA) + j;
        if ((k < this.height) && (k > 0) && (this.wCo.LT(i) != null)) {
          paramCanvas.drawText(this.wCo.LT(i).content, this.width / 2, k, this.wCv);
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
    GestureDetector localGestureDetector = this.iNw;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63190);
      return true;
      this.gph = paramMotionEvent.getY();
      this.gpg = paramMotionEvent.getX();
      this.wCE = this.uOo;
      this.wCD = true;
      this.wCC = false;
      continue;
      int k = (int)(paramMotionEvent.getX() - this.gpg);
      int m = (int)(paramMotionEvent.getY() - this.gph);
      int i = this.wCE - m;
      if (i > 0)
      {
        if (i > this.wCx) {}
        for (j = this.wCx;; j = i)
        {
          this.uOo = j;
          invalidate();
          ae.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.wCE) });
          break;
        }
      }
      if (i < -this.wCw) {}
      for (int j = -this.wCw;; j = i)
      {
        this.uOo = j;
        break;
      }
      this.wCD = false;
    }
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(63183);
    if (this.hLA != paramLong)
    {
      this.hLA = paramLong;
      if ((this.wCo == null) || (this.wCo.wAq.size() == 0))
      {
        AppMethodBeat.o(63183);
        return;
      }
      int j = -1;
      int i = 0;
      while ((i < this.wCo.wAq.size()) && (this.wCo.LT(i).timestamp < paramLong))
      {
        if (!this.wCo.LT(i).wAw) {
          j = i;
        }
        i += 1;
      }
      if ((!this.wCD) && (j != this.wCy))
      {
        this.wCy = j;
        this.wCw = ((wCz + wCA) * this.wCy);
        this.wCx = ((wCz + wCA) * (this.wCo.wAq.size() - this.wCy - 1));
        if (this.uOo == 0) {
          this.uOo = (-this.wCB);
        }
        this.wCC = true;
        invalidate();
      }
    }
    AppMethodBeat.o(63183);
  }
  
  public void setLyricColor(int paramInt)
  {
    AppMethodBeat.i(63187);
    this.wCu.setColor(paramInt);
    this.wCu.setAlpha(255);
    this.wCv.setColor(paramInt);
    this.wCv.setAlpha(127);
    AppMethodBeat.o(63187);
  }
  
  public void setLyricObj(com.tencent.mm.plugin.music.model.b paramb)
  {
    AppMethodBeat.i(63182);
    this.wCo = paramb;
    invalidate();
    AppMethodBeat.o(63182);
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220702);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220702);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220701);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220701);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(63181);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
      paramMotionEvent = LyricView.a(LyricView.this, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!bu.isNullOrNil(paramMotionEvent))
      {
        f.dwv().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
        Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(2131761463, new Object[] { paramMotionEvent }), 0).show();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(63181);
        return;
        ae.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220700);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220700);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView
 * JD-Core Version:    0.7.0.1
 */