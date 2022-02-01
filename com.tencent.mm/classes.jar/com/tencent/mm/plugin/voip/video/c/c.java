package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.video.render.a;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "release", "", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "encodeRotate", "encodeMirror", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "plugin-voip_release"})
public final class c
{
  public a Hms;
  public final boolean Hmt;
  public int hEA;
  public e hEx;
  public int hEy;
  public int hEz;
  public int programId;
  
  public c()
  {
    AppMethodBeat.i(236171);
    Object localObject = g.HgZ;
    this.Hmt = g.fKi();
    localObject = com.tencent.mm.media.k.c.ilt;
    this.programId = com.tencent.mm.media.k.c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (g.fKg())
    {
      if (this.Hmt)
      {
        this.Hms = new a();
        AppMethodBeat.o(236171);
        return;
      }
      this.hEx = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(236171);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram$setRGBDataCallback$1$1"})
  public static final class a
    extends q
    implements b<ByteBuffer, x>
  {
    public a(c paramc, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.c
 * JD-Core Version:    0.7.0.1
 */