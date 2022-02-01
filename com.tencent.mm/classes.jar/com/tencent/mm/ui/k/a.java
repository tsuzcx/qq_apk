package com.tencent.mm.ui.k;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.f.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.af;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "future", "Ljava/util/concurrent/Future;", "mContext", "mHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mHandlerCallback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "mInflateRunnable", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRunnable;", "cancel", "", "inflate", "resid", "", "parent", "Landroid/view/ViewGroup;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "callback", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "serialTag", "", "isRunning", "", "obtainRequest", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "releaseRequest", "obj", "Companion", "InflateRequest", "InflateRunnable", "OnInflateFinishedListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a afwt;
  private static final e.c<b> afww;
  c afwu;
  private final MMHandler.Callback afwv;
  Future<?> dBj;
  private Context mContext;
  private MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(250151);
    afwt = new a.a((byte)0);
    afww = new e.c(10);
    AppMethodBeat.o(250151);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(250139);
    this.afwv = new a..ExternalSyntheticLambda0(this);
    this.mContext = paramContext;
    this.mHandler = new MMHandler(Looper.getMainLooper(), this.afwv);
    AppMethodBeat.o(250139);
  }
  
  private static final boolean a(a parama, Message paramMessage)
  {
    AppMethodBeat.i(250143);
    s.u(parama, "this$0");
    s.u(paramMessage, "msg");
    parama = paramMessage.obj;
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.inflate.WxAsyncLayoutInflater.InflateRequest");
      AppMethodBeat.o(250143);
      throw parama;
    }
    parama = (b)parama;
    parama.afwy = null;
    parama.afwx = null;
    parama.parent = null;
    parama.resId = 0;
    parama.view = null;
    afww.release(parama);
    AppMethodBeat.o(250143);
    return true;
  }
  
  public final void a(int paramInt, ViewGroup paramViewGroup, CountDownLatch paramCountDownLatch, a.d paramd, String paramString)
  {
    AppMethodBeat.i(250156);
    paramViewGroup = (b)afww.acquire();
    if (paramViewGroup == null) {
      paramViewGroup = new b();
    }
    for (;;)
    {
      paramViewGroup.afwx = this;
      paramViewGroup.resId = paramInt;
      paramViewGroup.parent = null;
      paramViewGroup.afwy = paramd;
      paramViewGroup.yuW = paramCountDownLatch;
      paramViewGroup = new c(paramViewGroup);
      this.afwu = paramViewGroup;
      if (paramString == null) {}
      for (paramViewGroup = (Future)h.ahAA.bo((Runnable)paramViewGroup);; paramViewGroup = (Future)h.ahAA.j((Runnable)paramViewGroup, paramString))
      {
        this.dBj = paramViewGroup;
        AppMethodBeat.o(250156);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "", "()V", "callback", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "getCallback", "()Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "setCallback", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;)V", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getCountDownLatch", "()Ljava/util/concurrent/CountDownLatch;", "setCountDownLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "inflater", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "getInflater", "()Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "setInflater", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "resId", "", "getResId", "()I", "setResId", "(I)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    a afwx;
    a.d afwy;
    ViewGroup parent;
    int resId;
    View view;
    CountDownLatch yuW;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRunnable;", "Ljava/lang/Runnable;", "request", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;", "(Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$InflateRequest;)V", "<set-?>", "", "isRunning", "()Z", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements Runnable
  {
    boolean Uz;
    private final a.b afwz;
    
    public c(a.b paramb)
    {
      AppMethodBeat.i(250135);
      this.afwz = paramb;
      AppMethodBeat.o(250135);
    }
    
    public final void run()
    {
      AppMethodBeat.i(250142);
      this.Uz = true;
      long l = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a.b localb = this.afwz;
          localObject = this.afwz.afwx;
          if (localObject != null) {
            continue;
          }
          localObject = null;
          localb.view = af.mU((Context)localObject).inflate(this.afwz.resId, this.afwz.parent, false);
        }
        catch (RuntimeException localRuntimeException)
        {
          Object localObject;
          Log.w("MicroMsg.WxAsyncLayoutInflater", "Failed to inflate resource(" + this.afwz.resId + ") in the background! Retry on the UI thread. " + localRuntimeException.getMessage());
          continue;
        }
        localObject = this.afwz.afwy;
        if (localObject != null) {
          ((a.d)localObject).lW(this.afwz.view);
        }
        localObject = this.afwz.yuW;
        if (localObject != null) {
          ((CountDownLatch)localObject).countDown();
        }
        localObject = this.afwz.afwx;
        if (localObject != null)
        {
          localObject = a.b((a)localObject);
          if (localObject != null)
          {
            localObject = ((MMHandler)localObject).obtainMessage(0, this.afwz);
            if (localObject != null) {
              ((Message)localObject).sendToTarget();
            }
          }
        }
        Log.i("MicroMsg.WxAsyncLayoutInflater", "InflateRunnable " + this.afwz.resId + ' ' + (System.currentTimeMillis() - l));
        AppMethodBeat.o(250142);
        return;
        localObject = a.a((a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */