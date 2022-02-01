package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.t;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=t.class)
public class w
  extends a
  implements t
{
  private List<Long> HVa;
  
  public w()
  {
    AppMethodBeat.i(196475);
    this.HVa = new ArrayList();
    AppMethodBeat.o(196475);
  }
  
  public final void Bg(long paramLong)
  {
    AppMethodBeat.i(196477);
    if (!this.HVa.contains(Long.valueOf(paramLong))) {
      this.HVa.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(196477);
  }
  
  public final boolean bI(bo parambo)
  {
    AppMethodBeat.i(196478);
    if ((parambo != null) && (parambo.field_solitaireFoldInfo != null))
    {
      if (this.HVa.contains(Long.valueOf(parambo.field_msgId)))
      {
        AppMethodBeat.o(196478);
        return false;
      }
      AppMethodBeat.o(196478);
      return true;
    }
    AppMethodBeat.o(196478);
    return false;
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(196476);
    super.fgl();
    ac.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.HVa.clear();
    AppMethodBeat.o(196476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.w
 * JD-Core Version:    0.7.0.1
 */