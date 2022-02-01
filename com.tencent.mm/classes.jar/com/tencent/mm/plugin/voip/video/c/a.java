package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "hwPixelFormat", "", "hwProgramId", "mInputTexture", "needUpdateMatrix", "rotateIdxMap", "", "[[Ljava/lang/Integer;", "softProgramId", "surfaceHeight", "surfaceWidth", "textureLeft", "", "textureRight", "uniformFlipX", "uniformFlipY", "uniformTexLeft", "uniformTexture", "uniformUseY", "uniformXOffset", "uniformYOffset", "initDrawCoordBuffer", "", "refreshToHwProgram", "refreshToSoftProgram", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateSurfaceSize", "Companion", "plugin-voip_release"})
public final class a
  extends com.tencent.mm.media.j.b.a
{
  public static final a.a CIv;
  public final int CIh;
  public final int CIi;
  public int CIj;
  public int CIk;
  public int CIl;
  public int CIm;
  public int CIn;
  public int CIo;
  public int CIp;
  private boolean CIq;
  private float CIr;
  private float CIs;
  public boolean CIt;
  private final Integer[][] CIu;
  private final int gOw;
  private final int gOx;
  public int gOy;
  public int surfaceHeight;
  public int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(210487);
    CIv = new a.a((byte)0);
    AppMethodBeat.o(210487);
  }
  
  public a()
  {
    this(0, 31);
  }
  
  private a(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(210485);
    this.CIp = -1;
    this.CIq = true;
    this.CIs = 1.0F;
    this.CIt = true;
    Object localObject = c.hrD;
    localObject = com.tencent.mm.media.c.a.hkS;
    localObject = com.tencent.mm.media.c.a.atx();
    com.tencent.mm.media.c.a.a locala = com.tencent.mm.media.c.a.hkS;
    this.CIh = c.a.az((String)localObject, com.tencent.mm.media.c.a.aty());
    localObject = c.hrD;
    localObject = com.tencent.mm.media.c.a.hkS;
    localObject = com.tencent.mm.media.c.a.atz();
    locala = com.tencent.mm.media.c.a.hkS;
    this.CIi = c.a.az((String)localObject, com.tencent.mm.media.c.a.atA());
    this.gOw = 0;
    this.gOx = 1;
    ng(0);
    localObject = new Integer[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(1) };
    this.CIu = ((Integer[][])new Integer[][] { { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }, localObject, { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0) }, { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(2) } });
    AppMethodBeat.o(210485);
  }
  
  public final void aur()
  {
    AppMethodBeat.i(210483);
    if (!this.CIq)
    {
      AppMethodBeat.o(210483);
      return;
    }
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = this.CIr;
    arrayOfFloat1[1] = 0.0F;
    arrayOfFloat1[2] = this.CIs;
    arrayOfFloat1[3] = 0.0F;
    arrayOfFloat1[4] = this.CIr;
    arrayOfFloat1[5] = 1.0F;
    arrayOfFloat1[6] = this.CIs;
    arrayOfFloat1[7] = 1.0F;
    Integer[] arrayOfInteger = this.CIu[(this.hpY / 90 % 4)];
    float[] arrayOfFloat2 = new float[8];
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFloat2[(i * 2)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2)];
      arrayOfFloat2[(i * 2 + 1)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2 + 1)];
      i += 1;
    }
    this.gNU.put(arrayOfFloat2).position(0);
    this.gNV.position(0);
    this.gNV.put(c.hrw);
    this.gNV.position(0);
    this.CIq = false;
    AppMethodBeat.o(210483);
  }
  
  public final void aut()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(210484);
    if (this.CIp == -1)
    {
      AppMethodBeat.o(210484);
      return;
    }
    GLES30.glViewport(0, this.surfaceHeight - this.gOn, this.gOm, this.gOn);
    int i;
    if (this.CIt)
    {
      GLES30.glUseProgram(this.CIh);
      GLES30.glActiveTexture(33984);
      GLES30.glBindTexture(3553, this.CIp);
      GLES30.glTexParameteri(3553, 10241, 9729);
      GLES30.glTexParameteri(3553, 10240, 9729);
      GLES30.glTexParameteri(3553, 10242, 33071);
      GLES30.glTexParameteri(3553, 10243, 33071);
      GLES30.glUniform1i(this.gOy, 0);
      GLES30.glUniform1f(this.CIo, this.CIr);
      GLES30.glUniform1f(this.CIj, 1.0F / this.gOm / 4.0F);
      i = this.CIl;
      if ((Math.abs(this.hpY) != 90) && (Math.abs(this.hpY) != 270)) {
        break label382;
      }
      f1 = 0.0F;
      label185:
      GLES30.glUniform1f(i, f1);
      i = this.CIm;
      if ((this.hpY != -90) && (this.hpY != 270)) {
        break label387;
      }
      f1 = 1.0F;
      label216:
      GLES30.glUniform1f(i, f1);
      i = this.CIn;
      if (Math.abs(this.hpY) != 180) {
        break label392;
      }
    }
    label387:
    label392:
    for (float f1 = f2;; f1 = 0.0F)
    {
      GLES30.glUniform1f(i, f1);
      this.gNV.position(0);
      GLES30.glVertexAttribPointer(this.gOw, 2, 5126, false, 0, (Buffer)this.gNV);
      GLES30.glEnableVertexAttribArray(this.gOw);
      this.gNU.position(0);
      GLES30.glVertexAttribPointer(this.gOx, 2, 5126, false, 0, (Buffer)this.gNU);
      GLES30.glEnableVertexAttribArray(this.gOx);
      GLES30.glDrawArrays(5, 0, 4);
      GLES30.glDisableVertexAttribArray(this.gOw);
      GLES30.glDisableVertexAttribArray(this.gOx);
      GLES30.glBindTexture(3553, 0);
      GLES30.glBindTexture(36197, 0);
      AppMethodBeat.o(210484);
      return;
      GLES30.glUseProgram(this.CIi);
      GLES30.glUniform1f(this.CIk, 2.0F / this.gOn);
      break;
      label382:
      f1 = 1.0F;
      break label185;
      f1 = 0.0F;
      break label216;
    }
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210481);
    int i = paramInt2 / 4;
    int j = paramInt1 * 3 / 2;
    if ((i == this.gOm) && (j == this.gOn))
    {
      AppMethodBeat.o(210481);
      return;
    }
    float f = paramInt2 / this.gNt;
    f = paramInt1 / this.gNs / f;
    super.cT(i, j);
    this.CIr = ((1.0F - f) / 2.0F);
    this.CIs = (1.0F - this.CIr);
    this.CIq = true;
    AppMethodBeat.o(210481);
  }
  
  public final void nQ(int paramInt)
  {
    this.CIp = paramInt;
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(210482);
    paramInt = (paramInt + 360 - 90) % 360;
    if (paramInt != this.hpY) {
      this.CIq = true;
    }
    super.ng(paramInt);
    AppMethodBeat.o(210482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.a
 * JD-Core Version:    0.7.0.1
 */