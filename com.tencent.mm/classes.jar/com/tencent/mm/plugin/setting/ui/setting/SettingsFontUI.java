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
import com.tencent.mm.cr.d;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.plugin.webview.j.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int wgO;
  private int wgP;
  private int wgQ;
  private float wgR;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(74154);
    this.wgO = 0;
    this.wgP = 2;
    this.wgQ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 2131166038);
    this.wgR = 1.0F;
    AppMethodBeat.o(74154);
  }
  
  private static int Lz(int paramInt)
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
  
  private void bn(final float paramFloat)
  {
    AppMethodBeat.i(74159);
    final float f = fP(getContext());
    ad.i("MicroMsg.SettingsFontUI", "fontSizeAfter=".concat(String.valueOf(f)));
    final int i = fO(getContext());
    if (f != paramFloat)
    {
      f.a locala = new f.a(getContext());
      locala.aMo(getContext().getResources().getString(2131763120)).wZ(true);
      locala.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(74153);
          if (paramAnonymousBoolean)
          {
            SettingsFontUI.this.finish();
            int i = com.tencent.mm.ce.a.eDd();
            int j = SettingsFontUI.LA(i);
            if (j != i)
            {
              com.tencent.mm.ce.a.VR(j);
              paramAnonymousString = new Intent();
              paramAnonymousString.putExtra("Intro_Need_Clear_Top ", true);
              b.hYt.p(paramAnonymousString, SettingsFontUI.this.getContext());
              com.tencent.mm.bw.a.hr(aj.getContext());
              System.exit(0);
              AppMethodBeat.o(74153);
              return;
            }
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("Intro_Need_Clear_Top ", true);
            b.hYt.p(paramAnonymousString, SettingsFontUI.this.getContext());
            paramAnonymousString = new hi();
            paramAnonymousString.dkW.dkX = paramFloat;
            paramAnonymousString.dkW.dkY = f;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
            d.aNr("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
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
  
  private void bo(float paramFloat)
  {
    AppMethodBeat.i(74163);
    SharedPreferences.Editor localEditor = getContext().getSharedPreferences(aj.eFD(), 0).edit();
    localEditor.putFloat("current_text_size_scale_key", paramFloat);
    localEditor.commit();
    AppMethodBeat.o(74163);
  }
  
  private static float fN(Context paramContext)
  {
    AppMethodBeat.i(74160);
    float f2 = com.tencent.mm.cd.a.hM(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cd.a.hF(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cd.a.hE(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cd.a.hG(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cd.a.hH(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cd.a.hI(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cd.a.hJ(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cd.a.hK(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cd.a.hL(paramContext)) {
                    f1 = com.tencent.mm.cd.a.hF(paramContext);
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
  
  private static int fO(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(74161);
    if (paramContext != null) {
      i = paramContext.getSharedPreferences(aj.eFD(), 0).getInt("current_text_size_index_key", 1);
    }
    AppMethodBeat.o(74161);
    return i;
  }
  
  private float fP(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(74162);
    if (paramContext != null) {
      f = getContext().getSharedPreferences(aj.eFD(), 0).getFloat("current_text_size_scale_key", 1.0F);
    }
    AppMethodBeat.o(74162);
    return f;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74157);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      bn(this.wgR);
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
    this.wgR = fN(getContext());
    ad.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.wgR);
    final ImageView localImageView1 = (ImageView)findViewById(2131298058);
    final ImageView localImageView2 = (ImageView)findViewById(2131297009);
    final ImageView localImageView3 = (ImageView)findViewById(2131297010);
    final MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(2131304648);
    final MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(2131304646);
    final MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(2131304647);
    a.b.c(localImageView1, u.aqG());
    this.wgQ = ((int)(com.tencent.mm.cd.a.ap(getContext(), 2131166038) / com.tencent.mm.ce.a.eCR()));
    localMMNeat7extView2.setMaxWidth(this.wgQ);
    localMMNeat7extView3.setMaxWidth(this.wgQ);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(2131300195);
    float f2 = fN(getContext());
    if (f2 != fP(getContext())) {
      bo(f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cd.a.hE(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cd.a.hL(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cd.a.hE(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cd.a.hE(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new FontSelectorView.a()
      {
        public final void LB(int paramAnonymousInt)
        {
          AppMethodBeat.i(74151);
          float f2;
          float f1;
          switch (paramAnonymousInt)
          {
          default: 
            f2 = com.tencent.mm.cd.a.hF(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 400.0F;
            if (!com.tencent.mm.cd.a.hN(SettingsFontUI.this.getContext())) {
              f1 = f2;
            }
            if (f2 != SettingsFontUI.a(SettingsFontUI.this)) {
              SettingsFontUI.a(SettingsFontUI.this, 1);
            }
            break;
          }
          for (;;)
          {
            com.tencent.mm.cd.a.h(SettingsFontUI.this.getContext(), f2);
            SettingsFontUI.a(SettingsFontUI.this, f2);
            Object localObject = SettingsFontUI.this.getContext().getSharedPreferences(aj.eFD(), 0).edit();
            ((SharedPreferences.Editor)localObject).putInt("current_text_size_index_key", paramAnonymousInt);
            ((SharedPreferences.Editor)localObject).commit();
            e.tH(true);
            SettingsFontUI.b(SettingsFontUI.this, com.tencent.mm.cd.a.hO(SettingsFontUI.this.getContext()));
            localObject = SettingsFontUI.this.getContext();
            localMMNeat7extView1.setTextSize(0, ao.ap(SettingsFontUI.this.getContext(), 2131165517) * f1);
            localMMNeat7extView2.setTextSize(0, ao.ap(SettingsFontUI.this.getContext(), 2131165517) * f1);
            localMMNeat7extView3.setTextSize(0, f1 * ao.ap(SettingsFontUI.this.getContext(), 2131165517));
            SettingsFontUI localSettingsFontUI = SettingsFontUI.this;
            f1 = com.tencent.mm.cd.a.ap((Context)localObject, 2131165184);
            localSettingsFontUI.setMMTitleSize(com.tencent.mm.cd.a.hQ((Context)localObject) * f1);
            if (com.tencent.mm.cd.a.hN(SettingsFontUI.this.getContext()))
            {
              SettingsFontUI.a(SettingsFontUI.this, localImageView1, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView2, paramAnonymousInt);
              SettingsFontUI.a(SettingsFontUI.this, localImageView3, paramAnonymousInt);
            }
            AppMethodBeat.o(74151);
            return;
            f2 = com.tencent.mm.cd.a.hE(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 440.0F;
            break;
            f2 = com.tencent.mm.cd.a.hF(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 400.0F;
            break;
            f2 = com.tencent.mm.cd.a.hG(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 360.0F;
            break;
            f2 = com.tencent.mm.cd.a.hH(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 360.0F * 1.12F;
            break;
            f2 = com.tencent.mm.cd.a.hI(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 340.0F * 1.125F;
            break;
            f2 = com.tencent.mm.cd.a.hJ(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 340.0F * 1.4F;
            break;
            f2 = com.tencent.mm.cd.a.hK(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 340.0F * 1.55F;
            break;
            f2 = com.tencent.mm.cd.a.hL(SettingsFontUI.this.getContext());
            f1 = com.tencent.mm.ce.a.eDd() / 340.0F * 1.65F;
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
          h.vKh.f(11609, new Object[] { Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.c(SettingsFontUI.this)), Integer.valueOf(0) });
          ad.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.b(SettingsFontUI.this)), Integer.valueOf(SettingsFontUI.c(SettingsFontUI.this)) });
          SettingsFontUI.b(SettingsFontUI.this, SettingsFontUI.a(SettingsFontUI.this));
          AppMethodBeat.o(74152);
          return true;
        }
      });
      AppMethodBeat.o(74156);
      return;
      if (f1 == com.tencent.mm.cd.a.hG(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cd.a.hH(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cd.a.hI(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cd.a.hJ(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cd.a.hK(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cd.a.hL(getContext())) {
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
      h.vKh.f(11609, new Object[] { Integer.valueOf(this.wgO), Integer.valueOf(this.wgP), Integer.valueOf(0) });
      ad.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.wgO), Integer.valueOf(this.wgP) });
      bn(this.wgR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */