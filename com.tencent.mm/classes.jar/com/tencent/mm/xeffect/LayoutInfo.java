package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/LayoutInfo;", "", "()V", "centerX", "", "getCenterX", "()I", "setCenterX", "(I)V", "centerY", "getCenterY", "setCenterY", "ptr", "", "getPtr", "()J", "rotate", "", "getRotate", "()F", "setRotate", "(F)V", "scale", "getScale", "setScale", "scaleBase", "getScaleBase", "setScaleBase", "finalize", "", "nDestroy", "nInit", "nUpdate", "updateNative", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class LayoutInfo
{
  public static final LayoutInfo.a agXA;
  private float aBi;
  public int agXz;
  public int centerX;
  public int centerY;
  final long ptr;
  public float scale;
  
  static
  {
    AppMethodBeat.i(234522);
    agXA = new LayoutInfo.a((byte)0);
    AppMethodBeat.o(234522);
  }
  
  public LayoutInfo()
  {
    AppMethodBeat.i(234519);
    this.scale = 1.0F;
    this.ptr = nInit();
    AppMethodBeat.o(234519);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(234527);
    nDestroy(this.ptr);
    AppMethodBeat.o(234527);
  }
  
  public final void jQf()
  {
    AppMethodBeat.i(234526);
    nUpdate(this.ptr, this.centerX, this.centerY, this.scale, this.aBi, this.agXz);
    AppMethodBeat.o(234526);
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native long nInit();
  
  public final native void nUpdate(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.LayoutInfo
 * JD-Core Version:    0.7.0.1
 */