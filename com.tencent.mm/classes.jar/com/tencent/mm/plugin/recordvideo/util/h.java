package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.a.a> ObA;
  public static final h Obz;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(76225);
    Obz = new h();
    ObA = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.ui.editor.a.a parama)
  {
    AppMethodBeat.i(279574);
    s.u(parama, "panel");
    Log.i(TAG, s.X("add panel  ", parama));
    ObA.add(parama);
    AppMethodBeat.o(279574);
  }
  
  public static void gLj()
  {
    AppMethodBeat.i(76224);
    Log.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)ObA).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)localIterator.next();
      Log.i(TAG, s.X("release panel ", locala));
      locala.moB.destroy();
    }
    ObA.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.h
 * JD-Core Version:    0.7.0.1
 */