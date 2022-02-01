package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

public final class an
  extends TouchDelegate
{
  private static final Rect Wfa;
  public ArrayList<ao> Wfb;
  public ao Wfc;
  
  static
  {
    AppMethodBeat.i(223085);
    Wfa = new Rect();
    AppMethodBeat.o(223085);
  }
  
  public an(View paramView)
  {
    super(Wfa, paramView);
  }
  
  private static ao a(ArrayList<ao> paramArrayList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223084);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(223084);
      return null;
    }
    int m = paramArrayList.size();
    if (m <= 0)
    {
      AppMethodBeat.o(223084);
      return null;
    }
    if (m == 1)
    {
      paramArrayList = (ao)paramArrayList.get(0);
      AppMethodBeat.o(223084);
      return paramArrayList;
    }
    int i = 2147483647;
    Object localObject = null;
    int j = 0;
    if (j < m)
    {
      ao localao = (ao)paramArrayList.get(j);
      p.k(paramMotionEvent, "event");
      int[] arrayOfInt = new int[2];
      localao.Wfd.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int n = localao.Wfd.getWidth() / 2;
      int i1 = arrayOfInt[1];
      int i2 = localao.Wfd.getHeight() / 2;
      k = (int)Math.sqrt(Math.pow(paramMotionEvent.getRawX() - (k + n), 2.0D) + Math.pow(paramMotionEvent.getRawY() - (i1 + i2), 2.0D));
      if (k >= i) {
        break label230;
      }
      i = k;
      localObject = localao;
    }
    label230:
    for (;;)
    {
      j += 1;
      break;
      if (i == 2147483647)
      {
        paramArrayList = (ao)paramArrayList.get(0);
        AppMethodBeat.o(223084);
        return paramArrayList;
      }
      AppMethodBeat.o(223084);
      return localObject;
    }
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(223075);
    if (this.Wfb == null) {
      this.Wfb = new ArrayList();
    }
    this.Wfb.add(paramao);
    AppMethodBeat.o(223075);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(223078);
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject1 = localObject3;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(223078);
      return false;
      localObject1 = localObject3;
      if (this.Wfb != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        Iterator localIterator = this.Wfb.iterator();
        for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
        {
          label93:
          ao localao = (ao)localIterator.next();
          paramMotionEvent.setLocation(f1, f2);
          if ((localao == null) || (!localao.onTouchEvent(paramMotionEvent))) {
            break label93;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localao);
        }
        paramMotionEvent.setLocation(f1, f2);
        Object localObject2 = a((ArrayList)localObject1, paramMotionEvent);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          this.Wfc = ((ao)localObject2);
          AppMethodBeat.o(223078);
          return true;
          localObject1 = this.Wfc;
          continue;
          localObject1 = this.Wfc;
          this.Wfc = null;
        }
      }
    }
    boolean bool = ((TouchDelegate)localObject1).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(223078);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.an
 * JD-Core Version:    0.7.0.1
 */