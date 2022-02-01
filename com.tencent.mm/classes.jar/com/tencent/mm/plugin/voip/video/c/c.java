package com.tencent.mm.plugin.voip.video.c;

import android.media.ImageReader;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.j.b.g;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.plugin.voip.video.render.c.c;
import com.tencent.mm.plugin.voip.video.render.c.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoIPRenderOnEncoderProgram;", "Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;", "()V", "mEncoderPixelReader", "Lcom/tencent/mm/plugin/voip/video/programv2/EncoderSurfacePixelReader;", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipEncoderRenderProgram;", "release", "", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "", "renderMode", "transformMatrix", "", "setMirror", "isMirror", "", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setRotate", "encodeRotate", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encodeWidth", "encodeHeight", "encoderType", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  private d URk;
  private a URl;
  
  public c()
  {
    AppMethodBeat.i(293236);
    this.URk = new d();
    this.URl = new a();
    AppMethodBeat.o(293236);
  }
  
  public final void a(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(293246);
    s.u(paramFloatBuffer1, "cubeBuffer");
    s.u(paramFloatBuffer2, "textureCoordBuff");
    s.u(paramArrayOfFloat, "transformMatrix");
    Object localObject = h.ULL;
    if (!h.ibJ())
    {
      paramFloatBuffer1 = this.URl;
      if (paramFloatBuffer1.URi)
      {
        paramFloatBuffer1 = paramFloatBuffer1.URh;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer1.TXY = paramInt1;
          paramFloatBuffer1.bI((kotlin.g.a.a)new c.c(paramFloatBuffer1));
          AppMethodBeat.o(293246);
        }
      }
      else
      {
        paramFloatBuffer1 = paramFloatBuffer1.mWu;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer1.mVb = paramInt1;
          paramFloatBuffer1.nDP = true;
          paramFloatBuffer1.bgE();
        }
      }
      AppMethodBeat.o(293246);
      return;
    }
    localObject = this.URk;
    s.u(paramFloatBuffer1, "cubeBuffer");
    s.u(paramFloatBuffer2, "textureCoordBuff");
    s.u(paramArrayOfFloat, "transformMatrix");
    if (paramInt1 != -1)
    {
      GLES20.glUseProgram(((d)localObject).programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(((d)localObject).mWx, 0);
      GLES20.glUniformMatrix4fv(((d)localObject).yob, 1, false, paramArrayOfFloat, 0);
      GLES20.glEnableVertexAttribArray(((d)localObject).mWv);
      GLES20.glVertexAttribPointer(((d)localObject).mWv, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(((d)localObject).mWw);
      GLES20.glVertexAttribPointer(((d)localObject).mWw, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(((d)localObject).mWv);
      GLES20.glDisableVertexAttribArray(((d)localObject).mWw);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
    }
    AppMethodBeat.o(293246);
  }
  
  public final void bl(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.URl;
    if (((a)localObject).URi)
    {
      localObject = ((a)localObject).URh;
      if ((localObject != null) && (((com.tencent.mm.plugin.voip.video.render.c)localObject).UIy))
      {
        ((com.tencent.mm.plugin.voip.video.render.c)localObject).URV = paramInt1;
        ((com.tencent.mm.plugin.voip.video.render.c)localObject).URW = paramInt2;
        ((com.tencent.mm.plugin.voip.video.render.c)localObject).qIF = paramInt3;
      }
    }
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293262);
    Object localObject = this.URl;
    com.tencent.mm.plugin.voip.video.render.c localc = ((a)localObject).URh;
    if ((localc != null) && ((localc.width != paramInt1) || (localc.height != paramInt2)))
    {
      localc.width = paramInt1;
      localc.nAh = (localc.width * 3 / 2);
      localc.height = paramInt2;
      localc.nAg = (localc.height / 4);
      localc.bI((kotlin.g.a.a)new c.d(localc));
    }
    localObject = ((a)localObject).mWu;
    if (localObject != null)
    {
      ((e)localObject).el(paramInt1, paramInt2);
      ((e)localObject).ek(paramInt2, paramInt1);
      ((e)localObject).es(paramInt2, paramInt1);
    }
    AppMethodBeat.o(293262);
  }
  
  public final void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> paramr)
  {
    AppMethodBeat.i(293275);
    s.u(paramr, "callback");
    Object localObject = this.URl;
    s.u(paramr, "callback");
    if (((a)localObject).URi)
    {
      localObject = ((a)localObject).URh;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.voip.video.render.c)localObject).URQ = paramr;
        AppMethodBeat.o(293275);
      }
    }
    else
    {
      e locale = ((a)localObject).mWu;
      if (locale != null) {
        locale.nDM = ((kotlin.g.a.b)new a.a(paramr, (a)localObject));
      }
    }
    AppMethodBeat.o(293275);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293254);
    GLES20.glDeleteProgram(this.URk.programId);
    Object localObject1 = this.URl;
    com.tencent.mm.plugin.voip.video.render.c localc = ((a)localObject1).URh;
    if (localc != null)
    {
      Object localObject2 = localc.mVi;
      if (localObject2 != null)
      {
        c.a locala = com.tencent.mm.media.util.c.nFs;
        c.a.a((c.b)localObject2);
      }
      localObject2 = localc.URP;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localc.URS.clear();
      localc.mVi = null;
      localc.URO.quitSafely();
      localObject2 = localc.URR;
      if (localObject2 != null) {
        ((g)localObject2).release();
      }
      localc.URP = null;
      localc.URT.clear();
      localc.URQ = null;
    }
    localObject1 = ((a)localObject1).mWu;
    if (localObject1 != null) {
      ((e)localObject1).release();
    }
    AppMethodBeat.o(293254);
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(293266);
    Object localObject1 = this.URl;
    Object localObject2 = ((a)localObject1).URh;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject2).URR;
      if (localObject2 != null) {
        ((g)localObject2).gr(paramBoolean);
      }
    }
    localObject1 = ((a)localObject1).mWu;
    if (localObject1 != null) {
      ((e)localObject1).gr(paramBoolean);
    }
    AppMethodBeat.o(293266);
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(293271);
    Object localObject1 = this.URl;
    Object localObject2 = ((a)localObject1).URh;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject2).URR;
      if (localObject2 != null) {
        ((g)localObject2).th(paramInt);
      }
    }
    localObject1 = ((a)localObject1).mWu;
    if (localObject1 != null) {
      ((e)localObject1).th(paramInt);
    }
    AppMethodBeat.o(293271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.c
 * JD-Core Version:    0.7.0.1
 */