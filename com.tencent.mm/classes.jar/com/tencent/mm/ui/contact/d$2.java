package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b.b;

final class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public final int aqn()
  {
    AppMethodBeat.i(33562);
    int i = this.AbC.getCount();
    AppMethodBeat.o(33562);
    return i;
  }
  
  public final String mS(int paramInt)
  {
    AppMethodBeat.i(33561);
    if ((paramInt < 0) || (paramInt >= this.AbC.getCount()))
    {
      ab.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
      AppMethodBeat.o(33561);
      return null;
    }
    Object localObject = (ad)this.AbC.getItem(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(33561);
      return null;
    }
    localObject = ((aq)localObject).field_username;
    AppMethodBeat.o(33561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d.2
 * JD-Core Version:    0.7.0.1
 */