package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.t;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class b$b
  implements DialogInterface.OnClickListener
{
  b$b(EmojiInfo paramEmojiInfo, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(105836);
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_id", this.gnq.field_groupId);
    localIntent.putExtra("preceding_scence", 20);
    Context localContext = this.cqB;
    if (localContext == null)
    {
      paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
      AppMethodBeat.o(105836);
      throw paramDialogInterface;
    }
    d.b(((t)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
    paramDialogInterface.cancel();
    AppMethodBeat.o(105836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.b.b.b
 * JD-Core Version:    0.7.0.1
 */