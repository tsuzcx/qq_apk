package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$1
  implements View.OnClickListener
{
  w$1(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33811);
    paramView = paramView.getContext();
    Intent localIntent = new Intent(paramView, OpenIMAddressUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_openim_acctype_id", w.a(this.Aez));
    paramView.startActivity(localIntent);
    AppMethodBeat.o(33811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w.1
 * JD-Core Version:    0.7.0.1
 */