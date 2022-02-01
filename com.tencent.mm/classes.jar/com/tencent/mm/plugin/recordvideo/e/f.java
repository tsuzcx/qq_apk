package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class f
{
  private static final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.a.a> Ifj;
  public static final f Ifk;
  private static final String TAG = "MicroMsg.MemLeakUtil";
  
  static
  {
    AppMethodBeat.i(76225);
    Ifk = new f();
    Ifj = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.ui.editor.a.a parama)
  {
    AppMethodBeat.i(222810);
    p.k(parama, "panel");
    Log.i(TAG, "add panel  ".concat(String.valueOf(parama)));
    Ifj.add(parama);
    AppMethodBeat.o(222810);
  }
  
  public static void fzy()
  {
    AppMethodBeat.i(76224);
    Log.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)Ifj).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)localIterator.next();
      Log.i(TAG, "release panel ".concat(String.valueOf(locala)));
      locala.jPK.destroy();
    }
    Ifj.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.f
 * JD-Core Version:    0.7.0.1
 */