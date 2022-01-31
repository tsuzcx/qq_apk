package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.l;

public final class c
  extends a
{
  public c()
  {
    super(12);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6425);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 2);
    localIntent.putExtra("key_fav_item_id", parame.bzu.getLong("fav_local_id", -1L));
    b.b(paramContext, ".ui.FavTagEditUI", localIntent);
    h.qsU.cT(982, 1);
    AppMethodBeat.o(6425);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6424);
    boolean bool1 = parame.bzu.getBoolean("is_favorite_item", false);
    boolean bool2 = parame.bzu.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paraml.a(12, paramContext.getString(2131299681), 2131231001);
    }
    AppMethodBeat.o(6424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */