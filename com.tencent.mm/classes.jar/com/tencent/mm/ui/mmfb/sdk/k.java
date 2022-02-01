package com.tencent.mm.ui.mmfb.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k
{
  private final boolean afzB;
  private final boolean afzC;
  private final boolean afzD;
  private final boolean afzE;
  private final boolean afzF;
  private final boolean afzG;
  
  static
  {
    AppMethodBeat.i(250189);
    afzu = new k("NATIVE_WITH_FALLBACK", 0, true, true, true, false, true, true);
    afzv = new k("NATIVE_ONLY", 1, true, true, false, false, false, true);
    afzw = new k("KATANA_ONLY", 2, false, true, false, false, false, false);
    afzx = new k("WEB_ONLY", 3, false, false, true, false, true, false);
    afzy = new k("WEB_VIEW_ONLY", 4, false, false, true, false, false, false);
    afzz = new k("DIALOG_ONLY", 5, false, true, true, false, true, true);
    afzA = new k("DEVICE_AUTH", 6, false, false, false, true, false, false);
    afzH = new k[] { afzu, afzv, afzw, afzx, afzy, afzz, afzA };
    AppMethodBeat.o(250189);
  }
  
  private k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.afzB = paramBoolean1;
    this.afzC = paramBoolean2;
    this.afzD = paramBoolean3;
    this.afzE = paramBoolean4;
    this.afzF = paramBoolean5;
    this.afzG = paramBoolean6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.k
 * JD-Core Version:    0.7.0.1
 */