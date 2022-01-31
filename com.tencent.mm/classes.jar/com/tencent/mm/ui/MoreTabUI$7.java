package com.tencent.mm.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.listview.PullDownListView;

final class MoreTabUI$7
  implements View.OnClickListener
{
  MoreTabUI$7(MoreTabUI paramMoreTabUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29698);
    if (MoreTabUI.g(this.zdu))
    {
      t.makeText(this.zdu.getContext(), this.zdu.getResources().getString(2131304178), 0).show();
      AppMethodBeat.o(29698);
      return;
    }
    if (MoreTabUI.h(this.zdu) != null) {
      MoreTabUI.h(this.zdu).dPj();
    }
    AppMethodBeat.o(29698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.7
 * JD-Core Version:    0.7.0.1
 */