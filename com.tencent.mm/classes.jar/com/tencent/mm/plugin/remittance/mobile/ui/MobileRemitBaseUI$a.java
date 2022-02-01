package com.tencent.mm.plugin.remittance.mobile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum MobileRemitBaseUI$a
{
  static
  {
    AppMethodBeat.i(67680);
    wHQ = new a("ACTIVITY_INIT", 0);
    wHR = new a("ACTIVITY_RESUME", 1);
    wHS = new a("ACTIVITY_PAUSE", 2);
    wHT = new a[] { wHQ, wHR, wHS };
    AppMethodBeat.o(67680);
  }
  
  private MobileRemitBaseUI$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI.a
 * JD-Core Version:    0.7.0.1
 */