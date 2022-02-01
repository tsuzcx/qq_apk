package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.story.api.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.f;
import com.tencent.mm.storagebase.a.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class a$4
  implements Runnable
{
  a$4(a parama, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(210141);
    az.ayM();
    Cursor localCursor = c.awB().a(this.IsF.Isk, this.IsF.Isl, this.IsF.fzw, this.Kgt, a.g(this.IsF), a.h(this.IsF));
    if (localCursor != null)
    {
      try
      {
        if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
          break label214;
        }
        ArrayList localArrayList = new ArrayList();
        d locald = ((com.tencent.mm.storagebase.a.e)localCursor).Hcf[0];
        int i = locald.getPosition();
        if (locald != null)
        {
          while (locald.moveToNext())
          {
            f localf = new f();
            localf.convertFrom(locald);
            localArrayList.add(localf.field_username);
            ac.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
          }
          locald.moveToPosition(i);
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(210141);
      }
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().fZ(localList);
    }
    label214:
    if (localCursor != null)
    {
      localCursor.close();
      AppMethodBeat.o(210141);
      return;
    }
    AppMethodBeat.o(210141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.4
 * JD-Core Version:    0.7.0.1
 */