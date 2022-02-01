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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.io.OutputStream;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements i
{
  private int CYK = 1;
  private ImageView CYP = null;
  private byte[] CYQ = null;
  private ProgressDialog gtM = null;
  
  final void eSI()
  {
    AppMethodBeat.i(73868);
    final com.tencent.mm.bc.a locala = new com.tencent.mm.bc.a();
    com.tencent.mm.kernel.g.azz().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.gtM = h.a(localAppCompatActivity, getString(2131765181), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(256466);
        com.tencent.mm.kernel.g.azz().a(locala);
        AppMethodBeat.o(256466);
      }
    });
    AppMethodBeat.o(73868);
  }
  
  public int getLayoutId()
  {
    return 2131496315;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73867);
    setMMTitle(2131765226);
    this.CYP = ((ImageView)findViewById(2131307592));
    this.CYK = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(2131307873);
    if (this.CYK == 3) {
      localTextView.setText(getString(2131765186, new Object[] { getString(2131765190) }));
    }
    for (;;)
    {
      eSI();
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
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73861);
          paramAnonymousMenuItem = ShowQRCodeStep1UI.this;
          String str1 = paramAnonymousMenuItem.getString(2131765178);
          String str2 = paramAnonymousMenuItem.getString(2131765182);
          ShowQRCodeStep1UI.4 local4 = new ShowQRCodeStep1UI.4(paramAnonymousMenuItem);
          h.b(paramAnonymousMenuItem, "", new String[] { str1, str2 }, "", local4);
          AppMethodBeat.o(73861);
          return true;
        }
      });
      ((Button)findViewById(2131307593)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73862);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.g.aAg().qe(1);
            localObject = z.aTY();
            int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(66561, null));
            Log.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { Util.secPrint(Util.encodeHexString(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/rweibourl?sid=" + com.tencent.mm.b.g.getMessageDigest(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + d.ics + "&version=" + d.KyO;
            Log.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(2131765196));
            com.tencent.mm.br.c.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            ShowQRCodeStep1UI.this.finish();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(73862);
            return;
            if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 4)
            {
              if (z.aUF())
              {
                localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                ((Intent)localObject).putExtra("show_to", 4);
                paramAnonymousView = ShowQRCodeStep1UI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
            else
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 1);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
          }
        }
      });
      AppMethodBeat.o(73867);
      return;
      if (this.CYK == 4) {
        localTextView.setText(getString(2131765186, new Object[] { getString(2131765187) }));
      } else if (this.CYK == 2) {
        localTextView.setText(getString(2131765186, new Object[] { getString(2131765189) }));
      } else {
        localTextView.setText(getString(2131765186, new Object[] { getString(2131765188) }));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73865);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.azz().a(168, this);
    AppMethodBeat.o(73865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73866);
    com.tencent.mm.kernel.g.azz().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(73866);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73869);
    Log.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (com.tencent.mm.plugin.setting.c.jRu.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73869);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131760879, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73869);
      return;
    }
    this.CYQ = ((com.tencent.mm.bc.a)paramq).jhH;
    this.CYP.setImageBitmap(BitmapUtil.decodeByteArray(this.CYQ));
    AppMethodBeat.o(73869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI
 * JD-Core Version:    0.7.0.1
 */