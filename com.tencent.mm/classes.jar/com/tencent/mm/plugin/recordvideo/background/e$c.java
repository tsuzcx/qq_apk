package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ja;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3"})
final class e$c
  implements Runnable
{
  e$c(ja paramja, Context paramContext, ViewGroup paramViewGroup, afy paramafy) {}
  
  public final void run()
  {
    AppMethodBeat.i(75191);
    Object localObject = e.xuo;
    localObject = this.hqo;
    ViewGroup localViewGroup = this.xuq;
    ja localja = this.xup;
    p.g(localja, "it");
    e.a((Context)localObject, localViewGroup, new k(localja));
    AppMethodBeat.o(75191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e.c
 * JD-Core Version:    0.7.0.1
 */