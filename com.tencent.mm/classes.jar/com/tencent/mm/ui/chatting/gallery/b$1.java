package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(List paramList, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(35876);
    boolean bool1;
    int i;
    label33:
    bo localbo;
    boolean bool2;
    if (this.Iai.size() <= 1)
    {
      bool1 = true;
      Iterator localIterator = this.Iai.iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label106;
      }
      localbo = (bo)localIterator.next();
      if (!b.m(localbo)) {
        break label92;
      }
      bool2 = b.b(this.val$context, localbo, bool1);
      label74:
      if ((i != 0) || (!bool2)) {
        break label184;
      }
      i = 1;
    }
    label184:
    for (;;)
    {
      break label33;
      bool1 = false;
      break;
      label92:
      bool2 = b.d(this.val$context, localbo, bool1);
      break label74;
      label106:
      if ((i == 0) && (!bool1))
      {
        Toast.makeText(this.val$context, this.val$context.getString(2131762780), 1).show();
        AppMethodBeat.o(35876);
        return;
      }
      if ((i != 0) && (!bool1)) {
        Toast.makeText(this.val$context, this.val$context.getString(2131758631, new Object[] { com.tencent.mm.loader.j.b.aps() }), 1).show();
      }
      AppMethodBeat.o(35876);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.1
 * JD-Core Version:    0.7.0.1
 */