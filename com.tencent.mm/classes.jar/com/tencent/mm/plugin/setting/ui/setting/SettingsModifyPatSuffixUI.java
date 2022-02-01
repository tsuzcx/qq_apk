package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent.a;
import com.tencent.mm.k.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.emoji.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMClearEditText;
import com.tencent.mm.ui.widget.pulldown.c;

@c(0)
public class SettingsModifyPatSuffixUI
  extends MMWizardActivity
  implements EmojiPanelInputComponent.a, h.b
{
  private Button FSq;
  private int MHN;
  private EmojiPanelInputComponent MHO;
  private MTimerHandler MHS;
  private MMClearEditText PuJ;
  private int PuK;
  private TextWatcher PuL;
  private TextView qjr;
  private w tipDialog;
  
  public SettingsModifyPatSuffixUI()
  {
    AppMethodBeat.i(299064);
    this.MHN = 20;
    this.PuK = 1;
    this.PuL = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(298630);
        SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).removeTextChangedListener(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this));
        paramAnonymousEditable = new e(paramAnonymousEditable.toString(), (int)SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getPaint().getTextSize());
        int i = paramAnonymousEditable.a(g.a.afII);
        if (i > SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this))
        {
          paramAnonymousEditable = paramAnonymousEditable.b(SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this), g.a.afII);
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_limit_tip, new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this) / 2) }));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.red_text_color));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).performHapticFeedback(3, 2);
          if (SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).stopped()) {
            SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).startTimer(5000L);
          }
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setText(com.tencent.mm.ui.i.c.b.a(SettingsModifyPatSuffixUI.this, paramAnonymousEditable, (int)SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getPaint().getTextSize()));
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setSelection(SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText().length());
        }
        for (;;)
        {
          SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).setEnabled(true);
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).addTextChangedListener(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this));
          if (i <= 0) {
            break;
          }
          SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).setSmileySendButtonEnable(true);
          AppMethodBeat.o(298630);
          return;
          if (i < SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this))
          {
            SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).stopTimer();
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_tip));
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.desc_text_color));
          }
        }
        SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).setSmileySendButtonEnable(false);
        AppMethodBeat.o(298630);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    AppMethodBeat.o(299064);
  }
  
  public final void a(int paramInt, dzc paramdzc, k.b paramb)
  {
    AppMethodBeat.i(299140);
    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), paramdzc.nUB, paramdzc.hAP });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if (paramInt == 0) {}
    try
    {
      k.cZ(this, getString(b.i.app_modify_success));
      paramdzc = (dpx)paramb.KRu;
      if (!Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null)).equals(paramdzc.aaWy)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgx, Integer.valueOf(2));
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgr, paramdzc.aaWy);
      aAp(1);
      com.tencent.mm.plugin.report.service.h.OAn.b(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(this.PuK) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgz, Long.valueOf(cn.bDw()));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgA, Integer.valueOf(0));
      AppMethodBeat.o(299140);
      return;
    }
    catch (Exception paramdzc)
    {
      Log.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", paramdzc, "", new Object[0]);
      AppMethodBeat.o(299140);
    }
    if (!Util.isNullOrNil(paramdzc.nUB)) {
      k.c(this, paramdzc.nUB, getString(b.i.app_modify_failed), true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(paramInt), Integer.valueOf(this.PuK) });
      AppMethodBeat.o(299140);
      return;
      k.s(getContext(), b.i.app_err_system_busy_tip, b.i.app_modify_failed);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.g.settings_modify_pat_suffix;
  }
  
  public void initView()
  {
    AppMethodBeat.i(299126);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    this.MHO = ((EmojiPanelInputComponent)findViewById(b.f.input_component));
    this.FSq = ((Button)findViewById(b.f.next_btn));
    this.PuJ = ((MMClearEditText)findViewById(b.f.pat_suffix_edit));
    this.qjr = ((TextView)findViewById(b.f.pat_suffix_hint_tv));
    this.FSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298650);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SettingsModifyPatSuffixUI.this.hideVKB();
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298650);
      }
    });
    String str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgx, 0);
    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "curSuffix %s, suffixVersion %d", new Object[] { str2, Integer.valueOf(i) });
    if (!Util.isNullOrNil(str2))
    {
      String str1 = str2;
      if (i == 0)
      {
        str1 = str2;
        if (LocaleUtil.isChineseAppLang()) {
          str1 = "的".concat(String.valueOf(str2));
        }
      }
      this.PuJ.setText(p.b(this, str1));
      this.PuJ.setSelection(str1.length());
    }
    this.PuJ.requestFocus();
    this.PuJ.addTextChangedListener(this.PuL);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().a(222, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298651);
        SettingsModifyPatSuffixUI.this.onBackPressed();
        AppMethodBeat.o(298651);
        return true;
      }
    });
    this.MHO.setMMEditText(this.PuJ);
    this.MHO.setVisibility(4);
    this.MHO.setInputComponentListener(this);
    if (this.PuJ.getText().length() > 0)
    {
      this.MHO.setSmileySendButtonEnable(true);
      AppMethodBeat.o(299126);
      return;
    }
    this.MHO.setSmileySendButtonEnable(false);
    AppMethodBeat.o(299126);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(299135);
    super.onBackPressed();
    com.tencent.mm.plugin.report.service.h.OAn.b(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(this.PuK) });
    AppMethodBeat.o(299135);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299110);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      this.PuK = 2;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(this.PuK) });
    this.MHN = i.aRC().getInt("PatSuffixMaxByte", 16);
    initView();
    this.MHS = new MTimerHandler(getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(298648);
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_tip));
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.desc_text_color));
        AppMethodBeat.o(298648);
        return false;
      }
    }, false);
    AppMethodBeat.o(299110);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(299118);
    if (this.MHO != null) {
      this.MHO.release();
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b(222, this);
    if (this.MHS != null) {
      this.MHS.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(299118);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(299151);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.FSq.getLayoutParams();
    if (paramBoolean) {}
    for (localLayoutParams.bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(this, 16) + paramInt);; localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 96))
    {
      this.FSq.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(299151);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(299146);
    if (paramInt == 4)
    {
      if (this.MHO.aWG())
      {
        this.MHO.aWI();
        AppMethodBeat.o(299146);
        return true;
      }
      finish();
      AppMethodBeat.o(299146);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(299146);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI
 * JD-Core Version:    0.7.0.1
 */