package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;

final class b$d$2
  implements View.OnClickListener
{
  b$d$2(b.d paramd, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31136);
    boolean bool;
    if (!this.zDL.mCC.isChecked())
    {
      bool = true;
      if (h.a.dKg().mCl.size() >= 9) {
        break label142;
      }
      this.zDL.mCC.setChecked(bool);
      if (bool) {
        break label128;
      }
      this.zDL.mCA.setVisibility(8);
    }
    for (;;)
    {
      if (this.zDL.zDH.zDG != null)
      {
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = this.zDL.zDH.PC(i);
        this.zDL.zDH.zDG.a(bool, paramView, i);
      }
      AppMethodBeat.o(31136);
      return;
      bool = false;
      break;
      label128:
      this.zDL.mCA.setVisibility(0);
      continue;
      label142:
      if (!bool) {
        this.zDL.mCC.setChecked(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */