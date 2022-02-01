package com.tencent.mm.videocomposition.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectTextureScreenOutputRenderer;", "", "()V", "CUBE_PROTRAIT", "", "FragmentShader", "", "TEXTURE_COORD", "VertexShader", "aPositionHandle", "", "aTextureCoordHandle", "cubeBuffer", "Ljava/nio/FloatBuffer;", "kotlin.jvm.PlatformType", "program", "textureCoordBuffer", "uTextureHandle", "finishDraw", "", "info", "Lcom/tencent/tav/coremedia/TextureInfo;", "initProgram", "prepareDraw", "release", "render", "texture", "video_composition_release"})
public final class f
{
  private final String YIV;
  private final String YIW;
  int YIX;
  int YIY;
  int aPositionHandle;
  final FloatBuffer ksb;
  private final float[] laj;
  private final float[] lak;
  int program;
  final FloatBuffer vca;
  
  public f()
  {
    AppMethodBeat.i(248315);
    this.YIV = "\n            attribute vec4 aPosition;\n            attribute vec2 aTextureCoord;\n            varying vec2 vTextureCoord;\n            void main() {\n              gl_Position = aPosition;\n              vTextureCoord = aTextureCoord;\n            }\n        ";
    this.YIW = "\n            precision mediump float;\n            varying vec2 vTextureCoord;\n            uniform sampler2D sTexture;\n            void main() {\n              gl_FragColor = texture2D(sTexture, vTextureCoord);\n            }\n        ";
    this.lak = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.laj = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(this.lak);
    this.vca = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(this.laj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(this.laj);
    this.ksb = localFloatBuffer;
    this.program = Program.createProgram(this.YIV, this.YIW);
    if (this.program == 0) {
      new RuntimeException("failed creating program");
    }
    for (;;)
    {
      GLES30.glDisable(3042);
      AppMethodBeat.o(248315);
      return;
      this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
      RenderContext.checkEglError("glGetAttribLocation aPosition");
      if (this.aPositionHandle == -1)
      {
        new RuntimeException("Could not get attribute location for aPosition");
      }
      else
      {
        this.YIX = GLES20.glGetAttribLocation(this.program, "aTextureCoord");
        RenderContext.checkEglError("glGetAttribLocation aTextureCoord");
        if (this.YIX == -1)
        {
          new RuntimeException("Could not get attribute location for aTextureCoord");
        }
        else
        {
          this.YIY = GLES20.glGetUniformLocation(this.program, "sTexture");
          RenderContext.checkEglError("glGetUniformLocation sTexture");
          if (this.YIY == -1) {
            new RuntimeException("Could not get uniform location for sTexture");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.f
 * JD-Core Version:    0.7.0.1
 */