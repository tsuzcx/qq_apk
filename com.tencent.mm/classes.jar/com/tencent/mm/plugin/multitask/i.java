package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/MultiTaskPathRouter;", "", "()V", "multiTaskAccPath", "", "getMultiTaskAccPath", "()Ljava/lang/String;", "multiTaskCoverImgPath", "getMultiTaskCoverImgPath", "plugin-multitask_release"})
public final class i
{
  private static String zZo;
  private static final String zZp;
  public static final i zZq;
  
  static
  {
    AppMethodBeat.i(200306);
    zZq = new i();
    zZo = "";
    zZp = eqB() + "coverimg/";
    if (!s.YS(eqB())) {
      s.boN(eqB());
    }
    if (!s.YS(zZp)) {
      s.boN(zZp);
    }
    AppMethodBeat.o(200306);
  }
  
  private static String eqB()
  {
    AppMethodBeat.i(200305);
    Object localObject = new StringBuilder();
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "multitask/";
    AppMethodBeat.o(200305);
    return localObject;
  }
  
  public static String eqC()
  {
    return zZp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.i
 * JD-Core Version:    0.7.0.1
 */