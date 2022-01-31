package com.tencent.mm.plugin.translate;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.az;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void a(int paramInt, SparseArray<c.c> paramSparseArray)
  {
    AppMethodBeat.i(26049);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      c.c localc = (c.c)paramSparseArray.valueAt(i);
      if (localc != null) {
        this.toK.toG.e(new a.1.1(this, paramInt, localc));
      }
      i += 1;
    }
    AppMethodBeat.o(26049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.1
 * JD-Core Version:    0.7.0.1
 */