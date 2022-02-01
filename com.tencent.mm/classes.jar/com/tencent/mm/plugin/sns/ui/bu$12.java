package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import java.lang.ref.WeakReference;

final class bu$12
  implements View.OnClickListener
{
  bu$12(bu parambu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99731);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof ak)))
    {
      localObject1 = ((ak)paramView.getTag()).KCX;
      Object localObject2 = ((ak)paramView.getTag()).KGd;
      if ((localObject1 != null) && (((TimeLineObject)localObject1).ContentObj != null) && (((TimeLineObject)localObject1).ContentObj.Sqw != null) && (localObject2 != null) && (((WeakReference)localObject2).get() != null))
      {
        localObject2 = (View)((WeakReference)localObject2).get();
        Rect localRect = new Rect();
        int[] arrayOfInt = new int[2];
        ((View)localObject2).getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        int k = arrayOfInt[0];
        int m = ((View)localObject2).getMeasuredWidth();
        int n = arrayOfInt[1];
        localRect.set(i, j, k + m, ((View)localObject2).getMeasuredHeight() + n);
        i.a(paramView.getContext(), ((TimeLineObject)localObject1).ContentObj.Sqw, localRect);
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu.12
 * JD-Core Version:    0.7.0.1
 */