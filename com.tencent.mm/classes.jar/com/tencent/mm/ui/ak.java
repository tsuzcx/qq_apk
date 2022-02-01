package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

public final class ak
  extends TouchDelegate
{
  private static final Rect OLB;
  public ArrayList<al> OLC;
  public al OLD;
  
  static
  {
    AppMethodBeat.i(205133);
    OLB = new Rect();
    AppMethodBeat.o(205133);
  }
  
  public ak(View paramView)
  {
    super(OLB, paramView);
  }
  
  private static al a(ArrayList<al> paramArrayList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205132);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(205132);
      return null;
    }
    int m = paramArrayList.size();
    if (m <= 0)
    {
      AppMethodBeat.o(205132);
      return null;
    }
    if (m == 1)
    {
      paramArrayList = (al)paramArrayList.get(0);
      AppMethodBeat.o(205132);
      return paramArrayList;
    }
    int i = 2147483647;
    Object localObject = null;
    int j = 0;
    if (j < m)
    {
      al localal = (al)paramArrayList.get(j);
      p.h(paramMotionEvent, "event");
      int[] arrayOfInt = new int[2];
      localal.OLE.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int n = localal.OLE.getWidth() / 2;
      int i1 = arrayOfInt[1];
      int i2 = localal.OLE.getHeight() / 2;
      k = (int)Math.sqrt(Math.pow(paramMotionEvent.getRawX() - (k + n), 2.0D) + Math.pow(paramMotionEvent.getRawY() - (i1 + i2), 2.0D));
      if (k >= i) {
        break label230;
      }
      i = k;
      localObject = localal;
    }
    label230:
    for (;;)
    {
      j += 1;
      break;
      if (i == 2147483647)
      {
        paramArrayList = (al)paramArrayList.get(0);
        AppMethodBeat.o(205132);
        return paramArrayList;
      }
      AppMethodBeat.o(205132);
      return localObject;
    }
  }
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(205130);
    if (this.OLC == null) {
      this.OLC = new ArrayList();
    }
    this.OLC.add(paramal);
    AppMethodBeat.o(205130);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(205131);
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject1 = localObject3;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(205131);
      return false;
      localObject1 = localObject3;
      if (this.OLC != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        Iterator localIterator = this.OLC.iterator();
        for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
        {
          label93:
          al localal = (al)localIterator.next();
          paramMotionEvent.setLocation(f1, f2);
          if ((localal == null) || (!localal.onTouchEvent(paramMotionEvent))) {
            break label93;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localal);
        }
        paramMotionEvent.setLocation(f1, f2);
        Object localObject2 = a((ArrayList)localObject1, paramMotionEvent);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          this.OLD = ((al)localObject2);
          AppMethodBeat.o(205131);
          return true;
          localObject1 = this.OLD;
          continue;
          localObject1 = this.OLD;
          this.OLD = null;
        }
      }
    }
    boolean bool = ((TouchDelegate)localObject1).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205131);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ak
 * JD-Core Version:    0.7.0.1
 */