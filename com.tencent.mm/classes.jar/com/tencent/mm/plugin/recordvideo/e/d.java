package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class d
{
  private static final String TAG = "MicroMsg.MemLeakUtil";
  private static final ArrayList<com.tencent.mm.media.editor.b.a> vtQ;
  public static final d vtR;
  
  static
  {
    AppMethodBeat.i(76225);
    vtR = new d();
    vtQ = new ArrayList();
    TAG = "MicroMsg.MemLeakUtil";
    AppMethodBeat.o(76225);
  }
  
  public static void a(com.tencent.mm.media.editor.b.a parama)
  {
    AppMethodBeat.i(76223);
    k.h(parama, "panel");
    ad.i(TAG, "add panel  ".concat(String.valueOf(parama)));
    vtQ.add(parama);
    AppMethodBeat.o(76223);
  }
  
  public static void djg()
  {
    AppMethodBeat.i(76224);
    ad.i(TAG, "release panel ");
    Iterator localIterator = ((Iterable)vtQ).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.media.editor.b.a locala = (com.tencent.mm.media.editor.b.a)localIterator.next();
      ad.i(TAG, "release panel ".concat(String.valueOf(locala)));
      locala.fSY.destroy();
    }
    vtQ.clear();
    AppMethodBeat.o(76224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d
 * JD-Core Version:    0.7.0.1
 */