package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.account.ui.MMFBAuthUI;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.vfs.y;
import java.io.OutputStream;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int PoQ = 1;
  private ImageView PoV = null;
  private byte[] PoW = null;
  private ProgressDialog lzP = null;
  
  final void gVa()
  {
    AppMethodBeat.i(73868);
    final com.tencent.mm.az.a locala = new com.tencent.mm.az.a();
    com.tencent.mm.kernel.h.aZW().a(locala, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(b.i.app_tip);
    this.lzP = k.a(localAppCompatActivity, getString(b.i.self_qrcode_getting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(298575);
        com.tencent.mm.kernel.h.aZW().a(locala);
        AppMethodBeat.o(298575);
      }
    });
    AppMethodBeat.o(73868);
  }
  
  public int getLayoutId()
  {
    return b.g.show_qrcode_step1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73867);
    setMMTitle(b.i.send_qrcode_to_microblog);
    this.PoV = ((ImageView)findViewById(b.f.self_qrcode_iv));
    this.PoQ = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(b.f.show_qrcode_info_tv);
    if (this.PoQ == 3) {
      localTextView.setText(getString(b.i.self_qrcode_show_all, new Object[] { getString(b.i.self_qrcode_show_all_sina) }));
    }
    for (;;)
    {
      gVa();
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
      addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73861);
          paramAnonymousMenuItem = ShowQRCodeStep1UI.this;
          String str1 = paramAnonymousMenuItem.getString(b.i.self_qrcode_change);
          String str2 = paramAnonymousMenuItem.getString(b.i.self_qrcode_save);
          ShowQRCodeStep1UI.4 local4 = new ShowQRCodeStep1UI.4(paramAnonymousMenuItem);
          k.b(paramAnonymousMenuItem, "", new String[] { str1, str2 }, "", local4);
          AppMethodBeat.o(73861);
          return true;
        }
      });
      ((Button)findViewById(b.f.self_qrcode_share_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73862);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 3)
          {
            paramAnonymousView = com.tencent.mm.kernel.h.baD().sA(1);
            localObject = z.bAM();
            int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(66561, null));
            Log.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { Util.secPrint(Util.encodeHexString(paramAnonymousView)), localObject, Integer.valueOf(i) });
            paramAnonymousView = "https://" + WeChatHosts.domainString(b.i.host_weixin_qq_com) + "/cgi-bin/rweibourl?sid=" + g.getMessageDigest(paramAnonymousView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + d.nsC + "&version=" + d.Yxh;
            Log.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("title", ShowQRCodeStep1UI.this.getString(b.i.self_qrcode_show_to_sina));
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
              if (z.bBz())
              {
                localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                ((Intent)localObject).putExtra("show_to", 4);
                paramAnonymousView = ShowQRCodeStep1UI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                ShowQRCodeStep1UI.this.finish();
                break;
                ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, MMFBAuthUI.class);
              }
            }
            if (ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this) == 2)
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 2);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
            else
            {
              localObject = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
              ((Intent)localObject).putExtra("show_to", 1);
              paramAnonymousView = ShowQRCodeStep1UI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ShowQRCodeStep1UI.this.finish();
            }
          }
        }
      });
      AppMethodBeat.o(73867);
      return;
      if (this.PoQ == 4) {
        localTextView.setText(getString(b.i.self_qrcode_show_all, new Object[] { getString(b.i.self_qrcode_show_all_facebook) }));
      } else if (this.PoQ == 2) {
        localTextView.setText(getString(b.i.self_qrcode_show_all, new Object[] { getString(b.i.self_qrcode_show_all_qzone) }));
      } else {
        localTextView.setText(getString(b.i.self_qrcode_show_all, new Object[] { getString(b.i.self_qrcode_show_all_qqwb) }));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73865);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.h.aZW().a(168, this);
    AppMethodBeat.o(73865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73866);
    com.tencent.mm.kernel.h.aZW().b(168, this);
    super.onDestroy();
    AppMethodBeat.o(73866);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(73869);
    Log.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (com.tencent.mm.plugin.setting.c.pFo.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73869);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(b.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73869);
      return;
    }
    this.PoW = ((com.tencent.mm.az.a)paramp).oRo;
    this.PoV.setImageBitmap(BitmapUtil.decodeByteArray(this.PoW));
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