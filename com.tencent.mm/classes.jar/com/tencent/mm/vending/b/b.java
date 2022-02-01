package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private a QZF;
  public _Callback QZG;
  private int QZH;
  private int mPriority;
  public d mScheduler;
  
  public b(_Callback param_Callback, a parama)
  {
    AppMethodBeat.i(74905);
    this.mPriority = -1;
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.QZH = param_Callback.hashCode();
    this.QZG = param_Callback;
    this.QZF = parama;
    AppMethodBeat.o(74905);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(74907);
    Assert.assertNotNull(this.QZF);
    this.QZF.remove(this);
    AppMethodBeat.o(74907);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74906);
    if ((paramObject != null) && (paramObject.hashCode() == this.QZH))
    {
      AppMethodBeat.o(74906);
      return true;
    }
    AppMethodBeat.o(74906);
    return false;
  }
  
  public final int hashCode()
  {
    return this.QZH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */