package com.tencent.mm.videocomposition.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectTextureScreenOutputRenderer;", "", "()V", "CUBE_PROTRAIT", "", "FragmentShader", "", "TEXTURE_COORD", "VertexShader", "aPositionHandle", "", "aTextureCoordHandle", "cubeBuffer", "Ljava/nio/FloatBuffer;", "kotlin.jvm.PlatformType", "program", "textureCoordBuffer", "uTextureHandle", "finishDraw", "", "info", "Lcom/tencent/tav/coremedia/TextureInfo;", "initProgram", "prepareDraw", "release", "render", "texture", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class g
{
  int aPositionHandle;
  private final String agEO;
  private final String agEP;
  int agEQ;
  int agER;
  final FloatBuffer mVV;
  private final float[] nFt;
  private final float[] nFu;
  int program;
  final FloatBuffer ynT;
  
  public g()
  {
    AppMethodBeat.i(233655);
    this.agEO = "\n            attribute vec4 aPosition;\n            attribute vec2 aTextureCoord;\n            varying vec2 vTextureCoord;\n            void main() {\n              gl_Position = aPosition;\n              vTextureCoord = aTextureCoord;\n            }\n        ";
    this.agEP = "\n            precision mediump float;\n            varying vec2 vTextureCoord;\n            uniform sampler2D sTexture;\n            void main() {\n              gl_FragColor = texture2D(sTexture, vTextureCoord);\n            }\n        ";
    this.nFu = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.nFt = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(this.nFu);
    this.ynT = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(this.nFt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(this.nFt);
    this.mVV = localFloatBuffer;
    this.program = Program.createProgram(this.agEO, this.agEP);
    if (this.program == 0) {
      new RuntimeException("failed creating program");
    }
    for (;;)
    {
      GLES30.glDisable(3042);
      AppMethodBeat.o(233655);
      return;
      this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
      RenderContext.checkEglError("glGetAttribLocation aPosition");
      if (this.aPositionHandle == -1)
      {
        new RuntimeException("Could not get attribute location for aPosition");
      }
      else
      {
        this.agEQ = GLES20.glGetAttribLocation(this.program, "aTextureCoord");
        RenderContext.checkEglError("glGetAttribLocation aTextureCoord");
        if (this.agEQ == -1)
        {
          new RuntimeException("Could not get attribute location for aTextureCoord");
        }
        else
        {
          this.agER = GLES20.glGetUniformLocation(this.program, "sTexture");
          RenderContext.checkEglError("glGetUniformLocation sTexture");
          if (this.agER == -1) {
            new RuntimeException("Could not get uniform location for sTexture");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.g
 * JD-Core Version:    0.7.0.1
 */