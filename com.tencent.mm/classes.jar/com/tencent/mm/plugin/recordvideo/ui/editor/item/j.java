package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"})
public abstract interface j
{
  public abstract void bj(String paramString, long paramLong);
  
  public abstract b fyN();
  
  public abstract boolean fyO();
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static boolean a(j paramj)
    {
      AppMethodBeat.i(221421);
      if (((CharSequence)paramj.fyN().path).length() > 0)
      {
        AppMethodBeat.o(221421);
        return true;
      }
      AppMethodBeat.o(221421);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.j
 * JD-Core Version:    0.7.0.1
 */