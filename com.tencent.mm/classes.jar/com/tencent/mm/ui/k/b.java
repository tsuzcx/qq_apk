package com.tencent.mm.ui.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutLoader;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "mCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mInflater", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater;", "mLayoutId", "", "mRealView", "Landroid/view/View;", "mRootView", "Landroid/view/ViewGroup;", "getRealView", "inflate", "", "resId", "parent", "resid", "listener", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "serialTag", "", "inflateSync", "setLayoutParamByParent", "context", "layoutResId", "view", "successInflateView", "", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a afwA;
  private static final h<b> afwD;
  private int IxU;
  private CountDownLatch PnX;
  private View afwB;
  private a afwC;
  private Context mContext;
  private ViewGroup tth;
  
  static
  {
    AppMethodBeat.i(250150);
    afwA = new a((byte)0);
    afwD = new h();
    AppMethodBeat.o(250150);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(250136);
    this.mContext = paramContext;
    this.PnX = new CountDownLatch(1);
    AppMethodBeat.o(250136);
  }
  
  /* Error */
  private static void a(Context paramContext, ViewGroup paramViewGroup, int paramInt, View paramView)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +9 -> 15
    //   9: ldc 110
    //   11: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: aload_0
    //   16: invokestatic 114	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: invokevirtual 120	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload_2
    //   24: invokevirtual 126	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   27: astore_0
    //   28: aload_0
    //   29: ldc 128
    //   31: invokestatic 131	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload_1
    //   35: aload_0
    //   36: checkcast 133	org/xmlpull/v1/XmlPullParser
    //   39: invokestatic 139	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   42: invokevirtual 145	android/view/ViewGroup:generateLayoutParams	(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    //   45: astore_1
    //   46: aload_3
    //   47: invokestatic 114	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 151	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   55: aload_0
    //   56: invokeinterface 156 1 0
    //   61: ldc 110
    //   63: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: invokeinterface 156 1 0
    //   74: ldc 110
    //   76: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: invokeinterface 156 1 0
    //   87: ldc 110
    //   89: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   0	94	1	paramViewGroup	ViewGroup
    //   0	94	2	paramInt	int
    //   0	94	3	paramView	View
    // Exception table:
    //   from	to	target	type
    //   34	55	67	java/lang/Exception
    //   34	55	80	finally
  }
  
  public final void eh(int paramInt, String paramString)
  {
    AppMethodBeat.i(250154);
    this.tth = null;
    this.IxU = paramInt;
    afwD.e(this.IxU, this);
    a.d locald = (a.d)new b(this);
    this.afwC = new a(this.mContext);
    a locala = this.afwC;
    s.checkNotNull(locala);
    locala.a(paramInt, null, this.PnX, locald, paramString);
    AppMethodBeat.o(250154);
  }
  
  public final boolean jBD()
  {
    return this.afwB != null;
  }
  
  public final View jBE()
  {
    AppMethodBeat.i(250157);
    Object localObject;
    int i;
    if (this.afwB == null)
    {
      localObject = this.afwC;
      if (localObject != null)
      {
        localObject = ((a)localObject).afwu;
        s.checkNotNull(localObject);
        if (!((a.c)localObject).Uz)
        {
          i = 1;
          if (i == 0) {
            break label116;
          }
          localObject = this.afwC;
          if (localObject != null)
          {
            localObject = ((a)localObject).dBj;
            s.checkNotNull(localObject);
            ((Future)localObject).cancel(true);
          }
          Log.i("MicroMsg.WxAsyncLayoutLoader", "inflateSync");
          this.afwB = af.mU(this.mContext).inflate(this.IxU, this.tth, false);
        }
      }
    }
    for (;;)
    {
      localObject = this.afwB;
      AppMethodBeat.o(250157);
      return localObject;
      i = 0;
      break;
      label116:
      if (this.afwB == null) {}
      try
      {
        this.PnX.await();
        label130:
        a(this.mContext, this.tth, this.IxU, this.afwB);
        continue;
        a(this.mContext, this.tth, this.IxU, this.afwB);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label130;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/inflate/WxAsyncLayoutLoader$Companion;", "", "()V", "TAG", "", "sArrayCompat", "Landroidx/collection/SparseArrayCompat;", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutLoader;", "getLayoutLoader", "resId", "", "reset", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b aDY(int paramInt)
    {
      AppMethodBeat.i(250144);
      b localb = (b)b.jBF().d(paramInt, null);
      AppMethodBeat.o(250144);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/inflate/WxAsyncLayoutLoader$inflate$1", "Lcom/tencent/mm/ui/inflate/WxAsyncLayoutInflater$OnInflateFinishedListener;", "onInflateFinished", "", "view", "Landroid/view/View;", "resid", "", "parent", "Landroid/view/ViewGroup;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.d
  {
    b(b paramb) {}
    
    public final void lW(View paramView)
    {
      AppMethodBeat.i(250140);
      b.a(this.afwE, paramView);
      AppMethodBeat.o(250140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.k.b
 * JD-Core Version:    0.7.0.1
 */