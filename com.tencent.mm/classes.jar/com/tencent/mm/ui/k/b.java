package com.tencent.mm.ui.k;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutLoader;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "mCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mInflater", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "mLayoutId", "", "mRealView", "Landroid/view/View;", "mRootView", "Landroid/view/ViewGroup;", "getRealView", "inflate", "", "resId", "parent", "resid", "listener", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "serialTag", "", "inflateSync", "setLayoutParamByParent", "context", "layoutResId", "view", "successInflateView", "", "Companion", "libmmui_release"})
public final class b
{
  private static final h<b> XIX;
  public static final b.a XIY;
  private int CDQ;
  private CountDownLatch JdE;
  private View XIV;
  private a XIW;
  private Context mContext;
  private ViewGroup qoE;
  
  static
  {
    AppMethodBeat.i(219241);
    XIY = new b.a((byte)0);
    XIX = new h();
    AppMethodBeat.o(219241);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(219240);
    this.mContext = paramContext;
    this.JdE = new CountDownLatch(1);
    AppMethodBeat.o(219240);
  }
  
  private static void a(Context paramContext, ViewGroup paramViewGroup, int paramInt, View paramView)
  {
    AppMethodBeat.i(219238);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(219238);
      return;
    }
    if (paramContext == null) {
      p.iCn();
    }
    paramContext = paramContext.getResources().getLayout(paramInt);
    p.j(paramContext, "context!!.resources.getLayout(layoutResId)");
    try
    {
      paramViewGroup = paramViewGroup.generateLayoutParams(Xml.asAttributeSet((XmlPullParser)paramContext));
      if (paramView == null) {
        p.iCn();
      }
      paramView.setLayoutParams(paramViewGroup);
      return;
    }
    catch (Exception paramViewGroup) {}finally
    {
      paramContext.close();
      AppMethodBeat.o(219238);
    }
  }
  
  public final void jdMethod_do(int paramInt, String paramString)
  {
    AppMethodBeat.i(219234);
    this.qoE = null;
    this.CDQ = paramInt;
    XIX.c(this.CDQ, this);
    a.d locald = (a.d)new b(this);
    this.XIW = new a(this.mContext);
    a locala = this.XIW;
    if (locala == null) {
      p.iCn();
    }
    locala.a(paramInt, null, this.JdE, locald, paramString);
    AppMethodBeat.o(219234);
  }
  
  public final boolean hXg()
  {
    return this.XIV != null;
  }
  
  public final View hXh()
  {
    AppMethodBeat.i(219237);
    Object localObject;
    if (this.XIV == null)
    {
      localObject = this.XIW;
      if (localObject != null)
      {
        localObject = ((a)localObject).XIN;
        if (localObject == null) {
          p.iCn();
        }
        if (!((a.c)localObject).isRunning)
        {
          localObject = this.XIW;
          if (localObject != null)
          {
            localObject = ((a)localObject).fuk;
            if (localObject == null) {
              p.iCn();
            }
            ((Future)localObject).cancel(true);
          }
          Log.i("MicroMsg.WxAsyncLayoutLoader", "inflateSync");
          this.XIV = ad.kS(this.mContext).inflate(this.CDQ, this.qoE, false);
        }
      }
    }
    for (;;)
    {
      localObject = this.XIV;
      AppMethodBeat.o(219237);
      return localObject;
      if (this.XIV == null) {}
      try
      {
        this.JdE.await();
        label125:
        a(this.mContext, this.qoE, this.CDQ, this.XIV);
        continue;
        a(this.mContext, this.qoE, this.CDQ, this.XIV);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label125;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/inflate/WxAsyncLayoutLoader$inflate$1", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "onInflateFinished", "", "view", "Landroid/view/View;", "resid", "", "parent", "Landroid/view/ViewGroup;", "libmmui_release"})
  public static final class b
    implements a.d
  {
    public final void iz(View paramView)
    {
      AppMethodBeat.i(198146);
      b.a(this.XIZ, paramView);
      AppMethodBeat.o(198146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.k.b
 * JD-Core Version:    0.7.0.1
 */