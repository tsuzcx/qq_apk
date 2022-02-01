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
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.y;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "MSG_LOAD_DATA", "", "MSG_PROCESS_IMG_DATA", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "setLoading", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "getScene", "()I", "setScene", "(I)V", "taskHandler", "com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1;", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "finishImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "onLoadData", "onPrepareImageData", "processImageData", "plugin-recordvideo_release"})
public abstract class a
{
  final String TAG;
  public boolean cancel;
  float dmL;
  float doB;
  public d.g.a.b<? super LinkedList<bsq>, y> fPk;
  final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fSt;
  boolean isLoading;
  public boolean ofE;
  int scene;
  int thumbHeight;
  int thumbWidth;
  long urm;
  public final int wrb;
  final int wrc;
  final LinkedList<com.tencent.mm.bw.b> wrd;
  int[] wre;
  public long wrf;
  public final b wrg;
  
  public a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fSt = paramb;
    this.wrc = 1;
    this.TAG = "MicroMsg.AbsGetRecommendAudioTask";
    this.wrd = new LinkedList();
    this.wre = new int[0];
    this.thumbWidth = 299;
    this.thumbHeight = 299;
    paramb = com.tencent.mm.plugin.recordvideo.model.a.wra;
    this.wrg = new b(this, com.tencent.mm.plugin.recordvideo.model.a.dvq().getLooper());
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMT, 299);
    this.thumbWidth = i;
    this.thumbHeight = i;
    ac.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.thumbWidth + " thumbHeight " + this.thumbHeight + " thumbTarget " + i);
  }
  
  protected final void D(int[] paramArrayOfInt)
  {
    k.h(paramArrayOfInt, "<set-?>");
    this.wre = paramArrayOfInt;
  }
  
  public abstract Bitmap Mh(int paramInt);
  
  public final void cfp()
  {
    this.wrg.obtainMessage(this.wrc).sendToTarget();
  }
  
  public abstract void dvr();
  
  public abstract void dvs();
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(a parama) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-recordvideo_release"})
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
        i = this.wrh.wrb;
        if (paramMessage != null) {
          break label52;
        }
      }
      label52:
      while (paramMessage.intValue() != i)
      {
        i = this.wrh.wrc;
        if (paramMessage != null) {
          break label442;
        }
        AppMethodBeat.o(75397);
        return;
        paramMessage = null;
        break;
      }
      this.wrh.dvr();
      paramMessage = this.wrh;
      int m = 1;
      if ((paramMessage.thumbHeight <= 0) || (paramMessage.thumbWidth <= 0))
      {
        ac.i(paramMessage.TAG, "get image data fail!");
        i = 0;
      }
      for (;;)
      {
        label100:
        if (i == 0)
        {
          int j = 0;
          paramMessage.wrd.clear();
          Object localObject1 = com.tencent.mm.sdk.platformtools.f.j(Bitmap.createBitmap(299, 299, Bitmap.Config.ARGB_8888), 50);
          int k = paramMessage.wre.length;
          i = 0;
          for (;;)
          {
            if (i < k)
            {
              Object localObject2 = new com.tencent.mm.bw.b((byte[])localObject1);
              paramMessage.wrd.add(localObject2);
              j += ((com.tencent.mm.bw.b)localObject2).getBytes().length;
              i += 1;
              continue;
              localObject1 = Bitmap.createBitmap(paramMessage.thumbWidth, paramMessage.thumbHeight, Bitmap.Config.ARGB_8888);
              paramMessage.wrd.clear();
              localObject2 = paramMessage.wre;
              i = 0;
              int n = localObject2.length;
              j = 0;
              k = 0;
              while (j < n)
              {
                localObject2 = paramMessage.Mh(i);
                new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, paramMessage.thumbWidth, paramMessage.thumbHeight), null);
                localObject2 = new com.tencent.mm.bw.b(com.tencent.mm.sdk.platformtools.f.j((Bitmap)localObject1, 50));
                paramMessage.wrd.add(localObject2);
                k += ((com.tencent.mm.bw.b)localObject2).getBytes().length;
                j += 1;
                i += 1;
              }
              ac.i(paramMessage.TAG, "imageData size:" + k + " thumbWidth:" + paramMessage.thumbWidth + " thumbHeight:" + paramMessage.thumbHeight);
              paramMessage.thumbWidth /= 2;
              paramMessage.thumbHeight /= 2;
              if (k > 102400) {
                break;
              }
              i = m;
              break label100;
            }
          }
          ac.i(paramMessage.TAG, "backup imageData size:".concat(String.valueOf(j)));
        }
      }
      paramMessage = this.wrh;
      paramMessage.dvs();
      if (paramMessage.ofE) {
        paramMessage.cfp();
      }
      AppMethodBeat.o(75397);
      return;
      label442:
      if (paramMessage.intValue() == i)
      {
        paramMessage = this.wrh;
        ac.i(paramMessage.TAG, "onLoadData: " + paramMessage.isLoading + ' ' + paramMessage.cancel);
        if ((paramMessage.isLoading) || (paramMessage.cancel))
        {
          AppMethodBeat.o(75397);
          return;
        }
        paramMessage.isLoading = true;
        new e(paramMessage.wrd, paramMessage.dmL, paramMessage.doB, paramMessage.wrf, paramMessage.urm, paramMessage.scene, (byte)0).aBB().a(paramMessage.fSt).b((com.tencent.mm.vending.c.a)new a.a(paramMessage));
      }
      AppMethodBeat.o(75397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.a
 * JD-Core Version:    0.7.0.1
 */