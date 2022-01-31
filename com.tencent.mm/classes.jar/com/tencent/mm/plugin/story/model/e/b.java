package com.tencent.mm.plugin.story.model.e;

import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.plugin.story.g.g;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "drawingRect", "", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useX264Encode", "", "(Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;Ljava/util/List;[FLjava/lang/String;Ljava/lang/String;IZ)V", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "getCaptureInfo", "()Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getDrawingRect", "()[F", "getEditorItems", "()Ljava/util/List;", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/media/mix/FrameInfo;", "getMixThumbPath", "()Ljava/lang/String;", "setMixThumbPath", "(Ljava/lang/String;)V", "getMixVideoPath", "setMixVideoPath", "onFinish", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "", "getRetryTime", "()I", "setRetryTime", "(I)V", "videoBitrate", "videoFrameRate", "videoHeight", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "createGraffitiThumb", "createThumb", "mix", "readPictureDegree", "path", "setMixConfig", "width", "height", "start", "Companion", "plugin-story_release"})
public final class b
{
  public static final b.a syS;
  private int audioSampleRate;
  private int ePE;
  private int eRF;
  public final a.f.a.b<Long, Bitmap> eVY;
  public final List<com.tencent.mm.media.editor.a.b> eVw;
  public int eWL;
  private final boolean eXv;
  private int fzT;
  public final float[] qaY;
  private q<? super String, ? super String, ? super Boolean, y> syL;
  private long syM;
  private c syN;
  public a syO;
  public final com.tencent.mm.plugin.story.e.a syP;
  String syQ;
  String syR;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(109339);
    syS = new b.a((byte)0);
    AppMethodBeat.o(109339);
  }
  
  private b(com.tencent.mm.plugin.story.e.a parama, List<com.tencent.mm.media.editor.a.b> paramList, float[] paramArrayOfFloat, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155301);
    this.syP = parama;
    this.eVw = paramList;
    this.qaY = paramArrayOfFloat;
    this.syQ = paramString1;
    this.syR = paramString2;
    this.ePE = paramInt;
    this.eXv = paramBoolean;
    this.syM = -1L;
    if (!e.cN(this.syQ))
    {
      parama = com.tencent.mm.plugin.story.model.l.svv;
      com.tencent.mm.plugin.story.model.l.add(this.syQ);
    }
    if (!e.cN(this.syR))
    {
      parama = com.tencent.mm.plugin.story.model.l.svv;
      com.tencent.mm.plugin.story.model.l.add(this.syR);
    }
    ab.i("MicroMsg.Media.StoryVideoMixer", "create StoryVideoMixer, videoPath:" + this.syP.ssl + ", outputFilePath:" + this.syQ + ", isCaptureVideo:" + this.syP.fbp + ", retryTime:" + this.ePE);
    if (!e.cN(this.syP.ssl))
    {
      parama = g.sEy;
      g.mg(this.syP.fbp);
    }
    this.eVY = ((a.f.a.b)new b.b(this));
    AppMethodBeat.o(155301);
  }
  
  public static int acP(String paramString)
  {
    AppMethodBeat.i(151079);
    j.q(paramString, "path");
    j = 0;
    for (;;)
    {
      try
      {
        int k = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
        i = j;
        switch (k)
        {
        default: 
          i = j;
        }
      }
      catch (IOException paramString)
      {
        int i = j;
        continue;
      }
      AppMethodBeat.o(151079);
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  private final String cBP()
  {
    boolean bool = true;
    AppMethodBeat.i(156675);
    Object localObject = com.tencent.mm.plugin.mmsight.d.aw(this.syQ, 20L);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.Media.StoryVideoMixer", "createThumb getParentAbsolutePath: " + e.avK(this.syR));
        e.cO(this.syR);
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, 70, Bitmap.CompressFormat.JPEG, this.syR, true);
        StringBuilder localStringBuilder = new StringBuilder(" mixVideoPath : ").append(this.syQ).append(" mixThumbPath:").append(this.syR).append("   thumb-bitmap is null:");
        if (localObject != null) {
          break label160;
        }
        ab.i("MicroMsg.Media.StoryVideoMixer", bool);
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(156675);
        return null;
      }
      catch (IOException localIOException)
      {
        localh = h.sEz;
        h.cDf();
        continue;
      }
      h localh = h.sEz;
      h.cDf();
      continue;
      label160:
      bool = false;
    }
    localObject = this.syR;
    AppMethodBeat.o(156675);
    return localObject;
  }
  
  private final void g(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(151078);
    if (this.syP.ssr != null)
    {
      Object localObject = this.syP.ssr;
      if (localObject == null) {
        j.ebi();
      }
      if (!((AudioCacheInfo)localObject).arq)
      {
        localObject = i.swW;
        localObject = i.cBF();
        AudioCacheInfo localAudioCacheInfo = this.syP.ssr;
        if (localAudioCacheInfo == null) {
          j.ebi();
        }
        ((i)localObject).a(localAudioCacheInfo, (m)new b.c(parama));
        AppMethodBeat.o(151078);
        return;
      }
    }
    parama.invoke();
    AppMethodBeat.o(151078);
  }
  
  public static Point ga(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109337);
    Point localPoint = new Point(paramInt1 * 1, paramInt2 * 1);
    AppMethodBeat.o(109337);
    return localPoint;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.videoBitrate = paramInt3;
    this.fzT = paramInt4;
    this.audioSampleRate = paramInt5;
    this.eRF = paramInt6;
    this.videoFrameRate = paramInt7;
    this.eWL = paramInt8;
  }
  
  public final void a(q<? super String, ? super String, ? super Boolean, y> paramq)
  {
    AppMethodBeat.i(109336);
    ab.i("MicroMsg.Media.StoryVideoMixer", "Start mixer " + bo.dtY());
    this.syL = paramq;
    g((a.f.a.a)new b.f(this, paramq));
    AppMethodBeat.o(109336);
  }
  
  public final void adl(String paramString)
  {
    AppMethodBeat.i(151080);
    j.q(paramString, "<set-?>");
    this.syQ = paramString;
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e.b
 * JD-Core Version:    0.7.0.1
 */