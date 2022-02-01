package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.e;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.util.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "glSTFilterInputFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlSTFilterInputFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlSTFilterInputFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glSTFilterInputTextureObject", "getGlSTFilterInputTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlSTFilterInputTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mSTFilter", "Lcom/tencent/mm/video/videoprocessing/GPUImageSpatiotemporalDenosing;", "programId", "uniformTexture", "checkInit", "", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTfilterScreenOut", "skipFilter", "", "setMotionLevel", "motionLevel", "noiseLevel", "", "updateTextureSize", "width", "height", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a URp;
  public e URq;
  public d URr;
  public a URs;
  public d mWs;
  public int mWv;
  public int mWw;
  public int mWx;
  public int programId;
  
  static
  {
    AppMethodBeat.i(293235);
    URp = new i.a((byte)0);
    AppMethodBeat.o(293235);
  }
  
  public i()
  {
    AppMethodBeat.i(293228);
    Object localObject = com.tencent.mm.media.util.c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    this.URq = new e();
    localObject = this.URq;
    if (localObject != null) {
      ((e)localObject).apC();
    }
    if (this.URr == null)
    {
      this.URr = com.tencent.mm.media.g.c.d(true, 3L);
      localObject = com.tencent.mm.media.g.c.nAB;
      this.URs = com.tencent.mm.media.g.c.hX(3L);
    }
    A(5, 0.024F);
    AppMethodBeat.o(293228);
  }
  
  public final void A(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(293242);
    e locale = this.URq;
    if (locale != null)
    {
      locale.aFK(paramInt);
      locale.er(paramFloat);
    }
    AppMethodBeat.o(293242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.i
 * JD-Core Version:    0.7.0.1
 */