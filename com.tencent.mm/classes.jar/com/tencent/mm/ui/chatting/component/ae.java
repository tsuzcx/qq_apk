package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.aa;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=aa.class)
public class ae
  extends a
  implements aa
{
  private List<Long> aesL;
  
  public ae()
  {
    AppMethodBeat.i(255864);
    this.aesL = new ArrayList();
    AppMethodBeat.o(255864);
  }
  
  public final boolean cT(cc paramcc)
  {
    AppMethodBeat.i(255874);
    if ((paramcc != null) && (paramcc.field_solitaireFoldInfo != null))
    {
      if (this.aesL.contains(Long.valueOf(paramcc.field_msgId)))
      {
        AppMethodBeat.o(255874);
        return false;
      }
      AppMethodBeat.o(255874);
      return true;
    }
    AppMethodBeat.o(255874);
    return false;
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(255868);
    super.jjk();
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
    this.aesL.clear();
    AppMethodBeat.o(255868);
  }
  
  public final void zR(long paramLong)
  {
    AppMethodBeat.i(255871);
    if (!this.aesL.contains(Long.valueOf(paramLong))) {
      this.aesL.add(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(255871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ae
 * JD-Core Version:    0.7.0.1
 */