package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class e
{
  private static final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.a.a> Cis;
  public static final e Cit;
  private static final String TAG = "MicroMsg.MemLeakUtil";
  
  static
  {
    AppMethodBeat.i(76225);
    Cit = new e();
    Cis = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.ui.editor.a.a parama)
  {
    AppMethodBeat.i(237990);
    p.h(parama, "panel");
    Log.i(TAG, "add panel  ".concat(String.valueOf(parama)));
    Cis.add(parama);
    AppMethodBeat.o(237990);
  }
  
  public static void eMN()
  {
    AppMethodBeat.i(76224);
    Log.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)Cis).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)localIterator.next();
      Log.i(TAG, "release panel ".concat(String.valueOf(locala)));
      locala.hee.destroy();
    }
    Cis.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.e
 * JD-Core Version:    0.7.0.1
 */