package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import d.y;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "MSG_LOAD_DATA", "", "MSG_PROCESS_IMG_DATA", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "setLoading", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "getScene", "()I", "setScene", "(I)V", "taskHandler", "com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1;", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "finishImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "onLoadData", "onPrepareImageData", "processImageData", "plugin-recordvideo_release"})
public abstract class a
{
  final String TAG;
  public boolean cancel;
  float dpb;
  float dqQ;
  public d.g.a.b<? super LinkedList<boa>, y> fLy;
  final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fOI;
  boolean isLoading;
  public boolean nCD;
  int scene;
  int thumbHeight;
  int thumbWidth;
  long tiV;
  public final int vir;
  final int vis;
  final LinkedList<com.tencent.mm.bx.b> vit;
  int[] viu;
  public long viv;
  public final b vix;
  
  public a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fOI = paramb;
    this.vis = 1;
    this.TAG = "MicroMsg.AbsGetRecommendAudioTask";
    this.vit = new LinkedList();
    this.viu = new int[0];
    this.thumbWidth = 299;
    this.thumbHeight = 299;
    paramb = com.tencent.mm.plugin.recordvideo.model.a.viq;
    this.vix = new b(this, com.tencent.mm.plugin.recordvideo.model.a.dhI().getLooper());
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjC, 299);
    this.thumbWidth = i;
    this.thumbHeight = i;
    ad.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.thumbWidth + " thumbHeight " + this.thumbHeight + " thumbTarget " + i);
  }
  
  protected final void D(int[] paramArrayOfInt)
  {
    k.h(paramArrayOfInt, "<set-?>");
    this.viu = paramArrayOfInt;
  }
  
  public abstract Bitmap Kj(int paramInt);
  
  public final void bYc()
  {
    this.vix.obtainMessage(this.vis).sendToTarget();
  }
  
  public abstract void dhJ();
  
  public abstract void dhK();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(a parama) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-recordvideo_release"})
  public static final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(75397);
      int i;
      if (paramMessage != null)
      {
        paramMessage = Integer.valueOf(paramMessage.what);
        i = this.viy.vir;
        if (paramMessage != null) {
          break label52;
        }
      }
      label52:
      while (paramMessage.intValue() != i)
      {
        i = this.viy.vis;
        if (paramMessage != null) {
          break label442;
        }
        AppMethodBeat.o(75397);
        return;
        paramMessage = null;
        break;
      }
      this.viy.dhJ();
      paramMessage = this.viy;
      int m = 1;
      if ((paramMessage.thumbHeight <= 0) || (paramMessage.thumbWidth <= 0))
      {
        ad.i(paramMessage.TAG, "get image data fail!");
        i = 0;
      }
      for (;;)
      {
        label100:
        if (i == 0)
        {
          int j = 0;
          paramMessage.vit.clear();
          Object localObject1 = com.tencent.mm.sdk.platformtools.f.j(Bitmap.createBitmap(299, 299, Bitmap.Config.ARGB_8888), 50);
          int k = paramMessage.viu.length;
          i = 0;
          for (;;)
          {
            if (i < k)
            {
              Object localObject2 = new com.tencent.mm.bx.b((byte[])localObject1);
              paramMessage.vit.add(localObject2);
              j += ((com.tencent.mm.bx.b)localObject2).getBytes().length;
              i += 1;
              continue;
              localObject1 = Bitmap.createBitmap(paramMessage.thumbWidth, paramMessage.thumbHeight, Bitmap.Config.ARGB_8888);
              paramMessage.vit.clear();
              localObject2 = paramMessage.viu;
              i = 0;
              int n = localObject2.length;
              j = 0;
              k = 0;
              while (j < n)
              {
                localObject2 = paramMessage.Kj(i);
                new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, paramMessage.thumbWidth, paramMessage.thumbHeight), null);
                localObject2 = new com.tencent.mm.bx.b(com.tencent.mm.sdk.platformtools.f.j((Bitmap)localObject1, 50));
                paramMessage.vit.add(localObject2);
                k += ((com.tencent.mm.bx.b)localObject2).getBytes().length;
                j += 1;
                i += 1;
              }
              ad.i(paramMessage.TAG, "imageData size:" + k + " thumbWidth:" + paramMessage.thumbWidth + " thumbHeight:" + paramMessage.thumbHeight);
              paramMessage.thumbWidth /= 2;
              paramMessage.thumbHeight /= 2;
              if (k > 102400) {
                break;
              }
              i = m;
              break label100;
            }
          }
          ad.i(paramMessage.TAG, "backup imageData size:".concat(String.valueOf(j)));
        }
      }
      paramMessage = this.viy;
      paramMessage.dhK();
      if (paramMessage.nCD) {
        paramMessage.bYc();
      }
      AppMethodBeat.o(75397);
      return;
      label442:
      if (paramMessage.intValue() == i)
      {
        paramMessage = this.viy;
        ad.i(paramMessage.TAG, "onLoadData: " + paramMessage.isLoading + ' ' + paramMessage.cancel);
        if ((paramMessage.isLoading) || (paramMessage.cancel))
        {
          AppMethodBeat.o(75397);
          return;
        }
        paramMessage.isLoading = true;
        new e(paramMessage.vit, paramMessage.dpb, paramMessage.dqQ, paramMessage.viv, paramMessage.tiV, paramMessage.scene, (byte)0).auK().a(paramMessage.fOI).b((com.tencent.mm.vending.c.a)new a.a(paramMessage));
      }
      AppMethodBeat.o(75397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.a
 * JD-Core Version:    0.7.0.1
 */