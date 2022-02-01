package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
public final class MusicMvDebugUIC$e
  implements o.g
{
  public MusicMvDebugUIC$e(MusicMvDebugUIC paramMusicMvDebugUIC) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(258904);
    p.g(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(258904);
      return;
      paramMenuItem = g.Aku;
      s.deleteDir(g.eux());
      this.Atu.getActivity().finish();
      Toast.makeText((Context)this.Atu.getActivity(), 2131755766, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.e
 * JD-Core Version:    0.7.0.1
 */