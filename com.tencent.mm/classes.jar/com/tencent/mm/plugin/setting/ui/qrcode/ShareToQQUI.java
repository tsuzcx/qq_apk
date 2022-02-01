package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQUI
  extends MMActivity
  implements i
{
  private TextView CYJ;
  private int CYK;
  private boolean CYL = false;
  private ProgressDialog gtM = null;
  private EditText nBD;
  
  public int getLayoutId()
  {
    return 2131493874;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73857);
    setMMTitle(2131765226);
    this.nBD = ((EditText)findViewById(2131299180));
    this.CYJ = ((TextView)findViewById(2131310528));
    this.nBD.addTextChangedListener(new MMEditText.c(this.nBD, this.CYJ, 280));
    this.CYK = getIntent().getIntExtra("show_to", 2);
    if (this.CYK == 4) {
      this.nBD.setText(2131765191);
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
      addTextOptionMenu(0, getString(2131755983), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
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
          for (paramAnonymousMenuItem = new y(paramAnonymousMenuItem, bool1, bool2);; paramAnonymousMenuItem = new y(ShareToQQUI.c(ShareToQQUI.this).getText().toString()))
          {
            g.azz().a(paramAnonymousMenuItem, 0);
            Object localObject = ShareToQQUI.this;
            AppCompatActivity localAppCompatActivity = ShareToQQUI.this.getContext();
            ShareToQQUI.this.getString(2131755998);
            ShareToQQUI.a((ShareToQQUI)localObject, h.a(localAppCompatActivity, ShareToQQUI.this.getString(2131755978), true, new ShareToQQUI.2.2(this, paramAnonymousMenuItem)));
            AppMethodBeat.o(73849);
            return true;
            bool1 = false;
            break;
            bool2 = false;
            break label75;
            if (ShareToQQUI.b(ShareToQQUI.this) != 4) {
              break label304;
            }
            long l = Util.nullAsNil((Long)g.aAh().azQ().get(65831, null));
            paramAnonymousMenuItem = Util.nullAsNil((String)g.aAh().azQ().get(65830, null));
            if ((Util.milliSecondsToNow(l) > 86400000L) && (paramAnonymousMenuItem.length() > 0))
            {
              localObject = new com.tencent.mm.ui.h.a.c(ShareToQQUI.this.getString(2131759094));
              ((com.tencent.mm.ui.h.a.c)localObject).bnE(paramAnonymousMenuItem);
              new k((com.tencent.mm.ui.h.a.c)localObject, new com.tencent.mm.plugin.account.model.l()
              {
                public final void E(Bundle paramAnonymous2Bundle)
                {
                  AppMethodBeat.i(73846);
                  super.E(paramAnonymous2Bundle);
                  AppMethodBeat.o(73846);
                }
                
                public final void onError(int paramAnonymous2Int, String paramAnonymous2String)
                {
                  AppMethodBeat.i(73847);
                  super.onError(paramAnonymous2Int, paramAnonymous2String);
                  AppMethodBeat.o(73847);
                }
              }).bnw();
            }
          }
          label162:
          label304:
          h.n(ShareToQQUI.this.getContext(), 2131765831, 2131755998);
          AppMethodBeat.o(73849);
          return true;
        }
      });
      AppMethodBeat.o(73857);
      return;
      this.nBD.setText(2131765193);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73855);
    super.onCreate(paramBundle);
    g.azz().a(26, this);
    initView();
    if (z.aUF())
    {
      paramBundle = new com.tencent.mm.ui.h.a.c(getString(2131759094));
      paramBundle.bnE(Util.nullAsNil((String)g.aAh().azQ().get(65830, null)));
      new k(paramBundle, new com.tencent.mm.plugin.account.model.l()
      {
        public final void E(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(73852);
          super.E(paramAnonymousBundle);
          AppMethodBeat.o(73852);
        }
        
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(73853);
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToQQUI.d(ShareToQQUI.this);
          }
          AppMethodBeat.o(73853);
        }
      }).bnw();
    }
    AppMethodBeat.o(73855);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73856);
    g.azz().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(73856);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73858);
    Log.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 26)
    {
      AppMethodBeat.o(73858);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      h.a(this, paramq, getString(2131755998), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73850);
          Object localObject = new Intent(ShareToQQUI.this.getContext(), FacebookAuthUI.class);
          ((Intent)localObject).putExtra("is_force_unbind", true);
          paramAnonymousDialogInterface = ShareToQQUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      paramString = getString(2131765834);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(73851);
          ShareToQQUI.this.finish();
          AppMethodBeat.o(73851);
        }
      };
      h.cD(this, paramString);
      AppMethodBeat.o(73858);
      return;
    }
    this.CYL = false;
    if (com.tencent.mm.plugin.setting.c.jRu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73858);
      return;
    }
    Toast.makeText(this, getString(2131765833, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(73858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI
 * JD-Core Version:    0.7.0.1
 */