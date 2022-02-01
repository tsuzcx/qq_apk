package com.tencent.mm.plugin.wxpayreport;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayBtnDisabledReport;", "", "()V", "CLICK_DURATION_THRESHOLD", "", "MAX_CLICK_COUNT", "TAG", "", "doReport", "", "view", "Landroid/view/View;", "viewId", "hasPressSpanTouchListener", "", "monitorBtnNoResponse", "id", "activity", "Landroid/app/Activity;", "delayMs", "", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/String;Landroid/app/Activity;J)V", "TouchListener", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f XIR;
  
  static
  {
    AppMethodBeat.i(261117);
    XIR = new f();
    AppMethodBeat.o(261117);
  }
  
  public static void a(View paramView, Integer paramInteger, String paramString, Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(261085);
    s.u(paramString, "viewId");
    if (paramLong > 0L)
    {
      paramView = new WeakReference(paramView);
      paramActivity = new WeakReference(paramActivity);
      com.tencent.threadpool.h.ahAA.a(new f..ExternalSyntheticLambda0(paramActivity, paramView, paramInteger, paramString), paramLong, "wcpay_report_check_btn_no_response");
    }
    AppMethodBeat.o(261085);
  }
  
  private static final void a(WeakReference paramWeakReference1, WeakReference paramWeakReference2, Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(261111);
    s.u(paramWeakReference1, "$activityWeakReference");
    s.u(paramWeakReference2, "$viewWeakReference");
    s.u(paramString, "$viewId");
    Activity localActivity;
    try
    {
      localActivity = (Activity)paramWeakReference1.get();
      if (localActivity == null)
      {
        AppMethodBeat.o(261111);
        return;
      }
      paramWeakReference2 = (View)paramWeakReference2.get();
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        AppMethodBeat.o(261111);
        return;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.WcPayReport|WcPayBtnDisabledReport", paramWeakReference1, "", new Object[0]);
      AppMethodBeat.o(261111);
      return;
    }
    paramWeakReference1 = paramWeakReference2;
    if (paramWeakReference2 == null)
    {
      paramWeakReference1 = paramWeakReference2;
      if (paramInteger != null)
      {
        int i = ((Number)paramInteger).intValue();
        paramWeakReference1 = paramWeakReference2;
        if (i != 0) {
          paramWeakReference1 = localActivity.findViewById(i);
        }
      }
    }
    if ((paramWeakReference1 == null) && ((localActivity.getWindow().getDecorView() instanceof ViewGroup))) {
      paramWeakReference1 = d.a((ViewGroup)localActivity.getWindow().getDecorView(), a.b.wcpay_report_view_id, paramString);
    }
    for (;;)
    {
      if (paramWeakReference1 == null)
      {
        Log.w("MicroMsg.WcPayReport|WcPayBtnDisabledReport", s.X("not find targetview: ", paramString));
        AppMethodBeat.o(261111);
        return;
      }
      paramWeakReference2 = h.XIV;
      paramWeakReference1 = new a(h.f(paramString, localActivity), paramWeakReference1);
      ((MMFragmentActivity)localActivity).addDispatchedTouchListener((MMFragmentActivity.b)paramWeakReference1);
      Log.d("MicroMsg.WcPayReport|WcPayBtnDisabledReport", "set touch listener");
      AppMethodBeat.o(261111);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayBtnDisabledReport$TouchListener;", "Lcom/tencent/mm/ui/MMFragmentActivity$DispatchedTouchListener;", "viewId", "", "targetView", "Landroid/view/View;", "(Ljava/lang/String;Landroid/view/View;)V", "recentClickTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTargetView", "()Landroid/view/View;", "targetViewRect", "Landroid/graphics/Rect;", "getViewId", "()Ljava/lang/String;", "key", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MMFragmentActivity.b
  {
    private ArrayList<Long> XIS;
    private final Rect XIT;
    private final View nmf;
    private final String viewId;
    
    public a(String paramString, View paramView)
    {
      AppMethodBeat.i(261048);
      this.viewId = paramString;
      this.nmf = paramView;
      this.XIS = new ArrayList(4);
      this.XIT = new Rect();
      AppMethodBeat.o(261048);
    }
    
    public final String key()
    {
      return this.viewId;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(261061);
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(261061);
        return;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.nmf.getGlobalVisibleRect(this.XIT);
        if ((this.nmf.isShown()) && (this.XIT.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
        {
          this.XIS.add(Long.valueOf(paramMotionEvent.getEventTime()));
          while (this.XIS.size() > 3) {
            this.XIS.remove(0);
          }
          if (this.XIS.size() == 3)
          {
            long l = ((Number)this.XIS.get(2)).longValue();
            paramMotionEvent = this.XIS.get(0);
            s.s(paramMotionEvent, "recentClickTime[0]");
            l -= ((Number)paramMotionEvent).longValue();
            if (l <= 1000L)
            {
              Log.w("MicroMsg.WcPayReport|WcPayBtnDisabledReport", "hit max threshold: " + l + ", " + this.XIS);
              paramMotionEvent = f.XIR;
              f.k(this.nmf, this.viewId);
              this.XIS.clear();
            }
          }
        }
      }
      AppMethodBeat.o(261061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.f
 * JD-Core Version:    0.7.0.1
 */