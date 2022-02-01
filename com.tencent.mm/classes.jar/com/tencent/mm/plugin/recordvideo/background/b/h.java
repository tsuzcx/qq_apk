package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "", "()V", "enableX264Encoder", "", "getEnableX264Encoder", "()Z", "setEnableX264Encoder", "(Z)V", "lastBlendBitmapId", "", "getLastBlendBitmapId", "()I", "setLastBlendBitmapId", "(I)V", "mHeight", "getMHeight", "setMHeight", "mImagePlayer", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "getMImagePlayer", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "setMImagePlayer", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "mSimpleImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;", "getMSimpleImageShader", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;", "setMSimpleImageShader", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/SimpleImageShader;)V", "mWidth", "getMWidth", "setMWidth", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "step", "getStep", "setStep", "addImages", "", "imageList", "", "", "clearImage", "initGL", "onDrawBlendBitmap", "bitmap", "Landroid/graphics/Bitmap;", "onDrawFrame", "onGLDestroy", "resetGL", "resetTs", "setStepTime", "setViewport", "width", "height", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a NFL;
  static final String TAG;
  public long NFM;
  public g NFN;
  f NFO;
  boolean NFP;
  int NFQ;
  int mHeight;
  int mWidth;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(75320);
    NFL = new h.a((byte)0);
    TAG = "MicroMsg.Story.StoryImageVideoRender";
    AppMethodBeat.o(75320);
  }
  
  public h()
  {
    AppMethodBeat.i(75319);
    this.NFM = 33L;
    this.NFN = new g();
    this.NFO = new f();
    AppMethodBeat.o(75319);
  }
  
  final void gHi()
  {
    AppMethodBeat.i(75318);
    this.NFN.gHg();
    this.NFN.gHh();
    this.NFQ = 0;
    AppMethodBeat.o(75318);
  }
  
  public final void jI(List<String> paramList)
  {
    AppMethodBeat.i(75317);
    s.u(paramList, "imageList");
    e locale = new e(MMApplicationContext.getContext());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.NFN.a(str, locale);
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
    this.NFN.w(this.startTime, this.mWidth, this.mHeight);
    this.startTime += this.NFM;
    Log.i(TAG, s.X("draw cost:", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(75316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.h
 * JD-Core Version:    0.7.0.1
 */