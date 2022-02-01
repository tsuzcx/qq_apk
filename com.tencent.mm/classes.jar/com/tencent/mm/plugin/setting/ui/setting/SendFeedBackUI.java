package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI
  extends MMActivity
  implements i
{
  private TextView CZK = null;
  private ProgressDialog gtM = null;
  private EditText nBD;
  
  public int getLayoutId()
  {
    return 2131493875;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73989);
    setMMTitle(2131765399);
    this.nBD = ((EditText)findViewById(2131299180));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.CZK = ((TextView)findViewById(2131309866));
      this.CZK.setVisibility(0);
      this.CZK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73982);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SendFeedBackUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("rawUrl", SendFeedBackUI.this.getString(2131768660));
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
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
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
            c.V(SendFeedBackUI.this.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
            AppMethodBeat.o(73985);
            return false;
          }
          paramAnonymousMenuItem = new m(com.tencent.mm.compatible.deviceinfo.q.aoL(), paramAnonymousMenuItem + " key " + ck.getFingerprint() + " local key " + ck.gEv() + "NetType:" + NetStatusUtil.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + n.aos() + " isArmv6: " + n.aou() + " isArmv7: " + n.aot());
          g.azz().a(153, SendFeedBackUI.this);
          g.azz().a(paramAnonymousMenuItem, 0);
          SendFeedBackUI.this.hideVKB();
          SendFeedBackUI localSendFeedBackUI1 = SendFeedBackUI.this;
          SendFeedBackUI localSendFeedBackUI2 = SendFeedBackUI.this;
          SendFeedBackUI.this.getString(2131755998);
          SendFeedBackUI.a(localSendFeedBackUI1, h.a(localSendFeedBackUI2, SendFeedBackUI.this.getString(2131755978), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(73984);
              g.azz().a(paramAnonymousMenuItem);
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
    g.azz().b(153, this);
    super.onDestroy();
    AppMethodBeat.o(73988);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(73990);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.d(this, getString(2131765398), getString(2131755998), new DialogInterface.OnClickListener()
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
    h.d(this, getString(2131765397), getString(2131755998), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI
 * JD-Core Version:    0.7.0.1
 */