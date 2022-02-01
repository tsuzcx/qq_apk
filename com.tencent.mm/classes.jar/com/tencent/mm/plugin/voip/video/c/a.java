package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "hwPixelFormat", "", "hwProgramId", "mInputTexture", "needUpdateMatrix", "rotateIdxMap", "", "[[Ljava/lang/Integer;", "softProgramId", "surfaceHeight", "surfaceWidth", "textureLeft", "", "textureRight", "uniformFlipX", "uniformFlipY", "uniformTexLeft", "uniformTexture", "uniformUseY", "uniformXOffset", "uniformYOffset", "initDrawCoordBuffer", "", "refreshToHwProgram", "refreshToSoftProgram", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateSurfaceSize", "Companion", "plugin-voip_release"})
public final class a
  extends com.tencent.mm.media.j.b.a
{
  public static final a.a CqR;
  public final int CqD;
  public final int CqE;
  public int CqF;
  public int CqG;
  public int CqH;
  public int CqI;
  public int CqJ;
  public int CqK;
  public int CqL;
  private boolean CqM;
  private float CqN;
  private float CqO;
  public boolean CqP;
  private final Integer[][] CqQ;
  private final int gLN;
  private final int gLO;
  public int gLP;
  public int surfaceHeight;
  public int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(216066);
    CqR = new a.a((byte)0);
    AppMethodBeat.o(216066);
  }
  
  public a()
  {
    this(0, 31);
  }
  
  private a(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(216064);
    this.CqL = -1;
    this.CqM = true;
    this.CqO = 1.0F;
    this.CqP = true;
    Object localObject1 = c.hoP;
    localObject1 = com.tencent.mm.media.c.a.hie;
    localObject1 = com.tencent.mm.media.c.a.ati();
    Object localObject2 = com.tencent.mm.media.c.a.hie;
    this.CqD = c.a.ay((String)localObject1, com.tencent.mm.media.c.a.atj());
    localObject1 = c.hoP;
    localObject1 = com.tencent.mm.media.c.a.hie;
    localObject1 = com.tencent.mm.media.c.a.atk();
    localObject2 = com.tencent.mm.media.c.a.hie;
    this.CqE = c.a.ay((String)localObject1, com.tencent.mm.media.c.a.atl());
    this.gLN = 0;
    this.gLO = 1;
    nd(0);
    localObject1 = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) };
    localObject2 = new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0) };
    Integer[] arrayOfInteger = { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(2) };
    this.CqQ = ((Integer[][])new Integer[][] { localObject1, { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(1) }, localObject2, arrayOfInteger });
    AppMethodBeat.o(216064);
  }
  
  public final void auc()
  {
    AppMethodBeat.i(216062);
    if (!this.CqM)
    {
      AppMethodBeat.o(216062);
      return;
    }
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = this.CqN;
    arrayOfFloat1[1] = 0.0F;
    arrayOfFloat1[2] = this.CqO;
    arrayOfFloat1[3] = 0.0F;
    arrayOfFloat1[4] = this.CqN;
    arrayOfFloat1[5] = 1.0F;
    arrayOfFloat1[6] = this.CqO;
    arrayOfFloat1[7] = 1.0F;
    Integer[] arrayOfInteger = this.CqQ[(this.hnk / 90 % 4)];
    float[] arrayOfFloat2 = new float[8];
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFloat2[(i * 2)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2)];
      arrayOfFloat2[(i * 2 + 1)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2 + 1)];
      i += 1;
    }
    this.gLl.put(arrayOfFloat2).position(0);
    this.gLm.position(0);
    this.gLm.put(c.hoI);
    this.gLm.position(0);
    this.CqM = false;
    AppMethodBeat.o(216062);
  }
  
  public final void aue()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(216063);
    if (this.CqL == -1)
    {
      AppMethodBeat.o(216063);
      return;
    }
    GLES30.glViewport(0, this.surfaceHeight - this.gLE, this.gLD, this.gLE);
    int i;
    if (this.CqP)
    {
      GLES30.glUseProgram(this.CqD);
      GLES30.glActiveTexture(33984);
      GLES30.glBindTexture(3553, this.CqL);
      GLES30.glTexParameteri(3553, 10241, 9729);
      GLES30.glTexParameteri(3553, 10240, 9729);
      GLES30.glTexParameteri(3553, 10242, 33071);
      GLES30.glTexParameteri(3553, 10243, 33071);
      GLES30.glUniform1i(this.gLP, 0);
      GLES30.glUniform1f(this.CqK, this.CqN);
      GLES30.glUniform1f(this.CqF, 1.0F / this.gLD / 4.0F);
      i = this.CqH;
      if ((Math.abs(this.hnk) != 90) && (Math.abs(this.hnk) != 270)) {
        break label382;
      }
      f1 = 0.0F;
      label185:
      GLES30.glUniform1f(i, f1);
      i = this.CqI;
      if ((this.hnk != -90) && (this.hnk != 270)) {
        break label387;
      }
      f1 = 1.0F;
      label216:
      GLES30.glUniform1f(i, f1);
      i = this.CqJ;
      if (Math.abs(this.hnk) != 180) {
        break label392;
      }
    }
    label387:
    label392:
    for (float f1 = f2;; f1 = 0.0F)
    {
      GLES30.glUniform1f(i, f1);
      this.gLm.position(0);
      GLES30.glVertexAttribPointer(this.gLN, 2, 5126, false, 0, (Buffer)this.gLm);
      GLES30.glEnableVertexAttribArray(this.gLN);
      this.gLl.position(0);
      GLES30.glVertexAttribPointer(this.gLO, 2, 5126, false, 0, (Buffer)this.gLl);
      GLES30.glEnableVertexAttribArray(this.gLO);
      GLES30.glDrawArrays(5, 0, 4);
      GLES30.glDisableVertexAttribArray(this.gLN);
      GLES30.glDisableVertexAttribArray(this.gLO);
      GLES30.glBindTexture(3553, 0);
      GLES30.glBindTexture(36197, 0);
      AppMethodBeat.o(216063);
      return;
      GLES30.glUseProgram(this.CqE);
      GLES30.glUniform1f(this.CqG, 2.0F / this.gLE);
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
    AppMethodBeat.i(216060);
    int i = paramInt2 / 4;
    int j = paramInt1 * 3 / 2;
    if ((i == this.gLD) && (j == this.gLE))
    {
      AppMethodBeat.o(216060);
      return;
    }
    float f = paramInt2 / this.gKK;
    f = paramInt1 / this.gKJ / f;
    super.cT(i, j);
    this.CqN = ((1.0F - f) / 2.0F);
    this.CqO = (1.0F - this.CqN);
    this.CqM = true;
    AppMethodBeat.o(216060);
  }
  
  public final void nN(int paramInt)
  {
    this.CqL = paramInt;
  }
  
  public final void nd(int paramInt)
  {
    AppMethodBeat.i(216061);
    paramInt = (paramInt + 360 - 90) % 360;
    if (paramInt != this.hnk) {
      this.CqM = true;
    }
    super.nd(paramInt);
    AppMethodBeat.o(216061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.a
 * JD-Core Version:    0.7.0.1
 */