package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public boolean CIF;
  public long LYf;
  public boolean LYg;
  public final Rect LYh;
  public final Rect LYi;
  public final Rect LYj;
  public int dHi;
  public int height;
  public int hpY;
  public float scale;
  public int textureId;
  public int translateX;
  public int translateY;
  public int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, (byte)0);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    this(paramInt1, paramInt2, paramInt3, -1, -1L);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(216758);
    this.CIF = false;
    this.dHi = 0;
    this.LYg = false;
    this.LYh = new Rect();
    this.LYi = new Rect();
    this.LYj = new Rect();
    this.hpY = 0;
    this.scale = 1.0F;
    this.translateX = 0;
    this.translateY = 0;
    this.LYf = paramLong;
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.CIF = false;
    this.dHi = paramInt4;
    this.LYh.right = paramInt2;
    this.LYh.bottom = paramInt3;
    AppMethodBeat.o(216758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.a
 * JD-Core Version:    0.7.0.1
 */