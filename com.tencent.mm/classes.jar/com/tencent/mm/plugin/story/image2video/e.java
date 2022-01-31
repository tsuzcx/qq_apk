package com.tencent.mm.plugin.story.image2video;

import a.f.a.m;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "width", "", "height", "init", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "getDrawCallback", "setDrawCallback", "glThread", "Lcom/tencent/mm/plugin/story/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/story/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/story/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "getInit", "()Lkotlin/jvm/functions/Function2;", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/story/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/story/image2video/StoryImageVideoRender;", "stepTime", "getStepTime", "setStepTime", "getWidth", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.media.c.b
{
  private static final String TAG = "MicroMsg.MediaCodecFakeDecoder";
  public static final e.a stg;
  a.f.a.b<? super Boolean, y> eVT;
  private final int height;
  long pts;
  final j ssZ;
  c sta;
  long stb;
  boolean stc;
  a.f.a.b<? super Long, Bitmap> std;
  ArrayList<String> ste;
  final m<e, Boolean, y> stf;
  private final int width;
  
  static
  {
    AppMethodBeat.i(151000);
    stg = new e.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(151000);
  }
  
  public e(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, m<? super e, ? super Boolean, y> paramm)
  {
    super(paramLong1, paramLong2, null, paramSurface);
    AppMethodBeat.i(150999);
    this.ste = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.stf = paramm;
    this.ssZ = new j();
    this.stb = (1000L / d.ssU);
    this.ssZ.suc = this.stb;
    this.sta = new c(paramSurface, this.ssZ);
    this.sta.cR(this.width, this.height);
    this.sta.start();
    this.sta.postJob((Runnable)new e.1(this));
    AppMethodBeat.o(150999);
  }
  
  private void requestRender()
  {
    AppMethodBeat.i(150996);
    ab.i(TAG, "requestRender");
    if (this.stc)
    {
      AppMethodBeat.o(150996);
      return;
    }
    this.sta.postJob((Runnable)new e.b(this));
    AppMethodBeat.o(150996);
  }
  
  public final void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(150997);
    ab.d(TAG, "setPauseDecoder ".concat(String.valueOf(paramBoolean)));
    this.cvo = paramBoolean;
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(150997);
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(150998);
    super.pJ();
    this.sta.stop();
    AppMethodBeat.o(150998);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(150995);
    this.sta.postJob((Runnable)new e.c(this));
    requestRender();
    AppMethodBeat.o(150995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.e
 * JD-Core Version:    0.7.0.1
 */