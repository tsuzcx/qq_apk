package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class FMessageListView$4
  implements View.OnLongClickListener
{
  FMessageListView$4(FMessageListView paramFMessageListView, b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(28041);
    ab.d("MicroMsg.FMessageListView", "jacks long click digest");
    paramView = this.waO.getContext();
    String str = this.waO.getContext().getString(2131298161);
    FMessageListView.4.1 local1 = new FMessageListView.4.1(this);
    h.a(paramView, null, new String[] { str }, local1);
    AppMethodBeat.o(28041);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView.4
 * JD-Core Version:    0.7.0.1
 */