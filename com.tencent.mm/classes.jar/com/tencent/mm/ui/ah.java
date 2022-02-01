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
  private static final Rect Jgl;
  public ArrayList<ai> Jgm;
  public ai Jgn;
  
  static
  {
    AppMethodBeat.i(186446);
    Jgl = new Rect();
    AppMethodBeat.o(186446);
  }
  
  public ah(View paramView)
  {
    super(Jgl, paramView);
  }
  
  private static ai a(ArrayList<ai> paramArrayList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186445);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(186445);
      return null;
    }
    int m = paramArrayList.size();
    if (m <= 0)
    {
      AppMethodBeat.o(186445);
      return null;
    }
    if (m == 1)
    {
      paramArrayList = (ai)paramArrayList.get(0);
      AppMethodBeat.o(186445);
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
      localai.Jgo.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int n = localai.Jgo.getWidth() / 2;
      int i1 = arrayOfInt[1];
      int i2 = localai.Jgo.getHeight() / 2;
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
        AppMethodBeat.o(186445);
        return paramArrayList;
      }
      AppMethodBeat.o(186445);
      return localObject;
    }
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(186443);
    if (this.Jgm == null) {
      this.Jgm = new ArrayList();
    }
    this.Jgm.add(paramai);
    AppMethodBeat.o(186443);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(186444);
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject1 = localObject3;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(186444);
      return false;
      localObject1 = localObject3;
      if (this.Jgm != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        Iterator localIterator = this.Jgm.iterator();
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
          this.Jgn = ((ai)localObject2);
          AppMethodBeat.o(186444);
          return true;
          localObject1 = this.Jgn;
          continue;
          localObject1 = this.Jgn;
          this.Jgn = null;
        }
      }
    }
    boolean bool = ((TouchDelegate)localObject1).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(186444);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */