package com.tencent.mm.ui.k;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.f.f.c;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.ad;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "future", "Ljava/util/concurrent/Future;", "mContext", "mHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mHandlerCallback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "mInflateRunnable", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRunnable;", "cancel", "", "inflate", "resid", "", "parent", "Landroid/view/ViewGroup;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "callback", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "serialTag", "", "isRunning", "", "obtainRequest", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "releaseRequest", "obj", "Companion", "InflateRequest", "InflateRunnable", "OnInflateFinishedListener", "libmmui_release"})
public final class a
{
  private static final f.c<b> XIP;
  public static final a.a XIQ;
  c XIN;
  private final MMHandler.Callback XIO;
  Future<?> fuk;
  private Context mContext;
  private MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(218033);
    XIQ = new a.a((byte)0);
    XIP = new f.c(10);
    AppMethodBeat.o(218033);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(218032);
    this.XIO = ((MMHandler.Callback)new e(this));
    this.mContext = paramContext;
    this.mHandler = new MMHandler(Looper.getMainLooper(), this.XIO);
    AppMethodBeat.o(218032);
  }
  
  public final void a(int paramInt, ViewGroup paramViewGroup, CountDownLatch paramCountDownLatch, d paramd, String paramString)
  {
    AppMethodBeat.i(218029);
    paramViewGroup = (b)XIP.acquire();
    if (paramViewGroup == null) {
      paramViewGroup = new b();
    }
    for (;;)
    {
      paramViewGroup.XIR = ((a)this);
      paramViewGroup.resId = paramInt;
      paramViewGroup.parent = null;
      paramViewGroup.XIS = paramd;
      paramViewGroup.viX = paramCountDownLatch;
      paramViewGroup = new c(paramViewGroup);
      this.XIN = paramViewGroup;
      if (paramString == null) {}
      for (paramViewGroup = (Future)h.ZvG.bg((Runnable)paramViewGroup);; paramViewGroup = (Future)h.ZvG.g((Runnable)paramViewGroup, paramString))
      {
        this.fuk = paramViewGroup;
        AppMethodBeat.o(218029);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "", "()V", "callback", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "getCallback", "()Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "setCallback", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;)V", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getCountDownLatch", "()Ljava/util/concurrent/CountDownLatch;", "setCountDownLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "inflater", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "getInflater", "()Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "setInflater", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "resId", "", "getResId", "()I", "setResId", "(I)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "libmmui_release"})
  public static final class b
  {
    a XIR;
    a.d XIS;
    ViewGroup parent;
    int resId;
    CountDownLatch viX;
    View view;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRunnable;", "Ljava/lang/Runnable;", "request", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;)V", "<set-?>", "", "isRunning", "()Z", "run", "", "libmmui_release"})
  static final class c
    implements Runnable
  {
    private final a.b XIT;
    boolean isRunning;
    
    public c(a.b paramb)
    {
      AppMethodBeat.i(214901);
      this.XIT = paramb;
      AppMethodBeat.o(214901);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214898);
      this.isRunning = true;
      long l = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a.b localb = this.XIT;
          localObject = this.XIT.XIR;
          if (localObject == null) {
            continue;
          }
          localObject = a.a((a)localObject);
          localb.view = ad.kS((Context)localObject).inflate(this.XIT.resId, this.XIT.parent, false);
        }
        catch (RuntimeException localRuntimeException)
        {
          Object localObject;
          Log.w("MicroMsg.WxAsyncLayoutInflater", "Failed to inflate resource(" + this.XIT.resId + ") in the background! Retry on the UI thread. " + localRuntimeException.getMessage());
          continue;
        }
        localObject = this.XIT.XIS;
        if (localObject != null) {
          ((a.d)localObject).iz(this.XIT.view);
        }
        localObject = this.XIT.viX;
        if (localObject != null) {
          ((CountDownLatch)localObject).countDown();
        }
        localObject = this.XIT.XIR;
        if (localObject != null)
        {
          localObject = a.b((a)localObject);
          if (localObject != null)
          {
            localObject = ((MMHandler)localObject).obtainMessage(0, this.XIT);
            if (localObject != null) {
              ((Message)localObject).sendToTarget();
            }
          }
        }
        Log.i("MicroMsg.WxAsyncLayoutInflater", "InflateRunnable " + this.XIT.resId + ' ' + (System.currentTimeMillis() - l));
        AppMethodBeat.o(214898);
        return;
        localObject = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "", "onInflateFinished", "", "view", "Landroid/view/View;", "resid", "", "parent", "Landroid/view/ViewGroup;", "libmmui_release"})
  public static abstract interface d
  {
    public abstract void iz(View paramView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class e
    implements MMHandler.Callback
  {
    e(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(193738);
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.ui.inflate.WxAsyncLayoutInflater.InflateRequest");
        AppMethodBeat.o(193738);
        throw paramMessage;
      }
      a.a((a.b)paramMessage);
      AppMethodBeat.o(193738);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */