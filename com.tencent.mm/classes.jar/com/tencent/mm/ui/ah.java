package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Iterator;

public final class ah
  extends TouchDelegate
{
  private static final Rect JAW;
  public ArrayList<ai> JAX;
  public ai JAY;
  
  static
  {
    AppMethodBeat.i(193699);
    JAW = new Rect();
    AppMethodBeat.o(193699);
  }
  
  public ah(View paramView)
  {
    super(JAW, paramView);
  }
  
  private static ai a(ArrayList<ai> paramArrayList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193698);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(193698);
      return null;
    }
    int m = paramArrayList.size();
    if (m <= 0)
    {
      AppMethodBeat.o(193698);
      return null;
    }
    if (m == 1)
    {
      paramArrayList = (ai)paramArrayList.get(0);
      AppMethodBeat.o(193698);
      return paramArrayList;
    }
    int i = 2147483647;
    Object localObject = null;
    int j = 0;
    if (j < m)
    {
      ai localai = (ai)paramArrayList.get(j);
      p.h(paramMotionEvent, "event");
      int[] arrayOfInt = new int[2];
      localai.JAZ.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int n = localai.JAZ.getWidth() / 2;
      int i1 = arrayOfInt[1];
      int i2 = localai.JAZ.getHeight() / 2;
      k = (int)Math.sqrt(Math.pow(paramMotionEvent.getRawX() - (k + n), 2.0D) + Math.pow(paramMotionEvent.getRawY() - (i1 + i2), 2.0D));
      if (k >= i) {
        break label230;
      }
      i = k;
      localObject = localai;
    }
    label230:
    for (;;)
    {
      j += 1;
      break;
      if (i == 2147483647)
      {
        paramArrayList = (ai)paramArrayList.get(0);
        AppMethodBeat.o(193698);
        return paramArrayList;
      }
      AppMethodBeat.o(193698);
      return localObject;
    }
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(193696);
    if (this.JAX == null) {
      this.JAX = new ArrayList();
    }
    this.JAX.add(paramai);
    AppMethodBeat.o(193696);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(193697);
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject1 = localObject3;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(193697);
      return false;
      localObject1 = localObject3;
      if (this.JAX != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        Iterator localIterator = this.JAX.iterator();
        for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
        {
          label93:
          ai localai = (ai)localIterator.next();
          paramMotionEvent.setLocation(f1, f2);
          if ((localai == null) || (!localai.onTouchEvent(paramMotionEvent))) {
            break label93;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localai);
        }
        paramMotionEvent.setLocation(f1, f2);
        Object localObject2 = a((ArrayList)localObject1, paramMotionEvent);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          this.JAY = ((ai)localObject2);
          AppMethodBeat.o(193697);
          return true;
          localObject1 = this.JAY;
          continue;
          localObject1 = this.JAY;
          this.JAY = null;
        }
      }
    }
    boolean bool = ((TouchDelegate)localObject1).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(193697);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */