package com.tencent.mm.ui.base.preference;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Preference$1
  implements Runnable
{
  Preference$1(Preference paramPreference, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(164171);
    CharSequence localCharSequence = this.aeak.gBR();
    if (localCharSequence == null)
    {
      AppMethodBeat.o(164171);
      return;
    }
    int i = this.MGK.getMeasuredWidth() + this.aeaj.getMeasuredWidth();
    if (i > 0)
    {
      int j = (int)this.aeaj.getPaint().measureText(this.aeaj.getText().toString());
      if ((int)this.MGK.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
      {
        localCharSequence = TextUtils.ellipsize(localCharSequence, this.MGK.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
        this.MGK.setText(localCharSequence);
      }
    }
    AppMethodBeat.o(164171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference.1
 * JD-Core Version:    0.7.0.1
 */