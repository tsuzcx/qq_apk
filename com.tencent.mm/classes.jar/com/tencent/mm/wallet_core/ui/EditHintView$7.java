package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.e;
import java.util.Calendar;

final class EditHintView$7
  implements View.OnClickListener
{
  EditHintView$7(EditHintView paramEditHintView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49184);
    if (EditHintView.h(this.AYr) == null)
    {
      paramView = Calendar.getInstance();
      paramView.setTimeInMillis(System.currentTimeMillis());
      paramView.add(2, 1);
      EditHintView.a(this.AYr, paramView.get(1));
      EditHintView.b(this.AYr, paramView.get(2));
      EditHintView.a(this.AYr, new e(this.AYr.getContext(), new EditHintView.7.1(this), EditHintView.i(this.AYr), EditHintView.j(this.AYr), paramView.get(5), paramView.getTimeInMillis()));
    }
    EditHintView.h(this.AYr).show();
    AppMethodBeat.o(49184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.7
 * JD-Core Version:    0.7.0.1
 */