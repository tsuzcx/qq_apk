package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.emoji.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMClearEditText;
import com.tencent.mm.ui.widget.pulldown.c;

@c(0)
public class SettingsModifyPatSuffixUI
  extends MMWizardActivity
  implements EmojiPanelInputComponent.a, h.b
{
  private Button Ata;
  private int GKR;
  private EmojiPanelInputComponent GKS;
  private MTimerHandler GKW;
  private MMClearEditText JiC;
  private int JiD;
  private TextWatcher JiE;
  private TextView nmi;
  private s tipDialog;
  
  public SettingsModifyPatSuffixUI()
  {
    AppMethodBeat.i(264963);
    this.GKR = 20;
    this.JiD = 1;
    this.JiE = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(264812);
        SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).removeTextChangedListener(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this));
        paramAnonymousEditable = new e(paramAnonymousEditable.toString(), (int)SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getPaint().getTextSize());
        int i = paramAnonymousEditable.a(g.a.XSu);
        if (i > SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this))
        {
          paramAnonymousEditable = paramAnonymousEditable.b(SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this), g.a.XSu);
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_limit_tip, new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this) / 2) }));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.red_text_color));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).performHapticFeedback(3, 2);
          if (SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).stopped()) {
            SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).startTimer(5000L);
          }
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setText(com.tencent.mm.ui.h.c.b.a(SettingsModifyPatSuffixUI.this, paramAnonymousEditable, (int)SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getPaint().getTextSize()));
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
          AppMethodBeat.o(264812);
          return;
          if (i < SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this))
          {
            SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).stopTimer();
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_tip));
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.desc_text_color));
          }
        }
        SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).setSmileySendButtonEnable(false);
        AppMethodBeat.o(264812);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    AppMethodBeat.o(264963);
  }
  
  public final void a(int paramInt, dgv paramdgv, k.b paramb)
  {
    AppMethodBeat.i(264968);
    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), paramdgv.lpy, paramdgv.fwr });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if (paramInt == 0) {}
    try
    {
      com.tencent.mm.ui.base.h.cO(this, getString(b.i.app_modify_success));
      paramdgv = (cyr)paramb.EVU;
      if (!Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDu, null)).equals(paramdgv.TGR)) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDA, Integer.valueOf(2));
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDu, paramdgv.TGR);
      atX(1);
      com.tencent.mm.plugin.report.service.h.IzE.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(this.JiD) });
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDC, Long.valueOf(cm.bfE()));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDD, Integer.valueOf(0));
      AppMethodBeat.o(264968);
      return;
    }
    catch (Exception paramdgv)
    {
      Log.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", paramdgv, "", new Object[0]);
      AppMethodBeat.o(264968);
    }
    if (!Util.isNullOrNil(paramdgv.lpy)) {
      com.tencent.mm.ui.base.h.c(this, paramdgv.lpy, getString(b.i.app_modify_failed), true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(paramInt), Integer.valueOf(this.JiD) });
      AppMethodBeat.o(264968);
      return;
      com.tencent.mm.ui.base.h.p(getContext(), b.i.app_err_system_busy_tip, b.i.app_modify_failed);
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
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(264971);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ata.getLayoutParams();
    if (paramBoolean) {}
    for (localLayoutParams.bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(this, 16) + paramInt);; localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this, 96))
    {
      this.Ata.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(264971);
      return;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(264966);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    this.GKS = ((EmojiPanelInputComponent)findViewById(b.f.input_component));
    this.Ata = ((Button)findViewById(b.f.next_btn));
    this.JiC = ((MMClearEditText)findViewById(b.f.pat_suffix_edit));
    this.nmi = ((TextView)findViewById(b.f.pat_suffix_hint_tv));
    this.Ata.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SettingsModifyPatSuffixUI.this.hideVKB();
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264871);
      }
    });
    String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDu, null);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDA, 0);
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
      this.JiC.setText(l.c(this, str1));
      this.JiC.setSelection(str1.length());
    }
    this.JiC.requestFocus();
    this.JiC.addTextChangedListener(this.JiE);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().a(222, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(264950);
        SettingsModifyPatSuffixUI.this.onBackPressed();
        AppMethodBeat.o(264950);
        return true;
      }
    });
    this.GKS.setMMEditText(this.JiC);
    this.GKS.setVisibility(4);
    this.GKS.setInputComponentListener(this);
    if (this.JiC.getText().length() > 0)
    {
      this.GKS.setSmileySendButtonEnable(true);
      AppMethodBeat.o(264966);
      return;
    }
    this.GKS.setSmileySendButtonEnable(false);
    AppMethodBeat.o(264966);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(264967);
    super.onBackPressed();
    com.tencent.mm.plugin.report.service.h.IzE.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(this.JiD) });
    AppMethodBeat.o(264967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264964);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      this.JiD = 2;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(this.JiD) });
    this.GKR = com.tencent.mm.n.h.axc().getInt("PatSuffixMaxByte", 16);
    initView();
    this.GKW = new MTimerHandler(getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(264841);
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(b.i.setting_pat_suffix_tip));
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(b.c.desc_text_color));
        AppMethodBeat.o(264841);
        return false;
      }
    }, false);
    AppMethodBeat.o(264964);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264965);
    if (this.GKS != null) {
      this.GKS.release();
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().b(222, this);
    if (this.GKW != null) {
      this.GKW.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(264965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(264970);
    if (paramInt == 4)
    {
      if (this.GKS.aDI())
      {
        this.GKS.aDK();
        AppMethodBeat.o(264970);
        return true;
      }
      finish();
      AppMethodBeat.o(264970);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(264970);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI
 * JD-Core Version:    0.7.0.1
 */