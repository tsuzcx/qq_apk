package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$2
  implements View.OnTouchListener
{
  float cEZ;
  float cFa;
  int tHo = -1;
  int tHp = -1;
  int tHq;
  int tHr;
  
  n$2(SliderSeekBar paramSliderSeekBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94445);
    if (!SliderSeekBar.h(this.tHn))
    {
      AppMethodBeat.o(94445);
      return false;
    }
    boolean bool;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      AppMethodBeat.o(94445);
      return false;
    case 2: 
      if ((!SliderSeekBar.a(this.tHn, true)) && (!SliderSeekBar.a(this.tHn, false)))
      {
        AppMethodBeat.o(94445);
        return false;
      }
      if (SliderSeekBar.i(this.tHn))
      {
        AppMethodBeat.o(94445);
        return true;
      }
      this.tHr = 0;
      bool = false;
      if (this.tHr < paramMotionEvent.getPointerCount())
      {
        this.tHq = paramMotionEvent.getPointerId(this.tHr);
        if ((this.tHq == this.tHo) || (this.tHq == this.tHp))
        {
          paramView = this.tHn;
          if (this.tHq != this.tHo) {
            break label301;
          }
          bool = true;
          bool = paramView.d(bool, paramMotionEvent.getX(this.tHr));
          if ((SliderSeekBar.j(this.tHn)) && (bool) && (!SliderSeekBar.k(this.tHn))) {
            this.tHn.performHapticFeedback(0, 2);
          }
          SliderSeekBar.b(this.tHn, bool);
          if (SliderSeekBar.l(this.tHn) != null)
          {
            paramView = SliderSeekBar.l(this.tHn);
            if (this.tHq != this.tHo) {
              break label306;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          paramView.nj(bool);
          bool = true;
          this.tHr += 1;
          break;
          bool = false;
          break label191;
        }
      }
      AppMethodBeat.o(94445);
      return bool;
    case 1: 
    case 3: 
    case 6: 
      label191:
      this.tHq = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      label301:
      label306:
      if ((this.tHq != this.tHo) && (this.tHq != this.tHp))
      {
        AppMethodBeat.o(94445);
        return false;
      }
      if (SliderSeekBar.l(this.tHn) != null)
      {
        paramView = SliderSeekBar.l(this.tHn);
        if (this.tHq == this.tHo)
        {
          bool = true;
          paramView.yW(bool);
        }
      }
      else
      {
        paramView = this.tHn;
        if (this.tHq != this.tHo) {
          break label458;
        }
        bool = true;
        label415:
        SliderSeekBar.a(paramView, bool, false);
        if (this.tHq != this.tHo) {
          break label463;
        }
        this.tHo = -1;
      }
      for (;;)
      {
        SliderSeekBar.b(this.tHn, false);
        AppMethodBeat.o(94445);
        return true;
        bool = false;
        break;
        label458:
        bool = false;
        break label415;
        label463:
        this.tHp = -1;
      }
    }
    this.tHr = paramMotionEvent.getActionIndex();
    this.tHq = paramMotionEvent.getPointerId(this.tHr);
    this.cEZ = paramMotionEvent.getX(this.tHr);
    this.cFa = paramMotionEvent.getY(this.tHr);
    if (SliderSeekBar.a(this.tHn, SliderSeekBar.c(this.tHn), this.cEZ, this.cFa))
    {
      if (SliderSeekBar.a(this.tHn, true))
      {
        AppMethodBeat.o(94445);
        return false;
      }
      if (SliderSeekBar.l(this.tHn) != null) {
        SliderSeekBar.l(this.tHn).cQD();
      }
      this.tHo = this.tHq;
      SliderSeekBar.b(this.tHn, SliderSeekBar.c(this.tHn).getBounds().left);
      SliderSeekBar.a(this.tHn, true, true);
      AppMethodBeat.o(94445);
      return true;
    }
    if (SliderSeekBar.a(this.tHn, SliderSeekBar.e(this.tHn), this.cEZ, this.cFa))
    {
      if (SliderSeekBar.a(this.tHn, false))
      {
        AppMethodBeat.o(94445);
        return false;
      }
      if (SliderSeekBar.l(this.tHn) != null) {
        SliderSeekBar.l(this.tHn).cQD();
      }
      this.tHp = this.tHq;
      SliderSeekBar.a(this.tHn, SliderSeekBar.e(this.tHn).getBounds().right);
      SliderSeekBar.a(this.tHn, false, true);
      AppMethodBeat.o(94445);
      return true;
    }
    AppMethodBeat.o(94445);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.2
 * JD-Core Version:    0.7.0.1
 */