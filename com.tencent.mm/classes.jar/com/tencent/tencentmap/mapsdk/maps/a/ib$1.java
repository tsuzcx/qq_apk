package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ib$1
  implements Runnable
{
  ib$1(ib paramib, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5) {}
  
  public void run()
  {
    AppMethodBeat.i(148151);
    ib.a(this.g, ib.a(this.g) + this.a);
    ib.a(this.g, this.b, ib.a(this.g), true);
    if (ib.b(this.g) < 10)
    {
      ib.c(this.g).postDelayed(this, 16L);
      AppMethodBeat.o(148151);
      return;
    }
    ib.a(this.g, this.b, this.c, true);
    if ((this.d >= 3.0F) && (this.d <= 20.0F))
    {
      if (this.e)
      {
        ib.1.1 local1 = new ib.1.1(this);
        ib.d(this.g).a().a((int)this.d, local1, false);
        AppMethodBeat.o(148151);
        return;
      }
      ib.d(this.g).a().a(this.f);
    }
    AppMethodBeat.o(148151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ib.1
 * JD-Core Version:    0.7.0.1
 */