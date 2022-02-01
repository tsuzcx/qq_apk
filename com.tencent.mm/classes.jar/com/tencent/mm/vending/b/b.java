package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private a YzV;
  public _Callback YzW;
  private int YzX;
  private int mPriority;
  public d mScheduler;
  
  public b(_Callback param_Callback, a parama)
  {
    AppMethodBeat.i(74905);
    this.mPriority = -1;
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.YzX = param_Callback.hashCode();
    this.YzW = param_Callback;
    this.YzV = parama;
    AppMethodBeat.o(74905);
  }
  
  public void dead()
  {
    AppMethodBeat.i(74907);
    Assert.assertNotNull(this.YzV);
    this.YzV.remove(this);
    AppMethodBeat.o(74907);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74906);
    if ((paramObject != null) && (paramObject.hashCode() == this.YzX))
    {
      AppMethodBeat.o(74906);
      return true;
    }
    AppMethodBeat.o(74906);
    return false;
  }
  
  public int hashCode()
  {
    return this.YzX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */