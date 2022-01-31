package com.tencent.mm.plugin.music.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class b$a$1
  extends ShapeDrawable.ShaderFactory
{
  b$a$1(b.a parama, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = paramInt2;
    paramInt1 = this.mBK;
    Shader.TileMode localTileMode = Shader.TileMode.REPEAT;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, paramInt1 }, new float[] { 0.0F, 1.0F }, localTileMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b.a.1
 * JD-Core Version:    0.7.0.1
 */