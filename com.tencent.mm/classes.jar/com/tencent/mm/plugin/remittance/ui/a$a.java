package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.yz;
import java.util.Comparator;

final class a$a
  implements Comparator
{
  a$a(a parama) {}
  
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (yz)paramObject1;
    paramObject2 = (yz)paramObject2;
    if (paramObject1.sXP - paramObject2.sXP > 0L) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.a.a
 * JD-Core Version:    0.7.0.1
 */