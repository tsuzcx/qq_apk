package com.tencent.mm.plugin.voip.video.render;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.plugin.voip.f.i.a;
import com.tencent.mm.plugin.voip.video.c.f;
import com.tencent.mm.plugin.voip.video.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "beautyInputTexture", "beautyParam", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalGLTextureID", "faceBeautyAlgo", "getFaceBeautyAlgo", "()I", "setFaceBeautyAlgo", "(I)V", "faceRotate", "isFaceBeautyAlogChanged", "", "()Z", "setFaceBeautyAlogChanged", "(Z)V", "isViewPortChange", "mSTFilterMotionNoiseDataCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseDataCallBack;", "getMSTFilterMotionNoiseDataCallback", "()Lkotlin/jvm/functions/Function2;", "setMSTFilterMotionNoiseDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "mSTFilterMotionNoiseDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseData;", "outputTexturObject", "programId", "stFilterOutputTexturObject", "stFilterProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "stfilterParam", "getStfilterParam", "setStfilterParam", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "useSTfilterScreenOut", "useSkipFilterProcess", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getDrawHeight", "()Ljava/lang/Integer;", "getDrawWidth", "getOutputRendererTexture", "getSTFilterMotionNoiseData", "release", "renderImpl", "setFaceRotate", "rotate", "setInputTexture", "texture", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoipBeauty", "algorithm", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.media.j.b.a
{
  private final String TAG;
  private int UNp;
  private int UTX;
  private g UTY;
  private f UTZ;
  private com.tencent.mm.plugin.voip.video.c.k UUa;
  private com.tencent.mm.plugin.voip.video.c.i UUb;
  private com.tencent.mm.media.g.d UUc;
  private int UUd;
  private boolean UUe;
  boolean UUf;
  private int UUg;
  private int UUh;
  private int UUi;
  private boolean UUj;
  private com.tencent.mm.media.g.d UUk;
  private com.tencent.mm.media.g.d UUl;
  private com.tencent.mm.plugin.voip.video.d.a UUm;
  kotlin.g.a.m<? super Integer, ? super Float, ah> UUn;
  int akjo;
  private int programId;
  
  public m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
    AppMethodBeat.i(293111);
    this.TAG = s.X("MicroMsg.VoipRenderProcExternalTexture@", Integer.valueOf(hashCode()));
    this.UTX = -1;
    this.UUd = -1;
    this.UUe = true;
    this.UUm = new com.tencent.mm.plugin.voip.video.d.a();
    AppMethodBeat.o(293111);
  }
  
  public final void a(com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(293130);
    s.u(paramd, "texture");
    this.UUc = paramd;
    this.UUd = paramd.nAF;
    Log.i(this.TAG, s.X("externalGLTextureID:", Integer.valueOf(this.UUd)));
    AppMethodBeat.o(293130);
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(293201);
    if (this.UUe)
    {
      bpV().position(0);
      bpV().put(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    }
    bpV().position(0);
    bpW().position(0);
    bpW().put(com.tencent.mm.media.util.c.nFt);
    bpW().position(0);
    if (this.nDF == null)
    {
      this.nDF = com.tencent.mm.media.g.c.d(true, 3L);
      localObject = com.tencent.mm.media.g.c.nAB;
      a(com.tencent.mm.media.g.c.hX(3L));
    }
    Object localObject = com.tencent.mm.media.util.c.nFs;
    c.a.a(bpX(), this.nDF, getDrawWidth(), getDrawHeight());
    GLES20.glViewport(0, 0, getDrawWidth(), getDrawHeight());
    AppMethodBeat.o(293201);
  }
  
  public final void bqf()
  {
    AppMethodBeat.i(293258);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(293258);
  }
  
  public final void bqg()
  {
    AppMethodBeat.i(293247);
    Object localObject1 = com.tencent.mm.plugin.voip.video.a.d.UPM;
    if (!com.tencent.mm.plugin.voip.video.a.d.UPO)
    {
      Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initRenderProc");
      com.tencent.mm.plugin.voip.video.a.d.UPO = true;
      com.tencent.mm.plugin.voip.video.a.d.UPP = new JSONArray();
    }
    Object localObject2 = this.nDF;
    if (localObject2 == null)
    {
      AppMethodBeat.o(293247);
      return;
    }
    localObject1 = this.UUc;
    if ((localObject1 != null) && (((com.tencent.mm.media.g.d)localObject1).nAx == true)) {}
    for (int i = 1; (i != 0) || (this.UUd < 0) || (!GLES30.glIsTexture(this.UUd)); i = 0)
    {
      Log.e(this.TAG, "render error externalTexture already released");
      AppMethodBeat.o(293247);
      return;
    }
    Object localObject3;
    int j;
    int k;
    if (this.UUg == 1)
    {
      if (this.UUn == null) {
        this.UUn = ((kotlin.g.a.m)new m.a(this));
      }
      localObject1 = this.UUm;
      if (localObject1 == null)
      {
        AppMethodBeat.o(293247);
        return;
      }
      localObject3 = this.UUb;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.voip.video.c.i)localObject3).A(((com.tencent.mm.plugin.voip.video.d.a)localObject1).UUK, ((com.tencent.mm.plugin.voip.video.d.a)localObject1).UUL);
      }
      localObject3 = this.UUb;
      if (localObject3 != null)
      {
        i = getDrawWidth();
        j = getDrawHeight();
        FloatBuffer localFloatBuffer1 = bpW();
        FloatBuffer localFloatBuffer2 = bpV();
        k = this.UUd;
        boolean bool = this.UUj;
        s.u(localFloatBuffer1, "cubeBuffer");
        s.u(localFloatBuffer2, "textureCoordBuff");
        s.u(localObject2, "outputTexture");
        if (k == -1) {
          break label826;
        }
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = com.tencent.mm.media.util.c.nFs;
        c.a.a(((com.tencent.mm.plugin.voip.video.c.i)localObject3).URs, ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URr, i, j);
        GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.i)localObject3).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWx, 0);
        localFloatBuffer1.position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWv, 2, 5126, false, 0, (Buffer)localFloatBuffer1);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWv);
        localFloatBuffer2.position(0);
        GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWw, 2, 5126, false, 0, (Buffer)localFloatBuffer2);
        GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWv);
        GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWw);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        com.tencent.mm.cm.a.e locale;
        if ((((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWs == null) && (((com.tencent.mm.plugin.voip.video.c.i)localObject3).URq != null))
        {
          localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWs;
          if (localObject1 != null) {
            ((com.tencent.mm.media.g.d)localObject1).close();
          }
          ((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWs = com.tencent.mm.media.g.c.d(true, 14L);
          locale = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URq;
          if (locale != null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWs;
            if (localObject1 != null) {
              break label764;
            }
            localObject1 = null;
            s.checkNotNull(localObject1);
            locale.aFN(((Integer)localObject1).intValue());
          }
        }
        if (!bool)
        {
          locale = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URq;
          if (locale != null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URq;
            if (localObject1 != null) {
              ((com.tencent.mm.cm.a.e)localObject1).pg(i, j);
            }
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URr;
            if (localObject1 != null) {
              break label777;
            }
            localObject1 = null;
            label569:
            s.checkNotNull(localObject1);
            i = ((Integer)localObject1).intValue();
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URr;
            if (localObject1 != null) {
              break label790;
            }
            localObject1 = null;
            label595:
            s.checkNotNull(localObject1);
            j = ((Integer)localObject1).intValue();
            localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URr;
            if (localObject1 != null) {
              break label803;
            }
            localObject1 = null;
            label621:
            s.checkNotNull(localObject1);
            locale.a(i, j, ((Integer)localObject1).intValue(), localFloatBuffer1, localFloatBuffer2);
          }
        }
        if (bool) {
          break label816;
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).mWs;
        label654:
        if (localObject1 != null)
        {
          this.UUl = ((com.tencent.mm.media.g.d)localObject1);
          this.UTX = ((com.tencent.mm.media.g.d)localObject1).nAF;
        }
      }
      label674:
      switch (this.UUh)
      {
      default: 
        localObject1 = com.tencent.mm.plugin.voip.video.a.d.UPM;
        if (!com.tencent.mm.plugin.voip.video.a.d.icS()) {
          break label1246;
        }
        ub(2);
        localObject1 = this.UUa;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.voip.video.c.k)localObject1).Be(false);
        }
        localObject1 = this.UUa;
        if (localObject1 != null) {
          break;
        }
      }
    }
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.voip.video.c.k)localObject1).a(getDrawWidth(), getDrawHeight(), bpW(), bpV(), this.akjo, this.UTX, (com.tencent.mm.media.g.d)localObject2, this.UNp, this.UUg))
    {
      this.UUk = ((com.tencent.mm.media.g.d)localObject1);
      AppMethodBeat.o(293247);
      return;
      label764:
      localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).nAF);
      break;
      label777:
      localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).nAF);
      break label569;
      label790:
      localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).nAF);
      break label595;
      label803:
      localObject1 = Integer.valueOf(((com.tencent.mm.media.g.d)localObject1).nAF);
      break label621;
      label816:
      localObject1 = ((com.tencent.mm.plugin.voip.video.c.i)localObject3).URr;
      break label654;
      label826:
      localObject1 = localObject2;
      break label654;
      this.UTX = this.UUd;
      break label674;
      localObject1 = this.UUa;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.voip.video.c.k)localObject1).Be(true);
      }
      localObject1 = this.UUa;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.voip.video.c.k)localObject1).a(getDrawWidth(), getDrawHeight(), bpW(), bpV(), this.akjo, this.UTX, (com.tencent.mm.media.g.d)localObject2, this.UNp, this.UUg))
      {
        this.UUk = ((com.tencent.mm.media.g.d)localObject1);
        AppMethodBeat.o(293247);
        return;
      }
      localObject1 = this.UTZ;
      if (localObject1 == null) {
        break label1413;
      }
      i = getDrawWidth();
      j = getDrawHeight();
      localObject2 = bpW();
      localObject3 = bpV();
      k = this.UUd;
      s.u(localObject2, "cubeBuffer");
      s.u(localObject3, "textureCoordBuff");
      if (k != -1)
      {
        GLES20.glUseProgram(((f)localObject1).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, k);
        GLES20.glUniform1i(((f)localObject1).mWx, 0);
        GLES20.glUniform1f(((f)localObject1).UPT, 0.5F);
        GLES20.glUniform1i(((f)localObject1).UPU, 0);
        GLES20.glUniform1i(((f)localObject1).UPV, 2);
        GLES20.glUniform1f(((f)localObject1).UPW, 0.8F);
        GLES20.glUniform1f(((f)localObject1).UPX, i);
        GLES20.glUniform1f(((f)localObject1).UPY, j);
        ((FloatBuffer)localObject2).position(0);
        GLES20.glVertexAttribPointer(((f)localObject1).mWv, 2, 5126, false, 8, (Buffer)localObject2);
        GLES20.glEnableVertexAttribArray(((f)localObject1).mWv);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((f)localObject1).mWw, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((f)localObject1).mWw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((f)localObject1).mWv);
        GLES20.glDisableVertexAttribArray(((f)localObject1).mWw);
        GLES20.glBindTexture(36197, 0);
      }
      AppMethodBeat.o(293247);
      return;
      this.UUk = this.UUl;
      AppMethodBeat.o(293247);
      return;
    }
    label1246:
    ub(1);
    localObject1 = this.UTY;
    if (localObject1 != null)
    {
      localObject2 = bpW();
      localObject3 = bpV();
      i = this.UUd;
      s.u(localObject2, "cubeBuffer");
      s.u(localObject3, "textureCoordBuff");
      if (i != -1)
      {
        GLES20.glUseProgram(((g)localObject1).programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(((g)localObject1).mWx, 0);
        GLES20.glVertexAttribPointer(((g)localObject1).mWv, 2, 5126, false, 8, (Buffer)localObject2);
        GLES20.glEnableVertexAttribArray(((g)localObject1).mWv);
        GLES20.glVertexAttribPointer(((g)localObject1).mWw, 2, 5126, false, 8, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((g)localObject1).mWw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((g)localObject1).mWv);
        GLES20.glDisableVertexAttribArray(((g)localObject1).mWw);
      }
    }
    this.UUk = null;
    label1413:
    AppMethodBeat.o(293247);
  }
  
  public final void cf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(293143);
    Log.i(this.TAG, "setSTFilter(Hseasun), isON:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.UUh == 1)
    {
      this.UUg = 0;
      AppMethodBeat.o(293143);
      return;
    }
    this.UUg = paramInt;
    if (this.UUg == 1)
    {
      if (this.UUb == null) {
        this.UUb = new com.tencent.mm.plugin.voip.video.c.i();
      }
      Log.i(this.TAG, "faceBeautyAlgo:  " + this.UUh + ", isFaceBeautyAlogChanged: " + this.UUf);
      if ((this.UUh == 0) || (this.UUh == 3))
      {
        this.UUh = 3;
        ub(2);
        this.UUf = true;
        this.UUi = 1;
        this.UUj = paramBoolean;
        AppMethodBeat.o(293143);
        return;
      }
      if (this.UUh != 3) {
        this.UUi = 0;
      }
    }
    AppMethodBeat.o(293143);
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293175);
    if ((paramInt1 != getDrawWidth()) || (paramInt2 != getDrawHeight()))
    {
      super.ek(paramInt1, paramInt2);
      this.UUe = true;
    }
    AppMethodBeat.o(293175);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293164);
    super.el(paramInt1, paramInt2);
    this.UUe = true;
    AppMethodBeat.o(293164);
  }
  
  public final Integer idC()
  {
    AppMethodBeat.i(293186);
    int i = getDrawWidth();
    AppMethodBeat.o(293186);
    return Integer.valueOf(i);
  }
  
  public final Integer idD()
  {
    AppMethodBeat.i(293194);
    int i = getDrawHeight();
    AppMethodBeat.o(293194);
    return Integer.valueOf(i);
  }
  
  public final com.tencent.mm.media.g.d idE()
  {
    if (this.UUk != null) {
      return this.UUk;
    }
    return this.nDF;
  }
  
  public final void mP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293157);
    Log.printInfoStack(this.TAG, "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.UNp = paramInt1;
    if ((this.UUh != paramInt2) && (this.UUh != 3) && (paramInt1 != 0))
    {
      this.UUh = paramInt2;
      this.UUe = true;
    }
    i.a locala;
    for (this.UUf = true;; this.UUf = false) {
      switch (paramInt2)
      {
      default: 
        if (this.UTY == null)
        {
          this.UTY = new g();
          locala = com.tencent.mm.plugin.voip.f.i.ULP;
          i.a.arf(0);
        }
        if (this.UUa == null) {
          this.UUa = new com.tencent.mm.plugin.voip.video.c.k();
        }
        ub(1);
        AppMethodBeat.o(293157);
        return;
      }
    }
    if (this.UUa == null)
    {
      this.UUa = new com.tencent.mm.plugin.voip.video.c.k();
      locala = com.tencent.mm.plugin.voip.f.i.ULP;
      i.a.arf(1);
    }
    Log.i(this.TAG, "render YT face-beauty algorithm");
    ub(2);
    AppMethodBeat.o(293157);
    return;
    if (this.UTZ == null)
    {
      this.UTZ = new f();
      locala = com.tencent.mm.plugin.voip.f.i.ULP;
      i.a.arf(2);
    }
    ub(2);
    AppMethodBeat.o(293157);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293270);
    super.release();
    Object localObject1 = this.UTY;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((g)localObject1).programId);
    }
    localObject1 = this.UUa;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.k)localObject1).mWs;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.k)localObject1).URv;
      if (localObject2 != null) {
        Log.i(com.tencent.mm.plugin.voip.video.a.e.TAG, "clear %s %d", new Object[] { localObject2, Long.valueOf(Thread.currentThread().getId()) });
      }
    }
    try
    {
      Object localObject3 = ((com.tencent.mm.plugin.voip.video.a.e)localObject2).mVc;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.e)localObject2).muW != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.e)localObject2).muW;
        s.checkNotNull(localObject3);
        ((com.tencent.mm.plugin.xlabeffect.k)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.e)localObject2).muW = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.e.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.k)localObject1).programId);
    localObject1 = this.UTZ;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((f)localObject1).programId);
    }
    localObject1 = this.UUb;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.i)localObject1).URr;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.i)localObject1).URs;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.a)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.i)localObject1).mWs;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.i)localObject1).URq;
      if (localObject2 != null) {
        ((com.tencent.mm.cm.a.e)localObject2).destroy();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.i)localObject1).programId);
    }
    com.tencent.mm.plugin.voip.video.a.d.a(com.tencent.mm.plugin.voip.video.a.d.UPM);
    com.tencent.mm.plugin.voip.video.a.d.UPO = false;
    GLES20.glDeleteProgram(this.programId);
    AppMethodBeat.o(293270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.m
 * JD-Core Version:    0.7.0.1
 */