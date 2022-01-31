package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class o$2
  implements View.OnTouchListener
{
  float fSy;
  float fSz;
  int mmV = -1;
  int mmW = -1;
  int mmX;
  int mmY;
  
  o$2(o paramo) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!o.h(this.mmU)) {}
    label309:
    label375:
    label380:
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            return false;
            switch (paramMotionEvent.getActionMasked())
            {
            case 4: 
            default: 
              return false;
            case 0: 
            case 5: 
              this.mmY = paramMotionEvent.getActionIndex();
              this.mmX = paramMotionEvent.getPointerId(this.mmY);
              this.fSy = paramMotionEvent.getX(this.mmY);
              this.fSz = paramMotionEvent.getY(this.mmY);
              if (!o.a(this.mmU, o.c(this.mmU), this.fSy, this.fSz)) {
                break label498;
              }
            }
          } while (o.a(this.mmU, true));
          if (o.j(this.mmU) != null) {
            o.j(this.mmU).bjW();
          }
          this.mmV = this.mmX;
          o.a(this.mmU, o.c(this.mmU).getBounds().left);
          o.a(this.mmU, true, true);
          return true;
        } while ((!o.a(this.mmU, true)) && (!o.a(this.mmU, false)));
        if (o.i(this.mmU)) {
          return true;
        }
        this.mmY = 0;
        bool = false;
        if (this.mmY < paramMotionEvent.getPointerCount())
        {
          this.mmX = paramMotionEvent.getPointerId(this.mmY);
          if ((this.mmX == this.mmV) || (this.mmX == this.mmW))
          {
            paramView = this.mmU;
            if (this.mmX != this.mmV) {
              break label375;
            }
            bool = true;
            o.a(paramView, bool, paramMotionEvent.getX(this.mmY));
            if (o.j(this.mmU) != null)
            {
              paramView = o.j(this.mmU);
              if (this.mmX != this.mmV) {
                break label380;
              }
            }
          }
          for (bool = true;; bool = false)
          {
            paramView.hx(bool);
            bool = true;
            this.mmY += 1;
            break;
            bool = false;
            break label309;
          }
        }
        return bool;
        this.mmX = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      } while ((this.mmX != this.mmV) && (this.mmX != this.mmW));
      if (o.j(this.mmU) != null) {
        o.j(this.mmU).bjX();
      }
      paramView = this.mmU;
      if (this.mmX == this.mmV)
      {
        bool = true;
        o.a(paramView, bool, false);
        if (this.mmX != this.mmV) {
          break label490;
        }
        this.mmV = -1;
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        this.mmW = -1;
      }
    } while ((!o.a(this.mmU, o.e(this.mmU), this.fSy, this.fSz)) || (o.a(this.mmU, false)));
    label490:
    label498:
    if (o.j(this.mmU) != null) {
      o.j(this.mmU).bjW();
    }
    this.mmW = this.mmX;
    o.b(this.mmU, o.e(this.mmU).getBounds().right);
    o.a(this.mmU, false, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.o.2
 * JD-Core Version:    0.7.0.1
 */