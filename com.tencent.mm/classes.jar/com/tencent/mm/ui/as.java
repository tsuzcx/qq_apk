package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.s;

public final class as
  extends TouchDelegate
{
  private static final Rect adKI;
  public ArrayList<at> adKJ;
  public at adKK;
  
  static
  {
    AppMethodBeat.i(249308);
    adKI = new Rect();
    AppMethodBeat.o(249308);
  }
  
  public as(View paramView)
  {
    super(adKI, paramView);
  }
  
  private static at a(ArrayList<at> paramArrayList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(249304);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(249304);
      return null;
    }
    int m = paramArrayList.size();
    if (m <= 0)
    {
      AppMethodBeat.o(249304);
      return null;
    }
    if (m == 1)
    {
      paramArrayList = (at)paramArrayList.get(0);
      AppMethodBeat.o(249304);
      return paramArrayList;
    }
    int i = 2147483647;
    Object localObject = null;
    int j = 0;
    if (j < m)
    {
      at localat = (at)paramArrayList.get(j);
      s.u(paramMotionEvent, "event");
      int[] arrayOfInt = new int[2];
      localat.adKL.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int n = localat.adKL.getWidth() / 2;
      int i1 = arrayOfInt[1];
      int i2 = localat.adKL.getHeight() / 2;
      k = (int)Math.sqrt(Math.pow(paramMotionEvent.getRawX() - (k + n), 2.0D) + Math.pow(paramMotionEvent.getRawY() - (i1 + i2), 2.0D));
      if (k >= i) {
        break label230;
      }
      i = k;
      localObject = localat;
    }
    label230:
    for (;;)
    {
      j += 1;
      break;
      if (i == 2147483647)
      {
        paramArrayList = (at)paramArrayList.get(0);
        AppMethodBeat.o(249304);
        return paramArrayList;
      }
      AppMethodBeat.o(249304);
      return localObject;
    }
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(249312);
    if (this.adKJ == null) {
      this.adKJ = new ArrayList();
    }
    this.adKJ.add(paramat);
    AppMethodBeat.o(249312);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(249318);
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject1 = localObject3;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(249318);
      return false;
      localObject1 = localObject3;
      if (this.adKJ != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        Iterator localIterator = this.adKJ.iterator();
        for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
        {
          label93:
          at localat = (at)localIterator.next();
          paramMotionEvent.setLocation(f1, f2);
          if ((localat == null) || (!localat.onTouchEvent(paramMotionEvent))) {
            break label93;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localat);
        }
        paramMotionEvent.setLocation(f1, f2);
        Object localObject2 = a((ArrayList)localObject1, paramMotionEvent);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          this.adKK = ((at)localObject2);
          AppMethodBeat.o(249318);
          return true;
          localObject1 = this.adKK;
          continue;
          localObject1 = this.adKK;
          this.adKK = null;
        }
      }
    }
    boolean bool = ((TouchDelegate)localObject1).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(249318);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.as
 * JD-Core Version:    0.7.0.1
 */