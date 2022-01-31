package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p;
import com.tencent.mm.plugin.websearch.api.am.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$4
  implements Runnable
{
  FindMoreFriendsUI$4(FindMoreFriendsUI paramFindMoreFriendsUI, IconPreference paramIconPreference, am.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(29210);
    if (this.yWJ == null)
    {
      AppMethodBeat.o(29210);
      return;
    }
    if (this.yWK == null)
    {
      this.yWJ.ON(8);
      AppMethodBeat.o(29210);
      return;
    }
    if (this.yWK.isValid())
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[] { this.yWJ.getTitle() });
      switch (this.yWK.type)
      {
      default: 
        ab.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(this.yWK.type) });
      }
    }
    for (;;)
    {
      FindMoreFriendsUI.a(this.yWI).notifyDataSetChanged();
      AppMethodBeat.o(29210);
      return;
      this.yWJ.ON(0);
      this.yWJ.OM(8);
      continue;
      this.yWJ.ON(8);
      this.yWJ.OM(0);
      this.yWJ.aG(this.yWK.text, -1, Color.parseColor("#8c8c8c"));
      this.yWJ.qI(true);
      this.yWJ.OQ(8);
      continue;
      this.yWJ.OQ(0);
      this.yWJ.OP(0);
      this.yWJ.OR(0);
      this.yWJ.qI(false);
      o.ahB();
      Bitmap localBitmap = c.lK(this.yWK.cDz);
      if (localBitmap != null)
      {
        FindMoreFriendsUI.a(this.yWI, null);
        this.yWJ.ap(localBitmap);
      }
      else
      {
        o.ahF().a(this.yWK.cDz, this.yWI.yWH);
        FindMoreFriendsUI.a(this.yWI, this.yWK.cDz);
        continue;
        this.yWJ.OQ(0);
        this.yWJ.OP(0);
        this.yWJ.OR(0);
        this.yWJ.OM(0);
        this.yWJ.qI(false);
        this.yWJ.aG(this.yWK.text, -1, Color.parseColor("#8c8c8c"));
        o.ahB();
        localBitmap = c.lK(this.yWK.cDz);
        if (localBitmap != null)
        {
          FindMoreFriendsUI.a(this.yWI, null);
          this.yWJ.ap(localBitmap);
        }
        else
        {
          o.ahF().a(this.yWK.cDz, this.yWI.yWH);
          FindMoreFriendsUI.a(this.yWI, this.yWK.cDz);
          continue;
          ab.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[] { this.yWJ.getTitle() });
          this.yWJ.ON(8);
          this.yWJ.OM(8);
          this.yWJ.OQ(8);
          this.yWJ.OW(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */