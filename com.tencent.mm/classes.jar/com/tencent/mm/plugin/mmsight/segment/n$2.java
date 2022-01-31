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
  float bTE;
  float bTF;
  int oMd = -1;
  int oMe = -1;
  int oMf;
  int oMg;
  
  n$2(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55012);
    if (!n.h(this.oMc))
    {
      AppMethodBeat.o(55012);
      return false;
    }
    boolean bool;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      AppMethodBeat.o(55012);
      return false;
    case 2: 
      if ((!n.a(this.oMc, true)) && (!n.a(this.oMc, false)))
      {
        AppMethodBeat.o(55012);
        return false;
      }
      if (n.i(this.oMc))
      {
        AppMethodBeat.o(55012);
        return true;
      }
      this.oMg = 0;
      bool = false;
      if (this.oMg < paramMotionEvent.getPointerCount())
      {
        this.oMf = paramMotionEvent.getPointerId(this.oMg);
        if ((this.oMf == this.oMd) || (this.oMf == this.oMe))
        {
          paramView = this.oMc;
          if (this.oMf != this.oMd) {
            break label257;
          }
          bool = true;
          n.a(paramView, bool, paramMotionEvent.getX(this.oMg));
          if (n.j(this.oMc) != null)
          {
            paramView = n.j(this.oMc);
            if (this.oMf != this.oMd) {
              break label262;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          paramView.jq(bool);
          bool = true;
          this.oMg += 1;
          break;
          bool = false;
          break label191;
        }
      }
      AppMethodBeat.o(55012);
      return bool;
    case 1: 
    case 3: 
    case 6: 
      label191:
      this.oMf = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      label257:
      label262:
      if ((this.oMf != this.oMd) && (this.oMf != this.oMe))
      {
        AppMethodBeat.o(55012);
        return false;
      }
      if (n.j(this.oMc) != null) {
        n.j(this.oMc).bRK();
      }
      paramView = this.oMc;
      if (this.oMf == this.oMd)
      {
        bool = true;
        n.a(paramView, bool, false);
        if (this.oMf != this.oMd) {
          break label389;
        }
        this.oMd = -1;
      }
      for (;;)
      {
        AppMethodBeat.o(55012);
        return true;
        bool = false;
        break;
        label389:
        this.oMe = -1;
      }
    }
    this.oMg = paramMotionEvent.getActionIndex();
    this.oMf = paramMotionEvent.getPointerId(this.oMg);
    this.bTE = paramMotionEvent.getX(this.oMg);
    this.bTF = paramMotionEvent.getY(this.oMg);
    if (n.a(this.oMc, n.c(this.oMc), this.bTE, this.bTF))
    {
      if (n.a(this.oMc, true))
      {
        AppMethodBeat.o(55012);
        return false;
      }
      if (n.j(this.oMc) != null) {
        n.j(this.oMc).bRJ();
      }
      this.oMd = this.oMf;
      n.a(this.oMc, n.c(this.oMc).getBounds().left);
      n.a(this.oMc, true, true);
      AppMethodBeat.o(55012);
      return true;
    }
    if (n.a(this.oMc, n.e(this.oMc), this.bTE, this.bTF))
    {
      if (n.a(this.oMc, false))
      {
        AppMethodBeat.o(55012);
        return false;
      }
      if (n.j(this.oMc) != null) {
        n.j(this.oMc).bRJ();
      }
      this.oMe = this.oMf;
      n.b(this.oMc, n.e(this.oMc).getBounds().right);
      n.a(this.oMc, false, true);
      AppMethodBeat.o(55012);
      return true;
    }
    AppMethodBeat.o(55012);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.2
 * JD-Core Version:    0.7.0.1
 */