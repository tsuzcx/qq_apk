package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class h$16
  implements n.c
{
  h$16(String paramString1, List paramList1, List paramList2, String paramString2) {}
  
  public final void a(l paraml)
  {
    if (!bk.bl(this.dYK)) {
      paraml.setHeaderTitle(this.dYK);
    }
    int i = 0;
    while (i < this.oPC.size())
    {
      paraml.e(((Integer)this.oOX.get(i)).intValue(), (CharSequence)this.oPC.get(i));
      i += 1;
    }
    if (!bk.bl(this.uTZ)) {
      paraml.e(-1, this.uTZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.16
 * JD-Core Version:    0.7.0.1
 */