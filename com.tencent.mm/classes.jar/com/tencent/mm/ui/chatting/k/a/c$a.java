package com.tencent.mm.ui.chatting.k.a;

import android.view.View;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

final class c$a
  implements Runnable
{
  private String username;
  private View view;
  private long vzW;
  private long vzX;
  WeakReference<MMChattingListView> vzY;
  
  private c$a(c paramc, MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
  {
    this.view = paramMMChattingListView;
    this.username = paramString;
    this.vzY = new WeakReference(paramMMChattingListView);
    this.vzW = paramLong2;
    this.vzX = paramLong1;
  }
  
  public final void run()
  {
    Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
    int k = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().r(this.username, 0L, this.vzX - 1L);
    if (k <= 0) {}
    for (int i = ((b)localObject).o(this.username, 0L, this.vzX - 1L);; i = 0)
    {
      boolean bool3;
      int m;
      if ((k <= 0) && (i <= 0))
      {
        bool3 = true;
        m = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().r(this.username, this.vzW + 1L, 9223372036854775807L);
        if (m > 0) {
          break label288;
        }
      }
      label150:
      label282:
      label288:
      for (int j = ((b)localObject).o(this.username, this.vzW + 1L, 9223372036854775807L);; j = 0)
      {
        boolean bool1;
        if ((m <= 0) && (j <= 0))
        {
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            localObject = ((b)localObject).Hm(this.username);
            if (((w)localObject).field_lastLocalSeq != ((w)localObject).field_lastPushSeq) {
              break label282;
            }
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
          this.view.postDelayed(new c.a.1(this, bool3, bool2), 60L);
          return;
          bool3 = false;
          break;
          bool1 = false;
          break label150;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.c.a
 * JD-Core Version:    0.7.0.1
 */