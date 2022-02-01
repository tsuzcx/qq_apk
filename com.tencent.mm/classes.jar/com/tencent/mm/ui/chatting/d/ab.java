package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.x;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=x.class)
public class ab
  extends a
  implements x
{
  private List<Long> WKH;
  
  public ab()
  {
    AppMethodBeat.i(286765);
    this.WKH = new ArrayList();
    AppMethodBeat.o(286765);
  }
  
  public final void VJ(long paramLong)
  {
    AppMethodBeat.i(286767);
    if (!this.WKH.contains(Long.valueOf(paramLong))) {
      this.WKH.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(286767);
  }
  
  public final boolean cx(ca paramca)
  {
    AppMethodBeat.i(286768);
    if ((paramca != null) && (paramca.field_solitaireFoldInfo != null))
    {
      if (this.WKH.contains(Long.valueOf(paramca.field_msgId)))
      {
        AppMethodBeat.o(286768);
        return false;
      }
      AppMethodBeat.o(286768);
      return true;
    }
    AppMethodBeat.o(286768);
    return false;
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(286766);
    super.hGZ();
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.WKH.clear();
    AppMethodBeat.o(286766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ab
 * JD-Core Version:    0.7.0.1
 */