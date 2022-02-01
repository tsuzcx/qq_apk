package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.t;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=t.class)
public class w
  extends a
  implements t
{
  private List<Long> Gvj;
  
  public w()
  {
    AppMethodBeat.i(191518);
    this.Gvj = new ArrayList();
    AppMethodBeat.o(191518);
  }
  
  public final boolean bG(bl parambl)
  {
    AppMethodBeat.i(191521);
    if ((parambl != null) && (parambl.field_solitaireFoldInfo != null))
    {
      if (this.Gvj.contains(Long.valueOf(parambl.field_msgId)))
      {
        AppMethodBeat.o(191521);
        return false;
      }
      AppMethodBeat.o(191521);
      return true;
    }
    AppMethodBeat.o(191521);
    return false;
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(191519);
    super.eQF();
    ad.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.Gvj.clear();
    AppMethodBeat.o(191519);
  }
  
  public final void wD(long paramLong)
  {
    AppMethodBeat.i(191520);
    if (!this.Gvj.contains(Long.valueOf(paramLong))) {
      this.Gvj.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(191520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.w
 * JD-Core Version:    0.7.0.1
 */