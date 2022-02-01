package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "MSG_LOAD_DATA", "", "MSG_PROCESS_IMG_DATA", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "setLoading", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "getScene", "()I", "setScene", "(I)V", "taskHandler", "com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1;", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "finishImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "onLoadData", "onPrepareImageData", "processImageData", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public final int NIu;
  final int NIv;
  final LinkedList<com.tencent.mm.bx.b> NIw;
  int[] NIx;
  public long NIy;
  public final a NIz;
  final String TAG;
  public kotlin.g.a.b<? super LinkedList<dls>, ah> callback;
  public boolean cancel;
  private boolean isLoading;
  private float latitude;
  private float longitude;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> mjD;
  private int scene;
  int thumbHeight;
  int thumbWidth;
  private long vYw;
  public boolean wDG;
  
  public a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.mjD = paramb;
    this.NIv = 1;
    this.TAG = "MicroMsg.AbsGetRecommendAudioTask";
    this.NIw = new LinkedList();
    this.NIx = new int[0];
    this.thumbWidth = 299;
    this.thumbHeight = 299;
    paramb = com.tencent.mm.plugin.recordvideo.model.a.NIt;
    this.NIz = new a(this, com.tencent.mm.plugin.recordvideo.model.a.gHI().getLooper());
    int i = ((c)h.ax(c.class)).a(c.a.yIJ, 299);
    this.thumbWidth = i;
    this.thumbHeight = i;
    Log.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.thumbWidth + " thumbHeight " + this.thumbHeight + " thumbTarget " + i);
  }
  
  private static final Void a(a parama, b.a parama1)
  {
    s.u(parama, "this$0");
    parama.isLoading = false;
    int i = parama1.errType;
    int j = parama1.errCode;
    Object localObject = parama1.errMsg;
    Log.i(parama.TAG, "LogStory: getRecommendMusic callback " + i + ' ' + j + ", " + localObject);
    if ((i != 0) || (j != 0))
    {
      parama = parama.callback;
      if (parama != null) {
        parama.invoke(new LinkedList());
      }
      return com.tencent.mm.vending.c.a.aguz;
    }
    localObject = (dlp)parama1.ott;
    parama.NIy = ((dlp)localObject).NII;
    parama1 = ((dlp)localObject).ZPz;
    Log.i(parama.TAG, s.X("get audio list ", localObject));
    parama = parama.callback;
    if (parama != null)
    {
      s.s(parama1, "audioList");
      parama.invoke(parama1);
    }
    return com.tencent.mm.vending.c.a.aguz;
  }
  
  protected final void L(int[] paramArrayOfInt)
  {
    s.u(paramArrayOfInt, "<set-?>");
    this.NIx = paramArrayOfInt;
  }
  
  public final void aWi()
  {
    this.NIz.obtainMessage(this.NIv).sendToTarget();
  }
  
  public abstract Bitmap agx(int paramInt);
  
  public final void gHJ()
  {
    Log.i(this.TAG, "onLoadData: " + this.isLoading + ' ' + this.cancel);
    if ((this.isLoading) || (this.cancel)) {
      return;
    }
    this.isLoading = true;
    e locale = new e(this.NIw, this.latitude, this.longitude, this.NIy, this.vYw, this.scene, (byte)0);
    locale.otr = true;
    locale.bFJ().a(this.mjD).b(new a..ExternalSyntheticLambda0(this));
  }
  
  public abstract void gHK();
  
  public abstract void gHL();
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  protected final void kq(long paramLong)
  {
    this.vYw = paramLong;
  }
  
  protected final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends Handler
  {
    a(a parama, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(75397);
      s.u(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == this.NIA.NIu)
      {
        this.NIA.gHK();
        paramMessage = this.NIA;
        int m = 1;
        if ((paramMessage.thumbHeight <= 0) || (paramMessage.thumbWidth <= 0))
        {
          Log.i(paramMessage.TAG, "get image data fail!");
          i = 0;
        }
        for (;;)
        {
          label67:
          if (i == 0)
          {
            int j = 0;
            paramMessage.NIw.clear();
            Object localObject1 = BitmapUtil.Bitmap2Bytes(Bitmap.createBitmap(299, 299, Bitmap.Config.ARGB_8888), 50);
            int k = paramMessage.NIx.length;
            i = 0;
            for (;;)
            {
              if (i < k)
              {
                Object localObject2 = new com.tencent.mm.bx.b((byte[])localObject1);
                paramMessage.NIw.add(localObject2);
                j += ((com.tencent.mm.bx.b)localObject2).Op.length;
                i += 1;
                continue;
                localObject1 = Bitmap.createBitmap(paramMessage.thumbWidth, paramMessage.thumbHeight, Bitmap.Config.ARGB_8888);
                paramMessage.NIw.clear();
                localObject2 = paramMessage.NIx;
                i = 0;
                int n = localObject2.length;
                j = 0;
                k = 0;
                while (j < n)
                {
                  localObject2 = paramMessage.agx(i);
                  Canvas localCanvas = new Canvas((Bitmap)localObject1);
                  s.checkNotNull(localObject2);
                  localCanvas.drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, paramMessage.thumbWidth, paramMessage.thumbHeight), null);
                  localObject2 = new com.tencent.mm.bx.b(BitmapUtil.Bitmap2Bytes((Bitmap)localObject1, 50));
                  paramMessage.NIw.add(localObject2);
                  k += ((com.tencent.mm.bx.b)localObject2).Op.length;
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
                break label67;
              }
            }
            Log.i(paramMessage.TAG, s.X("backup imageData size:", Integer.valueOf(j)));
          }
        }
        paramMessage = this.NIA;
        paramMessage.gHL();
        if (paramMessage.wDG) {
          paramMessage.aWi();
        }
        AppMethodBeat.o(75397);
        return;
      }
      if (i == this.NIA.NIv) {
        this.NIA.gHJ();
      }
      AppMethodBeat.o(75397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.a
 * JD-Core Version:    0.7.0.1
 */