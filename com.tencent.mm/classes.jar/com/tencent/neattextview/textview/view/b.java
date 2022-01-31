package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.neattextview.textview.b.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, NeatTextView.c
{
  private GestureDetector gEU;
  public View mView;
  private a wEX;
  public c wEY;
  private com.tencent.neattextview.textview.layout.b wEm;
  
  public b(Context paramContext, a parama)
  {
    this.wEX = parama;
    this.gEU = new GestureDetector(paramContext, this);
    this.gEU.setOnDoubleTapListener(this);
  }
  
  public void cancel(int paramInt)
  {
    if (this.wEY != null)
    {
      this.wEY.mmZ = false;
      this.mView.invalidate();
      this.wEY = null;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.wEX.getOnDoubleClickListener() != null)
    {
      this.wEX.getOnDoubleClickListener().eb(this.mView);
      return true;
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.wEX.cNP()) {}
    Object localObject2;
    do
    {
      Object localObject1;
      while (!((Iterator)localObject1).hasNext())
      {
        return false;
        localObject1 = this.wEm;
        if (((com.tencent.neattextview.textview.layout.b)localObject1).wEa == null)
        {
          ((com.tencent.neattextview.textview.layout.b)localObject1).wEa = new LinkedList();
          localObject2 = ((com.tencent.neattextview.textview.layout.b)localObject1).wDK.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)((Iterator)localObject2).next();
            if (localb.getClass() == c.class) {
              ((com.tencent.neattextview.textview.layout.b)localObject1).wEa.add((c)localb);
            }
          }
        }
        localObject1 = ((com.tencent.neattextview.textview.layout.b)localObject1).wEa.iterator();
      }
      localObject2 = (c)((Iterator)localObject1).next();
    } while (!((c)localObject2).af(paramMotionEvent.getX() - this.wEX.getHorizontalOffset(), paramMotionEvent.getY() - this.wEX.getVerticalOffset()));
    this.wEY = ((c)localObject2);
    ((c)localObject2).mmZ = true;
    this.mView.postInvalidate();
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    cancel(2);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    cancel(1);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.wEX.cNP()) {}
    View localView;
    do
    {
      do
      {
        return false;
      } while (this.wEY == null);
      paramMotionEvent = this.wEY;
      localView = this.mView;
    } while (paramMotionEvent.wDz == null);
    ((ClickableSpan)paramMotionEvent.wDz).onClick(localView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (this.wEX.getLayout() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      this.wEm = this.wEX.getLayout();
      this.mView = paramView;
      bool2 = this.gEU.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 3) {
        break;
      }
      bool1 = bool2;
    } while (paramMotionEvent.getAction() != 1);
    cancel(2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.b
 * JD-Core Version:    0.7.0.1
 */