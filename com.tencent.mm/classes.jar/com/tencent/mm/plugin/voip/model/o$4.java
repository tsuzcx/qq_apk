package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.ah;

final class o$4
  implements DialogInterface.OnClickListener
{
  o$4(o paramo, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.pSR != null) {
      o.g(this.pSP).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", this.pSR.isChecked()).commit();
    }
    if (4096 != o.v(this.pSP))
    {
      o.d(this.pSP, o.v(this.pSP));
      o.w(this.pSP);
    }
    if (o.x(this.pSP) != null) {
      o.x(this.pSP).post(new Runnable()
      {
        public final void run()
        {
          o.k(o.4.this.pSP);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.4
 * JD-Core Version:    0.7.0.1
 */