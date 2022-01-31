package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
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
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 2);
    localIntent.putExtra("key_fav_item_id", parame.biV.getLong("fav_local_id", -1L));
    d.b(paramContext, "favorite", ".ui.FavTagEditUI", localIntent);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    boolean bool1 = parame.biV.getBoolean("is_favorite_item", false);
    boolean bool2 = parame.biV.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paraml.a(12, paramContext.getString(R.l.favorite_add_tag_tips), R.k.bottomsheet_icon_addtag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */