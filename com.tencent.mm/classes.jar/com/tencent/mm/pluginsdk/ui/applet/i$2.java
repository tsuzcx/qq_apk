package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class i$2
  implements k.b
{
  i$2(i parami) {}
  
  public final boolean iz(int paramInt)
  {
    AppMethodBeat.i(79732);
    if ((!this.vTI.vTA.vTS) || (!this.vTI.vTA.Ma(paramInt)))
    {
      AppMethodBeat.o(79732);
      return true;
    }
    if (!this.vTI.vTA.LY(paramInt)) {
      ab.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(79732);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i.2
 * JD-Core Version:    0.7.0.1
 */