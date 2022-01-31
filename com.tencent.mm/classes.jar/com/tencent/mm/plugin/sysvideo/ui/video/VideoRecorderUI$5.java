package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.b;

final class VideoRecorderUI$5
  implements MenuItem.OnMenuItemClickListener
{
  VideoRecorderUI$5(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25649);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(this.tbs).filename);
    paramMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(this.tbs).qWJ.fXx);
    paramMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(this.tbs));
    this.tbs.setResult(-1, paramMenuItem);
    this.tbs.finish();
    AppMethodBeat.o(25649);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.5
 * JD-Core Version:    0.7.0.1
 */