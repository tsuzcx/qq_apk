package com.tencent.mm.ui.conversation;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.al;

final class h$10
  implements ViewTreeObserver.OnPreDrawListener
{
  h$10(h paramh, h.f paramf) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153999);
    this.Akp.egq.getViewTreeObserver().removeOnPreDrawListener(this);
    int i = this.Akp.egq.getWidth();
    int j = al.ap(h.g(this.Akm), 2131427800);
    if (i != j)
    {
      ab.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Akp.egq.getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = j;
      this.Akp.egq.setLayoutParams(localLayoutParams);
      ab.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.Akp.egq.getWidth()) });
      if (!h.h(this.Akm))
      {
        e.qrI.idkeyStat(1055L, 4L, 1L, false);
        ab.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
        h.i(this.Akm);
      }
    }
    AppMethodBeat.o(153999);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.10
 * JD-Core Version:    0.7.0.1
 */