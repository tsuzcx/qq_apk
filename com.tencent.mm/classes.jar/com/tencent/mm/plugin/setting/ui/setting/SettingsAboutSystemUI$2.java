package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

final class SettingsAboutSystemUI$2
  implements View.OnClickListener
{
  SettingsAboutSystemUI$2(SettingsAboutSystemUI paramSettingsAboutSystemUI, LinearLayout paramLinearLayout, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74041);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    final int i = 0;
    while (i < this.yFM.getChildCount())
    {
      localObject = (TextView)this.yFM.getChildAt(i);
      if (2131305896 != ((TextView)localObject).getId()) {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
    i = ((Integer)paramView.getTag()).intValue();
    ad.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[] { Integer.valueOf(this.yFN), Integer.valueOf(i) });
    if (this.yFN == i)
    {
      a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(74041);
      return;
    }
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74040);
        ((Dialog)SettingsAboutSystemUI.2.this.yFM.getTag()).dismiss();
        g.ajC().ajl().set(327686, Integer.valueOf(i));
        g.ajC().ajl().fqc();
        SettingsAboutSystemUI.f(SettingsAboutSystemUI.2.this.yFL);
        AppMethodBeat.o(74040);
      }
    });
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(74041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2
 * JD-Core Version:    0.7.0.1
 */