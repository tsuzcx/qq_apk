package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.x;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=x.class)
public class aa
  extends a
  implements x
{
  private List<Long> Pql;
  
  public aa()
  {
    AppMethodBeat.i(233104);
    this.Pql = new ArrayList();
    AppMethodBeat.o(233104);
  }
  
  public final void Nx(long paramLong)
  {
    AppMethodBeat.i(233106);
    if (!this.Pql.contains(Long.valueOf(paramLong))) {
      this.Pql.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(233106);
  }
  
  public final boolean cd(ca paramca)
  {
    AppMethodBeat.i(233107);
    if ((paramca != null) && (paramca.field_solitaireFoldInfo != null))
    {
      if (this.Pql.contains(Long.valueOf(paramca.field_msgId)))
      {
        AppMethodBeat.o(233107);
        return false;
      }
      AppMethodBeat.o(233107);
      return true;
    }
    AppMethodBeat.o(233107);
    return false;
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(233105);
    super.gIn();
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.Pql.clear();
    AppMethodBeat.o(233105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aa
 * JD-Core Version:    0.7.0.1
 */