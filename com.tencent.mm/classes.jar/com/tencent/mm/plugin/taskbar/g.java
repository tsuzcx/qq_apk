package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/TaskBarPathRouter;", "", "()V", "taskBarAccPath", "", "getTaskBarAccPath", "()Ljava/lang/String;", "taskBarCoverImgPath", "getTaskBarCoverImgPath", "plugin-taskbar_release"})
public final class g
{
  private static String FSb;
  private static final String FSc;
  public static final g FSd;
  
  static
  {
    AppMethodBeat.i(238424);
    FSd = new g();
    FSb = "";
    FSc = fus() + "coverimg/";
    if (!s.YS(fus())) {
      s.boN(fus());
    }
    if (!s.YS(FSc)) {
      s.boN(FSc);
    }
    AppMethodBeat.o(238424);
  }
  
  private static String fus()
  {
    AppMethodBeat.i(238423);
    Object localObject = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "taskbar/";
    AppMethodBeat.o(238423);
    return localObject;
  }
  
  public static String fut()
  {
    return FSc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.g
 * JD-Core Version:    0.7.0.1
 */