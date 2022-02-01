package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"})
public abstract interface i
{
  public abstract void bh(String paramString, long paramLong);
  
  public abstract b eMp();
  
  public abstract boolean eMq();
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static boolean a(i parami)
    {
      AppMethodBeat.i(237777);
      if (((CharSequence)parami.eMp().path).length() > 0)
      {
        AppMethodBeat.o(237777);
        return true;
      }
      AppMethodBeat.o(237777);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.i
 * JD-Core Version:    0.7.0.1
 */