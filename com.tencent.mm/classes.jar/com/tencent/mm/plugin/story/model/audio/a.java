package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.a.f;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/AbsGetRecommendAudioTask;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "", "getScene", "()I", "setScene", "(I)V", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "onPrepareImageData", "processImageData", "plugin-story_release"})
public abstract class a
{
  public final String TAG = "MicroMsg.AbsGetRecommendAudioTask";
  private float cAH;
  private float cyV;
  public a.f.a.b<? super LinkedList<bsq>, y> evv;
  public int fgQ;
  public int fgR;
  boolean isLoading;
  long qZL;
  int scene;
  public final LinkedList<com.tencent.mm.bv.b> swl = new LinkedList();
  public int[] swm = new int[0];
  public long swn;
  
  public a()
  {
    Object localObject = a.f.sGk;
    this.fgR = a.f.cED();
    localObject = a.f.sGk;
    this.fgQ = a.f.cED();
    localObject = (com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class);
    com.tencent.mm.plugin.expt.a.a.a locala = com.tencent.mm.plugin.expt.a.a.a.lSi;
    a.f localf = a.f.sGk;
    int i = ((com.tencent.mm.plugin.expt.a.a)localObject).a(locala, a.f.cED());
    this.fgR = i;
    this.fgQ = i;
    ab.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.fgR + " thumbHeight " + this.fgQ + " thumbTarget " + i);
  }
  
  protected final void A(int[] paramArrayOfInt)
  {
    j.q(paramArrayOfInt, "<set-?>");
    this.swm = paramArrayOfInt;
  }
  
  public abstract Bitmap FI(int paramInt);
  
  public abstract void cBr();
  
  public abstract void cBs();
  
  public final void ccL()
  {
    ab.i(this.TAG, "loadMore: " + this.isLoading);
    if (this.isLoading) {
      return;
    }
    this.isLoading = true;
    new e(this.swl, this.cyV, this.cAH, this.swn, this.qZL, this.scene, 0, 64).adl().b((com.tencent.mm.vending.c.a)new a.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.a
 * JD-Core Version:    0.7.0.1
 */