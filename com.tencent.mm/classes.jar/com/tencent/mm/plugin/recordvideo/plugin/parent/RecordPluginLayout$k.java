package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RecordPluginLayout$k
  implements View.OnClickListener
{
  RecordPluginLayout$k(RecordPluginLayout paramRecordPluginLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(237411);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    RecordPluginLayout.b(this.BXg);
    paramView = this.BXg.getContext();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(237411);
      throw paramView;
    }
    paramView = (Activity)paramView;
    localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(237411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.k
 * JD-Core Version:    0.7.0.1
 */