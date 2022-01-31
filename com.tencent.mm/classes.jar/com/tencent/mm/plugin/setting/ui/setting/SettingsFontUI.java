package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.b.e.a;

@com.tencent.mm.ui.base.a(17)
public class SettingsFontUI
  extends MMActivity
{
  private int qIi;
  private int qIj;
  private int qIk;
  private float qIl;
  
  public SettingsFontUI()
  {
    AppMethodBeat.i(127223);
    this.qIi = 0;
    this.qIj = 2;
    this.qIk = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 2131428227);
    this.qIl = 1.0F;
    AppMethodBeat.o(127223);
  }
  
  private static int CY(int paramInt)
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
  
  private void aW(float paramFloat)
  {
    AppMethodBeat.i(127227);
    float f = eQ(getContext());
    ab.i("MicroMsg.SettingsFontUI", "fontSizeAfter=".concat(String.valueOf(f)));
    int i = eP(getContext());
    if (f != paramFloat)
    {
      e.a locala = new e.a(ah.getContext());
      locala.avu(getContext().getResources().getString(2131303154)).rI(true);
      locala.c(new SettingsFontUI.3(this, i, paramFloat, f)).show();
      AppMethodBeat.o(127227);
      return;
    }
    finish();
    AppMethodBeat.o(127227);
  }
  
  private void aX(float paramFloat)
  {
    AppMethodBeat.i(154183);
    SharedPreferences.Editor localEditor = getContext().getSharedPreferences(ah.dsP(), 0).edit();
    localEditor.putFloat("current_text_size_scale_key", paramFloat);
    localEditor.commit();
    AppMethodBeat.o(154183);
  }
  
  private static float eO(Context paramContext)
  {
    AppMethodBeat.i(154180);
    float f2 = com.tencent.mm.cb.a.gn(paramContext);
    float f1 = f2;
    if (f2 != com.tencent.mm.cb.a.gg(paramContext))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.gf(paramContext))
      {
        f1 = f2;
        if (f2 != com.tencent.mm.cb.a.gh(paramContext))
        {
          f1 = f2;
          if (f2 != com.tencent.mm.cb.a.gi(paramContext))
          {
            f1 = f2;
            if (f2 != com.tencent.mm.cb.a.gj(paramContext))
            {
              f1 = f2;
              if (f2 != com.tencent.mm.cb.a.gk(paramContext))
              {
                f1 = f2;
                if (f2 != com.tencent.mm.cb.a.gl(paramContext))
                {
                  f1 = f2;
                  if (f2 != com.tencent.mm.cb.a.gm(paramContext)) {
                    f1 = com.tencent.mm.cb.a.gg(paramContext);
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(154180);
    return f1;
  }
  
  private static int eP(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(154181);
    if (paramContext != null) {
      i = paramContext.getSharedPreferences(ah.dsP(), 0).getInt("current_text_size_index_key", 1);
    }
    AppMethodBeat.o(154181);
    return i;
  }
  
  private float eQ(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(154182);
    if (paramContext != null) {
      f = getContext().getSharedPreferences(ah.dsP(), 0).getFloat("current_text_size_scale_key", 1.0F);
    }
    AppMethodBeat.o(154182);
    return f;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(154179);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      aW(this.qIl);
      AppMethodBeat.o(154179);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(154179);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970693;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127225);
    setMMTitle(2131303474);
    this.qIl = eO(getContext());
    ab.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.qIl);
    ImageView localImageView1 = (ImageView)findViewById(2131827612);
    ImageView localImageView2 = (ImageView)findViewById(2131827613);
    ImageView localImageView3 = (ImageView)findViewById(2131827615);
    MMNeat7extView localMMNeat7extView1 = (MMNeat7extView)findViewById(2131827611);
    MMNeat7extView localMMNeat7extView2 = (MMNeat7extView)findViewById(2131827614);
    MMNeat7extView localMMNeat7extView3 = (MMNeat7extView)findViewById(2131827616);
    a.b.c(localImageView1, r.Zn());
    this.qIk = ((int)(com.tencent.mm.cb.a.ap(getContext(), 2131428227) / com.tencent.mm.cc.a.dqS()));
    localMMNeat7extView2.setMaxWidth(this.qIk);
    localMMNeat7extView3.setMaxWidth(this.qIk);
    FontSelectorView localFontSelectorView = (FontSelectorView)findViewById(2131827617);
    float f2 = eO(getContext());
    if (f2 != eQ(getContext())) {
      aX(f2);
    }
    float f1;
    if (f2 >= com.tencent.mm.cb.a.gf(getContext()))
    {
      f1 = f2;
      if (f2 <= com.tencent.mm.cb.a.gm(getContext())) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.gf(getContext());
    }
    int i;
    if (f1 == com.tencent.mm.cb.a.gf(getContext())) {
      i = 0;
    }
    for (;;)
    {
      localFontSelectorView.setSliderIndex(i);
      localFontSelectorView.setOnChangeListener(new SettingsFontUI.1(this, localMMNeat7extView1, localMMNeat7extView2, localMMNeat7extView3, localImageView1, localImageView2, localImageView3));
      setBackBtn(new SettingsFontUI.2(this));
      AppMethodBeat.o(127225);
      return;
      if (f1 == com.tencent.mm.cb.a.gh(getContext())) {
        i = 2;
      } else if (f1 == com.tencent.mm.cb.a.gi(getContext())) {
        i = 3;
      } else if (f1 == com.tencent.mm.cb.a.gj(getContext())) {
        i = 4;
      } else if (f1 == com.tencent.mm.cb.a.gk(getContext())) {
        i = 5;
      } else if (f1 == com.tencent.mm.cb.a.gl(getContext())) {
        i = 6;
      } else if (f1 == com.tencent.mm.cb.a.gm(getContext())) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127224);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127224);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127226);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.qsU.e(11609, new Object[] { Integer.valueOf(this.qIi), Integer.valueOf(this.qIj), Integer.valueOf(0) });
      ab.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.qIi), Integer.valueOf(this.qIj) });
      aW(this.qIl);
      AppMethodBeat.o(127226);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127226);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */