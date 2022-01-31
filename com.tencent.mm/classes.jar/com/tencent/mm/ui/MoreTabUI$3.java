package com.tencent.mm.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.listview.PullDownListView;

final class MoreTabUI$3
  implements View.OnClickListener
{
  MoreTabUI$3(MoreTabUI paramMoreTabUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29691);
    ab.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
    if (MoreTabUI.g(this.zdu))
    {
      t.makeText(this.zdu.getContext(), this.zdu.getResources().getString(2131304178), 0).show();
      AppMethodBeat.o(29691);
      return;
    }
    if ((MoreTabUI.h(this.zdu) != null) && (MoreTabUI.h(this.zdu).isVisible)) {
      MoreTabUI.h(this.zdu).dPj();
    }
    AppMethodBeat.o(29691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.3
 * JD-Core Version:    0.7.0.1
 */