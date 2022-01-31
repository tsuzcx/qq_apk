package com.tencent.mm.plugin.story.image2video;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(150929);
    Object localObject1 = this.ssT;
    ab.i("MicroMsg.Story.GLThread", "initGL");
    Object localObject2 = com.tencent.mm.media.i.b.eZw;
    ((c)localObject1).ssS = b.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0);
    if (((c)localObject1).ssR != null)
    {
      localObject1 = ((c)localObject1).ssR;
      ab.i(j.TAG, "initGL");
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      localObject2 = ((j)localObject1).sud;
      ((i)localObject2).stI.czR();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      g localg = ((i)localObject2).stJ;
      if (localg != null) {
        localg.destroy();
      }
      ((i)localObject2).stJ = new g(ah.getContext());
      ((j)localObject1).czY();
      ((j)localObject1).sue.czR();
    }
    ab.i("MicroMsg.Story.GLThread", "initGL succ");
    AppMethodBeat.o(150929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.c.1
 * JD-Core Version:    0.7.0.1
 */