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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.i;
import java.io.OutputStream;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements f
{
  private ProgressDialog fMu = null;
  private int yDM = 1;
  private ImageView yDR = null;
  private byte[] yDS = null;
  
  final void dNl()
  {
    AppMethodBeat.i(73868);
    final com.tencent.mm.bd.a locala = new com.tencent.mm.bd.a();
    com.tencent.mm.kernel.g.aiU().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fMu = h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(220936);
        com.tencent.mm.kernel.g.aiU().a(locala);
        AppMethodBeat.o(220936);
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
    this.yDR = ((ImageView)findViewById(2131304554));
    this.yDM = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(2131304791);
    if (this.yDM == 3) {
      localTextView.setText(getString(2131763035, new Object[] { getString(2131763039) }));
    }
    for (;;)
    {
      dNl();
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.g.ajB().mO(1);
            localObject = u.aAm();
            int i = bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(66561, null));
            ad.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { bt.aRp(bt.cE(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.b.g.getMessageDigest(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + com.tencent.mm.protocal.d.hgH + "&version=" + com.tencent.mm.protocal.d.Fnj;
            ad.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(2131763045));
            com.tencent.mm.bs.d.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            ShowQRCodeStep1UI.this.finish();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(73862);
            return;
            if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 4)
            {
              if (u.aAS())
              {
                localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                ((Intent)localObject).putExtra("show_to", 4);
                paramAnonymousView = ShowQRCodeStep1UI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
            else
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 1);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
          }
        }
      });
      AppMethodBeat.o(73867);
      return;
      if (this.yDM == 4) {
        localTextView.setText(getString(2131763035, new Object[] { getString(2131763036) }));
      } else if (this.yDM == 2) {
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
    com.tencent.mm.kernel.g.aiU().a(168, this);
    AppMethodBeat.o(73865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73866);
    com.tencent.mm.kernel.g.aiU().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(73866);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73869);
    ad.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (com.tencent.mm.plugin.setting.b.iRH.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.yDS = ((com.tencent.mm.bd.a)paramn).ijG;
    this.yDR.setImageBitmap(com.tencent.mm.sdk.platformtools.g.cr(this.yDS));
    AppMethodBeat.o(73869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI
 * JD-Core Version:    0.7.0.1
 */