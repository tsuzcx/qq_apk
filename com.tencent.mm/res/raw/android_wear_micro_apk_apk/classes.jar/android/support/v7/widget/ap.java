package android.support.v7.widget;

import android.view.View;

final class ap
{
  static int a(ak paramak, s params, View paramView1, View paramView2, ab paramab, boolean paramBoolean)
  {
    if ((paramab.getChildCount() == 0) || (paramak.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(ab.av(paramView1) - ab.av(paramView2)) + 1;
    }
    int i = params.am(paramView2);
    int j = params.al(paramView1);
    return Math.min(params.dl(), i - j);
  }
  
  static int a(ak paramak, s params, View paramView1, View paramView2, ab paramab, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramab.getChildCount() != 0)
    {
      j = i;
      if (paramak.getItemCount() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(ab.av(paramView1), ab.av(paramView2));
    j = Math.max(ab.av(paramView1), ab.av(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, paramak.getItemCount() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(params.am(paramView2) - params.al(paramView1));
      int k = Math.abs(ab.av(paramView1) - ab.av(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (params.dj() - params.al(paramView1)));
    }
  }
  
  static int b(ak paramak, s params, View paramView1, View paramView2, ab paramab, boolean paramBoolean)
  {
    if ((paramab.getChildCount() == 0) || (paramak.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return paramak.getItemCount();
    }
    int i = params.am(paramView2);
    int j = params.al(paramView1);
    int k = Math.abs(ab.av(paramView1) - ab.av(paramView2));
    return (int)((i - j) / (k + 1) * paramak.getItemCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */