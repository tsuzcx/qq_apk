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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;

public class SettingsCreateAliasUI
  extends MMActivity
  implements f
{
  private ProgressDialog fMu = null;
  private ImageView fOf;
  private TextView fOg;
  private String ffB;
  private TextView jpy;
  private f yFz = null;
  private EditText yGG;
  private d yGH;
  private boolean yGI = false;
  private TextView yGJ;
  
  public int getLayoutId()
  {
    return 2131495391;
  }
  
  public void initView()
  {
    AppMethodBeat.i(220990);
    setMMTitle(2131762350);
    this.fOf = ((ImageView)findViewById(2131297008));
    this.fOg = ((TextView)findViewById(2131302867));
    this.jpy = ((TextView)findViewById(2131306253));
    this.yGJ = ((TextView)findViewById(2131302439));
    this.yGG = ((EditText)findViewById(2131303958));
    String str = u.aAm();
    if (!am.aSX(str))
    {
      this.yGG.setText(u.aAm());
      this.jpy.setText(getString(2131755271, new Object[] { str }));
    }
    this.yGG.setSelection(this.yGG.getText().length());
    this.yGG.setFocusable(true);
    this.yGG.setFocusableInTouchMode(true);
    this.yGG.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220980);
        SettingsCreateAliasUI localSettingsCreateAliasUI = SettingsCreateAliasUI.this;
        a locala = new a();
        if ((paramAnonymousCharSequence.length() < 6) || (paramAnonymousCharSequence.length() > 20))
        {
          locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
          locala.dpn = false;
          if (!locala.dpn) {
            break label339;
          }
          SettingsCreateAliasUI.this.enableOptionMenu(true);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100490));
        }
        for (;;)
        {
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setText(locala.errMsg);
          SettingsCreateAliasUI.b(SettingsCreateAliasUI.this).setText(SettingsCreateAliasUI.this.getString(2131755271, new Object[] { paramAnonymousCharSequence }));
          AppMethodBeat.o(220980);
          return;
          if (!bt.F(paramAnonymousCharSequence.charAt(0)))
          {
            locala.errMsg = localSettingsCreateAliasUI.getString(2131764647);
            locala.dpn = false;
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
                locala.dpn = false;
                break;
              }
              if (bt.E(c))
              {
                locala.errMsg = localSettingsCreateAliasUI.getString(2131764644);
                locala.dpn = false;
                break;
              }
              locala.errMsg = localSettingsCreateAliasUI.getString(2131764649);
              locala.dpn = false;
              break;
            }
            paramAnonymousInt1 -= 1;
          }
          label318:
          locala.errMsg = localSettingsCreateAliasUI.getString(2131761322);
          locala.dpn = true;
          break;
          label339:
          SettingsCreateAliasUI.this.enableOptionMenu(false);
          SettingsCreateAliasUI.a(SettingsCreateAliasUI.this).setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(2131100859));
        }
      }
    });
    this.fOg.setText(k.b(this, bt.nullAsNil(u.aAo()), this.fOg.getTextSize()));
    a.b.c(this.fOf, str);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(220981);
        SettingsCreateAliasUI.this.hideVKB();
        SettingsCreateAliasUI.this.finish();
        AppMethodBeat.o(220981);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(220983);
        SettingsCreateAliasUI.a(SettingsCreateAliasUI.this, SettingsCreateAliasUI.c(SettingsCreateAliasUI.this).getText().toString().trim());
        if (u.aAm().equalsIgnoreCase(SettingsCreateAliasUI.d(SettingsCreateAliasUI.this)))
        {
          SettingsCreateAliasUI.this.hideVKB();
          SettingsCreateAliasUI.this.finish();
          AppMethodBeat.o(220983);
          return true;
        }
        h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(2131761320, new Object[] { SettingsCreateAliasUI.d(SettingsCreateAliasUI.this) }), SettingsCreateAliasUI.this.getString(2131757566), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(220982);
            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
            AppMethodBeat.o(220982);
          }
        }, null);
        AppMethodBeat.o(220983);
        return true;
      }
    }, null, s.b.JbS);
    enableOptionMenu(false);
    AppMethodBeat.o(220990);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220987);
    super.onCreate(paramBundle);
    this.yGI = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    com.tencent.mm.kernel.g.aiU().a(177, this);
    AppMethodBeat.o(220987);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(220989);
    if (this.yGH != null) {
      com.tencent.mm.kernel.g.aiU().a(this.yGH);
    }
    com.tencent.mm.kernel.g.aiU().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(220989);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(220988);
    super.onPause();
    AppMethodBeat.o(220988);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(220991);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.yGI) {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10358, "1");
      }
      hideVKB();
      com.tencent.mm.kernel.g.ajC().ajl().set(42, this.ffB);
      paramString = com.tencent.mm.kernel.g.aiU();
      paramn = new f()
      {
        public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
        {
          AppMethodBeat.i(220986);
          ad.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          com.tencent.mm.kernel.g.aiU().b(255, SettingsCreateAliasUI.g(SettingsCreateAliasUI.this));
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220985);
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
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localSettingsCreateAliasUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localSettingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(220985);
                return;
              }
            }
          });
          AppMethodBeat.o(220986);
        }
      };
      this.yFz = paramn;
      paramString.a(255, paramn);
      paramString = new t(1);
      com.tencent.mm.kernel.g.aiU().a(paramString, 0);
      AppMethodBeat.o(220991);
      return;
    }
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (b.iRH.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(220991);
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
    AppMethodBeat.o(220991);
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