package com.tencent.mm.ui.chatting.l.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

final class c$a
  implements Runnable
{
  private String username;
  private View view;
  private long zQt;
  private long zQu;
  WeakReference<MMChattingListView> zQv;
  
  private c$a(c paramc, MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(32723);
    this.view = paramMMChattingListView;
    this.username = paramString;
    this.zQv = new WeakReference(paramMMChattingListView);
    this.zQt = paramLong2;
    this.zQu = paramLong1;
    AppMethodBeat.o(32723);
  }
  
  public final void run()
  {
    AppMethodBeat.i(32724);
    Object localObject = ((j)g.E(j.class)).bPL();
    int k = ((j)g.E(j.class)).bPQ().z(this.username, 0L, this.zQu - 1L);
    if (k <= 0) {}
    for (int i = ((b)localObject).v(this.username, 0L, this.zQu - 1L);; i = 0)
    {
      boolean bool3;
      int m;
      if ((k <= 0) && (i <= 0))
      {
        bool3 = true;
        m = ((j)g.E(j.class)).bPQ().z(this.username, this.zQt + 1L, 9223372036854775807L);
        if (m > 0) {
          break label300;
        }
      }
      label156:
      label294:
      label300:
      for (int j = ((b)localObject).v(this.username, this.zQt + 1L, 9223372036854775807L);; j = 0)
      {
        boolean bool1;
        if ((m <= 0) && (j <= 0))
        {
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            localObject = ((b)localObject).SY(this.username);
            if (((w)localObject).field_lastLocalSeq != ((w)localObject).field_lastPushSeq) {
              break label294;
            }
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
          this.view.postDelayed(new c.a.1(this, bool3, bool2), 60L);
          AppMethodBeat.o(32724);
          return;
          bool3 = false;
          break;
          bool1 = false;
          break label156;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.c.a
 * JD-Core Version:    0.7.0.1
 */