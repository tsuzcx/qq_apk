package com.tencent.mm.plugin.sns.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class SnsHeader$3
  extends ShapeDrawable.ShaderFactory
{
  SnsHeader$3(SnsHeader paramSnsHeader, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = paramInt2;
    paramInt1 = this.oYt;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { paramInt1, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader.3
 * JD-Core Version:    0.7.0.1
 */