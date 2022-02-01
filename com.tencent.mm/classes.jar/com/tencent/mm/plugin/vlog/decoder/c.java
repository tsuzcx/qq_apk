package com.tencent.mm.plugin.vlog.decoder;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.videocomposition.d.b;
import com.tencent.tav.decoder.RenderContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/GLRenderProc;", "", "()V", "TAG", "", "attributeYUVPosition", "", "attributeYUVTextureCoord", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "height", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "uTex", "uUTexture", "uVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vTex", "width", "yTex", "yuvProgramId", "allocTexMem", "", "internalFormat", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "checkErr", "msg", "release", "render", "buffer", "Ljava/nio/ByteBuffer;", "setSize", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  String TAG;
  int TXA;
  int TXB;
  int TXx;
  int TXy;
  int TXz;
  int height;
  FloatBuffer mVU;
  FloatBuffer mVV;
  float[] nDI;
  int nEC;
  int nED;
  int nEE;
  int nEF;
  int nEI;
  int width;
  
  public c()
  {
    AppMethodBeat.i(281348);
    this.TAG = "GLRenderProc";
    this.nDI = new float[16];
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVU = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVV = ((FloatBuffer)localObject);
    Matrix.setIdentityM(this.nDI, 0);
    this.mVU.position(0);
    this.mVU.put(com.tencent.mm.media.util.c.nFu);
    this.mVV.position(0);
    this.mVV.put(com.tencent.mm.media.util.c.nFt);
    localObject = com.tencent.mm.media.util.c.nFs;
    this.nEC = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.nEC == 0) {
      b.e(this.TAG, "checkInit, load program failed!", new Object[0]);
    }
    this.nEE = GLES20.glGetAttribLocation(this.nEC, "a_position");
    this.nED = GLES20.glGetAttribLocation(this.nEC, "a_texCoord");
    this.nEF = GLES20.glGetUniformLocation(this.nEC, "y_texture");
    this.TXx = GLES20.glGetUniformLocation(this.nEC, "u_texture");
    this.TXy = GLES20.glGetUniformLocation(this.nEC, "v_texture");
    this.nEI = GLES20.glGetUniformLocation(this.nEC, "uMatrix");
    this.TXz = RenderContext.createTexture(3553);
    this.TXA = RenderContext.createTexture(3553);
    this.TXB = RenderContext.createTexture(3553);
    AppMethodBeat.o(281348);
  }
  
  public final void beX(String paramString)
  {
    AppMethodBeat.i(281359);
    int i = GLES20.glGetError();
    if (i != 0) {
      b.e(this.TAG, "gl error " + i + ", " + paramString, new Object[0]);
    }
    AppMethodBeat.o(281359);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.c
 * JD-Core Version:    0.7.0.1
 */