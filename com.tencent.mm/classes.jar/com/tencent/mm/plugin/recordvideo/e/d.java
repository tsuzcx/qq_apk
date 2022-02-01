package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.SmileyPanelImpl;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class d
{
  private static final String TAG = "MicroMsg.MemLeakUtil";
  private static final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.a.a> yht;
  public static final d yhu;
  
  static
  {
    AppMethodBeat.i(76225);
    yhu = new d();
    yht = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.ui.editor.a.a parama)
  {
    AppMethodBeat.i(207143);
    p.h(parama, "panel");
    ae.i(TAG, "add panel  ".concat(String.valueOf(parama)));
    yht.add(parama);
    AppMethodBeat.o(207143);
  }
  
  public static void dLP()
  {
    AppMethodBeat.i(76224);
    ae.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)yht).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)localIterator.next();
      ae.i(TAG, "release panel ".concat(String.valueOf(locala)));
      locala.gsU.destroy();
    }
    yht.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d
 * JD-Core Version:    0.7.0.1
 */