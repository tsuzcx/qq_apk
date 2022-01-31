package com.tencent.tencentmap.mapsdk.a;

import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

class au$2
  implements au.a
{
  private dc b = null;
  private boolean c = false;
  
  au$2(au paramau) {}
  
  public void a()
  {
    this.c = false;
    this.b = null;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149745);
    if ((au.b(this.a) == null) || (au.b(this.a).b() == null) || (!this.c) || (this.b == null))
    {
      AppMethodBeat.o(149745);
      return;
    }
    ah.m localm = this.b.s();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(149745);
      return;
      AppMethodBeat.o(149745);
      return;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      paramMotionEvent = new DoublePoint(i, j);
      paramMotionEvent = ka.a(au.b(this.a).b().t().a(paramMotionEvent));
      this.b.a(paramMotionEvent);
      if (localm != null) {
        localm.b(this.b);
      }
      if (au.c(this.a) != null)
      {
        au.c(this.a).b(this.b);
        AppMethodBeat.o(149745);
        return;
        this.c = false;
        if (localm != null) {
          localm.c(this.b);
        }
        if (au.c(this.a) != null) {
          au.c(this.a).c(this.b);
        }
        this.b = null;
      }
    }
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(149746);
    if (paramString.trim().length() == 0)
    {
      this.b = null;
      this.c = false;
      AppMethodBeat.o(149746);
      return;
    }
    this.b = au.a(this.a, paramString);
    if (this.b != null)
    {
      if (!this.b.i())
      {
        this.b = null;
        this.c = false;
        AppMethodBeat.o(149746);
        return;
      }
      this.c = true;
      if (au.c(this.a) != null) {
        au.c(this.a).a(this.b);
      }
    }
    AppMethodBeat.o(149746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.au.2
 * JD-Core Version:    0.7.0.1
 */