package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public boolean HmG;
  public boolean RxG;
  public boolean RxH;
  public final Rect RxI;
  public final Rect RxJ;
  public int dYT;
  public int height;
  public int ijt;
  public float scale;
  public int textureId;
  public int translateX;
  public int translateY;
  public int width;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, false, 0);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    this(paramInt1, paramInt2, paramInt3, false, 0);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(236751);
    this.HmG = false;
    this.dYT = 0;
    this.RxG = false;
    this.RxH = true;
    this.RxI = new Rect();
    this.RxJ = new Rect();
    this.ijt = 0;
    this.scale = 1.0F;
    this.translateX = 0;
    this.translateY = 0;
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.HmG = paramBoolean;
    this.dYT = paramInt4;
    this.RxI.right = paramInt2;
    this.RxI.bottom = paramInt3;
    AppMethodBeat.o(236751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.b
 * JD-Core Version:    0.7.0.1
 */