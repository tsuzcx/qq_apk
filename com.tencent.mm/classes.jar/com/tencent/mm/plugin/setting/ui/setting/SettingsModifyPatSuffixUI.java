package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class SettingsModifyPatSuffixUI
  extends MMWizardActivity
  implements h.a, b.a
{
  private int ARG = 16;
  private MTimerHandler ARK;
  private MMClearEditText DcC;
  private int Ddb = 1;
  private ScrollView gxx;
  private InputPanelLinearLayout gxy;
  private TextView kuu;
  private q tipDialog;
  private Button vMn;
  
  public final void a(int paramInt, cxl paramcxl, k.b paramb)
  {
    AppMethodBeat.i(256583);
    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), paramcxl.iAc, paramcxl.Title });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if (paramInt == 0) {}
    try
    {
      com.tencent.mm.ui.base.h.cD(this, getString(2131755898));
      paramcxl = (cqa)paramb.zqv;
      if (!Util.nullAsNil((String)g.aAh().azQ().get(ar.a.Oob, null)).equals(paramcxl.MvT)) {
        g.aAh().azQ().set(ar.a.Ooh, Integer.valueOf(2));
      }
      g.aAh().azQ().set(ar.a.Oob, paramcxl.MvT);
      ala(1);
      com.tencent.mm.plugin.report.service.h.CyF.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(this.Ddb) });
      g.aAh().azQ().set(ar.a.Ooj, Long.valueOf(cl.aWA()));
      g.aAh().azQ().set(ar.a.Ook, Integer.valueOf(0));
      AppMethodBeat.o(256583);
      return;
    }
    catch (Exception paramcxl)
    {
      Log.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", paramcxl, "", new Object[0]);
      AppMethodBeat.o(256583);
    }
    if (!Util.isNullOrNil(paramcxl.iAc)) {
      com.tencent.mm.ui.base.h.c(this, paramcxl.iAc, getString(2131755897), true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(paramInt), Integer.valueOf(this.Ddb) });
      AppMethodBeat.o(256583);
      return;
      com.tencent.mm.ui.base.h.n(getContext(), 2131755804, 2131755897);
    }
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(256582);
    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.vMn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165296);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165296);
      this.vMn.setLayoutParams(localLayoutParams);
      this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), paramInt);
      paramInt = this.gxx.getHeight();
      this.gxy.requestLayout();
      this.gxy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256577);
          Log.i("MicroMsg.SettingsModifyPatSuffixUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() > paramInt) {
            SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).scrollBy(0, SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(256577);
        }
      });
      AppMethodBeat.o(256582);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vMn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165281);
    localLayoutParams.topMargin = 0;
    this.vMn.setLayoutParams(localLayoutParams);
    this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
    this.gxx.scrollBy(0, 0);
    AppMethodBeat.o(256582);
  }
  
  public int getLayoutId()
  {
    return 2131496262;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256580);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.gxy = ((InputPanelLinearLayout)findViewById(2131302671));
    this.gxy.setExternalListener(this);
    this.vMn = ((Button)findViewById(2131305423));
    this.DcC = ((MMClearEditText)findViewById(2131305794));
    this.kuu = ((TextView)findViewById(2131305795));
    this.gxx = ((ScrollView)findViewById(2131307339));
    this.vMn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256574);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsModifyPatSuffixUI.this.hideVKB();
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText());
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256574);
      }
    });
    String str2 = (String)g.aAh().azQ().get(ar.a.Oob, null);
    int i = g.aAh().azQ().getInt(ar.a.Ooh, 0);
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
      this.DcC.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, str1));
      this.DcC.setSelection(str1.length());
    }
    this.DcC.requestFocus();
    this.DcC.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(256575);
        int i = com.tencent.mm.ui.tools.f.a(paramAnonymousEditable.toString(), f.a.Qui);
        if (i > SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
        {
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131765280, new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this) / 2) }));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100996));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).performHapticFeedback(3, 2);
          if (SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).stopped()) {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).startTimer(5000L);
          }
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setText(com.tencent.mm.ui.tools.f.hm(paramAnonymousEditable.toString(), SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this)));
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setSelection(SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText().length());
        }
        for (;;)
        {
          SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).setEnabled(true);
          AppMethodBeat.o(256575);
          return;
          if (i < SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
          {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).stopTimer();
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131765281));
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100245));
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eis().a(222, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256576);
        SettingsModifyPatSuffixUI.this.onBackPressed();
        AppMethodBeat.o(256576);
        return true;
      }
    });
    AppMethodBeat.o(256580);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(256581);
    super.onBackPressed();
    com.tencent.mm.plugin.report.service.h.CyF.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(this.Ddb) });
    AppMethodBeat.o(256581);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256578);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      this.Ddb = 2;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(this.Ddb) });
    this.ARG = com.tencent.mm.n.h.aqJ().getInt("PatSuffixMaxByte", 16);
    initView();
    this.ARK = new MTimerHandler(getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(256573);
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131765281));
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100245));
        AppMethodBeat.o(256573);
        return false;
      }
    }, false);
    AppMethodBeat.o(256578);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(256579);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eis().b(222, this);
    if (this.ARK != null) {
      this.ARK.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(256579);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI
 * JD-Core Version:    0.7.0.1
 */