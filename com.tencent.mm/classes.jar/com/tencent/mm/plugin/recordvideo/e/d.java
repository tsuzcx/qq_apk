package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.SmileyPanelImpl;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class d
{
  private static final String TAG = "MicroMsg.MemLeakUtil";
  private static final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.a.a> xRA;
  public static final d xRB;
  
  static
  {
    AppMethodBeat.i(76225);
    xRB = new d();
    xRA = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.ui.editor.a.a parama)
  {
    AppMethodBeat.i(200885);
    p.h(parama, "panel");
    ad.i(TAG, "add panel  ".concat(String.valueOf(parama)));
    xRA.add(parama);
    AppMethodBeat.o(200885);
  }
  
  public static void dIy()
  {
    AppMethodBeat.i(76224);
    ad.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)xRA).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)localIterator.next();
      ad.i(TAG, "release panel ".concat(String.valueOf(locala)));
      locala.gqu.destroy();
    }
    xRA.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d
 * JD-Core Version:    0.7.0.1
 */