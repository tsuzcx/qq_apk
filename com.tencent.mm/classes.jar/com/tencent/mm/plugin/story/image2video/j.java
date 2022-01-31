package com.tencent.mm.plugin.story.image2video;

import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryImageVideoRender;", "", "()V", "lastBlendBitmapId", "", "getLastBlendBitmapId", "()I", "setLastBlendBitmapId", "(I)V", "mHeight", "getMHeight", "setMHeight", "mImagePlayer", "Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer;", "getMImagePlayer", "()Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer;", "setMImagePlayer", "(Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer;)V", "mSimpleImageShader", "Lcom/tencent/mm/plugin/story/image2video/SimpleImageShader;", "getMSimpleImageShader", "()Lcom/tencent/mm/plugin/story/image2video/SimpleImageShader;", "setMSimpleImageShader", "(Lcom/tencent/mm/plugin/story/image2video/SimpleImageShader;)V", "mWidth", "getMWidth", "setMWidth", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "step", "getStep", "setStep", "addImages", "", "imageList", "", "", "clearImage", "initGL", "onDrawBlendBitmap", "bitmap", "Landroid/graphics/Bitmap;", "onDrawFrame", "onGLDestroy", "resetGL", "resetTs", "setStepTime", "setViewport", "width", "height", "Companion", "plugin-story_release"})
public final class j
{
  static final String TAG = "MicroMsg.Story.StoryImageVideoRender";
  public static final j.a sug;
  int mHeight;
  int mWidth;
  long startTime;
  long suc;
  i sud;
  h sue;
  int suf;
  
  static
  {
    AppMethodBeat.i(151055);
    sug = new j.a((byte)0);
    TAG = "MicroMsg.Story.StoryImageVideoRender";
    AppMethodBeat.o(151055);
  }
  
  public j()
  {
    AppMethodBeat.i(151054);
    this.suc = 33L;
    this.sud = new i();
    this.sue = new h();
    AppMethodBeat.o(151054);
  }
  
  final void czY()
  {
    AppMethodBeat.i(151053);
    this.sud.czW();
    this.sud.czX();
    this.suf = 0;
    AppMethodBeat.o(151053);
  }
  
  public final void dD(List<String> paramList)
  {
    AppMethodBeat.i(151052);
    a.f.b.j.q(paramList, "imageList");
    g localg = new g(ah.getContext());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.sud.a(str, localg);
    }
    localg.destroy();
    AppMethodBeat.o(151052);
  }
  
  public final void onDrawFrame()
  {
    AppMethodBeat.i(151051);
    long l = System.currentTimeMillis();
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
    GLES20.glClear(16384);
    this.sud.n(this.startTime, this.mWidth, this.mHeight);
    this.startTime += this.suc;
    ab.i(TAG, "draw cost:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(151051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.j
 * JD-Core Version:    0.7.0.1
 */