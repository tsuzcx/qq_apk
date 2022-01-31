package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.n;

final class a$3
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof n))
    {
      n localn = (n)paramView.getTag();
      a.a(paramView, paramView.getContext(), localn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a.3
 * JD-Core Version:    0.7.0.1
 */