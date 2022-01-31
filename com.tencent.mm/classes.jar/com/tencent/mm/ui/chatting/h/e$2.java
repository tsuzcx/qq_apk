package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

final class e$2
  implements Runnable
{
  e$2(e parame, List paramList) {}
  
  public final void run()
  {
    int i = e.eg(this.gFL);
    if (this.gFL.size() == i) {
      e.d(this.vyV).post(new e.2.1(this));
    }
    do
    {
      return;
      Object localObject1 = this.vyV;
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        e.a((e)localObject1, bool);
        localObject2 = e.b(this.vyV, this.gFL);
        localObject1 = e.c(this.vyV, this.gFL);
        y.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
        e.a(this.vyV, ((List)localObject2).size() + ((List)localObject1).size());
        if ((aq.isWifi(ae.getContext())) || (e.e(this.vyV) != this.gFL.size())) {
          break;
        }
        e.d(this.vyV).post(new e.2.2(this));
        return;
      }
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bi localbi = (bi)((Iterator)localObject2).next();
        e.a(this.vyV, localbi, com.tencent.mm.ui.chatting.gallery.e.bt(localbi));
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bi)((Iterator)localObject1).next();
        e.a(this.vyV, (bi)localObject2);
      }
      if (e.f(this.vyV)) {
        e.d(this.vyV).post(new e.2.3(this));
      }
    } while ((!e.g(this.vyV)) || (e.f(this.vyV)));
    e.d(this.vyV).post(new e.2.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.2
 * JD-Core Version:    0.7.0.1
 */