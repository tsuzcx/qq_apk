package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.i;
import java.io.OutputStream;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private int xpj = 1;
  private ImageView xpo = null;
  private byte[] xpp = null;
  
  final void dBI()
  {
    AppMethodBeat.i(73868);
    final com.tencent.mm.bc.a locala = new com.tencent.mm.bc.a();
    com.tencent.mm.kernel.g.agi().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fts = h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(190973);
        com.tencent.mm.kernel.g.agi().a(locala);
        AppMethodBeat.o(190973);
      }
    });
    AppMethodBeat.o(73868);
  }
  
  public int getLayoutId()
  {
    return 2131495443;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73867);
    setMMTitle(2131763067);
    this.xpo = ((ImageView)findViewById(2131304554));
    this.xpj = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(2131304791);
    if (this.xpj == 3) {
      localTextView.setText(getString(2131763035, new Object[] { getString(2131763039) }));
    }
    for (;;)
    {
      dBI();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73860);
          ShowQRCodeStep1UI.this.hideVKB();
          ShowQRCodeStep1UI.this.finish();
          AppMethodBeat.o(73860);
          return true;
        }
      });
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73861);
          paramAnonymousMenuItem = ShowQRCodeStep1UI.this;
          String str1 = paramAnonymousMenuItem.getString(2131763027);
          String str2 = paramAnonymousMenuItem.getString(2131763031);
          ShowQRCodeStep1UI.4 local4 = new ShowQRCodeStep1UI.4(paramAnonymousMenuItem);
          h.b(paramAnonymousMenuItem, "", new String[] { str1, str2 }, "", local4);
          AppMethodBeat.o(73861);
          return true;
        }
      });
      ((Button)findViewById(2131304555)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73862);
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.g.agQ().mp(1);
            localObject = u.axw();
            int i = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66561, null));
            ac.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { bs.aLJ(bs.cx(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.b.g.getMessageDigest(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + com.tencent.mm.protocal.d.gMK + "&version=" + com.tencent.mm.protocal.d.DIc;
            ac.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(2131763045));
            com.tencent.mm.br.d.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            ShowQRCodeStep1UI.this.finish();
            AppMethodBeat.o(73862);
            return;
          }
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 4)
          {
            if (u.axZ())
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 4);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            for (;;)
            {
              ShowQRCodeStep1UI.this.finish();
              AppMethodBeat.o(73862);
              return;
              ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
            }
          }
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 2)
          {
            localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
            ((Intent)localObject).putExtra("show_to", 2);
            paramAnonymousView = ShowQRCodeStep1UI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ShowQRCodeStep1UI.this.finish();
            AppMethodBeat.o(73862);
            return;
          }
          Object localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
          ((Intent)localObject).putExtra("show_to", 1);
          paramAnonymousView = ShowQRCodeStep1UI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ShowQRCodeStep1UI.this.finish();
          AppMethodBeat.o(73862);
        }
      });
      AppMethodBeat.o(73867);
      return;
      if (this.xpj == 4) {
        localTextView.setText(getString(2131763035, new Object[] { getString(2131763036) }));
      } else if (this.xpj == 2) {
        localTextView.setText(getString(2131763035, new Object[] { getString(2131763038) }));
      } else {
        localTextView.setText(getString(2131763035, new Object[] { getString(2131763037) }));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73865);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.agi().a(168, this);
    AppMethodBeat.o(73865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73866);
    com.tencent.mm.kernel.g.agi().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(73866);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73869);
    ac.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (com.tencent.mm.plugin.setting.b.iyy.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73869);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131759562, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73869);
      return;
    }
    this.xpp = ((com.tencent.mm.bc.a)paramn).hQs;
    this.xpo.setImageBitmap(f.ck(this.xpp));
    AppMethodBeat.o(73869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI
 * JD-Core Version:    0.7.0.1
 */