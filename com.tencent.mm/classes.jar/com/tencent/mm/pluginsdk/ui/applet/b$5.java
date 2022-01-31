package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$5
  implements q.a
{
  b$5(b paramb) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(27628);
    ab.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
    this.vTc.kw(-1);
    AppMethodBeat.o(27628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b.5
 * JD-Core Version:    0.7.0.1
 */