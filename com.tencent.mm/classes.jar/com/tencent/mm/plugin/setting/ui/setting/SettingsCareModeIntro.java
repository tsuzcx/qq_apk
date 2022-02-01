package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ay.b.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;

public class SettingsCareModeIntro
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private Button AkB;
  private boolean PsA;
  private View PsB;
  private Button Psw;
  private CheckBox Psx;
  private TextView Psy;
  private TextView Psz;
  private w tipDialog = null;
  private long xct;
  
  public int getLayoutId()
  {
    return b.g.settings_care_mode_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(299314);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.setting.b.c.white));
    Object localObject = (TextView)findViewById(b.f.intro_title);
    if (localObject != null) {
      aw.d(((TextView)localObject).getPaint());
    }
    this.PsA = com.tencent.mm.ce.b.iRp();
    Log.i("MicroMsg.SettingsCareModeIntro", "is care mode open:%s", new Object[] { Boolean.valueOf(this.PsA) });
    this.Psz = ((TextView)findViewById(b.f.intro_title));
    this.PsB = findViewById(b.f.law_doc_ll);
    this.AkB = ((Button)findViewById(b.f.care_mode_open_btn));
    this.Psw = ((Button)findViewById(b.f.care_mode_close_btn));
    if (this.PsA)
    {
      this.AkB.setVisibility(8);
      this.Psw.setVisibility(0);
      this.PsB.setVisibility(8);
      this.Psz.setText(getResources().getString(b.i.care_mode_title_open));
      this.Psw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(299160);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new g.a(SettingsCareModeIntro.this.getContext());
          paramAnonymousView.bDE(SettingsCareModeIntro.this.getContext().getResources().getString(b.i.setting_care_alert_tips)).NF(true);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(299091);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.setting.a.a.CE(false);
                SettingsCareModeIntro.a(SettingsCareModeIntro.this, false);
                SettingsCareModeIntro.a(SettingsCareModeIntro.this);
              }
              AppMethodBeat.o(299091);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(299160);
        }
      });
    }
    String str;
    for (;;)
    {
      this.Psx = ((CheckBox)findViewById(b.f.law_detail_cb));
      Util.expandViewTouchArea(this.Psx, 250, 250, 250, 250);
      this.Psx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(299168);
          if (paramAnonymousBoolean)
          {
            SettingsCareModeIntro.b(SettingsCareModeIntro.this).setEnabled(true);
            AppMethodBeat.o(299168);
            return;
          }
          SettingsCareModeIntro.b(SettingsCareModeIntro.this).setEnabled(false);
          AppMethodBeat.o(299168);
        }
      });
      localObject = getString(b.i.care_mode_law_check);
      str = getString(b.i.care_mode_law_check_link);
      if (((String)localObject).lastIndexOf(str) >= 0) {
        break;
      }
      AppMethodBeat.o(299314);
      return;
      this.Psw.setVisibility(8);
      this.PsB.setVisibility(8);
      this.Psz.setText(getResources().getString(b.i.care_mode_title_close));
      this.AkB.setVisibility(0);
      this.AkB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(299167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new g.a(SettingsCareModeIntro.this.getContext());
          paramAnonymousView.bDE(SettingsCareModeIntro.this.getContext().getResources().getString(b.i.setting_care_alert_tips)).NF(true);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(298636);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.setting.a.a.CE(true);
                float f = com.tencent.mm.cd.a.mk(SettingsCareModeIntro.this.getContext());
                paramAnonymous2String = SettingsCareModeIntro.this.getContext();
                int i = com.tencent.mm.ce.a.dH(f);
                SharedPreferences.Editor localEditor = paramAnonymous2String.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
                localEditor.putFloat("before_care_mode_text_size_scale_key", f);
                Log.i("MicroMsg.FontUtil", "TEXT_SIZE_BEFOR_CARE_MODE_KEY put result:%s, currentFont:%s ", new Object[] { Boolean.valueOf(localEditor.commit()), Float.valueOf(f) });
                paramAnonymous2String = paramAnonymous2String.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
                paramAnonymous2String.putInt("before_care_mode_text_size_index_key", i);
                Log.i("MicroMsg.FontUtil", "set TEXT_INDEX_BEFOR_CARE_MODE_KEY result:%s, sliderIndex:%s", new Object[] { Boolean.valueOf(paramAnonymous2String.commit()), Integer.valueOf(i) });
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acQA, q.aPg());
                SettingsCareModeIntro.a(SettingsCareModeIntro.this, true);
                SettingsCareModeIntro.a(SettingsCareModeIntro.this);
              }
              AppMethodBeat.o(298636);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(299167);
        }
      });
    }
    str.length();
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    this.Psy = ((TextView)findViewById(b.f.law_detail_tv));
    this.Psy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    this.Psy.setClickable(true);
    this.Psy.setText((CharSequence)localObject);
    AppMethodBeat.o(299314);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299302);
    super.onCreate(paramBundle);
    this.xct = z.bAR();
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(299157);
        SettingsCareModeIntro.this.finish();
        AppMethodBeat.o(299157);
        return true;
      }
    });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(681, this);
    AppMethodBeat.o(299302);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(299309);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(681, this);
    super.onDestroy();
    AppMethodBeat.o(299309);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(299320);
    if (this.tipDialog == null)
    {
      AppMethodBeat.o(299320);
      return;
    }
    this.tipDialog.dismiss();
    this.tipDialog = null;
    Log.i("MicroMsg.SettingsCareModeIntro", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    int i;
    float f;
    if (paramp.getType() == 681)
    {
      paramString = ((com.tencent.mm.ay.b)paramp).oPH;
      paramp = ((com.tencent.mm.ay.b.c)((com.tencent.mm.ay.b)paramp).oPG.getRespObj()).oPL;
      paramInt2 = 0;
      if (paramInt2 < paramString.size()) {
        if ((((k.b)paramString.get(paramInt2)).getCmdId() == 23) && (paramp.abdX != null) && (((Integer)paramp.abdX.aamU.get(paramInt2)).intValue() == 0))
        {
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(com.tencent.mm.ce.b.aclz, true);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQy, Boolean.valueOf(this.PsA));
          com.tencent.mm.ce.b.Kn(false);
          i = com.tencent.mm.plugin.setting.a.jD(getContext());
          f = com.tencent.mm.cd.a.mk(getContext());
          if (this.PsA) {
            break label344;
          }
          paramInt1 = com.tencent.mm.ce.a.mu(getContext());
          AppCompatActivity localAppCompatActivity = getContext();
          if (localAppCompatActivity == null) {
            break label374;
          }
          f = localAppCompatActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("before_care_mode_text_size_scale_key", 1.0F);
        }
      }
    }
    for (;;)
    {
      label287:
      com.tencent.mm.ce.b.axU(0);
      for (;;)
      {
        com.tencent.mm.plugin.setting.a.a(getContext(), f, paramInt1);
        com.tencent.mm.ce.c.axV(com.tencent.mm.plugin.setting.a.aiQ(paramInt1));
        com.tencent.mm.kernel.h.baE().ban().iZy();
        com.tencent.threadpool.h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(299171);
            Object localObject1 = new Intent();
            ((Intent)localObject1).putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.c.pFn.n((Intent)localObject1, SettingsCareModeIntro.this.getContext());
            com.tencent.mm.bv.a.lJ(MMApplicationContext.getContext());
            localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            Object localObject2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$5", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/setting/ui/setting/SettingsCareModeIntro$5", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            SettingsCareModeIntro.this.finish();
            AppMethodBeat.o(299171);
          }
        }, 200L);
        paramInt2 += 1;
        break;
        label344:
        paramInt1 = i;
        if (i >= 5) {
          break label287;
        }
        f = 1.4F;
        com.tencent.mm.ce.b.axU(5);
        paramInt1 = 5;
      }
      AppMethodBeat.o(299320);
      return;
      label374:
      f = 1.0F;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCareModeIntro
 * JD-Core Version:    0.7.0.1
 */