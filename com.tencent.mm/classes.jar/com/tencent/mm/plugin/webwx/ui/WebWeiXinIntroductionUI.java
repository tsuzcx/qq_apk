package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI
  extends MMActivity
{
  private Button JFL;
  
  public int getLayoutId()
  {
    return 2131497056;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30247);
    setMMTitle("");
    this.JFL = ((Button)findViewById(2131310409));
    this.JFL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30244);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webwx/ui/WebWeiXinIntroductionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("BaseScanUI_select_scan_mode", 1);
        paramAnonymousView.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        paramAnonymousView.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
        paramAnonymousView.putExtra("from_album", false);
        paramAnonymousView.putExtra("show_intro", false);
        paramAnonymousView.setFlags(65536);
        c.b(WebWeiXinIntroductionUI.this, "scanner", ".ui.BaseScanUI", paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWeiXinIntroductionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30244);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(30245);
        WebWeiXinIntroductionUI.this.finish();
        AppMethodBeat.o(30245);
        return true;
      }
    });
    AppMethodBeat.o(30247);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30246);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(30246);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI
 * JD-Core Version:    0.7.0.1
 */