package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.plugin.webview.j.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int xse;
  private int xsf;
  private int xsg;
  private float xsh;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.xse = 0;
    this.xsf = 2;
    this.xsg = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 2131166038);
    this.xsh = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static int Nz(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 400;
    case 0: 
      return 440;
    case 2: 
    case 3: 
      return 360;
    }
    return 340;
  }
  
  private void bv(final float paramFloat)
  {
    AppMethodBeat.i(74159);
    final float f = gb(getContext());
    ac.i("MicroMsg.SettingsFontUI", "fontSizeAfter=".concat(String.valueOf(f)));
    final int i = ga(getContext());
    if (f != paramFloat)
    {
      f.a locala = new f.a(getContext());
      locala.aRQ(getContext().getResources().getString(2131763120)).yi(true);
      locala.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(74153);
          if (paramAnonymousBoolean)
          {
            SettingsFontUI.this.finish();
            int i = com.tencent.mm.cd.a.eSx();
            int j = SettingsFontUI.NA(i);
            if (j != i)
            {
              com.tencent.mm.cd.a.Ya(j);
              paramAnonymousString = new Intent();
              paramAnonymousString.putExtra("Intro_Need_Clear_Top ", true);
              b.iyx.p(paramAnonymousString, SettingsFontUI.this.getContext());
              com.tencent.mm.bv.a.hC(ai.getContext());
              System.exit(0);
              AppMethodBeat.o(74153);
              return;
            }
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("Intro_Need_Clear_Top ", true);
            b.iyx.p(paramAnonymousString, SettingsFontUI.this.getContext());
            paramAnonymousString = new ho();
            paramAnonymousString.diF.diG = paramFloat;
            paramAnonymousString.diF.diH = f;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
            d.aSU("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
          }
          AppMethodBeat.o(74153);
        }
      }).show();
      AppMethodBeat.o(74159);
      return;
    }
    finish();
    AppMethodBeat.o(74159);
  }
  
  private void bw(float paramFloat)
  {
    AppMethodBeat.i(74163);
    SharedPreferences.Editor localEditor = getContext().getSharedPreferences(ai.eUX(), 0).edit();
    localEditor.putFloat("current_text_size_scale_key", paramFloat);
    localEditor.commit();
    AppMethodBeat.o(74163);
  }
  
  private static float fZ(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.cc.a.hX(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cc.a.hQ(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cc.a.hP(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cc.a.hR(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cc.a.hS(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cc.a.hT(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cc.a.hU(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cc.a.hV(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cc.a.hW(paramContext)) {
                    f1 = com.tencent.mm.cc.a.hQ(paramContext);
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
  
  private static int ga(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(74161);
    if (paramContext != null) {
      i = paramContext.getSharedPreferences(ai.eUX(), 0).getInt("current_text_size_index_key", 1);
    }
    AppMethodBeat.o(74161);
    return i;
  }
  
  private float gb(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(74162);
    if (paramContext != null) {
      f = getContext().getSharedPreferences(ai.eUX(), 0).getFloat("current_text_size_scale_key", 1.0F);
    }
    AppMethodBeat.o(74162);
    return f;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74157);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      bv(this.xsh);
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
    this.xsh = fZ(getContext());
    ac.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.xsh);
    final ImageView localImageView1 = (ImageView)findViewById(2131298058);
    final ImageView localImageView2 = (ImageView)findViewById(2131297009);
    final ImageView localImageView3 = (ImageView)findViewById(2131297010);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(2131304648);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(2131304646);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(2131304647);
    a.b.c(localImageView1, u.axw());
    this.xsg = ((int)(com.tencent.mm.cc.a.av(getContext(), 2131166038) / com.tencent.mm.cd.a.eSl()));
    localMMNeat7extView2.setMaxWidth(this.xsg);
    localMMNeat7extView3.setMaxWidth(this.xsg);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(2131300195);
    float f2 = fZ(getContext());
    if (f2 != gb(getContext())) {
      bw(f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cc.a.hP(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cc.a.hW(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cc.a.hP(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cc.a.hP(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void NB(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          float f2;
          float f1;
          switch (paramAnonymousInt)
          {
          default: 
            f2 = com.tencent.mm.cc.a.hQ(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 400.0F;
            if (!com.tencent.mm.cc.a.hY(SettingsFontUI.this.getContext())) {
              f1 = f2;
            }
            if (f2 != SettingsFontUI.a(SettingsFontUI.this)) {
              SettingsFontUI.a(SettingsFontUI.this, 1);
            }
            break;
          }
          for (;;)
          {
            com.tencent.mm.cc.a.h(SettingsFontUI.this.getContext(), f2);
            SettingsFontUI.a(SettingsFontUI.this, f2);
            Object localObject = SettingsFontUI.this.getContext().getSharedPreferences(ai.eUX(), 0).edit();
            ((SharedPreferences.Editor)localObject).putInt("current_text_size_index_key", paramAnonymousInt);
            ((SharedPreferences.Editor)localObject).commit();
            e.uJ(true);
            SettingsFontUI.b(SettingsFontUI.this, com.tencent.mm.cc.a.hZ(SettingsFontUI.this.getContext()));
            localObject = SettingsFontUI.this.getContext();
            localMMNeat7extView1.setTextSize(0, ao.av(SettingsFontUI.this.getContext(), 2131165517) * f1);
            localMMNeat7extView2.setTextSize(0, ao.av(SettingsFontUI.this.getContext(), 2131165517) * f1);
            localMMNeat7extView3.setTextSize(0, f1 * ao.av(SettingsFontUI.this.getContext(), 2131165517));
            SettingsFontUI localSettingsFontUI = SettingsFontUI.this;
            f1 = com.tencent.mm.cc.a.av((Context)localObject, 2131165184);
            localSettingsFontUI.setMMTitleSize(com.tencent.mm.cc.a.ib((Context)localObject) * f1);
            if (com.tencent.mm.cc.a.hY(SettingsFontUI.this.getContext()))
            {
              SettingsFontUI.a(SettingsFontUI.this, localImageView1, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView2, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView3, paramAnonymousInt);
            }
            AppMethodBeat.o(74151);
            return;
            f2 = com.tencent.mm.cc.a.hP(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 440.0F;
            break;
            f2 = com.tencent.mm.cc.a.hQ(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 400.0F;
            break;
            f2 = com.tencent.mm.cc.a.hR(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 360.0F;
            break;
            f2 = com.tencent.mm.cc.a.hS(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 360.0F * 1.12F;
            break;
            f2 = com.tencent.mm.cc.a.hT(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 340.0F * 1.125F;
            break;
            f2 = com.tencent.mm.cc.a.hU(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 340.0F * 1.4F;
            break;
            f2 = com.tencent.mm.cc.a.hV(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 340.0F * 1.55F;
            break;
            f2 = com.tencent.mm.cc.a.hW(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.cd.a.eSx() / 340.0F * 1.65F;
            break;
            SettingsFontUI.a(SettingsFontUI.this, 0);
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74152);
          h.wUl.f(11609, new Object[] { Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.c(SettingsFontUI.this)), Integer.valueOf(0) });
          ac.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.c(SettingsFontUI.this)) });
          SettingsFontUI.b(SettingsFontUI.this, SettingsFontUI.a(SettingsFontUI.this));
          AppMethodBeat.o(74152);
          return true;
        }
      });
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.cc.a.hR(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cc.a.hS(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cc.a.hT(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cc.a.hU(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cc.a.hV(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cc.a.hW(getContext())) {
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
      h.wUl.f(11609, new Object[] { Integer.valueOf(this.xse), Integer.valueOf(this.xsf), Integer.valueOf(0) });
      ac.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.xse), Integer.valueOf(this.xsf) });
      bv(this.xsh);
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