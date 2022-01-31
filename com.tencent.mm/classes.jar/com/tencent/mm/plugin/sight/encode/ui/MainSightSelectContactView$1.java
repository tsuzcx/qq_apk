package com.tencent.mm.plugin.sight.encode.ui;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R.e;

final class MainSightSelectContactView$1
  implements Runnable
{
  MainSightSelectContactView$1(MainSightSelectContactView paramMainSightSelectContactView) {}
  
  public final void run()
  {
    if ((MainSightSelectContactView.a(this.oiv) == MainSightSelectContactView.b(this.oiv).getCount()) && (MainSightSelectContactView.c(this.oiv).getViewHeight() >= MainSightSelectContactView.d(this.oiv))) {}
    int i;
    label225:
    do
    {
      return;
      if (MainSightSelectContactView.e(this.oiv) != null) {
        MainSightSelectContactView.f(this.oiv).removeFooterView(MainSightSelectContactView.e(this.oiv));
      }
      i = MainSightSelectContactView.d(this.oiv);
      if ((MainSightSelectContactView.d(this.oiv) < 0) || (MainSightSelectContactView.d(this.oiv) > MainSightSelectContactView.c(this.oiv).getViewHeight())) {
        i = MainSightSelectContactView.c(this.oiv).getViewHeight();
      }
      MainSightSelectContactView.a(this.oiv, MainSightSelectContactView.b(this.oiv).getCount());
      MainSightSelectContactView.b(this.oiv, i);
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= MainSightSelectContactView.b(this.oiv).getCount()) {
          break label225;
        }
        localObject = MainSightSelectContactView.b(this.oiv).getView(j, null, MainSightSelectContactView.f(this.oiv));
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        k += ((View)localObject).getMeasuredHeight();
        if (k >= i) {
          break;
        }
        j += 1;
      }
      i -= k;
    } while (i <= 0);
    MainSightSelectContactView.a(this.oiv, new View(this.oiv.getContext()));
    Object localObject = new AbsListView.LayoutParams(-1, i);
    MainSightSelectContactView.e(this.oiv).setLayoutParams((ViewGroup.LayoutParams)localObject);
    MainSightSelectContactView.e(this.oiv).setBackgroundResource(R.e.black);
    MainSightSelectContactView.f(this.oiv).addFooterView(MainSightSelectContactView.e(this.oiv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView.1
 * JD-Core Version:    0.7.0.1
 */