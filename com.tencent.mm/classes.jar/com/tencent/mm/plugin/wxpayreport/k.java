package com.tencent.mm.plugin.wxpayreport;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayViewExposureReport;", "", "()V", "COLOR_DIFFERENCE_THRESHOLD", "", "CONTRAST_THRESHOLD", "COVERED", "INAPPROPRIATE_COLOR", "NOT_ADD", "NOT_SHOWN", "OK", "OUT_OF_SCREEN_RANGE", "PART_OUT_OF_SCREEN_RANGE", "TAG", "", "TRANSPARENT", "checkViewColorSimilarity", "", "view", "Landroid/view/View;", "bgColor", "checkViewCovered", "searchEndViewId", "(Landroid/view/View;Ljava/lang/Integer;)Z", "checkViewExposure", "checkColor", "(Landroid/view/View;ZILjava/lang/Integer;)I", "doReport", "", "ret", "viewId", "getDrawableColor", "drawable", "Landroid/graphics/drawable/Drawable;", "isLowContrast", "textColor", "isSimilarColor", "first", "second", "reportViewExposure", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "id", "delayMs", "", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Landroid/view/View;IJLjava/lang/String;Lcom/tencent/mm/ui/MMFragmentActivity;ZILjava/lang/Integer;)Lcom/tencent/threadpool/runnable/CancelableRunnable;", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k XJk;
  
  static
  {
    AppMethodBeat.i(261184);
    XJk = new k();
    AppMethodBeat.o(261184);
  }
  
  public static com.tencent.threadpool.i.b a(View paramView, int paramInt1, long paramLong, final String paramString, MMFragmentActivity paramMMFragmentActivity, final boolean paramBoolean, final int paramInt2, final Integer paramInteger)
  {
    AppMethodBeat.i(261121);
    s.u(paramString, "viewId");
    s.u(paramMMFragmentActivity, "activity");
    if (!paramBoolean) {
      if ((paramView == null) || (paramView.isLaidOut())) {
        break label146;
      }
    }
    label146:
    for (int i = 1;; i = 0)
    {
      long l = paramLong;
      if (i != 0)
      {
        l = paramLong;
        if (paramLong <= 0L) {
          l = 500L;
        }
      }
      paramInteger = (m)new a(paramInt1, paramString, paramBoolean, paramInt2, paramInteger);
      if (l <= 0L) {
        break;
      }
      paramView = new b(paramString, new WeakReference(paramView), paramInteger, new WeakReference(paramMMFragmentActivity));
      h.ahAA.a((Runnable)paramView, l, "wcpay_report_check_exposure");
      paramView = (com.tencent.threadpool.i.b)paramView;
      AppMethodBeat.o(261121);
      return paramView;
    }
    paramInteger.invoke(paramView, paramMMFragmentActivity);
    AppMethodBeat.o(261121);
    return null;
  }
  
  private static boolean a(View paramView, Integer paramInteger)
  {
    AppMethodBeat.i(261141);
    Rect localRect1 = new Rect();
    paramView.getGlobalVisibleRect(localRect1);
    int i = 0;
    break label89;
    label23:
    Object localObject;
    label79:
    label89:
    label109:
    int i1;
    int m;
    for (;;)
    {
      if (((paramView.getParent() instanceof ViewGroup)) && (i < 200))
      {
        localObject = paramView.getParent();
        if (localObject == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(261141);
          throw paramView;
        }
        localObject = (ViewGroup)localObject;
        if (paramInteger == null)
        {
          j = ((ViewGroup)localObject).getId();
          if (paramInteger != null) {
            break label211;
          }
          if (!((ViewGroup)localObject).isShown()) {
            continue;
          }
          if (((ViewGroup)localObject).getAlpha() != 0.0F) {
            break label226;
          }
          j = 1;
          if (j != 0) {
            break label229;
          }
          i1 = ((ViewGroup)localObject).getChildCount();
          if (i1 > 0) {
            m = 0;
          }
        }
      }
    }
    int k;
    for (int j = 0;; j = k)
    {
      int n = m + 1;
      View localView = ((ViewGroup)localObject).getChildAt(m);
      k = j;
      if (localView != null) {
        if (j == 0)
        {
          k = j;
          if (!s.p(localView, paramView)) {}
        }
        else
        {
          if (!s.p(localView, paramView)) {
            break label231;
          }
          k = 1;
        }
      }
      for (;;)
      {
        if (n >= i1)
        {
          paramView = (View)localObject;
          i += 1;
          break label23;
          if (paramInteger.intValue() == 0) {
            break;
          }
          break label79;
          label211:
          if (paramInteger.intValue() != j) {
            break;
          }
          AppMethodBeat.o(261141);
          return false;
          label226:
          j = 0;
          break label109;
          label229:
          break label23;
          label231:
          k = j;
          if (localView.isShown())
          {
            if (localView.getAlpha() == 0.0F) {}
            for (m = 1;; m = 0)
            {
              k = j;
              if (m != 0) {
                break;
              }
              Rect localRect2 = new Rect();
              localView.getGlobalVisibleRect(localRect2);
              k = j;
              if (!localRect2.contains(localRect1)) {
                break;
              }
              Log.w("MicroMsg.WcPayReport|WcPayViewExposureReport", "target: " + localRect1 + ", overlay: " + localRect2 + ", " + localView);
              AppMethodBeat.o(261141);
              return true;
            }
          }
        }
      }
      m = n;
    }
  }
  
  private final boolean be(View paramView, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(261156);
    int i;
    if ((paramView instanceof ImageView))
    {
      Drawable localDrawable = ((ImageView)paramView).getDrawable();
      localObject = localDrawable;
      if (localDrawable == null) {
        localObject = ((ImageView)paramView).getBackground();
      }
      paramView = (View)localObject;
      if (localObject == null)
      {
        AppMethodBeat.o(261156);
        return false;
        if ((paramView instanceof StateListDrawable))
        {
          paramView = ((StateListDrawable)paramView).getCurrent();
          s.s(paramView, "drawable.current");
        }
      }
      else if ((paramView instanceof ColorDrawable))
      {
        i = ((ColorDrawable)paramView).getColor();
      }
      for (;;)
      {
        Log.d("MicroMsg.WcPayReport|WcPayViewExposureReport", s.X("drawable color: ", a.avj(i)));
        if (i != 0) {
          break label193;
        }
        AppMethodBeat.o(261156);
        return false;
        if (!(paramView instanceof BitmapDrawable)) {
          break;
        }
        paramView = ((BitmapDrawable)paramView).getBitmap();
        s.s(paramView, "drawable.bitmap");
        i = a.aX(paramView);
        continue;
        if ((paramView instanceof com.tencent.mm.svg.a.b))
        {
          Log.w("MicroMsg.WcPayReport|WcPayViewExposureReport", "is SVGDrawable");
          i = 0;
        }
        else
        {
          Log.w("MicroMsg.WcPayReport|WcPayViewExposureReport", s.X("can't parse drawable: ", paramView));
          i = 0;
        }
      }
      label193:
      bool1 = nA(a.ny(i, paramInt), paramInt);
      if (bool1) {
        Log.w("MicroMsg.WcPayReport|WcPayViewExposureReport", "find similarColor: " + a.avj(a.ny(i, paramInt)) + ", " + a.avj(paramInt));
      }
      AppMethodBeat.o(261156);
      return bool1;
    }
    if ((paramView instanceof TextView))
    {
      i = ((TextView)paramView).getCurrentTextColor();
      if (androidx.core.graphics.b.aw(i, paramInt) < 2.0D) {
        bool1 = true;
      }
      if (bool1) {
        Log.w("MicroMsg.WcPayReport|WcPayViewExposureReport", "find low contrast: " + a.avj(i) + ", " + a.avj(paramInt));
      }
      AppMethodBeat.o(261156);
      return bool1;
    }
    Object localObject = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas((Bitmap)localObject));
    s.s(localObject, "bitmap");
    a.l((Bitmap)localObject, paramInt);
    paramView = ((Iterable)a.aY((Bitmap)localObject)).iterator();
    if (paramView.hasNext())
    {
      i = ((Number)paramView.next()).intValue();
      if (nA(i, paramInt)) {}
    }
    for (bool1 = bool2;; bool1 = true)
    {
      AppMethodBeat.o(261156);
      return bool1;
      Log.d("MicroMsg.WcPayReport|WcPayViewExposureReport", s.X("similar color: ", a.avj(i)));
      break;
    }
  }
  
  private static boolean nA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261163);
    if (a.nz(paramInt1, paramInt2) <= 5.0D)
    {
      AppMethodBeat.o(261163);
      return true;
    }
    AppMethodBeat.o(261163);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "view", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<View, MMFragmentActivity, ah>
  {
    a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2, Integer paramInteger)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wxpayreport/WcPayViewExposureReport$reportViewExposure$runnable$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.threadpool.i.b
  {
    b(String paramString, WeakReference<View> paramWeakReference, m<? super View, ? super MMFragmentActivity, ah> paramm, WeakReference<MMFragmentActivity> paramWeakReference1) {}
    
    public final String getKey()
    {
      return this.XJl;
    }
    
    public final void run()
    {
      AppMethodBeat.i(261096);
      Log.d("MicroMsg.WcPayReport|WcPayViewExposureReport", "do func: " + this.XJl + ", " + this.XJp.get());
      paramInteger.invoke(this.XJp.get(), this.XJr.get());
      AppMethodBeat.o(261096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.k
 * JD-Core Version:    0.7.0.1
 */