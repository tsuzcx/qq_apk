package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.q.g;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class h$d
  implements q.g
{
  h$d(h paramh, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONObject paramJSONObject3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(234037);
    p.j(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(234037);
      return;
      ClipboardHelper.setText((CharSequence)this.Gjc.toString());
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(234037);
      return;
      ClipboardHelper.setText((CharSequence)this.Gjd.toString());
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(234037);
      return;
      ClipboardHelper.setText((CharSequence)this.Gje.toString());
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(234037);
      return;
      ClipboardHelper.setText((CharSequence)this.Gjf.toString());
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(234037);
      return;
      ClipboardHelper.setText((CharSequence)this.Gjg.toString());
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_copy_ok, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h.d
 * JD-Core Version:    0.7.0.1
 */