package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ak;

final class b$1
  extends n.a
{
  b$1(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(25756);
    if (paramInt != 4)
    {
      AppMethodBeat.o(25756);
      return;
    }
    new ak(Looper.getMainLooper()).post(new b.1.1(this));
    AppMethodBeat.o(25756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b.1
 * JD-Core Version:    0.7.0.1
 */