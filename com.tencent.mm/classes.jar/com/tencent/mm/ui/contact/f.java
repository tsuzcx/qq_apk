package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;

public final class f
{
  public am contact;
  public at conversation;
  
  public f()
  {
    AppMethodBeat.i(102820);
    this.contact = new am();
    this.conversation = new at();
    AppMethodBeat.o(102820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.f
 * JD-Core Version:    0.7.0.1
 */