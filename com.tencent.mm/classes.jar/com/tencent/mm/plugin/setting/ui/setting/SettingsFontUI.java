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
import com.tencent.mm.cp.d;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.model.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.plugin.webview.j.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.c;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int yWW;
  private int yWX;
  private int yWY;
  private float yWZ;
  float yXa;
  float yXb;
  int yXc;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.yWW = 0;
    this.yWX = 2;
    this.yWY = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 2131166038);
    this.yWZ = 1.0F;
    this.yXa = 1.0F;
    this.yXb = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static float gk(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.cb.a.il(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cb.a.ie(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.id(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cb.a.jdMethod_if(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cb.a.ig(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cb.a.ih(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cb.a.ii(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cb.a.ij(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cb.a.ik(paramContext)) {
                    f1 = com.tencent.mm.cb.a.ie(paramContext);
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
      g.yxI.f(11609, new Object[] { Integer.valueOf(this.yWW), Integer.valueOf(this.yWX), Integer.valueOf(0) });
      ae.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.yWW), Integer.valueOf(this.yWX) });
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
    return 2131495392;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74156);
    setMMTitle(2131763456);
    this.yWZ = gk(getContext());
    this.yXa = this.yWZ;
    ae.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.yWZ);
    final ImageView localImageView1 = (ImageView)findViewById(2131298058);
    final ImageView localImageView2 = (ImageView)findViewById(2131297009);
    final ImageView localImageView3 = (ImageView)findViewById(2131297010);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(2131304648);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(2131304646);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(2131304647);
    a.b.c(localImageView1, v.aAC());
    this.yWY = ((int)(com.tencent.mm.cb.a.ay(getContext(), 2131166038) / com.tencent.mm.cc.a.flw()));
    localMMNeat7extView2.setMaxWidth(this.yWY);
    localMMNeat7extView3.setMaxWidth(this.yWY);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(2131300195);
    float f2 = gk(getContext());
    if (f2 != com.tencent.mm.plugin.setting.a.gj(getContext())) {
      com.tencent.mm.plugin.setting.a.g(getContext(), f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cb.a.id(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cb.a.ik(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.id(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cb.a.id(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void PL(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          SettingsFontUI.this.yXc = paramAnonymousInt;
          AppCompatActivity localAppCompatActivity = SettingsFontUI.this.getContext();
          b localb;
          if (localAppCompatActivity == null)
          {
            ae.e("MicroMsg.FontSizeService", "onChangeFontSize get null");
            localb = new b();
            SettingsFontUI.this.yXa = localb.ySQ;
            SettingsFontUI.this.yXb = localb.ySR;
            localMMNeat7extView1.setTextSize(0, aq.ay(SettingsFontUI.this.getContext(), 2131165517) * SettingsFontUI.this.yXb);
            localMMNeat7extView2.setTextSize(0, aq.ay(SettingsFontUI.this.getContext(), 2131165517) * SettingsFontUI.this.yXb);
            localMMNeat7extView3.setTextSize(0, aq.ay(SettingsFontUI.this.getContext(), 2131165517) * SettingsFontUI.this.yXb);
            SettingsFontUI.this.setMMTitleSize(com.tencent.mm.cb.a.ay(localAppCompatActivity, 2131165184) * com.tencent.mm.cb.a.ip(localAppCompatActivity));
            if (com.tencent.mm.cb.a.im(SettingsFontUI.this.getContext()))
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
            f2 = com.tencent.mm.cb.a.ie(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 400.0F;
          }
          for (;;)
          {
            if (!com.tencent.mm.cb.a.im(localAppCompatActivity)) {
              f1 = f2;
            }
            localb = new b();
            localb.ySQ = f2;
            localb.ySR = f1;
            break;
            f2 = com.tencent.mm.cb.a.id(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 440.0F;
            continue;
            f2 = com.tencent.mm.cb.a.jdMethod_if(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 360.0F;
            continue;
            f2 = com.tencent.mm.cb.a.ig(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 360.0F * 1.12F;
            continue;
            f2 = com.tencent.mm.cb.a.ih(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 340.0F * 1.125F;
            continue;
            f2 = com.tencent.mm.cb.a.ii(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 340.0F * 1.4F;
            continue;
            f2 = com.tencent.mm.cb.a.ij(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 340.0F * 1.55F;
            continue;
            f2 = com.tencent.mm.cb.a.ik(localAppCompatActivity);
            f1 = com.tencent.mm.cc.a.flI() / 340.0F * 1.65F;
          }
        }
      });
      this.yWX = com.tencent.mm.cb.a.in(getContext());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74152);
          g.yxI.f(11609, new Object[] { Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(0) });
          ae.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)) });
          SettingsFontUI.this.finish();
          AppMethodBeat.o(74152);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190364);
          SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.c(SettingsFontUI.this));
          AppMethodBeat.o(190364);
          return true;
        }
      }, null, s.b.JwA);
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.cb.a.jdMethod_if(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cb.a.ig(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cb.a.ih(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cb.a.ii(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cb.a.ij(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cb.a.ik(getContext())) {
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
      g.yxI.f(11609, new Object[] { Integer.valueOf(this.yWW), Integer.valueOf(this.yWX), Integer.valueOf(0) });
      ae.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.yWW), Integer.valueOf(this.yWX) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */