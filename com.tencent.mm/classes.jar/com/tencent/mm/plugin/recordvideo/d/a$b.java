package com.tencent.mm.plugin.recordvideo.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
final class a$b
  implements Runnable
{
  a$b(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(150832);
    if (!this.qfw.qby) {
      com.tencent.mm.vfs.e.deleteFile(this.qfw.qbC);
    }
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    boolean bool = ((com.tencent.mm.kernel.e)localObject).Ru().getBoolean(ac.a.yEI, true);
    if (!bool)
    {
      AppMethodBeat.o(150832);
      return;
    }
    if (((this.qfx) && (bool)) || ((!this.qfx) && (this.qfy.qbz) && (this.qfz)))
    {
      localObject = d.TY("jpg");
      if (!this.qfx) {
        localObject = b.TY("jpg");
      }
      ab.i("MicroMsg.RemuxPlugin", "auto save pic src " + this.qfy.qbD + " dest " + (String)localObject + ' ');
      com.tencent.mm.vfs.e.C(this.qfy.qbD, (String)localObject);
      b.a((String)localObject, ah.getContext());
    }
    AppMethodBeat.o(150832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a.b
 * JD-Core Version:    0.7.0.1
 */