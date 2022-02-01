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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ProgressDialog fpP = null;
  private EditText lmq;
  private TextView weY = null;
  
  public int getLayoutId()
  {
    return 2131493740;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73989);
    setMMTitle(2131763230);
    this.lmq = ((EditText)findViewById(2131298739));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.weY = ((TextView)findViewById(2131306434));
      this.weY.setVisibility(0);
      this.weY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73982);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("rawUrl", SendFeedBackUI.this.getString(2131766184));
          d.b(SendFeedBackUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
    addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
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
            d.O(SendFeedBackUI.this.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
            AppMethodBeat.o(73985);
            return false;
          }
          paramAnonymousMenuItem = new k(com.tencent.mm.compatible.deviceinfo.q.Xe(), paramAnonymousMenuItem + " key " + bt.eMY() + " local key " + bt.eMX() + "NetType:" + ay.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.WL() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.WN() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.WM());
          com.tencent.mm.kernel.g.aeS().a(153, SendFeedBackUI.this);
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem, 0);
          SendFeedBackUI.this.hideVKB();
          SendFeedBackUI localSendFeedBackUI1 = SendFeedBackUI.this;
          SendFeedBackUI localSendFeedBackUI2 = SendFeedBackUI.this;
          SendFeedBackUI.this.getString(2131755906);
          SendFeedBackUI.a(localSendFeedBackUI1, h.b(localSendFeedBackUI2, SendFeedBackUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(73984);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem);
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
    com.tencent.mm.kernel.g.aeS().b(153, this);
    super.onDestroy();
    AppMethodBeat.o(73988);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(73990);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.d(this, getString(2131763229), getString(2131755906), new DialogInterface.OnClickListener()
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
    h.d(this, getString(2131763228), getString(2131755906), new DialogInterface.OnClickListener()
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