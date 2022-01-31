package com.tencent.mm.plugin.sight.encode.ui;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MainSightSelectContactView$1
  implements Runnable
{
  MainSightSelectContactView$1(MainSightSelectContactView paramMainSightSelectContactView) {}
  
  public final void run()
  {
    AppMethodBeat.i(25083);
    if ((MainSightSelectContactView.a(this.qWI) == MainSightSelectContactView.b(this.qWI).getCount()) && (MainSightSelectContactView.c(this.qWI).getViewHeight() >= MainSightSelectContactView.d(this.qWI)))
    {
      AppMethodBeat.o(25083);
      return;
    }
    if (MainSightSelectContactView.e(this.qWI) != null) {
      MainSightSelectContactView.f(this.qWI).removeFooterView(MainSightSelectContactView.e(this.qWI));
    }
    int i = MainSightSelectContactView.d(this.qWI);
    if ((MainSightSelectContactView.d(this.qWI) < 0) || (MainSightSelectContactView.d(this.qWI) > MainSightSelectContactView.c(this.qWI).getViewHeight())) {
      i = MainSightSelectContactView.c(this.qWI).getViewHeight();
    }
    MainSightSelectContactView.a(this.qWI, MainSightSelectContactView.b(this.qWI).getCount());
    MainSightSelectContactView.b(this.qWI, i);
    int j = 0;
    int k = 0;
    Object localObject;
    while (j < MainSightSelectContactView.b(this.qWI).getCount())
    {
      localObject = MainSightSelectContactView.b(this.qWI).getView(j, null, MainSightSelectContactView.f(this.qWI));
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      k += ((View)localObject).getMeasuredHeight();
      if (k >= i)
      {
        AppMethodBeat.o(25083);
        return;
      }
      j += 1;
    }
    i -= k;
    if (i > 0)
    {
      MainSightSelectContactView.a(this.qWI, new View(this.qWI.getContext()));
      localObject = new AbsListView.LayoutParams(-1, i);
      MainSightSelectContactView.e(this.qWI).setLayoutParams((ViewGroup.LayoutParams)localObject);
      MainSightSelectContactView.e(this.qWI).setBackgroundResource(2131689763);
      MainSightSelectContactView.f(this.qWI).addFooterView(MainSightSelectContactView.e(this.qWI));
    }
    AppMethodBeat.o(25083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView.1
 * JD-Core Version:    0.7.0.1
 */