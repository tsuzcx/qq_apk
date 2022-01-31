package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;

final class SettingsAboutSystemUI$3
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$3(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!a.zD()) {}
    for (boolean bool = true;; bool = false)
    {
      a.bt(bool);
      g.DQ().releaseAll();
      ai.d(new SettingsAboutSystemUI.3.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3
 * JD-Core Version:    0.7.0.1
 */