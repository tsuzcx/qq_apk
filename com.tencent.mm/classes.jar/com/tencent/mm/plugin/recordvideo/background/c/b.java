package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends a
{
  public static final a NFR = a.NFS;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer$Companion;", "", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String CLASS;
    
    static
    {
      AppMethodBeat.i(75321);
      NFS = new a();
      CLASS = "com.tencent.mm.plugin.PluginBgMixer";
      AppMethodBeat.o(75321);
    }
    
    public static String getCLASS()
    {
      return CLASS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.b
 * JD-Core Version:    0.7.0.1
 */