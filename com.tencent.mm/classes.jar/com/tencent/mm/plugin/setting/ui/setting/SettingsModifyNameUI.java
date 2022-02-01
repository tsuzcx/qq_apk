package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;

public class SettingsModifyNameUI
  extends MMActivity
  implements c.a
{
  private MMEditText PuE;
  private k.b PuF;
  private boolean PuG;
  private j.a PuH;
  private w psR;
  
  public SettingsModifyNameUI()
  {
    AppMethodBeat.i(74247);
    this.PuG = false;
    this.psR = null;
    this.PuH = new j.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(299031);
        if ((paramAnonymousInt != 0) && (paramAnonymousString2 != null))
        {
          k.c(SettingsModifyNameUI.this, paramAnonymousString2, paramAnonymousString1, true);
          if (SettingsModifyNameUI.a(SettingsModifyNameUI.this) != null) {
            ((n)h.ax(n.class)).bzz().e(SettingsModifyNameUI.a(SettingsModifyNameUI.this));
          }
        }
        for (;;)
        {
          if (SettingsModifyNameUI.d(SettingsModifyNameUI.this) != null) {
            SettingsModifyNameUI.d(SettingsModifyNameUI.this).dismiss();
          }
          AppMethodBeat.o(299031);
          return;
          if ((paramAnonymousInt == 0) && (SettingsModifyNameUI.b(SettingsModifyNameUI.this)))
          {
            h.baE().ban().B(4, SettingsModifyNameUI.c(SettingsModifyNameUI.this).getText().toString());
            ((b)h.ax(b.class)).bKY().wG(7);
            SettingsModifyNameUI.this.finish();
            l.kK(4, 1);
          }
        }
      }
    };
    AppMethodBeat.o(74247);
  }
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(74251);
    Log.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : ".concat(String.valueOf(paramString)));
    this.PuG = true;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(b.i.app_tip);
    this.psR = k.a(localAppCompatActivity, getString(b.i.contact_info_change_remarkimage_save), false, null);
    this.PuF = z.IA(paramString);
    AppMethodBeat.o(74251);
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(299047);
    k.s(this, b.i.settings_modify_name_invalid_less, b.i.settings_modify_name_title);
    AppMethodBeat.o(299047);
  }
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(164136);
    k.s(this, b.i.settings_modify_name_invalid_more, b.i.settings_modify_name_title);
    AppMethodBeat.o(164136);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_modify_name;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74250);
    setMMTitle(b.i.settings_modify_name);
    this.PuE = ((MMEditText)findViewById(b.f.settings_modify_name_new_name_et));
    this.PuE.setText(p.b(this, (String)h.baE().ban().d(4, null), this.PuE.getTextSize()));
    this.PuE.setSelection(this.PuE.getText().length());
    this.PuE.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(74244);
        SettingsModifyNameUI.this.enableOptionMenu(true);
        AppMethodBeat.o(74244);
      }
    });
    com.tencent.mm.ui.tools.b.c.i(this.PuE).oF(1, 32).Nc(false).a(null);
    addTextOptionMenu(0, getString(b.i.app_save), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74245);
        paramAnonymousMenuItem = SettingsModifyNameUI.c(SettingsModifyNameUI.this).getText().toString();
        String str = com.tencent.mm.k.c.aRm();
        if ((!Util.isNullOrNil(str)) && (paramAnonymousMenuItem.matches(".*[" + str + "].*")))
        {
          k.c(SettingsModifyNameUI.this.getContext(), SettingsModifyNameUI.this.getString(b.i.invalid_input_character_toast, new Object[] { str }), SettingsModifyNameUI.this.getString(b.i.app_tip), true);
          AppMethodBeat.o(74245);
          return false;
        }
        com.tencent.mm.ui.tools.b.c.i(SettingsModifyNameUI.c(SettingsModifyNameUI.this)).oF(1, 32).a(SettingsModifyNameUI.this);
        AppMethodBeat.o(74245);
        return true;
      }
    }, null, y.b.adEJ);
    enableOptionMenu(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74246);
        SettingsModifyNameUI.this.hideVKB();
        SettingsModifyNameUI.this.finish();
        AppMethodBeat.o(74246);
        return true;
      }
    });
    AppMethodBeat.o(74250);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74248);
    super.onCreate(paramBundle);
    ((n)h.ax(n.class)).bzz().a(64, this.PuH);
    initView();
    AppMethodBeat.o(74248);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74249);
    ((n)h.ax(n.class)).bzz().b(64, this.PuH);
    super.onDestroy();
    AppMethodBeat.o(74249);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI
 * JD-Core Version:    0.7.0.1
 */