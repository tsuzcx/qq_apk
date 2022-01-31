package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.d;
import java.util.Calendar;

final class EditHintView$7
  implements View.OnClickListener
{
  EditHintView$7(EditHintView paramEditHintView) {}
  
  public final void onClick(View paramView)
  {
    if (EditHintView.h(this.wBY) == null)
    {
      paramView = Calendar.getInstance();
      paramView.setTimeInMillis(System.currentTimeMillis());
      paramView.add(2, 1);
      EditHintView.a(this.wBY, paramView.get(1));
      EditHintView.b(this.wBY, paramView.get(2));
      EditHintView.a(this.wBY, new d(this.wBY.getContext(), new EditHintView.7.1(this), EditHintView.i(this.wBY), EditHintView.j(this.wBY), paramView.get(5), paramView.getTimeInMillis()));
    }
    EditHintView.h(this.wBY).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.7
 * JD-Core Version:    0.7.0.1
 */