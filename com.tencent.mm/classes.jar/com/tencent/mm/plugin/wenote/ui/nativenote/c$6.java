package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ac;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30817);
    ac.i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().X(-1, false);
    Intent localIntent = new Intent();
    localIntent.putExtra("max_select_count", 9);
    localIntent.putExtra("query_source_type", 13);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("show_header_view", true);
    localIntent.putExtra("send_btn_string", this.val$context.getString(2131758845));
    Object localObject = (SightParams)localIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new SightParams(4, 0);
    }
    localObject = "micromsg_" + System.currentTimeMillis();
    String str1 = b.aps() + (String)localObject + ".mp4";
    String str2 = b.aps() + (String)localObject + ".jpeg";
    int i = localIntent.getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(4, 1);
    localSightParams.uJv = 2;
    localSightParams.mode = 0;
    if (localSightParams.hcZ == null) {
      localSightParams.hcZ = new VideoTransPara();
    }
    localSightParams.hcZ.duration = i;
    localSightParams.r((String)localObject, str1, str2, b.aps() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    localIntent.putExtra("KEY_SIGHT_PARAMS", paramView);
    localIntent.putExtra("record_video_force_sys_camera", false);
    localIntent.putExtra("record_video_is_sight_capture", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_can_select_video_and_pic", true);
    d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", localIntent, 4097);
    AppMethodBeat.o(30817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.6
 * JD-Core Version:    0.7.0.1
 */