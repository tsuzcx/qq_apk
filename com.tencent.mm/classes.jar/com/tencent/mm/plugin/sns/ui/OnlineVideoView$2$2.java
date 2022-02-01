package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class OnlineVideoView$2$2
  implements p.a
{
  OnlineVideoView$2$2(OnlineVideoView.2 param2, long paramLong, String paramString, Runnable paramRunnable) {}
  
  public final void bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292886);
    Toast.makeText(this.Ofs.KHP.getContext(), this.Ofs.KHP.getContext().getString(i.j.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    AndroidMediaUtil.refreshMediaScanner(paramString2, this.Ofs.KHP.getContext());
    OnlineVideoView.fUu();
    OnlineVideoView.x(this.Ofs.KHP);
    OnlineVideoView.w(this.Ofs.KHP);
    Log.i(OnlineVideoView.c(this.Ofs.KHP), "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(this.val$startTime)), this.lHc });
    OnlineVideoView.g(this.Ofs.KHP).post(this.Oft);
    AppMethodBeat.o(292886);
  }
  
  public final void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292887);
    Toast.makeText(this.Ofs.KHP.getContext(), this.Ofs.KHP.getContext().getString(i.j.video_file_save_failed), 1).show();
    OnlineVideoView.fUt();
    OnlineVideoView.w(this.Ofs.KHP);
    Log.w(OnlineVideoView.c(this.Ofs.KHP), "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(this.val$startTime)), this.lHc });
    OnlineVideoView.g(this.Ofs.KHP).post(this.Oft);
    AppMethodBeat.o(292887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.2.2
 * JD-Core Version:    0.7.0.1
 */