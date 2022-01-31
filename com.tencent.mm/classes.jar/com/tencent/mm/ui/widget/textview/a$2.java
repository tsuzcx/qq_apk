package com.tencent.mm.ui.widget.textview;

import android.text.Layout;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = this.wsy;
    int j = this.wsy.wsq;
    int i = this.wsy.wsr;
    paramView.cKI();
    paramView.cKJ();
    paramView.cbz = false;
    if (paramView.wsk == null) {
      paramView.wsk = new a.b(paramView, true);
    }
    if (paramView.wsl == null) {
      paramView.wsl = new a.b(paramView, false);
    }
    Layout localLayout = paramView.lh.getLayout();
    if (localLayout != null)
    {
      i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i), j);
      if ((int)localLayout.getPrimaryHorizontal(i) > j) {
        i = localLayout.getOffsetToLeftOf(i);
      }
    }
    for (;;)
    {
      if ((paramView.lh.getText() instanceof Spannable)) {
        paramView.wso = ((Spannable)paramView.lh.getText());
      }
      if ((paramView.wso != null) && (i < paramView.lh.getText().length())) {
        break;
      }
      return true;
      continue;
      i = -1;
    }
    paramView.fP(i, i + 1);
    paramView.a(paramView.wsk);
    paramView.a(paramView.wsl);
    paramView.cKK();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.2
 * JD-Core Version:    0.7.0.1
 */