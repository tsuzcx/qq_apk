package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class SettingsFontUI$1
  implements FontSelectorView.a
{
  SettingsFontUI$1(SettingsFontUI paramSettingsFontUI, MMNeat7extView paramMMNeat7extView1, MMNeat7extView paramMMNeat7extView2, MMNeat7extView paramMMNeat7extView3, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public final void Da(int paramInt)
  {
    AppMethodBeat.i(127221);
    float f2;
    float f1;
    switch (paramInt)
    {
    default: 
      f2 = com.tencent.mm.cb.a.gg(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 400.0F;
      if (!com.tencent.mm.cb.a.go(this.qIs.getContext())) {
        f1 = f2;
      }
      if (f2 != SettingsFontUI.a(this.qIs)) {
        SettingsFontUI.a(this.qIs, 1);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.cb.a.h(this.qIs.getContext(), f2);
      SettingsFontUI.a(this.qIs, f2);
      Object localObject = this.qIs.getContext().getSharedPreferences(ah.dsP(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("current_text_size_index_key", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      SettingsFontUI.b(this.qIs, com.tencent.mm.cb.a.gp(this.qIs.getContext()));
      localObject = this.qIs.getContext();
      this.qIm.setTextSize(0, al.ap(this.qIs.getContext(), 2131427809) * f1);
      this.qIn.setTextSize(0, al.ap(this.qIs.getContext(), 2131427809) * f1);
      this.qIo.setTextSize(0, f1 * al.ap(this.qIs.getContext(), 2131427809));
      SettingsFontUI localSettingsFontUI = this.qIs;
      f1 = com.tencent.mm.cb.a.ap((Context)localObject, 2131427493);
      localSettingsFontUI.setMMTitleSize(com.tencent.mm.cb.a.gr((Context)localObject) * f1);
      if (com.tencent.mm.cb.a.go(this.qIs.getContext()))
      {
        SettingsFontUI.a(this.qIs, this.qIp, paramInt);
        SettingsFontUI.a(this.qIs, this.qIq, paramInt);
        SettingsFontUI.a(this.qIs, this.qIr, paramInt);
      }
      AppMethodBeat.o(127221);
      return;
      f2 = com.tencent.mm.cb.a.gf(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 440.0F;
      break;
      f2 = com.tencent.mm.cb.a.gg(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 400.0F;
      break;
      f2 = com.tencent.mm.cb.a.gh(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 360.0F;
      break;
      f2 = com.tencent.mm.cb.a.gi(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 360.0F * 1.12F;
      break;
      f2 = com.tencent.mm.cb.a.gj(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 340.0F * 1.125F;
      break;
      f2 = com.tencent.mm.cb.a.gk(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 340.0F * 1.4F;
      break;
      f2 = com.tencent.mm.cb.a.gl(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 340.0F * 1.55F;
      break;
      f2 = com.tencent.mm.cb.a.gm(this.qIs.getContext());
      f1 = com.tencent.mm.cc.a.dre() / 340.0F * 1.65F;
      break;
      SettingsFontUI.a(this.qIs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.1
 * JD-Core Version:    0.7.0.1
 */