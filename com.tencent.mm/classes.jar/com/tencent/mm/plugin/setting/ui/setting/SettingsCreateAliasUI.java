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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String eKn;
  private ProgressDialog fpP = null;
  private ImageView frr;
  private TextView frs;
  private TextView iwl;
  private com.tencent.mm.al.g wfC = null;
  private EditText wgH;
  private d wgI;
  private boolean wgJ = false;
  private TextView wgK;
  
  public int getLayoutId()
  {
    return 2131495391;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186557);
    setMMTitle(2131760628);
    this.frr = ((ImageView)findViewById(2131297008));
    this.frs = ((TextView)findViewById(2131302867));
    this.iwl = ((TextView)findViewById(2131306253));
    this.wgK = ((TextView)findViewById(2131302439));
    this.wgH = ((EditText)findViewById(2131303958));
    String str = u.aqG();
    if (!af.aHK(str))
    {
      this.wgH.setText(u.aqG());
      this.iwl.setText(getString(2131755271, new Object[] { str }));
    }
    this.wgH.setSelection(this.wgH.getText().length());
    this.wgH.setFocusable(true);
    this.wgH.setFocusableInTouchMode(true);
    this.wgH.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(186547);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
          locala.dgw = false;
          if (!locala.dgw) {
            break label339;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100490));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(2131755271, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(186547);
          return;
          if (!bt.F(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(2131764647);
            locala.dgw = false;
            break;
          }
          paramAnonymousInt1 = paramAnonymousCharSequence.length() - 1;
          for (;;)
          {
            if (paramAnonymousInt1 <= 0) {
              break label318;
            }
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if ((!bt.F(c)) && (c != '-') && (c != '_') && (!bt.G(c)))
            {
              if (Character.isSpace(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764646);
                locala.dgw = false;
                break;
              }
              if (bt.E(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764644);
                locala.dgw = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
              locala.dgw = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label318:
          locala.errMsg = localSettingsCreateAliasUI.getString(2131761322);
          locala.dgw = true;
          break;
          label339:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100859));
        }
      }
    });
    this.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bt.nullAsNil(u.aqI()), this.frs.getTextSize()));
    a.b.c(this.frr, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186548);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(186548);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186550);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (u.aqG().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(186550);
          return true;
        }
        com.tencent.mm.ui.base.h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(2131761320, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(2131757566), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(186549);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(186549);
          }
        }, null);
        AppMethodBeat.o(186550);
        return true;
      }
    }, null, r.b.FOB);
    enableOptionMenu(false);
    AppMethodBeat.o(186557);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186554);
    super.onCreate(paramBundle);
    this.wgJ = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.g.aeS().a(177, this);
    AppMethodBeat.o(186554);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186556);
    if (this.wgI != null) {
      com.tencent.mm.kernel.g.aeS().a(this.wgI);
    }
    com.tencent.mm.kernel.g.aeS().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(186556);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186555);
    super.onPause();
    AppMethodBeat.o(186555);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(186558);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.wgJ) {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.g.afB().afk().set(42, this.eKn);
      paramString = com.tencent.mm.kernel.g.aeS();
      paramn = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
        {
          AppMethodBeat.i(186553);
          ad.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          com.tencent.mm.kernel.g.aeS().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186552);
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(186552);
                return;
              }
            }
          });
          AppMethodBeat.o(186553);
        }
      };
      this.wfC = paramn;
      paramString.a(255, paramn);
      paramString = new t(1);
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      AppMethodBeat.o(186558);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (b.hYu.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(186558);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      com.tencent.mm.ui.base.h.j(getContext(), 2131762274, 2131761323);
      paramInt1 = i;
    }
    AppMethodBeat.o(186558);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI
 * JD-Core Version:    0.7.0.1
 */