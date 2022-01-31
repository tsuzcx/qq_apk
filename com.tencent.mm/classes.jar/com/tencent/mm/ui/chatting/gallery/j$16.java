package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class j$16
  implements Runnable
{
  j$16(j paramj, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32334);
    ab.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
    u.vu(j.a(this.zNd));
    if (this.zNd.zJI == null)
    {
      AppMethodBeat.o(32334);
      return;
    }
    Object localObject = this.zNd.zJI.dJY();
    ((k)localObject).dKP().zNt.stop();
    ((k)localObject).a(false, 0.0F);
    String str = this.zNd.zJI.zJK.getString(2131304519);
    if ((this.zNf == -5103059) || (this.zNf == -5103087)) {
      str = this.zNd.zJI.zJK.getString(2131304518);
    }
    for (localObject = new j.16.1(this);; localObject = new j.16.2(this))
    {
      h.a(this.zNd.zJI.zJK, str, this.zNd.zJI.zJK.getString(2131298283), (DialogInterface.OnClickListener)localObject);
      this.zNd.zMN.clear();
      AppMethodBeat.o(32334);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.16
 * JD-Core Version:    0.7.0.1
 */