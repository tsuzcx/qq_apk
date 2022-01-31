package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

final class e$2
  implements Runnable
{
  e$2(e parame, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(32557);
    int i = e.fq(this.ieO);
    if (this.ieO.size() == i)
    {
      e.d(this.zPs).post(new e.2.1(this));
      AppMethodBeat.o(32557);
      return;
    }
    Object localObject1 = this.zPs;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      e.a((e)localObject1, bool);
      localObject2 = e.b(this.zPs, this.ieO);
      localObject1 = e.c(this.zPs, this.ieO);
      ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
      e.a(this.zPs, ((List)localObject2).size() + ((List)localObject1).size());
      if ((at.isWifi(ah.getContext())) || (e.e(this.zPs) != this.ieO.size())) {
        break;
      }
      e.d(this.zPs).post(new e.2.2(this));
      AppMethodBeat.o(32557);
      return;
    }
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bi localbi = (bi)((Iterator)localObject2).next();
      e.a(this.zPs, localbi, com.tencent.mm.ui.chatting.gallery.e.d(localbi));
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bi)((Iterator)localObject1).next();
      e.a(this.zPs, (bi)localObject2);
    }
    if (e.f(this.zPs)) {
      e.d(this.zPs).post(new e.2.3(this));
    }
    if ((e.g(this.zPs)) && (!e.f(this.zPs))) {
      e.d(this.zPs).post(new e.2.4(this));
    }
    AppMethodBeat.o(32557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.2
 * JD-Core Version:    0.7.0.1
 */