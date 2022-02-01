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
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class SettingsModifyPatSuffixUI
  extends MMWizardActivity
  implements h.a, b.a
{
  private ScrollView fQj;
  private InputPanelLinearLayout fQk;
  private TextView jtn;
  private Button sEg;
  private p tipDialog;
  private MMClearEditText yHA;
  private av yHZ;
  private int yIa = 16;
  private int yIb = 1;
  
  public final void a(int paramInt, cgk paramcgk, k.b paramb)
  {
    AppMethodBeat.i(221034);
    ad.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), paramcgk.hDa, paramcgk.Title });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if (paramInt == 0) {}
    try
    {
      com.tencent.mm.ui.base.h.cl(this, getString(2131756261));
      paramcgk = (cae)paramb.vKm;
      if (!bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJN, null)).equals(paramcgk.GUX)) {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJS, Integer.valueOf(2));
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJN, paramcgk.GUX);
      abK(1);
      com.tencent.mm.plugin.report.service.g.yhR.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(this.yIb) });
      AppMethodBeat.o(221034);
      return;
    }
    catch (Exception paramcgk)
    {
      ad.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", paramcgk, "", new Object[0]);
      AppMethodBeat.o(221034);
    }
    if (!bt.isNullOrNil(paramcgk.hDa)) {
      com.tencent.mm.ui.base.h.c(this, paramcgk.hDa, getString(2131757998), true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(paramInt), Integer.valueOf(this.yIb) });
      AppMethodBeat.o(221034);
      return;
      com.tencent.mm.ui.base.h.l(getContext(), 2131755733, 2131757998);
    }
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(221033);
    ad.i("MicroMsg.SettingsModifyPatSuffixUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.sEg.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.sEg.setLayoutParams(localLayoutParams);
      this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), paramInt);
      paramInt = this.fQj.getHeight();
      this.fQk.requestLayout();
      this.fQk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221676);
          ad.i("MicroMsg.SettingsModifyPatSuffixUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() > paramInt) {
            SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).scrollBy(0, SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(221676);
        }
      });
      AppMethodBeat.o(221033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sEg.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.sEg.setLayoutParams(localLayoutParams);
    this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), 0);
    this.fQj.scrollBy(0, 0);
    AppMethodBeat.o(221033);
  }
  
  public int getLayoutId()
  {
    return 2131496421;
  }
  
  public void initView()
  {
    AppMethodBeat.i(221031);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fQk = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fQk.setExternalListener(this);
    this.sEg = ((Button)findViewById(2131302852));
    this.yHA = ((MMClearEditText)findViewById(2131308172));
    this.jtn = ((TextView)findViewById(2131308173));
    this.fQj = ((ScrollView)findViewById(2131304376));
    this.sEg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221022);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SettingsModifyPatSuffixUI.this.hideVKB();
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText());
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221022);
      }
    });
    String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJN, null);
    int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJS, 0);
    ad.i("MicroMsg.SettingsModifyPatSuffixUI", "curSuffix %s, suffixVersion %d", new Object[] { str2, Integer.valueOf(i) });
    if (!bt.isNullOrNil(str2))
    {
      String str1 = str2;
      if (i == 0)
      {
        str1 = str2;
        if (ac.fko()) {
          str1 = "的".concat(String.valueOf(str2));
        }
      }
      this.yHA.setText(k.c(this, str1));
      this.yHA.setSelection(str1.length());
    }
    this.yHA.requestFocus();
    this.yHA.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(221025);
        int i = f.a(paramAnonymousEditable.toString(), f.a.KIN);
        if (i > SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
        {
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131767173, new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this) / 2) }));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100800));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).performHapticFeedback(3, 2);
          if (SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).fkZ()) {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).az(5000L, 5000L);
          }
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setText(f.hA(paramAnonymousEditable.toString(), SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this)));
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setSelection(SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText().length());
        }
        for (;;)
        {
          SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).setEnabled(true);
          AppMethodBeat.o(221025);
          return;
          if (i < SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
          {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).stopTimer();
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131766976));
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100212));
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(221023);
        AppMethodBeat.o(221023);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(221024);
        AppMethodBeat.o(221024);
      }
    });
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlE().a(222, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(221675);
        SettingsModifyPatSuffixUI.this.onBackPressed();
        AppMethodBeat.o(221675);
        return true;
      }
    });
    AppMethodBeat.o(221031);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(221032);
    super.onBackPressed();
    com.tencent.mm.plugin.report.service.g.yhR.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(this.yIb) });
    AppMethodBeat.o(221032);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221029);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      this.yIb = 2;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(this.yIb) });
    this.yIa = com.tencent.mm.n.g.acA().getInt("PatSuffixMaxByte", 16);
    initView();
    this.yHZ = new av(getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(221021);
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131766976));
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100212));
        AppMethodBeat.o(221021);
        return false;
      }
    }, false);
    AppMethodBeat.o(221029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(221030);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlE().b(222, this);
    if (this.yHZ != null) {
      this.yHZ.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(221030);
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