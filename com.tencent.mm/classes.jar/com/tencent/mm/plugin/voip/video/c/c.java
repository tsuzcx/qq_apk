package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "programId", "uniformTexture", "release", "", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "plugin-voip_release"})
public final class c
{
  public int gvL;
  public int gvM;
  public int gvN;
  public int gvO;
  
  public c()
  {
    AppMethodBeat.i(192375);
    c.a locala = com.tencent.mm.media.j.c.gwl;
    this.gvL = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvO = GLES20.glGetUniformLocation(this.gvL, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    AppMethodBeat.o(192375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.c
 * JD-Core Version:    0.7.0.1
 */