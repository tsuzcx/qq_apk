package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$3
  implements AdapterView.OnItemClickListener
{
  MailAddrsViewControl$3(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(68340);
    paramAdapterView = MailAddrsViewControl.e(this.pNE).Ca(paramInt);
    this.pNE.e(paramAdapterView);
    this.pNE.pNx.setText("");
    AppMethodBeat.o(68340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.3
 * JD-Core Version:    0.7.0.1
 */