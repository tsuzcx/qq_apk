package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/LayoutInfo;", "", "()V", "centerX", "", "getCenterX", "()I", "setCenterX", "(I)V", "centerY", "getCenterY", "setCenterY", "ptr", "", "getPtr", "()J", "rotate", "", "getRotate", "()F", "setRotate", "(F)V", "scale", "getScale", "setScale", "scaleBase", "getScaleBase", "setScaleBase", "finalize", "", "nDestroy", "nInit", "nUpdate", "updateNative", "Companion", "renderlib_release"})
public final class LayoutInfo
{
  public static final a YZp;
  public int YZo;
  public int centerX;
  public int centerY;
  private float oYk;
  final long ptr;
  public float scale;
  
  static
  {
    AppMethodBeat.i(195652);
    YZp = new a((byte)0);
    AppMethodBeat.o(195652);
  }
  
  public LayoutInfo()
  {
    AppMethodBeat.i(195650);
    this.scale = 1.0F;
    this.ptr = nInit();
    AppMethodBeat.o(195650);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(195646);
    nDestroy(this.ptr);
    AppMethodBeat.o(195646);
  }
  
  public final void ijX()
  {
    AppMethodBeat.i(195644);
    nUpdate(this.ptr, this.centerX, this.centerY, this.scale, this.oYk, this.YZo);
    AppMethodBeat.o(195644);
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native long nInit();
  
  public final native void nUpdate(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3);
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/LayoutInfo$Companion;", "", "()V", "ScaleBaseCenterCrop", "", "ScaleBaseCenterInside", "ScaleBaseHeight", "ScaleBaseNone", "ScaleBaseWidth", "renderlib_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.LayoutInfo
 * JD-Core Version:    0.7.0.1
 */