package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;

final class e$10
  implements b.b
{
  e$10(e parame) {}
  
  public final void a(boolean paramBoolean, b.c paramc, int paramInt)
  {
    AppMethodBeat.i(32570);
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if ((paramBoolean) && (h.a.dKg().mCl.size() >= 9))
    {
      Toast.makeText(e.b(this.zPs), e.b(this.zPs).getResources().getString(2131300308, new Object[] { Integer.valueOf(9) }), 1).show();
      this.zPs.zPp.bR(paramInt);
      AppMethodBeat.o(32570);
      return;
    }
    if (paramBoolean) {
      h.a.dKg().bD(paramc.cEE);
    }
    for (;;)
    {
      e.c(this.zPs).wa(h.a.dKg().mCl.size());
      AppMethodBeat.o(32570);
      return;
      h.a.dKg().bE(paramc.cEE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.10
 * JD-Core Version:    0.7.0.1
 */