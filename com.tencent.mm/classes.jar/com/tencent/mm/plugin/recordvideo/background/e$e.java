package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ja;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5"})
final class e$e
  implements Runnable
{
  e$e(ja paramja, Context paramContext, ViewGroup paramViewGroup, afy paramafy) {}
  
  public final void run()
  {
    AppMethodBeat.i(75193);
    long l1 = this.xur.endTime;
    long l2 = this.xur.startTime;
    Object localObject = this.xup;
    p.g(localObject, "it");
    localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l((ja)localObject);
    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject).yN(l1 - l2);
    e locale = e.xuo;
    e.a(this.hqo, this.xuq, (com.tencent.mm.plugin.recordvideo.ui.editor.item.l)localObject);
    AppMethodBeat.o(75193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e.e
 * JD-Core Version:    0.7.0.1
 */