package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=v.class)
public class y
  extends a
  implements v
{
  private List<Long> Keu;
  
  public y()
  {
    AppMethodBeat.i(187334);
    this.Keu = new ArrayList();
    AppMethodBeat.o(187334);
  }
  
  public final void Eu(long paramLong)
  {
    AppMethodBeat.i(187336);
    if (!this.Keu.contains(Long.valueOf(paramLong))) {
      this.Keu.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(187336);
  }
  
  public final boolean bN(bv parambv)
  {
    AppMethodBeat.i(187337);
    if ((parambv != null) && (parambv.field_solitaireFoldInfo != null))
    {
      if (this.Keu.contains(Long.valueOf(parambv.field_msgId)))
      {
        AppMethodBeat.o(187337);
        return false;
      }
      AppMethodBeat.o(187337);
      return true;
    }
    AppMethodBeat.o(187337);
    return false;
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(187335);
    super.fAx();
    ae.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.Keu.clear();
    AppMethodBeat.o(187335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.y
 * JD-Core Version:    0.7.0.1
 */