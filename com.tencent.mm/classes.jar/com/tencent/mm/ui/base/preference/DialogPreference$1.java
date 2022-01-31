package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.widget.a.c;

final class DialogPreference$1
  implements AdapterView.OnItemClickListener
{
  DialogPreference$1(DialogPreference paramDialogPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (DialogPreference.a(this.vcg) != null) {
      DialogPreference.a(this.vcg).dismiss();
    }
    this.vcg.setValue((String)DialogPreference.b(this.vcg).vcb[paramInt]);
    if (DialogPreference.c(this.vcg) != null) {
      DialogPreference.c(this.vcg).cBt();
    }
    if (DialogPreference.d(this.vcg) != null) {
      DialogPreference.d(this.vcg).a(this.vcg, this.vcg.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference.1
 * JD-Core Version:    0.7.0.1
 */