package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class FMessageListView$4
  implements View.OnLongClickListener
{
  FMessageListView$4(FMessageListView paramFMessageListView, b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.d("MicroMsg.FMessageListView", "jacks long click digest");
    paramView = this.sip.getContext();
    String str = this.sip.getContext().getString(R.l.chatting_copy);
    FMessageListView.4.1 local1 = new FMessageListView.4.1(this);
    h.a(paramView, null, new String[] { str }, local1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView.4
 * JD-Core Version:    0.7.0.1
 */