package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.vas.VASActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.y.b;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends VASActivity
{
  private int Pta;
  private int Ptb;
  private int Ptc;
  private float Ptd;
  float Pte;
  float Ptf;
  int Ptg;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.Pta = 0;
    this.Ptb = 2;
    this.Ptc = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), b.d.chatting_normal_item_width);
    this.Ptd = 1.0F;
    this.Pte = 1.0F;
    this.Ptf = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static float jF(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.cd.a.mk(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cd.a.md(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cd.a.mc(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cd.a.me(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cd.a.mf(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cd.a.mg(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cd.a.mh(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cd.a.mi(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cd.a.mj(paramContext)) {
                    f1 = com.tencent.mm.cd.a.md(paramContext);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(11609, new Object[] { Integer.valueOf(this.Pta), Integer.valueOf(this.Ptb), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.Pta), Integer.valueOf(this.Ptb) });
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
    this.Ptd = jF(getContext());
    this.Pte = this.Ptd;
    Log.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.Ptd);
    final ImageView localImageView1 = (ImageView)findViewById(b.f.chatting_avatar_iv_to);
    final ImageView localImageView2 = (ImageView)findViewById(b.f.avatar_iv_from);
    final ImageView localImageView3 = (ImageView)findViewById(b.f.avatar_iv_from_two);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(b.f.settings_font_msg_to);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(b.f.settings_font_illustrate_one);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(b.f.settings_font_illustrate_two);
    if (com.tencent.mm.kernel.h.baz()) {
      a.b.g(localImageView1, z.bAM());
    }
    this.Ptc = ((int)(com.tencent.mm.cd.a.bs(getContext(), b.d.chatting_normal_item_width) / com.tencent.mm.ce.c.iRs()));
    localMMNeat7extView2.setMaxWidth(this.Ptc);
    localMMNeat7extView3.setMaxWidth(this.Ptc);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(b.f.font_selector_view);
    float f2 = jF(getContext());
    if (f2 != com.tencent.mm.plugin.setting.a.jE(getContext())) {
      com.tencent.mm.plugin.setting.a.h(getContext(), f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cd.a.mc(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cd.a.mj(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cd.a.mc(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cd.a.mc(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void mL(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          SettingsFontUI.this.Ptg = paramAnonymousInt;
          AppCompatActivity localAppCompatActivity = SettingsFontUI.this.getContext();
          com.tencent.mm.plugin.setting.model.c localc;
          if (localAppCompatActivity == null)
          {
            Log.e("MicroMsg.FontSizeService", "onChangeFontSize get null");
            localc = new com.tencent.mm.plugin.setting.model.c();
            SettingsFontUI.this.Pte = localc.PnA;
            SettingsFontUI.this.Ptf = localc.PnB;
            localMMNeat7extView1.setTextSize(0, bd.bs(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Ptf);
            localMMNeat7extView2.setTextSize(0, bd.bs(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Ptf);
            localMMNeat7extView3.setTextSize(0, bd.bs(SettingsFontUI.this.getContext(), b.d.NormalTextSize) * SettingsFontUI.this.Ptf);
            SettingsFontUI.this.setMMTitleSize(com.tencent.mm.cd.a.bs(localAppCompatActivity, b.d.ActionBarTextSize) * com.tencent.mm.cd.a.jO(localAppCompatActivity));
            if (com.tencent.mm.cd.a.ml(SettingsFontUI.this.getContext()))
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
            f2 = com.tencent.mm.cd.a.md(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 400.0F;
          }
          for (;;)
          {
            if (!com.tencent.mm.cd.a.ml(localAppCompatActivity)) {
              f1 = f2;
            }
            localc = new com.tencent.mm.plugin.setting.model.c();
            localc.PnA = f2;
            localc.PnB = f1;
            break;
            f2 = com.tencent.mm.cd.a.mc(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 440.0F;
            continue;
            f2 = com.tencent.mm.cd.a.me(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 360.0F;
            continue;
            f2 = com.tencent.mm.cd.a.mf(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 360.0F * 1.12F;
            continue;
            f2 = com.tencent.mm.cd.a.mg(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 340.0F * 1.125F;
            continue;
            f2 = com.tencent.mm.cd.a.mh(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 340.0F * 1.4F;
            continue;
            f2 = com.tencent.mm.cd.a.mi(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 340.0F * 1.55F;
            continue;
            f2 = com.tencent.mm.cd.a.mj(localAppCompatActivity);
            f1 = com.tencent.mm.ce.c.iRG() / 340.0F * 1.65F;
          }
        }
      });
      this.Ptb = com.tencent.mm.cd.a.mm(getContext());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74152);
          com.tencent.mm.plugin.report.service.h.OAn.b(11609, new Object[] { Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(0) });
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
          AppMethodBeat.i(298652);
          SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.c(SettingsFontUI.this));
          AppMethodBeat.o(298652);
          return true;
        }
      }, null, y.b.adEJ);
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.cd.a.me(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cd.a.mf(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cd.a.mg(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cd.a.mh(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cd.a.mi(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cd.a.mj(getContext())) {
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
      com.tencent.mm.plugin.report.service.h.OAn.b(11609, new Object[] { Integer.valueOf(this.Pta), Integer.valueOf(this.Ptb), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.Pta), Integer.valueOf(this.Ptb) });
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(298858);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.setting.ui.a.b.class);
    AppMethodBeat.o(298858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */