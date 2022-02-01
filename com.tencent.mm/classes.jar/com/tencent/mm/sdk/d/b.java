package com.tencent.mm.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.Serializable;

public class b
  extends c
  implements Serializable
{
  public final String name;
  
  public b()
  {
    AppMethodBeat.i(158007);
    this.name = getClass().getSimpleName();
    AppMethodBeat.o(158007);
  }
  
  public void enter()
  {
    AppMethodBeat.i(158008);
    super.enter();
    ad.i("LogStateTransitionState", "entering " + this.name);
    AppMethodBeat.o(158008);
  }
  
  public void exit()
  {
    AppMethodBeat.i(158009);
    super.exit();
    ad.i("LogStateTransitionState", "exiting " + this.name);
    AppMethodBeat.o(158009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */