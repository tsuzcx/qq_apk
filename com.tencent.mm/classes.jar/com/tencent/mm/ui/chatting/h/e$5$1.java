package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.aj.a;
import com.tencent.mm.ui.chatting.d.a.b;
import java.util.ArrayList;
import java.util.List;

final class e$5$1
  implements aj
{
  e$5$1(e.5 param5) {}
  
  public final void a(aj.a parama)
  {
    if (parama == aj.a.vmw) {
      e.a(this.vyY.vyV).removeAll(this.vyY.gFL);
    }
  }
  
  public final void b(aj.a parama)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(this.vyY.gFL.size()), parama });
    if (parama == aj.a.vmw) {
      e.c(this.vyY.vyV).aRP();
    }
  }
  
  public final void cDe() {}
  
  public final boolean cDf()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.5.1
 * JD-Core Version:    0.7.0.1
 */