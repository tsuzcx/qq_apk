package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipEncoderRenderProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "programId", "uMatrix", "uniformTexture", "initNormalRenderProgram", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "transformMatrix", "", "renderOnNormal", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  int mWv;
  int mWw;
  int mWx;
  int programId;
  int yob;
  
  public d()
  {
    AppMethodBeat.i(293232);
    c.a locala = c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    this.yob = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 10497.0F);
    GLES20.glTexParameterf(3553, 10243, 10497.0F);
    AppMethodBeat.o(293232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.d
 * JD-Core Version:    0.7.0.1
 */