package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$g
  extends am.b
{
  TextView aeSn;
  LinearLayout aeSo;
  MMNeat7extView vIW;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_text_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.chatting_item_biz_text);
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(R.h.title));
    this.aeSn = ((TextView)this.vJU.findViewById(R.h.fZa));
    this.aeSo = ((LinearLayout)this.vJU.findViewById(R.h.fZd));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.g
 * JD-Core Version:    0.7.0.1
 */