package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.ui.base.l;

public final class e
  extends a
{
  public e()
  {
    super(12);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78689);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 2);
    localIntent.putExtra("key_fav_item_id", paramf.mParams.getLong("fav_local_id", -1L));
    b.b(paramContext, ".ui.FavTagEditUI", localIntent);
    h.wUl.dB(982, 1);
    AppMethodBeat.o(78689);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78688);
    boolean bool1 = paramf.mParams.getBoolean("is_favorite_item", false);
    boolean bool2 = paramf.mParams.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paraml.a(12, paramContext.getString(2131758846), 2131689794);
    }
    AppMethodBeat.o(78688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */