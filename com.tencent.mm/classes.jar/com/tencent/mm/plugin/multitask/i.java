package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/MultiTaskPathRouter;", "", "()V", "multiTaskAccPath", "", "getMultiTaskAccPath", "()Ljava/lang/String;", "multiTaskCoverImgPath", "getMultiTaskCoverImgPath", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i LBf;
  private static String LBg;
  private static final String LBh;
  
  static
  {
    AppMethodBeat.i(303890);
    LBf = new i();
    LBg = "";
    LBh = s.X(gjw(), "coverimg/");
    if (!y.ZC(gjw())) {
      y.bDX(gjw());
    }
    if (!y.ZC(LBh)) {
      y.bDX(LBh);
    }
    AppMethodBeat.o(303890);
  }
  
  private static String gjw()
  {
    AppMethodBeat.i(303879);
    String str = s.X(h.baE().mCJ, "multitask/");
    AppMethodBeat.o(303879);
    return str;
  }
  
  public static String gjx()
  {
    return LBh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.i
 * JD-Core Version:    0.7.0.1
 */