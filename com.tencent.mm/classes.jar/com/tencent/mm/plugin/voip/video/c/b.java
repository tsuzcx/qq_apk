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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class b
  extends com.tencent.mm.media.j.b.a
{
  public static final b.a CIx;
  private final int CIj;
  public int CIp;
  private final int CIw;
  private final int gOv;
  private final int gOw;
  private final int gOx;
  private final int gOy;
  private final int hra;
  
  static
  {
    AppMethodBeat.i(210492);
    CIx = new b.a((byte)0);
    AppMethodBeat.o(210492);
  }
  
  public b()
  {
    this(0, 31);
  }
  
  private b(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(210490);
    this.CIp = -1;
    Object localObject = c.hrD;
    localObject = com.tencent.mm.media.c.a.hkS;
    localObject = com.tencent.mm.media.c.a.atv();
    a.a locala = com.tencent.mm.media.c.a.hkS;
    this.gOv = c.a.az((String)localObject, com.tencent.mm.media.c.a.atw());
    this.CIj = GLES30.glGetUniformLocation(this.gOv, "xoffset");
    this.CIw = GLES30.glGetUniformLocation(this.gOv, "yuvGap");
    this.gOy = GLES30.glGetUniformLocation(this.gOv, "inTexture");
    this.gOw = 0;
    this.gOx = 1;
    this.hra = GLES20.glGetUniformLocation(this.gOv, "uMatrix");
    this.hqm = true;
    AppMethodBeat.o(210490);
  }
  
  public final void aut()
  {
    AppMethodBeat.i(210489);
    if (this.CIp == -1)
    {
      AppMethodBeat.o(210489);
      return;
    }
    GLES30.glUseProgram(this.gOv);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.CIp);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
    GLES30.glUniform1i(this.gOy, 0);
    GLES30.glUniform1f(this.CIj, 1.0F / this.gOm / 4.0F);
    GLES30.glUniform1f(this.CIw, 0.3333333F);
    GLES30.glUniformMatrix4fv(this.hra, 1, false, this.hql, 0);
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
    AppMethodBeat.o(210489);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210488);
    super.cT(paramInt1 / 4, paramInt2 * 3 / 2);
    super.cW(paramInt1 / 4, paramInt2 * 3 / 2);
    AppMethodBeat.o(210488);
  }
  
  public final void nQ(int paramInt)
  {
    this.CIp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.b
 * JD-Core Version:    0.7.0.1
 */