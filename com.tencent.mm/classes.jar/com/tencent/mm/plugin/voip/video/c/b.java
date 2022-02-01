package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class b
  extends com.tencent.mm.media.j.b.a
{
  public static final b.a CqT;
  private final int CqF;
  public int CqL;
  private final int CqS;
  private final int gLM;
  private final int gLN;
  private final int gLO;
  private final int gLP;
  private final int hom;
  
  static
  {
    AppMethodBeat.i(216071);
    CqT = new b.a((byte)0);
    AppMethodBeat.o(216071);
  }
  
  public b()
  {
    this(0, 31);
  }
  
  private b(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(216069);
    this.CqL = -1;
    Object localObject = c.hoP;
    localObject = com.tencent.mm.media.c.a.hie;
    localObject = com.tencent.mm.media.c.a.atg();
    a.a locala = com.tencent.mm.media.c.a.hie;
    this.gLM = c.a.ay((String)localObject, com.tencent.mm.media.c.a.ath());
    this.CqF = GLES30.glGetUniformLocation(this.gLM, "xoffset");
    this.CqS = GLES30.glGetUniformLocation(this.gLM, "yuvGap");
    this.gLP = GLES30.glGetUniformLocation(this.gLM, "inTexture");
    this.gLN = 0;
    this.gLO = 1;
    this.hom = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    this.hny = true;
    AppMethodBeat.o(216069);
  }
  
  public final void aue()
  {
    AppMethodBeat.i(216068);
    if (this.CqL == -1)
    {
      AppMethodBeat.o(216068);
      return;
    }
    GLES30.glUseProgram(this.gLM);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.CqL);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
    GLES30.glUniform1i(this.gLP, 0);
    GLES30.glUniform1f(this.CqF, 1.0F / this.gLD / 4.0F);
    GLES30.glUniform1f(this.CqS, 0.3333333F);
    GLES30.glUniformMatrix4fv(this.hom, 1, false, this.hnx, 0);
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
    AppMethodBeat.o(216068);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216067);
    super.cT(paramInt1 / 4, paramInt2 * 3 / 2);
    super.cW(paramInt1 / 4, paramInt2 * 3 / 2);
    AppMethodBeat.o(216067);
  }
  
  public final void nN(int paramInt)
  {
    this.CqL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.b
 * JD-Core Version:    0.7.0.1
 */