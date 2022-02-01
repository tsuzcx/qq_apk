package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class RecordPluginLayout$d
  implements DialogInterface.OnClickListener
{
  RecordPluginLayout$d(RecordPluginLayout paramRecordPluginLayout) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(237407);
    paramDialogInterface.dismiss();
    RecordPluginLayout.b(this.BXg);
    paramDialogInterface = this.BXg.getContext();
    if (paramDialogInterface == null)
    {
      paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(237407);
      throw paramDialogInterface;
    }
    paramDialogInterface = (Activity)paramDialogInterface;
    Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(237407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.d
 * JD-Core Version:    0.7.0.1
 */