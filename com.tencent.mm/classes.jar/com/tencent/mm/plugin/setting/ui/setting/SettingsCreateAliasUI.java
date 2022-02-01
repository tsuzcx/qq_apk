package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements i
{
  private i JfY = null;
  private EditText Jhi;
  private e Jhj;
  private boolean Jhk = false;
  private TextView Jhl;
  private ProgressDialog iXX = null;
  private ImageView iZG;
  private TextView iZH;
  private String idS;
  private TextView nit;
  
  public int getLayoutId()
  {
    return b.g.settings_create_alias;
  }
  
  public void initView()
  {
    AppMethodBeat.i(263315);
    setMMTitle(b.i.create_alias);
    this.iZG = ((ImageView)findViewById(b.f.avatar_iv));
    this.iZH = ((TextView)findViewById(b.f.nickname_tv));
    this.nit = ((TextView)findViewById(b.f.username_tv));
    this.Jhl = ((TextView)findViewById(b.f.modify_username_detail_message));
    this.Jhi = ((EditText)findViewById(b.f.regbyqqreg_account_et));
    String str = z.bcZ();
    if (!as.bvU(str))
    {
      this.Jhi.setText(z.bcZ());
      this.nit.setText(getString(b.i.app_account, new Object[] { str }));
    }
    this.Jhi.setSelection(this.Jhi.getText().length());
    this.Jhi.setFocusable(true);
    this.Jhi.setFocusableInTouchMode(true);
    this.Jhi.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(263702);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_tip);
          locala.fAw = false;
          if (!locala.fAw) {
            break label347;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(b.c.hint_text_color));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(b.i.app_account, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(263702);
          return;
          if (!Util.isAlpha(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_err_start);
            locala.fAw = false;
            break;
          }
          paramAnonymousInt1 = paramAnonymousCharSequence.length() - 1;
          for (;;)
          {
            if (paramAnonymousInt1 <= 0) {
              break label325;
            }
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if ((!Util.isAlpha(c)) && (c != '-') && (c != '_') && (!Util.isNum(c)))
            {
              if (Character.isSpace(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_err_space);
                locala.fAw = false;
                break;
              }
              if (Util.isChinese(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_err_chinese);
                locala.fAw = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_tip);
              locala.fAw = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label325:
          locala.errMsg = localSettingsCreateAliasUI.getString(b.i.modify_username_detail);
          locala.fAw = true;
          break;
          label347:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(b.c.settings_alias_warning));
        }
      }
    });
    this.iZH.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(z.bdb()), this.iZH.getTextSize()));
    a.b.c(this.iZG, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(264327);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(264327);
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.i.app_save), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(263335);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (z.bcZ().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(263335);
          return true;
        }
        com.tencent.mm.ui.base.h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(b.i.modify_username_confirm, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(b.i.confirm_username), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(263613);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(263613);
          }
        }, null);
        AppMethodBeat.o(263335);
        return true;
      }
    }, null, w.b.Wao);
    enableOptionMenu(false);
    AppMethodBeat.o(263315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263312);
    super.onCreate(paramBundle);
    this.Jhk = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.h.aGY().a(177, this);
    AppMethodBeat.o(263312);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(263314);
    if (this.Jhj != null) {
      com.tencent.mm.kernel.h.aGY().a(this.Jhj);
    }
    com.tencent.mm.kernel.h.aGY().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(263314);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(263313);
    super.onPause();
    AppMethodBeat.o(263313);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(263317);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Jhk) {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.h.aHG().aHp().i(42, this.idS);
      paramString = com.tencent.mm.kernel.h.aGY();
      paramq = new i()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
        {
          AppMethodBeat.i(264770);
          Log.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
          com.tencent.mm.kernel.h.aGY().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(264084);
              if (SettingsCreateAliasUI.h(SettingsCreateAliasUI.this) != null)
              {
                SettingsCreateAliasUI.h(SettingsCreateAliasUI.this).dismiss();
                SettingsCreateAliasUI.i(SettingsCreateAliasUI.this);
              }
              SettingsCreateAliasUI.j(SettingsCreateAliasUI.this);
              if (paramAnonymousq.getType() == 255) {
                if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4)) {
                  break label194;
                }
              }
              label194:
              for (boolean bool = true;; bool = false)
              {
                Object localObject = new Intent(SettingsCreateAliasUI.this, SettingsAliasResultUI.class);
                ((Intent)localObject).putExtra("has_pwd", bool);
                SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(264084);
                return;
              }
            }
          });
          AppMethodBeat.o(264770);
        }
      };
      this.JfY = paramq;
      paramString.a(255, paramq);
      paramString = new u(1);
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      AppMethodBeat.o(263317);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (c.mIH.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(263317);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      com.tencent.mm.ui.base.h.p(getContext(), b.i.reg_username_exist_tip, b.i.modify_username_failed);
      paramInt1 = i;
    }
    AppMethodBeat.o(263317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI
 * JD-Core Version:    0.7.0.1
 */