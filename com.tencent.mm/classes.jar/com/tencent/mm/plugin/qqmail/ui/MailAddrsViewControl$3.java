package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;

final class MailAddrsViewControl$3
  implements AdapterView.OnItemClickListener
{
  MailAddrsViewControl$3(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = MailAddrsViewControl.e(this.nir).wo(paramInt);
    this.nir.e(paramAdapterView);
    this.nir.nik.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.3
 * JD-Core Version:    0.7.0.1
 */