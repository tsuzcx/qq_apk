package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "MSG_LOAD_DATA", "", "MSG_PROCESS_IMG_DATA", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "setLoading", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "getScene", "()I", "setScene", "(I)V", "taskHandler", "com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1;", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "finishImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "onLoadData", "onPrepareImageData", "processImageData", "plugin-recordvideo_release"})
public abstract class a
{
  final int BOP;
  final int BOQ;
  final LinkedList<com.tencent.mm.bw.b> BOR;
  int[] BOS;
  public long BOT;
  private final b BOU;
  final String TAG;
  public kotlin.g.a.b<? super LinkedList<clp>, x> callback;
  public boolean cancel;
  float dTj;
  final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
  boolean isLoading;
  float latitude;
  long pLQ;
  public boolean qdn;
  int scene;
  int thumbHeight;
  int thumbWidth;
  
  public a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.gZm = paramb;
    this.BOQ = 1;
    this.TAG = "MicroMsg.AbsGetRecommendAudioTask";
    this.BOR = new LinkedList();
    this.BOS = new int[0];
    this.thumbWidth = 299;
    this.thumbHeight = 299;
    paramb = com.tencent.mm.plugin.recordvideo.model.a.BOO;
    this.BOU = new b(this, com.tencent.mm.plugin.recordvideo.model.a.eJP().getLooper());
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPv, 299);
    this.thumbWidth = i;
    this.thumbHeight = i;
    Log.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.thumbWidth + " thumbHeight " + this.thumbHeight + " thumbTarget " + i);
  }
  
  protected final void I(int[] paramArrayOfInt)
  {
    p.h(paramArrayOfInt, "<set-?>");
    this.BOS = paramArrayOfInt;
  }
  
  public abstract Bitmap VB(int paramInt);
  
  public final void cJk()
  {
    this.BOU.obtainMessage(this.BOQ).sendToTarget();
  }
  
  public final void eJQ()
  {
    this.BOU.obtainMessage(this.BOP).sendToTarget();
  }
  
  public abstract void eJR();
  
  public abstract void eJS();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-recordvideo_release"})
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
        i = this.BOV.BOP;
        if (paramMessage != null) {
          break label52;
        }
      }
      label52:
      while (paramMessage.intValue() != i)
      {
        i = this.BOV.BOQ;
        if (paramMessage != null) {
          break label454;
        }
        AppMethodBeat.o(75397);
        return;
        paramMessage = null;
        break;
      }
      this.BOV.eJR();
      paramMessage = this.BOV;
      int m = 1;
      if ((paramMessage.thumbHeight <= 0) || (paramMessage.thumbWidth <= 0))
      {
        Log.i(paramMessage.TAG, "get image data fail!");
        i = 0;
      }
      for (;;)
      {
        label100:
        if (i == 0)
        {
          int j = 0;
          paramMessage.BOR.clear();
          Object localObject1 = BitmapUtil.Bitmap2Bytes(Bitmap.createBitmap(299, 299, Bitmap.Config.ARGB_8888), 50);
          int k = paramMessage.BOS.length;
          i = 0;
          for (;;)
          {
            if (i < k)
            {
              Object localObject2 = new com.tencent.mm.bw.b((byte[])localObject1);
              paramMessage.BOR.add(localObject2);
              j += ((com.tencent.mm.bw.b)localObject2).zy.length;
              i += 1;
              continue;
              localObject1 = Bitmap.createBitmap(paramMessage.thumbWidth, paramMessage.thumbHeight, Bitmap.Config.ARGB_8888);
              paramMessage.BOR.clear();
              localObject2 = paramMessage.BOS;
              i = 0;
              int n = localObject2.length;
              j = 0;
              k = 0;
              while (j < n)
              {
                localObject2 = paramMessage.VB(i);
                Canvas localCanvas = new Canvas((Bitmap)localObject1);
                if (localObject2 == null) {
                  p.hyc();
                }
                localCanvas.drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, paramMessage.thumbWidth, paramMessage.thumbHeight), null);
                localObject2 = new com.tencent.mm.bw.b(BitmapUtil.Bitmap2Bytes((Bitmap)localObject1, 50));
                paramMessage.BOR.add(localObject2);
                k += ((com.tencent.mm.bw.b)localObject2).zy.length;
                j += 1;
                i += 1;
              }
              Log.i(paramMessage.TAG, "imageData size:" + k + " thumbWidth:" + paramMessage.thumbWidth + " thumbHeight:" + paramMessage.thumbHeight);
              paramMessage.thumbWidth /= 2;
              paramMessage.thumbHeight /= 2;
              if (k > 102400) {
                break;
              }
              i = m;
              break label100;
            }
          }
          Log.i(paramMessage.TAG, "backup imageData size:".concat(String.valueOf(j)));
        }
      }
      paramMessage = this.BOV;
      paramMessage.eJS();
      if (paramMessage.qdn) {
        paramMessage.cJk();
      }
      AppMethodBeat.o(75397);
      return;
      label454:
      if (paramMessage.intValue() == i)
      {
        paramMessage = this.BOV;
        Log.i(paramMessage.TAG, "onLoadData: " + paramMessage.isLoading + ' ' + paramMessage.cancel);
        if ((paramMessage.isLoading) || (paramMessage.cancel))
        {
          AppMethodBeat.o(75397);
          return;
        }
        paramMessage.isLoading = true;
        new e(paramMessage.BOR, paramMessage.latitude, paramMessage.dTj, paramMessage.BOT, paramMessage.pLQ, paramMessage.scene, (byte)0).aYH().aYI().a(paramMessage.gZm).b((com.tencent.mm.vending.c.a)new a.a(paramMessage));
      }
      AppMethodBeat.o(75397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.a
 * JD-Core Version:    0.7.0.1
 */