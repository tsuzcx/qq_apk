package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(26714);
    ab.i("MicroMsg.Note.NoteDataManager", "NoteDataManager onDestroy");
    this.vyj.dio();
    c.a(this.vyj);
    c.b(this.vyj);
    c.c(this.vyj);
    c.diA();
    AppMethodBeat.o(26714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1
 * JD-Core Version:    0.7.0.1
 */