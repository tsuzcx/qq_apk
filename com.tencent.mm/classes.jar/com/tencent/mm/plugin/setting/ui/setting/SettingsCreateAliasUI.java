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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements f
{
  private ProgressDialog fOC = null;
  private ImageView fQl;
  private TextView fQm;
  private String fhy;
  private TextView jsr;
  private f yVI = null;
  private EditText yWP;
  private com.tencent.mm.plugin.setting.model.e yWQ;
  private boolean yWR = false;
  private TextView yWS;
  
  public int getLayoutId()
  {
    return 2131495391;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190361);
    setMMTitle(2131762350);
    this.fQl = ((ImageView)findViewById(2131297008));
    this.fQm = ((TextView)findViewById(2131302867));
    this.jsr = ((TextView)findViewById(2131306253));
    this.yWS = ((TextView)findViewById(2131302439));
    this.yWP = ((EditText)findViewById(2131303958));
    String str = v.aAC();
    if (!an.aUy(str))
    {
      this.yWP.setText(v.aAC());
      this.jsr.setText(getString(2131755271, new Object[] { str }));
    }
    this.yWP.setSelection(this.yWP.getText().length());
    this.yWP.setFocusable(true);
    this.yWP.setFocusableInTouchMode(true);
    this.yWP.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(190351);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
          locala.dqs = false;
          if (!locala.dqs) {
            break label339;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100490));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(2131755271, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(190351);
          return;
          if (!bu.F(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(2131764647);
            locala.dqs = false;
            break;
          }
          paramAnonymousInt1 = paramAnonymousCharSequence.length() - 1;
          for (;;)
          {
            if (paramAnonymousInt1 <= 0) {
              break label318;
            }
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if ((!bu.F(c)) && (c != '-') && (c != '_') && (!bu.G(c)))
            {
              if (Character.isSpace(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764646);
                locala.dqs = false;
                break;
              }
              if (bu.E(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764644);
                locala.dqs = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
              locala.dqs = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label318:
          locala.errMsg = localSettingsCreateAliasUI.getString(2131761322);
          locala.dqs = true;
          break;
          label339:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100859));
        }
      }
    });
    this.fQm.setText(k.b(this, bu.nullAsNil(v.aAE()), this.fQm.getTextSize()));
    a.b.c(this.fQl, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(190352);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(190352);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(190354);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (v.aAC().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(190354);
          return true;
        }
        h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(2131761320, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(2131757566), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(190353);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(190353);
          }
        }, null);
        AppMethodBeat.o(190354);
        return true;
      }
    }, null, s.b.JwA);
    enableOptionMenu(false);
    AppMethodBeat.o(190361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190358);
    super.onCreate(paramBundle);
    this.yWR = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.g.ajj().a(177, this);
    AppMethodBeat.o(190358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190360);
    if (this.yWQ != null) {
      com.tencent.mm.kernel.g.ajj().a(this.yWQ);
    }
    com.tencent.mm.kernel.g.ajj().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(190360);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190359);
    super.onPause();
    AppMethodBeat.o(190359);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(190362);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.yWR) {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.g.ajR().ajA().set(42, this.fhy);
      paramString = com.tencent.mm.kernel.g.ajj();
      paramn = new f()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
        {
          AppMethodBeat.i(190357);
          ae.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          com.tencent.mm.kernel.g.ajj().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190356);
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(190356);
                return;
              }
            }
          });
          AppMethodBeat.o(190357);
        }
      };
      this.yVI = paramn;
      paramString.a(255, paramn);
      paramString = new u(1);
      com.tencent.mm.kernel.g.ajj().a(paramString, 0);
      AppMethodBeat.o(190362);
      return;
    }
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (c.iUA.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(190362);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      h.l(getContext(), 2131762274, 2131761323);
      paramInt1 = i;
    }
    AppMethodBeat.o(190362);
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