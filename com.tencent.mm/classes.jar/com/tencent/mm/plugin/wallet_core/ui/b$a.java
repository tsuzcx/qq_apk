package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.j;

public final class b$a
{
  public String ppn;
  public j umL;
  public double umM;
  public String umN;
  
  public final String toString()
  {
    AppMethodBeat.i(47098);
    Object localObject = new StringBuffer();
    if (this.umL != null) {
      ((StringBuffer)localObject).append("|faovrComposeId: " + this.umL.tUv);
    }
    ((StringBuffer)localObject).append("|bankName: " + this.ppn);
    ((StringBuffer)localObject).append("|bankFavorAmount: " + this.umM);
    ((StringBuffer)localObject).append("|bankType: " + this.umN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(47098);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b.a
 * JD-Core Version:    0.7.0.1
 */