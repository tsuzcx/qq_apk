package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/InputAnimation;", "", "()V", "endMs", "", "getEndMs", "()J", "setEndMs", "(J)V", "interpolator", "", "getInterpolator", "()I", "setInterpolator", "(I)V", "ptr", "getPtr", "startMs", "getStartMs", "setStartMs", "finalize", "", "nDestroy", "nInit", "nUpdate", "updateNative", "Companion", "renderlib_release"})
public final class InputAnimation
{
  public static final a YZg;
  int YZf;
  public long dgn;
  public long gcH;
  final long ptr;
  
  static
  {
    AppMethodBeat.i(195630);
    YZg = new a((byte)0);
    AppMethodBeat.o(195630);
  }
  
  public InputAnimation()
  {
    AppMethodBeat.i(195629);
    this.ptr = nInit();
    AppMethodBeat.o(195629);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(195626);
    nDestroy(this.ptr);
    AppMethodBeat.o(195626);
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native long nInit();
  
  public final native void nUpdate(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/InputAnimation$Companion;", "", "()V", "InterpolatorEaseOut", "", "renderlib_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.InputAnimation
 * JD-Core Version:    0.7.0.1
 */