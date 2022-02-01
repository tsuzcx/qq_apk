package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.e.a;
import java.util.List;

public final class y
  implements ba
{
  private a dom;
  
  public y(a parama)
  {
    AppMethodBeat.i(34778);
    this.dom = parama;
    AppMethodBeat.o(34778);
  }
  
  public final void S(List<ca> paramList)
  {
    AppMethodBeat.i(34780);
    AppMethodBeat.o(34780);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(ca paramca)
  {
    AppMethodBeat.i(34779);
    if (this.dom.bh(aa.class) == null)
    {
      Log.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((aa)this.dom.bh(aa.class)).gPx();
    AppMethodBeat.o(34779);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(34784);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(34784);
    return localLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y
 * JD-Core Version:    0.7.0.1
 */