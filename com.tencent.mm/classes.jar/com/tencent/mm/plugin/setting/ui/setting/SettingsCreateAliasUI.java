package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.model.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.am.h PqN = null;
  private EditText PsN;
  private g PsO;
  private boolean PsP = false;
  private TextView PsQ;
  private String kDc;
  private ImageView lBC;
  private TextView lBD;
  private ProgressDialog lzP = null;
  private TextView qfH;
  
  public int getLayoutId()
  {
    return b.g.settings_create_alias;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298793);
    setMMTitle(b.i.create_alias);
    this.lBC = ((ImageView)findViewById(b.f.avatar_iv));
    this.lBD = ((TextView)findViewById(b.f.nickname_tv));
    this.qfH = ((TextView)findViewById(b.f.username_tv));
    this.PsQ = ((TextView)findViewById(b.f.modify_username_detail_message));
    this.PsN = ((EditText)findViewById(b.f.regbyqqreg_account_et));
    String str = z.bAM();
    if (!au.bxb(str))
    {
      this.PsN.setText(z.bAM());
      this.qfH.setText(getString(b.i.app_account, new Object[] { str }));
    }
    this.PsN.setSelection(this.PsN.getText().length());
    this.PsN.setFocusable(true);
    this.PsN.setFocusableInTouchMode(true);
    this.PsN.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(299177);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_tip);
          locala.hFj = false;
          if (!locala.hFj) {
            break label347;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(b.c.hint_text_color));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(b.i.app_account, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(299177);
          return;
          if (!Util.isAlpha(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_err_start);
            locala.hFj = false;
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
                locala.hFj = false;
                break;
              }
              if (Util.isChinese(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_err_chinese);
                locala.hFj = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(b.i.verify_account_tip);
              locala.hFj = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label325:
          locala.errMsg = localSettingsCreateAliasUI.getString(b.i.modify_username_detail);
          locala.hFj = true;
          break;
          label347:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(b.c.settings_alias_warning));
        }
      }
    });
    this.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(z.bAO()), this.lBD.getTextSize()));
    a.b.g(this.lBC, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(299176);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(299176);
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.i.app_save), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(299130);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (z.bAM().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(299130);
          return true;
        }
        k.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(b.i.modify_username_confirm, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(b.i.confirm_username), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(299348);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(299348);
          }
        }, null);
        AppMethodBeat.o(299130);
        return true;
      }
    }, null, y.b.adEJ);
    enableOptionMenu(false);
    AppMethodBeat.o(298793);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298774);
    super.onCreate(paramBundle);
    this.PsP = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.h.aZW().a(177, this);
    AppMethodBeat.o(298774);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(298787);
    if (this.PsO != null) {
      com.tencent.mm.kernel.h.aZW().a(this.PsO);
    }
    com.tencent.mm.kernel.h.aZW().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(298787);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(298783);
    super.onPause();
    AppMethodBeat.o(298783);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 1;
    AppMethodBeat.i(298796);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.PsP) {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.h.baE().ban().B(42, this.kDc);
      paramString = com.tencent.mm.kernel.h.aZW();
      paramp = new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(299108);
          Log.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousp.getType());
          com.tencent.mm.kernel.h.aZW().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(299368);
              if (SettingsCreateAliasUI.h(SettingsCreateAliasUI.this) != null)
              {
                SettingsCreateAliasUI.h(SettingsCreateAliasUI.this).dismiss();
                SettingsCreateAliasUI.i(SettingsCreateAliasUI.this);
              }
              SettingsCreateAliasUI.j(SettingsCreateAliasUI.this);
              if (paramAnonymousp.getType() == 255) {
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(299368);
                return;
              }
            }
          });
          AppMethodBeat.o(299108);
        }
      };
      this.PqN = paramp;
      paramString.a(255, paramp);
      paramString = new v(1);
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      AppMethodBeat.o(298796);
      return;
    }
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (c.pFo.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(298796);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      k.s(getContext(), b.i.reg_username_exist_tip, b.i.modify_username_failed);
      paramInt1 = i;
    }
    AppMethodBeat.o(298796);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI
 * JD-Core Version:    0.7.0.1
 */