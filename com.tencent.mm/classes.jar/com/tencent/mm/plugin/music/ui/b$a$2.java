package com.tencent.mm.plugin.music.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a$2
  extends ShapeDrawable.ShaderFactory
{
  b$a$2(b.a parama, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63213);
    float f = paramInt2;
    paramInt1 = this.wnr;
    Object localObject = Shader.TileMode.REPEAT;
    localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { paramInt1, 0 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
    AppMethodBeat.o(63213);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b.a.2
 * JD-Core Version:    0.7.0.1
 */