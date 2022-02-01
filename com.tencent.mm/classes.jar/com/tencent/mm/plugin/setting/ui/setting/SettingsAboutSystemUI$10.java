package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class SettingsAboutSystemUI$10
  implements View.OnClickListener
{
  SettingsAboutSystemUI$10(SettingsAboutSystemUI paramSettingsAboutSystemUI, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    int k = 0;
    AppMethodBeat.i(74053);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    int i = 0;
    while (i < this.DaJ.getChildCount())
    {
      localObject = (TextView)this.DaJ.getChildAt(i);
      if (2131309187 != ((TextView)localObject).getId()) {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691379, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
    int m = ((Integer)g.aAh().azQ().get(7, Integer.valueOf(0))).intValue();
    int n = ((Integer)paramView.getTag()).intValue();
    Log.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(n) });
    if (n == 0)
    {
      i = 1;
      if ((m & 0x1000000) != 0) {
        break label204;
      }
    }
    label204:
    for (int j = 1;; j = 0)
    {
      if (i != j) {
        break label209;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(74053);
      return;
      i = 0;
      break;
    }
    label209:
    i = k;
    if (n == 0) {
      i = 1;
    }
    if (i != 0)
    {
      j = 0xFEFFFFFF & m;
      if (i != 0) {
        break label349;
      }
    }
    label349:
    for (i = 1;; i = 2)
    {
      g.aAh().azQ().set(7, Integer.valueOf(j));
      localObject = new bfx();
      ((bfx)localObject).LPB = 35;
      ((bfx)localObject).BsD = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      c.jRu.WZ();
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74052);
          ((Dialog)SettingsAboutSystemUI.10.this.DaJ.getTag()).dismiss();
          SettingsAboutSystemUI.e(SettingsAboutSystemUI.10.this.DaI);
          AppMethodBeat.o(74052);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(74053);
      return;
      j = m | 0x1000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.10
 * JD-Core Version:    0.7.0.1
 */