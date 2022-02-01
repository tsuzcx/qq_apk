package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/TaskBarPathRouter;", "", "()V", "taskBarAccPath", "", "getTaskBarAccPath", "()Ljava/lang/String;", "taskBarCoverImgPath", "getTaskBarCoverImgPath", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static String SQA;
  private static final String SQB;
  public static final g SQz;
  
  static
  {
    AppMethodBeat.i(263982);
    SQz = new g();
    SQA = "";
    SQB = s.X(hCU(), "coverimg/");
    if (!y.ZC(hCU())) {
      y.bDX(hCU());
    }
    if (!y.ZC(SQB)) {
      y.bDX(SQB);
    }
    AppMethodBeat.o(263982);
  }
  
  private static String hCU()
  {
    AppMethodBeat.i(263966);
    String str = s.X(h.baE().mCJ, "taskbar/");
    AppMethodBeat.o(263966);
    return str;
  }
  
  public static String hCV()
  {
    return SQB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.g
 * JD-Core Version:    0.7.0.1
 */