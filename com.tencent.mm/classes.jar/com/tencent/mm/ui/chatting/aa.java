package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.d.a;
import java.util.List;

public final class aa
  implements bb
{
  private a hlc;
  
  public aa(a parama)
  {
    AppMethodBeat.i(34778);
    this.hlc = parama;
    AppMethodBeat.o(34778);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(cc paramcc)
  {
    AppMethodBeat.i(34779);
    if (this.hlc.cm(ad.class) == null)
    {
      Log.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((ad)this.hlc.cm(ad.class)).jrB();
    AppMethodBeat.o(34779);
  }
  
  public final void bp(List<cc> paramList)
  {
    AppMethodBeat.i(34780);
    AppMethodBeat.o(34780);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.aa
 * JD-Core Version:    0.7.0.1
 */