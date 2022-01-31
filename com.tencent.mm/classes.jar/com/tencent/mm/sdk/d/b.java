package com.tencent.mm.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Serializable;

public class b
  extends c
  implements Serializable
{
  public final String name;
  
  public b()
  {
    AppMethodBeat.i(52444);
    this.name = getClass().getSimpleName();
    AppMethodBeat.o(52444);
  }
  
  public void enter()
  {
    AppMethodBeat.i(52445);
    super.enter();
    ab.i("LogStateTransitionState", "entering " + this.name);
    AppMethodBeat.o(52445);
  }
  
  public void exit()
  {
    AppMethodBeat.i(52446);
    super.exit();
    ab.i("LogStateTransitionState", "exiting " + this.name);
    AppMethodBeat.o(52446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */