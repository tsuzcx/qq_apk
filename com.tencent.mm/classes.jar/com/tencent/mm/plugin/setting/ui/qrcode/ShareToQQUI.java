package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private EditText lMg;
  private TextView xpi;
  private int xpj;
  private boolean xpk = false;
  
  public int getLayoutId()
  {
    return 2131493739;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73857);
    setMMTitle(2131763067);
    this.lMg = ((EditText)findViewById(2131298739));
    this.xpi = ((TextView)findViewById(2131307005));
    this.lMg.addTextChangedListener(new MMEditText.c(this.lMg, this.xpi, 280));
    this.xpj = getIntent().getIntExtra("show_to", 2);
    if (this.xpj == 4) {
      this.lMg.setText(2131763040);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73845);
          ShareToQQUI.this.hideVKB();
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73845);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755891), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73849);
          ShareToQQUI.a(ShareToQQUI.this);
          boolean bool1;
          boolean bool2;
          if ((ShareToQQUI.b(ShareToQQUI.this) == 2) || (ShareToQQUI.b(ShareToQQUI.this) == 1))
          {
            paramAnonymousMenuItem = ShareToQQUI.c(ShareToQQUI.this).getText().toString();
            if (ShareToQQUI.b(ShareToQQUI.this) == 1)
            {
              bool1 = true;
              if (ShareToQQUI.b(ShareToQQUI.this) != 2) {
                break label162;
              }
              bool2 = true;
            }
          }
          label75:
          for (paramAnonymousMenuItem = new x(paramAnonymousMenuItem, bool1, bool2);; paramAnonymousMenuItem = new x(ShareToQQUI.c(ShareToQQUI.this).getText().toString()))
          {
            com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem, 0);
            Object localObject = ShareToQQUI.this;
            AppCompatActivity localAppCompatActivity = ShareToQQUI.this.getContext();
            ShareToQQUI.this.getString(2131755906);
            ShareToQQUI.a((ShareToQQUI)localObject, h.b(localAppCompatActivity, ShareToQQUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(73848);
                com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem);
                AppMethodBeat.o(73848);
              }
            }));
            AppMethodBeat.o(73849);
            return true;
            bool1 = false;
            break;
            bool2 = false;
            break label75;
            if (ShareToQQUI.b(ShareToQQUI.this) != 4) {
              break label304;
            }
            long l = bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(65831, null));
            paramAnonymousMenuItem = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65830, null));
            if ((bs.Ap(l) > 86400000L) && (paramAnonymousMenuItem.length() > 0))
            {
              localObject = new c(ShareToQQUI.this.getString(2131758773));
              ((c)localObject).aRc(paramAnonymousMenuItem);
              new j((c)localObject, new com.tencent.mm.plugin.account.model.k()
              {
                public final void onError(int paramAnonymous2Int, String paramAnonymous2String)
                {
                  AppMethodBeat.i(73847);
                  super.onError(paramAnonymous2Int, paramAnonymous2String);
                  AppMethodBeat.o(73847);
                }
                
                public final void w(Bundle paramAnonymous2Bundle)
                {
                  AppMethodBeat.i(73846);
                  super.w(paramAnonymous2Bundle);
                  AppMethodBeat.o(73846);
                }
              }).aOY();
            }
          }
          label162:
          label304:
          h.l(ShareToQQUI.this.getContext(), 2131763643, 2131755906);
          AppMethodBeat.o(73849);
          return true;
        }
      });
      AppMethodBeat.o(73857);
      return;
      this.lMg.setText(2131763042);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73855);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(26, this);
    initView();
    if (u.axZ())
    {
      paramBundle = new c(getString(2131758773));
      paramBundle.aRc(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65830, null)));
      new j(paramBundle, new com.tencent.mm.plugin.account.model.k()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(73853);
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToQQUI.d(ShareToQQUI.this);
          }
          AppMethodBeat.o(73853);
        }
        
        public final void w(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(73852);
          super.w(paramAnonymousBundle);
          AppMethodBeat.o(73852);
        }
      }).aOY();
    }
    AppMethodBeat.o(73855);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73856);
    com.tencent.mm.kernel.g.agi().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(73856);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73858);
    ac.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 26)
    {
      AppMethodBeat.o(73858);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = "error";
      }
      h.a(this, paramn, getString(2131755906), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73850);
          Object localObject = new Intent(ShareToQQUI.this.getContext(), FacebookAuthUI.class);
          ((Intent)localObject).putExtra("is_force_unbind", true);
          paramAnonymousDialogInterface = ShareToQQUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ShareToQQUI.this.hideVKB();
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73850);
        }
      }, null);
      AppMethodBeat.o(73858);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      hideVKB();
      paramString = getString(2131763646);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(73851);
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73851);
        }
      };
      h.cg(this, paramString);
      AppMethodBeat.o(73858);
      return;
    }
    this.xpk = false;
    if (b.iyy.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73858);
      return;
    }
    Toast.makeText(this, getString(2131763645, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(73858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI
 * JD-Core Version:    0.7.0.1
 */