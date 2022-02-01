package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/MultiTaskPathRouter;", "", "()V", "multiTaskAccPath", "", "getMultiTaskAccPath", "()Ljava/lang/String;", "multiTaskCoverImgPath", "getMultiTaskCoverImgPath", "plugin-multitask_release"})
public final class i
{
  private static String FFc;
  private static final String FFd;
  public static final i FFe;
  
  static
  {
    AppMethodBeat.i(248386);
    FFe = new i();
    FFc = "";
    FFd = far() + "coverimg/";
    if (!u.agG(far())) {
      u.bBD(far());
    }
    if (!u.agG(FFd)) {
      u.bBD(FFd);
    }
    AppMethodBeat.o(248386);
  }
  
  private static String far()
  {
    AppMethodBeat.i(248383);
    Object localObject = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "multitask/";
    AppMethodBeat.o(248383);
    return localObject;
  }
  
  public static String fas()
  {
    return FFd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.i
 * JD-Core Version:    0.7.0.1
 */