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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.o;
import java.io.OutputStream;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements f
{
  private ProgressDialog fOC = null;
  private int yTR = 1;
  private ImageView yTW = null;
  private byte[] yTX = null;
  
  final void dQH()
  {
    AppMethodBeat.i(73868);
    final com.tencent.mm.bc.a locala = new com.tencent.mm.bc.a();
    com.tencent.mm.kernel.g.ajj().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(190298);
        com.tencent.mm.kernel.g.ajj().a(locala);
        AppMethodBeat.o(190298);
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
    this.yTW = ((ImageView)findViewById(2131304554));
    this.yTR = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(2131304791);
    if (this.yTR == 3) {
      localTextView.setText(getString(2131763035, new Object[] { getString(2131763039) }));
    }
    for (;;)
    {
      dQH();
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
          com.tencent.mm.ui.base.h.b(paramAnonymousMenuItem, "", new String[] { str1, str2 }, "", local4);
          AppMethodBeat.o(73861);
          return true;
        }
      });
      ((Button)findViewById(2131304555)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73862);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.g.ajQ().mR(1);
            localObject = v.aAC();
            int i = bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(66561, null));
            ae.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { bu.aSM(bu.cH(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.b.g.getMessageDigest(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + com.tencent.mm.protocal.d.hjv + "&version=" + com.tencent.mm.protocal.d.FFH;
            ae.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(2131763045));
            com.tencent.mm.br.d.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            ShowQRCodeStep1UI.this.finish();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(73862);
            return;
            if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 4)
            {
              if (v.aBi())
              {
                localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                ((Intent)localObject).putExtra("show_to", 4);
                paramAnonymousView = ShowQRCodeStep1UI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                ShowQRCodeStep1UI.this.finish();
                break;
                ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
              }
            }
            if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 2)
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 2);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
            else
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 1);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
          }
        }
      });
      AppMethodBeat.o(73867);
      return;
      if (this.yTR == 4) {
        localTextView.setText(getString(2131763035, new Object[] { getString(2131763036) }));
      } else if (this.yTR == 2) {
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
    com.tencent.mm.kernel.g.ajj().a(168, this);
    AppMethodBeat.o(73865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73866);
    com.tencent.mm.kernel.g.ajj().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(73866);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73869);
    ae.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (c.iUA.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.yTX = ((com.tencent.mm.bc.a)paramn).imz;
    this.yTW.setImageBitmap(com.tencent.mm.sdk.platformtools.h.cu(this.yTX));
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