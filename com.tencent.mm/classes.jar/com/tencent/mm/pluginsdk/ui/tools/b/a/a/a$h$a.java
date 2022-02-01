package com.tencent.mm.pluginsdk.ui.tools.b.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1$onClick$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$h$a
  implements DialogInterface.OnClickListener
{
  a$h$a(View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(245855);
    s.u(paramDialogInterface, "dialog");
    if ((this.$v instanceof MMNumberCheckbox)) {
      ((MMNumberCheckbox)this.$v).setChecked(false);
    }
    AppMethodBeat.o(245855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.h.a
 * JD-Core Version:    0.7.0.1
 */