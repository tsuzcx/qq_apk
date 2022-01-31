package com.tencent.mm.plugin.sns.ui.e;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(40414);
    int i = 0;
    while (i < a.cxp().size())
    {
      Object localObject = (Set)((HashMap)a.cxp().valueAt(i)).get(this.efI);
      if ((localObject == null) || (((Set)localObject).size() == 0))
      {
        AppMethodBeat.o(40414);
        return;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        l locall = (l)((WeakReference)((Iterator)localObject).next()).get();
        if (locall != null) {
          locall.bx(this.efI, this.slQ);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(40414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.e.a.1.1
 * JD-Core Version:    0.7.0.1
 */