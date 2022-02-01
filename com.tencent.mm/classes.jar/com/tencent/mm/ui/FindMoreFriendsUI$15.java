package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.websearch.api.ar.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$15
  implements Runnable
{
  FindMoreFriendsUI$15(FindMoreFriendsUI paramFindMoreFriendsUI, IconPreference paramIconPreference, ar.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(33038);
    if (this.tYu == null)
    {
      AppMethodBeat.o(33038);
      return;
    }
    FindMoreFriendsUI.ef("find_friends_by_search", false);
    a locala = (a)this.tYu;
    if ((this.adyG != null) && (this.adyG.isValid()) && (this.adyG.type > 0) && (this.adyG.type <= 4)) {}
    for (boolean bool = true; locala.ym(bool); bool = false)
    {
      AppMethodBeat.o(33038);
      return;
    }
    this.tYu.afx(8);
    if (this.adyG == null)
    {
      this.tYu.aeD(8);
      AppMethodBeat.o(33038);
      return;
    }
    if (this.adyG.isValid())
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[] { this.tYu.getTitle() });
      switch (this.adyG.type)
      {
      default: 
        Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(this.adyG.type) });
      }
    }
    for (;;)
    {
      FindMoreFriendsUI.ef("find_friends_by_search", this.adyG.isValid());
      FindMoreFriendsUI.a(this.adyF).notifyDataSetChanged();
      AppMethodBeat.o(33038);
      return;
      this.tYu.aeD(0);
      this.tYu.aBf(8);
      locala.a(k.MsK, true);
      continue;
      this.tYu.aeD(8);
      this.tYu.aBf(0);
      this.tYu.bd(this.adyG.text, -1, Color.parseColor("#8c8c8c"));
      this.tYu.LF(true);
      this.tYu.aBi(8);
      locala.a(k.MsM, true);
      continue;
      this.tYu.aBi(0);
      this.tYu.aBh(0);
      this.tYu.aBj(0);
      this.tYu.LF(false);
      r.bJZ();
      Bitmap localBitmap = e.Eo(this.adyG.icon);
      if (localBitmap != null)
      {
        FindMoreFriendsUI.c(this.adyF, null);
        this.tYu.bd(localBitmap);
      }
      for (;;)
      {
        locala.a(k.MsN, true);
        break;
        r.bKd().a(this.adyG.icon, this.adyF.MrK);
        FindMoreFriendsUI.c(this.adyF, this.adyG.icon);
      }
      this.tYu.aBi(0);
      this.tYu.aBh(0);
      this.tYu.aBj(0);
      this.tYu.aBf(0);
      this.tYu.LF(false);
      this.tYu.bd(this.adyG.text, -1, Color.parseColor("#8c8c8c"));
      r.bJZ();
      localBitmap = e.Eo(this.adyG.icon);
      if (localBitmap != null)
      {
        FindMoreFriendsUI.c(this.adyF, null);
        this.tYu.bd(localBitmap);
      }
      for (;;)
      {
        locala.a(k.MsO, true);
        break;
        r.bKd().a(this.adyG.icon, this.adyF.MrK);
        FindMoreFriendsUI.c(this.adyF, this.adyG.icon);
      }
      Log.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[] { this.tYu.getTitle() });
      this.tYu.aeD(8);
      this.tYu.aBf(8);
      this.tYu.aBi(8);
      this.tYu.aBq(0);
      if ((this.tYu instanceof NormalIconNewTipPreference)) {
        g.a((NormalIconNewTipPreference)this.tYu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.15
 * JD-Core Version:    0.7.0.1
 */