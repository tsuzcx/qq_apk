package com.tencent.mm.plugin.story.image2video;

import a.f.a.a;
import a.f.a.b;
import a.f.a.q;
import a.l;
import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class e$b
  implements Runnable
{
  e$b(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(150993);
    Object localObject = this.sth;
    ((e)localObject).pts += this.sth.stb;
    this.sth.ssZ.onDrawFrame();
    localObject = this.sth.std;
    if (localObject != null) {}
    for (localObject = (Bitmap)((b)localObject).S(Long.valueOf(this.sth.pts * 1000L));; localObject = null)
    {
      if (localObject != null)
      {
        j localj = this.sth.ssZ;
        a.f.b.j.q(localObject, "bitmap");
        localj.sue.czQ();
        localj.sue.a(a.a.ssG, localj.mWidth, localj.mHeight, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        GLES20.glActiveTexture(33984);
        localj.suf = h.c((Bitmap)localObject, localj.suf);
        localj.sue.FE(localj.suf);
        localj.sue.j(localj.sue.str);
        h.czS();
      }
      this.sth.sta.swapBuffers();
      localObject = e.a(this.sth);
      if (localObject != null) {
        ((q)localObject).d(null, Long.valueOf(this.sth.pts * 1000L), new MediaCodec.BufferInfo());
      }
      localObject = this.sth.eVT;
      if (localObject != null) {
        ((b)localObject).S(Boolean.TRUE);
      }
      if (this.sth.pts < 15000L) {
        break;
      }
      this.sth.stc = true;
      localObject = e.b(this.sth);
      if (localObject == null) {
        break;
      }
      ((a)localObject).invoke();
      AppMethodBeat.o(150993);
      return;
    }
    AppMethodBeat.o(150993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.e.b
 * JD-Core Version:    0.7.0.1
 */