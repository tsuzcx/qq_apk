package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.o.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
public final class MusicMvDebugUIC$d
  implements o.g
{
  public MusicMvDebugUIC$d(MusicMvDebugUIC paramMusicMvDebugUIC, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(258903);
    p.g(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(258903);
      return;
      ClipboardHelper.setText((CharSequence)this.Urb);
      Toast.makeText((Context)this.Atu.getActivity(), 2131755773, 0).show();
      AppMethodBeat.o(258903);
      return;
      ClipboardHelper.setText((CharSequence)this.Urc);
      Toast.makeText((Context)this.Atu.getActivity(), 2131755773, 0).show();
      AppMethodBeat.o(258903);
      return;
      ClipboardHelper.setText((CharSequence)this.Urd);
      Toast.makeText((Context)this.Atu.getActivity(), 2131755773, 0).show();
      AppMethodBeat.o(258903);
      return;
      ClipboardHelper.setText((CharSequence)this.Ure);
      Toast.makeText((Context)this.Atu.getActivity(), 2131755773, 0).show();
      AppMethodBeat.o(258903);
      return;
      ClipboardHelper.setText((CharSequence)this.Urf);
      Toast.makeText((Context)this.Atu.getActivity(), 2131755773, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.d
 * JD-Core Version:    0.7.0.1
 */