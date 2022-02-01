package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;

public final class e
  extends a
{
  public e()
  {
    super(12);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78689);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 2);
    localIntent.putExtra("key_fav_item_id", paramg.mParams.getLong("fav_local_id", -1L));
    b.b(paramContext, ".ui.FavTagEditUI", localIntent);
    h.CyF.dN(982, 1);
    AppMethodBeat.o(78689);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78688);
    boolean bool1 = paramg.mParams.getBoolean("is_favorite_item", false);
    boolean bool2 = paramg.mParams.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paramm.b(12, paramContext.getString(2131759169), 2131689805);
    }
    AppMethodBeat.o(78688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */