package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.h.a;
import com.tencent.mm.plugin.voip.video.c.b.a;
import com.tencent.mm.plugin.voip.video.c.e.b;
import com.tencent.mm.plugin.voip.video.c.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyInputTexture", "beautyParam", "encodeMirror", "", "getEncodeMirror", "()Z", "setEncodeMirror", "(Z)V", "encodeRotate", "getEncodeRotate", "()I", "setEncodeRotate", "(I)V", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "setFaceBeautyAlgo", "isFaceBeautyAlogChanged", "setFaceBeautyAlogChanged", "isViewPortChange", "mSTFilterMotionNoiseDataCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseDataCallBack;", "getMSTFilterMotionNoiseDataCallback", "()Lkotlin/jvm/functions/Function2;", "setMSTFilterMotionNoiseDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "mSTFilterMotionNoiseDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseData;", "onFaceBeautyDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "getOnFaceBeautyDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnFaceBeautyDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "getOnSTFilterDataCallback", "setOnSTFilterDataCallback", "outputTexturObject", "programId", "stFilterOutputTexturObject", "stFilterProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "stfilterParam", "getStfilterParam", "setStfilterParam", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "useSTfilterScreenOut", "useSkipFilterProcess", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getDrawHeight", "()Ljava/lang/Integer;", "getDrawWidth", "getOutputRendererTexture", "getSTFilterMotionNoiseData", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoipBeauty", "algorithm", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class k
  extends com.tencent.mm.media.j.b.a
{
  public static final k.a Hpg;
  private int HiD;
  private int HoM;
  com.tencent.mm.plugin.voip.video.c.c HoN;
  com.tencent.mm.plugin.voip.video.c.b HoO;
  com.tencent.mm.plugin.voip.video.c.g HoP;
  com.tencent.mm.plugin.voip.video.c.e HoQ;
  com.tencent.mm.media.g.d HoR;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HoS;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HoT;
  private boolean HoU;
  boolean HoV;
  private int HoW;
  int HoX;
  private int HoY;
  int HoZ;
  private boolean Hpa;
  boolean Hpb;
  com.tencent.mm.media.g.d Hpc;
  private com.tencent.mm.media.g.d Hpd;
  private com.tencent.mm.plugin.voip.video.d.a Hpe;
  m<? super Integer, ? super Float, x> Hpf;
  int ikx;
  private int programId;
  
  static
  {
    AppMethodBeat.i(236329);
    Hpg = new k.a((byte)0);
    AppMethodBeat.o(236329);
  }
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
    AppMethodBeat.i(236328);
    this.ikx = -1;
    this.HoM = -1;
    this.HoU = true;
    this.Hpe = new com.tencent.mm.plugin.voip.video.d.a();
    AppMethodBeat.o(236328);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(236324);
    Object localObject;
    if (this.HoU)
    {
      this.hDT.position(0);
      if (this.HoX != 0)
      {
        this.hDT.put(k(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        this.hDT.position(0);
        this.hDU.position(0);
        this.hDU.put(com.tencent.mm.media.k.c.ilm);
        this.hDU.position(0);
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.voip.b.g.fKg()) {
        break label602;
      }
      if (this.ijD == null)
      {
        this.ijD = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.igu;
        this.ijE = com.tencent.mm.media.g.c.zI(3L);
      }
      localObject = com.tencent.mm.media.k.c.ilt;
      com.tencent.mm.media.k.c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
    }
    for (;;)
    {
      GLES20.glViewport(0, 0, this.hEp, this.hEq);
      AppMethodBeat.o(236324);
      return;
      float f7 = this.ijS.x / this.hDn;
      float f4 = (this.ijS.y - 1.0F) / this.hDo;
      float f6 = (this.ijT.x - 1.0F) / this.hDn;
      float f5 = this.ijT.y / this.hDo;
      localObject = com.tencent.mm.media.k.c.iln;
      localObject = Arrays.copyOf((float[])localObject, localObject.length);
      int i;
      label303:
      int j;
      int k;
      int m;
      label346:
      label351:
      float f8;
      float f9;
      float f3;
      float f2;
      if ((this.ijt == 90) || (this.ijt == 270))
      {
        i = 1;
        j = this.ijT.x - this.ijS.x;
        k = this.ijS.y - this.ijT.y;
        if (i == 0) {
          break label537;
        }
        m = k;
        if (i == 0) {
          break label544;
        }
        f8 = this.hEp / m;
        f9 = this.hEq / j;
        f3 = 0.0F;
        f2 = 0.0F;
        if (f8 >= f9) {
          break label551;
        }
        f1 = m - this.hEp / f9;
        label398:
        this.ijO = (m - (int)f1);
        this.ijP = (j - (int)f2);
        if (i == 0) {
          break label579;
        }
        f2 = f2 / 2.0F / j;
      }
      for (float f1 = f1 / 2.0F / m;; f1 = f3)
      {
        f3 = f7 + f2;
        f2 = f6 - f2;
        f5 += f1;
        f1 = f4 - f1;
        localObject[0] = f3;
        localObject[1] = f1;
        localObject[2] = f2;
        localObject[3] = f1;
        localObject[4] = f3;
        localObject[5] = f5;
        localObject[6] = f2;
        localObject[7] = f5;
        FloatBuffer localFloatBuffer = this.hDT;
        p.g(localObject, "cropTextureCoord");
        localFloatBuffer.put(k((float[])localObject));
        break;
        i = 0;
        break label303;
        label537:
        m = j;
        break label346;
        label544:
        j = k;
        break label351;
        label551:
        f1 = f3;
        if (f8 <= f9) {
          break label398;
        }
        f2 = j - this.hEq / f8;
        f1 = f3;
        break label398;
        label579:
        f1 = f1 / 2.0F / m;
        f3 = f2 / 2.0F / j;
        f2 = f1;
      }
      label602:
      if (this.HoX != 0)
      {
        if (this.ijD == null)
        {
          this.ijD = com.tencent.mm.media.g.c.a(true, 3L);
          localObject = com.tencent.mm.media.g.c.igu;
          this.ijE = com.tencent.mm.media.g.c.zI(3L);
        }
        localObject = com.tencent.mm.media.k.c.ilt;
        com.tencent.mm.media.k.c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
      }
    }
  }
  
  public final void aMU()
  {
    AppMethodBeat.i(236326);
    if (com.tencent.mm.plugin.voip.b.g.fKg()) {
      GLES20.glBindFramebuffer(36160, 0);
    }
    for (;;)
    {
      GLES20.glFinish();
      AppMethodBeat.o(236326);
      return;
      if (this.HoX != 0) {
        GLES20.glBindFramebuffer(36160, 0);
      }
    }
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(236325);
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
    if (this.HoW == 1)
    {
      if (this.Hpf == null) {
        this.Hpf = ((m)new k.b(this));
      }
      localObject3 = this.Hpe;
      localObject2 = this.HoQ;
      if (localObject2 != null)
      {
        if (localObject3 != null)
        {
          localObject1 = Integer.valueOf(((com.tencent.mm.plugin.voip.video.d.a)localObject3).HpA);
          if (localObject1 == null) {
            p.hyc();
          }
          i = ((Integer)localObject1).intValue();
          if (localObject3 == null) {
            break label1077;
          }
          localObject1 = Float.valueOf(((com.tencent.mm.plugin.voip.video.d.a)localObject3).HpB);
          if (localObject1 == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.voip.video.c.e)localObject2).w(i, ((Float)localObject1).floatValue());
        }
      }
      else
      {
        localObject2 = this.HoQ;
        if (localObject2 == null) {
          break label1333;
        }
        i = this.hEp;
        j = this.hEq;
        localObject3 = this.hDU;
        localObject4 = this.hDT;
        int n = this.ikx;
        localObject1 = this.ijD;
        if (localObject1 == null) {
          p.hyc();
        }
        k = this.HoY;
        m = this.HoZ;
        bool1 = this.Hpb;
        bool2 = this.Hpa;
        p.h(localObject3, "cubeBuffer");
        p.h(localObject4, "textureCoordBuff");
        p.h(localObject1, "outputTexture");
        if (n != -1)
        {
          GLES20.glBindFramebuffer(36160, 0);
          localObject1 = com.tencent.mm.media.k.c.ilt;
          com.tencent.mm.media.k.c.a.a(((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmD, ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC, i, j);
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject2).programId);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, n);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEA, 0);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEy, 2, 5126, false, 0, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEy);
          ((FloatBuffer)localObject4).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEz, 2, 5126, false, 0, (Buffer)localObject4);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEz);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEy);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEz);
          GLES20.glBindTexture(36197, 0);
          GLES20.glBindFramebuffer(36160, 0);
          if ((((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv == null) && (((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmB != null))
          {
            ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv = com.tencent.mm.media.g.c.a(true, 14L);
            localObject1 = com.tencent.mm.media.g.c.igu;
            ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmA = com.tencent.mm.media.g.c.zI(3L);
          }
          f localf = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmB;
          if (localf != null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv;
            if (localObject1 == null) {
              break label1083;
            }
            localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
            label462:
            if (localObject1 == null) {
              p.hyc();
            }
            localf.apK(((Integer)localObject1).intValue());
          }
          if (!bool2)
          {
            localf = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmB;
            if (localf != null)
            {
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmB;
              if (localObject1 != null) {
                ((f)localObject1).lS(i, j);
              }
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
              if (localObject1 == null) {
                break label1089;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
              label538:
              if (localObject1 == null) {
                p.hyc();
              }
              n = ((Integer)localObject1).intValue();
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
              if (localObject1 == null) {
                break label1095;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
              label575:
              if (localObject1 == null) {
                p.hyc();
              }
              int i1 = ((Integer)localObject1).intValue();
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
              if (localObject1 == null) {
                break label1101;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
              label612:
              if (localObject1 == null) {
                p.hyc();
              }
              localf.a(n, i1, ((Integer)localObject1).intValue(), (FloatBuffer)localObject3, (FloatBuffer)localObject4);
            }
          }
          if (k == 1)
          {
            if (!((com.tencent.mm.plugin.voip.video.c.e)localObject2).Hmt) {
              break label1162;
            }
            localObject3 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).Hms;
            if (localObject3 != null)
            {
              if (bool2) {
                break label1113;
              }
              localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv;
              if (localObject1 == null) {
                break label1107;
              }
              localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
              label690:
              if (localObject1 == null) {
                p.hyc();
              }
              ((a)localObject3).Gxi = ((Integer)localObject1).intValue();
              ((a)localObject3).jj(i, j);
              ((a)localObject3).requestRender();
            }
          }
          label720:
          if (bool2) {
            break label1323;
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv;
        }
        label732:
        this.Hpd = ((com.tencent.mm.media.g.d)localObject1);
        localObject1 = this.Hpd;
        if (localObject1 == null) {
          break label1339;
        }
        localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);
        label759:
        if (localObject1 == null) {
          p.hyc();
        }
      }
    }
    for (this.HoM = ((Integer)localObject1).intValue();; this.HoM = this.ikx) {
      switch (this.HoX)
      {
      default: 
        localObject2 = this.HoN;
        if (localObject2 == null) {
          break label1990;
        }
        i = this.hEp;
        j = this.hEq;
        localObject3 = this.hDU;
        localObject4 = this.hDT;
        k = this.ikx;
        localObject1 = this.ijD;
        if (localObject1 == null) {
          p.hyc();
        }
        m = this.HoZ;
        bool1 = this.Hpb;
        p.h(localObject3, "cubeBuffer");
        p.h(localObject4, "textureCoordBuff");
        p.h(localObject1, "outputTexture");
        if (k == -1) {
          break label1983;
        }
        GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject2).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEA, 0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEy, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEy);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEz, 2, 5126, false, 8, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEz);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEy);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEz);
        if (!com.tencent.mm.plugin.voip.b.g.fKg()) {
          break label1983;
        }
        GLES20.glBindTexture(36197, 0);
        if (!((com.tencent.mm.plugin.voip.video.c.c)localObject2).Hmt) {
          break label1908;
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.c.c)localObject2).Hms;
        if (localObject2 == null) {
          break label1901;
        }
        ((a)localObject2).Gxi = ((com.tencent.mm.media.g.d)localObject1).igv;
        ((a)localObject2).jj(i, j);
        ((a)localObject2).requestRender();
        AppMethodBeat.o(236325);
        return;
        localObject1 = null;
        break label68;
        label1077:
        localObject1 = null;
        break label97;
        label1083:
        localObject1 = null;
        break label462;
        label1089:
        localObject1 = null;
        break label538;
        label1095:
        localObject1 = null;
        break label575;
        label1101:
        localObject1 = null;
        break label612;
        label1107:
        localObject1 = null;
        break label690;
        label1113:
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);; localObject1 = null)
        {
          if (localObject1 == null) {
            p.hyc();
          }
          ((a)localObject3).Gxi = ((Integer)localObject1).intValue();
          break;
        }
        label1162:
        localObject3 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEx;
        if (localObject3 == null) {
          break label720;
        }
        ((com.tencent.mm.media.j.b.e)localObject3).qx(m);
        ((com.tencent.mm.media.j.b.a)localObject3).iju = bool1;
        if (!bool2)
        {
          localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).hEv;
          if (localObject1 != null) {}
          for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);; localObject1 = null)
          {
            if (localObject1 == null) {
              p.hyc();
            }
            ((com.tencent.mm.media.j.b.e)localObject3).hDl = ((Integer)localObject1).intValue();
            ((com.tencent.mm.media.j.b.e)localObject3).cZ(i, j);
            ((com.tencent.mm.media.j.b.e)localObject3).cY(j, i);
            ((com.tencent.mm.media.j.b.e)localObject3).dc(j, i);
            ((com.tencent.mm.media.j.b.a)localObject3).ijM = true;
            ((com.tencent.mm.media.j.b.e)localObject3).aED();
            break;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).igv);; localObject1 = null)
        {
          if (localObject1 == null) {
            p.hyc();
          }
          ((com.tencent.mm.media.j.b.e)localObject3).hDl = ((Integer)localObject1).intValue();
          break;
        }
        label1323:
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.e)localObject2).HmC;
        break label732;
        label1333:
        localObject1 = null;
        break label732;
        label1339:
        localObject1 = null;
        break label759;
      }
    }
    Object localObject1 = this.HoP;
    if (localObject1 != null)
    {
      i = this.hEp;
      j = this.hEq;
      localObject2 = this.hDU;
      localObject3 = this.hDT;
      k = this.HoM;
      localObject4 = this.ijD;
      if (localObject4 == null) {
        p.hyc();
      }
    }
    for (localObject1 = ((com.tencent.mm.plugin.voip.video.c.g)localObject1).a(i, j, (FloatBuffer)localObject2, (FloatBuffer)localObject3, k, (com.tencent.mm.media.g.d)localObject4, this.HiD, this.HoW, this.HoZ, this.Hpb);; localObject1 = null)
    {
      this.Hpc = ((com.tencent.mm.media.g.d)localObject1);
      AppMethodBeat.o(236325);
      return;
    }
    Object localObject2 = this.HoO;
    if (localObject2 != null)
    {
      i = this.hEp;
      j = this.hEq;
      localObject3 = this.hDU;
      localObject4 = this.hDT;
      k = this.ikx;
      localObject1 = this.ijD;
      if (localObject1 == null) {
        p.hyc();
      }
      m = this.HoZ;
      bool1 = this.Hpb;
      p.h(localObject3, "cubeBuffer");
      p.h(localObject4, "textureCoordBuff");
      p.h(localObject1, "outputTexture");
      if (k != -1)
      {
        GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject2).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEA, 0);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hle, 0.5F);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hlf, 0);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hlg, 2);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hlh, 0.8F);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hli, i);
        GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hlj, j);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEy, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEy);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEz, 2, 5126, false, 8, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEz);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEy);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEz);
        GLES20.glBindTexture(36197, 0);
        if (((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hmt)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hms;
          if (localObject2 != null)
          {
            ((a)localObject2).Gxi = ((com.tencent.mm.media.g.d)localObject1).igv;
            ((a)localObject2).jj(i, j);
            ((a)localObject2).requestRender();
            AppMethodBeat.o(236325);
            return;
          }
          AppMethodBeat.o(236325);
          return;
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEx;
        if (localObject2 != null)
        {
          ((com.tencent.mm.media.j.b.e)localObject2).qx(m);
          ((com.tencent.mm.media.j.b.a)localObject2).iju = bool1;
          ((com.tencent.mm.media.j.b.e)localObject2).hDl = ((com.tencent.mm.media.g.d)localObject1).igv;
          ((com.tencent.mm.media.j.b.e)localObject2).cZ(i, j);
          ((com.tencent.mm.media.j.b.e)localObject2).cY(j, i);
          ((com.tencent.mm.media.j.b.e)localObject2).dc(j, i);
          ((com.tencent.mm.media.j.b.a)localObject2).ijM = true;
          ((com.tencent.mm.media.j.b.e)localObject2).aED();
          AppMethodBeat.o(236325);
          return;
        }
      }
      AppMethodBeat.o(236325);
      return;
    }
    AppMethodBeat.o(236325);
    return;
    this.Hpc = this.Hpd;
    AppMethodBeat.o(236325);
    return;
    label1901:
    AppMethodBeat.o(236325);
    return;
    label1908:
    localObject2 = ((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEx;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.j.b.e)localObject2).qx(m);
      ((com.tencent.mm.media.j.b.a)localObject2).iju = bool1;
      ((com.tencent.mm.media.j.b.e)localObject2).hDl = ((com.tencent.mm.media.g.d)localObject1).igv;
      ((com.tencent.mm.media.j.b.e)localObject2).cZ(i, j);
      ((com.tencent.mm.media.j.b.e)localObject2).cY(j, i);
      ((com.tencent.mm.media.j.b.e)localObject2).dc(j, i);
      ((com.tencent.mm.media.j.b.a)localObject2).ijM = true;
      ((com.tencent.mm.media.j.b.e)localObject2).aED();
      AppMethodBeat.o(236325);
      return;
    }
    label1983:
    AppMethodBeat.o(236325);
    return;
    label1990:
    AppMethodBeat.o(236325);
  }
  
  public final void bm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(236318);
    Log.i("MicroMsg.VoipRenderProcExternalTexture", "setSTFilter(Hseasun), isON:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.HoX == 1)
    {
      this.HoW = 0;
      AppMethodBeat.o(236318);
      return;
    }
    this.HoW = paramInt;
    if (this.HoW == 1)
    {
      if (this.HoQ == null) {
        this.HoQ = new com.tencent.mm.plugin.voip.video.c.e();
      }
      Log.i("MicroMsg.VoipRenderProcExternalTexture", "faceBeautyAlgo:  " + this.HoX + ", isFaceBeautyAlogChanged: " + this.HoV);
      if ((this.HoX == 0) || (this.HoX == 3))
      {
        Object localObject = this.HoQ;
        r localr;
        if (localObject != null)
        {
          localr = (r)new c(this);
          p.h(localr, "callback");
          if (!((com.tencent.mm.plugin.voip.video.c.e)localObject).Hmt) {
            break label219;
          }
          localObject = ((com.tencent.mm.plugin.voip.video.c.e)localObject).Hms;
          if (localObject != null) {
            ((a)localObject).HmO = localr;
          }
        }
        for (;;)
        {
          this.HoX = 3;
          this.ijy = 2;
          this.HoV = true;
          this.HoY = 1;
          this.Hpa = paramBoolean;
          AppMethodBeat.o(236318);
          return;
          label219:
          com.tencent.mm.media.j.b.e locale = ((com.tencent.mm.plugin.voip.video.c.e)localObject).hEx;
          if (locale != null) {
            locale.ijK = ((kotlin.g.a.b)new e.b((com.tencent.mm.plugin.voip.video.c.e)localObject, localr));
          }
        }
      }
      if (this.HoX != 3) {
        this.HoY = 0;
      }
    }
    AppMethodBeat.o(236318);
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236321);
    if ((paramInt1 != this.hEp) || (paramInt2 != this.hEq))
    {
      super.cY(paramInt1, paramInt2);
      this.HoU = true;
    }
    AppMethodBeat.o(236321);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236320);
    super.cZ(paramInt1, paramInt2);
    this.HoU = true;
    AppMethodBeat.o(236320);
  }
  
  public final Integer fMb()
  {
    AppMethodBeat.i(236322);
    int i = this.hEp;
    AppMethodBeat.o(236322);
    return Integer.valueOf(i);
  }
  
  public final Integer fMc()
  {
    AppMethodBeat.i(236323);
    int i = this.hEq;
    AppMethodBeat.o(236323);
    return Integer.valueOf(i);
  }
  
  public final void jO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236319);
    Log.printInfoStack("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.HiD = paramInt1;
    Object localObject2;
    Object localObject1;
    if ((this.HoX != paramInt2) && (this.HoX != 3) && (paramInt1 != 0))
    {
      this.HoX = paramInt2;
      this.HoU = true;
      this.HoV = true;
      switch (paramInt2)
      {
      default: 
        if (this.HoN == null)
        {
          this.HoN = new com.tencent.mm.plugin.voip.video.c.c();
          localObject2 = this.HoN;
          if (localObject2 != null)
          {
            localObject1 = (r)new f(this);
            p.h(localObject1, "callback");
            if (!((com.tencent.mm.plugin.voip.video.c.c)localObject2).Hmt) {
              break label453;
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.c)localObject2).Hms;
            if (localObject2 != null) {
              ((a)localObject2).HmO = ((r)localObject1);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = h.Hhl;
      h.a.adK(0);
      this.ijy = 1;
      AppMethodBeat.o(236319);
      return;
      this.HoV = false;
      break;
      if (this.HoP == null)
      {
        this.HoP = new com.tencent.mm.plugin.voip.video.c.g();
        localObject2 = this.HoP;
        if (localObject2 != null)
        {
          localObject1 = (r)new d(this);
          p.h(localObject1, "callback");
          if (!((com.tencent.mm.plugin.voip.video.c.g)localObject2).Hmt) {
            break label293;
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject2).Hms;
          if (localObject2 != null) {
            ((a)localObject2).HmO = ((r)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = h.Hhl;
        h.a.adK(1);
        Log.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
        this.ijy = 2;
        AppMethodBeat.o(236319);
        return;
        label293:
        locale = ((com.tencent.mm.plugin.voip.video.c.g)localObject2).hEx;
        if (locale != null) {
          locale.ijK = ((kotlin.g.a.b)new g.b((com.tencent.mm.plugin.voip.video.c.g)localObject2, (r)localObject1));
        }
      }
      if (this.HoO == null)
      {
        this.HoO = new com.tencent.mm.plugin.voip.video.c.b();
        localObject2 = this.HoO;
        if (localObject2 != null)
        {
          localObject1 = (r)new e(this);
          p.h(localObject1, "callback");
          if (!((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hmt) {
            break label420;
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).Hms;
          if (localObject2 != null) {
            ((a)localObject2).HmO = ((r)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = h.Hhl;
        h.a.adK(2);
        this.ijy = 2;
        AppMethodBeat.o(236319);
        return;
        label420:
        locale = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).hEx;
        if (locale != null) {
          locale.ijK = ((kotlin.g.a.b)new b.a((com.tencent.mm.plugin.voip.video.c.b)localObject2, (r)localObject1));
        }
      }
      label453:
      com.tencent.mm.media.j.b.e locale = ((com.tencent.mm.plugin.voip.video.c.c)localObject2).hEx;
      if (locale != null) {
        locale.ijK = ((kotlin.g.a.b)new com.tencent.mm.plugin.voip.video.c.c.a((com.tencent.mm.plugin.voip.video.c.c)localObject2, (r)localObject1));
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(236327);
    super.release();
    Object localObject1 = this.HoN;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.c)localObject1).Hms;
      if (localObject2 != null) {
        ((a)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.c)localObject1).hEx;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject1).programId);
    }
    localObject1 = this.HoP;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject1).hEx;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject1).hEv;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject1).HmH;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        Log.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).hDm;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).hiH != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).hiH;
        if (localObject3 == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).hiH = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    Object localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject1).Hms;
    if (localObject2 != null) {
      ((a)localObject2).release();
    }
    GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.g)localObject1).programId);
    localObject1 = this.HoO;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject1).Hms;
      if (localObject2 != null) {
        ((a)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject1).hEx;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject1).programId);
    }
    GLES20.glDeleteProgram(this.programId);
    AppMethodBeat.o(236327);
  }
  
  public final void rl(int paramInt)
  {
    this.ikx = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class c
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class d
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class e
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    e(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class f
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    f(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */