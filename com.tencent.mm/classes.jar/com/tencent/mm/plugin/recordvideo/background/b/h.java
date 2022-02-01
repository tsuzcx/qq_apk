package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.blur.e;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "", "()V", "enableX264Encoder", "", "getEnableX264Encoder", "()Z", "setEnableX264Encoder", "(Z)V", "lastBlendBitmapId", "", "getLastBlendBitmapId", "()I", "setLastBlendBitmapId", "(I)V", "mHeight", "getMHeight", "setMHeight", "mImagePlayer", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "getMImagePlayer", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "setMImagePlayer", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "mSimpleImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;", "getMSimpleImageShader", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;", "setMSimpleImageShader", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;)V", "mWidth", "getMWidth", "setMWidth", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "step", "getStep", "setStep", "addImages", "", "imageList", "", "", "clearImage", "initGL", "onDrawBlendBitmap", "bitmap", "Landroid/graphics/Bitmap;", "onDrawFrame", "onGLDestroy", "resetGL", "resetTs", "setStepTime", "setViewport", "width", "height", "Companion", "plugin-recordvideo_release"})
public final class h
{
  static final String TAG = "MicroMsg.Story.StoryImageVideoRender";
  public static final h.a xwj;
  int mHeight;
  int mWidth;
  public long startTime;
  long xwe;
  public g xwf;
  f xwg;
  boolean xwh;
  int xwi;
  
  static
  {
    AppMethodBeat.i(75320);
    xwj = new h.a((byte)0);
    TAG = "MicroMsg.Story.StoryImageVideoRender";
    AppMethodBeat.o(75320);
  }
  
  public h()
  {
    AppMethodBeat.i(75319);
    this.xwe = 33L;
    this.xwf = new g();
    this.xwg = new f();
    AppMethodBeat.o(75319);
  }
  
  final void dFl()
  {
    AppMethodBeat.i(75318);
    this.xwf.dFj();
    this.xwf.dFk();
    this.xwi = 0;
    AppMethodBeat.o(75318);
  }
  
  public final void fa(List<String> paramList)
  {
    AppMethodBeat.i(75317);
    p.h(paramList, "imageList");
    e locale = new e(aj.getContext());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.xwf.a(str, locale);
    }
    locale.destroy();
    AppMethodBeat.o(75317);
  }
  
  public final void onDrawFrame()
  {
    AppMethodBeat.i(75316);
    long l = System.currentTimeMillis();
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
    GLES20.glClear(16384);
    this.xwf.o(this.startTime, this.mWidth, this.mHeight);
    this.startTime += this.xwe;
    ad.i(TAG, "draw cost:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(75316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.h
 * JD-Core Version:    0.7.0.1
 */