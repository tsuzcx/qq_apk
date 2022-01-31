package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;

final class n$8
  implements View.OnClickListener
{
  n$8(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27980);
    paramView = new e.a(this.vZW.getContext());
    n.8.1 local1 = new n.8.1(this, paramView);
    e.a locala = paramView.aj(this.vZW.getContext().getString(2131304550));
    ArrayList localArrayList = n.d(this.vZW);
    int k = n.c(this.vZW);
    View localView = View.inflate(locala.mContext, 2130969326, null);
    locala.AHw = ((RadioGroup)localView.findViewById(2131823421));
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = 0)
    {
      int j = 0;
      while (j < i)
      {
        RadioButton localRadioButton = (RadioButton)View.inflate(locala.mContext, 2130969325, null);
        localRadioButton.setId(j);
        if (j == k) {
          localRadioButton.setChecked(true);
        }
        localRadioButton.setText((CharSequence)localArrayList.get(j));
        locala.AHw.addView(localRadioButton);
        j += 1;
      }
      locala.AHw.setOnCheckedChangeListener(local1);
      locala.vTt.fu(localView);
      locala.rI(true);
      paramView.a(new n.8.2(this));
      paramView.show();
      this.vZW.Mo(3);
      AppMethodBeat.o(27980);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.8
 * JD-Core Version:    0.7.0.1
 */