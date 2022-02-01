package com.tencent.mm.plugin.voip.video.render;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.c.h.a;
import com.tencent.mm.plugin.voip.video.c.e.a;
import com.tencent.mm.plugin.voip.video.c.f;
import com.tencent.mm.plugin.voip.video.c.f.a;
import com.tencent.mm.plugin.voip.video.c.h.b;
import com.tencent.mm.plugin.voip.video.c.j;
import com.tencent.mm.plugin.voip.video.c.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyInputTexture", "beautyParam", "encodeMirror", "", "getEncodeMirror", "()Z", "setEncodeMirror", "(Z)V", "encodeRotate", "getEncodeRotate", "()I", "setEncodeRotate", "(I)V", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "setFaceBeautyAlgo", "isFaceBeautyAlogChanged", "setFaceBeautyAlogChanged", "isViewPortChange", "mSTFilterMotionNoiseDataCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseDataCallBack;", "getMSTFilterMotionNoiseDataCallback", "()Lkotlin/jvm/functions/Function2;", "setMSTFilterMotionNoiseDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "mSTFilterMotionNoiseDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseData;", "onFaceBeautyDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "getOnFaceBeautyDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnFaceBeautyDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "getOnSTFilterDataCallback", "setOnSTFilterDataCallback", "outputTexturObject", "programId", "stFilterOutputTexturObject", "stFilterProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "stfilterParam", "getStfilterParam", "setStfilterParam", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "useSTfilterScreenOut", "useSkipFilterProcess", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getDrawHeight", "()Ljava/lang/Integer;", "getDrawWidth", "getOutputRendererTexture", "getSTFilterMotionNoiseData", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoipBeauty", "algorithm", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class n
  extends com.tencent.mm.media.j.b.a
{
  public static final a OfW;
  private int NZs;
  private int OfE;
  f OfF;
  com.tencent.mm.plugin.voip.video.c.e OfG;
  j OfH;
  com.tencent.mm.plugin.voip.video.c.h OfI;
  com.tencent.mm.media.g.d OfJ;
  private boolean OfK;
  boolean OfL;
  private int OfM;
  int OfN;
  private int OfO;
  int OfP;
  private boolean OfQ;
  boolean OfR;
  com.tencent.mm.media.g.d OfS;
  private com.tencent.mm.media.g.d OfT;
  private com.tencent.mm.plugin.voip.video.d.a OfU;
  m<? super Integer, ? super Float, x> OfV;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Sux;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Suy;
  int kZr;
  private int programId;
  
  static
  {
    AppMethodBeat.i(245813);
    OfW = new a((byte)0);
    AppMethodBeat.o(245813);
  }
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
    AppMethodBeat.i(245810);
    this.kZr = -1;
    this.OfE = -1;
    this.OfK = true;
    this.OfU = new com.tencent.mm.plugin.voip.video.d.a();
    AppMethodBeat.o(245810);
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(245805);
    if (this.OfK)
    {
      aVl().position(0);
      aVl().put(k(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    }
    aVl().position(0);
    aVm().position(0);
    aVm().put(com.tencent.mm.media.k.c.laj);
    aVm().position(0);
    if (this.kYx == null)
    {
      this.kYx = com.tencent.mm.media.g.c.a(true, 3L);
      localObject = com.tencent.mm.media.g.c.kVi;
      a(com.tencent.mm.media.g.c.FP(3L));
    }
    Object localObject = com.tencent.mm.media.k.c.lar;
    c.a.a(aVn(), this.kYx, getDrawWidth(), getDrawHeight());
    GLES20.glViewport(0, 0, getDrawWidth(), getDrawHeight());
    AppMethodBeat.o(245805);
  }
  
  public final void aVv()
  {
    AppMethodBeat.i(245807);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glFinish();
    AppMethodBeat.o(245807);
  }
  
  public final void aVw()
  {
    AppMethodBeat.i(245806);
    Object localObject3;
    label68:
    int i;
    label97:
    int j;
    Object localObject4;
    int k;
    int m;
    boolean bool1;
    boolean bool2;
    if (this.OfM == 1)
    {
      if (this.OfV == null) {
        this.OfV = ((m)new b(this));
      }
      localObject3 = this.OfU;
      localObject2 = this.OfI;
      if (localObject2 != null)
      {
        if (localObject3 != null)
        {
          localObject1 = Integer.valueOf(((com.tencent.mm.plugin.voip.video.d.a)localObject3).Ogt);
          if (localObject1 == null) {
            p.iCn();
          }
          i = ((Integer)localObject1).intValue();
          if (localObject3 == null) {
            break label1081;
          }
          localObject1 = Float.valueOf(((com.tencent.mm.plugin.voip.video.d.a)localObject3).Ogu);
          if (localObject1 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.voip.video.c.h)localObject2).x(i, ((Float)localObject1).floatValue());
        }
      }
      else
      {
        localObject2 = this.OfI;
        if (localObject2 == null) {
          break label1337;
        }
        i = getDrawWidth();
        j = getDrawHeight();
        localObject3 = aVm();
        localObject4 = aVl();
        aVp();
        int n = this.kZr;
        localObject1 = this.kYx;
        if (localObject1 == null) {
          p.iCn();
        }
        k = this.OfO;
        m = this.OfP;
        bool1 = this.OfR;
        bool2 = this.OfQ;
        p.k(localObject3, "cubeBuffer");
        p.k(localObject4, "textureCoordBuff");
        p.k(localObject1, "outputTexture");
        if (n != -1)
        {
          GLES20.glBindFramebuffer(36160, 0);
          localObject1 = com.tencent.mm.media.k.c.lar;
          c.a.a(((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odr, ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq, i, j);
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.h)localObject2).programId);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, n);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksF, 0);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksD, 2, 5126, false, 0, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksD);
          ((FloatBuffer)localObject4).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksE, 2, 5126, false, 0, (Buffer)localObject4);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksE);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksD);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksE);
          GLES20.glBindTexture(36197, 0);
          GLES20.glBindFramebuffer(36160, 0);
          com.tencent.mm.ct.a.e locale;
          if ((((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA == null) && (((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odp != null))
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA;
            if (localObject1 != null) {
              ((com.tencent.mm.media.g.d)localObject1).close();
            }
            ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA = com.tencent.mm.media.g.c.a(true, 14L);
            locale = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odp;
            if (locale != null)
            {
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA;
              if (localObject1 == null) {
                break label1087;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
              label468:
              if (localObject1 == null) {
                p.iCn();
              }
              locale.azj(((Integer)localObject1).intValue());
            }
          }
          if (!bool2)
          {
            locale = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odp;
            if (locale != null)
            {
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odp;
              if (localObject1 != null) {
                ((com.tencent.mm.ct.a.e)localObject1).nj(i, j);
              }
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
              if (localObject1 == null) {
                break label1093;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
              label544:
              if (localObject1 == null) {
                p.iCn();
              }
              n = ((Integer)localObject1).intValue();
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
              if (localObject1 == null) {
                break label1099;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
              label581:
              if (localObject1 == null) {
                p.iCn();
              }
              int i1 = ((Integer)localObject1).intValue();
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
              if (localObject1 == null) {
                break label1105;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
              label618:
              if (localObject1 == null) {
                p.iCn();
              }
              locale.a(n, i1, ((Integer)localObject1).intValue(), (FloatBuffer)localObject3, (FloatBuffer)localObject4);
            }
          }
          if (k == 1)
          {
            if (!((com.tencent.mm.plugin.voip.video.c.h)localObject2).QQU) {
              break label1166;
            }
            localObject3 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).QQT;
            if (localObject3 != null)
            {
              if (bool2) {
                break label1117;
              }
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA;
              if (localObject1 == null) {
                break label1111;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
              label696:
              if (localObject1 == null) {
                p.iCn();
              }
              ((b)localObject3).NkK = ((Integer)localObject1).intValue();
              ((b)localObject3).ku(i, j);
              ((b)localObject3).requestRender();
            }
          }
          label726:
          if (bool2) {
            break label1327;
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA;
        }
        label738:
        this.OfT = ((com.tencent.mm.media.g.d)localObject1);
        localObject1 = this.OfT;
        if (localObject1 == null) {
          break label1343;
        }
        localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);
        label765:
        if (localObject1 == null) {
          p.iCn();
        }
      }
    }
    for (this.OfE = ((Integer)localObject1).intValue();; this.OfE = this.kZr) {
      switch (this.OfN)
      {
      default: 
        localObject2 = this.OfF;
        if (localObject2 == null) {
          break label1999;
        }
        i = getDrawWidth();
        j = getDrawHeight();
        localObject3 = aVm();
        localObject4 = aVl();
        k = this.kZr;
        localObject1 = this.kYx;
        if (localObject1 == null) {
          p.iCn();
        }
        m = this.OfP;
        bool1 = this.OfR;
        p.k(localObject3, "cubeBuffer");
        p.k(localObject4, "textureCoordBuff");
        p.k(localObject1, "outputTexture");
        if (k == -1) {
          break label1992;
        }
        GLES20.glUseProgram(((f)localObject2).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((f)localObject2).ksF, 0);
        GLES20.glVertexAttribPointer(((f)localObject2).ksD, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((f)localObject2).ksD);
        GLES20.glVertexAttribPointer(((f)localObject2).ksE, 2, 5126, false, 8, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((f)localObject2).ksE);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((f)localObject2).ksD);
        GLES20.glDisableVertexAttribArray(((f)localObject2).ksE);
        if (!g.gCF()) {
          break label1992;
        }
        GLES20.glBindTexture(36197, 0);
        if (!((f)localObject2).QQU) {
          break label1917;
        }
        localObject2 = ((f)localObject2).QQT;
        if (localObject2 == null) {
          break label1910;
        }
        ((b)localObject2).NkK = ((com.tencent.mm.media.g.d)localObject1).kVj;
        ((b)localObject2).ku(i, j);
        ((b)localObject2).requestRender();
        AppMethodBeat.o(245806);
        return;
        localObject1 = null;
        break label68;
        label1081:
        localObject1 = null;
        break label97;
        label1087:
        localObject1 = null;
        break label468;
        label1093:
        localObject1 = null;
        break label544;
        label1099:
        localObject1 = null;
        break label581;
        label1105:
        localObject1 = null;
        break label618;
        label1111:
        localObject1 = null;
        break label696;
        label1117:
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);; localObject1 = null)
        {
          if (localObject1 == null) {
            p.iCn();
          }
          ((b)localObject3).NkK = ((Integer)localObject1).intValue();
          break;
        }
        label1166:
        localObject3 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksC;
        if (localObject3 == null) {
          break label726;
        }
        ((com.tencent.mm.media.j.b.e)localObject3).tm(m);
        ((com.tencent.mm.media.j.b.a)localObject3).kYh = bool1;
        if (!bool2)
        {
          localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).ksA;
          if (localObject1 != null) {}
          for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);; localObject1 = null)
          {
            if (localObject1 == null) {
              p.iCn();
            }
            ((com.tencent.mm.media.j.b.e)localObject3).kre = ((Integer)localObject1).intValue();
            ((com.tencent.mm.media.j.b.e)localObject3).dv(i, j);
            ((com.tencent.mm.media.j.b.e)localObject3).du(j, i);
            ((com.tencent.mm.media.j.b.e)localObject3).dy(j, i);
            ((com.tencent.mm.media.j.b.a)localObject3).kYH = true;
            ((com.tencent.mm.media.j.b.e)localObject3).aMU();
            break;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).kVj);; localObject1 = null)
        {
          if (localObject1 == null) {
            p.iCn();
          }
          ((com.tencent.mm.media.j.b.e)localObject3).kre = ((Integer)localObject1).intValue();
          break;
        }
        label1327:
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Odq;
        break label738;
        label1337:
        localObject1 = null;
        break label738;
        label1343:
        localObject1 = null;
        break label765;
      }
    }
    Object localObject1 = this.OfH;
    if (localObject1 != null)
    {
      i = getDrawWidth();
      j = getDrawHeight();
      localObject2 = aVm();
      localObject3 = aVl();
      aVp();
      k = this.OfE;
      localObject4 = this.kYx;
      if (localObject4 == null) {
        p.iCn();
      }
    }
    for (localObject1 = ((j)localObject1).a(i, j, (FloatBuffer)localObject2, (FloatBuffer)localObject3, k, (com.tencent.mm.media.g.d)localObject4, this.NZs, this.OfM, this.OfP, this.OfR);; localObject1 = null)
    {
      this.OfS = ((com.tencent.mm.media.g.d)localObject1);
      AppMethodBeat.o(245806);
      return;
    }
    Object localObject2 = this.OfG;
    if (localObject2 != null)
    {
      i = getDrawWidth();
      j = getDrawHeight();
      localObject3 = aVm();
      localObject4 = aVl();
      k = this.kZr;
      localObject1 = this.kYx;
      if (localObject1 == null) {
        p.iCn();
      }
      m = this.OfP;
      bool1 = this.OfR;
      p.k(localObject3, "cubeBuffer");
      p.k(localObject4, "textureCoordBuff");
      p.k(localObject1, "outputTexture");
      if (k != -1)
      {
        GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject2).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksF, 0);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObT, 0.5F);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObU, 0);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObV, 2);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObW, 0.8F);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObX, i);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ObY, j);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksD, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksD);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksE, 2, 5126, false, 8, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksE);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksD);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksE);
        GLES20.glBindTexture(36197, 0);
        if (((com.tencent.mm.plugin.voip.video.c.e)localObject2).QQU)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).QQT;
          if (localObject2 != null)
          {
            ((b)localObject2).NkK = ((com.tencent.mm.media.g.d)localObject1).kVj;
            ((b)localObject2).ku(i, j);
            ((b)localObject2).requestRender();
            AppMethodBeat.o(245806);
            return;
          }
          AppMethodBeat.o(245806);
          return;
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksC;
        if (localObject2 != null)
        {
          ((com.tencent.mm.media.j.b.e)localObject2).tm(m);
          ((com.tencent.mm.media.j.b.a)localObject2).kYh = bool1;
          ((com.tencent.mm.media.j.b.e)localObject2).kre = ((com.tencent.mm.media.g.d)localObject1).kVj;
          ((com.tencent.mm.media.j.b.e)localObject2).dv(i, j);
          ((com.tencent.mm.media.j.b.e)localObject2).du(j, i);
          ((com.tencent.mm.media.j.b.e)localObject2).dy(j, i);
          ((com.tencent.mm.media.j.b.a)localObject2).kYH = true;
          ((com.tencent.mm.media.j.b.e)localObject2).aMU();
          AppMethodBeat.o(245806);
          return;
        }
      }
      AppMethodBeat.o(245806);
      return;
    }
    AppMethodBeat.o(245806);
    return;
    this.OfS = this.OfT;
    AppMethodBeat.o(245806);
    return;
    label1910:
    AppMethodBeat.o(245806);
    return;
    label1917:
    localObject2 = ((f)localObject2).ksC;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.j.b.e)localObject2).tm(m);
      ((com.tencent.mm.media.j.b.a)localObject2).kYh = bool1;
      ((com.tencent.mm.media.j.b.e)localObject2).kre = ((com.tencent.mm.media.g.d)localObject1).kVj;
      ((com.tencent.mm.media.j.b.e)localObject2).dv(i, j);
      ((com.tencent.mm.media.j.b.e)localObject2).du(j, i);
      ((com.tencent.mm.media.j.b.e)localObject2).dy(j, i);
      ((com.tencent.mm.media.j.b.a)localObject2).kYH = true;
      ((com.tencent.mm.media.j.b.e)localObject2).aMU();
      AppMethodBeat.o(245806);
      return;
    }
    label1992:
    AppMethodBeat.o(245806);
    return;
    label1999:
    AppMethodBeat.o(245806);
  }
  
  public final void bx(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(245794);
    Log.i("MicroMsg.VoipRenderProcExternalTexture", "setSTFilter(Hseasun), isON:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.OfN == 1)
    {
      this.OfM = 0;
      AppMethodBeat.o(245794);
      return;
    }
    this.OfM = paramInt;
    if (this.OfM == 1)
    {
      if (this.OfI == null) {
        this.OfI = new com.tencent.mm.plugin.voip.video.c.h();
      }
      Log.i("MicroMsg.VoipRenderProcExternalTexture", "faceBeautyAlgo:  " + this.OfN + ", isFaceBeautyAlogChanged: " + this.OfL);
      if ((this.OfN == 0) || (this.OfN == 3))
      {
        Object localObject = this.OfI;
        r localr;
        if (localObject != null)
        {
          localr = (r)new n.c(this);
          p.k(localr, "callback");
          if (!((com.tencent.mm.plugin.voip.video.c.h)localObject).QQU) {
            break label219;
          }
          localObject = ((com.tencent.mm.plugin.voip.video.c.h)localObject).QQT;
          if (localObject != null) {
            ((b)localObject).OdM = localr;
          }
        }
        for (;;)
        {
          this.OfN = 3;
          ud(2);
          this.OfL = true;
          this.OfO = 1;
          this.OfQ = paramBoolean;
          AppMethodBeat.o(245794);
          return;
          label219:
          com.tencent.mm.media.j.b.e locale = ((com.tencent.mm.plugin.voip.video.c.h)localObject).ksC;
          if (locale != null) {
            locale.kYE = ((kotlin.g.a.b)new h.b((com.tencent.mm.plugin.voip.video.c.h)localObject, localr));
          }
        }
      }
      if (this.OfN != 3) {
        this.OfO = 0;
      }
    }
    AppMethodBeat.o(245794);
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245800);
    if ((paramInt1 != getDrawWidth()) || (paramInt2 != getDrawHeight()))
    {
      super.du(paramInt1, paramInt2);
      this.OfK = true;
    }
    AppMethodBeat.o(245800);
  }
  
  public final void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245798);
    super.dv(paramInt1, paramInt2);
    this.OfK = true;
    AppMethodBeat.o(245798);
  }
  
  public final Integer gED()
  {
    AppMethodBeat.i(245801);
    int i = getDrawWidth();
    AppMethodBeat.o(245801);
    return Integer.valueOf(i);
  }
  
  public final Integer gEE()
  {
    AppMethodBeat.i(245803);
    int i = getDrawHeight();
    AppMethodBeat.o(245803);
    return Integer.valueOf(i);
  }
  
  public final void le(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245796);
    Log.printInfoStack("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.NZs = paramInt1;
    Object localObject2;
    Object localObject1;
    if ((this.OfN != paramInt2) && (this.OfN != 3) && (paramInt1 != 0))
    {
      this.OfN = paramInt2;
      this.OfK = true;
      this.OfL = true;
      switch (paramInt2)
      {
      default: 
        if (this.OfF == null)
        {
          this.OfF = new f();
          localObject2 = this.OfF;
          if (localObject2 != null)
          {
            localObject1 = (r)new n.f(this);
            p.k(localObject1, "callback");
            if (!((f)localObject2).QQU) {
              break label453;
            }
            localObject2 = ((f)localObject2).QQT;
            if (localObject2 != null) {
              ((b)localObject2).OdM = ((r)localObject1);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.voip.c.h.NYa;
      h.a.alx(0);
      ud(1);
      AppMethodBeat.o(245796);
      return;
      this.OfL = false;
      break;
      if (this.OfH == null)
      {
        this.OfH = new j();
        localObject2 = this.OfH;
        if (localObject2 != null)
        {
          localObject1 = (r)new n.d(this);
          p.k(localObject1, "callback");
          if (!((j)localObject2).QQU) {
            break label293;
          }
          localObject2 = ((j)localObject2).QQT;
          if (localObject2 != null) {
            ((b)localObject2).OdM = ((r)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.voip.c.h.NYa;
        h.a.alx(1);
        Log.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
        ud(2);
        AppMethodBeat.o(245796);
        return;
        label293:
        locale = ((j)localObject2).ksC;
        if (locale != null) {
          locale.kYE = ((kotlin.g.a.b)new j.b((j)localObject2, (r)localObject1));
        }
      }
      if (this.OfG == null)
      {
        this.OfG = new com.tencent.mm.plugin.voip.video.c.e();
        localObject2 = this.OfG;
        if (localObject2 != null)
        {
          localObject1 = (r)new n.e(this);
          p.k(localObject1, "callback");
          if (!((com.tencent.mm.plugin.voip.video.c.e)localObject2).QQU) {
            break label420;
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).QQT;
          if (localObject2 != null) {
            ((b)localObject2).OdM = ((r)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.voip.c.h.NYa;
        h.a.alx(2);
        ud(2);
        AppMethodBeat.o(245796);
        return;
        label420:
        locale = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).ksC;
        if (locale != null) {
          locale.kYE = ((kotlin.g.a.b)new e.a((com.tencent.mm.plugin.voip.video.c.e)localObject2, (r)localObject1));
        }
      }
      label453:
      com.tencent.mm.media.j.b.e locale = ((f)localObject2).ksC;
      if (locale != null) {
        locale.kYE = ((kotlin.g.a.b)new f.a((f)localObject2, (r)localObject1));
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(245809);
    super.release();
    Object localObject1 = this.OfF;
    if (localObject1 != null)
    {
      localObject2 = ((f)localObject1).QQT;
      if (localObject2 != null) {
        ((b)localObject2).release();
      }
      localObject2 = ((f)localObject1).ksC;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((f)localObject1).programId);
    }
    localObject1 = this.OfH;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).ksC;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((j)localObject1).ksA;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((j)localObject1).Odu;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.j(localThread, "Thread.currentThread()");
        Log.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).krf;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).jUF != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).jUF;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).jUF = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    Object localObject2 = ((j)localObject1).QQT;
    if (localObject2 != null) {
      ((b)localObject2).release();
    }
    GLES20.glDeleteProgram(((j)localObject1).programId);
    localObject1 = this.OfG;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.e)localObject1).QQT;
      if (localObject2 != null) {
        ((b)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.e)localObject1).ksC;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject1).programId);
    }
    localObject1 = this.OfI;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).Odq;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).Odr;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.a)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).ksA;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).ksC;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).Odp;
      if (localObject2 != null) {
        ((com.tencent.mm.ct.a.e)localObject2).destroy();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.h)localObject1).QQT;
      if (localObject2 != null) {
        ((b)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.h)localObject1).programId);
    }
    GLES20.glDeleteProgram(this.programId);
    AppMethodBeat.o(245809);
  }
  
  public final void ua(int paramInt)
  {
    this.kZr = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "motion", "", "noise", "", "invoke"})
  static final class b
    extends q
    implements m<Integer, Float, x>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.n
 * JD-Core Version:    0.7.0.1
 */