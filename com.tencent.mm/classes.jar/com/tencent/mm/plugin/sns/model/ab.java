package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ak;

public final class ab
{
  public static boolean ocf;
  public static char[] rfO;
  private ak handler;
  public boolean rfL;
  public long rfM;
  private int rfN;
  
  static
  {
    int i = 0;
    ocf = false;
    rfO = new char[36];
    int j = 48;
    while (j <= 57)
    {
      rfO[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      rfO[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public ab()
  {
    AppMethodBeat.i(36369);
    this.rfL = false;
    this.rfM = 0L;
    this.rfN = 0;
    this.handler = new ab.1(this, Looper.getMainLooper());
    AppMethodBeat.o(36369);
  }
  
  public static void b(PInt paramPInt1, PInt paramPInt2)
  {
    if (paramPInt2.value + 1 >= 36)
    {
      paramPInt2.value = 0;
      paramPInt1.value = ((paramPInt1.value + 1) % 36);
      return;
    }
    paramPInt2.value = ((paramPInt2.value + 1) % 36);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */