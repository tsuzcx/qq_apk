package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView jVn;
  private Button nAa;
  
  public int getLayoutId()
  {
    return 2131493868;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71781);
    this.jVn = ((TextView)findViewById(2131299510));
    Object localObject = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ);
    if (localObject != null) {}
    try
    {
      if (localObject.length != 0)
      {
        localObject = (cxc)new cxc().parseFrom((byte[])localObject);
        if ((localObject != null) && (!Util.isNullOrNil(((cxc)localObject).desc))) {
          this.jVn.setText(((cxc)localObject).desc);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletECardFinishUI", localException, "", new Object[0]);
      }
    }
    this.nAa = ((Button)findViewById(2131301536));
    this.nAa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71779);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        Log.i("MicroMsg.WalletECardFinishUI", "click finish");
        paramAnonymousView = new ov();
        EventCenter.instance.publish(paramAnonymousView);
        paramAnonymousView = WalletECardFinishUI.this.getProcess();
        if (paramAnonymousView != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("key_process_result_code", -1);
          paramAnonymousView.b(WalletECardFinishUI.this.getContext(), (Bundle)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71779);
          return;
          Log.w("MicroMsg.WalletECardFinishUI", "process is null");
          WalletECardFinishUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(71781);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71780);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    enableBackMenu(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(71778);
        Log.i("MicroMsg.WalletECardFinishUI", "press back btn");
        WalletECardFinishUI.a(WalletECardFinishUI.this).performClick();
        AppMethodBeat.o(71778);
        return false;
      }
    });
    showHomeBtn(false);
    initView();
    AppMethodBeat.o(71780);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI
 * JD-Core Version:    0.7.0.1
 */