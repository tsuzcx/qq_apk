package com.tencent.mm.plugin.recordvideo.background.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "Companion", "plugin-recordvideo_release"})
public abstract interface b
  extends a
{
  public static final a vfI = a.vfJ;
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer$Companion;", "", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "plugin-recordvideo_release"})
  public static final class a
  {
    private static String CLASS;
    
    static
    {
      AppMethodBeat.i(75321);
      vfJ = new a();
      CLASS = "com.tencent.mm.plugin.mediabase.PluginBgMixer";
      AppMethodBeat.o(75321);
    }
    
    public static String dhj()
    {
      return CLASS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.b
 * JD-Core Version:    0.7.0.1
 */