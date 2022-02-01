package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "", "isOes", "", "(Z)V", "attributePosition", "", "attributeTextureCoord", "()Z", "setOes", "programId", "uniformTexture", "initNormalRenderProgram", "", "initOesRenderProgram", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderOnNormal", "renderOnOes", "plugin-voip_release"})
public final class i
{
  public boolean Odt;
  public int ksD;
  public int ksE;
  public int ksF;
  public int programId;
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(238173);
    this.Odt = paramBoolean;
    if (this.Odt)
    {
      locala = c.lar;
      this.programId = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
      this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
      this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
      this.ksF = GLES20.glGetUniformLocation(this.programId, "texture");
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      AppMethodBeat.o(238173);
      return;
    }
    c.a locala = c.lar;
    this.programId = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ksF = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 10497.0F);
    GLES20.glTexParameterf(3553, 10243, 10497.0F);
    AppMethodBeat.o(238173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.i
 * JD-Core Version:    0.7.0.1
 */