package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/InputAnimation;", "", "()V", "endMs", "", "getEndMs", "()J", "setEndMs", "(J)V", "interpolator", "", "getInterpolator", "()I", "setInterpolator", "(I)V", "ptr", "getPtr", "startMs", "getStartMs", "setStartMs", "finalize", "", "nDestroy", "nInit", "nUpdate", "updateNative", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class InputAnimation
{
  public static final InputAnimation.a agXr;
  int agXq;
  public long endMs;
  final long ptr;
  public long startMs;
  
  static
  {
    AppMethodBeat.i(234486);
    agXr = new InputAnimation.a((byte)0);
    AppMethodBeat.o(234486);
  }
  
  public InputAnimation()
  {
    AppMethodBeat.i(234481);
    this.ptr = nInit();
    AppMethodBeat.o(234481);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(234490);
    nDestroy(this.ptr);
    AppMethodBeat.o(234490);
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native long nInit();
  
  public final native void nUpdate(long paramLong1, long paramLong2, long paramLong3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.InputAnimation
 * JD-Core Version:    0.7.0.1
 */