package com.tencent.mm.ui.conversation.a;

import android.view.ViewGroup;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.List;

final class l$a
  implements Runnable
{
  WeakReference<l> vUS;
  
  public final void run()
  {
    List localList1 = o.Sr().SI();
    List localList2 = o.Sr().SJ();
    Object localObject = (l)this.vUS.get();
    if (localObject == null) {
      y.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
    }
    do
    {
      return;
      y.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((l)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
    } while ((((l)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()));
    localObject = new l.c((byte)0);
    ((l.c)localObject).vUS = new WeakReference(this.vUS.get());
    ((l.c)localObject).vVb = localList1;
    ((l.c)localObject).vVc = localList2;
    ai.d((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.a
 * JD-Core Version:    0.7.0.1
 */