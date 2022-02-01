package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ja;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4"})
final class e$d
  implements Runnable
{
  e$d(ja paramja, Context paramContext, ViewGroup paramViewGroup, afy paramafy) {}
  
  public final void run()
  {
    AppMethodBeat.i(75192);
    Object localObject = e.xuo;
    localObject = this.hqo;
    ViewGroup localViewGroup = this.xuq;
    ja localja = this.xup;
    p.g(localja, "it");
    e.b((Context)localObject, localViewGroup, new q(localja));
    AppMethodBeat.o(75192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e.d
 * JD-Core Version:    0.7.0.1
 */