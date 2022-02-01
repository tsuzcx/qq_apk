package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"})
public abstract interface i
{
  public abstract void bf(String paramString, long paramLong);
  
  public abstract b dLp();
  
  public abstract boolean dLq();
  
  @l(gjZ={1, 1, 16})
  public static final class a
  {
    public static boolean a(i parami)
    {
      AppMethodBeat.i(206936);
      if (((CharSequence)parami.dLp().path).length() > 0)
      {
        AppMethodBeat.o(206936);
        return true;
      }
      AppMethodBeat.o(206936);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.i
 * JD-Core Version:    0.7.0.1
 */