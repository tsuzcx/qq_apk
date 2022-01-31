package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.d.a.b;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;

final class e$10
  implements b.b
{
  e$10(e parame) {}
  
  public final void a(boolean paramBoolean, b.c paramc, int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if ((paramBoolean) && (h.a.cGc().khB.size() >= 9))
    {
      Toast.makeText(e.b(this.vyV), e.b(this.vyV).getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
      this.vyV.vyS.bL(paramInt);
      return;
    }
    if (paramBoolean) {
      h.a.cGc().bv(paramc.bWO);
    }
    for (;;)
    {
      e.c(this.vyV).re(h.a.cGc().khB.size());
      return;
      h.a.cGc().bw(paramc.bWO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.10
 * JD-Core Version:    0.7.0.1
 */