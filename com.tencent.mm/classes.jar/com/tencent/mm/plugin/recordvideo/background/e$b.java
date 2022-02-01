package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ja;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2"})
final class e$b
  implements Runnable
{
  e$b(ja paramja, Context paramContext, ViewGroup paramViewGroup, afy paramafy) {}
  
  public final void run()
  {
    AppMethodBeat.i(75190);
    Object localObject = e.xuo;
    localObject = this.hqo;
    ViewGroup localViewGroup = this.xuq;
    ja localja = this.xup;
    p.g(localja, "it");
    e.a((Context)localObject, localViewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(localja));
    AppMethodBeat.o(75190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e.b
 * JD-Core Version:    0.7.0.1
 */