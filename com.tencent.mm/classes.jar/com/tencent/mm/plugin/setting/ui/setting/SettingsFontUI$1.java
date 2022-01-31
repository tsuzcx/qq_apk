package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SettingsFontUI$1
  implements FontSelectorView.a
{
  SettingsFontUI$1(SettingsFontUI paramSettingsFontUI, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3) {}
  
  public final void xc(int paramInt)
  {
    float f2 = 1.0F;
    float f1 = f2;
    label75:
    Object localObject;
    switch (paramInt)
    {
    default: 
      f1 = f2;
    case 1: 
      if (f1 != this.nUp.nUl)
      {
        SettingsFontUI.a(this.nUp, 1);
        a.g(this.nUp.mController.uMN, f1);
        localObject = this.nUp.mController.uMN.getSharedPreferences(ae.cqR(), 0).edit();
        ((SharedPreferences.Editor)localObject).putFloat("current_text_size_scale_key", f1);
        ((SharedPreferences.Editor)localObject).commit();
        SettingsFontUI.b(this.nUp, a.fe(this.nUp.mController.uMN));
        f2 = a.cJ(this.nUp.mController.uMN);
        localObject = this.nUp.mController.uMN;
        if (f2 != 0.875F) {
          break label330;
        }
        SettingsFontUI.c(this.nUp, a.ab((Context)localObject, a.d.chatting_small_item_width));
      }
      break;
    }
    for (;;)
    {
      this.nUm.setTextSize(1, SetTextSizeUI.ax(f1));
      this.nUn.setTextSize(1, SetTextSizeUI.ax(f1));
      this.nUo.setTextSize(1, SetTextSizeUI.ax(f1));
      SettingsFontUI localSettingsFontUI = this.nUp;
      f1 = a.ab((Context)localObject, a.d.ActionBarTextSize);
      f2 = a.ff((Context)localObject);
      localSettingsFontUI.mController.uMS.setTextSize(0, f1 * f2);
      return;
      f1 = 0.875F;
      break;
      f1 = 1.125F;
      break;
      f1 = 1.25F;
      break;
      f1 = 1.375F;
      break;
      f1 = 1.625F;
      break;
      f1 = 1.875F;
      break;
      f1 = 2.025F;
      break;
      SettingsFontUI.a(this.nUp, 0);
      break label75;
      label330:
      if (f2 == 1.125F) {
        SettingsFontUI.c(this.nUp, a.ab((Context)localObject, a.d.chatting_large_item_width));
      } else if (f2 == 1.25F) {
        SettingsFontUI.c(this.nUp, a.ab((Context)localObject, a.d.chatting_super_item_width));
      } else if (f2 == 1.375F) {
        SettingsFontUI.c(this.nUp, a.ab((Context)localObject, a.d.chatting_huge_item_width));
      } else if ((f2 == 1.625F) || (f2 == 1.875F) || (f2 == 2.025F)) {
        SettingsFontUI.c(this.nUp, a.ab((Context)localObject, a.d.chatting_huger_item_width));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.1
 * JD-Core Version:    0.7.0.1
 */