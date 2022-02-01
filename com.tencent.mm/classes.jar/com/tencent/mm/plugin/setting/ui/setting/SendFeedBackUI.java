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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private EditText lMg;
  private TextView xqm = null;
  
  public int getLayoutId()
  {
    return 2131493740;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73989);
    setMMTitle(2131763230);
    this.lMg = ((EditText)findViewById(2131298739));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.xqm = ((TextView)findViewById(2131306434));
      this.xqm.setVisibility(0);
      this.xqm.setOnClickListener(new View.OnClickListener()
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
            d.N(SendFeedBackUI.this.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
            AppMethodBeat.o(73985);
            return false;
          }
          paramAnonymousMenuItem = new k(com.tencent.mm.compatible.deviceinfo.q.Yb(), paramAnonymousMenuItem + " key " + bw.fcC() + " local key " + bw.fcB() + "NetType:" + ax.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.XJ() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.XL() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.XK());
          com.tencent.mm.kernel.g.agi().a(153, SendFeedBackUI.this);
          com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem, 0);
          SendFeedBackUI.this.hideVKB();
          SendFeedBackUI localSendFeedBackUI1 = SendFeedBackUI.this;
          SendFeedBackUI localSendFeedBackUI2 = SendFeedBackUI.this;
          SendFeedBackUI.this.getString(2131755906);
          SendFeedBackUI.a(localSendFeedBackUI1, h.b(localSendFeedBackUI2, SendFeedBackUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(73984);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem);
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
    com.tencent.mm.kernel.g.agi().b(153, this);
    super.onDestroy();
    AppMethodBeat.o(73988);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(73990);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI
 * JD-Core Version:    0.7.0.1
 */