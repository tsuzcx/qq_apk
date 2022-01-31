package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsAboutSystemUI$2
  implements View.OnClickListener
{
  SettingsAboutSystemUI$2(SettingsAboutSystemUI paramSettingsAboutSystemUI, LinearLayout paramLinearLayout, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    while (i < this.nTq.getChildCount())
    {
      TextView localTextView = (TextView)this.nTq.getChildAt(i);
      if (a.f.tips_tv != localTextView.getId()) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(a.h.radio_off, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(a.h.radio_on, 0, 0, 0);
    i = ((Integer)paramView.getTag()).intValue();
    y.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[] { Integer.valueOf(this.nTr), Integer.valueOf(i) });
    if (this.nTr == i) {
      return;
    }
    paramView.post(new SettingsAboutSystemUI.2.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2
 * JD-Core Version:    0.7.0.1
 */