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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String eNf;
  private ProgressDialog fts = null;
  private ImageView fuY;
  private TextView fuZ;
  private TextView iWp;
  private com.tencent.mm.ak.g xqS = null;
  private EditText xrX;
  private d xrY;
  private boolean xrZ = false;
  private TextView xsa;
  
  public int getLayoutId()
  {
    return 2131495391;
  }
  
  public void initView()
  {
    AppMethodBeat.i(191023);
    setMMTitle(2131762350);
    this.fuY = ((ImageView)findViewById(2131297008));
    this.fuZ = ((TextView)findViewById(2131302867));
    this.iWp = ((TextView)findViewById(2131306253));
    this.xsa = ((TextView)findViewById(2131302439));
    this.xrX = ((EditText)findViewById(2131303958));
    String str = u.axw();
    if (!ai.aNf(str))
    {
      this.xrX.setText(u.axw());
      this.iWp.setText(getString(2131755271, new Object[] { str }));
    }
    this.xrX.setSelection(this.xrX.getText().length());
    this.xrX.setFocusable(true);
    this.xrX.setFocusableInTouchMode(true);
    this.xrX.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(191013);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
          locala.ddR = false;
          if (!locala.ddR) {
            break label339;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100490));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(2131755271, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(191013);
          return;
          if (!bs.D(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(2131764647);
            locala.ddR = false;
            break;
          }
          paramAnonymousInt1 = paramAnonymousCharSequence.length() - 1;
          for (;;)
          {
            if (paramAnonymousInt1 <= 0) {
              break label318;
            }
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if ((!bs.D(c)) && (c != '-') && (c != '_') && (!bs.E(c)))
            {
              if (Character.isSpace(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764646);
                locala.ddR = false;
                break;
              }
              if (bs.C(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764644);
                locala.ddR = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
              locala.ddR = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label318:
          locala.errMsg = localSettingsCreateAliasUI.getString(2131761322);
          locala.ddR = true;
          break;
          label339:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100859));
        }
      }
    });
    this.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bs.nullAsNil(u.axy()), this.fuZ.getTextSize()));
    a.b.c(this.fuY, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191014);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(191014);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191016);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (u.axw().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(191016);
          return true;
        }
        com.tencent.mm.ui.base.h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(2131761320, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(2131757566), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(191015);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(191015);
          }
        }, null);
        AppMethodBeat.o(191016);
        return true;
      }
    }, null, s.b.Hom);
    enableOptionMenu(false);
    AppMethodBeat.o(191023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191020);
    super.onCreate(paramBundle);
    this.xrZ = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.g.agi().a(177, this);
    AppMethodBeat.o(191020);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191022);
    if (this.xrY != null) {
      com.tencent.mm.kernel.g.agi().a(this.xrY);
    }
    com.tencent.mm.kernel.g.agi().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(191022);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(191021);
    super.onPause();
    AppMethodBeat.o(191021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(191024);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.xrZ) {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.g.agR().agA().set(42, this.eNf);
      paramString = com.tencent.mm.kernel.g.agi();
      paramn = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
        {
          AppMethodBeat.i(191019);
          ac.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          com.tencent.mm.kernel.g.agi().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191018);
              if (SettingsCreateAliasUI.h(SettingsCreateAliasUI.this) != null)
              {
                SettingsCreateAliasUI.h(SettingsCreateAliasUI.this).dismiss();
                SettingsCreateAliasUI.i(SettingsCreateAliasUI.this);
              }
              SettingsCreateAliasUI.j(SettingsCreateAliasUI.this);
              if (paramAnonymousn.getType() == 255) {
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(191018);
                return;
              }
            }
          });
          AppMethodBeat.o(191019);
        }
      };
      this.xqS = paramn;
      paramString.a(255, paramn);
      paramString = new t(1);
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      AppMethodBeat.o(191024);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (b.iyy.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(191024);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      com.tencent.mm.ui.base.h.l(getContext(), 2131762274, 2131761323);
      paramInt1 = i;
    }
    AppMethodBeat.o(191024);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI
 * JD-Core Version:    0.7.0.1
 */