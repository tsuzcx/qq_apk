package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public boolean Crb;
  public long LBf;
  public boolean LBg;
  public final Rect LBh;
  public final Rect LBi;
  public final Rect LBj;
  public int dGc;
  public int height;
  public int hnk;
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
    AppMethodBeat.i(220007);
    this.Crb = false;
    this.dGc = 0;
    this.LBg = false;
    this.LBh = new Rect();
    this.LBi = new Rect();
    this.LBj = new Rect();
    this.hnk = 0;
    this.scale = 1.0F;
    this.translateX = 0;
    this.translateY = 0;
    this.LBf = paramLong;
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.Crb = false;
    this.dGc = paramInt4;
    this.LBh.right = paramInt2;
    this.LBh.bottom = paramInt3;
    AppMethodBeat.o(220007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.a
 * JD-Core Version:    0.7.0.1
 */