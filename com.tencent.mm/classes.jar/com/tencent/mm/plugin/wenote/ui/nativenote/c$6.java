package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ae;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30817);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    ae.i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Z(-1, false);
    Intent localIntent = new Intent();
    localIntent.putExtra("max_select_count", 9);
    localIntent.putExtra("query_source_type", 13);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("show_header_view", true);
    localIntent.putExtra("send_btn_string", this.val$context.getString(2131758845));
    localObject = (SightParams)localIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new SightParams(4, 0);
    }
    localObject = "micromsg_" + System.currentTimeMillis();
    String str1 = com.tencent.mm.loader.j.b.asv() + (String)localObject + ".mp4";
    String str2 = com.tencent.mm.loader.j.b.asv() + (String)localObject + ".jpeg";
    int i = localIntent.getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(4, 1);
    localSightParams.vYF = 2;
    localSightParams.mode = 0;
    if (localSightParams.hxV == null) {
      localSightParams.hxV = new VideoTransPara();
    }
    localSightParams.hxV.duration = i;
    localSightParams.r((String)localObject, str1, str2, com.tencent.mm.loader.j.b.asv() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    localIntent.putExtra("KEY_SIGHT_PARAMS", paramView);
    localIntent.putExtra("record_video_force_sys_camera", false);
    localIntent.putExtra("record_video_is_sight_capture", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_can_select_video_and_pic", true);
    d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", localIntent, 4097);
    a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.6
 * JD-Core Version:    0.7.0.1
 */