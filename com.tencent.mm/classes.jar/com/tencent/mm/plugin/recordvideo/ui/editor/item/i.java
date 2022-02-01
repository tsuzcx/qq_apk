package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"})
public abstract interface i
{
  public abstract void be(String paramString, long paramLong);
  
  public abstract b dHY();
  
  public abstract boolean dHZ();
  
  @l(gfx={1, 1, 16})
  public static final class a
  {
    public static boolean a(i parami)
    {
      AppMethodBeat.i(200678);
      if (((CharSequence)parami.dHY().path).length() > 0)
      {
        AppMethodBeat.o(200678);
        return true;
      }
      AppMethodBeat.o(200678);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.i
 * JD-Core Version:    0.7.0.1
 */