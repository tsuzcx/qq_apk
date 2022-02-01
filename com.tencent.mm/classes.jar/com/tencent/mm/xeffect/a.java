package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public boolean LEs;
  public final Rect LEt;
  public int dwp;
  public int height;
  public int textureId;
  public int width;
  public boolean zyz;
  
  public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(201290);
    this.zyz = false;
    this.dwp = 0;
    this.LEs = false;
    this.LEt = new Rect();
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.zyz = paramBoolean;
    this.LEt.right = paramInt2;
    this.LEt.bottom = paramInt3;
    AppMethodBeat.o(201290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.a
 * JD-Core Version:    0.7.0.1
 */