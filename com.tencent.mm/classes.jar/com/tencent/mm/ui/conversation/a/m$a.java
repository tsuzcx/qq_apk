package com.tencent.mm.ui.conversation.a;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.List;

final class m$a
  implements Runnable
{
  WeakReference<m> AmU;
  
  public final void run()
  {
    AppMethodBeat.i(34689);
    List localList1 = o.alE().alU();
    List localList2 = o.alE().alV();
    Object localObject = (m)this.AmU.get();
    if (localObject == null)
    {
      ab.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
      AppMethodBeat.o(34689);
      return;
    }
    ab.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((m)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
    if ((((m)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
    {
      AppMethodBeat.o(34689);
      return;
    }
    localObject = new m.c((byte)0);
    ((m.c)localObject).AmU = new WeakReference(this.AmU.get());
    ((m.c)localObject).And = localList1;
    ((m.c)localObject).Ane = localList2;
    al.d((Runnable)localObject);
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m.a
 * JD-Core Version:    0.7.0.1
 */