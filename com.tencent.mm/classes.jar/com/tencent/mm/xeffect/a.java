package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public boolean ARq;
  public boolean JHZ;
  public final Rect JIa;
  public int duc;
  public int height;
  public int textureId;
  public int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(197158);
    this.ARq = false;
    this.duc = 0;
    this.JHZ = false;
    this.JIa = new Rect();
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.ARq = paramBoolean;
    this.JIa.right = paramInt2;
    this.JIa.bottom = paramInt3;
    AppMethodBeat.o(197158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.xeffect.a
 * JD-Core Version:    0.7.0.1
 */