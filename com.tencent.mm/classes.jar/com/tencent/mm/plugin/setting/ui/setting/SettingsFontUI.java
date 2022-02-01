package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.g.a.il;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.plugin.webview.k.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.c;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int DbO;
  private int DbP;
  private int DbQ;
  private float DbR;
  float DbS;
  float DbT;
  int DbU;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.DbO = 0;
    this.DbP = 2;
    this.DbQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2131166078);
    this.DbR = 1.0F;
    this.DbS = 1.0F;
    this.DbT = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static float gW(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.cb.a.je(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cb.a.iX(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.iW(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cb.a.iY(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cb.a.iZ(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cb.a.ja(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cb.a.jb(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cb.a.jc(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cb.a.jd(paramContext)) {
                    f1 = com.tencent.mm.cb.a.iX(paramContext);
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
      h.CyF.a(11609, new Object[] { Integer.valueOf(this.DbO), Integer.valueOf(this.DbP), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.DbO), Integer.valueOf(this.DbP) });
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
    return 2131496253;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74156);
    setMMTitle(2131765639);
    this.DbR = gW(getContext());
    this.DbS = this.DbR;
    Log.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.DbR);
    final ImageView localImageView1 = (ImageView)findViewById(2131298399);
    final ImageView localImageView2 = (ImageView)findViewById(2131297135);
    final ImageView localImageView3 = (ImageView)findViewById(2131297136);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(2131307701);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(2131307699);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(2131307700);
    a.b.c(localImageView1, z.aTY());
    this.DbQ = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131166078) / com.tencent.mm.cc.a.gvi()));
    localMMNeat7extView2.setMaxWidth(this.DbQ);
    localMMNeat7extView3.setMaxWidth(this.DbQ);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(2131301660);
    float f2 = gW(getContext());
    if (f2 != com.tencent.mm.plugin.setting.a.gV(getContext())) {
      com.tencent.mm.plugin.setting.a.g(getContext(), f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cb.a.iW(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cb.a.jd(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.iW(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cb.a.iW(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void ig(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          SettingsFontUI.this.DbU = paramAnonymousInt;
          AppCompatActivity localAppCompatActivity = SettingsFontUI.this.getContext();
          b localb;
          if (localAppCompatActivity == null)
          {
            Log.e("MicroMsg.FontSizeService", "onChangeFontSize get null");
            localb = new b();
            SettingsFontUI.this.DbS = localb.CXG;
            SettingsFontUI.this.DbT = localb.CXH;
            localMMNeat7extView1.setTextSize(0, at.aH(SettingsFontUI.this.getContext(), 2131165535) * SettingsFontUI.this.DbT);
            localMMNeat7extView2.setTextSize(0, at.aH(SettingsFontUI.this.getContext(), 2131165535) * SettingsFontUI.this.DbT);
            localMMNeat7extView3.setTextSize(0, at.aH(SettingsFontUI.this.getContext(), 2131165535) * SettingsFontUI.this.DbT);
            SettingsFontUI.this.setMMTitleSize(com.tencent.mm.cb.a.aH(localAppCompatActivity, 2131165186) * com.tencent.mm.cb.a.ji(localAppCompatActivity));
            if (com.tencent.mm.cb.a.jf(SettingsFontUI.this.getContext()))
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
            f2 = com.tencent.mm.cb.a.iX(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 400.0F;
          }
          for (;;)
          {
            if (!com.tencent.mm.cb.a.jf(localAppCompatActivity)) {
              f1 = f2;
            }
            localb = new b();
            localb.CXG = f2;
            localb.CXH = f1;
            break;
            f2 = com.tencent.mm.cb.a.iW(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 440.0F;
            continue;
            f2 = com.tencent.mm.cb.a.iY(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 360.0F;
            continue;
            f2 = com.tencent.mm.cb.a.iZ(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 360.0F * 1.12F;
            continue;
            f2 = com.tencent.mm.cb.a.ja(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 340.0F * 1.125F;
            continue;
            f2 = com.tencent.mm.cb.a.jb(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 340.0F * 1.4F;
            continue;
            f2 = com.tencent.mm.cb.a.jc(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 340.0F * 1.55F;
            continue;
            f2 = com.tencent.mm.cb.a.jd(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.gvu() / 340.0F * 1.65F;
          }
        }
      });
      this.DbP = com.tencent.mm.cb.a.jg(getContext());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74152);
          h.CyF.a(11609, new Object[] { Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(0) });
          Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)) });
          SettingsFontUI.this.finish();
          AppMethodBeat.o(74152);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(256538);
          SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.c(SettingsFontUI.this));
          AppMethodBeat.o(256538);
          return true;
        }
      }, null, t.b.OGU);
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.cb.a.iY(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cb.a.iZ(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cb.a.ja(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cb.a.jb(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cb.a.jc(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cb.a.jd(getContext())) {
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
      h.CyF.a(11609, new Object[] { Integer.valueOf(this.DbO), Integer.valueOf(this.DbP), Integer.valueOf(0) });
      Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.DbO), Integer.valueOf(this.DbP) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */