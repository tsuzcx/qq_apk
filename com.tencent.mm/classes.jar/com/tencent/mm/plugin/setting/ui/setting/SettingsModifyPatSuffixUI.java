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
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private ScrollView fSp;
  private InputPanelLinearLayout fSq;
  private TextView jwg;
  private Button sPf;
  private p tipDialog;
  private MMClearEditText yXK;
  private aw yYj;
  private int yYk = 16;
  private int yYl = 1;
  
  public final void a(int paramInt, che paramche, k.b paramb)
  {
    AppMethodBeat.i(190406);
    ae.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), paramche.hFS, paramche.Title });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if (paramInt == 0) {}
    try
    {
      com.tencent.mm.ui.base.h.cm(this, getString(2131756261));
      paramche = (cay)paramb.vWq;
      if (!bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jet, null)).equals(paramche.Hoy)) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jez, Integer.valueOf(2));
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jet, paramche.Hoy);
      acs(1);
      com.tencent.mm.plugin.report.service.g.yxI.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(this.yYl) });
      AppMethodBeat.o(190406);
      return;
    }
    catch (Exception paramche)
    {
      ae.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", paramche, "", new Object[0]);
      AppMethodBeat.o(190406);
    }
    if (!bu.isNullOrNil(paramche.hFS)) {
      com.tencent.mm.ui.base.h.c(this, paramche.hFS, getString(2131757998), true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(2), Integer.valueOf(paramInt), Integer.valueOf(this.yYl) });
      AppMethodBeat.o(190406);
      return;
      com.tencent.mm.ui.base.h.l(getContext(), 2131755733, 2131757998);
    }
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(190405);
    ae.i("MicroMsg.SettingsModifyPatSuffixUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.sPf.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.sPf.setLayoutParams(localLayoutParams);
      this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), paramInt);
      paramInt = this.fSp.getHeight();
      this.fSq.requestLayout();
      this.fSq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190400);
          ae.i("MicroMsg.SettingsModifyPatSuffixUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() > paramInt) {
            SettingsModifyPatSuffixUI.g(SettingsModifyPatSuffixUI.this).scrollBy(0, SettingsModifyPatSuffixUI.f(SettingsModifyPatSuffixUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(190400);
        }
      });
      AppMethodBeat.o(190405);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sPf.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.sPf.setLayoutParams(localLayoutParams);
    this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), 0);
    this.fSp.scrollBy(0, 0);
    AppMethodBeat.o(190405);
  }
  
  public int getLayoutId()
  {
    return 2131496421;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190403);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fSq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fSq.setExternalListener(this);
    this.sPf = ((Button)findViewById(2131302852));
    this.yXK = ((MMClearEditText)findViewById(2131308172));
    this.jwg = ((TextView)findViewById(2131308173));
    this.fSp = ((ScrollView)findViewById(2131304376));
    this.sPf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190397);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SettingsModifyPatSuffixUI.this.hideVKB();
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText());
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190397);
      }
    });
    String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jet, null);
    int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jez, 0);
    ae.i("MicroMsg.SettingsModifyPatSuffixUI", "curSuffix %s, suffixVersion %d", new Object[] { str2, Integer.valueOf(i) });
    if (!bu.isNullOrNil(str2))
    {
      String str1 = str2;
      if (i == 0)
      {
        str1 = str2;
        if (ad.foi()) {
          str1 = "的".concat(String.valueOf(str2));
        }
      }
      this.yXK.setText(k.c(this, str1));
      this.yXK.setSelection(str1.length());
    }
    this.yXK.requestFocus();
    this.yXK.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190398);
        int i = f.a(paramAnonymousEditable.toString(), f.a.Lfh);
        if (i > SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
        {
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131767173, new Object[] { Integer.valueOf(SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this) / 2) }));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100800));
          SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).performHapticFeedback(3, 2);
          if (SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).foU()) {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).ay(5000L, 5000L);
          }
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setText(f.gT(paramAnonymousEditable.toString(), SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this)));
          SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).setSelection(SettingsModifyPatSuffixUI.b(SettingsModifyPatSuffixUI.this).getText().length());
        }
        for (;;)
        {
          SettingsModifyPatSuffixUI.e(SettingsModifyPatSuffixUI.this).setEnabled(true);
          AppMethodBeat.o(190398);
          return;
          if (i < SettingsModifyPatSuffixUI.c(SettingsModifyPatSuffixUI.this))
          {
            SettingsModifyPatSuffixUI.d(SettingsModifyPatSuffixUI.this).stopTimer();
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131766976));
            SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100212));
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doD().a(222, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(190399);
        SettingsModifyPatSuffixUI.this.onBackPressed();
        AppMethodBeat.o(190399);
        return true;
      }
    });
    AppMethodBeat.o(190403);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190404);
    super.onBackPressed();
    com.tencent.mm.plugin.report.service.g.yxI.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(this.yYl) });
    AppMethodBeat.o(190404);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190401);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      this.yYl = 2;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(20379, new Object[] { System.currentTimeMillis(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(this.yYl) });
    this.yYk = com.tencent.mm.n.g.acL().getInt("PatSuffixMaxByte", 16);
    initView();
    this.yYj = new aw(getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(190396);
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setText(SettingsModifyPatSuffixUI.this.getString(2131766976));
        SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this).setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(2131100212));
        AppMethodBeat.o(190396);
        return false;
      }
    }, false);
    AppMethodBeat.o(190401);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190402);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doD().b(222, this);
    if (this.yYj != null) {
      this.yYj.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(190402);
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