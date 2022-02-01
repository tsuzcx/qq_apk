package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=v.class)
public class y
  extends a
  implements v
{
  private List<Long> JJy;
  
  public y()
  {
    AppMethodBeat.i(194020);
    this.JJy = new ArrayList();
    AppMethodBeat.o(194020);
  }
  
  public final void DV(long paramLong)
  {
    AppMethodBeat.i(194022);
    if (!this.JJy.contains(Long.valueOf(paramLong))) {
      this.JJy.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(194022);
  }
  
  public final boolean bO(bu parambu)
  {
    AppMethodBeat.i(194023);
    if ((parambu != null) && (parambu.field_solitaireFoldInfo != null))
    {
      if (this.JJy.contains(Long.valueOf(parambu.field_msgId)))
      {
        AppMethodBeat.o(194023);
        return false;
      }
      AppMethodBeat.o(194023);
      return true;
    }
    AppMethodBeat.o(194023);
    return false;
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(194021);
    super.fwx();
    ad.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.JJy.clear();
    AppMethodBeat.o(194021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.y
 * JD-Core Version:    0.7.0.1
 */