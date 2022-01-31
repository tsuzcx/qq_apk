package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.f.a;
import java.util.HashSet;

final class Vending$4
  implements c.a
{
  Vending$4(Vending paramVending) {}
  
  public final void dQg()
  {
    AppMethodBeat.i(126159);
    a.i("Vending", "%s beforeSynchronize", new Object[] { this.ANV });
    Vending.b(this.ANV).dQi();
    AppMethodBeat.o(126159);
  }
  
  public final void dQh()
  {
    AppMethodBeat.i(126161);
    a.i("Vending", "%s afterSynchronize", new Object[] { this.ANV });
    if (Vending.e(this.ANV) != null) {
      Vending.e(this.ANV).ate();
    }
    AppMethodBeat.o(126161);
  }
  
  public final void synchronizing(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(126160);
    a.i("Vending", "%s synchronizing", new Object[] { this.ANV });
    this.ANV.b.clear();
    Vending.b(this.ANV).dQi();
    Vending.c(this.ANV).removeCallbacksAndMessages(null);
    if (paramInt == 2) {
      paramObject = this.ANV.prepareVendingDataAsynchronous();
    }
    if ((paramInt == 2) || (paramInt == 1)) {
      this.ANV.applyChangeSynchronized(paramObject);
    }
    this.ANV.synchronizing(paramInt, paramObject);
    Vending.d(this.ANV).clear();
    AppMethodBeat.o(126160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.4
 * JD-Core Version:    0.7.0.1
 */