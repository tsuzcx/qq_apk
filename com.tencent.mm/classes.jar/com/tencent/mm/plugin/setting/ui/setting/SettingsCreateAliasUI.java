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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements i
{
  private i Dax = null;
  private EditText DbH;
  private com.tencent.mm.plugin.setting.model.e DbI;
  private boolean DbJ = false;
  private TextView DbK;
  private String fMb;
  private ProgressDialog gtM = null;
  private ImageView gvv;
  private TextView gvw;
  private TextView kqG;
  
  public int getLayoutId()
  {
    return 2131496252;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256535);
    setMMTitle(2131758203);
    this.gvv = ((ImageView)findViewById(2131297134));
    this.gvw = ((TextView)findViewById(2131305440));
    this.kqG = ((TextView)findViewById(2131309652));
    this.DbK = ((TextView)findViewById(2131304839));
    this.DbH = ((EditText)findViewById(2131306812));
    String str = z.aTY();
    if (!as.bjx(str))
    {
      this.DbH.setText(z.aTY());
      this.kqG.setText(getString(2131755306, new Object[] { str }));
    }
    this.DbH.setSelection(this.DbH.getText().length());
    this.DbH.setFocusable(true);
    this.DbH.setFocusableInTouchMode(true);
    this.DbH.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(256525);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(2131767020);
          locala.dHF = false;
          if (!locala.dHF) {
            break label339;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100594));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(2131755306, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(256525);
          return;
          if (!Util.isAlpha(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(2131767018);
            locala.dHF = false;
            break;
          }
          paramAnonymousInt1 = paramAnonymousCharSequence.length() - 1;
          for (;;)
          {
            if (paramAnonymousInt1 <= 0) {
              break label318;
            }
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if ((!Util.isAlpha(c)) && (c != '-') && (c != '_') && (!Util.isNum(c)))
            {
              if (Character.isSpace(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131767017);
                locala.dHF = false;
                break;
              }
              if (Util.isChinese(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131767015);
                locala.dHF = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(2131767020);
              locala.dHF = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label318:
          locala.errMsg = localSettingsCreateAliasUI.getString(2131763149);
          locala.dHF = true;
          break;
          label339:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131101058));
        }
      }
    });
    this.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(z.aUa()), this.gvw.getTextSize()));
    a.b.c(this.gvv, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256526);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(256526);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256528);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (z.aTY().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(256528);
          return true;
        }
        com.tencent.mm.ui.base.h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(2131763147, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(2131757793), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(256527);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(256527);
          }
        }, null);
        AppMethodBeat.o(256528);
        return true;
      }
    }, null, t.b.OGU);
    enableOptionMenu(false);
    AppMethodBeat.o(256535);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256532);
    super.onCreate(paramBundle);
    this.DbJ = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    g.azz().a(177, this);
    AppMethodBeat.o(256532);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(256534);
    if (this.DbI != null) {
      g.azz().a(this.DbI);
    }
    g.azz().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(256534);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(256533);
    super.onPause();
    AppMethodBeat.o(256533);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(256536);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.DbJ) {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10358, "1");
      }
      hideVKB();
      g.aAh().azQ().set(42, this.fMb);
      paramString = g.azz();
      paramq = new i()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
        {
          AppMethodBeat.i(256531);
          Log.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
          g.azz().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256530);
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(256530);
                return;
              }
            }
          });
          AppMethodBeat.o(256531);
        }
      };
      this.Dax = paramq;
      paramString.a(255, paramq);
      paramString = new u(1);
      g.azz().a(paramString, 0);
      AppMethodBeat.o(256536);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (c.jRu.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(256536);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      com.tencent.mm.ui.base.h.n(getContext(), 2131764340, 2131763150);
      paramInt1 = i;
    }
    AppMethodBeat.o(256536);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI
 * JD-Core Version:    0.7.0.1
 */