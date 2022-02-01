package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.plugin.webview.k.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.c;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int Jhp;
  private int Jhq;
  private int Jhr;
  private float Jhs;
  float Jht;
  float Jhu;
  int Jhv;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.Jhp = 0;
    this.Jhq = 2;
    this.Jhr = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), b.d.chatting_normal_item_width);
    this.Jhs = 1.0F;
    this.Jht = 1.0F;
    this.Jhu = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static float hW(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.ci.a.ki(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.ci.a.kb(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.ci.a.ka(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.ci.a.kc(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.ci.a.kd(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.ci.a.ke(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.ci.a.kf(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.ci.a.kg(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.ci.a.kh(paramContext)) {
                    f1 = com.tencent.mm.ci.a.kb(paramContext);
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(74160);
    return f1;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74157);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.IzE.a(11609, new Object[] { Integer.valueOf(this.Jhp), Integer.valueOf(this.Jhq), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.Jhp), Integer.valueOf(this.Jhq) });
      finish();
      AppMethodBeat.o(74157);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(74157);
    return bool;
  }
  
  public int getLayoutId()
  {
    return b.g.settings_font_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74156);
    setMMTitle(b.i.settings_text_size);
    this.Jhs = hW(getContext());
    this.Jht = this.Jhs;
    Log.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.Jhs);
    final ImageView localImageView1 = (ImageView)findViewById(b.f.chatting_avatar_iv_to);
    final ImageView localImageView2 = (ImageView)findViewById(b.f.avatar_iv_from);
    final ImageView localImageView3 = (ImageView)findViewById(b.f.avatar_iv_from_two);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(b.f.settings_font_msg_to);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(b.f.settings_font_illustrate_one);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(b.f.settings_font_illustrate_two);
    a.b.c(localImageView1, z.bcZ());
    this.Jhr = ((int)(com.tencent.mm.ci.a.aZ(getContext(), b.d.chatting_normal_item_width) / com.tencent.mm.cj.a.hrd()));
    localMMNeat7extView2.setMaxWidth(this.Jhr);
    localMMNeat7extView3.setMaxWidth(this.Jhr);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(b.f.font_selector_view);
    float f2 = hW(getContext());
    if (f2 != com.tencent.mm.plugin.setting.a.hV(getContext())) {
      com.tencent.mm.plugin.setting.a.g(getContext(), f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.ci.a.ka(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.ci.a.kh(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.ci.a.ka(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.ci.a.ka(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void jj(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          SettingsFontUI.this.Jhv = paramAnonymousInt;
          AppCompatActivity localAppCompatActivity = SettingsFontUI.this.getContext();
          b localb;
          if (localAppCompatActivity == null)
          {
            Log.e("MicroMsg.FontSizeService", "onChangeFontSize get null");
            localb = new b();
            SettingsFontUI.this.Jht = localb.Jdm;
            SettingsFontUI.this.Jhu = localb.Jdn;
            localMMNeat7extView1.setTextSize(0, aw.aZ(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Jhu);
            localMMNeat7extView2.setTextSize(0, aw.aZ(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Jhu);
            localMMNeat7extView3.setTextSize(0, aw.aZ(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Jhu);
            SettingsFontUI.this.setMMTitleSize(com.tencent.mm.ci.a.aZ(localAppCompatActivity, b.d.ActionBarTextSize) * com.tencent.mm.ci.a.km(localAppCompatActivity));
            if (com.tencent.mm.ci.a.kj(SettingsFontUI.this.getContext()))
            {
              SettingsFontUI.a(SettingsFontUI.this, localImageView1, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView2, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView3, paramAnonymousInt);
            }
            AppMethodBeat.o(74151);
            return;
          }
          float f2;
          float f1;
          switch (paramAnonymousInt)
          {
          case 1: 
          default: 
            f2 = com.tencent.mm.ci.a.kb(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 400.0F;
          }
          for (;;)
          {
            if (!com.tencent.mm.ci.a.kj(localAppCompatActivity)) {
              f1 = f2;
            }
            localb = new b();
            localb.Jdm = f2;
            localb.Jdn = f1;
            break;
            f2 = com.tencent.mm.ci.a.ka(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 440.0F;
            continue;
            f2 = com.tencent.mm.ci.a.kc(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 360.0F;
            continue;
            f2 = com.tencent.mm.ci.a.kd(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 360.0F * 1.12F;
            continue;
            f2 = com.tencent.mm.ci.a.ke(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 340.0F * 1.125F;
            continue;
            f2 = com.tencent.mm.ci.a.kf(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 340.0F * 1.4F;
            continue;
            f2 = com.tencent.mm.ci.a.kg(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 340.0F * 1.55F;
            continue;
            f2 = com.tencent.mm.ci.a.kh(localAppCompatActivity);
            f1 = com.tencent.mm.cj.a.hrq() / 340.0F * 1.65F;
          }
        }
      });
      this.Jhq = com.tencent.mm.ci.a.kk(getContext());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74152);
          h.IzE.a(11609, new Object[] { Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(0) });
          Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)) });
          SettingsFontUI.this.finish();
          AppMethodBeat.o(74152);
          return true;
        }
      });
      addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(264500);
          SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.c(SettingsFontUI.this));
          AppMethodBeat.o(264500);
          return true;
        }
      }, null, w.b.Wao);
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.ci.a.kc(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.ci.a.kd(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.ci.a.ke(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.ci.a.kf(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.ci.a.kg(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.ci.a.kh(getContext())) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74155);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74155);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74158);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.IzE.a(11609, new Object[] { Integer.valueOf(this.Jhp), Integer.valueOf(this.Jhq), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.Jhp), Integer.valueOf(this.Jhq) });
      finish();
      AppMethodBeat.o(74158);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74158);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */