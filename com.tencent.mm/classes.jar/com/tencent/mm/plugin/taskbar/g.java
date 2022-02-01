package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/TaskBarPathRouter;", "", "()V", "taskBarAccPath", "", "getTaskBarAccPath", "()Ljava/lang/String;", "taskBarCoverImgPath", "getTaskBarCoverImgPath", "plugin-taskbar_release"})
public final class g
{
  private static String Mng;
  private static final String Mnh;
  public static final g Mni;
  
  static
  {
    AppMethodBeat.i(215299);
    Mni = new g();
    Mng = "";
    Mnh = giU() + "coverimg/";
    if (!u.agG(giU())) {
      u.bBD(giU());
    }
    if (!u.agG(Mnh)) {
      u.bBD(Mnh);
    }
    AppMethodBeat.o(215299);
  }
  
  private static String giU()
  {
    AppMethodBeat.i(215297);
    Object localObject = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "taskbar/";
    AppMethodBeat.o(215297);
    return localObject;
  }
  
  public static String giV()
  {
    return Mnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.g
 * JD-Core Version:    0.7.0.1
 */