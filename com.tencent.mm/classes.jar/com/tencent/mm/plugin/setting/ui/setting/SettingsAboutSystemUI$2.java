package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SettingsAboutSystemUI$2
  implements View.OnClickListener
{
  SettingsAboutSystemUI$2(SettingsAboutSystemUI paramSettingsAboutSystemUI, LinearLayout paramLinearLayout, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127109);
    int i = 0;
    while (i < this.qHq.getChildCount())
    {
      TextView localTextView = (TextView)this.qHq.getChildAt(i);
      if (2131823916 != localTextView.getId()) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2131231905, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    i = ((Integer)paramView.getTag()).intValue();
    ab.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[] { Integer.valueOf(this.qHr), Integer.valueOf(i) });
    if (this.qHr == i)
    {
      AppMethodBeat.o(127109);
      return;
    }
    paramView.post(new SettingsAboutSystemUI.2.1(this, i));
    AppMethodBeat.o(127109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2
 * JD-Core Version:    0.7.0.1
 */