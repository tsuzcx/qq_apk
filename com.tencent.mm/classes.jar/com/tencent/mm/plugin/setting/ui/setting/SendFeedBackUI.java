package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.o;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class SendFeedBackUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private TextView PpM = null;
  private ProgressDialog lzP = null;
  private EditText tID;
  
  public int getLayoutId()
  {
    return b.g.edit_signature;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73989);
    setMMTitle(b.i.settings_feedbackui_title);
    this.tID = ((EditText)findViewById(b.f.content));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.PpM = ((TextView)findViewById(b.f.view_question_text_view));
      this.PpM.setVisibility(0);
      this.PpM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73982);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SendFeedBackUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("rawUrl", SendFeedBackUI.this.getString(b.i.wechat_faq_url));
          c.b(SendFeedBackUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SendFeedBackUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73982);
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73983);
        SendFeedBackUI.this.hideVKB();
        SendFeedBackUI.this.finish();
        AppMethodBeat.o(73983);
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.i.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73985);
        paramAnonymousMenuItem = SendFeedBackUI.a(SendFeedBackUI.this).getText().toString().trim();
        if (paramAnonymousMenuItem.length() > 0)
        {
          if (paramAnonymousMenuItem.startsWith("//traceroute"))
          {
            SendFeedBackUI.a(SendFeedBackUI.this).setText("");
            c.ai(SendFeedBackUI.this.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
            AppMethodBeat.o(73985);
            return false;
          }
          paramAnonymousMenuItem = new o(q.aPl(), paramAnonymousMenuItem + " key " + co.jcP() + " local key " + co.jcO() + "NetType:" + NetStatusUtil.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + n.aOQ() + " isArmv6: " + n.aOS() + " isArmv7: " + n.aOR());
          com.tencent.mm.kernel.h.aZW().a(153, SendFeedBackUI.this);
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem, 0);
          SendFeedBackUI.this.hideVKB();
          SendFeedBackUI localSendFeedBackUI1 = SendFeedBackUI.this;
          SendFeedBackUI localSendFeedBackUI2 = SendFeedBackUI.this;
          SendFeedBackUI.this.getString(b.i.app_tip);
          SendFeedBackUI.a(localSendFeedBackUI1, k.a(localSendFeedBackUI2, SendFeedBackUI.this.getString(b.i.app_sending), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(73984);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem);
              AppMethodBeat.o(73984);
            }
          }));
        }
        AppMethodBeat.o(73985);
        return false;
      }
    });
    AppMethodBeat.o(73989);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73987);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(73987);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73988);
    com.tencent.mm.kernel.h.aZW().b(153, this);
    super.onDestroy();
    AppMethodBeat.o(73988);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(73990);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.d(this, getString(b.i.settings_feedbackui_succ), getString(b.i.app_tip), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73986);
          SendFeedBackUI.this.finish();
          AppMethodBeat.o(73986);
        }
      });
      AppMethodBeat.o(73990);
      return;
    }
    k.d(this, getString(b.i.settings_feedbackui_err), getString(b.i.app_tip), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(73990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI
 * JD-Core Version:    0.7.0.1
 */