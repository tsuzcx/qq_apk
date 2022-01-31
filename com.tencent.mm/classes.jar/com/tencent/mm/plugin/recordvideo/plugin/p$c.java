package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.camerarecordview.a.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
public final class p$c
  implements Runnable
{
  public p$c(TextView paramTextView, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(150680);
    Object localObject = p.b(this.qcH);
    if (localObject != null) {}
    for (localObject = ((b)localObject).fbn;; localObject = null)
    {
      localObject = d.TX((String)localObject);
      if (!bo.isNullOrNil((String)localObject)) {
        break;
      }
      AppMethodBeat.o(150680);
      return;
    }
    if (ah.dsT())
    {
      e locale = g.RL();
      j.p(locale, "storage()");
      if (locale.Ru().getInt(ac.a.yDR, 0) != 1)
      {
        AppMethodBeat.o(150680);
        return;
      }
    }
    al.d((Runnable)new p.c.1(this, (String)localObject));
    AppMethodBeat.o(150680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p.c
 * JD-Core Version:    0.7.0.1
 */