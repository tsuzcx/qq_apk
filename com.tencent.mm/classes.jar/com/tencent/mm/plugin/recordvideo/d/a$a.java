package com.tencent.mm.plugin.recordvideo.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$a
  implements Runnable
{
  a$a(RecordConfigProvider paramRecordConfigProvider) {}
  
  public final void run()
  {
    AppMethodBeat.i(155504);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).Ru().getBoolean(ac.a.yEJ, true))
    {
      localObject = d.TY("mp4");
      com.tencent.mm.vfs.e.C(this.qfw.qbB, (String)localObject);
      b.a((String)localObject, ah.getContext());
    }
    com.tencent.mm.vfs.e.deleteFile(this.qfw.qbA);
    AppMethodBeat.o(155504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a.a
 * JD-Core Version:    0.7.0.1
 */