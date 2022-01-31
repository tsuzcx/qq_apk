package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements c.a
{
  byte[] gbJ;
  
  a$2(a parama) {}
  
  public final void CO()
  {
    AppMethodBeat.i(155196);
    ab.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(155196);
  }
  
  public final void amM()
  {
    AppMethodBeat.i(155195);
    int i = e.cM(a.cKX());
    ab.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
    if ((i > 0) && (a.c(this.tpj) != null))
    {
      ab.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
      a.c(this.tpj).mt(i);
    }
    AppMethodBeat.o(155195);
  }
  
  public final void amN()
  {
    AppMethodBeat.i(155194);
    ab.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
    if (a.c(this.tpj) != null)
    {
      ab.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
      a.c(this.tpj).amR();
    }
    if ((a.b(this.tpj) != null) && (!a.b(this.tpj).Fc())) {
      a.error(1);
    }
    AppMethodBeat.o(155194);
  }
  
  public final void c(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(155193);
    if (paramArrayOfShort == null)
    {
      AppMethodBeat.o(155193);
      return;
    }
    if ((this.gbJ == null) || (this.gbJ.length < paramInt * 2)) {
      this.gbJ = new byte[paramInt * 2];
    }
    int i = 0;
    while (i < paramInt)
    {
      this.gbJ[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
      this.gbJ[(i * 2 + 1)] = ((byte)((paramArrayOfShort[i] & 0xFF00) >> 8));
      i += 1;
    }
    if (a.b(this.tpj) != null) {}
    for (paramInt = a.b(this.tpj).a(new g.a(this.gbJ, paramInt * 2), 0, true);; paramInt = -1)
    {
      if (-1 == paramInt)
      {
        a.error(2);
        ab.e("MicroMsg.CutShortSentence", "write to file failed");
      }
      AppMethodBeat.o(155193);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a.2
 * JD-Core Version:    0.7.0.1
 */