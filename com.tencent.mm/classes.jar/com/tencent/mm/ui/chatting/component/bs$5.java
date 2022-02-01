package com.tencent.mm.ui.chatting.component;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class bs$5
  implements ExportFileUtil.a
{
  bs$5(bs parambs) {}
  
  public final void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255773);
    Toast.makeText(this.aeyW.hlc.aezO.getContext(), this.aeyW.hlc.aezO.getMMResources().getString(R.l.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    t.refreshMediaScanner(paramString2, this.aeyW.hlc.aezO.getContext());
    AppMethodBeat.o(255773);
  }
  
  public final void ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255776);
    Toast.makeText(this.aeyW.hlc.aezO.getContext(), this.aeyW.hlc.aezO.getMMResources().getString(R.l.video_file_save_failed), 1).show();
    AppMethodBeat.o(255776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bs.5
 * JD-Core Version:    0.7.0.1
 */