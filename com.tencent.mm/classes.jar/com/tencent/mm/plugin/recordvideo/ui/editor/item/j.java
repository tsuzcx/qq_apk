package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j
{
  public abstract void bv(String paramString, long paramLong);
  
  public abstract boolean gKA();
  
  public abstract b gKz();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean a(j paramj)
    {
      AppMethodBeat.i(280209);
      s.u(paramj, "this");
      if (((CharSequence)paramj.gKz().path).length() > 0)
      {
        AppMethodBeat.o(280209);
        return true;
      }
      AppMethodBeat.o(280209);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.j
 * JD-Core Version:    0.7.0.1
 */