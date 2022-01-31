package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.protobuf.adg;
import java.util.Comparator;

final class b$a
  implements Comparator
{
  b$a(b paramb) {}
  
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (adg)paramObject1;
    paramObject2 = (adg)paramObject2;
    if (paramObject1.wVO - paramObject2.wVO > 0L) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b.a
 * JD-Core Version:    0.7.0.1
 */