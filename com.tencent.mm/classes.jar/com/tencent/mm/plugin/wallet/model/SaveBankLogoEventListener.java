package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vu;
import com.tencent.mm.sdk.event.IListener;

public class SaveBankLogoEventListener
  extends IListener<vu>
{
  public SaveBankLogoEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160863);
    this.__eventId = vu.class.getName().hashCode();
    AppMethodBeat.o(160863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.SaveBankLogoEventListener
 * JD-Core Version:    0.7.0.1
 */